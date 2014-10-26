
package org.openbravo.erpWindows.org.openbravo.zsoft.finance.Assets;


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

public class Assets800078 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Assets800078.class);
  
  private static final String windowId = "800027";
  private static final String tabId = "800078";
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
        String straAssetId = request.getParameter("inpaAssetId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !straAssetId.equals(""))
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

      String strA_Asset_ID = vars.getGlobalVariable("inpaAssetId", windowId + "|A_Asset_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|Assets800078.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strA_Asset_ID.equals("")) strA_Asset_ID = firstElement(vars, tableSQL);
          if (strA_Asset_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strA_Asset_ID, tableSQL);

      else printPageDataSheet(response, vars, strA_Asset_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strA_Asset_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strA_Asset_ID.equals("")) strA_Asset_ID = vars.getRequiredGlobalVariable("inpaAssetId", windowId + "|A_Asset_ID");
      else vars.setSessionValue(windowId + "|A_Asset_ID", strA_Asset_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Assets800078.view", "EDIT");

        printPageEdit(response, request, vars, false, strA_Asset_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Assets800078.view", "RELATION");
        printPageDataSheet(response, vars, strA_Asset_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|Assets800078.view");
      String strA_Asset_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strA_Asset_ID = firstElement(vars, tableSQL);
          if (strA_Asset_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strA_Asset_ID.equals("")) strA_Asset_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strA_Asset_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamIsActive", tabId + "|paramIsActive");
vars.getRequestGlobalVariable("inpParamAD_Org_ID", tabId + "|paramAD_Org_ID");
vars.getRequestGlobalVariable("inpParamDocumentNo", tabId + "|paramDocumentNo");
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamA_Asset_Group_ID", tabId + "|paramA_Asset_Group_ID");
vars.getRequestGlobalVariable("inpParamAssettype", tabId + "|paramAssettype");
vars.getRequestGlobalVariable("inpParamAmortizationcalctype", tabId + "|paramAmortizationcalctype");
vars.getRequestGlobalVariable("inpParamIscostcenter", tabId + "|paramIscostcenter");

      
      
      vars.removeSessionValue(windowId + "|A_Asset_ID");
      String strA_Asset_ID="";

      String strView = vars.getSessionValue(tabId + "|Assets800078.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strA_Asset_ID = firstElement(vars, tableSQL);
        if (strA_Asset_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Assets800078.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strA_Asset_ID, tableSQL);

      else printPageDataSheet(response, vars, strA_Asset_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strA_Asset_ID = vars.getGlobalVariable("inpaAssetId", windowId + "|A_Asset_ID", "");
      vars.setSessionValue(tabId + "|Assets800078.view", "RELATION");
      printPageDataSheet(response, vars, strA_Asset_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strA_Asset_ID = vars.getGlobalVariable("inpaAssetId", windowId + "|A_Asset_ID", "");
      vars.setSessionValue(tabId + "|Assets800078.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strA_Asset_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strA_Asset_ID = vars.getRequiredStringParameter("inpaAssetId");
      
      String strNext = nextElement(vars, strA_Asset_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strA_Asset_ID = vars.getRequiredStringParameter("inpaAssetId");
      
      String strPrevious = previousElement(vars, strA_Asset_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|Assets800078.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|Assets800078.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Assets800078.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Assets800078.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|A_Asset_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|Assets800078.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Assets800078.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|A_Asset_ID");

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

      String strA_Asset_ID = vars.getRequiredGlobalVariable("inpaAssetId", windowId + "|A_Asset_ID");
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
          String strNext = nextElement(vars, strA_Asset_ID, tableSQL);
          vars.setSessionValue(windowId + "|A_Asset_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strA_Asset_ID = vars.getRequiredInStringParameter("inpaAssetId");
      String message = deleteRelation(vars, strA_Asset_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|aAssetId");
        vars.setSessionValue(tabId + "|Assets800078.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strA_Asset_ID = vars.getRequiredStringParameter("inpaAssetId");
      //Assets800078Data data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = Assets800078Data.delete(this, strA_Asset_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|aAssetId");
        vars.setSessionValue(tabId + "|Assets800078.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONProcessed800125")) {
        vars.setSessionValue("button800125.strprocessed", vars.getStringParameter("inpprocessed"));
        vars.setSessionValue("button800125.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button800125.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button800125.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button800125.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "800125", request.getServletPath());    
     } else if (vars.commandIn("BUTTON800125")) {
        String strA_Asset_ID = vars.getGlobalVariable("inpaAssetId", windowId + "|A_Asset_ID", "");
        String strprocessed = vars.getSessionValue("button800125.strprocessed");
        String strProcessing = vars.getSessionValue("button800125.strProcessing");
        String strOrg = vars.getSessionValue("button800125.strOrg");
        String strClient = vars.getSessionValue("button800125.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessed800125(response, vars, strA_Asset_ID, strprocessed, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcessed800125")) {
        String strA_Asset_ID = vars.getGlobalVariable("inpKey", windowId + "|A_Asset_ID", "");
        @SuppressWarnings("unused")
        String strprocessed = vars.getStringParameter("inpprocessed");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "800125", (("A_Asset_ID".equalsIgnoreCase("AD_Language"))?"0":strA_Asset_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
          ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
          new ProcessRunner(bundle).execute(this);
          
          PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
          myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
        } catch (ServletException ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myMessage);
        }
        //close popup
        if (myMessage!=null) {
          if (log4j.isDebugEnabled()) log4j.debug(myMessage.getMessage());
          vars.setMessage(tabId, myMessage);
        }
        printPageClosePopUp(response, vars);






    } else if (vars.getCommand().toUpperCase().startsWith("BUTTON") || vars.getCommand().toUpperCase().startsWith("SAVE_BUTTON")) {
      pageErrorPopUp(response);
    } else pageError(response);
  }
/*
  String deleteRelation(VariablesSecureApp vars, String strA_Asset_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strA_Asset_ID.startsWith("(")) strA_Asset_ID = strA_Asset_ID.substring(1, strA_Asset_ID.length()-1);
      if (!strA_Asset_ID.equals("")) {
        strA_Asset_ID = Replace.replace(strA_Asset_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strA_Asset_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (Assets800078Data.deleteTransactional(conn, this, strKey)==0) {
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
  private Assets800078Data getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    Assets800078Data data = new Assets800078Data();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.documentno = vars.getStringParameter("inpdocumentno");     data.value = vars.getStringParameter("inpvalue");     data.name = vars.getStringParameter("inpname");     data.description = vars.getStringParameter("inpdescription");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.iscostcenter = vars.getStringParameter("inpiscostcenter", "N");     data.assettype = vars.getStringParameter("inpassettype");     data.assettyper = vars.getStringParameter("inpassettype_R");     data.aAssetGroupId = vars.getStringParameter("inpaAssetGroupId");     data.aAssetGroupIdr = vars.getStringParameter("inpaAssetGroupId_R");     data.isdepreciated = vars.getStringParameter("inpisdepreciated", "N");     data.isfullydepreciated = vars.getStringParameter("inpisfullydepreciated", "N");     data.amortizationtype = vars.getStringParameter("inpamortizationtype");     data.amortizationtyper = vars.getStringParameter("inpamortizationtype_R");     data.amortizationcalctype = vars.getRequestGlobalVariable("inpamortizationcalctype", windowId + "|Amortizationcalctype");     data.amortizationcalctyper = vars.getStringParameter("inpamortizationcalctype_R");     data.assetschedule = vars.getStringParameter("inpassetschedule");     data.assetscheduler = vars.getStringParameter("inpassetschedule_R");    try {   data.uselifeyears = vars.getNumericParameter("inpuselifeyears");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.uselifemonths = vars.getNumericParameter("inpuselifemonths");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.annualamortizationpercentage = vars.getNumericParameter("inpannualamortizationpercentage");  } catch (ServletException paramEx) { ex = paramEx; }     data.cCurrencyId = vars.getStringParameter("inpcCurrencyId");     data.cCurrencyIdr = vars.getStringParameter("inpcCurrencyId_R");     data.datepurchased = vars.getStringParameter("inpdatepurchased");     data.datecancelled = vars.getStringParameter("inpdatecancelled");     data.amortizationstartdate = vars.getStringParameter("inpamortizationstartdate");     data.amortizationenddate = vars.getStringParameter("inpamortizationenddate");    try {   data.assetvalueamt = vars.getNumericParameter("inpassetvalueamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.residualassetvalueamt = vars.getNumericParameter("inpresidualassetvalueamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.amortizationvalueamt = vars.getNumericParameter("inpamortizationvalueamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.depreciatedpreviousamt = vars.getNumericParameter("inpdepreciatedpreviousamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.depreciatedvalue = vars.getNumericParameter("inpdepreciatedvalue");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.depreciatedplan = vars.getNumericParameter("inpdepreciatedplan");  } catch (ServletException paramEx) { ex = paramEx; }     data.processed = vars.getStringParameter("inpprocessed");     data.locationcomment = vars.getStringParameter("inplocationcomment");     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cBpartnerLocationId = vars.getStringParameter("inpcBpartnerLocationId");    try {   data.profit = vars.getNumericParameter("inpprofit");  } catch (ServletException paramEx) { ex = paramEx; }     data.isinposession = vars.getStringParameter("inpisinposession", "N");     data.aAssetId = vars.getRequestGlobalVariable("inpaAssetId", windowId + "|A_Asset_ID");     data.cLocationId = vars.getStringParameter("inpcLocationId");     data.isdisposed = vars.getStringParameter("inpisdisposed", "N");     data.assetservicedate = vars.getStringParameter("inpassetservicedate");     data.adUserId = vars.getStringParameter("inpadUserId");     data.assetdepreciationdate = vars.getStringParameter("inpassetdepreciationdate");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");    try {   data.lifeuseunits = vars.getNumericParameter("inplifeuseunits");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.useunits = vars.getNumericParameter("inpuseunits");  } catch (ServletException paramEx) { ex = paramEx; }     data.assetdisposaldate = vars.getStringParameter("inpassetdisposaldate");     data.guaranteedate = vars.getStringParameter("inpguaranteedate");     data.isowned = vars.getStringParameter("inpisowned", "N");     data.help = vars.getStringParameter("inphelp");     data.versionno = vars.getStringParameter("inpversionno");     data.serno = vars.getStringParameter("inpserno");    try {   data.acctvalueamt = vars.getNumericParameter("inpacctvalueamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.lot = vars.getStringParameter("inplot"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");



    
         if (data.documentno.startsWith("<")) data.documentno = Utility.getDocumentNo(con, this, vars, windowId, "A_Asset", "", "", false, true);

    
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

   private Assets800078Data[] getRelationData(Assets800078Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].documentno = FormatUtilities.truncate(data[i].documentno, 10);        data[i].value = FormatUtilities.truncate(data[i].value, 20);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].assettype = FormatUtilities.truncate(data[i].assettype, 0);        data[i].aAssetGroupId = FormatUtilities.truncate(data[i].aAssetGroupId, 44);        data[i].amortizationtype = FormatUtilities.truncate(data[i].amortizationtype, 50);        data[i].amortizationcalctype = FormatUtilities.truncate(data[i].amortizationcalctype, 50);        data[i].assetschedule = FormatUtilities.truncate(data[i].assetschedule, 21);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 44);        data[i].locationcomment = FormatUtilities.truncate(data[i].locationcomment, 50);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 32);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 44);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, 10);        data[i].cLocationId = FormatUtilities.truncate(data[i].cLocationId, 50);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 44);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 44);        data[i].help = FormatUtilities.truncate(data[i].help, 50);        data[i].versionno = FormatUtilities.truncate(data[i].versionno, 20);        data[i].serno = FormatUtilities.truncate(data[i].serno, 20);        data[i].lot = FormatUtilities.truncate(data[i].lot, 20);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|Amortizationcalctype", data[0].getField("amortizationcalctype"));    vars.setSessionValue(windowId + "|A_Asset_ID", data[0].getField("aAssetId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      Assets800078Data[] data = Assets800078Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpaAssetId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strA_Asset_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamIsActive = vars.getSessionValue(tabId + "|paramIsActive");
String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamDocumentNo = vars.getSessionValue(tabId + "|paramDocumentNo");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamA_Asset_Group_ID = vars.getSessionValue(tabId + "|paramA_Asset_Group_ID");
String strParamAssettype = vars.getSessionValue(tabId + "|paramAssettype");
String strParamAmortizationcalctype = vars.getSessionValue(tabId + "|paramAmortizationcalctype");
String strParamIscostcenter = vars.getSessionValue(tabId + "|paramIscostcenter");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamIsActive.equals("") && strParamAD_Org_ID.equals("") && strParamDocumentNo.equals("") && strParamName.equals("") && strParamA_Asset_Group_ID.equals("") && strParamAssettype.equals("") && strParamAmortizationcalctype.equals("") && strParamIscostcenter.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strA_Asset_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strA_Asset_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/finance/Assets/Assets800078_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Assets800078", false, "document.frmMain.inpaAssetId", "grid", "..", "".equals("Y"), "Assets", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "aAssetId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Assets800078_Relation.html", "Assets", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Assets800078_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strA_Asset_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " A_Asset.Name";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    Assets800078Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamIsActive = vars.getSessionValue(tabId + "|paramIsActive");
String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamDocumentNo = vars.getSessionValue(tabId + "|paramDocumentNo");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamA_Asset_Group_ID = vars.getSessionValue(tabId + "|paramA_Asset_Group_ID");
String strParamAssettype = vars.getSessionValue(tabId + "|paramAssettype");
String strParamAmortizationcalctype = vars.getSessionValue(tabId + "|paramAmortizationcalctype");
String strParamIscostcenter = vars.getSessionValue(tabId + "|paramIscostcenter");

    boolean hasSearchCondition=false;
    if (!(strParamIsActive.equals("") && strParamAD_Org_ID.equals("") && strParamDocumentNo.equals("") && strParamName.equals("") && strParamA_Asset_Group_ID.equals("") && strParamAssettype.equals("") && strParamAmortizationcalctype.equals("") && strParamIscostcenter.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = Assets800078Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strA_Asset_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strA_Asset_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new Assets800078Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("aAssetId") == null || dataField.getField("aAssetId").equals("")) {
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
        data = Assets800078Data.set(Utility.getDefault(this, vars, "Name", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "VersionNo", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "Datepurchased", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "Iscostcenter", "Y", "800027", "800078", "N", dataField), Utility.getDefault(this, vars, "A_Asset_Group_ID", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "AssetValueAmt", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "IsOwned", "Y", "800027", "800078", "N", dataField), Utility.getDefault(this, vars, "Help", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "LocationComment", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "Annualamortizationpercentage", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "Processed", "N", "800027", "800078", "N", dataField), (vars.getLanguage().equals("en_US")?ListData.selectName(this, "800042", Utility.getDefault(this, vars, "Processed", "N", "800027", "800078", "N", dataField)):ListData.selectNameTrl(this, vars.getLanguage(), "800042", Utility.getDefault(this, vars, "Processed", "N", "800027", "800078", "N", dataField))), Utility.getDefault(this, vars, "C_BPartner_ID", "", "800027", "800078", "", dataField), "", Utility.getDefault(this, vars, "IsDisposed", "N", "800027", "800078", "N", dataField), Utility.getDefault(this, vars, "Residualassetvalueamt", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "DocumentNo", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "UseLifeMonths", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "800027", "800078", "", dataField), Assets800078Data.selectDef8045_0(this, Utility.getDefault(this, vars, "CreatedBy", "", "800027", "800078", "", dataField)), Utility.getDefault(this, vars, "Depreciatedplan", "0", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "Datecancelled", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "Amortizationcalctype", "PE", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "Value", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "IsDepreciated", "N", "800027", "800078", "N", dataField), Utility.getDefault(this, vars, "IsInPosession", "Y", "800027", "800078", "N", dataField), Utility.getDefault(this, vars, "Amortizationstartdate", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "Depreciatedpreviousamt", "0", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "UseUnits", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "Acctvalueamt", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "Amortizationenddate", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "Lot", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "Amortizationvalueamt", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "UseLifeYears", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "AD_User_ID", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "C_Project_ID", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "Amortizationtype", "LI", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "SerNo", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "Description", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "IsFullyDepreciated", "N", "800027", "800078", "N", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "800027", "800078", "", dataField), Assets800078Data.selectDef8063_1(this, Utility.getDefault(this, vars, "UpdatedBy", "", "800027", "800078", "", dataField)), Utility.getDefault(this, vars, "C_BPartner_Location_ID", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "AssetDepreciationDate", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "GuaranteeDate", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "AssetServiceDate", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "C_Currency_ID", "@C_Currency_ID@", "800027", "800078", "", dataField), "Y", Utility.getDefault(this, vars, "Depreciatedvalue", "0", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "C_Location_ID", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "Assetschedule", "YE", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "Assettype", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "Profit", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "LifeUseUnits", "", "800027", "800078", "", dataField), Utility.getDefault(this, vars, "AssetDisposalDate", "", "800027", "800078", "", dataField));
             data[0].documentno = "<" + Utility.getDocumentNo( this, vars, windowId, "A_Asset", "", "", false, false) + ">";
      }
    } else {
      data = new Assets800078Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(Assets800078Data) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Assets800078", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpaAssetId", "", "..", "".equals("Y"), "Assets", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strA_Asset_ID));
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
  
    void printPageButtonProcessed800125(HttpServletResponse response, VariablesSecureApp vars, String strA_Asset_ID, String strprocessed, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "800125",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "800125" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"800125" );
        String isDocAction=UtilsData.isProcessDocAction(this, "800125");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "539",strA_Asset_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "539", strA_Asset_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strprocessed, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "800125");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONProcessed" + "800125" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","Assets800078_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "800125");
        script.addHiddenfield("inpKey",strA_Asset_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("800125");
        vars.removeMessage("800125");
        if (myMessage!=null) {
          script.addMessage(this, vars, myMessage);
        }
        strOutput = script.doScript(strOutput, "",this,vars);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(strOutput);
        out.close();
      } catch (Exception ex) {
        throw new ServletException(ex);
      }
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
    Assets800078Data data = null;
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
                data.aAssetId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (Assets800078Data.getCurrentDBTimestamp(this, data.aAssetId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.aAssetId, vars, this);
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
                    data.aAssetId = "";
                }
                else {                    
                    
                        //BUTTON TEXT FILLING
                    data.processedBtn = ActionButtonDefaultData.getText(this, vars.getLanguage(), "800042", data.getField("Processed"));
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|A_Asset_ID", data.aAssetId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Assets800078. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
