
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.ItemActiveStatus;





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

public class ItemAA5160A40205448A8DB8F317C23AC2AB extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(ItemAA5160A40205448A8DB8F317C23AC2AB.class);
  
  private static final String windowId = "41CF1E6C3E65481F8CDE1B45EC1C669E";
  private static final String tabId = "AA5160A40205448A8DB8F317C23AC2AB";
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
        String strmProductId = request.getParameter("inpmProductId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strmProductId.equals(""))
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

      String strM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|ItemAA5160A40205448A8DB8F317C23AC2AB.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strM_Product_ID.equals("")) strM_Product_ID = firstElement(vars, tableSQL);
          if (strM_Product_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strM_Product_ID, tableSQL);

      else printPageDataSheet(response, vars, strM_Product_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strM_Product_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strM_Product_ID.equals("")) strM_Product_ID = vars.getRequiredGlobalVariable("inpmProductId", windowId + "|M_Product_ID");
      else vars.setSessionValue(windowId + "|M_Product_ID", strM_Product_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|ItemAA5160A40205448A8DB8F317C23AC2AB.view", "EDIT");

        printPageEdit(response, request, vars, false, strM_Product_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|ItemAA5160A40205448A8DB8F317C23AC2AB.view", "RELATION");
        printPageDataSheet(response, vars, strM_Product_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|ItemAA5160A40205448A8DB8F317C23AC2AB.view");
      String strM_Product_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strM_Product_ID = firstElement(vars, tableSQL);
          if (strM_Product_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strM_Product_ID.equals("")) strM_Product_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strM_Product_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamC_BPartner_ID", tabId + "|paramC_BPartner_ID");
vars.getRequestGlobalVariable("inpParamValue", tabId + "|paramValue");
vars.getRequestGlobalVariable("inpParamProduction", tabId + "|paramProduction");
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamM_Product_Category_ID", tabId + "|paramM_Product_Category_ID");
vars.getRequestGlobalVariable("inpParamProductType", tabId + "|paramProductType");
vars.getRequestGlobalVariable("inpParamTypeofproduct", tabId + "|paramTypeofproduct");
vars.getRequestGlobalVariable("inpParamVendorProductNo", tabId + "|paramVendorProductNo");
vars.getRequestGlobalVariable("inpParamUPC", tabId + "|paramUPC");
vars.getRequestGlobalVariable("inpParamDescription", tabId + "|paramDescription");
vars.getRequestGlobalVariable("inpParamDocumentNote", tabId + "|paramDocumentNote");
vars.getRequestGlobalVariable("inpParamIsStocked", tabId + "|paramIsStocked");
vars.getRequestGlobalVariable("inpParamIsPurchased", tabId + "|paramIsPurchased");
vars.getRequestGlobalVariable("inpParamIsSold", tabId + "|paramIsSold");
vars.getRequestGlobalVariable("inpParamAD_Org_ID", tabId + "|paramAD_Org_ID");

      
      
      vars.removeSessionValue(windowId + "|M_Product_ID");
      String strM_Product_ID="";

      String strView = vars.getSessionValue(tabId + "|ItemAA5160A40205448A8DB8F317C23AC2AB.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strM_Product_ID = firstElement(vars, tableSQL);
        if (strM_Product_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|ItemAA5160A40205448A8DB8F317C23AC2AB.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strM_Product_ID, tableSQL);

      else printPageDataSheet(response, vars, strM_Product_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID", "");
      vars.setSessionValue(tabId + "|ItemAA5160A40205448A8DB8F317C23AC2AB.view", "RELATION");
      printPageDataSheet(response, vars, strM_Product_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID", "");
      vars.setSessionValue(tabId + "|ItemAA5160A40205448A8DB8F317C23AC2AB.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strM_Product_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strM_Product_ID = vars.getRequiredStringParameter("inpmProductId");
      
      String strNext = nextElement(vars, strM_Product_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strM_Product_ID = vars.getRequiredStringParameter("inpmProductId");
      
      String strPrevious = previousElement(vars, strM_Product_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|ItemAA5160A40205448A8DB8F317C23AC2AB.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|ItemAA5160A40205448A8DB8F317C23AC2AB.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|ItemAA5160A40205448A8DB8F317C23AC2AB.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|ItemAA5160A40205448A8DB8F317C23AC2AB.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|M_Product_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|ItemAA5160A40205448A8DB8F317C23AC2AB.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|ItemAA5160A40205448A8DB8F317C23AC2AB.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|M_Product_ID");

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

      String strM_Product_ID = vars.getRequiredGlobalVariable("inpmProductId", windowId + "|M_Product_ID");
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
          String strNext = nextElement(vars, strM_Product_ID, tableSQL);
          vars.setSessionValue(windowId + "|M_Product_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strM_Product_ID = vars.getRequiredInStringParameter("inpmProductId");
      String message = deleteRelation(vars, strM_Product_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|mProductId");
        vars.setSessionValue(tabId + "|ItemAA5160A40205448A8DB8F317C23AC2AB.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strM_Product_ID = vars.getRequiredStringParameter("inpmProductId");
      //ItemAA5160A40205448A8DB8F317C23AC2ABData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = ItemAA5160A40205448A8DB8F317C23AC2ABData.delete(this, strM_Product_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|mProductId");
        vars.setSessionValue(tabId + "|ItemAA5160A40205448A8DB8F317C23AC2AB.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strM_Product_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strM_Product_ID.startsWith("(")) strM_Product_ID = strM_Product_ID.substring(1, strM_Product_ID.length()-1);
      if (!strM_Product_ID.equals("")) {
        strM_Product_ID = Replace.replace(strM_Product_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strM_Product_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (ItemAA5160A40205448A8DB8F317C23AC2ABData.deleteTransactional(conn, this, strKey)==0) {
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
  private ItemAA5160A40205448A8DB8F317C23AC2ABData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    ItemAA5160A40205448A8DB8F317C23AC2ABData data = new ItemAA5160A40205448A8DB8F317C23AC2ABData();
    ServletException ex = null;
    try {
    data.isactive = vars.getStringParameter("inpisactive", "N");     data.production = vars.getStringParameter("inpproduction", "N");     data.value = vars.getRequestGlobalVariable("inpvalue", windowId + "|Value");     data.name = vars.getRequestGlobalVariable("inpname", windowId + "|Name");     data.vendorproductno = vars.getStringParameter("inpvendorproductno");     data.isconsumable = vars.getStringParameter("inpisconsumable", "N");     data.mProductCategoryId = vars.getStringParameter("inpmProductCategoryId");     data.mProductCategoryIdr = vars.getStringParameter("inpmProductCategoryId_R");     data.producttype = vars.getStringParameter("inpproducttype");     data.producttyper = vars.getStringParameter("inpproducttype_R");     data.typeofproduct = vars.getStringParameter("inptypeofproduct");     data.typeofproductr = vars.getStringParameter("inptypeofproduct_R");     data.upc = vars.getStringParameter("inpupc");     data.description = vars.getStringParameter("inpdescription");     data.documentnote = vars.getStringParameter("inpdocumentnote");     data.isserviceitem = vars.getStringParameter("inpisserviceitem", "N");     data.isstocked = vars.getStringParameter("inpisstocked", "N");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.ispurchased = vars.getStringParameter("inpispurchased", "N");     data.issold = vars.getStringParameter("inpissold", "N");     data.ispriceprinted = vars.getStringParameter("inpispriceprinted", "N");    try {   data.coststd = vars.getNumericParameter("inpcoststd");  } catch (ServletException paramEx) { ex = paramEx; }     data.calculated = vars.getStringParameter("inpcalculated", "N");     data.buttoncopyitem = vars.getStringParameter("inpbuttoncopyitem");    try {   data.guaranteedays = vars.getNumericParameter("inpguaranteedays");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.delaymin = vars.getNumericParameter("inpdelaymin");  } catch (ServletException paramEx) { ex = paramEx; }     data.descriptionurl = vars.getStringParameter("inpdescriptionurl");     data.setready4production = vars.getRequestGlobalVariable("inpsetready4production", windowId + "|Setready4production");     data.discontinued = vars.getStringParameter("inpdiscontinued", "N");     data.isbom = vars.getRequiredInputGlobalVariable("inpisbom", windowId + "|IsBOM", "N");     data.sku = vars.getStringParameter("inpsku");     data.maProcessplanId = vars.getStringParameter("inpmaProcessplanId");    try {   data.volume = vars.getNumericParameter("inpvolume");  } catch (ServletException paramEx) { ex = paramEx; }     data.mAttributesetinstanceId = vars.getStringParameter("inpmAttributesetinstanceId");     data.classification = vars.getStringParameter("inpclassification");     data.sExpensetypeId = vars.getStringParameter("inpsExpensetypeId");    try {   data.unitsperpallet = vars.getNumericParameter("inpunitsperpallet");  } catch (ServletException paramEx) { ex = paramEx; }     data.mrpPlanningmethodId = vars.getStringParameter("inpmrpPlanningmethodId");     data.costtype = vars.getStringParameter("inpcosttype");     data.name2 = vars.getStringParameter("inpname2");     data.discontinuedby = vars.getStringParameter("inpdiscontinuedby");    try {   data.shelfdepth = vars.getNumericParameter("inpshelfdepth");  } catch (ServletException paramEx) { ex = paramEx; }     data.imageurl = vars.getStringParameter("inpimageurl");    try {   data.shelfwidth = vars.getNumericParameter("inpshelfwidth");  } catch (ServletException paramEx) { ex = paramEx; }     data.qtytype = vars.getStringParameter("inpqtytype", "N");     data.mAttributesetId = vars.getStringParameter("inpmAttributesetId");     data.salesrepId = vars.getStringParameter("inpsalesrepId");     data.mProductId = vars.getRequestGlobalVariable("inpmProductId", windowId + "|M_Product_ID");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");    try {   data.shelfheight = vars.getNumericParameter("inpshelfheight");  } catch (ServletException paramEx) { ex = paramEx; }     data.mFreightcategoryId = vars.getStringParameter("inpmFreightcategoryId");     data.cUomId = vars.getStringParameter("inpcUomId");     data.isinvoiceprintdetails = vars.getStringParameter("inpisinvoiceprintdetails", "N");     data.cTaxId = vars.getStringParameter("inpcTaxId");    try {   data.stockmin = vars.getNumericParameter("inpstockmin");  } catch (ServletException paramEx) { ex = paramEx; }     data.buttonprintbom = vars.getStringParameter("inpbuttonprintbom");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.isverified = vars.getStringParameter("inpisverified", "N");     data.enforceAttribute = vars.getStringParameter("inpenforceAttribute", "N");     data.downloadurl = vars.getStringParameter("inpdownloadurl");     data.ispicklistprintdetails = vars.getStringParameter("inpispicklistprintdetails", "N");     data.mLocatorId = vars.getStringParameter("inpmLocatorId");     data.versionno = vars.getStringParameter("inpversionno");    try {   data.qtystd = vars.getNumericParameter("inpqtystd");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.capacity = vars.getNumericParameter("inpcapacity");  } catch (ServletException paramEx) { ex = paramEx; }     data.sResourceId = vars.getStringParameter("inpsResourceId");     data.processing = vars.getStringParameter("inpprocessing");    try {   data.qtymax = vars.getNumericParameter("inpqtymax");  } catch (ServletException paramEx) { ex = paramEx; }     data.adImageId = vars.getStringParameter("inpadImageId");     data.help = vars.getStringParameter("inphelp");    try {   data.stockMin = vars.getNumericParameter("inpstockMin");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qtymin = vars.getNumericParameter("inpqtymin");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.weight = vars.getNumericParameter("inpweight");  } catch (ServletException paramEx) { ex = paramEx; }     data.mrpPlannerId = vars.getStringParameter("inpmrpPlannerId");     data.issparepart = vars.getStringParameter("inpissparepart", "N"); 
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

   private ItemAA5160A40205448A8DB8F317C23AC2ABData[] getRelationData(ItemAA5160A40205448A8DB8F317C23AC2ABData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].value = FormatUtilities.truncate(data[i].value, 20);        data[i].name = FormatUtilities.truncate(data[i].name, 40);        data[i].vendorproductno = FormatUtilities.truncate(data[i].vendorproductno, 40);        data[i].mProductCategoryId = FormatUtilities.truncate(data[i].mProductCategoryId, 22);        data[i].producttype = FormatUtilities.truncate(data[i].producttype, 50);        data[i].typeofproduct = FormatUtilities.truncate(data[i].typeofproduct, 50);        data[i].upc = FormatUtilities.truncate(data[i].upc, 30);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].documentnote = FormatUtilities.truncate(data[i].documentnote, 50);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 50);        data[i].descriptionurl = FormatUtilities.truncate(data[i].descriptionurl, 50);        data[i].sku = FormatUtilities.truncate(data[i].sku, 30);        data[i].maProcessplanId = FormatUtilities.truncate(data[i].maProcessplanId, 12);        data[i].mAttributesetinstanceId = FormatUtilities.truncate(data[i].mAttributesetinstanceId, 22);        data[i].classification = FormatUtilities.truncate(data[i].classification, 1);        data[i].sExpensetypeId = FormatUtilities.truncate(data[i].sExpensetypeId, 22);        data[i].mrpPlanningmethodId = FormatUtilities.truncate(data[i].mrpPlanningmethodId, 32);        data[i].costtype = FormatUtilities.truncate(data[i].costtype, 50);        data[i].name2 = FormatUtilities.truncate(data[i].name2, 50);        data[i].imageurl = FormatUtilities.truncate(data[i].imageurl, 50);        data[i].mAttributesetId = FormatUtilities.truncate(data[i].mAttributesetId, 22);        data[i].salesrepId = FormatUtilities.truncate(data[i].salesrepId, 22);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 40);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 22);        data[i].mFreightcategoryId = FormatUtilities.truncate(data[i].mFreightcategoryId, 22);        data[i].cUomId = FormatUtilities.truncate(data[i].cUomId, 22);        data[i].cTaxId = FormatUtilities.truncate(data[i].cTaxId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 22);        data[i].downloadurl = FormatUtilities.truncate(data[i].downloadurl, 50);        data[i].mLocatorId = FormatUtilities.truncate(data[i].mLocatorId, 50);        data[i].versionno = FormatUtilities.truncate(data[i].versionno, 20);        data[i].sResourceId = FormatUtilities.truncate(data[i].sResourceId, 22);        data[i].adImageId = FormatUtilities.truncate(data[i].adImageId, 12);        data[i].help = FormatUtilities.truncate(data[i].help, 50);        data[i].mrpPlannerId = FormatUtilities.truncate(data[i].mrpPlannerId, 32);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Value", data[0].getField("value"));    vars.setSessionValue(windowId + "|Name", data[0].getField("name"));    vars.setSessionValue(windowId + "|Setready4production", data[0].getField("setready4production"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|M_Product_ID", data[0].getField("mProductId"));    vars.setSessionValue(windowId + "|IsBOM", data[0].getField("isbom"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      ItemAA5160A40205448A8DB8F317C23AC2ABData[] data = ItemAA5160A40205448A8DB8F317C23AC2ABData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpmProductId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strM_Product_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamProduction = vars.getSessionValue(tabId + "|paramProduction");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamM_Product_Category_ID = vars.getSessionValue(tabId + "|paramM_Product_Category_ID");
String strParamProductType = vars.getSessionValue(tabId + "|paramProductType");
String strParamTypeofproduct = vars.getSessionValue(tabId + "|paramTypeofproduct");
String strParamVendorProductNo = vars.getSessionValue(tabId + "|paramVendorProductNo");
String strParamUPC = vars.getSessionValue(tabId + "|paramUPC");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamDocumentNote = vars.getSessionValue(tabId + "|paramDocumentNote");
String strParamIsStocked = vars.getSessionValue(tabId + "|paramIsStocked");
String strParamIsPurchased = vars.getSessionValue(tabId + "|paramIsPurchased");
String strParamIsSold = vars.getSessionValue(tabId + "|paramIsSold");
String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamC_BPartner_ID.equals("") && strParamValue.equals("") && strParamProduction.equals("") && strParamName.equals("") && strParamM_Product_Category_ID.equals("") && strParamProductType.equals("") && strParamTypeofproduct.equals("") && strParamVendorProductNo.equals("") && strParamUPC.equals("") && strParamDescription.equals("") && strParamDocumentNote.equals("") && strParamIsStocked.equals("") && strParamIsPurchased.equals("") && strParamIsSold.equals("") && strParamAD_Org_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strM_Product_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strM_Product_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/smartui/ItemActiveStatus/ItemAA5160A40205448A8DB8F317C23AC2AB_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "ItemAA5160A40205448A8DB8F317C23AC2AB", false, "document.frmMain.inpmProductId", "grid", "..", "".equals("Y"), "ItemActiveStatus", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "mProductId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "ItemAA5160A40205448A8DB8F317C23AC2AB_Relation.html", "ItemActiveStatus", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "ItemAA5160A40205448A8DB8F317C23AC2AB_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strM_Product_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " M_Product.Value";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    ItemAA5160A40205448A8DB8F317C23AC2ABData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamProduction = vars.getSessionValue(tabId + "|paramProduction");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamM_Product_Category_ID = vars.getSessionValue(tabId + "|paramM_Product_Category_ID");
String strParamProductType = vars.getSessionValue(tabId + "|paramProductType");
String strParamTypeofproduct = vars.getSessionValue(tabId + "|paramTypeofproduct");
String strParamVendorProductNo = vars.getSessionValue(tabId + "|paramVendorProductNo");
String strParamUPC = vars.getSessionValue(tabId + "|paramUPC");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamDocumentNote = vars.getSessionValue(tabId + "|paramDocumentNote");
String strParamIsStocked = vars.getSessionValue(tabId + "|paramIsStocked");
String strParamIsPurchased = vars.getSessionValue(tabId + "|paramIsPurchased");
String strParamIsSold = vars.getSessionValue(tabId + "|paramIsSold");
String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");

    boolean hasSearchCondition=false;
    if (!(strParamC_BPartner_ID.equals("") && strParamValue.equals("") && strParamProduction.equals("") && strParamName.equals("") && strParamM_Product_Category_ID.equals("") && strParamProductType.equals("") && strParamTypeofproduct.equals("") && strParamVendorProductNo.equals("") && strParamUPC.equals("") && strParamDescription.equals("") && strParamDocumentNote.equals("") && strParamIsStocked.equals("") && strParamIsPurchased.equals("") && strParamIsSold.equals("") && strParamAD_Org_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = ItemAA5160A40205448A8DB8F317C23AC2ABData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strM_Product_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strM_Product_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new ItemAA5160A40205448A8DB8F317C23AC2ABData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("mProductId") == null || dataField.getField("mProductId").equals("")) {
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
        data = ItemAA5160A40205448A8DB8F317C23AC2ABData.set(Utility.getDefault(this, vars, "ShelfWidth", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "M_Product_Category_ID", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "DocumentNote", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "Costtype", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "Stockmin", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "S_ExpenseType_ID", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "M_AttributeSet_ID", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), ItemAA5160A40205448A8DB8F317C23AC2ABData.selectDef1407_0(this, Utility.getDefault(this, vars, "CreatedBy", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField)), Utility.getDefault(this, vars, "Weight", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), ItemAA5160A40205448A8DB8F317C23AC2ABData.selectDef2011(this, Utility.getContext(this, vars, "AD_ORG_ID", "41CF1E6C3E65481F8CDE1B45EC1C669E")), Utility.getDefault(this, vars, "C_BPartner_ID", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "IsInvoicePrintDetails", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), Utility.getDefault(this, vars, "MRP_Planner_ID", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "IsBOM", "N", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), Utility.getDefault(this, vars, "Delaymin", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "MA_Processplan_ID", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "Help", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "Name", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "Ispriceprinted", "Y", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), "", Utility.getDefault(this, vars, "SKU", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "DownloadURL", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "DiscontinuedBy", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "IsStocked", "Y", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), Utility.getDefault(this, vars, "Buttoncopyitem", "N", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "Discontinued", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), Utility.getDefault(this, vars, "M_AttributeSetInstance_ID", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "Classification", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "Description", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "VersionNo", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "Buttonprintbom", "N", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), Utility.getDefault(this, vars, "M_Locator_ID", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "IsSold", "Y", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), Utility.getDefault(this, vars, "Qtystd", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "Calculated", "Y", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), Utility.getDefault(this, vars, "isConsumable", "N", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), Utility.getDefault(this, vars, "Qtymax", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "S_Resource_ID", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "Typeofproduct", "ST", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "Processing", "N", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), Utility.getDefault(this, vars, "Name2", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "Production", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), Utility.getDefault(this, vars, "AD_Image_ID", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "Qtytype", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "isServiceItem", "N", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), Utility.getDefault(this, vars, "Enforce_Attribute", "N", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), Utility.getDefault(this, vars, "ProductType", "I", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "Stock_Min", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "isSparePart", "N", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), ItemAA5160A40205448A8DB8F317C23AC2ABData.selectDef2304(this, Utility.getContext(this, vars, "AD_ORG_ID", "41CF1E6C3E65481F8CDE1B45EC1C669E")), Utility.getDefault(this, vars, "SalesRep_ID", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "Setready4production", "N", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), Utility.getDefault(this, vars, "MRP_Planningmethod_ID", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "VendorProductNo", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "ShelfHeight", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), ItemAA5160A40205448A8DB8F317C23AC2ABData.selectDef1760(this), Utility.getDefault(this, vars, "GuaranteeDays", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "UnitsPerPallet", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), ItemAA5160A40205448A8DB8F317C23AC2ABData.selectDef1409_1(this, Utility.getDefault(this, vars, "UpdatedBy", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField)), Utility.getDefault(this, vars, "Capacity", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), "Y", Utility.getDefault(this, vars, "isVerified", "N", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), Utility.getDefault(this, vars, "Qtymin", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "IsPurchased", "Y", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), Utility.getDefault(this, vars, "M_FreightCategory_ID", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "Volume", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "ShelfDepth", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "Coststd", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "C_Tax_ID", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "DescriptionURL", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField), Utility.getDefault(this, vars, "IsPickListPrintDetails", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "N", dataField), Utility.getDefault(this, vars, "ImageURL", "", "41CF1E6C3E65481F8CDE1B45EC1C669E", "AA5160A40205448A8DB8F317C23AC2AB", "", dataField));
        
      }
    } else {
      data = new ItemAA5160A40205448A8DB8F317C23AC2ABData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(ItemAA5160A40205448A8DB8F317C23AC2ABData) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "ItemAA5160A40205448A8DB8F317C23AC2AB", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpmProductId", "", "..", "".equals("Y"), "ItemActiveStatus", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strM_Product_ID));
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
    ItemAA5160A40205448A8DB8F317C23AC2ABData data = null;
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
                data.mProductId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (ItemAA5160A40205448A8DB8F317C23AC2ABData.getCurrentDBTimestamp(this, data.mProductId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.mProductId, vars, this);
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
                    data.mProductId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|M_Product_ID", data.mProductId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet ItemAA5160A40205448A8DB8F317C23AC2AB. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
