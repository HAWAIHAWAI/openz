
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.WorkSteps;





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

public class WorkStepsECE46D9675A84540808D61E971782779 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(WorkStepsECE46D9675A84540808D61E971782779.class);
  
  private static final String windowId = "A117A2A8301F47EFA4E03E785FF9CF9D";
  private static final String tabId = "ECE46D9675A84540808D61E971782779";
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
        String strzssmWorkstepPrpVId = request.getParameter("inpzssmWorkstepPrpVId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strzssmWorkstepPrpVId.equals(""))
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

      String strZssm_Workstep_Prp_V_ID = vars.getGlobalVariable("inpzssmWorkstepPrpVId", windowId + "|Zssm_Workstep_Prp_V_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|WorkStepsECE46D9675A84540808D61E971782779.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strZssm_Workstep_Prp_V_ID.equals("")) strZssm_Workstep_Prp_V_ID = firstElement(vars, tableSQL);
          if (strZssm_Workstep_Prp_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssm_Workstep_Prp_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strZssm_Workstep_Prp_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strZssm_Workstep_Prp_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strZssm_Workstep_Prp_V_ID.equals("")) strZssm_Workstep_Prp_V_ID = vars.getRequiredGlobalVariable("inpzssmWorkstepPrpVId", windowId + "|Zssm_Workstep_Prp_V_ID");
      else vars.setSessionValue(windowId + "|Zssm_Workstep_Prp_V_ID", strZssm_Workstep_Prp_V_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|WorkStepsECE46D9675A84540808D61E971782779.view", "EDIT");

        printPageEdit(response, request, vars, false, strZssm_Workstep_Prp_V_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|WorkStepsECE46D9675A84540808D61E971782779.view", "RELATION");
        printPageDataSheet(response, vars, strZssm_Workstep_Prp_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|WorkStepsECE46D9675A84540808D61E971782779.view");
      String strZssm_Workstep_Prp_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strZssm_Workstep_Prp_V_ID = firstElement(vars, tableSQL);
          if (strZssm_Workstep_Prp_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strZssm_Workstep_Prp_V_ID.equals("")) strZssm_Workstep_Prp_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strZssm_Workstep_Prp_V_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamIsActive", tabId + "|paramIsActive");
vars.getRequestGlobalVariable("inpParamValue", tabId + "|paramValue");
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamM_Product_ID", tabId + "|paramM_Product_ID");

      
      
      vars.removeSessionValue(windowId + "|Zssm_Workstep_Prp_V_ID");
      String strZssm_Workstep_Prp_V_ID="";

      String strView = vars.getSessionValue(tabId + "|WorkStepsECE46D9675A84540808D61E971782779.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strZssm_Workstep_Prp_V_ID = firstElement(vars, tableSQL);
        if (strZssm_Workstep_Prp_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|WorkStepsECE46D9675A84540808D61E971782779.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssm_Workstep_Prp_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strZssm_Workstep_Prp_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strZssm_Workstep_Prp_V_ID = vars.getGlobalVariable("inpzssmWorkstepPrpVId", windowId + "|Zssm_Workstep_Prp_V_ID", "");
      vars.setSessionValue(tabId + "|WorkStepsECE46D9675A84540808D61E971782779.view", "RELATION");
      printPageDataSheet(response, vars, strZssm_Workstep_Prp_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strZssm_Workstep_Prp_V_ID = vars.getGlobalVariable("inpzssmWorkstepPrpVId", windowId + "|Zssm_Workstep_Prp_V_ID", "");
      vars.setSessionValue(tabId + "|WorkStepsECE46D9675A84540808D61E971782779.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strZssm_Workstep_Prp_V_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strZssm_Workstep_Prp_V_ID = vars.getRequiredStringParameter("inpzssmWorkstepPrpVId");
      
      String strNext = nextElement(vars, strZssm_Workstep_Prp_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strZssm_Workstep_Prp_V_ID = vars.getRequiredStringParameter("inpzssmWorkstepPrpVId");
      
      String strPrevious = previousElement(vars, strZssm_Workstep_Prp_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|WorkStepsECE46D9675A84540808D61E971782779.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|WorkStepsECE46D9675A84540808D61E971782779.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|WorkStepsECE46D9675A84540808D61E971782779.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|WorkStepsECE46D9675A84540808D61E971782779.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Zssm_Workstep_Prp_V_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|WorkStepsECE46D9675A84540808D61E971782779.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|WorkStepsECE46D9675A84540808D61E971782779.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Zssm_Workstep_Prp_V_ID");

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

      String strZssm_Workstep_Prp_V_ID = vars.getRequiredGlobalVariable("inpzssmWorkstepPrpVId", windowId + "|Zssm_Workstep_Prp_V_ID");
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
          String strNext = nextElement(vars, strZssm_Workstep_Prp_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|Zssm_Workstep_Prp_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strZssm_Workstep_Prp_V_ID = vars.getRequiredInStringParameter("inpzssmWorkstepPrpVId");
      String message = deleteRelation(vars, strZssm_Workstep_Prp_V_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|zssmWorkstepPrpVId");
        vars.setSessionValue(tabId + "|WorkStepsECE46D9675A84540808D61E971782779.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strZssm_Workstep_Prp_V_ID = vars.getRequiredStringParameter("inpzssmWorkstepPrpVId");
      //WorkStepsECE46D9675A84540808D61E971782779Data data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = WorkStepsECE46D9675A84540808D61E971782779Data.delete(this, strZssm_Workstep_Prp_V_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|zssmWorkstepPrpVId");
        vars.setSessionValue(tabId + "|WorkStepsECE46D9675A84540808D61E971782779.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strZssm_Workstep_Prp_V_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strZssm_Workstep_Prp_V_ID.startsWith("(")) strZssm_Workstep_Prp_V_ID = strZssm_Workstep_Prp_V_ID.substring(1, strZssm_Workstep_Prp_V_ID.length()-1);
      if (!strZssm_Workstep_Prp_V_ID.equals("")) {
        strZssm_Workstep_Prp_V_ID = Replace.replace(strZssm_Workstep_Prp_V_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strZssm_Workstep_Prp_V_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (WorkStepsECE46D9675A84540808D61E971782779Data.deleteTransactional(conn, this, strKey)==0) {
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
  private WorkStepsECE46D9675A84540808D61E971782779Data getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    WorkStepsECE46D9675A84540808D61E971782779Data data = new WorkStepsECE46D9675A84540808D61E971782779Data();
    ServletException ex = null;
    try {
    data.zssmWorkstepPrpVId = vars.getRequestGlobalVariable("inpzssmWorkstepPrpVId", windowId + "|Zssm_Workstep_Prp_V_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.value = vars.getStringParameter("inpvalue");     data.name = vars.getStringParameter("inpname");    try {   data.seqno = vars.getNumericParameter("inpseqno");  } catch (ServletException paramEx) { ex = paramEx; }     data.description = vars.getStringParameter("inpdescription");     data.assembly = vars.getStringParameter("inpassembly", "N");     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.forcematerialscan = vars.getStringParameter("inpforcematerialscan", "N");     data.startonlywithcompletematerial = vars.getStringParameter("inpstartonlywithcompletematerial", "N");     data.isautotriggered = vars.getStringParameter("inpisautotriggered", "N");     data.isautogeneratedplan = vars.getStringParameter("inpisautogeneratedplan", "N");     data.receivingLocator = vars.getRequestGlobalVariable("inpreceivingLocator", windowId + "|Receiving_Locator");     data.receivingLocatorr = vars.getStringParameter("inpreceivingLocator_R");     data.issuingLocator = vars.getRequestGlobalVariable("inpissuingLocator", windowId + "|Issuing_Locator");     data.issuingLocatorr = vars.getStringParameter("inpissuingLocator_R");     data.help = vars.getStringParameter("inphelp");    try {   data.timeperpiece = vars.getNumericParameter("inptimeperpiece");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.setuptime = vars.getNumericParameter("inpsetuptime");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qty = vars.getNumericParameter("inpqty");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.servcostplan = vars.getNumericParameter("inpservcostplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.machinecostplan = vars.getNumericParameter("inpmachinecostplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.materialcostplan = vars.getNumericParameter("inpmaterialcostplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.plannedcost = vars.getNumericParameter("inpplannedcost");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.indirectcostplan = vars.getNumericParameter("inpindirectcostplan");  } catch (ServletException paramEx) { ex = paramEx; }     data.zssmWorkstepVId = vars.getRequestGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");    try {   data.percentrejects = vars.getNumericParameter("inppercentrejects");  } catch (ServletException paramEx) { ex = paramEx; } 
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

   private WorkStepsECE46D9675A84540808D61E971782779Data[] getRelationData(WorkStepsECE46D9675A84540808D61E971782779Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].zssmWorkstepPrpVId = FormatUtilities.truncate(data[i].zssmWorkstepPrpVId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].value = FormatUtilities.truncate(data[i].value, 20);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].receivingLocator = FormatUtilities.truncate(data[i].receivingLocator, 32);        data[i].issuingLocator = FormatUtilities.truncate(data[i].issuingLocator, 32);        data[i].help = FormatUtilities.truncate(data[i].help, 50);        data[i].zssmWorkstepVId = FormatUtilities.truncate(data[i].zssmWorkstepVId, 32);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Zssm_Workstep_Prp_V_ID", data[0].getField("zssmWorkstepPrpVId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|Receiving_Locator", data[0].getField("receivingLocator"));    vars.setSessionValue(windowId + "|Issuing_Locator", data[0].getField("issuingLocator"));    vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", data[0].getField("zssmWorkstepVId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      WorkStepsECE46D9675A84540808D61E971782779Data[] data = WorkStepsECE46D9675A84540808D61E971782779Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpzssmWorkstepPrpVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strZssm_Workstep_Prp_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamIsActive = vars.getSessionValue(tabId + "|paramIsActive");
String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamIsActive.equals("") && strParamValue.equals("") && strParamName.equals("") && strParamM_Product_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strZssm_Workstep_Prp_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strZssm_Workstep_Prp_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/serprod/WorkSteps/WorkStepsECE46D9675A84540808D61E971782779_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "WorkStepsECE46D9675A84540808D61E971782779", false, "document.frmMain.inpzssmWorkstepPrpVId", "grid", "..", "".equals("Y"), "WorkSteps", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "zssmWorkstepPrpVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "WorkStepsECE46D9675A84540808D61E971782779_Relation.html", "WorkSteps", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "WorkStepsECE46D9675A84540808D61E971782779_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strZssm_Workstep_Prp_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " zssm_workstep_prp_v.Value, zssm_workstep_prp_v.SeqNo";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    WorkStepsECE46D9675A84540808D61E971782779Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamIsActive = vars.getSessionValue(tabId + "|paramIsActive");
String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");

    boolean hasSearchCondition=false;
    if (!(strParamIsActive.equals("") && strParamValue.equals("") && strParamName.equals("") && strParamM_Product_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = WorkStepsECE46D9675A84540808D61E971782779Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strZssm_Workstep_Prp_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strZssm_Workstep_Prp_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new WorkStepsECE46D9675A84540808D61E971782779Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("zssmWorkstepPrpVId") == null || dataField.getField("zssmWorkstepPrpVId").equals("")) {
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
        data = WorkStepsECE46D9675A84540808D61E971782779Data.set(Utility.getDefault(this, vars, "Help", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), Utility.getDefault(this, vars, "Assembly", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "N", dataField), Utility.getDefault(this, vars, "Receiving_Locator", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), WorkStepsECE46D9675A84540808D61E971782779Data.selectDefBAA267FE9E92450CBD4B1E645B335AEA_0(this, Utility.getDefault(this, vars, "Receiving_Locator", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField)), "", Utility.getDefault(this, vars, "Value", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), Utility.getDefault(this, vars, "ForceMaterialScan", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "N", dataField), Utility.getDefault(this, vars, "Isautotriggered", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "N", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), WorkStepsECE46D9675A84540808D61E971782779Data.selectDef4653F635D4344A91A2D6897E7117B36C_1(this, Utility.getDefault(this, vars, "CreatedBy", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField)), WorkStepsECE46D9675A84540808D61E971782779Data.selectDef972A0F4F848D42B28029CF8FC6BC8256(this, Utility.getContext(this, vars, "C_Project_ID", "A117A2A8301F47EFA4E03E785FF9CF9D")), Utility.getDefault(this, vars, "IndirectCostPlan", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), Utility.getDefault(this, vars, "C_Projecttask_ID", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), Utility.getDefault(this, vars, "Description", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), WorkStepsECE46D9675A84540808D61E971782779Data.selectDef0BA9DC7FB4D9420EADBF95E46E79A679_2(this, Utility.getDefault(this, vars, "UpdatedBy", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField)), Utility.getDefault(this, vars, "Name", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), Utility.getDefault(this, vars, "isautogeneratedplan", "Y", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "N", dataField), Utility.getDefault(this, vars, "Zssm_Workstep_V_ID", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), WorkStepsECE46D9675A84540808D61E971782779Data.selectDef180AE6A146914989BD5EC1B93EF10A9F_3(this, Utility.getDefault(this, vars, "M_Product_ID", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField)), Utility.getDefault(this, vars, "Timeperpiece", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), Utility.getDefault(this, vars, "PlannedCost", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), Utility.getDefault(this, vars, "MaterialCostPlan", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), Utility.getDefault(this, vars, "MachineCostPlan", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), "Y", Utility.getDefault(this, vars, "Issuing_Locator", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), WorkStepsECE46D9675A84540808D61E971782779Data.selectDefCE9C6CB4D92340A781A479792D144209_4(this, Utility.getDefault(this, vars, "Issuing_Locator", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField)), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), Utility.getDefault(this, vars, "Setuptime", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), Utility.getDefault(this, vars, "ServCostPlan", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), Utility.getDefault(this, vars, "StartOnlyWithCompleteMaterial", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "N", dataField), Utility.getDefault(this, vars, "Qty", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField), Utility.getDefault(this, vars, "PercentRejects", "", "A117A2A8301F47EFA4E03E785FF9CF9D", "ECE46D9675A84540808D61E971782779", "", dataField));
        
      }
    } else {
      data = new WorkStepsECE46D9675A84540808D61E971782779Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(WorkStepsECE46D9675A84540808D61E971782779Data) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "WorkStepsECE46D9675A84540808D61E971782779", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpzssmWorkstepPrpVId", "", "..", "".equals("Y"), "WorkSteps", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strZssm_Workstep_Prp_V_ID));
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
      String result = "var strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\nvar strisComplete=\"" + Utility.getContext(this, vars, "isComplete", windowId) + "\";\n";
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
    WorkStepsECE46D9675A84540808D61E971782779Data data = null;
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
                data.zssmWorkstepPrpVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (WorkStepsECE46D9675A84540808D61E971782779Data.getCurrentDBTimestamp(this, data.zssmWorkstepPrpVId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.zssmWorkstepPrpVId, vars, this);
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
                    data.zssmWorkstepPrpVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Zssm_Workstep_Prp_V_ID", data.zssmWorkstepPrpVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet WorkStepsECE46D9675A84540808D61E971782779. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
