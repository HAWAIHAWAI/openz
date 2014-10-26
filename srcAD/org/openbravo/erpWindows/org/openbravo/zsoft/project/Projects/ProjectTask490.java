
package org.openbravo.erpWindows.org.openbravo.zsoft.project.Projects;


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

public class ProjectTask490 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(ProjectTask490.class);
  
  private static final String windowId = "130";
  private static final String tabId = "490";
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
        String strcProjecttaskId = request.getParameter("inpcProjecttaskId");
         String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcProjecttaskId.equals(""))
              total = saveRecord(vars, myError, 'U', strPC_Project_ID);
          else
              total = saveRecord(vars, myError, 'I', strPC_Project_ID);
          
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
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID", "");

      String strC_ProjectTask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID", "");
            if (strPC_Project_ID.equals("")) {
        strPC_Project_ID = getParentID(vars, strC_ProjectTask_ID);
        if (strPC_Project_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_Project_ID");
        vars.setSessionValue(windowId + "|C_Project_ID", strPC_Project_ID);

        refreshParentSession(vars, strPC_Project_ID);
      }


      String strView = vars.getSessionValue(tabId + "|ProjectTask490.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_ProjectTask_ID.equals("")) strC_ProjectTask_ID = firstElement(vars, tableSQL);
          if (strC_ProjectTask_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_ProjectTask_ID, strPC_Project_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Project_ID, strC_ProjectTask_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_ProjectTask_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_ProjectTask_ID.equals("")) strC_ProjectTask_ID = vars.getRequiredGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID");
      else vars.setSessionValue(windowId + "|C_ProjectTask_ID", strC_ProjectTask_ID);
      
      
      String strPC_Project_ID = getParentID(vars, strC_ProjectTask_ID);
      
      vars.setSessionValue(windowId + "|C_Project_ID", strPC_Project_ID);
      vars.setSessionValue("157|Project-Header.view", "EDIT");

      refreshParentSession(vars, strPC_Project_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|ProjectTask490.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_ProjectTask_ID, strPC_Project_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|ProjectTask490.view", "RELATION");
        printPageDataSheet(response, vars, strPC_Project_ID, strC_ProjectTask_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|C_ProjectTask_ID");
      refreshParentSession(vars, strPC_Project_ID);


      String strView = vars.getSessionValue(tabId + "|ProjectTask490.view");
      String strC_ProjectTask_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_ProjectTask_ID = firstElement(vars, tableSQL);
          if (strC_ProjectTask_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_ProjectTask_ID.equals("")) strC_ProjectTask_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_ProjectTask_ID, strPC_Project_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_Project_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamC_Project_ID", tabId + "|paramC_Project_ID");

            String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");

      
      vars.removeSessionValue(windowId + "|C_ProjectTask_ID");
      String strC_ProjectTask_ID="";

      String strView = vars.getSessionValue(tabId + "|ProjectTask490.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_ProjectTask_ID = firstElement(vars, tableSQL);
        if (strC_ProjectTask_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|ProjectTask490.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_ProjectTask_ID, strPC_Project_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Project_ID, strC_ProjectTask_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");
      

      String strC_ProjectTask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID", "");
      vars.setSessionValue(tabId + "|ProjectTask490.view", "RELATION");
      printPageDataSheet(response, vars, strPC_Project_ID, strC_ProjectTask_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");


      printPageEdit(response, request, vars, true, "", strPC_Project_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_ProjectTask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID", "");
      vars.setSessionValue(tabId + "|ProjectTask490.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_ProjectTask_ID, strPC_Project_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");
      String strC_ProjectTask_ID = vars.getRequiredStringParameter("inpcProjecttaskId");
      
      String strNext = nextElement(vars, strC_ProjectTask_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_Project_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");
      String strC_ProjectTask_ID = vars.getRequiredStringParameter("inpcProjecttaskId");
      
      String strPrevious = previousElement(vars, strC_ProjectTask_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_Project_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");

      vars.setSessionValue(tabId + "|ProjectTask490.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|ProjectTask490.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|ProjectTask490.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|ProjectTask490.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_ProjectTask_ID");
      vars.setSessionValue(windowId + "|C_Project_ID", strPC_Project_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|ProjectTask490.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|ProjectTask490.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_ProjectTask_ID");
      vars.setSessionValue(windowId + "|C_Project_ID", strPC_Project_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPC_Project_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPC_Project_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPC_Project_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPC_Project_ID);      
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
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");
      String strC_ProjectTask_ID = vars.getRequiredGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPC_Project_ID);      
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
          String strNext = nextElement(vars, strC_ProjectTask_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_ProjectTask_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");

      String strC_ProjectTask_ID = vars.getRequiredInStringParameter("inpcProjecttaskId");
      String message = deleteRelation(vars, strC_ProjectTask_ID, strPC_Project_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cProjecttaskId");
        vars.setSessionValue(tabId + "|ProjectTask490.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPC_Project_ID = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");

      String strC_ProjectTask_ID = vars.getRequiredStringParameter("inpcProjecttaskId");
      //ProjectTask490Data data = getEditVariables(vars, strPC_Project_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = ProjectTask490Data.delete(this, strC_ProjectTask_ID, strPC_Project_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cProjecttaskId");
        vars.setSessionValue(tabId + "|ProjectTask490.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONPreplanmaterial57015F5D946C4D7F9BD584C16BAF8201")) {
        vars.setSessionValue("button57015F5D946C4D7F9BD584C16BAF8201.strpreplanmaterial", vars.getStringParameter("inppreplanmaterial"));
        vars.setSessionValue("button57015F5D946C4D7F9BD584C16BAF8201.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button57015F5D946C4D7F9BD584C16BAF8201.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button57015F5D946C4D7F9BD584C16BAF8201.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button57015F5D946C4D7F9BD584C16BAF8201.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "57015F5D946C4D7F9BD584C16BAF8201", request.getServletPath());    
     } else if (vars.commandIn("BUTTON57015F5D946C4D7F9BD584C16BAF8201")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID", "");
        String strpreplanmaterial = vars.getSessionValue("button57015F5D946C4D7F9BD584C16BAF8201.strpreplanmaterial");
        String strProcessing = vars.getSessionValue("button57015F5D946C4D7F9BD584C16BAF8201.strProcessing");
        String strOrg = vars.getSessionValue("button57015F5D946C4D7F9BD584C16BAF8201.strOrg");
        String strClient = vars.getSessionValue("button57015F5D946C4D7F9BD584C16BAF8201.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonPreplanmaterial57015F5D946C4D7F9BD584C16BAF8201(response, vars, strC_ProjectTask_ID, strpreplanmaterial, strProcessing);
        }

     } else if (vars.commandIn("BUTTONCopyptask0CABC5C489604305B9C05718CEE88C90")) {
        vars.setSessionValue("button0CABC5C489604305B9C05718CEE88C90.strcopyptask", vars.getStringParameter("inpcopyptask"));
        vars.setSessionValue("button0CABC5C489604305B9C05718CEE88C90.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button0CABC5C489604305B9C05718CEE88C90.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button0CABC5C489604305B9C05718CEE88C90.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        p.put("C_Project_ID", vars.getStringParameter("inpcProjectId"));

        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button0CABC5C489604305B9C05718CEE88C90.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "0CABC5C489604305B9C05718CEE88C90", request.getServletPath());    
     } else if (vars.commandIn("BUTTON0CABC5C489604305B9C05718CEE88C90")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID", "");
        String strcopyptask = vars.getSessionValue("button0CABC5C489604305B9C05718CEE88C90.strcopyptask");
        String strProcessing = vars.getSessionValue("button0CABC5C489604305B9C05718CEE88C90.strProcessing");
        String strOrg = vars.getSessionValue("button0CABC5C489604305B9C05718CEE88C90.strOrg");
        String strClient = vars.getSessionValue("button0CABC5C489604305B9C05718CEE88C90.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCopyptask0CABC5C489604305B9C05718CEE88C90(response, vars, strC_ProjectTask_ID, strcopyptask, strProcessing);
        }

     } else if (vars.commandIn("BUTTONCreatebomEA7B66710CE548CF9F704ABE5DD3608F")) {
        vars.setSessionValue("buttonEA7B66710CE548CF9F704ABE5DD3608F.strcreatebom", vars.getStringParameter("inpcreatebom"));
        vars.setSessionValue("buttonEA7B66710CE548CF9F704ABE5DD3608F.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonEA7B66710CE548CF9F704ABE5DD3608F.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonEA7B66710CE548CF9F704ABE5DD3608F.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonEA7B66710CE548CF9F704ABE5DD3608F.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "EA7B66710CE548CF9F704ABE5DD3608F", request.getServletPath());    
     } else if (vars.commandIn("BUTTONEA7B66710CE548CF9F704ABE5DD3608F")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID", "");
        String strcreatebom = vars.getSessionValue("buttonEA7B66710CE548CF9F704ABE5DD3608F.strcreatebom");
        String strProcessing = vars.getSessionValue("buttonEA7B66710CE548CF9F704ABE5DD3608F.strProcessing");
        String strOrg = vars.getSessionValue("buttonEA7B66710CE548CF9F704ABE5DD3608F.strOrg");
        String strClient = vars.getSessionValue("buttonEA7B66710CE548CF9F704ABE5DD3608F.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCreatebomEA7B66710CE548CF9F704ABE5DD3608F(response, vars, strC_ProjectTask_ID, strcreatebom, strProcessing);
        }

     } else if (vars.commandIn("BUTTONPlanmaterial4BB6C04ECD8A486CA7C4BA75E685816C")) {
        vars.setSessionValue("button4BB6C04ECD8A486CA7C4BA75E685816C.strplanmaterial", vars.getStringParameter("inpplanmaterial"));
        vars.setSessionValue("button4BB6C04ECD8A486CA7C4BA75E685816C.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button4BB6C04ECD8A486CA7C4BA75E685816C.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button4BB6C04ECD8A486CA7C4BA75E685816C.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button4BB6C04ECD8A486CA7C4BA75E685816C.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "4BB6C04ECD8A486CA7C4BA75E685816C", request.getServletPath());    
     } else if (vars.commandIn("BUTTON4BB6C04ECD8A486CA7C4BA75E685816C")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID", "");
        String strplanmaterial = vars.getSessionValue("button4BB6C04ECD8A486CA7C4BA75E685816C.strplanmaterial");
        String strProcessing = vars.getSessionValue("button4BB6C04ECD8A486CA7C4BA75E685816C.strProcessing");
        String strOrg = vars.getSessionValue("button4BB6C04ECD8A486CA7C4BA75E685816C.strOrg");
        String strClient = vars.getSessionValue("button4BB6C04ECD8A486CA7C4BA75E685816C.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonPlanmaterial4BB6C04ECD8A486CA7C4BA75E685816C(response, vars, strC_ProjectTask_ID, strplanmaterial, strProcessing);
        }

     } else if (vars.commandIn("BUTTONUnplanmaterialAD93C112045249B78A9D3BEEC04F42B0")) {
        vars.setSessionValue("buttonAD93C112045249B78A9D3BEEC04F42B0.strunplanmaterial", vars.getStringParameter("inpunplanmaterial"));
        vars.setSessionValue("buttonAD93C112045249B78A9D3BEEC04F42B0.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonAD93C112045249B78A9D3BEEC04F42B0.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonAD93C112045249B78A9D3BEEC04F42B0.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonAD93C112045249B78A9D3BEEC04F42B0.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "AD93C112045249B78A9D3BEEC04F42B0", request.getServletPath());    
     } else if (vars.commandIn("BUTTONAD93C112045249B78A9D3BEEC04F42B0")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID", "");
        String strunplanmaterial = vars.getSessionValue("buttonAD93C112045249B78A9D3BEEC04F42B0.strunplanmaterial");
        String strProcessing = vars.getSessionValue("buttonAD93C112045249B78A9D3BEEC04F42B0.strProcessing");
        String strOrg = vars.getSessionValue("buttonAD93C112045249B78A9D3BEEC04F42B0.strOrg");
        String strClient = vars.getSessionValue("buttonAD93C112045249B78A9D3BEEC04F42B0.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonUnplanmaterialAD93C112045249B78A9D3BEEC04F42B0(response, vars, strC_ProjectTask_ID, strunplanmaterial, strProcessing);
        }

     } else if (vars.commandIn("BUTTONGetmaterialfromstockA7A38A66C68F4799826CF635BFBE0027")) {
        vars.setSessionValue("buttonA7A38A66C68F4799826CF635BFBE0027.strgetmaterialfromstock", vars.getStringParameter("inpgetmaterialfromstock"));
        vars.setSessionValue("buttonA7A38A66C68F4799826CF635BFBE0027.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonA7A38A66C68F4799826CF635BFBE0027.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonA7A38A66C68F4799826CF635BFBE0027.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonA7A38A66C68F4799826CF635BFBE0027.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "A7A38A66C68F4799826CF635BFBE0027", request.getServletPath());    
     } else if (vars.commandIn("BUTTONA7A38A66C68F4799826CF635BFBE0027")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID", "");
        String strgetmaterialfromstock = vars.getSessionValue("buttonA7A38A66C68F4799826CF635BFBE0027.strgetmaterialfromstock");
        String strProcessing = vars.getSessionValue("buttonA7A38A66C68F4799826CF635BFBE0027.strProcessing");
        String strOrg = vars.getSessionValue("buttonA7A38A66C68F4799826CF635BFBE0027.strOrg");
        String strClient = vars.getSessionValue("buttonA7A38A66C68F4799826CF635BFBE0027.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonGetmaterialfromstockA7A38A66C68F4799826CF635BFBE0027(response, vars, strC_ProjectTask_ID, strgetmaterialfromstock, strProcessing);
        }

     } else if (vars.commandIn("BUTTONReturnmaterialtostockDF8481DB26CA47D4BF842C8AA3E49A9B")) {
        vars.setSessionValue("buttonDF8481DB26CA47D4BF842C8AA3E49A9B.strreturnmaterialtostock", vars.getStringParameter("inpreturnmaterialtostock"));
        vars.setSessionValue("buttonDF8481DB26CA47D4BF842C8AA3E49A9B.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonDF8481DB26CA47D4BF842C8AA3E49A9B.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonDF8481DB26CA47D4BF842C8AA3E49A9B.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonDF8481DB26CA47D4BF842C8AA3E49A9B.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "DF8481DB26CA47D4BF842C8AA3E49A9B", request.getServletPath());    
     } else if (vars.commandIn("BUTTONDF8481DB26CA47D4BF842C8AA3E49A9B")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID", "");
        String strreturnmaterialtostock = vars.getSessionValue("buttonDF8481DB26CA47D4BF842C8AA3E49A9B.strreturnmaterialtostock");
        String strProcessing = vars.getSessionValue("buttonDF8481DB26CA47D4BF842C8AA3E49A9B.strProcessing");
        String strOrg = vars.getSessionValue("buttonDF8481DB26CA47D4BF842C8AA3E49A9B.strOrg");
        String strClient = vars.getSessionValue("buttonDF8481DB26CA47D4BF842C8AA3E49A9B.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonReturnmaterialtostockDF8481DB26CA47D4BF842C8AA3E49A9B(response, vars, strC_ProjectTask_ID, strreturnmaterialtostock, strProcessing);
        }

     } else if (vars.commandIn("BUTTONBegintaskAA3B9F4E77034F9D902BCF8BCB375A8C")) {
        vars.setSessionValue("buttonAA3B9F4E77034F9D902BCF8BCB375A8C.strbegintask", vars.getStringParameter("inpbegintask"));
        vars.setSessionValue("buttonAA3B9F4E77034F9D902BCF8BCB375A8C.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonAA3B9F4E77034F9D902BCF8BCB375A8C.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonAA3B9F4E77034F9D902BCF8BCB375A8C.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonAA3B9F4E77034F9D902BCF8BCB375A8C.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "AA3B9F4E77034F9D902BCF8BCB375A8C", request.getServletPath());    
     } else if (vars.commandIn("BUTTONAA3B9F4E77034F9D902BCF8BCB375A8C")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID", "");
        String strbegintask = vars.getSessionValue("buttonAA3B9F4E77034F9D902BCF8BCB375A8C.strbegintask");
        String strProcessing = vars.getSessionValue("buttonAA3B9F4E77034F9D902BCF8BCB375A8C.strProcessing");
        String strOrg = vars.getSessionValue("buttonAA3B9F4E77034F9D902BCF8BCB375A8C.strOrg");
        String strClient = vars.getSessionValue("buttonAA3B9F4E77034F9D902BCF8BCB375A8C.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBegintaskAA3B9F4E77034F9D902BCF8BCB375A8C(response, vars, strC_ProjectTask_ID, strbegintask, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEndtask4B4D99FCF77C4975B726D40794A920EB")) {
        vars.setSessionValue("button4B4D99FCF77C4975B726D40794A920EB.strendtask", vars.getStringParameter("inpendtask"));
        vars.setSessionValue("button4B4D99FCF77C4975B726D40794A920EB.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button4B4D99FCF77C4975B726D40794A920EB.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button4B4D99FCF77C4975B726D40794A920EB.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button4B4D99FCF77C4975B726D40794A920EB.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "4B4D99FCF77C4975B726D40794A920EB", request.getServletPath());    
     } else if (vars.commandIn("BUTTON4B4D99FCF77C4975B726D40794A920EB")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID", "");
        String strendtask = vars.getSessionValue("button4B4D99FCF77C4975B726D40794A920EB.strendtask");
        String strProcessing = vars.getSessionValue("button4B4D99FCF77C4975B726D40794A920EB.strProcessing");
        String strOrg = vars.getSessionValue("button4B4D99FCF77C4975B726D40794A920EB.strOrg");
        String strClient = vars.getSessionValue("button4B4D99FCF77C4975B726D40794A920EB.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEndtask4B4D99FCF77C4975B726D40794A920EB(response, vars, strC_ProjectTask_ID, strendtask, strProcessing);
        }

     } else if (vars.commandIn("BUTTONCanceltaskE32139CEB5F44BA99B5E64B86E56ABA5")) {
        vars.setSessionValue("buttonE32139CEB5F44BA99B5E64B86E56ABA5.strcanceltask", vars.getStringParameter("inpcanceltask"));
        vars.setSessionValue("buttonE32139CEB5F44BA99B5E64B86E56ABA5.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonE32139CEB5F44BA99B5E64B86E56ABA5.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonE32139CEB5F44BA99B5E64B86E56ABA5.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonE32139CEB5F44BA99B5E64B86E56ABA5.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "E32139CEB5F44BA99B5E64B86E56ABA5", request.getServletPath());    
     } else if (vars.commandIn("BUTTONE32139CEB5F44BA99B5E64B86E56ABA5")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID", "");
        String strcanceltask = vars.getSessionValue("buttonE32139CEB5F44BA99B5E64B86E56ABA5.strcanceltask");
        String strProcessing = vars.getSessionValue("buttonE32139CEB5F44BA99B5E64B86E56ABA5.strProcessing");
        String strOrg = vars.getSessionValue("buttonE32139CEB5F44BA99B5E64B86E56ABA5.strOrg");
        String strClient = vars.getSessionValue("buttonE32139CEB5F44BA99B5E64B86E56ABA5.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCanceltaskE32139CEB5F44BA99B5E64B86E56ABA5(response, vars, strC_ProjectTask_ID, strcanceltask, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONPreplanmaterial57015F5D946C4D7F9BD584C16BAF8201")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpKey", windowId + "|C_ProjectTask_ID", "");
        @SuppressWarnings("unused")
        String strpreplanmaterial = vars.getStringParameter("inppreplanmaterial");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "57015F5D946C4D7F9BD584C16BAF8201", (("C_ProjectTask_ID".equalsIgnoreCase("AD_Language"))?"0":strC_ProjectTask_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONCopyptask0CABC5C489604305B9C05718CEE88C90")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpKey", windowId + "|C_ProjectTask_ID", "");
        @SuppressWarnings("unused")
        String strcopyptask = vars.getStringParameter("inpcopyptask");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "0CABC5C489604305B9C05718CEE88C90", (("C_ProjectTask_ID".equalsIgnoreCase("AD_Language"))?"0":strC_ProjectTask_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strcProjectId = vars.getStringParameter("inpcProjectId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_Project_ID", strcProjectId, vars.getClient(), vars.getOrg(), vars.getUser());
String strcProjecttaskId = vars.getStringParameter("inpcProjecttaskId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "C_Projecttask_Id", strcProjecttaskId, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
    } else if (vars.commandIn("SAVE_BUTTONCreatebomEA7B66710CE548CF9F704ABE5DD3608F")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpKey", windowId + "|C_ProjectTask_ID", "");
        @SuppressWarnings("unused")
        String strcreatebom = vars.getStringParameter("inpcreatebom");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "EA7B66710CE548CF9F704ABE5DD3608F", (("C_ProjectTask_ID".equalsIgnoreCase("AD_Language"))?"0":strC_ProjectTask_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONPlanmaterial4BB6C04ECD8A486CA7C4BA75E685816C")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpKey", windowId + "|C_ProjectTask_ID", "");
        @SuppressWarnings("unused")
        String strplanmaterial = vars.getStringParameter("inpplanmaterial");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "4BB6C04ECD8A486CA7C4BA75E685816C", (("C_ProjectTask_ID".equalsIgnoreCase("AD_Language"))?"0":strC_ProjectTask_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONUnplanmaterialAD93C112045249B78A9D3BEEC04F42B0")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpKey", windowId + "|C_ProjectTask_ID", "");
        @SuppressWarnings("unused")
        String strunplanmaterial = vars.getStringParameter("inpunplanmaterial");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "AD93C112045249B78A9D3BEEC04F42B0", (("C_ProjectTask_ID".equalsIgnoreCase("AD_Language"))?"0":strC_ProjectTask_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONGetmaterialfromstockA7A38A66C68F4799826CF635BFBE0027")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpKey", windowId + "|C_ProjectTask_ID", "");
        @SuppressWarnings("unused")
        String strgetmaterialfromstock = vars.getStringParameter("inpgetmaterialfromstock");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "A7A38A66C68F4799826CF635BFBE0027", (("C_ProjectTask_ID".equalsIgnoreCase("AD_Language"))?"0":strC_ProjectTask_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONReturnmaterialtostockDF8481DB26CA47D4BF842C8AA3E49A9B")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpKey", windowId + "|C_ProjectTask_ID", "");
        @SuppressWarnings("unused")
        String strreturnmaterialtostock = vars.getStringParameter("inpreturnmaterialtostock");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "DF8481DB26CA47D4BF842C8AA3E49A9B", (("C_ProjectTask_ID".equalsIgnoreCase("AD_Language"))?"0":strC_ProjectTask_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strreturnequipmentorall = vars.getStringParameter("inpreturnequipmentorall");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "returnequipmentorall", strreturnequipmentorall, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
    } else if (vars.commandIn("SAVE_BUTTONBegintaskAA3B9F4E77034F9D902BCF8BCB375A8C")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpKey", windowId + "|C_ProjectTask_ID", "");
        @SuppressWarnings("unused")
        String strbegintask = vars.getStringParameter("inpbegintask");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "AA3B9F4E77034F9D902BCF8BCB375A8C", (("C_ProjectTask_ID".equalsIgnoreCase("AD_Language"))?"0":strC_ProjectTask_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEndtask4B4D99FCF77C4975B726D40794A920EB")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpKey", windowId + "|C_ProjectTask_ID", "");
        @SuppressWarnings("unused")
        String strendtask = vars.getStringParameter("inpendtask");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "4B4D99FCF77C4975B726D40794A920EB", (("C_ProjectTask_ID".equalsIgnoreCase("AD_Language"))?"0":strC_ProjectTask_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONCanceltaskE32139CEB5F44BA99B5E64B86E56ABA5")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpKey", windowId + "|C_ProjectTask_ID", "");
        @SuppressWarnings("unused")
        String strcanceltask = vars.getStringParameter("inpcanceltask");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "E32139CEB5F44BA99B5E64B86E56ABA5", (("C_ProjectTask_ID".equalsIgnoreCase("AD_Language"))?"0":strC_ProjectTask_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
  String deleteRelation(VariablesSecureApp vars, String strC_ProjectTask_ID, String strPC_Project_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_ProjectTask_ID.startsWith("(")) strC_ProjectTask_ID = strC_ProjectTask_ID.substring(1, strC_ProjectTask_ID.length()-1);
      if (!strC_ProjectTask_ID.equals("")) {
        strC_ProjectTask_ID = Replace.replace(strC_ProjectTask_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_ProjectTask_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (ProjectTask490Data.deleteTransactional(conn, this, strKey, strPC_Project_ID)==0) {
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
  private ProjectTask490Data getEditVariables(Connection con, VariablesSecureApp vars, String strPC_Project_ID) throws IOException,ServletException {
    ProjectTask490Data data = new ProjectTask490Data();
    ServletException ex = null;
    try {
    data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");    try {   data.seqno = vars.getNumericParameter("inpseqno");  } catch (ServletException paramEx) { ex = paramEx; }     data.isactive = vars.getStringParameter("inpisactive", "N");     data.adUserId = vars.getStringParameter("inpadUserId");     data.adUserIdr = vars.getStringParameter("inpadUserId_R");     data.outsourcing = vars.getRequiredInputGlobalVariable("inpoutsourcing", windowId + "|Outsourcing", "N");     data.name = vars.getStringParameter("inpname");     data.description = vars.getStringParameter("inpdescription");     data.help = vars.getStringParameter("inphelp");     data.cColorId = vars.getStringParameter("inpcColorId");     data.cColorIdr = vars.getStringParameter("inpcColorId_R");     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");    try {   data.qty = vars.getNumericParameter("inpqty");  } catch (ServletException paramEx) { ex = paramEx; }     data.startdate = vars.getStringParameter("inpstartdate");     data.enddate = vars.getStringParameter("inpenddate");     data.feedbackfinished = vars.getStringParameter("inpfeedbackfinished", "N");     data.taskbegun = vars.getRequiredInputGlobalVariable("inptaskbegun", windowId + "|Taskbegun", "N");     data.iscomplete = vars.getStringParameter("inpiscomplete", "N");     data.ismaterialdisposed = vars.getRequiredInputGlobalVariable("inpismaterialdisposed", windowId + "|Ismaterialdisposed", "N");     data.istaskcancelled = vars.getStringParameter("inpistaskcancelled", "N");    try {   data.expensesplan = vars.getNumericParameter("inpexpensesplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.expenses = vars.getNumericParameter("inpexpenses");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.externalserviceplan = vars.getNumericParameter("inpexternalserviceplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.externalservice = vars.getNumericParameter("inpexternalservice");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.materialcostplan = vars.getNumericParameter("inpmaterialcostplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.materialcost = vars.getNumericParameter("inpmaterialcost");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.servcostplan = vars.getNumericParameter("inpservcostplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.servcost = vars.getNumericParameter("inpservcost");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.machinecostplan = vars.getNumericParameter("inpmachinecostplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.machinecost = vars.getNumericParameter("inpmachinecost");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.indirectcostplan = vars.getNumericParameter("inpindirectcostplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.indirectcost = vars.getNumericParameter("inpindirectcost");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.committedamt = vars.getNumericParameter("inpcommittedamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.invoicedamt = vars.getNumericParameter("inpinvoicedamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.plannedcost = vars.getNumericParameter("inpplannedcost");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.actualcost = vars.getNumericParameter("inpactualcost");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.percentdone = vars.getNumericParameter("inppercentdone");  } catch (ServletException paramEx) { ex = paramEx; }     data.schedulestatus = vars.getStringParameter("inpschedulestatus");     data.schedulestatusr = vars.getStringParameter("inpschedulestatus_R");     data.preplanmaterial = vars.getStringParameter("inppreplanmaterial");     data.copyptask = vars.getStringParameter("inpcopyptask");     data.createbom = vars.getStringParameter("inpcreatebom");     data.planmaterial = vars.getStringParameter("inpplanmaterial");     data.unplanmaterial = vars.getStringParameter("inpunplanmaterial");     data.getmaterialfromstock = vars.getStringParameter("inpgetmaterialfromstock");     data.returnmaterialtostock = vars.getStringParameter("inpreturnmaterialtostock");     data.begintask = vars.getStringParameter("inpbegintask");     data.endtask = vars.getStringParameter("inpendtask");     data.canceltask = vars.getStringParameter("inpcanceltask");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.cProjecttaskId = vars.getRequestGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.datecontract = vars.getStringParameter("inpdatecontract");     data.gotopurchasing = vars.getStringParameter("inpgotopurchasing", "N");     data.cTaskId = vars.getStringParameter("inpcTaskId");    try {   data.priceactual = vars.getNumericParameter("inppriceactual");  } catch (ServletException paramEx) { ex = paramEx; }     data.iscommitceiling = vars.getStringParameter("inpiscommitceiling", "N");     data.cProjectphaseId = vars.getStringParameter("inpcProjectphaseId"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cProjectId = vars.getGlobalVariable("inpcProjectId", windowId + "|C_Project_ID");


    
    

    
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

   private ProjectTask490Data[] getRelationData(ProjectTask490Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 32);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 32);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].help = FormatUtilities.truncate(data[i].help, 50);        data[i].cColorId = FormatUtilities.truncate(data[i].cColorId, 32);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 44);        data[i].schedulestatus = FormatUtilities.truncate(data[i].schedulestatus, 50);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 10);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].cTaskId = FormatUtilities.truncate(data[i].cTaskId, 44);        data[i].cProjectphaseId = FormatUtilities.truncate(data[i].cProjectphaseId, 44);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPC_Project_ID) throws IOException,ServletException {
      ProjectHeader157Data[] data = ProjectHeader157Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Project_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|ProjectCategory", data[0].projectcategory);    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].mWarehouseId);    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].cBpartnerId);    vars.setSessionValue(windowId + "|C_Project_ID", data[0].cProjectId);    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].cCurrencyId);    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].mPricelistId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|IsCommitment", data[0].iscommitment);
      vars.setSessionValue(windowId + "|C_Project_ID", strPC_Project_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
      vars.setSessionValue(windowId + "|PREPROJECTCATEGORY", "S");
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strC_ProjectTask_ID) throws ServletException {
    String strPC_Project_ID = ProjectTask490Data.selectParentID(this, strC_ProjectTask_ID);
    if (strPC_Project_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strC_ProjectTask_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_Project_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Outsourcing", data[0].getField("outsourcing"));    vars.setSessionValue(windowId + "|Taskbegun", data[0].getField("taskbegun"));    vars.setSessionValue(windowId + "|Ismaterialdisposed", data[0].getField("ismaterialdisposed"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|C_ProjectTask_ID", data[0].getField("cProjecttaskId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_Project_ID) throws IOException,ServletException {
      ProjectTask490Data[] data = ProjectTask490Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Project_ID, vars.getStringParameter("inpcProjecttaskId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_Project_ID, String strC_ProjectTask_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamName.equals("") && strParamC_Project_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_ProjectTask_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_ProjectTask_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/project/Projects/ProjectTask490_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "ProjectTask490", false, "document.frmMain.inpcProjecttaskId", "grid", "../projecttask/print.html", "N".equals("Y"), "Projects", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPC_Project_ID);

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
    xmlDocument.setParameter("KeyName", "cProjecttaskId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "ProjectTask490_Relation.html", "Projects", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "ProjectTask490_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", ProjectTask490Data.selectParent(this, strPC_Project_ID));
    else xmlDocument.setParameter("parent", ProjectTask490Data.selectParentTrl(this, strPC_Project_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_ProjectTask_ID, String strPC_Project_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " C_ProjectTask.SeqNo";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    ProjectTask490Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");

    boolean hasSearchCondition=false;
    if (!(strParamName.equals("") && strParamC_Project_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = ProjectTask490Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Project_ID, strC_ProjectTask_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_ProjectTask_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new ProjectTask490Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cProjecttaskId") == null || dataField.getField("cProjecttaskId").equals("")) {
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
        refreshSessionNew(vars, strPC_Project_ID);
        data = ProjectTask490Data.set(strPC_Project_ID, Utility.getDefault(this, vars, "C_Projectphase_ID", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "Name", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "Materialcostplan", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "Returnmaterialtostock", "N", "130", "490", "N", dataField), Utility.getDefault(this, vars, "C_Color_ID", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "Istaskcancelled", "N", "130", "490", "N", dataField), Utility.getDefault(this, vars, "Externalserviceplan", "0", "130", "490", "", dataField), Utility.getDefault(this, vars, "Servcostplan", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "Expensesplan", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "Qty", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "Outsourcing", "N", "130", "490", "N", dataField), Utility.getDefault(this, vars, "AD_User_ID", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "Invoicedamt", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "Schedulestatus", "OK", "130", "490", "", dataField), Utility.getDefault(this, vars, "Indirectcostplan", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "Help", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "Iscomplete", "N", "130", "490", "N", dataField), Utility.getDefault(this, vars, "Datecontract", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "Machinecostplan", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "C_Task_ID", "", "130", "490", "", dataField), "", Utility.getDefault(this, vars, "Copyptask", "N", "130", "490", "N", dataField), Utility.getDefault(this, vars, "Createbom", "N", "130", "490", "N", dataField), Utility.getDefault(this, vars, "Servcost", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "Materialcost", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "Iscommitceiling", "N", "130", "490", "N", dataField), Utility.getDefault(this, vars, "PriceActual", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "Gotopurchasing", "N", "130", "490", "N", dataField), Utility.getDefault(this, vars, "Feedbackfinished", "N", "130", "490", "N", dataField), Utility.getDefault(this, vars, "Begintask", "N", "130", "490", "N", dataField), Utility.getDefault(this, vars, "Percentdone", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "Taskbegun", "N", "130", "490", "N", dataField), Utility.getDefault(this, vars, "Endtask", "N", "130", "490", "N", dataField), Utility.getDefault(this, vars, "Plannedcost", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "130", "490", "", dataField), ProjectTask490Data.selectDef8890_0(this, Utility.getDefault(this, vars, "M_Product_ID", "", "130", "490", "", dataField)), Utility.getDefault(this, vars, "Description", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "130", "490", "", dataField), ProjectTask490Data.selectDef8893_1(this, Utility.getDefault(this, vars, "CreatedBy", "", "130", "490", "", dataField)), ProjectTask490Data.selectDef1005900001(this, Utility.getContext(this, vars, "#AD_JAVADATEFORMAT", windowId), strPC_Project_ID), Utility.getDefault(this, vars, "Indirectcost", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "Ismaterialdisposed", "N", "130", "490", "N", dataField), Utility.getDefault(this, vars, "Machinecost", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "130", "490", "", dataField), ProjectTask490Data.selectDef8895_2(this, Utility.getDefault(this, vars, "UpdatedBy", "", "130", "490", "", dataField)), Utility.getDefault(this, vars, "Planmaterial", "N", "130", "490", "N", dataField), ProjectTask490Data.selectDef1005900000(this, Utility.getContext(this, vars, "#AD_JAVADATEFORMAT", windowId), strPC_Project_ID), Utility.getDefault(this, vars, "Expenses", "", "130", "490", "", dataField), ProjectTask490Data.selectDef8894(this, strPC_Project_ID), Utility.getDefault(this, vars, "Committedamt", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "130", "490", "", dataField), Utility.getDefault(this, vars, "Getmaterialfromstock", "N", "130", "490", "N", dataField), "Y", Utility.getDefault(this, vars, "Preplanmaterial", "N", "130", "490", "N", dataField), Utility.getDefault(this, vars, "Externalservice", "0", "130", "490", "", dataField), Utility.getDefault(this, vars, "Canceltask", "N", "130", "490", "N", dataField), Utility.getDefault(this, vars, "Actualcost", "", "130", "490", "", dataField), Utility.getDefault(this, vars, "Unplanmaterial", "N", "130", "490", "N", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "130", "490", "", dataField));
        
      }
    } else {
      data = new ProjectTask490Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(ProjectTask490Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=ProjectHeader157Data.selectOrg(this, strPC_Project_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "ProjectTask490", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcProjecttaskId", "", "../projecttask/print.html", "N".equals("Y"), "Projects", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_ProjectTask_ID));
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
  
    void printPageButtonPreplanmaterial57015F5D946C4D7F9BD584C16BAF8201(HttpServletResponse response, VariablesSecureApp vars, String strC_ProjectTask_ID, String strpreplanmaterial, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "57015F5D946C4D7F9BD584C16BAF8201",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "57015F5D946C4D7F9BD584C16BAF8201" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"57015F5D946C4D7F9BD584C16BAF8201" );
        String isDocAction=UtilsData.isProcessDocAction(this, "57015F5D946C4D7F9BD584C16BAF8201");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "584",strC_ProjectTask_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "584", strC_ProjectTask_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strpreplanmaterial, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "57015F5D946C4D7F9BD584C16BAF8201");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONPreplanmaterial" + "57015F5D946C4D7F9BD584C16BAF8201" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","ProjectTask490_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "57015F5D946C4D7F9BD584C16BAF8201");
        script.addHiddenfield("inpKey",strC_ProjectTask_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("57015F5D946C4D7F9BD584C16BAF8201");
        vars.removeMessage("57015F5D946C4D7F9BD584C16BAF8201");
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
    void printPageButtonCopyptask0CABC5C489604305B9C05718CEE88C90(HttpServletResponse response, VariablesSecureApp vars, String strC_ProjectTask_ID, String strcopyptask, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "0CABC5C489604305B9C05718CEE88C90",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "0CABC5C489604305B9C05718CEE88C90" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"0CABC5C489604305B9C05718CEE88C90" );
        String isDocAction=UtilsData.isProcessDocAction(this, "0CABC5C489604305B9C05718CEE88C90");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "584",strC_ProjectTask_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "584", strC_ProjectTask_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strcopyptask, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "0CABC5C489604305B9C05718CEE88C90");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONCopyptask" + "0CABC5C489604305B9C05718CEE88C90" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","ProjectTask490_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "0CABC5C489604305B9C05718CEE88C90");
        script.addHiddenfield("inpKey",strC_ProjectTask_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("0CABC5C489604305B9C05718CEE88C90");
        vars.removeMessage("0CABC5C489604305B9C05718CEE88C90");
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
    void printPageButtonCreatebomEA7B66710CE548CF9F704ABE5DD3608F(HttpServletResponse response, VariablesSecureApp vars, String strC_ProjectTask_ID, String strcreatebom, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "EA7B66710CE548CF9F704ABE5DD3608F",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "EA7B66710CE548CF9F704ABE5DD3608F" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"EA7B66710CE548CF9F704ABE5DD3608F" );
        String isDocAction=UtilsData.isProcessDocAction(this, "EA7B66710CE548CF9F704ABE5DD3608F");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "584",strC_ProjectTask_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "584", strC_ProjectTask_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strcreatebom, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "EA7B66710CE548CF9F704ABE5DD3608F");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONCreatebom" + "EA7B66710CE548CF9F704ABE5DD3608F" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","ProjectTask490_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "EA7B66710CE548CF9F704ABE5DD3608F");
        script.addHiddenfield("inpKey",strC_ProjectTask_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("EA7B66710CE548CF9F704ABE5DD3608F");
        vars.removeMessage("EA7B66710CE548CF9F704ABE5DD3608F");
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
    void printPageButtonPlanmaterial4BB6C04ECD8A486CA7C4BA75E685816C(HttpServletResponse response, VariablesSecureApp vars, String strC_ProjectTask_ID, String strplanmaterial, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "4BB6C04ECD8A486CA7C4BA75E685816C",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "4BB6C04ECD8A486CA7C4BA75E685816C" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"4BB6C04ECD8A486CA7C4BA75E685816C" );
        String isDocAction=UtilsData.isProcessDocAction(this, "4BB6C04ECD8A486CA7C4BA75E685816C");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "584",strC_ProjectTask_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "584", strC_ProjectTask_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strplanmaterial, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "4BB6C04ECD8A486CA7C4BA75E685816C");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONPlanmaterial" + "4BB6C04ECD8A486CA7C4BA75E685816C" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","ProjectTask490_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "4BB6C04ECD8A486CA7C4BA75E685816C");
        script.addHiddenfield("inpKey",strC_ProjectTask_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("4BB6C04ECD8A486CA7C4BA75E685816C");
        vars.removeMessage("4BB6C04ECD8A486CA7C4BA75E685816C");
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
    void printPageButtonUnplanmaterialAD93C112045249B78A9D3BEEC04F42B0(HttpServletResponse response, VariablesSecureApp vars, String strC_ProjectTask_ID, String strunplanmaterial, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "AD93C112045249B78A9D3BEEC04F42B0",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "AD93C112045249B78A9D3BEEC04F42B0" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"AD93C112045249B78A9D3BEEC04F42B0" );
        String isDocAction=UtilsData.isProcessDocAction(this, "AD93C112045249B78A9D3BEEC04F42B0");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "584",strC_ProjectTask_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "584", strC_ProjectTask_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strunplanmaterial, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "AD93C112045249B78A9D3BEEC04F42B0");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONUnplanmaterial" + "AD93C112045249B78A9D3BEEC04F42B0" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","ProjectTask490_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "AD93C112045249B78A9D3BEEC04F42B0");
        script.addHiddenfield("inpKey",strC_ProjectTask_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("AD93C112045249B78A9D3BEEC04F42B0");
        vars.removeMessage("AD93C112045249B78A9D3BEEC04F42B0");
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
    void printPageButtonGetmaterialfromstockA7A38A66C68F4799826CF635BFBE0027(HttpServletResponse response, VariablesSecureApp vars, String strC_ProjectTask_ID, String strgetmaterialfromstock, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "A7A38A66C68F4799826CF635BFBE0027",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "A7A38A66C68F4799826CF635BFBE0027" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"A7A38A66C68F4799826CF635BFBE0027" );
        String isDocAction=UtilsData.isProcessDocAction(this, "A7A38A66C68F4799826CF635BFBE0027");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "584",strC_ProjectTask_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "584", strC_ProjectTask_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strgetmaterialfromstock, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "A7A38A66C68F4799826CF635BFBE0027");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONGetmaterialfromstock" + "A7A38A66C68F4799826CF635BFBE0027" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","ProjectTask490_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "A7A38A66C68F4799826CF635BFBE0027");
        script.addHiddenfield("inpKey",strC_ProjectTask_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("A7A38A66C68F4799826CF635BFBE0027");
        vars.removeMessage("A7A38A66C68F4799826CF635BFBE0027");
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
    void printPageButtonReturnmaterialtostockDF8481DB26CA47D4BF842C8AA3E49A9B(HttpServletResponse response, VariablesSecureApp vars, String strC_ProjectTask_ID, String strreturnmaterialtostock, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "DF8481DB26CA47D4BF842C8AA3E49A9B",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "DF8481DB26CA47D4BF842C8AA3E49A9B" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"DF8481DB26CA47D4BF842C8AA3E49A9B" );
        String isDocAction=UtilsData.isProcessDocAction(this, "DF8481DB26CA47D4BF842C8AA3E49A9B");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "584",strC_ProjectTask_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "584", strC_ProjectTask_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strreturnmaterialtostock, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "DF8481DB26CA47D4BF842C8AA3E49A9B");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONReturnmaterialtostock" + "DF8481DB26CA47D4BF842C8AA3E49A9B" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","ProjectTask490_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "DF8481DB26CA47D4BF842C8AA3E49A9B");
        script.addHiddenfield("inpKey",strC_ProjectTask_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("DF8481DB26CA47D4BF842C8AA3E49A9B");
        vars.removeMessage("DF8481DB26CA47D4BF842C8AA3E49A9B");
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
    void printPageButtonBegintaskAA3B9F4E77034F9D902BCF8BCB375A8C(HttpServletResponse response, VariablesSecureApp vars, String strC_ProjectTask_ID, String strbegintask, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "AA3B9F4E77034F9D902BCF8BCB375A8C",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "AA3B9F4E77034F9D902BCF8BCB375A8C" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"AA3B9F4E77034F9D902BCF8BCB375A8C" );
        String isDocAction=UtilsData.isProcessDocAction(this, "AA3B9F4E77034F9D902BCF8BCB375A8C");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "584",strC_ProjectTask_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "584", strC_ProjectTask_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strbegintask, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "AA3B9F4E77034F9D902BCF8BCB375A8C");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONBegintask" + "AA3B9F4E77034F9D902BCF8BCB375A8C" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","ProjectTask490_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "AA3B9F4E77034F9D902BCF8BCB375A8C");
        script.addHiddenfield("inpKey",strC_ProjectTask_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("AA3B9F4E77034F9D902BCF8BCB375A8C");
        vars.removeMessage("AA3B9F4E77034F9D902BCF8BCB375A8C");
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
    void printPageButtonEndtask4B4D99FCF77C4975B726D40794A920EB(HttpServletResponse response, VariablesSecureApp vars, String strC_ProjectTask_ID, String strendtask, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "4B4D99FCF77C4975B726D40794A920EB",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "4B4D99FCF77C4975B726D40794A920EB" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"4B4D99FCF77C4975B726D40794A920EB" );
        String isDocAction=UtilsData.isProcessDocAction(this, "4B4D99FCF77C4975B726D40794A920EB");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "584",strC_ProjectTask_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "584", strC_ProjectTask_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strendtask, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "4B4D99FCF77C4975B726D40794A920EB");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONEndtask" + "4B4D99FCF77C4975B726D40794A920EB" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","ProjectTask490_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "4B4D99FCF77C4975B726D40794A920EB");
        script.addHiddenfield("inpKey",strC_ProjectTask_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("4B4D99FCF77C4975B726D40794A920EB");
        vars.removeMessage("4B4D99FCF77C4975B726D40794A920EB");
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
    void printPageButtonCanceltaskE32139CEB5F44BA99B5E64B86E56ABA5(HttpServletResponse response, VariablesSecureApp vars, String strC_ProjectTask_ID, String strcanceltask, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "E32139CEB5F44BA99B5E64B86E56ABA5",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "E32139CEB5F44BA99B5E64B86E56ABA5" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"E32139CEB5F44BA99B5E64B86E56ABA5" );
        String isDocAction=UtilsData.isProcessDocAction(this, "E32139CEB5F44BA99B5E64B86E56ABA5");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "584",strC_ProjectTask_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "584", strC_ProjectTask_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strcanceltask, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "E32139CEB5F44BA99B5E64B86E56ABA5");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONCanceltask" + "E32139CEB5F44BA99B5E64B86E56ABA5" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","ProjectTask490_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "E32139CEB5F44BA99B5E64B86E56ABA5");
        script.addHiddenfield("inpKey",strC_ProjectTask_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("E32139CEB5F44BA99B5E64B86E56ABA5");
        vars.removeMessage("E32139CEB5F44BA99B5E64B86E56ABA5");
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
      String result = "var strProjectCategory=\"" +Utility.getContext(this, vars, "ProjectCategory", windowId) + "\";\nvar strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\n";
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPC_Project_ID) throws IOException, ServletException {
    ProjectTask490Data data = null;
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
            data = getEditVariables(con, vars, strPC_Project_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.cProjecttaskId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (ProjectTask490Data.getCurrentDBTimestamp(this, data.cProjecttaskId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cProjecttaskId, vars, this);
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
                    data.cProjecttaskId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_ProjectTask_ID", data.cProjecttaskId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet ProjectTask490. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
