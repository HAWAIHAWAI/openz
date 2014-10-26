
package org.openbravo.erpWindows.BusinessPartnerCategory;


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

public class Accounting extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Accounting.class);
  
  private static final String windowId = "192";
  private static final String tabId = "323";
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
        String strcBpGroupAcctId = request.getParameter("inpcBpGroupAcctId");
         String strPC_BP_Group_ID = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcBpGroupAcctId.equals(""))
              total = saveRecord(vars, myError, 'U', strPC_BP_Group_ID);
          else
              total = saveRecord(vars, myError, 'I', strPC_BP_Group_ID);
          
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
      String strPC_BP_Group_ID = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID", "");

      String strC_Bp_Group_Acct_ID = vars.getGlobalVariable("inpcBpGroupAcctId", windowId + "|C_Bp_Group_Acct_ID", "");
            if (strPC_BP_Group_ID.equals("")) {
        strPC_BP_Group_ID = getParentID(vars, strC_Bp_Group_Acct_ID);
        if (strPC_BP_Group_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_BP_Group_ID");
        vars.setSessionValue(windowId + "|C_BP_Group_ID", strPC_BP_Group_ID);

        refreshParentSession(vars, strPC_BP_Group_ID);
      }


      String strView = vars.getSessionValue(tabId + "|Accounting.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_Bp_Group_Acct_ID.equals("")) strC_Bp_Group_Acct_ID = firstElement(vars, tableSQL);
          if (strC_Bp_Group_Acct_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Bp_Group_Acct_ID, strPC_BP_Group_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_BP_Group_ID, strC_Bp_Group_Acct_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_Bp_Group_Acct_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_Bp_Group_Acct_ID.equals("")) strC_Bp_Group_Acct_ID = vars.getRequiredGlobalVariable("inpcBpGroupAcctId", windowId + "|C_Bp_Group_Acct_ID");
      else vars.setSessionValue(windowId + "|C_Bp_Group_Acct_ID", strC_Bp_Group_Acct_ID);
      
      
      String strPC_BP_Group_ID = getParentID(vars, strC_Bp_Group_Acct_ID);
      
      vars.setSessionValue(windowId + "|C_BP_Group_ID", strPC_BP_Group_ID);
      vars.setSessionValue("322|Business Partner Category.view", "EDIT");

      refreshParentSession(vars, strPC_BP_Group_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Accounting.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_Bp_Group_Acct_ID, strPC_BP_Group_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Accounting.view", "RELATION");
        printPageDataSheet(response, vars, strPC_BP_Group_ID, strC_Bp_Group_Acct_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_BP_Group_ID = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|C_Bp_Group_Acct_ID");
      refreshParentSession(vars, strPC_BP_Group_ID);


      String strView = vars.getSessionValue(tabId + "|Accounting.view");
      String strC_Bp_Group_Acct_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_Bp_Group_Acct_ID = firstElement(vars, tableSQL);
          if (strC_Bp_Group_Acct_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_Bp_Group_Acct_ID.equals("")) strC_Bp_Group_Acct_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_Bp_Group_Acct_ID, strPC_BP_Group_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_BP_Group_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamC_BP_Group_ID", tabId + "|paramC_BP_Group_ID");

            String strPC_BP_Group_ID = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");

      
      vars.removeSessionValue(windowId + "|C_Bp_Group_Acct_ID");
      String strC_Bp_Group_Acct_ID="";

      String strView = vars.getSessionValue(tabId + "|Accounting.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_Bp_Group_Acct_ID = firstElement(vars, tableSQL);
        if (strC_Bp_Group_Acct_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Accounting.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Bp_Group_Acct_ID, strPC_BP_Group_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_BP_Group_ID, strC_Bp_Group_Acct_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_BP_Group_ID = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");
      

      String strC_Bp_Group_Acct_ID = vars.getGlobalVariable("inpcBpGroupAcctId", windowId + "|C_Bp_Group_Acct_ID", "");
      vars.setSessionValue(tabId + "|Accounting.view", "RELATION");
      printPageDataSheet(response, vars, strPC_BP_Group_ID, strC_Bp_Group_Acct_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_BP_Group_ID = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");


      printPageEdit(response, request, vars, true, "", strPC_BP_Group_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_BP_Group_ID = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_Bp_Group_Acct_ID = vars.getGlobalVariable("inpcBpGroupAcctId", windowId + "|C_Bp_Group_Acct_ID", "");
      vars.setSessionValue(tabId + "|Accounting.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_Bp_Group_Acct_ID, strPC_BP_Group_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_BP_Group_ID = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");
      String strC_Bp_Group_Acct_ID = vars.getRequiredStringParameter("inpcBpGroupAcctId");
      
      String strNext = nextElement(vars, strC_Bp_Group_Acct_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_BP_Group_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_BP_Group_ID = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");
      String strC_Bp_Group_Acct_ID = vars.getRequiredStringParameter("inpcBpGroupAcctId");
      
      String strPrevious = previousElement(vars, strC_Bp_Group_Acct_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_BP_Group_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");

      vars.setSessionValue(tabId + "|Accounting.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_BP_Group_ID = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Accounting.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Accounting.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Accounting.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_Bp_Group_Acct_ID");
      vars.setSessionValue(windowId + "|C_BP_Group_ID", strPC_BP_Group_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_BP_Group_ID = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Accounting.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Accounting.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_Bp_Group_Acct_ID");
      vars.setSessionValue(windowId + "|C_BP_Group_ID", strPC_BP_Group_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPC_BP_Group_ID = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPC_BP_Group_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPC_BP_Group_ID = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPC_BP_Group_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPC_BP_Group_ID = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPC_BP_Group_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPC_BP_Group_ID = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPC_BP_Group_ID);      
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
      String strPC_BP_Group_ID = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");
      String strC_Bp_Group_Acct_ID = vars.getRequiredGlobalVariable("inpcBpGroupAcctId", windowId + "|C_Bp_Group_Acct_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPC_BP_Group_ID);      
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
          String strNext = nextElement(vars, strC_Bp_Group_Acct_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_Bp_Group_Acct_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPC_BP_Group_ID = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");

      String strC_Bp_Group_Acct_ID = vars.getRequiredInStringParameter("inpcBpGroupAcctId");
      String message = deleteRelation(vars, strC_Bp_Group_Acct_ID, strPC_BP_Group_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cBpGroupAcctId");
        vars.setSessionValue(tabId + "|Accounting.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPC_BP_Group_ID = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");

      String strC_Bp_Group_Acct_ID = vars.getRequiredStringParameter("inpcBpGroupAcctId");
      //AccountingData data = getEditVariables(vars, strPC_BP_Group_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = AccountingData.delete(this, strC_Bp_Group_Acct_ID, strPC_BP_Group_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cBpGroupAcctId");
        vars.setSessionValue(tabId + "|Accounting.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONProcessing112")) {
        vars.setSessionValue("button112.strprocessing", vars.getStringParameter("inpprocessing"));
        vars.setSessionValue("button112.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button112.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button112.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        p.put("AD_Org_ID", vars.getStringParameter("inpadOrgId"));

        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button112.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "112", request.getServletPath());    
     } else if (vars.commandIn("BUTTON112")) {
        String strC_Bp_Group_Acct_ID = vars.getGlobalVariable("inpcBpGroupAcctId", windowId + "|C_Bp_Group_Acct_ID", "");
        String strprocessing = vars.getSessionValue("button112.strprocessing");
        String strProcessing = vars.getSessionValue("button112.strProcessing");
        String strOrg = vars.getSessionValue("button112.strOrg");
        String strClient = vars.getSessionValue("button112.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessing112(response, vars, strC_Bp_Group_Acct_ID, strprocessing, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcessing112")) {
        String strC_Bp_Group_Acct_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Bp_Group_Acct_ID", "");
        @SuppressWarnings("unused")
        String strprocessing = vars.getStringParameter("inpprocessing");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "112", (("C_Bp_Group_Acct_ID".equalsIgnoreCase("AD_Language"))?"0":strC_Bp_Group_Acct_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strcBpGroupId = vars.getStringParameter("inpcBpGroupId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_BP_Group_ID", strcBpGroupId, vars.getClient(), vars.getOrg(), vars.getUser());
String strcAcctschemaId = vars.getStringParameter("inpcAcctschemaId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "C_AcctSchema_ID", strcAcctschemaId, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
  String deleteRelation(VariablesSecureApp vars, String strC_Bp_Group_Acct_ID, String strPC_BP_Group_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_Bp_Group_Acct_ID.startsWith("(")) strC_Bp_Group_Acct_ID = strC_Bp_Group_Acct_ID.substring(1, strC_Bp_Group_Acct_ID.length()-1);
      if (!strC_Bp_Group_Acct_ID.equals("")) {
        strC_Bp_Group_Acct_ID = Replace.replace(strC_Bp_Group_Acct_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_Bp_Group_Acct_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (AccountingData.deleteTransactional(conn, this, strKey, strPC_BP_Group_ID)==0) {
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
  private AccountingData getEditVariables(Connection con, VariablesSecureApp vars, String strPC_BP_Group_ID) throws IOException,ServletException {
    AccountingData data = new AccountingData();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.cBpGroupId = vars.getRequestGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");     data.cBpGroupIdr = vars.getStringParameter("inpcBpGroupId_R");     data.cAcctschemaId = vars.getRequestGlobalVariable("inpcAcctschemaId", windowId + "|C_AcctSchema_ID");     data.cAcctschemaIdr = vars.getStringParameter("inpcAcctschemaId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.cReceivableAcct = vars.getStringParameter("inpcReceivableAcct");     data.cReceivableAcctr = vars.getStringParameter("inpcReceivableAcct_R");     data.cPrepaymentAcct = vars.getStringParameter("inpcPrepaymentAcct");     data.paydiscountExpAcct = vars.getStringParameter("inppaydiscountExpAcct");     data.writeoffAcct = vars.getStringParameter("inpwriteoffAcct");     data.writeoffAcctr = vars.getStringParameter("inpwriteoffAcct_R");     data.notinvoicedreceivablesAcct = vars.getStringParameter("inpnotinvoicedreceivablesAcct");     data.notinvoicedrevenueAcct = vars.getStringParameter("inpnotinvoicedrevenueAcct");     data.unearnedrevenueAcct = vars.getStringParameter("inpunearnedrevenueAcct");     data.vLiabilityAcct = vars.getStringParameter("inpvLiabilityAcct");     data.vLiabilityAcctr = vars.getStringParameter("inpvLiabilityAcct_R");     data.vLiabilityServicesAcct = vars.getStringParameter("inpvLiabilityServicesAcct");     data.vPrepaymentAcct = vars.getStringParameter("inpvPrepaymentAcct");     data.paydiscountRevAcct = vars.getStringParameter("inppaydiscountRevAcct");     data.notinvoicedreceiptsAcct = vars.getStringParameter("inpnotinvoicedreceiptsAcct");     data.notinvoicedreceiptsAcctr = vars.getStringParameter("inpnotinvoicedreceiptsAcct_R");     data.unrealizedgainAcct = vars.getStringParameter("inpunrealizedgainAcct");     data.unrealizedlossAcct = vars.getStringParameter("inpunrealizedlossAcct");     data.realizedgainAcct = vars.getStringParameter("inprealizedgainAcct");     data.realizedlossAcct = vars.getStringParameter("inprealizedlossAcct");     data.processing = vars.getStringParameter("inpprocessing");     data.status = vars.getStringParameter("inpstatus");     data.cBpGroupAcctId = vars.getRequestGlobalVariable("inpcBpGroupAcctId", windowId + "|C_Bp_Group_Acct_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cBpGroupId = vars.getGlobalVariable("inpcBpGroupId", windowId + "|C_BP_Group_ID");


    
    

    
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

   private AccountingData[] getRelationData(AccountingData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].cBpGroupId = FormatUtilities.truncate(data[i].cBpGroupId, 44);        data[i].cAcctschemaId = FormatUtilities.truncate(data[i].cAcctschemaId, 44);        data[i].cReceivableAcct = FormatUtilities.truncate(data[i].cReceivableAcct, 44);        data[i].cPrepaymentAcct = FormatUtilities.truncate(data[i].cPrepaymentAcct, 44);        data[i].paydiscountExpAcct = FormatUtilities.truncate(data[i].paydiscountExpAcct, 44);        data[i].writeoffAcct = FormatUtilities.truncate(data[i].writeoffAcct, 44);        data[i].notinvoicedreceivablesAcct = FormatUtilities.truncate(data[i].notinvoicedreceivablesAcct, 44);        data[i].notinvoicedrevenueAcct = FormatUtilities.truncate(data[i].notinvoicedrevenueAcct, 44);        data[i].unearnedrevenueAcct = FormatUtilities.truncate(data[i].unearnedrevenueAcct, 44);        data[i].vLiabilityAcct = FormatUtilities.truncate(data[i].vLiabilityAcct, 44);        data[i].vLiabilityServicesAcct = FormatUtilities.truncate(data[i].vLiabilityServicesAcct, 44);        data[i].vPrepaymentAcct = FormatUtilities.truncate(data[i].vPrepaymentAcct, 44);        data[i].paydiscountRevAcct = FormatUtilities.truncate(data[i].paydiscountRevAcct, 44);        data[i].notinvoicedreceiptsAcct = FormatUtilities.truncate(data[i].notinvoicedreceiptsAcct, 44);        data[i].unrealizedgainAcct = FormatUtilities.truncate(data[i].unrealizedgainAcct, 44);        data[i].unrealizedlossAcct = FormatUtilities.truncate(data[i].unrealizedlossAcct, 44);        data[i].realizedgainAcct = FormatUtilities.truncate(data[i].realizedgainAcct, 44);        data[i].realizedlossAcct = FormatUtilities.truncate(data[i].realizedlossAcct, 44);        data[i].status = FormatUtilities.truncate(data[i].status, 21);        data[i].cBpGroupAcctId = FormatUtilities.truncate(data[i].cBpGroupAcctId, 10);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPC_BP_Group_ID) throws IOException,ServletException {
      BusinessPartnerCategoryData[] data = BusinessPartnerCategoryData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_BP_Group_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|C_BP_Group_ID", data[0].cBpGroupId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);
      vars.setSessionValue(windowId + "|C_BP_Group_ID", strPC_BP_Group_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strC_Bp_Group_Acct_ID) throws ServletException {
    String strPC_BP_Group_ID = AccountingData.selectParentID(this, strC_Bp_Group_Acct_ID);
    if (strPC_BP_Group_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strC_Bp_Group_Acct_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_BP_Group_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|C_BP_Group_ID", data[0].getField("cBpGroupId"));    vars.setSessionValue(windowId + "|C_AcctSchema_ID", data[0].getField("cAcctschemaId"));    vars.setSessionValue(windowId + "|C_Bp_Group_Acct_ID", data[0].getField("cBpGroupAcctId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_BP_Group_ID) throws IOException,ServletException {
      AccountingData[] data = AccountingData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_BP_Group_ID, vars.getStringParameter("inpcBpGroupAcctId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_BP_Group_ID, String strC_Bp_Group_Acct_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamC_BP_Group_ID = vars.getSessionValue(tabId + "|paramC_BP_Group_ID");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamC_BP_Group_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_Bp_Group_Acct_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_Bp_Group_Acct_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/BusinessPartnerCategory/Accounting_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Accounting", false, "document.frmMain.inpcBpGroupAcctId", "grid", "..", "".equals("Y"), "BusinessPartnerCategory", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPC_BP_Group_ID);

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
    xmlDocument.setParameter("KeyName", "cBpGroupAcctId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Accounting_Relation.html", "BusinessPartnerCategory", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Accounting_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", AccountingData.selectParent(this, strPC_BP_Group_ID));
    else xmlDocument.setParameter("parent", AccountingData.selectParentTrl(this, strPC_BP_Group_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_Bp_Group_Acct_ID, String strPC_BP_Group_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = "  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') )";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    AccountingData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamC_BP_Group_ID = vars.getSessionValue(tabId + "|paramC_BP_Group_ID");

    boolean hasSearchCondition=false;
    if (!(strParamC_BP_Group_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = AccountingData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_BP_Group_ID, strC_Bp_Group_Acct_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_Bp_Group_Acct_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new AccountingData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cBpGroupAcctId") == null || dataField.getField("cBpGroupAcctId").equals("")) {
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
        refreshSessionNew(vars, strPC_BP_Group_ID);
        data = AccountingData.set(strPC_BP_Group_ID, Utility.getDefault(this, vars, "Processing", "", "192", "323", "N", dataField), Utility.getDefault(this, vars, "RealizedLoss_Acct", "", "192", "323", "", dataField), AccountingData.selectDef4995_0(this, Utility.getDefault(this, vars, "RealizedLoss_Acct", "", "192", "323", "", dataField)), Utility.getDefault(this, vars, "RealizedGain_Acct", "", "192", "323", "", dataField), AccountingData.selectDef4994_1(this, Utility.getDefault(this, vars, "RealizedGain_Acct", "", "192", "323", "", dataField)), Utility.getDefault(this, vars, "V_Prepayment_Acct", "", "192", "323", "", dataField), AccountingData.selectDef4987_2(this, Utility.getDefault(this, vars, "V_Prepayment_Acct", "", "192", "323", "", dataField)), Utility.getDefault(this, vars, "NotInvoicedReceipts_Acct", "", "192", "323", "", dataField), AccountingData.selectDef4996_3(this, Utility.getDefault(this, vars, "NotInvoicedReceipts_Acct", "", "192", "323", "", dataField)), "", Utility.getDefault(this, vars, "C_Receivable_Acct", "", "192", "323", "", dataField), AccountingData.selectDef4982_4(this, Utility.getDefault(this, vars, "C_Receivable_Acct", "", "192", "323", "", dataField)), Utility.getDefault(this, vars, "NotInvoicedReceivables_Acct", "", "192", "323", "", dataField), AccountingData.selectDef4999_5(this, Utility.getDefault(this, vars, "NotInvoicedReceivables_Acct", "", "192", "323", "", dataField)), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "192", "323", "", dataField), Utility.getDefault(this, vars, "C_AcctSchema_ID", "", "192", "323", "", dataField), Utility.getDefault(this, vars, "C_Prepayment_Acct", "", "192", "323", "", dataField), AccountingData.selectDef4983_6(this, Utility.getDefault(this, vars, "C_Prepayment_Acct", "", "192", "323", "", dataField)), Utility.getDefault(this, vars, "V_Liability_Services_Acct", "", "192", "323", "", dataField), AccountingData.selectDef4986_7(this, Utility.getDefault(this, vars, "V_Liability_Services_Acct", "", "192", "323", "", dataField)), Utility.getDefault(this, vars, "WriteOff_Acct", "", "192", "323", "", dataField), AccountingData.selectDef4990_8(this, Utility.getDefault(this, vars, "WriteOff_Acct", "", "192", "323", "", dataField)), Utility.getDefault(this, vars, "Status", "", "192", "323", "", dataField), Utility.getDefault(this, vars, "UnrealizedLoss_Acct", "", "192", "323", "", dataField), AccountingData.selectDef4993_9(this, Utility.getDefault(this, vars, "UnrealizedLoss_Acct", "", "192", "323", "", dataField)), Utility.getDefault(this, vars, "PayDiscount_Exp_Acct", "", "192", "323", "", dataField), AccountingData.selectDef4988_10(this, Utility.getDefault(this, vars, "PayDiscount_Exp_Acct", "", "192", "323", "", dataField)), Utility.getDefault(this, vars, "UnEarnedRevenue_Acct", "", "192", "323", "", dataField), AccountingData.selectDef4997_11(this, Utility.getDefault(this, vars, "UnEarnedRevenue_Acct", "", "192", "323", "", dataField)), Utility.getDefault(this, vars, "UpdatedBy", "", "192", "323", "", dataField), AccountingData.selectDef4981_12(this, Utility.getDefault(this, vars, "UpdatedBy", "", "192", "323", "", dataField)), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "192", "323", "", dataField), Utility.getDefault(this, vars, "UnrealizedGain_Acct", "", "192", "323", "", dataField), AccountingData.selectDef4992_13(this, Utility.getDefault(this, vars, "UnrealizedGain_Acct", "", "192", "323", "", dataField)), "Y", Utility.getDefault(this, vars, "NotInvoicedRevenue_Acct", "", "192", "323", "", dataField), AccountingData.selectDef4998_14(this, Utility.getDefault(this, vars, "NotInvoicedRevenue_Acct", "", "192", "323", "", dataField)), Utility.getDefault(this, vars, "PayDiscount_Rev_Acct", "", "192", "323", "", dataField), AccountingData.selectDef4989_15(this, Utility.getDefault(this, vars, "PayDiscount_Rev_Acct", "", "192", "323", "", dataField)), Utility.getDefault(this, vars, "V_Liability_Acct", "", "192", "323", "", dataField), AccountingData.selectDef4985_16(this, Utility.getDefault(this, vars, "V_Liability_Acct", "", "192", "323", "", dataField)), Utility.getDefault(this, vars, "CreatedBy", "", "192", "323", "", dataField), AccountingData.selectDef4979_17(this, Utility.getDefault(this, vars, "CreatedBy", "", "192", "323", "", dataField)));
        
      }
    } else {
      data = new AccountingData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(AccountingData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=BusinessPartnerCategoryData.selectOrg(this, strPC_BP_Group_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Accounting", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcBpGroupAcctId", "", "..", "".equals("Y"), "BusinessPartnerCategory", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_Bp_Group_Acct_ID));
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
  
    void printPageButtonProcessing112(HttpServletResponse response, VariablesSecureApp vars, String strC_Bp_Group_Acct_ID, String strprocessing, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "112",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "112" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"112" );
        String isDocAction=UtilsData.isProcessDocAction(this, "112");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "395",strC_Bp_Group_Acct_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "395", strC_Bp_Group_Acct_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strprocessing, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "112");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONProcessing" + "112" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","Accounting_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "112");
        script.addHiddenfield("inpKey",strC_Bp_Group_Acct_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("112");
        vars.removeMessage("112");
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPC_BP_Group_ID) throws IOException, ServletException {
    AccountingData data = null;
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
            data = getEditVariables(con, vars, strPC_BP_Group_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.cBpGroupAcctId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (AccountingData.getCurrentDBTimestamp(this, data.cBpGroupAcctId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cBpGroupAcctId, vars, this);
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
                    data.cBpGroupAcctId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_Bp_Group_Acct_ID", data.cBpGroupAcctId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Accounting. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
