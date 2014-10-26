
package org.openbravo.erpWindows.ImportOrders;





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

public class ImportOrder extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(ImportOrder.class);
  
  private static final String windowId = "281";
  private static final String tabId = "512";
  private static final String defaultTabView = "RELATION";
  private static final int accesslevel = 7;
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
        String striOrderId = request.getParameter("inpiOrderId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !striOrderId.equals(""))
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

      String strI_Order_ID = vars.getGlobalVariable("inpiOrderId", windowId + "|I_Order_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|ImportOrder.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strI_Order_ID.equals("")) strI_Order_ID = firstElement(vars, tableSQL);
          if (strI_Order_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strI_Order_ID, tableSQL);

      else printPageDataSheet(response, vars, strI_Order_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strI_Order_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strI_Order_ID.equals("")) strI_Order_ID = vars.getRequiredGlobalVariable("inpiOrderId", windowId + "|I_Order_ID");
      else vars.setSessionValue(windowId + "|I_Order_ID", strI_Order_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|ImportOrder.view", "EDIT");

        printPageEdit(response, request, vars, false, strI_Order_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|ImportOrder.view", "RELATION");
        printPageDataSheet(response, vars, strI_Order_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|ImportOrder.view");
      String strI_Order_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strI_Order_ID = firstElement(vars, tableSQL);
          if (strI_Order_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strI_Order_ID.equals("")) strI_Order_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strI_Order_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamAD_Client_ID", tabId + "|paramAD_Client_ID");

      
      
      vars.removeSessionValue(windowId + "|I_Order_ID");
      String strI_Order_ID="";

      String strView = vars.getSessionValue(tabId + "|ImportOrder.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strI_Order_ID = firstElement(vars, tableSQL);
        if (strI_Order_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|ImportOrder.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strI_Order_ID, tableSQL);

      else printPageDataSheet(response, vars, strI_Order_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strI_Order_ID = vars.getGlobalVariable("inpiOrderId", windowId + "|I_Order_ID", "");
      vars.setSessionValue(tabId + "|ImportOrder.view", "RELATION");
      printPageDataSheet(response, vars, strI_Order_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strI_Order_ID = vars.getGlobalVariable("inpiOrderId", windowId + "|I_Order_ID", "");
      vars.setSessionValue(tabId + "|ImportOrder.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strI_Order_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strI_Order_ID = vars.getRequiredStringParameter("inpiOrderId");
      
      String strNext = nextElement(vars, strI_Order_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strI_Order_ID = vars.getRequiredStringParameter("inpiOrderId");
      
      String strPrevious = previousElement(vars, strI_Order_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|ImportOrder.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|ImportOrder.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|ImportOrder.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|ImportOrder.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|I_Order_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|ImportOrder.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|ImportOrder.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|I_Order_ID");

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

      String strI_Order_ID = vars.getRequiredGlobalVariable("inpiOrderId", windowId + "|I_Order_ID");
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
          String strNext = nextElement(vars, strI_Order_ID, tableSQL);
          vars.setSessionValue(windowId + "|I_Order_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strI_Order_ID = vars.getRequiredInStringParameter("inpiOrderId");
      String message = deleteRelation(vars, strI_Order_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|iOrderId");
        vars.setSessionValue(tabId + "|ImportOrder.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strI_Order_ID = vars.getRequiredStringParameter("inpiOrderId");
      //ImportOrderData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = ImportOrderData.delete(this, strI_Order_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|iOrderId");
        vars.setSessionValue(tabId + "|ImportOrder.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strI_Order_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strI_Order_ID.startsWith("(")) strI_Order_ID = strI_Order_ID.substring(1, strI_Order_ID.length()-1);
      if (!strI_Order_ID.equals("")) {
        strI_Order_ID = Replace.replace(strI_Order_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strI_Order_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (ImportOrderData.deleteTransactional(conn, this, strKey)==0) {
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
  private ImportOrderData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    ImportOrderData data = new ImportOrderData();
    ServletException ex = null;
    try {
    data.isactive = vars.getStringParameter("inpisactive", "N");     data.iOrderId = vars.getRequestGlobalVariable("inpiOrderId", windowId + "|I_Order_ID");     data.iIsimported = vars.getStringParameter("inpiIsimported", "N");     data.cOrderId = vars.getStringParameter("inpcOrderId");     data.cOrderIdr = vars.getStringParameter("inpcOrderId_R");     data.cOrderlineId = vars.getStringParameter("inpcOrderlineId");     data.cOrderlineIdr = vars.getStringParameter("inpcOrderlineId_R");     data.iErrormsg = vars.getStringParameter("inpiErrormsg");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.doctypename = vars.getStringParameter("inpdoctypename");     data.cDoctypeId = vars.getStringParameter("inpcDoctypeId");     data.cDoctypeIdr = vars.getStringParameter("inpcDoctypeId_R");     data.documentno = vars.getStringParameter("inpdocumentno");     data.issotrx = vars.getStringParameter("inpissotrx", "N");     data.description = vars.getStringParameter("inpdescription");     data.vendorUpc = vars.getStringParameter("inpvendorUpc");     data.salesrepId = vars.getStringParameter("inpsalesrepId");     data.salesrepIdr = vars.getStringParameter("inpsalesrepId_R");     data.orderReferenceno = vars.getStringParameter("inporderReferenceno");     data.cCurrencyId = vars.getStringParameter("inpcCurrencyId");     data.cCurrencyIdr = vars.getStringParameter("inpcCurrencyId_R");     data.mPricelistId = vars.getStringParameter("inpmPricelistId");     data.mPricelistIdr = vars.getStringParameter("inpmPricelistId_R");     data.paymenttermvalue = vars.getStringParameter("inppaymenttermvalue");     data.cPaymenttermId = vars.getStringParameter("inpcPaymenttermId");     data.cPaymenttermIdr = vars.getStringParameter("inpcPaymenttermId_R");     data.mWarehouseId = vars.getStringParameter("inpmWarehouseId");     data.mWarehouseIdr = vars.getStringParameter("inpmWarehouseId_R");     data.mShipperId = vars.getStringParameter("inpmShipperId");     data.mShipperIdr = vars.getStringParameter("inpmShipperId_R");     data.dateordered = vars.getStringParameter("inpdateordered");     data.datepromised = vars.getStringParameter("inpdatepromised");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.bpartnerupc = vars.getStringParameter("inpbpartnerupc");     data.name = vars.getStringParameter("inpname");     data.bpartnervalue = vars.getStringParameter("inpbpartnervalue");     data.billtoId = vars.getStringParameter("inpbilltoId");     data.billtoIdr = vars.getStringParameter("inpbilltoId_R");     data.billtoUpc = vars.getStringParameter("inpbilltoUpc");     data.cBpartnerLocationId = vars.getStringParameter("inpcBpartnerLocationId");     data.cBpartnerLocationIdr = vars.getStringParameter("inpcBpartnerLocationId_R");     data.cBpartnerLocationUpc = vars.getStringParameter("inpcBpartnerLocationUpc");     data.cLocationId = vars.getStringParameter("inpcLocationId");     data.cLocationIdr = vars.getStringParameter("inpcLocationId_R");     data.address1 = vars.getStringParameter("inpaddress1");     data.address2 = vars.getStringParameter("inpaddress2");     data.city = vars.getStringParameter("inpcity");     data.postal = vars.getStringParameter("inppostal");     data.regionname = vars.getStringParameter("inpregionname");     data.cRegionId = vars.getStringParameter("inpcRegionId");     data.cRegionIdr = vars.getStringParameter("inpcRegionId_R");     data.countrycode = vars.getStringParameter("inpcountrycode");     data.cCountryId = vars.getStringParameter("inpcCountryId");     data.cCountryIdr = vars.getStringParameter("inpcCountryId_R");     data.adUserId = vars.getStringParameter("inpadUserId");     data.adUserIdr = vars.getStringParameter("inpadUserId_R");     data.contactname = vars.getStringParameter("inpcontactname");     data.phone = vars.getStringParameter("inpphone");     data.email = vars.getStringParameter("inpemail");     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.upc = vars.getStringParameter("inpupc");     data.productvalue = vars.getStringParameter("inpproductvalue");     data.sku = vars.getStringParameter("inpsku");     data.cUomId = vars.getStringParameter("inpcUomId");     data.cUomIdr = vars.getStringParameter("inpcUomId_R");    try {   data.qtyordered = vars.getNumericParameter("inpqtyordered");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.priceactual = vars.getNumericParameter("inppriceactual");  } catch (ServletException paramEx) { ex = paramEx; }     data.linedescription = vars.getStringParameter("inplinedescription");     data.taxindicator = vars.getStringParameter("inptaxindicator");     data.cTaxId = vars.getStringParameter("inpcTaxId");     data.cTaxIdr = vars.getStringParameter("inpcTaxId_R");    try {   data.taxamt = vars.getNumericParameter("inptaxamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.cCampaignId = vars.getStringParameter("inpcCampaignId");     data.cCampaignIdr = vars.getStringParameter("inpcCampaignId_R");     data.cActivityId = vars.getStringParameter("inpcActivityId");     data.cActivityIdr = vars.getStringParameter("inpcActivityId_R");     data.adOrgtrxId = vars.getStringParameter("inpadOrgtrxId");     data.adOrgtrxIdr = vars.getStringParameter("inpadOrgtrxId_R");     data.processing = vars.getStringParameter("inpprocessing");     data.processed = vars.getStringParameter("inpprocessed", "N"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");



    
         if (data.documentno.startsWith("<")) data.documentno = Utility.getDocumentNo(con, this, vars, windowId, "I_Order", "", data.cDoctypeId, false, true);

    
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

   private ImportOrderData[] getRelationData(ImportOrderData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].iOrderId = FormatUtilities.truncate(data[i].iOrderId, 10);        data[i].cOrderId = FormatUtilities.truncate(data[i].cOrderId, 44);        data[i].cOrderlineId = FormatUtilities.truncate(data[i].cOrderlineId, 44);        data[i].iErrormsg = FormatUtilities.truncate(data[i].iErrormsg, 50);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].doctypename = FormatUtilities.truncate(data[i].doctypename, 20);        data[i].cDoctypeId = FormatUtilities.truncate(data[i].cDoctypeId, 44);        data[i].documentno = FormatUtilities.truncate(data[i].documentno, 10);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].vendorUpc = FormatUtilities.truncate(data[i].vendorUpc, 30);        data[i].salesrepId = FormatUtilities.truncate(data[i].salesrepId, 44);        data[i].orderReferenceno = FormatUtilities.truncate(data[i].orderReferenceno, 40);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 44);        data[i].mPricelistId = FormatUtilities.truncate(data[i].mPricelistId, 44);        data[i].paymenttermvalue = FormatUtilities.truncate(data[i].paymenttermvalue, 20);        data[i].cPaymenttermId = FormatUtilities.truncate(data[i].cPaymenttermId, 44);        data[i].mWarehouseId = FormatUtilities.truncate(data[i].mWarehouseId, 44);        data[i].mShipperId = FormatUtilities.truncate(data[i].mShipperId, 44);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 44);        data[i].bpartnerupc = FormatUtilities.truncate(data[i].bpartnerupc, 30);        data[i].name = FormatUtilities.truncate(data[i].name, 20);        data[i].bpartnervalue = FormatUtilities.truncate(data[i].bpartnervalue, 20);        data[i].billtoId = FormatUtilities.truncate(data[i].billtoId, 44);        data[i].billtoUpc = FormatUtilities.truncate(data[i].billtoUpc, 30);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 44);        data[i].cBpartnerLocationUpc = FormatUtilities.truncate(data[i].cBpartnerLocationUpc, 30);        data[i].cLocationId = FormatUtilities.truncate(data[i].cLocationId, 50);        data[i].address1 = FormatUtilities.truncate(data[i].address1, 20);        data[i].address2 = FormatUtilities.truncate(data[i].address2, 20);        data[i].city = FormatUtilities.truncate(data[i].city, 20);        data[i].postal = FormatUtilities.truncate(data[i].postal, 10);        data[i].regionname = FormatUtilities.truncate(data[i].regionname, 20);        data[i].cRegionId = FormatUtilities.truncate(data[i].cRegionId, 44);        data[i].countrycode = FormatUtilities.truncate(data[i].countrycode, 2);        data[i].cCountryId = FormatUtilities.truncate(data[i].cCountryId, 44);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 44);        data[i].contactname = FormatUtilities.truncate(data[i].contactname, 20);        data[i].phone = FormatUtilities.truncate(data[i].phone, 20);        data[i].email = FormatUtilities.truncate(data[i].email, 20);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 44);        data[i].upc = FormatUtilities.truncate(data[i].upc, 20);        data[i].productvalue = FormatUtilities.truncate(data[i].productvalue, 20);        data[i].sku = FormatUtilities.truncate(data[i].sku, 20);        data[i].cUomId = FormatUtilities.truncate(data[i].cUomId, 44);        data[i].linedescription = FormatUtilities.truncate(data[i].linedescription, 50);        data[i].taxindicator = FormatUtilities.truncate(data[i].taxindicator, 5);        data[i].cTaxId = FormatUtilities.truncate(data[i].cTaxId, 44);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 44);        data[i].cCampaignId = FormatUtilities.truncate(data[i].cCampaignId, 44);        data[i].cActivityId = FormatUtilities.truncate(data[i].cActivityId, 44);        data[i].adOrgtrxId = FormatUtilities.truncate(data[i].adOrgtrxId, 44);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|I_Order_ID", data[0].getField("iOrderId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      ImportOrderData[] data = ImportOrderData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpiOrderId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strI_Order_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamAD_Client_ID = vars.getSessionValue(tabId + "|paramAD_Client_ID");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamAD_Client_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strI_Order_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strI_Order_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/ImportOrders/ImportOrder_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "ImportOrder", false, "document.frmMain.inpiOrderId", "grid", "..", "".equals("Y"), "ImportOrders", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "iOrderId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "ImportOrder_Relation.html", "ImportOrders", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "ImportOrder_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strI_Order_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " 1";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    ImportOrderData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamAD_Client_ID = vars.getSessionValue(tabId + "|paramAD_Client_ID");

    boolean hasSearchCondition=false;
    if (!(strParamAD_Client_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = ImportOrderData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strI_Order_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strI_Order_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new ImportOrderData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("iOrderId") == null || dataField.getField("iOrderId").equals("")) {
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
        data = ImportOrderData.set(Utility.getDefault(this, vars, "C_DocType_ID", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "TaxIndicator", "", "281", "512", "", dataField), "Y", Utility.getDefault(this, vars, "C_Order_ID", "", "281", "512", "", dataField), ImportOrderData.selectDef9000_0(this, Utility.getDefault(this, vars, "C_Order_ID", "", "281", "512", "", dataField)), "", Utility.getDefault(this, vars, "C_PaymentTerm_ID", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "LineDescription", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "Postal", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "Vendor_Upc", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "PaymentTermValue", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "281", "512", "", dataField), ImportOrderData.selectDef9008_1(this, Utility.getDefault(this, vars, "M_Product_ID", "", "281", "512", "", dataField)), Utility.getDefault(this, vars, "Address1", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "C_Region_ID", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "I_IsImported", "", "281", "512", "N", dataField), Utility.getDefault(this, vars, "ProductValue", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "ContactName", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "Processed", "", "281", "512", "N", dataField), Utility.getDefault(this, vars, "C_BPartner_Location_ID", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "281", "512", "", dataField), ImportOrderData.selectDef9019_2(this, Utility.getDefault(this, vars, "UpdatedBy", "", "281", "512", "", dataField)), Utility.getDefault(this, vars, "C_UOM_ID", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "C_OrderLine_ID", "", "281", "512", "", dataField), ImportOrderData.selectDef9001_3(this, Utility.getDefault(this, vars, "C_OrderLine_ID", "", "281", "512", "", dataField)), Utility.getDefault(this, vars, "SKU", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "Bpartnerupc", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "M_Warehouse_ID", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "CountryCode", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "281", "512", "", dataField), Utility.getDefault(this, vars, "IsSOTrx", "", "281", "512", "N", dataField), Utility.getDefault(this, vars, "Processing", "", "281", "512", "N", dataField), Utility.getDefault(this, vars, "C_BPartner_ID", "", "281", "512", "", dataField), ImportOrderData.selectDef9010_4(this, Utility.getDefault(this, vars, "C_BPartner_ID", "", "281", "512", "", dataField)), Utility.getDefault(this, vars, "Order_Referenceno", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "C_Campaign_ID", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "C_Tax_ID", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "Address2", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "DatePromised", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "C_Currency_ID", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "BillTo_ID", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "Name", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "AD_OrgTrx_ID", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "Billto_Upc", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "C_Bpartner_Location_Upc", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "M_Shipper_ID", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "DocTypeName", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "SalesRep_ID", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "Email", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "C_Location_ID", "", "281", "512", "", dataField), ImportOrderData.selectDef9408_5(this, Utility.getDefault(this, vars, "C_Location_ID", "", "281", "512", "", dataField)), Utility.getDefault(this, vars, "DateOrdered", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "C_Activity_ID", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "DocumentNo", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "281", "512", "", dataField), ImportOrderData.selectDef9004_6(this, Utility.getDefault(this, vars, "CreatedBy", "", "281", "512", "", dataField)), Utility.getDefault(this, vars, "C_Country_ID", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "TaxAmt", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "City", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "Description", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "I_ErrorMsg", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "M_PriceList_ID", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "RegionName", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "C_Project_ID", "", "281", "512", "", dataField), ImportOrderData.selectDef9012_7(this, Utility.getDefault(this, vars, "C_Project_ID", "", "281", "512", "", dataField)), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "281", "512", "", dataField), Utility.getDefault(this, vars, "UPC", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "BPartnerValue", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "PriceActual", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "AD_User_ID", "-1", "281", "512", "", dataField), Utility.getDefault(this, vars, "Phone", "", "281", "512", "", dataField), Utility.getDefault(this, vars, "QtyOrdered", "", "281", "512", "", dataField));
             data[0].documentno = "<" + Utility.getDocumentNo( this, vars, windowId, "I_Order", "", vars.getSessionValue(windowId + "|C_DocType_ID"), false, false) + ">";
      }
    } else {
      data = new ImportOrderData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(ImportOrderData) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "ImportOrder", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpiOrderId", "", "..", "".equals("Y"), "ImportOrders", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strI_Order_ID));
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
    ImportOrderData data = null;
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
                data.iOrderId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (ImportOrderData.getCurrentDBTimestamp(this, data.iOrderId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.iOrderId, vars, this);
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
                    data.iOrderId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|I_Order_ID", data.iOrderId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet ImportOrder. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
