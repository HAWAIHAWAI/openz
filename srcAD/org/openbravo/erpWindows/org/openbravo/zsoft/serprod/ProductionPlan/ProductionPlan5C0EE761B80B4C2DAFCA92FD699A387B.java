
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.ProductionPlan;


import org.openbravo.erpCommon.reference.*;


import org.openbravo.erpCommon.ad_actionButton.*;



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

public class ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B.class);
  
  private static final String windowId = "3E801605DEA44BA0920CD7A8BB1A2A0B";
  private static final String tabId = "5C0EE761B80B4C2DAFCA92FD699A387B";
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
        String strzssmProductionplanVId = request.getParameter("inpzssmProductionplanVId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strzssmProductionplanVId.equals(""))
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

      String strZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strZssm_Productionplan_V_ID.equals("")) strZssm_Productionplan_V_ID = firstElement(vars, tableSQL);
          if (strZssm_Productionplan_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssm_Productionplan_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strZssm_Productionplan_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strZssm_Productionplan_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strZssm_Productionplan_V_ID.equals("")) strZssm_Productionplan_V_ID = vars.getRequiredGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");
      else vars.setSessionValue(windowId + "|Zssm_Productionplan_V_ID", strZssm_Productionplan_V_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B.view", "EDIT");

        printPageEdit(response, request, vars, false, strZssm_Productionplan_V_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B.view", "RELATION");
        printPageDataSheet(response, vars, strZssm_Productionplan_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B.view");
      String strZssm_Productionplan_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strZssm_Productionplan_V_ID = firstElement(vars, tableSQL);
          if (strZssm_Productionplan_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strZssm_Productionplan_V_ID.equals("")) strZssm_Productionplan_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strZssm_Productionplan_V_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamValue", tabId + "|paramValue");
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamDescription", tabId + "|paramDescription");
vars.getRequestGlobalVariable("inpParamNote", tabId + "|paramNote");
vars.getRequestGlobalVariable("inpParamIsActive", tabId + "|paramIsActive");
vars.getRequestGlobalVariable("inpParamProjectStatus", tabId + "|paramProjectStatus");
vars.getRequestGlobalVariable("inpParamResponsible_ID", tabId + "|paramResponsible_ID");

      
      
      vars.removeSessionValue(windowId + "|Zssm_Productionplan_V_ID");
      String strZssm_Productionplan_V_ID="";

      String strView = vars.getSessionValue(tabId + "|ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strZssm_Productionplan_V_ID = firstElement(vars, tableSQL);
        if (strZssm_Productionplan_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssm_Productionplan_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strZssm_Productionplan_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID", "");
      vars.setSessionValue(tabId + "|ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B.view", "RELATION");
      printPageDataSheet(response, vars, strZssm_Productionplan_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID", "");
      vars.setSessionValue(tabId + "|ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strZssm_Productionplan_V_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strZssm_Productionplan_V_ID = vars.getRequiredStringParameter("inpzssmProductionplanVId");
      
      String strNext = nextElement(vars, strZssm_Productionplan_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strZssm_Productionplan_V_ID = vars.getRequiredStringParameter("inpzssmProductionplanVId");
      
      String strPrevious = previousElement(vars, strZssm_Productionplan_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Zssm_Productionplan_V_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Zssm_Productionplan_V_ID");

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

      String strZssm_Productionplan_V_ID = vars.getRequiredGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");
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
          String strNext = nextElement(vars, strZssm_Productionplan_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|Zssm_Productionplan_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strZssm_Productionplan_V_ID = vars.getRequiredInStringParameter("inpzssmProductionplanVId");
      String message = deleteRelation(vars, strZssm_Productionplan_V_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|zssmProductionplanVId");
        vars.setSessionValue(tabId + "|ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strZssm_Productionplan_V_ID = vars.getRequiredStringParameter("inpzssmProductionplanVId");
      //ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.delete(this, strZssm_Productionplan_V_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|zssmProductionplanVId");
        vars.setSessionValue(tabId + "|ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONChangeProjectStatusEC001EF3DBFB414DAC79E871985CBF20")) {
        vars.setSessionValue("buttonEC001EF3DBFB414DAC79E871985CBF20.strchangeprojectstatus", vars.getStringParameter("inpchangeprojectstatus"));
        vars.setSessionValue("buttonEC001EF3DBFB414DAC79E871985CBF20.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonEC001EF3DBFB414DAC79E871985CBF20.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonEC001EF3DBFB414DAC79E871985CBF20.strClient", vars.getStringParameter("inpadClientId"));
        vars.setSessionValue("buttonEC001EF3DBFB414DAC79E871985CBF20.inpprojectstatus", vars.getRequiredStringParameter("inpprojectstatus"));

        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonEC001EF3DBFB414DAC79E871985CBF20.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "EC001EF3DBFB414DAC79E871985CBF20", request.getServletPath());    
     } else if (vars.commandIn("BUTTONEC001EF3DBFB414DAC79E871985CBF20")) {
        String strZssm_Productionplan_V_ID = vars.getGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID", "");
        String strchangeprojectstatus = vars.getSessionValue("buttonEC001EF3DBFB414DAC79E871985CBF20.strchangeprojectstatus");
        String strProcessing = vars.getSessionValue("buttonEC001EF3DBFB414DAC79E871985CBF20.strProcessing");
        String strOrg = vars.getSessionValue("buttonEC001EF3DBFB414DAC79E871985CBF20.strOrg");
        String strClient = vars.getSessionValue("buttonEC001EF3DBFB414DAC79E871985CBF20.strClient");
        
        String strprojectstatus = vars.getSessionValue("buttonEC001EF3DBFB414DAC79E871985CBF20.inpprojectstatus");

        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonChangeProjectStatusEC001EF3DBFB414DAC79E871985CBF20(response, vars, strZssm_Productionplan_V_ID, strchangeprojectstatus, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONChangeProjectStatusEC001EF3DBFB414DAC79E871985CBF20")) {
        String strZssm_Productionplan_V_ID = vars.getGlobalVariable("inpKey", windowId + "|Zssm_Productionplan_V_ID", "");
        @SuppressWarnings("unused")
        String strchangeprojectstatus = vars.getStringParameter("inpchangeprojectstatus");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "EC001EF3DBFB414DAC79E871985CBF20", (("Zssm_Productionplan_V_ID".equalsIgnoreCase("AD_Language"))?"0":strZssm_Productionplan_V_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          PInstanceProcessData.insertPInstanceParam(this, pinstance, "0", "ChangeProjectStatus", strchangeprojectstatus, vars.getClient(), vars.getOrg(), vars.getUser());

          
          ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
          new ProcessRunner(bundle).execute(this);
          
          PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
          myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
        } catch (ServletException ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myMessage);
        }
        //close popup
        if (myMessage!=null) {
          if (log4j.isDebugEnabled()) log4j.debug(myMessage.getMessage());
          vars.setMessage(tabId, myMessage);
        }
        printPageClosePopUp(response, vars);






    } else if (vars.getCommand().toUpperCase().startsWith("BUTTON") || vars.getCommand().toUpperCase().startsWith("SAVE_BUTTON")) {
      pageErrorPopUp(response);
    } else pageError(response);
  }
/*
  String deleteRelation(VariablesSecureApp vars, String strZssm_Productionplan_V_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strZssm_Productionplan_V_ID.startsWith("(")) strZssm_Productionplan_V_ID = strZssm_Productionplan_V_ID.substring(1, strZssm_Productionplan_V_ID.length()-1);
      if (!strZssm_Productionplan_V_ID.equals("")) {
        strZssm_Productionplan_V_ID = Replace.replace(strZssm_Productionplan_V_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strZssm_Productionplan_V_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.deleteTransactional(conn, this, strKey)==0) {
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
  private ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData data = new ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData();
    ServletException ex = null;
    try {
    data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.projectcategory = vars.getRequestGlobalVariable("inpprojectcategory", windowId + "|ProjectCategory");     data.projectcategoryr = vars.getStringParameter("inpprojectcategory_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.projectstatus = vars.getStringParameter("inpprojectstatus");     data.projectstatusr = vars.getStringParameter("inpprojectstatus_R");     data.isdefault = vars.getStringParameter("inpisdefault", "N");     data.isautotriggered = vars.getStringParameter("inpisautotriggered", "N");    try {   data.timeperpiece = vars.getNumericParameter("inptimeperpiece");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.setuptime = vars.getNumericParameter("inpsetuptime");  } catch (ServletException paramEx) { ex = paramEx; }     data.value = vars.getStringParameter("inpvalue");     data.name = vars.getStringParameter("inpname");     data.description = vars.getStringParameter("inpdescription");     data.note = vars.getStringParameter("inpnote");     data.responsibleId = vars.getStringParameter("inpresponsibleId");     data.responsibleIdr = vars.getStringParameter("inpresponsibleId_R");     data.changeprojectstatus = vars.getStringParameter("inpchangeprojectstatus");     data.cPhaseId = vars.getStringParameter("inpcPhaseId");    try {   data.committedamt = vars.getNumericParameter("inpcommittedamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.expreinvoicing = vars.getNumericParameter("inpexpreinvoicing");  } catch (ServletException paramEx) { ex = paramEx; }     data.processed = vars.getStringParameter("inpprocessed", "N");     data.lastplannedproposaldate = vars.getStringParameter("inplastplannedproposaldate");     data.cProjecttypeId = vars.getStringParameter("inpcProjecttypeId");     data.projectphase = vars.getStringParameter("inpprojectphase");    try {   data.expenses = vars.getNumericParameter("inpexpenses");  } catch (ServletException paramEx) { ex = paramEx; }     data.paymentrule = vars.getStringParameter("inppaymentrule");    try {   data.machinecost = vars.getNumericParameter("inpmachinecost");  } catch (ServletException paramEx) { ex = paramEx; }     data.iscommitceiling = vars.getStringParameter("inpiscommitceiling", "N");     data.generateto = vars.getStringParameter("inpgenerateto");     data.cBpartnerId = vars.getRequestGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");     data.issummary = vars.getStringParameter("inpissummary", "N");    try {   data.committedqty = vars.getNumericParameter("inpcommittedqty");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.plannedmarginamt = vars.getNumericParameter("inpplannedmarginamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.invoicedamt = vars.getNumericParameter("inpinvoicedamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.cLocationId = vars.getStringParameter("inpcLocationId");     data.invoiceToproject = vars.getStringParameter("inpinvoiceToproject", "N");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");    try {   data.documentCopies = vars.getNumericParameter("inpdocumentCopies");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.percentdoneyet = vars.getNumericParameter("inppercentdoneyet");  } catch (ServletException paramEx) { ex = paramEx; }     data.projectkind = vars.getStringParameter("inpprojectkind");    try {   data.plannedpoamt = vars.getNumericParameter("inpplannedpoamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.mPricelistVersionId = vars.getStringParameter("inpmPricelistVersionId");    try {   data.indirectcost = vars.getNumericParameter("inpindirectcost");  } catch (ServletException paramEx) { ex = paramEx; }     data.datefinish = vars.getStringParameter("inpdatefinish");     data.aAssetId = vars.getStringParameter("inpaAssetId");    try {   data.projectbalanceamt = vars.getNumericParameter("inpprojectbalanceamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.servcost = vars.getNumericParameter("inpservcost");  } catch (ServletException paramEx) { ex = paramEx; }     data.cCampaignId = vars.getStringParameter("inpcCampaignId");     data.schedulestatus = vars.getStringParameter("inpschedulestatus");    try {   data.qtyofproduct = vars.getNumericParameter("inpqtyofproduct");  } catch (ServletException paramEx) { ex = paramEx; }     data.iscommitment = vars.getRequiredInputGlobalVariable("inpiscommitment", windowId + "|IsCommitment", "N");    try {   data.servrevenue = vars.getNumericParameter("inpservrevenue");  } catch (ServletException paramEx) { ex = paramEx; }     data.zssmProductionplanVId = vars.getRequestGlobalVariable("inpzssmProductionplanVId", windowId + "|Zssm_Productionplan_V_ID");    try {   data.expexpenses = vars.getNumericParameter("inpexpexpenses");  } catch (ServletException paramEx) { ex = paramEx; }     data.reopenproject = vars.getStringParameter("inpreopenproject");     data.datecontract = vars.getStringParameter("inpdatecontract");     data.cCurrencyId = vars.getRequestGlobalVariable("inpcCurrencyId", windowId + "|C_Currency_ID");     data.processing = vars.getStringParameter("inpprocessing");    try {   data.estimatedamt = vars.getNumericParameter("inpestimatedamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.adUserId = vars.getStringParameter("inpadUserId");     data.mProductId = vars.getStringParameter("inpmProductId");    try {   data.plannedamt = vars.getNumericParameter("inpplannedamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.actualcostamount = vars.getNumericParameter("inpactualcostamount");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.expmargin = vars.getNumericParameter("inpexpmargin");  } catch (ServletException paramEx) { ex = paramEx; }     data.accountno = vars.getStringParameter("inpaccountno");     data.publicprivate = vars.getStringParameter("inppublicprivate");     data.mPricelistId = vars.getRequestGlobalVariable("inpmPricelistId", windowId + "|M_PriceList_ID");     data.poreference = vars.getStringParameter("inpporeference");     data.mWarehouseId = vars.getRequestGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");     data.cPaymenttermId = vars.getStringParameter("inpcPaymenttermId");     data.cBpartnerLocationId = vars.getStringParameter("inpcBpartnerLocationId");     data.createtemppricelist = vars.getStringParameter("inpcreatetemppricelist", "N");     data.cProjectId = vars.getStringParameter("inpcProjectId");    try {   data.plannedqty = vars.getNumericParameter("inpplannedqty");  } catch (ServletException paramEx) { ex = paramEx; }     data.setprojecttype = vars.getStringParameter("inpsetprojecttype");    try {   data.invoicedqty = vars.getNumericParameter("inpinvoicedqty");  } catch (ServletException paramEx) { ex = paramEx; }     data.billtoId = vars.getStringParameter("inpbilltoId");    try {   data.materialcost = vars.getNumericParameter("inpmaterialcost");  } catch (ServletException paramEx) { ex = paramEx; }     data.salesrepId = vars.getStringParameter("inpsalesrepId");     data.closeproject = vars.getStringParameter("inpcloseproject");    try {   data.servmargin = vars.getNumericParameter("inpservmargin");  } catch (ServletException paramEx) { ex = paramEx; }     data.startdate = vars.getStringParameter("inpstartdate");     data.copyfrom = vars.getStringParameter("inpcopyfrom");     data.generateorder = vars.getStringParameter("inpgenerateorder"); 
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

   private ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[] getRelationData(ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].projectcategory = FormatUtilities.truncate(data[i].projectcategory, 32);        data[i].projectstatus = FormatUtilities.truncate(data[i].projectstatus, 20);        data[i].value = FormatUtilities.truncate(data[i].value, 44);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].note = FormatUtilities.truncate(data[i].note, 50);        data[i].responsibleId = FormatUtilities.truncate(data[i].responsibleId, 45);        data[i].cPhaseId = FormatUtilities.truncate(data[i].cPhaseId, 22);        data[i].cProjecttypeId = FormatUtilities.truncate(data[i].cProjecttypeId, 44);        data[i].projectphase = FormatUtilities.truncate(data[i].projectphase, 21);        data[i].paymentrule = FormatUtilities.truncate(data[i].paymentrule, 21);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 44);        data[i].cLocationId = FormatUtilities.truncate(data[i].cLocationId, 50);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].projectkind = FormatUtilities.truncate(data[i].projectkind, 50);        data[i].mPricelistVersionId = FormatUtilities.truncate(data[i].mPricelistVersionId, 44);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, 32);        data[i].cCampaignId = FormatUtilities.truncate(data[i].cCampaignId, 44);        data[i].schedulestatus = FormatUtilities.truncate(data[i].schedulestatus, 50);        data[i].zssmProductionplanVId = FormatUtilities.truncate(data[i].zssmProductionplanVId, 32);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 44);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 44);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].accountno = FormatUtilities.truncate(data[i].accountno, 20);        data[i].publicprivate = FormatUtilities.truncate(data[i].publicprivate, 50);        data[i].mPricelistId = FormatUtilities.truncate(data[i].mPricelistId, 44);        data[i].poreference = FormatUtilities.truncate(data[i].poreference, 20);        data[i].mWarehouseId = FormatUtilities.truncate(data[i].mWarehouseId, 44);        data[i].cPaymenttermId = FormatUtilities.truncate(data[i].cPaymenttermId, 44);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 44);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 10);        data[i].billtoId = FormatUtilities.truncate(data[i].billtoId, 44);        data[i].salesrepId = FormatUtilities.truncate(data[i].salesrepId, 44);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|ProjectCategory", data[0].getField("projectcategory"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|IsCommitment", data[0].getField("iscommitment"));    vars.setSessionValue(windowId + "|Zssm_Productionplan_V_ID", data[0].getField("zssmProductionplanVId"));    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].getField("cCurrencyId"));    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].getField("mPricelistId"));    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].getField("mWarehouseId"));    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].getField("cBpartnerId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[] data = ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpzssmProductionplanVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strZssm_Productionplan_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamNote = vars.getSessionValue(tabId + "|paramNote");
String strParamIsActive = vars.getSessionValue(tabId + "|paramIsActive");
String strParamProjectStatus = vars.getSessionValue(tabId + "|paramProjectStatus");
String strParamResponsible_ID = vars.getSessionValue(tabId + "|paramResponsible_ID");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamValue.equals("") && strParamName.equals("") && strParamDescription.equals("") && strParamNote.equals("") && strParamIsActive.equals("") && strParamProjectStatus.equals("") && strParamResponsible_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strZssm_Productionplan_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strZssm_Productionplan_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/serprod/ProductionPlan/ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B", false, "document.frmMain.inpzssmProductionplanVId", "grid", "..", "".equals("Y"), "ProductionPlan", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "zssmProductionplanVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B_Relation.html", "ProductionPlan", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strZssm_Productionplan_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " zssm_productionplan_v.Name";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamNote = vars.getSessionValue(tabId + "|paramNote");
String strParamIsActive = vars.getSessionValue(tabId + "|paramIsActive");
String strParamProjectStatus = vars.getSessionValue(tabId + "|paramProjectStatus");
String strParamResponsible_ID = vars.getSessionValue(tabId + "|paramResponsible_ID");

    boolean hasSearchCondition=false;
    if (!(strParamValue.equals("") && strParamName.equals("") && strParamDescription.equals("") && strParamNote.equals("") && strParamIsActive.equals("") && strParamProjectStatus.equals("") && strParamResponsible_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strZssm_Productionplan_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strZssm_Productionplan_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("zssmProductionplanVId") == null || dataField.getField("zssmProductionplanVId").equals("")) {
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
        data = ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.set(Utility.getDefault(this, vars, "Expexpenses", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "InvoicedQty", "0", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "ProjectBalanceAmt", "0", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "C_Phase_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "AccountNo", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Materialcost", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "IsCommitment", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "N", dataField), Utility.getDefault(this, vars, "Actualcostamount", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "SalesRep_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "CommittedQty", "0", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Responsible_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Closeproject", "N", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "N", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Projectphase", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Schedulestatus", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Servrevenue", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "IsCommitCeiling", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "N", dataField), Utility.getDefault(this, vars, "Projectkind", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "InvoicedAmt", "0", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "PlannedPOAmt", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Note", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Setuptime", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "CommittedAmt", "0", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Name", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "ProjectStatus", "OP", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "M_PriceList_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Invoice_ToProject", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "N", dataField), Utility.getDefault(this, vars, "POReference", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "PlannedQty", "0", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "M_PriceList_Version_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Expenses", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.selectDef464EC7312A434A6B8CFB56A6244A0DD5(this, Utility.getContext(this, vars, "#ad_client_ID", windowId)), Utility.getDefault(this, vars, "CreatedBy", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.selectDefDDCB17F4783B42F3AB9159DBC8BA5284_0(this, Utility.getDefault(this, vars, "CreatedBy", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField)), Utility.getDefault(this, vars, "Setprojecttype", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "N", dataField), Utility.getDefault(this, vars, "C_PaymentTerm_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Startdate", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Expreinvoicing", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "PlannedAmt", "0", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.selectDefC3CDDA746364456B84023E8993F65CEF_1(this, Utility.getDefault(this, vars, "UpdatedBy", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField)), Utility.getDefault(this, vars, "LastPlannedProposalDate", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Processed", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "N", dataField), Utility.getDefault(this, vars, "IsSummary", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "N", dataField), Utility.getDefault(this, vars, "DateFinish", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "PaymentRule", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Isdefault", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "N", dataField), Utility.getDefault(this, vars, "C_Location_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "A_Asset_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Servcost", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Description", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "GenerateOrder", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "N", dataField), Utility.getDefault(this, vars, "BillTo_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "C_Campaign_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Publicprivate", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "C_BPartner_Location_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Isautotriggered", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "N", dataField), Utility.getDefault(this, vars, "Qtyofproduct", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), "", Utility.getDefault(this, vars, "Expmargin", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Percentdoneyet", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "CopyFrom", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "N", dataField), Utility.getDefault(this, vars, "C_ProjectType_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Machinecost", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Timeperpiece", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Servmargin", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "PlannedMarginAmt", "0", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "DateContract", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Estimatedamt", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "ChangeProjectStatus", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "N", dataField), (vars.getLanguage().equals("en_US")?ListData.selectName(this, "CF2E265D07B74B8492A031AAD6BCE74D", Utility.getDefault(this, vars, "ChangeProjectStatus", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "N", dataField)):ListData.selectNameTrl(this, vars.getLanguage(), "CF2E265D07B74B8492A031AAD6BCE74D", Utility.getDefault(this, vars, "ChangeProjectStatus", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "N", dataField))), Utility.getDefault(this, vars, "Value", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "C_Project_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "GenerateTo", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "N", dataField), Utility.getDefault(this, vars, "C_BPartner_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Reopenproject", "N", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "N", dataField), Utility.getDefault(this, vars, "ProjectCategory", "PRP", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), "Y", Utility.getDefault(this, vars, "AD_User_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Processing", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "N", dataField), Utility.getDefault(this, vars, "Createtemppricelist", "N", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "N", dataField), Utility.getDefault(this, vars, "Document_Copies", "1", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "Indirectcost", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField), Utility.getDefault(this, vars, "M_Warehouse_ID", "", "3E801605DEA44BA0920CD7A8BB1A2A0B", "5C0EE761B80B4C2DAFCA92FD699A387B", "", dataField));
        
      }
    } else {
      data = new ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpzssmProductionplanVId", "", "..", "".equals("Y"), "ProductionPlan", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strZssm_Productionplan_V_ID));
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
  
    void printPageButtonChangeProjectStatusEC001EF3DBFB414DAC79E871985CBF20(HttpServletResponse response, VariablesSecureApp vars, String strZssm_Productionplan_V_ID, String strchangeprojectstatus, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "EC001EF3DBFB414DAC79E871985CBF20",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "EC001EF3DBFB414DAC79E871985CBF20" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"EC001EF3DBFB414DAC79E871985CBF20" );
        String isDocAction=UtilsData.isProcessDocAction(this, "EC001EF3DBFB414DAC79E871985CBF20");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "23115BC0B180403984041462A8E3C35F",strZssm_Productionplan_V_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "23115BC0B180403984041462A8E3C35F", strZssm_Productionplan_V_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strchangeprojectstatus, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "EC001EF3DBFB414DAC79E871985CBF20");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONChangeProjectStatus" + "EC001EF3DBFB414DAC79E871985CBF20" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "EC001EF3DBFB414DAC79E871985CBF20");
        script.addHiddenfield("inpKey",strZssm_Productionplan_V_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("EC001EF3DBFB414DAC79E871985CBF20");
        vars.removeMessage("EC001EF3DBFB414DAC79E871985CBF20");
        if (myMessage!=null) {
          script.addMessage(this, vars, myMessage);
        }
        strOutput = script.doScript(strOutput, "",this,vars);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(strOutput);
        out.close();
      } catch (Exception ex) {
        throw new ServletException(ex);
      }
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
    ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData data = null;
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
                data.zssmProductionplanVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387BData.getCurrentDBTimestamp(this, data.zssmProductionplanVId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.zssmProductionplanVId, vars, this);
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
                    data.zssmProductionplanVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Zssm_Productionplan_V_ID", data.zssmProductionplanVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet ProductionPlan5C0EE761B80B4C2DAFCA92FD699A387B. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
