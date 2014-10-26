
package org.openbravo.erpWindows.PurchaseInvoiceCreditCardPayments;





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

public class Overview extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Overview.class);
  
  private static final String windowId = "244DEF3D6A8340BF907D744A22A1C1FB";
  private static final String tabId = "D412B1BB6D4544BD8D75C3480AB95F5C";
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
        String strcInvoiceCreditcardLineVId = request.getParameter("inpcInvoiceCreditcardLineVId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcInvoiceCreditcardLineVId.equals(""))
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

      String strC_Invoice_Creditcard_Line_V_ID = vars.getGlobalVariable("inpcInvoiceCreditcardLineVId", windowId + "|C_Invoice_Creditcard_Line_V_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|Overview.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_Invoice_Creditcard_Line_V_ID.equals("")) strC_Invoice_Creditcard_Line_V_ID = firstElement(vars, tableSQL);
          if (strC_Invoice_Creditcard_Line_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Invoice_Creditcard_Line_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strC_Invoice_Creditcard_Line_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_Invoice_Creditcard_Line_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_Invoice_Creditcard_Line_V_ID.equals("")) strC_Invoice_Creditcard_Line_V_ID = vars.getRequiredGlobalVariable("inpcInvoiceCreditcardLineVId", windowId + "|C_Invoice_Creditcard_Line_V_ID");
      else vars.setSessionValue(windowId + "|C_Invoice_Creditcard_Line_V_ID", strC_Invoice_Creditcard_Line_V_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Overview.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_Invoice_Creditcard_Line_V_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Overview.view", "RELATION");
        printPageDataSheet(response, vars, strC_Invoice_Creditcard_Line_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|Overview.view");
      String strC_Invoice_Creditcard_Line_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_Invoice_Creditcard_Line_V_ID = firstElement(vars, tableSQL);
          if (strC_Invoice_Creditcard_Line_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_Invoice_Creditcard_Line_V_ID.equals("")) strC_Invoice_Creditcard_Line_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_Invoice_Creditcard_Line_V_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamInvoiceDocumentNo", tabId + "|paramInvoiceDocumentNo");
vars.getRequestGlobalVariable("inpParamC_BPartner_ID", tabId + "|paramC_BPartner_ID");
vars.getRequestGlobalVariable("inpParamAD_User_ID", tabId + "|paramAD_User_ID");
vars.getRequestGlobalVariable("inpParamDescription", tabId + "|paramDescription");
vars.getRequestGlobalVariable("inpParamInternalNote", tabId + "|paramInternalNote");
vars.getRequestGlobalVariable("inpParamDocStatus", tabId + "|paramDocStatus");
vars.getRequestGlobalVariable("inpParamHasVoucher", tabId + "|paramHasVoucher");
vars.getRequestGlobalVariable("inpParamVoucherDate", tabId + "|paramVoucherDate");
vars.getRequestGlobalVariable("inpParamM_Product_ID", tabId + "|paramM_Product_ID");
vars.getRequestGlobalVariable("inpParamLineDescription", tabId + "|paramLineDescription");
vars.getRequestGlobalVariable("inpParamC_Tax_ID", tabId + "|paramC_Tax_ID");
vars.getRequestGlobalVariable("inpParamA_Asset_ID", tabId + "|paramA_Asset_ID");
vars.getRequestGlobalVariable("inpParamC_Project_ID", tabId + "|paramC_Project_ID");
vars.getRequestGlobalVariable("inpParamC_Cashline_ID", tabId + "|paramC_Cashline_ID");
vars.getRequestGlobalVariable("inpParamLineAdUser", tabId + "|paramLineAdUser");
vars.getRequestGlobalVariable("inpParamVoucherDate_f", tabId + "|paramVoucherDate_f");

      
      
      vars.removeSessionValue(windowId + "|C_Invoice_Creditcard_Line_V_ID");
      String strC_Invoice_Creditcard_Line_V_ID="";

      String strView = vars.getSessionValue(tabId + "|Overview.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_Invoice_Creditcard_Line_V_ID = firstElement(vars, tableSQL);
        if (strC_Invoice_Creditcard_Line_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Overview.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Invoice_Creditcard_Line_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strC_Invoice_Creditcard_Line_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strC_Invoice_Creditcard_Line_V_ID = vars.getGlobalVariable("inpcInvoiceCreditcardLineVId", windowId + "|C_Invoice_Creditcard_Line_V_ID", "");
      vars.setSessionValue(tabId + "|Overview.view", "RELATION");
      printPageDataSheet(response, vars, strC_Invoice_Creditcard_Line_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_Invoice_Creditcard_Line_V_ID = vars.getGlobalVariable("inpcInvoiceCreditcardLineVId", windowId + "|C_Invoice_Creditcard_Line_V_ID", "");
      vars.setSessionValue(tabId + "|Overview.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_Invoice_Creditcard_Line_V_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strC_Invoice_Creditcard_Line_V_ID = vars.getRequiredStringParameter("inpcInvoiceCreditcardLineVId");
      
      String strNext = nextElement(vars, strC_Invoice_Creditcard_Line_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strC_Invoice_Creditcard_Line_V_ID = vars.getRequiredStringParameter("inpcInvoiceCreditcardLineVId");
      
      String strPrevious = previousElement(vars, strC_Invoice_Creditcard_Line_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|Overview.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|Overview.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Overview.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Overview.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_Invoice_Creditcard_Line_V_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|Overview.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Overview.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_Invoice_Creditcard_Line_V_ID");

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

      String strC_Invoice_Creditcard_Line_V_ID = vars.getRequiredGlobalVariable("inpcInvoiceCreditcardLineVId", windowId + "|C_Invoice_Creditcard_Line_V_ID");
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
          String strNext = nextElement(vars, strC_Invoice_Creditcard_Line_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_Invoice_Creditcard_Line_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strC_Invoice_Creditcard_Line_V_ID = vars.getRequiredInStringParameter("inpcInvoiceCreditcardLineVId");
      String message = deleteRelation(vars, strC_Invoice_Creditcard_Line_V_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cInvoiceCreditcardLineVId");
        vars.setSessionValue(tabId + "|Overview.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strC_Invoice_Creditcard_Line_V_ID = vars.getRequiredStringParameter("inpcInvoiceCreditcardLineVId");
      //OverviewData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = OverviewData.delete(this, strC_Invoice_Creditcard_Line_V_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cInvoiceCreditcardLineVId");
        vars.setSessionValue(tabId + "|Overview.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strC_Invoice_Creditcard_Line_V_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_Invoice_Creditcard_Line_V_ID.startsWith("(")) strC_Invoice_Creditcard_Line_V_ID = strC_Invoice_Creditcard_Line_V_ID.substring(1, strC_Invoice_Creditcard_Line_V_ID.length()-1);
      if (!strC_Invoice_Creditcard_Line_V_ID.equals("")) {
        strC_Invoice_Creditcard_Line_V_ID = Replace.replace(strC_Invoice_Creditcard_Line_V_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_Invoice_Creditcard_Line_V_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (OverviewData.deleteTransactional(conn, this, strKey)==0) {
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
  private OverviewData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    OverviewData data = new OverviewData();
    ServletException ex = null;
    try {
    data.invoicedocumentno = vars.getStringParameter("inpinvoicedocumentno");     data.cDoctypeId = vars.getStringParameter("inpcDoctypeId");     data.cDoctypeIdr = vars.getStringParameter("inpcDoctypeId_R");     data.mPricelistId = vars.getStringParameter("inpmPricelistId");     data.mPricelistIdr = vars.getStringParameter("inpmPricelistId_R");     data.isgrossinvoice = vars.getStringParameter("inpisgrossinvoice", "N");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.cInvoiceCreditcardVId = vars.getStringParameter("inpcInvoiceCreditcardVId");     data.cInvoiceCreditcardVIdr = vars.getStringParameter("inpcInvoiceCreditcardVId_R");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.adUserId = vars.getStringParameter("inpadUserId");     data.adUserIdr = vars.getStringParameter("inpadUserId_R");     data.cCurrencyId = vars.getStringParameter("inpcCurrencyId");     data.cCurrencyIdr = vars.getStringParameter("inpcCurrencyId_R");     data.dateacct = vars.getStringParameter("inpdateacct");     data.description = vars.getStringParameter("inpdescription");     data.internalnote = vars.getStringParameter("inpinternalnote");    try {   data.grandtotal = vars.getNumericParameter("inpgrandtotal");  } catch (ServletException paramEx) { ex = paramEx; }     data.docstatus = vars.getStringParameter("inpdocstatus");     data.docstatusr = vars.getStringParameter("inpdocstatus_R");     data.lineisactive = vars.getStringParameter("inplineisactive", "N");     data.lineaduser = vars.getStringParameter("inplineaduser");     data.lineaduserr = vars.getStringParameter("inplineaduser_R");     data.cInvoicelineCreditcardVId = vars.getStringParameter("inpcInvoicelineCreditcardVId");     data.cInvoicelineCreditcardVIdr = vars.getStringParameter("inpcInvoicelineCreditcardVId_R");    try {   data.line = vars.getNumericParameter("inpline");  } catch (ServletException paramEx) { ex = paramEx; }     data.hasvoucher = vars.getStringParameter("inphasvoucher", "N");     data.cInvoiceCreditcardLineVId = vars.getRequestGlobalVariable("inpcInvoiceCreditcardLineVId", windowId + "|C_Invoice_Creditcard_Line_V_ID");     data.voucherdate = vars.getStringParameter("inpvoucherdate");     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.adClientId = vars.getStringParameter("inpadClientId");     data.cTaxId = vars.getStringParameter("inpcTaxId");     data.cTaxIdr = vars.getStringParameter("inpcTaxId_R");     data.adOrgId = vars.getStringParameter("inpadOrgId");     data.linedescription = vars.getStringParameter("inplinedescription");    try {   data.priceactual = vars.getNumericParameter("inppriceactual");  } catch (ServletException paramEx) { ex = paramEx; }     data.aAssetId = vars.getStringParameter("inpaAssetId");     data.aAssetIdr = vars.getStringParameter("inpaAssetId_R");     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.cOrderlineId = vars.getStringParameter("inpcOrderlineId");     data.cOrderlineIdr = vars.getStringParameter("inpcOrderlineId_R");     data.cCashlineId = vars.getStringParameter("inpcCashlineId");     data.cCashlineIdr = vars.getStringParameter("inpcCashlineId_R");     data.issotrx = vars.getStringParameter("inpissotrx", "N");    try {   data.linegrossamt = vars.getNumericParameter("inplinegrossamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.docaction = vars.getStringParameter("inpdocaction");     data.cBpartnerLocationId = vars.getStringParameter("inpcBpartnerLocationId");     data.paymentrule = vars.getStringParameter("inppaymentrule");     data.cPaymenttermId = vars.getStringParameter("inpcPaymenttermId");    try {   data.totallines = vars.getNumericParameter("inptotallines");  } catch (ServletException paramEx) { ex = paramEx; }     data.linecreated = vars.getStringParameter("inplinecreated");     data.linecreatedby = vars.getStringParameter("inplinecreatedby");     data.lineupdated = vars.getStringParameter("inplineupdated");     data.lineupdatedby = vars.getStringParameter("inplineupdatedby");    try {   data.qtyinvoiced = vars.getNumericParameter("inpqtyinvoiced");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.linenetamt = vars.getNumericParameter("inplinenetamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.cUomId = vars.getStringParameter("inpcUomId");     data.processed = vars.getStringParameter("inpprocessed", "N"); 
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

   private OverviewData[] getRelationData(OverviewData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].invoicedocumentno = FormatUtilities.truncate(data[i].invoicedocumentno, 30);        data[i].cDoctypeId = FormatUtilities.truncate(data[i].cDoctypeId, 32);        data[i].mPricelistId = FormatUtilities.truncate(data[i].mPricelistId, 32);        data[i].cInvoiceCreditcardVId = FormatUtilities.truncate(data[i].cInvoiceCreditcardVId, 32);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 44);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 32);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 32);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].internalnote = FormatUtilities.truncate(data[i].internalnote, 50);        data[i].docstatus = FormatUtilities.truncate(data[i].docstatus, 50);        data[i].lineaduser = FormatUtilities.truncate(data[i].lineaduser, 32);        data[i].cInvoicelineCreditcardVId = FormatUtilities.truncate(data[i].cInvoicelineCreditcardVId, 32);        data[i].cInvoiceCreditcardLineVId = FormatUtilities.truncate(data[i].cInvoiceCreditcardLineVId, 32);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 44);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].cTaxId = FormatUtilities.truncate(data[i].cTaxId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].linedescription = FormatUtilities.truncate(data[i].linedescription, 50);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, 32);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 32);        data[i].cOrderlineId = FormatUtilities.truncate(data[i].cOrderlineId, 32);        data[i].cCashlineId = FormatUtilities.truncate(data[i].cCashlineId, 20);        data[i].docaction = FormatUtilities.truncate(data[i].docaction, 50);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 32);        data[i].paymentrule = FormatUtilities.truncate(data[i].paymentrule, 50);        data[i].cPaymenttermId = FormatUtilities.truncate(data[i].cPaymenttermId, 32);        data[i].linecreatedby = FormatUtilities.truncate(data[i].linecreatedby, 32);        data[i].lineupdatedby = FormatUtilities.truncate(data[i].lineupdatedby, 32);        data[i].cUomId = FormatUtilities.truncate(data[i].cUomId, 32);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|C_Invoice_Creditcard_Line_V_ID", data[0].getField("cInvoiceCreditcardLineVId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      OverviewData[] data = OverviewData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpcInvoiceCreditcardLineVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strC_Invoice_Creditcard_Line_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamInvoiceDocumentNo = vars.getSessionValue(tabId + "|paramInvoiceDocumentNo");
String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParamAD_User_ID = vars.getSessionValue(tabId + "|paramAD_User_ID");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamInternalNote = vars.getSessionValue(tabId + "|paramInternalNote");
String strParamDocStatus = vars.getSessionValue(tabId + "|paramDocStatus");
String strParamHasVoucher = vars.getSessionValue(tabId + "|paramHasVoucher");
String strParamVoucherDate = vars.getSessionValue(tabId + "|paramVoucherDate");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamLineDescription = vars.getSessionValue(tabId + "|paramLineDescription");
String strParamC_Tax_ID = vars.getSessionValue(tabId + "|paramC_Tax_ID");
String strParamA_Asset_ID = vars.getSessionValue(tabId + "|paramA_Asset_ID");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamC_Cashline_ID = vars.getSessionValue(tabId + "|paramC_Cashline_ID");
String strParamLineAdUser = vars.getSessionValue(tabId + "|paramLineAdUser");
String strParamVoucherDate_f = vars.getSessionValue(tabId + "|paramVoucherDate_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamInvoiceDocumentNo.equals("") && strParamC_BPartner_ID.equals("") && strParamAD_User_ID.equals("") && strParamDescription.equals("") && strParamInternalNote.equals("") && strParamDocStatus.equals("") && strParamHasVoucher.equals("") && strParamVoucherDate.equals("") && strParamM_Product_ID.equals("") && strParamLineDescription.equals("") && strParamC_Tax_ID.equals("") && strParamA_Asset_ID.equals("") && strParamC_Project_ID.equals("") && strParamC_Cashline_ID.equals("") && strParamLineAdUser.equals("") && strParamVoucherDate_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_Invoice_Creditcard_Line_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_Invoice_Creditcard_Line_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/PurchaseInvoiceCreditCardPayments/Overview_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Overview", false, "document.frmMain.inpcInvoiceCreditcardLineVId", "grid", "..", "".equals("Y"), "PurchaseInvoiceCreditCardPayments", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), true, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
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
    xmlDocument.setParameter("KeyName", "cInvoiceCreditcardLineVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Overview_Relation.html", "PurchaseInvoiceCreditCardPayments", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Overview_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_Invoice_Creditcard_Line_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " c_invoice_creditcard_line_v.invoicedocumentno DESC";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    OverviewData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamInvoiceDocumentNo = vars.getSessionValue(tabId + "|paramInvoiceDocumentNo");
String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParamAD_User_ID = vars.getSessionValue(tabId + "|paramAD_User_ID");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamInternalNote = vars.getSessionValue(tabId + "|paramInternalNote");
String strParamDocStatus = vars.getSessionValue(tabId + "|paramDocStatus");
String strParamHasVoucher = vars.getSessionValue(tabId + "|paramHasVoucher");
String strParamVoucherDate = vars.getSessionValue(tabId + "|paramVoucherDate");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamLineDescription = vars.getSessionValue(tabId + "|paramLineDescription");
String strParamC_Tax_ID = vars.getSessionValue(tabId + "|paramC_Tax_ID");
String strParamA_Asset_ID = vars.getSessionValue(tabId + "|paramA_Asset_ID");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamC_Cashline_ID = vars.getSessionValue(tabId + "|paramC_Cashline_ID");
String strParamLineAdUser = vars.getSessionValue(tabId + "|paramLineAdUser");
String strParamVoucherDate_f = vars.getSessionValue(tabId + "|paramVoucherDate_f");

    boolean hasSearchCondition=false;
    if (!(strParamInvoiceDocumentNo.equals("") && strParamC_BPartner_ID.equals("") && strParamAD_User_ID.equals("") && strParamDescription.equals("") && strParamInternalNote.equals("") && strParamDocStatus.equals("") && strParamHasVoucher.equals("") && strParamVoucherDate.equals("") && strParamM_Product_ID.equals("") && strParamLineDescription.equals("") && strParamC_Tax_ID.equals("") && strParamA_Asset_ID.equals("") && strParamC_Project_ID.equals("") && strParamC_Cashline_ID.equals("") && strParamLineAdUser.equals("") && strParamVoucherDate_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = OverviewData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strC_Invoice_Creditcard_Line_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_Invoice_Creditcard_Line_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (data==null || data.length==0) {
        strC_Invoice_Creditcard_Line_V_ID = firstElement(vars, tableSQL);
        if (strC_Invoice_Creditcard_Line_V_ID.equals("")) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        } else {
          data = OverviewData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strC_Invoice_Creditcard_Line_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
        }
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new OverviewData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cInvoiceCreditcardLineVId") == null || dataField.getField("cInvoiceCreditcardLineVId").equals("")) {
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
        data = OverviewData.set(Utility.getDefault(this, vars, "C_BPartner_ID", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "TotalLines", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "Processed", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "N", dataField), Utility.getDefault(this, vars, "DocAction", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "C_Uom_ID", "@C_UOM_ID@", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "A_Asset_ID", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "InternalNote", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "M_Pricelist_ID", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "PriceActual", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "C_Orderline_ID", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), "Y", Utility.getDefault(this, vars, "C_Bpartner_Location_ID", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), "", Utility.getDefault(this, vars, "HasVoucher", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "N", dataField), Utility.getDefault(this, vars, "QtyInvoiced", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "C_Doctype_ID", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "LineAdUser", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), OverviewData.selectDef84FF2259D5C64940A764744DB5207547_0(this, Utility.getDefault(this, vars, "UpdatedBy", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField)), Utility.getDefault(this, vars, "C_Tax_ID", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "LineGrossAmt", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "LineUpdatedBy", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "AD_User_ID", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "DateAcct", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "C_Project_ID", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "LineUpdated", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "LineCreated", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "Description", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "LineDescription", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "IsGrossInvoice", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "N", dataField), Utility.getDefault(this, vars, "VoucherDate", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "GrandTotal", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "DocStatus", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "LineIsActive", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "N", dataField), Utility.getDefault(this, vars, "C_Invoice_Creditcard_V_ID", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "Line", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "LineNetAmt", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "IsSOTrx", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "N", dataField), Utility.getDefault(this, vars, "C_Invoiceline_Creditcard_V_ID", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "C_Cashline_ID", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "C_PaymentTerm_ID", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), OverviewData.selectDef8ED8A2136BDB4786B490496683BA9F4C_1(this, Utility.getDefault(this, vars, "CreatedBy", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField)), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "PaymentRule", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "LineCreatedBy", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "InvoiceDocumentNo", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField), Utility.getDefault(this, vars, "C_Currency_ID", "", "244DEF3D6A8340BF907D744A22A1C1FB", "D412B1BB6D4544BD8D75C3480AB95F5C", "", dataField));
        
      }
    } else {
      data = new OverviewData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(OverviewData) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Overview", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcInvoiceCreditcardLineVId", "", "..", "".equals("Y"), "PurchaseInvoiceCreditCardPayments", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_Invoice_Creditcard_Line_V_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type) throws IOException, ServletException {
    OverviewData data = null;
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
                data.cInvoiceCreditcardLineVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (OverviewData.getCurrentDBTimestamp(this, data.cInvoiceCreditcardLineVId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cInvoiceCreditcardLineVId, vars, this);
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
                    data.cInvoiceCreditcardLineVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_Invoice_Creditcard_Line_V_ID", data.cInvoiceCreditcardLineVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Overview. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
