
package org.openbravo.erpWindows.SalesOrder;


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

public class SubscriptionIntervals extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(SubscriptionIntervals.class);
  
  private static final String windowId = "143";
  private static final String tabId = "8A541CF5111C4654809F092C675EAC04";
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
        String strcSubscriptionintervalViewId = request.getParameter("inpcSubscriptionintervalViewId");
         String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcSubscriptionintervalViewId.equals(""))
              total = saveRecord(vars, myError, 'U', strPC_Order_ID);
          else
              total = saveRecord(vars, myError, 'I', strPC_Order_ID);
          
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
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");

      String strC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID", "");
            if (strPC_Order_ID.equals("")) {
        strPC_Order_ID = getParentID(vars, strC_Subscriptioninterval_View_ID);
        if (strPC_Order_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_Order_ID");
        vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);

        refreshParentSession(vars, strPC_Order_ID);
      }


      String strView = vars.getSessionValue(tabId + "|SubscriptionIntervals.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_Subscriptioninterval_View_ID.equals("")) strC_Subscriptioninterval_View_ID = firstElement(vars, tableSQL);
          if (strC_Subscriptioninterval_View_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Subscriptioninterval_View_ID, strPC_Order_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Order_ID, strC_Subscriptioninterval_View_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_Subscriptioninterval_View_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_Subscriptioninterval_View_ID.equals("")) strC_Subscriptioninterval_View_ID = vars.getRequiredGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");
      else vars.setSessionValue(windowId + "|C_Subscriptioninterval_View_ID", strC_Subscriptioninterval_View_ID);
      
      
      String strPC_Order_ID = getParentID(vars, strC_Subscriptioninterval_View_ID);
      
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);
      vars.setSessionValue("186|Header.view", "EDIT");

      refreshParentSession(vars, strPC_Order_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|SubscriptionIntervals.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_Subscriptioninterval_View_ID, strPC_Order_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|SubscriptionIntervals.view", "RELATION");
        printPageDataSheet(response, vars, strPC_Order_ID, strC_Subscriptioninterval_View_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|C_Subscriptioninterval_View_ID");
      refreshParentSession(vars, strPC_Order_ID);


      String strView = vars.getSessionValue(tabId + "|SubscriptionIntervals.view");
      String strC_Subscriptioninterval_View_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_Subscriptioninterval_View_ID = firstElement(vars, tableSQL);
          if (strC_Subscriptioninterval_View_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_Subscriptioninterval_View_ID.equals("")) strC_Subscriptioninterval_View_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_Subscriptioninterval_View_ID, strPC_Order_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_Order_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamAD_Org_ID", tabId + "|paramAD_Org_ID");
vars.getRequestGlobalVariable("inpParamDocumentno", tabId + "|paramDocumentno");
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamPoreference", tabId + "|paramPoreference");
vars.getRequestGlobalVariable("inpParamDateordered", tabId + "|paramDateordered");
vars.getRequestGlobalVariable("inpParamC_Bpartner_ID", tabId + "|paramC_Bpartner_ID");
vars.getRequestGlobalVariable("inpParambpzipcode", tabId + "|parambpzipcode");
vars.getRequestGlobalVariable("inpParamC_Project_ID", tabId + "|paramC_Project_ID");
vars.getRequestGlobalVariable("inpParamA_Asset_ID", tabId + "|paramA_Asset_ID");
vars.getRequestGlobalVariable("inpParamSalesrep_ID", tabId + "|paramSalesrep_ID");
vars.getRequestGlobalVariable("inpParamGrandtotal", tabId + "|paramGrandtotal");
vars.getRequestGlobalVariable("inpParamInvoicerule", tabId + "|paramInvoicerule");
vars.getRequestGlobalVariable("inpParamDatepromised", tabId + "|paramDatepromised");
vars.getRequestGlobalVariable("inpParamC_Doctype_ID", tabId + "|paramC_Doctype_ID");
vars.getRequestGlobalVariable("inpParamDocstatus", tabId + "|paramDocstatus");
vars.getRequestGlobalVariable("inpParamProposalstatus", tabId + "|paramProposalstatus");
vars.getRequestGlobalVariable("inpParamDateordered_f", tabId + "|paramDateordered_f");
vars.getRequestGlobalVariable("inpParamGrandtotal_f", tabId + "|paramGrandtotal_f");
vars.getRequestGlobalVariable("inpParamDatepromised_f", tabId + "|paramDatepromised_f");

            String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      
      vars.removeSessionValue(windowId + "|C_Subscriptioninterval_View_ID");
      String strC_Subscriptioninterval_View_ID="";

      String strView = vars.getSessionValue(tabId + "|SubscriptionIntervals.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_Subscriptioninterval_View_ID = firstElement(vars, tableSQL);
        if (strC_Subscriptioninterval_View_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|SubscriptionIntervals.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Subscriptioninterval_View_ID, strPC_Order_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Order_ID, strC_Subscriptioninterval_View_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      

      String strC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID", "");
      vars.setSessionValue(tabId + "|SubscriptionIntervals.view", "RELATION");
      printPageDataSheet(response, vars, strPC_Order_ID, strC_Subscriptioninterval_View_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");


      printPageEdit(response, request, vars, true, "", strPC_Order_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID", "");
      vars.setSessionValue(tabId + "|SubscriptionIntervals.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_Subscriptioninterval_View_ID, strPC_Order_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      String strC_Subscriptioninterval_View_ID = vars.getRequiredStringParameter("inpcSubscriptionintervalViewId");
      
      String strNext = nextElement(vars, strC_Subscriptioninterval_View_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      String strC_Subscriptioninterval_View_ID = vars.getRequiredStringParameter("inpcSubscriptionintervalViewId");
      
      String strPrevious = previousElement(vars, strC_Subscriptioninterval_View_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      vars.setSessionValue(tabId + "|SubscriptionIntervals.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|SubscriptionIntervals.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|SubscriptionIntervals.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|SubscriptionIntervals.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_Subscriptioninterval_View_ID");
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|SubscriptionIntervals.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|SubscriptionIntervals.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_Subscriptioninterval_View_ID");
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPC_Order_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPC_Order_ID);      
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
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      String strC_Subscriptioninterval_View_ID = vars.getRequiredGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPC_Order_ID);      
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
          String strNext = nextElement(vars, strC_Subscriptioninterval_View_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_Subscriptioninterval_View_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strC_Subscriptioninterval_View_ID = vars.getRequiredInStringParameter("inpcSubscriptionintervalViewId");
      String message = deleteRelation(vars, strC_Subscriptioninterval_View_ID, strPC_Order_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cSubscriptionintervalViewId");
        vars.setSessionValue(tabId + "|SubscriptionIntervals.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strC_Subscriptioninterval_View_ID = vars.getRequiredStringParameter("inpcSubscriptionintervalViewId");
      //SubscriptionIntervalsData data = getEditVariables(vars, strPC_Order_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = SubscriptionIntervalsData.delete(this, strC_Subscriptioninterval_View_ID, strPC_Order_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cSubscriptionintervalViewId");
        vars.setSessionValue(tabId + "|SubscriptionIntervals.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONDocAction104")) {
        vars.setSessionValue("button104.strdocaction", vars.getStringParameter("inpdocaction"));
        vars.setSessionValue("button104.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button104.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button104.strClient", vars.getStringParameter("inpadClientId"));
        vars.setSessionValue("button104.inpdocstatus", vars.getRequiredStringParameter("inpdocstatus"));

        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button104.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "104", request.getServletPath());    
     } else if (vars.commandIn("BUTTON104")) {
        String strC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID", "");
        String strdocaction = vars.getSessionValue("button104.strdocaction");
        String strProcessing = vars.getSessionValue("button104.strProcessing");
        String strOrg = vars.getSessionValue("button104.strOrg");
        String strClient = vars.getSessionValue("button104.strClient");
        
        String strdocstatus = vars.getSessionValue("button104.inpdocstatus");
String stradTableId = "E5A34E9B2AE84350B2B1E5A3FE61EFBA";

        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonDocAction104(response, vars, strC_Subscriptioninterval_View_ID, strdocaction, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONDocAction104")) {
        String strC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Subscriptioninterval_View_ID", "");
        @SuppressWarnings("unused")
        String strdocaction = vars.getStringParameter("inpdocaction");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "104", (("C_Subscriptioninterval_View_ID".equalsIgnoreCase("AD_Language"))?"0":strC_Subscriptioninterval_View_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          SubscriptionIntervalsData.updateDocAction(this, strdocaction, strC_Subscriptioninterval_View_ID);

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
  String deleteRelation(VariablesSecureApp vars, String strC_Subscriptioninterval_View_ID, String strPC_Order_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_Subscriptioninterval_View_ID.startsWith("(")) strC_Subscriptioninterval_View_ID = strC_Subscriptioninterval_View_ID.substring(1, strC_Subscriptioninterval_View_ID.length()-1);
      if (!strC_Subscriptioninterval_View_ID.equals("")) {
        strC_Subscriptioninterval_View_ID = Replace.replace(strC_Subscriptioninterval_View_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_Subscriptioninterval_View_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (SubscriptionIntervalsData.deleteTransactional(conn, this, strKey, strPC_Order_ID)==0) {
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
  private SubscriptionIntervalsData getEditVariables(Connection con, VariablesSecureApp vars, String strPC_Order_ID) throws IOException,ServletException {
    SubscriptionIntervalsData data = new SubscriptionIntervalsData();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.cSubscriptionintervalViewId = vars.getRequestGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.documentno = vars.getStringParameter("inpdocumentno");     data.poreference = vars.getStringParameter("inpporeference");     data.dateordered = vars.getRequestGlobalVariable("inpdateordered", windowId + "|Dateordered");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.cDoctypetargetId = vars.getRequestGlobalVariable("inpcDoctypetargetId", windowId + "|C_Doctypetarget_ID");     data.cDoctypetargetIdr = vars.getStringParameter("inpcDoctypetargetId_R");     data.aAssetId = vars.getStringParameter("inpaAssetId");     data.name = vars.getStringParameter("inpname");     data.cDoctypeId = vars.getRequestGlobalVariable("inpcDoctypeId", windowId + "|C_Doctype_ID");     data.cDoctypeIdr = vars.getStringParameter("inpcDoctypeId_R");     data.docstatus = vars.getStringParameter("inpdocstatus");     data.docstatusr = vars.getStringParameter("inpdocstatus_R");     data.description = vars.getStringParameter("inpdescription");     data.deliverynotes = vars.getStringParameter("inpdeliverynotes");     data.internalnote = vars.getStringParameter("inpinternalnote");     data.cBpartnerId = vars.getRequestGlobalVariable("inpcBpartnerId", windowId + "|C_Bpartner_ID");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.bpzipcode = vars.getStringParameter("inpbpzipcode");     data.billtoId = vars.getStringParameter("inpbilltoId");     data.billtoIdr = vars.getStringParameter("inpbilltoId_R");     data.cBpartnerLocationId = vars.getRequestGlobalVariable("inpcBpartnerLocationId", windowId + "|C_Bpartner_Location_ID");     data.cBpartnerLocationIdr = vars.getStringParameter("inpcBpartnerLocationId_R");     data.adUserId = vars.getStringParameter("inpadUserId");     data.adUserIdr = vars.getStringParameter("inpadUserId_R");     data.salesrepId = vars.getStringParameter("inpsalesrepId");     data.salesrepIdr = vars.getStringParameter("inpsalesrepId_R");     data.mPricelistId = vars.getRequestGlobalVariable("inpmPricelistId", windowId + "|M_Pricelist_ID");     data.mPricelistIdr = vars.getStringParameter("inpmPricelistId_R");     data.isdiscountprinted = vars.getStringParameter("inpisdiscountprinted", "N");     data.invoicerule = vars.getStringParameter("inpinvoicerule");     data.invoiceruler = vars.getStringParameter("inpinvoicerule_R");     data.estpropability = vars.getStringParameter("inpestpropability");     data.estpropabilityr = vars.getStringParameter("inpestpropability_R");     data.mWarehouseId = vars.getRequestGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");     data.mWarehouseIdr = vars.getStringParameter("inpmWarehouseId_R");     data.cCurrencyId = vars.getRequestGlobalVariable("inpcCurrencyId", windowId + "|C_Currency_ID");     data.cCurrencyIdr = vars.getStringParameter("inpcCurrencyId_R");     data.deliveryrule = vars.getStringParameter("inpdeliveryrule");     data.deliveryruler = vars.getStringParameter("inpdeliveryrule_R");     data.priorityrule = vars.getStringParameter("inppriorityrule");     data.priorityruler = vars.getStringParameter("inppriorityrule_R");     data.paymentrule = vars.getStringParameter("inppaymentrule");     data.paymentruler = vars.getStringParameter("inppaymentrule_R");     data.cPaymenttermId = vars.getStringParameter("inpcPaymenttermId");     data.cPaymenttermIdr = vars.getStringParameter("inpcPaymenttermId_R");     data.cIncotermsId = vars.getStringParameter("inpcIncotermsId");     data.cIncotermsIdr = vars.getStringParameter("inpcIncotermsId_R");     data.deliveryLocationId = vars.getStringParameter("inpdeliveryLocationId");     data.deliveryLocationIdr = vars.getStringParameter("inpdeliveryLocationId_R");     data.deliveryviarule = vars.getRequestGlobalVariable("inpdeliveryviarule", windowId + "|Deliveryviarule");     data.deliveryviaruler = vars.getStringParameter("inpdeliveryviarule_R");     data.mShipperId = vars.getRequestGlobalVariable("inpmShipperId", windowId + "|M_Shipper_ID");     data.mShipperIdr = vars.getStringParameter("inpmShipperId_R");    try {   data.weight = vars.getNumericParameter("inpweight");  } catch (ServletException paramEx) { ex = paramEx; }     data.weightUom = vars.getStringParameter("inpweightUom");     data.weightUomr = vars.getStringParameter("inpweightUom_R");     data.freightcostrule = vars.getRequestGlobalVariable("inpfreightcostrule", windowId + "|Freightcostrule");     data.freightcostruler = vars.getStringParameter("inpfreightcostrule_R");     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");    try {   data.qty = vars.getNumericParameter("inpqty");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.freightamt = vars.getNumericParameter("inpfreightamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.orderselfjoin = vars.getStringParameter("inporderselfjoin");     data.orderselfjoinr = vars.getStringParameter("inporderselfjoin_R");     data.firstschedinvoicedate = vars.getStringParameter("inpfirstschedinvoicedate");     data.datepromised = vars.getStringParameter("inpdatepromised");     data.scheddeliverydate = vars.getRequestGlobalVariable("inpscheddeliverydate", windowId + "|Scheddeliverydate");     data.schedtransactiondate = vars.getStringParameter("inpschedtransactiondate");     data.transactiondate = vars.getStringParameter("inptransactiondate");     data.contractdate = vars.getStringParameter("inpcontractdate");     data.enddate = vars.getStringParameter("inpenddate");     data.invoicefrequence = vars.getStringParameter("inpinvoicefrequence");     data.invoicefrequencer = vars.getStringParameter("inpinvoicefrequence_R");     data.isinvoiceafterfirstcycle = vars.getStringParameter("inpisinvoiceafterfirstcycle", "N");     data.quarterlyMonth = vars.getStringParameter("inpquarterlyMonth");     data.quarterlyMonthr = vars.getStringParameter("inpquarterlyMonth_R");     data.yearlyMonth = vars.getStringParameter("inpyearlyMonth");     data.yearlyMonthr = vars.getStringParameter("inpyearlyMonth_R");     data.weeklyDay = vars.getStringParameter("inpweeklyDay");     data.weeklyDayr = vars.getStringParameter("inpweeklyDay_R");    try {   data.monthlyDay = vars.getNumericParameter("inpmonthlyDay");  } catch (ServletException paramEx) { ex = paramEx; }     data.proposalstatus = vars.getStringParameter("inpproposalstatus");     data.proposalstatusr = vars.getStringParameter("inpproposalstatus_R");     data.lostproposalfixedreason = vars.getStringParameter("inplostproposalfixedreason");     data.lostproposalfixedreasonr = vars.getStringParameter("inplostproposalfixedreason_R");     data.lostproposalreason = vars.getStringParameter("inplostproposalreason");    try {   data.totallinesonetime = vars.getNumericParameter("inptotallinesonetime");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.grandtotalonetime = vars.getNumericParameter("inpgrandtotalonetime");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.totallines = vars.getNumericParameter("inptotallines");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.grandtotal = vars.getNumericParameter("inpgrandtotal");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.invoicedamt = vars.getNumericParameter("inpinvoicedamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.totalpaid = vars.getNumericParameter("inptotalpaid");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.completeordervalue = vars.getNumericParameter("inpcompleteordervalue");  } catch (ServletException paramEx) { ex = paramEx; }     data.iscompletelyinvoiced = vars.getStringParameter("inpiscompletelyinvoiced", "N");     data.generatetemplate = vars.getStringParameter("inpgeneratetemplate");     data.copyfrom = vars.getStringParameter("inpcopyfrom");     data.copyfrompo = vars.getStringParameter("inpcopyfrompo");     data.docaction = vars.getStringParameter("inpdocaction");     data.cOrderId = vars.getStringParameter("inpcOrderId");     data.issotrx = vars.getRequiredInputGlobalVariable("inpissotrx", windowId + "|Issotrx", "N");     data.processed = vars.getRequiredInputGlobalVariable("inpprocessed", windowId + "|Processed", "N");     data.isdelivered = vars.getStringParameter("inpisdelivered", "N");     data.isinvoiced = vars.getStringParameter("inpisinvoiced", "N");     data.isprinted = vars.getStringParameter("inpisprinted", "N");     data.isselected = vars.getStringParameter("inpisselected", "N");     data.dateprinted = vars.getStringParameter("inpdateprinted");     data.dateacct = vars.getStringParameter("inpdateacct");     data.cChargeId = vars.getStringParameter("inpcChargeId");    try {   data.chargeamt = vars.getNumericParameter("inpchargeamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.istaxincluded = vars.getStringParameter("inpistaxincluded", "N");     data.cCampaignId = vars.getStringParameter("inpcCampaignId");     data.cActivityId = vars.getStringParameter("inpcActivityId");     data.posted = vars.getStringParameter("inpposted");     data.dropshipBpartnerId = vars.getStringParameter("inpdropshipBpartnerId");     data.dropshipLocationId = vars.getStringParameter("inpdropshipLocationId");     data.dropshipUserId = vars.getStringParameter("inpdropshipUserId");     data.isselfservice = vars.getStringParameter("inpisselfservice", "N");     data.adOrgtrxId = vars.getStringParameter("inpadOrgtrxId");     data.user1Id = vars.getStringParameter("inpuser1Id");     data.user2Id = vars.getStringParameter("inpuser2Id");     data.incotermsdescription = vars.getStringParameter("inpincotermsdescription");     data.cBidprojectId = vars.getStringParameter("inpcBidprojectId");     data.cProjectphaseId = vars.getStringParameter("inpcProjectphaseId");     data.generateproject = vars.getStringParameter("inpgenerateproject");     data.closeproject = vars.getStringParameter("inpcloseproject");     data.ispaid = vars.getStringParameter("inpispaid", "N");     data.isrecharge = vars.getStringParameter("inpisrecharge", "N"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cOrderId = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");


    
    

    
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

   private SubscriptionIntervalsData[] getRelationData(SubscriptionIntervalsData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].cSubscriptionintervalViewId = FormatUtilities.truncate(data[i].cSubscriptionintervalViewId, 0);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].documentno = FormatUtilities.truncate(data[i].documentno, 8);        data[i].poreference = FormatUtilities.truncate(data[i].poreference, 11);        data[i].cDoctypetargetId = FormatUtilities.truncate(data[i].cDoctypetargetId, 44);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, 32);        data[i].name = FormatUtilities.truncate(data[i].name, 30);        data[i].cDoctypeId = FormatUtilities.truncate(data[i].cDoctypeId, 12);        data[i].docstatus = FormatUtilities.truncate(data[i].docstatus, 16);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].deliverynotes = FormatUtilities.truncate(data[i].deliverynotes, 50);        data[i].internalnote = FormatUtilities.truncate(data[i].internalnote, 50);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 34);        data[i].bpzipcode = FormatUtilities.truncate(data[i].bpzipcode, 10);        data[i].billtoId = FormatUtilities.truncate(data[i].billtoId, 40);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 44);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 20);        data[i].salesrepId = FormatUtilities.truncate(data[i].salesrepId, 20);        data[i].mPricelistId = FormatUtilities.truncate(data[i].mPricelistId, 44);        data[i].invoicerule = FormatUtilities.truncate(data[i].invoicerule, 20);        data[i].estpropability = FormatUtilities.truncate(data[i].estpropability, 10);        data[i].mWarehouseId = FormatUtilities.truncate(data[i].mWarehouseId, 44);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 21);        data[i].deliveryrule = FormatUtilities.truncate(data[i].deliveryrule, 21);        data[i].priorityrule = FormatUtilities.truncate(data[i].priorityrule, 21);        data[i].paymentrule = FormatUtilities.truncate(data[i].paymentrule, 20);        data[i].cPaymenttermId = FormatUtilities.truncate(data[i].cPaymenttermId, 48);        data[i].cIncotermsId = FormatUtilities.truncate(data[i].cIncotermsId, 44);        data[i].deliveryLocationId = FormatUtilities.truncate(data[i].deliveryLocationId, 44);        data[i].deliveryviarule = FormatUtilities.truncate(data[i].deliveryviarule, 21);        data[i].mShipperId = FormatUtilities.truncate(data[i].mShipperId, 44);        data[i].weightUom = FormatUtilities.truncate(data[i].weightUom, 32);        data[i].freightcostrule = FormatUtilities.truncate(data[i].freightcostrule, 21);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 44);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].orderselfjoin = FormatUtilities.truncate(data[i].orderselfjoin, 32);        data[i].invoicefrequence = FormatUtilities.truncate(data[i].invoicefrequence, 20);        data[i].quarterlyMonth = FormatUtilities.truncate(data[i].quarterlyMonth, 50);        data[i].yearlyMonth = FormatUtilities.truncate(data[i].yearlyMonth, 50);        data[i].weeklyDay = FormatUtilities.truncate(data[i].weeklyDay, 50);        data[i].proposalstatus = FormatUtilities.truncate(data[i].proposalstatus, 30);        data[i].lostproposalfixedreason = FormatUtilities.truncate(data[i].lostproposalfixedreason, 30);        data[i].lostproposalreason = FormatUtilities.truncate(data[i].lostproposalreason, 50);        data[i].cOrderId = FormatUtilities.truncate(data[i].cOrderId, 10);        data[i].cChargeId = FormatUtilities.truncate(data[i].cChargeId, 44);        data[i].cCampaignId = FormatUtilities.truncate(data[i].cCampaignId, 44);        data[i].cActivityId = FormatUtilities.truncate(data[i].cActivityId, 44);        data[i].dropshipBpartnerId = FormatUtilities.truncate(data[i].dropshipBpartnerId, 44);        data[i].dropshipLocationId = FormatUtilities.truncate(data[i].dropshipLocationId, 44);        data[i].dropshipUserId = FormatUtilities.truncate(data[i].dropshipUserId, 44);        data[i].adOrgtrxId = FormatUtilities.truncate(data[i].adOrgtrxId, 44);        data[i].user1Id = FormatUtilities.truncate(data[i].user1Id, 44);        data[i].user2Id = FormatUtilities.truncate(data[i].user2Id, 44);        data[i].incotermsdescription = FormatUtilities.truncate(data[i].incotermsdescription, 50);        data[i].cBidprojectId = FormatUtilities.truncate(data[i].cBidprojectId, 32);        data[i].cProjectphaseId = FormatUtilities.truncate(data[i].cProjectphaseId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPC_Order_ID) throws IOException,ServletException {
      HeaderData[] data = HeaderData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Order_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|DateOrdered", data[0].dateordered);    vars.setSessionValue(windowId + "|C_DocTypeTarget_ID", data[0].cDoctypetargetId);    vars.setSessionValue(windowId + "|C_DocType_ID", data[0].cDoctypeId);    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].cBpartnerId);    vars.setSessionValue(windowId + "|C_BPartner_Location_ID", data[0].cBpartnerLocationId);    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].mPricelistId);    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].mWarehouseId);    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].cCurrencyId);    vars.setSessionValue(windowId + "|DeliveryViaRule", data[0].deliveryviarule);    vars.setSessionValue(windowId + "|M_Shipper_ID", data[0].mShipperId);    vars.setSessionValue(windowId + "|FreightCostRule", data[0].freightcostrule);    vars.setSessionValue(windowId + "|DatePromised", data[0].datepromised);    vars.setSessionValue(windowId + "|Scheddeliverydate", data[0].scheddeliverydate);    vars.setSessionValue(windowId + "|C_Order_ID", data[0].cOrderId);    vars.setSessionValue(windowId + "|Processed", data[0].processed);    vars.setSessionValue(windowId + "|IsSOTrx", data[0].issotrx);
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
      vars.setSessionValue(windowId + "|ORDERTYPE", HeaderData.selectAux6(this, ((dataField!=null)?dataField.getField("cDoctypetargetId"):((data==null || data.length==0)?"":data[0].cDoctypetargetId))));
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strC_Subscriptioninterval_View_ID) throws ServletException {
    String strPC_Order_ID = SubscriptionIntervalsData.selectParentID(this, strC_Subscriptioninterval_View_ID);
    if (strPC_Order_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strC_Subscriptioninterval_View_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_Order_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|C_Subscriptioninterval_View_ID", data[0].getField("cSubscriptionintervalViewId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|DateOrdered", data[0].getField("dateordered"));    vars.setSessionValue(windowId + "|C_DocTypeTarget_ID", data[0].getField("cDoctypetargetId"));    vars.setSessionValue(windowId + "|C_DocType_ID", data[0].getField("cDoctypeId"));    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].getField("cBpartnerId"));    vars.setSessionValue(windowId + "|C_BPartner_Location_ID", data[0].getField("cBpartnerLocationId"));    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].getField("mPricelistId"));    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].getField("mWarehouseId"));    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].getField("cCurrencyId"));    vars.setSessionValue(windowId + "|DeliveryViaRule", data[0].getField("deliveryviarule"));    vars.setSessionValue(windowId + "|M_Shipper_ID", data[0].getField("mShipperId"));    vars.setSessionValue(windowId + "|FreightCostRule", data[0].getField("freightcostrule"));    vars.setSessionValue(windowId + "|Scheddeliverydate", data[0].getField("scheddeliverydate"));    vars.setSessionValue(windowId + "|IsSOTrx", data[0].getField("issotrx"));    vars.setSessionValue(windowId + "|Processed", data[0].getField("processed"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_Order_ID) throws IOException,ServletException {
      SubscriptionIntervalsData[] data = SubscriptionIntervalsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Order_ID, vars.getStringParameter("inpcSubscriptionintervalViewId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_Order_ID, String strC_Subscriptioninterval_View_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamDocumentno = vars.getSessionValue(tabId + "|paramDocumentno");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamPoreference = vars.getSessionValue(tabId + "|paramPoreference");
String strParamDateordered = vars.getSessionValue(tabId + "|paramDateordered");
String strParamC_Bpartner_ID = vars.getSessionValue(tabId + "|paramC_Bpartner_ID");
String strParambpzipcode = vars.getSessionValue(tabId + "|parambpzipcode");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamA_Asset_ID = vars.getSessionValue(tabId + "|paramA_Asset_ID");
String strParamSalesrep_ID = vars.getSessionValue(tabId + "|paramSalesrep_ID");
String strParamGrandtotal = vars.getSessionValue(tabId + "|paramGrandtotal");
String strParamInvoicerule = vars.getSessionValue(tabId + "|paramInvoicerule");
String strParamDatepromised = vars.getSessionValue(tabId + "|paramDatepromised");
String strParamC_Doctype_ID = vars.getSessionValue(tabId + "|paramC_Doctype_ID");
String strParamDocstatus = vars.getSessionValue(tabId + "|paramDocstatus");
String strParamProposalstatus = vars.getSessionValue(tabId + "|paramProposalstatus");
String strParamDateordered_f = vars.getSessionValue(tabId + "|paramDateordered_f");
String strParamGrandtotal_f = vars.getSessionValue(tabId + "|paramGrandtotal_f");
String strParamDatepromised_f = vars.getSessionValue(tabId + "|paramDatepromised_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamAD_Org_ID.equals("") && strParamDocumentno.equals("") && strParamName.equals("") && strParamPoreference.equals("") && strParamDateordered.equals("") && strParamC_Bpartner_ID.equals("") && strParambpzipcode.equals("") && strParamC_Project_ID.equals("") && strParamA_Asset_ID.equals("") && strParamSalesrep_ID.equals("") && strParamGrandtotal.equals("") && strParamInvoicerule.equals("") && strParamDatepromised.equals("") && strParamC_Doctype_ID.equals("") && strParamDocstatus.equals("") && strParamProposalstatus.equals("") && strParamDateordered_f.equals("") && strParamGrandtotal_f.equals("") && strParamDatepromised_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_Subscriptioninterval_View_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_Subscriptioninterval_View_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/SalesOrder/SubscriptionIntervals_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "SubscriptionIntervals", false, "document.frmMain.inpcSubscriptionintervalViewId", "grid", "..", "".equals("Y"), "SalesOrder", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPC_Order_ID);

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
    xmlDocument.setParameter("KeyName", "cSubscriptionintervalViewId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "SubscriptionIntervals_Relation.html", "SalesOrder", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "SubscriptionIntervals_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", SubscriptionIntervalsData.selectParent(this, strPC_Order_ID));
    else xmlDocument.setParameter("parent", SubscriptionIntervalsData.selectParentTrl(this, strPC_Order_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_Subscriptioninterval_View_ID, String strPC_Order_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " EXTRACT(EPOCH FROM datepromised)";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    SubscriptionIntervalsData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamDocumentno = vars.getSessionValue(tabId + "|paramDocumentno");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamPoreference = vars.getSessionValue(tabId + "|paramPoreference");
String strParamDateordered = vars.getSessionValue(tabId + "|paramDateordered");
String strParamC_Bpartner_ID = vars.getSessionValue(tabId + "|paramC_Bpartner_ID");
String strParambpzipcode = vars.getSessionValue(tabId + "|parambpzipcode");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamA_Asset_ID = vars.getSessionValue(tabId + "|paramA_Asset_ID");
String strParamSalesrep_ID = vars.getSessionValue(tabId + "|paramSalesrep_ID");
String strParamGrandtotal = vars.getSessionValue(tabId + "|paramGrandtotal");
String strParamInvoicerule = vars.getSessionValue(tabId + "|paramInvoicerule");
String strParamDatepromised = vars.getSessionValue(tabId + "|paramDatepromised");
String strParamC_Doctype_ID = vars.getSessionValue(tabId + "|paramC_Doctype_ID");
String strParamDocstatus = vars.getSessionValue(tabId + "|paramDocstatus");
String strParamProposalstatus = vars.getSessionValue(tabId + "|paramProposalstatus");
String strParamDateordered_f = vars.getSessionValue(tabId + "|paramDateordered_f");
String strParamGrandtotal_f = vars.getSessionValue(tabId + "|paramGrandtotal_f");
String strParamDatepromised_f = vars.getSessionValue(tabId + "|paramDatepromised_f");

    boolean hasSearchCondition=false;
    if (!(strParamAD_Org_ID.equals("") && strParamDocumentno.equals("") && strParamName.equals("") && strParamPoreference.equals("") && strParamDateordered.equals("") && strParamC_Bpartner_ID.equals("") && strParambpzipcode.equals("") && strParamC_Project_ID.equals("") && strParamA_Asset_ID.equals("") && strParamSalesrep_ID.equals("") && strParamGrandtotal.equals("") && strParamInvoicerule.equals("") && strParamDatepromised.equals("") && strParamC_Doctype_ID.equals("") && strParamDocstatus.equals("") && strParamProposalstatus.equals("") && strParamDateordered_f.equals("") && strParamGrandtotal_f.equals("") && strParamDatepromised_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = SubscriptionIntervalsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Order_ID, strC_Subscriptioninterval_View_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_Subscriptioninterval_View_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new SubscriptionIntervalsData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cSubscriptionintervalViewId") == null || dataField.getField("cSubscriptionintervalViewId").equals("")) {
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
        refreshSessionNew(vars, strPC_Order_ID);
        data = SubscriptionIntervalsData.set(strPC_Order_ID, Utility.getDefault(this, vars, "Lostproposalreason", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Poreference", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Freightamt", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Transactiondate", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Description", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Processed", "", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "C_Bpartner_Location_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Isinvoiced", "", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "Totallines", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Totalpaid", "0", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Chargeamt", "0", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Completeordervalue", "0", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Delivery_Location_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Dateacct", "@#Date@", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Generatetemplate", "N", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "Isselected", "", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "C_Campaign_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Weekly_Day", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "M_Pricelist_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Freightcostrule", "I", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "AD_Orgtrx_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "C_Project_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), SubscriptionIntervalsData.selectDef8E484ACDA22C4137912AB7CE03F16DF6_0(this, Utility.getDefault(this, vars, "C_Project_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField)), Utility.getDefault(this, vars, "Istaxincluded", "", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "Ispaid", "N", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "Issotrx", "@IsSOTrx@", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "Generateproject", "N", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "Internalnote", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "DocAction", "CO", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), (vars.getLanguage().equals("en_US")?ListData.selectName(this, "135", Utility.getDefault(this, vars, "DocAction", "CO", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField)):ListData.selectNameTrl(this, vars.getLanguage(), "135", Utility.getDefault(this, vars, "DocAction", "CO", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField))), Utility.getDefault(this, vars, "Isinvoiceafterfirstcycle", "Y", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "Grandtotalonetime", "0", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), "Y", Utility.getDefault(this, vars, "Dateordered", "@#Date@", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Name", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "M_Shipper_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "bpzipcode", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Invoicefrequence", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "C_Charge_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Invoicerule", "D", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "User1_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Closeproject", "N", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "Dropship_Bpartner_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Schedtransactiondate", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Weight_Uom", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), "", Utility.getDefault(this, vars, "M_Warehouse_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Quarterly_Month", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Qty", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "A_Asset_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Isdiscountprinted", "", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "Createdby", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), SubscriptionIntervalsData.selectDefDCC3A82F3D444E338D83C930D884FC48_1(this, Utility.getDefault(this, vars, "Createdby", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField)), Utility.getDefault(this, vars, "Dropship_Location_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Paymentrule", "B", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "C_Incoterms_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "User2_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Enddate", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Priorityrule", "5", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Salesrep_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), SubscriptionIntervalsData.selectDef851ED0863DD048029EBBEBFAFA8F1601_2(this, Utility.getDefault(this, vars, "Updatedby", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField)), Utility.getDefault(this, vars, "Firstschedinvoicedate", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "C_Activity_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "C_Doctype_ID", "0", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "C_Projectphase_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Datepromised", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "C_Doctypetarget_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Iscompletelyinvoiced", "N", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "C_Projecttask_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Lostproposalfixedreason", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "C_Paymentterm_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Dateprinted", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "C_Currency_ID", "@C_Currency_ID@", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Docstatus", "DR", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Contractdate", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Copyfrompo", "", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "Posted", "N", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "Totallinesonetime", "0", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Deliveryrule", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "C_Bpartner_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), SubscriptionIntervalsData.selectDef8AFDA0D37D114D80B6F7A77103DA7A72_3(this, Utility.getDefault(this, vars, "C_Bpartner_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField)), Utility.getDefault(this, vars, "Monthly_Day", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Proposalstatus", "OP", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Deliveryviarule", "P", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Documentno", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Isdelivered", "", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "Isselfservice", "", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "Isrecharge", "Y", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "Billto_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "C_Bidproject_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Yearly_Month", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Deliverynotes", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Weight", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Scheddeliverydate", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Grandtotal", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "AD_User_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Incotermsdescription", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Isprinted", "", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "Invoicedamt", "0", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Estpropability", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Orderselfjoin", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField), Utility.getDefault(this, vars, "Copyfrom", "", "143", "8A541CF5111C4654809F092C675EAC04", "N", dataField), Utility.getDefault(this, vars, "Dropship_User_ID", "", "143", "8A541CF5111C4654809F092C675EAC04", "", dataField));
        
      }
    } else {
      data = new SubscriptionIntervalsData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(SubscriptionIntervalsData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=HeaderData.selectOrg(this, strPC_Order_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "SubscriptionIntervals", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcSubscriptionintervalViewId", "", "..", "".equals("Y"), "SalesOrder", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_Subscriptioninterval_View_ID));
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
  
    void printPageButtonDocAction104(HttpServletResponse response, VariablesSecureApp vars, String strC_Subscriptioninterval_View_ID, String strdocaction, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "104",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "104" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"104" );
        String isDocAction=UtilsData.isProcessDocAction(this, "104");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "E5A34E9B2AE84350B2B1E5A3FE61EFBA",strC_Subscriptioninterval_View_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "E5A34E9B2AE84350B2B1E5A3FE61EFBA", strC_Subscriptioninterval_View_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strdocaction, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "104");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONDocAction" + "104" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","SubscriptionIntervals_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "104");
        script.addHiddenfield("inpKey",strC_Subscriptioninterval_View_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("104");
        vars.removeMessage("104");
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
      String result = "var strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\nvar strOrderType=\"" + Utility.getContext(this, vars, "OrderType", windowId) + "\";\n";
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPC_Order_ID) throws IOException, ServletException {
    SubscriptionIntervalsData data = null;
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
            data = getEditVariables(con, vars, strPC_Order_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.cSubscriptionintervalViewId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (SubscriptionIntervalsData.getCurrentDBTimestamp(this, data.cSubscriptionintervalViewId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cSubscriptionintervalViewId, vars, this);
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
                    data.cSubscriptionintervalViewId = "";
                }
                else {                    
                    
                        //BUTTON TEXT FILLING
                    data.docactionBtn = ActionButtonDefaultData.getText(this, vars.getLanguage(), "135", data.getField("DocAction"));
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_Subscriptioninterval_View_ID", data.cSubscriptionintervalViewId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet SubscriptionIntervals. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
