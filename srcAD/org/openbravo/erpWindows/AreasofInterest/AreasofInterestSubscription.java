
package org.openbravo.erpWindows.AreasofInterest;





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

public class AreasofInterestSubscription extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(AreasofInterestSubscription.class);
  
  private static final String windowId = "245";
  private static final String tabId = "536";
  private static final String defaultTabView = "RELATION";
  private static final int accesslevel = 7;
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
        String strrContactinterestId = request.getParameter("inprContactinterestId");
         String strPR_InterestArea_ID = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strrContactinterestId.equals(""))
              total = saveRecord(vars, myError, 'U', strPR_InterestArea_ID);
          else
              total = saveRecord(vars, myError, 'I', strPR_InterestArea_ID);
          
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
      String strPR_InterestArea_ID = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID", "");

      String strR_ContactInterest_ID = vars.getGlobalVariable("inprContactinterestId", windowId + "|R_ContactInterest_ID", "");
            if (strPR_InterestArea_ID.equals("")) {
        strPR_InterestArea_ID = getParentID(vars, strR_ContactInterest_ID);
        if (strPR_InterestArea_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|R_InterestArea_ID");
        vars.setSessionValue(windowId + "|R_InterestArea_ID", strPR_InterestArea_ID);

        refreshParentSession(vars, strPR_InterestArea_ID);
      }


      String strView = vars.getSessionValue(tabId + "|AreasofInterestSubscription.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strR_ContactInterest_ID.equals("")) strR_ContactInterest_ID = firstElement(vars, tableSQL);
          if (strR_ContactInterest_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strR_ContactInterest_ID, strPR_InterestArea_ID, tableSQL);

      else printPageDataSheet(response, vars, strPR_InterestArea_ID, strR_ContactInterest_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strR_ContactInterest_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strR_ContactInterest_ID.equals("")) strR_ContactInterest_ID = vars.getRequiredGlobalVariable("inprContactinterestId", windowId + "|R_ContactInterest_ID");
      else vars.setSessionValue(windowId + "|R_ContactInterest_ID", strR_ContactInterest_ID);
      
      
      String strPR_InterestArea_ID = getParentID(vars, strR_ContactInterest_ID);
      
      vars.setSessionValue(windowId + "|R_InterestArea_ID", strPR_InterestArea_ID);
      vars.setSessionValue("null|null.view", "EDIT");

      refreshParentSession(vars, strPR_InterestArea_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|AreasofInterestSubscription.view", "EDIT");

        printPageEdit(response, request, vars, false, strR_ContactInterest_ID, strPR_InterestArea_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|AreasofInterestSubscription.view", "RELATION");
        printPageDataSheet(response, vars, strPR_InterestArea_ID, strR_ContactInterest_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPR_InterestArea_ID = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|R_ContactInterest_ID");
      refreshParentSession(vars, strPR_InterestArea_ID);


      String strView = vars.getSessionValue(tabId + "|AreasofInterestSubscription.view");
      String strR_ContactInterest_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strR_ContactInterest_ID = firstElement(vars, tableSQL);
          if (strR_ContactInterest_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strR_ContactInterest_ID.equals("")) strR_ContactInterest_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strR_ContactInterest_ID, strPR_InterestArea_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPR_InterestArea_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamAD_User_ID", tabId + "|paramAD_User_ID");
vars.getRequestGlobalVariable("inpParamR_InterestArea_ID", tabId + "|paramR_InterestArea_ID");

            String strPR_InterestArea_ID = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID");

      
      vars.removeSessionValue(windowId + "|R_ContactInterest_ID");
      String strR_ContactInterest_ID="";

      String strView = vars.getSessionValue(tabId + "|AreasofInterestSubscription.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strR_ContactInterest_ID = firstElement(vars, tableSQL);
        if (strR_ContactInterest_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|AreasofInterestSubscription.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strR_ContactInterest_ID, strPR_InterestArea_ID, tableSQL);

      else printPageDataSheet(response, vars, strPR_InterestArea_ID, strR_ContactInterest_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPR_InterestArea_ID = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID");
      

      String strR_ContactInterest_ID = vars.getGlobalVariable("inprContactinterestId", windowId + "|R_ContactInterest_ID", "");
      vars.setSessionValue(tabId + "|AreasofInterestSubscription.view", "RELATION");
      printPageDataSheet(response, vars, strPR_InterestArea_ID, strR_ContactInterest_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPR_InterestArea_ID = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID");


      printPageEdit(response, request, vars, true, "", strPR_InterestArea_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPR_InterestArea_ID = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strR_ContactInterest_ID = vars.getGlobalVariable("inprContactinterestId", windowId + "|R_ContactInterest_ID", "");
      vars.setSessionValue(tabId + "|AreasofInterestSubscription.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strR_ContactInterest_ID, strPR_InterestArea_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPR_InterestArea_ID = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID");
      String strR_ContactInterest_ID = vars.getRequiredStringParameter("inprContactinterestId");
      
      String strNext = nextElement(vars, strR_ContactInterest_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPR_InterestArea_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPR_InterestArea_ID = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID");
      String strR_ContactInterest_ID = vars.getRequiredStringParameter("inprContactinterestId");
      
      String strPrevious = previousElement(vars, strR_ContactInterest_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPR_InterestArea_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID");

      vars.setSessionValue(tabId + "|AreasofInterestSubscription.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPR_InterestArea_ID = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|AreasofInterestSubscription.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|AreasofInterestSubscription.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|AreasofInterestSubscription.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|R_ContactInterest_ID");
      vars.setSessionValue(windowId + "|R_InterestArea_ID", strPR_InterestArea_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPR_InterestArea_ID = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|AreasofInterestSubscription.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|AreasofInterestSubscription.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|R_ContactInterest_ID");
      vars.setSessionValue(windowId + "|R_InterestArea_ID", strPR_InterestArea_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPR_InterestArea_ID = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPR_InterestArea_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPR_InterestArea_ID = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPR_InterestArea_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPR_InterestArea_ID = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPR_InterestArea_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPR_InterestArea_ID = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPR_InterestArea_ID);      
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
      String strPR_InterestArea_ID = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID");
      String strR_ContactInterest_ID = vars.getRequiredGlobalVariable("inprContactinterestId", windowId + "|R_ContactInterest_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPR_InterestArea_ID);      
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
          String strNext = nextElement(vars, strR_ContactInterest_ID, tableSQL);
          vars.setSessionValue(windowId + "|R_ContactInterest_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPR_InterestArea_ID = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID");

      String strR_ContactInterest_ID = vars.getRequiredInStringParameter("inprContactinterestId");
      String message = deleteRelation(vars, strR_ContactInterest_ID, strPR_InterestArea_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|rContactinterestId");
        vars.setSessionValue(tabId + "|AreasofInterestSubscription.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPR_InterestArea_ID = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID");

      String strR_ContactInterest_ID = vars.getRequiredStringParameter("inprContactinterestId");
      //AreasofInterestSubscriptionData data = getEditVariables(vars, strPR_InterestArea_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = AreasofInterestSubscriptionData.delete(this, strR_ContactInterest_ID, strPR_InterestArea_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|rContactinterestId");
        vars.setSessionValue(tabId + "|AreasofInterestSubscription.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strR_ContactInterest_ID, String strPR_InterestArea_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strR_ContactInterest_ID.startsWith("(")) strR_ContactInterest_ID = strR_ContactInterest_ID.substring(1, strR_ContactInterest_ID.length()-1);
      if (!strR_ContactInterest_ID.equals("")) {
        strR_ContactInterest_ID = Replace.replace(strR_ContactInterest_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strR_ContactInterest_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (AreasofInterestSubscriptionData.deleteTransactional(conn, this, strKey, strPR_InterestArea_ID)==0) {
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
  private AreasofInterestSubscriptionData getEditVariables(Connection con, VariablesSecureApp vars, String strPR_InterestArea_ID) throws IOException,ServletException {
    AreasofInterestSubscriptionData data = new AreasofInterestSubscriptionData();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.rInterestareaId = vars.getStringParameter("inprInterestareaId");     data.rInterestareaIdr = vars.getStringParameter("inprInterestareaId_R");     data.adUserId = vars.getStringParameter("inpadUserId");     data.adUserIdr = vars.getStringParameter("inpadUserId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.subscribedate = vars.getStringParameter("inpsubscribedate");     data.optoutdate = vars.getStringParameter("inpoptoutdate");     data.rContactinterestId = vars.getRequestGlobalVariable("inprContactinterestId", windowId + "|R_ContactInterest_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.rInterestareaId = vars.getGlobalVariable("inprInterestareaId", windowId + "|R_InterestArea_ID");


    
    

    
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

   private AreasofInterestSubscriptionData[] getRelationData(AreasofInterestSubscriptionData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].rInterestareaId = FormatUtilities.truncate(data[i].rInterestareaId, 44);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 44);        data[i].rContactinterestId = FormatUtilities.truncate(data[i].rContactinterestId, 1);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPR_InterestArea_ID) throws IOException,ServletException {
      AreasofInterestData[] data = AreasofInterestData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPR_InterestArea_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|R_InterestArea_ID", data[0].rInterestareaId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);
      vars.setSessionValue(windowId + "|R_InterestArea_ID", strPR_InterestArea_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strR_ContactInterest_ID) throws ServletException {
    String strPR_InterestArea_ID = AreasofInterestSubscriptionData.selectParentID(this, strR_ContactInterest_ID);
    if (strPR_InterestArea_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strR_ContactInterest_ID);
      throw new ServletException("Parent record not found");
    }
    return strPR_InterestArea_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|R_ContactInterest_ID", data[0].getField("rContactinterestId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPR_InterestArea_ID) throws IOException,ServletException {
      AreasofInterestSubscriptionData[] data = AreasofInterestSubscriptionData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), Utility.getContext(this, vars, "R_InterestArea_ID", windowId), strPR_InterestArea_ID, vars.getStringParameter("inprContactinterestId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPR_InterestArea_ID, String strR_ContactInterest_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamAD_User_ID = vars.getSessionValue(tabId + "|paramAD_User_ID");
String strParamR_InterestArea_ID = vars.getSessionValue(tabId + "|paramR_InterestArea_ID");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamAD_User_ID.equals("") && strParamR_InterestArea_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strR_ContactInterest_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strR_ContactInterest_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/AreasofInterest/AreasofInterestSubscription_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "AreasofInterestSubscription", false, "document.frmMain.inprContactinterestId", "grid", "..", "".equals("Y"), "AreasofInterest", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPR_InterestArea_ID);

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
    xmlDocument.setParameter("KeyName", "rContactinterestId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "AreasofInterestSubscription_Relation.html", "AreasofInterest", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "AreasofInterestSubscription_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", AreasofInterestSubscriptionData.selectParent(this, strPR_InterestArea_ID));
    else xmlDocument.setParameter("parent", AreasofInterestSubscriptionData.selectParentTrl(this, strPR_InterestArea_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strR_ContactInterest_ID, String strPR_InterestArea_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = "  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') )";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    AreasofInterestSubscriptionData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamAD_User_ID = vars.getSessionValue(tabId + "|paramAD_User_ID");
String strParamR_InterestArea_ID = vars.getSessionValue(tabId + "|paramR_InterestArea_ID");

    boolean hasSearchCondition=false;
    if (!(strParamAD_User_ID.equals("") && strParamR_InterestArea_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = AreasofInterestSubscriptionData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), Utility.getContext(this, vars, "R_InterestArea_ID", windowId), strPR_InterestArea_ID, strR_ContactInterest_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strR_ContactInterest_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new AreasofInterestSubscriptionData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("rContactinterestId") == null || dataField.getField("rContactinterestId").equals("")) {
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
        refreshSessionNew(vars, strPR_InterestArea_ID);
        data = AreasofInterestSubscriptionData.set(strPR_InterestArea_ID, Utility.getDefault(this, vars, "SubscribeDate", "", "245", "536", "", dataField), Utility.getDefault(this, vars, "OptOutDate", "", "245", "536", "", dataField), "Y", "", Utility.getDefault(this, vars, "CreatedBy", "", "245", "536", "", dataField), AreasofInterestSubscriptionData.selectDef7762_0(this, Utility.getDefault(this, vars, "CreatedBy", "", "245", "536", "", dataField)), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "245", "536", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "245", "536", "", dataField), AreasofInterestSubscriptionData.selectDef7763_1(this, Utility.getDefault(this, vars, "UpdatedBy", "", "245", "536", "", dataField)), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "245", "536", "", dataField), Utility.getDefault(this, vars, "AD_User_ID", "", "245", "536", "", dataField));
        
      }
    } else {
      data = new AreasofInterestSubscriptionData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(AreasofInterestSubscriptionData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=AreasofInterestData.selectOrg(this, strPR_InterestArea_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "AreasofInterestSubscription", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inprContactinterestId", "", "..", "".equals("Y"), "AreasofInterest", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strR_ContactInterest_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPR_InterestArea_ID) throws IOException, ServletException {
    AreasofInterestSubscriptionData data = null;
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
            data = getEditVariables(con, vars, strPR_InterestArea_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.rContactinterestId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (AreasofInterestSubscriptionData.getCurrentDBTimestamp(this, data.rContactinterestId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.rContactinterestId, vars, this);
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
                    data.rContactinterestId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|R_ContactInterest_ID", data.rContactinterestId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet AreasofInterestSubscription. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
