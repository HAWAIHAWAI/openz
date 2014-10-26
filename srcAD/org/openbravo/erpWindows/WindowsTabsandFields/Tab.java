
package org.openbravo.erpWindows.WindowsTabsandFields;


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

public class Tab extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Tab.class);
  
  private static final String windowId = "102";
  private static final String tabId = "106";
  private static final String defaultTabView = "RELATION";
  private static final int accesslevel = 4;
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
        String stradTabId = request.getParameter("inpadTabId");
         String strPAD_Window_ID = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !stradTabId.equals(""))
              total = saveRecord(vars, myError, 'U', strPAD_Window_ID);
          else
              total = saveRecord(vars, myError, 'I', strPAD_Window_ID);
          
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
      String strPAD_Window_ID = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID", "");

      String strAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID", "");
            if (strPAD_Window_ID.equals("")) {
        strPAD_Window_ID = getParentID(vars, strAD_Tab_ID);
        if (strPAD_Window_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|AD_Window_ID");
        vars.setSessionValue(windowId + "|AD_Window_ID", strPAD_Window_ID);

        refreshParentSession(vars, strPAD_Window_ID);
      }


      String strView = vars.getSessionValue(tabId + "|Tab.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strAD_Tab_ID.equals("")) strAD_Tab_ID = firstElement(vars, tableSQL);
          if (strAD_Tab_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strAD_Tab_ID, strPAD_Window_ID, tableSQL);

      else printPageDataSheet(response, vars, strPAD_Window_ID, strAD_Tab_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strAD_Tab_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strAD_Tab_ID.equals("")) strAD_Tab_ID = vars.getRequiredGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");
      else vars.setSessionValue(windowId + "|AD_Tab_ID", strAD_Tab_ID);
      
      
      String strPAD_Window_ID = getParentID(vars, strAD_Tab_ID);
      
      vars.setSessionValue(windowId + "|AD_Window_ID", strPAD_Window_ID);
      vars.setSessionValue("105|Window.view", "EDIT");

      refreshParentSession(vars, strPAD_Window_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Tab.view", "EDIT");

        printPageEdit(response, request, vars, false, strAD_Tab_ID, strPAD_Window_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Tab.view", "RELATION");
        printPageDataSheet(response, vars, strPAD_Window_ID, strAD_Tab_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPAD_Window_ID = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|AD_Tab_ID");
      refreshParentSession(vars, strPAD_Window_ID);


      String strView = vars.getSessionValue(tabId + "|Tab.view");
      String strAD_Tab_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strAD_Tab_ID = firstElement(vars, tableSQL);
          if (strAD_Tab_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strAD_Tab_ID.equals("")) strAD_Tab_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strAD_Tab_ID, strPAD_Window_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPAD_Window_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamAD_Window_ID", tabId + "|paramAD_Window_ID");

            String strPAD_Window_ID = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID");

      
      vars.removeSessionValue(windowId + "|AD_Tab_ID");
      String strAD_Tab_ID="";

      String strView = vars.getSessionValue(tabId + "|Tab.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strAD_Tab_ID = firstElement(vars, tableSQL);
        if (strAD_Tab_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Tab.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strAD_Tab_ID, strPAD_Window_ID, tableSQL);

      else printPageDataSheet(response, vars, strPAD_Window_ID, strAD_Tab_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPAD_Window_ID = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID");
      

      String strAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID", "");
      vars.setSessionValue(tabId + "|Tab.view", "RELATION");
      printPageDataSheet(response, vars, strPAD_Window_ID, strAD_Tab_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPAD_Window_ID = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID");


      printPageEdit(response, request, vars, true, "", strPAD_Window_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPAD_Window_ID = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID", "");
      vars.setSessionValue(tabId + "|Tab.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strAD_Tab_ID, strPAD_Window_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPAD_Window_ID = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID");
      String strAD_Tab_ID = vars.getRequiredStringParameter("inpadTabId");
      
      String strNext = nextElement(vars, strAD_Tab_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPAD_Window_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPAD_Window_ID = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID");
      String strAD_Tab_ID = vars.getRequiredStringParameter("inpadTabId");
      
      String strPrevious = previousElement(vars, strAD_Tab_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPAD_Window_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID");

      vars.setSessionValue(tabId + "|Tab.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPAD_Window_ID = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Tab.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Tab.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Tab.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|AD_Tab_ID");
      vars.setSessionValue(windowId + "|AD_Window_ID", strPAD_Window_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPAD_Window_ID = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Tab.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Tab.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|AD_Tab_ID");
      vars.setSessionValue(windowId + "|AD_Window_ID", strPAD_Window_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPAD_Window_ID = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPAD_Window_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPAD_Window_ID = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPAD_Window_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPAD_Window_ID = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPAD_Window_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPAD_Window_ID = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPAD_Window_ID);      
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
      String strPAD_Window_ID = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID");
      String strAD_Tab_ID = vars.getRequiredGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPAD_Window_ID);      
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
          String strNext = nextElement(vars, strAD_Tab_ID, tableSQL);
          vars.setSessionValue(windowId + "|AD_Tab_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPAD_Window_ID = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID");

      String strAD_Tab_ID = vars.getRequiredInStringParameter("inpadTabId");
      String message = deleteRelation(vars, strAD_Tab_ID, strPAD_Window_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|adTabId");
        vars.setSessionValue(tabId + "|Tab.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPAD_Window_ID = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID");

      String strAD_Tab_ID = vars.getRequiredStringParameter("inpadTabId");
      //TabData data = getEditVariables(vars, strPAD_Window_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = TabData.delete(this, strAD_Tab_ID, strPAD_Window_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|adTabId");
        vars.setSessionValue(tabId + "|Tab.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONImportFields174")) {
        vars.setSessionValue("button174.strimportfields", vars.getStringParameter("inpimportfields"));
        vars.setSessionValue("button174.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button174.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button174.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button174.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "174", request.getServletPath());    
     } else if (vars.commandIn("BUTTON174")) {
        String strAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID", "");
        String strimportfields = vars.getSessionValue("button174.strimportfields");
        String strProcessing = vars.getSessionValue("button174.strProcessing");
        String strOrg = vars.getSessionValue("button174.strOrg");
        String strClient = vars.getSessionValue("button174.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonImportFields174(response, vars, strAD_Tab_ID, strimportfields, strProcessing);
        }

     } else if (vars.commandIn("BUTTONProcessing114")) {
        vars.setSessionValue("button114.strprocessing", vars.getStringParameter("inpprocessing"));
        vars.setSessionValue("button114.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button114.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button114.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button114.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "114", request.getServletPath());    
     } else if (vars.commandIn("BUTTON114")) {
        String strAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID", "");
        String strprocessing = vars.getSessionValue("button114.strprocessing");
        String strProcessing = vars.getSessionValue("button114.strProcessing");
        String strOrg = vars.getSessionValue("button114.strOrg");
        String strClient = vars.getSessionValue("button114.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessing114(response, vars, strAD_Tab_ID, strprocessing, strProcessing);
        }

     } else if (vars.commandIn("BUTTONCreatecustomAA32CDB810BE481184D7C249B7B1C8D9")) {
        vars.setSessionValue("buttonAA32CDB810BE481184D7C249B7B1C8D9.strcreatecustom", vars.getStringParameter("inpcreatecustom"));
        vars.setSessionValue("buttonAA32CDB810BE481184D7C249B7B1C8D9.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonAA32CDB810BE481184D7C249B7B1C8D9.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonAA32CDB810BE481184D7C249B7B1C8D9.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonAA32CDB810BE481184D7C249B7B1C8D9.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "AA32CDB810BE481184D7C249B7B1C8D9", request.getServletPath());    
     } else if (vars.commandIn("BUTTONAA32CDB810BE481184D7C249B7B1C8D9")) {
        String strAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID", "");
        String strcreatecustom = vars.getSessionValue("buttonAA32CDB810BE481184D7C249B7B1C8D9.strcreatecustom");
        String strProcessing = vars.getSessionValue("buttonAA32CDB810BE481184D7C249B7B1C8D9.strProcessing");
        String strOrg = vars.getSessionValue("buttonAA32CDB810BE481184D7C249B7B1C8D9.strOrg");
        String strClient = vars.getSessionValue("buttonAA32CDB810BE481184D7C249B7B1C8D9.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCreatecustomAA32CDB810BE481184D7C249B7B1C8D9(response, vars, strAD_Tab_ID, strcreatecustom, strProcessing);
        }

     } else if (vars.commandIn("BUTTONDropcustomFA6E59BBBFBA451A9EB36D06D8B28381")) {
        vars.setSessionValue("buttonFA6E59BBBFBA451A9EB36D06D8B28381.strdropcustom", vars.getStringParameter("inpdropcustom"));
        vars.setSessionValue("buttonFA6E59BBBFBA451A9EB36D06D8B28381.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonFA6E59BBBFBA451A9EB36D06D8B28381.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonFA6E59BBBFBA451A9EB36D06D8B28381.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonFA6E59BBBFBA451A9EB36D06D8B28381.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "FA6E59BBBFBA451A9EB36D06D8B28381", request.getServletPath());    
     } else if (vars.commandIn("BUTTONFA6E59BBBFBA451A9EB36D06D8B28381")) {
        String strAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID", "");
        String strdropcustom = vars.getSessionValue("buttonFA6E59BBBFBA451A9EB36D06D8B28381.strdropcustom");
        String strProcessing = vars.getSessionValue("buttonFA6E59BBBFBA451A9EB36D06D8B28381.strProcessing");
        String strOrg = vars.getSessionValue("buttonFA6E59BBBFBA451A9EB36D06D8B28381.strOrg");
        String strClient = vars.getSessionValue("buttonFA6E59BBBFBA451A9EB36D06D8B28381.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonDropcustomFA6E59BBBFBA451A9EB36D06D8B28381(response, vars, strAD_Tab_ID, strdropcustom, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONImportFields174")) {
        String strAD_Tab_ID = vars.getGlobalVariable("inpKey", windowId + "|AD_Tab_ID", "");
        @SuppressWarnings("unused")
        String strimportfields = vars.getStringParameter("inpimportfields");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "174", (("AD_Tab_ID".equalsIgnoreCase("AD_Language"))?"0":strAD_Tab_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONProcessing114")) {
        String strAD_Tab_ID = vars.getGlobalVariable("inpKey", windowId + "|AD_Tab_ID", "");
        @SuppressWarnings("unused")
        String strprocessing = vars.getStringParameter("inpprocessing");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "114", (("AD_Tab_ID".equalsIgnoreCase("AD_Language"))?"0":strAD_Tab_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String stradTabId = vars.getStringParameter("inpadTabId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "AD_Tab_ID", stradTabId, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
    } else if (vars.commandIn("SAVE_BUTTONCreatecustomAA32CDB810BE481184D7C249B7B1C8D9")) {
        String strAD_Tab_ID = vars.getGlobalVariable("inpKey", windowId + "|AD_Tab_ID", "");
        @SuppressWarnings("unused")
        String strcreatecustom = vars.getStringParameter("inpcreatecustom");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "AA32CDB810BE481184D7C249B7B1C8D9", (("AD_Tab_ID".equalsIgnoreCase("AD_Language"))?"0":strAD_Tab_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strdatatype = vars.getStringParameter("inpdatatype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "datatype", strdatatype, vars.getClient(), vars.getOrg(), vars.getUser());
String strlength = vars.getNumericParameter("inplength");
PInstanceProcessData.insertPInstanceParamNumber(this, pinstance, "20", "length", strlength, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
    } else if (vars.commandIn("SAVE_BUTTONDropcustomFA6E59BBBFBA451A9EB36D06D8B28381")) {
        String strAD_Tab_ID = vars.getGlobalVariable("inpKey", windowId + "|AD_Tab_ID", "");
        @SuppressWarnings("unused")
        String strdropcustom = vars.getStringParameter("inpdropcustom");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "FA6E59BBBFBA451A9EB36D06D8B28381", (("AD_Tab_ID".equalsIgnoreCase("AD_Language"))?"0":strAD_Tab_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String stradFieldVId = vars.getStringParameter("inpadFieldVId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "ad_field_v_id", stradFieldVId, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
  String deleteRelation(VariablesSecureApp vars, String strAD_Tab_ID, String strPAD_Window_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strAD_Tab_ID.startsWith("(")) strAD_Tab_ID = strAD_Tab_ID.substring(1, strAD_Tab_ID.length()-1);
      if (!strAD_Tab_ID.equals("")) {
        strAD_Tab_ID = Replace.replace(strAD_Tab_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strAD_Tab_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (TabData.deleteTransactional(conn, this, strKey, strPAD_Window_ID)==0) {
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
  private TabData getEditVariables(Connection con, VariablesSecureApp vars, String strPAD_Window_ID) throws IOException,ServletException {
    TabData data = new TabData();
    ServletException ex = null;
    try {
    data.adImageId = vars.getStringParameter("inpadImageId");     data.includedTabId = vars.getStringParameter("inpincludedTabId");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.editreference = vars.getStringParameter("inpeditreference");     data.adWindowId = vars.getStringParameter("inpadWindowId");     data.adWindowIdr = vars.getStringParameter("inpadWindowId_R");     data.adModuleId = vars.getStringParameter("inpadModuleId");     data.adModuleIdr = vars.getStringParameter("inpadModuleId_R");     data.name = vars.getStringParameter("inpname");     data.description = vars.getStringParameter("inpdescription");     data.help = vars.getStringParameter("inphelp");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.adTableId = vars.getRequestGlobalVariable("inpadTableId", windowId + "|AD_Table_ID");     data.adTableIdr = vars.getStringParameter("inpadTableId_R");    try {   data.seqno = vars.getNumericParameter("inpseqno");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.tablevel = vars.getNumericParameter("inptablevel");  } catch (ServletException paramEx) { ex = paramEx; }     data.issinglerow = vars.getStringParameter("inpissinglerow", "N");     data.uipattern = vars.getStringParameter("inpuipattern");     data.uipatternr = vars.getStringParameter("inpuipattern_R");     data.hastree = vars.getStringParameter("inphastree", "N");     data.isinfotab = vars.getStringParameter("inpisinfotab", "N");     data.istranslationtab = vars.getStringParameter("inpistranslationtab", "N");     data.issorttab = vars.getStringParameter("inpissorttab", "N");     data.adColumnsortorderId = vars.getStringParameter("inpadColumnsortorderId");     data.adColumnsortorderIdr = vars.getStringParameter("inpadColumnsortorderId_R");     data.adColumnsortyesnoId = vars.getStringParameter("inpadColumnsortyesnoId");     data.adColumnsortyesnoIdr = vars.getStringParameter("inpadColumnsortyesnoId_R");     data.adColumnId = vars.getStringParameter("inpadColumnId");     data.adColumnIdr = vars.getStringParameter("inpadColumnId_R");     data.adProcessId = vars.getStringParameter("inpadProcessId");     data.adProcessIdr = vars.getStringParameter("inpadProcessId_R");     data.commitwarning = vars.getStringParameter("inpcommitwarning");     data.whereclause = vars.getStringParameter("inpwhereclause");     data.filterclause = vars.getStringParameter("inpfilterclause");     data.orderbyclause = vars.getStringParameter("inporderbyclause");     data.lefttabsmode = vars.getStringParameter("inplefttabsmode");     data.lefttabsmoder = vars.getStringParameter("inplefttabsmode_R");     data.adRelationtoolbar = vars.getStringParameter("inpadRelationtoolbar");     data.adRelationtoolbarr = vars.getStringParameter("inpadRelationtoolbar_R");     data.adEditiontoolbar = vars.getStringParameter("inpadEditiontoolbar");     data.adEditiontoolbarr = vars.getStringParameter("inpadEditiontoolbar_R");     data.manualservletclass = vars.getStringParameter("inpmanualservletclass");     data.relationmanual = vars.getStringParameter("inprelationmanual", "N");     data.editionmanual = vars.getStringParameter("inpeditionmanual", "N");     data.isstandalone = vars.getStringParameter("inpisstandalone", "N");     data.importfields = vars.getStringParameter("inpimportfields");     data.processing = vars.getStringParameter("inpprocessing");     data.createcustom = vars.getStringParameter("inpcreatecustom");     data.dropcustom = vars.getStringParameter("inpdropcustom");     data.adTabId = vars.getRequestGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.adWindowId = vars.getGlobalVariable("inpadWindowId", windowId + "|AD_Window_ID");


    
    

    
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

   private TabData[] getRelationData(TabData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adImageId = FormatUtilities.truncate(data[i].adImageId, 44);        data[i].includedTabId = FormatUtilities.truncate(data[i].includedTabId, 44);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].editreference = FormatUtilities.truncate(data[i].editreference, 44);        data[i].adWindowId = FormatUtilities.truncate(data[i].adWindowId, 44);        data[i].adModuleId = FormatUtilities.truncate(data[i].adModuleId, 32);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].help = FormatUtilities.truncate(data[i].help, 50);        data[i].adTableId = FormatUtilities.truncate(data[i].adTableId, 44);        data[i].uipattern = FormatUtilities.truncate(data[i].uipattern, 20);        data[i].adColumnsortorderId = FormatUtilities.truncate(data[i].adColumnsortorderId, 44);        data[i].adColumnsortyesnoId = FormatUtilities.truncate(data[i].adColumnsortyesnoId, 44);        data[i].adColumnId = FormatUtilities.truncate(data[i].adColumnId, 44);        data[i].adProcessId = FormatUtilities.truncate(data[i].adProcessId, 44);        data[i].commitwarning = FormatUtilities.truncate(data[i].commitwarning, 50);        data[i].whereclause = FormatUtilities.truncate(data[i].whereclause, 50);        data[i].filterclause = FormatUtilities.truncate(data[i].filterclause, 50);        data[i].orderbyclause = FormatUtilities.truncate(data[i].orderbyclause, 50);        data[i].lefttabsmode = FormatUtilities.truncate(data[i].lefttabsmode, 30);        data[i].adRelationtoolbar = FormatUtilities.truncate(data[i].adRelationtoolbar, 32);        data[i].adEditiontoolbar = FormatUtilities.truncate(data[i].adEditiontoolbar, 32);        data[i].manualservletclass = FormatUtilities.truncate(data[i].manualservletclass, 50);        data[i].adTabId = FormatUtilities.truncate(data[i].adTabId, 10);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPAD_Window_ID) throws IOException,ServletException {
      WindowData[] data = WindowData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPAD_Window_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|AD_Window_ID", data[0].adWindowId);
      vars.setSessionValue(windowId + "|AD_Window_ID", strPAD_Window_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strAD_Tab_ID) throws ServletException {
    String strPAD_Window_ID = TabData.selectParentID(this, strAD_Tab_ID);
    if (strPAD_Window_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strAD_Tab_ID);
      throw new ServletException("Parent record not found");
    }
    return strPAD_Window_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|AD_Table_ID", data[0].getField("adTableId"));    vars.setSessionValue(windowId + "|AD_Tab_ID", data[0].getField("adTabId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPAD_Window_ID) throws IOException,ServletException {
      TabData[] data = TabData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPAD_Window_ID, vars.getStringParameter("inpadTabId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPAD_Window_ID, String strAD_Tab_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamAD_Window_ID = vars.getSessionValue(tabId + "|paramAD_Window_ID");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamName.equals("") && strParamAD_Window_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strAD_Tab_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strAD_Tab_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/WindowsTabsandFields/Tab_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Tab", false, "document.frmMain.inpadTabId", "grid", "..", "".equals("Y"), "WindowsTabsandFields", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPAD_Window_ID);

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
    xmlDocument.setParameter("KeyName", "adTabId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Tab_Relation.html", "WindowsTabsandFields", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Tab_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", TabData.selectParent(this, vars.getLanguage(), strPAD_Window_ID));
    else xmlDocument.setParameter("parent", TabData.selectParentTrl(this, vars.getLanguage(), strPAD_Window_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strAD_Tab_ID, String strPAD_Window_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " AD_Tab.SeqNo";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    TabData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamAD_Window_ID = vars.getSessionValue(tabId + "|paramAD_Window_ID");

    boolean hasSearchCondition=false;
    if (!(strParamName.equals("") && strParamAD_Window_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = TabData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPAD_Window_ID, strAD_Tab_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strAD_Tab_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new TabData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("adTabId") == null || dataField.getField("adTabId").equals("")) {
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
        refreshSessionNew(vars, strPAD_Window_ID);
        data = TabData.set(strPAD_Window_ID, Utility.getDefault(this, vars, "AD_Table_ID", "", "102", "106", "", dataField), Utility.getDefault(this, vars, "UIPattern", "STD", "102", "106", "", dataField), Utility.getDefault(this, vars, "IsInfoTab", "", "102", "106", "N", dataField), Utility.getDefault(this, vars, "IsReadOnly", "", "102", "106", "N", dataField), Utility.getDefault(this, vars, "Lefttabsmode", "", "102", "106", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "102", "106", "", dataField), TabData.selectDef577_0(this, Utility.getDefault(this, vars, "UpdatedBy", "", "102", "106", "", dataField)), Utility.getDefault(this, vars, "AD_Image_ID", "", "102", "106", "", dataField), TabData.selectDef165(this, strPAD_Window_ID), Utility.getDefault(this, vars, "ImportFields", "", "102", "106", "N", dataField), "0", Utility.getDefault(this, vars, "IsSortTab", "N", "102", "106", "N", dataField), Utility.getDefault(this, vars, "Name", "", "102", "106", "", dataField), Utility.getDefault(this, vars, "Editionmanual", "N", "102", "106", "N", dataField), Utility.getDefault(this, vars, "AD_Relationtoolbar", "", "102", "106", "", dataField), Utility.getDefault(this, vars, "AD_Process_ID", "", "102", "106", "", dataField), Utility.getDefault(this, vars, "Description", "", "102", "106", "", dataField), TabData.selectDef5661EC317B643D0FE040007F01004528(this, strPAD_Window_ID), Utility.getDefault(this, vars, "HasTree", "", "102", "106", "N", dataField), Utility.getDefault(this, vars, "WhereClause", "", "102", "106", "", dataField), Utility.getDefault(this, vars, "AD_Column_ID", "", "102", "106", "", dataField), Utility.getDefault(this, vars, "Manualservletclass", "", "102", "106", "", dataField), Utility.getDefault(this, vars, "Isstandalone", "N", "102", "106", "N", dataField), Utility.getDefault(this, vars, "Relationmanual", "N", "102", "106", "N", dataField), Utility.getDefault(this, vars, "CommitWarning", "", "102", "106", "", dataField), Utility.getDefault(this, vars, "AD_ColumnSortOrder_ID", "", "102", "106", "", dataField), Utility.getDefault(this, vars, "Help", "", "102", "106", "", dataField), Utility.getDefault(this, vars, "OrderByClause", "", "102", "106", "", dataField), Utility.getDefault(this, vars, "AD_ColumnSortYesNo_ID", "", "102", "106", "", dataField), Utility.getDefault(this, vars, "Createcustom", "Y", "102", "106", "N", dataField), Utility.getDefault(this, vars, "Dropcustom", "Y", "102", "106", "N", dataField), Utility.getDefault(this, vars, "TabLevel", "", "102", "106", "", dataField), Utility.getDefault(this, vars, "EditReference", "", "102", "106", "", dataField), "0", Utility.getDefault(this, vars, "IsSingleRow", "", "102", "106", "N", dataField), "", Utility.getDefault(this, vars, "Included_Tab_ID", "", "102", "106", "", dataField), "Y", Utility.getDefault(this, vars, "FilterClause", "", "102", "106", "", dataField), Utility.getDefault(this, vars, "IsTranslationTab", "", "102", "106", "N", dataField), Utility.getDefault(this, vars, "AD_Editiontoolbar", "", "102", "106", "", dataField), Utility.getDefault(this, vars, "Processing", "", "102", "106", "N", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "102", "106", "", dataField), TabData.selectDef575_1(this, Utility.getDefault(this, vars, "CreatedBy", "", "102", "106", "", dataField)));
        
      }
    } else {
      data = new TabData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(TabData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=WindowData.selectOrg(this, strPAD_Window_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Tab", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpadTabId", "", "..", "".equals("Y"), "WindowsTabsandFields", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strAD_Tab_ID));
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
  
    void printPageButtonImportFields174(HttpServletResponse response, VariablesSecureApp vars, String strAD_Tab_ID, String strimportfields, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "174",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "174" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"174" );
        String isDocAction=UtilsData.isProcessDocAction(this, "174");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "106",strAD_Tab_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "106", strAD_Tab_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strimportfields, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "174");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONImportFields" + "174" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","Tab_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "174");
        script.addHiddenfield("inpKey",strAD_Tab_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("174");
        vars.removeMessage("174");
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
    void printPageButtonProcessing114(HttpServletResponse response, VariablesSecureApp vars, String strAD_Tab_ID, String strprocessing, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "114",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "114" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"114" );
        String isDocAction=UtilsData.isProcessDocAction(this, "114");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "106",strAD_Tab_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "106", strAD_Tab_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strprocessing, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "114");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONProcessing" + "114" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","Tab_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "114");
        script.addHiddenfield("inpKey",strAD_Tab_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("114");
        vars.removeMessage("114");
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
    void printPageButtonCreatecustomAA32CDB810BE481184D7C249B7B1C8D9(HttpServletResponse response, VariablesSecureApp vars, String strAD_Tab_ID, String strcreatecustom, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "AA32CDB810BE481184D7C249B7B1C8D9",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "AA32CDB810BE481184D7C249B7B1C8D9" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"AA32CDB810BE481184D7C249B7B1C8D9" );
        String isDocAction=UtilsData.isProcessDocAction(this, "AA32CDB810BE481184D7C249B7B1C8D9");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "106",strAD_Tab_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "106", strAD_Tab_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strcreatecustom, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "AA32CDB810BE481184D7C249B7B1C8D9");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONCreatecustom" + "AA32CDB810BE481184D7C249B7B1C8D9" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","Tab_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "AA32CDB810BE481184D7C249B7B1C8D9");
        script.addHiddenfield("inpKey",strAD_Tab_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("AA32CDB810BE481184D7C249B7B1C8D9");
        vars.removeMessage("AA32CDB810BE481184D7C249B7B1C8D9");
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
    void printPageButtonDropcustomFA6E59BBBFBA451A9EB36D06D8B28381(HttpServletResponse response, VariablesSecureApp vars, String strAD_Tab_ID, String strdropcustom, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "FA6E59BBBFBA451A9EB36D06D8B28381",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "FA6E59BBBFBA451A9EB36D06D8B28381" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"FA6E59BBBFBA451A9EB36D06D8B28381" );
        String isDocAction=UtilsData.isProcessDocAction(this, "FA6E59BBBFBA451A9EB36D06D8B28381");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "106",strAD_Tab_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "106", strAD_Tab_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strdropcustom, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "FA6E59BBBFBA451A9EB36D06D8B28381");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONDropcustom" + "FA6E59BBBFBA451A9EB36D06D8B28381" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","Tab_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "FA6E59BBBFBA451A9EB36D06D8B28381");
        script.addHiddenfield("inpKey",strAD_Tab_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("FA6E59BBBFBA451A9EB36D06D8B28381");
        vars.removeMessage("FA6E59BBBFBA451A9EB36D06D8B28381");
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPAD_Window_ID) throws IOException, ServletException {
    TabData data = null;
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
            data = getEditVariables(con, vars, strPAD_Window_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.adTabId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (TabData.getCurrentDBTimestamp(this, data.adTabId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.adTabId, vars, this);
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
                    data.adTabId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|AD_Tab_ID", data.adTabId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Tab. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
