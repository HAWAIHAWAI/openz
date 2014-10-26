
package org.openbravo.erpWindows.org.openz.timeservice.MachineFeedback;





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

public class MachineFeedback01AD76C0516B4D5591C348C6A118F21F extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(MachineFeedback01AD76C0516B4D5591C348C6A118F21F.class);
  
  private static final String windowId = "A5D5CE0CDB8E414F8A7A107B96C4ABA8";
  private static final String tabId = "01AD76C0516B4D5591C348C6A118F21F";
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
        String strzspmPtaskfeedbacklineId = request.getParameter("inpzspmPtaskfeedbacklineId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strzspmPtaskfeedbacklineId.equals(""))
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

      String strZspm_Ptaskfeedbackline_ID = vars.getGlobalVariable("inpzspmPtaskfeedbacklineId", windowId + "|Zspm_Ptaskfeedbackline_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|MachineFeedback01AD76C0516B4D5591C348C6A118F21F.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strZspm_Ptaskfeedbackline_ID.equals("")) strZspm_Ptaskfeedbackline_ID = firstElement(vars, tableSQL);
          if (strZspm_Ptaskfeedbackline_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZspm_Ptaskfeedbackline_ID, tableSQL);

      else printPageDataSheet(response, vars, strZspm_Ptaskfeedbackline_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strZspm_Ptaskfeedbackline_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strZspm_Ptaskfeedbackline_ID.equals("")) strZspm_Ptaskfeedbackline_ID = vars.getRequiredGlobalVariable("inpzspmPtaskfeedbacklineId", windowId + "|Zspm_Ptaskfeedbackline_ID");
      else vars.setSessionValue(windowId + "|Zspm_Ptaskfeedbackline_ID", strZspm_Ptaskfeedbackline_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|MachineFeedback01AD76C0516B4D5591C348C6A118F21F.view", "EDIT");

        printPageEdit(response, request, vars, false, strZspm_Ptaskfeedbackline_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|MachineFeedback01AD76C0516B4D5591C348C6A118F21F.view", "RELATION");
        printPageDataSheet(response, vars, strZspm_Ptaskfeedbackline_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|MachineFeedback01AD76C0516B4D5591C348C6A118F21F.view");
      String strZspm_Ptaskfeedbackline_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strZspm_Ptaskfeedbackline_ID = firstElement(vars, tableSQL);
          if (strZspm_Ptaskfeedbackline_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strZspm_Ptaskfeedbackline_ID.equals("")) strZspm_Ptaskfeedbackline_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strZspm_Ptaskfeedbackline_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamC_Project_ID", tabId + "|paramC_Project_ID");
vars.getRequestGlobalVariable("inpParamC_Projecttask_ID", tabId + "|paramC_Projecttask_ID");
vars.getRequestGlobalVariable("inpParamWorkdate", tabId + "|paramWorkdate");
vars.getRequestGlobalVariable("inpParamMA_Machine_ID", tabId + "|paramMA_Machine_ID");
vars.getRequestGlobalVariable("inpParamDescription", tabId + "|paramDescription");
vars.getRequestGlobalVariable("inpParamHours", tabId + "|paramHours");
vars.getRequestGlobalVariable("inpParamWorkdate_f", tabId + "|paramWorkdate_f");
vars.getRequestGlobalVariable("inpParamHours_f", tabId + "|paramHours_f");

      
      
      vars.removeSessionValue(windowId + "|Zspm_Ptaskfeedbackline_ID");
      String strZspm_Ptaskfeedbackline_ID="";

      String strView = vars.getSessionValue(tabId + "|MachineFeedback01AD76C0516B4D5591C348C6A118F21F.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strZspm_Ptaskfeedbackline_ID = firstElement(vars, tableSQL);
        if (strZspm_Ptaskfeedbackline_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|MachineFeedback01AD76C0516B4D5591C348C6A118F21F.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZspm_Ptaskfeedbackline_ID, tableSQL);

      else printPageDataSheet(response, vars, strZspm_Ptaskfeedbackline_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strZspm_Ptaskfeedbackline_ID = vars.getGlobalVariable("inpzspmPtaskfeedbacklineId", windowId + "|Zspm_Ptaskfeedbackline_ID", "");
      vars.setSessionValue(tabId + "|MachineFeedback01AD76C0516B4D5591C348C6A118F21F.view", "RELATION");
      printPageDataSheet(response, vars, strZspm_Ptaskfeedbackline_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strZspm_Ptaskfeedbackline_ID = vars.getGlobalVariable("inpzspmPtaskfeedbacklineId", windowId + "|Zspm_Ptaskfeedbackline_ID", "");
      vars.setSessionValue(tabId + "|MachineFeedback01AD76C0516B4D5591C348C6A118F21F.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strZspm_Ptaskfeedbackline_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strZspm_Ptaskfeedbackline_ID = vars.getRequiredStringParameter("inpzspmPtaskfeedbacklineId");
      
      String strNext = nextElement(vars, strZspm_Ptaskfeedbackline_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strZspm_Ptaskfeedbackline_ID = vars.getRequiredStringParameter("inpzspmPtaskfeedbacklineId");
      
      String strPrevious = previousElement(vars, strZspm_Ptaskfeedbackline_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|MachineFeedback01AD76C0516B4D5591C348C6A118F21F.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|MachineFeedback01AD76C0516B4D5591C348C6A118F21F.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|MachineFeedback01AD76C0516B4D5591C348C6A118F21F.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|MachineFeedback01AD76C0516B4D5591C348C6A118F21F.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Zspm_Ptaskfeedbackline_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|MachineFeedback01AD76C0516B4D5591C348C6A118F21F.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|MachineFeedback01AD76C0516B4D5591C348C6A118F21F.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Zspm_Ptaskfeedbackline_ID");

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

      String strZspm_Ptaskfeedbackline_ID = vars.getRequiredGlobalVariable("inpzspmPtaskfeedbacklineId", windowId + "|Zspm_Ptaskfeedbackline_ID");
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
          String strNext = nextElement(vars, strZspm_Ptaskfeedbackline_ID, tableSQL);
          vars.setSessionValue(windowId + "|Zspm_Ptaskfeedbackline_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strZspm_Ptaskfeedbackline_ID = vars.getRequiredInStringParameter("inpzspmPtaskfeedbacklineId");
      String message = deleteRelation(vars, strZspm_Ptaskfeedbackline_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|zspmPtaskfeedbacklineId");
        vars.setSessionValue(tabId + "|MachineFeedback01AD76C0516B4D5591C348C6A118F21F.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strZspm_Ptaskfeedbackline_ID = vars.getRequiredStringParameter("inpzspmPtaskfeedbacklineId");
      //MachineFeedback01AD76C0516B4D5591C348C6A118F21FData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = MachineFeedback01AD76C0516B4D5591C348C6A118F21FData.delete(this, strZspm_Ptaskfeedbackline_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|zspmPtaskfeedbacklineId");
        vars.setSessionValue(tabId + "|MachineFeedback01AD76C0516B4D5591C348C6A118F21F.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strZspm_Ptaskfeedbackline_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strZspm_Ptaskfeedbackline_ID.startsWith("(")) strZspm_Ptaskfeedbackline_ID = strZspm_Ptaskfeedbackline_ID.substring(1, strZspm_Ptaskfeedbackline_ID.length()-1);
      if (!strZspm_Ptaskfeedbackline_ID.equals("")) {
        strZspm_Ptaskfeedbackline_ID = Replace.replace(strZspm_Ptaskfeedbackline_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strZspm_Ptaskfeedbackline_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (MachineFeedback01AD76C0516B4D5591C348C6A118F21FData.deleteTransactional(conn, this, strKey)==0) {
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
  private MachineFeedback01AD76C0516B4D5591C348C6A118F21FData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    MachineFeedback01AD76C0516B4D5591C348C6A118F21FData data = new MachineFeedback01AD76C0516B4D5591C348C6A118F21FData();
    ServletException ex = null;
    try {
    data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.zspmPtaskfeedbacklineId = vars.getRequestGlobalVariable("inpzspmPtaskfeedbacklineId", windowId + "|Zspm_Ptaskfeedbackline_ID");     data.workdate = vars.getStringParameter("inpworkdate");     data.cProjectId = vars.getRequestGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.cProjecttaskId = vars.getRequestGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.maMachineId = vars.getStringParameter("inpmaMachineId");     data.maMachineIdr = vars.getStringParameter("inpmaMachineId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");    try {   data.hours = vars.getNumericParameter("inphours");  } catch (ServletException paramEx) { ex = paramEx; }     data.costuom = vars.getStringParameter("inpcostuom");     data.costuomr = vars.getStringParameter("inpcostuom_R");     data.cCalendareventId = vars.getStringParameter("inpcCalendareventId");     data.cCalendareventIdr = vars.getStringParameter("inpcCalendareventId_R");     data.description = vars.getStringParameter("inpdescription");    try {   data.actualcostamount = vars.getNumericParameter("inpactualcostamount");  } catch (ServletException paramEx) { ex = paramEx; }     data.hourFrom = vars.getStringParameter("inphourFrom");     data.hourTo = vars.getStringParameter("inphourTo");     data.dayhours = vars.getStringParameter("inpdayhours"); 
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

   private MachineFeedback01AD76C0516B4D5591C348C6A118F21FData[] getRelationData(MachineFeedback01AD76C0516B4D5591C348C6A118F21FData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].zspmPtaskfeedbacklineId = FormatUtilities.truncate(data[i].zspmPtaskfeedbacklineId, 32);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 37);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].maMachineId = FormatUtilities.truncate(data[i].maMachineId, 32);        data[i].costuom = FormatUtilities.truncate(data[i].costuom, 50);        data[i].cCalendareventId = FormatUtilities.truncate(data[i].cCalendareventId, 32);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].dayhours = FormatUtilities.truncate(data[i].dayhours, 10);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Zspm_Ptaskfeedbackline_ID", data[0].getField("zspmPtaskfeedbacklineId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|C_Project_ID", data[0].getField("cProjectId"));    vars.setSessionValue(windowId + "|C_ProjectTask_ID", data[0].getField("cProjecttaskId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      MachineFeedback01AD76C0516B4D5591C348C6A118F21FData[] data = MachineFeedback01AD76C0516B4D5591C348C6A118F21FData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpzspmPtaskfeedbacklineId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strZspm_Ptaskfeedbackline_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamC_Projecttask_ID = vars.getSessionValue(tabId + "|paramC_Projecttask_ID");
String strParamWorkdate = vars.getSessionValue(tabId + "|paramWorkdate");
String strParamMA_Machine_ID = vars.getSessionValue(tabId + "|paramMA_Machine_ID");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamHours = vars.getSessionValue(tabId + "|paramHours");
String strParamWorkdate_f = vars.getSessionValue(tabId + "|paramWorkdate_f");
String strParamHours_f = vars.getSessionValue(tabId + "|paramHours_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamC_Project_ID.equals("") && strParamC_Projecttask_ID.equals("") && strParamWorkdate.equals("") && strParamMA_Machine_ID.equals("") && strParamDescription.equals("") && strParamHours.equals("") && strParamWorkdate_f.equals("") && strParamHours_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strZspm_Ptaskfeedbackline_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strZspm_Ptaskfeedbackline_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openz/timeservice/MachineFeedback/MachineFeedback01AD76C0516B4D5591C348C6A118F21F_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "MachineFeedback01AD76C0516B4D5591C348C6A118F21F", false, "document.frmMain.inpzspmPtaskfeedbacklineId", "grid", "..", "".equals("Y"), "MachineFeedback", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "zspmPtaskfeedbacklineId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "MachineFeedback01AD76C0516B4D5591C348C6A118F21F_Relation.html", "MachineFeedback", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "MachineFeedback01AD76C0516B4D5591C348C6A118F21F_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strZspm_Ptaskfeedbackline_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " zspm_ptaskfeedbackline.Workdate";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    MachineFeedback01AD76C0516B4D5591C348C6A118F21FData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamC_Projecttask_ID = vars.getSessionValue(tabId + "|paramC_Projecttask_ID");
String strParamWorkdate = vars.getSessionValue(tabId + "|paramWorkdate");
String strParamMA_Machine_ID = vars.getSessionValue(tabId + "|paramMA_Machine_ID");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamHours = vars.getSessionValue(tabId + "|paramHours");
String strParamWorkdate_f = vars.getSessionValue(tabId + "|paramWorkdate_f");
String strParamHours_f = vars.getSessionValue(tabId + "|paramHours_f");

    boolean hasSearchCondition=false;
    if (!(strParamC_Project_ID.equals("") && strParamC_Projecttask_ID.equals("") && strParamWorkdate.equals("") && strParamMA_Machine_ID.equals("") && strParamDescription.equals("") && strParamHours.equals("") && strParamWorkdate_f.equals("") && strParamHours_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = MachineFeedback01AD76C0516B4D5591C348C6A118F21FData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strZspm_Ptaskfeedbackline_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strZspm_Ptaskfeedbackline_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new MachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("zspmPtaskfeedbacklineId") == null || dataField.getField("zspmPtaskfeedbacklineId").equals("")) {
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
        data = MachineFeedback01AD76C0516B4D5591C348C6A118F21FData.set(Utility.getDefault(this, vars, "Workdate", "@#Date@", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField), Utility.getDefault(this, vars, "Hour_To", "", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField), Utility.getDefault(this, vars, "C_Project_ID", "", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField), MachineFeedback01AD76C0516B4D5591C348C6A118F21FData.selectDef0F48330170E44E77BA40C4084A431884_0(this, Utility.getDefault(this, vars, "C_Project_ID", "", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField)), Utility.getDefault(this, vars, "C_Calendarevent_ID", "", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField), Utility.getDefault(this, vars, "Description", "", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField), "Y", Utility.getDefault(this, vars, "Dayhours", "", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField), Utility.getDefault(this, vars, "Actualcostamount", "", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField), MachineFeedback01AD76C0516B4D5591C348C6A118F21FData.selectDef91F75684F9FA4CFE9AFFA6E3A4C52E7A_1(this, Utility.getDefault(this, vars, "Updatedby", "", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField)), "", Utility.getDefault(this, vars, "Hours", "", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField), MachineFeedback01AD76C0516B4D5591C348C6A118F21FData.selectDefECFFEA70E45840F78F27B8164CFB6BA6_2(this, Utility.getDefault(this, vars, "Createdby", "", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField)), Utility.getDefault(this, vars, "C_Projecttask_ID", "", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField), Utility.getDefault(this, vars, "Hour_From", "", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField), Utility.getDefault(this, vars, "Costuom", "H", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField), Utility.getDefault(this, vars, "MA_Machine_ID", "", "A5D5CE0CDB8E414F8A7A107B96C4ABA8", "01AD76C0516B4D5591C348C6A118F21F", "", dataField));
        
      }
    } else {
      data = new MachineFeedback01AD76C0516B4D5591C348C6A118F21FData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(MachineFeedback01AD76C0516B4D5591C348C6A118F21FData) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "MachineFeedback01AD76C0516B4D5591C348C6A118F21F", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpzspmPtaskfeedbacklineId", "", "..", "".equals("Y"), "MachineFeedback", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strZspm_Ptaskfeedbackline_ID));
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
    MachineFeedback01AD76C0516B4D5591C348C6A118F21FData data = null;
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
                data.zspmPtaskfeedbacklineId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (MachineFeedback01AD76C0516B4D5591C348C6A118F21FData.getCurrentDBTimestamp(this, data.zspmPtaskfeedbacklineId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.zspmPtaskfeedbacklineId, vars, this);
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
                    data.zspmPtaskfeedbacklineId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Zspm_Ptaskfeedbackline_ID", data.zspmPtaskfeedbacklineId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet MachineFeedback01AD76C0516B4D5591C348C6A118F21F. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
