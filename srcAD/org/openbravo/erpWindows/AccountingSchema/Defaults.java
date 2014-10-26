
package org.openbravo.erpWindows.AccountingSchema;





import org.openbravo.erpCommon.utility.*;
import org.openbravo.data.FieldProvider;
import org.openbravo.utils.FormatUtilities;
import org.openbravo.utils.Replace;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.exception.OBException;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessRunner;
import org.openbravo.erpCommon.businessUtility.WindowTabs;
import org.openbravo.xmlEngine.XmlDocument;
import java.util.Vector;
import java.util.StringTokenizer;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.Connection;
import org.apache.log4j.Logger;
import org.openz.view.*;
import org.openz.model.*;
import org.openz.controller.callouts.CalloutStructure;
import org.openz.view.Formhelper;
import org.openz.view.Scripthelper;
import org.openz.view.templates.ConfigureButton;
import org.openz.view.templates.ConfigureInfobar;
import org.openz.view.templates.ConfigurePopup;
import org.openz.view.templates.ConfigureSelectBox;
import org.openz.view.templates.ConfigureFrameWindow;
import org.openz.util.LocalizationUtils;
import org.openz.util.UtilsData;
import org.openz.controller.businessprocess.DocActionWorkflowOptions;
import org.openbravo.data.Sqlc;

public class Defaults extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Defaults.class);
  
  private static final String windowId = "125";
  private static final String tabId = "252";
  private static final String defaultTabView = "RELATION";
  private static final int accesslevel = 3;
  private static final double SUBTABS_COL_SIZE = 15;

  public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    TableSQLData tableSQL = null;
    VariablesSecureApp vars = new VariablesSecureApp(request);
    
    Boolean saveRequest = (Boolean) request.getAttribute("autosave");
    this.setWindowId(windowId);
    this.setTabId(tabId);
    if(saveRequest != null && saveRequest){
      String currentOrg = vars.getStringParameter("inpadOrgId");
      String currentClient = vars.getStringParameter("inpadClientId");
      boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)
                            && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars,"#User_Org", windowId, accesslevel), currentOrg)) 
                            && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),currentClient)));
    
        OBError myError = new OBError();
        String commandType = request.getParameter("inpCommandType");
        String strcAcctschemaDefaultId = request.getParameter("inpcAcctschemaDefaultId");
         String strPC_AcctSchema_ID = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcAcctschemaDefaultId.equals(""))
              total = saveRecord(vars, myError, 'U', strPC_AcctSchema_ID);
          else
              total = saveRecord(vars, myError, 'I', strPC_AcctSchema_ID);
          
          if (!myError.isEmpty() && total == 0)     
            throw new OBException(myError.getMessage());
        }
        vars.setSessionValue(request.getParameter("mappingName") +"|hash", vars.getPostDataHash());
        vars.setSessionValue(tabId + "|Header.view", "EDIT");
        
        return;
    }
    
    try {
      tableSQL = new TableSQLData(vars, this, tabId, Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    String strOrderBy = vars.getSessionValue(tabId + "|orderby");
    if (!strOrderBy.equals("")) {
      vars.setSessionValue(tabId + "|newOrder", "1");
    }

    if (vars.commandIn("DEFAULT")) {
      String strPC_AcctSchema_ID = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID", "");

      String strC_Acctschema_Default_ID = vars.getGlobalVariable("inpcAcctschemaDefaultId", windowId + "|C_Acctschema_Default_ID", "");
            if (strPC_AcctSchema_ID.equals("")) {
        strPC_AcctSchema_ID = getParentID(vars, strC_Acctschema_Default_ID);
        if (strPC_AcctSchema_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_AcctSchema_ID");
        vars.setSessionValue(windowId + "|C_AcctSchema_ID", strPC_AcctSchema_ID);

        refreshParentSession(vars, strPC_AcctSchema_ID);
      }


      String strView = vars.getSessionValue(tabId + "|Defaults.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_Acctschema_Default_ID.equals("")) strC_Acctschema_Default_ID = firstElement(vars, tableSQL);
          if (strC_Acctschema_Default_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Acctschema_Default_ID, strPC_AcctSchema_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_AcctSchema_ID, strC_Acctschema_Default_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_Acctschema_Default_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_Acctschema_Default_ID.equals("")) strC_Acctschema_Default_ID = vars.getRequiredGlobalVariable("inpcAcctschemaDefaultId", windowId + "|C_Acctschema_Default_ID");
      else vars.setSessionValue(windowId + "|C_Acctschema_Default_ID", strC_Acctschema_Default_ID);
      
      
      String strPC_AcctSchema_ID = getParentID(vars, strC_Acctschema_Default_ID);
      
      vars.setSessionValue(windowId + "|C_AcctSchema_ID", strPC_AcctSchema_ID);
      vars.setSessionValue("199|Accounting Schema.view", "EDIT");

      refreshParentSession(vars, strPC_AcctSchema_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Defaults.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_Acctschema_Default_ID, strPC_AcctSchema_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Defaults.view", "RELATION");
        printPageDataSheet(response, vars, strPC_AcctSchema_ID, strC_Acctschema_Default_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_AcctSchema_ID = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|C_Acctschema_Default_ID");
      refreshParentSession(vars, strPC_AcctSchema_ID);


      String strView = vars.getSessionValue(tabId + "|Defaults.view");
      String strC_Acctschema_Default_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_Acctschema_Default_ID = firstElement(vars, tableSQL);
          if (strC_Acctschema_Default_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_Acctschema_Default_ID.equals("")) strC_Acctschema_Default_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_Acctschema_Default_ID, strPC_AcctSchema_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_AcctSchema_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamC_AcctSchema_ID", tabId + "|paramC_AcctSchema_ID");

            String strPC_AcctSchema_ID = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");

      
      vars.removeSessionValue(windowId + "|C_Acctschema_Default_ID");
      String strC_Acctschema_Default_ID="";

      String strView = vars.getSessionValue(tabId + "|Defaults.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_Acctschema_Default_ID = firstElement(vars, tableSQL);
        if (strC_Acctschema_Default_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Defaults.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Acctschema_Default_ID, strPC_AcctSchema_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_AcctSchema_ID, strC_Acctschema_Default_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_AcctSchema_ID = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");
      

      String strC_Acctschema_Default_ID = vars.getGlobalVariable("inpcAcctschemaDefaultId", windowId + "|C_Acctschema_Default_ID", "");
      vars.setSessionValue(tabId + "|Defaults.view", "RELATION");
      printPageDataSheet(response, vars, strPC_AcctSchema_ID, strC_Acctschema_Default_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_AcctSchema_ID = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");


      printPageEdit(response, request, vars, true, "", strPC_AcctSchema_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_AcctSchema_ID = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_Acctschema_Default_ID = vars.getGlobalVariable("inpcAcctschemaDefaultId", windowId + "|C_Acctschema_Default_ID", "");
      vars.setSessionValue(tabId + "|Defaults.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_Acctschema_Default_ID, strPC_AcctSchema_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_AcctSchema_ID = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");
      String strC_Acctschema_Default_ID = vars.getRequiredStringParameter("inpcAcctschemaDefaultId");
      
      String strNext = nextElement(vars, strC_Acctschema_Default_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_AcctSchema_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_AcctSchema_ID = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");
      String strC_Acctschema_Default_ID = vars.getRequiredStringParameter("inpcAcctschemaDefaultId");
      
      String strPrevious = previousElement(vars, strC_Acctschema_Default_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_AcctSchema_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");

      vars.setSessionValue(tabId + "|Defaults.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_AcctSchema_ID = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Defaults.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Defaults.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Defaults.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_Acctschema_Default_ID");
      vars.setSessionValue(windowId + "|C_AcctSchema_ID", strPC_AcctSchema_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_AcctSchema_ID = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Defaults.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Defaults.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_Acctschema_Default_ID");
      vars.setSessionValue(windowId + "|C_AcctSchema_ID", strPC_AcctSchema_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPC_AcctSchema_ID = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPC_AcctSchema_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPC_AcctSchema_ID = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPC_AcctSchema_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPC_AcctSchema_ID = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPC_AcctSchema_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPC_AcctSchema_ID = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPC_AcctSchema_ID);      
      if (!myError.isEmpty()) {        
        response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
      } 
      else {
		if (myError.isEmpty()) {
		  myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsInserted");
		  myError.setMessage(total + " " + myError.getMessage());
		  vars.setMessage(tabId, myError);
		}        
        if (vars.commandIn("SAVE_NEW_NEW")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
        else if (vars.commandIn("SAVE_NEW_EDIT")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
    } else if (vars.commandIn("SAVE_EDIT_RELATION", "SAVE_EDIT_NEW", "SAVE_EDIT_EDIT", "SAVE_EDIT_NEXT")) {
      String strPC_AcctSchema_ID = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");
      String strC_Acctschema_Default_ID = vars.getRequiredGlobalVariable("inpcAcctschemaDefaultId", windowId + "|C_Acctschema_Default_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPC_AcctSchema_ID);      
      if (!myError.isEmpty()) {
        response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
      } 
      else {
        if (myError.isEmpty()) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsUpdated");
          myError.setMessage(total + " " + myError.getMessage());
          vars.setMessage(tabId, myError);
        }
        if (vars.commandIn("SAVE_EDIT_NEW")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
        else if (vars.commandIn("SAVE_EDIT_EDIT")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        else if (vars.commandIn("SAVE_EDIT_NEXT")) {
          String strNext = nextElement(vars, strC_Acctschema_Default_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_Acctschema_Default_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPC_AcctSchema_ID = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");

      String strC_Acctschema_Default_ID = vars.getRequiredInStringParameter("inpcAcctschemaDefaultId");
      String message = deleteRelation(vars, strC_Acctschema_Default_ID, strPC_AcctSchema_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cAcctschemaDefaultId");
        vars.setSessionValue(tabId + "|Defaults.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPC_AcctSchema_ID = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");

      String strC_Acctschema_Default_ID = vars.getRequiredStringParameter("inpcAcctschemaDefaultId");
      //DefaultsData data = getEditVariables(vars, strPC_AcctSchema_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = DefaultsData.delete(this, strC_Acctschema_Default_ID, strPC_AcctSchema_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
        } catch(ServletException ex) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myError.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myError);
        }
        if (myError==null && total==0) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
        }
        vars.removeSessionValue(windowId + "|cAcctschemaDefaultId");
        vars.setSessionValue(tabId + "|Defaults.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());








    } else if (vars.getCommand().toUpperCase().startsWith("BUTTON") || vars.getCommand().toUpperCase().startsWith("SAVE_BUTTON")) {
      pageErrorPopUp(response);
    } else pageError(response);
  }
/*
  String deleteRelation(VariablesSecureApp vars, String strC_Acctschema_Default_ID, String strPC_AcctSchema_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_Acctschema_Default_ID.startsWith("(")) strC_Acctschema_Default_ID = strC_Acctschema_Default_ID.substring(1, strC_Acctschema_Default_ID.length()-1);
      if (!strC_Acctschema_Default_ID.equals("")) {
        strC_Acctschema_Default_ID = Replace.replace(strC_Acctschema_Default_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_Acctschema_Default_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (DefaultsData.deleteTransactional(conn, this, strKey, strPC_AcctSchema_ID)==0) {
            releaseRollbackConnection(conn);
            log4j.warn("deleteRelation - key :" + strKey + " - 0 records deleted");
          }
        }
      }
      releaseCommitConnection(conn);
    } catch (ServletException e) {
      releaseRollbackConnection(conn);
      e.printStackTrace();
      log4j.error("Rollback in transaction");
      return "ProcessRunError";
    }
    return "";
  }
*/
  private DefaultsData getEditVariables(Connection con, VariablesSecureApp vars, String strPC_AcctSchema_ID) throws IOException,ServletException {
    DefaultsData data = new DefaultsData();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.cAcctschemaDefaultId = vars.getRequestGlobalVariable("inpcAcctschemaDefaultId", windowId + "|C_Acctschema_Default_ID");     data.cAcctschemaId = vars.getRequestGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");     data.cAcctschemaIdr = vars.getStringParameter("inpcAcctschemaId_R");     data.cReceivableAcct = vars.getStringParameter("inpcReceivableAcct");     data.cReceivableAcctr = vars.getStringParameter("inpcReceivableAcct_R");     data.cPrepaymentAcct = vars.getStringParameter("inpcPrepaymentAcct");     data.aDisposalGain = vars.getStringParameter("inpaDisposalGain");     data.paydiscountExpAcct = vars.getStringParameter("inppaydiscountExpAcct");     data.aDisposalLoss = vars.getStringParameter("inpaDisposalLoss");     data.writeoffAcct = vars.getStringParameter("inpwriteoffAcct");     data.writeoffAcctr = vars.getStringParameter("inpwriteoffAcct_R");     data.arDiscountAcct = vars.getStringParameter("inparDiscountAcct");     data.arDiscountAcctr = vars.getStringParameter("inparDiscountAcct_R");     data.apDiscountAcct = vars.getStringParameter("inpapDiscountAcct");     data.apDiscountAcctr = vars.getStringParameter("inpapDiscountAcct_R");     data.notinvoicedreceivablesAcct = vars.getStringParameter("inpnotinvoicedreceivablesAcct");     data.notinvoicedrevenueAcct = vars.getStringParameter("inpnotinvoicedrevenueAcct");     data.unearnedrevenueAcct = vars.getStringParameter("inpunearnedrevenueAcct");     data.vLiabilityAcct = vars.getStringParameter("inpvLiabilityAcct");     data.vLiabilityAcctr = vars.getStringParameter("inpvLiabilityAcct_R");     data.vLiabilityServicesAcct = vars.getStringParameter("inpvLiabilityServicesAcct");     data.vPrepaymentAcct = vars.getStringParameter("inpvPrepaymentAcct");     data.paydiscountRevAcct = vars.getStringParameter("inppaydiscountRevAcct");     data.notinvoicedreceiptsAcct = vars.getStringParameter("inpnotinvoicedreceiptsAcct");     data.notinvoicedreceiptsAcctr = vars.getStringParameter("inpnotinvoicedreceiptsAcct_R");     data.ePrepaymentAcct = vars.getStringParameter("inpePrepaymentAcct");     data.eExpenseAcct = vars.getStringParameter("inpeExpenseAcct");     data.pAssetAcct = vars.getStringParameter("inppAssetAcct");     data.pAssetAcctr = vars.getStringParameter("inppAssetAcct_R");     data.pExpenseAcct = vars.getStringParameter("inppExpenseAcct");     data.pExpenseAcctr = vars.getStringParameter("inppExpenseAcct_R");     data.pRevenueAcct = vars.getStringParameter("inppRevenueAcct");     data.pRevenueAcctr = vars.getStringParameter("inppRevenueAcct_R");     data.pCogsAcct = vars.getStringParameter("inppCogsAcct");     data.pCogsAcctr = vars.getStringParameter("inppCogsAcct_R");     data.pPurchasepricevarianceAcct = vars.getStringParameter("inppPurchasepricevarianceAcct");     data.pInvoicepricevarianceAcct = vars.getStringParameter("inppInvoicepricevarianceAcct");     data.pInvoicepricevarianceAcctr = vars.getStringParameter("inppInvoicepricevarianceAcct_R");     data.pTradediscountrecAcct = vars.getStringParameter("inppTradediscountrecAcct");     data.pTradediscountgrantAcct = vars.getStringParameter("inppTradediscountgrantAcct");     data.wInventoryAcct = vars.getStringParameter("inpwInventoryAcct");     data.wInventoryAcctr = vars.getStringParameter("inpwInventoryAcct_R");     data.wInvactualadjustAcct = vars.getStringParameter("inpwInvactualadjustAcct");     data.wDifferencesAcct = vars.getStringParameter("inpwDifferencesAcct");     data.wDifferencesAcctr = vars.getStringParameter("inpwDifferencesAcct_R");     data.wRevaluationAcct = vars.getStringParameter("inpwRevaluationAcct");     data.wRevaluationAcctr = vars.getStringParameter("inpwRevaluationAcct_R");     data.bAssetAcct = vars.getStringParameter("inpbAssetAcct");     data.bAssetAcctr = vars.getStringParameter("inpbAssetAcct_R");     data.bIntransitAcct = vars.getStringParameter("inpbIntransitAcct");     data.bIntransitAcctr = vars.getStringParameter("inpbIntransitAcct_R");     data.bUnidentifiedAcct = vars.getStringParameter("inpbUnidentifiedAcct");     data.bUnallocatedcashAcct = vars.getStringParameter("inpbUnallocatedcashAcct");     data.bPaymentselectAcct = vars.getStringParameter("inpbPaymentselectAcct");     data.bPaymentselectAcctr = vars.getStringParameter("inpbPaymentselectAcct_R");     data.bExpenseAcct = vars.getStringParameter("inpbExpenseAcct");     data.bExpenseAcctr = vars.getStringParameter("inpbExpenseAcct_R");     data.bInterestexpAcct = vars.getStringParameter("inpbInterestexpAcct");     data.bInterestrevAcct = vars.getStringParameter("inpbInterestrevAcct");     data.bRevaluationgainAcct = vars.getStringParameter("inpbRevaluationgainAcct");     data.bRevaluationgainAcctr = vars.getStringParameter("inpbRevaluationgainAcct_R");     data.bRevaluationlossAcct = vars.getStringParameter("inpbRevaluationlossAcct");     data.bRevaluationlossAcctr = vars.getStringParameter("inpbRevaluationlossAcct_R");     data.bSettlementlossAcct = vars.getStringParameter("inpbSettlementlossAcct");     data.bSettlementgainAcct = vars.getStringParameter("inpbSettlementgainAcct");     data.tDueAcct = vars.getStringParameter("inptDueAcct");     data.tDueAcctr = vars.getStringParameter("inptDueAcct_R");     data.tLiabilityAcct = vars.getStringParameter("inptLiabilityAcct");     data.tCreditAcct = vars.getStringParameter("inptCreditAcct");     data.tCreditAcctr = vars.getStringParameter("inptCreditAcct_R");     data.tReceivablesAcct = vars.getStringParameter("inptReceivablesAcct");     data.tExpenseAcct = vars.getStringParameter("inptExpenseAcct");     data.chExpenseAcct = vars.getStringParameter("inpchExpenseAcct");     data.chExpenseAcctr = vars.getStringParameter("inpchExpenseAcct_R");     data.chRevenueAcct = vars.getStringParameter("inpchRevenueAcct");     data.unrealizedgainAcct = vars.getStringParameter("inpunrealizedgainAcct");     data.unrealizedlossAcct = vars.getStringParameter("inpunrealizedlossAcct");     data.realizedgainAcct = vars.getStringParameter("inprealizedgainAcct");     data.realizedlossAcct = vars.getStringParameter("inprealizedlossAcct");     data.cbAssetAcct = vars.getStringParameter("inpcbAssetAcct");     data.cbAssetAcctr = vars.getStringParameter("inpcbAssetAcct_R");     data.cbDifferencesAcct = vars.getStringParameter("inpcbDifferencesAcct");     data.cbDifferencesAcctr = vars.getStringParameter("inpcbDifferencesAcct_R");     data.cbCashtransferAcct = vars.getStringParameter("inpcbCashtransferAcct");     data.cbCashtransferAcctr = vars.getStringParameter("inpcbCashtransferAcct_R");     data.cbExpenseAcct = vars.getStringParameter("inpcbExpenseAcct");     data.cbExpenseAcctr = vars.getStringParameter("inpcbExpenseAcct_R");     data.cbReceiptAcct = vars.getStringParameter("inpcbReceiptAcct");     data.cbReceiptAcctr = vars.getStringParameter("inpcbReceiptAcct_R");     data.aDepreciationAcct = vars.getStringParameter("inpaDepreciationAcct");     data.aDepreciationAcctr = vars.getStringParameter("inpaDepreciationAcct_R");     data.aAccumdepreciationAcct = vars.getStringParameter("inpaAccumdepreciationAcct");     data.aAccumdepreciationAcctr = vars.getStringParameter("inpaAccumdepreciationAcct_R");     data.pjAssetAcct = vars.getStringParameter("inppjAssetAcct");     data.pjAssetAcctr = vars.getStringParameter("inppjAssetAcct_R");     data.pjWipAcct = vars.getStringParameter("inppjWipAcct");     data.pjWipAcctr = vars.getStringParameter("inppjWipAcct_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.withholdingAcct = vars.getStringParameter("inpwithholdingAcct");     data.processing = vars.getStringParameter("inpprocessing"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cAcctschemaId = vars.getGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");


    
    

    
    }
    catch(ServletException e) {
    	vars.setEditionData(tabId, data);
    	throw e;
    }
    // Behavior with exception for numeric fields is to catch last one if we have multiple ones
    if(ex != null) {
      vars.setEditionData(tabId, data);
      throw ex;
    }
    return data;
  }

   private DefaultsData[] getRelationData(DefaultsData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].cAcctschemaDefaultId = FormatUtilities.truncate(data[i].cAcctschemaDefaultId, 10);        data[i].cAcctschemaId = FormatUtilities.truncate(data[i].cAcctschemaId, 44);        data[i].cReceivableAcct = FormatUtilities.truncate(data[i].cReceivableAcct, 44);        data[i].cPrepaymentAcct = FormatUtilities.truncate(data[i].cPrepaymentAcct, 44);        data[i].aDisposalGain = FormatUtilities.truncate(data[i].aDisposalGain, 23);        data[i].paydiscountExpAcct = FormatUtilities.truncate(data[i].paydiscountExpAcct, 44);        data[i].aDisposalLoss = FormatUtilities.truncate(data[i].aDisposalLoss, 23);        data[i].writeoffAcct = FormatUtilities.truncate(data[i].writeoffAcct, 44);        data[i].arDiscountAcct = FormatUtilities.truncate(data[i].arDiscountAcct, 32);        data[i].apDiscountAcct = FormatUtilities.truncate(data[i].apDiscountAcct, 32);        data[i].notinvoicedreceivablesAcct = FormatUtilities.truncate(data[i].notinvoicedreceivablesAcct, 44);        data[i].notinvoicedrevenueAcct = FormatUtilities.truncate(data[i].notinvoicedrevenueAcct, 44);        data[i].unearnedrevenueAcct = FormatUtilities.truncate(data[i].unearnedrevenueAcct, 44);        data[i].vLiabilityAcct = FormatUtilities.truncate(data[i].vLiabilityAcct, 44);        data[i].vLiabilityServicesAcct = FormatUtilities.truncate(data[i].vLiabilityServicesAcct, 44);        data[i].vPrepaymentAcct = FormatUtilities.truncate(data[i].vPrepaymentAcct, 44);        data[i].paydiscountRevAcct = FormatUtilities.truncate(data[i].paydiscountRevAcct, 44);        data[i].notinvoicedreceiptsAcct = FormatUtilities.truncate(data[i].notinvoicedreceiptsAcct, 44);        data[i].ePrepaymentAcct = FormatUtilities.truncate(data[i].ePrepaymentAcct, 44);        data[i].eExpenseAcct = FormatUtilities.truncate(data[i].eExpenseAcct, 44);        data[i].pAssetAcct = FormatUtilities.truncate(data[i].pAssetAcct, 44);        data[i].pExpenseAcct = FormatUtilities.truncate(data[i].pExpenseAcct, 44);        data[i].pRevenueAcct = FormatUtilities.truncate(data[i].pRevenueAcct, 44);        data[i].pCogsAcct = FormatUtilities.truncate(data[i].pCogsAcct, 44);        data[i].pPurchasepricevarianceAcct = FormatUtilities.truncate(data[i].pPurchasepricevarianceAcct, 44);        data[i].pInvoicepricevarianceAcct = FormatUtilities.truncate(data[i].pInvoicepricevarianceAcct, 44);        data[i].pTradediscountrecAcct = FormatUtilities.truncate(data[i].pTradediscountrecAcct, 44);        data[i].pTradediscountgrantAcct = FormatUtilities.truncate(data[i].pTradediscountgrantAcct, 44);        data[i].wInventoryAcct = FormatUtilities.truncate(data[i].wInventoryAcct, 44);        data[i].wInvactualadjustAcct = FormatUtilities.truncate(data[i].wInvactualadjustAcct, 44);        data[i].wDifferencesAcct = FormatUtilities.truncate(data[i].wDifferencesAcct, 44);        data[i].wRevaluationAcct = FormatUtilities.truncate(data[i].wRevaluationAcct, 44);        data[i].bAssetAcct = FormatUtilities.truncate(data[i].bAssetAcct, 44);        data[i].bIntransitAcct = FormatUtilities.truncate(data[i].bIntransitAcct, 44);        data[i].bUnidentifiedAcct = FormatUtilities.truncate(data[i].bUnidentifiedAcct, 44);        data[i].bUnallocatedcashAcct = FormatUtilities.truncate(data[i].bUnallocatedcashAcct, 44);        data[i].bPaymentselectAcct = FormatUtilities.truncate(data[i].bPaymentselectAcct, 44);        data[i].bExpenseAcct = FormatUtilities.truncate(data[i].bExpenseAcct, 44);        data[i].bInterestexpAcct = FormatUtilities.truncate(data[i].bInterestexpAcct, 44);        data[i].bInterestrevAcct = FormatUtilities.truncate(data[i].bInterestrevAcct, 44);        data[i].bRevaluationgainAcct = FormatUtilities.truncate(data[i].bRevaluationgainAcct, 44);        data[i].bRevaluationlossAcct = FormatUtilities.truncate(data[i].bRevaluationlossAcct, 44);        data[i].bSettlementlossAcct = FormatUtilities.truncate(data[i].bSettlementlossAcct, 44);        data[i].bSettlementgainAcct = FormatUtilities.truncate(data[i].bSettlementgainAcct, 44);        data[i].tDueAcct = FormatUtilities.truncate(data[i].tDueAcct, 44);        data[i].tLiabilityAcct = FormatUtilities.truncate(data[i].tLiabilityAcct, 44);        data[i].tCreditAcct = FormatUtilities.truncate(data[i].tCreditAcct, 44);        data[i].tReceivablesAcct = FormatUtilities.truncate(data[i].tReceivablesAcct, 44);        data[i].tExpenseAcct = FormatUtilities.truncate(data[i].tExpenseAcct, 44);        data[i].chExpenseAcct = FormatUtilities.truncate(data[i].chExpenseAcct, 44);        data[i].chRevenueAcct = FormatUtilities.truncate(data[i].chRevenueAcct, 44);        data[i].unrealizedgainAcct = FormatUtilities.truncate(data[i].unrealizedgainAcct, 44);        data[i].unrealizedlossAcct = FormatUtilities.truncate(data[i].unrealizedlossAcct, 44);        data[i].realizedgainAcct = FormatUtilities.truncate(data[i].realizedgainAcct, 44);        data[i].realizedlossAcct = FormatUtilities.truncate(data[i].realizedlossAcct, 44);        data[i].cbAssetAcct = FormatUtilities.truncate(data[i].cbAssetAcct, 44);        data[i].cbDifferencesAcct = FormatUtilities.truncate(data[i].cbDifferencesAcct, 44);        data[i].cbCashtransferAcct = FormatUtilities.truncate(data[i].cbCashtransferAcct, 44);        data[i].cbExpenseAcct = FormatUtilities.truncate(data[i].cbExpenseAcct, 44);        data[i].cbReceiptAcct = FormatUtilities.truncate(data[i].cbReceiptAcct, 44);        data[i].aDepreciationAcct = FormatUtilities.truncate(data[i].aDepreciationAcct, 23);        data[i].aAccumdepreciationAcct = FormatUtilities.truncate(data[i].aAccumdepreciationAcct, 23);        data[i].pjAssetAcct = FormatUtilities.truncate(data[i].pjAssetAcct, 44);        data[i].pjWipAcct = FormatUtilities.truncate(data[i].pjWipAcct, 44);        data[i].withholdingAcct = FormatUtilities.truncate(data[i].withholdingAcct, 44);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPC_AcctSchema_ID) throws IOException,ServletException {
      AccountingSchemaData[] data = AccountingSchemaData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_AcctSchema_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|C_AcctSchema_ID", data[0].cAcctschemaId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);
      vars.setSessionValue(windowId + "|C_AcctSchema_ID", strPC_AcctSchema_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strC_Acctschema_Default_ID) throws ServletException {
    String strPC_AcctSchema_ID = DefaultsData.selectParentID(this, strC_Acctschema_Default_ID);
    if (strPC_AcctSchema_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strC_Acctschema_Default_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_AcctSchema_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|C_Acctschema_Default_ID", data[0].getField("cAcctschemaDefaultId"));    vars.setSessionValue(windowId + "|C_AcctSchema_ID", data[0].getField("cAcctschemaId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_AcctSchema_ID) throws IOException,ServletException {
      DefaultsData[] data = DefaultsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_AcctSchema_ID, vars.getStringParameter("inpcAcctschemaDefaultId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
      refreshSessionEdit(vars, data);
    }

  private String nextElement(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (strSelected == null || strSelected.equals("")) return firstElement(vars, tableSQL);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(), 0, 0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.NEXT, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting next element", e);
      }
      if (data!=null) {
        if (data!=null) return data;
      }
    }
    return strSelected;
  }

  private int getKeyPosition(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("getKeyPosition: " + strSelected);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.GETPOSITION, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting key position", e);
      }
      if (data!=null) {
        // split offset -> (page,relativeOffset)
        int absoluteOffset = Integer.valueOf(data);
        int page = absoluteOffset / TableSQLData.maxRowsPerGridPage;
        int relativeOffset = absoluteOffset % TableSQLData.maxRowsPerGridPage;
        log4j.debug("getKeyPosition: absOffset: " + absoluteOffset + "=> page: " + page + " relOffset: " + relativeOffset);
        String currPageKey = tabId + "|" + "currentPage";
        vars.setSessionValue(currPageKey, String.valueOf(page));
        return relativeOffset;
      }
    }
    return 0;
  }

  private String previousElement(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (strSelected == null || strSelected.equals("")) return firstElement(vars, tableSQL);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.PREVIOUS, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting previous element", e);
      }
      if (data!=null) {
        return data;
      }
    }
    return strSelected;
  }

  private String firstElement(VariablesSecureApp vars, TableSQLData tableSQL) throws IOException, ServletException {
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,1);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.FIRST, "", tableSQL.getKeyColumn());

      } catch (Exception e) { 
        log4j.debug("Error getting first element", e);
      }
      if (data!=null) return data;
    }
    return "";
  }

  private String lastElement(VariablesSecureApp vars, TableSQLData tableSQL) throws IOException, ServletException {
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.LAST, "", tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting last element", e);
      }
      if (data!=null) return data;
    }
    return "";
  }

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_AcctSchema_ID, String strC_Acctschema_Default_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamC_AcctSchema_ID = vars.getSessionValue(tabId + "|paramC_AcctSchema_ID");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamC_AcctSchema_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_Acctschema_Default_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_Acctschema_Default_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/AccountingSchema/Defaults_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Defaults", false, "document.frmMain.inpcAcctschemaDefaultId", "grid", "..", "".equals("Y"), "AccountingSchema", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPC_AcctSchema_ID);

    StringBuffer orderByArray = new StringBuffer();
      vars.setSessionValue(tabId + "|newOrder", "1");
      String positions = vars.getSessionValue(tabId + "|orderbyPositions");
      orderByArray.append("var orderByPositions = new Array(\n");
      if (!positions.equals("")) {
        StringTokenizer tokens=new StringTokenizer(positions, ",");
        boolean firstOrder = true;
        while(tokens.hasMoreTokens()){
          if (!firstOrder) orderByArray.append(",\n");
          orderByArray.append("\"").append(tokens.nextToken()).append("\"");
          firstOrder = false;
        }
      }
      orderByArray.append(");\n");
      String directions = vars.getSessionValue(tabId + "|orderbyDirections");
      orderByArray.append("var orderByDirections = new Array(\n");
      if (!positions.equals("")) {
        StringTokenizer tokens=new StringTokenizer(directions, ",");
        boolean firstOrder = true;
        while(tokens.hasMoreTokens()){
          if (!firstOrder) orderByArray.append(",\n");
          orderByArray.append("\"").append(tokens.nextToken()).append("\"");
          firstOrder = false;
        }
      }
      orderByArray.append(");\n");
//    }

    xmlDocument.setParameter("selectedColumn", "\nvar selectedRow = " + selectedRow + ";\n" + orderByArray.toString());
    xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
    xmlDocument.setParameter("windowId", windowId);
    xmlDocument.setParameter("KeyName", "cAcctschemaDefaultId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Defaults_Relation.html", "AccountingSchema", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Defaults_Relation.html", strReplaceWith);
      xmlDocument.setParameter("leftTabs", lBar.relationTemplate());
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
    {
      OBError myMessage = vars.getMessage(tabId);
      vars.removeMessage(tabId);
      if (myMessage!=null) {
        xmlDocument.setParameter("messageType", myMessage.getType());
        xmlDocument.setParameter("messageTitle", myMessage.getTitle());
        xmlDocument.setParameter("messageMessage", myMessage.getMessage());
      }
    }
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", DefaultsData.selectParent(this, strPC_AcctSchema_ID));
    else xmlDocument.setParameter("parent", DefaultsData.selectParentTrl(this, strPC_AcctSchema_ID));

    xmlDocument.setParameter("grid", Utility.getContext(this, vars, "#RecordRange", windowId));
xmlDocument.setParameter("grid_Offset", strOffset);
xmlDocument.setParameter("grid_SortCols", positions);
xmlDocument.setParameter("grid_SortDirs", directions);
xmlDocument.setParameter("grid_Default", selectedRow);


    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_Acctschema_Default_ID, String strPC_AcctSchema_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " C_AcctSchema_Default.IsActive";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    DefaultsData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamC_AcctSchema_ID = vars.getSessionValue(tabId + "|paramC_AcctSchema_ID");

    boolean hasSearchCondition=false;
    if (!(strParamC_AcctSchema_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = DefaultsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_AcctSchema_ID, strC_Acctschema_Default_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_Acctschema_Default_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new DefaultsData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cAcctschemaDefaultId") == null || dataField.getField("cAcctschemaDefaultId").equals("")) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        boolNew = true;
      } else {
        discard[0] = new String ("newDiscard");
        strCommand = "EDIT";
      }
    }
    
    
    
    if (dataField==null) {
      if (boolNew || data==null || data.length==0) {
        refreshSessionNew(vars, strPC_AcctSchema_ID);
        data = DefaultsData.set(strPC_AcctSchema_ID, Utility.getDefault(this, vars, "AP_Discount_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4AB84B7CA36B42088BA5533EE6998C45_0(this, Utility.getDefault(this, vars, "AP_Discount_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "A_Depreciation_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef803370_1(this, Utility.getDefault(this, vars, "A_Depreciation_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "NotInvoicedRevenue_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4840_2(this, Utility.getDefault(this, vars, "NotInvoicedRevenue_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "PJ_WIP_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4854_3(this, Utility.getDefault(this, vars, "PJ_WIP_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "A_Accumdepreciation_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef803369_4(this, Utility.getDefault(this, vars, "A_Accumdepreciation_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "B_InterestRev_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4863_5(this, Utility.getDefault(this, vars, "B_InterestRev_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "125", "252", "", dataField), Utility.getDefault(this, vars, "W_InvActualAdjust_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef6114_6(this, Utility.getDefault(this, vars, "W_InvActualAdjust_Acct", "", "125", "252", "", dataField)), "", Utility.getDefault(this, vars, "C_Prepayment_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef3452_7(this, Utility.getDefault(this, vars, "C_Prepayment_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "B_PaymentSelect_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef6491_8(this, Utility.getDefault(this, vars, "B_PaymentSelect_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "P_Revenue_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef3445_9(this, Utility.getDefault(this, vars, "P_Revenue_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "Created", "", "125", "252", "", dataField), Utility.getDefault(this, vars, "E_Prepayment_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef3450_10(this, Utility.getDefault(this, vars, "E_Prepayment_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "C_Receivable_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef3451_11(this, Utility.getDefault(this, vars, "C_Receivable_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "P_InvoicePriceVariance_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef6111_12(this, Utility.getDefault(this, vars, "P_InvoicePriceVariance_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "NotInvoicedReceipts_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4841_13(this, Utility.getDefault(this, vars, "NotInvoicedReceipts_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "T_Credit_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4859_14(this, Utility.getDefault(this, vars, "T_Credit_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "V_Liability_Services_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef3455_15(this, Utility.getDefault(this, vars, "V_Liability_Services_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "V_Liability_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef3453_16(this, Utility.getDefault(this, vars, "V_Liability_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "PayDiscount_Exp_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4846_17(this, Utility.getDefault(this, vars, "PayDiscount_Exp_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "B_Asset_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4861_18(this, Utility.getDefault(this, vars, "B_Asset_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "Withholding_Acct", "", "125", "252", "", dataField), Utility.getDefault(this, vars, "B_RevaluationGain_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4868_19(this, Utility.getDefault(this, vars, "B_RevaluationGain_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "W_Differences_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef3444_20(this, Utility.getDefault(this, vars, "W_Differences_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "CB_Receipt_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef5209_21(this, Utility.getDefault(this, vars, "CB_Receipt_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "P_Expense_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef3446_22(this, Utility.getDefault(this, vars, "P_Expense_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "P_Asset_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef3447_23(this, Utility.getDefault(this, vars, "P_Asset_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "CB_Differences_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef5207_24(this, Utility.getDefault(this, vars, "CB_Differences_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "Ch_Expense_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4870_25(this, Utility.getDefault(this, vars, "Ch_Expense_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "PJ_Asset_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef3456_26(this, Utility.getDefault(this, vars, "PJ_Asset_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "UnEarnedRevenue_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4872_27(this, Utility.getDefault(this, vars, "UnEarnedRevenue_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "B_Expense_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4862_28(this, Utility.getDefault(this, vars, "B_Expense_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "A_Disposal_Loss", "", "125", "252", "", dataField), Utility.getDefault(this, vars, "UnrealizedLoss_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4850_29(this, Utility.getDefault(this, vars, "UnrealizedLoss_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "UnrealizedGain_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4849_30(this, Utility.getDefault(this, vars, "UnrealizedGain_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "P_TradeDiscountRec_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef6112_31(this, Utility.getDefault(this, vars, "P_TradeDiscountRec_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "CreatedBy", "", "125", "252", "", dataField), DefaultsData.selectDef3440_32(this, Utility.getDefault(this, vars, "CreatedBy", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "T_Receivables_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4857_33(this, Utility.getDefault(this, vars, "T_Receivables_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "W_Inventory_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef3443_34(this, Utility.getDefault(this, vars, "W_Inventory_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "WriteOff_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4847_35(this, Utility.getDefault(this, vars, "WriteOff_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "125", "252", "", dataField), Utility.getDefault(this, vars, "CB_Expense_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef5208_36(this, Utility.getDefault(this, vars, "CB_Expense_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "B_InterestExp_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4864_37(this, Utility.getDefault(this, vars, "B_InterestExp_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "P_PurchasePriceVariance_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4844_38(this, Utility.getDefault(this, vars, "P_PurchasePriceVariance_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "B_InTransit_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4860_39(this, Utility.getDefault(this, vars, "B_InTransit_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "W_Revaluation_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4843_40(this, Utility.getDefault(this, vars, "W_Revaluation_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "AR_Discount_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef9E64B4959F9B4D29B393E3E516093DB1_41(this, Utility.getDefault(this, vars, "AR_Discount_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "Ch_Revenue_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4871_42(this, Utility.getDefault(this, vars, "Ch_Revenue_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "RealizedGain_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4851_43(this, Utility.getDefault(this, vars, "RealizedGain_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "RealizedLoss_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4852_44(this, Utility.getDefault(this, vars, "RealizedLoss_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "B_SettlementGain_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4866_45(this, Utility.getDefault(this, vars, "B_SettlementGain_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "P_Cogs_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef3448_46(this, Utility.getDefault(this, vars, "P_Cogs_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "A_Disposal_Gain", "", "125", "252", "", dataField), Utility.getDefault(this, vars, "CB_CashTransfer_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef6493_47(this, Utility.getDefault(this, vars, "CB_CashTransfer_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "T_Due_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4858_48(this, Utility.getDefault(this, vars, "T_Due_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "V_Prepayment_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef3454_49(this, Utility.getDefault(this, vars, "V_Prepayment_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "P_TradeDiscountGrant_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef6113_50(this, Utility.getDefault(this, vars, "P_TradeDiscountGrant_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "T_Expense_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4855_51(this, Utility.getDefault(this, vars, "T_Expense_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "NotInvoicedReceivables_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4873_52(this, Utility.getDefault(this, vars, "NotInvoicedReceivables_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "T_Liability_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4856_53(this, Utility.getDefault(this, vars, "T_Liability_Acct", "", "125", "252", "", dataField)), "Y", Utility.getDefault(this, vars, "CB_Asset_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef5206_54(this, Utility.getDefault(this, vars, "CB_Asset_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "Processing", "", "125", "252", "N", dataField), Utility.getDefault(this, vars, "B_UnallocatedCash_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef6492_55(this, Utility.getDefault(this, vars, "B_UnallocatedCash_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "B_SettlementLoss_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4867_56(this, Utility.getDefault(this, vars, "B_SettlementLoss_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "UpdatedBy", "", "125", "252", "", dataField), DefaultsData.selectDef3442_57(this, Utility.getDefault(this, vars, "UpdatedBy", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "B_Unidentified_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4865_58(this, Utility.getDefault(this, vars, "B_Unidentified_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "PayDiscount_Rev_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4848_59(this, Utility.getDefault(this, vars, "PayDiscount_Rev_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "E_Expense_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef3449_60(this, Utility.getDefault(this, vars, "E_Expense_Acct", "", "125", "252", "", dataField)), Utility.getDefault(this, vars, "B_RevaluationLoss_Acct", "", "125", "252", "", dataField), DefaultsData.selectDef4869_61(this, Utility.getDefault(this, vars, "B_RevaluationLoss_Acct", "", "125", "252", "", dataField)));
        
      }
    } else {
      data = new DefaultsData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(DefaultsData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=AccountingSchemaData.selectOrg(this, strPC_AcctSchema_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Defaults", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcAcctschemaDefaultId", "", "..", "".equals("Y"), "AccountingSchema", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_Acctschema_Default_ID));
    toolbar.prepareEditionTemplate("N".equals("Y"), hasSearchCondition, vars.getSessionValue("#ShowTest", "N").equals("Y"), "STD", Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    
  // set updated timestamp to manage locking mechanism
    String updatedTimestamp="";
    if (!boolNew) {
      updatedTimestamp=(dataField != null ? dataField.getField("updatedTimeStamp") : data[0].getField("updatedTimeStamp"));
    }
    this.setUpdatedtimestamp(updatedTimestamp);
   // this.setOrgparent(currentPOrg);
    this.setCommandtype(strCommand);
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, true, (strCommand.equalsIgnoreCase("NEW")));
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter output = response.getWriter();
      
      Connection conn = null;
      Scripthelper script = new Scripthelper();
      if (boolNew) 
        script.addHiddenfieldWithID("newdatasetindicator", "NEW");
      else
        script.addHiddenfieldWithID("newdatasetindicator", "");
      script.addHiddenfieldWithID("enabledautosave", "Y");
      script.addMessage(this, vars, vars.getMessage(tabId));
      Formhelper fh=new Formhelper();
      String strLeftabsmode="EDIT";
      String focus=fh.TabGetFirstFocusField(this,tabId);
      String strSkeleton = ConfigureFrameWindow.doConfigureWindowMode(this,vars,Sqlc.TransformaNombreColumna(focus),tabs.breadcrumb(), "Form Window",null,strLeftabsmode,tabs,"_Relation",toolbar.toString());
      String strTableStructure="";
      if (editableTab||tabId.equalsIgnoreCase("800026"))
        strTableStructure=fh.prepareTabFields(this, vars, script, tabId,data[0], Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
      else
        strTableStructure=fh.prepareTabFieldsRO(this, vars, script, tabId,data[0], Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
      strSkeleton=Replace.replace(strSkeleton, "@CONTENT@", strTableStructure );  
      strSkeleton = script.doScript(strSkeleton, "",this,vars);
      output.println(strSkeleton);
      vars.removeMessage(tabId);
      output.close();
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
  }

  void printPageButtonFS(HttpServletResponse response, VariablesSecureApp vars, String strProcessId, String path) throws IOException, ServletException {
    log4j.debug("Output: Frames action button");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "org/openbravo/erpCommon/ad_actionButton/ActionButtonDefaultFrames").createXmlDocument();
    xmlDocument.setParameter("processId", strProcessId);
    xmlDocument.setParameter("trlFormType", "PROCESS");
    xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
    xmlDocument.setParameter("type", strDireccion + path);
    out.println(xmlDocument.print());
    out.close();
  }
  






    private String getDisplayLogicContext(VariablesSecureApp vars, boolean isNew) throws IOException, ServletException {
      log4j.debug("Output: Display logic context fields");
      String result = "var strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\n";
      return result;
    }


    private String getReadOnlyLogicContext(VariablesSecureApp vars) throws IOException, ServletException {
      log4j.debug("Output: Read Only logic context fields");
      String result = "";
      return result;
    }




 
  private String getShortcutScript( HashMap<String, String> usedButtonShortCuts){
    StringBuffer shortcuts = new StringBuffer();
    shortcuts.append(" function buttonListShorcuts() {\n");
    Iterator<String> ik = usedButtonShortCuts.keySet().iterator();
    Iterator<String> iv = usedButtonShortCuts.values().iterator();
    while(ik.hasNext() && iv.hasNext()){
      shortcuts.append("  keyArray[keyArray.length] = new keyArrayItem(\"").append(ik.next()).append("\", \"").append(iv.next()).append("\", null, \"altKey\", false, \"onkeydown\");\n");
    }
    shortcuts.append(" return true;\n}");
    return shortcuts.toString();
  }
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPC_AcctSchema_ID) throws IOException, ServletException {
    DefaultsData data = null;
    int total = 0;
    if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        OBError newError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        myError.setError(newError);
        vars.setMessage(tabId, myError);
    }
    else {
        Connection con = null;
        try {
            con = this.getTransactionConnection();
            data = getEditVariables(con, vars, strPC_AcctSchema_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.cAcctschemaDefaultId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (DefaultsData.getCurrentDBTimestamp(this, data.cAcctschemaDefaultId).equals(
                vars.getStringParameter("updatedTimestamp"))) {
                total = data.update(con, this);
               } else {
                 myError.setMessage(Replace.replace(Replace.replace(Utility.messageBD(this,
                    "SavingModifiedRecord", vars.getLanguage()), "\\n", "<br/>"), "&quot;", "\""));
                 myError.setType("Error");
                 vars.setSessionValue(tabId + "|concurrentSave", "true");
               } 
		     }		            
          
            }
                else {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
            myError.setError(newError);            
          }
          releaseCommitConnection(con);
          CrudOperations.UpdateCustomFields(tabId, data.cAcctschemaDefaultId, vars, this);
        } catch(Exception ex) {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
            myError.setError(newError);   
            try {
              releaseRollbackConnection(con);
            } catch (final Exception e) { //do nothing 
            }           
        }
            
        if (myError.isEmpty() && total == 0) {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=DBExecuteError");
            myError.setError(newError);
        }
        vars.setMessage(tabId, myError);
            
        if(!myError.isEmpty()){
            if(data != null ) {
                if(type == 'I') {            			
                    data.cAcctschemaDefaultId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_Acctschema_Default_ID", data.cAcctschemaDefaultId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Defaults. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
