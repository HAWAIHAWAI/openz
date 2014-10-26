
package org.openbravo.erpWindows.SalesOrder;





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

public class Status6780E60B374444A49AC7010A32FE9884 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Status6780E60B374444A49AC7010A32FE9884.class);
  
  private static final String windowId = "143";
  private static final String tabId = "6780E60B374444A49AC7010A32FE9884";
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
        String strjuwimmOrderstatusId = request.getParameter("inpjuwimmOrderstatusId");
         String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strjuwimmOrderstatusId.equals(""))
              total = saveRecord(vars, myError, 'U', strPC_Order_ID);
          else
              total = saveRecord(vars, myError, 'I', strPC_Order_ID);
          
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
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");

      String strJuwimm_Orderstatus_ID = vars.getGlobalVariable("inpjuwimmOrderstatusId", windowId + "|Juwimm_Orderstatus_ID", "");
            if (strPC_Order_ID.equals("")) {
        strPC_Order_ID = getParentID(vars, strJuwimm_Orderstatus_ID);
        if (strPC_Order_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_Order_ID");
        vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);

        refreshParentSession(vars, strPC_Order_ID);
      }


      String strView = vars.getSessionValue(tabId + "|Status6780E60B374444A49AC7010A32FE9884.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strJuwimm_Orderstatus_ID.equals("")) strJuwimm_Orderstatus_ID = firstElement(vars, tableSQL);
          if (strJuwimm_Orderstatus_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strJuwimm_Orderstatus_ID, strPC_Order_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Order_ID, strJuwimm_Orderstatus_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strJuwimm_Orderstatus_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strJuwimm_Orderstatus_ID.equals("")) strJuwimm_Orderstatus_ID = vars.getRequiredGlobalVariable("inpjuwimmOrderstatusId", windowId + "|Juwimm_Orderstatus_ID");
      else vars.setSessionValue(windowId + "|Juwimm_Orderstatus_ID", strJuwimm_Orderstatus_ID);
      
      
      String strPC_Order_ID = getParentID(vars, strJuwimm_Orderstatus_ID);
      
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);
      vars.setSessionValue("186|Header.view", "EDIT");

      refreshParentSession(vars, strPC_Order_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Status6780E60B374444A49AC7010A32FE9884.view", "EDIT");

        printPageEdit(response, request, vars, false, strJuwimm_Orderstatus_ID, strPC_Order_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Status6780E60B374444A49AC7010A32FE9884.view", "RELATION");
        printPageDataSheet(response, vars, strPC_Order_ID, strJuwimm_Orderstatus_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|Juwimm_Orderstatus_ID");
      refreshParentSession(vars, strPC_Order_ID);


      String strView = vars.getSessionValue(tabId + "|Status6780E60B374444A49AC7010A32FE9884.view");
      String strJuwimm_Orderstatus_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strJuwimm_Orderstatus_ID = firstElement(vars, tableSQL);
          if (strJuwimm_Orderstatus_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strJuwimm_Orderstatus_ID.equals("")) strJuwimm_Orderstatus_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strJuwimm_Orderstatus_ID, strPC_Order_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_Order_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamJuwimm_Completion", tabId + "|paramJuwimm_Completion");
vars.getRequestGlobalVariable("inpParamJuwimm_Time", tabId + "|paramJuwimm_Time");
vars.getRequestGlobalVariable("inpParamJuwimm_Resources", tabId + "|paramJuwimm_Resources");
vars.getRequestGlobalVariable("inpParamJuwimm_Budget", tabId + "|paramJuwimm_Budget");
vars.getRequestGlobalVariable("inpParamJuwimm_Team_ID", tabId + "|paramJuwimm_Team_ID");
vars.getRequestGlobalVariable("inpParamJuwimm_Description", tabId + "|paramJuwimm_Description");

            String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      
      vars.removeSessionValue(windowId + "|Juwimm_Orderstatus_ID");
      String strJuwimm_Orderstatus_ID="";

      String strView = vars.getSessionValue(tabId + "|Status6780E60B374444A49AC7010A32FE9884.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strJuwimm_Orderstatus_ID = firstElement(vars, tableSQL);
        if (strJuwimm_Orderstatus_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Status6780E60B374444A49AC7010A32FE9884.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strJuwimm_Orderstatus_ID, strPC_Order_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Order_ID, strJuwimm_Orderstatus_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      

      String strJuwimm_Orderstatus_ID = vars.getGlobalVariable("inpjuwimmOrderstatusId", windowId + "|Juwimm_Orderstatus_ID", "");
      vars.setSessionValue(tabId + "|Status6780E60B374444A49AC7010A32FE9884.view", "RELATION");
      printPageDataSheet(response, vars, strPC_Order_ID, strJuwimm_Orderstatus_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");


      printPageEdit(response, request, vars, true, "", strPC_Order_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strJuwimm_Orderstatus_ID = vars.getGlobalVariable("inpjuwimmOrderstatusId", windowId + "|Juwimm_Orderstatus_ID", "");
      vars.setSessionValue(tabId + "|Status6780E60B374444A49AC7010A32FE9884.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strJuwimm_Orderstatus_ID, strPC_Order_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      String strJuwimm_Orderstatus_ID = vars.getRequiredStringParameter("inpjuwimmOrderstatusId");
      
      String strNext = nextElement(vars, strJuwimm_Orderstatus_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      String strJuwimm_Orderstatus_ID = vars.getRequiredStringParameter("inpjuwimmOrderstatusId");
      
      String strPrevious = previousElement(vars, strJuwimm_Orderstatus_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      vars.setSessionValue(tabId + "|Status6780E60B374444A49AC7010A32FE9884.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Status6780E60B374444A49AC7010A32FE9884.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Status6780E60B374444A49AC7010A32FE9884.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Status6780E60B374444A49AC7010A32FE9884.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Juwimm_Orderstatus_ID");
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Status6780E60B374444A49AC7010A32FE9884.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Status6780E60B374444A49AC7010A32FE9884.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Juwimm_Orderstatus_ID");
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPC_Order_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPC_Order_ID);      
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
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      String strJuwimm_Orderstatus_ID = vars.getRequiredGlobalVariable("inpjuwimmOrderstatusId", windowId + "|Juwimm_Orderstatus_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPC_Order_ID);      
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
          String strNext = nextElement(vars, strJuwimm_Orderstatus_ID, tableSQL);
          vars.setSessionValue(windowId + "|Juwimm_Orderstatus_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strJuwimm_Orderstatus_ID = vars.getRequiredInStringParameter("inpjuwimmOrderstatusId");
      String message = deleteRelation(vars, strJuwimm_Orderstatus_ID, strPC_Order_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|juwimmOrderstatusId");
        vars.setSessionValue(tabId + "|Status6780E60B374444A49AC7010A32FE9884.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strJuwimm_Orderstatus_ID = vars.getRequiredStringParameter("inpjuwimmOrderstatusId");
      //Status6780E60B374444A49AC7010A32FE9884Data data = getEditVariables(vars, strPC_Order_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = Status6780E60B374444A49AC7010A32FE9884Data.delete(this, strJuwimm_Orderstatus_ID, strPC_Order_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|juwimmOrderstatusId");
        vars.setSessionValue(tabId + "|Status6780E60B374444A49AC7010A32FE9884.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strJuwimm_Orderstatus_ID, String strPC_Order_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strJuwimm_Orderstatus_ID.startsWith("(")) strJuwimm_Orderstatus_ID = strJuwimm_Orderstatus_ID.substring(1, strJuwimm_Orderstatus_ID.length()-1);
      if (!strJuwimm_Orderstatus_ID.equals("")) {
        strJuwimm_Orderstatus_ID = Replace.replace(strJuwimm_Orderstatus_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strJuwimm_Orderstatus_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (Status6780E60B374444A49AC7010A32FE9884Data.deleteTransactional(conn, this, strKey, strPC_Order_ID)==0) {
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
  private Status6780E60B374444A49AC7010A32FE9884Data getEditVariables(Connection con, VariablesSecureApp vars, String strPC_Order_ID) throws IOException,ServletException {
    Status6780E60B374444A49AC7010A32FE9884Data data = new Status6780E60B374444A49AC7010A32FE9884Data();
    ServletException ex = null;
    try {
    data.cOrderId = vars.getStringParameter("inpcOrderId");     data.juwimmOrderstatusId = vars.getRequestGlobalVariable("inpjuwimmOrderstatusId", windowId + "|Juwimm_Orderstatus_ID");     data.juwimmProjectman = vars.getStringParameter("inpjuwimmProjectman");     data.juwimmCompletion = vars.getStringParameter("inpjuwimmCompletion");     data.juwimmCompletionr = vars.getStringParameter("inpjuwimmCompletion_R");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.juwimmTime = vars.getStringParameter("inpjuwimmTime");     data.juwimmTimer = vars.getStringParameter("inpjuwimmTime_R");     data.juwimmResources = vars.getStringParameter("inpjuwimmResources");     data.juwimmResourcesr = vars.getStringParameter("inpjuwimmResources_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.juwimmBudget = vars.getStringParameter("inpjuwimmBudget");     data.juwimmBudgetr = vars.getStringParameter("inpjuwimmBudget_R");     data.juwimmTeamId = vars.getStringParameter("inpjuwimmTeamId");     data.juwimmTeamIdr = vars.getStringParameter("inpjuwimmTeamId_R");     data.juwimmPlannedgolive = vars.getStringParameter("inpjuwimmPlannedgolive");     data.juwimmEstgolive = vars.getStringParameter("inpjuwimmEstgolive");     data.juwimmNextimpdate = vars.getStringParameter("inpjuwimmNextimpdate");     data.juwimmDescription = vars.getStringParameter("inpjuwimmDescription");     data.juwimmPlannedstart = vars.getStringParameter("inpjuwimmPlannedstart");     data.juwimmEststart = vars.getStringParameter("inpjuwimmEststart");     data.juwimmMilestone1 = vars.getStringParameter("inpjuwimmMilestone1");     data.juwimmMs1planneddate = vars.getStringParameter("inpjuwimmMs1planneddate");     data.juwimmMs1estdate = vars.getStringParameter("inpjuwimmMs1estdate");     data.juwimmMilestone2 = vars.getStringParameter("inpjuwimmMilestone2");     data.juwimmMs2planneddate = vars.getStringParameter("inpjuwimmMs2planneddate");     data.juwimmMs2estdate = vars.getStringParameter("inpjuwimmMs2estdate");     data.juwimmMilestone3 = vars.getStringParameter("inpjuwimmMilestone3");     data.juwimmMs3planneddate = vars.getStringParameter("inpjuwimmMs3planneddate");     data.juwimmMs3estdate = vars.getStringParameter("inpjuwimmMs3estdate");     data.juwimmMilestone4 = vars.getStringParameter("inpjuwimmMilestone4");     data.juwimmMs4planneddate = vars.getStringParameter("inpjuwimmMs4planneddate");     data.juwimmMs4estdate = vars.getStringParameter("inpjuwimmMs4estdate");     data.juwimmMilestone5 = vars.getStringParameter("inpjuwimmMilestone5");     data.juwimmMs5planneddate = vars.getStringParameter("inpjuwimmMs5planneddate");     data.juwimmMs5estdate = vars.getStringParameter("inpjuwimmMs5estdate");     data.juwimmMilestone6 = vars.getStringParameter("inpjuwimmMilestone6");     data.juwimmMs6planneddate = vars.getStringParameter("inpjuwimmMs6planneddate");     data.juwimmMs6estdate = vars.getStringParameter("inpjuwimmMs6estdate");     data.juwimmMilestone7 = vars.getStringParameter("inpjuwimmMilestone7");     data.juwimmMs7planneddate = vars.getStringParameter("inpjuwimmMs7planneddate");     data.juwimmMs7estdate = vars.getStringParameter("inpjuwimmMs7estdate");     data.juwimmPlannedend = vars.getStringParameter("inpjuwimmPlannedend");     data.juwimmEstend = vars.getStringParameter("inpjuwimmEstend");     data.juwimmOuputremarks = vars.getStringParameter("inpjuwimmOuputremarks");     data.juwimmLastaction = vars.getStringParameter("inpjuwimmLastaction");     data.juwimmNextaction = vars.getStringParameter("inpjuwimmNextaction");     data.juwimmIssues = vars.getStringParameter("inpjuwimmIssues");     data.juwimmDecisions = vars.getStringParameter("inpjuwimmDecisions"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cOrderId = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");


    
    

    
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

   private Status6780E60B374444A49AC7010A32FE9884Data[] getRelationData(Status6780E60B374444A49AC7010A32FE9884Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].cOrderId = FormatUtilities.truncate(data[i].cOrderId, 32);        data[i].juwimmOrderstatusId = FormatUtilities.truncate(data[i].juwimmOrderstatusId, 32);        data[i].juwimmProjectman = FormatUtilities.truncate(data[i].juwimmProjectman, 32);        data[i].juwimmCompletion = FormatUtilities.truncate(data[i].juwimmCompletion, 16);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].juwimmTime = FormatUtilities.truncate(data[i].juwimmTime, 16);        data[i].juwimmResources = FormatUtilities.truncate(data[i].juwimmResources, 16);        data[i].juwimmBudget = FormatUtilities.truncate(data[i].juwimmBudget, 16);        data[i].juwimmTeamId = FormatUtilities.truncate(data[i].juwimmTeamId, 32);        data[i].juwimmDescription = FormatUtilities.truncate(data[i].juwimmDescription, 50);        data[i].juwimmMilestone1 = FormatUtilities.truncate(data[i].juwimmMilestone1, 15);        data[i].juwimmMilestone2 = FormatUtilities.truncate(data[i].juwimmMilestone2, 15);        data[i].juwimmMilestone3 = FormatUtilities.truncate(data[i].juwimmMilestone3, 15);        data[i].juwimmMilestone4 = FormatUtilities.truncate(data[i].juwimmMilestone4, 15);        data[i].juwimmMilestone5 = FormatUtilities.truncate(data[i].juwimmMilestone5, 15);        data[i].juwimmMilestone6 = FormatUtilities.truncate(data[i].juwimmMilestone6, 15);        data[i].juwimmMilestone7 = FormatUtilities.truncate(data[i].juwimmMilestone7, 15);        data[i].juwimmOuputremarks = FormatUtilities.truncate(data[i].juwimmOuputremarks, 50);        data[i].juwimmLastaction = FormatUtilities.truncate(data[i].juwimmLastaction, 50);        data[i].juwimmNextaction = FormatUtilities.truncate(data[i].juwimmNextaction, 50);        data[i].juwimmIssues = FormatUtilities.truncate(data[i].juwimmIssues, 50);        data[i].juwimmDecisions = FormatUtilities.truncate(data[i].juwimmDecisions, 50);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPC_Order_ID) throws IOException,ServletException {
      HeaderData[] data = HeaderData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Order_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|DateOrdered", data[0].dateordered);    vars.setSessionValue(windowId + "|C_DocTypeTarget_ID", data[0].cDoctypetargetId);    vars.setSessionValue(windowId + "|C_DocType_ID", data[0].cDoctypeId);    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].cBpartnerId);    vars.setSessionValue(windowId + "|C_BPartner_Location_ID", data[0].cBpartnerLocationId);    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].mPricelistId);    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].mWarehouseId);    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].cCurrencyId);    vars.setSessionValue(windowId + "|DeliveryViaRule", data[0].deliveryviarule);    vars.setSessionValue(windowId + "|M_Shipper_ID", data[0].mShipperId);    vars.setSessionValue(windowId + "|FreightCostRule", data[0].freightcostrule);    vars.setSessionValue(windowId + "|DatePromised", data[0].datepromised);    vars.setSessionValue(windowId + "|Scheddeliverydate", data[0].scheddeliverydate);    vars.setSessionValue(windowId + "|C_Order_ID", data[0].cOrderId);    vars.setSessionValue(windowId + "|Processed", data[0].processed);    vars.setSessionValue(windowId + "|IsSOTrx", data[0].issotrx);
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
      vars.setSessionValue(windowId + "|ORDERTYPE", HeaderData.selectAux6(this, Utility.getContext(this, vars, "C_DOCTYPETARGET_ID", "143")));
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strJuwimm_Orderstatus_ID) throws ServletException {
    String strPC_Order_ID = Status6780E60B374444A49AC7010A32FE9884Data.selectParentID(this, strJuwimm_Orderstatus_ID);
    if (strPC_Order_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strJuwimm_Orderstatus_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_Order_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Juwimm_Orderstatus_ID", data[0].getField("juwimmOrderstatusId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_Order_ID) throws IOException,ServletException {
      Status6780E60B374444A49AC7010A32FE9884Data[] data = Status6780E60B374444A49AC7010A32FE9884Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Order_ID, vars.getStringParameter("inpjuwimmOrderstatusId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_Order_ID, String strJuwimm_Orderstatus_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamJuwimm_Completion = vars.getSessionValue(tabId + "|paramJuwimm_Completion");
String strParamJuwimm_Time = vars.getSessionValue(tabId + "|paramJuwimm_Time");
String strParamJuwimm_Resources = vars.getSessionValue(tabId + "|paramJuwimm_Resources");
String strParamJuwimm_Budget = vars.getSessionValue(tabId + "|paramJuwimm_Budget");
String strParamJuwimm_Team_ID = vars.getSessionValue(tabId + "|paramJuwimm_Team_ID");
String strParamJuwimm_Description = vars.getSessionValue(tabId + "|paramJuwimm_Description");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamJuwimm_Completion.equals("") && strParamJuwimm_Time.equals("") && strParamJuwimm_Resources.equals("") && strParamJuwimm_Budget.equals("") && strParamJuwimm_Team_ID.equals("") && strParamJuwimm_Description.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strJuwimm_Orderstatus_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strJuwimm_Orderstatus_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/SalesOrder/Status6780E60B374444A49AC7010A32FE9884_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Status6780E60B374444A49AC7010A32FE9884", false, "document.frmMain.inpjuwimmOrderstatusId", "grid", "..", "".equals("Y"), "SalesOrder", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPC_Order_ID);

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
    xmlDocument.setParameter("KeyName", "juwimmOrderstatusId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Status6780E60B374444A49AC7010A32FE9884_Relation.html", "SalesOrder", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Status6780E60B374444A49AC7010A32FE9884_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", Status6780E60B374444A49AC7010A32FE9884Data.selectParent(this, strPC_Order_ID));
    else xmlDocument.setParameter("parent", Status6780E60B374444A49AC7010A32FE9884Data.selectParentTrl(this, strPC_Order_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strJuwimm_Orderstatus_ID, String strPC_Order_ID, TableSQLData tableSQL)
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
    Status6780E60B374444A49AC7010A32FE9884Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamJuwimm_Completion = vars.getSessionValue(tabId + "|paramJuwimm_Completion");
String strParamJuwimm_Time = vars.getSessionValue(tabId + "|paramJuwimm_Time");
String strParamJuwimm_Resources = vars.getSessionValue(tabId + "|paramJuwimm_Resources");
String strParamJuwimm_Budget = vars.getSessionValue(tabId + "|paramJuwimm_Budget");
String strParamJuwimm_Team_ID = vars.getSessionValue(tabId + "|paramJuwimm_Team_ID");
String strParamJuwimm_Description = vars.getSessionValue(tabId + "|paramJuwimm_Description");

    boolean hasSearchCondition=false;
    if (!(strParamJuwimm_Completion.equals("") && strParamJuwimm_Time.equals("") && strParamJuwimm_Resources.equals("") && strParamJuwimm_Budget.equals("") && strParamJuwimm_Team_ID.equals("") && strParamJuwimm_Description.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = Status6780E60B374444A49AC7010A32FE9884Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Order_ID, strJuwimm_Orderstatus_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strJuwimm_Orderstatus_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new Status6780E60B374444A49AC7010A32FE9884Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("juwimmOrderstatusId") == null || dataField.getField("juwimmOrderstatusId").equals("")) {
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
        refreshSessionNew(vars, strPC_Order_ID);
        data = Status6780E60B374444A49AC7010A32FE9884Data.set(strPC_Order_ID, Utility.getDefault(this, vars, "Juwimm_Milestone7", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms2planneddate", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Budget", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Lastaction", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms6estdate", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms5planneddate", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Resources", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Milestone3", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms3estdate", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Completion", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Issues", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms7estdate", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), "", Utility.getDefault(this, vars, "Juwimm_Ms5estdate", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Time", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Status6780E60B374444A49AC7010A32FE9884Data.selectDef3107A020B4654A5B8BA3D94B27DFD73D_0(this, Utility.getDefault(this, vars, "Updatedby", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField)), Utility.getDefault(this, vars, "Juwimm_Ouputremarks", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), "Y", Utility.getDefault(this, vars, "Juwimm_Description", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Estend", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Decisions", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Status6780E60B374444A49AC7010A32FE9884Data.selectDef1EF30B9969DB4F4CB3B14AC79BA0178F_1(this, Utility.getDefault(this, vars, "Createdby", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField)), Utility.getDefault(this, vars, "Juwimm_Eststart", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms4estdate", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Estgolive", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Projectman", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms6planneddate", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Milestone1", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Milestone2", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms3planneddate", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms4planneddate", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Plannedend", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Team_ID", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms1estdate", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Nextimpdate", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Milestone6", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms1planneddate", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Plannedgolive", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms7planneddate", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Milestone5", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Nextaction", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Plannedstart", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms2estdate", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField), Utility.getDefault(this, vars, "Juwimm_Milestone4", "", "143", "6780E60B374444A49AC7010A32FE9884", "", dataField));
        
      }
    } else {
      data = new Status6780E60B374444A49AC7010A32FE9884Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(Status6780E60B374444A49AC7010A32FE9884Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=HeaderData.selectOrg(this, strPC_Order_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Status6780E60B374444A49AC7010A32FE9884", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpjuwimmOrderstatusId", "", "..", "".equals("Y"), "SalesOrder", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strJuwimm_Orderstatus_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPC_Order_ID) throws IOException, ServletException {
    Status6780E60B374444A49AC7010A32FE9884Data data = null;
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
            data = getEditVariables(con, vars, strPC_Order_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.juwimmOrderstatusId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (Status6780E60B374444A49AC7010A32FE9884Data.getCurrentDBTimestamp(this, data.juwimmOrderstatusId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.juwimmOrderstatusId, vars, this);
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
                    data.juwimmOrderstatusId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Juwimm_Orderstatus_ID", data.juwimmOrderstatusId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Status6780E60B374444A49AC7010A32FE9884. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
