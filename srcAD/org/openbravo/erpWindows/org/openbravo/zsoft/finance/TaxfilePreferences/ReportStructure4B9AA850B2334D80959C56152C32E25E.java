
package org.openbravo.erpWindows.org.openbravo.zsoft.finance.TaxfilePreferences;





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

public class ReportStructure4B9AA850B2334D80959C56152C32E25E extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(ReportStructure4B9AA850B2334D80959C56152C32E25E.class);
  
  private static final String windowId = "C59A8ACF5F9F43318EAA425133E45732";
  private static final String tabId = "4B9AA850B2334D80959C56152C32E25E";
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
        String strzsprBwaprefsId = request.getParameter("inpzsprBwaprefsId");
         String strPZspr_Bwaheader_ID = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strzsprBwaprefsId.equals(""))
              total = saveRecord(vars, myError, 'U', strPZspr_Bwaheader_ID);
          else
              total = saveRecord(vars, myError, 'I', strPZspr_Bwaheader_ID);
          
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
      String strPZspr_Bwaheader_ID = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID", "");

      String strZspr_Bwaprefs_ID = vars.getGlobalVariable("inpzsprBwaprefsId", windowId + "|Zspr_Bwaprefs_ID", "");
            if (strPZspr_Bwaheader_ID.equals("")) {
        strPZspr_Bwaheader_ID = getParentID(vars, strZspr_Bwaprefs_ID);
        if (strPZspr_Bwaheader_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|Zspr_Bwaheader_ID");
        vars.setSessionValue(windowId + "|Zspr_Bwaheader_ID", strPZspr_Bwaheader_ID);

        refreshParentSession(vars, strPZspr_Bwaheader_ID);
      }


      String strView = vars.getSessionValue(tabId + "|ReportStructure4B9AA850B2334D80959C56152C32E25E.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strZspr_Bwaprefs_ID.equals("")) strZspr_Bwaprefs_ID = firstElement(vars, tableSQL);
          if (strZspr_Bwaprefs_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZspr_Bwaprefs_ID, strPZspr_Bwaheader_ID, tableSQL);

      else printPageDataSheet(response, vars, strPZspr_Bwaheader_ID, strZspr_Bwaprefs_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strZspr_Bwaprefs_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strZspr_Bwaprefs_ID.equals("")) strZspr_Bwaprefs_ID = vars.getRequiredGlobalVariable("inpzsprBwaprefsId", windowId + "|Zspr_Bwaprefs_ID");
      else vars.setSessionValue(windowId + "|Zspr_Bwaprefs_ID", strZspr_Bwaprefs_ID);
      
      
      String strPZspr_Bwaheader_ID = getParentID(vars, strZspr_Bwaprefs_ID);
      
      vars.setSessionValue(windowId + "|Zspr_Bwaheader_ID", strPZspr_Bwaheader_ID);
      vars.setSessionValue("77515489D07B4FF3A7FA711D67F7E1DD|Report Header.view", "EDIT");

      refreshParentSession(vars, strPZspr_Bwaheader_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|ReportStructure4B9AA850B2334D80959C56152C32E25E.view", "EDIT");

        printPageEdit(response, request, vars, false, strZspr_Bwaprefs_ID, strPZspr_Bwaheader_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|ReportStructure4B9AA850B2334D80959C56152C32E25E.view", "RELATION");
        printPageDataSheet(response, vars, strPZspr_Bwaheader_ID, strZspr_Bwaprefs_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPZspr_Bwaheader_ID = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|Zspr_Bwaprefs_ID");
      refreshParentSession(vars, strPZspr_Bwaheader_ID);


      String strView = vars.getSessionValue(tabId + "|ReportStructure4B9AA850B2334D80959C56152C32E25E.view");
      String strZspr_Bwaprefs_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strZspr_Bwaprefs_ID = firstElement(vars, tableSQL);
          if (strZspr_Bwaprefs_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strZspr_Bwaprefs_ID.equals("")) strZspr_Bwaprefs_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strZspr_Bwaprefs_ID, strPZspr_Bwaheader_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPZspr_Bwaheader_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamZspr_Bwaheader_ID", tabId + "|paramZspr_Bwaheader_ID");

            String strPZspr_Bwaheader_ID = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID");

      
      vars.removeSessionValue(windowId + "|Zspr_Bwaprefs_ID");
      String strZspr_Bwaprefs_ID="";

      String strView = vars.getSessionValue(tabId + "|ReportStructure4B9AA850B2334D80959C56152C32E25E.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strZspr_Bwaprefs_ID = firstElement(vars, tableSQL);
        if (strZspr_Bwaprefs_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|ReportStructure4B9AA850B2334D80959C56152C32E25E.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZspr_Bwaprefs_ID, strPZspr_Bwaheader_ID, tableSQL);

      else printPageDataSheet(response, vars, strPZspr_Bwaheader_ID, strZspr_Bwaprefs_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPZspr_Bwaheader_ID = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID");
      

      String strZspr_Bwaprefs_ID = vars.getGlobalVariable("inpzsprBwaprefsId", windowId + "|Zspr_Bwaprefs_ID", "");
      vars.setSessionValue(tabId + "|ReportStructure4B9AA850B2334D80959C56152C32E25E.view", "RELATION");
      printPageDataSheet(response, vars, strPZspr_Bwaheader_ID, strZspr_Bwaprefs_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPZspr_Bwaheader_ID = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID");


      printPageEdit(response, request, vars, true, "", strPZspr_Bwaheader_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPZspr_Bwaheader_ID = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strZspr_Bwaprefs_ID = vars.getGlobalVariable("inpzsprBwaprefsId", windowId + "|Zspr_Bwaprefs_ID", "");
      vars.setSessionValue(tabId + "|ReportStructure4B9AA850B2334D80959C56152C32E25E.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strZspr_Bwaprefs_ID, strPZspr_Bwaheader_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPZspr_Bwaheader_ID = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID");
      String strZspr_Bwaprefs_ID = vars.getRequiredStringParameter("inpzsprBwaprefsId");
      
      String strNext = nextElement(vars, strZspr_Bwaprefs_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPZspr_Bwaheader_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPZspr_Bwaheader_ID = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID");
      String strZspr_Bwaprefs_ID = vars.getRequiredStringParameter("inpzsprBwaprefsId");
      
      String strPrevious = previousElement(vars, strZspr_Bwaprefs_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPZspr_Bwaheader_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID");

      vars.setSessionValue(tabId + "|ReportStructure4B9AA850B2334D80959C56152C32E25E.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPZspr_Bwaheader_ID = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|ReportStructure4B9AA850B2334D80959C56152C32E25E.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|ReportStructure4B9AA850B2334D80959C56152C32E25E.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|ReportStructure4B9AA850B2334D80959C56152C32E25E.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Zspr_Bwaprefs_ID");
      vars.setSessionValue(windowId + "|Zspr_Bwaheader_ID", strPZspr_Bwaheader_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPZspr_Bwaheader_ID = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|ReportStructure4B9AA850B2334D80959C56152C32E25E.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|ReportStructure4B9AA850B2334D80959C56152C32E25E.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Zspr_Bwaprefs_ID");
      vars.setSessionValue(windowId + "|Zspr_Bwaheader_ID", strPZspr_Bwaheader_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPZspr_Bwaheader_ID = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPZspr_Bwaheader_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPZspr_Bwaheader_ID = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPZspr_Bwaheader_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPZspr_Bwaheader_ID = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPZspr_Bwaheader_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPZspr_Bwaheader_ID = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPZspr_Bwaheader_ID);      
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
      String strPZspr_Bwaheader_ID = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID");
      String strZspr_Bwaprefs_ID = vars.getRequiredGlobalVariable("inpzsprBwaprefsId", windowId + "|Zspr_Bwaprefs_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPZspr_Bwaheader_ID);      
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
          String strNext = nextElement(vars, strZspr_Bwaprefs_ID, tableSQL);
          vars.setSessionValue(windowId + "|Zspr_Bwaprefs_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPZspr_Bwaheader_ID = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID");

      String strZspr_Bwaprefs_ID = vars.getRequiredInStringParameter("inpzsprBwaprefsId");
      String message = deleteRelation(vars, strZspr_Bwaprefs_ID, strPZspr_Bwaheader_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|zsprBwaprefsId");
        vars.setSessionValue(tabId + "|ReportStructure4B9AA850B2334D80959C56152C32E25E.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPZspr_Bwaheader_ID = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID");

      String strZspr_Bwaprefs_ID = vars.getRequiredStringParameter("inpzsprBwaprefsId");
      //ReportStructure4B9AA850B2334D80959C56152C32E25EData data = getEditVariables(vars, strPZspr_Bwaheader_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = ReportStructure4B9AA850B2334D80959C56152C32E25EData.delete(this, strZspr_Bwaprefs_ID, strPZspr_Bwaheader_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|zsprBwaprefsId");
        vars.setSessionValue(tabId + "|ReportStructure4B9AA850B2334D80959C56152C32E25E.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strZspr_Bwaprefs_ID, String strPZspr_Bwaheader_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strZspr_Bwaprefs_ID.startsWith("(")) strZspr_Bwaprefs_ID = strZspr_Bwaprefs_ID.substring(1, strZspr_Bwaprefs_ID.length()-1);
      if (!strZspr_Bwaprefs_ID.equals("")) {
        strZspr_Bwaprefs_ID = Replace.replace(strZspr_Bwaprefs_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strZspr_Bwaprefs_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (ReportStructure4B9AA850B2334D80959C56152C32E25EData.deleteTransactional(conn, this, strKey, strPZspr_Bwaheader_ID)==0) {
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
  private ReportStructure4B9AA850B2334D80959C56152C32E25EData getEditVariables(Connection con, VariablesSecureApp vars, String strPZspr_Bwaheader_ID) throws IOException,ServletException {
    ReportStructure4B9AA850B2334D80959C56152C32E25EData data = new ReportStructure4B9AA850B2334D80959C56152C32E25EData();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.zsprBwaprefsId = vars.getRequestGlobalVariable("inpzsprBwaprefsId", windowId + "|Zspr_Bwaprefs_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.zsprBwaheaderId = vars.getStringParameter("inpzsprBwaheaderId");     data.zsprBwaheaderIdr = vars.getStringParameter("inpzsprBwaheaderId_R");     data.name = vars.getStringParameter("inpname");    try {   data.orderno = vars.getNumericParameter("inporderno");  } catch (ServletException paramEx) { ex = paramEx; }     data.isasset = vars.getStringParameter("inpisasset", "N");     data.sumfrombeginning = vars.getStringParameter("inpsumfrombeginning", "N");     data.allwowonlypositive = vars.getStringParameter("inpallwowonlypositive", "N");     data.allwowonlynegative = vars.getStringParameter("inpallwowonlynegative", "N");     data.dontprintdetails = vars.getStringParameter("inpdontprintdetails", "N");     data.issuminfooter = vars.getStringParameter("inpissuminfooter", "N");     data.isparent = vars.getStringParameter("inpisparent", "N");     data.parentpref = vars.getStringParameter("inpparentpref");     data.parentprefr = vars.getStringParameter("inpparentpref_R");     data.isactive = vars.getStringParameter("inpisactive", "N"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.zsprBwaheaderId = vars.getGlobalVariable("inpzsprBwaheaderId", windowId + "|Zspr_Bwaheader_ID");


    
    

    
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

   private ReportStructure4B9AA850B2334D80959C56152C32E25EData[] getRelationData(ReportStructure4B9AA850B2334D80959C56152C32E25EData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].zsprBwaprefsId = FormatUtilities.truncate(data[i].zsprBwaprefsId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].zsprBwaheaderId = FormatUtilities.truncate(data[i].zsprBwaheaderId, 32);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].parentpref = FormatUtilities.truncate(data[i].parentpref, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPZspr_Bwaheader_ID) throws IOException,ServletException {
      ReportHeader77515489D07B4FF3A7FA711D67F7E1DDData[] data = ReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPZspr_Bwaheader_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|Zspr_Bwaheader_ID", data[0].zsprBwaheaderId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);
      vars.setSessionValue(windowId + "|Zspr_Bwaheader_ID", strPZspr_Bwaheader_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strZspr_Bwaprefs_ID) throws ServletException {
    String strPZspr_Bwaheader_ID = ReportStructure4B9AA850B2334D80959C56152C32E25EData.selectParentID(this, strZspr_Bwaprefs_ID);
    if (strPZspr_Bwaheader_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strZspr_Bwaprefs_ID);
      throw new ServletException("Parent record not found");
    }
    return strPZspr_Bwaheader_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Zspr_Bwaprefs_ID", data[0].getField("zsprBwaprefsId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPZspr_Bwaheader_ID) throws IOException,ServletException {
      ReportStructure4B9AA850B2334D80959C56152C32E25EData[] data = ReportStructure4B9AA850B2334D80959C56152C32E25EData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPZspr_Bwaheader_ID, vars.getStringParameter("inpzsprBwaprefsId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPZspr_Bwaheader_ID, String strZspr_Bwaprefs_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamZspr_Bwaheader_ID = vars.getSessionValue(tabId + "|paramZspr_Bwaheader_ID");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamName.equals("") && strParamZspr_Bwaheader_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strZspr_Bwaprefs_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strZspr_Bwaprefs_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/finance/TaxfilePreferences/ReportStructure4B9AA850B2334D80959C56152C32E25E_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "ReportStructure4B9AA850B2334D80959C56152C32E25E", false, "document.frmMain.inpzsprBwaprefsId", "grid", "..", "".equals("Y"), "TaxfilePreferences", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPZspr_Bwaheader_ID);

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
    xmlDocument.setParameter("KeyName", "zsprBwaprefsId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "ReportStructure4B9AA850B2334D80959C56152C32E25E_Relation.html", "TaxfilePreferences", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "ReportStructure4B9AA850B2334D80959C56152C32E25E_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", ReportStructure4B9AA850B2334D80959C56152C32E25EData.selectParent(this, strPZspr_Bwaheader_ID));
    else xmlDocument.setParameter("parent", ReportStructure4B9AA850B2334D80959C56152C32E25EData.selectParentTrl(this, strPZspr_Bwaheader_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strZspr_Bwaprefs_ID, String strPZspr_Bwaheader_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " orderno";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    ReportStructure4B9AA850B2334D80959C56152C32E25EData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamZspr_Bwaheader_ID = vars.getSessionValue(tabId + "|paramZspr_Bwaheader_ID");

    boolean hasSearchCondition=false;
    if (!(strParamName.equals("") && strParamZspr_Bwaheader_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = ReportStructure4B9AA850B2334D80959C56152C32E25EData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPZspr_Bwaheader_ID, strZspr_Bwaprefs_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strZspr_Bwaprefs_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new ReportStructure4B9AA850B2334D80959C56152C32E25EData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("zsprBwaprefsId") == null || dataField.getField("zsprBwaprefsId").equals("")) {
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
        refreshSessionNew(vars, strPZspr_Bwaheader_ID);
        data = ReportStructure4B9AA850B2334D80959C56152C32E25EData.set(strPZspr_Bwaheader_ID, Utility.getDefault(this, vars, "Issuminfooter", "Y", "C59A8ACF5F9F43318EAA425133E45732", "4B9AA850B2334D80959C56152C32E25E", "N", dataField), Utility.getDefault(this, vars, "Dontprintdetails", "N", "C59A8ACF5F9F43318EAA425133E45732", "4B9AA850B2334D80959C56152C32E25E", "N", dataField), Utility.getDefault(this, vars, "Sumfrombeginning", "Y", "C59A8ACF5F9F43318EAA425133E45732", "4B9AA850B2334D80959C56152C32E25E", "N", dataField), Utility.getDefault(this, vars, "Createdby", "", "C59A8ACF5F9F43318EAA425133E45732", "4B9AA850B2334D80959C56152C32E25E", "", dataField), ReportStructure4B9AA850B2334D80959C56152C32E25EData.selectDef2A4340D638AA4565B316C624809B9EC0_0(this, Utility.getDefault(this, vars, "Createdby", "", "C59A8ACF5F9F43318EAA425133E45732", "4B9AA850B2334D80959C56152C32E25E", "", dataField)), Utility.getDefault(this, vars, "Orderno", "0", "C59A8ACF5F9F43318EAA425133E45732", "4B9AA850B2334D80959C56152C32E25E", "", dataField), Utility.getDefault(this, vars, "Isparent", "Y", "C59A8ACF5F9F43318EAA425133E45732", "4B9AA850B2334D80959C56152C32E25E", "N", dataField), Utility.getDefault(this, vars, "Allwowonlypositive", "N", "C59A8ACF5F9F43318EAA425133E45732", "4B9AA850B2334D80959C56152C32E25E", "N", dataField), "", Utility.getDefault(this, vars, "Isasset", "N", "C59A8ACF5F9F43318EAA425133E45732", "4B9AA850B2334D80959C56152C32E25E", "N", dataField), Utility.getDefault(this, vars, "Allwowonlynegative", "N", "C59A8ACF5F9F43318EAA425133E45732", "4B9AA850B2334D80959C56152C32E25E", "N", dataField), Utility.getDefault(this, vars, "Name", "", "C59A8ACF5F9F43318EAA425133E45732", "4B9AA850B2334D80959C56152C32E25E", "", dataField), Utility.getDefault(this, vars, "Parentpref", "", "C59A8ACF5F9F43318EAA425133E45732", "4B9AA850B2334D80959C56152C32E25E", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "C59A8ACF5F9F43318EAA425133E45732", "4B9AA850B2334D80959C56152C32E25E", "", dataField), ReportStructure4B9AA850B2334D80959C56152C32E25EData.selectDef4B61594118DA437491F87B3F9385C069_1(this, strPZspr_Bwaheader_ID), Utility.getDefault(this, vars, "Updatedby", "", "C59A8ACF5F9F43318EAA425133E45732", "4B9AA850B2334D80959C56152C32E25E", "", dataField), ReportStructure4B9AA850B2334D80959C56152C32E25EData.selectDef7343457F219649ED9DEE3FE9A9573ECE_2(this, Utility.getDefault(this, vars, "Updatedby", "", "C59A8ACF5F9F43318EAA425133E45732", "4B9AA850B2334D80959C56152C32E25E", "", dataField)), "Y", Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "C59A8ACF5F9F43318EAA425133E45732", "4B9AA850B2334D80959C56152C32E25E", "", dataField));
        
      }
    } else {
      data = new ReportStructure4B9AA850B2334D80959C56152C32E25EData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(ReportStructure4B9AA850B2334D80959C56152C32E25EData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=ReportHeader77515489D07B4FF3A7FA711D67F7E1DDData.selectOrg(this, strPZspr_Bwaheader_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "ReportStructure4B9AA850B2334D80959C56152C32E25E", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpzsprBwaprefsId", "", "..", "".equals("Y"), "TaxfilePreferences", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strZspr_Bwaprefs_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPZspr_Bwaheader_ID) throws IOException, ServletException {
    ReportStructure4B9AA850B2334D80959C56152C32E25EData data = null;
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
            data = getEditVariables(con, vars, strPZspr_Bwaheader_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.zsprBwaprefsId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (ReportStructure4B9AA850B2334D80959C56152C32E25EData.getCurrentDBTimestamp(this, data.zsprBwaprefsId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.zsprBwaprefsId, vars, this);
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
                    data.zsprBwaprefsId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Zspr_Bwaprefs_ID", data.zsprBwaprefsId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet ReportStructure4B9AA850B2334D80959C56152C32E25E. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
