
package org.openbravo.erpWindows.User;





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

public class User extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(User.class);
  
  private static final String windowId = "108";
  private static final String tabId = "118";
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
        String stradUserId = request.getParameter("inpadUserId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !stradUserId.equals(""))
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

      String strAD_User_ID = vars.getGlobalVariable("inpadUserId", windowId + "|AD_User_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|User.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strAD_User_ID.equals("")) strAD_User_ID = firstElement(vars, tableSQL);
          if (strAD_User_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strAD_User_ID, tableSQL);

      else printPageDataSheet(response, vars, strAD_User_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strAD_User_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strAD_User_ID.equals("")) strAD_User_ID = vars.getRequiredGlobalVariable("inpadUserId", windowId + "|AD_User_ID");
      else vars.setSessionValue(windowId + "|AD_User_ID", strAD_User_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|User.view", "EDIT");

        printPageEdit(response, request, vars, false, strAD_User_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|User.view", "RELATION");
        printPageDataSheet(response, vars, strAD_User_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|User.view");
      String strAD_User_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strAD_User_ID = firstElement(vars, tableSQL);
          if (strAD_User_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strAD_User_ID.equals("")) strAD_User_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strAD_User_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamUserName", tabId + "|paramUserName");

      
      
      vars.removeSessionValue(windowId + "|AD_User_ID");
      String strAD_User_ID="";

      String strView = vars.getSessionValue(tabId + "|User.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strAD_User_ID = firstElement(vars, tableSQL);
        if (strAD_User_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|User.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strAD_User_ID, tableSQL);

      else printPageDataSheet(response, vars, strAD_User_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strAD_User_ID = vars.getGlobalVariable("inpadUserId", windowId + "|AD_User_ID", "");
      vars.setSessionValue(tabId + "|User.view", "RELATION");
      printPageDataSheet(response, vars, strAD_User_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strAD_User_ID = vars.getGlobalVariable("inpadUserId", windowId + "|AD_User_ID", "");
      vars.setSessionValue(tabId + "|User.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strAD_User_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strAD_User_ID = vars.getRequiredStringParameter("inpadUserId");
      
      String strNext = nextElement(vars, strAD_User_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strAD_User_ID = vars.getRequiredStringParameter("inpadUserId");
      
      String strPrevious = previousElement(vars, strAD_User_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|User.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|User.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|User.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|User.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|AD_User_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|User.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|User.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|AD_User_ID");

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

      String strAD_User_ID = vars.getRequiredGlobalVariable("inpadUserId", windowId + "|AD_User_ID");
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
          String strNext = nextElement(vars, strAD_User_ID, tableSQL);
          vars.setSessionValue(windowId + "|AD_User_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strAD_User_ID = vars.getRequiredInStringParameter("inpadUserId");
      String message = deleteRelation(vars, strAD_User_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|adUserId");
        vars.setSessionValue(tabId + "|User.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strAD_User_ID = vars.getRequiredStringParameter("inpadUserId");
      //UserData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = UserData.delete(this, strAD_User_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|adUserId");
        vars.setSessionValue(tabId + "|User.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());






    } else if (vars.commandIn("BUTTONPassword")) {
        String strAD_User_ID = vars.getGlobalVariable("inpadUserId", windowId + "|AD_User_ID", "");
        
        printPageButtonPassword(request, response, vars, strAD_User_ID);

    } else if (vars.commandIn("SAVE_BUTTONPassword")) {
        String strAD_User_ID = vars.getGlobalVariable("inpKey", windowId + "|AD_User_ID", "");
        String strPassword = FormatUtilities.sha1Base64(vars.getStringParameter("inpValue"));



        OBError myError = null;
        int count = 0;
        try {
          count = UserData.updatepassword(this, strPassword, strAD_User_ID);
        } catch(ServletException ex) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myError.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myError);
        }
        if (myError==null) {
          myError = new OBError();
          if (count==0) {
            myError.setTitle(Utility.messageBD(this, "Error", vars.getLanguage()));
            myError.setType("Error");            
          } else {
            myError.setTitle(Utility.messageBD(this, "Success", vars.getLanguage()));
            myError.setType("Success");
          }
          vars.setMessage(tabId, myError);
        }
        if (log4j.isDebugEnabled() && myError!=null) log4j.debug(myError.getMessage());
        printPageClosePopUp(response, vars);

    } else if (vars.getCommand().toUpperCase().startsWith("BUTTON") || vars.getCommand().toUpperCase().startsWith("SAVE_BUTTON")) {
      pageErrorPopUp(response);
    } else pageError(response);
  }
/*
  String deleteRelation(VariablesSecureApp vars, String strAD_User_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strAD_User_ID.startsWith("(")) strAD_User_ID = strAD_User_ID.substring(1, strAD_User_ID.length()-1);
      if (!strAD_User_ID.equals("")) {
        strAD_User_ID = Replace.replace(strAD_User_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strAD_User_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (UserData.deleteTransactional(conn, this, strKey)==0) {
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
  private UserData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    UserData data = new UserData();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.name = vars.getStringParameter("inpname");     data.description = vars.getStringParameter("inpdescription");     data.comments = vars.getStringParameter("inpcomments");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.username = vars.getStringParameter("inpusername");     data.password = FormatUtilities.sha1Base64(vars.getStringParameter("inppassword"));     data.adOrgtrxId = vars.getStringParameter("inpadOrgtrxId");     data.defaultAdRoleId = vars.getStringParameter("inpdefaultAdRoleId");     data.defaultAdRoleIdr = vars.getStringParameter("inpdefaultAdRoleId_R");     data.defaultAdLanguage = vars.getStringParameter("inpdefaultAdLanguage");     data.defaultAdLanguager = vars.getStringParameter("inpdefaultAdLanguage_R");     data.defaultAdClientId = vars.getStringParameter("inpdefaultAdClientId");     data.defaultAdClientIdr = vars.getStringParameter("inpdefaultAdClientId_R");     data.defaultAdOrgId = vars.getStringParameter("inpdefaultAdOrgId");     data.defaultAdOrgIdr = vars.getStringParameter("inpdefaultAdOrgId_R");     data.defaultMWarehouseId = vars.getStringParameter("inpdefaultMWarehouseId");     data.defaultMWarehouseIdr = vars.getStringParameter("inpdefaultMWarehouseId_R");     data.phone2 = vars.getStringParameter("inpphone2");     data.birthday = vars.getStringParameter("inpbirthday");     data.cBpartnerLocationId = vars.getStringParameter("inpcBpartnerLocationId");     data.phone = vars.getStringParameter("inpphone");     data.fax = vars.getStringParameter("inpfax");     data.lastresult = vars.getStringParameter("inplastresult");     data.lastcontact = vars.getStringParameter("inplastcontact");     data.title = vars.getStringParameter("inptitle");     data.cGreetingId = vars.getStringParameter("inpcGreetingId");     data.firstname = vars.getStringParameter("inpfirstname");     data.lastname = vars.getStringParameter("inplastname");     data.emailuserpw = FormatUtilities.encryptDecrypt(vars.getStringParameter("inpemailuserpw"), true);     data.emailuser = vars.getStringParameter("inpemailuser");     data.processing = vars.getStringParameter("inpprocessing");     data.supervisorId = vars.getStringParameter("inpsupervisorId");     data.email = vars.getStringParameter("inpemail");     data.adUserId = vars.getRequestGlobalVariable("inpadUserId", windowId + "|AD_User_ID"); 
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

   private UserData[] getRelationData(UserData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].name = FormatUtilities.truncate(data[i].name, 30);        data[i].description = FormatUtilities.truncate(data[i].description, 20);        data[i].comments = FormatUtilities.truncate(data[i].comments, 20);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 30);        data[i].username = FormatUtilities.truncate(data[i].username, 10);        data[i].password = FormatUtilities.truncate(data[i].password, 10);        data[i].adOrgtrxId = FormatUtilities.truncate(data[i].adOrgtrxId, 20);        data[i].defaultAdRoleId = FormatUtilities.truncate(data[i].defaultAdRoleId, 10);        data[i].defaultAdLanguage = FormatUtilities.truncate(data[i].defaultAdLanguage, 20);        data[i].defaultAdClientId = FormatUtilities.truncate(data[i].defaultAdClientId, 20);        data[i].defaultAdOrgId = FormatUtilities.truncate(data[i].defaultAdOrgId, 20);        data[i].defaultMWarehouseId = FormatUtilities.truncate(data[i].defaultMWarehouseId, 20);        data[i].phone2 = FormatUtilities.truncate(data[i].phone2, 20);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 30);        data[i].phone = FormatUtilities.truncate(data[i].phone, 30);        data[i].fax = FormatUtilities.truncate(data[i].fax, 30);        data[i].lastresult = FormatUtilities.truncate(data[i].lastresult, 20);        data[i].title = FormatUtilities.truncate(data[i].title, 30);        data[i].cGreetingId = FormatUtilities.truncate(data[i].cGreetingId, 10);        data[i].firstname = FormatUtilities.truncate(data[i].firstname, 30);        data[i].lastname = FormatUtilities.truncate(data[i].lastname, 30);        data[i].emailuserpw = FormatUtilities.truncate(data[i].emailuserpw, 20);        data[i].emailuser = FormatUtilities.truncate(data[i].emailuser, 20);        data[i].supervisorId = FormatUtilities.truncate(data[i].supervisorId, 20);        data[i].email = FormatUtilities.truncate(data[i].email, 40);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 10);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|AD_User_ID", data[0].getField("adUserId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      UserData[] data = UserData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpadUserId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strAD_User_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamUserName = vars.getSessionValue(tabId + "|paramUserName");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamName.equals("") && strParamUserName.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strAD_User_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strAD_User_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/User/User_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "User", false, "document.frmMain.inpadUserId", "grid", "..", "".equals("Y"), "User", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "adUserId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "User_Relation.html", "User", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "User_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strAD_User_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " AD_User.Name";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    UserData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamUserName = vars.getSessionValue(tabId + "|paramUserName");

    boolean hasSearchCondition=false;
    if (!(strParamName.equals("") && strParamUserName.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = UserData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strAD_User_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strAD_User_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new UserData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("adUserId") == null || dataField.getField("adUserId").equals("")) {
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
        data = UserData.set(Utility.getDefault(this, vars, "C_BPartner_Location_ID", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "Default_Ad_Org_ID", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "EmailUser", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "EmailUserPW", "", "108", "118", "", dataField), "Y", Utility.getDefault(this, vars, "Supervisor_ID", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "Firstname", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "LastContact", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "Default_Ad_Language", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "Default_Ad_Role_ID", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "Birthday", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "Processing", "", "108", "118", "N", dataField), Utility.getDefault(this, vars, "Name", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "108", "118", "", dataField), "", Utility.getDefault(this, vars, "Default_Ad_Client_ID", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "UserName", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "Email", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "108", "118", "", dataField), Utility.getDefault(this, vars, "Fax", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "Password", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "Default_M_Warehouse_ID", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "C_Greeting_ID", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "Title", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "Comments", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "Phone", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "Lastname", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "108", "118", "", dataField), UserData.selectDef626_0(this, Utility.getDefault(this, vars, "UpdatedBy", "", "108", "118", "", dataField)), Utility.getDefault(this, vars, "AD_OrgTrx_ID", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "Description", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "C_BPartner_ID", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "LastResult", "", "108", "118", "", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "108", "118", "", dataField), UserData.selectDef624_1(this, Utility.getDefault(this, vars, "CreatedBy", "", "108", "118", "", dataField)), Utility.getDefault(this, vars, "Phone2", "", "108", "118", "", dataField));
        
      }
    } else {
      data = new UserData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(UserData) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "User", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpadUserId", "", "..", "".equals("Y"), "User", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strAD_User_ID));
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
      String result = "var strautosave=\"" +Utility.getContext(this, vars, "autosave", windowId) + "\";\nvar strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\n";
      return result;
    }


    private String getReadOnlyLogicContext(VariablesSecureApp vars) throws IOException, ServletException {
      log4j.debug("Output: Read Only logic context fields");
      String result = "";
      return result;
    }


    void printPageButtonPassword(HttpServletRequest request, HttpServletResponse response, VariablesSecureApp vars, String strAD_User_ID)
    throws IOException, ServletException {
      log4j.debug("Output: Button Encrypted Password");
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EncryptedButtons").createXmlDocument();

      if (UserData.checkpassword(this, strAD_User_ID).equals("0")) {
        bdErrorGeneralPopUp(request, response,Utility.messageBD(this,"Error", vars.getLanguage()),Utility.messageBD(this,"SaveAndTry", vars.getLanguage()));
      } else {
        xmlDocument.setParameter("theme", vars.getTheme());
        xmlDocument.setParameter("realName", "Password");
        xmlDocument.setParameter("key", strAD_User_ID);
        xmlDocument.setParameter("keyName", "adUserId");
        xmlDocument.setParameter("form", "User_Edition.html");
        xmlDocument.setParameter("fieldId", "302");
        xmlDocument.setParameter("fieldLabel", Utility.messageBD(this, "Password", vars.getLanguage()));
        xmlDocument.setParameter("fieldColumnName", "Password");
        
        xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
        xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
        xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
        xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
  
        out.println(xmlDocument.print());
      }
      out.close();
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
    UserData data = null;
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
                data.adUserId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (UserData.getCurrentDBTimestamp(this, data.adUserId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.adUserId, vars, this);
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
                    data.adUserId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|AD_User_ID", data.adUserId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet User. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
