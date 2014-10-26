
package org.openbravo.erpWindows.Product;





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

public class BatchNumberTransactions extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(BatchNumberTransactions.class);
  
  private static final String windowId = "140";
  private static final String tabId = "34C87156AB954D2C846CBF000F8402D3";
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
        String strsnrSerialnumbertrackingId = request.getParameter("inpsnrSerialnumbertrackingId");
         String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strsnrSerialnumbertrackingId.equals(""))
              total = saveRecord(vars, myError, 'U', strPSNR_Batchmasterdata_ID);
          else
              total = saveRecord(vars, myError, 'I', strPSNR_Batchmasterdata_ID);
          
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
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID", "");

      String strSNR_Serialnumbertracking_ID = vars.getGlobalVariable("inpsnrSerialnumbertrackingId", windowId + "|SNR_Serialnumbertracking_ID", "");
            if (strPSNR_Batchmasterdata_ID.equals("")) {
        strPSNR_Batchmasterdata_ID = getParentID(vars, strSNR_Serialnumbertracking_ID);
        if (strPSNR_Batchmasterdata_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|SNR_Batchmasterdata_ID");
        vars.setSessionValue(windowId + "|SNR_Batchmasterdata_ID", strPSNR_Batchmasterdata_ID);

        refreshParentSession(vars, strPSNR_Batchmasterdata_ID);
      }


      String strView = vars.getSessionValue(tabId + "|BatchNumberTransactions.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strSNR_Serialnumbertracking_ID.equals("")) strSNR_Serialnumbertracking_ID = firstElement(vars, tableSQL);
          if (strSNR_Serialnumbertracking_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strSNR_Serialnumbertracking_ID, strPSNR_Batchmasterdata_ID, tableSQL);

      else printPageDataSheet(response, vars, strPSNR_Batchmasterdata_ID, strSNR_Serialnumbertracking_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strSNR_Serialnumbertracking_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strSNR_Serialnumbertracking_ID.equals("")) strSNR_Serialnumbertracking_ID = vars.getRequiredGlobalVariable("inpsnrSerialnumbertrackingId", windowId + "|SNR_Serialnumbertracking_ID");
      else vars.setSessionValue(windowId + "|SNR_Serialnumbertracking_ID", strSNR_Serialnumbertracking_ID);
      
      
      String strPSNR_Batchmasterdata_ID = getParentID(vars, strSNR_Serialnumbertracking_ID);
      
      vars.setSessionValue(windowId + "|SNR_Batchmasterdata_ID", strPSNR_Batchmasterdata_ID);
      vars.setSessionValue("8596B86FF51C411A909F1432E32840BF|Batch Numbers.view", "EDIT");

      refreshParentSession(vars, strPSNR_Batchmasterdata_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|BatchNumberTransactions.view", "EDIT");

        printPageEdit(response, request, vars, false, strSNR_Serialnumbertracking_ID, strPSNR_Batchmasterdata_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|BatchNumberTransactions.view", "RELATION");
        printPageDataSheet(response, vars, strPSNR_Batchmasterdata_ID, strSNR_Serialnumbertracking_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|SNR_Serialnumbertracking_ID");
      refreshParentSession(vars, strPSNR_Batchmasterdata_ID);


      String strView = vars.getSessionValue(tabId + "|BatchNumberTransactions.view");
      String strSNR_Serialnumbertracking_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strSNR_Serialnumbertracking_ID = firstElement(vars, tableSQL);
          if (strSNR_Serialnumbertracking_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strSNR_Serialnumbertracking_ID.equals("")) strSNR_Serialnumbertracking_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strSNR_Serialnumbertracking_ID, strPSNR_Batchmasterdata_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPSNR_Batchmasterdata_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamAD_Org_ID", tabId + "|paramAD_Org_ID");
vars.getRequestGlobalVariable("inpParamC_Bpartner_ID", tabId + "|paramC_Bpartner_ID");
vars.getRequestGlobalVariable("inpParamMovementtype", tabId + "|paramMovementtype");
vars.getRequestGlobalVariable("inpParamC_Orderline_ID", tabId + "|paramC_Orderline_ID");
vars.getRequestGlobalVariable("inpParamMovementdate", tabId + "|paramMovementdate");
vars.getRequestGlobalVariable("inpParamSerialnumber", tabId + "|paramSerialnumber");
vars.getRequestGlobalVariable("inpParamRfidnumber", tabId + "|paramRfidnumber");
vars.getRequestGlobalVariable("inpParamM_Product_ID", tabId + "|paramM_Product_ID");
vars.getRequestGlobalVariable("inpParamM_Attributesetinstance_ID", tabId + "|paramM_Attributesetinstance_ID");
vars.getRequestGlobalVariable("inpParamM_Inoutline_ID", tabId + "|paramM_Inoutline_ID");
vars.getRequestGlobalVariable("inpParamM_Internal_Consumptionline_ID", tabId + "|paramM_Internal_Consumptionline_ID");
vars.getRequestGlobalVariable("inpParamM_Inventoryline_ID", tabId + "|paramM_Inventoryline_ID");
vars.getRequestGlobalVariable("inpParamM_Movementline_ID", tabId + "|paramM_Movementline_ID");
vars.getRequestGlobalVariable("inpParamGuaranteedate", tabId + "|paramGuaranteedate");
vars.getRequestGlobalVariable("inpParamC_Project_ID", tabId + "|paramC_Project_ID");
vars.getRequestGlobalVariable("inpParamA_Asset_ID", tabId + "|paramA_Asset_ID");
vars.getRequestGlobalVariable("inpParamC_Projecttask_ID", tabId + "|paramC_Projecttask_ID");
vars.getRequestGlobalVariable("inpParamM_Inout_ID", tabId + "|paramM_Inout_ID");
vars.getRequestGlobalVariable("inpParamM_Internal_Consumption_ID", tabId + "|paramM_Internal_Consumption_ID");
vars.getRequestGlobalVariable("inpParamM_Inventory_ID", tabId + "|paramM_Inventory_ID");
vars.getRequestGlobalVariable("inpParamM_Movement_ID", tabId + "|paramM_Movement_ID");
vars.getRequestGlobalVariable("inpParamM_Locator_ID", tabId + "|paramM_Locator_ID");
vars.getRequestGlobalVariable("inpParamDescription", tabId + "|paramDescription");
vars.getRequestGlobalVariable("inpParamDocstatus", tabId + "|paramDocstatus");
vars.getRequestGlobalVariable("inpParamAssembly_Snr", tabId + "|paramAssembly_Snr");
vars.getRequestGlobalVariable("inpParamAssembly_Productid", tabId + "|paramAssembly_Productid");
vars.getRequestGlobalVariable("inpParamMovementdate_f", tabId + "|paramMovementdate_f");
vars.getRequestGlobalVariable("inpParamGuaranteedate_f", tabId + "|paramGuaranteedate_f");

            String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");

      
      vars.removeSessionValue(windowId + "|SNR_Serialnumbertracking_ID");
      String strSNR_Serialnumbertracking_ID="";

      String strView = vars.getSessionValue(tabId + "|BatchNumberTransactions.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strSNR_Serialnumbertracking_ID = firstElement(vars, tableSQL);
        if (strSNR_Serialnumbertracking_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|BatchNumberTransactions.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strSNR_Serialnumbertracking_ID, strPSNR_Batchmasterdata_ID, tableSQL);

      else printPageDataSheet(response, vars, strPSNR_Batchmasterdata_ID, strSNR_Serialnumbertracking_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");
      

      String strSNR_Serialnumbertracking_ID = vars.getGlobalVariable("inpsnrSerialnumbertrackingId", windowId + "|SNR_Serialnumbertracking_ID", "");
      vars.setSessionValue(tabId + "|BatchNumberTransactions.view", "RELATION");
      printPageDataSheet(response, vars, strPSNR_Batchmasterdata_ID, strSNR_Serialnumbertracking_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");


      printPageEdit(response, request, vars, true, "", strPSNR_Batchmasterdata_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strSNR_Serialnumbertracking_ID = vars.getGlobalVariable("inpsnrSerialnumbertrackingId", windowId + "|SNR_Serialnumbertracking_ID", "");
      vars.setSessionValue(tabId + "|BatchNumberTransactions.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strSNR_Serialnumbertracking_ID, strPSNR_Batchmasterdata_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");
      String strSNR_Serialnumbertracking_ID = vars.getRequiredStringParameter("inpsnrSerialnumbertrackingId");
      
      String strNext = nextElement(vars, strSNR_Serialnumbertracking_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPSNR_Batchmasterdata_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");
      String strSNR_Serialnumbertracking_ID = vars.getRequiredStringParameter("inpsnrSerialnumbertrackingId");
      
      String strPrevious = previousElement(vars, strSNR_Serialnumbertracking_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPSNR_Batchmasterdata_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");

      vars.setSessionValue(tabId + "|BatchNumberTransactions.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|BatchNumberTransactions.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|BatchNumberTransactions.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|BatchNumberTransactions.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|SNR_Serialnumbertracking_ID");
      vars.setSessionValue(windowId + "|SNR_Batchmasterdata_ID", strPSNR_Batchmasterdata_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|BatchNumberTransactions.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|BatchNumberTransactions.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|SNR_Serialnumbertracking_ID");
      vars.setSessionValue(windowId + "|SNR_Batchmasterdata_ID", strPSNR_Batchmasterdata_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPSNR_Batchmasterdata_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPSNR_Batchmasterdata_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPSNR_Batchmasterdata_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPSNR_Batchmasterdata_ID);      
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
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");
      String strSNR_Serialnumbertracking_ID = vars.getRequiredGlobalVariable("inpsnrSerialnumbertrackingId", windowId + "|SNR_Serialnumbertracking_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPSNR_Batchmasterdata_ID);      
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
          String strNext = nextElement(vars, strSNR_Serialnumbertracking_ID, tableSQL);
          vars.setSessionValue(windowId + "|SNR_Serialnumbertracking_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");

      String strSNR_Serialnumbertracking_ID = vars.getRequiredInStringParameter("inpsnrSerialnumbertrackingId");
      String message = deleteRelation(vars, strSNR_Serialnumbertracking_ID, strPSNR_Batchmasterdata_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|snrSerialnumbertrackingId");
        vars.setSessionValue(tabId + "|BatchNumberTransactions.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");

      String strSNR_Serialnumbertracking_ID = vars.getRequiredStringParameter("inpsnrSerialnumbertrackingId");
      //BatchNumberTransactionsData data = getEditVariables(vars, strPSNR_Batchmasterdata_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = BatchNumberTransactionsData.delete(this, strSNR_Serialnumbertracking_ID, strPSNR_Batchmasterdata_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|snrSerialnumbertrackingId");
        vars.setSessionValue(tabId + "|BatchNumberTransactions.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strSNR_Serialnumbertracking_ID, String strPSNR_Batchmasterdata_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strSNR_Serialnumbertracking_ID.startsWith("(")) strSNR_Serialnumbertracking_ID = strSNR_Serialnumbertracking_ID.substring(1, strSNR_Serialnumbertracking_ID.length()-1);
      if (!strSNR_Serialnumbertracking_ID.equals("")) {
        strSNR_Serialnumbertracking_ID = Replace.replace(strSNR_Serialnumbertracking_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strSNR_Serialnumbertracking_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (BatchNumberTransactionsData.deleteTransactional(conn, this, strKey, strPSNR_Batchmasterdata_ID)==0) {
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
  private BatchNumberTransactionsData getEditVariables(Connection con, VariablesSecureApp vars, String strPSNR_Batchmasterdata_ID) throws IOException,ServletException {
    BatchNumberTransactionsData data = new BatchNumberTransactionsData();
    ServletException ex = null;
    try {
    data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.lotnumber = vars.getStringParameter("inplotnumber");    try {   data.quantity = vars.getNumericParameter("inpquantity");  } catch (ServletException paramEx) { ex = paramEx; }     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.serialnumber = vars.getStringParameter("inpserialnumber");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.movementdate = vars.getStringParameter("inpmovementdate");     data.mAttributesetinstanceId = vars.getStringParameter("inpmAttributesetinstanceId");     data.mAttributesetinstanceIdr = vars.getStringParameter("inpmAttributesetinstanceId_R");     data.mLocatorId = vars.getStringParameter("inpmLocatorId");     data.mLocatorIdr = vars.getStringParameter("inpmLocatorId_R");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.cOrderlineId = vars.getStringParameter("inpcOrderlineId");     data.cOrderlineIdr = vars.getStringParameter("inpcOrderlineId_R");     data.movementtype = vars.getStringParameter("inpmovementtype");     data.movementtyper = vars.getStringParameter("inpmovementtype_R");     data.mMovementId = vars.getStringParameter("inpmMovementId");     data.mMovementIdr = vars.getStringParameter("inpmMovementId_R");     data.mInventoryId = vars.getStringParameter("inpmInventoryId");     data.mInventoryIdr = vars.getStringParameter("inpmInventoryId_R");     data.mInoutId = vars.getStringParameter("inpmInoutId");     data.mInoutIdr = vars.getStringParameter("inpmInoutId_R");    try {   data.guaranteedays = vars.getNumericParameter("inpguaranteedays");  } catch (ServletException paramEx) { ex = paramEx; }     data.mInternalConsumptionId = vars.getStringParameter("inpmInternalConsumptionId");     data.mInternalConsumptionIdr = vars.getStringParameter("inpmInternalConsumptionId_R");     data.mInoutlineId = vars.getStringParameter("inpmInoutlineId");     data.mInoutlineIdr = vars.getStringParameter("inpmInoutlineId_R");     data.mMovementlineId = vars.getStringParameter("inpmMovementlineId");     data.mMovementlineIdr = vars.getStringParameter("inpmMovementlineId_R");     data.rfidnumber = vars.getStringParameter("inprfidnumber");     data.mInternalConsumptionlineId = vars.getStringParameter("inpmInternalConsumptionlineId");     data.mInternalConsumptionlineIdr = vars.getStringParameter("inpmInternalConsumptionlineId_R");     data.mInventorylineId = vars.getStringParameter("inpmInventorylineId");     data.mInventorylineIdr = vars.getStringParameter("inpmInventorylineId_R");     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.snrSerialnumbertrackingId = vars.getRequestGlobalVariable("inpsnrSerialnumbertrackingId", windowId + "|SNR_Serialnumbertracking_ID");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.aAssetId = vars.getStringParameter("inpaAssetId");     data.aAssetIdr = vars.getStringParameter("inpaAssetId_R");     data.assemblyProductid = vars.getStringParameter("inpassemblyProductid");     data.assemblyProductidr = vars.getStringParameter("inpassemblyProductid_R");     data.assemblySnr = vars.getStringParameter("inpassemblySnr");     data.guaranteedate = vars.getStringParameter("inpguaranteedate");     data.description = vars.getStringParameter("inpdescription");     data.docstatus = vars.getStringParameter("inpdocstatus");     data.snrBatchmasterdataId = vars.getStringParameter("inpsnrBatchmasterdataId"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.snrBatchmasterdataId = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");


    
    

    
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

   private BatchNumberTransactionsData[] getRelationData(BatchNumberTransactionsData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].lotnumber = FormatUtilities.truncate(data[i].lotnumber, 40);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].serialnumber = FormatUtilities.truncate(data[i].serialnumber, 40);        data[i].mAttributesetinstanceId = FormatUtilities.truncate(data[i].mAttributesetinstanceId, 32);        data[i].mLocatorId = FormatUtilities.truncate(data[i].mLocatorId, 32);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 32);        data[i].cOrderlineId = FormatUtilities.truncate(data[i].cOrderlineId, 32);        data[i].movementtype = FormatUtilities.truncate(data[i].movementtype, 50);        data[i].mMovementId = FormatUtilities.truncate(data[i].mMovementId, 50);        data[i].mInventoryId = FormatUtilities.truncate(data[i].mInventoryId, 50);        data[i].mInoutId = FormatUtilities.truncate(data[i].mInoutId, -5);        data[i].mInternalConsumptionId = FormatUtilities.truncate(data[i].mInternalConsumptionId, -5);        data[i].mInoutlineId = FormatUtilities.truncate(data[i].mInoutlineId, -5);        data[i].mMovementlineId = FormatUtilities.truncate(data[i].mMovementlineId, 50);        data[i].rfidnumber = FormatUtilities.truncate(data[i].rfidnumber, 40);        data[i].mInternalConsumptionlineId = FormatUtilities.truncate(data[i].mInternalConsumptionlineId, -5);        data[i].mInventorylineId = FormatUtilities.truncate(data[i].mInventorylineId, 50);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, -5);        data[i].snrSerialnumbertrackingId = FormatUtilities.truncate(data[i].snrSerialnumbertrackingId, 32);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, -5);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, -5);        data[i].assemblyProductid = FormatUtilities.truncate(data[i].assemblyProductid, -5);        data[i].assemblySnr = FormatUtilities.truncate(data[i].assemblySnr, 40);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].docstatus = FormatUtilities.truncate(data[i].docstatus, 50);        data[i].snrBatchmasterdataId = FormatUtilities.truncate(data[i].snrBatchmasterdataId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPSNR_Batchmasterdata_ID) throws IOException,ServletException {
      BatchNumbersData[] data = BatchNumbersData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), Utility.getContext(this, vars, "M_PRODUCT_ID", windowId), strPSNR_Batchmasterdata_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|SNR_Batchmasterdata_ID", data[0].snrBatchmasterdataId);    vars.setSessionValue(windowId + "|Batchnumber", data[0].batchnumber);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);
      vars.setSessionValue(windowId + "|SNR_Batchmasterdata_ID", strPSNR_Batchmasterdata_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strSNR_Serialnumbertracking_ID) throws ServletException {
    String strPSNR_Batchmasterdata_ID = BatchNumberTransactionsData.selectParentID(this, strSNR_Serialnumbertracking_ID);
    if (strPSNR_Batchmasterdata_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strSNR_Serialnumbertracking_ID);
      throw new ServletException("Parent record not found");
    }
    return strPSNR_Batchmasterdata_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|SNR_Serialnumbertracking_ID", data[0].getField("snrSerialnumbertrackingId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPSNR_Batchmasterdata_ID) throws IOException,ServletException {
      BatchNumberTransactionsData[] data = BatchNumberTransactionsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), Utility.getContext(this, vars, "snr_batchmasterdata_ID", windowId), strPSNR_Batchmasterdata_ID, vars.getStringParameter("inpsnrSerialnumbertrackingId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPSNR_Batchmasterdata_ID, String strSNR_Serialnumbertracking_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamC_Bpartner_ID = vars.getSessionValue(tabId + "|paramC_Bpartner_ID");
String strParamMovementtype = vars.getSessionValue(tabId + "|paramMovementtype");
String strParamC_Orderline_ID = vars.getSessionValue(tabId + "|paramC_Orderline_ID");
String strParamMovementdate = vars.getSessionValue(tabId + "|paramMovementdate");
String strParamSerialnumber = vars.getSessionValue(tabId + "|paramSerialnumber");
String strParamRfidnumber = vars.getSessionValue(tabId + "|paramRfidnumber");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamM_Attributesetinstance_ID = vars.getSessionValue(tabId + "|paramM_Attributesetinstance_ID");
String strParamM_Inoutline_ID = vars.getSessionValue(tabId + "|paramM_Inoutline_ID");
String strParamM_Internal_Consumptionline_ID = vars.getSessionValue(tabId + "|paramM_Internal_Consumptionline_ID");
String strParamM_Inventoryline_ID = vars.getSessionValue(tabId + "|paramM_Inventoryline_ID");
String strParamM_Movementline_ID = vars.getSessionValue(tabId + "|paramM_Movementline_ID");
String strParamGuaranteedate = vars.getSessionValue(tabId + "|paramGuaranteedate");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamA_Asset_ID = vars.getSessionValue(tabId + "|paramA_Asset_ID");
String strParamC_Projecttask_ID = vars.getSessionValue(tabId + "|paramC_Projecttask_ID");
String strParamM_Inout_ID = vars.getSessionValue(tabId + "|paramM_Inout_ID");
String strParamM_Internal_Consumption_ID = vars.getSessionValue(tabId + "|paramM_Internal_Consumption_ID");
String strParamM_Inventory_ID = vars.getSessionValue(tabId + "|paramM_Inventory_ID");
String strParamM_Movement_ID = vars.getSessionValue(tabId + "|paramM_Movement_ID");
String strParamM_Locator_ID = vars.getSessionValue(tabId + "|paramM_Locator_ID");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamDocstatus = vars.getSessionValue(tabId + "|paramDocstatus");
String strParamAssembly_Snr = vars.getSessionValue(tabId + "|paramAssembly_Snr");
String strParamAssembly_Productid = vars.getSessionValue(tabId + "|paramAssembly_Productid");
String strParamMovementdate_f = vars.getSessionValue(tabId + "|paramMovementdate_f");
String strParamGuaranteedate_f = vars.getSessionValue(tabId + "|paramGuaranteedate_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamAD_Org_ID.equals("") && strParamC_Bpartner_ID.equals("") && strParamMovementtype.equals("") && strParamC_Orderline_ID.equals("") && strParamMovementdate.equals("") && strParamSerialnumber.equals("") && strParamRfidnumber.equals("") && strParamM_Product_ID.equals("") && strParamM_Attributesetinstance_ID.equals("") && strParamM_Inoutline_ID.equals("") && strParamM_Internal_Consumptionline_ID.equals("") && strParamM_Inventoryline_ID.equals("") && strParamM_Movementline_ID.equals("") && strParamGuaranteedate.equals("") && strParamC_Project_ID.equals("") && strParamA_Asset_ID.equals("") && strParamC_Projecttask_ID.equals("") && strParamM_Inout_ID.equals("") && strParamM_Internal_Consumption_ID.equals("") && strParamM_Inventory_ID.equals("") && strParamM_Movement_ID.equals("") && strParamM_Locator_ID.equals("") && strParamDescription.equals("") && strParamDocstatus.equals("") && strParamAssembly_Snr.equals("") && strParamAssembly_Productid.equals("") && strParamMovementdate_f.equals("") && strParamGuaranteedate_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strSNR_Serialnumbertracking_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strSNR_Serialnumbertracking_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/Product/BatchNumberTransactions_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "BatchNumberTransactions", false, "document.frmMain.inpsnrSerialnumbertrackingId", "grid", "..", "".equals("Y"), "Product", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), true, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPSNR_Batchmasterdata_ID);

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
    xmlDocument.setParameter("KeyName", "snrSerialnumbertrackingId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "BatchNumberTransactions_Relation.html", "Product", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "BatchNumberTransactions_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", BatchNumberTransactionsData.selectParent(this, strPSNR_Batchmasterdata_ID));
    else xmlDocument.setParameter("parent", BatchNumberTransactionsData.selectParentTrl(this, strPSNR_Batchmasterdata_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strSNR_Serialnumbertracking_ID, String strPSNR_Batchmasterdata_ID, TableSQLData tableSQL)
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
    BatchNumberTransactionsData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamC_Bpartner_ID = vars.getSessionValue(tabId + "|paramC_Bpartner_ID");
String strParamMovementtype = vars.getSessionValue(tabId + "|paramMovementtype");
String strParamC_Orderline_ID = vars.getSessionValue(tabId + "|paramC_Orderline_ID");
String strParamMovementdate = vars.getSessionValue(tabId + "|paramMovementdate");
String strParamSerialnumber = vars.getSessionValue(tabId + "|paramSerialnumber");
String strParamRfidnumber = vars.getSessionValue(tabId + "|paramRfidnumber");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamM_Attributesetinstance_ID = vars.getSessionValue(tabId + "|paramM_Attributesetinstance_ID");
String strParamM_Inoutline_ID = vars.getSessionValue(tabId + "|paramM_Inoutline_ID");
String strParamM_Internal_Consumptionline_ID = vars.getSessionValue(tabId + "|paramM_Internal_Consumptionline_ID");
String strParamM_Inventoryline_ID = vars.getSessionValue(tabId + "|paramM_Inventoryline_ID");
String strParamM_Movementline_ID = vars.getSessionValue(tabId + "|paramM_Movementline_ID");
String strParamGuaranteedate = vars.getSessionValue(tabId + "|paramGuaranteedate");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamA_Asset_ID = vars.getSessionValue(tabId + "|paramA_Asset_ID");
String strParamC_Projecttask_ID = vars.getSessionValue(tabId + "|paramC_Projecttask_ID");
String strParamM_Inout_ID = vars.getSessionValue(tabId + "|paramM_Inout_ID");
String strParamM_Internal_Consumption_ID = vars.getSessionValue(tabId + "|paramM_Internal_Consumption_ID");
String strParamM_Inventory_ID = vars.getSessionValue(tabId + "|paramM_Inventory_ID");
String strParamM_Movement_ID = vars.getSessionValue(tabId + "|paramM_Movement_ID");
String strParamM_Locator_ID = vars.getSessionValue(tabId + "|paramM_Locator_ID");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamDocstatus = vars.getSessionValue(tabId + "|paramDocstatus");
String strParamAssembly_Snr = vars.getSessionValue(tabId + "|paramAssembly_Snr");
String strParamAssembly_Productid = vars.getSessionValue(tabId + "|paramAssembly_Productid");
String strParamMovementdate_f = vars.getSessionValue(tabId + "|paramMovementdate_f");
String strParamGuaranteedate_f = vars.getSessionValue(tabId + "|paramGuaranteedate_f");

    boolean hasSearchCondition=false;
    if (!(strParamAD_Org_ID.equals("") && strParamC_Bpartner_ID.equals("") && strParamMovementtype.equals("") && strParamC_Orderline_ID.equals("") && strParamMovementdate.equals("") && strParamSerialnumber.equals("") && strParamRfidnumber.equals("") && strParamM_Product_ID.equals("") && strParamM_Attributesetinstance_ID.equals("") && strParamM_Inoutline_ID.equals("") && strParamM_Internal_Consumptionline_ID.equals("") && strParamM_Inventoryline_ID.equals("") && strParamM_Movementline_ID.equals("") && strParamGuaranteedate.equals("") && strParamC_Project_ID.equals("") && strParamA_Asset_ID.equals("") && strParamC_Projecttask_ID.equals("") && strParamM_Inout_ID.equals("") && strParamM_Internal_Consumption_ID.equals("") && strParamM_Inventory_ID.equals("") && strParamM_Movement_ID.equals("") && strParamM_Locator_ID.equals("") && strParamDescription.equals("") && strParamDocstatus.equals("") && strParamAssembly_Snr.equals("") && strParamAssembly_Productid.equals("") && strParamMovementdate_f.equals("") && strParamGuaranteedate_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = BatchNumberTransactionsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), Utility.getContext(this, vars, "snr_batchmasterdata_ID", windowId), strPSNR_Batchmasterdata_ID, strSNR_Serialnumbertracking_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strSNR_Serialnumbertracking_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (data==null || data.length==0) {
        strSNR_Serialnumbertracking_ID = firstElement(vars, tableSQL);
        if (strSNR_Serialnumbertracking_ID.equals("")) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        } else {
          data = BatchNumberTransactionsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), Utility.getContext(this, vars, "snr_batchmasterdata_ID", windowId), strPSNR_Batchmasterdata_ID, strSNR_Serialnumbertracking_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
        }
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new BatchNumberTransactionsData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("snrSerialnumbertrackingId") == null || dataField.getField("snrSerialnumbertrackingId").equals("")) {
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
        refreshSessionNew(vars, strPSNR_Batchmasterdata_ID);
        data = BatchNumberTransactionsData.set(strPSNR_Batchmasterdata_ID, Utility.getDefault(this, vars, "M_Inoutline_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), BatchNumberTransactionsData.selectDef90CAE05DF99641938BECABEA651659F3_0(this, Utility.getDefault(this, vars, "M_Inoutline_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField)), Utility.getDefault(this, vars, "Assembly_Productid", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), BatchNumberTransactionsData.selectDefA71F774962944D41B980C9C2D5B34669_1(this, Utility.getDefault(this, vars, "Assembly_Productid", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField)), "Y", Utility.getDefault(this, vars, "C_Projecttask_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), "", Utility.getDefault(this, vars, "M_Movement_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "Description", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "Quantity", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "M_Inventoryline_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "Movementdate", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "M_Internal_Consumptionline_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "Guaranteedate", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "Lotnumber", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "M_Movementline_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), BatchNumberTransactionsData.selectDef775B3326D4104402A931CEDBFEA06933_2(this, Utility.getDefault(this, vars, "Createdby", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField)), Utility.getDefault(this, vars, "Movementtype", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "M_Internal_Consumption_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "Assembly_Snr", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), BatchNumberTransactionsData.selectDefABA0AE095068430AAF34BB38C525657A_3(this, Utility.getDefault(this, vars, "Updatedby", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField)), Utility.getDefault(this, vars, "M_Inventory_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "Guaranteedays", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "M_Attributesetinstance_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), BatchNumberTransactionsData.selectDefD6E8C36F2B8F4CC7AB52999AB9D274DA_4(this, Utility.getDefault(this, vars, "M_Attributesetinstance_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField)), Utility.getDefault(this, vars, "M_Inout_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), BatchNumberTransactionsData.selectDefB78C46BB7000448EA0E2B35DF351ADC6_5(this, Utility.getDefault(this, vars, "M_Inout_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField)), Utility.getDefault(this, vars, "C_Bpartner_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), BatchNumberTransactionsData.selectDefFE03AA8BA4B7448088819DDAB664189F_6(this, Utility.getDefault(this, vars, "C_Bpartner_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField)), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "Rfidnumber", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "Docstatus", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "Serialnumber", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "M_Locator_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), BatchNumberTransactionsData.selectDefC25C3D6A592D47C8B084245749AD006C_7(this, Utility.getDefault(this, vars, "M_Locator_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField)), Utility.getDefault(this, vars, "C_Project_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), BatchNumberTransactionsData.selectDef4F68001A1827490B8E25617CCFE9A835_8(this, Utility.getDefault(this, vars, "C_Project_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField)), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), Utility.getDefault(this, vars, "C_Orderline_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), BatchNumberTransactionsData.selectDef8E2C92CCC5F547E998DC56323ADBAB8F_9(this, Utility.getDefault(this, vars, "C_Orderline_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField)), Utility.getDefault(this, vars, "M_Product_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField), BatchNumberTransactionsData.selectDefED4444A033624267A14E465923306FF7_10(this, Utility.getDefault(this, vars, "M_Product_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField)), Utility.getDefault(this, vars, "A_Asset_ID", "", "140", "34C87156AB954D2C846CBF000F8402D3", "", dataField));
        
      }
    } else {
      data = new BatchNumberTransactionsData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(BatchNumberTransactionsData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=BatchNumbersData.selectOrg(this, strPSNR_Batchmasterdata_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "BatchNumberTransactions", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpsnrSerialnumbertrackingId", "", "..", "".equals("Y"), "Product", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strSNR_Serialnumbertracking_ID));
    toolbar.prepareEditionTemplate("N".equals("Y"), hasSearchCondition, vars.getSessionValue("#ShowTest", "N").equals("Y"), "RO", Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPSNR_Batchmasterdata_ID) throws IOException, ServletException {
    BatchNumberTransactionsData data = null;
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
            data = getEditVariables(con, vars, strPSNR_Batchmasterdata_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.snrSerialnumbertrackingId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (BatchNumberTransactionsData.getCurrentDBTimestamp(this, data.snrSerialnumbertrackingId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.snrSerialnumbertrackingId, vars, this);
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
                    data.snrSerialnumbertrackingId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|SNR_Serialnumbertracking_ID", data.snrSerialnumbertrackingId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet BatchNumberTransactions. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
