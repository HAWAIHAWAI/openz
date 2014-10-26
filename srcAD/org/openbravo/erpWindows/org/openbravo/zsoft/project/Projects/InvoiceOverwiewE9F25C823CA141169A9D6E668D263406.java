
package org.openbravo.erpWindows.org.openbravo.zsoft.project.Projects;





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

public class InvoiceOverwiewE9F25C823CA141169A9D6E668D263406 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(InvoiceOverwiewE9F25C823CA141169A9D6E668D263406.class);
  
  private static final String windowId = "130";
  private static final String tabId = "E9F25C823CA141169A9D6E668D263406";
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
        String strcProjectInvoiceOverviewId = request.getParameter("inpcProjectInvoiceOverviewId");
         String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcProjectInvoiceOverviewId.equals(""))
              total = saveRecord(vars, myError, 'U', strPC_Project_ID);
          else
              total = saveRecord(vars, myError, 'I', strPC_Project_ID);
          
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
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID", "");

      String strC_Project_Invoice_Overview_ID = vars.getGlobalVariable("inpcProjectInvoiceOverviewId", windowId + "|C_Project_Invoice_Overview_ID", "");
            if (strPC_Project_ID.equals("")) {
        strPC_Project_ID = getParentID(vars, strC_Project_Invoice_Overview_ID);
        if (strPC_Project_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_Project_ID");
        vars.setSessionValue(windowId + "|C_Project_ID", strPC_Project_ID);

        refreshParentSession(vars, strPC_Project_ID);
      }


      String strView = vars.getSessionValue(tabId + "|InvoiceOverwiewE9F25C823CA141169A9D6E668D263406.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_Project_Invoice_Overview_ID.equals("")) strC_Project_Invoice_Overview_ID = firstElement(vars, tableSQL);
          if (strC_Project_Invoice_Overview_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Project_Invoice_Overview_ID, strPC_Project_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Project_ID, strC_Project_Invoice_Overview_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_Project_Invoice_Overview_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_Project_Invoice_Overview_ID.equals("")) strC_Project_Invoice_Overview_ID = vars.getRequiredGlobalVariable("inpcProjectInvoiceOverviewId", windowId + "|C_Project_Invoice_Overview_ID");
      else vars.setSessionValue(windowId + "|C_Project_Invoice_Overview_ID", strC_Project_Invoice_Overview_ID);
      
      
      String strPC_Project_ID = getParentID(vars, strC_Project_Invoice_Overview_ID);
      
      vars.setSessionValue(windowId + "|C_Project_ID", strPC_Project_ID);
      vars.setSessionValue("157|Project-Header.view", "EDIT");

      refreshParentSession(vars, strPC_Project_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|InvoiceOverwiewE9F25C823CA141169A9D6E668D263406.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_Project_Invoice_Overview_ID, strPC_Project_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|InvoiceOverwiewE9F25C823CA141169A9D6E668D263406.view", "RELATION");
        printPageDataSheet(response, vars, strPC_Project_ID, strC_Project_Invoice_Overview_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|C_Project_Invoice_Overview_ID");
      refreshParentSession(vars, strPC_Project_ID);


      String strView = vars.getSessionValue(tabId + "|InvoiceOverwiewE9F25C823CA141169A9D6E668D263406.view");
      String strC_Project_Invoice_Overview_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_Project_Invoice_Overview_ID = firstElement(vars, tableSQL);
          if (strC_Project_Invoice_Overview_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_Project_Invoice_Overview_ID.equals("")) strC_Project_Invoice_Overview_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_Project_Invoice_Overview_ID, strPC_Project_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_Project_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamC_Bpartner_ID", tabId + "|paramC_Bpartner_ID");
vars.getRequestGlobalVariable("inpParamC_Bpartner_Location_ID", tabId + "|paramC_Bpartner_Location_ID");
vars.getRequestGlobalVariable("inpParamIspaid", tabId + "|paramIspaid");
vars.getRequestGlobalVariable("inpParamC_Doctype_ID", tabId + "|paramC_Doctype_ID");
vars.getRequestGlobalVariable("inpParamSalestotallines", tabId + "|paramSalestotallines");
vars.getRequestGlobalVariable("inpParamPurchasetotallines", tabId + "|paramPurchasetotallines");
vars.getRequestGlobalVariable("inpParamM_Product_ID", tabId + "|paramM_Product_ID");
vars.getRequestGlobalVariable("inpParamC_Projecttask_ID", tabId + "|paramC_Projecttask_ID");
vars.getRequestGlobalVariable("inpParamSalestotallines_f", tabId + "|paramSalestotallines_f");
vars.getRequestGlobalVariable("inpParamPurchasetotallines_f", tabId + "|paramPurchasetotallines_f");

            String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");

      
      vars.removeSessionValue(windowId + "|C_Project_Invoice_Overview_ID");
      String strC_Project_Invoice_Overview_ID="";

      String strView = vars.getSessionValue(tabId + "|InvoiceOverwiewE9F25C823CA141169A9D6E668D263406.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_Project_Invoice_Overview_ID = firstElement(vars, tableSQL);
        if (strC_Project_Invoice_Overview_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|InvoiceOverwiewE9F25C823CA141169A9D6E668D263406.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Project_Invoice_Overview_ID, strPC_Project_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Project_ID, strC_Project_Invoice_Overview_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");
      

      String strC_Project_Invoice_Overview_ID = vars.getGlobalVariable("inpcProjectInvoiceOverviewId", windowId + "|C_Project_Invoice_Overview_ID", "");
      vars.setSessionValue(tabId + "|InvoiceOverwiewE9F25C823CA141169A9D6E668D263406.view", "RELATION");
      printPageDataSheet(response, vars, strPC_Project_ID, strC_Project_Invoice_Overview_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");


      printPageEdit(response, request, vars, true, "", strPC_Project_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_Project_Invoice_Overview_ID = vars.getGlobalVariable("inpcProjectInvoiceOverviewId", windowId + "|C_Project_Invoice_Overview_ID", "");
      vars.setSessionValue(tabId + "|InvoiceOverwiewE9F25C823CA141169A9D6E668D263406.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_Project_Invoice_Overview_ID, strPC_Project_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");
      String strC_Project_Invoice_Overview_ID = vars.getRequiredStringParameter("inpcProjectInvoiceOverviewId");
      
      String strNext = nextElement(vars, strC_Project_Invoice_Overview_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_Project_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");
      String strC_Project_Invoice_Overview_ID = vars.getRequiredStringParameter("inpcProjectInvoiceOverviewId");
      
      String strPrevious = previousElement(vars, strC_Project_Invoice_Overview_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_Project_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");

      vars.setSessionValue(tabId + "|InvoiceOverwiewE9F25C823CA141169A9D6E668D263406.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|InvoiceOverwiewE9F25C823CA141169A9D6E668D263406.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|InvoiceOverwiewE9F25C823CA141169A9D6E668D263406.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|InvoiceOverwiewE9F25C823CA141169A9D6E668D263406.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_Project_Invoice_Overview_ID");
      vars.setSessionValue(windowId + "|C_Project_ID", strPC_Project_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|InvoiceOverwiewE9F25C823CA141169A9D6E668D263406.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|InvoiceOverwiewE9F25C823CA141169A9D6E668D263406.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_Project_Invoice_Overview_ID");
      vars.setSessionValue(windowId + "|C_Project_ID", strPC_Project_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPC_Project_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPC_Project_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPC_Project_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPC_Project_ID);      
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
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");
      String strC_Project_Invoice_Overview_ID = vars.getRequiredGlobalVariable("inpcProjectInvoiceOverviewId", windowId + "|C_Project_Invoice_Overview_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPC_Project_ID);      
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
          String strNext = nextElement(vars, strC_Project_Invoice_Overview_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_Project_Invoice_Overview_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");

      String strC_Project_Invoice_Overview_ID = vars.getRequiredInStringParameter("inpcProjectInvoiceOverviewId");
      String message = deleteRelation(vars, strC_Project_Invoice_Overview_ID, strPC_Project_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cProjectInvoiceOverviewId");
        vars.setSessionValue(tabId + "|InvoiceOverwiewE9F25C823CA141169A9D6E668D263406.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");

      String strC_Project_Invoice_Overview_ID = vars.getRequiredStringParameter("inpcProjectInvoiceOverviewId");
      //InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data data = getEditVariables(vars, strPC_Project_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.delete(this, strC_Project_Invoice_Overview_ID, strPC_Project_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cProjectInvoiceOverviewId");
        vars.setSessionValue(tabId + "|InvoiceOverwiewE9F25C823CA141169A9D6E668D263406.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strC_Project_Invoice_Overview_ID, String strPC_Project_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_Project_Invoice_Overview_ID.startsWith("(")) strC_Project_Invoice_Overview_ID = strC_Project_Invoice_Overview_ID.substring(1, strC_Project_Invoice_Overview_ID.length()-1);
      if (!strC_Project_Invoice_Overview_ID.equals("")) {
        strC_Project_Invoice_Overview_ID = Replace.replace(strC_Project_Invoice_Overview_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_Project_Invoice_Overview_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.deleteTransactional(conn, this, strKey, strPC_Project_ID)==0) {
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
  private InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data getEditVariables(Connection con, VariablesSecureApp vars, String strPC_Project_ID) throws IOException,ServletException {
    InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data data = new InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data();
    ServletException ex = null;
    try {
    data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.cProjectInvoiceOverviewId = vars.getRequestGlobalVariable("inpcProjectInvoiceOverviewId", windowId + "|C_Project_Invoice_Overview_ID");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.cDoctypeId = vars.getStringParameter("inpcDoctypeId");     data.cDoctypeIdr = vars.getStringParameter("inpcDoctypeId_R");     data.issotrx = vars.getStringParameter("inpissotrx", "N");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.cBpartnerLocationId = vars.getStringParameter("inpcBpartnerLocationId");     data.cBpartnerLocationIdr = vars.getStringParameter("inpcBpartnerLocationId_R");    try {   data.salestotallines = vars.getNumericParameter("inpsalestotallines");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.purchasetotallines = vars.getNumericParameter("inppurchasetotallines");  } catch (ServletException paramEx) { ex = paramEx; }     data.ispaid = vars.getStringParameter("inpispaid", "N");    try {   data.salestotalpaid = vars.getNumericParameter("inpsalestotalpaid");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.purchasetotalpaid = vars.getNumericParameter("inppurchasetotalpaid");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.salesoutstandingamt = vars.getNumericParameter("inpsalesoutstandingamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.purchaseoutstandingamt = vars.getNumericParameter("inppurchaseoutstandingamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.linenetamt = vars.getNumericParameter("inplinenetamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.linegrossamt = vars.getNumericParameter("inplinegrossamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");    try {   data.qtyinvoiced = vars.getNumericParameter("inpqtyinvoiced");  } catch (ServletException paramEx) { ex = paramEx; }     data.description = vars.getStringParameter("inpdescription");     data.cInvoiceId = vars.getStringParameter("inpcInvoiceId");     data.cInvoiceIdr = vars.getStringParameter("inpcInvoiceId_R");     data.mPricelistId = vars.getStringParameter("inpmPricelistId");     data.mPricelistIdr = vars.getStringParameter("inpmPricelistId_R");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.isactive = vars.getStringParameter("inpisactive", "N"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cProjectId = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");


    
    

    
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

   private InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[] getRelationData(InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 32);        data[i].cProjectInvoiceOverviewId = FormatUtilities.truncate(data[i].cProjectInvoiceOverviewId, 32);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].cDoctypeId = FormatUtilities.truncate(data[i].cDoctypeId, 32);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 32);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 32);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].cInvoiceId = FormatUtilities.truncate(data[i].cInvoiceId, 32);        data[i].mPricelistId = FormatUtilities.truncate(data[i].mPricelistId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPC_Project_ID) throws IOException,ServletException {
      ProjectHeader157Data[] data = ProjectHeader157Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Project_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|ProjectCategory", data[0].projectcategory);    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].mWarehouseId);    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].cBpartnerId);    vars.setSessionValue(windowId + "|C_Project_ID", data[0].cProjectId);    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].cCurrencyId);    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].mPricelistId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|IsCommitment", data[0].iscommitment);
      vars.setSessionValue(windowId + "|C_Project_ID", strPC_Project_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
      vars.setSessionValue(windowId + "|PREPROJECTCATEGORY", "S");
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strC_Project_Invoice_Overview_ID) throws ServletException {
    String strPC_Project_ID = InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.selectParentID(this, strC_Project_Invoice_Overview_ID);
    if (strPC_Project_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strC_Project_Invoice_Overview_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_Project_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|C_Project_Invoice_Overview_ID", data[0].getField("cProjectInvoiceOverviewId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_Project_ID) throws IOException,ServletException {
      InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[] data = InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Project_ID, vars.getStringParameter("inpcProjectInvoiceOverviewId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_Project_ID, String strC_Project_Invoice_Overview_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamC_Bpartner_ID = vars.getSessionValue(tabId + "|paramC_Bpartner_ID");
String strParamC_Bpartner_Location_ID = vars.getSessionValue(tabId + "|paramC_Bpartner_Location_ID");
String strParamIspaid = vars.getSessionValue(tabId + "|paramIspaid");
String strParamC_Doctype_ID = vars.getSessionValue(tabId + "|paramC_Doctype_ID");
String strParamSalestotallines = vars.getSessionValue(tabId + "|paramSalestotallines");
String strParamPurchasetotallines = vars.getSessionValue(tabId + "|paramPurchasetotallines");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamC_Projecttask_ID = vars.getSessionValue(tabId + "|paramC_Projecttask_ID");
String strParamSalestotallines_f = vars.getSessionValue(tabId + "|paramSalestotallines_f");
String strParamPurchasetotallines_f = vars.getSessionValue(tabId + "|paramPurchasetotallines_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamC_Bpartner_ID.equals("") && strParamC_Bpartner_Location_ID.equals("") && strParamIspaid.equals("") && strParamC_Doctype_ID.equals("") && strParamSalestotallines.equals("") && strParamPurchasetotallines.equals("") && strParamM_Product_ID.equals("") && strParamC_Projecttask_ID.equals("") && strParamSalestotallines_f.equals("") && strParamPurchasetotallines_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_Project_Invoice_Overview_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_Project_Invoice_Overview_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/project/Projects/InvoiceOverwiewE9F25C823CA141169A9D6E668D263406_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "InvoiceOverwiewE9F25C823CA141169A9D6E668D263406", false, "document.frmMain.inpcProjectInvoiceOverviewId", "grid", "..", "".equals("Y"), "Projects", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), true, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPC_Project_ID);

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
    xmlDocument.setParameter("KeyName", "cProjectInvoiceOverviewId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "InvoiceOverwiewE9F25C823CA141169A9D6E668D263406_Relation.html", "Projects", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "InvoiceOverwiewE9F25C823CA141169A9D6E668D263406_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.selectParent(this, strPC_Project_ID));
    else xmlDocument.setParameter("parent", InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.selectParentTrl(this, strPC_Project_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_Project_Invoice_Overview_ID, String strPC_Project_ID, TableSQLData tableSQL)
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
    InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamC_Bpartner_ID = vars.getSessionValue(tabId + "|paramC_Bpartner_ID");
String strParamC_Bpartner_Location_ID = vars.getSessionValue(tabId + "|paramC_Bpartner_Location_ID");
String strParamIspaid = vars.getSessionValue(tabId + "|paramIspaid");
String strParamC_Doctype_ID = vars.getSessionValue(tabId + "|paramC_Doctype_ID");
String strParamSalestotallines = vars.getSessionValue(tabId + "|paramSalestotallines");
String strParamPurchasetotallines = vars.getSessionValue(tabId + "|paramPurchasetotallines");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamC_Projecttask_ID = vars.getSessionValue(tabId + "|paramC_Projecttask_ID");
String strParamSalestotallines_f = vars.getSessionValue(tabId + "|paramSalestotallines_f");
String strParamPurchasetotallines_f = vars.getSessionValue(tabId + "|paramPurchasetotallines_f");

    boolean hasSearchCondition=false;
    if (!(strParamC_Bpartner_ID.equals("") && strParamC_Bpartner_Location_ID.equals("") && strParamIspaid.equals("") && strParamC_Doctype_ID.equals("") && strParamSalestotallines.equals("") && strParamPurchasetotallines.equals("") && strParamM_Product_ID.equals("") && strParamC_Projecttask_ID.equals("") && strParamSalestotallines_f.equals("") && strParamPurchasetotallines_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Project_ID, strC_Project_Invoice_Overview_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_Project_Invoice_Overview_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (data==null || data.length==0) {
        strC_Project_Invoice_Overview_ID = firstElement(vars, tableSQL);
        if (strC_Project_Invoice_Overview_ID.equals("")) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        } else {
          data = InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Project_ID, strC_Project_Invoice_Overview_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
        }
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cProjectInvoiceOverviewId") == null || dataField.getField("cProjectInvoiceOverviewId").equals("")) {
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
        refreshSessionNew(vars, strPC_Project_ID);
        data = InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.set(strPC_Project_ID, Utility.getDefault(this, vars, "Purchaseoutstandingamt", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), "", Utility.getDefault(this, vars, "C_Bpartner_ID", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.selectDef4B6F17A5FB3949F7A37E60CFD4686908_0(this, Utility.getDefault(this, vars, "C_Bpartner_ID", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField)), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), Utility.getDefault(this, vars, "Salestotallines", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), Utility.getDefault(this, vars, "Ispaid", "", "130", "E9F25C823CA141169A9D6E668D263406", "N", dataField), Utility.getDefault(this, vars, "Purchasetotallines", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), Utility.getDefault(this, vars, "C_Projecttask_ID", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), Utility.getDefault(this, vars, "M_Pricelist_ID", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), Utility.getDefault(this, vars, "Linegrossamt", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), Utility.getDefault(this, vars, "C_Invoice_ID", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), Utility.getDefault(this, vars, "Purchasetotalpaid", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.selectDef3C8E791A01734B7488F1CBD3435E1CED_1(this, Utility.getDefault(this, vars, "Updatedby", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField)), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), Utility.getDefault(this, vars, "Qtyinvoiced", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.selectDef52DF8262DD11461AA80A8AEA3B504B63_2(this, Utility.getDefault(this, vars, "M_Product_ID", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField)), Utility.getDefault(this, vars, "Salesoutstandingamt", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), "Y", Utility.getDefault(this, vars, "Linenetamt", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), Utility.getDefault(this, vars, "Description", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), Utility.getDefault(this, vars, "Salestotalpaid", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), Utility.getDefault(this, vars, "Issotrx", "", "130", "E9F25C823CA141169A9D6E668D263406", "N", dataField), Utility.getDefault(this, vars, "C_Bpartner_Location_ID", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), Utility.getDefault(this, vars, "C_Doctype_ID", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField), InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.selectDef12BEF6D30CED485AB3FDAB1068B705F4_3(this, Utility.getDefault(this, vars, "Createdby", "", "130", "E9F25C823CA141169A9D6E668D263406", "", dataField)));
        
      }
    } else {
      data = new InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=ProjectHeader157Data.selectOrg(this, strPC_Project_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "InvoiceOverwiewE9F25C823CA141169A9D6E668D263406", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcProjectInvoiceOverviewId", "", "..", "".equals("Y"), "Projects", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_Project_Invoice_Overview_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPC_Project_ID) throws IOException, ServletException {
    InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data data = null;
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
            data = getEditVariables(con, vars, strPC_Project_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.cProjectInvoiceOverviewId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (InvoiceOverwiewE9F25C823CA141169A9D6E668D263406Data.getCurrentDBTimestamp(this, data.cProjectInvoiceOverviewId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cProjectInvoiceOverviewId, vars, this);
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
                    data.cProjectInvoiceOverviewId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_Project_Invoice_Overview_ID", data.cProjectInvoiceOverviewId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet InvoiceOverwiewE9F25C823CA141169A9D6E668D263406. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
