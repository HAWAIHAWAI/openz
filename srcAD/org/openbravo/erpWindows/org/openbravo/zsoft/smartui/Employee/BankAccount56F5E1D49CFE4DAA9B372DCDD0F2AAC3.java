
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.Employee;





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

public class BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3.class);
  
  private static final String windowId = "39D3CD9F77A942D690965D49106F011B";
  private static final String tabId = "56F5E1D49CFE4DAA9B372DCDD0F2AAC3";
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
        String strcBpBankaccountId = request.getParameter("inpcBpBankaccountId");
         String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcBpBankaccountId.equals(""))
              total = saveRecord(vars, myError, 'U', strPC_BPartner_ID);
          else
              total = saveRecord(vars, myError, 'I', strPC_BPartner_ID);
          
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
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", "");

      String strC_BP_BankAccount_ID = vars.getGlobalVariable("inpcBpBankaccountId", windowId + "|C_BP_BankAccount_ID", "");
            if (strPC_BPartner_ID.equals("")) {
        strPC_BPartner_ID = getParentID(vars, strC_BP_BankAccount_ID);
        if (strPC_BPartner_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_BPartner_ID");
        vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);

        refreshParentSession(vars, strPC_BPartner_ID);
      }


      String strView = vars.getSessionValue(tabId + "|BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_BP_BankAccount_ID.equals("")) strC_BP_BankAccount_ID = firstElement(vars, tableSQL);
          if (strC_BP_BankAccount_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_BP_BankAccount_ID, strPC_BPartner_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_BPartner_ID, strC_BP_BankAccount_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_BP_BankAccount_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_BP_BankAccount_ID.equals("")) strC_BP_BankAccount_ID = vars.getRequiredGlobalVariable("inpcBpBankaccountId", windowId + "|C_BP_BankAccount_ID");
      else vars.setSessionValue(windowId + "|C_BP_BankAccount_ID", strC_BP_BankAccount_ID);
      
      
      String strPC_BPartner_ID = getParentID(vars, strC_BP_BankAccount_ID);
      
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);
      vars.setSessionValue("A3D0B320B69845B386024B5FF6B1E266|Employee.view", "EDIT");

      refreshParentSession(vars, strPC_BPartner_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_BP_BankAccount_ID, strPC_BPartner_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3.view", "RELATION");
        printPageDataSheet(response, vars, strPC_BPartner_ID, strC_BP_BankAccount_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|C_BP_BankAccount_ID");
      refreshParentSession(vars, strPC_BPartner_ID);


      String strView = vars.getSessionValue(tabId + "|BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3.view");
      String strC_BP_BankAccount_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_BP_BankAccount_ID = firstElement(vars, tableSQL);
          if (strC_BP_BankAccount_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_BP_BankAccount_ID.equals("")) strC_BP_BankAccount_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_BP_BankAccount_ID, strPC_BPartner_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_BPartner_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamDisplayedaccount", tabId + "|paramDisplayedaccount");

            String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      
      vars.removeSessionValue(windowId + "|C_BP_BankAccount_ID");
      String strC_BP_BankAccount_ID="";

      String strView = vars.getSessionValue(tabId + "|BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_BP_BankAccount_ID = firstElement(vars, tableSQL);
        if (strC_BP_BankAccount_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_BP_BankAccount_ID, strPC_BPartner_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_BPartner_ID, strC_BP_BankAccount_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      

      String strC_BP_BankAccount_ID = vars.getGlobalVariable("inpcBpBankaccountId", windowId + "|C_BP_BankAccount_ID", "");
      vars.setSessionValue(tabId + "|BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3.view", "RELATION");
      printPageDataSheet(response, vars, strPC_BPartner_ID, strC_BP_BankAccount_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");


      printPageEdit(response, request, vars, true, "", strPC_BPartner_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_BP_BankAccount_ID = vars.getGlobalVariable("inpcBpBankaccountId", windowId + "|C_BP_BankAccount_ID", "");
      vars.setSessionValue(tabId + "|BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_BP_BankAccount_ID, strPC_BPartner_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      String strC_BP_BankAccount_ID = vars.getRequiredStringParameter("inpcBpBankaccountId");
      
      String strNext = nextElement(vars, strC_BP_BankAccount_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      String strC_BP_BankAccount_ID = vars.getRequiredStringParameter("inpcBpBankaccountId");
      
      String strPrevious = previousElement(vars, strC_BP_BankAccount_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      vars.setSessionValue(tabId + "|BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_BP_BankAccount_ID");
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_BP_BankAccount_ID");
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPC_BPartner_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPC_BPartner_ID);      
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
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      String strC_BP_BankAccount_ID = vars.getRequiredGlobalVariable("inpcBpBankaccountId", windowId + "|C_BP_BankAccount_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPC_BPartner_ID);      
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
          String strNext = nextElement(vars, strC_BP_BankAccount_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_BP_BankAccount_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strC_BP_BankAccount_ID = vars.getRequiredInStringParameter("inpcBpBankaccountId");
      String message = deleteRelation(vars, strC_BP_BankAccount_ID, strPC_BPartner_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cBpBankaccountId");
        vars.setSessionValue(tabId + "|BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strC_BP_BankAccount_ID = vars.getRequiredStringParameter("inpcBpBankaccountId");
      //BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data data = getEditVariables(vars, strPC_BPartner_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.delete(this, strC_BP_BankAccount_ID, strPC_BPartner_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cBpBankaccountId");
        vars.setSessionValue(tabId + "|BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strC_BP_BankAccount_ID, String strPC_BPartner_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_BP_BankAccount_ID.startsWith("(")) strC_BP_BankAccount_ID = strC_BP_BankAccount_ID.substring(1, strC_BP_BankAccount_ID.length()-1);
      if (!strC_BP_BankAccount_ID.equals("")) {
        strC_BP_BankAccount_ID = Replace.replace(strC_BP_BankAccount_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_BP_BankAccount_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.deleteTransactional(conn, this, strKey, strPC_BPartner_ID)==0) {
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
  private BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data getEditVariables(Connection con, VariablesSecureApp vars, String strPC_BPartner_ID) throws IOException,ServletException {
    BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data data = new BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data();
    ServletException ex = null;
    try {
    data.aCountry = vars.getStringParameter("inpaCountry");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.adUserId = vars.getStringParameter("inpadUserId");     data.adUserIdr = vars.getStringParameter("inpadUserId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.bankaccounttype = vars.getStringParameter("inpbankaccounttype");     data.bankaccounttyper = vars.getStringParameter("inpbankaccounttype_R");     data.routingno = vars.getStringParameter("inproutingno");     data.accountno = vars.getStringParameter("inpaccountno");     data.showaccountno = vars.getStringParameter("inpshowaccountno", "N");     data.aZip = vars.getStringParameter("inpaZip");     data.iban = vars.getStringParameter("inpiban");     data.showiban = vars.getStringParameter("inpshowiban", "N");     data.swiftcode = vars.getStringParameter("inpswiftcode");     data.cCountryId = vars.getStringParameter("inpcCountryId");     data.cCountryIdr = vars.getStringParameter("inpcCountryId_R");     data.displayedaccount = vars.getStringParameter("inpdisplayedaccount");     data.bankName = vars.getStringParameter("inpbankName");     data.creditcardtype = vars.getStringParameter("inpcreditcardtype");     data.creditcardtyper = vars.getStringParameter("inpcreditcardtype_R");     data.creditcardnumber = vars.getStringParameter("inpcreditcardnumber");    try {   data.creditcardexpmm = vars.getNumericParameter("inpcreditcardexpmm");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.creditcardexpyy = vars.getNumericParameter("inpcreditcardexpyy");  } catch (ServletException paramEx) { ex = paramEx; }     data.aName = vars.getStringParameter("inpaName");     data.text1 = vars.getStringParameter("inptext1");     data.aStreet = vars.getStringParameter("inpaStreet");     data.aIdentSsn = vars.getStringParameter("inpaIdentSsn");     data.aIdentDl = vars.getStringParameter("inpaIdentDl");     data.aCity = vars.getStringParameter("inpaCity");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.aState = vars.getStringParameter("inpaState");     data.rAvszip = vars.getStringParameter("inprAvszip");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.cBpBankaccountId = vars.getRequestGlobalVariable("inpcBpBankaccountId", windowId + "|C_BP_BankAccount_ID");     data.aEmail = vars.getStringParameter("inpaEmail"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cBpartnerId = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");


    
    

    
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

   private BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[] getRelationData(BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].aCountry = FormatUtilities.truncate(data[i].aCountry, 20);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 44);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 44);        data[i].bankaccounttype = FormatUtilities.truncate(data[i].bankaccounttype, 21);        data[i].routingno = FormatUtilities.truncate(data[i].routingno, 20);        data[i].accountno = FormatUtilities.truncate(data[i].accountno, 30);        data[i].aZip = FormatUtilities.truncate(data[i].aZip, 20);        data[i].iban = FormatUtilities.truncate(data[i].iban, 34);        data[i].swiftcode = FormatUtilities.truncate(data[i].swiftcode, 0);        data[i].cCountryId = FormatUtilities.truncate(data[i].cCountryId, 12);        data[i].displayedaccount = FormatUtilities.truncate(data[i].displayedaccount, 26);        data[i].bankName = FormatUtilities.truncate(data[i].bankName, 34);        data[i].creditcardtype = FormatUtilities.truncate(data[i].creditcardtype, 21);        data[i].creditcardnumber = FormatUtilities.truncate(data[i].creditcardnumber, 20);        data[i].aName = FormatUtilities.truncate(data[i].aName, 20);        data[i].text1 = FormatUtilities.truncate(data[i].text1, 50);        data[i].aStreet = FormatUtilities.truncate(data[i].aStreet, 20);        data[i].aIdentSsn = FormatUtilities.truncate(data[i].aIdentSsn, 20);        data[i].aIdentDl = FormatUtilities.truncate(data[i].aIdentDl, 20);        data[i].aCity = FormatUtilities.truncate(data[i].aCity, 20);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].aState = FormatUtilities.truncate(data[i].aState, 20);        data[i].rAvszip = FormatUtilities.truncate(data[i].rAvszip, 21);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].cBpBankaccountId = FormatUtilities.truncate(data[i].cBpBankaccountId, 10);        data[i].aEmail = FormatUtilities.truncate(data[i].aEmail, 20);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPC_BPartner_ID) throws IOException,ServletException {
      EmployeeA3D0B320B69845B386024B5FF6B1E266Data[] data = EmployeeA3D0B320B69845B386024B5FF6B1E266Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_BPartner_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].cBpartnerId);
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strC_BP_BankAccount_ID) throws ServletException {
    String strPC_BPartner_ID = BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.selectParentID(this, strC_BP_BankAccount_ID);
    if (strPC_BPartner_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strC_BP_BankAccount_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_BPartner_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|C_BP_BankAccount_ID", data[0].getField("cBpBankaccountId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_BPartner_ID) throws IOException,ServletException {
      BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[] data = BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_BPartner_ID, vars.getStringParameter("inpcBpBankaccountId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_BPartner_ID, String strC_BP_BankAccount_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamDisplayedaccount = vars.getSessionValue(tabId + "|paramDisplayedaccount");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamDisplayedaccount.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_BP_BankAccount_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_BP_BankAccount_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/smartui/Employee/BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3", false, "document.frmMain.inpcBpBankaccountId", "grid", "..", "".equals("Y"), "Employee", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPC_BPartner_ID);

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
    xmlDocument.setParameter("KeyName", "cBpBankaccountId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3_Relation.html", "Employee", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.selectParent(this, strPC_BPartner_ID));
    else xmlDocument.setParameter("parent", BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.selectParentTrl(this, strPC_BPartner_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_BP_BankAccount_ID, String strPC_BPartner_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " 1";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamDisplayedaccount = vars.getSessionValue(tabId + "|paramDisplayedaccount");

    boolean hasSearchCondition=false;
    if (!(strParamDisplayedaccount.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_BPartner_ID, strC_BP_BankAccount_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_BP_BankAccount_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cBpBankaccountId") == null || dataField.getField("cBpBankaccountId").equals("")) {
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
        refreshSessionNew(vars, strPC_BPartner_ID);
        data = BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.set(strPC_BPartner_ID, Utility.getDefault(this, vars, "A_Street", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "Displayedaccount", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "A_EMail", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "A_Zip", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "BankAccountType", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "A_Name", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "Bank_Name", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "SwiftCode", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "Showiban", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "N", dataField), Utility.getDefault(this, vars, "AccountNo", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "R_AvsZip", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "A_State", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), "Y", Utility.getDefault(this, vars, "UpdatedBy", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.selectDef3101_0(this, Utility.getDefault(this, vars, "UpdatedBy", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField)), "", Utility.getDefault(this, vars, "Text1", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "C_Country_ID", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "A_Country", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "ShowAccountNo", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "N", dataField), Utility.getDefault(this, vars, "CreditCardExpMM", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "CreditCardNumber", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "Iban", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.selectDef3100_1(this, Utility.getDefault(this, vars, "CreatedBy", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField)), Utility.getDefault(this, vars, "RoutingNo", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "A_City", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "CreditCardType", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.selectDef3102_2(this, strPC_BPartner_ID), Utility.getDefault(this, vars, "Created", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "AD_User_ID", "-1", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "CreditCardExpYY", "2000", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "A_Ident_DL", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField), Utility.getDefault(this, vars, "A_Ident_SSN", "", "39D3CD9F77A942D690965D49106F011B", "56F5E1D49CFE4DAA9B372DCDD0F2AAC3", "", dataField));
        
      }
    } else {
      data = new BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=EmployeeA3D0B320B69845B386024B5FF6B1E266Data.selectOrg(this, strPC_BPartner_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcBpBankaccountId", "", "..", "".equals("Y"), "Employee", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_BP_BankAccount_ID));
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
      String result = "var strIsACH=\"" +Utility.getContext(this, vars, "IsACH", windowId) + "\";\nvar strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\n";
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPC_BPartner_ID) throws IOException, ServletException {
    BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data data = null;
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
            data = getEditVariables(con, vars, strPC_BPartner_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.cBpBankaccountId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3Data.getCurrentDBTimestamp(this, data.cBpBankaccountId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cBpBankaccountId, vars, this);
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
                    data.cBpBankaccountId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_BP_BankAccount_ID", data.cBpBankaccountId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet BankAccount56F5E1D49CFE4DAA9B372DCDD0F2AAC3. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
