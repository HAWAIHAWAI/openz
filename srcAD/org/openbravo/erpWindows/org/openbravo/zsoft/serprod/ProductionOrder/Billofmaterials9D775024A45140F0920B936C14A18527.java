
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.ProductionOrder;





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

public class Billofmaterials9D775024A45140F0920B936C14A18527 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Billofmaterials9D775024A45140F0920B936C14A18527.class);
  
  private static final String windowId = "A2BEBB9B07564D2AAA372B4CB2D01165";
  private static final String tabId = "9D775024A45140F0920B936C14A18527";
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
        String strzssmWorkstepbomVId = request.getParameter("inpzssmWorkstepbomVId");
         String strPzssm_workstep_v_id = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strzssmWorkstepbomVId.equals(""))
              total = saveRecord(vars, myError, 'U', strPzssm_workstep_v_id);
          else
              total = saveRecord(vars, myError, 'I', strPzssm_workstep_v_id);
          
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
      String strPzssm_workstep_v_id = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id", "");

      String strZssm_WorkstepBOM_V_ID = vars.getGlobalVariable("inpzssmWorkstepbomVId", windowId + "|Zssm_WorkstepBOM_V_ID", "");
            if (strPzssm_workstep_v_id.equals("")) {
        strPzssm_workstep_v_id = getParentID(vars, strZssm_WorkstepBOM_V_ID);
        if (strPzssm_workstep_v_id.equals("")) throw new ServletException("Required parameter :" + windowId + "|zssm_workstep_v_id");
        vars.setSessionValue(windowId + "|zssm_workstep_v_id", strPzssm_workstep_v_id);
      vars.removeSessionValue(windowId + "|zssm_productionorder_v_id");
        refreshParentSession(vars, strPzssm_workstep_v_id);
      }


      String strView = vars.getSessionValue(tabId + "|Billofmaterials9D775024A45140F0920B936C14A18527.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strZssm_WorkstepBOM_V_ID.equals("")) strZssm_WorkstepBOM_V_ID = firstElement(vars, tableSQL);
          if (strZssm_WorkstepBOM_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssm_WorkstepBOM_V_ID, strPzssm_workstep_v_id, tableSQL);

      else printPageDataSheet(response, vars, strPzssm_workstep_v_id, strZssm_WorkstepBOM_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strZssm_WorkstepBOM_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strZssm_WorkstepBOM_V_ID.equals("")) strZssm_WorkstepBOM_V_ID = vars.getRequiredGlobalVariable("inpzssmWorkstepbomVId", windowId + "|Zssm_WorkstepBOM_V_ID");
      else vars.setSessionValue(windowId + "|Zssm_WorkstepBOM_V_ID", strZssm_WorkstepBOM_V_ID);
      
      
      String strPzssm_workstep_v_id = getParentID(vars, strZssm_WorkstepBOM_V_ID);
      
      vars.setSessionValue(windowId + "|zssm_workstep_v_id", strPzssm_workstep_v_id);
      vars.setSessionValue("035860BB9D4F4D08878CED2F371D7201|Work Steps.view", "EDIT");
      vars.removeSessionValue(windowId + "|zssm_productionorder_v_id");
      refreshParentSession(vars, strPzssm_workstep_v_id);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Billofmaterials9D775024A45140F0920B936C14A18527.view", "EDIT");

        printPageEdit(response, request, vars, false, strZssm_WorkstepBOM_V_ID, strPzssm_workstep_v_id, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Billofmaterials9D775024A45140F0920B936C14A18527.view", "RELATION");
        printPageDataSheet(response, vars, strPzssm_workstep_v_id, strZssm_WorkstepBOM_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPzssm_workstep_v_id = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id", false, false, true, "");
      vars.removeSessionValue(windowId + "|Zssm_WorkstepBOM_V_ID");
      refreshParentSession(vars, strPzssm_workstep_v_id);


      String strView = vars.getSessionValue(tabId + "|Billofmaterials9D775024A45140F0920B936C14A18527.view");
      String strZssm_WorkstepBOM_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strZssm_WorkstepBOM_V_ID = firstElement(vars, tableSQL);
          if (strZssm_WorkstepBOM_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strZssm_WorkstepBOM_V_ID.equals("")) strZssm_WorkstepBOM_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strZssm_WorkstepBOM_V_ID, strPzssm_workstep_v_id, tableSQL);

      } else printPageDataSheet(response, vars, strPzssm_workstep_v_id, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamM_Product_ID", tabId + "|paramM_Product_ID");

            String strPzssm_workstep_v_id = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id");

      
      vars.removeSessionValue(windowId + "|Zssm_WorkstepBOM_V_ID");
      String strZssm_WorkstepBOM_V_ID="";

      String strView = vars.getSessionValue(tabId + "|Billofmaterials9D775024A45140F0920B936C14A18527.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strZssm_WorkstepBOM_V_ID = firstElement(vars, tableSQL);
        if (strZssm_WorkstepBOM_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Billofmaterials9D775024A45140F0920B936C14A18527.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssm_WorkstepBOM_V_ID, strPzssm_workstep_v_id, tableSQL);

      else printPageDataSheet(response, vars, strPzssm_workstep_v_id, strZssm_WorkstepBOM_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPzssm_workstep_v_id = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id");
      

      String strZssm_WorkstepBOM_V_ID = vars.getGlobalVariable("inpzssmWorkstepbomVId", windowId + "|Zssm_WorkstepBOM_V_ID", "");
      vars.setSessionValue(tabId + "|Billofmaterials9D775024A45140F0920B936C14A18527.view", "RELATION");
      printPageDataSheet(response, vars, strPzssm_workstep_v_id, strZssm_WorkstepBOM_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPzssm_workstep_v_id = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id");


      printPageEdit(response, request, vars, true, "", strPzssm_workstep_v_id, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPzssm_workstep_v_id = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strZssm_WorkstepBOM_V_ID = vars.getGlobalVariable("inpzssmWorkstepbomVId", windowId + "|Zssm_WorkstepBOM_V_ID", "");
      vars.setSessionValue(tabId + "|Billofmaterials9D775024A45140F0920B936C14A18527.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strZssm_WorkstepBOM_V_ID, strPzssm_workstep_v_id, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPzssm_workstep_v_id = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id");
      String strZssm_WorkstepBOM_V_ID = vars.getRequiredStringParameter("inpzssmWorkstepbomVId");
      
      String strNext = nextElement(vars, strZssm_WorkstepBOM_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPzssm_workstep_v_id, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPzssm_workstep_v_id = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id");
      String strZssm_WorkstepBOM_V_ID = vars.getRequiredStringParameter("inpzssmWorkstepbomVId");
      
      String strPrevious = previousElement(vars, strZssm_WorkstepBOM_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPzssm_workstep_v_id, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id");

      vars.setSessionValue(tabId + "|Billofmaterials9D775024A45140F0920B936C14A18527.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPzssm_workstep_v_id = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id");

      String strInitRecord = vars.getSessionValue(tabId + "|Billofmaterials9D775024A45140F0920B936C14A18527.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Billofmaterials9D775024A45140F0920B936C14A18527.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Billofmaterials9D775024A45140F0920B936C14A18527.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Zssm_WorkstepBOM_V_ID");
      vars.setSessionValue(windowId + "|zssm_workstep_v_id", strPzssm_workstep_v_id);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPzssm_workstep_v_id = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id");

      String strInitRecord = vars.getSessionValue(tabId + "|Billofmaterials9D775024A45140F0920B936C14A18527.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Billofmaterials9D775024A45140F0920B936C14A18527.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Zssm_WorkstepBOM_V_ID");
      vars.setSessionValue(windowId + "|zssm_workstep_v_id", strPzssm_workstep_v_id);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPzssm_workstep_v_id = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPzssm_workstep_v_id, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPzssm_workstep_v_id = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPzssm_workstep_v_id, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPzssm_workstep_v_id = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPzssm_workstep_v_id, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPzssm_workstep_v_id = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPzssm_workstep_v_id);      
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
      String strPzssm_workstep_v_id = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id");
      String strZssm_WorkstepBOM_V_ID = vars.getRequiredGlobalVariable("inpzssmWorkstepbomVId", windowId + "|Zssm_WorkstepBOM_V_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPzssm_workstep_v_id);      
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
          String strNext = nextElement(vars, strZssm_WorkstepBOM_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|Zssm_WorkstepBOM_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPzssm_workstep_v_id = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id");

      String strZssm_WorkstepBOM_V_ID = vars.getRequiredInStringParameter("inpzssmWorkstepbomVId");
      String message = deleteRelation(vars, strZssm_WorkstepBOM_V_ID, strPzssm_workstep_v_id);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|zssmWorkstepbomVId");
        vars.setSessionValue(tabId + "|Billofmaterials9D775024A45140F0920B936C14A18527.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPzssm_workstep_v_id = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id");

      String strZssm_WorkstepBOM_V_ID = vars.getRequiredStringParameter("inpzssmWorkstepbomVId");
      //Billofmaterials9D775024A45140F0920B936C14A18527Data data = getEditVariables(vars, strPzssm_workstep_v_id);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = Billofmaterials9D775024A45140F0920B936C14A18527Data.delete(this, strZssm_WorkstepBOM_V_ID, strPzssm_workstep_v_id, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|zssmWorkstepbomVId");
        vars.setSessionValue(tabId + "|Billofmaterials9D775024A45140F0920B936C14A18527.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strZssm_WorkstepBOM_V_ID, String strPzssm_workstep_v_id) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strZssm_WorkstepBOM_V_ID.startsWith("(")) strZssm_WorkstepBOM_V_ID = strZssm_WorkstepBOM_V_ID.substring(1, strZssm_WorkstepBOM_V_ID.length()-1);
      if (!strZssm_WorkstepBOM_V_ID.equals("")) {
        strZssm_WorkstepBOM_V_ID = Replace.replace(strZssm_WorkstepBOM_V_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strZssm_WorkstepBOM_V_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (Billofmaterials9D775024A45140F0920B936C14A18527Data.deleteTransactional(conn, this, strKey, strPzssm_workstep_v_id)==0) {
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
  private Billofmaterials9D775024A45140F0920B936C14A18527Data getEditVariables(Connection con, VariablesSecureApp vars, String strPzssm_workstep_v_id) throws IOException,ServletException {
    Billofmaterials9D775024A45140F0920B936C14A18527Data data = new Billofmaterials9D775024A45140F0920B936C14A18527Data();
    ServletException ex = null;
    try {
    data.zssmWorkstepVId = vars.getStringParameter("inpzssmWorkstepVId");     data.zssmWorkstepVIdr = vars.getStringParameter("inpzssmWorkstepVId_R");     data.zspmProjecttaskbomId = vars.getStringParameter("inpzspmProjecttaskbomId");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");    try {   data.line = vars.getNumericParameter("inpline");  } catch (ServletException paramEx) { ex = paramEx; }     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.snrBatchmasterdataId = vars.getStringParameter("inpsnrBatchmasterdataId");     data.snrBatchmasterdataIdr = vars.getStringParameter("inpsnrBatchmasterdataId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.description = vars.getStringParameter("inpdescription");     data.rawmaterial = vars.getStringParameter("inprawmaterial");     data.constuctivemeasure = vars.getStringParameter("inpconstuctivemeasure");    try {   data.quantity = vars.getNumericParameter("inpquantity");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qtyreceived = vars.getNumericParameter("inpqtyreceived");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qtyAvailable = vars.getNumericParameter("inpqtyAvailable");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qtyInstock = vars.getNumericParameter("inpqtyInstock");  } catch (ServletException paramEx) { ex = paramEx; }     data.issuingLocator = vars.getStringParameter("inpissuingLocator");     data.issuingLocatorr = vars.getStringParameter("inpissuingLocator_R");     data.receivingLocator = vars.getStringParameter("inpreceivingLocator");     data.receivingLocatorr = vars.getStringParameter("inpreceivingLocator_R");     data.mLocatorId = vars.getStringParameter("inpmLocatorId");    try {   data.actualcosamount = vars.getNumericParameter("inpactualcosamount");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.cutoff = vars.getNumericParameter("inpcutoff");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qtyPlan = vars.getNumericParameter("inpqtyPlan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qtyreserved = vars.getNumericParameter("inpqtyreserved");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qtyinrequisition = vars.getNumericParameter("inpqtyinrequisition");  } catch (ServletException paramEx) { ex = paramEx; }     data.datePlan = vars.getStringParameter("inpdatePlan");     data.planrequisition = vars.getStringParameter("inpplanrequisition", "N");     data.zssmWorkstepbomVId = vars.getRequestGlobalVariable("inpzssmWorkstepbomVId", windowId + "|Zssm_WorkstepBOM_V_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.zssmWorkstepVId = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|zssm_workstep_v_id");


    
    

    
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

   private Billofmaterials9D775024A45140F0920B936C14A18527Data[] getRelationData(Billofmaterials9D775024A45140F0920B936C14A18527Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].zssmWorkstepVId = FormatUtilities.truncate(data[i].zssmWorkstepVId, 32);        data[i].zspmProjecttaskbomId = FormatUtilities.truncate(data[i].zspmProjecttaskbomId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].snrBatchmasterdataId = FormatUtilities.truncate(data[i].snrBatchmasterdataId, 32);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].rawmaterial = FormatUtilities.truncate(data[i].rawmaterial, 50);        data[i].constuctivemeasure = FormatUtilities.truncate(data[i].constuctivemeasure, 50);        data[i].issuingLocator = FormatUtilities.truncate(data[i].issuingLocator, 32);        data[i].receivingLocator = FormatUtilities.truncate(data[i].receivingLocator, 32);        data[i].mLocatorId = FormatUtilities.truncate(data[i].mLocatorId, 32);        data[i].zssmWorkstepbomVId = FormatUtilities.truncate(data[i].zssmWorkstepbomVId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPzssm_workstep_v_id) throws IOException,ServletException {
      WorkSteps035860BB9D4F4D08878CED2F371D7201Data[] data = WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getSessionValue(windowId + "|zssm_productionorder_v_id"), strPzssm_workstep_v_id, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Receiving_Locator", data[0].receivingLocator);    vars.setSessionValue(windowId + "|Issuing_Locator", data[0].issuingLocator);    vars.setSessionValue(windowId + "|Taskbegun", data[0].taskbegun);    vars.setSessionValue(windowId + "|IsComplete", data[0].iscomplete);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", data[0].zssmWorkstepVId);    vars.setSessionValue(windowId + "|Outsourcing", data[0].outsourcing);    vars.setSessionValue(windowId + "|QtyLeft", data[0].qtyleft);    vars.setSessionValue(windowId + "|Ismaterialdisposed", data[0].ismaterialdisposed);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);
      vars.setSessionValue(windowId + "|zssm_workstep_v_id", strPzssm_workstep_v_id); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strZssm_WorkstepBOM_V_ID) throws ServletException {
    String strPzssm_workstep_v_id = Billofmaterials9D775024A45140F0920B936C14A18527Data.selectParentID(this, strZssm_WorkstepBOM_V_ID);
    if (strPzssm_workstep_v_id.equals("")) {
      log4j.error("Parent record not found for id: " + strZssm_WorkstepBOM_V_ID);
      throw new ServletException("Parent record not found");
    }
    return strPzssm_workstep_v_id;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|Zssm_WorkstepBOM_V_ID", data[0].getField("zssmWorkstepbomVId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPzssm_workstep_v_id) throws IOException,ServletException {
      Billofmaterials9D775024A45140F0920B936C14A18527Data[] data = Billofmaterials9D775024A45140F0920B936C14A18527Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPzssm_workstep_v_id, vars.getStringParameter("inpzssmWorkstepbomVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPzssm_workstep_v_id, String strZssm_WorkstepBOM_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamM_Product_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strZssm_WorkstepBOM_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strZssm_WorkstepBOM_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/serprod/ProductionOrder/Billofmaterials9D775024A45140F0920B936C14A18527_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Billofmaterials9D775024A45140F0920B936C14A18527", false, "document.frmMain.inpzssmWorkstepbomVId", "grid", "..", "".equals("Y"), "ProductionOrder", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPzssm_workstep_v_id);

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
    xmlDocument.setParameter("KeyName", "zssmWorkstepbomVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Billofmaterials9D775024A45140F0920B936C14A18527_Relation.html", "ProductionOrder", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Billofmaterials9D775024A45140F0920B936C14A18527_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", Billofmaterials9D775024A45140F0920B936C14A18527Data.selectParent(this, strPzssm_workstep_v_id));
    else xmlDocument.setParameter("parent", Billofmaterials9D775024A45140F0920B936C14A18527Data.selectParentTrl(this, strPzssm_workstep_v_id));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strZssm_WorkstepBOM_V_ID, String strPzssm_workstep_v_id, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " zssm_workstepbom_v.line";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    Billofmaterials9D775024A45140F0920B936C14A18527Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");

    boolean hasSearchCondition=false;
    if (!(strParamM_Product_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = Billofmaterials9D775024A45140F0920B936C14A18527Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPzssm_workstep_v_id, strZssm_WorkstepBOM_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strZssm_WorkstepBOM_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new Billofmaterials9D775024A45140F0920B936C14A18527Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("zssmWorkstepbomVId") == null || dataField.getField("zssmWorkstepbomVId").equals("")) {
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
        refreshSessionNew(vars, strPzssm_workstep_v_id);
        data = Billofmaterials9D775024A45140F0920B936C14A18527Data.set(strPzssm_workstep_v_id, Utility.getDefault(this, vars, "QTY_Plan", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), "", Utility.getDefault(this, vars, "SNR_Batchmasterdata_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Utility.getDefault(this, vars, "Qtyreserved", "0", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Utility.getDefault(this, vars, "QTY_Available", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Utility.getDefault(this, vars, "Qtyreceived", "0", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Utility.getDefault(this, vars, "Rawmaterial", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Utility.getDefault(this, vars, "Description", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Utility.getDefault(this, vars, "Cutoff", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Billofmaterials9D775024A45140F0920B936C14A18527Data.selectDef7A3F6AF960BC464C8334BFAC465DD8DB_0(this, Utility.getDefault(this, vars, "M_Product_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField)), Utility.getDefault(this, vars, "Date_Plan", "@#Date@", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), "Y", Billofmaterials9D775024A45140F0920B936C14A18527Data.selectDefBA20CE0076A6439B8059C15E850186F8(this, Utility.getContext(this, vars, "zssm_workstep_prp_v_id", "A2BEBB9B07564D2AAA372B4CB2D01165"), strPzssm_workstep_v_id), Utility.getDefault(this, vars, "QTY_Instock", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Utility.getDefault(this, vars, "Zspm_Projecttaskbom_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Utility.getDefault(this, vars, "Issuing_Locator", "@Issuing_Locator@", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Billofmaterials9D775024A45140F0920B936C14A18527Data.selectDefCD3B8890911A4846A51869974E95AB3D_1(this, Utility.getDefault(this, vars, "Issuing_Locator", "@Issuing_Locator@", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField)), Utility.getDefault(this, vars, "Planrequisition", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "N", dataField), Utility.getDefault(this, vars, "Createdby", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Billofmaterials9D775024A45140F0920B936C14A18527Data.selectDef46D4D22988AC41AAB9A58DD210B09837_2(this, Utility.getDefault(this, vars, "Createdby", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField)), Utility.getDefault(this, vars, "M_Locator_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Utility.getDefault(this, vars, "Receiving_Locator", "@Receiving_Locator@", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Billofmaterials9D775024A45140F0920B936C14A18527Data.selectDef66C89371CA33406C84E2A61CF9B8DC91_3(this, Utility.getDefault(this, vars, "Receiving_Locator", "@Receiving_Locator@", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField)), Utility.getDefault(this, vars, "Actualcosamount", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Utility.getDefault(this, vars, "Qtyinrequisition", "0", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Utility.getDefault(this, vars, "Constuctivemeasure", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Billofmaterials9D775024A45140F0920B936C14A18527Data.selectDef29EE2442C220441C839A0E8F1C38656B_4(this, Utility.getDefault(this, vars, "Updatedby", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField)), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField), Utility.getDefault(this, vars, "Quantity", "1", "A2BEBB9B07564D2AAA372B4CB2D01165", "9D775024A45140F0920B936C14A18527", "", dataField));
        
      }
    } else {
      data = new Billofmaterials9D775024A45140F0920B936C14A18527Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(Billofmaterials9D775024A45140F0920B936C14A18527Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectOrg(this, strPzssm_workstep_v_id);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Billofmaterials9D775024A45140F0920B936C14A18527", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpzssmWorkstepbomVId", "", "..", "".equals("Y"), "ProductionOrder", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strZssm_WorkstepBOM_V_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPzssm_workstep_v_id) throws IOException, ServletException {
    Billofmaterials9D775024A45140F0920B936C14A18527Data data = null;
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
            data = getEditVariables(con, vars, strPzssm_workstep_v_id);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.zssmWorkstepbomVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (Billofmaterials9D775024A45140F0920B936C14A18527Data.getCurrentDBTimestamp(this, data.zssmWorkstepbomVId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.zssmWorkstepbomVId, vars, this);
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
                    data.zssmWorkstepbomVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Zssm_WorkstepBOM_V_ID", data.zssmWorkstepbomVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Billofmaterials9D775024A45140F0920B936C14A18527. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
