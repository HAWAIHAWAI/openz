
package org.openbravo.erpWindows.org.openbravo.zsoft.mrp.PurchasingPlan;





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

public class Lines800259 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Lines800259.class);
  
  private static final String windowId = "800097";
  private static final String tabId = "800259";
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
        String strmrpRunPurchaselineId = request.getParameter("inpmrpRunPurchaselineId");
         String strPMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strmrpRunPurchaselineId.equals(""))
              total = saveRecord(vars, myError, 'U', strPMRP_Run_Purchase_ID);
          else
              total = saveRecord(vars, myError, 'I', strPMRP_Run_Purchase_ID);
          
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
      String strPMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID", "");

      String strMRP_Run_Purchaseline_ID = vars.getGlobalVariable("inpmrpRunPurchaselineId", windowId + "|MRP_Run_Purchaseline_ID", "");
            if (strPMRP_Run_Purchase_ID.equals("")) {
        strPMRP_Run_Purchase_ID = getParentID(vars, strMRP_Run_Purchaseline_ID);
        if (strPMRP_Run_Purchase_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|MRP_Run_Purchase_ID");
        vars.setSessionValue(windowId + "|MRP_Run_Purchase_ID", strPMRP_Run_Purchase_ID);

        refreshParentSession(vars, strPMRP_Run_Purchase_ID);
      }


      String strView = vars.getSessionValue(tabId + "|Lines800259.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strMRP_Run_Purchaseline_ID.equals("")) strMRP_Run_Purchaseline_ID = firstElement(vars, tableSQL);
          if (strMRP_Run_Purchaseline_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strMRP_Run_Purchaseline_ID, strPMRP_Run_Purchase_ID, tableSQL);

      else printPageDataSheet(response, vars, strPMRP_Run_Purchase_ID, strMRP_Run_Purchaseline_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strMRP_Run_Purchaseline_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strMRP_Run_Purchaseline_ID.equals("")) strMRP_Run_Purchaseline_ID = vars.getRequiredGlobalVariable("inpmrpRunPurchaselineId", windowId + "|MRP_Run_Purchaseline_ID");
      else vars.setSessionValue(windowId + "|MRP_Run_Purchaseline_ID", strMRP_Run_Purchaseline_ID);
      
      
      String strPMRP_Run_Purchase_ID = getParentID(vars, strMRP_Run_Purchaseline_ID);
      
      vars.setSessionValue(windowId + "|MRP_Run_Purchase_ID", strPMRP_Run_Purchase_ID);
      vars.setSessionValue("800258|Header.view", "EDIT");

      refreshParentSession(vars, strPMRP_Run_Purchase_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Lines800259.view", "EDIT");

        printPageEdit(response, request, vars, false, strMRP_Run_Purchaseline_ID, strPMRP_Run_Purchase_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Lines800259.view", "RELATION");
        printPageDataSheet(response, vars, strPMRP_Run_Purchase_ID, strMRP_Run_Purchaseline_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|MRP_Run_Purchaseline_ID");
      refreshParentSession(vars, strPMRP_Run_Purchase_ID);


      String strView = vars.getSessionValue(tabId + "|Lines800259.view");
      String strMRP_Run_Purchaseline_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strMRP_Run_Purchaseline_ID = firstElement(vars, tableSQL);
          if (strMRP_Run_Purchaseline_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strMRP_Run_Purchaseline_ID.equals("")) strMRP_Run_Purchaseline_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strMRP_Run_Purchaseline_ID, strPMRP_Run_Purchase_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPMRP_Run_Purchase_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamAD_Org_ID", tabId + "|paramAD_Org_ID");
vars.getRequestGlobalVariable("inpParamM_Product_ID", tabId + "|paramM_Product_ID");
vars.getRequestGlobalVariable("inpParamInouttrxtype", tabId + "|paramInouttrxtype");
vars.getRequestGlobalVariable("inpParamC_BPartner_ID", tabId + "|paramC_BPartner_ID");

            String strPMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID");

      
      vars.removeSessionValue(windowId + "|MRP_Run_Purchaseline_ID");
      String strMRP_Run_Purchaseline_ID="";

      String strView = vars.getSessionValue(tabId + "|Lines800259.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strMRP_Run_Purchaseline_ID = firstElement(vars, tableSQL);
        if (strMRP_Run_Purchaseline_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Lines800259.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strMRP_Run_Purchaseline_ID, strPMRP_Run_Purchase_ID, tableSQL);

      else printPageDataSheet(response, vars, strPMRP_Run_Purchase_ID, strMRP_Run_Purchaseline_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID");
      

      String strMRP_Run_Purchaseline_ID = vars.getGlobalVariable("inpmrpRunPurchaselineId", windowId + "|MRP_Run_Purchaseline_ID", "");
      vars.setSessionValue(tabId + "|Lines800259.view", "RELATION");
      printPageDataSheet(response, vars, strPMRP_Run_Purchase_ID, strMRP_Run_Purchaseline_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID");


      printPageEdit(response, request, vars, true, "", strPMRP_Run_Purchase_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strMRP_Run_Purchaseline_ID = vars.getGlobalVariable("inpmrpRunPurchaselineId", windowId + "|MRP_Run_Purchaseline_ID", "");
      vars.setSessionValue(tabId + "|Lines800259.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strMRP_Run_Purchaseline_ID, strPMRP_Run_Purchase_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID");
      String strMRP_Run_Purchaseline_ID = vars.getRequiredStringParameter("inpmrpRunPurchaselineId");
      
      String strNext = nextElement(vars, strMRP_Run_Purchaseline_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPMRP_Run_Purchase_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID");
      String strMRP_Run_Purchaseline_ID = vars.getRequiredStringParameter("inpmrpRunPurchaselineId");
      
      String strPrevious = previousElement(vars, strMRP_Run_Purchaseline_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPMRP_Run_Purchase_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID");

      vars.setSessionValue(tabId + "|Lines800259.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Lines800259.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Lines800259.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Lines800259.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|MRP_Run_Purchaseline_ID");
      vars.setSessionValue(windowId + "|MRP_Run_Purchase_ID", strPMRP_Run_Purchase_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Lines800259.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Lines800259.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|MRP_Run_Purchaseline_ID");
      vars.setSessionValue(windowId + "|MRP_Run_Purchase_ID", strPMRP_Run_Purchase_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPMRP_Run_Purchase_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPMRP_Run_Purchase_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPMRP_Run_Purchase_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPMRP_Run_Purchase_ID);      
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
      String strPMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID");
      String strMRP_Run_Purchaseline_ID = vars.getRequiredGlobalVariable("inpmrpRunPurchaselineId", windowId + "|MRP_Run_Purchaseline_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPMRP_Run_Purchase_ID);      
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
          String strNext = nextElement(vars, strMRP_Run_Purchaseline_ID, tableSQL);
          vars.setSessionValue(windowId + "|MRP_Run_Purchaseline_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID");

      String strMRP_Run_Purchaseline_ID = vars.getRequiredInStringParameter("inpmrpRunPurchaselineId");
      String message = deleteRelation(vars, strMRP_Run_Purchaseline_ID, strPMRP_Run_Purchase_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|mrpRunPurchaselineId");
        vars.setSessionValue(tabId + "|Lines800259.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID");

      String strMRP_Run_Purchaseline_ID = vars.getRequiredStringParameter("inpmrpRunPurchaselineId");
      //Lines800259Data data = getEditVariables(vars, strPMRP_Run_Purchase_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = Lines800259Data.delete(this, strMRP_Run_Purchaseline_ID, strPMRP_Run_Purchase_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|mrpRunPurchaselineId");
        vars.setSessionValue(tabId + "|Lines800259.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strMRP_Run_Purchaseline_ID, String strPMRP_Run_Purchase_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strMRP_Run_Purchaseline_ID.startsWith("(")) strMRP_Run_Purchaseline_ID = strMRP_Run_Purchaseline_ID.substring(1, strMRP_Run_Purchaseline_ID.length()-1);
      if (!strMRP_Run_Purchaseline_ID.equals("")) {
        strMRP_Run_Purchaseline_ID = Replace.replace(strMRP_Run_Purchaseline_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strMRP_Run_Purchaseline_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (Lines800259Data.deleteTransactional(conn, this, strKey, strPMRP_Run_Purchase_ID)==0) {
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
  private Lines800259Data getEditVariables(Connection con, VariablesSecureApp vars, String strPMRP_Run_Purchase_ID) throws IOException,ServletException {
    Lines800259Data data = new Lines800259Data();
    ServletException ex = null;
    try {
    data.mrpRunPurchaseId = vars.getStringParameter("inpmrpRunPurchaseId");     data.mrpRunPurchaseIdr = vars.getStringParameter("inpmrpRunPurchaseId_R");     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");    try {   data.qty = vars.getNumericParameter("inpqty");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.neededqty = vars.getNumericParameter("inpneededqty");  } catch (ServletException paramEx) { ex = paramEx; }     data.planneddate = vars.getStringParameter("inpplanneddate");     data.inouttrxtype = vars.getStringParameter("inpinouttrxtype");     data.inouttrxtyper = vars.getStringParameter("inpinouttrxtype_R");     data.mRequisitionlineId = vars.getStringParameter("inpmRequisitionlineId");     data.mRequisitionlineIdr = vars.getStringParameter("inpmRequisitionlineId_R");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.mrpSalesforecastlineId = vars.getStringParameter("inpmrpSalesforecastlineId");     data.mrpSalesforecastlineIdr = vars.getStringParameter("inpmrpSalesforecastlineId_R");     data.cOrderlineId = vars.getStringParameter("inpcOrderlineId");     data.cOrderlineIdr = vars.getStringParameter("inpcOrderlineId_R");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");    try {   data.pricelist = vars.getNumericParameter("inppricelist");  } catch (ServletException paramEx) { ex = paramEx; }     data.mWarehouseId = vars.getStringParameter("inpmWarehouseId");     data.mWarehouseIdr = vars.getStringParameter("inpmWarehouseId_R");     data.framecontractline = vars.getStringParameter("inpframecontractline");     data.framecontractliner = vars.getStringParameter("inpframecontractline_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.iscompleted = vars.getStringParameter("inpiscompleted", "N");     data.mrpRunPurchaselineId = vars.getRequestGlobalVariable("inpmrpRunPurchaselineId", windowId + "|MRP_Run_Purchaseline_ID");    try {   data.cumqty = vars.getNumericParameter("inpcumqty");  } catch (ServletException paramEx) { ex = paramEx; }     data.isfixed = vars.getStringParameter("inpisfixed", "N");     data.plannedorderdate = vars.getStringParameter("inpplannedorderdate");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.mrpRunPurchaseId = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID");


    
    

    
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

   private Lines800259Data[] getRelationData(Lines800259Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].mrpRunPurchaseId = FormatUtilities.truncate(data[i].mrpRunPurchaseId, 44);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 44);        data[i].inouttrxtype = FormatUtilities.truncate(data[i].inouttrxtype, 27);        data[i].mRequisitionlineId = FormatUtilities.truncate(data[i].mRequisitionlineId, 44);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].mrpSalesforecastlineId = FormatUtilities.truncate(data[i].mrpSalesforecastlineId, 44);        data[i].cOrderlineId = FormatUtilities.truncate(data[i].cOrderlineId, 44);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 44);        data[i].mWarehouseId = FormatUtilities.truncate(data[i].mWarehouseId, 32);        data[i].framecontractline = FormatUtilities.truncate(data[i].framecontractline, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].mrpRunPurchaselineId = FormatUtilities.truncate(data[i].mrpRunPurchaselineId, 10);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPMRP_Run_Purchase_ID) throws IOException,ServletException {
      Header800258Data[] data = Header800258Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPMRP_Run_Purchase_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|MRP_Run_Purchase_ID", data[0].mrpRunPurchaseId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);
      vars.setSessionValue(windowId + "|MRP_Run_Purchase_ID", strPMRP_Run_Purchase_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strMRP_Run_Purchaseline_ID) throws ServletException {
    String strPMRP_Run_Purchase_ID = Lines800259Data.selectParentID(this, strMRP_Run_Purchaseline_ID);
    if (strPMRP_Run_Purchase_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strMRP_Run_Purchaseline_ID);
      throw new ServletException("Parent record not found");
    }
    return strPMRP_Run_Purchase_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|MRP_Run_Purchaseline_ID", data[0].getField("mrpRunPurchaselineId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPMRP_Run_Purchase_ID) throws IOException,ServletException {
      Lines800259Data[] data = Lines800259Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPMRP_Run_Purchase_ID, vars.getStringParameter("inpmrpRunPurchaselineId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPMRP_Run_Purchase_ID, String strMRP_Run_Purchaseline_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamInouttrxtype = vars.getSessionValue(tabId + "|paramInouttrxtype");
String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamAD_Org_ID.equals("") && strParamM_Product_ID.equals("") && strParamInouttrxtype.equals("") && strParamC_BPartner_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strMRP_Run_Purchaseline_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strMRP_Run_Purchaseline_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/mrp/PurchasingPlan/Lines800259_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Lines800259", false, "document.frmMain.inpmrpRunPurchaselineId", "grid", "..", "".equals("Y"), "PurchasingPlan", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPMRP_Run_Purchase_ID);

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
    xmlDocument.setParameter("KeyName", "mrpRunPurchaselineId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Lines800259_Relation.html", "PurchasingPlan", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Lines800259_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", Lines800259Data.selectParent(this, vars.getLanguage(), strPMRP_Run_Purchase_ID));
    else xmlDocument.setParameter("parent", Lines800259Data.selectParentTrl(this, vars.getLanguage(), strPMRP_Run_Purchase_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strMRP_Run_Purchaseline_ID, String strPMRP_Run_Purchase_ID, TableSQLData tableSQL)
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
    Lines800259Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamInouttrxtype = vars.getSessionValue(tabId + "|paramInouttrxtype");
String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");

    boolean hasSearchCondition=false;
    if (!(strParamAD_Org_ID.equals("") && strParamM_Product_ID.equals("") && strParamInouttrxtype.equals("") && strParamC_BPartner_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = Lines800259Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPMRP_Run_Purchase_ID, strMRP_Run_Purchaseline_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strMRP_Run_Purchaseline_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new Lines800259Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("mrpRunPurchaselineId") == null || dataField.getField("mrpRunPurchaselineId").equals("")) {
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
        refreshSessionNew(vars, strPMRP_Run_Purchase_ID);
        data = Lines800259Data.set(strPMRP_Run_Purchase_ID, Utility.getDefault(this, vars, "Cumqty", "", "800097", "800259", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "800097", "800259", "", dataField), Lines800259Data.selectDef803675_0(this, Utility.getDefault(this, vars, "M_Product_ID", "", "800097", "800259", "", dataField)), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "800097", "800259", "", dataField), Utility.getDefault(this, vars, "Neededqty", "0", "800097", "800259", "", dataField), "", Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "800097", "800259", "", dataField), Utility.getDefault(this, vars, "C_OrderLine_ID", "", "800097", "800259", "", dataField), Utility.getDefault(this, vars, "Iscompleted", "", "800097", "800259", "N", dataField), Utility.getDefault(this, vars, "Framecontractline", "", "800097", "800259", "", dataField), Utility.getDefault(this, vars, "Plannedorderdate", "", "800097", "800259", "", dataField), Utility.getDefault(this, vars, "Pricelist", "", "800097", "800259", "", dataField), Utility.getDefault(this, vars, "M_Requisitionline_ID", "", "800097", "800259", "", dataField), Utility.getDefault(this, vars, "C_Projecttask_ID", "", "800097", "800259", "", dataField), Utility.getDefault(this, vars, "M_Warehouse_ID", "", "800097", "800259", "", dataField), "Y", Utility.getDefault(this, vars, "MRP_Salesforecastline_ID", "", "800097", "800259", "", dataField), Utility.getDefault(this, vars, "C_BPartner_ID", "", "800097", "800259", "", dataField), Lines800259Data.selectDef803699_1(this, Utility.getDefault(this, vars, "C_BPartner_ID", "", "800097", "800259", "", dataField)), Utility.getDefault(this, vars, "Updatedby", "", "800097", "800259", "", dataField), Lines800259Data.selectDef803673_2(this, Utility.getDefault(this, vars, "Updatedby", "", "800097", "800259", "", dataField)), Utility.getDefault(this, vars, "Planneddate", "", "800097", "800259", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "800097", "800259", "", dataField), Lines800259Data.selectDef803671_3(this, Utility.getDefault(this, vars, "Createdby", "", "800097", "800259", "", dataField)), Utility.getDefault(this, vars, "Qty", "", "800097", "800259", "", dataField), Utility.getDefault(this, vars, "Inouttrxtype", "", "800097", "800259", "", dataField), Utility.getDefault(this, vars, "Isfixed", "N", "800097", "800259", "N", dataField));
        
      }
    } else {
      data = new Lines800259Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(Lines800259Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=Header800258Data.selectOrg(this, strPMRP_Run_Purchase_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Lines800259", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpmrpRunPurchaselineId", "", "..", "".equals("Y"), "PurchasingPlan", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strMRP_Run_Purchaseline_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPMRP_Run_Purchase_ID) throws IOException, ServletException {
    Lines800259Data data = null;
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
            data = getEditVariables(con, vars, strPMRP_Run_Purchase_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.mrpRunPurchaselineId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (Lines800259Data.getCurrentDBTimestamp(this, data.mrpRunPurchaselineId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.mrpRunPurchaselineId, vars, this);
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
                    data.mrpRunPurchaselineId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|MRP_Run_Purchaseline_ID", data.mrpRunPurchaselineId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Lines800259. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
