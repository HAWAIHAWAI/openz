
package org.openbravo.erpWindows.SalesOrder;





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

public class IntervalLines extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(IntervalLines.class);
  
  private static final String windowId = "143";
  private static final String tabId = "21D5BDEE93C047CBA2BF24D24F5536BC";
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
        String strcSubscriptionintervallinesViewId = request.getParameter("inpcSubscriptionintervallinesViewId");
         String strPC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcSubscriptionintervallinesViewId.equals(""))
              total = saveRecord(vars, myError, 'U', strPC_Subscriptioninterval_View_ID);
          else
              total = saveRecord(vars, myError, 'I', strPC_Subscriptioninterval_View_ID);
          
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
      String strPC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID", "");

      String strC_Subscriptionintervallines_View_ID = vars.getGlobalVariable("inpcSubscriptionintervallinesViewId", windowId + "|C_Subscriptionintervallines_View_ID", "");
            if (strPC_Subscriptioninterval_View_ID.equals("")) {
        strPC_Subscriptioninterval_View_ID = getParentID(vars, strC_Subscriptionintervallines_View_ID);
        if (strPC_Subscriptioninterval_View_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_Subscriptioninterval_View_ID");
        vars.setSessionValue(windowId + "|C_Subscriptioninterval_View_ID", strPC_Subscriptioninterval_View_ID);
      vars.removeSessionValue(windowId + "|C_Order_ID");
        refreshParentSession(vars, strPC_Subscriptioninterval_View_ID);
      }


      String strView = vars.getSessionValue(tabId + "|IntervalLines.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_Subscriptionintervallines_View_ID.equals("")) strC_Subscriptionintervallines_View_ID = firstElement(vars, tableSQL);
          if (strC_Subscriptionintervallines_View_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Subscriptionintervallines_View_ID, strPC_Subscriptioninterval_View_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Subscriptioninterval_View_ID, strC_Subscriptionintervallines_View_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_Subscriptionintervallines_View_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_Subscriptionintervallines_View_ID.equals("")) strC_Subscriptionintervallines_View_ID = vars.getRequiredGlobalVariable("inpcSubscriptionintervallinesViewId", windowId + "|C_Subscriptionintervallines_View_ID");
      else vars.setSessionValue(windowId + "|C_Subscriptionintervallines_View_ID", strC_Subscriptionintervallines_View_ID);
      
      
      String strPC_Subscriptioninterval_View_ID = getParentID(vars, strC_Subscriptionintervallines_View_ID);
      
      vars.setSessionValue(windowId + "|C_Subscriptioninterval_View_ID", strPC_Subscriptioninterval_View_ID);
      vars.setSessionValue("8A541CF5111C4654809F092C675EAC04|Subscription Intervals.view", "EDIT");
      vars.removeSessionValue(windowId + "|C_Order_ID");
      refreshParentSession(vars, strPC_Subscriptioninterval_View_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|IntervalLines.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_Subscriptionintervallines_View_ID, strPC_Subscriptioninterval_View_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|IntervalLines.view", "RELATION");
        printPageDataSheet(response, vars, strPC_Subscriptioninterval_View_ID, strC_Subscriptionintervallines_View_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|C_Subscriptionintervallines_View_ID");
      refreshParentSession(vars, strPC_Subscriptioninterval_View_ID);


      String strView = vars.getSessionValue(tabId + "|IntervalLines.view");
      String strC_Subscriptionintervallines_View_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_Subscriptionintervallines_View_ID = firstElement(vars, tableSQL);
          if (strC_Subscriptionintervallines_View_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_Subscriptionintervallines_View_ID.equals("")) strC_Subscriptionintervallines_View_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_Subscriptionintervallines_View_ID, strPC_Subscriptioninterval_View_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_Subscriptioninterval_View_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamC_Subscriptioninterval_View_ID", tabId + "|paramC_Subscriptioninterval_View_ID");
vars.getRequestGlobalVariable("inpParamLine", tabId + "|paramLine");
vars.getRequestGlobalVariable("inpParamLineNetAmt", tabId + "|paramLineNetAmt");
vars.getRequestGlobalVariable("inpParamLine_f", tabId + "|paramLine_f");
vars.getRequestGlobalVariable("inpParamLineNetAmt_f", tabId + "|paramLineNetAmt_f");

            String strPC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");

      
      vars.removeSessionValue(windowId + "|C_Subscriptionintervallines_View_ID");
      String strC_Subscriptionintervallines_View_ID="";

      String strView = vars.getSessionValue(tabId + "|IntervalLines.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_Subscriptionintervallines_View_ID = firstElement(vars, tableSQL);
        if (strC_Subscriptionintervallines_View_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|IntervalLines.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Subscriptionintervallines_View_ID, strPC_Subscriptioninterval_View_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Subscriptioninterval_View_ID, strC_Subscriptionintervallines_View_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");
      

      String strC_Subscriptionintervallines_View_ID = vars.getGlobalVariable("inpcSubscriptionintervallinesViewId", windowId + "|C_Subscriptionintervallines_View_ID", "");
      vars.setSessionValue(tabId + "|IntervalLines.view", "RELATION");
      printPageDataSheet(response, vars, strPC_Subscriptioninterval_View_ID, strC_Subscriptionintervallines_View_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");


      printPageEdit(response, request, vars, true, "", strPC_Subscriptioninterval_View_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_Subscriptionintervallines_View_ID = vars.getGlobalVariable("inpcSubscriptionintervallinesViewId", windowId + "|C_Subscriptionintervallines_View_ID", "");
      vars.setSessionValue(tabId + "|IntervalLines.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_Subscriptionintervallines_View_ID, strPC_Subscriptioninterval_View_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");
      String strC_Subscriptionintervallines_View_ID = vars.getRequiredStringParameter("inpcSubscriptionintervallinesViewId");
      
      String strNext = nextElement(vars, strC_Subscriptionintervallines_View_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_Subscriptioninterval_View_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");
      String strC_Subscriptionintervallines_View_ID = vars.getRequiredStringParameter("inpcSubscriptionintervallinesViewId");
      
      String strPrevious = previousElement(vars, strC_Subscriptionintervallines_View_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_Subscriptioninterval_View_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");

      vars.setSessionValue(tabId + "|IntervalLines.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|IntervalLines.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|IntervalLines.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|IntervalLines.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_Subscriptionintervallines_View_ID");
      vars.setSessionValue(windowId + "|C_Subscriptioninterval_View_ID", strPC_Subscriptioninterval_View_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|IntervalLines.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|IntervalLines.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_Subscriptionintervallines_View_ID");
      vars.setSessionValue(windowId + "|C_Subscriptioninterval_View_ID", strPC_Subscriptioninterval_View_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPC_Subscriptioninterval_View_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPC_Subscriptioninterval_View_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPC_Subscriptioninterval_View_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPC_Subscriptioninterval_View_ID);      
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
      String strPC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");
      String strC_Subscriptionintervallines_View_ID = vars.getRequiredGlobalVariable("inpcSubscriptionintervallinesViewId", windowId + "|C_Subscriptionintervallines_View_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPC_Subscriptioninterval_View_ID);      
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
          String strNext = nextElement(vars, strC_Subscriptionintervallines_View_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_Subscriptionintervallines_View_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");

      String strC_Subscriptionintervallines_View_ID = vars.getRequiredInStringParameter("inpcSubscriptionintervallinesViewId");
      String message = deleteRelation(vars, strC_Subscriptionintervallines_View_ID, strPC_Subscriptioninterval_View_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cSubscriptionintervallinesViewId");
        vars.setSessionValue(tabId + "|IntervalLines.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPC_Subscriptioninterval_View_ID = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");

      String strC_Subscriptionintervallines_View_ID = vars.getRequiredStringParameter("inpcSubscriptionintervallinesViewId");
      //IntervalLinesData data = getEditVariables(vars, strPC_Subscriptioninterval_View_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = IntervalLinesData.delete(this, strC_Subscriptionintervallines_View_ID, strPC_Subscriptioninterval_View_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cSubscriptionintervallinesViewId");
        vars.setSessionValue(tabId + "|IntervalLines.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strC_Subscriptionintervallines_View_ID, String strPC_Subscriptioninterval_View_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_Subscriptionintervallines_View_ID.startsWith("(")) strC_Subscriptionintervallines_View_ID = strC_Subscriptionintervallines_View_ID.substring(1, strC_Subscriptionintervallines_View_ID.length()-1);
      if (!strC_Subscriptionintervallines_View_ID.equals("")) {
        strC_Subscriptionintervallines_View_ID = Replace.replace(strC_Subscriptionintervallines_View_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_Subscriptionintervallines_View_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (IntervalLinesData.deleteTransactional(conn, this, strKey, strPC_Subscriptioninterval_View_ID)==0) {
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
  private IntervalLinesData getEditVariables(Connection con, VariablesSecureApp vars, String strPC_Subscriptioninterval_View_ID) throws IOException,ServletException {
    IntervalLinesData data = new IntervalLinesData();
    ServletException ex = null;
    try {
    data.isdescription = vars.getStringParameter("inpisdescription", "N");     data.refOrderlineId = vars.getStringParameter("inprefOrderlineId");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.mOfferId = vars.getStringParameter("inpmOfferId");     data.adOrgId = vars.getStringParameter("inpadOrgId");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.cSubscriptionintervalViewId = vars.getRequestGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");     data.cSubscriptionintervalViewIdr = vars.getStringParameter("inpcSubscriptionintervalViewId_R");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.cBpartnerLocationId = vars.getRequestGlobalVariable("inpcBpartnerLocationId", windowId + "|C_BPartner_Location_ID");     data.cBpartnerLocationIdr = vars.getStringParameter("inpcBpartnerLocationId_R");     data.dateordered = vars.getRequestGlobalVariable("inpdateordered", windowId + "|DateOrdered");    try {   data.linetaxamt = vars.getNumericParameter("inplinetaxamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.line = vars.getNumericParameter("inpline");  } catch (ServletException paramEx) { ex = paramEx; }     data.isgrossprice = vars.getStringParameter("inpisgrossprice", "N");     data.datepromised = vars.getRequestGlobalVariable("inpdatepromised", windowId + "|DatePromised");     data.cProjectphaseId = vars.getStringParameter("inpcProjectphaseId");     data.scheddeliverydate = vars.getStringParameter("inpscheddeliverydate");     data.directship = vars.getStringParameter("inpdirectship", "N");     data.aAssetId = vars.getStringParameter("inpaAssetId");     data.mWarehouseId = vars.getRequestGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");     data.mWarehouseIdr = vars.getStringParameter("inpmWarehouseId_R");     data.isonetimeposition = vars.getStringParameter("inpisonetimeposition", "N");     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.issummaryitem = vars.getStringParameter("inpissummaryitem", "N");     data.mAttributesetinstanceId = vars.getStringParameter("inpmAttributesetinstanceId");     data.mAttributesetinstanceIdr = vars.getStringParameter("inpmAttributesetinstanceId_R");     data.sResourceassignmentId = vars.getStringParameter("inpsResourceassignmentId");     data.description = vars.getStringParameter("inpdescription");    try {   data.quantityorder = vars.getNumericParameter("inpquantityorder");  } catch (ServletException paramEx) { ex = paramEx; }     data.cSubscriptionintervallinesViewId = vars.getRequestGlobalVariable("inpcSubscriptionintervallinesViewId", windowId + "|C_Subscriptionintervallines_View_ID");     data.mProductUomId = vars.getStringParameter("inpmProductUomId");     data.mProductUomIdr = vars.getStringParameter("inpmProductUomId_R");    try {   data.qtyordered = vars.getNumericParameter("inpqtyordered");  } catch (ServletException paramEx) { ex = paramEx; }     data.cUomId = vars.getStringParameter("inpcUomId");     data.cUomIdr = vars.getStringParameter("inpcUomId_R");    try {   data.qtydelivered = vars.getNumericParameter("inpqtydelivered");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qtyreserved = vars.getNumericParameter("inpqtyreserved");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qtyinvoiced = vars.getNumericParameter("inpqtyinvoiced");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.invoicedamt = vars.getNumericParameter("inpinvoicedamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.ignoreresidue = vars.getStringParameter("inpignoreresidue", "N");     data.mShipperId = vars.getRequestGlobalVariable("inpmShipperId", windowId + "|M_Shipper_ID");     data.mShipperIdr = vars.getStringParameter("inpmShipperId_R");    try {   data.priceactual = vars.getNumericParameter("inppriceactual");  } catch (ServletException paramEx) { ex = paramEx; }     data.cCurrencyId = vars.getRequestGlobalVariable("inpcCurrencyId", windowId + "|C_Currency_ID");     data.cCurrencyIdr = vars.getStringParameter("inpcCurrencyId_R");    try {   data.pricestd = vars.getNumericParameter("inppricestd");  } catch (ServletException paramEx) { ex = paramEx; }     data.cancelpricead = vars.getStringParameter("inpcancelpricead", "N");    try {   data.pricelist = vars.getNumericParameter("inppricelist");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.discount = vars.getNumericParameter("inpdiscount");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.freightamt = vars.getNumericParameter("inpfreightamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.cTaxId = vars.getStringParameter("inpcTaxId");     data.cTaxIdr = vars.getStringParameter("inpcTaxId_R");     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");    try {   data.linenetamt = vars.getNumericParameter("inplinenetamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.linegrossamt = vars.getNumericParameter("inplinegrossamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.cChargeId = vars.getStringParameter("inpcChargeId");     data.datedelivered = vars.getStringParameter("inpdatedelivered");     data.dateinvoiced = vars.getStringParameter("inpdateinvoiced");    try {   data.pricelimit = vars.getNumericParameter("inppricelimit");  } catch (ServletException paramEx) { ex = paramEx; }     data.isactive = vars.getStringParameter("inpisactive", "N");    try {   data.chargeamt = vars.getNumericParameter("inpchargeamt");  } catch (ServletException paramEx) { ex = paramEx; } 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cSubscriptionintervalViewId = vars.getGlobalVariable("inpcSubscriptionintervalViewId", windowId + "|C_Subscriptioninterval_View_ID");


          vars.getGlobalVariable("inpdocbasetype", windowId + "|DOCBASETYPE", "");
    
    

    
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

   private IntervalLinesData[] getRelationData(IntervalLinesData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].refOrderlineId = FormatUtilities.truncate(data[i].refOrderlineId, 44);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].mOfferId = FormatUtilities.truncate(data[i].mOfferId, 44);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].cSubscriptionintervalViewId = FormatUtilities.truncate(data[i].cSubscriptionintervalViewId, 44);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 44);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 44);        data[i].cProjectphaseId = FormatUtilities.truncate(data[i].cProjectphaseId, 32);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, 32);        data[i].mWarehouseId = FormatUtilities.truncate(data[i].mWarehouseId, 44);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 44);        data[i].mAttributesetinstanceId = FormatUtilities.truncate(data[i].mAttributesetinstanceId, 14);        data[i].sResourceassignmentId = FormatUtilities.truncate(data[i].sResourceassignmentId, 14);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].cSubscriptionintervallinesViewId = FormatUtilities.truncate(data[i].cSubscriptionintervallinesViewId, 0);        data[i].mProductUomId = FormatUtilities.truncate(data[i].mProductUomId, 44);        data[i].cUomId = FormatUtilities.truncate(data[i].cUomId, 44);        data[i].mShipperId = FormatUtilities.truncate(data[i].mShipperId, 44);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 44);        data[i].cTaxId = FormatUtilities.truncate(data[i].cTaxId, 44);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 32);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].cChargeId = FormatUtilities.truncate(data[i].cChargeId, 44);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPC_Subscriptioninterval_View_ID) throws IOException,ServletException {
      SubscriptionIntervalsData[] data = SubscriptionIntervalsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getSessionValue(windowId + "|C_Order_ID"), strPC_Subscriptioninterval_View_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|C_Subscriptioninterval_View_ID", data[0].cSubscriptionintervalViewId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|DateOrdered", data[0].dateordered);    vars.setSessionValue(windowId + "|C_DocTypeTarget_ID", data[0].cDoctypetargetId);    vars.setSessionValue(windowId + "|C_DocType_ID", data[0].cDoctypeId);    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].cBpartnerId);    vars.setSessionValue(windowId + "|C_BPartner_Location_ID", data[0].cBpartnerLocationId);    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].mPricelistId);    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].mWarehouseId);    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].cCurrencyId);    vars.setSessionValue(windowId + "|DeliveryViaRule", data[0].deliveryviarule);    vars.setSessionValue(windowId + "|M_Shipper_ID", data[0].mShipperId);    vars.setSessionValue(windowId + "|FreightCostRule", data[0].freightcostrule);    vars.setSessionValue(windowId + "|Scheddeliverydate", data[0].scheddeliverydate);    vars.setSessionValue(windowId + "|IsSOTrx", data[0].issotrx);    vars.setSessionValue(windowId + "|Processed", data[0].processed);
      vars.setSessionValue(windowId + "|C_Subscriptioninterval_View_ID", strPC_Subscriptioninterval_View_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strC_Subscriptionintervallines_View_ID) throws ServletException {
    String strPC_Subscriptioninterval_View_ID = IntervalLinesData.selectParentID(this, strC_Subscriptionintervallines_View_ID);
    if (strPC_Subscriptioninterval_View_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strC_Subscriptionintervallines_View_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_Subscriptioninterval_View_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|C_Subscriptioninterval_View_ID", data[0].getField("cSubscriptionintervalViewId"));    vars.setSessionValue(windowId + "|C_BPartner_Location_ID", data[0].getField("cBpartnerLocationId"));    vars.setSessionValue(windowId + "|DateOrdered", data[0].getField("dateordered"));    vars.setSessionValue(windowId + "|DatePromised", data[0].getField("datepromised"));    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].getField("mWarehouseId"));    vars.setSessionValue(windowId + "|C_Subscriptionintervallines_View_ID", data[0].getField("cSubscriptionintervallinesViewId"));    vars.setSessionValue(windowId + "|M_Shipper_ID", data[0].getField("mShipperId"));    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].getField("cCurrencyId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_Subscriptioninterval_View_ID) throws IOException,ServletException {
      IntervalLinesData[] data = IntervalLinesData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Subscriptioninterval_View_ID, vars.getStringParameter("inpcSubscriptionintervallinesViewId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_Subscriptioninterval_View_ID, String strC_Subscriptionintervallines_View_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamC_Subscriptioninterval_View_ID = vars.getSessionValue(tabId + "|paramC_Subscriptioninterval_View_ID");
String strParamLine = vars.getSessionValue(tabId + "|paramLine");
String strParamLineNetAmt = vars.getSessionValue(tabId + "|paramLineNetAmt");
String strParamLine_f = vars.getSessionValue(tabId + "|paramLine_f");
String strParamLineNetAmt_f = vars.getSessionValue(tabId + "|paramLineNetAmt_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamC_Subscriptioninterval_View_ID.equals("") && strParamLine.equals("") && strParamLineNetAmt.equals("") && strParamLine_f.equals("") && strParamLineNetAmt_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_Subscriptionintervallines_View_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_Subscriptionintervallines_View_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/SalesOrder/IntervalLines_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "IntervalLines", false, "document.frmMain.inpcSubscriptionintervallinesViewId", "grid", "..", "".equals("Y"), "SalesOrder", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPC_Subscriptioninterval_View_ID);

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
    xmlDocument.setParameter("KeyName", "cSubscriptionintervallinesViewId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "IntervalLines_Relation.html", "SalesOrder", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "IntervalLines_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", IntervalLinesData.selectParent(this, strPC_Subscriptioninterval_View_ID));
    else xmlDocument.setParameter("parent", IntervalLinesData.selectParentTrl(this, strPC_Subscriptioninterval_View_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_Subscriptionintervallines_View_ID, String strPC_Subscriptioninterval_View_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " c_subscriptionintervallines_view.Line";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    IntervalLinesData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamC_Subscriptioninterval_View_ID = vars.getSessionValue(tabId + "|paramC_Subscriptioninterval_View_ID");
String strParamLine = vars.getSessionValue(tabId + "|paramLine");
String strParamLineNetAmt = vars.getSessionValue(tabId + "|paramLineNetAmt");
String strParamLine_f = vars.getSessionValue(tabId + "|paramLine_f");
String strParamLineNetAmt_f = vars.getSessionValue(tabId + "|paramLineNetAmt_f");

    boolean hasSearchCondition=false;
    if (!(strParamC_Subscriptioninterval_View_ID.equals("") && strParamLine.equals("") && strParamLineNetAmt.equals("") && strParamLine_f.equals("") && strParamLineNetAmt_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = IntervalLinesData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Subscriptioninterval_View_ID, strC_Subscriptionintervallines_View_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_Subscriptionintervallines_View_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new IntervalLinesData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cSubscriptionintervallinesViewId") == null || dataField.getField("cSubscriptionintervallinesViewId").equals("")) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        boolNew = true;
      } else {
        discard[0] = new String ("newDiscard");
        strCommand = "EDIT";
      }
    }
    
        String strDOCBASETYPE = IntervalLinesData.selectAuxFC17DFE42B964D5A9AF556A2F1A13492(this, Utility.getContext(this, vars, "c_doctype_id", "143"));
    vars.setSessionValue(windowId + "|DOCBASETYPE", strDOCBASETYPE);
    
    
    if (dataField==null) {
      if (boolNew || data==null || data.length==0) {
        refreshSessionNew(vars, strPC_Subscriptioninterval_View_ID);
        data = IntervalLinesData.set(strPC_Subscriptioninterval_View_ID, Utility.getDefault(this, vars, "UpdatedBy", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), IntervalLinesData.selectDef5B279745ED3748BA9F47AE8CF7429546_0(this, Utility.getDefault(this, vars, "UpdatedBy", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField)), Utility.getDefault(this, vars, "Discount", "0", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "Scheddeliverydate", "@Scheddeliverydate@", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "C_Currency_ID", "@C_Currency_ID@", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "DateOrdered", "@DateOrdered@", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "Ignoreresidue", "N", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "N", dataField), "", Utility.getDefault(this, vars, "Ref_OrderLine_ID", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "Linegrossamt", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "QuantityOrder", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "LineNetAmt", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "M_Shipper_ID", "@M_Shipper_ID@", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), IntervalLinesData.selectDefFF567F89E6E44BE0B9635230964D3AAA(this, Utility.getContext(this, vars, "c_order_ID", "143")), Utility.getDefault(this, vars, "DatePromised", "@DatePromised@", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "PriceStd", "0", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), IntervalLinesData.selectDef400514558EEC48B89EB53EDF4B132CA1(this, Utility.getContext(this, vars, "c_order_ID", "143")), Utility.getDefault(this, vars, "Description", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "QtyDelivered", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "C_BPartner_Location_ID", "@C_BPartner_Location_ID@", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "Issummaryitem", "N", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "N", dataField), Utility.getDefault(this, vars, "DateDelivered", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "PriceLimit", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "Isgrossprice", "N", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "N", dataField), Utility.getDefault(this, vars, "C_UOM_ID", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "QtyReserved", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "Invoicedamt", "0", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), IntervalLinesData.selectDef685B417ACB3044BDB4EBA1272388DFE2_1(this, Utility.getDefault(this, vars, "CreatedBy", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField)), Utility.getDefault(this, vars, "M_AttributeSetInstance_ID", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), IntervalLinesData.selectDef2E892DA4D3134858A87CA976B303A3F1_2(this, Utility.getDefault(this, vars, "M_AttributeSetInstance_ID", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField)), Utility.getDefault(this, vars, "PriceList", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), IntervalLinesData.selectDef0D22CCF0AC2749A4A4F41B7472042F2A_3(this, Utility.getDefault(this, vars, "M_Product_ID", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField)), Utility.getDefault(this, vars, "IsDescription", "N", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "N", dataField), IntervalLinesData.selectDef3D84E9048403492EB9C62DD777F65845_4(this, strPC_Subscriptioninterval_View_ID), Utility.getDefault(this, vars, "FreightAmt", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "M_Offer_ID", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "QtyInvoiced", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "S_ResourceAssignment_ID", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), IntervalLinesData.selectDef1B89E4F709F4492B814FCFD40B326C34(this, Utility.getContext(this, vars, "c_order_ID", "143")), Utility.getDefault(this, vars, "CANCELPRICEAD", "N", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "N", dataField), Utility.getDefault(this, vars, "PriceActual", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "Linetaxamt", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "M_Product_Uom_Id", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "ChargeAmt", "0", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "DirectShip", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "N", dataField), IntervalLinesData.selectDef0ADC146B62014DDEB36538C37BF4B744(this, Utility.getContext(this, vars, "c_order_ID", "143")), IntervalLinesData.selectDef0ADC146B62014DDEB36538C37BF4B744_5(this, IntervalLinesData.selectDef0ADC146B62014DDEB36538C37BF4B744(this, Utility.getContext(this, vars, "c_order_ID", "143"))), Utility.getDefault(this, vars, "QtyOrdered", "1", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_Client_ID@", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), "Y", Utility.getDefault(this, vars, "Isonetimeposition", "N", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "N", dataField), Utility.getDefault(this, vars, "C_Charge_ID", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "M_Warehouse_ID", "@M_Warehouse_ID@", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), Utility.getDefault(this, vars, "DateInvoiced", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), IntervalLinesData.selectDefABCCB98672FD49109BAF16F9A0A0710F(this, Utility.getContext(this, vars, "C_Order_ID", "143")), Utility.getDefault(this, vars, "C_Tax_ID", "", "143", "21D5BDEE93C047CBA2BF24D24F5536BC", "", dataField), IntervalLinesData.selectDefD501463B963F43BFAEDC2E411D9535B8(this, Utility.getContext(this, vars, "C_Order_ID", "143")), IntervalLinesData.selectDefD501463B963F43BFAEDC2E411D9535B8_6(this, IntervalLinesData.selectDefD501463B963F43BFAEDC2E411D9535B8(this, Utility.getContext(this, vars, "C_Order_ID", "143"))));
        
      }
    } else {
      data = new IntervalLinesData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(IntervalLinesData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=SubscriptionIntervalsData.selectOrg(this, strPC_Subscriptioninterval_View_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "IntervalLines", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcSubscriptionintervallinesViewId", "", "..", "".equals("Y"), "SalesOrder", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_Subscriptionintervallines_View_ID));
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
      String result = "var strOrderType=\"" +Utility.getContext(this, vars, "OrderType", windowId) + "\";\nvar strProcessed=\"" +Utility.getContext(this, vars, "Processed", windowId) + "\";\nvar strC_DocTypeTarget_ID=\"" +Utility.getContext(this, vars, "C_DocTypeTarget_ID", windowId) + "\";\nvar strHASSECONDUOM=\"" +Utility.getContext(this, vars, "HASSECONDUOM", windowId) + "\";\nvar strDeliveryViaRule=\"" +Utility.getContext(this, vars, "DeliveryViaRule", windowId) + "\";\nvar strFreightCostRule=\"" +Utility.getContext(this, vars, "FreightCostRule", windowId) + "\";\nvar strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\nvar strProcessed=\"" + Utility.getContext(this, vars, "Processed", windowId) + "\";\n";
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPC_Subscriptioninterval_View_ID) throws IOException, ServletException {
    IntervalLinesData data = null;
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
            data = getEditVariables(con, vars, strPC_Subscriptioninterval_View_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.cSubscriptionintervallinesViewId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (IntervalLinesData.getCurrentDBTimestamp(this, data.cSubscriptionintervallinesViewId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cSubscriptionintervallinesViewId, vars, this);
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
                    data.cSubscriptionintervallinesViewId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_Subscriptionintervallines_View_ID", data.cSubscriptionintervallinesViewId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet IntervalLines. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
