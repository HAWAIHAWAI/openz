
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.Employee;





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

public class PersonalDataC9B028F8723040C8A2BE9C26E125FA22 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(PersonalDataC9B028F8723040C8A2BE9C26E125FA22.class);
  
  private static final String windowId = "39D3CD9F77A942D690965D49106F011B";
  private static final String tabId = "C9B028F8723040C8A2BE9C26E125FA22";
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
         String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !stradUserId.equals(""))
              total = saveRecord(vars, myError, 'U', strPC_BPartner_ID);
          else
              total = saveRecord(vars, myError, 'I', strPC_BPartner_ID);
          
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
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", "");

      String strAD_User_ID = vars.getGlobalVariable("inpadUserId", windowId + "|AD_User_ID", "");
            if (strPC_BPartner_ID.equals("")) {
        strPC_BPartner_ID = getParentID(vars, strAD_User_ID);
        if (strPC_BPartner_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_BPartner_ID");
        vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);

        refreshParentSession(vars, strPC_BPartner_ID);
      }


      String strView = vars.getSessionValue(tabId + "|PersonalDataC9B028F8723040C8A2BE9C26E125FA22.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strAD_User_ID.equals("")) strAD_User_ID = firstElement(vars, tableSQL);
          if (strAD_User_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strAD_User_ID, strPC_BPartner_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_BPartner_ID, strAD_User_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strAD_User_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strAD_User_ID.equals("")) strAD_User_ID = vars.getRequiredGlobalVariable("inpadUserId", windowId + "|AD_User_ID");
      else vars.setSessionValue(windowId + "|AD_User_ID", strAD_User_ID);
      
      
      String strPC_BPartner_ID = getParentID(vars, strAD_User_ID);
      
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);
      vars.setSessionValue("A3D0B320B69845B386024B5FF6B1E266|Employee.view", "EDIT");

      refreshParentSession(vars, strPC_BPartner_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|PersonalDataC9B028F8723040C8A2BE9C26E125FA22.view", "EDIT");

        printPageEdit(response, request, vars, false, strAD_User_ID, strPC_BPartner_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|PersonalDataC9B028F8723040C8A2BE9C26E125FA22.view", "RELATION");
        printPageDataSheet(response, vars, strPC_BPartner_ID, strAD_User_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|AD_User_ID");
      refreshParentSession(vars, strPC_BPartner_ID);


      String strView = vars.getSessionValue(tabId + "|PersonalDataC9B028F8723040C8A2BE9C26E125FA22.view");
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
        printPageEdit(response, request, vars, false, strAD_User_ID, strPC_BPartner_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_BPartner_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamUserName", tabId + "|paramUserName");
vars.getRequestGlobalVariable("inpParamEnumber", tabId + "|paramEnumber");

            String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      
      vars.removeSessionValue(windowId + "|AD_User_ID");
      String strAD_User_ID="";

      String strView = vars.getSessionValue(tabId + "|PersonalDataC9B028F8723040C8A2BE9C26E125FA22.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strAD_User_ID = firstElement(vars, tableSQL);
        if (strAD_User_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|PersonalDataC9B028F8723040C8A2BE9C26E125FA22.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strAD_User_ID, strPC_BPartner_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_BPartner_ID, strAD_User_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      

      String strAD_User_ID = vars.getGlobalVariable("inpadUserId", windowId + "|AD_User_ID", "");
      vars.setSessionValue(tabId + "|PersonalDataC9B028F8723040C8A2BE9C26E125FA22.view", "RELATION");
      printPageDataSheet(response, vars, strPC_BPartner_ID, strAD_User_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");


      printPageEdit(response, request, vars, true, "", strPC_BPartner_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strAD_User_ID = vars.getGlobalVariable("inpadUserId", windowId + "|AD_User_ID", "");
      vars.setSessionValue(tabId + "|PersonalDataC9B028F8723040C8A2BE9C26E125FA22.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strAD_User_ID, strPC_BPartner_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      String strAD_User_ID = vars.getRequiredStringParameter("inpadUserId");
      
      String strNext = nextElement(vars, strAD_User_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      String strAD_User_ID = vars.getRequiredStringParameter("inpadUserId");
      
      String strPrevious = previousElement(vars, strAD_User_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      vars.setSessionValue(tabId + "|PersonalDataC9B028F8723040C8A2BE9C26E125FA22.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|PersonalDataC9B028F8723040C8A2BE9C26E125FA22.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|PersonalDataC9B028F8723040C8A2BE9C26E125FA22.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|PersonalDataC9B028F8723040C8A2BE9C26E125FA22.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|AD_User_ID");
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|PersonalDataC9B028F8723040C8A2BE9C26E125FA22.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|PersonalDataC9B028F8723040C8A2BE9C26E125FA22.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|AD_User_ID");
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPC_BPartner_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPC_BPartner_ID);      
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
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      String strAD_User_ID = vars.getRequiredGlobalVariable("inpadUserId", windowId + "|AD_User_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPC_BPartner_ID);      
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
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strAD_User_ID = vars.getRequiredInStringParameter("inpadUserId");
      String message = deleteRelation(vars, strAD_User_ID, strPC_BPartner_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|adUserId");
        vars.setSessionValue(tabId + "|PersonalDataC9B028F8723040C8A2BE9C26E125FA22.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strAD_User_ID = vars.getRequiredStringParameter("inpadUserId");
      //PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data data = getEditVariables(vars, strPC_BPartner_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.delete(this, strAD_User_ID, strPC_BPartner_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.setSessionValue(tabId + "|PersonalDataC9B028F8723040C8A2BE9C26E125FA22.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strAD_User_ID, String strPC_BPartner_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strAD_User_ID.startsWith("(")) strAD_User_ID = strAD_User_ID.substring(1, strAD_User_ID.length()-1);
      if (!strAD_User_ID.equals("")) {
        strAD_User_ID = Replace.replace(strAD_User_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strAD_User_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.deleteTransactional(conn, this, strKey, strPC_BPartner_ID)==0) {
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
  private PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data getEditVariables(Connection con, VariablesSecureApp vars, String strPC_BPartner_ID) throws IOException,ServletException {
    PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data data = new PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data();
    ServletException ex = null;
    try {
    data.cBpartnerLocationId = vars.getStringParameter("inpcBpartnerLocationId");     data.lastcontact = vars.getStringParameter("inplastcontact");     data.emailuserpw = FormatUtilities.encryptDecrypt(vars.getStringParameter("inpemailuserpw"), true);     data.processing = vars.getStringParameter("inpprocessing");     data.emailuser = vars.getStringParameter("inpemailuser");     data.lastresult = vars.getStringParameter("inplastresult");     data.adOrgtrxId = vars.getStringParameter("inpadOrgtrxId");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.firstname = vars.getStringParameter("inpfirstname");     data.cGreetingId = vars.getStringParameter("inpcGreetingId");     data.cGreetingIdr = vars.getStringParameter("inpcGreetingId_R");     data.lastname = vars.getStringParameter("inplastname");     data.title = vars.getStringParameter("inptitle");     data.username = vars.getStringParameter("inpusername");     data.name = vars.getStringParameter("inpname");     data.defaultAdClientId = vars.getStringParameter("inpdefaultAdClientId");     data.enumber = vars.getStringParameter("inpenumber");     data.defaultAdOrgId = vars.getStringParameter("inpdefaultAdOrgId");     data.birthday = vars.getStringParameter("inpbirthday");     data.defaultAdLanguage = vars.getStringParameter("inpdefaultAdLanguage");     data.email = vars.getStringParameter("inpemail");     data.defaultAdRoleId = vars.getStringParameter("inpdefaultAdRoleId");     data.fax = vars.getStringParameter("inpfax");     data.defaultMWarehouseId = vars.getStringParameter("inpdefaultMWarehouseId");     data.phone = vars.getStringParameter("inpphone");     data.phone2 = vars.getStringParameter("inpphone2");     data.description = vars.getStringParameter("inpdescription");     data.comments = vars.getStringParameter("inpcomments");     data.supervisorId = vars.getStringParameter("inpsupervisorId");     data.supervisorIdr = vars.getStringParameter("inpsupervisorId_R");     data.cColorId = vars.getStringParameter("inpcColorId");     data.cColorIdr = vars.getStringParameter("inpcColorId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.mailingzielgruppe = vars.getStringParameter("inpmailingzielgruppe");     data.persoenlicherkontakt2010 = vars.getStringParameter("inppersoenlicherkontakt2010");     data.date1 = vars.getStringParameter("inpdate1");     data.einkauf = vars.getStringParameter("inpeinkauf");     data.persoenlicherkontakt2009 = vars.getStringParameter("inppersoenlicherkontakt2009");     data.marktforschung = vars.getStringParameter("inpmarktforschung");     data.date4 = vars.getStringParameter("inpdate4");     data.communityzugehoerigkeit = vars.getStringParameter("inpcommunityzugehoerigkeit");     data.kooperation = vars.getStringParameter("inpkooperation");     data.prominenter = vars.getStringParameter("inpprominenter");     data.emarketing = vars.getStringParameter("inpemarketing");    try {   data.number5 = vars.getNumericParameter("inpnumber5");  } catch (ServletException paramEx) { ex = paramEx; }     data.it = vars.getStringParameter("inpit");     data.blockbuster = vars.getStringParameter("inpblockbuster");     data.unternehmenskommunikation = vars.getStringParameter("inpunternehmenskommunikation");    try {   data.number4 = vars.getNumericParameter("inpnumber4");  } catch (ServletException paramEx) { ex = paramEx; }     data.nis = vars.getStringParameter("inpnis");    try {   data.number3 = vars.getNumericParameter("inpnumber3");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.number2 = vars.getNumericParameter("inpnumber2");  } catch (ServletException paramEx) { ex = paramEx; }     data.training = vars.getStringParameter("inptraining");     data.marketing = vars.getStringParameter("inpmarketing");     data.aussendienst = vars.getStringParameter("inpaussendienst");     data.medwissen = vars.getStringParameter("inpmedwissen");     data.klinikkunde = vars.getStringParameter("inpklinikkunde");     data.kunde = vars.getStringParameter("inpkunde");     data.kol = vars.getStringParameter("inpkol");     data.persoenlicherkontakt2008 = vars.getStringParameter("inppersoenlicherkontakt2008");     data.sachgebiet = vars.getStringParameter("inpsachgebiet");     data.presse = vars.getStringParameter("inppresse");    try {   data.number1 = vars.getNumericParameter("inpnumber1");  } catch (ServletException paramEx) { ex = paramEx; }     data.stippvisitenkunde = vars.getStringParameter("inpstippvisitenkunde");     data.branche = vars.getStringParameter("inpbranche");     data.persoenlicherkontakt2011 = vars.getStringParameter("inppersoenlicherkontakt2011");     data.geschaeftsentwicklung = vars.getStringParameter("inpgeschaeftsentwicklung");     data.hobby = vars.getStringParameter("inphobby");     data.veranstaltungsmanagement = vars.getStringParameter("inpveranstaltungsmanagement");     data.schluesselkontakt = vars.getStringParameter("inpschluesselkontakt");     data.planung = vars.getStringParameter("inpplanung");     data.land = vars.getStringParameter("inpland");     data.positionfunktion = vars.getStringParameter("inppositionfunktion");     data.klinik = vars.getStringParameter("inpklinik");     data.abteilungbereich = vars.getStringParameter("inpabteilungbereich");     data.geschaeftsfuehrer = vars.getStringParameter("inpgeschaeftsfuehrer");     data.medicaleducation = vars.getStringParameter("inpmedicaleducation");     data.humanresources = vars.getStringParameter("inphumanresources");     data.auxtext1 = vars.getStringParameter("inpauxtext1");     data.salesrepId = vars.getStringParameter("inpsalesrepId");     data.auxtext2 = vars.getStringParameter("inpauxtext2");     data.cUserPositionId = vars.getStringParameter("inpcUserPositionId");     data.auxtext3 = vars.getStringParameter("inpauxtext3");     data.cUserDepartmentId = vars.getStringParameter("inpcUserDepartmentId");     data.date2 = vars.getStringParameter("inpdate2");     data.date3 = vars.getStringParameter("inpdate3");     data.date5 = vars.getStringParameter("inpdate5");     data.adUserId = vars.getRequestGlobalVariable("inpadUserId", windowId + "|AD_User_ID");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.password = FormatUtilities.sha1Base64(vars.getStringParameter("inppassword"));     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cBpartnerId = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");


    
    

    
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

   private PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[] getRelationData(PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 22);        data[i].emailuserpw = FormatUtilities.truncate(data[i].emailuserpw, 40);        data[i].emailuser = FormatUtilities.truncate(data[i].emailuser, 20);        data[i].lastresult = FormatUtilities.truncate(data[i].lastresult, 50);        data[i].adOrgtrxId = FormatUtilities.truncate(data[i].adOrgtrxId, 22);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 50);        data[i].firstname = FormatUtilities.truncate(data[i].firstname, 50);        data[i].cGreetingId = FormatUtilities.truncate(data[i].cGreetingId, 22);        data[i].lastname = FormatUtilities.truncate(data[i].lastname, 50);        data[i].title = FormatUtilities.truncate(data[i].title, 40);        data[i].username = FormatUtilities.truncate(data[i].username, 20);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].defaultAdClientId = FormatUtilities.truncate(data[i].defaultAdClientId, 12);        data[i].enumber = FormatUtilities.truncate(data[i].enumber, 40);        data[i].defaultAdOrgId = FormatUtilities.truncate(data[i].defaultAdOrgId, 12);        data[i].defaultAdLanguage = FormatUtilities.truncate(data[i].defaultAdLanguage, 6);        data[i].email = FormatUtilities.truncate(data[i].email, 40);        data[i].defaultAdRoleId = FormatUtilities.truncate(data[i].defaultAdRoleId, 12);        data[i].fax = FormatUtilities.truncate(data[i].fax, 40);        data[i].defaultMWarehouseId = FormatUtilities.truncate(data[i].defaultMWarehouseId, 12);        data[i].phone = FormatUtilities.truncate(data[i].phone, 40);        data[i].phone2 = FormatUtilities.truncate(data[i].phone2, 40);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].comments = FormatUtilities.truncate(data[i].comments, 50);        data[i].supervisorId = FormatUtilities.truncate(data[i].supervisorId, 22);        data[i].cColorId = FormatUtilities.truncate(data[i].cColorId, 32);        data[i].mailingzielgruppe = FormatUtilities.truncate(data[i].mailingzielgruppe, 50);        data[i].persoenlicherkontakt2010 = FormatUtilities.truncate(data[i].persoenlicherkontakt2010, 50);        data[i].einkauf = FormatUtilities.truncate(data[i].einkauf, 50);        data[i].persoenlicherkontakt2009 = FormatUtilities.truncate(data[i].persoenlicherkontakt2009, 50);        data[i].marktforschung = FormatUtilities.truncate(data[i].marktforschung, 50);        data[i].communityzugehoerigkeit = FormatUtilities.truncate(data[i].communityzugehoerigkeit, 50);        data[i].kooperation = FormatUtilities.truncate(data[i].kooperation, 50);        data[i].prominenter = FormatUtilities.truncate(data[i].prominenter, 50);        data[i].emarketing = FormatUtilities.truncate(data[i].emarketing, 50);        data[i].it = FormatUtilities.truncate(data[i].it, 50);        data[i].blockbuster = FormatUtilities.truncate(data[i].blockbuster, 50);        data[i].unternehmenskommunikation = FormatUtilities.truncate(data[i].unternehmenskommunikation, 50);        data[i].nis = FormatUtilities.truncate(data[i].nis, 50);        data[i].training = FormatUtilities.truncate(data[i].training, 50);        data[i].marketing = FormatUtilities.truncate(data[i].marketing, 50);        data[i].aussendienst = FormatUtilities.truncate(data[i].aussendienst, 50);        data[i].medwissen = FormatUtilities.truncate(data[i].medwissen, 50);        data[i].klinikkunde = FormatUtilities.truncate(data[i].klinikkunde, 50);        data[i].kunde = FormatUtilities.truncate(data[i].kunde, 50);        data[i].kol = FormatUtilities.truncate(data[i].kol, 50);        data[i].persoenlicherkontakt2008 = FormatUtilities.truncate(data[i].persoenlicherkontakt2008, 50);        data[i].sachgebiet = FormatUtilities.truncate(data[i].sachgebiet, 50);        data[i].presse = FormatUtilities.truncate(data[i].presse, 50);        data[i].stippvisitenkunde = FormatUtilities.truncate(data[i].stippvisitenkunde, 50);        data[i].branche = FormatUtilities.truncate(data[i].branche, 50);        data[i].persoenlicherkontakt2011 = FormatUtilities.truncate(data[i].persoenlicherkontakt2011, 50);        data[i].geschaeftsentwicklung = FormatUtilities.truncate(data[i].geschaeftsentwicklung, 50);        data[i].hobby = FormatUtilities.truncate(data[i].hobby, 50);        data[i].veranstaltungsmanagement = FormatUtilities.truncate(data[i].veranstaltungsmanagement, 50);        data[i].schluesselkontakt = FormatUtilities.truncate(data[i].schluesselkontakt, 50);        data[i].planung = FormatUtilities.truncate(data[i].planung, 50);        data[i].land = FormatUtilities.truncate(data[i].land, 50);        data[i].positionfunktion = FormatUtilities.truncate(data[i].positionfunktion, 50);        data[i].klinik = FormatUtilities.truncate(data[i].klinik, 50);        data[i].abteilungbereich = FormatUtilities.truncate(data[i].abteilungbereich, 50);        data[i].geschaeftsfuehrer = FormatUtilities.truncate(data[i].geschaeftsfuehrer, 50);        data[i].medicaleducation = FormatUtilities.truncate(data[i].medicaleducation, 50);        data[i].humanresources = FormatUtilities.truncate(data[i].humanresources, 50);        data[i].auxtext1 = FormatUtilities.truncate(data[i].auxtext1, 50);        data[i].salesrepId = FormatUtilities.truncate(data[i].salesrepId, 32);        data[i].auxtext2 = FormatUtilities.truncate(data[i].auxtext2, 50);        data[i].cUserPositionId = FormatUtilities.truncate(data[i].cUserPositionId, 32);        data[i].auxtext3 = FormatUtilities.truncate(data[i].auxtext3, 50);        data[i].cUserDepartmentId = FormatUtilities.truncate(data[i].cUserDepartmentId, 32);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 22);        data[i].password = FormatUtilities.truncate(data[i].password, 40);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 22);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPC_BPartner_ID) throws IOException,ServletException {
      EmployeeA3D0B320B69845B386024B5FF6B1E266Data[] data = EmployeeA3D0B320B69845B386024B5FF6B1E266Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_BPartner_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].cBpartnerId);
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strAD_User_ID) throws ServletException {
    String strPC_BPartner_ID = PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.selectParentID(this, strAD_User_ID);
    if (strPC_BPartner_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strAD_User_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_BPartner_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_User_ID", data[0].getField("adUserId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_BPartner_ID) throws IOException,ServletException {
      PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[] data = PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_BPartner_ID, vars.getStringParameter("inpadUserId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_BPartner_ID, String strAD_User_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamUserName = vars.getSessionValue(tabId + "|paramUserName");
String strParamEnumber = vars.getSessionValue(tabId + "|paramEnumber");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamName.equals("") && strParamUserName.equals("") && strParamEnumber.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strAD_User_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strAD_User_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/smartui/Employee/PersonalDataC9B028F8723040C8A2BE9C26E125FA22_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "PersonalDataC9B028F8723040C8A2BE9C26E125FA22", false, "document.frmMain.inpadUserId", "grid", "..", "".equals("Y"), "Employee", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPC_BPartner_ID);

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
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "PersonalDataC9B028F8723040C8A2BE9C26E125FA22_Relation.html", "Employee", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "PersonalDataC9B028F8723040C8A2BE9C26E125FA22_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.selectParent(this, strPC_BPartner_ID));
    else xmlDocument.setParameter("parent", PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.selectParentTrl(this, strPC_BPartner_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strAD_User_ID, String strPC_BPartner_ID, TableSQLData tableSQL)
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
    PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamUserName = vars.getSessionValue(tabId + "|paramUserName");
String strParamEnumber = vars.getSessionValue(tabId + "|paramEnumber");

    boolean hasSearchCondition=false;
    if (!(strParamName.equals("") && strParamUserName.equals("") && strParamEnumber.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_BPartner_ID, strAD_User_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
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
        data = new PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[0];
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
        refreshSessionNew(vars, strPC_BPartner_ID);
        data = PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.set(strPC_BPartner_ID, Utility.getDefault(this, vars, "Stippvisitenkunde", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Kol", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Date1", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "AD_OrgTrx_ID", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Number2", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Number3", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Phone", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "EmailUser", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "EmailUserPW", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Humanresources", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Salesrep_ID", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Emarketing", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "LastContact", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Medwissen", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Positionfunktion", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Klinikkunde", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Veranstaltungsmanagement", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Schluesselkontakt", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "C_User_Department_ID", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Fax", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Name", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Default_M_Warehouse_ID", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Communityzugehoerigkeit", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Sachgebiet", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "C_Greeting_ID", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Persoenlicherkontakt2010", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Hobby", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), "", Utility.getDefault(this, vars, "Birthday", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Number5", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Auxtext3", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Kunde", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Default_Ad_Client_ID", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Einkauf", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Blockbuster", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Geschaeftsentwicklung", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Nis", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Branche", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Auxtext2", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Default_Ad_Org_ID", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Description", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Supervisor_ID", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "LastResult", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.selectDef624_0(this, Utility.getDefault(this, vars, "CreatedBy", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField)), Utility.getDefault(this, vars, "Number4", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Klinik", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "C_BPartner_Location_ID", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Presse", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Unternehmenskommunikation", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Persoenlicherkontakt2008", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Medicaleducation", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Date2", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), "Y", Utility.getDefault(this, vars, "Phone2", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "It", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Firstname", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "UserName", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Persoenlicherkontakt2009", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Aussendienst", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Email", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Processing", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "N", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Date3", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Password", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Title", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Persoenlicherkontakt2011", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Mailingzielgruppe", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Enumber", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Prominenter", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Abteilungbereich", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Auxtext1", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Default_Ad_Language", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Default_Ad_Role_ID", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "C_User_Position_ID", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Training", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Geschaeftsfuehrer", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Land", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Date4", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Date5", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Comments", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Lastname", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Marketing", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.selectDef626_1(this, Utility.getDefault(this, vars, "UpdatedBy", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField)), Utility.getDefault(this, vars, "Planung", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Kooperation", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "C_Color_ID", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Number1", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField), Utility.getDefault(this, vars, "Marktforschung", "", "39D3CD9F77A942D690965D49106F011B", "C9B028F8723040C8A2BE9C26E125FA22", "", dataField));
        
      }
    } else {
      data = new PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=EmployeeA3D0B320B69845B386024B5FF6B1E266Data.selectOrg(this, strPC_BPartner_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "PersonalDataC9B028F8723040C8A2BE9C26E125FA22", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpadUserId", "", "..", "".equals("Y"), "Employee", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strAD_User_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPC_BPartner_ID) throws IOException, ServletException {
    PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data data = null;
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
            data = getEditVariables(con, vars, strPC_BPartner_ID);
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
		       if (PersonalDataC9B028F8723040C8A2BE9C26E125FA22Data.getCurrentDBTimestamp(this, data.adUserId).equals(
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
    return "Servlet PersonalDataC9B028F8723040C8A2BE9C26E125FA22. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
