
package org.openbravo.erpWindows.Organization;





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

public class CalendarSettings extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(CalendarSettings.class);
  
  private static final String windowId = "110";
  private static final String tabId = "FA369E65EE864BCE86AE1DBA330BA244";
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
        String strcWorkcalendarsettingsId = request.getParameter("inpcWorkcalendarsettingsId");
         String strPAD_Org_ID = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcWorkcalendarsettingsId.equals(""))
              total = saveRecord(vars, myError, 'U', strPAD_Org_ID);
          else
              total = saveRecord(vars, myError, 'I', strPAD_Org_ID);
          
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
      String strPAD_Org_ID = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID", "");

      String strC_Workcalendarsettings_ID = vars.getGlobalVariable("inpcWorkcalendarsettingsId", windowId + "|C_Workcalendarsettings_ID", "");
            if (strPAD_Org_ID.equals("")) {
        strPAD_Org_ID = getParentID(vars, strC_Workcalendarsettings_ID);
        if (strPAD_Org_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|AD_Org_ID");
        vars.setSessionValue(windowId + "|AD_Org_ID", strPAD_Org_ID);

        refreshParentSession(vars, strPAD_Org_ID);
      }


      String strView = vars.getSessionValue(tabId + "|CalendarSettings.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_Workcalendarsettings_ID.equals("")) strC_Workcalendarsettings_ID = firstElement(vars, tableSQL);
          if (strC_Workcalendarsettings_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Workcalendarsettings_ID, strPAD_Org_ID, tableSQL);

      else printPageDataSheet(response, vars, strPAD_Org_ID, strC_Workcalendarsettings_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_Workcalendarsettings_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_Workcalendarsettings_ID.equals("")) strC_Workcalendarsettings_ID = vars.getRequiredGlobalVariable("inpcWorkcalendarsettingsId", windowId + "|C_Workcalendarsettings_ID");
      else vars.setSessionValue(windowId + "|C_Workcalendarsettings_ID", strC_Workcalendarsettings_ID);
      
      
      String strPAD_Org_ID = getParentID(vars, strC_Workcalendarsettings_ID);
      
      vars.setSessionValue(windowId + "|AD_Org_ID", strPAD_Org_ID);
      vars.setSessionValue("143|Organization.view", "EDIT");

      refreshParentSession(vars, strPAD_Org_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|CalendarSettings.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_Workcalendarsettings_ID, strPAD_Org_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|CalendarSettings.view", "RELATION");
        printPageDataSheet(response, vars, strPAD_Org_ID, strC_Workcalendarsettings_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPAD_Org_ID = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|C_Workcalendarsettings_ID");
      refreshParentSession(vars, strPAD_Org_ID);


      String strView = vars.getSessionValue(tabId + "|CalendarSettings.view");
      String strC_Workcalendarsettings_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_Workcalendarsettings_ID = firstElement(vars, tableSQL);
          if (strC_Workcalendarsettings_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_Workcalendarsettings_ID.equals("")) strC_Workcalendarsettings_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_Workcalendarsettings_ID, strPAD_Org_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPAD_Org_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamValidfrom", tabId + "|paramValidfrom");
vars.getRequestGlobalVariable("inpParamValidfrom_f", tabId + "|paramValidfrom_f");

            String strPAD_Org_ID = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");

      
      vars.removeSessionValue(windowId + "|C_Workcalendarsettings_ID");
      String strC_Workcalendarsettings_ID="";

      String strView = vars.getSessionValue(tabId + "|CalendarSettings.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_Workcalendarsettings_ID = firstElement(vars, tableSQL);
        if (strC_Workcalendarsettings_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|CalendarSettings.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Workcalendarsettings_ID, strPAD_Org_ID, tableSQL);

      else printPageDataSheet(response, vars, strPAD_Org_ID, strC_Workcalendarsettings_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPAD_Org_ID = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");
      

      String strC_Workcalendarsettings_ID = vars.getGlobalVariable("inpcWorkcalendarsettingsId", windowId + "|C_Workcalendarsettings_ID", "");
      vars.setSessionValue(tabId + "|CalendarSettings.view", "RELATION");
      printPageDataSheet(response, vars, strPAD_Org_ID, strC_Workcalendarsettings_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPAD_Org_ID = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");


      printPageEdit(response, request, vars, true, "", strPAD_Org_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPAD_Org_ID = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_Workcalendarsettings_ID = vars.getGlobalVariable("inpcWorkcalendarsettingsId", windowId + "|C_Workcalendarsettings_ID", "");
      vars.setSessionValue(tabId + "|CalendarSettings.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_Workcalendarsettings_ID, strPAD_Org_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPAD_Org_ID = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");
      String strC_Workcalendarsettings_ID = vars.getRequiredStringParameter("inpcWorkcalendarsettingsId");
      
      String strNext = nextElement(vars, strC_Workcalendarsettings_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPAD_Org_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPAD_Org_ID = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");
      String strC_Workcalendarsettings_ID = vars.getRequiredStringParameter("inpcWorkcalendarsettingsId");
      
      String strPrevious = previousElement(vars, strC_Workcalendarsettings_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPAD_Org_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");

      vars.setSessionValue(tabId + "|CalendarSettings.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPAD_Org_ID = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|CalendarSettings.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|CalendarSettings.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|CalendarSettings.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_Workcalendarsettings_ID");
      vars.setSessionValue(windowId + "|AD_Org_ID", strPAD_Org_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPAD_Org_ID = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|CalendarSettings.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|CalendarSettings.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_Workcalendarsettings_ID");
      vars.setSessionValue(windowId + "|AD_Org_ID", strPAD_Org_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPAD_Org_ID = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPAD_Org_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPAD_Org_ID = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPAD_Org_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPAD_Org_ID = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPAD_Org_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPAD_Org_ID = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPAD_Org_ID);      
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
      String strPAD_Org_ID = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");
      String strC_Workcalendarsettings_ID = vars.getRequiredGlobalVariable("inpcWorkcalendarsettingsId", windowId + "|C_Workcalendarsettings_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPAD_Org_ID);      
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
          String strNext = nextElement(vars, strC_Workcalendarsettings_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_Workcalendarsettings_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPAD_Org_ID = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");

      String strC_Workcalendarsettings_ID = vars.getRequiredInStringParameter("inpcWorkcalendarsettingsId");
      String message = deleteRelation(vars, strC_Workcalendarsettings_ID, strPAD_Org_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cWorkcalendarsettingsId");
        vars.setSessionValue(tabId + "|CalendarSettings.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPAD_Org_ID = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");

      String strC_Workcalendarsettings_ID = vars.getRequiredStringParameter("inpcWorkcalendarsettingsId");
      //CalendarSettingsData data = getEditVariables(vars, strPAD_Org_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = CalendarSettingsData.delete(this, strC_Workcalendarsettings_ID, strPAD_Org_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cWorkcalendarsettingsId");
        vars.setSessionValue(tabId + "|CalendarSettings.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strC_Workcalendarsettings_ID, String strPAD_Org_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_Workcalendarsettings_ID.startsWith("(")) strC_Workcalendarsettings_ID = strC_Workcalendarsettings_ID.substring(1, strC_Workcalendarsettings_ID.length()-1);
      if (!strC_Workcalendarsettings_ID.equals("")) {
        strC_Workcalendarsettings_ID = Replace.replace(strC_Workcalendarsettings_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_Workcalendarsettings_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (CalendarSettingsData.deleteTransactional(conn, this, strKey, strPAD_Org_ID)==0) {
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
  private CalendarSettingsData getEditVariables(Connection con, VariablesSecureApp vars, String strPAD_Org_ID) throws IOException,ServletException {
    CalendarSettingsData data = new CalendarSettingsData();
    ServletException ex = null;
    try {
    data.cWorkcalendarsettingsId = vars.getRequestGlobalVariable("inpcWorkcalendarsettingsId", windowId + "|C_Workcalendarsettings_ID");     data.validfrom = vars.getStringParameter("inpvalidfrom");     data.isactive = vars.getStringParameter("inpisactive", "N");    try {   data.worktimemonday = vars.getNumericParameter("inpworktimemonday");  } catch (ServletException paramEx) { ex = paramEx; }     data.workbegintimemonday = vars.getStringParameter("inpworkbegintimemonday");    try {   data.worktimetuesday = vars.getNumericParameter("inpworktimetuesday");  } catch (ServletException paramEx) { ex = paramEx; }     data.workbegintimetuesday = vars.getStringParameter("inpworkbegintimetuesday");    try {   data.worktimewednesday = vars.getNumericParameter("inpworktimewednesday");  } catch (ServletException paramEx) { ex = paramEx; }     data.workbegintimewednesday = vars.getStringParameter("inpworkbegintimewednesday");    try {   data.worktimethursday = vars.getNumericParameter("inpworktimethursday");  } catch (ServletException paramEx) { ex = paramEx; }     data.workbegintimethursday = vars.getStringParameter("inpworkbegintimethursday");    try {   data.worktimefriday = vars.getNumericParameter("inpworktimefriday");  } catch (ServletException paramEx) { ex = paramEx; }     data.workbegintimefriday = vars.getStringParameter("inpworkbegintimefriday");    try {   data.worktimesaturday = vars.getNumericParameter("inpworktimesaturday");  } catch (ServletException paramEx) { ex = paramEx; }     data.workbegintimesaturday = vars.getStringParameter("inpworkbegintimesaturday");    try {   data.worktimesunday = vars.getNumericParameter("inpworktimesunday");  } catch (ServletException paramEx) { ex = paramEx; }     data.workbegintimesunday = vars.getStringParameter("inpworkbegintimesunday");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.adOrgId = vars.getGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");


    
    

    
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

   private CalendarSettingsData[] getRelationData(CalendarSettingsData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].cWorkcalendarsettingsId = FormatUtilities.truncate(data[i].cWorkcalendarsettingsId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPAD_Org_ID) throws IOException,ServletException {
      OrganizationData[] data = OrganizationData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), Utility.getContext(this, vars, "AD_CLIENT_ID", windowId), strPAD_Org_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|C_Calendar_ID", data[0].cCalendarId);    vars.setSessionValue(windowId + "|IsPeriodControlAllowed", data[0].isperiodcontrolallowed);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);
      vars.setSessionValue(windowId + "|AD_Org_ID", strPAD_Org_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
      vars.setSessionValue(windowId + "|ISPERIODCONTROLALLOWED_AUX", OrganizationData.selectAuxCA8005C0F23945E89C4AD3C7899E5E89(this, strPAD_Org_ID));
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strC_Workcalendarsettings_ID) throws ServletException {
    String strPAD_Org_ID = CalendarSettingsData.selectParentID(this, strC_Workcalendarsettings_ID);
    if (strPAD_Org_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strC_Workcalendarsettings_ID);
      throw new ServletException("Parent record not found");
    }
    return strPAD_Org_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|C_Workcalendarsettings_ID", data[0].getField("cWorkcalendarsettingsId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPAD_Org_ID) throws IOException,ServletException {
      CalendarSettingsData[] data = CalendarSettingsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPAD_Org_ID, vars.getStringParameter("inpcWorkcalendarsettingsId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPAD_Org_ID, String strC_Workcalendarsettings_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamValidfrom = vars.getSessionValue(tabId + "|paramValidfrom");
String strParamValidfrom_f = vars.getSessionValue(tabId + "|paramValidfrom_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamValidfrom.equals("") && strParamValidfrom_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_Workcalendarsettings_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_Workcalendarsettings_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/Organization/CalendarSettings_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "CalendarSettings", false, "document.frmMain.inpcWorkcalendarsettingsId", "grid", "..", "".equals("Y"), "Organization", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPAD_Org_ID);

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
    xmlDocument.setParameter("KeyName", "cWorkcalendarsettingsId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "CalendarSettings_Relation.html", "Organization", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "CalendarSettings_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", CalendarSettingsData.selectParent(this, strPAD_Org_ID));
    else xmlDocument.setParameter("parent", CalendarSettingsData.selectParentTrl(this, strPAD_Org_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_Workcalendarsettings_ID, String strPAD_Org_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " C_WORKCALENDARSETTINGS.validfrom asc";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    CalendarSettingsData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamValidfrom = vars.getSessionValue(tabId + "|paramValidfrom");
String strParamValidfrom_f = vars.getSessionValue(tabId + "|paramValidfrom_f");

    boolean hasSearchCondition=false;
    if (!(strParamValidfrom.equals("") && strParamValidfrom_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = CalendarSettingsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPAD_Org_ID, strC_Workcalendarsettings_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_Workcalendarsettings_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new CalendarSettingsData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cWorkcalendarsettingsId") == null || dataField.getField("cWorkcalendarsettingsId").equals("")) {
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
        refreshSessionNew(vars, strPAD_Org_ID);
        data = CalendarSettingsData.set(strPAD_Org_ID, Utility.getDefault(this, vars, "Updatedby", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField), CalendarSettingsData.selectDef50AE782B0ACB4EDFB29D44B544BFCBF8_0(this, Utility.getDefault(this, vars, "Updatedby", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField)), Utility.getDefault(this, vars, "Workbegintimesaturday", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField), Utility.getDefault(this, vars, "Worktimewednesday", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField), Utility.getDefault(this, vars, "Worktimemonday", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField), Utility.getDefault(this, vars, "Workbegintimethursday", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField), Utility.getDefault(this, vars, "Worktimetuesday", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField), Utility.getDefault(this, vars, "Validfrom", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField), "Y", Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField), CalendarSettingsData.selectDef8D9D62329EC24703AC22005A8A86C4CF_1(this, Utility.getDefault(this, vars, "Createdby", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField)), Utility.getDefault(this, vars, "Workbegintimesunday", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField), Utility.getDefault(this, vars, "Worktimefriday", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField), Utility.getDefault(this, vars, "Workbegintimewednesday", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField), "", Utility.getDefault(this, vars, "Workbegintimefriday", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField), Utility.getDefault(this, vars, "Worktimesaturday", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField), Utility.getDefault(this, vars, "Worktimethursday", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField), Utility.getDefault(this, vars, "Worktimesunday", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField), Utility.getDefault(this, vars, "Workbegintimemonday", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField), Utility.getDefault(this, vars, "Workbegintimetuesday", "", "110", "FA369E65EE864BCE86AE1DBA330BA244", "", dataField));
        
      }
    } else {
      data = new CalendarSettingsData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(CalendarSettingsData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=OrganizationData.selectOrg(this, strPAD_Org_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "CalendarSettings", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcWorkcalendarsettingsId", "", "..", "".equals("Y"), "Organization", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_Workcalendarsettings_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPAD_Org_ID) throws IOException, ServletException {
    CalendarSettingsData data = null;
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
            data = getEditVariables(con, vars, strPAD_Org_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.cWorkcalendarsettingsId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId) ){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (CalendarSettingsData.getCurrentDBTimestamp(this, data.cWorkcalendarsettingsId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cWorkcalendarsettingsId, vars, this);
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
                    data.cWorkcalendarsettingsId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_Workcalendarsettings_ID", data.cWorkcalendarsettingsId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet CalendarSettings. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
