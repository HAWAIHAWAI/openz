
package org.openbravo.erpWindows.org.zsoft.serial.SerialNumberTracking;


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

public class SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7.class);
  
  private static final String windowId = "40F78582E7444D0495EF8B32AB67BACE";
  private static final String tabId = "A5789BF6B4F84FF4B77AACC9D3CBD2E7";
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
        String strsnrMasterdataId = request.getParameter("inpsnrMasterdataId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strsnrMasterdataId.equals(""))
              total = saveRecord(vars, myError, 'U');
          else
              total = saveRecord(vars, myError, 'I');
          
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

      String strSNR_Masterdata_ID = vars.getGlobalVariable("inpsnrMasterdataId", windowId + "|SNR_Masterdata_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strSNR_Masterdata_ID.equals("")) strSNR_Masterdata_ID = firstElement(vars, tableSQL);
          if (strSNR_Masterdata_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strSNR_Masterdata_ID, tableSQL);

      else printPageDataSheet(response, vars, strSNR_Masterdata_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strSNR_Masterdata_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strSNR_Masterdata_ID.equals("")) strSNR_Masterdata_ID = vars.getRequiredGlobalVariable("inpsnrMasterdataId", windowId + "|SNR_Masterdata_ID");
      else vars.setSessionValue(windowId + "|SNR_Masterdata_ID", strSNR_Masterdata_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7.view", "EDIT");

        printPageEdit(response, request, vars, false, strSNR_Masterdata_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7.view", "RELATION");
        printPageDataSheet(response, vars, strSNR_Masterdata_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7.view");
      String strSNR_Masterdata_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strSNR_Masterdata_ID = firstElement(vars, tableSQL);
          if (strSNR_Masterdata_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strSNR_Masterdata_ID.equals("")) strSNR_Masterdata_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strSNR_Masterdata_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamAD_Org_ID", tabId + "|paramAD_Org_ID");
vars.getRequestGlobalVariable("inpParamIsactive", tabId + "|paramIsactive");
vars.getRequestGlobalVariable("inpParamM_Product_ID", tabId + "|paramM_Product_ID");
vars.getRequestGlobalVariable("inpParamSerialnumber", tabId + "|paramSerialnumber");
vars.getRequestGlobalVariable("inpParamFirstseen", tabId + "|paramFirstseen");
vars.getRequestGlobalVariable("inpParamMovementdate", tabId + "|paramMovementdate");
vars.getRequestGlobalVariable("inpParamMovementtype", tabId + "|paramMovementtype");
vars.getRequestGlobalVariable("inpParamM_Locator_ID", tabId + "|paramM_Locator_ID");
vars.getRequestGlobalVariable("inpParamC_Bpartner_ID", tabId + "|paramC_Bpartner_ID");
vars.getRequestGlobalVariable("inpParamC_Projecttask_ID", tabId + "|paramC_Projecttask_ID");
vars.getRequestGlobalVariable("inpParamDescription", tabId + "|paramDescription");
vars.getRequestGlobalVariable("inpParamAD_User_ID", tabId + "|paramAD_User_ID");
vars.getRequestGlobalVariable("inpParamGuaranteedate", tabId + "|paramGuaranteedate");
vars.getRequestGlobalVariable("inpParamVendor", tabId + "|paramVendor");
vars.getRequestGlobalVariable("inpParamModel", tabId + "|paramModel");
vars.getRequestGlobalVariable("inpParamIdentifier2", tabId + "|paramIdentifier2");
vars.getRequestGlobalVariable("inpParamOrderreference", tabId + "|paramOrderreference");
vars.getRequestGlobalVariable("inpParamExternaltrackingno", tabId + "|paramExternaltrackingno");
vars.getRequestGlobalVariable("inpParamIdentifier3", tabId + "|paramIdentifier3");
vars.getRequestGlobalVariable("inpParamFirstseen_f", tabId + "|paramFirstseen_f");
vars.getRequestGlobalVariable("inpParamMovementdate_f", tabId + "|paramMovementdate_f");
vars.getRequestGlobalVariable("inpParamGuaranteedate_f", tabId + "|paramGuaranteedate_f");

      
      
      vars.removeSessionValue(windowId + "|SNR_Masterdata_ID");
      String strSNR_Masterdata_ID="";

      String strView = vars.getSessionValue(tabId + "|SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strSNR_Masterdata_ID = firstElement(vars, tableSQL);
        if (strSNR_Masterdata_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strSNR_Masterdata_ID, tableSQL);

      else printPageDataSheet(response, vars, strSNR_Masterdata_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strSNR_Masterdata_ID = vars.getGlobalVariable("inpsnrMasterdataId", windowId + "|SNR_Masterdata_ID", "");
      vars.setSessionValue(tabId + "|SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7.view", "RELATION");
      printPageDataSheet(response, vars, strSNR_Masterdata_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strSNR_Masterdata_ID = vars.getGlobalVariable("inpsnrMasterdataId", windowId + "|SNR_Masterdata_ID", "");
      vars.setSessionValue(tabId + "|SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strSNR_Masterdata_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strSNR_Masterdata_ID = vars.getRequiredStringParameter("inpsnrMasterdataId");
      
      String strNext = nextElement(vars, strSNR_Masterdata_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strSNR_Masterdata_ID = vars.getRequiredStringParameter("inpsnrMasterdataId");
      
      String strPrevious = previousElement(vars, strSNR_Masterdata_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|SNR_Masterdata_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|SNR_Masterdata_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {

      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {

      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {

      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I');      
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

      String strSNR_Masterdata_ID = vars.getRequiredGlobalVariable("inpsnrMasterdataId", windowId + "|SNR_Masterdata_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U');      
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
          String strNext = nextElement(vars, strSNR_Masterdata_ID, tableSQL);
          vars.setSessionValue(windowId + "|SNR_Masterdata_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strSNR_Masterdata_ID = vars.getRequiredInStringParameter("inpsnrMasterdataId");
      String message = deleteRelation(vars, strSNR_Masterdata_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|snrMasterdataId");
        vars.setSessionValue(tabId + "|SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strSNR_Masterdata_ID = vars.getRequiredStringParameter("inpsnrMasterdataId");
      //SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data.delete(this, strSNR_Masterdata_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|snrMasterdataId");
        vars.setSessionValue(tabId + "|SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONSendmail394DF41E9ADA45F59266E1F8232227D3")) {
        vars.setSessionValue("button394DF41E9ADA45F59266E1F8232227D3.strsendmail", vars.getStringParameter("inpsendmail"));
        vars.setSessionValue("button394DF41E9ADA45F59266E1F8232227D3.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button394DF41E9ADA45F59266E1F8232227D3.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button394DF41E9ADA45F59266E1F8232227D3.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button394DF41E9ADA45F59266E1F8232227D3.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "394DF41E9ADA45F59266E1F8232227D3", request.getServletPath());    
     } else if (vars.commandIn("BUTTON394DF41E9ADA45F59266E1F8232227D3")) {
        String strSNR_Masterdata_ID = vars.getGlobalVariable("inpsnrMasterdataId", windowId + "|SNR_Masterdata_ID", "");
        String strsendmail = vars.getSessionValue("button394DF41E9ADA45F59266E1F8232227D3.strsendmail");
        String strProcessing = vars.getSessionValue("button394DF41E9ADA45F59266E1F8232227D3.strProcessing");
        String strOrg = vars.getSessionValue("button394DF41E9ADA45F59266E1F8232227D3.strOrg");
        String strClient = vars.getSessionValue("button394DF41E9ADA45F59266E1F8232227D3.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonSendmail394DF41E9ADA45F59266E1F8232227D3(response, vars, strSNR_Masterdata_ID, strsendmail, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONSendmail394DF41E9ADA45F59266E1F8232227D3")) {
        String strSNR_Masterdata_ID = vars.getGlobalVariable("inpKey", windowId + "|SNR_Masterdata_ID", "");
        @SuppressWarnings("unused")
        String strsendmail = vars.getStringParameter("inpsendmail");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "394DF41E9ADA45F59266E1F8232227D3", (("SNR_Masterdata_ID".equalsIgnoreCase("AD_Language"))?"0":strSNR_Masterdata_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
  String deleteRelation(VariablesSecureApp vars, String strSNR_Masterdata_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strSNR_Masterdata_ID.startsWith("(")) strSNR_Masterdata_ID = strSNR_Masterdata_ID.substring(1, strSNR_Masterdata_ID.length()-1);
      if (!strSNR_Masterdata_ID.equals("")) {
        strSNR_Masterdata_ID = Replace.replace(strSNR_Masterdata_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strSNR_Masterdata_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data.deleteTransactional(conn, this, strKey)==0) {
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
  private SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data data = new SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data();
    ServletException ex = null;
    try {
    data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.snrMasterdataId = vars.getRequestGlobalVariable("inpsnrMasterdataId", windowId + "|SNR_Masterdata_ID");     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.serialnumber = vars.getRequestGlobalVariable("inpserialnumber", windowId + "|Serialnumber");     data.firstseen = vars.getStringParameter("inpfirstseen");     data.movementdate = vars.getStringParameter("inpmovementdate");     data.movementtype = vars.getStringParameter("inpmovementtype");     data.movementtyper = vars.getStringParameter("inpmovementtype_R");     data.mLocatorId = vars.getStringParameter("inpmLocatorId");     data.mLocatorIdr = vars.getStringParameter("inpmLocatorId_R");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.cBpartnerLocationId = vars.getStringParameter("inpcBpartnerLocationId");     data.cBpartnerLocationIdr = vars.getStringParameter("inpcBpartnerLocationId_R");     data.mInoutlineId = vars.getStringParameter("inpmInoutlineId");     data.mInoutlineIdr = vars.getStringParameter("inpmInoutlineId_R");     data.mInventorylineId = vars.getStringParameter("inpmInventorylineId");     data.mInventorylineIdr = vars.getStringParameter("inpmInventorylineId_R");     data.mInternalConsumptionlineId = vars.getStringParameter("inpmInternalConsumptionlineId");     data.mInternalConsumptionlineIdr = vars.getStringParameter("inpmInternalConsumptionlineId_R");     data.mMovementlineId = vars.getStringParameter("inpmMovementlineId");     data.mMovementlineIdr = vars.getStringParameter("inpmMovementlineId_R");     data.adUserId = vars.getStringParameter("inpadUserId");     data.adUserIdr = vars.getStringParameter("inpadUserId_R");     data.sendmail = vars.getStringParameter("inpsendmail");     data.snrselfjoin = vars.getStringParameter("inpsnrselfjoin");     data.snrselfjoinr = vars.getStringParameter("inpsnrselfjoin_R");     data.description = vars.getStringParameter("inpdescription");     data.guaranteedate = vars.getStringParameter("inpguaranteedate");     data.model = vars.getStringParameter("inpmodel");     data.orderreference = vars.getStringParameter("inporderreference");     data.identifier2 = vars.getStringParameter("inpidentifier2");     data.vendor = vars.getStringParameter("inpvendor");     data.externaltrackingno = vars.getStringParameter("inpexternaltrackingno");     data.identifier3 = vars.getStringParameter("inpidentifier3");     data.remark = vars.getStringParameter("inpremark");     data.itemname = vars.getStringParameter("inpitemname");     data.location = vars.getStringParameter("inplocation");     data.isactive = vars.getStringParameter("inpisactive", "N"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");



    
    

    
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

   private SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data[] getRelationData(SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].snrMasterdataId = FormatUtilities.truncate(data[i].snrMasterdataId, 32);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].serialnumber = FormatUtilities.truncate(data[i].serialnumber, 40);        data[i].movementtype = FormatUtilities.truncate(data[i].movementtype, 50);        data[i].mLocatorId = FormatUtilities.truncate(data[i].mLocatorId, 32);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 32);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 32);        data[i].mInoutlineId = FormatUtilities.truncate(data[i].mInoutlineId, 32);        data[i].mInventorylineId = FormatUtilities.truncate(data[i].mInventorylineId, 32);        data[i].mInternalConsumptionlineId = FormatUtilities.truncate(data[i].mInternalConsumptionlineId, 32);        data[i].mMovementlineId = FormatUtilities.truncate(data[i].mMovementlineId, 32);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 32);        data[i].snrselfjoin = FormatUtilities.truncate(data[i].snrselfjoin, 32);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].model = FormatUtilities.truncate(data[i].model, 50);        data[i].orderreference = FormatUtilities.truncate(data[i].orderreference, 50);        data[i].identifier2 = FormatUtilities.truncate(data[i].identifier2, 50);        data[i].vendor = FormatUtilities.truncate(data[i].vendor, 50);        data[i].externaltrackingno = FormatUtilities.truncate(data[i].externaltrackingno, 50);        data[i].identifier3 = FormatUtilities.truncate(data[i].identifier3, 50);        data[i].remark = FormatUtilities.truncate(data[i].remark, 50);        data[i].itemname = FormatUtilities.truncate(data[i].itemname, 50);        data[i].location = FormatUtilities.truncate(data[i].location, 50);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|SNR_Masterdata_ID", data[0].getField("snrMasterdataId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|Serialnumber", data[0].getField("serialnumber"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data[] data = SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpsnrMasterdataId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strSNR_Masterdata_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamIsactive = vars.getSessionValue(tabId + "|paramIsactive");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamSerialnumber = vars.getSessionValue(tabId + "|paramSerialnumber");
String strParamFirstseen = vars.getSessionValue(tabId + "|paramFirstseen");
String strParamMovementdate = vars.getSessionValue(tabId + "|paramMovementdate");
String strParamMovementtype = vars.getSessionValue(tabId + "|paramMovementtype");
String strParamM_Locator_ID = vars.getSessionValue(tabId + "|paramM_Locator_ID");
String strParamC_Bpartner_ID = vars.getSessionValue(tabId + "|paramC_Bpartner_ID");
String strParamC_Projecttask_ID = vars.getSessionValue(tabId + "|paramC_Projecttask_ID");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamAD_User_ID = vars.getSessionValue(tabId + "|paramAD_User_ID");
String strParamGuaranteedate = vars.getSessionValue(tabId + "|paramGuaranteedate");
String strParamVendor = vars.getSessionValue(tabId + "|paramVendor");
String strParamModel = vars.getSessionValue(tabId + "|paramModel");
String strParamIdentifier2 = vars.getSessionValue(tabId + "|paramIdentifier2");
String strParamOrderreference = vars.getSessionValue(tabId + "|paramOrderreference");
String strParamExternaltrackingno = vars.getSessionValue(tabId + "|paramExternaltrackingno");
String strParamIdentifier3 = vars.getSessionValue(tabId + "|paramIdentifier3");
String strParamFirstseen_f = vars.getSessionValue(tabId + "|paramFirstseen_f");
String strParamMovementdate_f = vars.getSessionValue(tabId + "|paramMovementdate_f");
String strParamGuaranteedate_f = vars.getSessionValue(tabId + "|paramGuaranteedate_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamAD_Org_ID.equals("") && strParamIsactive.equals("") && strParamM_Product_ID.equals("") && strParamSerialnumber.equals("") && strParamFirstseen.equals("") && strParamMovementdate.equals("") && strParamMovementtype.equals("") && strParamM_Locator_ID.equals("") && strParamC_Bpartner_ID.equals("") && strParamC_Projecttask_ID.equals("") && strParamDescription.equals("") && strParamAD_User_ID.equals("") && strParamGuaranteedate.equals("") && strParamVendor.equals("") && strParamModel.equals("") && strParamIdentifier2.equals("") && strParamOrderreference.equals("") && strParamExternaltrackingno.equals("") && strParamIdentifier3.equals("") && strParamFirstseen_f.equals("") && strParamMovementdate_f.equals("") && strParamGuaranteedate_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strSNR_Masterdata_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strSNR_Masterdata_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/zsoft/serial/SerialNumberTracking/SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7", false, "document.frmMain.inpsnrMasterdataId", "grid", "../serialnumber/print.html", "N".equals("Y"), "SerialNumberTracking", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());



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
    xmlDocument.setParameter("KeyName", "snrMasterdataId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7_Relation.html", "SerialNumberTracking", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strSNR_Masterdata_ID, TableSQLData tableSQL)
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
    SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamIsactive = vars.getSessionValue(tabId + "|paramIsactive");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamSerialnumber = vars.getSessionValue(tabId + "|paramSerialnumber");
String strParamFirstseen = vars.getSessionValue(tabId + "|paramFirstseen");
String strParamMovementdate = vars.getSessionValue(tabId + "|paramMovementdate");
String strParamMovementtype = vars.getSessionValue(tabId + "|paramMovementtype");
String strParamM_Locator_ID = vars.getSessionValue(tabId + "|paramM_Locator_ID");
String strParamC_Bpartner_ID = vars.getSessionValue(tabId + "|paramC_Bpartner_ID");
String strParamC_Projecttask_ID = vars.getSessionValue(tabId + "|paramC_Projecttask_ID");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamAD_User_ID = vars.getSessionValue(tabId + "|paramAD_User_ID");
String strParamGuaranteedate = vars.getSessionValue(tabId + "|paramGuaranteedate");
String strParamVendor = vars.getSessionValue(tabId + "|paramVendor");
String strParamModel = vars.getSessionValue(tabId + "|paramModel");
String strParamIdentifier2 = vars.getSessionValue(tabId + "|paramIdentifier2");
String strParamOrderreference = vars.getSessionValue(tabId + "|paramOrderreference");
String strParamExternaltrackingno = vars.getSessionValue(tabId + "|paramExternaltrackingno");
String strParamIdentifier3 = vars.getSessionValue(tabId + "|paramIdentifier3");
String strParamFirstseen_f = vars.getSessionValue(tabId + "|paramFirstseen_f");
String strParamMovementdate_f = vars.getSessionValue(tabId + "|paramMovementdate_f");
String strParamGuaranteedate_f = vars.getSessionValue(tabId + "|paramGuaranteedate_f");

    boolean hasSearchCondition=false;
    if (!(strParamAD_Org_ID.equals("") && strParamIsactive.equals("") && strParamM_Product_ID.equals("") && strParamSerialnumber.equals("") && strParamFirstseen.equals("") && strParamMovementdate.equals("") && strParamMovementtype.equals("") && strParamM_Locator_ID.equals("") && strParamC_Bpartner_ID.equals("") && strParamC_Projecttask_ID.equals("") && strParamDescription.equals("") && strParamAD_User_ID.equals("") && strParamGuaranteedate.equals("") && strParamVendor.equals("") && strParamModel.equals("") && strParamIdentifier2.equals("") && strParamOrderreference.equals("") && strParamExternaltrackingno.equals("") && strParamIdentifier3.equals("") && strParamFirstseen_f.equals("") && strParamMovementdate_f.equals("") && strParamGuaranteedate_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strSNR_Masterdata_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strSNR_Masterdata_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("snrMasterdataId") == null || dataField.getField("snrMasterdataId").equals("")) {
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
        refreshSessionNew(vars);
        data = SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data.set(Utility.getDefault(this, vars, "Orderreference", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "C_Bpartner_Location_ID", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "AD_User_ID", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), "", Utility.getDefault(this, vars, "Createdby", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data.selectDef317FB8A077064C76918AB109625DA981_0(this, Utility.getDefault(this, vars, "Createdby", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField)), Utility.getDefault(this, vars, "Description", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "Externaltrackingno", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "Firstseen", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "Identifier2", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "M_Locator_ID", "null", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data.selectDef2C7D9CFB113B43898F40654356D3F22B_1(this, Utility.getDefault(this, vars, "M_Locator_ID", "null", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField)), Utility.getDefault(this, vars, "Movementdate", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "Serialnumber", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "m_inventoryline_id", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "Identifier3", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data.selectDefEE5E955AF82E4EBB8CC343AA1BC17A2E_2(this, Utility.getDefault(this, vars, "M_Product_ID", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField)), Utility.getDefault(this, vars, "Model", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "Sendmail", "N", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "N", dataField), Utility.getDefault(this, vars, "Itemname", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "m_inoutline_id", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "Snrselfjoin", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "Movementtype", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "Location", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "C_Bpartner_ID", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data.selectDef6CDD97D1255940789152D2FF953D5266_3(this, Utility.getDefault(this, vars, "C_Bpartner_ID", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField)), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "m_movementline_id", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "Guaranteedate", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "m_internal_consumptionline_id", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), "Y", Utility.getDefault(this, vars, "C_Projecttask_ID", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data.selectDef882E0B7E4F8A43E6A5C5B886B0ABE8FD_4(this, Utility.getDefault(this, vars, "Updatedby", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField)), Utility.getDefault(this, vars, "Remark", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField), Utility.getDefault(this, vars, "Vendor", "", "40F78582E7444D0495EF8B32AB67BACE", "A5789BF6B4F84FF4B77AACC9D3CBD2E7", "", dataField));
        
      }
    } else {
      data = new SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpsnrMasterdataId", "", "../serialnumber/print.html", "N".equals("Y"), "SerialNumberTracking", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strSNR_Masterdata_ID));
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
  
    void printPageButtonSendmail394DF41E9ADA45F59266E1F8232227D3(HttpServletResponse response, VariablesSecureApp vars, String strSNR_Masterdata_ID, String strsendmail, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "394DF41E9ADA45F59266E1F8232227D3",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "394DF41E9ADA45F59266E1F8232227D3" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"394DF41E9ADA45F59266E1F8232227D3" );
        String isDocAction=UtilsData.isProcessDocAction(this, "394DF41E9ADA45F59266E1F8232227D3");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "6C720EB54D1C4E00AF80D81A0F46CA1B",strSNR_Masterdata_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "6C720EB54D1C4E00AF80D81A0F46CA1B", strSNR_Masterdata_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strsendmail, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "394DF41E9ADA45F59266E1F8232227D3");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONSendmail" + "394DF41E9ADA45F59266E1F8232227D3" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "394DF41E9ADA45F59266E1F8232227D3");
        script.addHiddenfield("inpKey",strSNR_Masterdata_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("394DF41E9ADA45F59266E1F8232227D3");
        vars.removeMessage("394DF41E9ADA45F59266E1F8232227D3");
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type) throws IOException, ServletException {
    SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data data = null;
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
            data = getEditVariables(con, vars);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.snrMasterdataId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7Data.getCurrentDBTimestamp(this, data.snrMasterdataId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.snrMasterdataId, vars, this);
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
                    data.snrMasterdataId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|SNR_Masterdata_ID", data.snrMasterdataId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet SerialNumbersA5789BF6B4F84FF4B77AACC9D3CBD2E7. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
