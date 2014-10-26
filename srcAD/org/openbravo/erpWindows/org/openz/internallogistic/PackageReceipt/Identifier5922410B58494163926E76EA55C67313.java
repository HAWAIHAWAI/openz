
package org.openbravo.erpWindows.org.openz.internallogistic.PackageReceipt;





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

public class Identifier5922410B58494163926E76EA55C67313 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Identifier5922410B58494163926E76EA55C67313.class);
  
  private static final String windowId = "4E31A5C7FD0148D68553F0F913396CDB";
  private static final String tabId = "5922410B58494163926E76EA55C67313";
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
        String strilsSnrinoutlineVId = request.getParameter("inpilsSnrinoutlineVId");
         String strPILS_Inoutpackage_V_ID = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strilsSnrinoutlineVId.equals(""))
              total = saveRecord(vars, myError, 'U', strPILS_Inoutpackage_V_ID);
          else
              total = saveRecord(vars, myError, 'I', strPILS_Inoutpackage_V_ID);
          
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
      String strPILS_Inoutpackage_V_ID = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID", "");

      String strILS_Snrinoutline_V_ID = vars.getGlobalVariable("inpilsSnrinoutlineVId", windowId + "|ILS_Snrinoutline_V_ID", "");
            if (strPILS_Inoutpackage_V_ID.equals("")) {
        strPILS_Inoutpackage_V_ID = getParentID(vars, strILS_Snrinoutline_V_ID);
        if (strPILS_Inoutpackage_V_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|ILS_Inoutpackage_V_ID");
        vars.setSessionValue(windowId + "|ILS_Inoutpackage_V_ID", strPILS_Inoutpackage_V_ID);

        refreshParentSession(vars, strPILS_Inoutpackage_V_ID);
      }


      String strView = vars.getSessionValue(tabId + "|Identifier5922410B58494163926E76EA55C67313.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strILS_Snrinoutline_V_ID.equals("")) strILS_Snrinoutline_V_ID = firstElement(vars, tableSQL);
          if (strILS_Snrinoutline_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strILS_Snrinoutline_V_ID, strPILS_Inoutpackage_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strPILS_Inoutpackage_V_ID, strILS_Snrinoutline_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strILS_Snrinoutline_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strILS_Snrinoutline_V_ID.equals("")) strILS_Snrinoutline_V_ID = vars.getRequiredGlobalVariable("inpilsSnrinoutlineVId", windowId + "|ILS_Snrinoutline_V_ID");
      else vars.setSessionValue(windowId + "|ILS_Snrinoutline_V_ID", strILS_Snrinoutline_V_ID);
      
      
      String strPILS_Inoutpackage_V_ID = getParentID(vars, strILS_Snrinoutline_V_ID);
      
      vars.setSessionValue(windowId + "|ILS_Inoutpackage_V_ID", strPILS_Inoutpackage_V_ID);
      vars.setSessionValue("62314289EB0A4FFBA4ACDB985018C68B|Receipt.view", "EDIT");

      refreshParentSession(vars, strPILS_Inoutpackage_V_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Identifier5922410B58494163926E76EA55C67313.view", "EDIT");

        printPageEdit(response, request, vars, false, strILS_Snrinoutline_V_ID, strPILS_Inoutpackage_V_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Identifier5922410B58494163926E76EA55C67313.view", "RELATION");
        printPageDataSheet(response, vars, strPILS_Inoutpackage_V_ID, strILS_Snrinoutline_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPILS_Inoutpackage_V_ID = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|ILS_Snrinoutline_V_ID");
      refreshParentSession(vars, strPILS_Inoutpackage_V_ID);


      String strView = vars.getSessionValue(tabId + "|Identifier5922410B58494163926E76EA55C67313.view");
      String strILS_Snrinoutline_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strILS_Snrinoutline_V_ID = firstElement(vars, tableSQL);
          if (strILS_Snrinoutline_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strILS_Snrinoutline_V_ID.equals("")) strILS_Snrinoutline_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strILS_Snrinoutline_V_ID, strPILS_Inoutpackage_V_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPILS_Inoutpackage_V_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamSerialnumber", tabId + "|paramSerialnumber");

            String strPILS_Inoutpackage_V_ID = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID");

      
      vars.removeSessionValue(windowId + "|ILS_Snrinoutline_V_ID");
      String strILS_Snrinoutline_V_ID="";

      String strView = vars.getSessionValue(tabId + "|Identifier5922410B58494163926E76EA55C67313.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strILS_Snrinoutline_V_ID = firstElement(vars, tableSQL);
        if (strILS_Snrinoutline_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Identifier5922410B58494163926E76EA55C67313.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strILS_Snrinoutline_V_ID, strPILS_Inoutpackage_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strPILS_Inoutpackage_V_ID, strILS_Snrinoutline_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPILS_Inoutpackage_V_ID = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID");
      

      String strILS_Snrinoutline_V_ID = vars.getGlobalVariable("inpilsSnrinoutlineVId", windowId + "|ILS_Snrinoutline_V_ID", "");
      vars.setSessionValue(tabId + "|Identifier5922410B58494163926E76EA55C67313.view", "RELATION");
      printPageDataSheet(response, vars, strPILS_Inoutpackage_V_ID, strILS_Snrinoutline_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPILS_Inoutpackage_V_ID = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID");


      printPageEdit(response, request, vars, true, "", strPILS_Inoutpackage_V_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPILS_Inoutpackage_V_ID = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strILS_Snrinoutline_V_ID = vars.getGlobalVariable("inpilsSnrinoutlineVId", windowId + "|ILS_Snrinoutline_V_ID", "");
      vars.setSessionValue(tabId + "|Identifier5922410B58494163926E76EA55C67313.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strILS_Snrinoutline_V_ID, strPILS_Inoutpackage_V_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPILS_Inoutpackage_V_ID = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID");
      String strILS_Snrinoutline_V_ID = vars.getRequiredStringParameter("inpilsSnrinoutlineVId");
      
      String strNext = nextElement(vars, strILS_Snrinoutline_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPILS_Inoutpackage_V_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPILS_Inoutpackage_V_ID = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID");
      String strILS_Snrinoutline_V_ID = vars.getRequiredStringParameter("inpilsSnrinoutlineVId");
      
      String strPrevious = previousElement(vars, strILS_Snrinoutline_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPILS_Inoutpackage_V_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID");

      vars.setSessionValue(tabId + "|Identifier5922410B58494163926E76EA55C67313.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPILS_Inoutpackage_V_ID = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Identifier5922410B58494163926E76EA55C67313.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Identifier5922410B58494163926E76EA55C67313.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Identifier5922410B58494163926E76EA55C67313.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|ILS_Snrinoutline_V_ID");
      vars.setSessionValue(windowId + "|ILS_Inoutpackage_V_ID", strPILS_Inoutpackage_V_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPILS_Inoutpackage_V_ID = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Identifier5922410B58494163926E76EA55C67313.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Identifier5922410B58494163926E76EA55C67313.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|ILS_Snrinoutline_V_ID");
      vars.setSessionValue(windowId + "|ILS_Inoutpackage_V_ID", strPILS_Inoutpackage_V_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPILS_Inoutpackage_V_ID = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPILS_Inoutpackage_V_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPILS_Inoutpackage_V_ID = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPILS_Inoutpackage_V_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPILS_Inoutpackage_V_ID = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPILS_Inoutpackage_V_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPILS_Inoutpackage_V_ID = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPILS_Inoutpackage_V_ID);      
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
      String strPILS_Inoutpackage_V_ID = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID");
      String strILS_Snrinoutline_V_ID = vars.getRequiredGlobalVariable("inpilsSnrinoutlineVId", windowId + "|ILS_Snrinoutline_V_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPILS_Inoutpackage_V_ID);      
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
          String strNext = nextElement(vars, strILS_Snrinoutline_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|ILS_Snrinoutline_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPILS_Inoutpackage_V_ID = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID");

      String strILS_Snrinoutline_V_ID = vars.getRequiredInStringParameter("inpilsSnrinoutlineVId");
      String message = deleteRelation(vars, strILS_Snrinoutline_V_ID, strPILS_Inoutpackage_V_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|ilsSnrinoutlineVId");
        vars.setSessionValue(tabId + "|Identifier5922410B58494163926E76EA55C67313.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPILS_Inoutpackage_V_ID = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID");

      String strILS_Snrinoutline_V_ID = vars.getRequiredStringParameter("inpilsSnrinoutlineVId");
      //Identifier5922410B58494163926E76EA55C67313Data data = getEditVariables(vars, strPILS_Inoutpackage_V_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = Identifier5922410B58494163926E76EA55C67313Data.delete(this, strILS_Snrinoutline_V_ID, strPILS_Inoutpackage_V_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|ilsSnrinoutlineVId");
        vars.setSessionValue(tabId + "|Identifier5922410B58494163926E76EA55C67313.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strILS_Snrinoutline_V_ID, String strPILS_Inoutpackage_V_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strILS_Snrinoutline_V_ID.startsWith("(")) strILS_Snrinoutline_V_ID = strILS_Snrinoutline_V_ID.substring(1, strILS_Snrinoutline_V_ID.length()-1);
      if (!strILS_Snrinoutline_V_ID.equals("")) {
        strILS_Snrinoutline_V_ID = Replace.replace(strILS_Snrinoutline_V_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strILS_Snrinoutline_V_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (Identifier5922410B58494163926E76EA55C67313Data.deleteTransactional(conn, this, strKey, strPILS_Inoutpackage_V_ID)==0) {
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
  private Identifier5922410B58494163926E76EA55C67313Data getEditVariables(Connection con, VariablesSecureApp vars, String strPILS_Inoutpackage_V_ID) throws IOException,ServletException {
    Identifier5922410B58494163926E76EA55C67313Data data = new Identifier5922410B58494163926E76EA55C67313Data();
    ServletException ex = null;
    try {
    data.ilsInoutpackageVId = vars.getStringParameter("inpilsInoutpackageVId");     data.ilsInoutpackageVIdr = vars.getStringParameter("inpilsInoutpackageVId_R");     data.serialnumber = vars.getStringParameter("inpserialnumber");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.isunavailable = vars.getStringParameter("inpisunavailable", "N");     data.ilsSnrinoutlineVId = vars.getRequestGlobalVariable("inpilsSnrinoutlineVId", windowId + "|ILS_Snrinoutline_V_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.ilsInoutpackageVId = vars.getGlobalVariable("inpilsInoutpackageVId", windowId + "|ILS_Inoutpackage_V_ID");


    
    

    
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

   private Identifier5922410B58494163926E76EA55C67313Data[] getRelationData(Identifier5922410B58494163926E76EA55C67313Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].ilsInoutpackageVId = FormatUtilities.truncate(data[i].ilsInoutpackageVId, 32);        data[i].serialnumber = FormatUtilities.truncate(data[i].serialnumber, 40);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].ilsSnrinoutlineVId = FormatUtilities.truncate(data[i].ilsSnrinoutlineVId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPILS_Inoutpackage_V_ID) throws IOException,ServletException {
      Receipt62314289EB0A4FFBA4ACDB985018C68BData[] data = Receipt62314289EB0A4FFBA4ACDB985018C68BData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPILS_Inoutpackage_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|ILS_Inoutpackage_V_ID", data[0].ilsInoutpackageVId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);
      vars.setSessionValue(windowId + "|ILS_Inoutpackage_V_ID", strPILS_Inoutpackage_V_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strILS_Snrinoutline_V_ID) throws ServletException {
    String strPILS_Inoutpackage_V_ID = Identifier5922410B58494163926E76EA55C67313Data.selectParentID(this, strILS_Snrinoutline_V_ID);
    if (strPILS_Inoutpackage_V_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strILS_Snrinoutline_V_ID);
      throw new ServletException("Parent record not found");
    }
    return strPILS_Inoutpackage_V_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|ILS_Snrinoutline_V_ID", data[0].getField("ilsSnrinoutlineVId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPILS_Inoutpackage_V_ID) throws IOException,ServletException {
      Identifier5922410B58494163926E76EA55C67313Data[] data = Identifier5922410B58494163926E76EA55C67313Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPILS_Inoutpackage_V_ID, vars.getStringParameter("inpilsSnrinoutlineVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPILS_Inoutpackage_V_ID, String strILS_Snrinoutline_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamSerialnumber = vars.getSessionValue(tabId + "|paramSerialnumber");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamSerialnumber.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strILS_Snrinoutline_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strILS_Snrinoutline_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openz/internallogistic/PackageReceipt/Identifier5922410B58494163926E76EA55C67313_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Identifier5922410B58494163926E76EA55C67313", false, "document.frmMain.inpilsSnrinoutlineVId", "grid", "..", "".equals("Y"), "PackageReceipt", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), true, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPILS_Inoutpackage_V_ID);

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
    xmlDocument.setParameter("KeyName", "ilsSnrinoutlineVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Identifier5922410B58494163926E76EA55C67313_Relation.html", "PackageReceipt", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Identifier5922410B58494163926E76EA55C67313_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", Identifier5922410B58494163926E76EA55C67313Data.selectParent(this, strPILS_Inoutpackage_V_ID));
    else xmlDocument.setParameter("parent", Identifier5922410B58494163926E76EA55C67313Data.selectParentTrl(this, strPILS_Inoutpackage_V_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strILS_Snrinoutline_V_ID, String strPILS_Inoutpackage_V_ID, TableSQLData tableSQL)
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
    Identifier5922410B58494163926E76EA55C67313Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamSerialnumber = vars.getSessionValue(tabId + "|paramSerialnumber");

    boolean hasSearchCondition=false;
    if (!(strParamSerialnumber.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = Identifier5922410B58494163926E76EA55C67313Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPILS_Inoutpackage_V_ID, strILS_Snrinoutline_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strILS_Snrinoutline_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (data==null || data.length==0) {
        strILS_Snrinoutline_V_ID = firstElement(vars, tableSQL);
        if (strILS_Snrinoutline_V_ID.equals("")) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        } else {
          data = Identifier5922410B58494163926E76EA55C67313Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPILS_Inoutpackage_V_ID, strILS_Snrinoutline_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
        }
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new Identifier5922410B58494163926E76EA55C67313Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("ilsSnrinoutlineVId") == null || dataField.getField("ilsSnrinoutlineVId").equals("")) {
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
        refreshSessionNew(vars, strPILS_Inoutpackage_V_ID);
        data = Identifier5922410B58494163926E76EA55C67313Data.set(strPILS_Inoutpackage_V_ID, "", Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "4E31A5C7FD0148D68553F0F913396CDB", "5922410B58494163926E76EA55C67313", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "4E31A5C7FD0148D68553F0F913396CDB", "5922410B58494163926E76EA55C67313", "", dataField), Utility.getDefault(this, vars, "Isunavailable", "N", "4E31A5C7FD0148D68553F0F913396CDB", "5922410B58494163926E76EA55C67313", "N", dataField), Utility.getDefault(this, vars, "Updatedby", "", "4E31A5C7FD0148D68553F0F913396CDB", "5922410B58494163926E76EA55C67313", "", dataField), Identifier5922410B58494163926E76EA55C67313Data.selectDef0A55F0E27BE345A9854425F5A842BF60_0(this, Utility.getDefault(this, vars, "Updatedby", "", "4E31A5C7FD0148D68553F0F913396CDB", "5922410B58494163926E76EA55C67313", "", dataField)), Utility.getDefault(this, vars, "Createdby", "", "4E31A5C7FD0148D68553F0F913396CDB", "5922410B58494163926E76EA55C67313", "", dataField), Identifier5922410B58494163926E76EA55C67313Data.selectDef7D47ACA98A37438793337F5F39F800F2_1(this, Utility.getDefault(this, vars, "Createdby", "", "4E31A5C7FD0148D68553F0F913396CDB", "5922410B58494163926E76EA55C67313", "", dataField)), "Y", Utility.getDefault(this, vars, "Serialnumber", "", "4E31A5C7FD0148D68553F0F913396CDB", "5922410B58494163926E76EA55C67313", "", dataField));
        
      }
    } else {
      data = new Identifier5922410B58494163926E76EA55C67313Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(Identifier5922410B58494163926E76EA55C67313Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=Receipt62314289EB0A4FFBA4ACDB985018C68BData.selectOrg(this, strPILS_Inoutpackage_V_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Identifier5922410B58494163926E76EA55C67313", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpilsSnrinoutlineVId", "", "..", "".equals("Y"), "PackageReceipt", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strILS_Snrinoutline_V_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPILS_Inoutpackage_V_ID) throws IOException, ServletException {
    Identifier5922410B58494163926E76EA55C67313Data data = null;
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
            data = getEditVariables(con, vars, strPILS_Inoutpackage_V_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.ilsSnrinoutlineVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (Identifier5922410B58494163926E76EA55C67313Data.getCurrentDBTimestamp(this, data.ilsSnrinoutlineVId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.ilsSnrinoutlineVId, vars, this);
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
                    data.ilsSnrinoutlineVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|ILS_Snrinoutline_V_ID", data.ilsSnrinoutlineVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Identifier5922410B58494163926E76EA55C67313. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
