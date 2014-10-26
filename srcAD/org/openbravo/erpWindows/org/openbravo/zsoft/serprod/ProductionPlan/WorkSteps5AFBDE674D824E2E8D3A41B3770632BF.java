
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.ProductionPlan;





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

public class WorkSteps5AFBDE674D824E2E8D3A41B3770632BF extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(WorkSteps5AFBDE674D824E2E8D3A41B3770632BF.class);
  
  private static final String windowId = "3E801605DEA44BA0920CD7A8BB1A2A0B";
  private static final String tabId = "5AFBDE674D824E2E8D3A41B3770632BF";
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
        String strzssmProductionplanTaskVId = request.getParameter("inpzssmProductionplanTaskVId");
         String strPZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strzssmProductionplanTaskVId.equals(""))
              total = saveRecord(vars, myError, 'U', strPZssm_Productionplan_V_ID);
          else
              total = saveRecord(vars, myError, 'I', strPZssm_Productionplan_V_ID);
          
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
      String strPZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID", "");

      String strZssm_Productionplan_Task_V_ID = vars.getGlobalVariable("inpzssmProductionplanTaskVId", windowId + "|Zssm_Productionplan_Task_V_ID", "");
            if (strPZssm_Productionplan_V_ID.equals("")) {
        strPZssm_Productionplan_V_ID = getParentID(vars, strZssm_Productionplan_Task_V_ID);
        if (strPZssm_Productionplan_V_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|Zssm_Productionplan_V_ID");
        vars.setSessionValue(windowId + "|Zssm_Productionplan_V_ID", strPZssm_Productionplan_V_ID);

        refreshParentSession(vars, strPZssm_Productionplan_V_ID);
      }


      String strView = vars.getSessionValue(tabId + "|WorkSteps5AFBDE674D824E2E8D3A41B3770632BF.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strZssm_Productionplan_Task_V_ID.equals("")) strZssm_Productionplan_Task_V_ID = firstElement(vars, tableSQL);
          if (strZssm_Productionplan_Task_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssm_Productionplan_Task_V_ID, strPZssm_Productionplan_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strPZssm_Productionplan_V_ID, strZssm_Productionplan_Task_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strZssm_Productionplan_Task_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strZssm_Productionplan_Task_V_ID.equals("")) strZssm_Productionplan_Task_V_ID = vars.getRequiredGlobalVariable("inpzssmProductionplanTaskVId", windowId + "|Zssm_Productionplan_Task_V_ID");
      else vars.setSessionValue(windowId + "|Zssm_Productionplan_Task_V_ID", strZssm_Productionplan_Task_V_ID);
      
      
      String strPZssm_Productionplan_V_ID = getParentID(vars, strZssm_Productionplan_Task_V_ID);
      
      vars.setSessionValue(windowId + "|Zssm_Productionplan_V_ID", strPZssm_Productionplan_V_ID);
      vars.setSessionValue("5C0EE761B80B4C2DAFCA92FD699A387B|Production Plan.view", "EDIT");

      refreshParentSession(vars, strPZssm_Productionplan_V_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|WorkSteps5AFBDE674D824E2E8D3A41B3770632BF.view", "EDIT");

        printPageEdit(response, request, vars, false, strZssm_Productionplan_Task_V_ID, strPZssm_Productionplan_V_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|WorkSteps5AFBDE674D824E2E8D3A41B3770632BF.view", "RELATION");
        printPageDataSheet(response, vars, strPZssm_Productionplan_V_ID, strZssm_Productionplan_Task_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|Zssm_Productionplan_Task_V_ID");
      refreshParentSession(vars, strPZssm_Productionplan_V_ID);


      String strView = vars.getSessionValue(tabId + "|WorkSteps5AFBDE674D824E2E8D3A41B3770632BF.view");
      String strZssm_Productionplan_Task_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strZssm_Productionplan_Task_V_ID = firstElement(vars, tableSQL);
          if (strZssm_Productionplan_Task_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strZssm_Productionplan_Task_V_ID.equals("")) strZssm_Productionplan_Task_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strZssm_Productionplan_Task_V_ID, strPZssm_Productionplan_V_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPZssm_Productionplan_V_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamValue", tabId + "|paramValue");
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamDescription", tabId + "|paramDescription");

            String strPZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");

      
      vars.removeSessionValue(windowId + "|Zssm_Productionplan_Task_V_ID");
      String strZssm_Productionplan_Task_V_ID="";

      String strView = vars.getSessionValue(tabId + "|WorkSteps5AFBDE674D824E2E8D3A41B3770632BF.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strZssm_Productionplan_Task_V_ID = firstElement(vars, tableSQL);
        if (strZssm_Productionplan_Task_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|WorkSteps5AFBDE674D824E2E8D3A41B3770632BF.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssm_Productionplan_Task_V_ID, strPZssm_Productionplan_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strPZssm_Productionplan_V_ID, strZssm_Productionplan_Task_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");
      

      String strZssm_Productionplan_Task_V_ID = vars.getGlobalVariable("inpzssmProductionplanTaskVId", windowId + "|Zssm_Productionplan_Task_V_ID", "");
      vars.setSessionValue(tabId + "|WorkSteps5AFBDE674D824E2E8D3A41B3770632BF.view", "RELATION");
      printPageDataSheet(response, vars, strPZssm_Productionplan_V_ID, strZssm_Productionplan_Task_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");


      printPageEdit(response, request, vars, true, "", strPZssm_Productionplan_V_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strZssm_Productionplan_Task_V_ID = vars.getGlobalVariable("inpzssmProductionplanTaskVId", windowId + "|Zssm_Productionplan_Task_V_ID", "");
      vars.setSessionValue(tabId + "|WorkSteps5AFBDE674D824E2E8D3A41B3770632BF.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strZssm_Productionplan_Task_V_ID, strPZssm_Productionplan_V_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");
      String strZssm_Productionplan_Task_V_ID = vars.getRequiredStringParameter("inpzssmProductionplanTaskVId");
      
      String strNext = nextElement(vars, strZssm_Productionplan_Task_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPZssm_Productionplan_V_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");
      String strZssm_Productionplan_Task_V_ID = vars.getRequiredStringParameter("inpzssmProductionplanTaskVId");
      
      String strPrevious = previousElement(vars, strZssm_Productionplan_Task_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPZssm_Productionplan_V_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");

      vars.setSessionValue(tabId + "|WorkSteps5AFBDE674D824E2E8D3A41B3770632BF.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|WorkSteps5AFBDE674D824E2E8D3A41B3770632BF.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|WorkSteps5AFBDE674D824E2E8D3A41B3770632BF.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|WorkSteps5AFBDE674D824E2E8D3A41B3770632BF.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Zssm_Productionplan_Task_V_ID");
      vars.setSessionValue(windowId + "|Zssm_Productionplan_V_ID", strPZssm_Productionplan_V_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|WorkSteps5AFBDE674D824E2E8D3A41B3770632BF.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|WorkSteps5AFBDE674D824E2E8D3A41B3770632BF.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Zssm_Productionplan_Task_V_ID");
      vars.setSessionValue(windowId + "|Zssm_Productionplan_V_ID", strPZssm_Productionplan_V_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPZssm_Productionplan_V_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPZssm_Productionplan_V_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPZssm_Productionplan_V_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPZssm_Productionplan_V_ID);      
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
      String strPZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");
      String strZssm_Productionplan_Task_V_ID = vars.getRequiredGlobalVariable("inpzssmProductionplanTaskVId", windowId + "|Zssm_Productionplan_Task_V_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPZssm_Productionplan_V_ID);      
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
          String strNext = nextElement(vars, strZssm_Productionplan_Task_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|Zssm_Productionplan_Task_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");

      String strZssm_Productionplan_Task_V_ID = vars.getRequiredInStringParameter("inpzssmProductionplanTaskVId");
      String message = deleteRelation(vars, strZssm_Productionplan_Task_V_ID, strPZssm_Productionplan_V_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|zssmProductionplanTaskVId");
        vars.setSessionValue(tabId + "|WorkSteps5AFBDE674D824E2E8D3A41B3770632BF.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");

      String strZssm_Productionplan_Task_V_ID = vars.getRequiredStringParameter("inpzssmProductionplanTaskVId");
      //WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData data = getEditVariables(vars, strPZssm_Productionplan_V_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.delete(this, strZssm_Productionplan_Task_V_ID, strPZssm_Productionplan_V_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|zssmProductionplanTaskVId");
        vars.setSessionValue(tabId + "|WorkSteps5AFBDE674D824E2E8D3A41B3770632BF.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strZssm_Productionplan_Task_V_ID, String strPZssm_Productionplan_V_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strZssm_Productionplan_Task_V_ID.startsWith("(")) strZssm_Productionplan_Task_V_ID = strZssm_Productionplan_Task_V_ID.substring(1, strZssm_Productionplan_Task_V_ID.length()-1);
      if (!strZssm_Productionplan_Task_V_ID.equals("")) {
        strZssm_Productionplan_Task_V_ID = Replace.replace(strZssm_Productionplan_Task_V_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strZssm_Productionplan_Task_V_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.deleteTransactional(conn, this, strKey, strPZssm_Productionplan_V_ID)==0) {
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
  private WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData getEditVariables(Connection con, VariablesSecureApp vars, String strPZssm_Productionplan_V_ID) throws IOException,ServletException {
    WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData data = new WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData();
    ServletException ex = null;
    try {
    data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.zssmProductionplanVId = vars.getStringParameter("inpzssmProductionplanVId");     data.zssmProductionplanVIdr = vars.getStringParameter("inpzssmProductionplanVId_R");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.value = vars.getStringParameter("inpvalue");     data.name = vars.getStringParameter("inpname");     data.zssmProductionplanTaskId = vars.getStringParameter("inpzssmProductionplanTaskId");    try {   data.sortno = vars.getNumericParameter("inpsortno");  } catch (ServletException paramEx) { ex = paramEx; }     data.description = vars.getStringParameter("inpdescription");     data.assembly = vars.getStringParameter("inpassembly", "N");     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.forcematerialscan = vars.getStringParameter("inpforcematerialscan", "N");     data.startonlywithcompletematerial = vars.getStringParameter("inpstartonlywithcompletematerial", "N");    try {   data.percentrejects = vars.getNumericParameter("inppercentrejects");  } catch (ServletException paramEx) { ex = paramEx; }     data.receivingLocator = vars.getStringParameter("inpreceivingLocator");     data.receivingLocatorr = vars.getStringParameter("inpreceivingLocator_R");     data.issuingLocator = vars.getStringParameter("inpissuingLocator");     data.issuingLocatorr = vars.getStringParameter("inpissuingLocator_R");     data.zssmProductionplanTaskVId = vars.getRequestGlobalVariable("inpzssmProductionplanTaskVId", windowId + "|Zssm_Productionplan_Task_V_ID");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.zssmProductionplanVId = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");


    
    

    
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

   private WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[] getRelationData(WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].zssmProductionplanVId = FormatUtilities.truncate(data[i].zssmProductionplanVId, 32);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].value = FormatUtilities.truncate(data[i].value, 20);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].zssmProductionplanTaskId = FormatUtilities.truncate(data[i].zssmProductionplanTaskId, 32);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 45);        data[i].receivingLocator = FormatUtilities.truncate(data[i].receivingLocator, 32);        data[i].issuingLocator = FormatUtilities.truncate(data[i].issuingLocator, 32);        data[i].zssmProductionplanTaskVId = FormatUtilities.truncate(data[i].zssmProductionplanTaskVId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPZssm_Productionplan_V_ID) throws IOException,ServletException {
      ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[] data = ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPZssm_Productionplan_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|ProjectCategory", data[0].projectcategory);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|IsCommitment", data[0].iscommitment);    vars.setSessionValue(windowId + "|Zssm_Productionplan_V_ID", data[0].zssmProductionplanVId);    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].cCurrencyId);    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].mPricelistId);    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].mWarehouseId);    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].cBpartnerId);
      vars.setSessionValue(windowId + "|Zssm_Productionplan_V_ID", strPZssm_Productionplan_V_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strZssm_Productionplan_Task_V_ID) throws ServletException {
    String strPZssm_Productionplan_V_ID = WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.selectParentID(this, strZssm_Productionplan_Task_V_ID);
    if (strPZssm_Productionplan_V_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strZssm_Productionplan_Task_V_ID);
      throw new ServletException("Parent record not found");
    }
    return strPZssm_Productionplan_V_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|Zssm_Productionplan_Task_V_ID", data[0].getField("zssmProductionplanTaskVId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPZssm_Productionplan_V_ID) throws IOException,ServletException {
      WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[] data = WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPZssm_Productionplan_V_ID, vars.getStringParameter("inpzssmProductionplanTaskVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPZssm_Productionplan_V_ID, String strZssm_Productionplan_Task_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamValue.equals("") && strParamName.equals("") && strParamDescription.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strZssm_Productionplan_Task_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strZssm_Productionplan_Task_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/serprod/ProductionPlan/WorkSteps5AFBDE674D824E2E8D3A41B3770632BF_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "WorkSteps5AFBDE674D824E2E8D3A41B3770632BF", false, "document.frmMain.inpzssmProductionplanTaskVId", "grid", "..", "".equals("Y"), "ProductionPlan", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPZssm_Productionplan_V_ID);

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
    xmlDocument.setParameter("KeyName", "zssmProductionplanTaskVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "WorkSteps5AFBDE674D824E2E8D3A41B3770632BF_Relation.html", "ProductionPlan", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "WorkSteps5AFBDE674D824E2E8D3A41B3770632BF_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.selectParent(this, strPZssm_Productionplan_V_ID));
    else xmlDocument.setParameter("parent", WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.selectParentTrl(this, strPZssm_Productionplan_V_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strZssm_Productionplan_Task_V_ID, String strPZssm_Productionplan_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " zssm_productionplan_task_v.SortNo,  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') )";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");

    boolean hasSearchCondition=false;
    if (!(strParamValue.equals("") && strParamName.equals("") && strParamDescription.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPZssm_Productionplan_V_ID, strZssm_Productionplan_Task_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strZssm_Productionplan_Task_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("zssmProductionplanTaskVId") == null || dataField.getField("zssmProductionplanTaskVId").equals("")) {
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
        refreshSessionNew(vars, strPZssm_Productionplan_V_ID);
        data = WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.set(strPZssm_Productionplan_V_ID, Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField), Utility.getDefault(this, vars, "ForceMaterialScan", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "N", dataField), "Y", Utility.getDefault(this, vars, "Zssm_Productionplan_Task_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField), Utility.getDefault(this, vars, "Assembly", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "N", dataField), Utility.getDefault(this, vars, "Issuing_Locator", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField), WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.selectDef1CADC7C20D664DA9A85C384173E0C11F_0(this, Utility.getDefault(this, vars, "Issuing_Locator", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField)), Utility.getDefault(this, vars, "Createdby", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField), WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.selectDefC29132CFEDBF453885F4A45582BD612F_1(this, Utility.getDefault(this, vars, "Createdby", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField)), Utility.getDefault(this, vars, "SortNo", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField), Utility.getDefault(this, vars, "Value", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField), Utility.getDefault(this, vars, "C_Projecttask_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField), Utility.getDefault(this, vars, "PercentRejects", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField), WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.selectDef846599C5BED34B6B9B4F1BB5EBB35BF0_2(this, Utility.getDefault(this, vars, "M_Product_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField)), Utility.getDefault(this, vars, "Receiving_Locator", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField), WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.selectDef11962709821246C89FB5E2D9FA4F8347_3(this, Utility.getDefault(this, vars, "Receiving_Locator", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField)), Utility.getDefault(this, vars, "StartOnlyWithCompleteMaterial", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "N", dataField), Utility.getDefault(this, vars, "Updatedby", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField), WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.selectDefDCD8D513BBAD45B4B6E522123A437AB4_4(this, Utility.getDefault(this, vars, "Updatedby", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField)), "", Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField), Utility.getDefault(this, vars, "Name", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField), Utility.getDefault(this, vars, "Description", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5AFBDE674D824E2E8D3A41B3770632BF", "", dataField));
        
      }
    } else {
      data = new WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.selectOrg(this, strPZssm_Productionplan_V_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "WorkSteps5AFBDE674D824E2E8D3A41B3770632BF", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpzssmProductionplanTaskVId", "", "..", "".equals("Y"), "ProductionPlan", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strZssm_Productionplan_Task_V_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPZssm_Productionplan_V_ID) throws IOException, ServletException {
    WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData data = null;
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
            data = getEditVariables(con, vars, strPZssm_Productionplan_V_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.zssmProductionplanTaskVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.getCurrentDBTimestamp(this, data.zssmProductionplanTaskVId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.zssmProductionplanTaskVId, vars, this);
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
                    data.zssmProductionplanTaskVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Zssm_Productionplan_Task_V_ID", data.zssmProductionplanTaskVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet WorkSteps5AFBDE674D824E2E8D3A41B3770632BF. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
