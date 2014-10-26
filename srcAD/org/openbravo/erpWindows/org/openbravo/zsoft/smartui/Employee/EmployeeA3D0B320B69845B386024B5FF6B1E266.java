
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.Employee;





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

public class EmployeeA3D0B320B69845B386024B5FF6B1E266 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(EmployeeA3D0B320B69845B386024B5FF6B1E266.class);
  
  private static final String windowId = "39D3CD9F77A942D690965D49106F011B";
  private static final String tabId = "A3D0B320B69845B386024B5FF6B1E266";
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
      

      String strView = vars.getSessionValue(tabId + "|EmployeeA3D0B320B69845B386024B5FF6B1E266.view");
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
        vars.setSessionValue(tabId + "|EmployeeA3D0B320B69845B386024B5FF6B1E266.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_BPartner_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|EmployeeA3D0B320B69845B386024B5FF6B1E266.view", "RELATION");
        printPageDataSheet(response, vars, strC_BPartner_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|EmployeeA3D0B320B69845B386024B5FF6B1E266.view");
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
vars.getRequestGlobalVariable("inpParamIsactive", tabId + "|paramIsactive");
vars.getRequestGlobalVariable("inpParamValue", tabId + "|paramValue");
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamDescription", tabId + "|paramDescription");
vars.getRequestGlobalVariable("inpParamC_Bp_Group_ID", tabId + "|paramC_Bp_Group_ID");
vars.getRequestGlobalVariable("inpParamIssalesrep", tabId + "|paramIssalesrep");
vars.getRequestGlobalVariable("inpParamReferenceno", tabId + "|paramReferenceno");
vars.getRequestGlobalVariable("inpParamTaxid", tabId + "|paramTaxid");
vars.getRequestGlobalVariable("inpParamIstaxexempt", tabId + "|paramIstaxexempt");
vars.getRequestGlobalVariable("inpParamIsworker", tabId + "|paramIsworker");
vars.getRequestGlobalVariable("inpParamCountry", tabId + "|paramCountry");
vars.getRequestGlobalVariable("inpParamCity", tabId + "|paramCity");
vars.getRequestGlobalVariable("inpParamZipcode", tabId + "|paramZipcode");
vars.getRequestGlobalVariable("inpParamIsprojectmanager", tabId + "|paramIsprojectmanager");
vars.getRequestGlobalVariable("inpParamIsprocurementmanager", tabId + "|paramIsprocurementmanager");
vars.getRequestGlobalVariable("inpParamApprovalamt", tabId + "|paramApprovalamt");
vars.getRequestGlobalVariable("inpParamIsapprover", tabId + "|paramIsapprover");
vars.getRequestGlobalVariable("inpParamIsprapprover", tabId + "|paramIsprapprover");
vars.getRequestGlobalVariable("inpParamIspaymentapprover", tabId + "|paramIspaymentapprover");
vars.getRequestGlobalVariable("inpParamA_Asset_ID", tabId + "|paramA_Asset_ID");
vars.getRequestGlobalVariable("inpParamApprovalamt_f", tabId + "|paramApprovalamt_f");

      
      
      vars.removeSessionValue(windowId + "|C_BPartner_ID");
      String strC_BPartner_ID="";

      String strView = vars.getSessionValue(tabId + "|EmployeeA3D0B320B69845B386024B5FF6B1E266.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_BPartner_ID = firstElement(vars, tableSQL);
        if (strC_BPartner_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|EmployeeA3D0B320B69845B386024B5FF6B1E266.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_BPartner_ID, tableSQL);

      else printPageDataSheet(response, vars, strC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", "");
      vars.setSessionValue(tabId + "|EmployeeA3D0B320B69845B386024B5FF6B1E266.view", "RELATION");
      printPageDataSheet(response, vars, strC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", "");
      vars.setSessionValue(tabId + "|EmployeeA3D0B320B69845B386024B5FF6B1E266.view", "EDIT");

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

      vars.setSessionValue(tabId + "|EmployeeA3D0B320B69845B386024B5FF6B1E266.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|EmployeeA3D0B320B69845B386024B5FF6B1E266.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|EmployeeA3D0B320B69845B386024B5FF6B1E266.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|EmployeeA3D0B320B69845B386024B5FF6B1E266.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_BPartner_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|EmployeeA3D0B320B69845B386024B5FF6B1E266.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|EmployeeA3D0B320B69845B386024B5FF6B1E266.initRecordNumber", strInitRecord);
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
        vars.setSessionValue(tabId + "|EmployeeA3D0B320B69845B386024B5FF6B1E266.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strC_BPartner_ID = vars.getRequiredStringParameter("inpcBpartnerId");
      //EmployeeA3D0B320B69845B386024B5FF6B1E266Data data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = EmployeeA3D0B320B69845B386024B5FF6B1E266Data.delete(this, strC_BPartner_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.setSessionValue(tabId + "|EmployeeA3D0B320B69845B386024B5FF6B1E266.view", "RELATION");
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
          if (EmployeeA3D0B320B69845B386024B5FF6B1E266Data.deleteTransactional(conn, this, strKey)==0) {
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
  private EmployeeA3D0B320B69845B386024B5FF6B1E266Data getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    EmployeeA3D0B320B69845B386024B5FF6B1E266Data data = new EmployeeA3D0B320B69845B386024B5FF6B1E266Data();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.value = vars.getStringParameter("inpvalue");     data.name = vars.getStringParameter("inpname");     data.description = vars.getStringParameter("inpdescription");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.isinresourceplan = vars.getStringParameter("inpisinresourceplan", "N");     data.issalesrep = vars.getStringParameter("inpissalesrep", "N");     data.isprojectmanager = vars.getStringParameter("inpisprojectmanager", "N");     data.isprocurementmanager = vars.getStringParameter("inpisprocurementmanager", "N");     data.isworker = vars.getStringParameter("inpisworker", "N");     data.isapprover = vars.getStringParameter("inpisapprover", "N");    try {   data.approvalamt = vars.getNumericParameter("inpapprovalamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.isprapprover = vars.getStringParameter("inpisprapprover", "N");     data.ispaymentapprover = vars.getStringParameter("inpispaymentapprover", "N");     data.cSalaryCategoryId = vars.getStringParameter("inpcSalaryCategoryId");     data.cSalaryCategoryIdr = vars.getStringParameter("inpcSalaryCategoryId_R");     data.taxid = vars.getStringParameter("inptaxid");     data.referenceno = vars.getStringParameter("inpreferenceno");     data.cBpGroupId = vars.getStringParameter("inpcBpGroupId");     data.cBpGroupIdr = vars.getStringParameter("inpcBpGroupId_R");     data.adLanguage = vars.getStringParameter("inpadLanguage");     data.adLanguager = vars.getStringParameter("inpadLanguage_R");     data.country = vars.getStringParameter("inpcountry");     data.zipcode = vars.getStringParameter("inpzipcode");     data.city = vars.getStringParameter("inpcity");     data.aAssetId = vars.getStringParameter("inpaAssetId");     data.aAssetIdr = vars.getStringParameter("inpaAssetId_R");     data.cBpartnerId = vars.getRequestGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");     data.isemployee = vars.getStringParameter("inpisemployee", "N");     data.istaxexempt = vars.getStringParameter("inpistaxexempt", "N");     data.cGreetingId = vars.getStringParameter("inpcGreetingId");     data.rating = vars.getStringParameter("inprating", "N"); 
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

   private EmployeeA3D0B320B69845B386024B5FF6B1E266Data[] getRelationData(EmployeeA3D0B320B69845B386024B5FF6B1E266Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].value = FormatUtilities.truncate(data[i].value, 24);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].cSalaryCategoryId = FormatUtilities.truncate(data[i].cSalaryCategoryId, 0);        data[i].taxid = FormatUtilities.truncate(data[i].taxid, 12);        data[i].referenceno = FormatUtilities.truncate(data[i].referenceno, 40);        data[i].cBpGroupId = FormatUtilities.truncate(data[i].cBpGroupId, 44);        data[i].adLanguage = FormatUtilities.truncate(data[i].adLanguage, 44);        data[i].country = FormatUtilities.truncate(data[i].country, 0);        data[i].zipcode = FormatUtilities.truncate(data[i].zipcode, 0);        data[i].city = FormatUtilities.truncate(data[i].city, 0);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, 12);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 32);        data[i].cGreetingId = FormatUtilities.truncate(data[i].cGreetingId, 32);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].getField("cBpartnerId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      EmployeeA3D0B320B69845B386024B5FF6B1E266Data[] data = EmployeeA3D0B320B69845B386024B5FF6B1E266Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpcBpartnerId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

    String strParamIsactive = vars.getSessionValue(tabId + "|paramIsactive");
String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamC_Bp_Group_ID = vars.getSessionValue(tabId + "|paramC_Bp_Group_ID");
String strParamIssalesrep = vars.getSessionValue(tabId + "|paramIssalesrep");
String strParamReferenceno = vars.getSessionValue(tabId + "|paramReferenceno");
String strParamTaxid = vars.getSessionValue(tabId + "|paramTaxid");
String strParamIstaxexempt = vars.getSessionValue(tabId + "|paramIstaxexempt");
String strParamIsworker = vars.getSessionValue(tabId + "|paramIsworker");
String strParamCountry = vars.getSessionValue(tabId + "|paramCountry");
String strParamCity = vars.getSessionValue(tabId + "|paramCity");
String strParamZipcode = vars.getSessionValue(tabId + "|paramZipcode");
String strParamIsprojectmanager = vars.getSessionValue(tabId + "|paramIsprojectmanager");
String strParamIsprocurementmanager = vars.getSessionValue(tabId + "|paramIsprocurementmanager");
String strParamApprovalamt = vars.getSessionValue(tabId + "|paramApprovalamt");
String strParamIsapprover = vars.getSessionValue(tabId + "|paramIsapprover");
String strParamIsprapprover = vars.getSessionValue(tabId + "|paramIsprapprover");
String strParamIspaymentapprover = vars.getSessionValue(tabId + "|paramIspaymentapprover");
String strParamA_Asset_ID = vars.getSessionValue(tabId + "|paramA_Asset_ID");
String strParamApprovalamt_f = vars.getSessionValue(tabId + "|paramApprovalamt_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamIsactive.equals("") && strParamValue.equals("") && strParamName.equals("") && strParamDescription.equals("") && strParamC_Bp_Group_ID.equals("") && strParamIssalesrep.equals("") && strParamReferenceno.equals("") && strParamTaxid.equals("") && strParamIstaxexempt.equals("") && strParamIsworker.equals("") && strParamCountry.equals("") && strParamCity.equals("") && strParamZipcode.equals("") && strParamIsprojectmanager.equals("") && strParamIsprocurementmanager.equals("") && strParamApprovalamt.equals("") && strParamIsapprover.equals("") && strParamIsprapprover.equals("") && strParamIspaymentapprover.equals("") && strParamA_Asset_ID.equals("") && strParamApprovalamt_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_BPartner_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_BPartner_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/smartui/Employee/EmployeeA3D0B320B69845B386024B5FF6B1E266_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "EmployeeA3D0B320B69845B386024B5FF6B1E266", false, "document.frmMain.inpcBpartnerId", "grid", "../empoyees/print.html", "N".equals("Y"), "Employee", strReplaceWith, false);
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
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "EmployeeA3D0B320B69845B386024B5FF6B1E266_Relation.html", "Employee", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "EmployeeA3D0B320B69845B386024B5FF6B1E266_Relation.html", strReplaceWith);
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
    String orderClause = " c_bpartneremployee_view.Value";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    EmployeeA3D0B320B69845B386024B5FF6B1E266Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamIsactive = vars.getSessionValue(tabId + "|paramIsactive");
String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamC_Bp_Group_ID = vars.getSessionValue(tabId + "|paramC_Bp_Group_ID");
String strParamIssalesrep = vars.getSessionValue(tabId + "|paramIssalesrep");
String strParamReferenceno = vars.getSessionValue(tabId + "|paramReferenceno");
String strParamTaxid = vars.getSessionValue(tabId + "|paramTaxid");
String strParamIstaxexempt = vars.getSessionValue(tabId + "|paramIstaxexempt");
String strParamIsworker = vars.getSessionValue(tabId + "|paramIsworker");
String strParamCountry = vars.getSessionValue(tabId + "|paramCountry");
String strParamCity = vars.getSessionValue(tabId + "|paramCity");
String strParamZipcode = vars.getSessionValue(tabId + "|paramZipcode");
String strParamIsprojectmanager = vars.getSessionValue(tabId + "|paramIsprojectmanager");
String strParamIsprocurementmanager = vars.getSessionValue(tabId + "|paramIsprocurementmanager");
String strParamApprovalamt = vars.getSessionValue(tabId + "|paramApprovalamt");
String strParamIsapprover = vars.getSessionValue(tabId + "|paramIsapprover");
String strParamIsprapprover = vars.getSessionValue(tabId + "|paramIsprapprover");
String strParamIspaymentapprover = vars.getSessionValue(tabId + "|paramIspaymentapprover");
String strParamA_Asset_ID = vars.getSessionValue(tabId + "|paramA_Asset_ID");
String strParamApprovalamt_f = vars.getSessionValue(tabId + "|paramApprovalamt_f");

    boolean hasSearchCondition=false;
    if (!(strParamIsactive.equals("") && strParamValue.equals("") && strParamName.equals("") && strParamDescription.equals("") && strParamC_Bp_Group_ID.equals("") && strParamIssalesrep.equals("") && strParamReferenceno.equals("") && strParamTaxid.equals("") && strParamIstaxexempt.equals("") && strParamIsworker.equals("") && strParamCountry.equals("") && strParamCity.equals("") && strParamZipcode.equals("") && strParamIsprojectmanager.equals("") && strParamIsprocurementmanager.equals("") && strParamApprovalamt.equals("") && strParamIsapprover.equals("") && strParamIsprapprover.equals("") && strParamIspaymentapprover.equals("") && strParamA_Asset_ID.equals("") && strParamApprovalamt_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = EmployeeA3D0B320B69845B386024B5FF6B1E266Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strC_BPartner_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
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
        data = new EmployeeA3D0B320B69845B386024B5FF6B1E266Data[0];
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
        data = EmployeeA3D0B320B69845B386024B5FF6B1E266Data.set(Utility.getDefault(this, vars, "C_Bp_Group_ID", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField), Utility.getDefault(this, vars, "Istaxexempt", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "N", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField), Utility.getDefault(this, vars, "Description", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField), Utility.getDefault(this, vars, "Referenceno", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField), Utility.getDefault(this, vars, "Issalesrep", "N", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "N", dataField), Utility.getDefault(this, vars, "Name", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField), Utility.getDefault(this, vars, "A_Asset_ID", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField), Utility.getDefault(this, vars, "Value", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField), Utility.getDefault(this, vars, "Country", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField), Utility.getDefault(this, vars, "Isemployee", "Y", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "N", dataField), "", Utility.getDefault(this, vars, "Rating", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "N", dataField), Utility.getDefault(this, vars, "AD_Language", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField), Utility.getDefault(this, vars, "Zipcode", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField), Utility.getDefault(this, vars, "C_Salary_Category_ID", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField), Utility.getDefault(this, vars, "Isprojectmanager", "N", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "N", dataField), Utility.getDefault(this, vars, "Isprapprover", "N", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "N", dataField), Utility.getDefault(this, vars, "Isprocurementmanager", "N", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "N", dataField), Utility.getDefault(this, vars, "Ispaymentapprover", "N", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "N", dataField), Utility.getDefault(this, vars, "City", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField), Utility.getDefault(this, vars, "Isworker", "N", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "N", dataField), Utility.getDefault(this, vars, "C_Greeting_ID", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField), "Y", Utility.getDefault(this, vars, "Isapprover", "N", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "N", dataField), Utility.getDefault(this, vars, "Approvalamt", "0", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField), EmployeeA3D0B320B69845B386024B5FF6B1E266Data.selectDef45A1EF4409BA4B759D2AEB557217145C_0(this, Utility.getDefault(this, vars, "Createdby", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField)), Utility.getDefault(this, vars, "Updatedby", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField), EmployeeA3D0B320B69845B386024B5FF6B1E266Data.selectDef45BBDF9A74B04ED996519AD982A8CAF8_1(this, Utility.getDefault(this, vars, "Updatedby", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField)), Utility.getDefault(this, vars, "Taxid", "", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField), Utility.getDefault(this, vars, "isinresourceplan", "Y", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "N", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "39D3CD9F77A942D690965D49106F011B", "A3D0B320B69845B386024B5FF6B1E266", "", dataField));
        
      }
    } else {
      data = new EmployeeA3D0B320B69845B386024B5FF6B1E266Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(EmployeeA3D0B320B69845B386024B5FF6B1E266Data) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "EmployeeA3D0B320B69845B386024B5FF6B1E266", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcBpartnerId", "", "../empoyees/print.html", "N".equals("Y"), "Employee", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_BPartner_ID));
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
    EmployeeA3D0B320B69845B386024B5FF6B1E266Data data = null;
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
		       if (EmployeeA3D0B320B69845B386024B5FF6B1E266Data.getCurrentDBTimestamp(this, data.cBpartnerId).equals(
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
    return "Servlet EmployeeA3D0B320B69845B386024B5FF6B1E266. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
