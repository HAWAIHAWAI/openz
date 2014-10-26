
package org.openbravo.erpWindows.org.openbravo.zsoft.project.RechargeInvoiceProject;





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

public class RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B.class);
  
  private static final String windowId = "7D7E984A1BDE424189F1D3658DDCBF2C";
  private static final String tabId = "EEB272C8E74845059CFC558280D2218B";
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
        String strzspmRechargeViewId = request.getParameter("inpzspmRechargeViewId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strzspmRechargeViewId.equals(""))
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

      String strZspm_Recharge_View_ID = vars.getGlobalVariable("inpzspmRechargeViewId", windowId + "|Zspm_Recharge_View_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strZspm_Recharge_View_ID.equals("")) strZspm_Recharge_View_ID = firstElement(vars, tableSQL);
          if (strZspm_Recharge_View_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZspm_Recharge_View_ID, tableSQL);

      else printPageDataSheet(response, vars, strZspm_Recharge_View_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strZspm_Recharge_View_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strZspm_Recharge_View_ID.equals("")) strZspm_Recharge_View_ID = vars.getRequiredGlobalVariable("inpzspmRechargeViewId", windowId + "|Zspm_Recharge_View_ID");
      else vars.setSessionValue(windowId + "|Zspm_Recharge_View_ID", strZspm_Recharge_View_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B.view", "EDIT");

        printPageEdit(response, request, vars, false, strZspm_Recharge_View_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B.view", "RELATION");
        printPageDataSheet(response, vars, strZspm_Recharge_View_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B.view");
      String strZspm_Recharge_View_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strZspm_Recharge_View_ID = firstElement(vars, tableSQL);
          if (strZspm_Recharge_View_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strZspm_Recharge_View_ID.equals("")) strZspm_Recharge_View_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strZspm_Recharge_View_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamC_Project_ID", tabId + "|paramC_Project_ID");
vars.getRequestGlobalVariable("inpParamIspaid", tabId + "|paramIspaid");
vars.getRequestGlobalVariable("inpParamIsrecharged", tabId + "|paramIsrecharged");
vars.getRequestGlobalVariable("inpParamNorecharge", tabId + "|paramNorecharge");

      
      
      vars.removeSessionValue(windowId + "|Zspm_Recharge_View_ID");
      String strZspm_Recharge_View_ID="";

      String strView = vars.getSessionValue(tabId + "|RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strZspm_Recharge_View_ID = firstElement(vars, tableSQL);
        if (strZspm_Recharge_View_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZspm_Recharge_View_ID, tableSQL);

      else printPageDataSheet(response, vars, strZspm_Recharge_View_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strZspm_Recharge_View_ID = vars.getGlobalVariable("inpzspmRechargeViewId", windowId + "|Zspm_Recharge_View_ID", "");
      vars.setSessionValue(tabId + "|RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B.view", "RELATION");
      printPageDataSheet(response, vars, strZspm_Recharge_View_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strZspm_Recharge_View_ID = vars.getGlobalVariable("inpzspmRechargeViewId", windowId + "|Zspm_Recharge_View_ID", "");
      vars.setSessionValue(tabId + "|RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strZspm_Recharge_View_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strZspm_Recharge_View_ID = vars.getRequiredStringParameter("inpzspmRechargeViewId");
      
      String strNext = nextElement(vars, strZspm_Recharge_View_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strZspm_Recharge_View_ID = vars.getRequiredStringParameter("inpzspmRechargeViewId");
      
      String strPrevious = previousElement(vars, strZspm_Recharge_View_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Zspm_Recharge_View_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Zspm_Recharge_View_ID");

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

      String strZspm_Recharge_View_ID = vars.getRequiredGlobalVariable("inpzspmRechargeViewId", windowId + "|Zspm_Recharge_View_ID");
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
          String strNext = nextElement(vars, strZspm_Recharge_View_ID, tableSQL);
          vars.setSessionValue(windowId + "|Zspm_Recharge_View_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strZspm_Recharge_View_ID = vars.getRequiredInStringParameter("inpzspmRechargeViewId");
      String message = deleteRelation(vars, strZspm_Recharge_View_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|zspmRechargeViewId");
        vars.setSessionValue(tabId + "|RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strZspm_Recharge_View_ID = vars.getRequiredStringParameter("inpzspmRechargeViewId");
      //RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.delete(this, strZspm_Recharge_View_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|zspmRechargeViewId");
        vars.setSessionValue(tabId + "|RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strZspm_Recharge_View_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strZspm_Recharge_View_ID.startsWith("(")) strZspm_Recharge_View_ID = strZspm_Recharge_View_ID.substring(1, strZspm_Recharge_View_ID.length()-1);
      if (!strZspm_Recharge_View_ID.equals("")) {
        strZspm_Recharge_View_ID = Replace.replace(strZspm_Recharge_View_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strZspm_Recharge_View_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.deleteTransactional(conn, this, strKey)==0) {
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
  private RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData data = new RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData();
    ServletException ex = null;
    try {
    data.zspmRechargeViewId = vars.getRequestGlobalVariable("inpzspmRechargeViewId", windowId + "|Zspm_Recharge_View_ID");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");    try {   data.qtyinvoiced = vars.getNumericParameter("inpqtyinvoiced");  } catch (ServletException paramEx) { ex = paramEx; }     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.cOrderId = vars.getStringParameter("inpcOrderId");     data.cOrderIdr = vars.getStringParameter("inpcOrderId_R");     data.cOrderlineId = vars.getStringParameter("inpcOrderlineId");     data.cOrderlineIdr = vars.getStringParameter("inpcOrderlineId_R");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.dateordered = vars.getStringParameter("inpdateordered");     data.salesrepId = vars.getStringParameter("inpsalesrepId");     data.salesrepIdr = vars.getStringParameter("inpsalesrepId_R");     data.cInvoiceId = vars.getStringParameter("inpcInvoiceId");     data.cInvoiceIdr = vars.getStringParameter("inpcInvoiceId_R");     data.cInvoicelineId = vars.getStringParameter("inpcInvoicelineId");     data.cInvoicelineIdr = vars.getStringParameter("inpcInvoicelineId_R");     data.description = vars.getStringParameter("inpdescription");     data.dateinvoiced = vars.getStringParameter("inpdateinvoiced");    try {   data.linenetamt = vars.getNumericParameter("inplinenetamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.ispaid = vars.getStringParameter("inpispaid", "N");     data.transactiondate = vars.getStringParameter("inptransactiondate");    try {   data.rechargeQtyinvoiced = vars.getNumericParameter("inprechargeQtyinvoiced");  } catch (ServletException paramEx) { ex = paramEx; }     data.rechargeProductId = vars.getStringParameter("inprechargeProductId");     data.rechargeProductIdr = vars.getStringParameter("inprechargeProductId_R");     data.rechargeInvoiceId = vars.getStringParameter("inprechargeInvoiceId");     data.rechargeInvoiceIdr = vars.getStringParameter("inprechargeInvoiceId_R");    try {   data.totallines = vars.getNumericParameter("inptotallines");  } catch (ServletException paramEx) { ex = paramEx; }     data.reinvoicedbyId = vars.getStringParameter("inpreinvoicedbyId");     data.reinvoicedbyIdr = vars.getStringParameter("inpreinvoicedbyId_R");    try {   data.grandtotal = vars.getNumericParameter("inpgrandtotal");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.totalpaid = vars.getNumericParameter("inptotalpaid");  } catch (ServletException paramEx) { ex = paramEx; }     data.rechargeDateinvoiced = vars.getStringParameter("inprechargeDateinvoiced");     data.rechargeBpartnerId = vars.getStringParameter("inprechargeBpartnerId");     data.rechargeBpartnerIdr = vars.getStringParameter("inprechargeBpartnerId_R");    try {   data.rechargeLinenetamt = vars.getNumericParameter("inprechargeLinenetamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.rechargeOrderId = vars.getStringParameter("inprechargeOrderId");     data.rechargeOrderIdr = vars.getStringParameter("inprechargeOrderId_R");     data.isrecharged = vars.getStringParameter("inpisrecharged", "N");     data.norecharge = vars.getStringParameter("inpnorecharge", "N");     data.norechargecomment = vars.getStringParameter("inpnorechargecomment"); 
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

   private RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[] getRelationData(RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].zspmRechargeViewId = FormatUtilities.truncate(data[i].zspmRechargeViewId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 32);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].cOrderId = FormatUtilities.truncate(data[i].cOrderId, 32);        data[i].cOrderlineId = FormatUtilities.truncate(data[i].cOrderlineId, 32);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 32);        data[i].salesrepId = FormatUtilities.truncate(data[i].salesrepId, 32);        data[i].cInvoiceId = FormatUtilities.truncate(data[i].cInvoiceId, 32);        data[i].cInvoicelineId = FormatUtilities.truncate(data[i].cInvoicelineId, 32);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].rechargeProductId = FormatUtilities.truncate(data[i].rechargeProductId, 32);        data[i].rechargeInvoiceId = FormatUtilities.truncate(data[i].rechargeInvoiceId, 32);        data[i].reinvoicedbyId = FormatUtilities.truncate(data[i].reinvoicedbyId, 32);        data[i].rechargeBpartnerId = FormatUtilities.truncate(data[i].rechargeBpartnerId, 32);        data[i].rechargeOrderId = FormatUtilities.truncate(data[i].rechargeOrderId, 32);        data[i].norechargecomment = FormatUtilities.truncate(data[i].norechargecomment, 50);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|Zspm_Recharge_View_ID", data[0].getField("zspmRechargeViewId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[] data = RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpzspmRechargeViewId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strZspm_Recharge_View_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamIspaid = vars.getSessionValue(tabId + "|paramIspaid");
String strParamIsrecharged = vars.getSessionValue(tabId + "|paramIsrecharged");
String strParamNorecharge = vars.getSessionValue(tabId + "|paramNorecharge");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamC_Project_ID.equals("") && strParamIspaid.equals("") && strParamIsrecharged.equals("") && strParamNorecharge.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strZspm_Recharge_View_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strZspm_Recharge_View_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/project/RechargeInvoiceProject/RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B", false, "document.frmMain.inpzspmRechargeViewId", "grid", "..", "".equals("Y"), "RechargeInvoiceProject", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "zspmRechargeViewId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B_Relation.html", "RechargeInvoiceProject", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strZspm_Recharge_View_ID, TableSQLData tableSQL)
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
    RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamIspaid = vars.getSessionValue(tabId + "|paramIspaid");
String strParamIsrecharged = vars.getSessionValue(tabId + "|paramIsrecharged");
String strParamNorecharge = vars.getSessionValue(tabId + "|paramNorecharge");

    boolean hasSearchCondition=false;
    if (!(strParamC_Project_ID.equals("") && strParamIspaid.equals("") && strParamIsrecharged.equals("") && strParamNorecharge.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strZspm_Recharge_View_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strZspm_Recharge_View_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("zspmRechargeViewId") == null || dataField.getField("zspmRechargeViewId").equals("")) {
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
        data = RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.set(Utility.getDefault(this, vars, "C_Bpartner_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.selectDef1A65700C24484ADBA07374FAFBAEB7CA_0(this, Utility.getDefault(this, vars, "C_Bpartner_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField)), "Y", Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "Totalpaid", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "Recharge_Product_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.selectDefADB5E1B7F5884108B9BB8500D8347774_1(this, Utility.getDefault(this, vars, "Recharge_Product_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField)), Utility.getDefault(this, vars, "Transactiondate", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "C_Projecttask_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "Recharge_Order_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.selectDef5D3ABC0E4D9A4D269258A597831C577D_2(this, Utility.getDefault(this, vars, "Recharge_Order_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField)), Utility.getDefault(this, vars, "Recharge_Qtyinvoiced", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "Recharge_Bpartner_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.selectDef45AAA76FBB004DD3992E6DE63B26AA0E_3(this, Utility.getDefault(this, vars, "Createdby", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField)), "", Utility.getDefault(this, vars, "Linenetamt", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "C_Invoice_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "Norechargecomment", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "Norecharge", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "N", dataField), Utility.getDefault(this, vars, "Updatedby", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.selectDefAF13A123A5E041D2B97365F4B65E9752_4(this, Utility.getDefault(this, vars, "Updatedby", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField)), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "Qtyinvoiced", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "Isrecharged", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "N", dataField), Utility.getDefault(this, vars, "C_Invoiceline_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "C_Project_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.selectDef96C835755B3040DF86C734FE9042064D_5(this, Utility.getDefault(this, vars, "C_Project_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField)), Utility.getDefault(this, vars, "Totallines", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "Dateinvoiced", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "Recharge_Dateinvoiced", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "Dateordered", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "Recharge_Linenetamt", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "Grandtotal", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "Recharge_Invoice_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.selectDef3B61DE414DB24F70A8AA51E54C08AD79_6(this, Utility.getDefault(this, vars, "Recharge_Invoice_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField)), Utility.getDefault(this, vars, "Description", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "Salesrep_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "Ispaid", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "N", dataField), Utility.getDefault(this, vars, "C_Orderline_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "Reinvoicedby_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.selectDef8C6D38822E3B49C6906CF5F4EF2FD0CB_7(this, Utility.getDefault(this, vars, "Reinvoicedby_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField)), Utility.getDefault(this, vars, "C_Order_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField), RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.selectDefA7C16A1FEE104CF8A9EEA7FA77461446_8(this, Utility.getDefault(this, vars, "M_Product_ID", "", "7D7E984A1BDE424189F1D3658DDCBF2C", "EEB272C8E74845059CFC558280D2218B", "", dataField)));
        
      }
    } else {
      data = new RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpzspmRechargeViewId", "", "..", "".equals("Y"), "RechargeInvoiceProject", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strZspm_Recharge_View_ID));
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
    RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData data = null;
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
                data.zspmRechargeViewId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.getCurrentDBTimestamp(this, data.zspmRechargeViewId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.zspmRechargeViewId, vars, this);
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
                    data.zspmRechargeViewId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Zspm_Recharge_View_ID", data.zspmRechargeViewId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218B. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
