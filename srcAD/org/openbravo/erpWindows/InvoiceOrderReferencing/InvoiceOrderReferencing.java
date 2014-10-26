
package org.openbravo.erpWindows.InvoiceOrderReferencing;


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

public class InvoiceOrderReferencing extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(InvoiceOrderReferencing.class);
  
  private static final String windowId = "36AA235F1E064D12AE96788E48E9236D";
  private static final String tabId = "A5BFF27D073349D0B0BFE76DA04FC3FF";
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
        String strcRefinvoicetoorderViewId = request.getParameter("inpcRefinvoicetoorderViewId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcRefinvoicetoorderViewId.equals(""))
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

      String strC_Refinvoicetoorder_View_ID = vars.getGlobalVariable("inpcRefinvoicetoorderViewId", windowId + "|C_Refinvoicetoorder_View_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|InvoiceOrderReferencing.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_Refinvoicetoorder_View_ID.equals("")) strC_Refinvoicetoorder_View_ID = firstElement(vars, tableSQL);
          if (strC_Refinvoicetoorder_View_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Refinvoicetoorder_View_ID, tableSQL);

      else printPageDataSheet(response, vars, strC_Refinvoicetoorder_View_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_Refinvoicetoorder_View_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_Refinvoicetoorder_View_ID.equals("")) strC_Refinvoicetoorder_View_ID = vars.getRequiredGlobalVariable("inpcRefinvoicetoorderViewId", windowId + "|C_Refinvoicetoorder_View_ID");
      else vars.setSessionValue(windowId + "|C_Refinvoicetoorder_View_ID", strC_Refinvoicetoorder_View_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|InvoiceOrderReferencing.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_Refinvoicetoorder_View_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|InvoiceOrderReferencing.view", "RELATION");
        printPageDataSheet(response, vars, strC_Refinvoicetoorder_View_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|InvoiceOrderReferencing.view");
      String strC_Refinvoicetoorder_View_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_Refinvoicetoorder_View_ID = firstElement(vars, tableSQL);
          if (strC_Refinvoicetoorder_View_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_Refinvoicetoorder_View_ID.equals("")) strC_Refinvoicetoorder_View_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_Refinvoicetoorder_View_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamC_Order_ID", tabId + "|paramC_Order_ID");
vars.getRequestGlobalVariable("inpParamDocumentNo", tabId + "|paramDocumentNo");
vars.getRequestGlobalVariable("inpParamPOReference", tabId + "|paramPOReference");
vars.getRequestGlobalVariable("inpParamDateInvoiced", tabId + "|paramDateInvoiced");
vars.getRequestGlobalVariable("inpParamC_DocTypeTarget_ID", tabId + "|paramC_DocTypeTarget_ID");
vars.getRequestGlobalVariable("inpParamC_BPartner_ID", tabId + "|paramC_BPartner_ID");
vars.getRequestGlobalVariable("inpParamSalesRep_ID", tabId + "|paramSalesRep_ID");
vars.getRequestGlobalVariable("inpParamIspaid", tabId + "|paramIspaid");
vars.getRequestGlobalVariable("inpParamOutstandingAmt", tabId + "|paramOutstandingAmt");
vars.getRequestGlobalVariable("inpParamDueAmt", tabId + "|paramDueAmt");
vars.getRequestGlobalVariable("inpParamGrandTotal", tabId + "|paramGrandTotal");
vars.getRequestGlobalVariable("inpParamDocStatus", tabId + "|paramDocStatus");
vars.getRequestGlobalVariable("inpParamA_Asset_ID", tabId + "|paramA_Asset_ID");
vars.getRequestGlobalVariable("inpParamC_Project_ID", tabId + "|paramC_Project_ID");
vars.getRequestGlobalVariable("inpParamDateInvoiced_f", tabId + "|paramDateInvoiced_f");
vars.getRequestGlobalVariable("inpParamOutstandingAmt_f", tabId + "|paramOutstandingAmt_f");
vars.getRequestGlobalVariable("inpParamDueAmt_f", tabId + "|paramDueAmt_f");
vars.getRequestGlobalVariable("inpParamGrandTotal_f", tabId + "|paramGrandTotal_f");

      
      
      vars.removeSessionValue(windowId + "|C_Refinvoicetoorder_View_ID");
      String strC_Refinvoicetoorder_View_ID="";

      String strView = vars.getSessionValue(tabId + "|InvoiceOrderReferencing.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_Refinvoicetoorder_View_ID = firstElement(vars, tableSQL);
        if (strC_Refinvoicetoorder_View_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|InvoiceOrderReferencing.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Refinvoicetoorder_View_ID, tableSQL);

      else printPageDataSheet(response, vars, strC_Refinvoicetoorder_View_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strC_Refinvoicetoorder_View_ID = vars.getGlobalVariable("inpcRefinvoicetoorderViewId", windowId + "|C_Refinvoicetoorder_View_ID", "");
      vars.setSessionValue(tabId + "|InvoiceOrderReferencing.view", "RELATION");
      printPageDataSheet(response, vars, strC_Refinvoicetoorder_View_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_Refinvoicetoorder_View_ID = vars.getGlobalVariable("inpcRefinvoicetoorderViewId", windowId + "|C_Refinvoicetoorder_View_ID", "");
      vars.setSessionValue(tabId + "|InvoiceOrderReferencing.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_Refinvoicetoorder_View_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strC_Refinvoicetoorder_View_ID = vars.getRequiredStringParameter("inpcRefinvoicetoorderViewId");
      
      String strNext = nextElement(vars, strC_Refinvoicetoorder_View_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strC_Refinvoicetoorder_View_ID = vars.getRequiredStringParameter("inpcRefinvoicetoorderViewId");
      
      String strPrevious = previousElement(vars, strC_Refinvoicetoorder_View_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|InvoiceOrderReferencing.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|InvoiceOrderReferencing.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|InvoiceOrderReferencing.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|InvoiceOrderReferencing.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_Refinvoicetoorder_View_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|InvoiceOrderReferencing.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|InvoiceOrderReferencing.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_Refinvoicetoorder_View_ID");

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

      String strC_Refinvoicetoorder_View_ID = vars.getRequiredGlobalVariable("inpcRefinvoicetoorderViewId", windowId + "|C_Refinvoicetoorder_View_ID");
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
          String strNext = nextElement(vars, strC_Refinvoicetoorder_View_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_Refinvoicetoorder_View_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strC_Refinvoicetoorder_View_ID = vars.getRequiredInStringParameter("inpcRefinvoicetoorderViewId");
      String message = deleteRelation(vars, strC_Refinvoicetoorder_View_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cRefinvoicetoorderViewId");
        vars.setSessionValue(tabId + "|InvoiceOrderReferencing.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strC_Refinvoicetoorder_View_ID = vars.getRequiredStringParameter("inpcRefinvoicetoorderViewId");
      //InvoiceOrderReferencingData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = InvoiceOrderReferencingData.delete(this, strC_Refinvoicetoorder_View_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cRefinvoicetoorderViewId");
        vars.setSessionValue(tabId + "|InvoiceOrderReferencing.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());





    } else if (vars.commandIn("BUTTONPosted")) {
        String strC_Refinvoicetoorder_View_ID = vars.getGlobalVariable("inpcRefinvoicetoorderViewId", windowId + "|C_Refinvoicetoorder_View_ID", "");
        String strTableId = "0CF2122CA58840B4BC453307C76D6F08";
        String strPosted = vars.getStringParameter("inpposted");
        String strProcessId = "";
        log4j.debug("Loading Posted button in table: " + strTableId);
        String strOrg = vars.getStringParameter("inpadOrgId");
        String strClient = vars.getStringParameter("inpadClientId");
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{
          vars.setSessionValue("Posted|key", strC_Refinvoicetoorder_View_ID);
          vars.setSessionValue("Posted|tableId", strTableId);
          vars.setSessionValue("Posted|tabId", tabId);
          vars.setSessionValue("Posted|posted", strPosted);
          vars.setSessionValue("Posted|processId", strProcessId);
          vars.setSessionValue("Posted|path", strDireccion + request.getServletPath());
          vars.setSessionValue("Posted|windowId", windowId);
          vars.setSessionValue("Posted|tabName", "InvoiceOrderReferencing");
          response.sendRedirect(strDireccion + "/ad_actionButton/Posted.html");
        }



    } else if (vars.getCommand().toUpperCase().startsWith("BUTTON") || vars.getCommand().toUpperCase().startsWith("SAVE_BUTTON")) {
      pageErrorPopUp(response);
    } else pageError(response);
  }
/*
  String deleteRelation(VariablesSecureApp vars, String strC_Refinvoicetoorder_View_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_Refinvoicetoorder_View_ID.startsWith("(")) strC_Refinvoicetoorder_View_ID = strC_Refinvoicetoorder_View_ID.substring(1, strC_Refinvoicetoorder_View_ID.length()-1);
      if (!strC_Refinvoicetoorder_View_ID.equals("")) {
        strC_Refinvoicetoorder_View_ID = Replace.replace(strC_Refinvoicetoorder_View_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_Refinvoicetoorder_View_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (InvoiceOrderReferencingData.deleteTransactional(conn, this, strKey)==0) {
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
  private InvoiceOrderReferencingData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    InvoiceOrderReferencingData data = new InvoiceOrderReferencingData();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.cOrderId = vars.getStringParameter("inpcOrderId");     data.cOrderIdr = vars.getStringParameter("inpcOrderId_R");     data.dateordered = vars.getStringParameter("inpdateordered");     data.documentno = vars.getStringParameter("inpdocumentno");     data.poreference = vars.getStringParameter("inpporeference");     data.description = vars.getStringParameter("inpdescription");     data.internalnote = vars.getStringParameter("inpinternalnote");     data.cDoctypetargetId = vars.getRequestGlobalVariable("inpcDoctypetargetId", windowId + "|C_DocTypeTarget_ID");     data.cDoctypetargetIdr = vars.getStringParameter("inpcDoctypetargetId_R");     data.dateinvoiced = vars.getRequestGlobalVariable("inpdateinvoiced", windowId + "|DateInvoiced");     data.dateacct = vars.getStringParameter("inpdateacct");     data.performanceperiodstart = vars.getStringParameter("inpperformanceperiodstart");     data.performanceperiodend = vars.getStringParameter("inpperformanceperiodend");     data.cBpartnerId = vars.getRequestGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.cBpartnerLocationId = vars.getStringParameter("inpcBpartnerLocationId");     data.cBpartnerLocationIdr = vars.getStringParameter("inpcBpartnerLocationId_R");     data.adUserId = vars.getStringParameter("inpadUserId");     data.adUserIdr = vars.getStringParameter("inpadUserId_R");     data.mPricelistId = vars.getRequestGlobalVariable("inpmPricelistId", windowId + "|M_PriceList_ID");     data.mPricelistIdr = vars.getStringParameter("inpmPricelistId_R");     data.cCurrencyId = vars.getRequestGlobalVariable("inpcCurrencyId", windowId + "|C_Currency_ID");     data.cCurrencyIdr = vars.getStringParameter("inpcCurrencyId_R");     data.salesrepId = vars.getStringParameter("inpsalesrepId");     data.salesrepIdr = vars.getStringParameter("inpsalesrepId_R");     data.cChargeId = vars.getStringParameter("inpcChargeId");     data.cChargeIdr = vars.getStringParameter("inpcChargeId_R");    try {   data.chargeamt = vars.getNumericParameter("inpchargeamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.paymentrule = vars.getStringParameter("inppaymentrule");     data.paymentruler = vars.getStringParameter("inppaymentrule_R");     data.cPaymenttermId = vars.getStringParameter("inpcPaymenttermId");     data.cPaymenttermIdr = vars.getStringParameter("inpcPaymenttermId_R");     data.deliveryrule = vars.getStringParameter("inpdeliveryrule");     data.deliveryruler = vars.getStringParameter("inpdeliveryrule_R");     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");    try {   data.totalpaid = vars.getNumericParameter("inptotalpaid");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.outstandingamt = vars.getNumericParameter("inpoutstandingamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.discountamt = vars.getNumericParameter("inpdiscountamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.writeoffamt = vars.getNumericParameter("inpwriteoffamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.transactiondate = vars.getStringParameter("inptransactiondate");     data.schedtransactiondate = vars.getStringParameter("inpschedtransactiondate");     data.ispaid = vars.getRequiredInputGlobalVariable("inpispaid", windowId + "|Ispaid", "N");    try {   data.totallines = vars.getNumericParameter("inptotallines");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.grandtotal = vars.getNumericParameter("inpgrandtotal");  } catch (ServletException paramEx) { ex = paramEx; }     data.cDoctypeId = vars.getRequestGlobalVariable("inpcDoctypeId", windowId + "|C_DocType_ID");     data.cDoctypeIdr = vars.getStringParameter("inpcDoctypeId_R");     data.docstatus = vars.getStringParameter("inpdocstatus");     data.docstatusr = vars.getStringParameter("inpdocstatus_R");     data.posted = vars.getStringParameter("inpposted");     data.isgrossinvoice = vars.getStringParameter("inpisgrossinvoice", "N");     data.cActivityId = vars.getStringParameter("inpcActivityId");     data.processed = vars.getRequiredInputGlobalVariable("inpprocessed", windowId + "|Processed", "N");     data.isselfservice = vars.getStringParameter("inpisselfservice", "N");     data.taxdate = vars.getStringParameter("inptaxdate");     data.cCampaignId = vars.getStringParameter("inpcCampaignId");     data.istaxincluded = vars.getStringParameter("inpistaxincluded", "N");     data.copyfrom = vars.getStringParameter("inpcopyfrom");     data.user1Id = vars.getStringParameter("inpuser1Id");     data.issotrx = vars.getRequiredInputGlobalVariable("inpissotrx", windowId + "|IsSOTrx", "N");     data.isdiscountprinted = vars.getStringParameter("inpisdiscountprinted", "N");     data.btnreinvoiceprojectexpenses = vars.getStringParameter("inpbtnreinvoiceprojectexpenses");     data.isprinted = vars.getStringParameter("inpisprinted", "N");     data.cWithholdingId = vars.getStringParameter("inpcWithholdingId");     data.updatepaymentmonitor = vars.getStringParameter("inpupdatepaymentmonitor");     data.docaction = vars.getStringParameter("inpdocaction");     data.dateprinted = vars.getStringParameter("inpdateprinted");     data.user2Id = vars.getStringParameter("inpuser2Id");    try {   data.withholdingamount = vars.getNumericParameter("inpwithholdingamount");  } catch (ServletException paramEx) { ex = paramEx; }     data.processing = vars.getStringParameter("inpprocessing");     data.adOrgtrxId = vars.getStringParameter("inpadOrgtrxId");    try {   data.dueamt = vars.getNumericParameter("inpdueamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.cInvoiceId = vars.getRequestGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");     data.aAssetId = vars.getStringParameter("inpaAssetId");     data.cProjectphaseId = vars.getStringParameter("inpcProjectphaseId");     data.createfrom = vars.getStringParameter("inpcreatefrom");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.cRefinvoicetoorderViewId = vars.getRequestGlobalVariable("inpcRefinvoicetoorderViewId", windowId + "|C_Refinvoicetoorder_View_ID");     data.lastcalculatedondate = vars.getStringParameter("inplastcalculatedondate");     data.generateto = vars.getStringParameter("inpgenerateto");     data.ispaymentshedulesummary = vars.getStringParameter("inpispaymentshedulesummary", "N");    try {   data.daystilldue = vars.getNumericParameter("inpdaystilldue");  } catch (ServletException paramEx) { ex = paramEx; } 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");



    
         if (data.documentno.startsWith("<")) data.documentno = Utility.getDocumentNo(con, this, vars, windowId, "c_refinvoicetoorder_view", data.cDoctypetargetId, data.cDoctypeId, false, true);

    
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

   private InvoiceOrderReferencingData[] getRelationData(InvoiceOrderReferencingData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 22);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].cOrderId = FormatUtilities.truncate(data[i].cOrderId, 44);        data[i].documentno = FormatUtilities.truncate(data[i].documentno, 8);        data[i].poreference = FormatUtilities.truncate(data[i].poreference, 20);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].internalnote = FormatUtilities.truncate(data[i].internalnote, 50);        data[i].cDoctypetargetId = FormatUtilities.truncate(data[i].cDoctypetargetId, 44);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 30);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 36);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 44);        data[i].mPricelistId = FormatUtilities.truncate(data[i].mPricelistId, 44);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 44);        data[i].salesrepId = FormatUtilities.truncate(data[i].salesrepId, 44);        data[i].cChargeId = FormatUtilities.truncate(data[i].cChargeId, 44);        data[i].paymentrule = FormatUtilities.truncate(data[i].paymentrule, 21);        data[i].cPaymenttermId = FormatUtilities.truncate(data[i].cPaymenttermId, 44);        data[i].deliveryrule = FormatUtilities.truncate(data[i].deliveryrule, 16);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 44);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].cDoctypeId = FormatUtilities.truncate(data[i].cDoctypeId, 14);        data[i].docstatus = FormatUtilities.truncate(data[i].docstatus, 16);        data[i].cActivityId = FormatUtilities.truncate(data[i].cActivityId, 44);        data[i].cCampaignId = FormatUtilities.truncate(data[i].cCampaignId, 44);        data[i].user1Id = FormatUtilities.truncate(data[i].user1Id, 44);        data[i].cWithholdingId = FormatUtilities.truncate(data[i].cWithholdingId, 12);        data[i].user2Id = FormatUtilities.truncate(data[i].user2Id, 44);        data[i].adOrgtrxId = FormatUtilities.truncate(data[i].adOrgtrxId, 44);        data[i].cInvoiceId = FormatUtilities.truncate(data[i].cInvoiceId, 10);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, 32);        data[i].cProjectphaseId = FormatUtilities.truncate(data[i].cProjectphaseId, 32);        data[i].cRefinvoicetoorderViewId = FormatUtilities.truncate(data[i].cRefinvoicetoorderViewId, 32);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|C_DocTypeTarget_ID", data[0].getField("cDoctypetargetId"));    vars.setSessionValue(windowId + "|DateInvoiced", data[0].getField("dateinvoiced"));    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].getField("cBpartnerId"));    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].getField("mPricelistId"));    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].getField("cCurrencyId"));    vars.setSessionValue(windowId + "|IsPaid", data[0].getField("ispaid"));    vars.setSessionValue(windowId + "|C_DocType_ID", data[0].getField("cDoctypeId"));    vars.setSessionValue(windowId + "|Processed", data[0].getField("processed"));    vars.setSessionValue(windowId + "|C_Refinvoicetoorder_View_ID", data[0].getField("cRefinvoicetoorderViewId"));    vars.setSessionValue(windowId + "|C_Invoice_ID", data[0].getField("cInvoiceId"));    vars.setSessionValue(windowId + "|IsSOTrx", data[0].getField("issotrx"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      InvoiceOrderReferencingData[] data = InvoiceOrderReferencingData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpcRefinvoicetoorderViewId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strC_Refinvoicetoorder_View_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamC_Order_ID = vars.getSessionValue(tabId + "|paramC_Order_ID");
String strParamDocumentNo = vars.getSessionValue(tabId + "|paramDocumentNo");
String strParamPOReference = vars.getSessionValue(tabId + "|paramPOReference");
String strParamDateInvoiced = vars.getSessionValue(tabId + "|paramDateInvoiced");
String strParamC_DocTypeTarget_ID = vars.getSessionValue(tabId + "|paramC_DocTypeTarget_ID");
String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParamSalesRep_ID = vars.getSessionValue(tabId + "|paramSalesRep_ID");
String strParamIspaid = vars.getSessionValue(tabId + "|paramIspaid");
String strParamOutstandingAmt = vars.getSessionValue(tabId + "|paramOutstandingAmt");
String strParamDueAmt = vars.getSessionValue(tabId + "|paramDueAmt");
String strParamGrandTotal = vars.getSessionValue(tabId + "|paramGrandTotal");
String strParamDocStatus = vars.getSessionValue(tabId + "|paramDocStatus");
String strParamA_Asset_ID = vars.getSessionValue(tabId + "|paramA_Asset_ID");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamDateInvoiced_f = vars.getSessionValue(tabId + "|paramDateInvoiced_f");
String strParamOutstandingAmt_f = vars.getSessionValue(tabId + "|paramOutstandingAmt_f");
String strParamDueAmt_f = vars.getSessionValue(tabId + "|paramDueAmt_f");
String strParamGrandTotal_f = vars.getSessionValue(tabId + "|paramGrandTotal_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamC_Order_ID.equals("") && strParamDocumentNo.equals("") && strParamPOReference.equals("") && strParamDateInvoiced.equals("") && strParamC_DocTypeTarget_ID.equals("") && strParamC_BPartner_ID.equals("") && strParamSalesRep_ID.equals("") && strParamIspaid.equals("") && strParamOutstandingAmt.equals("") && strParamDueAmt.equals("") && strParamGrandTotal.equals("") && strParamDocStatus.equals("") && strParamA_Asset_ID.equals("") && strParamC_Project_ID.equals("") && strParamDateInvoiced_f.equals("") && strParamOutstandingAmt_f.equals("") && strParamDueAmt_f.equals("") && strParamGrandTotal_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_Refinvoicetoorder_View_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_Refinvoicetoorder_View_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/InvoiceOrderReferencing/InvoiceOrderReferencing_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "InvoiceOrderReferencing", false, "document.frmMain.inpcRefinvoicetoorderViewId", "grid", "..", "".equals("Y"), "InvoiceOrderReferencing", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "cRefinvoicetoorderViewId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "InvoiceOrderReferencing_Relation.html", "InvoiceOrderReferencing", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "InvoiceOrderReferencing_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_Refinvoicetoorder_View_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " c_refinvoicetoorder_view.DocumentNo DESC";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    InvoiceOrderReferencingData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamC_Order_ID = vars.getSessionValue(tabId + "|paramC_Order_ID");
String strParamDocumentNo = vars.getSessionValue(tabId + "|paramDocumentNo");
String strParamPOReference = vars.getSessionValue(tabId + "|paramPOReference");
String strParamDateInvoiced = vars.getSessionValue(tabId + "|paramDateInvoiced");
String strParamC_DocTypeTarget_ID = vars.getSessionValue(tabId + "|paramC_DocTypeTarget_ID");
String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParamSalesRep_ID = vars.getSessionValue(tabId + "|paramSalesRep_ID");
String strParamIspaid = vars.getSessionValue(tabId + "|paramIspaid");
String strParamOutstandingAmt = vars.getSessionValue(tabId + "|paramOutstandingAmt");
String strParamDueAmt = vars.getSessionValue(tabId + "|paramDueAmt");
String strParamGrandTotal = vars.getSessionValue(tabId + "|paramGrandTotal");
String strParamDocStatus = vars.getSessionValue(tabId + "|paramDocStatus");
String strParamA_Asset_ID = vars.getSessionValue(tabId + "|paramA_Asset_ID");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamDateInvoiced_f = vars.getSessionValue(tabId + "|paramDateInvoiced_f");
String strParamOutstandingAmt_f = vars.getSessionValue(tabId + "|paramOutstandingAmt_f");
String strParamDueAmt_f = vars.getSessionValue(tabId + "|paramDueAmt_f");
String strParamGrandTotal_f = vars.getSessionValue(tabId + "|paramGrandTotal_f");

    boolean hasSearchCondition=false;
    if (!(strParamC_Order_ID.equals("") && strParamDocumentNo.equals("") && strParamPOReference.equals("") && strParamDateInvoiced.equals("") && strParamC_DocTypeTarget_ID.equals("") && strParamC_BPartner_ID.equals("") && strParamSalesRep_ID.equals("") && strParamIspaid.equals("") && strParamOutstandingAmt.equals("") && strParamDueAmt.equals("") && strParamGrandTotal.equals("") && strParamDocStatus.equals("") && strParamA_Asset_ID.equals("") && strParamC_Project_ID.equals("") && strParamDateInvoiced_f.equals("") && strParamOutstandingAmt_f.equals("") && strParamDueAmt_f.equals("") && strParamGrandTotal_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = InvoiceOrderReferencingData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strC_Refinvoicetoorder_View_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_Refinvoicetoorder_View_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new InvoiceOrderReferencingData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cRefinvoicetoorderViewId") == null || dataField.getField("cRefinvoicetoorderViewId").equals("")) {
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
        data = InvoiceOrderReferencingData.set(Utility.getDefault(this, vars, "C_Charge_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "AD_User_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "C_Projectphase_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "performanceperiodend", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "DateAcct", "@#Date@", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "TotalLines", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "DueAmt", "0", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "IsDiscountPrinted", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField), Utility.getDefault(this, vars, "AD_OrgTrx_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), "", Utility.getDefault(this, vars, "Btnreinvoiceprojectexpenses", "N", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField), Utility.getDefault(this, vars, "DaysTillDue", "0", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "A_Asset_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "C_DocTypeTarget_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "CopyFrom", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField), Utility.getDefault(this, vars, "Description", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "Schedtransactiondate", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "Processing", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), InvoiceOrderReferencingData.selectDef5EBAFE1E03414A08939695F89ED0DB26_0(this, Utility.getDefault(this, vars, "UpdatedBy", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField)), Utility.getDefault(this, vars, "LastCalculatedOnDate", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "Totalpaid", "0", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "IsPrinted", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField), Utility.getDefault(this, vars, "DocStatus", "DR", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "IsPaymentshedulesummary", "N", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@#AD_Org_ID@", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "ChargeAmt", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "Ispaid", "N", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), InvoiceOrderReferencingData.selectDef2CB02F0F77D044FBA3743BD95C54483B_1(this, Utility.getDefault(this, vars, "CreatedBy", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField)), Utility.getDefault(this, vars, "C_Activity_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "SalesRep_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "UpdatePaymentMonitor", "N", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField), Utility.getDefault(this, vars, "Posted", "N", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField), (vars.getLanguage().equals("en_US")?ListData.selectName(this, "234", Utility.getDefault(this, vars, "Posted", "N", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField)):ListData.selectNameTrl(this, vars.getLanguage(), "234", Utility.getDefault(this, vars, "Posted", "N", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField))), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "IsSOTrx", "@IsSOTrx@", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField), Utility.getDefault(this, vars, "Created", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "Processed", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField), Utility.getDefault(this, vars, "DocumentNo", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "Internalnote", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "C_Order_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), InvoiceOrderReferencingData.selectDef4A11500C72ED4099A0FF8A87D91229E0_2(this, Utility.getDefault(this, vars, "C_Order_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField)), Utility.getDefault(this, vars, "C_BPartner_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), InvoiceOrderReferencingData.selectDefE721F93AFAA747079E24079AC33E829C_3(this, Utility.getDefault(this, vars, "C_BPartner_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField)), "Y", Utility.getDefault(this, vars, "User1_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "C_Project_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), InvoiceOrderReferencingData.selectDefF4A554245BB440048753705111491FEA_4(this, Utility.getDefault(this, vars, "C_Project_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField)), Utility.getDefault(this, vars, "C_Campaign_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "C_BPartner_Location_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "M_PriceList_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "OutstandingAmt", "0", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "Taxdate", "@#Date@", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "C_PaymentTerm_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "IsTaxIncluded", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField), Utility.getDefault(this, vars, "Deliveryrule", "A", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "Discountamt", "0", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "Isgrossinvoice", "N", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField), Utility.getDefault(this, vars, "GrandTotal", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "C_Projecttask_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "CreateFrom", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField), Utility.getDefault(this, vars, "DateOrdered", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "performanceperiodstart", "@#Date@", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "Writeoffamt", "0", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "IsSelfService", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField), Utility.getDefault(this, vars, "C_Withholding_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "User2_ID", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "C_DocType_ID", "0", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "GenerateTo", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField), Utility.getDefault(this, vars, "POReference", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "Withholdingamount", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "Transactiondate", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "PaymentRule", "P", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "DatePrinted", "", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "DocAction", "CO", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "N", dataField), Utility.getDefault(this, vars, "DateInvoiced", "@#Date@", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), Utility.getDefault(this, vars, "C_Currency_ID", "@C_Currency_ID@", "36AA235F1E064D12AE96788E48E9236D", "A5BFF27D073349D0B0BFE76DA04FC3FF", "", dataField), "");
             data[0].documentno = "<" + Utility.getDocumentNo( this, vars, windowId, "c_refinvoicetoorder_view", vars.getSessionValue(windowId + "|C_DocTypeTarget_ID"), vars.getSessionValue(windowId + "|C_DocType_ID"), false, false) + ">";
      }
    } else {
      data = new InvoiceOrderReferencingData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(InvoiceOrderReferencingData) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "InvoiceOrderReferencing", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcRefinvoicetoorderViewId", "", "..", "".equals("Y"), "InvoiceOrderReferencing", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_Refinvoicetoorder_View_ID));
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
      String result = "var strHasCharges=\"" +Utility.getContext(this, vars, "HasCharges", windowId) + "\";\nvar strShowAcctDel=\"" +Utility.getContext(this, vars, "ShowAcctDel", windowId) + "\";\nvar strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\n";
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
    InvoiceOrderReferencingData data = null;
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
                data.cRefinvoicetoorderViewId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (InvoiceOrderReferencingData.getCurrentDBTimestamp(this, data.cRefinvoicetoorderViewId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cRefinvoicetoorderViewId, vars, this);
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
                    data.cRefinvoicetoorderViewId = "";
                }
                else {                    
                    
                        //BUTTON TEXT FILLING
                    data.postedBtn = ActionButtonDefaultData.getText(this, vars.getLanguage(), "234", data.getField("Posted"));
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_Refinvoicetoorder_View_ID", data.cRefinvoicetoorderViewId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet InvoiceOrderReferencing. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
