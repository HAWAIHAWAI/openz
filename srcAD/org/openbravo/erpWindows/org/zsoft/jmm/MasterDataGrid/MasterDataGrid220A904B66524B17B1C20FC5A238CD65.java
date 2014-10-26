
package org.openbravo.erpWindows.org.zsoft.jmm.MasterDataGrid;





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

public class MasterDataGrid220A904B66524B17B1C20FC5A238CD65 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(MasterDataGrid220A904B66524B17B1C20FC5A238CD65.class);
  
  private static final String windowId = "BE6055A11F204CB4BB30A2B694D9664F";
  private static final String tabId = "220A904B66524B17B1C20FC5A238CD65";
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
        String strjuwimmOrderstatuscompleteVId = request.getParameter("inpjuwimmOrderstatuscompleteVId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strjuwimmOrderstatuscompleteVId.equals(""))
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

      String strJuwimm_Orderstatuscomplete_V_ID = vars.getGlobalVariable("inpjuwimmOrderstatuscompleteVId", windowId + "|Juwimm_Orderstatuscomplete_V_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|MasterDataGrid220A904B66524B17B1C20FC5A238CD65.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strJuwimm_Orderstatuscomplete_V_ID.equals("")) strJuwimm_Orderstatuscomplete_V_ID = firstElement(vars, tableSQL);
          if (strJuwimm_Orderstatuscomplete_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strJuwimm_Orderstatuscomplete_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strJuwimm_Orderstatuscomplete_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strJuwimm_Orderstatuscomplete_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strJuwimm_Orderstatuscomplete_V_ID.equals("")) strJuwimm_Orderstatuscomplete_V_ID = vars.getRequiredGlobalVariable("inpjuwimmOrderstatuscompleteVId", windowId + "|Juwimm_Orderstatuscomplete_V_ID");
      else vars.setSessionValue(windowId + "|Juwimm_Orderstatuscomplete_V_ID", strJuwimm_Orderstatuscomplete_V_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|MasterDataGrid220A904B66524B17B1C20FC5A238CD65.view", "EDIT");

        printPageEdit(response, request, vars, false, strJuwimm_Orderstatuscomplete_V_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|MasterDataGrid220A904B66524B17B1C20FC5A238CD65.view", "RELATION");
        printPageDataSheet(response, vars, strJuwimm_Orderstatuscomplete_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|MasterDataGrid220A904B66524B17B1C20FC5A238CD65.view");
      String strJuwimm_Orderstatuscomplete_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strJuwimm_Orderstatuscomplete_V_ID = firstElement(vars, tableSQL);
          if (strJuwimm_Orderstatuscomplete_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strJuwimm_Orderstatuscomplete_V_ID.equals("")) strJuwimm_Orderstatuscomplete_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strJuwimm_Orderstatuscomplete_V_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamAD_Org_ID", tabId + "|paramAD_Org_ID");
vars.getRequestGlobalVariable("inpParamDocumentNo", tabId + "|paramDocumentNo");
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamPOReference", tabId + "|paramPOReference");
vars.getRequestGlobalVariable("inpParamDateOrdered", tabId + "|paramDateOrdered");
vars.getRequestGlobalVariable("inpParamC_BPartner_ID", tabId + "|paramC_BPartner_ID");
vars.getRequestGlobalVariable("inpParamAD_User_ID", tabId + "|paramAD_User_ID");
vars.getRequestGlobalVariable("inpParambpzipcode", tabId + "|parambpzipcode");
vars.getRequestGlobalVariable("inpParamC_Project_ID", tabId + "|paramC_Project_ID");
vars.getRequestGlobalVariable("inpParamA_Asset_ID", tabId + "|paramA_Asset_ID");
vars.getRequestGlobalVariable("inpParamSalesRep_ID", tabId + "|paramSalesRep_ID");
vars.getRequestGlobalVariable("inpParamGrandTotal", tabId + "|paramGrandTotal");
vars.getRequestGlobalVariable("inpParamInvoiceRule", tabId + "|paramInvoiceRule");
vars.getRequestGlobalVariable("inpParamDatePromised", tabId + "|paramDatePromised");
vars.getRequestGlobalVariable("inpParamC_DocType_ID", tabId + "|paramC_DocType_ID");
vars.getRequestGlobalVariable("inpParamDocStatus", tabId + "|paramDocStatus");
vars.getRequestGlobalVariable("inpParamProposalstatus", tabId + "|paramProposalstatus");
vars.getRequestGlobalVariable("inpParamContractdate", tabId + "|paramContractdate");
vars.getRequestGlobalVariable("inpParamEnddate", tabId + "|paramEnddate");
vars.getRequestGlobalVariable("inpParamSchedtransactiondate", tabId + "|paramSchedtransactiondate");
vars.getRequestGlobalVariable("inpParamTransactiondate", tabId + "|paramTransactiondate");
vars.getRequestGlobalVariable("inpParamIscompletelyinvoiced", tabId + "|paramIscompletelyinvoiced");
vars.getRequestGlobalVariable("inpParamTransactionreference", tabId + "|paramTransactionreference");
vars.getRequestGlobalVariable("inpParamDeliverycomplete", tabId + "|paramDeliverycomplete");
vars.getRequestGlobalVariable("inpParamJuwimm_Completion", tabId + "|paramJuwimm_Completion");
vars.getRequestGlobalVariable("inpParamJuwimm_Time", tabId + "|paramJuwimm_Time");
vars.getRequestGlobalVariable("inpParamJuwimm_Resources", tabId + "|paramJuwimm_Resources");
vars.getRequestGlobalVariable("inpParamJuwimm_Budget", tabId + "|paramJuwimm_Budget");
vars.getRequestGlobalVariable("inpParamJuwimm_Team_ID", tabId + "|paramJuwimm_Team_ID");
vars.getRequestGlobalVariable("inpParamJuwimm_Plannedgolive", tabId + "|paramJuwimm_Plannedgolive");
vars.getRequestGlobalVariable("inpParamJuwimm_Estgolive", tabId + "|paramJuwimm_Estgolive");
vars.getRequestGlobalVariable("inpParamJuwimm_Nextimpdate", tabId + "|paramJuwimm_Nextimpdate");
vars.getRequestGlobalVariable("inpParamJuwimm_Plannedstart", tabId + "|paramJuwimm_Plannedstart");
vars.getRequestGlobalVariable("inpParamJuwimm_Eststart", tabId + "|paramJuwimm_Eststart");
vars.getRequestGlobalVariable("inpParamJuwimm_Plannedend", tabId + "|paramJuwimm_Plannedend");
vars.getRequestGlobalVariable("inpParamJuwimm_Estend", tabId + "|paramJuwimm_Estend");
vars.getRequestGlobalVariable("inpParamJuwimm_Lastupdateon", tabId + "|paramJuwimm_Lastupdateon");
vars.getRequestGlobalVariable("inpParamJuwimm_Lastupdateby", tabId + "|paramJuwimm_Lastupdateby");
vars.getRequestGlobalVariable("inpParamDateOrdered_f", tabId + "|paramDateOrdered_f");
vars.getRequestGlobalVariable("inpParamGrandTotal_f", tabId + "|paramGrandTotal_f");
vars.getRequestGlobalVariable("inpParamDatePromised_f", tabId + "|paramDatePromised_f");
vars.getRequestGlobalVariable("inpParamContractdate_f", tabId + "|paramContractdate_f");
vars.getRequestGlobalVariable("inpParamEnddate_f", tabId + "|paramEnddate_f");
vars.getRequestGlobalVariable("inpParamSchedtransactiondate_f", tabId + "|paramSchedtransactiondate_f");
vars.getRequestGlobalVariable("inpParamTransactiondate_f", tabId + "|paramTransactiondate_f");
vars.getRequestGlobalVariable("inpParamJuwimm_Plannedgolive_f", tabId + "|paramJuwimm_Plannedgolive_f");
vars.getRequestGlobalVariable("inpParamJuwimm_Estgolive_f", tabId + "|paramJuwimm_Estgolive_f");
vars.getRequestGlobalVariable("inpParamJuwimm_Nextimpdate_f", tabId + "|paramJuwimm_Nextimpdate_f");
vars.getRequestGlobalVariable("inpParamJuwimm_Plannedstart_f", tabId + "|paramJuwimm_Plannedstart_f");
vars.getRequestGlobalVariable("inpParamJuwimm_Eststart_f", tabId + "|paramJuwimm_Eststart_f");
vars.getRequestGlobalVariable("inpParamJuwimm_Plannedend_f", tabId + "|paramJuwimm_Plannedend_f");
vars.getRequestGlobalVariable("inpParamJuwimm_Estend_f", tabId + "|paramJuwimm_Estend_f");
vars.getRequestGlobalVariable("inpParamJuwimm_Lastupdateon_f", tabId + "|paramJuwimm_Lastupdateon_f");

      
      
      vars.removeSessionValue(windowId + "|Juwimm_Orderstatuscomplete_V_ID");
      String strJuwimm_Orderstatuscomplete_V_ID="";

      String strView = vars.getSessionValue(tabId + "|MasterDataGrid220A904B66524B17B1C20FC5A238CD65.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strJuwimm_Orderstatuscomplete_V_ID = firstElement(vars, tableSQL);
        if (strJuwimm_Orderstatuscomplete_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|MasterDataGrid220A904B66524B17B1C20FC5A238CD65.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strJuwimm_Orderstatuscomplete_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strJuwimm_Orderstatuscomplete_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strJuwimm_Orderstatuscomplete_V_ID = vars.getGlobalVariable("inpjuwimmOrderstatuscompleteVId", windowId + "|Juwimm_Orderstatuscomplete_V_ID", "");
      vars.setSessionValue(tabId + "|MasterDataGrid220A904B66524B17B1C20FC5A238CD65.view", "RELATION");
      printPageDataSheet(response, vars, strJuwimm_Orderstatuscomplete_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strJuwimm_Orderstatuscomplete_V_ID = vars.getGlobalVariable("inpjuwimmOrderstatuscompleteVId", windowId + "|Juwimm_Orderstatuscomplete_V_ID", "");
      vars.setSessionValue(tabId + "|MasterDataGrid220A904B66524B17B1C20FC5A238CD65.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strJuwimm_Orderstatuscomplete_V_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strJuwimm_Orderstatuscomplete_V_ID = vars.getRequiredStringParameter("inpjuwimmOrderstatuscompleteVId");
      
      String strNext = nextElement(vars, strJuwimm_Orderstatuscomplete_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strJuwimm_Orderstatuscomplete_V_ID = vars.getRequiredStringParameter("inpjuwimmOrderstatuscompleteVId");
      
      String strPrevious = previousElement(vars, strJuwimm_Orderstatuscomplete_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|MasterDataGrid220A904B66524B17B1C20FC5A238CD65.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|MasterDataGrid220A904B66524B17B1C20FC5A238CD65.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|MasterDataGrid220A904B66524B17B1C20FC5A238CD65.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|MasterDataGrid220A904B66524B17B1C20FC5A238CD65.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Juwimm_Orderstatuscomplete_V_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|MasterDataGrid220A904B66524B17B1C20FC5A238CD65.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|MasterDataGrid220A904B66524B17B1C20FC5A238CD65.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Juwimm_Orderstatuscomplete_V_ID");

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

      String strJuwimm_Orderstatuscomplete_V_ID = vars.getRequiredGlobalVariable("inpjuwimmOrderstatuscompleteVId", windowId + "|Juwimm_Orderstatuscomplete_V_ID");
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
          String strNext = nextElement(vars, strJuwimm_Orderstatuscomplete_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|Juwimm_Orderstatuscomplete_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strJuwimm_Orderstatuscomplete_V_ID = vars.getRequiredInStringParameter("inpjuwimmOrderstatuscompleteVId");
      String message = deleteRelation(vars, strJuwimm_Orderstatuscomplete_V_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|juwimmOrderstatuscompleteVId");
        vars.setSessionValue(tabId + "|MasterDataGrid220A904B66524B17B1C20FC5A238CD65.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strJuwimm_Orderstatuscomplete_V_ID = vars.getRequiredStringParameter("inpjuwimmOrderstatuscompleteVId");
      //MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.delete(this, strJuwimm_Orderstatuscomplete_V_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|juwimmOrderstatuscompleteVId");
        vars.setSessionValue(tabId + "|MasterDataGrid220A904B66524B17B1C20FC5A238CD65.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strJuwimm_Orderstatuscomplete_V_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strJuwimm_Orderstatuscomplete_V_ID.startsWith("(")) strJuwimm_Orderstatuscomplete_V_ID = strJuwimm_Orderstatuscomplete_V_ID.substring(1, strJuwimm_Orderstatuscomplete_V_ID.length()-1);
      if (!strJuwimm_Orderstatuscomplete_V_ID.equals("")) {
        strJuwimm_Orderstatuscomplete_V_ID = Replace.replace(strJuwimm_Orderstatuscomplete_V_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strJuwimm_Orderstatuscomplete_V_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.deleteTransactional(conn, this, strKey)==0) {
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
  private MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data data = new MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data();
    ServletException ex = null;
    try {
    data.user1Id = vars.getStringParameter("inpuser1Id");     data.isselfservice = vars.getStringParameter("inpisselfservice", "N");     data.adOrgtrxId = vars.getStringParameter("inpadOrgtrxId");     data.dropshipLocationId = vars.getStringParameter("inpdropshipLocationId");     data.copyfrom = vars.getStringParameter("inpcopyfrom");     data.user2Id = vars.getStringParameter("inpuser2Id");     data.dropshipUserId = vars.getStringParameter("inpdropshipUserId");     data.dropshipBpartnerId = vars.getStringParameter("inpdropshipBpartnerId");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.documentno = vars.getStringParameter("inpdocumentno");     data.incotermsdescription = vars.getStringParameter("inpincotermsdescription");     data.poreference = vars.getStringParameter("inpporeference");     data.generatetemplate = vars.getStringParameter("inpgeneratetemplate");     data.dateordered = vars.getRequestGlobalVariable("inpdateordered", windowId + "|DateOrdered");     data.transactionreference = vars.getStringParameter("inptransactionreference");     data.copyfrompo = vars.getStringParameter("inpcopyfrompo");     data.aAssetId = vars.getStringParameter("inpaAssetId");     data.cDoctypetargetId = vars.getRequestGlobalVariable("inpcDoctypetargetId", windowId + "|C_DocTypeTarget_ID");     data.cDoctypetargetIdr = vars.getStringParameter("inpcDoctypetargetId_R");     data.name = vars.getStringParameter("inpname");     data.cDoctypeId = vars.getRequestGlobalVariable("inpcDoctypeId", windowId + "|C_DocType_ID");     data.cDoctypeIdr = vars.getStringParameter("inpcDoctypeId_R");     data.docstatus = vars.getStringParameter("inpdocstatus");     data.docstatusr = vars.getStringParameter("inpdocstatus_R");     data.description = vars.getStringParameter("inpdescription");     data.deliverynotes = vars.getStringParameter("inpdeliverynotes");     data.internalnote = vars.getStringParameter("inpinternalnote");     data.cBpartnerId = vars.getRequestGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.bpzipcode = vars.getStringParameter("inpbpzipcode");     data.billtoId = vars.getStringParameter("inpbilltoId");     data.billtoIdr = vars.getStringParameter("inpbilltoId_R");     data.cBpartnerLocationId = vars.getRequestGlobalVariable("inpcBpartnerLocationId", windowId + "|C_BPartner_Location_ID");     data.cBpartnerLocationIdr = vars.getStringParameter("inpcBpartnerLocationId_R");     data.adUserId = vars.getStringParameter("inpadUserId");     data.adUserIdr = vars.getStringParameter("inpadUserId_R");     data.salesrepId = vars.getStringParameter("inpsalesrepId");     data.salesrepIdr = vars.getStringParameter("inpsalesrepId_R");     data.mPricelistId = vars.getRequestGlobalVariable("inpmPricelistId", windowId + "|M_PriceList_ID");     data.mPricelistIdr = vars.getStringParameter("inpmPricelistId_R");     data.isdiscountprinted = vars.getStringParameter("inpisdiscountprinted", "N");     data.invoicerule = vars.getStringParameter("inpinvoicerule");     data.invoiceruler = vars.getStringParameter("inpinvoicerule_R");     data.estpropability = vars.getStringParameter("inpestpropability");     data.estpropabilityr = vars.getStringParameter("inpestpropability_R");     data.mWarehouseId = vars.getRequestGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");     data.mWarehouseIdr = vars.getStringParameter("inpmWarehouseId_R");     data.cCurrencyId = vars.getRequestGlobalVariable("inpcCurrencyId", windowId + "|C_Currency_ID");     data.cCurrencyIdr = vars.getStringParameter("inpcCurrencyId_R");     data.deliveryrule = vars.getStringParameter("inpdeliveryrule");     data.deliveryruler = vars.getStringParameter("inpdeliveryrule_R");     data.priorityrule = vars.getStringParameter("inppriorityrule");     data.priorityruler = vars.getStringParameter("inppriorityrule_R");     data.paymentrule = vars.getStringParameter("inppaymentrule");     data.paymentruler = vars.getStringParameter("inppaymentrule_R");     data.cPaymenttermId = vars.getStringParameter("inpcPaymenttermId");     data.cPaymenttermIdr = vars.getStringParameter("inpcPaymenttermId_R");     data.cIncotermsId = vars.getStringParameter("inpcIncotermsId");     data.cIncotermsIdr = vars.getStringParameter("inpcIncotermsId_R");     data.deliveryLocationId = vars.getStringParameter("inpdeliveryLocationId");     data.deliveryLocationIdr = vars.getStringParameter("inpdeliveryLocationId_R");     data.deliveryviarule = vars.getRequestGlobalVariable("inpdeliveryviarule", windowId + "|DeliveryViaRule");     data.deliveryviaruler = vars.getStringParameter("inpdeliveryviarule_R");     data.mShipperId = vars.getRequestGlobalVariable("inpmShipperId", windowId + "|M_Shipper_ID");     data.mShipperIdr = vars.getStringParameter("inpmShipperId_R");    try {   data.weight = vars.getNumericParameter("inpweight");  } catch (ServletException paramEx) { ex = paramEx; }     data.weightUom = vars.getStringParameter("inpweightUom");     data.weightUomr = vars.getStringParameter("inpweightUom_R");     data.freightcostrule = vars.getRequestGlobalVariable("inpfreightcostrule", windowId + "|FreightCostRule");     data.freightcostruler = vars.getStringParameter("inpfreightcostrule_R");     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");    try {   data.qty = vars.getNumericParameter("inpqty");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.freightamt = vars.getNumericParameter("inpfreightamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.orderselfjoin = vars.getStringParameter("inporderselfjoin");     data.orderselfjoinr = vars.getStringParameter("inporderselfjoin_R");     data.firstschedinvoicedate = vars.getStringParameter("inpfirstschedinvoicedate");     data.datepromised = vars.getRequestGlobalVariable("inpdatepromised", windowId + "|DatePromised");     data.scheddeliverydate = vars.getRequestGlobalVariable("inpscheddeliverydate", windowId + "|Scheddeliverydate");     data.schedtransactiondate = vars.getStringParameter("inpschedtransactiondate");     data.transactiondate = vars.getStringParameter("inptransactiondate");     data.contractdate = vars.getStringParameter("inpcontractdate");     data.enddate = vars.getStringParameter("inpenddate");     data.invoicefrequence = vars.getStringParameter("inpinvoicefrequence");     data.invoicefrequencer = vars.getStringParameter("inpinvoicefrequence_R");     data.cProjectphaseId = vars.getStringParameter("inpcProjectphaseId");     data.isinvoiceafterfirstcycle = vars.getStringParameter("inpisinvoiceafterfirstcycle", "N");     data.quarterlyMonth = vars.getStringParameter("inpquarterlyMonth");     data.quarterlyMonthr = vars.getStringParameter("inpquarterlyMonth_R");     data.yearlyMonth = vars.getStringParameter("inpyearlyMonth");     data.yearlyMonthr = vars.getStringParameter("inpyearlyMonth_R");     data.weeklyDay = vars.getStringParameter("inpweeklyDay");     data.weeklyDayr = vars.getStringParameter("inpweeklyDay_R");     data.cBidprojectId = vars.getStringParameter("inpcBidprojectId");    try {   data.monthlyDay = vars.getNumericParameter("inpmonthlyDay");  } catch (ServletException paramEx) { ex = paramEx; }     data.proposalstatus = vars.getStringParameter("inpproposalstatus");     data.proposalstatusr = vars.getStringParameter("inpproposalstatus_R");     data.lostproposalfixedreason = vars.getStringParameter("inplostproposalfixedreason");     data.lostproposalfixedreasonr = vars.getStringParameter("inplostproposalfixedreason_R");     data.lostproposalreason = vars.getStringParameter("inplostproposalreason");    try {   data.totallinesonetime = vars.getNumericParameter("inptotallinesonetime");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.grandtotalonetime = vars.getNumericParameter("inpgrandtotalonetime");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.totallines = vars.getNumericParameter("inptotallines");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.grandtotal = vars.getNumericParameter("inpgrandtotal");  } catch (ServletException paramEx) { ex = paramEx; }     data.generateproject = vars.getStringParameter("inpgenerateproject");     data.closeproject = vars.getStringParameter("inpcloseproject");    try {   data.invoicedamt = vars.getNumericParameter("inpinvoicedamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.totalpaid = vars.getNumericParameter("inptotalpaid");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.completeordervalue = vars.getNumericParameter("inpcompleteordervalue");  } catch (ServletException paramEx) { ex = paramEx; }     data.deliverycomplete = vars.getStringParameter("inpdeliverycomplete", "N");     data.iscompletelyinvoiced = vars.getStringParameter("inpiscompletelyinvoiced", "N");     data.juwimmCompletion = vars.getStringParameter("inpjuwimmCompletion");     data.juwimmCompletionr = vars.getStringParameter("inpjuwimmCompletion_R");     data.juwimmTime = vars.getStringParameter("inpjuwimmTime");     data.juwimmTimer = vars.getStringParameter("inpjuwimmTime_R");     data.juwimmResources = vars.getStringParameter("inpjuwimmResources");     data.juwimmResourcesr = vars.getStringParameter("inpjuwimmResources_R");     data.juwimmBudget = vars.getStringParameter("inpjuwimmBudget");     data.juwimmBudgetr = vars.getStringParameter("inpjuwimmBudget_R");     data.juwimmTeamId = vars.getStringParameter("inpjuwimmTeamId");     data.juwimmTeamIdr = vars.getStringParameter("inpjuwimmTeamId_R");     data.juwimmPlannedgolive = vars.getStringParameter("inpjuwimmPlannedgolive");     data.juwimmEstgolive = vars.getStringParameter("inpjuwimmEstgolive");     data.juwimmNextimpdate = vars.getStringParameter("inpjuwimmNextimpdate");     data.juwimmDescription = vars.getStringParameter("inpjuwimmDescription");     data.juwimmPlannedstart = vars.getStringParameter("inpjuwimmPlannedstart");     data.juwimmEststart = vars.getStringParameter("inpjuwimmEststart");     data.juwimmMilestone1 = vars.getStringParameter("inpjuwimmMilestone1");     data.juwimmMs1planneddate = vars.getStringParameter("inpjuwimmMs1planneddate");     data.juwimmMs1estdate = vars.getStringParameter("inpjuwimmMs1estdate");     data.juwimmMilestone2 = vars.getStringParameter("inpjuwimmMilestone2");     data.juwimmMs2planneddate = vars.getStringParameter("inpjuwimmMs2planneddate");     data.juwimmMs2estdate = vars.getStringParameter("inpjuwimmMs2estdate");     data.juwimmMilestone3 = vars.getStringParameter("inpjuwimmMilestone3");     data.juwimmMs3planneddate = vars.getStringParameter("inpjuwimmMs3planneddate");     data.juwimmMs3estdate = vars.getStringParameter("inpjuwimmMs3estdate");     data.juwimmMilestone4 = vars.getStringParameter("inpjuwimmMilestone4");     data.juwimmMs4planneddate = vars.getStringParameter("inpjuwimmMs4planneddate");     data.juwimmMs4estdate = vars.getStringParameter("inpjuwimmMs4estdate");     data.juwimmMilestone5 = vars.getStringParameter("inpjuwimmMilestone5");     data.juwimmMs5planneddate = vars.getStringParameter("inpjuwimmMs5planneddate");     data.ispaid = vars.getStringParameter("inpispaid", "N");     data.isrecharge = vars.getStringParameter("inpisrecharge", "N");     data.juwimmMs5estdate = vars.getStringParameter("inpjuwimmMs5estdate");     data.juwimmMilestone6 = vars.getStringParameter("inpjuwimmMilestone6");     data.btncopytemplate = vars.getStringParameter("inpbtncopytemplate");     data.juwimmMs6planneddate = vars.getStringParameter("inpjuwimmMs6planneddate");     data.juwimmMs6estdate = vars.getStringParameter("inpjuwimmMs6estdate");     data.subscriptionchangedate = vars.getStringParameter("inpsubscriptionchangedate");     data.juwimmMilestone7 = vars.getStringParameter("inpjuwimmMilestone7");     data.juwimmMs7planneddate = vars.getStringParameter("inpjuwimmMs7planneddate");     data.juwimmOrderstatuscompleteVId = vars.getRequestGlobalVariable("inpjuwimmOrderstatuscompleteVId", windowId + "|Juwimm_Orderstatuscomplete_V_ID");     data.juwimmMs7estdate = vars.getStringParameter("inpjuwimmMs7estdate");     data.juwimmPlannedend = vars.getStringParameter("inpjuwimmPlannedend");     data.juwimmOrderstatusId = vars.getStringParameter("inpjuwimmOrderstatusId");     data.juwimmEstend = vars.getStringParameter("inpjuwimmEstend");     data.juwimmProjectman = vars.getStringParameter("inpjuwimmProjectman");     data.juwimmOuputremarks = vars.getStringParameter("inpjuwimmOuputremarks");     data.juwimmLastaction = vars.getStringParameter("inpjuwimmLastaction");     data.juwimmNextaction = vars.getStringParameter("inpjuwimmNextaction");     data.juwimmIssues = vars.getStringParameter("inpjuwimmIssues");     data.juwimmDecisions = vars.getStringParameter("inpjuwimmDecisions");     data.juwimmLastupdateon = vars.getStringParameter("inpjuwimmLastupdateon");     data.juwimmLastupdateby = vars.getStringParameter("inpjuwimmLastupdateby");     data.juwimmLastupdatebyr = vars.getStringParameter("inpjuwimmLastupdateby_R");     data.cChargeId = vars.getStringParameter("inpcChargeId");     data.isdelivered = vars.getStringParameter("inpisdelivered", "N");     data.cActivityId = vars.getStringParameter("inpcActivityId");     data.processed = vars.getRequiredInputGlobalVariable("inpprocessed", windowId + "|Processed", "N");     data.issotrx = vars.getRequiredInputGlobalVariable("inpissotrx", windowId + "|IsSOTrx", "N");     data.docaction = vars.getStringParameter("inpdocaction");     data.cCampaignId = vars.getStringParameter("inpcCampaignId");     data.istaxincluded = vars.getStringParameter("inpistaxincluded", "N");     data.dateprinted = vars.getStringParameter("inpdateprinted");     data.isinvoiced = vars.getStringParameter("inpisinvoiced", "N");     data.dateacct = vars.getStringParameter("inpdateacct");     data.cOrderId = vars.getRequestGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");     data.isselected = vars.getStringParameter("inpisselected", "N");     data.isprinted = vars.getStringParameter("inpisprinted", "N");     data.posted = vars.getStringParameter("inpposted");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.processing = vars.getStringParameter("inpprocessing");    try {   data.chargeamt = vars.getNumericParameter("inpchargeamt");  } catch (ServletException paramEx) { ex = paramEx; } 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");



    
         if (data.documentno.startsWith("<")) data.documentno = Utility.getDocumentNo(con, this, vars, windowId, "juwimm_orderstatuscomplete_v", data.cDoctypetargetId, data.cDoctypeId, false, true);

    
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

   private MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[] getRelationData(MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].user1Id = FormatUtilities.truncate(data[i].user1Id, 44);        data[i].adOrgtrxId = FormatUtilities.truncate(data[i].adOrgtrxId, 44);        data[i].dropshipLocationId = FormatUtilities.truncate(data[i].dropshipLocationId, 44);        data[i].user2Id = FormatUtilities.truncate(data[i].user2Id, 44);        data[i].dropshipUserId = FormatUtilities.truncate(data[i].dropshipUserId, 44);        data[i].dropshipBpartnerId = FormatUtilities.truncate(data[i].dropshipBpartnerId, 44);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].documentno = FormatUtilities.truncate(data[i].documentno, 8);        data[i].incotermsdescription = FormatUtilities.truncate(data[i].incotermsdescription, 50);        data[i].poreference = FormatUtilities.truncate(data[i].poreference, 11);        data[i].transactionreference = FormatUtilities.truncate(data[i].transactionreference, 32);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, 32);        data[i].cDoctypetargetId = FormatUtilities.truncate(data[i].cDoctypetargetId, 44);        data[i].name = FormatUtilities.truncate(data[i].name, 30);        data[i].cDoctypeId = FormatUtilities.truncate(data[i].cDoctypeId, 12);        data[i].docstatus = FormatUtilities.truncate(data[i].docstatus, 16);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].deliverynotes = FormatUtilities.truncate(data[i].deliverynotes, 50);        data[i].internalnote = FormatUtilities.truncate(data[i].internalnote, 50);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 34);        data[i].bpzipcode = FormatUtilities.truncate(data[i].bpzipcode, 10);        data[i].billtoId = FormatUtilities.truncate(data[i].billtoId, 40);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 44);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 20);        data[i].salesrepId = FormatUtilities.truncate(data[i].salesrepId, 48);        data[i].mPricelistId = FormatUtilities.truncate(data[i].mPricelistId, 44);        data[i].invoicerule = FormatUtilities.truncate(data[i].invoicerule, 20);        data[i].estpropability = FormatUtilities.truncate(data[i].estpropability, 10);        data[i].mWarehouseId = FormatUtilities.truncate(data[i].mWarehouseId, 44);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 20);        data[i].deliveryrule = FormatUtilities.truncate(data[i].deliveryrule, 21);        data[i].priorityrule = FormatUtilities.truncate(data[i].priorityrule, 21);        data[i].paymentrule = FormatUtilities.truncate(data[i].paymentrule, 20);        data[i].cPaymenttermId = FormatUtilities.truncate(data[i].cPaymenttermId, 48);        data[i].cIncotermsId = FormatUtilities.truncate(data[i].cIncotermsId, 44);        data[i].deliveryLocationId = FormatUtilities.truncate(data[i].deliveryLocationId, 44);        data[i].deliveryviarule = FormatUtilities.truncate(data[i].deliveryviarule, 21);        data[i].mShipperId = FormatUtilities.truncate(data[i].mShipperId, 44);        data[i].weightUom = FormatUtilities.truncate(data[i].weightUom, 32);        data[i].freightcostrule = FormatUtilities.truncate(data[i].freightcostrule, 21);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 44);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].orderselfjoin = FormatUtilities.truncate(data[i].orderselfjoin, 32);        data[i].invoicefrequence = FormatUtilities.truncate(data[i].invoicefrequence, 20);        data[i].cProjectphaseId = FormatUtilities.truncate(data[i].cProjectphaseId, 32);        data[i].quarterlyMonth = FormatUtilities.truncate(data[i].quarterlyMonth, 50);        data[i].yearlyMonth = FormatUtilities.truncate(data[i].yearlyMonth, 50);        data[i].weeklyDay = FormatUtilities.truncate(data[i].weeklyDay, 50);        data[i].cBidprojectId = FormatUtilities.truncate(data[i].cBidprojectId, 32);        data[i].proposalstatus = FormatUtilities.truncate(data[i].proposalstatus, 30);        data[i].lostproposalfixedreason = FormatUtilities.truncate(data[i].lostproposalfixedreason, 30);        data[i].lostproposalreason = FormatUtilities.truncate(data[i].lostproposalreason, 50);        data[i].juwimmCompletion = FormatUtilities.truncate(data[i].juwimmCompletion, 16);        data[i].juwimmTime = FormatUtilities.truncate(data[i].juwimmTime, 16);        data[i].juwimmResources = FormatUtilities.truncate(data[i].juwimmResources, 16);        data[i].juwimmBudget = FormatUtilities.truncate(data[i].juwimmBudget, 16);        data[i].juwimmTeamId = FormatUtilities.truncate(data[i].juwimmTeamId, 32);        data[i].juwimmDescription = FormatUtilities.truncate(data[i].juwimmDescription, 50);        data[i].juwimmMilestone1 = FormatUtilities.truncate(data[i].juwimmMilestone1, 15);        data[i].juwimmMilestone2 = FormatUtilities.truncate(data[i].juwimmMilestone2, 15);        data[i].juwimmMilestone3 = FormatUtilities.truncate(data[i].juwimmMilestone3, 15);        data[i].juwimmMilestone4 = FormatUtilities.truncate(data[i].juwimmMilestone4, 15);        data[i].juwimmMilestone5 = FormatUtilities.truncate(data[i].juwimmMilestone5, 15);        data[i].juwimmMilestone6 = FormatUtilities.truncate(data[i].juwimmMilestone6, 15);        data[i].juwimmMilestone7 = FormatUtilities.truncate(data[i].juwimmMilestone7, 15);        data[i].juwimmOrderstatuscompleteVId = FormatUtilities.truncate(data[i].juwimmOrderstatuscompleteVId, 32);        data[i].juwimmOrderstatusId = FormatUtilities.truncate(data[i].juwimmOrderstatusId, 32);        data[i].juwimmProjectman = FormatUtilities.truncate(data[i].juwimmProjectman, 32);        data[i].juwimmOuputremarks = FormatUtilities.truncate(data[i].juwimmOuputremarks, 50);        data[i].juwimmLastaction = FormatUtilities.truncate(data[i].juwimmLastaction, 50);        data[i].juwimmNextaction = FormatUtilities.truncate(data[i].juwimmNextaction, 50);        data[i].juwimmIssues = FormatUtilities.truncate(data[i].juwimmIssues, 50);        data[i].juwimmDecisions = FormatUtilities.truncate(data[i].juwimmDecisions, 50);        data[i].juwimmLastupdateby = FormatUtilities.truncate(data[i].juwimmLastupdateby, 32);        data[i].cChargeId = FormatUtilities.truncate(data[i].cChargeId, 44);        data[i].cActivityId = FormatUtilities.truncate(data[i].cActivityId, 44);        data[i].cCampaignId = FormatUtilities.truncate(data[i].cCampaignId, 44);        data[i].cOrderId = FormatUtilities.truncate(data[i].cOrderId, 10);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|DateOrdered", data[0].getField("dateordered"));    vars.setSessionValue(windowId + "|C_DocTypeTarget_ID", data[0].getField("cDoctypetargetId"));    vars.setSessionValue(windowId + "|C_DocType_ID", data[0].getField("cDoctypeId"));    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].getField("cBpartnerId"));    vars.setSessionValue(windowId + "|C_BPartner_Location_ID", data[0].getField("cBpartnerLocationId"));    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].getField("mPricelistId"));    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].getField("mWarehouseId"));    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].getField("cCurrencyId"));    vars.setSessionValue(windowId + "|DeliveryViaRule", data[0].getField("deliveryviarule"));    vars.setSessionValue(windowId + "|M_Shipper_ID", data[0].getField("mShipperId"));    vars.setSessionValue(windowId + "|FreightCostRule", data[0].getField("freightcostrule"));    vars.setSessionValue(windowId + "|DatePromised", data[0].getField("datepromised"));    vars.setSessionValue(windowId + "|Scheddeliverydate", data[0].getField("scheddeliverydate"));    vars.setSessionValue(windowId + "|Juwimm_Orderstatuscomplete_V_ID", data[0].getField("juwimmOrderstatuscompleteVId"));    vars.setSessionValue(windowId + "|C_Order_ID", data[0].getField("cOrderId"));    vars.setSessionValue(windowId + "|Processed", data[0].getField("processed"));    vars.setSessionValue(windowId + "|IsSOTrx", data[0].getField("issotrx"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[] data = MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpjuwimmOrderstatuscompleteVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strJuwimm_Orderstatuscomplete_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamDocumentNo = vars.getSessionValue(tabId + "|paramDocumentNo");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamPOReference = vars.getSessionValue(tabId + "|paramPOReference");
String strParamDateOrdered = vars.getSessionValue(tabId + "|paramDateOrdered");
String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParamAD_User_ID = vars.getSessionValue(tabId + "|paramAD_User_ID");
String strParambpzipcode = vars.getSessionValue(tabId + "|parambpzipcode");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamA_Asset_ID = vars.getSessionValue(tabId + "|paramA_Asset_ID");
String strParamSalesRep_ID = vars.getSessionValue(tabId + "|paramSalesRep_ID");
String strParamGrandTotal = vars.getSessionValue(tabId + "|paramGrandTotal");
String strParamInvoiceRule = vars.getSessionValue(tabId + "|paramInvoiceRule");
String strParamDatePromised = vars.getSessionValue(tabId + "|paramDatePromised");
String strParamC_DocType_ID = vars.getSessionValue(tabId + "|paramC_DocType_ID");
String strParamDocStatus = vars.getSessionValue(tabId + "|paramDocStatus");
String strParamProposalstatus = vars.getSessionValue(tabId + "|paramProposalstatus");
String strParamContractdate = vars.getSessionValue(tabId + "|paramContractdate");
String strParamEnddate = vars.getSessionValue(tabId + "|paramEnddate");
String strParamSchedtransactiondate = vars.getSessionValue(tabId + "|paramSchedtransactiondate");
String strParamTransactiondate = vars.getSessionValue(tabId + "|paramTransactiondate");
String strParamIscompletelyinvoiced = vars.getSessionValue(tabId + "|paramIscompletelyinvoiced");
String strParamTransactionreference = vars.getSessionValue(tabId + "|paramTransactionreference");
String strParamDeliverycomplete = vars.getSessionValue(tabId + "|paramDeliverycomplete");
String strParamJuwimm_Completion = vars.getSessionValue(tabId + "|paramJuwimm_Completion");
String strParamJuwimm_Time = vars.getSessionValue(tabId + "|paramJuwimm_Time");
String strParamJuwimm_Resources = vars.getSessionValue(tabId + "|paramJuwimm_Resources");
String strParamJuwimm_Budget = vars.getSessionValue(tabId + "|paramJuwimm_Budget");
String strParamJuwimm_Team_ID = vars.getSessionValue(tabId + "|paramJuwimm_Team_ID");
String strParamJuwimm_Plannedgolive = vars.getSessionValue(tabId + "|paramJuwimm_Plannedgolive");
String strParamJuwimm_Estgolive = vars.getSessionValue(tabId + "|paramJuwimm_Estgolive");
String strParamJuwimm_Nextimpdate = vars.getSessionValue(tabId + "|paramJuwimm_Nextimpdate");
String strParamJuwimm_Plannedstart = vars.getSessionValue(tabId + "|paramJuwimm_Plannedstart");
String strParamJuwimm_Eststart = vars.getSessionValue(tabId + "|paramJuwimm_Eststart");
String strParamJuwimm_Plannedend = vars.getSessionValue(tabId + "|paramJuwimm_Plannedend");
String strParamJuwimm_Estend = vars.getSessionValue(tabId + "|paramJuwimm_Estend");
String strParamJuwimm_Lastupdateon = vars.getSessionValue(tabId + "|paramJuwimm_Lastupdateon");
String strParamJuwimm_Lastupdateby = vars.getSessionValue(tabId + "|paramJuwimm_Lastupdateby");
String strParamDateOrdered_f = vars.getSessionValue(tabId + "|paramDateOrdered_f");
String strParamGrandTotal_f = vars.getSessionValue(tabId + "|paramGrandTotal_f");
String strParamDatePromised_f = vars.getSessionValue(tabId + "|paramDatePromised_f");
String strParamContractdate_f = vars.getSessionValue(tabId + "|paramContractdate_f");
String strParamEnddate_f = vars.getSessionValue(tabId + "|paramEnddate_f");
String strParamSchedtransactiondate_f = vars.getSessionValue(tabId + "|paramSchedtransactiondate_f");
String strParamTransactiondate_f = vars.getSessionValue(tabId + "|paramTransactiondate_f");
String strParamJuwimm_Plannedgolive_f = vars.getSessionValue(tabId + "|paramJuwimm_Plannedgolive_f");
String strParamJuwimm_Estgolive_f = vars.getSessionValue(tabId + "|paramJuwimm_Estgolive_f");
String strParamJuwimm_Nextimpdate_f = vars.getSessionValue(tabId + "|paramJuwimm_Nextimpdate_f");
String strParamJuwimm_Plannedstart_f = vars.getSessionValue(tabId + "|paramJuwimm_Plannedstart_f");
String strParamJuwimm_Eststart_f = vars.getSessionValue(tabId + "|paramJuwimm_Eststart_f");
String strParamJuwimm_Plannedend_f = vars.getSessionValue(tabId + "|paramJuwimm_Plannedend_f");
String strParamJuwimm_Estend_f = vars.getSessionValue(tabId + "|paramJuwimm_Estend_f");
String strParamJuwimm_Lastupdateon_f = vars.getSessionValue(tabId + "|paramJuwimm_Lastupdateon_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamAD_Org_ID.equals("") && strParamDocumentNo.equals("") && strParamName.equals("") && strParamPOReference.equals("") && strParamDateOrdered.equals("") && strParamC_BPartner_ID.equals("") && strParamAD_User_ID.equals("") && strParambpzipcode.equals("") && strParamC_Project_ID.equals("") && strParamA_Asset_ID.equals("") && strParamSalesRep_ID.equals("") && strParamGrandTotal.equals("") && strParamInvoiceRule.equals("") && strParamDatePromised.equals("") && strParamC_DocType_ID.equals("") && strParamDocStatus.equals("") && strParamProposalstatus.equals("") && strParamContractdate.equals("") && strParamEnddate.equals("") && strParamSchedtransactiondate.equals("") && strParamTransactiondate.equals("") && strParamIscompletelyinvoiced.equals("") && strParamTransactionreference.equals("") && strParamDeliverycomplete.equals("") && strParamJuwimm_Completion.equals("") && strParamJuwimm_Time.equals("") && strParamJuwimm_Resources.equals("") && strParamJuwimm_Budget.equals("") && strParamJuwimm_Team_ID.equals("") && strParamJuwimm_Plannedgolive.equals("") && strParamJuwimm_Estgolive.equals("") && strParamJuwimm_Nextimpdate.equals("") && strParamJuwimm_Plannedstart.equals("") && strParamJuwimm_Eststart.equals("") && strParamJuwimm_Plannedend.equals("") && strParamJuwimm_Estend.equals("") && strParamJuwimm_Lastupdateon.equals("") && strParamJuwimm_Lastupdateby.equals("") && strParamDateOrdered_f.equals("") && strParamGrandTotal_f.equals("") && strParamDatePromised_f.equals("") && strParamContractdate_f.equals("") && strParamEnddate_f.equals("") && strParamSchedtransactiondate_f.equals("") && strParamTransactiondate_f.equals("") && strParamJuwimm_Plannedgolive_f.equals("") && strParamJuwimm_Estgolive_f.equals("") && strParamJuwimm_Nextimpdate_f.equals("") && strParamJuwimm_Plannedstart_f.equals("") && strParamJuwimm_Eststart_f.equals("") && strParamJuwimm_Plannedend_f.equals("") && strParamJuwimm_Estend_f.equals("") && strParamJuwimm_Lastupdateon_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strJuwimm_Orderstatuscomplete_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strJuwimm_Orderstatuscomplete_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/zsoft/jmm/MasterDataGrid/MasterDataGrid220A904B66524B17B1C20FC5A238CD65_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "MasterDataGrid220A904B66524B17B1C20FC5A238CD65", false, "document.frmMain.inpjuwimmOrderstatuscompleteVId", "grid", "..", "".equals("Y"), "MasterDataGrid", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "juwimmOrderstatuscompleteVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "MasterDataGrid220A904B66524B17B1C20FC5A238CD65_Relation.html", "MasterDataGrid", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "MasterDataGrid220A904B66524B17B1C20FC5A238CD65_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strJuwimm_Orderstatuscomplete_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " juwimm_orderstatuscomplete_v.DocumentNo DESC";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamDocumentNo = vars.getSessionValue(tabId + "|paramDocumentNo");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamPOReference = vars.getSessionValue(tabId + "|paramPOReference");
String strParamDateOrdered = vars.getSessionValue(tabId + "|paramDateOrdered");
String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParamAD_User_ID = vars.getSessionValue(tabId + "|paramAD_User_ID");
String strParambpzipcode = vars.getSessionValue(tabId + "|parambpzipcode");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamA_Asset_ID = vars.getSessionValue(tabId + "|paramA_Asset_ID");
String strParamSalesRep_ID = vars.getSessionValue(tabId + "|paramSalesRep_ID");
String strParamGrandTotal = vars.getSessionValue(tabId + "|paramGrandTotal");
String strParamInvoiceRule = vars.getSessionValue(tabId + "|paramInvoiceRule");
String strParamDatePromised = vars.getSessionValue(tabId + "|paramDatePromised");
String strParamC_DocType_ID = vars.getSessionValue(tabId + "|paramC_DocType_ID");
String strParamDocStatus = vars.getSessionValue(tabId + "|paramDocStatus");
String strParamProposalstatus = vars.getSessionValue(tabId + "|paramProposalstatus");
String strParamContractdate = vars.getSessionValue(tabId + "|paramContractdate");
String strParamEnddate = vars.getSessionValue(tabId + "|paramEnddate");
String strParamSchedtransactiondate = vars.getSessionValue(tabId + "|paramSchedtransactiondate");
String strParamTransactiondate = vars.getSessionValue(tabId + "|paramTransactiondate");
String strParamIscompletelyinvoiced = vars.getSessionValue(tabId + "|paramIscompletelyinvoiced");
String strParamTransactionreference = vars.getSessionValue(tabId + "|paramTransactionreference");
String strParamDeliverycomplete = vars.getSessionValue(tabId + "|paramDeliverycomplete");
String strParamJuwimm_Completion = vars.getSessionValue(tabId + "|paramJuwimm_Completion");
String strParamJuwimm_Time = vars.getSessionValue(tabId + "|paramJuwimm_Time");
String strParamJuwimm_Resources = vars.getSessionValue(tabId + "|paramJuwimm_Resources");
String strParamJuwimm_Budget = vars.getSessionValue(tabId + "|paramJuwimm_Budget");
String strParamJuwimm_Team_ID = vars.getSessionValue(tabId + "|paramJuwimm_Team_ID");
String strParamJuwimm_Plannedgolive = vars.getSessionValue(tabId + "|paramJuwimm_Plannedgolive");
String strParamJuwimm_Estgolive = vars.getSessionValue(tabId + "|paramJuwimm_Estgolive");
String strParamJuwimm_Nextimpdate = vars.getSessionValue(tabId + "|paramJuwimm_Nextimpdate");
String strParamJuwimm_Plannedstart = vars.getSessionValue(tabId + "|paramJuwimm_Plannedstart");
String strParamJuwimm_Eststart = vars.getSessionValue(tabId + "|paramJuwimm_Eststart");
String strParamJuwimm_Plannedend = vars.getSessionValue(tabId + "|paramJuwimm_Plannedend");
String strParamJuwimm_Estend = vars.getSessionValue(tabId + "|paramJuwimm_Estend");
String strParamJuwimm_Lastupdateon = vars.getSessionValue(tabId + "|paramJuwimm_Lastupdateon");
String strParamJuwimm_Lastupdateby = vars.getSessionValue(tabId + "|paramJuwimm_Lastupdateby");
String strParamDateOrdered_f = vars.getSessionValue(tabId + "|paramDateOrdered_f");
String strParamGrandTotal_f = vars.getSessionValue(tabId + "|paramGrandTotal_f");
String strParamDatePromised_f = vars.getSessionValue(tabId + "|paramDatePromised_f");
String strParamContractdate_f = vars.getSessionValue(tabId + "|paramContractdate_f");
String strParamEnddate_f = vars.getSessionValue(tabId + "|paramEnddate_f");
String strParamSchedtransactiondate_f = vars.getSessionValue(tabId + "|paramSchedtransactiondate_f");
String strParamTransactiondate_f = vars.getSessionValue(tabId + "|paramTransactiondate_f");
String strParamJuwimm_Plannedgolive_f = vars.getSessionValue(tabId + "|paramJuwimm_Plannedgolive_f");
String strParamJuwimm_Estgolive_f = vars.getSessionValue(tabId + "|paramJuwimm_Estgolive_f");
String strParamJuwimm_Nextimpdate_f = vars.getSessionValue(tabId + "|paramJuwimm_Nextimpdate_f");
String strParamJuwimm_Plannedstart_f = vars.getSessionValue(tabId + "|paramJuwimm_Plannedstart_f");
String strParamJuwimm_Eststart_f = vars.getSessionValue(tabId + "|paramJuwimm_Eststart_f");
String strParamJuwimm_Plannedend_f = vars.getSessionValue(tabId + "|paramJuwimm_Plannedend_f");
String strParamJuwimm_Estend_f = vars.getSessionValue(tabId + "|paramJuwimm_Estend_f");
String strParamJuwimm_Lastupdateon_f = vars.getSessionValue(tabId + "|paramJuwimm_Lastupdateon_f");

    boolean hasSearchCondition=false;
    if (!(strParamAD_Org_ID.equals("") && strParamDocumentNo.equals("") && strParamName.equals("") && strParamPOReference.equals("") && strParamDateOrdered.equals("") && strParamC_BPartner_ID.equals("") && strParamAD_User_ID.equals("") && strParambpzipcode.equals("") && strParamC_Project_ID.equals("") && strParamA_Asset_ID.equals("") && strParamSalesRep_ID.equals("") && strParamGrandTotal.equals("") && strParamInvoiceRule.equals("") && strParamDatePromised.equals("") && strParamC_DocType_ID.equals("") && strParamDocStatus.equals("") && strParamProposalstatus.equals("") && strParamContractdate.equals("") && strParamEnddate.equals("") && strParamSchedtransactiondate.equals("") && strParamTransactiondate.equals("") && strParamIscompletelyinvoiced.equals("") && strParamTransactionreference.equals("") && strParamDeliverycomplete.equals("") && strParamJuwimm_Completion.equals("") && strParamJuwimm_Time.equals("") && strParamJuwimm_Resources.equals("") && strParamJuwimm_Budget.equals("") && strParamJuwimm_Team_ID.equals("") && strParamJuwimm_Plannedgolive.equals("") && strParamJuwimm_Estgolive.equals("") && strParamJuwimm_Nextimpdate.equals("") && strParamJuwimm_Plannedstart.equals("") && strParamJuwimm_Eststart.equals("") && strParamJuwimm_Plannedend.equals("") && strParamJuwimm_Estend.equals("") && strParamJuwimm_Lastupdateon.equals("") && strParamJuwimm_Lastupdateby.equals("") && strParamDateOrdered_f.equals("") && strParamGrandTotal_f.equals("") && strParamDatePromised_f.equals("") && strParamContractdate_f.equals("") && strParamEnddate_f.equals("") && strParamSchedtransactiondate_f.equals("") && strParamTransactiondate_f.equals("") && strParamJuwimm_Plannedgolive_f.equals("") && strParamJuwimm_Estgolive_f.equals("") && strParamJuwimm_Nextimpdate_f.equals("") && strParamJuwimm_Plannedstart_f.equals("") && strParamJuwimm_Eststart_f.equals("") && strParamJuwimm_Plannedend_f.equals("") && strParamJuwimm_Estend_f.equals("") && strParamJuwimm_Lastupdateon_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strJuwimm_Orderstatuscomplete_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strJuwimm_Orderstatuscomplete_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("juwimmOrderstatuscompleteVId") == null || dataField.getField("juwimmOrderstatuscompleteVId").equals("")) {
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
        data = MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.set(Utility.getDefault(this, vars, "Juwimm_Completion", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms6planneddate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Processed", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "Proposalstatus", "OP", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "IsSelected", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.selectDef4C16A28F3F8D4000A99034B2DA013578_0(this, Utility.getDefault(this, vars, "UpdatedBy", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField)), Utility.getDefault(this, vars, "C_BPartner_Location_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "C_Activity_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "DeliveryViaRule", "P", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms3planneddate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Transactiondate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Projectman", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Ispaid", "N", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "Juwimm_Ms3estdate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "M_Warehouse_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "IsTaxIncluded", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "M_PriceList_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Internalnote", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "SalesRep_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "GrandTotal", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Milestone4", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "C_Currency_ID", "@C_Currency_ID@", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Name", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "DropShip_User_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms2estdate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Totallinesonetime", "0", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "DatePromised", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "DeliveryRule", "A", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Schedtransactiondate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "C_Campaign_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "A_Asset_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Estend", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Contractdate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "TotalLines", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Monthly_Day", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "C_Projecttask_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@#AD_Org_ID@", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Plannedstart", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms4planneddate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "DateAcct", "@#Date@", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "BillTo_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "InvoiceRule", "D", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Plannedend", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "DatePrinted", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Transactionreference", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Nextaction", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Closeproject", "N", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "Subscriptionchangedate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "User1_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Invoicefrequence", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "C_Incoterms_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "C_DocTypeTarget_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "FreightCostRule", "I", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Orderselfjoin", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Milestone2", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "CopyFromPO", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "IsDelivered", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "DateOrdered", "@#Date@", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "C_Bidproject_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Milestone7", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), "", Utility.getDefault(this, vars, "Juwimm_Ms2planneddate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Milestone5", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "C_PaymentTerm_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Milestone3", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "POReference", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Lastupdateon", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Deliverycomplete", "N", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "PaymentRule", "B", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Weight_Uom", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "IsDiscountPrinted", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "Lostproposalreason", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Firstschedinvoicedate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Decisions", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Generateproject", "N", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "C_BPartner_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.selectDef5961FEB7B1ED4D9DA0E25AC7BAA35D72_1(this, Utility.getDefault(this, vars, "C_BPartner_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField)), Utility.getDefault(this, vars, "Juwimm_Lastupdateby", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Incotermsdescription", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Isinvoiceafterfirstcycle", "Y", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "Juwimm_Budget", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Processing", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "Enddate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms4estdate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), "", Utility.getDefault(this, vars, "Juwimm_Description", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Estgolive", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "PriorityRule", "5", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Team_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Iscompletelyinvoiced", "N", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "Juwimm_Milestone1", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms1estdate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms7planneddate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Totalpaid", "0", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Nextimpdate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "IsSelfService", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "Deliverynotes", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "User2_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Yearly_Month", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Weekly_Day", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "bpzipcode", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Delivery_Location_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Quarterly_Month", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Lostproposalfixedreason", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "C_Project_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.selectDef15980CB5975542D7958C5B8E7B3786D5_2(this, Utility.getDefault(this, vars, "C_Project_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField)), Utility.getDefault(this, vars, "DropShip_Location_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "IsPrinted", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "Juwimm_Plannedgolive", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Description", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Qty", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Grandtotalonetime", "0", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms7estdate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Resources", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Generatetemplate", "N", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "Juwimm_Milestone6", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Isrecharge", "Y", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "C_Charge_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Estpropability", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms6estdate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "DocStatus", "DR", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "C_DocType_ID", "0", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Eststart", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "DropShip_BPartner_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Completeordervalue", "0", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "BtnCopyTemplate", "N", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "Juwimm_Issues", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "IsSOTrx", "@IsSOTrx@", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "M_Shipper_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "AD_OrgTrx_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Orderstatus_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "CopyFrom", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), "Y", Utility.getDefault(this, vars, "Posted", "N", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "Juwimm_Ms1planneddate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Weight", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "C_Projectphase_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Time", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "DocAction", "CO", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.selectDefDFB6035568AB4F4AB29F9EAB792AEA7B_3(this, Utility.getDefault(this, vars, "CreatedBy", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField)), Utility.getDefault(this, vars, "Juwimm_Ouputremarks", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "IsInvoiced", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "N", dataField), Utility.getDefault(this, vars, "Juwimm_Ms5estdate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "AD_User_ID", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Invoicedamt", "0", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "DocumentNo", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Lastaction", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "ChargeAmt", "0", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Scheddeliverydate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "FreightAmt", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField), Utility.getDefault(this, vars, "Juwimm_Ms5planneddate", "", "BE6055A11F204CB4BB30A2B694D9664F", "220A904B66524B17B1C20FC5A238CD65", "", dataField));
             data[0].documentno = "<" + Utility.getDocumentNo( this, vars, windowId, "juwimm_orderstatuscomplete_v", vars.getSessionValue(windowId + "|C_DocTypeTarget_ID"), vars.getSessionValue(windowId + "|C_DocType_ID"), false, false) + ">";
      }
    } else {
      data = new MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "MasterDataGrid220A904B66524B17B1C20FC5A238CD65", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpjuwimmOrderstatuscompleteVId", "", "..", "".equals("Y"), "MasterDataGrid", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strJuwimm_Orderstatuscomplete_V_ID));
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
    MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data data = null;
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
                data.juwimmOrderstatuscompleteVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.getCurrentDBTimestamp(this, data.juwimmOrderstatuscompleteVId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.juwimmOrderstatuscompleteVId, vars, this);
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
                    data.juwimmOrderstatuscompleteVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Juwimm_Orderstatuscomplete_V_ID", data.juwimmOrderstatuscompleteVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet MasterDataGrid220A904B66524B17B1C20FC5A238CD65. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
