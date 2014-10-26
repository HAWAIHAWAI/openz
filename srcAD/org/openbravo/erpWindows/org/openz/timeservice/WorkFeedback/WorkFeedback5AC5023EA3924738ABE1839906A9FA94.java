
package org.openbravo.erpWindows.org.openz.timeservice.WorkFeedback;





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

public class WorkFeedback5AC5023EA3924738ABE1839906A9FA94 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(WorkFeedback5AC5023EA3924738ABE1839906A9FA94.class);
  
  private static final String windowId = "82ED989E0C8746D4A95A7034F2895E0E";
  private static final String tabId = "5AC5023EA3924738ABE1839906A9FA94";
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
        String strtsrvFeedbackVId = request.getParameter("inptsrvFeedbackVId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strtsrvFeedbackVId.equals(""))
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

      String strTsrv_Feedback_V_ID = vars.getGlobalVariable("inptsrvFeedbackVId", windowId + "|Tsrv_Feedback_V_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|WorkFeedback5AC5023EA3924738ABE1839906A9FA94.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strTsrv_Feedback_V_ID.equals("")) strTsrv_Feedback_V_ID = firstElement(vars, tableSQL);
          if (strTsrv_Feedback_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strTsrv_Feedback_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strTsrv_Feedback_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strTsrv_Feedback_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strTsrv_Feedback_V_ID.equals("")) strTsrv_Feedback_V_ID = vars.getRequiredGlobalVariable("inptsrvFeedbackVId", windowId + "|Tsrv_Feedback_V_ID");
      else vars.setSessionValue(windowId + "|Tsrv_Feedback_V_ID", strTsrv_Feedback_V_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|WorkFeedback5AC5023EA3924738ABE1839906A9FA94.view", "EDIT");

        printPageEdit(response, request, vars, false, strTsrv_Feedback_V_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|WorkFeedback5AC5023EA3924738ABE1839906A9FA94.view", "RELATION");
        printPageDataSheet(response, vars, strTsrv_Feedback_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|WorkFeedback5AC5023EA3924738ABE1839906A9FA94.view");
      String strTsrv_Feedback_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strTsrv_Feedback_V_ID = firstElement(vars, tableSQL);
          if (strTsrv_Feedback_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strTsrv_Feedback_V_ID.equals("")) strTsrv_Feedback_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strTsrv_Feedback_V_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamAD_Org_ID", tabId + "|paramAD_Org_ID");
vars.getRequestGlobalVariable("inpParamc_project_id", tabId + "|paramc_project_id");
vars.getRequestGlobalVariable("inpParamC_Calendarevent_ID", tabId + "|paramC_Calendarevent_ID");
vars.getRequestGlobalVariable("inpParamemployee_id", tabId + "|paramemployee_id");
vars.getRequestGlobalVariable("inpParamWorkdate", tabId + "|paramWorkdate");
vars.getRequestGlobalVariable("inpParamC_Salary_Category_ID", tabId + "|paramC_Salary_Category_ID");
vars.getRequestGlobalVariable("inpParamTraveltime", tabId + "|paramTraveltime");
vars.getRequestGlobalVariable("inpParamWorkdate_f", tabId + "|paramWorkdate_f");
vars.getRequestGlobalVariable("inpParamTraveltime_f", tabId + "|paramTraveltime_f");

      
      
      vars.removeSessionValue(windowId + "|Tsrv_Feedback_V_ID");
      String strTsrv_Feedback_V_ID="";

      String strView = vars.getSessionValue(tabId + "|WorkFeedback5AC5023EA3924738ABE1839906A9FA94.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strTsrv_Feedback_V_ID = firstElement(vars, tableSQL);
        if (strTsrv_Feedback_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|WorkFeedback5AC5023EA3924738ABE1839906A9FA94.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strTsrv_Feedback_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strTsrv_Feedback_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strTsrv_Feedback_V_ID = vars.getGlobalVariable("inptsrvFeedbackVId", windowId + "|Tsrv_Feedback_V_ID", "");
      vars.setSessionValue(tabId + "|WorkFeedback5AC5023EA3924738ABE1839906A9FA94.view", "RELATION");
      printPageDataSheet(response, vars, strTsrv_Feedback_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strTsrv_Feedback_V_ID = vars.getGlobalVariable("inptsrvFeedbackVId", windowId + "|Tsrv_Feedback_V_ID", "");
      vars.setSessionValue(tabId + "|WorkFeedback5AC5023EA3924738ABE1839906A9FA94.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strTsrv_Feedback_V_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strTsrv_Feedback_V_ID = vars.getRequiredStringParameter("inptsrvFeedbackVId");
      
      String strNext = nextElement(vars, strTsrv_Feedback_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strTsrv_Feedback_V_ID = vars.getRequiredStringParameter("inptsrvFeedbackVId");
      
      String strPrevious = previousElement(vars, strTsrv_Feedback_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|WorkFeedback5AC5023EA3924738ABE1839906A9FA94.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|WorkFeedback5AC5023EA3924738ABE1839906A9FA94.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|WorkFeedback5AC5023EA3924738ABE1839906A9FA94.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|WorkFeedback5AC5023EA3924738ABE1839906A9FA94.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Tsrv_Feedback_V_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|WorkFeedback5AC5023EA3924738ABE1839906A9FA94.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|WorkFeedback5AC5023EA3924738ABE1839906A9FA94.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Tsrv_Feedback_V_ID");

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

      String strTsrv_Feedback_V_ID = vars.getRequiredGlobalVariable("inptsrvFeedbackVId", windowId + "|Tsrv_Feedback_V_ID");
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
          String strNext = nextElement(vars, strTsrv_Feedback_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|Tsrv_Feedback_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strTsrv_Feedback_V_ID = vars.getRequiredInStringParameter("inptsrvFeedbackVId");
      String message = deleteRelation(vars, strTsrv_Feedback_V_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|tsrvFeedbackVId");
        vars.setSessionValue(tabId + "|WorkFeedback5AC5023EA3924738ABE1839906A9FA94.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strTsrv_Feedback_V_ID = vars.getRequiredStringParameter("inptsrvFeedbackVId");
      //WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.delete(this, strTsrv_Feedback_V_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|tsrvFeedbackVId");
        vars.setSessionValue(tabId + "|WorkFeedback5AC5023EA3924738ABE1839906A9FA94.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strTsrv_Feedback_V_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strTsrv_Feedback_V_ID.startsWith("(")) strTsrv_Feedback_V_ID = strTsrv_Feedback_V_ID.substring(1, strTsrv_Feedback_V_ID.length()-1);
      if (!strTsrv_Feedback_V_ID.equals("")) {
        strTsrv_Feedback_V_ID = Replace.replace(strTsrv_Feedback_V_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strTsrv_Feedback_V_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.deleteTransactional(conn, this, strKey)==0) {
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
  private WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data data = new WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data();
    ServletException ex = null;
    try {
    data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.tsrvFeedbackVId = vars.getRequestGlobalVariable("inptsrvFeedbackVId", windowId + "|Tsrv_Feedback_V_ID");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.cProjectId = vars.getRequestGlobalVariable("inpcProjectId", windowId + "|c_project_id");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.cProjecttaskId = vars.getRequestGlobalVariable("inpcProjecttaskId", windowId + "|c_projecttask_id");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.employeeId = vars.getRequestGlobalVariable("inpemployeeId", windowId + "|employee_id");     data.employeeIdr = vars.getStringParameter("inpemployeeId_R");     data.cSalaryCategoryId = vars.getStringParameter("inpcSalaryCategoryId");     data.cSalaryCategoryIdr = vars.getStringParameter("inpcSalaryCategoryId_R");     data.workdate = vars.getStringParameter("inpworkdate");     data.hourFrom = vars.getStringParameter("inphourFrom");     data.hourTo = vars.getStringParameter("inphourTo");    try {   data.breaktime = vars.getNumericParameter("inpbreaktime");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.traveltime = vars.getNumericParameter("inptraveltime");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.timeunderhelmet = vars.getNumericParameter("inptimeunderhelmet");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.timeunderhelmet2 = vars.getNumericParameter("inptimeunderhelmet2");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.triggeramt = vars.getNumericParameter("inptriggeramt");  } catch (ServletException paramEx) { ex = paramEx; }     data.cCalendareventId = vars.getStringParameter("inpcCalendareventId");     data.cCalendareventIdr = vars.getStringParameter("inpcCalendareventId_R");     data.description = vars.getStringParameter("inpdescription");    try {   data.hours = vars.getNumericParameter("inphours");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.actualcostamount = vars.getNumericParameter("inpactualcostamount");  } catch (ServletException paramEx) { ex = paramEx; }     data.issaturday = vars.getStringParameter("inpissaturday", "N");     data.issunday = vars.getStringParameter("inpissunday", "N");     data.isholiday = vars.getStringParameter("inpisholiday", "N");    try {   data.overtimehours = vars.getNumericParameter("inpovertimehours");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.nighthours = vars.getNumericParameter("inpnighthours");  } catch (ServletException paramEx) { ex = paramEx; }     data.maMachineId = vars.getStringParameter("inpmaMachineId"); 
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

   private WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[] getRelationData(WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].tsrvFeedbackVId = FormatUtilities.truncate(data[i].tsrvFeedbackVId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 32);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].employeeId = FormatUtilities.truncate(data[i].employeeId, 32);        data[i].cSalaryCategoryId = FormatUtilities.truncate(data[i].cSalaryCategoryId, 32);        data[i].cCalendareventId = FormatUtilities.truncate(data[i].cCalendareventId, 32);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].maMachineId = FormatUtilities.truncate(data[i].maMachineId, 32);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|Tsrv_Feedback_V_ID", data[0].getField("tsrvFeedbackVId"));    vars.setSessionValue(windowId + "|C_Project_ID", data[0].getField("cProjectId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|C_ProjectTask_ID", data[0].getField("cProjecttaskId"));    vars.setSessionValue(windowId + "|Employee", data[0].getField("employee"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[] data = WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inptsrvFeedbackVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strTsrv_Feedback_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamc_project_id = vars.getSessionValue(tabId + "|paramc_project_id");
String strParamC_Calendarevent_ID = vars.getSessionValue(tabId + "|paramC_Calendarevent_ID");
String strParamemployee_id = vars.getSessionValue(tabId + "|paramemployee_id");
String strParamWorkdate = vars.getSessionValue(tabId + "|paramWorkdate");
String strParamC_Salary_Category_ID = vars.getSessionValue(tabId + "|paramC_Salary_Category_ID");
String strParamTraveltime = vars.getSessionValue(tabId + "|paramTraveltime");
String strParamWorkdate_f = vars.getSessionValue(tabId + "|paramWorkdate_f");
String strParamTraveltime_f = vars.getSessionValue(tabId + "|paramTraveltime_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamAD_Org_ID.equals("") && strParamc_project_id.equals("") && strParamC_Calendarevent_ID.equals("") && strParamemployee_id.equals("") && strParamWorkdate.equals("") && strParamC_Salary_Category_ID.equals("") && strParamTraveltime.equals("") && strParamWorkdate_f.equals("") && strParamTraveltime_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strTsrv_Feedback_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strTsrv_Feedback_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openz/timeservice/WorkFeedback/WorkFeedback5AC5023EA3924738ABE1839906A9FA94_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "WorkFeedback5AC5023EA3924738ABE1839906A9FA94", false, "document.frmMain.inptsrvFeedbackVId", "grid", "..", "".equals("Y"), "WorkFeedback", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "tsrvFeedbackVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "WorkFeedback5AC5023EA3924738ABE1839906A9FA94_Relation.html", "WorkFeedback", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "WorkFeedback5AC5023EA3924738ABE1839906A9FA94_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strTsrv_Feedback_V_ID, TableSQLData tableSQL)
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
    WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamc_project_id = vars.getSessionValue(tabId + "|paramc_project_id");
String strParamC_Calendarevent_ID = vars.getSessionValue(tabId + "|paramC_Calendarevent_ID");
String strParamemployee_id = vars.getSessionValue(tabId + "|paramemployee_id");
String strParamWorkdate = vars.getSessionValue(tabId + "|paramWorkdate");
String strParamC_Salary_Category_ID = vars.getSessionValue(tabId + "|paramC_Salary_Category_ID");
String strParamTraveltime = vars.getSessionValue(tabId + "|paramTraveltime");
String strParamWorkdate_f = vars.getSessionValue(tabId + "|paramWorkdate_f");
String strParamTraveltime_f = vars.getSessionValue(tabId + "|paramTraveltime_f");

    boolean hasSearchCondition=false;
    if (!(strParamAD_Org_ID.equals("") && strParamc_project_id.equals("") && strParamC_Calendarevent_ID.equals("") && strParamemployee_id.equals("") && strParamWorkdate.equals("") && strParamC_Salary_Category_ID.equals("") && strParamTraveltime.equals("") && strParamWorkdate_f.equals("") && strParamTraveltime_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strTsrv_Feedback_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strTsrv_Feedback_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("tsrvFeedbackVId") == null || dataField.getField("tsrvFeedbackVId").equals("")) {
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
        data = WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.set("", Utility.getDefault(this, vars, "Hour_From", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "Triggeramt", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "Description", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "Nighthours", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "Actualcostamount", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "Isholiday", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "N", dataField), Utility.getDefault(this, vars, "Issaturday", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "N", dataField), "Y", Utility.getDefault(this, vars, "Overtimehours", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "MA_Machine_ID", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "Workdate", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "Issunday", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "N", dataField), Utility.getDefault(this, vars, "Breaktime", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "C_Calendarevent_ID", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "Timeunderhelmet", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "c_project_id", "@c_project_id@", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.selectDefD9982ED00D794A11A00DA0C095BB82A7_0(this, Utility.getDefault(this, vars, "c_project_id", "@c_project_id@", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField)), Utility.getDefault(this, vars, "c_projecttask_id", "@c_projecttask_id@", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "Timeunderhelmet2", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.selectDef995FEA97D55B4F6795734CA0820FB547_1(this, Utility.getDefault(this, vars, "Createdby", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField)), Utility.getDefault(this, vars, "Hour_To", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.selectDef979476B70FBB4159A7BCD7644A835106_2(this, Utility.getDefault(this, vars, "Updatedby", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField)), Utility.getDefault(this, vars, "Traveltime", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "employee_id", "@employee_id@", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "C_Salary_Category_ID", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField), Utility.getDefault(this, vars, "Hours", "", "82ED989E0C8746D4A95A7034F2895E0E", "5AC5023EA3924738ABE1839906A9FA94", "", dataField));
        
      }
    } else {
      data = new WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "WorkFeedback5AC5023EA3924738ABE1839906A9FA94", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inptsrvFeedbackVId", "", "..", "".equals("Y"), "WorkFeedback", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strTsrv_Feedback_V_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type) throws IOException, ServletException {
    WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data data = null;
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
                data.tsrvFeedbackVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.getCurrentDBTimestamp(this, data.tsrvFeedbackVId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.tsrvFeedbackVId, vars, this);
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
                    data.tsrvFeedbackVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Tsrv_Feedback_V_ID", data.tsrvFeedbackVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet WorkFeedback5AC5023EA3924738ABE1839906A9FA94. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
