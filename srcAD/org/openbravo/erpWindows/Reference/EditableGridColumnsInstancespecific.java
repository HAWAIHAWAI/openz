
package org.openbravo.erpWindows.Reference;





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

public class EditableGridColumnsInstancespecific extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(EditableGridColumnsInstancespecific.class);
  
  private static final String windowId = "101";
  private static final String tabId = "00C0FDAA6CB5478D856F30ACCA1B998F";
  private static final String defaultTabView = "RELATION";
  private static final int accesslevel = 4;
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
        String stradRefGridcolumninstanceId = request.getParameter("inpadRefGridcolumninstanceId");
         String strPAD_Ref_Gridcolumn_ID = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !stradRefGridcolumninstanceId.equals(""))
              total = saveRecord(vars, myError, 'U', strPAD_Ref_Gridcolumn_ID);
          else
              total = saveRecord(vars, myError, 'I', strPAD_Ref_Gridcolumn_ID);
          
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
      String strPAD_Ref_Gridcolumn_ID = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID", "");

      String strAD_Ref_Gridcolumninstance_ID = vars.getGlobalVariable("inpadRefGridcolumninstanceId", windowId + "|AD_Ref_Gridcolumninstance_ID", "");
            if (strPAD_Ref_Gridcolumn_ID.equals("")) {
        strPAD_Ref_Gridcolumn_ID = getParentID(vars, strAD_Ref_Gridcolumninstance_ID);
        if (strPAD_Ref_Gridcolumn_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|AD_Ref_Gridcolumn_ID");
        vars.setSessionValue(windowId + "|AD_Ref_Gridcolumn_ID", strPAD_Ref_Gridcolumn_ID);
      vars.removeSessionValue(windowId + "|AD_Ref_Group_ID");
        refreshParentSession(vars, strPAD_Ref_Gridcolumn_ID);
      }


      String strView = vars.getSessionValue(tabId + "|EditableGridColumnsInstancespecific.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strAD_Ref_Gridcolumninstance_ID.equals("")) strAD_Ref_Gridcolumninstance_ID = firstElement(vars, tableSQL);
          if (strAD_Ref_Gridcolumninstance_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strAD_Ref_Gridcolumninstance_ID, strPAD_Ref_Gridcolumn_ID, tableSQL);

      else printPageDataSheet(response, vars, strPAD_Ref_Gridcolumn_ID, strAD_Ref_Gridcolumninstance_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strAD_Ref_Gridcolumninstance_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strAD_Ref_Gridcolumninstance_ID.equals("")) strAD_Ref_Gridcolumninstance_ID = vars.getRequiredGlobalVariable("inpadRefGridcolumninstanceId", windowId + "|AD_Ref_Gridcolumninstance_ID");
      else vars.setSessionValue(windowId + "|AD_Ref_Gridcolumninstance_ID", strAD_Ref_Gridcolumninstance_ID);
      
      
      String strPAD_Ref_Gridcolumn_ID = getParentID(vars, strAD_Ref_Gridcolumninstance_ID);
      
      vars.setSessionValue(windowId + "|AD_Ref_Gridcolumn_ID", strPAD_Ref_Gridcolumn_ID);
      vars.setSessionValue("6E35388135644A70A6A709039E338EA3|Editable Grid Columns.view", "EDIT");
      vars.removeSessionValue(windowId + "|AD_Ref_Group_ID");
      refreshParentSession(vars, strPAD_Ref_Gridcolumn_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|EditableGridColumnsInstancespecific.view", "EDIT");

        printPageEdit(response, request, vars, false, strAD_Ref_Gridcolumninstance_ID, strPAD_Ref_Gridcolumn_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|EditableGridColumnsInstancespecific.view", "RELATION");
        printPageDataSheet(response, vars, strPAD_Ref_Gridcolumn_ID, strAD_Ref_Gridcolumninstance_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPAD_Ref_Gridcolumn_ID = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|AD_Ref_Gridcolumninstance_ID");
      refreshParentSession(vars, strPAD_Ref_Gridcolumn_ID);


      String strView = vars.getSessionValue(tabId + "|EditableGridColumnsInstancespecific.view");
      String strAD_Ref_Gridcolumninstance_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strAD_Ref_Gridcolumninstance_ID = firstElement(vars, tableSQL);
          if (strAD_Ref_Gridcolumninstance_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strAD_Ref_Gridcolumninstance_ID.equals("")) strAD_Ref_Gridcolumninstance_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strAD_Ref_Gridcolumninstance_ID, strPAD_Ref_Gridcolumn_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPAD_Ref_Gridcolumn_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");

            String strPAD_Ref_Gridcolumn_ID = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID");

      
      vars.removeSessionValue(windowId + "|AD_Ref_Gridcolumninstance_ID");
      String strAD_Ref_Gridcolumninstance_ID="";

      String strView = vars.getSessionValue(tabId + "|EditableGridColumnsInstancespecific.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strAD_Ref_Gridcolumninstance_ID = firstElement(vars, tableSQL);
        if (strAD_Ref_Gridcolumninstance_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|EditableGridColumnsInstancespecific.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strAD_Ref_Gridcolumninstance_ID, strPAD_Ref_Gridcolumn_ID, tableSQL);

      else printPageDataSheet(response, vars, strPAD_Ref_Gridcolumn_ID, strAD_Ref_Gridcolumninstance_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPAD_Ref_Gridcolumn_ID = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID");
      

      String strAD_Ref_Gridcolumninstance_ID = vars.getGlobalVariable("inpadRefGridcolumninstanceId", windowId + "|AD_Ref_Gridcolumninstance_ID", "");
      vars.setSessionValue(tabId + "|EditableGridColumnsInstancespecific.view", "RELATION");
      printPageDataSheet(response, vars, strPAD_Ref_Gridcolumn_ID, strAD_Ref_Gridcolumninstance_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPAD_Ref_Gridcolumn_ID = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID");


      printPageEdit(response, request, vars, true, "", strPAD_Ref_Gridcolumn_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPAD_Ref_Gridcolumn_ID = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strAD_Ref_Gridcolumninstance_ID = vars.getGlobalVariable("inpadRefGridcolumninstanceId", windowId + "|AD_Ref_Gridcolumninstance_ID", "");
      vars.setSessionValue(tabId + "|EditableGridColumnsInstancespecific.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strAD_Ref_Gridcolumninstance_ID, strPAD_Ref_Gridcolumn_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPAD_Ref_Gridcolumn_ID = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID");
      String strAD_Ref_Gridcolumninstance_ID = vars.getRequiredStringParameter("inpadRefGridcolumninstanceId");
      
      String strNext = nextElement(vars, strAD_Ref_Gridcolumninstance_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPAD_Ref_Gridcolumn_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPAD_Ref_Gridcolumn_ID = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID");
      String strAD_Ref_Gridcolumninstance_ID = vars.getRequiredStringParameter("inpadRefGridcolumninstanceId");
      
      String strPrevious = previousElement(vars, strAD_Ref_Gridcolumninstance_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPAD_Ref_Gridcolumn_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID");

      vars.setSessionValue(tabId + "|EditableGridColumnsInstancespecific.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPAD_Ref_Gridcolumn_ID = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|EditableGridColumnsInstancespecific.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|EditableGridColumnsInstancespecific.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|EditableGridColumnsInstancespecific.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|AD_Ref_Gridcolumninstance_ID");
      vars.setSessionValue(windowId + "|AD_Ref_Gridcolumn_ID", strPAD_Ref_Gridcolumn_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPAD_Ref_Gridcolumn_ID = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|EditableGridColumnsInstancespecific.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|EditableGridColumnsInstancespecific.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|AD_Ref_Gridcolumninstance_ID");
      vars.setSessionValue(windowId + "|AD_Ref_Gridcolumn_ID", strPAD_Ref_Gridcolumn_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPAD_Ref_Gridcolumn_ID = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPAD_Ref_Gridcolumn_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPAD_Ref_Gridcolumn_ID = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPAD_Ref_Gridcolumn_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPAD_Ref_Gridcolumn_ID = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPAD_Ref_Gridcolumn_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPAD_Ref_Gridcolumn_ID = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPAD_Ref_Gridcolumn_ID);      
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
      String strPAD_Ref_Gridcolumn_ID = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID");
      String strAD_Ref_Gridcolumninstance_ID = vars.getRequiredGlobalVariable("inpadRefGridcolumninstanceId", windowId + "|AD_Ref_Gridcolumninstance_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPAD_Ref_Gridcolumn_ID);      
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
          String strNext = nextElement(vars, strAD_Ref_Gridcolumninstance_ID, tableSQL);
          vars.setSessionValue(windowId + "|AD_Ref_Gridcolumninstance_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPAD_Ref_Gridcolumn_ID = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID");

      String strAD_Ref_Gridcolumninstance_ID = vars.getRequiredInStringParameter("inpadRefGridcolumninstanceId");
      String message = deleteRelation(vars, strAD_Ref_Gridcolumninstance_ID, strPAD_Ref_Gridcolumn_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|adRefGridcolumninstanceId");
        vars.setSessionValue(tabId + "|EditableGridColumnsInstancespecific.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPAD_Ref_Gridcolumn_ID = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID");

      String strAD_Ref_Gridcolumninstance_ID = vars.getRequiredStringParameter("inpadRefGridcolumninstanceId");
      //EditableGridColumnsInstancespecificData data = getEditVariables(vars, strPAD_Ref_Gridcolumn_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = EditableGridColumnsInstancespecificData.delete(this, strAD_Ref_Gridcolumninstance_ID, strPAD_Ref_Gridcolumn_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|adRefGridcolumninstanceId");
        vars.setSessionValue(tabId + "|EditableGridColumnsInstancespecific.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strAD_Ref_Gridcolumninstance_ID, String strPAD_Ref_Gridcolumn_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strAD_Ref_Gridcolumninstance_ID.startsWith("(")) strAD_Ref_Gridcolumninstance_ID = strAD_Ref_Gridcolumninstance_ID.substring(1, strAD_Ref_Gridcolumninstance_ID.length()-1);
      if (!strAD_Ref_Gridcolumninstance_ID.equals("")) {
        strAD_Ref_Gridcolumninstance_ID = Replace.replace(strAD_Ref_Gridcolumninstance_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strAD_Ref_Gridcolumninstance_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (EditableGridColumnsInstancespecificData.deleteTransactional(conn, this, strKey, strPAD_Ref_Gridcolumn_ID)==0) {
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
  private EditableGridColumnsInstancespecificData getEditVariables(Connection con, VariablesSecureApp vars, String strPAD_Ref_Gridcolumn_ID) throws IOException,ServletException {
    EditableGridColumnsInstancespecificData data = new EditableGridColumnsInstancespecificData();
    ServletException ex = null;
    try {
    data.adRefGridcolumnId = vars.getStringParameter("inpadRefGridcolumnId");     data.adRefGridcolumnIdr = vars.getStringParameter("inpadRefGridcolumnId_R");    try {   data.line = vars.getNumericParameter("inpline");  } catch (ServletException paramEx) { ex = paramEx; }     data.adElementId = vars.getStringParameter("inpadElementId");     data.adElementIdr = vars.getStringParameter("inpadElementId_R");     data.visiblesetting = vars.getStringParameter("inpvisiblesetting");     data.visiblesettingr = vars.getStringParameter("inpvisiblesetting_R");     data.editsetting = vars.getStringParameter("inpeditsetting");     data.editsettingr = vars.getStringParameter("inpeditsetting_R");     data.isactive = vars.getStringParameter("inpisactive", "N");    try {   data.colspan = vars.getNumericParameter("inpcolspan");  } catch (ServletException paramEx) { ex = paramEx; }     data.required = vars.getStringParameter("inprequired");     data.requiredr = vars.getStringParameter("inprequired_R");     data.issecondheader = vars.getStringParameter("inpissecondheader");     data.issecondheaderr = vars.getStringParameter("inpissecondheader_R");    try {   data.maxlength = vars.getNumericParameter("inpmaxlength");  } catch (ServletException paramEx) { ex = paramEx; }     data.isinheader = vars.getStringParameter("inpisinheader");     data.isinheaderr = vars.getStringParameter("inpisinheader_R");     data.colreference = vars.getStringParameter("inpcolreference");     data.colreferencer = vars.getStringParameter("inpcolreference_R");     data.referenceurl = vars.getStringParameter("inpreferenceurl");     data.adTableId = vars.getStringParameter("inpadTableId");     data.adTableIdr = vars.getStringParameter("inpadTableId_R");     data.adValRuleId = vars.getStringParameter("inpadValRuleId");     data.adValRuleIdr = vars.getStringParameter("inpadValRuleId_R");     data.includesemptyitem = vars.getStringParameter("inpincludesemptyitem");     data.includesemptyitemr = vars.getStringParameter("inpincludesemptyitem_R");     data.template = vars.getStringParameter("inptemplate");     data.templater = vars.getStringParameter("inptemplate_R");     data.issplitgroup = vars.getStringParameter("inpissplitgroup");     data.issplitgroupr = vars.getStringParameter("inpissplitgroup_R");     data.defaultvalue = vars.getStringParameter("inpdefaultvalue");     data.onchangeevent = vars.getStringParameter("inponchangeevent");     data.adRefGridcolumninstanceId = vars.getRequestGlobalVariable("inpadRefGridcolumninstanceId", windowId + "|AD_Ref_Gridcolumninstance_ID");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.issortable = vars.getStringParameter("inpissortable");     data.readonlylogic = vars.getStringParameter("inpreadonlylogic");     data.isrowkey = vars.getStringParameter("inpisrowkey", "N");     data.name = vars.getStringParameter("inpname");     data.isdisplayed = vars.getStringParameter("inpisdisplayed", "N");     data.headertext = vars.getStringParameter("inpheadertext");     data.readonly = vars.getStringParameter("inpreadonly", "N");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.mandantorylogic = vars.getStringParameter("inpmandantorylogic");     data.rowkeysuffix = vars.getStringParameter("inprowkeysuffix"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.adRefGridcolumnId = vars.getGlobalVariable("inpadRefGridcolumnId", windowId + "|AD_Ref_Gridcolumn_ID");


    
    

    
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

   private EditableGridColumnsInstancespecificData[] getRelationData(EditableGridColumnsInstancespecificData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adRefGridcolumnId = FormatUtilities.truncate(data[i].adRefGridcolumnId, 32);        data[i].adElementId = FormatUtilities.truncate(data[i].adElementId, 32);        data[i].visiblesetting = FormatUtilities.truncate(data[i].visiblesetting, 50);        data[i].editsetting = FormatUtilities.truncate(data[i].editsetting, 50);        data[i].required = FormatUtilities.truncate(data[i].required, 1);        data[i].issecondheader = FormatUtilities.truncate(data[i].issecondheader, 1);        data[i].isinheader = FormatUtilities.truncate(data[i].isinheader, 1);        data[i].colreference = FormatUtilities.truncate(data[i].colreference, 32);        data[i].referenceurl = FormatUtilities.truncate(data[i].referenceurl, 50);        data[i].adTableId = FormatUtilities.truncate(data[i].adTableId, 32);        data[i].adValRuleId = FormatUtilities.truncate(data[i].adValRuleId, 32);        data[i].includesemptyitem = FormatUtilities.truncate(data[i].includesemptyitem, 1);        data[i].template = FormatUtilities.truncate(data[i].template, 50);        data[i].issplitgroup = FormatUtilities.truncate(data[i].issplitgroup, 1);        data[i].defaultvalue = FormatUtilities.truncate(data[i].defaultvalue, 50);        data[i].onchangeevent = FormatUtilities.truncate(data[i].onchangeevent, 50);        data[i].adRefGridcolumninstanceId = FormatUtilities.truncate(data[i].adRefGridcolumninstanceId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].issortable = FormatUtilities.truncate(data[i].issortable, 1);        data[i].readonlylogic = FormatUtilities.truncate(data[i].readonlylogic, 50);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].headertext = FormatUtilities.truncate(data[i].headertext, 50);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].mandantorylogic = FormatUtilities.truncate(data[i].mandantorylogic, 50);        data[i].rowkeysuffix = FormatUtilities.truncate(data[i].rowkeysuffix, 20);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPAD_Ref_Gridcolumn_ID) throws IOException,ServletException {
      EditableGridColumnsData[] data = EditableGridColumnsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getSessionValue(windowId + "|AD_Ref_Group_ID"), strPAD_Ref_Gridcolumn_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Ref_Gridcolumn_ID", data[0].adRefGridcolumnId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);
      vars.setSessionValue(windowId + "|AD_Ref_Gridcolumn_ID", strPAD_Ref_Gridcolumn_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strAD_Ref_Gridcolumninstance_ID) throws ServletException {
    String strPAD_Ref_Gridcolumn_ID = EditableGridColumnsInstancespecificData.selectParentID(this, strAD_Ref_Gridcolumninstance_ID);
    if (strPAD_Ref_Gridcolumn_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strAD_Ref_Gridcolumninstance_ID);
      throw new ServletException("Parent record not found");
    }
    return strPAD_Ref_Gridcolumn_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Ref_Gridcolumninstance_ID", data[0].getField("adRefGridcolumninstanceId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPAD_Ref_Gridcolumn_ID) throws IOException,ServletException {
      EditableGridColumnsInstancespecificData[] data = EditableGridColumnsInstancespecificData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPAD_Ref_Gridcolumn_ID, vars.getStringParameter("inpadRefGridcolumninstanceId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPAD_Ref_Gridcolumn_ID, String strAD_Ref_Gridcolumninstance_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamName = vars.getSessionValue(tabId + "|paramName");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamName.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strAD_Ref_Gridcolumninstance_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strAD_Ref_Gridcolumninstance_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/Reference/EditableGridColumnsInstancespecific_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "EditableGridColumnsInstancespecific", false, "document.frmMain.inpadRefGridcolumninstanceId", "grid", "..", "".equals("Y"), "Reference", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPAD_Ref_Gridcolumn_ID);

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
    xmlDocument.setParameter("KeyName", "adRefGridcolumninstanceId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "EditableGridColumnsInstancespecific_Relation.html", "Reference", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "EditableGridColumnsInstancespecific_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", EditableGridColumnsInstancespecificData.selectParent(this, strPAD_Ref_Gridcolumn_ID));
    else xmlDocument.setParameter("parent", EditableGridColumnsInstancespecificData.selectParentTrl(this, strPAD_Ref_Gridcolumn_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strAD_Ref_Gridcolumninstance_ID, String strPAD_Ref_Gridcolumn_ID, TableSQLData tableSQL)
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
    EditableGridColumnsInstancespecificData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamName = vars.getSessionValue(tabId + "|paramName");

    boolean hasSearchCondition=false;
    if (!(strParamName.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = EditableGridColumnsInstancespecificData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPAD_Ref_Gridcolumn_ID, strAD_Ref_Gridcolumninstance_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strAD_Ref_Gridcolumninstance_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new EditableGridColumnsInstancespecificData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("adRefGridcolumninstanceId") == null || dataField.getField("adRefGridcolumninstanceId").equals("")) {
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
        refreshSessionNew(vars, strPAD_Ref_Gridcolumn_ID);
        data = EditableGridColumnsInstancespecificData.set(strPAD_Ref_Gridcolumn_ID, Utility.getDefault(this, vars, "Colspan", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "Defaultvalue", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "Headertext", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "Template", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), "Y", Utility.getDefault(this, vars, "Required", "NON", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), EditableGridColumnsInstancespecificData.selectDefDA259AB1C5404BF28209DD6044B06665_0(this, Utility.getDefault(this, vars, "Createdby", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField)), Utility.getDefault(this, vars, "Updatedby", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), EditableGridColumnsInstancespecificData.selectDef3DDD02B35DF144DAB8EA2AD0B560A0D9_1(this, Utility.getDefault(this, vars, "Updatedby", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField)), Utility.getDefault(this, vars, "Isrowkey", "N", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "N", dataField), Utility.getDefault(this, vars, "Visiblesetting", "NON", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "AD_Table_ID", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "Includesemptyitem", "NON", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "Mandantorylogic", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "AD_Val_Rule_ID", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "AD_Element_ID", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "Readonlylogic", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "Isdisplayed", "N", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "N", dataField), Utility.getDefault(this, vars, "Issplitgroup", "NON", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "Colreference", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "Name", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "Maxlength", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "Referenceurl", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), "", Utility.getDefault(this, vars, "Readonly", "N", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "N", dataField), Utility.getDefault(this, vars, "Editsetting", "NON", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), "0", Utility.getDefault(this, vars, "Onchangeevent", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "Issecondheader", "NON", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "Issortable", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), "0", Utility.getDefault(this, vars, "Line", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "Rowkeysuffix", "", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField), Utility.getDefault(this, vars, "Isinheader", "NON", "101", "00C0FDAA6CB5478D856F30ACCA1B998F", "", dataField));
        
      }
    } else {
      data = new EditableGridColumnsInstancespecificData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(EditableGridColumnsInstancespecificData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=EditableGridColumnsData.selectOrg(this, strPAD_Ref_Gridcolumn_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "EditableGridColumnsInstancespecific", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpadRefGridcolumninstanceId", "", "..", "".equals("Y"), "Reference", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strAD_Ref_Gridcolumninstance_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPAD_Ref_Gridcolumn_ID) throws IOException, ServletException {
    EditableGridColumnsInstancespecificData data = null;
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
            data = getEditVariables(con, vars, strPAD_Ref_Gridcolumn_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.adRefGridcolumninstanceId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (EditableGridColumnsInstancespecificData.getCurrentDBTimestamp(this, data.adRefGridcolumninstanceId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.adRefGridcolumninstanceId, vars, this);
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
                    data.adRefGridcolumninstanceId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|AD_Ref_Gridcolumninstance_ID", data.adRefGridcolumninstanceId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet EditableGridColumnsInstancespecific. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
