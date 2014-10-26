
package org.openbravo.erpWindows.ProcessRequest;





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

public class ProcessRequest extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(ProcessRequest.class);
  
  private static final String windowId = "48E7EDE7D1104A59B46FC7449D9FB267";
  private static final String tabId = "CD573DF1E351485EA2B2DE487DCACA6F";
  private static final String defaultTabView = "RELATION";
  private static final int accesslevel = 7;
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
        String stradProcessRequestId = request.getParameter("inpadProcessRequestId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !stradProcessRequestId.equals(""))
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

      String strAD_Process_Request_ID = vars.getGlobalVariable("inpadProcessRequestId", windowId + "|AD_Process_Request_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|ProcessRequest.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strAD_Process_Request_ID.equals("")) strAD_Process_Request_ID = firstElement(vars, tableSQL);
          if (strAD_Process_Request_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strAD_Process_Request_ID, tableSQL);

      else printPageDataSheet(response, vars, strAD_Process_Request_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strAD_Process_Request_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strAD_Process_Request_ID.equals("")) strAD_Process_Request_ID = vars.getRequiredGlobalVariable("inpadProcessRequestId", windowId + "|AD_Process_Request_ID");
      else vars.setSessionValue(windowId + "|AD_Process_Request_ID", strAD_Process_Request_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|ProcessRequest.view", "EDIT");

        printPageEdit(response, request, vars, false, strAD_Process_Request_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|ProcessRequest.view", "RELATION");
        printPageDataSheet(response, vars, strAD_Process_Request_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|ProcessRequest.view");
      String strAD_Process_Request_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strAD_Process_Request_ID = firstElement(vars, tableSQL);
          if (strAD_Process_Request_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strAD_Process_Request_ID.equals("")) strAD_Process_Request_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strAD_Process_Request_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamAD_Process_ID", tabId + "|paramAD_Process_ID");
vars.getRequestGlobalVariable("inpParamChannel", tabId + "|paramChannel");

      
      
      vars.removeSessionValue(windowId + "|AD_Process_Request_ID");
      String strAD_Process_Request_ID="";

      String strView = vars.getSessionValue(tabId + "|ProcessRequest.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strAD_Process_Request_ID = firstElement(vars, tableSQL);
        if (strAD_Process_Request_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|ProcessRequest.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strAD_Process_Request_ID, tableSQL);

      else printPageDataSheet(response, vars, strAD_Process_Request_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strAD_Process_Request_ID = vars.getGlobalVariable("inpadProcessRequestId", windowId + "|AD_Process_Request_ID", "");
      vars.setSessionValue(tabId + "|ProcessRequest.view", "RELATION");
      printPageDataSheet(response, vars, strAD_Process_Request_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strAD_Process_Request_ID = vars.getGlobalVariable("inpadProcessRequestId", windowId + "|AD_Process_Request_ID", "");
      vars.setSessionValue(tabId + "|ProcessRequest.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strAD_Process_Request_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strAD_Process_Request_ID = vars.getRequiredStringParameter("inpadProcessRequestId");
      
      String strNext = nextElement(vars, strAD_Process_Request_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strAD_Process_Request_ID = vars.getRequiredStringParameter("inpadProcessRequestId");
      
      String strPrevious = previousElement(vars, strAD_Process_Request_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|ProcessRequest.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|ProcessRequest.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|ProcessRequest.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|ProcessRequest.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|AD_Process_Request_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|ProcessRequest.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|ProcessRequest.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|AD_Process_Request_ID");

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

      String strAD_Process_Request_ID = vars.getRequiredGlobalVariable("inpadProcessRequestId", windowId + "|AD_Process_Request_ID");
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
          String strNext = nextElement(vars, strAD_Process_Request_ID, tableSQL);
          vars.setSessionValue(windowId + "|AD_Process_Request_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strAD_Process_Request_ID = vars.getRequiredInStringParameter("inpadProcessRequestId");
      String message = deleteRelation(vars, strAD_Process_Request_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|adProcessRequestId");
        vars.setSessionValue(tabId + "|ProcessRequest.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strAD_Process_Request_ID = vars.getRequiredStringParameter("inpadProcessRequestId");
      //ProcessRequestData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = ProcessRequestData.delete(this, strAD_Process_Request_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|adProcessRequestId");
        vars.setSessionValue(tabId + "|ProcessRequest.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strAD_Process_Request_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strAD_Process_Request_ID.startsWith("(")) strAD_Process_Request_ID = strAD_Process_Request_ID.substring(1, strAD_Process_Request_ID.length()-1);
      if (!strAD_Process_Request_ID.equals("")) {
        strAD_Process_Request_ID = Replace.replace(strAD_Process_Request_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strAD_Process_Request_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (ProcessRequestData.deleteTransactional(conn, this, strKey)==0) {
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
  private ProcessRequestData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    ProcessRequestData data = new ProcessRequestData();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adProcessRequestId = vars.getRequestGlobalVariable("inpadProcessRequestId", windowId + "|AD_Process_Request_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.adProcessId = vars.getStringParameter("inpadProcessId");     data.adProcessIdr = vars.getStringParameter("inpadProcessId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.timingOption = vars.getStringParameter("inptimingOption");     data.timingOptionr = vars.getStringParameter("inptimingOption_R");     data.isrolesecurity = vars.getStringParameter("inpisrolesecurity", "N");     data.previousFireTime = vars.getStringParameter("inppreviousFireTime");     data.nextFireTime = vars.getStringParameter("inpnextFireTime");     data.startDate = vars.getStringParameter("inpstartDate");     data.startTime = vars.getStringParameter("inpstartTime");     data.channel = vars.getStringParameter("inpchannel");     data.frequency = vars.getStringParameter("inpfrequency");     data.frequencyr = vars.getStringParameter("inpfrequency_R");    try {   data.secondlyInterval = vars.getNumericParameter("inpsecondlyInterval");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.secondlyRepetitions = vars.getNumericParameter("inpsecondlyRepetitions");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.minutelyInterval = vars.getNumericParameter("inpminutelyInterval");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.minutelyRepetitions = vars.getNumericParameter("inpminutelyRepetitions");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.hourlyInterval = vars.getNumericParameter("inphourlyInterval");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.hourlyRepetitions = vars.getNumericParameter("inphourlyRepetitions");  } catch (ServletException paramEx) { ex = paramEx; }     data.dailyOption = vars.getStringParameter("inpdailyOption");     data.dailyOptionr = vars.getStringParameter("inpdailyOption_R");    try {   data.dailyInterval = vars.getNumericParameter("inpdailyInterval");  } catch (ServletException paramEx) { ex = paramEx; }     data.daySun = vars.getStringParameter("inpdaySun", "N");     data.dayMon = vars.getStringParameter("inpdayMon", "N");     data.dayTue = vars.getStringParameter("inpdayTue", "N");     data.dayWed = vars.getStringParameter("inpdayWed", "N");     data.dayThu = vars.getStringParameter("inpdayThu", "N");     data.dayFri = vars.getStringParameter("inpdayFri", "N");     data.daySat = vars.getStringParameter("inpdaySat", "N");     data.monthlyOption = vars.getStringParameter("inpmonthlyOption");     data.monthlyOptionr = vars.getStringParameter("inpmonthlyOption_R");     data.monthlyDayOfWeek = vars.getStringParameter("inpmonthlyDayOfWeek");     data.monthlyDayOfWeekr = vars.getStringParameter("inpmonthlyDayOfWeek_R");     data.cron = vars.getStringParameter("inpcron");    try {   data.monthlySpecificDay = vars.getNumericParameter("inpmonthlySpecificDay");  } catch (ServletException paramEx) { ex = paramEx; }     data.finishes = vars.getStringParameter("inpfinishes", "N");     data.finishesDate = vars.getStringParameter("inpfinishesDate");     data.finishesTime = vars.getStringParameter("inpfinishesTime");     data.schedule = vars.getStringParameter("inpschedule");     data.reschedule = vars.getStringParameter("inpreschedule");     data.unschedule = vars.getStringParameter("inpunschedule");     data.status = vars.getStringParameter("inpstatus");     data.statusr = vars.getStringParameter("inpstatus_R");     data.adProcessSetId = vars.getStringParameter("inpadProcessSetId");     data.scheduledFinish = vars.getStringParameter("inpscheduledFinish");     data.description = vars.getStringParameter("inpdescription");     data.obContext = vars.getStringParameter("inpobContext");     data.adUserId = vars.getStringParameter("inpadUserId");     data.params = vars.getStringParameter("inpparams"); 
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

   private ProcessRequestData[] getRelationData(ProcessRequestData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].adProcessRequestId = FormatUtilities.truncate(data[i].adProcessRequestId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].adProcessId = FormatUtilities.truncate(data[i].adProcessId, 32);        data[i].timingOption = FormatUtilities.truncate(data[i].timingOption, 1);        data[i].channel = FormatUtilities.truncate(data[i].channel, 1);        data[i].frequency = FormatUtilities.truncate(data[i].frequency, 1);        data[i].dailyOption = FormatUtilities.truncate(data[i].dailyOption, 1);        data[i].monthlyOption = FormatUtilities.truncate(data[i].monthlyOption, 1);        data[i].monthlyDayOfWeek = FormatUtilities.truncate(data[i].monthlyDayOfWeek, 1);        data[i].cron = FormatUtilities.truncate(data[i].cron, 32);        data[i].status = FormatUtilities.truncate(data[i].status, 10);        data[i].adProcessSetId = FormatUtilities.truncate(data[i].adProcessSetId, 32);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].obContext = FormatUtilities.truncate(data[i].obContext, 50);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 32);        data[i].params = FormatUtilities.truncate(data[i].params, 50);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Process_Request_ID", data[0].getField("adProcessRequestId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      ProcessRequestData[] data = ProcessRequestData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpadProcessRequestId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strAD_Process_Request_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamAD_Process_ID = vars.getSessionValue(tabId + "|paramAD_Process_ID");
String strParamChannel = vars.getSessionValue(tabId + "|paramChannel");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamAD_Process_ID.equals("") && strParamChannel.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strAD_Process_Request_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strAD_Process_Request_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/ProcessRequest/ProcessRequest_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "ProcessRequest", false, "document.frmMain.inpadProcessRequestId", "grid", "..", "".equals("Y"), "ProcessRequest", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "adProcessRequestId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "ProcessRequest_Relation.html", "ProcessRequest", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "ProcessRequest_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strAD_Process_Request_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " AD_Process_Request.Created DESC";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    ProcessRequestData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamAD_Process_ID = vars.getSessionValue(tabId + "|paramAD_Process_ID");
String strParamChannel = vars.getSessionValue(tabId + "|paramChannel");

    boolean hasSearchCondition=false;
    if (!(strParamAD_Process_ID.equals("") && strParamChannel.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = ProcessRequestData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strAD_Process_Request_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strAD_Process_Request_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new ProcessRequestData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("adProcessRequestId") == null || dataField.getField("adProcessRequestId").equals("")) {
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
        data = ProcessRequestData.set(Utility.getDefault(this, vars, "Description", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Monthly_Day_Of_Week", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "AD_Process_Set_ID", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), "", Utility.getDefault(this, vars, "Timing_Option", "I", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Params", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Monthly_Specific_Day", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "DAY_Tue", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "N", dataField), Utility.getDefault(this, vars, "Createdby", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), ProcessRequestData.selectDef573D452F04D1243FE040007F01012792_0(this, Utility.getDefault(this, vars, "Createdby", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField)), Utility.getDefault(this, vars, "AD_User_ID", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Next_Fire_Time", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Reschedule", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "N", dataField), Utility.getDefault(this, vars, "OB_Context", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Isrolesecurity", "Y", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "N", dataField), Utility.getDefault(this, vars, "Unschedule", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "N", dataField), "Y", Utility.getDefault(this, vars, "Start_Time", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Secondly_Repetitions", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Daily_Interval", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Status", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "DAY_Fri", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "N", dataField), Utility.getDefault(this, vars, "Daily_Option", "N", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Frequency", "4", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Minutely_Interval", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Scheduled_Finish", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "DAY_Wed", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "N", dataField), Utility.getDefault(this, vars, "Start_Date", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "DAY_Sun", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "N", dataField), Utility.getDefault(this, vars, "Schedule", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "N", dataField), Utility.getDefault(this, vars, "DAY_Mon", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "N", dataField), Utility.getDefault(this, vars, "DAY_Sat", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "N", dataField), Utility.getDefault(this, vars, "Previous_Fire_Time", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Monthly_Option", "S", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Hourly_Repetitions", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "DAY_Thu", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "N", dataField), Utility.getDefault(this, vars, "Finishes", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "N", dataField), Utility.getDefault(this, vars, "Finishes_Date", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Minutely_Repetitions", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Hourly_Interval", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "AD_Process_ID", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Channel", "Process Scheduler", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Cron", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Finishes_Time", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Secondly_Interval", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField), ProcessRequestData.selectDef573D452F04D3243FE040007F01012792_1(this, Utility.getDefault(this, vars, "Updatedby", "", "48E7EDE7D1104A59B46FC7449D9FB267", "CD573DF1E351485EA2B2DE487DCACA6F", "", dataField)));
        
      }
    } else {
      data = new ProcessRequestData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(ProcessRequestData) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "ProcessRequest", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpadProcessRequestId", "", "..", "".equals("Y"), "ProcessRequest", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strAD_Process_Request_ID));
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
    ProcessRequestData data = null;
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
                data.adProcessRequestId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (ProcessRequestData.getCurrentDBTimestamp(this, data.adProcessRequestId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.adProcessRequestId, vars, this);
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
                    data.adProcessRequestId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|AD_Process_Request_ID", data.adProcessRequestId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet ProcessRequest. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}