
package org.openbravo.erpWindows.BusinessPartner;





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

public class BusinessPartner extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(BusinessPartner.class);
  
  private static final String windowId = "123";
  private static final String tabId = "220";
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
        String strcBpartnerId = request.getParameter("inpcBpartnerId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcBpartnerId.equals(""))
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

      String strC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|BusinessPartner.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_BPartner_ID.equals("")) strC_BPartner_ID = firstElement(vars, tableSQL);
          if (strC_BPartner_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_BPartner_ID, tableSQL);

      else printPageDataSheet(response, vars, strC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_BPartner_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_BPartner_ID.equals("")) strC_BPartner_ID = vars.getRequiredGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      else vars.setSessionValue(windowId + "|C_BPartner_ID", strC_BPartner_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|BusinessPartner.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_BPartner_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|BusinessPartner.view", "RELATION");
        printPageDataSheet(response, vars, strC_BPartner_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|BusinessPartner.view");
      String strC_BPartner_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_BPartner_ID = firstElement(vars, tableSQL);
          if (strC_BPartner_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_BPartner_ID.equals("")) strC_BPartner_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_BPartner_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamValue", tabId + "|paramValue");
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamTaxID", tabId + "|paramTaxID");
vars.getRequestGlobalVariable("inpParamC_BP_Group_ID", tabId + "|paramC_BP_Group_ID");
vars.getRequestGlobalVariable("inpParamIsCustomer", tabId + "|paramIsCustomer");
vars.getRequestGlobalVariable("inpParamIsVendor", tabId + "|paramIsVendor");
vars.getRequestGlobalVariable("inpParamIsActive", tabId + "|paramIsActive");
vars.getRequestGlobalVariable("inpParamZssi_Groupofcompanies_ID", tabId + "|paramZssi_Groupofcompanies_ID");
vars.getRequestGlobalVariable("inpParamCountry", tabId + "|paramCountry");
vars.getRequestGlobalVariable("inpParamCity", tabId + "|paramCity");
vars.getRequestGlobalVariable("inpParamZipcode", tabId + "|paramZipcode");
vars.getRequestGlobalVariable("inpParamisSalesLead", tabId + "|paramisSalesLead");
vars.getRequestGlobalVariable("inpParamOwncodeatpartnersite", tabId + "|paramOwncodeatpartnersite");
vars.getRequestGlobalVariable("inpParamAD_Org_ID", tabId + "|paramAD_Org_ID");
vars.getRequestGlobalVariable("inpParamDescription", tabId + "|paramDescription");
vars.getRequestGlobalVariable("inpParamRating", tabId + "|paramRating");

      
      
      vars.removeSessionValue(windowId + "|C_BPartner_ID");
      String strC_BPartner_ID="";

      String strView = vars.getSessionValue(tabId + "|BusinessPartner.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_BPartner_ID = firstElement(vars, tableSQL);
        if (strC_BPartner_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|BusinessPartner.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_BPartner_ID, tableSQL);

      else printPageDataSheet(response, vars, strC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", "");
      vars.setSessionValue(tabId + "|BusinessPartner.view", "RELATION");
      printPageDataSheet(response, vars, strC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", "");
      vars.setSessionValue(tabId + "|BusinessPartner.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_BPartner_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strC_BPartner_ID = vars.getRequiredStringParameter("inpcBpartnerId");
      
      String strNext = nextElement(vars, strC_BPartner_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strC_BPartner_ID = vars.getRequiredStringParameter("inpcBpartnerId");
      
      String strPrevious = previousElement(vars, strC_BPartner_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|BusinessPartner.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|BusinessPartner.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|BusinessPartner.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|BusinessPartner.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_BPartner_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|BusinessPartner.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|BusinessPartner.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_BPartner_ID");

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

      String strC_BPartner_ID = vars.getRequiredGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
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
          String strNext = nextElement(vars, strC_BPartner_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_BPartner_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strC_BPartner_ID = vars.getRequiredInStringParameter("inpcBpartnerId");
      String message = deleteRelation(vars, strC_BPartner_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cBpartnerId");
        vars.setSessionValue(tabId + "|BusinessPartner.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strC_BPartner_ID = vars.getRequiredStringParameter("inpcBpartnerId");
      //BusinessPartnerData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = BusinessPartnerData.delete(this, strC_BPartner_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cBpartnerId");
        vars.setSessionValue(tabId + "|BusinessPartner.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strC_BPartner_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_BPartner_ID.startsWith("(")) strC_BPartner_ID = strC_BPartner_ID.substring(1, strC_BPartner_ID.length()-1);
      if (!strC_BPartner_ID.equals("")) {
        strC_BPartner_ID = Replace.replace(strC_BPartner_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_BPartner_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (BusinessPartnerData.deleteTransactional(conn, this, strKey)==0) {
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
  private BusinessPartnerData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    BusinessPartnerData data = new BusinessPartnerData();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.value = vars.getRequestGlobalVariable("inpvalue", windowId + "|Value");     data.name = vars.getStringParameter("inpname");     data.name2 = vars.getStringParameter("inpname2");     data.description = vars.getStringParameter("inpdescription");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.issaleslead = vars.getStringParameter("inpissaleslead", "N");     data.taxid = vars.getStringParameter("inptaxid");     data.referenceno = vars.getStringParameter("inpreferenceno");     data.rating = vars.getStringParameter("inprating");     data.owncodeatpartnersite = vars.getStringParameter("inpowncodeatpartnersite");     data.cBpGroupId = vars.getStringParameter("inpcBpGroupId");     data.cBpGroupIdr = vars.getStringParameter("inpcBpGroupId_R");     data.adLanguage = vars.getStringParameter("inpadLanguage");     data.adLanguager = vars.getStringParameter("inpadLanguage_R");     data.zssiGroupofcompaniesId = vars.getStringParameter("inpzssiGroupofcompaniesId");     data.zssiGroupofcompaniesIdr = vars.getStringParameter("inpzssiGroupofcompaniesId_R");     data.cLineofbusinessId = vars.getStringParameter("inpcLineofbusinessId");     data.cLineofbusinessIdr = vars.getStringParameter("inpcLineofbusinessId_R");     data.country = vars.getStringParameter("inpcountry");     data.zipcode = vars.getStringParameter("inpzipcode");     data.city = vars.getStringParameter("inpcity");     data.url = vars.getStringParameter("inpurl");     data.isprospect = vars.getStringParameter("inpisprospect", "N");    try {   data.potentiallifetimevalue = vars.getNumericParameter("inppotentiallifetimevalue");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.actuallifetimevalue = vars.getNumericParameter("inpactuallifetimevalue");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.numberemployees = vars.getNumericParameter("inpnumberemployees");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.shareofcustomer = vars.getNumericParameter("inpshareofcustomer");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.lastDays = vars.getNumericParameter("inplastDays");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.salesvolume = vars.getNumericParameter("inpsalesvolume");  } catch (ServletException paramEx) { ex = paramEx; }     data.firstsale = vars.getStringParameter("inpfirstsale");    try {   data.acqusitioncost = vars.getNumericParameter("inpacqusitioncost");  } catch (ServletException paramEx) { ex = paramEx; }     data.istaxexempt = vars.getStringParameter("inpistaxexempt", "N");     data.isonetime = vars.getStringParameter("inpisonetime", "N");    try {   data.soCreditused = vars.getNumericParameter("inpsoCreditused");  } catch (ServletException paramEx) { ex = paramEx; }     data.naics = vars.getStringParameter("inpnaics");     data.issummary = vars.getStringParameter("inpissummary", "N");     data.duns = vars.getStringParameter("inpduns");     data.cBpartnerId = vars.getRequestGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");     data.adForcedOrgId = vars.getStringParameter("inpadForcedOrgId");     data.showpriceinorder = vars.getStringParameter("inpshowpriceinorder", "N");     data.iscustomer = vars.getStringParameter("inpiscustomer", "N");     data.isvendor = vars.getStringParameter("inpisvendor", "N");     data.upc = vars.getStringParameter("inpupc");     data.isofiscalcode = vars.getStringParameter("inpisofiscalcode");     data.invoicegrouping = vars.getStringParameter("inpinvoicegrouping");     data.socreditstatus = vars.getStringParameter("inpsocreditstatus");     data.isworker = vars.getStringParameter("inpisworker", "N");     data.invoicerule = vars.getStringParameter("inpinvoicerule");     data.fiscalcode = vars.getStringParameter("inpfiscalcode"); 
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

   private BusinessPartnerData[] getRelationData(BusinessPartnerData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].value = FormatUtilities.truncate(data[i].value, 24);        data[i].name = FormatUtilities.truncate(data[i].name, 40);        data[i].name2 = FormatUtilities.truncate(data[i].name2, 50);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].taxid = FormatUtilities.truncate(data[i].taxid, 12);        data[i].referenceno = FormatUtilities.truncate(data[i].referenceno, 11);        data[i].rating = FormatUtilities.truncate(data[i].rating, 1);        data[i].owncodeatpartnersite = FormatUtilities.truncate(data[i].owncodeatpartnersite, 0);        data[i].cBpGroupId = FormatUtilities.truncate(data[i].cBpGroupId, 20);        data[i].adLanguage = FormatUtilities.truncate(data[i].adLanguage, 44);        data[i].zssiGroupofcompaniesId = FormatUtilities.truncate(data[i].zssiGroupofcompaniesId, 0);        data[i].cLineofbusinessId = FormatUtilities.truncate(data[i].cLineofbusinessId, 0);        data[i].country = FormatUtilities.truncate(data[i].country, 23);        data[i].zipcode = FormatUtilities.truncate(data[i].zipcode, 10);        data[i].city = FormatUtilities.truncate(data[i].city, 50);        data[i].url = FormatUtilities.truncate(data[i].url, 50);        data[i].naics = FormatUtilities.truncate(data[i].naics, 6);        data[i].duns = FormatUtilities.truncate(data[i].duns, 11);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 10);        data[i].adForcedOrgId = FormatUtilities.truncate(data[i].adForcedOrgId, 44);        data[i].upc = FormatUtilities.truncate(data[i].upc, 0);        data[i].isofiscalcode = FormatUtilities.truncate(data[i].isofiscalcode, 0);        data[i].invoicegrouping = FormatUtilities.truncate(data[i].invoicegrouping, 0);        data[i].socreditstatus = FormatUtilities.truncate(data[i].socreditstatus, 21);        data[i].invoicerule = FormatUtilities.truncate(data[i].invoicerule, 0);        data[i].fiscalcode = FormatUtilities.truncate(data[i].fiscalcode, 0);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|Value", data[0].getField("value"));    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].getField("cBpartnerId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      BusinessPartnerData[] data = BusinessPartnerData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpcBpartnerId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strC_BPartner_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamTaxID = vars.getSessionValue(tabId + "|paramTaxID");
String strParamC_BP_Group_ID = vars.getSessionValue(tabId + "|paramC_BP_Group_ID");
String strParamIsCustomer = vars.getSessionValue(tabId + "|paramIsCustomer");
String strParamIsVendor = vars.getSessionValue(tabId + "|paramIsVendor");
String strParamIsActive = vars.getSessionValue(tabId + "|paramIsActive");
String strParamZssi_Groupofcompanies_ID = vars.getSessionValue(tabId + "|paramZssi_Groupofcompanies_ID");
String strParamCountry = vars.getSessionValue(tabId + "|paramCountry");
String strParamCity = vars.getSessionValue(tabId + "|paramCity");
String strParamZipcode = vars.getSessionValue(tabId + "|paramZipcode");
String strParamisSalesLead = vars.getSessionValue(tabId + "|paramisSalesLead");
String strParamOwncodeatpartnersite = vars.getSessionValue(tabId + "|paramOwncodeatpartnersite");
String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamRating = vars.getSessionValue(tabId + "|paramRating");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamValue.equals("") && strParamName.equals("") && strParamTaxID.equals("") && strParamC_BP_Group_ID.equals("") && strParamIsCustomer.equals("") && strParamIsVendor.equals("") && strParamIsActive.equals("") && strParamZssi_Groupofcompanies_ID.equals("") && strParamCountry.equals("") && strParamCity.equals("") && strParamZipcode.equals("") && strParamisSalesLead.equals("") && strParamOwncodeatpartnersite.equals("") && strParamAD_Org_ID.equals("") && strParamDescription.equals("") && strParamRating.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_BPartner_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_BPartner_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/BusinessPartner/BusinessPartner_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "BusinessPartner", false, "document.frmMain.inpcBpartnerId", "grid", "../RptC_Bpartner.html", "N".equals("Y"), "BusinessPartner", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "cBpartnerId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "BusinessPartner_Relation.html", "BusinessPartner", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "BusinessPartner_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_BPartner_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " C_BPartner.Value";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    BusinessPartnerData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamTaxID = vars.getSessionValue(tabId + "|paramTaxID");
String strParamC_BP_Group_ID = vars.getSessionValue(tabId + "|paramC_BP_Group_ID");
String strParamIsCustomer = vars.getSessionValue(tabId + "|paramIsCustomer");
String strParamIsVendor = vars.getSessionValue(tabId + "|paramIsVendor");
String strParamIsActive = vars.getSessionValue(tabId + "|paramIsActive");
String strParamZssi_Groupofcompanies_ID = vars.getSessionValue(tabId + "|paramZssi_Groupofcompanies_ID");
String strParamCountry = vars.getSessionValue(tabId + "|paramCountry");
String strParamCity = vars.getSessionValue(tabId + "|paramCity");
String strParamZipcode = vars.getSessionValue(tabId + "|paramZipcode");
String strParamisSalesLead = vars.getSessionValue(tabId + "|paramisSalesLead");
String strParamOwncodeatpartnersite = vars.getSessionValue(tabId + "|paramOwncodeatpartnersite");
String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamRating = vars.getSessionValue(tabId + "|paramRating");

    boolean hasSearchCondition=false;
    if (!(strParamValue.equals("") && strParamName.equals("") && strParamTaxID.equals("") && strParamC_BP_Group_ID.equals("") && strParamIsCustomer.equals("") && strParamIsVendor.equals("") && strParamIsActive.equals("") && strParamZssi_Groupofcompanies_ID.equals("") && strParamCountry.equals("") && strParamCity.equals("") && strParamZipcode.equals("") && strParamisSalesLead.equals("") && strParamOwncodeatpartnersite.equals("") && strParamAD_Org_ID.equals("") && strParamDescription.equals("") && strParamRating.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = BusinessPartnerData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strC_BPartner_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_BPartner_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new BusinessPartnerData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cBpartnerId") == null || dataField.getField("cBpartnerId").equals("")) {
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
        data = BusinessPartnerData.set(Utility.getDefault(this, vars, "ReferenceNo", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "Name", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "SO_CreditUsed", "", "123", "220", "", dataField), "Y", Utility.getDefault(this, vars, "Owncodeatpartnersite", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "Last_Days", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "123", "220", "", dataField), BusinessPartnerData.selectDef2900_0(this, Utility.getDefault(this, vars, "UpdatedBy", "", "123", "220", "", dataField)), Utility.getDefault(this, vars, "UPC", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "ActualLifeTimeValue", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "Description", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "IsOneTime", "", "123", "220", "N", dataField), "", Utility.getDefault(this, vars, "NumberEmployees", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "Country", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "InvoiceRule", "I", "123", "220", "", dataField), Utility.getDefault(this, vars, "Zssi_Groupofcompanies_ID", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "ShareOfCustomer", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "FirstSale", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "City", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "Fiscalcode", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "AD_Language", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "TaxID", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "Zipcode", "", "123", "220", "", dataField), BusinessPartnerData.selectDef2901(this, Utility.getContext(this, vars, "AD_ORG_ID", "123")), Utility.getDefault(this, vars, "isSalesLead", "N", "123", "220", "N", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "123", "220", "", dataField), Utility.getDefault(this, vars, "IsSummary", "", "123", "220", "N", dataField), Utility.getDefault(this, vars, "DUNS", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "ShowPriceInOrder", "Y", "123", "220", "N", dataField), Utility.getDefault(this, vars, "Invoicegrouping", "000000000000000", "123", "220", "", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "123", "220", "", dataField), BusinessPartnerData.selectDef2898_1(this, Utility.getDefault(this, vars, "CreatedBy", "", "123", "220", "", dataField)), Utility.getDefault(this, vars, "Rating", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "SalesVolume", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "Name2", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "SOCreditStatus", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "123", "220", "", dataField), Utility.getDefault(this, vars, "C_Lineofbusiness_ID", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "URL", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "AD_Forced_Org_ID", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "NAICS", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "AcqusitionCost", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "IsCustomer", "N", "123", "220", "N", dataField), Utility.getDefault(this, vars, "ISOFiscalCode", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "IsTaxExempt", "", "123", "220", "N", dataField), Utility.getDefault(this, vars, "C_BP_Group_ID", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "Isworker", "N", "123", "220", "N", dataField), Utility.getDefault(this, vars, "IsVendor", "", "123", "220", "N", dataField), Utility.getDefault(this, vars, "PotentialLifeTimeValue", "", "123", "220", "", dataField), Utility.getDefault(this, vars, "IsProspect", "", "123", "220", "N", dataField));
        
      }
    } else {
      data = new BusinessPartnerData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(BusinessPartnerData) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "BusinessPartner", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcBpartnerId", "", "../RptC_Bpartner.html", "N".equals("Y"), "BusinessPartner", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_BPartner_ID));
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
      String result = "var strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\nvar strBPARTNERVALUEREADONLY=\"" + Utility.getContext(this, vars, "BPARTNERVALUEREADONLY", windowId) + "\";\n";
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
    BusinessPartnerData data = null;
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
                data.cBpartnerId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (BusinessPartnerData.getCurrentDBTimestamp(this, data.cBpartnerId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cBpartnerId, vars, this);
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
                    data.cBpartnerId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_BPartner_ID", data.cBpartnerId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet BusinessPartner. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
