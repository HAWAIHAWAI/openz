
package org.openbravo.erpWindows.org.openbravo.zsoft.finance.GLBatch;


import org.openbravo.erpCommon.reference.*;




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

public class GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58.class);
  
  private static final String windowId = "A7AF6B7EA2A04616BACD889B62835E17";
  private static final String tabId = "B67F4C4E5C064996B264A86E3622EF58";
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
        String strzsfiManualacctId = request.getParameter("inpzsfiManualacctId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strzsfiManualacctId.equals(""))
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

      String strZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strZsfi_Manualacct_ID.equals("")) strZsfi_Manualacct_ID = firstElement(vars, tableSQL);
          if (strZsfi_Manualacct_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZsfi_Manualacct_ID, tableSQL);

      else printPageDataSheet(response, vars, strZsfi_Manualacct_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strZsfi_Manualacct_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strZsfi_Manualacct_ID.equals("")) strZsfi_Manualacct_ID = vars.getRequiredGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");
      else vars.setSessionValue(windowId + "|Zsfi_Manualacct_ID", strZsfi_Manualacct_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58.view", "EDIT");

        printPageEdit(response, request, vars, false, strZsfi_Manualacct_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58.view", "RELATION");
        printPageDataSheet(response, vars, strZsfi_Manualacct_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58.view");
      String strZsfi_Manualacct_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strZsfi_Manualacct_ID = firstElement(vars, tableSQL);
          if (strZsfi_Manualacct_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strZsfi_Manualacct_ID.equals("")) strZsfi_Manualacct_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strZsfi_Manualacct_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamAcctdate", tabId + "|paramAcctdate");
vars.getRequestGlobalVariable("inpParamGlstatus", tabId + "|paramGlstatus");
vars.getRequestGlobalVariable("inpParamC_Project_ID", tabId + "|paramC_Project_ID");
vars.getRequestGlobalVariable("inpParamA_Asset_ID", tabId + "|paramA_Asset_ID");
vars.getRequestGlobalVariable("inpParamDocumentNo", tabId + "|paramDocumentNo");
vars.getRequestGlobalVariable("inpParamAcctdate_f", tabId + "|paramAcctdate_f");

      
      
      vars.removeSessionValue(windowId + "|Zsfi_Manualacct_ID");
      String strZsfi_Manualacct_ID="";

      String strView = vars.getSessionValue(tabId + "|GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strZsfi_Manualacct_ID = firstElement(vars, tableSQL);
        if (strZsfi_Manualacct_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZsfi_Manualacct_ID, tableSQL);

      else printPageDataSheet(response, vars, strZsfi_Manualacct_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID", "");
      vars.setSessionValue(tabId + "|GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58.view", "RELATION");
      printPageDataSheet(response, vars, strZsfi_Manualacct_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID", "");
      vars.setSessionValue(tabId + "|GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strZsfi_Manualacct_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strZsfi_Manualacct_ID = vars.getRequiredStringParameter("inpzsfiManualacctId");
      
      String strNext = nextElement(vars, strZsfi_Manualacct_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strZsfi_Manualacct_ID = vars.getRequiredStringParameter("inpzsfiManualacctId");
      
      String strPrevious = previousElement(vars, strZsfi_Manualacct_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Zsfi_Manualacct_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Zsfi_Manualacct_ID");

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

      String strZsfi_Manualacct_ID = vars.getRequiredGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");
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
          String strNext = nextElement(vars, strZsfi_Manualacct_ID, tableSQL);
          vars.setSessionValue(windowId + "|Zsfi_Manualacct_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strZsfi_Manualacct_ID = vars.getRequiredInStringParameter("inpzsfiManualacctId");
      String message = deleteRelation(vars, strZsfi_Manualacct_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|zsfiManualacctId");
        vars.setSessionValue(tabId + "|GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strZsfi_Manualacct_ID = vars.getRequiredStringParameter("inpzsfiManualacctId");
      //GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.delete(this, strZsfi_Manualacct_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|zsfiManualacctId");
        vars.setSessionValue(tabId + "|GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONPostE0560552B03C4F6C9452EE04DFE3EB67")) {
        vars.setSessionValue("buttonE0560552B03C4F6C9452EE04DFE3EB67.strpost", vars.getStringParameter("inppost"));
        vars.setSessionValue("buttonE0560552B03C4F6C9452EE04DFE3EB67.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonE0560552B03C4F6C9452EE04DFE3EB67.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonE0560552B03C4F6C9452EE04DFE3EB67.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonE0560552B03C4F6C9452EE04DFE3EB67.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "E0560552B03C4F6C9452EE04DFE3EB67", request.getServletPath());    
     } else if (vars.commandIn("BUTTONE0560552B03C4F6C9452EE04DFE3EB67")) {
        String strZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID", "");
        String strpost = vars.getSessionValue("buttonE0560552B03C4F6C9452EE04DFE3EB67.strpost");
        String strProcessing = vars.getSessionValue("buttonE0560552B03C4F6C9452EE04DFE3EB67.strProcessing");
        String strOrg = vars.getSessionValue("buttonE0560552B03C4F6C9452EE04DFE3EB67.strOrg");
        String strClient = vars.getSessionValue("buttonE0560552B03C4F6C9452EE04DFE3EB67.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonPostE0560552B03C4F6C9452EE04DFE3EB67(response, vars, strZsfi_Manualacct_ID, strpost, strProcessing);
        }

     } else if (vars.commandIn("BUTTONUnpost38AA5CAF42514C3FA8F6BEC9B12F6E95")) {
        vars.setSessionValue("button38AA5CAF42514C3FA8F6BEC9B12F6E95.strunpost", vars.getStringParameter("inpunpost"));
        vars.setSessionValue("button38AA5CAF42514C3FA8F6BEC9B12F6E95.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button38AA5CAF42514C3FA8F6BEC9B12F6E95.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button38AA5CAF42514C3FA8F6BEC9B12F6E95.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button38AA5CAF42514C3FA8F6BEC9B12F6E95.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "38AA5CAF42514C3FA8F6BEC9B12F6E95", request.getServletPath());    
     } else if (vars.commandIn("BUTTON38AA5CAF42514C3FA8F6BEC9B12F6E95")) {
        String strZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID", "");
        String strunpost = vars.getSessionValue("button38AA5CAF42514C3FA8F6BEC9B12F6E95.strunpost");
        String strProcessing = vars.getSessionValue("button38AA5CAF42514C3FA8F6BEC9B12F6E95.strProcessing");
        String strOrg = vars.getSessionValue("button38AA5CAF42514C3FA8F6BEC9B12F6E95.strOrg");
        String strClient = vars.getSessionValue("button38AA5CAF42514C3FA8F6BEC9B12F6E95.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonUnpost38AA5CAF42514C3FA8F6BEC9B12F6E95(response, vars, strZsfi_Manualacct_ID, strunpost, strProcessing);
        }

     } else if (vars.commandIn("BUTTONCancel4F89C1AD0A2C43238E0F1D370F3C0A92")) {
        vars.setSessionValue("button4F89C1AD0A2C43238E0F1D370F3C0A92.strcancel", vars.getStringParameter("inpcancel"));
        vars.setSessionValue("button4F89C1AD0A2C43238E0F1D370F3C0A92.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button4F89C1AD0A2C43238E0F1D370F3C0A92.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button4F89C1AD0A2C43238E0F1D370F3C0A92.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button4F89C1AD0A2C43238E0F1D370F3C0A92.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "4F89C1AD0A2C43238E0F1D370F3C0A92", request.getServletPath());    
     } else if (vars.commandIn("BUTTON4F89C1AD0A2C43238E0F1D370F3C0A92")) {
        String strZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID", "");
        String strcancel = vars.getSessionValue("button4F89C1AD0A2C43238E0F1D370F3C0A92.strcancel");
        String strProcessing = vars.getSessionValue("button4F89C1AD0A2C43238E0F1D370F3C0A92.strProcessing");
        String strOrg = vars.getSessionValue("button4F89C1AD0A2C43238E0F1D370F3C0A92.strOrg");
        String strClient = vars.getSessionValue("button4F89C1AD0A2C43238E0F1D370F3C0A92.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCancel4F89C1AD0A2C43238E0F1D370F3C0A92(response, vars, strZsfi_Manualacct_ID, strcancel, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONPostE0560552B03C4F6C9452EE04DFE3EB67")) {
        String strZsfi_Manualacct_ID = vars.getGlobalVariable("inpKey", windowId + "|Zsfi_Manualacct_ID", "");
        @SuppressWarnings("unused")
        String strpost = vars.getStringParameter("inppost");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "E0560552B03C4F6C9452EE04DFE3EB67", (("Zsfi_Manualacct_ID".equalsIgnoreCase("AD_Language"))?"0":strZsfi_Manualacct_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONUnpost38AA5CAF42514C3FA8F6BEC9B12F6E95")) {
        String strZsfi_Manualacct_ID = vars.getGlobalVariable("inpKey", windowId + "|Zsfi_Manualacct_ID", "");
        @SuppressWarnings("unused")
        String strunpost = vars.getStringParameter("inpunpost");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "38AA5CAF42514C3FA8F6BEC9B12F6E95", (("Zsfi_Manualacct_ID".equalsIgnoreCase("AD_Language"))?"0":strZsfi_Manualacct_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONCancel4F89C1AD0A2C43238E0F1D370F3C0A92")) {
        String strZsfi_Manualacct_ID = vars.getGlobalVariable("inpKey", windowId + "|Zsfi_Manualacct_ID", "");
        @SuppressWarnings("unused")
        String strcancel = vars.getStringParameter("inpcancel");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "4F89C1AD0A2C43238E0F1D370F3C0A92", (("Zsfi_Manualacct_ID".equalsIgnoreCase("AD_Language"))?"0":strZsfi_Manualacct_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
  String deleteRelation(VariablesSecureApp vars, String strZsfi_Manualacct_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strZsfi_Manualacct_ID.startsWith("(")) strZsfi_Manualacct_ID = strZsfi_Manualacct_ID.substring(1, strZsfi_Manualacct_ID.length()-1);
      if (!strZsfi_Manualacct_ID.equals("")) {
        strZsfi_Manualacct_ID = Replace.replace(strZsfi_Manualacct_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strZsfi_Manualacct_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.deleteTransactional(conn, this, strKey)==0) {
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
  private GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data data = new GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.zsfiManualacctId = vars.getRequestGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.documentno = vars.getStringParameter("inpdocumentno");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.acctdate = vars.getRequestGlobalVariable("inpacctdate", windowId + "|Acctdate");     data.description = vars.getStringParameter("inpdescription");     data.glstatus = vars.getStringParameter("inpglstatus");     data.glstatusr = vars.getStringParameter("inpglstatus_R");     data.aAssetId = vars.getStringParameter("inpaAssetId");     data.aAssetIdr = vars.getStringParameter("inpaAssetId_R");     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.cProjectphaseId = vars.getStringParameter("inpcProjectphaseId");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.post = vars.getStringParameter("inppost");     data.processing = vars.getStringParameter("inpprocessing", "N");     data.unpost = vars.getStringParameter("inpunpost");     data.cancel = vars.getStringParameter("inpcancel"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");



    
         if (data.documentno.startsWith("<")) data.documentno = Utility.getDocumentNo(con, this, vars, windowId, "zsfi_manualacct", "", "", false, true);

    
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

   private GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[] getRelationData(GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].zsfiManualacctId = FormatUtilities.truncate(data[i].zsfiManualacctId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].documentno = FormatUtilities.truncate(data[i].documentno, 30);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].glstatus = FormatUtilities.truncate(data[i].glstatus, 15);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, 32);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 32);        data[i].cProjectphaseId = FormatUtilities.truncate(data[i].cProjectphaseId, 32);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Zsfi_Manualacct_ID", data[0].getField("zsfiManualacctId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|Acctdate", data[0].getField("acctdate"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[] data = GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpzsfiManualacctId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strZsfi_Manualacct_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamAcctdate = vars.getSessionValue(tabId + "|paramAcctdate");
String strParamGlstatus = vars.getSessionValue(tabId + "|paramGlstatus");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamA_Asset_ID = vars.getSessionValue(tabId + "|paramA_Asset_ID");
String strParamDocumentNo = vars.getSessionValue(tabId + "|paramDocumentNo");
String strParamAcctdate_f = vars.getSessionValue(tabId + "|paramAcctdate_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamAcctdate.equals("") && strParamGlstatus.equals("") && strParamC_Project_ID.equals("") && strParamA_Asset_ID.equals("") && strParamDocumentNo.equals("") && strParamAcctdate_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strZsfi_Manualacct_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strZsfi_Manualacct_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/finance/GLBatch/GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58", false, "document.frmMain.inpzsfiManualacctId", "grid", "..", "".equals("Y"), "GLBatch", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "zsfiManualacctId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58_Relation.html", "GLBatch", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strZsfi_Manualacct_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " zsfi_manualacct.documentno desc";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamAcctdate = vars.getSessionValue(tabId + "|paramAcctdate");
String strParamGlstatus = vars.getSessionValue(tabId + "|paramGlstatus");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamA_Asset_ID = vars.getSessionValue(tabId + "|paramA_Asset_ID");
String strParamDocumentNo = vars.getSessionValue(tabId + "|paramDocumentNo");
String strParamAcctdate_f = vars.getSessionValue(tabId + "|paramAcctdate_f");

    boolean hasSearchCondition=false;
    if (!(strParamAcctdate.equals("") && strParamGlstatus.equals("") && strParamC_Project_ID.equals("") && strParamA_Asset_ID.equals("") && strParamDocumentNo.equals("") && strParamAcctdate_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strZsfi_Manualacct_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strZsfi_Manualacct_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("zsfiManualacctId") == null || dataField.getField("zsfiManualacctId").equals("")) {
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
        data = GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.set(Utility.getDefault(this, vars, "Unpost", "N", "A7AF6B7EA2A04616BACD889B62835E17", "B67F4C4E5C064996B264A86E3622EF58", "N", dataField), Utility.getDefault(this, vars, "Cancel", "N", "A7AF6B7EA2A04616BACD889B62835E17", "B67F4C4E5C064996B264A86E3622EF58", "N", dataField), "Y", Utility.getDefault(this, vars, "Description", "", "A7AF6B7EA2A04616BACD889B62835E17", "B67F4C4E5C064996B264A86E3622EF58", "", dataField), Utility.getDefault(this, vars, "Post", "N", "A7AF6B7EA2A04616BACD889B62835E17", "B67F4C4E5C064996B264A86E3622EF58", "N", dataField), Utility.getDefault(this, vars, "C_Projectphase_ID", "", "A7AF6B7EA2A04616BACD889B62835E17", "B67F4C4E5C064996B264A86E3622EF58", "", dataField), Utility.getDefault(this, vars, "C_Projecttask_ID", "", "A7AF6B7EA2A04616BACD889B62835E17", "B67F4C4E5C064996B264A86E3622EF58", "", dataField), Utility.getDefault(this, vars, "Glstatus", "OP", "A7AF6B7EA2A04616BACD889B62835E17", "B67F4C4E5C064996B264A86E3622EF58", "", dataField), Utility.getDefault(this, vars, "DocumentNo", "", "A7AF6B7EA2A04616BACD889B62835E17", "B67F4C4E5C064996B264A86E3622EF58", "", dataField), "", Utility.getDefault(this, vars, "A_Asset_ID", "", "A7AF6B7EA2A04616BACD889B62835E17", "B67F4C4E5C064996B264A86E3622EF58", "", dataField), Utility.getDefault(this, vars, "C_Project_ID", "", "A7AF6B7EA2A04616BACD889B62835E17", "B67F4C4E5C064996B264A86E3622EF58", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "A7AF6B7EA2A04616BACD889B62835E17", "B67F4C4E5C064996B264A86E3622EF58", "", dataField), Utility.getDefault(this, vars, "Acctdate", "@#Date@", "A7AF6B7EA2A04616BACD889B62835E17", "B67F4C4E5C064996B264A86E3622EF58", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "A7AF6B7EA2A04616BACD889B62835E17", "B67F4C4E5C064996B264A86E3622EF58", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "A7AF6B7EA2A04616BACD889B62835E17", "B67F4C4E5C064996B264A86E3622EF58", "", dataField), GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.selectDef9F1A49AD744741069EBE46B7B5376B30_0(this, Utility.getDefault(this, vars, "Createdby", "", "A7AF6B7EA2A04616BACD889B62835E17", "B67F4C4E5C064996B264A86E3622EF58", "", dataField)), Utility.getDefault(this, vars, "Processing", "N", "A7AF6B7EA2A04616BACD889B62835E17", "B67F4C4E5C064996B264A86E3622EF58", "N", dataField), Utility.getDefault(this, vars, "Updatedby", "", "A7AF6B7EA2A04616BACD889B62835E17", "B67F4C4E5C064996B264A86E3622EF58", "", dataField), GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.selectDef6929408566E04C0BB0AA1809D9BC13D9_1(this, Utility.getDefault(this, vars, "Updatedby", "", "A7AF6B7EA2A04616BACD889B62835E17", "B67F4C4E5C064996B264A86E3622EF58", "", dataField)));
             data[0].documentno = "<" + Utility.getDocumentNo( this, vars, windowId, "zsfi_manualacct", "", "", false, false) + ">";
      }
    } else {
      data = new GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpzsfiManualacctId", "", "..", "".equals("Y"), "GLBatch", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strZsfi_Manualacct_ID));
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
  
    void printPageButtonPostE0560552B03C4F6C9452EE04DFE3EB67(HttpServletResponse response, VariablesSecureApp vars, String strZsfi_Manualacct_ID, String strpost, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "E0560552B03C4F6C9452EE04DFE3EB67",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "E0560552B03C4F6C9452EE04DFE3EB67" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"E0560552B03C4F6C9452EE04DFE3EB67" );
        String isDocAction=UtilsData.isProcessDocAction(this, "E0560552B03C4F6C9452EE04DFE3EB67");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "A08E99D32F484618BE340C9718F4F307",strZsfi_Manualacct_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "A08E99D32F484618BE340C9718F4F307", strZsfi_Manualacct_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strpost, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "E0560552B03C4F6C9452EE04DFE3EB67");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONPost" + "E0560552B03C4F6C9452EE04DFE3EB67" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "E0560552B03C4F6C9452EE04DFE3EB67");
        script.addHiddenfield("inpKey",strZsfi_Manualacct_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("E0560552B03C4F6C9452EE04DFE3EB67");
        vars.removeMessage("E0560552B03C4F6C9452EE04DFE3EB67");
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
    void printPageButtonUnpost38AA5CAF42514C3FA8F6BEC9B12F6E95(HttpServletResponse response, VariablesSecureApp vars, String strZsfi_Manualacct_ID, String strunpost, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "38AA5CAF42514C3FA8F6BEC9B12F6E95",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "38AA5CAF42514C3FA8F6BEC9B12F6E95" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"38AA5CAF42514C3FA8F6BEC9B12F6E95" );
        String isDocAction=UtilsData.isProcessDocAction(this, "38AA5CAF42514C3FA8F6BEC9B12F6E95");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "A08E99D32F484618BE340C9718F4F307",strZsfi_Manualacct_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "A08E99D32F484618BE340C9718F4F307", strZsfi_Manualacct_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strunpost, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "38AA5CAF42514C3FA8F6BEC9B12F6E95");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONUnpost" + "38AA5CAF42514C3FA8F6BEC9B12F6E95" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "38AA5CAF42514C3FA8F6BEC9B12F6E95");
        script.addHiddenfield("inpKey",strZsfi_Manualacct_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("38AA5CAF42514C3FA8F6BEC9B12F6E95");
        vars.removeMessage("38AA5CAF42514C3FA8F6BEC9B12F6E95");
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
    void printPageButtonCancel4F89C1AD0A2C43238E0F1D370F3C0A92(HttpServletResponse response, VariablesSecureApp vars, String strZsfi_Manualacct_ID, String strcancel, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "4F89C1AD0A2C43238E0F1D370F3C0A92",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "4F89C1AD0A2C43238E0F1D370F3C0A92" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"4F89C1AD0A2C43238E0F1D370F3C0A92" );
        String isDocAction=UtilsData.isProcessDocAction(this, "4F89C1AD0A2C43238E0F1D370F3C0A92");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "A08E99D32F484618BE340C9718F4F307",strZsfi_Manualacct_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "A08E99D32F484618BE340C9718F4F307", strZsfi_Manualacct_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strcancel, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "4F89C1AD0A2C43238E0F1D370F3C0A92");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONCancel" + "4F89C1AD0A2C43238E0F1D370F3C0A92" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "4F89C1AD0A2C43238E0F1D370F3C0A92");
        script.addHiddenfield("inpKey",strZsfi_Manualacct_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("4F89C1AD0A2C43238E0F1D370F3C0A92");
        vars.removeMessage("4F89C1AD0A2C43238E0F1D370F3C0A92");
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
      String result = "var strShowAcctDel=\"" +Utility.getContext(this, vars, "ShowAcctDel", windowId) + "\";\nvar strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\nvar strDOCNOREADONLY=\"" + Utility.getContext(this, vars, "DOCNOREADONLY", windowId) + "\";\n";
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
    GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data data = null;
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
                data.zsfiManualacctId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.getCurrentDBTimestamp(this, data.zsfiManualacctId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.zsfiManualacctId, vars, this);
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
                    data.zsfiManualacctId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Zsfi_Manualacct_ID", data.zsfiManualacctId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
