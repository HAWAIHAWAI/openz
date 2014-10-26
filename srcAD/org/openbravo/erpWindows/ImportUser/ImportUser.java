
package org.openbravo.erpWindows.ImportUser;


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

public class ImportUser extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(ImportUser.class);
  
  private static final String windowId = "025F7B201CC2452A8B11A30F981DD49F";
  private static final String tabId = "13EB71BFF9954684BB803656D3EB188F";
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
        String striUserId = request.getParameter("inpiUserId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !striUserId.equals(""))
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

      String strI_User_ID = vars.getGlobalVariable("inpiUserId", windowId + "|I_User_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|ImportUser.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strI_User_ID.equals("")) strI_User_ID = firstElement(vars, tableSQL);
          if (strI_User_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strI_User_ID, tableSQL);

      else printPageDataSheet(response, vars, strI_User_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strI_User_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strI_User_ID.equals("")) strI_User_ID = vars.getRequiredGlobalVariable("inpiUserId", windowId + "|I_User_ID");
      else vars.setSessionValue(windowId + "|I_User_ID", strI_User_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|ImportUser.view", "EDIT");

        printPageEdit(response, request, vars, false, strI_User_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|ImportUser.view", "RELATION");
        printPageDataSheet(response, vars, strI_User_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|ImportUser.view");
      String strI_User_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strI_User_ID = firstElement(vars, tableSQL);
          if (strI_User_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strI_User_ID.equals("")) strI_User_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strI_User_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");

      
      
      vars.removeSessionValue(windowId + "|I_User_ID");
      String strI_User_ID="";

      String strView = vars.getSessionValue(tabId + "|ImportUser.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strI_User_ID = firstElement(vars, tableSQL);
        if (strI_User_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|ImportUser.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strI_User_ID, tableSQL);

      else printPageDataSheet(response, vars, strI_User_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strI_User_ID = vars.getGlobalVariable("inpiUserId", windowId + "|I_User_ID", "");
      vars.setSessionValue(tabId + "|ImportUser.view", "RELATION");
      printPageDataSheet(response, vars, strI_User_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strI_User_ID = vars.getGlobalVariable("inpiUserId", windowId + "|I_User_ID", "");
      vars.setSessionValue(tabId + "|ImportUser.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strI_User_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strI_User_ID = vars.getRequiredStringParameter("inpiUserId");
      
      String strNext = nextElement(vars, strI_User_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strI_User_ID = vars.getRequiredStringParameter("inpiUserId");
      
      String strPrevious = previousElement(vars, strI_User_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|ImportUser.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|ImportUser.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|ImportUser.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|ImportUser.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|I_User_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|ImportUser.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|ImportUser.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|I_User_ID");

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

      String strI_User_ID = vars.getRequiredGlobalVariable("inpiUserId", windowId + "|I_User_ID");
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
          String strNext = nextElement(vars, strI_User_ID, tableSQL);
          vars.setSessionValue(windowId + "|I_User_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strI_User_ID = vars.getRequiredInStringParameter("inpiUserId");
      String message = deleteRelation(vars, strI_User_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|iUserId");
        vars.setSessionValue(tabId + "|ImportUser.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strI_User_ID = vars.getRequiredStringParameter("inpiUserId");
      //ImportUserData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = ImportUserData.delete(this, strI_User_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|iUserId");
        vars.setSessionValue(tabId + "|ImportUser.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONBtnprocess2FE6CA5330DB43A8861F7BFAA62E896B")) {
        vars.setSessionValue("button2FE6CA5330DB43A8861F7BFAA62E896B.strbtnprocess", vars.getStringParameter("inpbtnprocess"));
        vars.setSessionValue("button2FE6CA5330DB43A8861F7BFAA62E896B.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button2FE6CA5330DB43A8861F7BFAA62E896B.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button2FE6CA5330DB43A8861F7BFAA62E896B.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button2FE6CA5330DB43A8861F7BFAA62E896B.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "2FE6CA5330DB43A8861F7BFAA62E896B", request.getServletPath());    
     } else if (vars.commandIn("BUTTON2FE6CA5330DB43A8861F7BFAA62E896B")) {
        String strI_User_ID = vars.getGlobalVariable("inpiUserId", windowId + "|I_User_ID", "");
        String strbtnprocess = vars.getSessionValue("button2FE6CA5330DB43A8861F7BFAA62E896B.strbtnprocess");
        String strProcessing = vars.getSessionValue("button2FE6CA5330DB43A8861F7BFAA62E896B.strProcessing");
        String strOrg = vars.getSessionValue("button2FE6CA5330DB43A8861F7BFAA62E896B.strOrg");
        String strClient = vars.getSessionValue("button2FE6CA5330DB43A8861F7BFAA62E896B.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBtnprocess2FE6CA5330DB43A8861F7BFAA62E896B(response, vars, strI_User_ID, strbtnprocess, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONBtnprocess2FE6CA5330DB43A8861F7BFAA62E896B")) {
        String strI_User_ID = vars.getGlobalVariable("inpKey", windowId + "|I_User_ID", "");
        @SuppressWarnings("unused")
        String strbtnprocess = vars.getStringParameter("inpbtnprocess");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "2FE6CA5330DB43A8861F7BFAA62E896B", (("I_User_ID".equalsIgnoreCase("AD_Language"))?"0":strI_User_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
  String deleteRelation(VariablesSecureApp vars, String strI_User_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strI_User_ID.startsWith("(")) strI_User_ID = strI_User_ID.substring(1, strI_User_ID.length()-1);
      if (!strI_User_ID.equals("")) {
        strI_User_ID = Replace.replace(strI_User_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strI_User_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (ImportUserData.deleteTransactional(conn, this, strKey)==0) {
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
  private ImportUserData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    ImportUserData data = new ImportUserData();
    ServletException ex = null;
    try {
    data.isimported = vars.getStringParameter("inpisimported", "N");     data.iUserId = vars.getRequestGlobalVariable("inpiUserId", windowId + "|I_User_ID");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cGreetingId = vars.getStringParameter("inpcGreetingId");     data.firstname = vars.getStringParameter("inpfirstname");     data.lastname = vars.getStringParameter("inplastname");     data.name = vars.getStringParameter("inpname");     data.enumber = vars.getStringParameter("inpenumber");     data.birthday = vars.getStringParameter("inpbirthday");     data.title = vars.getStringParameter("inptitle");     data.email = vars.getStringParameter("inpemail");     data.phone = vars.getStringParameter("inpphone");     data.phone2 = vars.getStringParameter("inpphone2");     data.fax = vars.getStringParameter("inpfax");     data.description = vars.getStringParameter("inpdescription");     data.comments = vars.getStringParameter("inpcomments");     data.cBpartnerLocationId = vars.getStringParameter("inpcBpartnerLocationId");     data.username = vars.getStringParameter("inpusername");     data.password = vars.getStringParameter("inppassword");     data.emailuser = vars.getStringParameter("inpemailuser");     data.emailuserpw = vars.getStringParameter("inpemailuserpw");     data.supervisorId = vars.getStringParameter("inpsupervisorId");     data.lastresult = vars.getStringParameter("inplastresult");     data.lastcontact = vars.getStringParameter("inplastcontact");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.processing = vars.getStringParameter("inpprocessing", "N");     data.adOrgtrxId = vars.getStringParameter("inpadOrgtrxId");     data.defaultAdRoleId = vars.getStringParameter("inpdefaultAdRoleId");     data.defaultAdLanguage = vars.getStringParameter("inpdefaultAdLanguage");     data.defaultAdClientId = vars.getStringParameter("inpdefaultAdClientId");     data.defaultAdOrgId = vars.getStringParameter("inpdefaultAdOrgId");     data.defaultMWarehouseId = vars.getStringParameter("inpdefaultMWarehouseId");     data.btnprocess = vars.getStringParameter("inpbtnprocess");     data.branche = vars.getStringParameter("inpbranche");     data.land = vars.getStringParameter("inpland");     data.kunde = vars.getStringParameter("inpkunde");     data.klinikkunde = vars.getStringParameter("inpklinikkunde");     data.stippvisitenkunde = vars.getStringParameter("inpstippvisitenkunde");     data.mailingzielgruppe = vars.getStringParameter("inpmailingzielgruppe");     data.geschaeftsfuehrer = vars.getStringParameter("inpgeschaeftsfuehrer");     data.einkauf = vars.getStringParameter("inpeinkauf");     data.marktforschung = vars.getStringParameter("inpmarktforschung");     data.marketing = vars.getStringParameter("inpmarketing");     data.blockbuster = vars.getStringParameter("inpblockbuster");     data.emarketing = vars.getStringParameter("inpemarketing");     data.aussendienst = vars.getStringParameter("inpaussendienst");     data.klinik = vars.getStringParameter("inpklinik");     data.it = vars.getStringParameter("inpit");     data.unternehmenskommunikation = vars.getStringParameter("inpunternehmenskommunikation");     data.medicaleducation = vars.getStringParameter("inpmedicaleducation");     data.nis = vars.getStringParameter("inpnis");     data.medwissen = vars.getStringParameter("inpmedwissen");     data.training = vars.getStringParameter("inptraining");     data.humanresources = vars.getStringParameter("inphumanresources");     data.veranstaltungsmanagement = vars.getStringParameter("inpveranstaltungsmanagement");     data.geschaeftsentwicklung = vars.getStringParameter("inpgeschaeftsentwicklung");     data.presse = vars.getStringParameter("inppresse");     data.prominenter = vars.getStringParameter("inpprominenter");     data.kol = vars.getStringParameter("inpkol");     data.kooperation = vars.getStringParameter("inpkooperation");     data.schluesselkontakt = vars.getStringParameter("inpschluesselkontakt");     data.persoenlicherkontakt2008 = vars.getStringParameter("inppersoenlicherkontakt2008");     data.persoenlicherkontakt2009 = vars.getStringParameter("inppersoenlicherkontakt2009");     data.persoenlicherkontakt2010 = vars.getStringParameter("inppersoenlicherkontakt2010");     data.persoenlicherkontakt2011 = vars.getStringParameter("inppersoenlicherkontakt2011");     data.hobby = vars.getStringParameter("inphobby");     data.communityzugehoerigkeit = vars.getStringParameter("inpcommunityzugehoerigkeit");     data.planung = vars.getStringParameter("inpplanung");     data.positionfunktion = vars.getStringParameter("inppositionfunktion");     data.abteilungbereich = vars.getStringParameter("inpabteilungbereich");     data.sachgebiet = vars.getStringParameter("inpsachgebiet"); 
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

   private ImportUserData[] getRelationData(ImportUserData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].iUserId = FormatUtilities.truncate(data[i].iUserId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 50);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 50);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 50);        data[i].cGreetingId = FormatUtilities.truncate(data[i].cGreetingId, 50);        data[i].firstname = FormatUtilities.truncate(data[i].firstname, 50);        data[i].lastname = FormatUtilities.truncate(data[i].lastname, 50);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].enumber = FormatUtilities.truncate(data[i].enumber, 40);        data[i].title = FormatUtilities.truncate(data[i].title, 40);        data[i].email = FormatUtilities.truncate(data[i].email, 40);        data[i].phone = FormatUtilities.truncate(data[i].phone, 40);        data[i].phone2 = FormatUtilities.truncate(data[i].phone2, 40);        data[i].fax = FormatUtilities.truncate(data[i].fax, 40);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].comments = FormatUtilities.truncate(data[i].comments, 50);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 50);        data[i].username = FormatUtilities.truncate(data[i].username, 50);        data[i].password = FormatUtilities.truncate(data[i].password, 40);        data[i].emailuser = FormatUtilities.truncate(data[i].emailuser, 40);        data[i].emailuserpw = FormatUtilities.truncate(data[i].emailuserpw, 40);        data[i].supervisorId = FormatUtilities.truncate(data[i].supervisorId, 50);        data[i].lastresult = FormatUtilities.truncate(data[i].lastresult, 50);        data[i].adOrgtrxId = FormatUtilities.truncate(data[i].adOrgtrxId, 50);        data[i].defaultAdRoleId = FormatUtilities.truncate(data[i].defaultAdRoleId, 50);        data[i].defaultAdLanguage = FormatUtilities.truncate(data[i].defaultAdLanguage, 50);        data[i].defaultAdClientId = FormatUtilities.truncate(data[i].defaultAdClientId, 50);        data[i].defaultAdOrgId = FormatUtilities.truncate(data[i].defaultAdOrgId, 50);        data[i].defaultMWarehouseId = FormatUtilities.truncate(data[i].defaultMWarehouseId, 50);        data[i].branche = FormatUtilities.truncate(data[i].branche, 50);        data[i].land = FormatUtilities.truncate(data[i].land, 50);        data[i].kunde = FormatUtilities.truncate(data[i].kunde, 50);        data[i].klinikkunde = FormatUtilities.truncate(data[i].klinikkunde, 50);        data[i].stippvisitenkunde = FormatUtilities.truncate(data[i].stippvisitenkunde, 50);        data[i].mailingzielgruppe = FormatUtilities.truncate(data[i].mailingzielgruppe, 50);        data[i].geschaeftsfuehrer = FormatUtilities.truncate(data[i].geschaeftsfuehrer, 50);        data[i].einkauf = FormatUtilities.truncate(data[i].einkauf, 50);        data[i].marktforschung = FormatUtilities.truncate(data[i].marktforschung, 50);        data[i].marketing = FormatUtilities.truncate(data[i].marketing, 50);        data[i].blockbuster = FormatUtilities.truncate(data[i].blockbuster, 50);        data[i].emarketing = FormatUtilities.truncate(data[i].emarketing, 50);        data[i].aussendienst = FormatUtilities.truncate(data[i].aussendienst, 50);        data[i].klinik = FormatUtilities.truncate(data[i].klinik, 50);        data[i].it = FormatUtilities.truncate(data[i].it, 50);        data[i].unternehmenskommunikation = FormatUtilities.truncate(data[i].unternehmenskommunikation, 50);        data[i].medicaleducation = FormatUtilities.truncate(data[i].medicaleducation, 50);        data[i].nis = FormatUtilities.truncate(data[i].nis, 50);        data[i].medwissen = FormatUtilities.truncate(data[i].medwissen, 50);        data[i].training = FormatUtilities.truncate(data[i].training, 50);        data[i].humanresources = FormatUtilities.truncate(data[i].humanresources, 50);        data[i].veranstaltungsmanagement = FormatUtilities.truncate(data[i].veranstaltungsmanagement, 50);        data[i].geschaeftsentwicklung = FormatUtilities.truncate(data[i].geschaeftsentwicklung, 50);        data[i].presse = FormatUtilities.truncate(data[i].presse, 50);        data[i].prominenter = FormatUtilities.truncate(data[i].prominenter, 50);        data[i].kol = FormatUtilities.truncate(data[i].kol, 50);        data[i].kooperation = FormatUtilities.truncate(data[i].kooperation, 50);        data[i].schluesselkontakt = FormatUtilities.truncate(data[i].schluesselkontakt, 50);        data[i].persoenlicherkontakt2008 = FormatUtilities.truncate(data[i].persoenlicherkontakt2008, 50);        data[i].persoenlicherkontakt2009 = FormatUtilities.truncate(data[i].persoenlicherkontakt2009, 50);        data[i].persoenlicherkontakt2010 = FormatUtilities.truncate(data[i].persoenlicherkontakt2010, 50);        data[i].persoenlicherkontakt2011 = FormatUtilities.truncate(data[i].persoenlicherkontakt2011, 50);        data[i].hobby = FormatUtilities.truncate(data[i].hobby, 50);        data[i].communityzugehoerigkeit = FormatUtilities.truncate(data[i].communityzugehoerigkeit, 50);        data[i].planung = FormatUtilities.truncate(data[i].planung, 50);        data[i].positionfunktion = FormatUtilities.truncate(data[i].positionfunktion, 50);        data[i].abteilungbereich = FormatUtilities.truncate(data[i].abteilungbereich, 50);        data[i].sachgebiet = FormatUtilities.truncate(data[i].sachgebiet, 50);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|I_User_ID", data[0].getField("iUserId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      ImportUserData[] data = ImportUserData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpiUserId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strI_User_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamName = vars.getSessionValue(tabId + "|paramName");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamName.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strI_User_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strI_User_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/ImportUser/ImportUser_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "ImportUser", false, "document.frmMain.inpiUserId", "grid", "..", "".equals("Y"), "ImportUser", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "iUserId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "ImportUser_Relation.html", "ImportUser", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "ImportUser_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strI_User_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " 1";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    ImportUserData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamName = vars.getSessionValue(tabId + "|paramName");

    boolean hasSearchCondition=false;
    if (!(strParamName.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = ImportUserData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strI_User_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strI_User_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new ImportUserData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("iUserId") == null || dataField.getField("iUserId").equals("")) {
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
        data = ImportUserData.set("Y", Utility.getDefault(this, vars, "Default_Ad_Org_ID", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Klinik", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Schluesselkontakt", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Klinikkunde", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Aussendienst", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Abteilungbereich", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), "", Utility.getDefault(this, vars, "Mailingzielgruppe", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Title", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), ImportUserData.selectDefEC8C46352F0449D8BA15D0B36FBD2FDB_0(this, Utility.getDefault(this, vars, "Createdby", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField)), Utility.getDefault(this, vars, "Phone2", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Persoenlicherkontakt2009", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Stippvisitenkunde", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Persoenlicherkontakt2010", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Geschaeftsfuehrer", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Username", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "C_Bpartner_ID", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Kol", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Processing", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "N", dataField), Utility.getDefault(this, vars, "Blockbuster", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Lastname", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Emailuserpw", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Persoenlicherkontakt2008", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Training", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Hobby", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Default_Ad_Language", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Branche", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Kunde", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Prominenter", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Name", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Geschaeftsentwicklung", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Firstname", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Positionfunktion", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Veranstaltungsmanagement", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Presse", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Persoenlicherkontakt2011", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Password", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Marktforschung", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Einkauf", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Birthday", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "C_Greeting_ID", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Enumber", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Humanresources", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Btnprocess", "N", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "N", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Fax", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "AD_Orgtrx_ID", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Default_M_Warehouse_ID", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Supervisor_ID", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Marketing", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Emarketing", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Email", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Communityzugehoerigkeit", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Phone", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Medicaleducation", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Nis", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Description", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Kooperation", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Emailuser", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Lastcontact", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Unternehmenskommunikation", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Sachgebiet", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Medwissen", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Lastresult", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Default_Ad_Role_ID", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Comments", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), ImportUserData.selectDefDBB027282C944036A33DAD8488B6DD7B_1(this, Utility.getDefault(this, vars, "Updatedby", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField)), Utility.getDefault(this, vars, "Land", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "C_Bpartner_Location_ID", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Planung", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "Isimported", "N", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "N", dataField), Utility.getDefault(this, vars, "Default_Ad_Client_ID", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField), Utility.getDefault(this, vars, "It", "", "025F7B201CC2452A8B11A30F981DD49F", "13EB71BFF9954684BB803656D3EB188F", "", dataField));
        
      }
    } else {
      data = new ImportUserData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(ImportUserData) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "ImportUser", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpiUserId", "", "..", "".equals("Y"), "ImportUser", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strI_User_ID));
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
  
    void printPageButtonBtnprocess2FE6CA5330DB43A8861F7BFAA62E896B(HttpServletResponse response, VariablesSecureApp vars, String strI_User_ID, String strbtnprocess, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "2FE6CA5330DB43A8861F7BFAA62E896B",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "2FE6CA5330DB43A8861F7BFAA62E896B" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"2FE6CA5330DB43A8861F7BFAA62E896B" );
        String isDocAction=UtilsData.isProcessDocAction(this, "2FE6CA5330DB43A8861F7BFAA62E896B");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "F6D2070E03534FB292940C87750950FE",strI_User_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "F6D2070E03534FB292940C87750950FE", strI_User_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strbtnprocess, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "2FE6CA5330DB43A8861F7BFAA62E896B");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONBtnprocess" + "2FE6CA5330DB43A8861F7BFAA62E896B" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","ImportUser_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "2FE6CA5330DB43A8861F7BFAA62E896B");
        script.addHiddenfield("inpKey",strI_User_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("2FE6CA5330DB43A8861F7BFAA62E896B");
        vars.removeMessage("2FE6CA5330DB43A8861F7BFAA62E896B");
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type) throws IOException, ServletException {
    ImportUserData data = null;
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
                data.iUserId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (ImportUserData.getCurrentDBTimestamp(this, data.iUserId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.iUserId, vars, this);
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
                    data.iUserId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|I_User_ID", data.iUserId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet ImportUser. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
