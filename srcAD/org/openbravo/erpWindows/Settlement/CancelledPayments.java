
package org.openbravo.erpWindows.Settlement;


import org.openbravo.erpCommon.reference.*;




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

public class CancelledPayments extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(CancelledPayments.class);
  
  private static final String windowId = "800005";
  private static final String tabId = "800026";
  private static final String defaultTabView = "RELATION";
  private static final int accesslevel = 1;
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
        String strcDebtPaymentId = request.getParameter("inpcDebtPaymentId");
         String strPC_Settlement_ID = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcDebtPaymentId.equals(""))
              total = saveRecord(vars, myError, 'U', strPC_Settlement_ID);
          else
              total = saveRecord(vars, myError, 'I', strPC_Settlement_ID);
          
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
      String strPC_Settlement_ID = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID", "");

      String strC_Debt_Payment_ID = vars.getGlobalVariable("inpcDebtPaymentId", windowId + "|C_Debt_Payment_ID", "");
            if (strPC_Settlement_ID.equals("")) {
        strPC_Settlement_ID = getParentID(vars, strC_Debt_Payment_ID);
        if (strPC_Settlement_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_Settlement_ID");
        vars.setSessionValue(windowId + "|C_Settlement_ID", strPC_Settlement_ID);

        refreshParentSession(vars, strPC_Settlement_ID);
      }


      String strView = vars.getSessionValue(tabId + "|CancelledPayments.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_Debt_Payment_ID.equals("")) strC_Debt_Payment_ID = firstElement(vars, tableSQL);
          if (strC_Debt_Payment_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Debt_Payment_ID, strPC_Settlement_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Settlement_ID, strC_Debt_Payment_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_Debt_Payment_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_Debt_Payment_ID.equals("")) strC_Debt_Payment_ID = vars.getRequiredGlobalVariable("inpcDebtPaymentId", windowId + "|C_Debt_Payment_ID");
      else vars.setSessionValue(windowId + "|C_Debt_Payment_ID", strC_Debt_Payment_ID);
      
      
      String strPC_Settlement_ID = getParentID(vars, strC_Debt_Payment_ID);
      
      vars.setSessionValue(windowId + "|C_Settlement_ID", strPC_Settlement_ID);
      vars.setSessionValue("800025|Settlement.view", "EDIT");

      refreshParentSession(vars, strPC_Settlement_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|CancelledPayments.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_Debt_Payment_ID, strPC_Settlement_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|CancelledPayments.view", "RELATION");
        printPageDataSheet(response, vars, strPC_Settlement_ID, strC_Debt_Payment_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_Settlement_ID = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|C_Debt_Payment_ID");
      refreshParentSession(vars, strPC_Settlement_ID);


      String strView = vars.getSessionValue(tabId + "|CancelledPayments.view");
      String strC_Debt_Payment_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_Debt_Payment_ID = firstElement(vars, tableSQL);
          if (strC_Debt_Payment_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_Debt_Payment_ID.equals("")) strC_Debt_Payment_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_Debt_Payment_ID, strPC_Settlement_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_Settlement_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamC_BPartner_ID", tabId + "|paramC_BPartner_ID");
vars.getRequestGlobalVariable("inpParamPaymentRule", tabId + "|paramPaymentRule");
vars.getRequestGlobalVariable("inpParamDateplanned", tabId + "|paramDateplanned");
vars.getRequestGlobalVariable("inpParamAmount", tabId + "|paramAmount");
vars.getRequestGlobalVariable("inpParamIsReceipt", tabId + "|paramIsReceipt");
vars.getRequestGlobalVariable("inpParamDateplanned_f", tabId + "|paramDateplanned_f");
vars.getRequestGlobalVariable("inpParamAmount_f", tabId + "|paramAmount_f");

            String strPC_Settlement_ID = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID");

      
      vars.removeSessionValue(windowId + "|C_Debt_Payment_ID");
      String strC_Debt_Payment_ID="";

      String strView = vars.getSessionValue(tabId + "|CancelledPayments.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_Debt_Payment_ID = firstElement(vars, tableSQL);
        if (strC_Debt_Payment_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|CancelledPayments.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Debt_Payment_ID, strPC_Settlement_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Settlement_ID, strC_Debt_Payment_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_Settlement_ID = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID");
      

      String strC_Debt_Payment_ID = vars.getGlobalVariable("inpcDebtPaymentId", windowId + "|C_Debt_Payment_ID", "");
      vars.setSessionValue(tabId + "|CancelledPayments.view", "RELATION");
      printPageDataSheet(response, vars, strPC_Settlement_ID, strC_Debt_Payment_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_Settlement_ID = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID");


      printPageEdit(response, request, vars, true, "", strPC_Settlement_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_Settlement_ID = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_Debt_Payment_ID = vars.getGlobalVariable("inpcDebtPaymentId", windowId + "|C_Debt_Payment_ID", "");
      vars.setSessionValue(tabId + "|CancelledPayments.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_Debt_Payment_ID, strPC_Settlement_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_Settlement_ID = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID");
      String strC_Debt_Payment_ID = vars.getRequiredStringParameter("inpcDebtPaymentId");
      
      String strNext = nextElement(vars, strC_Debt_Payment_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_Settlement_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_Settlement_ID = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID");
      String strC_Debt_Payment_ID = vars.getRequiredStringParameter("inpcDebtPaymentId");
      
      String strPrevious = previousElement(vars, strC_Debt_Payment_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_Settlement_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID");

      vars.setSessionValue(tabId + "|CancelledPayments.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_Settlement_ID = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|CancelledPayments.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|CancelledPayments.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|CancelledPayments.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_Debt_Payment_ID");
      vars.setSessionValue(windowId + "|C_Settlement_ID", strPC_Settlement_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_Settlement_ID = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|CancelledPayments.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|CancelledPayments.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_Debt_Payment_ID");
      vars.setSessionValue(windowId + "|C_Settlement_ID", strPC_Settlement_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPC_Settlement_ID = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPC_Settlement_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPC_Settlement_ID = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPC_Settlement_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPC_Settlement_ID = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPC_Settlement_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPC_Settlement_ID = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPC_Settlement_ID);      
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
      String strPC_Settlement_ID = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID");
      String strC_Debt_Payment_ID = vars.getRequiredGlobalVariable("inpcDebtPaymentId", windowId + "|C_Debt_Payment_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPC_Settlement_ID);      
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
          String strNext = nextElement(vars, strC_Debt_Payment_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_Debt_Payment_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPC_Settlement_ID = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID");

      String strC_Debt_Payment_ID = vars.getRequiredInStringParameter("inpcDebtPaymentId");
      String message = deleteRelation(vars, strC_Debt_Payment_ID, strPC_Settlement_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cDebtPaymentId");
        vars.setSessionValue(tabId + "|CancelledPayments.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPC_Settlement_ID = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID");

      String strC_Debt_Payment_ID = vars.getRequiredStringParameter("inpcDebtPaymentId");
      //CancelledPaymentsData data = getEditVariables(vars, strPC_Settlement_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = CancelledPaymentsData.delete(this, strC_Debt_Payment_ID, strPC_Settlement_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cDebtPaymentId");
        vars.setSessionValue(tabId + "|CancelledPayments.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONChangeSettlementCancel800024")) {
        vars.setSessionValue("button800024.strchangesettlementcancel", vars.getStringParameter("inpchangesettlementcancel"));
        vars.setSessionValue("button800024.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button800024.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button800024.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button800024.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "800024", request.getServletPath());    
     } else if (vars.commandIn("BUTTON800024")) {
        String strC_Debt_Payment_ID = vars.getGlobalVariable("inpcDebtPaymentId", windowId + "|C_Debt_Payment_ID", "");
        String strchangesettlementcancel = vars.getSessionValue("button800024.strchangesettlementcancel");
        String strProcessing = vars.getSessionValue("button800024.strProcessing");
        String strOrg = vars.getSessionValue("button800024.strOrg");
        String strClient = vars.getSessionValue("button800024.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonChangeSettlementCancel800024(response, vars, strC_Debt_Payment_ID, strchangesettlementcancel, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONChangeSettlementCancel800024")) {
        String strC_Debt_Payment_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Debt_Payment_ID", "");
        @SuppressWarnings("unused")
        String strchangesettlementcancel = vars.getStringParameter("inpchangesettlementcancel");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "800024", (("C_Debt_Payment_ID".equalsIgnoreCase("AD_Language"))?"0":strC_Debt_Payment_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
          ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
          new ProcessRunner(bundle).execute(this);
          
          PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
          myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
        } catch (ServletException ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myMessage);
        }
        //close popup
        if (myMessage!=null) {
          if (log4j.isDebugEnabled()) log4j.debug(myMessage.getMessage());
          vars.setMessage(tabId, myMessage);
        }
        printPageClosePopUp(response, vars);






    } else if (vars.getCommand().toUpperCase().startsWith("BUTTON") || vars.getCommand().toUpperCase().startsWith("SAVE_BUTTON")) {
      pageErrorPopUp(response);
    } else pageError(response);
  }
/*
  String deleteRelation(VariablesSecureApp vars, String strC_Debt_Payment_ID, String strPC_Settlement_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_Debt_Payment_ID.startsWith("(")) strC_Debt_Payment_ID = strC_Debt_Payment_ID.substring(1, strC_Debt_Payment_ID.length()-1);
      if (!strC_Debt_Payment_ID.equals("")) {
        strC_Debt_Payment_ID = Replace.replace(strC_Debt_Payment_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_Debt_Payment_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (CancelledPaymentsData.deleteTransactional(conn, this, strKey, strPC_Settlement_ID)==0) {
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
  private CancelledPaymentsData getEditVariables(Connection con, VariablesSecureApp vars, String strPC_Settlement_ID) throws IOException,ServletException {
    CancelledPaymentsData data = new CancelledPaymentsData();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.cSettlementId = vars.getStringParameter("inpcSettlementId");     data.cSettlementIdr = vars.getStringParameter("inpcSettlementId_R");     data.paymentrule = vars.getStringParameter("inppaymentrule");     data.paymentruler = vars.getStringParameter("inppaymentrule_R");     data.dateplanned = vars.getStringParameter("inpdateplanned");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.cInvoiceId = vars.getStringParameter("inpcInvoiceId");     data.cInvoiceIdr = vars.getStringParameter("inpcInvoiceId_R");     data.description = vars.getStringParameter("inpdescription");     data.cCashbookId = vars.getStringParameter("inpcCashbookId");     data.cCashbookIdr = vars.getStringParameter("inpcCashbookId_R");     data.cCashlineId = vars.getStringParameter("inpcCashlineId");     data.cCashlineIdr = vars.getStringParameter("inpcCashlineId_R");     data.cBankaccountId = vars.getStringParameter("inpcBankaccountId");     data.cBankaccountIdr = vars.getStringParameter("inpcBankaccountId_R");     data.cBankstatementlineId = vars.getStringParameter("inpcBankstatementlineId");     data.cBankstatementlineIdr = vars.getStringParameter("inpcBankstatementlineId_R");    try {   data.amount = vars.getNumericParameter("inpamount");  } catch (ServletException paramEx) { ex = paramEx; }     data.cCurrencyId = vars.getStringParameter("inpcCurrencyId");     data.cCurrencyIdr = vars.getStringParameter("inpcCurrencyId_R");    try {   data.writeoffamt = vars.getNumericParameter("inpwriteoffamt", vars.getSessionValue(windowId + "|WriteOffAmt"));  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.discountamt = vars.getNumericParameter("inpdiscountamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.isreceipt = vars.getStringParameter("inpisreceipt", "N");     data.ispaid = vars.getRequiredInputGlobalVariable("inpispaid", windowId + "|IsPaid", "N");     data.changesettlementcancel = vars.getStringParameter("inpchangesettlementcancel");     data.ismanual = vars.getStringParameter("inpismanual", "N");     data.isvalid = vars.getStringParameter("inpisvalid", "N");     data.cancelProcessed = vars.getStringParameter("inpcancelProcessed", "N");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.cDebtPaymentId = vars.getRequestGlobalVariable("inpcDebtPaymentId", windowId + "|C_Debt_Payment_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cSettlementId = vars.getGlobalVariable("inpcSettlementId", windowId + "|C_Settlement_ID");


    
    

    
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

   private CancelledPaymentsData[] getRelationData(CancelledPaymentsData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].cSettlementId = FormatUtilities.truncate(data[i].cSettlementId, 44);        data[i].paymentrule = FormatUtilities.truncate(data[i].paymentrule, 21);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 44);        data[i].cInvoiceId = FormatUtilities.truncate(data[i].cInvoiceId, 44);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].cCashbookId = FormatUtilities.truncate(data[i].cCashbookId, 44);        data[i].cCashlineId = FormatUtilities.truncate(data[i].cCashlineId, 44);        data[i].cBankaccountId = FormatUtilities.truncate(data[i].cBankaccountId, 44);        data[i].cBankstatementlineId = FormatUtilities.truncate(data[i].cBankstatementlineId, 44);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 44);        data[i].cDebtPaymentId = FormatUtilities.truncate(data[i].cDebtPaymentId, 10);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPC_Settlement_ID) throws IOException,ServletException {
      SettlementData[] data = SettlementData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Settlement_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|C_Settlement_ID", data[0].cSettlementId);
      vars.setSessionValue(windowId + "|C_Settlement_ID", strPC_Settlement_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
      vars.setSessionValue(windowId + "|TYPESETTLEMENT", "C");
      
      vars.setSessionValue(windowId + "|DOCTYPE_SETTLEMENT", "STT");
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strC_Debt_Payment_ID) throws ServletException {
    String strPC_Settlement_ID = CancelledPaymentsData.selectParentID(this, strC_Debt_Payment_ID);
    if (strPC_Settlement_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strC_Debt_Payment_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_Settlement_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|WriteOffAmt", data[0].getField("writeoffamt"));    vars.setSessionValue(windowId + "|IsPaid", data[0].getField("ispaid"));    vars.setSessionValue(windowId + "|C_Debt_Payment_ID", data[0].getField("cDebtPaymentId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_Settlement_ID) throws IOException,ServletException {
      CancelledPaymentsData[] data = CancelledPaymentsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Settlement_ID, vars.getStringParameter("inpcDebtPaymentId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_Settlement_ID, String strC_Debt_Payment_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParamPaymentRule = vars.getSessionValue(tabId + "|paramPaymentRule");
String strParamDateplanned = vars.getSessionValue(tabId + "|paramDateplanned");
String strParamAmount = vars.getSessionValue(tabId + "|paramAmount");
String strParamIsReceipt = vars.getSessionValue(tabId + "|paramIsReceipt");
String strParamDateplanned_f = vars.getSessionValue(tabId + "|paramDateplanned_f");
String strParamAmount_f = vars.getSessionValue(tabId + "|paramAmount_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamC_BPartner_ID.equals("") && strParamPaymentRule.equals("") && strParamDateplanned.equals("") && strParamAmount.equals("") && strParamIsReceipt.equals("") && strParamDateplanned_f.equals("") && strParamAmount_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_Debt_Payment_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_Debt_Payment_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/Settlement/CancelledPayments_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "CancelledPayments", false, "document.frmMain.inpcDebtPaymentId", "grid", "..", "".equals("Y"), "Settlement", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), true, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPC_Settlement_ID);

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
    xmlDocument.setParameter("KeyName", "cDebtPaymentId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "CancelledPayments_Relation.html", "Settlement", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "CancelledPayments_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", CancelledPaymentsData.selectParent(this, strPC_Settlement_ID));
    else xmlDocument.setParameter("parent", CancelledPaymentsData.selectParentTrl(this, strPC_Settlement_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_Debt_Payment_ID, String strPC_Settlement_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " 1";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    CancelledPaymentsData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParamPaymentRule = vars.getSessionValue(tabId + "|paramPaymentRule");
String strParamDateplanned = vars.getSessionValue(tabId + "|paramDateplanned");
String strParamAmount = vars.getSessionValue(tabId + "|paramAmount");
String strParamIsReceipt = vars.getSessionValue(tabId + "|paramIsReceipt");
String strParamDateplanned_f = vars.getSessionValue(tabId + "|paramDateplanned_f");
String strParamAmount_f = vars.getSessionValue(tabId + "|paramAmount_f");

    boolean hasSearchCondition=false;
    if (!(strParamC_BPartner_ID.equals("") && strParamPaymentRule.equals("") && strParamDateplanned.equals("") && strParamAmount.equals("") && strParamIsReceipt.equals("") && strParamDateplanned_f.equals("") && strParamAmount_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = CancelledPaymentsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Settlement_ID, strC_Debt_Payment_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_Debt_Payment_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (data==null || data.length==0) {
        strC_Debt_Payment_ID = firstElement(vars, tableSQL);
        if (strC_Debt_Payment_ID.equals("")) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        } else {
          data = CancelledPaymentsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Settlement_ID, strC_Debt_Payment_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
        }
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new CancelledPaymentsData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cDebtPaymentId") == null || dataField.getField("cDebtPaymentId").equals("")) {
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
        refreshSessionNew(vars, strPC_Settlement_ID);
        data = CancelledPaymentsData.set(strPC_Settlement_ID, Utility.getDefault(this, vars, "IsPaid", "", "800005", "800026", "N", dataField), Utility.getDefault(this, vars, "WriteOffAmt", "", "800005", "800026", "", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "800005", "800026", "", dataField), CancelledPaymentsData.selectDef800352_0(this, Utility.getDefault(this, vars, "CreatedBy", "", "800005", "800026", "", dataField)), "", Utility.getDefault(this, vars, "C_Invoice_ID", "", "800005", "800026", "", dataField), CancelledPaymentsData.selectDef800358_1(this, Utility.getDefault(this, vars, "C_Invoice_ID", "", "800005", "800026", "", dataField)), Utility.getDefault(this, vars, "C_Currency_ID", "", "800005", "800026", "", dataField), Utility.getDefault(this, vars, "Amount", "", "800005", "800026", "", dataField), Utility.getDefault(this, vars, "Dateplanned", "", "800005", "800026", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "800005", "800026", "", dataField), Utility.getDefault(this, vars, "C_BankStatementLine_ID", "", "800005", "800026", "", dataField), Utility.getDefault(this, vars, "Discountamt", "", "800005", "800026", "", dataField), Utility.getDefault(this, vars, "Created", "@#Date@", "800005", "800026", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "800005", "800026", "", dataField), Utility.getDefault(this, vars, "ChangeSettlementCancel", "", "800005", "800026", "N", dataField), Utility.getDefault(this, vars, "C_CashLine_ID", "", "800005", "800026", "", dataField), Utility.getDefault(this, vars, "Cancel_Processed", "", "800005", "800026", "N", dataField), Utility.getDefault(this, vars, "C_CashBook_ID", "", "800005", "800026", "", dataField), Utility.getDefault(this, vars, "IsReceipt", "", "800005", "800026", "N", dataField), Utility.getDefault(this, vars, "PaymentRule", "", "800005", "800026", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "800005", "800026", "", dataField), CancelledPaymentsData.selectDef800354_2(this, Utility.getDefault(this, vars, "UpdatedBy", "", "800005", "800026", "", dataField)), Utility.getDefault(this, vars, "C_BankAccount_ID", "", "800005", "800026", "", dataField), Utility.getDefault(this, vars, "IsManual", "", "800005", "800026", "N", dataField), "Y", Utility.getDefault(this, vars, "IsValid", "", "800005", "800026", "N", dataField), Utility.getDefault(this, vars, "Description", "", "800005", "800026", "", dataField), Utility.getDefault(this, vars, "C_BPartner_ID", "", "800005", "800026", "", dataField), CancelledPaymentsData.selectDef800359_3(this, Utility.getDefault(this, vars, "C_BPartner_ID", "", "800005", "800026", "", dataField)));
        
      }
    } else {
      data = new CancelledPaymentsData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(CancelledPaymentsData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=SettlementData.selectOrg(this, strPC_Settlement_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "CancelledPayments", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcDebtPaymentId", "", "..", "".equals("Y"), "Settlement", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_Debt_Payment_ID));
    toolbar.prepareEditionTemplate("N".equals("Y"), hasSearchCondition, vars.getSessionValue("#ShowTest", "N").equals("Y"), "RO", Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    
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
  
    void printPageButtonChangeSettlementCancel800024(HttpServletResponse response, VariablesSecureApp vars, String strC_Debt_Payment_ID, String strchangesettlementcancel, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "800024",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "800024" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"800024" );
        String isDocAction=UtilsData.isProcessDocAction(this, "800024");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "800020",strC_Debt_Payment_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "800020", strC_Debt_Payment_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strchangesettlementcancel, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "800024");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONChangeSettlementCancel" + "800024" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","CancelledPayments_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "800024");
        script.addHiddenfield("inpKey",strC_Debt_Payment_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("800024");
        vars.removeMessage("800024");
        if (myMessage!=null) {
          script.addMessage(this, vars, myMessage);
        }
        strOutput = script.doScript(strOutput, "",this,vars);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(strOutput);
        out.close();
      } catch (Exception ex) {
        throw new ServletException(ex);
      }
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




 
  private String getShortcutScript( HashMap<String, String> usedButtonShortCuts, HashMap<String, String> reservedButtonShortCuts){
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPC_Settlement_ID) throws IOException, ServletException {
    CancelledPaymentsData data = null;
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
            data = getEditVariables(con, vars, strPC_Settlement_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.cDebtPaymentId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (CancelledPaymentsData.getCurrentDBTimestamp(this, data.cDebtPaymentId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cDebtPaymentId, vars, this);
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
                    data.cDebtPaymentId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_Debt_Payment_ID", data.cDebtPaymentId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet CancelledPayments. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
