
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

public class RadiogroupInstanceSpecificSettings extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(RadiogroupInstanceSpecificSettings.class);
  
  private static final String windowId = "101";
  private static final String tabId = "14906347AE8A4FFABBFE27D7374D6399";
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
        String stradRefRadiogroupInstanceId = request.getParameter("inpadRefRadiogroupInstanceId");
         String strPAD_Ref_Radiogroup_ID = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !stradRefRadiogroupInstanceId.equals(""))
              total = saveRecord(vars, myError, 'U', strPAD_Ref_Radiogroup_ID);
          else
              total = saveRecord(vars, myError, 'I', strPAD_Ref_Radiogroup_ID);
          
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
      String strPAD_Ref_Radiogroup_ID = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID", "");

      String strAD_Ref_Radiogroup_Instance_ID = vars.getGlobalVariable("inpadRefRadiogroupInstanceId", windowId + "|AD_Ref_Radiogroup_Instance_ID", "");
            if (strPAD_Ref_Radiogroup_ID.equals("")) {
        strPAD_Ref_Radiogroup_ID = getParentID(vars, strAD_Ref_Radiogroup_Instance_ID);
        if (strPAD_Ref_Radiogroup_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|AD_Ref_Radiogroup_ID");
        vars.setSessionValue(windowId + "|AD_Ref_Radiogroup_ID", strPAD_Ref_Radiogroup_ID);
      vars.removeSessionValue(windowId + "|AD_Ref_Fieldcolumn_ID");
        refreshParentSession(vars, strPAD_Ref_Radiogroup_ID);
      }


      String strView = vars.getSessionValue(tabId + "|RadiogroupInstanceSpecificSettings.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strAD_Ref_Radiogroup_Instance_ID.equals("")) strAD_Ref_Radiogroup_Instance_ID = firstElement(vars, tableSQL);
          if (strAD_Ref_Radiogroup_Instance_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strAD_Ref_Radiogroup_Instance_ID, strPAD_Ref_Radiogroup_ID, tableSQL);

      else printPageDataSheet(response, vars, strPAD_Ref_Radiogroup_ID, strAD_Ref_Radiogroup_Instance_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strAD_Ref_Radiogroup_Instance_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strAD_Ref_Radiogroup_Instance_ID.equals("")) strAD_Ref_Radiogroup_Instance_ID = vars.getRequiredGlobalVariable("inpadRefRadiogroupInstanceId", windowId + "|AD_Ref_Radiogroup_Instance_ID");
      else vars.setSessionValue(windowId + "|AD_Ref_Radiogroup_Instance_ID", strAD_Ref_Radiogroup_Instance_ID);
      
      
      String strPAD_Ref_Radiogroup_ID = getParentID(vars, strAD_Ref_Radiogroup_Instance_ID);
      
      vars.setSessionValue(windowId + "|AD_Ref_Radiogroup_ID", strPAD_Ref_Radiogroup_ID);
      vars.setSessionValue("2661414F94D24A5A93FAFCD0D911FFA4|Radio Group Definition.view", "EDIT");
      vars.removeSessionValue(windowId + "|AD_Ref_Fieldcolumn_ID");
      refreshParentSession(vars, strPAD_Ref_Radiogroup_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|RadiogroupInstanceSpecificSettings.view", "EDIT");

        printPageEdit(response, request, vars, false, strAD_Ref_Radiogroup_Instance_ID, strPAD_Ref_Radiogroup_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|RadiogroupInstanceSpecificSettings.view", "RELATION");
        printPageDataSheet(response, vars, strPAD_Ref_Radiogroup_ID, strAD_Ref_Radiogroup_Instance_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPAD_Ref_Radiogroup_ID = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|AD_Ref_Radiogroup_Instance_ID");
      refreshParentSession(vars, strPAD_Ref_Radiogroup_ID);


      String strView = vars.getSessionValue(tabId + "|RadiogroupInstanceSpecificSettings.view");
      String strAD_Ref_Radiogroup_Instance_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strAD_Ref_Radiogroup_Instance_ID = firstElement(vars, tableSQL);
          if (strAD_Ref_Radiogroup_Instance_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strAD_Ref_Radiogroup_Instance_ID.equals("")) strAD_Ref_Radiogroup_Instance_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strAD_Ref_Radiogroup_Instance_ID, strPAD_Ref_Radiogroup_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPAD_Ref_Radiogroup_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamAD_Ref_Radiogroup_ID", tabId + "|paramAD_Ref_Radiogroup_ID");
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");

            String strPAD_Ref_Radiogroup_ID = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID");

      
      vars.removeSessionValue(windowId + "|AD_Ref_Radiogroup_Instance_ID");
      String strAD_Ref_Radiogroup_Instance_ID="";

      String strView = vars.getSessionValue(tabId + "|RadiogroupInstanceSpecificSettings.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strAD_Ref_Radiogroup_Instance_ID = firstElement(vars, tableSQL);
        if (strAD_Ref_Radiogroup_Instance_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|RadiogroupInstanceSpecificSettings.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strAD_Ref_Radiogroup_Instance_ID, strPAD_Ref_Radiogroup_ID, tableSQL);

      else printPageDataSheet(response, vars, strPAD_Ref_Radiogroup_ID, strAD_Ref_Radiogroup_Instance_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPAD_Ref_Radiogroup_ID = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID");
      

      String strAD_Ref_Radiogroup_Instance_ID = vars.getGlobalVariable("inpadRefRadiogroupInstanceId", windowId + "|AD_Ref_Radiogroup_Instance_ID", "");
      vars.setSessionValue(tabId + "|RadiogroupInstanceSpecificSettings.view", "RELATION");
      printPageDataSheet(response, vars, strPAD_Ref_Radiogroup_ID, strAD_Ref_Radiogroup_Instance_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPAD_Ref_Radiogroup_ID = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID");


      printPageEdit(response, request, vars, true, "", strPAD_Ref_Radiogroup_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPAD_Ref_Radiogroup_ID = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strAD_Ref_Radiogroup_Instance_ID = vars.getGlobalVariable("inpadRefRadiogroupInstanceId", windowId + "|AD_Ref_Radiogroup_Instance_ID", "");
      vars.setSessionValue(tabId + "|RadiogroupInstanceSpecificSettings.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strAD_Ref_Radiogroup_Instance_ID, strPAD_Ref_Radiogroup_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPAD_Ref_Radiogroup_ID = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID");
      String strAD_Ref_Radiogroup_Instance_ID = vars.getRequiredStringParameter("inpadRefRadiogroupInstanceId");
      
      String strNext = nextElement(vars, strAD_Ref_Radiogroup_Instance_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPAD_Ref_Radiogroup_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPAD_Ref_Radiogroup_ID = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID");
      String strAD_Ref_Radiogroup_Instance_ID = vars.getRequiredStringParameter("inpadRefRadiogroupInstanceId");
      
      String strPrevious = previousElement(vars, strAD_Ref_Radiogroup_Instance_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPAD_Ref_Radiogroup_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID");

      vars.setSessionValue(tabId + "|RadiogroupInstanceSpecificSettings.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPAD_Ref_Radiogroup_ID = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|RadiogroupInstanceSpecificSettings.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|RadiogroupInstanceSpecificSettings.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|RadiogroupInstanceSpecificSettings.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|AD_Ref_Radiogroup_Instance_ID");
      vars.setSessionValue(windowId + "|AD_Ref_Radiogroup_ID", strPAD_Ref_Radiogroup_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPAD_Ref_Radiogroup_ID = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|RadiogroupInstanceSpecificSettings.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|RadiogroupInstanceSpecificSettings.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|AD_Ref_Radiogroup_Instance_ID");
      vars.setSessionValue(windowId + "|AD_Ref_Radiogroup_ID", strPAD_Ref_Radiogroup_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPAD_Ref_Radiogroup_ID = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPAD_Ref_Radiogroup_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPAD_Ref_Radiogroup_ID = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPAD_Ref_Radiogroup_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPAD_Ref_Radiogroup_ID = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPAD_Ref_Radiogroup_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPAD_Ref_Radiogroup_ID = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPAD_Ref_Radiogroup_ID);      
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
      String strPAD_Ref_Radiogroup_ID = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID");
      String strAD_Ref_Radiogroup_Instance_ID = vars.getRequiredGlobalVariable("inpadRefRadiogroupInstanceId", windowId + "|AD_Ref_Radiogroup_Instance_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPAD_Ref_Radiogroup_ID);      
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
          String strNext = nextElement(vars, strAD_Ref_Radiogroup_Instance_ID, tableSQL);
          vars.setSessionValue(windowId + "|AD_Ref_Radiogroup_Instance_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPAD_Ref_Radiogroup_ID = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID");

      String strAD_Ref_Radiogroup_Instance_ID = vars.getRequiredInStringParameter("inpadRefRadiogroupInstanceId");
      String message = deleteRelation(vars, strAD_Ref_Radiogroup_Instance_ID, strPAD_Ref_Radiogroup_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|adRefRadiogroupInstanceId");
        vars.setSessionValue(tabId + "|RadiogroupInstanceSpecificSettings.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPAD_Ref_Radiogroup_ID = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID");

      String strAD_Ref_Radiogroup_Instance_ID = vars.getRequiredStringParameter("inpadRefRadiogroupInstanceId");
      //RadiogroupInstanceSpecificSettingsData data = getEditVariables(vars, strPAD_Ref_Radiogroup_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = RadiogroupInstanceSpecificSettingsData.delete(this, strAD_Ref_Radiogroup_Instance_ID, strPAD_Ref_Radiogroup_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|adRefRadiogroupInstanceId");
        vars.setSessionValue(tabId + "|RadiogroupInstanceSpecificSettings.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strAD_Ref_Radiogroup_Instance_ID, String strPAD_Ref_Radiogroup_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strAD_Ref_Radiogroup_Instance_ID.startsWith("(")) strAD_Ref_Radiogroup_Instance_ID = strAD_Ref_Radiogroup_Instance_ID.substring(1, strAD_Ref_Radiogroup_Instance_ID.length()-1);
      if (!strAD_Ref_Radiogroup_Instance_ID.equals("")) {
        strAD_Ref_Radiogroup_Instance_ID = Replace.replace(strAD_Ref_Radiogroup_Instance_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strAD_Ref_Radiogroup_Instance_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (RadiogroupInstanceSpecificSettingsData.deleteTransactional(conn, this, strKey, strPAD_Ref_Radiogroup_ID)==0) {
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
  private RadiogroupInstanceSpecificSettingsData getEditVariables(Connection con, VariablesSecureApp vars, String strPAD_Ref_Radiogroup_ID) throws IOException,ServletException {
    RadiogroupInstanceSpecificSettingsData data = new RadiogroupInstanceSpecificSettingsData();
    ServletException ex = null;
    try {
    data.adRefRadiogroupInstanceId = vars.getRequestGlobalVariable("inpadRefRadiogroupInstanceId", windowId + "|AD_Ref_Radiogroup_Instance_ID");     data.adRefRadiogroupId = vars.getStringParameter("inpadRefRadiogroupId");     data.adRefRadiogroupIdr = vars.getStringParameter("inpadRefRadiogroupId_R");    try {   data.line = vars.getNumericParameter("inpline");  } catch (ServletException paramEx) { ex = paramEx; }     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.name = vars.getStringParameter("inpname");     data.value = vars.getStringParameter("inpvalue");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.isactive = vars.getStringParameter("inpisactive", "N"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.adRefRadiogroupId = vars.getGlobalVariable("inpadRefRadiogroupId", windowId + "|AD_Ref_Radiogroup_ID");


    
    

    
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

   private RadiogroupInstanceSpecificSettingsData[] getRelationData(RadiogroupInstanceSpecificSettingsData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adRefRadiogroupInstanceId = FormatUtilities.truncate(data[i].adRefRadiogroupInstanceId, 32);        data[i].adRefRadiogroupId = FormatUtilities.truncate(data[i].adRefRadiogroupId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].value = FormatUtilities.truncate(data[i].value, 20);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPAD_Ref_Radiogroup_ID) throws IOException,ServletException {
      RadioGroupDefinitionData[] data = RadioGroupDefinitionData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getSessionValue(windowId + "|AD_Ref_Fieldcolumn_ID"), strPAD_Ref_Radiogroup_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Ref_Radiogroup_ID", data[0].adRefRadiogroupId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);
      vars.setSessionValue(windowId + "|AD_Ref_Radiogroup_ID", strPAD_Ref_Radiogroup_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strAD_Ref_Radiogroup_Instance_ID) throws ServletException {
    String strPAD_Ref_Radiogroup_ID = RadiogroupInstanceSpecificSettingsData.selectParentID(this, strAD_Ref_Radiogroup_Instance_ID);
    if (strPAD_Ref_Radiogroup_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strAD_Ref_Radiogroup_Instance_ID);
      throw new ServletException("Parent record not found");
    }
    return strPAD_Ref_Radiogroup_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Ref_Radiogroup_Instance_ID", data[0].getField("adRefRadiogroupInstanceId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPAD_Ref_Radiogroup_ID) throws IOException,ServletException {
      RadiogroupInstanceSpecificSettingsData[] data = RadiogroupInstanceSpecificSettingsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPAD_Ref_Radiogroup_ID, vars.getStringParameter("inpadRefRadiogroupInstanceId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPAD_Ref_Radiogroup_ID, String strAD_Ref_Radiogroup_Instance_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamAD_Ref_Radiogroup_ID = vars.getSessionValue(tabId + "|paramAD_Ref_Radiogroup_ID");
String strParamName = vars.getSessionValue(tabId + "|paramName");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamAD_Ref_Radiogroup_ID.equals("") && strParamName.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strAD_Ref_Radiogroup_Instance_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strAD_Ref_Radiogroup_Instance_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/Reference/RadiogroupInstanceSpecificSettings_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "RadiogroupInstanceSpecificSettings", false, "document.frmMain.inpadRefRadiogroupInstanceId", "grid", "..", "".equals("Y"), "Reference", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPAD_Ref_Radiogroup_ID);

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
    xmlDocument.setParameter("KeyName", "adRefRadiogroupInstanceId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "RadiogroupInstanceSpecificSettings_Relation.html", "Reference", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "RadiogroupInstanceSpecificSettings_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", RadiogroupInstanceSpecificSettingsData.selectParent(this, strPAD_Ref_Radiogroup_ID));
    else xmlDocument.setParameter("parent", RadiogroupInstanceSpecificSettingsData.selectParentTrl(this, strPAD_Ref_Radiogroup_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strAD_Ref_Radiogroup_Instance_ID, String strPAD_Ref_Radiogroup_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " ad_ref_radiogroup_instance.Value";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    RadiogroupInstanceSpecificSettingsData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamAD_Ref_Radiogroup_ID = vars.getSessionValue(tabId + "|paramAD_Ref_Radiogroup_ID");
String strParamName = vars.getSessionValue(tabId + "|paramName");

    boolean hasSearchCondition=false;
    if (!(strParamAD_Ref_Radiogroup_ID.equals("") && strParamName.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = RadiogroupInstanceSpecificSettingsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPAD_Ref_Radiogroup_ID, strAD_Ref_Radiogroup_Instance_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strAD_Ref_Radiogroup_Instance_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new RadiogroupInstanceSpecificSettingsData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("adRefRadiogroupInstanceId") == null || dataField.getField("adRefRadiogroupInstanceId").equals("")) {
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
        refreshSessionNew(vars, strPAD_Ref_Radiogroup_ID);
        data = RadiogroupInstanceSpecificSettingsData.set(strPAD_Ref_Radiogroup_ID, "Y", Utility.getDefault(this, vars, "Createdby", "", "101", "14906347AE8A4FFABBFE27D7374D6399", "", dataField), RadiogroupInstanceSpecificSettingsData.selectDef10013257F0344F6AA5F3E5600F46A4D3_0(this, Utility.getDefault(this, vars, "Createdby", "", "101", "14906347AE8A4FFABBFE27D7374D6399", "", dataField)), Utility.getDefault(this, vars, "Updatedby", "", "101", "14906347AE8A4FFABBFE27D7374D6399", "", dataField), RadiogroupInstanceSpecificSettingsData.selectDef87648F4B6D4F4FD18EBD6B69A8996B8B_1(this, Utility.getDefault(this, vars, "Updatedby", "", "101", "14906347AE8A4FFABBFE27D7374D6399", "", dataField)), Utility.getDefault(this, vars, "Line", "", "101", "14906347AE8A4FFABBFE27D7374D6399", "", dataField), Utility.getDefault(this, vars, "Value", "", "101", "14906347AE8A4FFABBFE27D7374D6399", "", dataField), "0", "", Utility.getDefault(this, vars, "Name", "", "101", "14906347AE8A4FFABBFE27D7374D6399", "", dataField), "0");
        
      }
    } else {
      data = new RadiogroupInstanceSpecificSettingsData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(RadiogroupInstanceSpecificSettingsData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=RadioGroupDefinitionData.selectOrg(this, strPAD_Ref_Radiogroup_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "RadiogroupInstanceSpecificSettings", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpadRefRadiogroupInstanceId", "", "..", "".equals("Y"), "Reference", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strAD_Ref_Radiogroup_Instance_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPAD_Ref_Radiogroup_ID) throws IOException, ServletException {
    RadiogroupInstanceSpecificSettingsData data = null;
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
            data = getEditVariables(con, vars, strPAD_Ref_Radiogroup_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.adRefRadiogroupInstanceId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (RadiogroupInstanceSpecificSettingsData.getCurrentDBTimestamp(this, data.adRefRadiogroupInstanceId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.adRefRadiogroupInstanceId, vars, this);
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
                    data.adRefRadiogroupInstanceId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|AD_Ref_Radiogroup_Instance_ID", data.adRefRadiogroupInstanceId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet RadiogroupInstanceSpecificSettings. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
