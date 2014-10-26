
package org.openbravo.erpWindows.org.zsoft.jmm.SalesOrderStatusReports;





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

public class SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526.class);
  
  private static final String windowId = "5CEDAA1D2A9C407980AED0B5E9341717";
  private static final String tabId = "3A41529F45B04ABE83EE3E73C38BA526";
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
        String strjuwimmOrderstatusControllingVId = request.getParameter("inpjuwimmOrderstatusControllingVId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strjuwimmOrderstatusControllingVId.equals(""))
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

      String strJuwimm_Orderstatus_Controlling_V_ID = vars.getGlobalVariable("inpjuwimmOrderstatusControllingVId", windowId + "|Juwimm_Orderstatus_Controlling_V_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strJuwimm_Orderstatus_Controlling_V_ID.equals("")) strJuwimm_Orderstatus_Controlling_V_ID = firstElement(vars, tableSQL);
          if (strJuwimm_Orderstatus_Controlling_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strJuwimm_Orderstatus_Controlling_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strJuwimm_Orderstatus_Controlling_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strJuwimm_Orderstatus_Controlling_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strJuwimm_Orderstatus_Controlling_V_ID.equals("")) strJuwimm_Orderstatus_Controlling_V_ID = vars.getRequiredGlobalVariable("inpjuwimmOrderstatusControllingVId", windowId + "|Juwimm_Orderstatus_Controlling_V_ID");
      else vars.setSessionValue(windowId + "|Juwimm_Orderstatus_Controlling_V_ID", strJuwimm_Orderstatus_Controlling_V_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526.view", "EDIT");

        printPageEdit(response, request, vars, false, strJuwimm_Orderstatus_Controlling_V_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526.view", "RELATION");
        printPageDataSheet(response, vars, strJuwimm_Orderstatus_Controlling_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526.view");
      String strJuwimm_Orderstatus_Controlling_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strJuwimm_Orderstatus_Controlling_V_ID = firstElement(vars, tableSQL);
          if (strJuwimm_Orderstatus_Controlling_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strJuwimm_Orderstatus_Controlling_V_ID.equals("")) strJuwimm_Orderstatus_Controlling_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strJuwimm_Orderstatus_Controlling_V_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamProject_Value", tabId + "|paramProject_Value");
vars.getRequestGlobalVariable("inpParamProject_Name", tabId + "|paramProject_Name");
vars.getRequestGlobalVariable("inpParamDocumentno", tabId + "|paramDocumentno");
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamTotallines", tabId + "|paramTotallines");
vars.getRequestGlobalVariable("inpParamSalesrep_ID", tabId + "|paramSalesrep_ID");
vars.getRequestGlobalVariable("inpParamC_Bpartner_ID", tabId + "|paramC_Bpartner_ID");
vars.getRequestGlobalVariable("inpParamJuwimm_Team_ID", tabId + "|paramJuwimm_Team_ID");
vars.getRequestGlobalVariable("inpParamJuwimm_Completion", tabId + "|paramJuwimm_Completion");
vars.getRequestGlobalVariable("inpParamJuwimm_Time", tabId + "|paramJuwimm_Time");
vars.getRequestGlobalVariable("inpParamJuwimm_Resources", tabId + "|paramJuwimm_Resources");
vars.getRequestGlobalVariable("inpParamJuwimm_Budget", tabId + "|paramJuwimm_Budget");
vars.getRequestGlobalVariable("inpParamJuwimm_Plannedstart", tabId + "|paramJuwimm_Plannedstart");
vars.getRequestGlobalVariable("inpParamJuwimm_Eststart", tabId + "|paramJuwimm_Eststart");
vars.getRequestGlobalVariable("inpParamJuwimm_Plannedend", tabId + "|paramJuwimm_Plannedend");
vars.getRequestGlobalVariable("inpParamJuwimm_Estend", tabId + "|paramJuwimm_Estend");
vars.getRequestGlobalVariable("inpParamTotallines_f", tabId + "|paramTotallines_f");
vars.getRequestGlobalVariable("inpParamJuwimm_Plannedstart_f", tabId + "|paramJuwimm_Plannedstart_f");
vars.getRequestGlobalVariable("inpParamJuwimm_Eststart_f", tabId + "|paramJuwimm_Eststart_f");
vars.getRequestGlobalVariable("inpParamJuwimm_Plannedend_f", tabId + "|paramJuwimm_Plannedend_f");
vars.getRequestGlobalVariable("inpParamJuwimm_Estend_f", tabId + "|paramJuwimm_Estend_f");

      
      
      vars.removeSessionValue(windowId + "|Juwimm_Orderstatus_Controlling_V_ID");
      String strJuwimm_Orderstatus_Controlling_V_ID="";

      String strView = vars.getSessionValue(tabId + "|SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strJuwimm_Orderstatus_Controlling_V_ID = firstElement(vars, tableSQL);
        if (strJuwimm_Orderstatus_Controlling_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strJuwimm_Orderstatus_Controlling_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strJuwimm_Orderstatus_Controlling_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strJuwimm_Orderstatus_Controlling_V_ID = vars.getGlobalVariable("inpjuwimmOrderstatusControllingVId", windowId + "|Juwimm_Orderstatus_Controlling_V_ID", "");
      vars.setSessionValue(tabId + "|SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526.view", "RELATION");
      printPageDataSheet(response, vars, strJuwimm_Orderstatus_Controlling_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strJuwimm_Orderstatus_Controlling_V_ID = vars.getGlobalVariable("inpjuwimmOrderstatusControllingVId", windowId + "|Juwimm_Orderstatus_Controlling_V_ID", "");
      vars.setSessionValue(tabId + "|SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strJuwimm_Orderstatus_Controlling_V_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strJuwimm_Orderstatus_Controlling_V_ID = vars.getRequiredStringParameter("inpjuwimmOrderstatusControllingVId");
      
      String strNext = nextElement(vars, strJuwimm_Orderstatus_Controlling_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strJuwimm_Orderstatus_Controlling_V_ID = vars.getRequiredStringParameter("inpjuwimmOrderstatusControllingVId");
      
      String strPrevious = previousElement(vars, strJuwimm_Orderstatus_Controlling_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Juwimm_Orderstatus_Controlling_V_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Juwimm_Orderstatus_Controlling_V_ID");

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

      String strJuwimm_Orderstatus_Controlling_V_ID = vars.getRequiredGlobalVariable("inpjuwimmOrderstatusControllingVId", windowId + "|Juwimm_Orderstatus_Controlling_V_ID");
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
          String strNext = nextElement(vars, strJuwimm_Orderstatus_Controlling_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|Juwimm_Orderstatus_Controlling_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strJuwimm_Orderstatus_Controlling_V_ID = vars.getRequiredInStringParameter("inpjuwimmOrderstatusControllingVId");
      String message = deleteRelation(vars, strJuwimm_Orderstatus_Controlling_V_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|juwimmOrderstatusControllingVId");
        vars.setSessionValue(tabId + "|SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strJuwimm_Orderstatus_Controlling_V_ID = vars.getRequiredStringParameter("inpjuwimmOrderstatusControllingVId");
      //SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.delete(this, strJuwimm_Orderstatus_Controlling_V_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|juwimmOrderstatusControllingVId");
        vars.setSessionValue(tabId + "|SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strJuwimm_Orderstatus_Controlling_V_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strJuwimm_Orderstatus_Controlling_V_ID.startsWith("(")) strJuwimm_Orderstatus_Controlling_V_ID = strJuwimm_Orderstatus_Controlling_V_ID.substring(1, strJuwimm_Orderstatus_Controlling_V_ID.length()-1);
      if (!strJuwimm_Orderstatus_Controlling_V_ID.equals("")) {
        strJuwimm_Orderstatus_Controlling_V_ID = Replace.replace(strJuwimm_Orderstatus_Controlling_V_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strJuwimm_Orderstatus_Controlling_V_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.deleteTransactional(conn, this, strKey)==0) {
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
  private SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data data = new SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data();
    ServletException ex = null;
    try {
    data.juwimmOrderstatusControllingVId = vars.getRequestGlobalVariable("inpjuwimmOrderstatusControllingVId", windowId + "|Juwimm_Orderstatus_Controlling_V_ID");     data.name = vars.getStringParameter("inpname");     data.documentno = vars.getStringParameter("inpdocumentno");     data.cOrderId = vars.getStringParameter("inpcOrderId");     data.projectName = vars.getStringParameter("inpprojectName");     data.projectValue = vars.getStringParameter("inpprojectValue");     data.salesrepId = vars.getStringParameter("inpsalesrepId");     data.salesrepIdr = vars.getStringParameter("inpsalesrepId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");    try {   data.totallines = vars.getNumericParameter("inptotallines");  } catch (ServletException paramEx) { ex = paramEx; }     data.adUserId = vars.getStringParameter("inpadUserId");     data.adUserIdr = vars.getStringParameter("inpadUserId_R");     data.juwimmCompletion = vars.getStringParameter("inpjuwimmCompletion");     data.juwimmCompletionr = vars.getStringParameter("inpjuwimmCompletion_R");     data.juwimmTime = vars.getStringParameter("inpjuwimmTime");     data.juwimmTimer = vars.getStringParameter("inpjuwimmTime_R");     data.juwimmResources = vars.getStringParameter("inpjuwimmResources");     data.juwimmResourcesr = vars.getStringParameter("inpjuwimmResources_R");     data.issotrx = vars.getStringParameter("inpissotrx", "N");     data.juwimmBudget = vars.getStringParameter("inpjuwimmBudget");     data.juwimmBudgetr = vars.getStringParameter("inpjuwimmBudget_R");     data.juwimmTeamId = vars.getStringParameter("inpjuwimmTeamId");     data.juwimmTeamIdr = vars.getStringParameter("inpjuwimmTeamId_R");     data.docstatus = vars.getStringParameter("inpdocstatus");     data.juwimmPlannedgolive = vars.getStringParameter("inpjuwimmPlannedgolive");     data.docaction = vars.getStringParameter("inpdocaction");     data.juwimmEstgolive = vars.getStringParameter("inpjuwimmEstgolive");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.juwimmNextimpdate = vars.getStringParameter("inpjuwimmNextimpdate");     data.juwimmPlannedstart = vars.getStringParameter("inpjuwimmPlannedstart");     data.juwimmEststart = vars.getStringParameter("inpjuwimmEststart");     data.juwimmPlannedend = vars.getStringParameter("inpjuwimmPlannedend");     data.juwimmEstend = vars.getStringParameter("inpjuwimmEstend");     data.juwimmOuputremarks = vars.getStringParameter("inpjuwimmOuputremarks");     data.juwimmLastaction = vars.getStringParameter("inpjuwimmLastaction");     data.juwimmNextaction = vars.getStringParameter("inpjuwimmNextaction");     data.juwimmIssues = vars.getStringParameter("inpjuwimmIssues");     data.juwimmDecisions = vars.getStringParameter("inpjuwimmDecisions");     data.iscompletelyinvoiced = vars.getStringParameter("inpiscompletelyinvoiced", "N"); 
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

   private SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[] getRelationData(SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].juwimmOrderstatusControllingVId = FormatUtilities.truncate(data[i].juwimmOrderstatusControllingVId, 32);        data[i].name = FormatUtilities.truncate(data[i].name, 30);        data[i].documentno = FormatUtilities.truncate(data[i].documentno, 30);        data[i].cOrderId = FormatUtilities.truncate(data[i].cOrderId, 32);        data[i].projectName = FormatUtilities.truncate(data[i].projectName, 50);        data[i].projectValue = FormatUtilities.truncate(data[i].projectValue, 40);        data[i].salesrepId = FormatUtilities.truncate(data[i].salesrepId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 32);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 32);        data[i].juwimmCompletion = FormatUtilities.truncate(data[i].juwimmCompletion, 32);        data[i].juwimmTime = FormatUtilities.truncate(data[i].juwimmTime, 32);        data[i].juwimmResources = FormatUtilities.truncate(data[i].juwimmResources, 32);        data[i].juwimmBudget = FormatUtilities.truncate(data[i].juwimmBudget, 32);        data[i].juwimmTeamId = FormatUtilities.truncate(data[i].juwimmTeamId, 32);        data[i].docstatus = FormatUtilities.truncate(data[i].docstatus, 50);        data[i].docaction = FormatUtilities.truncate(data[i].docaction, 50);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 32);        data[i].juwimmOuputremarks = FormatUtilities.truncate(data[i].juwimmOuputremarks, 50);        data[i].juwimmLastaction = FormatUtilities.truncate(data[i].juwimmLastaction, 50);        data[i].juwimmNextaction = FormatUtilities.truncate(data[i].juwimmNextaction, 50);        data[i].juwimmIssues = FormatUtilities.truncate(data[i].juwimmIssues, 50);        data[i].juwimmDecisions = FormatUtilities.truncate(data[i].juwimmDecisions, 50);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Juwimm_Orderstatus_Controlling_V_ID", data[0].getField("juwimmOrderstatusControllingVId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[] data = SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpjuwimmOrderstatusControllingVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strJuwimm_Orderstatus_Controlling_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamProject_Value = vars.getSessionValue(tabId + "|paramProject_Value");
String strParamProject_Name = vars.getSessionValue(tabId + "|paramProject_Name");
String strParamDocumentno = vars.getSessionValue(tabId + "|paramDocumentno");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamTotallines = vars.getSessionValue(tabId + "|paramTotallines");
String strParamSalesrep_ID = vars.getSessionValue(tabId + "|paramSalesrep_ID");
String strParamC_Bpartner_ID = vars.getSessionValue(tabId + "|paramC_Bpartner_ID");
String strParamJuwimm_Team_ID = vars.getSessionValue(tabId + "|paramJuwimm_Team_ID");
String strParamJuwimm_Completion = vars.getSessionValue(tabId + "|paramJuwimm_Completion");
String strParamJuwimm_Time = vars.getSessionValue(tabId + "|paramJuwimm_Time");
String strParamJuwimm_Resources = vars.getSessionValue(tabId + "|paramJuwimm_Resources");
String strParamJuwimm_Budget = vars.getSessionValue(tabId + "|paramJuwimm_Budget");
String strParamJuwimm_Plannedstart = vars.getSessionValue(tabId + "|paramJuwimm_Plannedstart");
String strParamJuwimm_Eststart = vars.getSessionValue(tabId + "|paramJuwimm_Eststart");
String strParamJuwimm_Plannedend = vars.getSessionValue(tabId + "|paramJuwimm_Plannedend");
String strParamJuwimm_Estend = vars.getSessionValue(tabId + "|paramJuwimm_Estend");
String strParamTotallines_f = vars.getSessionValue(tabId + "|paramTotallines_f");
String strParamJuwimm_Plannedstart_f = vars.getSessionValue(tabId + "|paramJuwimm_Plannedstart_f");
String strParamJuwimm_Eststart_f = vars.getSessionValue(tabId + "|paramJuwimm_Eststart_f");
String strParamJuwimm_Plannedend_f = vars.getSessionValue(tabId + "|paramJuwimm_Plannedend_f");
String strParamJuwimm_Estend_f = vars.getSessionValue(tabId + "|paramJuwimm_Estend_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamProject_Value.equals("") && strParamProject_Name.equals("") && strParamDocumentno.equals("") && strParamName.equals("") && strParamTotallines.equals("") && strParamSalesrep_ID.equals("") && strParamC_Bpartner_ID.equals("") && strParamJuwimm_Team_ID.equals("") && strParamJuwimm_Completion.equals("") && strParamJuwimm_Time.equals("") && strParamJuwimm_Resources.equals("") && strParamJuwimm_Budget.equals("") && strParamJuwimm_Plannedstart.equals("") && strParamJuwimm_Eststart.equals("") && strParamJuwimm_Plannedend.equals("") && strParamJuwimm_Estend.equals("") && strParamTotallines_f.equals("") && strParamJuwimm_Plannedstart_f.equals("") && strParamJuwimm_Eststart_f.equals("") && strParamJuwimm_Plannedend_f.equals("") && strParamJuwimm_Estend_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strJuwimm_Orderstatus_Controlling_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strJuwimm_Orderstatus_Controlling_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/zsoft/jmm/SalesOrderStatusReports/SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526", false, "document.frmMain.inpjuwimmOrderstatusControllingVId", "grid", "..", "".equals("Y"), "SalesOrderStatusReports", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), true, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
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
    xmlDocument.setParameter("KeyName", "juwimmOrderstatusControllingVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526_Relation.html", "SalesOrderStatusReports", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strJuwimm_Orderstatus_Controlling_V_ID, TableSQLData tableSQL)
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
    SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamProject_Value = vars.getSessionValue(tabId + "|paramProject_Value");
String strParamProject_Name = vars.getSessionValue(tabId + "|paramProject_Name");
String strParamDocumentno = vars.getSessionValue(tabId + "|paramDocumentno");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamTotallines = vars.getSessionValue(tabId + "|paramTotallines");
String strParamSalesrep_ID = vars.getSessionValue(tabId + "|paramSalesrep_ID");
String strParamC_Bpartner_ID = vars.getSessionValue(tabId + "|paramC_Bpartner_ID");
String strParamJuwimm_Team_ID = vars.getSessionValue(tabId + "|paramJuwimm_Team_ID");
String strParamJuwimm_Completion = vars.getSessionValue(tabId + "|paramJuwimm_Completion");
String strParamJuwimm_Time = vars.getSessionValue(tabId + "|paramJuwimm_Time");
String strParamJuwimm_Resources = vars.getSessionValue(tabId + "|paramJuwimm_Resources");
String strParamJuwimm_Budget = vars.getSessionValue(tabId + "|paramJuwimm_Budget");
String strParamJuwimm_Plannedstart = vars.getSessionValue(tabId + "|paramJuwimm_Plannedstart");
String strParamJuwimm_Eststart = vars.getSessionValue(tabId + "|paramJuwimm_Eststart");
String strParamJuwimm_Plannedend = vars.getSessionValue(tabId + "|paramJuwimm_Plannedend");
String strParamJuwimm_Estend = vars.getSessionValue(tabId + "|paramJuwimm_Estend");
String strParamTotallines_f = vars.getSessionValue(tabId + "|paramTotallines_f");
String strParamJuwimm_Plannedstart_f = vars.getSessionValue(tabId + "|paramJuwimm_Plannedstart_f");
String strParamJuwimm_Eststart_f = vars.getSessionValue(tabId + "|paramJuwimm_Eststart_f");
String strParamJuwimm_Plannedend_f = vars.getSessionValue(tabId + "|paramJuwimm_Plannedend_f");
String strParamJuwimm_Estend_f = vars.getSessionValue(tabId + "|paramJuwimm_Estend_f");

    boolean hasSearchCondition=false;
    if (!(strParamProject_Value.equals("") && strParamProject_Name.equals("") && strParamDocumentno.equals("") && strParamName.equals("") && strParamTotallines.equals("") && strParamSalesrep_ID.equals("") && strParamC_Bpartner_ID.equals("") && strParamJuwimm_Team_ID.equals("") && strParamJuwimm_Completion.equals("") && strParamJuwimm_Time.equals("") && strParamJuwimm_Resources.equals("") && strParamJuwimm_Budget.equals("") && strParamJuwimm_Plannedstart.equals("") && strParamJuwimm_Eststart.equals("") && strParamJuwimm_Plannedend.equals("") && strParamJuwimm_Estend.equals("") && strParamTotallines_f.equals("") && strParamJuwimm_Plannedstart_f.equals("") && strParamJuwimm_Eststart_f.equals("") && strParamJuwimm_Plannedend_f.equals("") && strParamJuwimm_Estend_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strJuwimm_Orderstatus_Controlling_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strJuwimm_Orderstatus_Controlling_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (data==null || data.length==0) {
        strJuwimm_Orderstatus_Controlling_V_ID = firstElement(vars, tableSQL);
        if (strJuwimm_Orderstatus_Controlling_V_ID.equals("")) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        } else {
          data = SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strJuwimm_Orderstatus_Controlling_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
        }
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("juwimmOrderstatusControllingVId") == null || dataField.getField("juwimmOrderstatusControllingVId").equals("")) {
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
        data = SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.set(Utility.getDefault(this, vars, "Name", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), "", Utility.getDefault(this, vars, "IsSOTrx", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "N", dataField), Utility.getDefault(this, vars, "Juwimm_Estend", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Salesrep_ID", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Juwimm_Plannedstart", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Juwimm_Time", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.selectDefFA0BF18F735E458EAD1F6AC24D76D38E_0(this, Utility.getDefault(this, vars, "Updatedby", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField)), Utility.getDefault(this, vars, "Juwimm_Budget", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Juwimm_Issues", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Documentno", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "C_Order_ID", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Project_Value", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Docstatus", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Juwimm_Plannedgolive", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ouputremarks", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.selectDef8836A70361064B9AB1E7587CF6B6C247_1(this, Utility.getDefault(this, vars, "Createdby", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField)), Utility.getDefault(this, vars, "AD_User_ID", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Juwimm_Resources", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Iscompletelyinvoiced", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "N", dataField), Utility.getDefault(this, vars, "Juwimm_Eststart", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Juwimm_Completion", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Juwimm_Team_ID", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Juwimm_Plannedend", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Juwimm_Decisions", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "C_Bpartner_ID", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.selectDefE7CAFB519FC94B64B02D7C3B3A6801EE_2(this, Utility.getDefault(this, vars, "C_Bpartner_ID", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField)), Utility.getDefault(this, vars, "Juwimm_Lastaction", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Juwimm_Nextaction", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Juwimm_Nextimpdate", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Juwimm_Estgolive", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Project_Name", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), "Y", Utility.getDefault(this, vars, "Docaction", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "C_Project_ID", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField), Utility.getDefault(this, vars, "Totallines", "", "5CEDAA1D2A9C407980AED0B5E9341717", "3A41529F45B04ABE83EE3E73C38BA526", "", dataField));
        
      }
    } else {
      data = new SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpjuwimmOrderstatusControllingVId", "", "..", "".equals("Y"), "SalesOrderStatusReports", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strJuwimm_Orderstatus_Controlling_V_ID));
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
    SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data data = null;
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
                data.juwimmOrderstatusControllingVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.getCurrentDBTimestamp(this, data.juwimmOrderstatusControllingVId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.juwimmOrderstatusControllingVId, vars, this);
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
                    data.juwimmOrderstatusControllingVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Juwimm_Orderstatus_Controlling_V_ID", data.juwimmOrderstatusControllingVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
