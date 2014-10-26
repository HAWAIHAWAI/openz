
package org.openbravo.erpWindows.PurchaseInvoice;





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

public class Lines extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Lines.class);
  
  private static final String windowId = "183";
  private static final String tabId = "291";
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
        String strcInvoicelineId = request.getParameter("inpcInvoicelineId");
         String strPC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcInvoicelineId.equals(""))
              total = saveRecord(vars, myError, 'U', strPC_Invoice_ID);
          else
              total = saveRecord(vars, myError, 'I', strPC_Invoice_ID);
          
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
      String strPC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID", "");

      String strC_InvoiceLine_ID = vars.getGlobalVariable("inpcInvoicelineId", windowId + "|C_InvoiceLine_ID", "");
            if (strPC_Invoice_ID.equals("")) {
        strPC_Invoice_ID = getParentID(vars, strC_InvoiceLine_ID);
        if (strPC_Invoice_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_Invoice_ID");
        vars.setSessionValue(windowId + "|C_Invoice_ID", strPC_Invoice_ID);

        refreshParentSession(vars, strPC_Invoice_ID);
      }


      String strView = vars.getSessionValue(tabId + "|Lines.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_InvoiceLine_ID.equals("")) strC_InvoiceLine_ID = firstElement(vars, tableSQL);
          if (strC_InvoiceLine_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_InvoiceLine_ID, strPC_Invoice_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Invoice_ID, strC_InvoiceLine_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_InvoiceLine_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_InvoiceLine_ID.equals("")) strC_InvoiceLine_ID = vars.getRequiredGlobalVariable("inpcInvoicelineId", windowId + "|C_InvoiceLine_ID");
      else vars.setSessionValue(windowId + "|C_InvoiceLine_ID", strC_InvoiceLine_ID);
      
      
      String strPC_Invoice_ID = getParentID(vars, strC_InvoiceLine_ID);
      
      vars.setSessionValue(windowId + "|C_Invoice_ID", strPC_Invoice_ID);
      vars.setSessionValue("290|Header.view", "EDIT");

      refreshParentSession(vars, strPC_Invoice_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Lines.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_InvoiceLine_ID, strPC_Invoice_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Lines.view", "RELATION");
        printPageDataSheet(response, vars, strPC_Invoice_ID, strC_InvoiceLine_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|C_InvoiceLine_ID");
      refreshParentSession(vars, strPC_Invoice_ID);


      String strView = vars.getSessionValue(tabId + "|Lines.view");
      String strC_InvoiceLine_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_InvoiceLine_ID = firstElement(vars, tableSQL);
          if (strC_InvoiceLine_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_InvoiceLine_ID.equals("")) strC_InvoiceLine_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_InvoiceLine_ID, strPC_Invoice_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_Invoice_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamC_Invoice_ID", tabId + "|paramC_Invoice_ID");
vars.getRequestGlobalVariable("inpParamLine", tabId + "|paramLine");
vars.getRequestGlobalVariable("inpParamLineNetAmt", tabId + "|paramLineNetAmt");
vars.getRequestGlobalVariable("inpParamLine_f", tabId + "|paramLine_f");
vars.getRequestGlobalVariable("inpParamLineNetAmt_f", tabId + "|paramLineNetAmt_f");

            String strPC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");

      
      vars.removeSessionValue(windowId + "|C_InvoiceLine_ID");
      String strC_InvoiceLine_ID="";

      String strView = vars.getSessionValue(tabId + "|Lines.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_InvoiceLine_ID = firstElement(vars, tableSQL);
        if (strC_InvoiceLine_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Lines.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_InvoiceLine_ID, strPC_Invoice_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Invoice_ID, strC_InvoiceLine_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");
      

      String strC_InvoiceLine_ID = vars.getGlobalVariable("inpcInvoicelineId", windowId + "|C_InvoiceLine_ID", "");
      vars.setSessionValue(tabId + "|Lines.view", "RELATION");
      printPageDataSheet(response, vars, strPC_Invoice_ID, strC_InvoiceLine_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");


      printPageEdit(response, request, vars, true, "", strPC_Invoice_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_InvoiceLine_ID = vars.getGlobalVariable("inpcInvoicelineId", windowId + "|C_InvoiceLine_ID", "");
      vars.setSessionValue(tabId + "|Lines.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_InvoiceLine_ID, strPC_Invoice_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");
      String strC_InvoiceLine_ID = vars.getRequiredStringParameter("inpcInvoicelineId");
      
      String strNext = nextElement(vars, strC_InvoiceLine_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_Invoice_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");
      String strC_InvoiceLine_ID = vars.getRequiredStringParameter("inpcInvoicelineId");
      
      String strPrevious = previousElement(vars, strC_InvoiceLine_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_Invoice_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");

      vars.setSessionValue(tabId + "|Lines.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Lines.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Lines.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Lines.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_InvoiceLine_ID");
      vars.setSessionValue(windowId + "|C_Invoice_ID", strPC_Invoice_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Lines.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Lines.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_InvoiceLine_ID");
      vars.setSessionValue(windowId + "|C_Invoice_ID", strPC_Invoice_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPC_Invoice_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPC_Invoice_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPC_Invoice_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPC_Invoice_ID);      
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
      String strPC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");
      String strC_InvoiceLine_ID = vars.getRequiredGlobalVariable("inpcInvoicelineId", windowId + "|C_InvoiceLine_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPC_Invoice_ID);      
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
          String strNext = nextElement(vars, strC_InvoiceLine_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_InvoiceLine_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");

      String strC_InvoiceLine_ID = vars.getRequiredInStringParameter("inpcInvoicelineId");
      String message = deleteRelation(vars, strC_InvoiceLine_ID, strPC_Invoice_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cInvoicelineId");
        vars.setSessionValue(tabId + "|Lines.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");

      String strC_InvoiceLine_ID = vars.getRequiredStringParameter("inpcInvoicelineId");
      //LinesData data = getEditVariables(vars, strPC_Invoice_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = LinesData.delete(this, strC_InvoiceLine_ID, strPC_Invoice_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cInvoicelineId");
        vars.setSessionValue(tabId + "|Lines.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strC_InvoiceLine_ID, String strPC_Invoice_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_InvoiceLine_ID.startsWith("(")) strC_InvoiceLine_ID = strC_InvoiceLine_ID.substring(1, strC_InvoiceLine_ID.length()-1);
      if (!strC_InvoiceLine_ID.equals("")) {
        strC_InvoiceLine_ID = Replace.replace(strC_InvoiceLine_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_InvoiceLine_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (LinesData.deleteTransactional(conn, this, strKey, strPC_Invoice_ID)==0) {
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
  private LinesData getEditVariables(Connection con, VariablesSecureApp vars, String strPC_Invoice_ID) throws IOException,ServletException {
    LinesData data = new LinesData();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adOrgId = vars.getStringParameter("inpadOrgId");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.cInvoiceId = vars.getRequestGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");     data.cInvoiceIdr = vars.getStringParameter("inpcInvoiceId_R");     data.cOrderlineId = vars.getStringParameter("inpcOrderlineId");     data.cOrderlineIdr = vars.getStringParameter("inpcOrderlineId_R");     data.mInoutlineId = vars.getStringParameter("inpmInoutlineId");     data.mInoutlineIdr = vars.getStringParameter("inpmInoutlineId_R");     data.reinvoicedbyId = vars.getStringParameter("inpreinvoicedbyId");     data.reinvoicedbyIdr = vars.getStringParameter("inpreinvoicedbyId_R");    try {   data.line = vars.getNumericParameter("inpline");  } catch (ServletException paramEx) { ex = paramEx; }     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.cChargeId = vars.getStringParameter("inpcChargeId");     data.description = vars.getStringParameter("inpdescription");    try {   data.quantityorder = vars.getNumericParameter("inpquantityorder");  } catch (ServletException paramEx) { ex = paramEx; }     data.mProductUomId = vars.getStringParameter("inpmProductUomId");     data.mProductUomIdr = vars.getStringParameter("inpmProductUomId_R");    try {   data.qtyinvoiced = vars.getNumericParameter("inpqtyinvoiced");  } catch (ServletException paramEx) { ex = paramEx; }     data.cUomId = vars.getStringParameter("inpcUomId");     data.cUomIdr = vars.getStringParameter("inpcUomId_R");     data.isgrossprice = vars.getStringParameter("inpisgrossprice", "N");    try {   data.priceactual = vars.getNumericParameter("inppriceactual");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.pricelist = vars.getNumericParameter("inppricelist");  } catch (ServletException paramEx) { ex = paramEx; }     data.cTaxId = vars.getStringParameter("inpcTaxId");     data.cTaxIdr = vars.getStringParameter("inpcTaxId_R");     data.aAssetId = vars.getStringParameter("inpaAssetId");     data.aAssetIdr = vars.getStringParameter("inpaAssetId_R");     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");    try {   data.linegrossamt = vars.getNumericParameter("inplinegrossamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.linenetamt = vars.getNumericParameter("inplinenetamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.sResourceassignmentId = vars.getStringParameter("inpsResourceassignmentId");    try {   data.taxamt = vars.getNumericParameter("inptaxamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.mAttributesetinstanceId = vars.getStringParameter("inpmAttributesetinstanceId");    try {   data.linetaxamt = vars.getNumericParameter("inplinetaxamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.chargeamt = vars.getNumericParameter("inpchargeamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.cInvoicelineId = vars.getRequestGlobalVariable("inpcInvoicelineId", windowId + "|C_InvoiceLine_ID");    try {   data.pricelimit = vars.getNumericParameter("inppricelimit");  } catch (ServletException paramEx) { ex = paramEx; }     data.mOfferId = vars.getStringParameter("inpmOfferId");    try {   data.pricestd = vars.getNumericParameter("inppricestd");  } catch (ServletException paramEx) { ex = paramEx; }     data.isdescription = vars.getStringParameter("inpisdescription", "N");     data.cProjectphaseId = vars.getStringParameter("inpcProjectphaseId");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.excludeforwithholding = vars.getStringParameter("inpexcludeforwithholding", "N"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cInvoiceId = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");


          vars.getGlobalVariable("inphasseconduom", windowId + "|HASSECONDUOM", "");
          vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPARTNER_ID", "");
          vars.getGlobalVariable("inpprocessed", windowId + "|Processed", "");
    
    

    
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

   private LinesData[] getRelationData(LinesData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].cInvoiceId = FormatUtilities.truncate(data[i].cInvoiceId, 44);        data[i].cOrderlineId = FormatUtilities.truncate(data[i].cOrderlineId, 44);        data[i].mInoutlineId = FormatUtilities.truncate(data[i].mInoutlineId, 44);        data[i].reinvoicedbyId = FormatUtilities.truncate(data[i].reinvoicedbyId, 32);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 44);        data[i].cChargeId = FormatUtilities.truncate(data[i].cChargeId, 44);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].mProductUomId = FormatUtilities.truncate(data[i].mProductUomId, 44);        data[i].cUomId = FormatUtilities.truncate(data[i].cUomId, 44);        data[i].cTaxId = FormatUtilities.truncate(data[i].cTaxId, 44);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, 30);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 30);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 30);        data[i].sResourceassignmentId = FormatUtilities.truncate(data[i].sResourceassignmentId, 14);        data[i].mAttributesetinstanceId = FormatUtilities.truncate(data[i].mAttributesetinstanceId, 14);        data[i].cInvoicelineId = FormatUtilities.truncate(data[i].cInvoicelineId, 10);        data[i].mOfferId = FormatUtilities.truncate(data[i].mOfferId, 44);        data[i].cProjectphaseId = FormatUtilities.truncate(data[i].cProjectphaseId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPC_Invoice_ID) throws IOException,ServletException {
      HeaderData[] data = HeaderData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), Utility.getContext(this, vars, "ad_user_id", windowId), Utility.getContext(this, vars, "ad_org_id", windowId), strPC_Invoice_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|C_DocTypeTarget_ID", data[0].cDoctypetargetId);    vars.setSessionValue(windowId + "|DateInvoiced", data[0].dateinvoiced);    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].cBpartnerId);    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].mPricelistId);    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].cCurrencyId);    vars.setSessionValue(windowId + "|IsPaid", data[0].ispaid);    vars.setSessionValue(windowId + "|C_DocType_ID", data[0].cDoctypeId);    vars.setSessionValue(windowId + "|Processed", data[0].processed);    vars.setSessionValue(windowId + "|IsSOTrx", data[0].issotrx);    vars.setSessionValue(windowId + "|C_Invoice_ID", data[0].cInvoiceId);
      vars.setSessionValue(windowId + "|C_Invoice_ID", strPC_Invoice_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strC_InvoiceLine_ID) throws ServletException {
    String strPC_Invoice_ID = LinesData.selectParentID(this, strC_InvoiceLine_ID);
    if (strPC_Invoice_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strC_InvoiceLine_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_Invoice_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|C_Invoice_ID", data[0].getField("cInvoiceId"));    vars.setSessionValue(windowId + "|C_InvoiceLine_ID", data[0].getField("cInvoicelineId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_Invoice_ID) throws IOException,ServletException {
      LinesData[] data = LinesData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Invoice_ID, vars.getStringParameter("inpcInvoicelineId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_Invoice_ID, String strC_InvoiceLine_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamC_Invoice_ID = vars.getSessionValue(tabId + "|paramC_Invoice_ID");
String strParamLine = vars.getSessionValue(tabId + "|paramLine");
String strParamLineNetAmt = vars.getSessionValue(tabId + "|paramLineNetAmt");
String strParamLine_f = vars.getSessionValue(tabId + "|paramLine_f");
String strParamLineNetAmt_f = vars.getSessionValue(tabId + "|paramLineNetAmt_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamC_Invoice_ID.equals("") && strParamLine.equals("") && strParamLineNetAmt.equals("") && strParamLine_f.equals("") && strParamLineNetAmt_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_InvoiceLine_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_InvoiceLine_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/PurchaseInvoice/Lines_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Lines", false, "document.frmMain.inpcInvoicelineId", "grid", "..", "".equals("Y"), "PurchaseInvoice", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPC_Invoice_ID);

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
    xmlDocument.setParameter("KeyName", "cInvoicelineId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Lines_Relation.html", "PurchaseInvoice", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Lines_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", LinesData.selectParent(this, strPC_Invoice_ID));
    else xmlDocument.setParameter("parent", LinesData.selectParentTrl(this, strPC_Invoice_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_InvoiceLine_ID, String strPC_Invoice_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " C_InvoiceLine.Line";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    LinesData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamC_Invoice_ID = vars.getSessionValue(tabId + "|paramC_Invoice_ID");
String strParamLine = vars.getSessionValue(tabId + "|paramLine");
String strParamLineNetAmt = vars.getSessionValue(tabId + "|paramLineNetAmt");
String strParamLine_f = vars.getSessionValue(tabId + "|paramLine_f");
String strParamLineNetAmt_f = vars.getSessionValue(tabId + "|paramLineNetAmt_f");

    boolean hasSearchCondition=false;
    if (!(strParamC_Invoice_ID.equals("") && strParamLine.equals("") && strParamLineNetAmt.equals("") && strParamLine_f.equals("") && strParamLineNetAmt_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = LinesData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Invoice_ID, strC_InvoiceLine_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_InvoiceLine_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new LinesData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cInvoicelineId") == null || dataField.getField("cInvoicelineId").equals("")) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        boolNew = true;
      } else {
        discard[0] = new String ("newDiscard");
        strCommand = "EDIT";
      }
    }
    
        String strHASSECONDUOM = LinesData.selectAux800003(this, ((dataField!=null)?dataField.getField("mProductId"):((data==null || data.length==0)?"":data[0].mProductId)));
    vars.setSessionValue(windowId + "|HASSECONDUOM", strHASSECONDUOM);
        String strC_BPARTNER_ID = Utility.getContext(this, vars, "C_BPARTNER_ID", "183");
    vars.setSessionValue(windowId + "|C_BPARTNER_ID", strC_BPARTNER_ID);
        String strProcessed = LinesData.selectAux80BB79DBFEAA45CAB10F60A9DD388780(this, strPC_Invoice_ID);
    vars.setSessionValue(windowId + "|Processed", strProcessed);
    
    
    if (dataField==null) {
      if (boolNew || data==null || data.length==0) {
        refreshSessionNew(vars, strPC_Invoice_ID);
        data = LinesData.set(strPC_Invoice_ID, Utility.getDefault(this, vars, "C_UOM_ID", "", "183", "291", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_Client_ID@", "183", "291", "", dataField), Utility.getDefault(this, vars, "PriceLimit", "", "183", "291", "", dataField), LinesData.selectDef3836_0(this, strPC_Invoice_ID), LinesData.selectDefD794AA02F9E34A3E858EA7EDBC5F98E4(this, strPC_Invoice_ID), Utility.getDefault(this, vars, "QuantityOrder", "", "183", "291", "", dataField), Utility.getDefault(this, vars, "M_Offer_ID", "", "183", "291", "", dataField), Utility.getDefault(this, vars, "Description", "", "183", "291", "", dataField), Utility.getDefault(this, vars, "PriceStd", "0", "183", "291", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "183", "291", "", dataField), LinesData.selectDef3838(this, strPC_Invoice_ID), Utility.getDefault(this, vars, "PriceList", "", "183", "291", "", dataField), Utility.getDefault(this, vars, "Created", "", "183", "291", "", dataField), Utility.getDefault(this, vars, "S_ResourceAssignment_ID", "", "183", "291", "", dataField), Utility.getDefault(this, vars, "LineNetAmt", "", "183", "291", "", dataField), Utility.getDefault(this, vars, "Linegrossamt", "0", "183", "291", "", dataField), Utility.getDefault(this, vars, "C_OrderLine_ID", "", "183", "291", "", dataField), Utility.getDefault(this, vars, "ChargeAmt", "", "183", "291", "", dataField), LinesData.selectDef4611D8B935474793AA95D7C78B750147(this, strPC_Invoice_ID), Utility.getDefault(this, vars, "M_Product_Uom_Id", "", "183", "291", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "183", "291", "", dataField), LinesData.selectDef3835_1(this, Utility.getDefault(this, vars, "UpdatedBy", "", "183", "291", "", dataField)), Utility.getDefault(this, vars, "Excludeforwithholding", "", "183", "291", "N", dataField), "Y", Utility.getDefault(this, vars, "C_Charge_ID", "", "183", "291", "", dataField), Utility.getDefault(this, vars, "Linetaxamt", "0", "183", "291", "", dataField), LinesData.selectDefE613BADFF69444FE8BFD5D28D22CC1B2(this, strPC_Invoice_ID), "", Utility.getDefault(this, vars, "Reinvoicedby_ID", "", "183", "291", "", dataField), LinesData.selectDef51C68662912C4B0D887CBE129758FB7E_2(this, Utility.getDefault(this, vars, "Reinvoicedby_ID", "", "183", "291", "", dataField)), Utility.getDefault(this, vars, "M_AttributeSetInstance_ID", "", "183", "291", "", dataField), LinesData.selectDefD368B486C6AC439D983B03CF4755EF72(this, strPC_Invoice_ID), Utility.getDefault(this, vars, "M_InOutLine_ID", "", "183", "291", "", dataField), LinesData.selectDef4251_3(this, Utility.getDefault(this, vars, "M_InOutLine_ID", "", "183", "291", "", dataField)), LinesData.selectDefC5F1E0FC079F4FCBAE27B1990366A8E5(this, strPC_Invoice_ID), LinesData.selectDefC5F1E0FC079F4FCBAE27B1990366A8E5_4(this, LinesData.selectDefC5F1E0FC079F4FCBAE27B1990366A8E5(this, strPC_Invoice_ID)), Utility.getDefault(this, vars, "IsDescription", "N", "183", "291", "N", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "183", "291", "", dataField), LinesData.selectDef3840_5(this, Utility.getDefault(this, vars, "M_Product_ID", "", "183", "291", "", dataField)), Utility.getDefault(this, vars, "TaxAmt", "", "183", "291", "", dataField), Utility.getDefault(this, vars, "C_Tax_ID", "", "183", "291", "", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "183", "291", "", dataField), LinesData.selectDef3833_6(this, Utility.getDefault(this, vars, "CreatedBy", "", "183", "291", "", dataField)), Utility.getDefault(this, vars, "QtyInvoiced", "1", "183", "291", "", dataField), Utility.getDefault(this, vars, "PriceActual", "", "183", "291", "", dataField));
        
      }
    } else {
      data = new LinesData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(LinesData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=HeaderData.selectOrg(this, strPC_Invoice_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Lines", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcInvoicelineId", "", "..", "".equals("Y"), "PurchaseInvoice", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_InvoiceLine_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPC_Invoice_ID) throws IOException, ServletException {
    LinesData data = null;
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
            data = getEditVariables(con, vars, strPC_Invoice_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.cInvoicelineId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (LinesData.getCurrentDBTimestamp(this, data.cInvoicelineId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cInvoicelineId, vars, this);
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
                    data.cInvoicelineId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_InvoiceLine_ID", data.cInvoicelineId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Lines. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
