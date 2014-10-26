
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.PlannedWorksteps;





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

public class PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB.class);
  
  private static final String windowId = "687E0E7367AE4F54B14B92A60DC46D05";
  private static final String tabId = "E3F3D04CCE7F4E7F95677A2298A0A6EB";
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
        String strzssmWorkstepVId = request.getParameter("inpzssmWorkstepVId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strzssmWorkstepVId.equals(""))
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

      String strZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strZssm_Workstep_V_ID.equals("")) strZssm_Workstep_V_ID = firstElement(vars, tableSQL);
          if (strZssm_Workstep_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssm_Workstep_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strZssm_Workstep_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strZssm_Workstep_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strZssm_Workstep_V_ID.equals("")) strZssm_Workstep_V_ID = vars.getRequiredGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
      else vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", strZssm_Workstep_V_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB.view", "EDIT");

        printPageEdit(response, request, vars, false, strZssm_Workstep_V_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB.view", "RELATION");
        printPageDataSheet(response, vars, strZssm_Workstep_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB.view");
      String strZssm_Workstep_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strZssm_Workstep_V_ID = firstElement(vars, tableSQL);
          if (strZssm_Workstep_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strZssm_Workstep_V_ID.equals("")) strZssm_Workstep_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strZssm_Workstep_V_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamValue", tabId + "|paramValue");
vars.getRequestGlobalVariable("inpParamIsActive", tabId + "|paramIsActive");
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamM_Product_ID", tabId + "|paramM_Product_ID");
vars.getRequestGlobalVariable("inpParamStarted", tabId + "|paramStarted");
vars.getRequestGlobalVariable("inpParamStartDate", tabId + "|paramStartDate");
vars.getRequestGlobalVariable("inpParamEnddate", tabId + "|paramEnddate");
vars.getRequestGlobalVariable("inpParamTriggerreason", tabId + "|paramTriggerreason");
vars.getRequestGlobalVariable("inpParamAD_Org_ID", tabId + "|paramAD_Org_ID");
vars.getRequestGlobalVariable("inpParamDescription", tabId + "|paramDescription");
vars.getRequestGlobalVariable("inpParamStarted_f", tabId + "|paramStarted_f");
vars.getRequestGlobalVariable("inpParamStartDate_f", tabId + "|paramStartDate_f");
vars.getRequestGlobalVariable("inpParamEnddate_f", tabId + "|paramEnddate_f");

      
      
      vars.removeSessionValue(windowId + "|Zssm_Workstep_V_ID");
      String strZssm_Workstep_V_ID="";

      String strView = vars.getSessionValue(tabId + "|PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strZssm_Workstep_V_ID = firstElement(vars, tableSQL);
        if (strZssm_Workstep_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssm_Workstep_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strZssm_Workstep_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID", "");
      vars.setSessionValue(tabId + "|PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB.view", "RELATION");
      printPageDataSheet(response, vars, strZssm_Workstep_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID", "");
      vars.setSessionValue(tabId + "|PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strZssm_Workstep_V_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strZssm_Workstep_V_ID = vars.getRequiredStringParameter("inpzssmWorkstepVId");
      
      String strNext = nextElement(vars, strZssm_Workstep_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strZssm_Workstep_V_ID = vars.getRequiredStringParameter("inpzssmWorkstepVId");
      
      String strPrevious = previousElement(vars, strZssm_Workstep_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Zssm_Workstep_V_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Zssm_Workstep_V_ID");

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

      String strZssm_Workstep_V_ID = vars.getRequiredGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
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
          String strNext = nextElement(vars, strZssm_Workstep_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strZssm_Workstep_V_ID = vars.getRequiredInStringParameter("inpzssmWorkstepVId");
      String message = deleteRelation(vars, strZssm_Workstep_V_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|zssmWorkstepVId");
        vars.setSessionValue(tabId + "|PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strZssm_Workstep_V_ID = vars.getRequiredStringParameter("inpzssmWorkstepVId");
      //PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.delete(this, strZssm_Workstep_V_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|zssmWorkstepVId");
        vars.setSessionValue(tabId + "|PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strZssm_Workstep_V_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strZssm_Workstep_V_ID.startsWith("(")) strZssm_Workstep_V_ID = strZssm_Workstep_V_ID.substring(1, strZssm_Workstep_V_ID.length()-1);
      if (!strZssm_Workstep_V_ID.equals("")) {
        strZssm_Workstep_V_ID = Replace.replace(strZssm_Workstep_V_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strZssm_Workstep_V_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.deleteTransactional(conn, this, strKey)==0) {
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
  private PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData data = new PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData();
    ServletException ex = null;
    try {
    data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.name = vars.getStringParameter("inpname");     data.zssmProductionorderVId = vars.getStringParameter("inpzssmProductionorderVId");     data.zssmProductionorderVIdr = vars.getStringParameter("inpzssmProductionorderVId_R");     data.ended = vars.getStringParameter("inpended");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.value = vars.getStringParameter("inpvalue");    try {   data.seqno = vars.getNumericParameter("inpseqno");  } catch (ServletException paramEx) { ex = paramEx; }     data.started = vars.getStringParameter("inpstarted");     data.startdate = vars.getStringParameter("inpstartdate");     data.enddate = vars.getStringParameter("inpenddate");     data.description = vars.getStringParameter("inpdescription");     data.triggerreason = vars.getStringParameter("inptriggerreason");    try {   data.qty = vars.getNumericParameter("inpqty");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qtyproduced = vars.getNumericParameter("inpqtyproduced");  } catch (ServletException paramEx) { ex = paramEx; }     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.assembly = vars.getStringParameter("inpassembly", "N");     data.receivingLocator = vars.getRequestGlobalVariable("inpreceivingLocator", windowId + "|Receiving_Locator");     data.receivingLocatorr = vars.getStringParameter("inpreceivingLocator_R");     data.issuingLocator = vars.getRequestGlobalVariable("inpissuingLocator", windowId + "|Issuing_Locator");     data.issuingLocatorr = vars.getStringParameter("inpissuingLocator_R");    try {   data.servcostplan = vars.getNumericParameter("inpservcostplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.machinecostplan = vars.getNumericParameter("inpmachinecostplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.materialcostplan = vars.getNumericParameter("inpmaterialcostplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.plannedcost = vars.getNumericParameter("inpplannedcost");  } catch (ServletException paramEx) { ex = paramEx; }     data.createbom = vars.getStringParameter("inpcreatebom");     data.cTaskId = vars.getStringParameter("inpcTaskId");     data.help = vars.getStringParameter("inphelp");     data.schedulestatus = vars.getStringParameter("inpschedulestatus");    try {   data.servcost = vars.getNumericParameter("inpservcost");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.priceactual = vars.getNumericParameter("inppriceactual");  } catch (ServletException paramEx) { ex = paramEx; }     data.canceltask = vars.getStringParameter("inpcanceltask");     data.cOrderlineId = vars.getStringParameter("inpcOrderlineId");     data.iscomplete = vars.getRequiredInputGlobalVariable("inpiscomplete", windowId + "|Iscomplete", "N");    try {   data.percentrejects = vars.getNumericParameter("inppercentrejects");  } catch (ServletException paramEx) { ex = paramEx; }     data.iscommitceiling = vars.getStringParameter("inpiscommitceiling", "N");     data.ismaterialdisposed = vars.getRequiredInputGlobalVariable("inpismaterialdisposed", windowId + "|Ismaterialdisposed", "N");    try {   data.indirectcostplan = vars.getNumericParameter("inpindirectcostplan");  } catch (ServletException paramEx) { ex = paramEx; }     data.datecontract = vars.getStringParameter("inpdatecontract");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.returnmaterialtostock = vars.getStringParameter("inpreturnmaterialtostock");    try {   data.percentdone = vars.getNumericParameter("inppercentdone");  } catch (ServletException paramEx) { ex = paramEx; }     data.outsourcing = vars.getRequiredInputGlobalVariable("inpoutsourcing", windowId + "|Outsourcing", "N");     data.begintask = vars.getStringParameter("inpbegintask");    try {   data.expenses = vars.getNumericParameter("inpexpenses");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.actualcost = vars.getNumericParameter("inpactualcost");  } catch (ServletException paramEx) { ex = paramEx; }     data.unplanmaterial = vars.getStringParameter("inpunplanmaterial");    try {   data.invoicedamt = vars.getNumericParameter("inpinvoicedamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.taskbegun = vars.getRequiredInputGlobalVariable("inptaskbegun", windowId + "|Taskbegun", "N");     data.getmaterialfromstock = vars.getStringParameter("inpgetmaterialfromstock");    try {   data.committedamt = vars.getNumericParameter("inpcommittedamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.indirectcost = vars.getNumericParameter("inpindirectcost");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.machinecost = vars.getNumericParameter("inpmachinecost");  } catch (ServletException paramEx) { ex = paramEx; }     data.istaskcancelled = vars.getStringParameter("inpistaskcancelled", "N");     data.endtask = vars.getStringParameter("inpendtask");     data.gotopurchasing = vars.getStringParameter("inpgotopurchasing", "N");    try {   data.materialcost = vars.getNumericParameter("inpmaterialcost");  } catch (ServletException paramEx) { ex = paramEx; }     data.planmaterial = vars.getStringParameter("inpplanmaterial");    try {   data.qtyleft = vars.getNumericParameter("inpqtyleft", vars.getSessionValue(windowId + "|Qtyleft"));  } catch (ServletException paramEx) { ex = paramEx; }     data.zssmWorkstepVId = vars.getRequestGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");     data.zssmProductionplanTaskId = vars.getStringParameter("inpzssmProductionplanTaskId"); 
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

   private PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[] getRelationData(PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 22);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].zssmProductionorderVId = FormatUtilities.truncate(data[i].zssmProductionorderVId, 32);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].value = FormatUtilities.truncate(data[i].value, 20);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].triggerreason = FormatUtilities.truncate(data[i].triggerreason, 50);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 50);        data[i].receivingLocator = FormatUtilities.truncate(data[i].receivingLocator, 32);        data[i].issuingLocator = FormatUtilities.truncate(data[i].issuingLocator, 32);        data[i].cTaskId = FormatUtilities.truncate(data[i].cTaskId, 22);        data[i].help = FormatUtilities.truncate(data[i].help, 50);        data[i].schedulestatus = FormatUtilities.truncate(data[i].schedulestatus, 20);        data[i].cOrderlineId = FormatUtilities.truncate(data[i].cOrderlineId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 22);        data[i].zssmWorkstepVId = FormatUtilities.truncate(data[i].zssmWorkstepVId, 32);        data[i].zssmProductionplanTaskId = FormatUtilities.truncate(data[i].zssmProductionplanTaskId, 32);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|Receiving_Locator", data[0].getField("receivingLocator"));    vars.setSessionValue(windowId + "|Issuing_Locator", data[0].getField("issuingLocator"));    vars.setSessionValue(windowId + "|QtyLeft", data[0].getField("qtyleft"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|IsComplete", data[0].getField("iscomplete"));    vars.setSessionValue(windowId + "|Ismaterialdisposed", data[0].getField("ismaterialdisposed"));    vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", data[0].getField("zssmWorkstepVId"));    vars.setSessionValue(windowId + "|Outsourcing", data[0].getField("outsourcing"));    vars.setSessionValue(windowId + "|Taskbegun", data[0].getField("taskbegun"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[] data = PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpzssmWorkstepVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strZssm_Workstep_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamIsActive = vars.getSessionValue(tabId + "|paramIsActive");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamStarted = vars.getSessionValue(tabId + "|paramStarted");
String strParamStartDate = vars.getSessionValue(tabId + "|paramStartDate");
String strParamEnddate = vars.getSessionValue(tabId + "|paramEnddate");
String strParamTriggerreason = vars.getSessionValue(tabId + "|paramTriggerreason");
String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamStarted_f = vars.getSessionValue(tabId + "|paramStarted_f");
String strParamStartDate_f = vars.getSessionValue(tabId + "|paramStartDate_f");
String strParamEnddate_f = vars.getSessionValue(tabId + "|paramEnddate_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamValue.equals("") && strParamIsActive.equals("") && strParamName.equals("") && strParamM_Product_ID.equals("") && strParamStarted.equals("") && strParamStartDate.equals("") && strParamEnddate.equals("") && strParamTriggerreason.equals("") && strParamAD_Org_ID.equals("") && strParamDescription.equals("") && strParamStarted_f.equals("") && strParamStartDate_f.equals("") && strParamEnddate_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strZssm_Workstep_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strZssm_Workstep_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/serprod/PlannedWorksteps/PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB", false, "document.frmMain.inpzssmWorkstepVId", "grid", "..", "".equals("Y"), "PlannedWorksteps", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "zssmWorkstepVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB_Relation.html", "PlannedWorksteps", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strZssm_Workstep_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " zssm_workstep_v.SeqNo, zssm_workstep_v.Value";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamIsActive = vars.getSessionValue(tabId + "|paramIsActive");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamStarted = vars.getSessionValue(tabId + "|paramStarted");
String strParamStartDate = vars.getSessionValue(tabId + "|paramStartDate");
String strParamEnddate = vars.getSessionValue(tabId + "|paramEnddate");
String strParamTriggerreason = vars.getSessionValue(tabId + "|paramTriggerreason");
String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamStarted_f = vars.getSessionValue(tabId + "|paramStarted_f");
String strParamStartDate_f = vars.getSessionValue(tabId + "|paramStartDate_f");
String strParamEnddate_f = vars.getSessionValue(tabId + "|paramEnddate_f");

    boolean hasSearchCondition=false;
    if (!(strParamValue.equals("") && strParamIsActive.equals("") && strParamName.equals("") && strParamM_Product_ID.equals("") && strParamStarted.equals("") && strParamStartDate.equals("") && strParamEnddate.equals("") && strParamTriggerreason.equals("") && strParamAD_Org_ID.equals("") && strParamDescription.equals("") && strParamStarted_f.equals("") && strParamStartDate_f.equals("") && strParamEnddate_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strZssm_Workstep_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strZssm_Workstep_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("zssmWorkstepVId") == null || dataField.getField("zssmWorkstepVId").equals("")) {
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
        data = PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.set(Utility.getDefault(this, vars, "Help", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Expenses", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Planmaterial", "N", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "N", dataField), Utility.getDefault(this, vars, "Machinecostplan", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Endtask", "N", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "N", dataField), Utility.getDefault(this, vars, "PriceActual", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.selectDef18E2B62B71AA4FCC8F0E7E5AB8FAD6D2_0(this, Utility.getDefault(this, vars, "UpdatedBy", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField)), Utility.getDefault(this, vars, "Outsourcing", "N", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "N", dataField), Utility.getDefault(this, vars, "Unplanmaterial", "N", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "N", dataField), Utility.getDefault(this, vars, "Taskbegun", "N", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "N", dataField), Utility.getDefault(this, vars, "Triggerreason", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Indirectcostplan", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Canceltask", "N", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "N", dataField), Utility.getDefault(this, vars, "Createbom", "N", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "N", dataField), Utility.getDefault(this, vars, "Invoicedamt", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Qty", "1", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.selectDef5289F216D0D6477B874F419B2DA25F87_1(this, Utility.getDefault(this, vars, "M_Product_ID", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField)), Utility.getDefault(this, vars, "Ismaterialdisposed", "N", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "N", dataField), PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.selectDef59634A916FC54AC99E95765067C5774C(this, Utility.getContext(this, vars, "#AD_JAVADATEFORMAT", windowId), Utility.getContext(this, vars, "C_Project_ID", "687E0E7367AE4F54B14B92A60DC46D05")), Utility.getDefault(this, vars, "Receiving_Locator", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.selectDef16D7CBA97CC64B5DBE296A6F9B754BD1_2(this, Utility.getDefault(this, vars, "Receiving_Locator", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField)), Utility.getDefault(this, vars, "BeginTask", "N", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "N", dataField), Utility.getDefault(this, vars, "Machinecost", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), "", Utility.getDefault(this, vars, "Iscomplete", "N", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "N", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.selectDefBF72293C90A14B129863C0F861752AE1_3(this, Utility.getDefault(this, vars, "CreatedBy", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField)), Utility.getDefault(this, vars, "Getmaterialfromstock", "N", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "N", dataField), Utility.getDefault(this, vars, "Iscommitceiling", "N", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "N", dataField), Utility.getDefault(this, vars, "Returnmaterialtostock", "N", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "N", dataField), Utility.getDefault(this, vars, "Schedulestatus", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Datecontract", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "C_Orderline_ID", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Qtyproduced", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Issuing_Locator", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.selectDef303E0FBA8DBC4B368E5FF9BACE658878_4(this, Utility.getDefault(this, vars, "Issuing_Locator", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField)), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "zssm_productionorder_v_id", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Actualcost", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Committedamt", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "C_Task_ID", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Servcost", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Servcostplan", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Ended", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Assembly", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "N", dataField), Utility.getDefault(this, vars, "Plannedcost", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.selectDefC46C3A0F43DC4141ACA5A7451857773A(this, Utility.getContext(this, vars, "C_Project_ID", "687E0E7367AE4F54B14B92A60DC46D05")), Utility.getDefault(this, vars, "Materialcostplan", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), "Y", Utility.getDefault(this, vars, "Materialcost", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Started", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Qtyleft", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Percentdone", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Value", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Zssm_Productionplan_Task_ID", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Gotopurchasing", "N", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "N", dataField), Utility.getDefault(this, vars, "Description", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Name", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Percentrejects", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.selectDef1119F3F170EF46D1A1B69625B63F826C(this, Utility.getContext(this, vars, "#AD_JAVADATEFORMAT", windowId), Utility.getContext(this, vars, "C_Project_ID", "687E0E7367AE4F54B14B92A60DC46D05")), Utility.getDefault(this, vars, "C_ProjectTask_ID", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Istaskcancelled", "N", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "N", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField), Utility.getDefault(this, vars, "Indirectcost", "", "687E0E7367AE4F54B14B92A60DC46D05", "E3F3D04CCE7F4E7F95677A2298A0A6EB", "", dataField));
        
      }
    } else {
      data = new PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpzssmWorkstepVId", "", "..", "".equals("Y"), "PlannedWorksteps", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strZssm_Workstep_V_ID));
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
    PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData data = null;
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
                data.zssmWorkstepVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.getCurrentDBTimestamp(this, data.zssmWorkstepVId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.zssmWorkstepVId, vars, this);
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
                    data.zssmWorkstepVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", data.zssmWorkstepVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EB. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
