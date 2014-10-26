
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

public class Lines5BC883ED6FC645D3B9E7EF231AEA2649 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Lines5BC883ED6FC645D3B9E7EF231AEA2649.class);
  
  private static final String windowId = "A7AF6B7EA2A04616BACD889B62835E17";
  private static final String tabId = "5BC883ED6FC645D3B9E7EF231AEA2649";
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
        String strzsfiMacctlineId = request.getParameter("inpzsfiMacctlineId");
         String strPZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strzsfiMacctlineId.equals(""))
              total = saveRecord(vars, myError, 'U', strPZsfi_Manualacct_ID);
          else
              total = saveRecord(vars, myError, 'I', strPZsfi_Manualacct_ID);
          
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
      String strPZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID", "");

      String strZsfi_Macctline_ID = vars.getGlobalVariable("inpzsfiMacctlineId", windowId + "|Zsfi_Macctline_ID", "");
            if (strPZsfi_Manualacct_ID.equals("")) {
        strPZsfi_Manualacct_ID = getParentID(vars, strZsfi_Macctline_ID);
        if (strPZsfi_Manualacct_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|Zsfi_Manualacct_ID");
        vars.setSessionValue(windowId + "|Zsfi_Manualacct_ID", strPZsfi_Manualacct_ID);

        refreshParentSession(vars, strPZsfi_Manualacct_ID);
      }


      String strView = vars.getSessionValue(tabId + "|Lines5BC883ED6FC645D3B9E7EF231AEA2649.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strZsfi_Macctline_ID.equals("")) strZsfi_Macctline_ID = firstElement(vars, tableSQL);
          if (strZsfi_Macctline_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZsfi_Macctline_ID, strPZsfi_Manualacct_ID, tableSQL);

      else printPageDataSheet(response, vars, strPZsfi_Manualacct_ID, strZsfi_Macctline_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strZsfi_Macctline_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strZsfi_Macctline_ID.equals("")) strZsfi_Macctline_ID = vars.getRequiredGlobalVariable("inpzsfiMacctlineId", windowId + "|Zsfi_Macctline_ID");
      else vars.setSessionValue(windowId + "|Zsfi_Macctline_ID", strZsfi_Macctline_ID);
      
      
      String strPZsfi_Manualacct_ID = getParentID(vars, strZsfi_Macctline_ID);
      
      vars.setSessionValue(windowId + "|Zsfi_Manualacct_ID", strPZsfi_Manualacct_ID);
      vars.setSessionValue("B67F4C4E5C064996B264A86E3622EF58|G/L Batch Header.view", "EDIT");

      refreshParentSession(vars, strPZsfi_Manualacct_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Lines5BC883ED6FC645D3B9E7EF231AEA2649.view", "EDIT");

        printPageEdit(response, request, vars, false, strZsfi_Macctline_ID, strPZsfi_Manualacct_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Lines5BC883ED6FC645D3B9E7EF231AEA2649.view", "RELATION");
        printPageDataSheet(response, vars, strPZsfi_Manualacct_ID, strZsfi_Macctline_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|Zsfi_Macctline_ID");
      refreshParentSession(vars, strPZsfi_Manualacct_ID);


      String strView = vars.getSessionValue(tabId + "|Lines5BC883ED6FC645D3B9E7EF231AEA2649.view");
      String strZsfi_Macctline_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strZsfi_Macctline_ID = firstElement(vars, tableSQL);
          if (strZsfi_Macctline_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strZsfi_Macctline_ID.equals("")) strZsfi_Macctline_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strZsfi_Macctline_ID, strPZsfi_Manualacct_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPZsfi_Manualacct_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamZsfi_Macctline_ID", tabId + "|paramZsfi_Macctline_ID");

            String strPZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");

      
      vars.removeSessionValue(windowId + "|Zsfi_Macctline_ID");
      String strZsfi_Macctline_ID="";

      String strView = vars.getSessionValue(tabId + "|Lines5BC883ED6FC645D3B9E7EF231AEA2649.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strZsfi_Macctline_ID = firstElement(vars, tableSQL);
        if (strZsfi_Macctline_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Lines5BC883ED6FC645D3B9E7EF231AEA2649.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZsfi_Macctline_ID, strPZsfi_Manualacct_ID, tableSQL);

      else printPageDataSheet(response, vars, strPZsfi_Manualacct_ID, strZsfi_Macctline_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");
      

      String strZsfi_Macctline_ID = vars.getGlobalVariable("inpzsfiMacctlineId", windowId + "|Zsfi_Macctline_ID", "");
      vars.setSessionValue(tabId + "|Lines5BC883ED6FC645D3B9E7EF231AEA2649.view", "RELATION");
      printPageDataSheet(response, vars, strPZsfi_Manualacct_ID, strZsfi_Macctline_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");


      printPageEdit(response, request, vars, true, "", strPZsfi_Manualacct_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strZsfi_Macctline_ID = vars.getGlobalVariable("inpzsfiMacctlineId", windowId + "|Zsfi_Macctline_ID", "");
      vars.setSessionValue(tabId + "|Lines5BC883ED6FC645D3B9E7EF231AEA2649.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strZsfi_Macctline_ID, strPZsfi_Manualacct_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");
      String strZsfi_Macctline_ID = vars.getRequiredStringParameter("inpzsfiMacctlineId");
      
      String strNext = nextElement(vars, strZsfi_Macctline_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPZsfi_Manualacct_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");
      String strZsfi_Macctline_ID = vars.getRequiredStringParameter("inpzsfiMacctlineId");
      
      String strPrevious = previousElement(vars, strZsfi_Macctline_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPZsfi_Manualacct_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");

      vars.setSessionValue(tabId + "|Lines5BC883ED6FC645D3B9E7EF231AEA2649.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Lines5BC883ED6FC645D3B9E7EF231AEA2649.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Lines5BC883ED6FC645D3B9E7EF231AEA2649.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Lines5BC883ED6FC645D3B9E7EF231AEA2649.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Zsfi_Macctline_ID");
      vars.setSessionValue(windowId + "|Zsfi_Manualacct_ID", strPZsfi_Manualacct_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Lines5BC883ED6FC645D3B9E7EF231AEA2649.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Lines5BC883ED6FC645D3B9E7EF231AEA2649.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Zsfi_Macctline_ID");
      vars.setSessionValue(windowId + "|Zsfi_Manualacct_ID", strPZsfi_Manualacct_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPZsfi_Manualacct_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPZsfi_Manualacct_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPZsfi_Manualacct_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPZsfi_Manualacct_ID);      
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
      String strPZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");
      String strZsfi_Macctline_ID = vars.getRequiredGlobalVariable("inpzsfiMacctlineId", windowId + "|Zsfi_Macctline_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPZsfi_Manualacct_ID);      
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
          String strNext = nextElement(vars, strZsfi_Macctline_ID, tableSQL);
          vars.setSessionValue(windowId + "|Zsfi_Macctline_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");

      String strZsfi_Macctline_ID = vars.getRequiredInStringParameter("inpzsfiMacctlineId");
      String message = deleteRelation(vars, strZsfi_Macctline_ID, strPZsfi_Manualacct_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|zsfiMacctlineId");
        vars.setSessionValue(tabId + "|Lines5BC883ED6FC645D3B9E7EF231AEA2649.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPZsfi_Manualacct_ID = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");

      String strZsfi_Macctline_ID = vars.getRequiredStringParameter("inpzsfiMacctlineId");
      //Lines5BC883ED6FC645D3B9E7EF231AEA2649Data data = getEditVariables(vars, strPZsfi_Manualacct_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = Lines5BC883ED6FC645D3B9E7EF231AEA2649Data.delete(this, strZsfi_Macctline_ID, strPZsfi_Manualacct_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|zsfiMacctlineId");
        vars.setSessionValue(tabId + "|Lines5BC883ED6FC645D3B9E7EF231AEA2649.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONCancel7D8C0A256D514A11B056AF14AFF952DE")) {
        vars.setSessionValue("button7D8C0A256D514A11B056AF14AFF952DE.strcancel", vars.getStringParameter("inpcancel"));
        vars.setSessionValue("button7D8C0A256D514A11B056AF14AFF952DE.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button7D8C0A256D514A11B056AF14AFF952DE.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button7D8C0A256D514A11B056AF14AFF952DE.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button7D8C0A256D514A11B056AF14AFF952DE.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "7D8C0A256D514A11B056AF14AFF952DE", request.getServletPath());    
     } else if (vars.commandIn("BUTTON7D8C0A256D514A11B056AF14AFF952DE")) {
        String strZsfi_Macctline_ID = vars.getGlobalVariable("inpzsfiMacctlineId", windowId + "|Zsfi_Macctline_ID", "");
        String strcancel = vars.getSessionValue("button7D8C0A256D514A11B056AF14AFF952DE.strcancel");
        String strProcessing = vars.getSessionValue("button7D8C0A256D514A11B056AF14AFF952DE.strProcessing");
        String strOrg = vars.getSessionValue("button7D8C0A256D514A11B056AF14AFF952DE.strOrg");
        String strClient = vars.getSessionValue("button7D8C0A256D514A11B056AF14AFF952DE.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCancel7D8C0A256D514A11B056AF14AFF952DE(response, vars, strZsfi_Macctline_ID, strcancel, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONCancel7D8C0A256D514A11B056AF14AFF952DE")) {
        String strZsfi_Macctline_ID = vars.getGlobalVariable("inpKey", windowId + "|Zsfi_Macctline_ID", "");
        @SuppressWarnings("unused")
        String strcancel = vars.getStringParameter("inpcancel");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "7D8C0A256D514A11B056AF14AFF952DE", (("Zsfi_Macctline_ID".equalsIgnoreCase("AD_Language"))?"0":strZsfi_Macctline_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
  String deleteRelation(VariablesSecureApp vars, String strZsfi_Macctline_ID, String strPZsfi_Manualacct_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strZsfi_Macctline_ID.startsWith("(")) strZsfi_Macctline_ID = strZsfi_Macctline_ID.substring(1, strZsfi_Macctline_ID.length()-1);
      if (!strZsfi_Macctline_ID.equals("")) {
        strZsfi_Macctline_ID = Replace.replace(strZsfi_Macctline_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strZsfi_Macctline_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (Lines5BC883ED6FC645D3B9E7EF231AEA2649Data.deleteTransactional(conn, this, strKey, strPZsfi_Manualacct_ID)==0) {
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
  private Lines5BC883ED6FC645D3B9E7EF231AEA2649Data getEditVariables(Connection con, VariablesSecureApp vars, String strPZsfi_Manualacct_ID) throws IOException,ServletException {
    Lines5BC883ED6FC645D3B9E7EF231AEA2649Data data = new Lines5BC883ED6FC645D3B9E7EF231AEA2649Data();
    ServletException ex = null;
    try {
    data.zsfiMacctlineId = vars.getRequestGlobalVariable("inpzsfiMacctlineId", windowId + "|Zsfi_Macctline_ID");     data.zsfiManualacctId = vars.getStringParameter("inpzsfiManualacctId");     data.zsfiManualacctIdr = vars.getStringParameter("inpzsfiManualacctId_R");    try {   data.line = vars.getNumericParameter("inpline");  } catch (ServletException paramEx) { ex = paramEx; }     data.acctdate = vars.getStringParameter("inpacctdate");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.acctcr = vars.getStringParameter("inpacctcr");     data.acctcrr = vars.getStringParameter("inpacctcr_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.acctdr = vars.getStringParameter("inpacctdr");     data.acctdrr = vars.getStringParameter("inpacctdr_R");    try {   data.amt = vars.getNumericParameter("inpamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.isdr2cr = vars.getStringParameter("inpisdr2cr", "N");     data.isgross = vars.getStringParameter("inpisgross", "N");     data.cTaxId = vars.getStringParameter("inpcTaxId");     data.cTaxIdr = vars.getStringParameter("inpcTaxId_R");     data.description = vars.getStringParameter("inpdescription");     data.aAssetId = vars.getStringParameter("inpaAssetId");     data.aAssetIdr = vars.getStringParameter("inpaAssetId_R");     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.glstatus = vars.getStringParameter("inpglstatus");     data.glstatusr = vars.getStringParameter("inpglstatus_R");     data.cancel = vars.getStringParameter("inpcancel");     data.processing = vars.getStringParameter("inpprocessing", "N");     data.cProjectphaseId = vars.getStringParameter("inpcProjectphaseId"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.zsfiManualacctId = vars.getGlobalVariable("inpzsfiManualacctId", windowId + "|Zsfi_Manualacct_ID");


    
    

    
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

   private Lines5BC883ED6FC645D3B9E7EF231AEA2649Data[] getRelationData(Lines5BC883ED6FC645D3B9E7EF231AEA2649Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].zsfiMacctlineId = FormatUtilities.truncate(data[i].zsfiMacctlineId, 32);        data[i].zsfiManualacctId = FormatUtilities.truncate(data[i].zsfiManualacctId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].acctcr = FormatUtilities.truncate(data[i].acctcr, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].acctdr = FormatUtilities.truncate(data[i].acctdr, 32);        data[i].cTaxId = FormatUtilities.truncate(data[i].cTaxId, 32);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, 32);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 32);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].glstatus = FormatUtilities.truncate(data[i].glstatus, 15);        data[i].cProjectphaseId = FormatUtilities.truncate(data[i].cProjectphaseId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPZsfi_Manualacct_ID) throws IOException,ServletException {
      GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data[] data = GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPZsfi_Manualacct_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Zsfi_Manualacct_ID", data[0].zsfiManualacctId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|Acctdate", data[0].acctdate);
      vars.setSessionValue(windowId + "|Zsfi_Manualacct_ID", strPZsfi_Manualacct_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strZsfi_Macctline_ID) throws ServletException {
    String strPZsfi_Manualacct_ID = Lines5BC883ED6FC645D3B9E7EF231AEA2649Data.selectParentID(this, strZsfi_Macctline_ID);
    if (strPZsfi_Manualacct_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strZsfi_Macctline_ID);
      throw new ServletException("Parent record not found");
    }
    return strPZsfi_Manualacct_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Zsfi_Macctline_ID", data[0].getField("zsfiMacctlineId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPZsfi_Manualacct_ID) throws IOException,ServletException {
      Lines5BC883ED6FC645D3B9E7EF231AEA2649Data[] data = Lines5BC883ED6FC645D3B9E7EF231AEA2649Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPZsfi_Manualacct_ID, vars.getStringParameter("inpzsfiMacctlineId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPZsfi_Manualacct_ID, String strZsfi_Macctline_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamZsfi_Macctline_ID = vars.getSessionValue(tabId + "|paramZsfi_Macctline_ID");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamZsfi_Macctline_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strZsfi_Macctline_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strZsfi_Macctline_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/finance/GLBatch/Lines5BC883ED6FC645D3B9E7EF231AEA2649_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Lines5BC883ED6FC645D3B9E7EF231AEA2649", false, "document.frmMain.inpzsfiMacctlineId", "grid", "..", "".equals("Y"), "GLBatch", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPZsfi_Manualacct_ID);

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
    xmlDocument.setParameter("KeyName", "zsfiMacctlineId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Lines5BC883ED6FC645D3B9E7EF231AEA2649_Relation.html", "GLBatch", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Lines5BC883ED6FC645D3B9E7EF231AEA2649_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", Lines5BC883ED6FC645D3B9E7EF231AEA2649Data.selectParent(this, strPZsfi_Manualacct_ID));
    else xmlDocument.setParameter("parent", Lines5BC883ED6FC645D3B9E7EF231AEA2649Data.selectParentTrl(this, strPZsfi_Manualacct_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strZsfi_Macctline_ID, String strPZsfi_Manualacct_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " line";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    Lines5BC883ED6FC645D3B9E7EF231AEA2649Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamZsfi_Macctline_ID = vars.getSessionValue(tabId + "|paramZsfi_Macctline_ID");

    boolean hasSearchCondition=false;
    if (!(strParamZsfi_Macctline_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = Lines5BC883ED6FC645D3B9E7EF231AEA2649Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPZsfi_Manualacct_ID, strZsfi_Macctline_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strZsfi_Macctline_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new Lines5BC883ED6FC645D3B9E7EF231AEA2649Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("zsfiMacctlineId") == null || dataField.getField("zsfiMacctlineId").equals("")) {
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
        refreshSessionNew(vars, strPZsfi_Manualacct_ID);
        data = Lines5BC883ED6FC645D3B9E7EF231AEA2649Data.set(strPZsfi_Manualacct_ID, Utility.getDefault(this, vars, "Isdr2cr", "Y", "A7AF6B7EA2A04616BACD889B62835E17", "5BC883ED6FC645D3B9E7EF231AEA2649", "N", dataField), Utility.getDefault(this, vars, "Description", "", "A7AF6B7EA2A04616BACD889B62835E17", "5BC883ED6FC645D3B9E7EF231AEA2649", "", dataField), "Y", Utility.getDefault(this, vars, "Createdby", "", "A7AF6B7EA2A04616BACD889B62835E17", "5BC883ED6FC645D3B9E7EF231AEA2649", "", dataField), Lines5BC883ED6FC645D3B9E7EF231AEA2649Data.selectDef9AF5C23B79C94B179EBFB567E84553B6_0(this, Utility.getDefault(this, vars, "Createdby", "", "A7AF6B7EA2A04616BACD889B62835E17", "5BC883ED6FC645D3B9E7EF231AEA2649", "", dataField)), Utility.getDefault(this, vars, "Isgross", "Y", "A7AF6B7EA2A04616BACD889B62835E17", "5BC883ED6FC645D3B9E7EF231AEA2649", "N", dataField), Utility.getDefault(this, vars, "Amt", "0", "A7AF6B7EA2A04616BACD889B62835E17", "5BC883ED6FC645D3B9E7EF231AEA2649", "", dataField), Utility.getDefault(this, vars, "Acctcr", "", "A7AF6B7EA2A04616BACD889B62835E17", "5BC883ED6FC645D3B9E7EF231AEA2649", "", dataField), "", Utility.getDefault(this, vars, "Cancel", "N", "A7AF6B7EA2A04616BACD889B62835E17", "5BC883ED6FC645D3B9E7EF231AEA2649", "N", dataField), Lines5BC883ED6FC645D3B9E7EF231AEA2649Data.selectDefA7918FD8CA9040A1919DD3A17E9B128F(this, strPZsfi_Manualacct_ID), Lines5BC883ED6FC645D3B9E7EF231AEA2649Data.selectDef582E7F472BE04A27BC7AD1D4711C284E(this, strPZsfi_Manualacct_ID), Utility.getDefault(this, vars, "C_Tax_ID", "", "A7AF6B7EA2A04616BACD889B62835E17", "5BC883ED6FC645D3B9E7EF231AEA2649", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "A7AF6B7EA2A04616BACD889B62835E17", "5BC883ED6FC645D3B9E7EF231AEA2649", "", dataField), Lines5BC883ED6FC645D3B9E7EF231AEA2649Data.selectDef9205C068E7444FE891B5A7A86C4384F8_1(this, Utility.getDefault(this, vars, "Updatedby", "", "A7AF6B7EA2A04616BACD889B62835E17", "5BC883ED6FC645D3B9E7EF231AEA2649", "", dataField)), Lines5BC883ED6FC645D3B9E7EF231AEA2649Data.selectDef6CA1EA8689424B18A0447B41F8DDF14E(this, strPZsfi_Manualacct_ID), Lines5BC883ED6FC645D3B9E7EF231AEA2649Data.selectDef37ED3A70E58949918FFC67ECE58F10BD(this, strPZsfi_Manualacct_ID), Utility.getDefault(this, vars, "Acctdr", "", "A7AF6B7EA2A04616BACD889B62835E17", "5BC883ED6FC645D3B9E7EF231AEA2649", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "A7AF6B7EA2A04616BACD889B62835E17", "5BC883ED6FC645D3B9E7EF231AEA2649", "", dataField), Utility.getDefault(this, vars, "Processing", "N", "A7AF6B7EA2A04616BACD889B62835E17", "5BC883ED6FC645D3B9E7EF231AEA2649", "N", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "A7AF6B7EA2A04616BACD889B62835E17", "5BC883ED6FC645D3B9E7EF231AEA2649", "", dataField), Utility.getDefault(this, vars, "Acctdate", "@Acctdate@", "A7AF6B7EA2A04616BACD889B62835E17", "5BC883ED6FC645D3B9E7EF231AEA2649", "", dataField), Utility.getDefault(this, vars, "Glstatus", "OP", "A7AF6B7EA2A04616BACD889B62835E17", "5BC883ED6FC645D3B9E7EF231AEA2649", "", dataField), Lines5BC883ED6FC645D3B9E7EF231AEA2649Data.selectDefEDED11C4C803480B9E751FA98AA97AA9(this, strPZsfi_Manualacct_ID));
        
      }
    } else {
      data = new Lines5BC883ED6FC645D3B9E7EF231AEA2649Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(Lines5BC883ED6FC645D3B9E7EF231AEA2649Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=GLBatchHeaderB67F4C4E5C064996B264A86E3622EF58Data.selectOrg(this, strPZsfi_Manualacct_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Lines5BC883ED6FC645D3B9E7EF231AEA2649", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpzsfiMacctlineId", "", "..", "".equals("Y"), "GLBatch", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strZsfi_Macctline_ID));
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
  
    void printPageButtonCancel7D8C0A256D514A11B056AF14AFF952DE(HttpServletResponse response, VariablesSecureApp vars, String strZsfi_Macctline_ID, String strcancel, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "7D8C0A256D514A11B056AF14AFF952DE",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "7D8C0A256D514A11B056AF14AFF952DE" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"7D8C0A256D514A11B056AF14AFF952DE" );
        String isDocAction=UtilsData.isProcessDocAction(this, "7D8C0A256D514A11B056AF14AFF952DE");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "4AF9D81E51A04F2B987CD91AA9EE99F4",strZsfi_Macctline_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "4AF9D81E51A04F2B987CD91AA9EE99F4", strZsfi_Macctline_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strcancel, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "7D8C0A256D514A11B056AF14AFF952DE");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONCancel" + "7D8C0A256D514A11B056AF14AFF952DE" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","Lines5BC883ED6FC645D3B9E7EF231AEA2649_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "7D8C0A256D514A11B056AF14AFF952DE");
        script.addHiddenfield("inpKey",strZsfi_Macctline_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("7D8C0A256D514A11B056AF14AFF952DE");
        vars.removeMessage("7D8C0A256D514A11B056AF14AFF952DE");
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPZsfi_Manualacct_ID) throws IOException, ServletException {
    Lines5BC883ED6FC645D3B9E7EF231AEA2649Data data = null;
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
            data = getEditVariables(con, vars, strPZsfi_Manualacct_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.zsfiMacctlineId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (Lines5BC883ED6FC645D3B9E7EF231AEA2649Data.getCurrentDBTimestamp(this, data.zsfiMacctlineId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.zsfiMacctlineId, vars, this);
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
                    data.zsfiMacctlineId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Zsfi_Macctline_ID", data.zsfiMacctlineId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Lines5BC883ED6FC645D3B9E7EF231AEA2649. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
