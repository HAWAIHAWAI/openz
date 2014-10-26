
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.ProductionOrder;


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

public class WorkSteps035860BB9D4F4D08878CED2F371D7201 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(WorkSteps035860BB9D4F4D08878CED2F371D7201.class);
  
  private static final String windowId = "A2BEBB9B07564D2AAA372B4CB2D01165";
  private static final String tabId = "035860BB9D4F4D08878CED2F371D7201";
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
        String strzssmWorkstepVId = request.getParameter("inpzssmWorkstepVId");
         String strPzssm_productionorder_v_id = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strzssmWorkstepVId.equals(""))
              total = saveRecord(vars, myError, 'U', strPzssm_productionorder_v_id);
          else
              total = saveRecord(vars, myError, 'I', strPzssm_productionorder_v_id);
          
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
      String strPzssm_productionorder_v_id = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id", "");

      String strZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID", "");
            if (strPzssm_productionorder_v_id.equals("")) {
        strPzssm_productionorder_v_id = getParentID(vars, strZssm_Workstep_V_ID);
        if (strPzssm_productionorder_v_id.equals("")) throw new ServletException("Required parameter :" + windowId + "|zssm_productionorder_v_id");
        vars.setSessionValue(windowId + "|zssm_productionorder_v_id", strPzssm_productionorder_v_id);

        refreshParentSession(vars, strPzssm_productionorder_v_id);
      }


      String strView = vars.getSessionValue(tabId + "|WorkSteps035860BB9D4F4D08878CED2F371D7201.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strZssm_Workstep_V_ID.equals("")) strZssm_Workstep_V_ID = firstElement(vars, tableSQL);
          if (strZssm_Workstep_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssm_Workstep_V_ID, strPzssm_productionorder_v_id, tableSQL);

      else printPageDataSheet(response, vars, strPzssm_productionorder_v_id, strZssm_Workstep_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strZssm_Workstep_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strZssm_Workstep_V_ID.equals("")) strZssm_Workstep_V_ID = vars.getRequiredGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
      else vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", strZssm_Workstep_V_ID);
      
      
      String strPzssm_productionorder_v_id = getParentID(vars, strZssm_Workstep_V_ID);
      
      vars.setSessionValue(windowId + "|zssm_productionorder_v_id", strPzssm_productionorder_v_id);
      vars.setSessionValue("CF6D6BC0255A47DFBD4FF6F8BEBA0C71|Production Order.view", "EDIT");

      refreshParentSession(vars, strPzssm_productionorder_v_id);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|WorkSteps035860BB9D4F4D08878CED2F371D7201.view", "EDIT");

        printPageEdit(response, request, vars, false, strZssm_Workstep_V_ID, strPzssm_productionorder_v_id, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|WorkSteps035860BB9D4F4D08878CED2F371D7201.view", "RELATION");
        printPageDataSheet(response, vars, strPzssm_productionorder_v_id, strZssm_Workstep_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPzssm_productionorder_v_id = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id", false, false, true, "");
      vars.removeSessionValue(windowId + "|Zssm_Workstep_V_ID");
      refreshParentSession(vars, strPzssm_productionorder_v_id);


      String strView = vars.getSessionValue(tabId + "|WorkSteps035860BB9D4F4D08878CED2F371D7201.view");
      String strZssm_Workstep_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strZssm_Workstep_V_ID = firstElement(vars, tableSQL);
          if (strZssm_Workstep_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strZssm_Workstep_V_ID.equals("")) strZssm_Workstep_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strZssm_Workstep_V_ID, strPzssm_productionorder_v_id, tableSQL);

      } else printPageDataSheet(response, vars, strPzssm_productionorder_v_id, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamValue", tabId + "|paramValue");
vars.getRequestGlobalVariable("inpParamIsActive", tabId + "|paramIsActive");
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamM_Product_ID", tabId + "|paramM_Product_ID");
vars.getRequestGlobalVariable("inpParamStarted", tabId + "|paramStarted");
vars.getRequestGlobalVariable("inpParamStartDate", tabId + "|paramStartDate");
vars.getRequestGlobalVariable("inpParamEnddate", tabId + "|paramEnddate");
vars.getRequestGlobalVariable("inpParamTriggerreason", tabId + "|paramTriggerreason");
vars.getRequestGlobalVariable("inpParamDescription", tabId + "|paramDescription");
vars.getRequestGlobalVariable("inpParamAD_Org_ID", tabId + "|paramAD_Org_ID");
vars.getRequestGlobalVariable("inpParamStarted_f", tabId + "|paramStarted_f");
vars.getRequestGlobalVariable("inpParamStartDate_f", tabId + "|paramStartDate_f");
vars.getRequestGlobalVariable("inpParamEnddate_f", tabId + "|paramEnddate_f");

            String strPzssm_productionorder_v_id = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id");

      
      vars.removeSessionValue(windowId + "|Zssm_Workstep_V_ID");
      String strZssm_Workstep_V_ID="";

      String strView = vars.getSessionValue(tabId + "|WorkSteps035860BB9D4F4D08878CED2F371D7201.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strZssm_Workstep_V_ID = firstElement(vars, tableSQL);
        if (strZssm_Workstep_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|WorkSteps035860BB9D4F4D08878CED2F371D7201.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssm_Workstep_V_ID, strPzssm_productionorder_v_id, tableSQL);

      else printPageDataSheet(response, vars, strPzssm_productionorder_v_id, strZssm_Workstep_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPzssm_productionorder_v_id = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id");
      

      String strZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID", "");
      vars.setSessionValue(tabId + "|WorkSteps035860BB9D4F4D08878CED2F371D7201.view", "RELATION");
      printPageDataSheet(response, vars, strPzssm_productionorder_v_id, strZssm_Workstep_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPzssm_productionorder_v_id = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id");


      printPageEdit(response, request, vars, true, "", strPzssm_productionorder_v_id, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPzssm_productionorder_v_id = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID", "");
      vars.setSessionValue(tabId + "|WorkSteps035860BB9D4F4D08878CED2F371D7201.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strZssm_Workstep_V_ID, strPzssm_productionorder_v_id, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPzssm_productionorder_v_id = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id");
      String strZssm_Workstep_V_ID = vars.getRequiredStringParameter("inpzssmWorkstepVId");
      
      String strNext = nextElement(vars, strZssm_Workstep_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPzssm_productionorder_v_id, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPzssm_productionorder_v_id = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id");
      String strZssm_Workstep_V_ID = vars.getRequiredStringParameter("inpzssmWorkstepVId");
      
      String strPrevious = previousElement(vars, strZssm_Workstep_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPzssm_productionorder_v_id, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id");

      vars.setSessionValue(tabId + "|WorkSteps035860BB9D4F4D08878CED2F371D7201.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPzssm_productionorder_v_id = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id");

      String strInitRecord = vars.getSessionValue(tabId + "|WorkSteps035860BB9D4F4D08878CED2F371D7201.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|WorkSteps035860BB9D4F4D08878CED2F371D7201.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|WorkSteps035860BB9D4F4D08878CED2F371D7201.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Zssm_Workstep_V_ID");
      vars.setSessionValue(windowId + "|zssm_productionorder_v_id", strPzssm_productionorder_v_id);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPzssm_productionorder_v_id = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id");

      String strInitRecord = vars.getSessionValue(tabId + "|WorkSteps035860BB9D4F4D08878CED2F371D7201.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|WorkSteps035860BB9D4F4D08878CED2F371D7201.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Zssm_Workstep_V_ID");
      vars.setSessionValue(windowId + "|zssm_productionorder_v_id", strPzssm_productionorder_v_id);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPzssm_productionorder_v_id = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPzssm_productionorder_v_id, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPzssm_productionorder_v_id = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPzssm_productionorder_v_id, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPzssm_productionorder_v_id = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPzssm_productionorder_v_id, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPzssm_productionorder_v_id = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPzssm_productionorder_v_id);      
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
      String strPzssm_productionorder_v_id = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id");
      String strZssm_Workstep_V_ID = vars.getRequiredGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPzssm_productionorder_v_id);      
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
          String strNext = nextElement(vars, strZssm_Workstep_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPzssm_productionorder_v_id = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id");

      String strZssm_Workstep_V_ID = vars.getRequiredInStringParameter("inpzssmWorkstepVId");
      String message = deleteRelation(vars, strZssm_Workstep_V_ID, strPzssm_productionorder_v_id);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|zssmWorkstepVId");
        vars.setSessionValue(tabId + "|WorkSteps035860BB9D4F4D08878CED2F371D7201.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPzssm_productionorder_v_id = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id");

      String strZssm_Workstep_V_ID = vars.getRequiredStringParameter("inpzssmWorkstepVId");
      //WorkSteps035860BB9D4F4D08878CED2F371D7201Data data = getEditVariables(vars, strPzssm_productionorder_v_id);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = WorkSteps035860BB9D4F4D08878CED2F371D7201Data.delete(this, strZssm_Workstep_V_ID, strPzssm_productionorder_v_id, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|zssmWorkstepVId");
        vars.setSessionValue(tabId + "|WorkSteps035860BB9D4F4D08878CED2F371D7201.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONBeginTask4093D1303F674DB6812B1852AF66660C")) {
        vars.setSessionValue("button4093D1303F674DB6812B1852AF66660C.strbegintask", vars.getStringParameter("inpbegintask"));
        vars.setSessionValue("button4093D1303F674DB6812B1852AF66660C.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button4093D1303F674DB6812B1852AF66660C.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button4093D1303F674DB6812B1852AF66660C.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button4093D1303F674DB6812B1852AF66660C.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "4093D1303F674DB6812B1852AF66660C", request.getServletPath());    
     } else if (vars.commandIn("BUTTON4093D1303F674DB6812B1852AF66660C")) {
        String strZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID", "");
        String strbegintask = vars.getSessionValue("button4093D1303F674DB6812B1852AF66660C.strbegintask");
        String strProcessing = vars.getSessionValue("button4093D1303F674DB6812B1852AF66660C.strProcessing");
        String strOrg = vars.getSessionValue("button4093D1303F674DB6812B1852AF66660C.strOrg");
        String strClient = vars.getSessionValue("button4093D1303F674DB6812B1852AF66660C.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBeginTask4093D1303F674DB6812B1852AF66660C(response, vars, strZssm_Workstep_V_ID, strbegintask, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEndtask70BF56CEF42F475DB46995FC019D754A")) {
        vars.setSessionValue("button70BF56CEF42F475DB46995FC019D754A.strendtask", vars.getStringParameter("inpendtask"));
        vars.setSessionValue("button70BF56CEF42F475DB46995FC019D754A.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button70BF56CEF42F475DB46995FC019D754A.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button70BF56CEF42F475DB46995FC019D754A.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button70BF56CEF42F475DB46995FC019D754A.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "70BF56CEF42F475DB46995FC019D754A", request.getServletPath());    
     } else if (vars.commandIn("BUTTON70BF56CEF42F475DB46995FC019D754A")) {
        String strZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID", "");
        String strendtask = vars.getSessionValue("button70BF56CEF42F475DB46995FC019D754A.strendtask");
        String strProcessing = vars.getSessionValue("button70BF56CEF42F475DB46995FC019D754A.strProcessing");
        String strOrg = vars.getSessionValue("button70BF56CEF42F475DB46995FC019D754A.strOrg");
        String strClient = vars.getSessionValue("button70BF56CEF42F475DB46995FC019D754A.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEndtask70BF56CEF42F475DB46995FC019D754A(response, vars, strZssm_Workstep_V_ID, strendtask, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONBeginTask4093D1303F674DB6812B1852AF66660C")) {
        String strZssm_Workstep_V_ID = vars.getGlobalVariable("inpKey", windowId + "|Zssm_Workstep_V_ID", "");
        @SuppressWarnings("unused")
        String strbegintask = vars.getStringParameter("inpbegintask");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "4093D1303F674DB6812B1852AF66660C", (("Zssm_Workstep_V_ID".equalsIgnoreCase("AD_Language"))?"0":strZssm_Workstep_V_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEndtask70BF56CEF42F475DB46995FC019D754A")) {
        String strZssm_Workstep_V_ID = vars.getGlobalVariable("inpKey", windowId + "|Zssm_Workstep_V_ID", "");
        @SuppressWarnings("unused")
        String strendtask = vars.getStringParameter("inpendtask");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "70BF56CEF42F475DB46995FC019D754A", (("Zssm_Workstep_V_ID".equalsIgnoreCase("AD_Language"))?"0":strZssm_Workstep_V_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strqtyreturned = vars.getNumericParameter("inpqtyreturned");
PInstanceProcessData.insertPInstanceParamNumber(this, pinstance, "10", "qtyreturned", strqtyreturned, vars.getClient(), vars.getOrg(), vars.getUser());
String strrejectremaining = vars.getStringParameter("inprejectremaining", "N");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "rejectremaining", strrejectremaining, vars.getClient(), vars.getOrg(), vars.getUser());
String strmLocatorId = vars.getStringParameter("inpmLocatorId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "30", "M_Locator_ID", strmLocatorId, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
  String deleteRelation(VariablesSecureApp vars, String strZssm_Workstep_V_ID, String strPzssm_productionorder_v_id) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strZssm_Workstep_V_ID.startsWith("(")) strZssm_Workstep_V_ID = strZssm_Workstep_V_ID.substring(1, strZssm_Workstep_V_ID.length()-1);
      if (!strZssm_Workstep_V_ID.equals("")) {
        strZssm_Workstep_V_ID = Replace.replace(strZssm_Workstep_V_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strZssm_Workstep_V_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (WorkSteps035860BB9D4F4D08878CED2F371D7201Data.deleteTransactional(conn, this, strKey, strPzssm_productionorder_v_id)==0) {
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
  private WorkSteps035860BB9D4F4D08878CED2F371D7201Data getEditVariables(Connection con, VariablesSecureApp vars, String strPzssm_productionorder_v_id) throws IOException,ServletException {
    WorkSteps035860BB9D4F4D08878CED2F371D7201Data data = new WorkSteps035860BB9D4F4D08878CED2F371D7201Data();
    ServletException ex = null;
    try {
    data.zssmProductionorderVId = vars.getStringParameter("inpzssmProductionorderVId");     data.zssmProductionorderVIdr = vars.getStringParameter("inpzssmProductionorderVId_R");    try {   data.seqno = vars.getNumericParameter("inpseqno");  } catch (ServletException paramEx) { ex = paramEx; }     data.value = vars.getStringParameter("inpvalue");     data.name = vars.getStringParameter("inpname");     data.description = vars.getStringParameter("inpdescription");     data.triggerreason = vars.getStringParameter("inptriggerreason");    try {   data.qty = vars.getNumericParameter("inpqty");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qtyproduced = vars.getNumericParameter("inpqtyproduced");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.weightproportion = vars.getNumericParameter("inpweightproportion");  } catch (ServletException paramEx) { ex = paramEx; }     data.assembly = vars.getStringParameter("inpassembly", "N");     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.forcematerialscan = vars.getStringParameter("inpforcematerialscan", "N");     data.startonlywithcompletematerial = vars.getStringParameter("inpstartonlywithcompletematerial", "N");     data.startdate = vars.getStringParameter("inpstartdate");     data.enddate = vars.getStringParameter("inpenddate");     data.receivingLocator = vars.getRequestGlobalVariable("inpreceivingLocator", windowId + "|Receiving_Locator");     data.receivingLocatorr = vars.getStringParameter("inpreceivingLocator_R");     data.issuingLocator = vars.getRequestGlobalVariable("inpissuingLocator", windowId + "|Issuing_Locator");     data.issuingLocatorr = vars.getStringParameter("inpissuingLocator_R");    try {   data.timeperpiece = vars.getNumericParameter("inptimeperpiece");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.setuptime = vars.getNumericParameter("inpsetuptime");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.timeplanned = vars.getNumericParameter("inptimeplanned");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.servcostplan = vars.getNumericParameter("inpservcostplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.machinecostplan = vars.getNumericParameter("inpmachinecostplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.materialcostplan = vars.getNumericParameter("inpmaterialcostplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.plannedcost = vars.getNumericParameter("inpplannedcost");  } catch (ServletException paramEx) { ex = paramEx; }     data.taskbegun = vars.getRequiredInputGlobalVariable("inptaskbegun", windowId + "|Taskbegun", "N");     data.started = vars.getStringParameter("inpstarted");     data.iscomplete = vars.getRequiredInputGlobalVariable("inpiscomplete", windowId + "|Iscomplete", "N");     data.ended = vars.getStringParameter("inpended");     data.begintask = vars.getStringParameter("inpbegintask");     data.endtask = vars.getStringParameter("inpendtask");     data.createbom = vars.getStringParameter("inpcreatebom");    try {   data.invoicedamt = vars.getNumericParameter("inpinvoicedamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.isactive = vars.getStringParameter("inpisactive", "N");     data.zssmPrjProjectcategory = vars.getStringParameter("inpzssmPrjProjectcategory");     data.outsourcing = vars.getRequiredInputGlobalVariable("inpoutsourcing", windowId + "|Outsourcing", "N");     data.canceltask = vars.getStringParameter("inpcanceltask");    try {   data.committedamt = vars.getNumericParameter("inpcommittedamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.gotopurchasing = vars.getStringParameter("inpgotopurchasing", "N");    try {   data.qtyleft = vars.getNumericParameter("inpqtyleft", vars.getSessionValue(windowId + "|Qtyleft"));  } catch (ServletException paramEx) { ex = paramEx; }     data.ismaterialdisposed = vars.getRequiredInputGlobalVariable("inpismaterialdisposed", windowId + "|Ismaterialdisposed", "N");     data.zssmProductionplanTaskId = vars.getStringParameter("inpzssmProductionplanTaskId");     data.isautotriggered = vars.getStringParameter("inpisautotriggered", "N");     data.returnmaterialtostock = vars.getStringParameter("inpreturnmaterialtostock");    try {   data.percentrejects = vars.getNumericParameter("inppercentrejects");  } catch (ServletException paramEx) { ex = paramEx; }     data.unplanmaterial = vars.getStringParameter("inpunplanmaterial");    try {   data.expenses = vars.getNumericParameter("inpexpenses");  } catch (ServletException paramEx) { ex = paramEx; }     data.planmaterial = vars.getStringParameter("inpplanmaterial");    try {   data.percentdone = vars.getNumericParameter("inppercentdone");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.priceactual = vars.getNumericParameter("inppriceactual");  } catch (ServletException paramEx) { ex = paramEx; }     data.zssmWorkstepVId = vars.getRequestGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.zssmPrjName = vars.getStringParameter("inpzssmPrjName");    try {   data.materialcost = vars.getNumericParameter("inpmaterialcost");  } catch (ServletException paramEx) { ex = paramEx; }     data.cOrderlineId = vars.getStringParameter("inpcOrderlineId");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.help = vars.getStringParameter("inphelp");     data.schedulestatus = vars.getStringParameter("inpschedulestatus");     data.datecontract = vars.getStringParameter("inpdatecontract");     data.getmaterialfromstock = vars.getStringParameter("inpgetmaterialfromstock");    try {   data.machinecost = vars.getNumericParameter("inpmachinecost");  } catch (ServletException paramEx) { ex = paramEx; }     data.istaskcancelled = vars.getStringParameter("inpistaskcancelled", "N");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");    try {   data.servcost = vars.getNumericParameter("inpservcost");  } catch (ServletException paramEx) { ex = paramEx; }     data.iscommitceiling = vars.getStringParameter("inpiscommitceiling", "N");    try {   data.indirectcostplan = vars.getNumericParameter("inpindirectcostplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.indirectcost = vars.getNumericParameter("inpindirectcost");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.actualcost = vars.getNumericParameter("inpactualcost");  } catch (ServletException paramEx) { ex = paramEx; }     data.cTaskId = vars.getStringParameter("inpcTaskId"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.zssmProductionorderVId = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|zssm_productionorder_v_id");


    
    

    
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

   private WorkSteps035860BB9D4F4D08878CED2F371D7201Data[] getRelationData(WorkSteps035860BB9D4F4D08878CED2F371D7201Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].zssmProductionorderVId = FormatUtilities.truncate(data[i].zssmProductionorderVId, 46);        data[i].value = FormatUtilities.truncate(data[i].value, 20);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].triggerreason = FormatUtilities.truncate(data[i].triggerreason, 50);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].receivingLocator = FormatUtilities.truncate(data[i].receivingLocator, 32);        data[i].issuingLocator = FormatUtilities.truncate(data[i].issuingLocator, 32);        data[i].zssmPrjProjectcategory = FormatUtilities.truncate(data[i].zssmPrjProjectcategory, 50);        data[i].zssmProductionplanTaskId = FormatUtilities.truncate(data[i].zssmProductionplanTaskId, 32);        data[i].zssmWorkstepVId = FormatUtilities.truncate(data[i].zssmWorkstepVId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 22);        data[i].zssmPrjName = FormatUtilities.truncate(data[i].zssmPrjName, 50);        data[i].cOrderlineId = FormatUtilities.truncate(data[i].cOrderlineId, 32);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].help = FormatUtilities.truncate(data[i].help, 50);        data[i].schedulestatus = FormatUtilities.truncate(data[i].schedulestatus, 20);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 22);        data[i].cTaskId = FormatUtilities.truncate(data[i].cTaskId, 22);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPzssm_productionorder_v_id) throws IOException,ServletException {
      ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[] data = ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPzssm_productionorder_v_id, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].mWarehouseId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].cCurrencyId);    vars.setSessionValue(windowId + "|IsCommitment", data[0].iscommitment);    vars.setSessionValue(windowId + "|Zssm_Productionorder_V_ID", data[0].zssmProductionorderVId);    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].cBpartnerId);    vars.setSessionValue(windowId + "|ProjectCategory", data[0].projectcategory);    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].mPricelistId);
      vars.setSessionValue(windowId + "|zssm_productionorder_v_id", strPzssm_productionorder_v_id); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strZssm_Workstep_V_ID) throws ServletException {
    String strPzssm_productionorder_v_id = WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectParentID(this, strZssm_Workstep_V_ID);
    if (strPzssm_productionorder_v_id.equals("")) {
      log4j.error("Parent record not found for id: " + strZssm_Workstep_V_ID);
      throw new ServletException("Parent record not found");
    }
    return strPzssm_productionorder_v_id;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Receiving_Locator", data[0].getField("receivingLocator"));    vars.setSessionValue(windowId + "|Issuing_Locator", data[0].getField("issuingLocator"));    vars.setSessionValue(windowId + "|Taskbegun", data[0].getField("taskbegun"));    vars.setSessionValue(windowId + "|IsComplete", data[0].getField("iscomplete"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", data[0].getField("zssmWorkstepVId"));    vars.setSessionValue(windowId + "|Outsourcing", data[0].getField("outsourcing"));    vars.setSessionValue(windowId + "|QtyLeft", data[0].getField("qtyleft"));    vars.setSessionValue(windowId + "|Ismaterialdisposed", data[0].getField("ismaterialdisposed"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPzssm_productionorder_v_id) throws IOException,ServletException {
      WorkSteps035860BB9D4F4D08878CED2F371D7201Data[] data = WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPzssm_productionorder_v_id, vars.getStringParameter("inpzssmWorkstepVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPzssm_productionorder_v_id, String strZssm_Workstep_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamIsActive = vars.getSessionValue(tabId + "|paramIsActive");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamStarted = vars.getSessionValue(tabId + "|paramStarted");
String strParamStartDate = vars.getSessionValue(tabId + "|paramStartDate");
String strParamEnddate = vars.getSessionValue(tabId + "|paramEnddate");
String strParamTriggerreason = vars.getSessionValue(tabId + "|paramTriggerreason");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamStarted_f = vars.getSessionValue(tabId + "|paramStarted_f");
String strParamStartDate_f = vars.getSessionValue(tabId + "|paramStartDate_f");
String strParamEnddate_f = vars.getSessionValue(tabId + "|paramEnddate_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamValue.equals("") && strParamIsActive.equals("") && strParamName.equals("") && strParamM_Product_ID.equals("") && strParamStarted.equals("") && strParamStartDate.equals("") && strParamEnddate.equals("") && strParamTriggerreason.equals("") && strParamDescription.equals("") && strParamAD_Org_ID.equals("") && strParamStarted_f.equals("") && strParamStartDate_f.equals("") && strParamEnddate_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strZssm_Workstep_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strZssm_Workstep_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/serprod/ProductionOrder/WorkSteps035860BB9D4F4D08878CED2F371D7201_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "WorkSteps035860BB9D4F4D08878CED2F371D7201", false, "document.frmMain.inpzssmWorkstepVId", "grid", "../workstep/print.html", "N".equals("Y"), "ProductionOrder", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPzssm_productionorder_v_id);

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
    xmlDocument.setParameter("KeyName", "zssmWorkstepVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "WorkSteps035860BB9D4F4D08878CED2F371D7201_Relation.html", "ProductionOrder", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "WorkSteps035860BB9D4F4D08878CED2F371D7201_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectParent(this, strPzssm_productionorder_v_id));
    else xmlDocument.setParameter("parent", WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectParentTrl(this, strPzssm_productionorder_v_id));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strZssm_Workstep_V_ID, String strPzssm_productionorder_v_id, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " zssm_workstep_v.SeqNo";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    WorkSteps035860BB9D4F4D08878CED2F371D7201Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamIsActive = vars.getSessionValue(tabId + "|paramIsActive");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamStarted = vars.getSessionValue(tabId + "|paramStarted");
String strParamStartDate = vars.getSessionValue(tabId + "|paramStartDate");
String strParamEnddate = vars.getSessionValue(tabId + "|paramEnddate");
String strParamTriggerreason = vars.getSessionValue(tabId + "|paramTriggerreason");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamStarted_f = vars.getSessionValue(tabId + "|paramStarted_f");
String strParamStartDate_f = vars.getSessionValue(tabId + "|paramStartDate_f");
String strParamEnddate_f = vars.getSessionValue(tabId + "|paramEnddate_f");

    boolean hasSearchCondition=false;
    if (!(strParamValue.equals("") && strParamIsActive.equals("") && strParamName.equals("") && strParamM_Product_ID.equals("") && strParamStarted.equals("") && strParamStartDate.equals("") && strParamEnddate.equals("") && strParamTriggerreason.equals("") && strParamDescription.equals("") && strParamAD_Org_ID.equals("") && strParamStarted_f.equals("") && strParamStartDate_f.equals("") && strParamEnddate_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPzssm_productionorder_v_id, strZssm_Workstep_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strZssm_Workstep_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new WorkSteps035860BB9D4F4D08878CED2F371D7201Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("zssmWorkstepVId") == null || dataField.getField("zssmWorkstepVId").equals("")) {
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
        refreshSessionNew(vars, strPzssm_productionorder_v_id);
        data = WorkSteps035860BB9D4F4D08878CED2F371D7201Data.set(strPzssm_productionorder_v_id, Utility.getDefault(this, vars, "Weightproportion", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "PriceActual", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectDef18E2B62B71AA4FCC8F0E7E5AB8FAD6D2_0(this, Utility.getDefault(this, vars, "UpdatedBy", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField)), Utility.getDefault(this, vars, "C_ProjectTask_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Outsourcing", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), Utility.getDefault(this, vars, "Unplanmaterial", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Zssm_Prj_Name", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Triggerreason", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Canceltask", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), Utility.getDefault(this, vars, "Timeplanned", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectDef5289F216D0D6477B874F419B2DA25F87_1(this, Utility.getDefault(this, vars, "M_Product_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField)), Utility.getDefault(this, vars, "Ismaterialdisposed", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectDef59634A916FC54AC99E95765067C5774C(this, Utility.getContext(this, vars, "#AD_JAVADATEFORMAT", windowId), Utility.getContext(this, vars, "C_Project_ID", "A2BEBB9B07564D2AAA372B4CB2D01165")), Utility.getDefault(this, vars, "CreatedBy", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectDefBF72293C90A14B129863C0F861752AE1_2(this, Utility.getDefault(this, vars, "CreatedBy", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField)), Utility.getDefault(this, vars, "Returnmaterialtostock", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), Utility.getDefault(this, vars, "Schedulestatus", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Issuing_Locator", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectDef303E0FBA8DBC4B368E5FF9BACE658878_3(this, Utility.getDefault(this, vars, "Issuing_Locator", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField)), Utility.getDefault(this, vars, "Datecontract", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Qtyproduced", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Iscomplete", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), Utility.getDefault(this, vars, "C_Task_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Servcostplan", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Assembly", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), Utility.getDefault(this, vars, "Startonlywithcompletematerial", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), Utility.getDefault(this, vars, "Materialcostplan", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Qtyleft", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Percentdone", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Value", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Percentrejects", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Gotopurchasing", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), Utility.getDefault(this, vars, "Taskbegun", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), Utility.getDefault(this, vars, "Help", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Setuptime", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Expenses", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Planmaterial", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), Utility.getDefault(this, vars, "Machinecostplan", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Isautotriggered", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), Utility.getDefault(this, vars, "Forcematerialscan", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), Utility.getDefault(this, vars, "Timeperpiece", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Indirectcostplan", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Createbom", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), Utility.getDefault(this, vars, "Name", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Invoicedamt", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Qty", "1", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Receiving_Locator", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectDef16D7CBA97CC64B5DBE296A6F9B754BD1_4(this, Utility.getDefault(this, vars, "Receiving_Locator", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField)), "", Utility.getDefault(this, vars, "Machinecost", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Zssm_Prj_Projectcategory", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Getmaterialfromstock", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), Utility.getDefault(this, vars, "Iscommitceiling", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), Utility.getDefault(this, vars, "Ended", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "C_Orderline_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "BeginTask", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), Utility.getDefault(this, vars, "Committedamt", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Actualcost", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Servcost", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Plannedcost", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectDefC46C3A0F43DC4141ACA5A7451857773A(this, Utility.getContext(this, vars, "C_Project_ID", "A2BEBB9B07564D2AAA372B4CB2D01165")), Utility.getDefault(this, vars, "Materialcost", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), "Y", Utility.getDefault(this, vars, "Endtask", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), Utility.getDefault(this, vars, "Started", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Zssm_Productionplan_Task_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), Utility.getDefault(this, vars, "Description", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField), WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectDef1119F3F170EF46D1A1B69625B63F826C(this, Utility.getContext(this, vars, "#AD_JAVADATEFORMAT", windowId), Utility.getContext(this, vars, "C_Project_ID", "A2BEBB9B07564D2AAA372B4CB2D01165")), Utility.getDefault(this, vars, "Istaskcancelled", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "N", dataField), Utility.getDefault(this, vars, "Indirectcost", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "035860BB9D4F4D08878CED2F371D7201", "", dataField));
        
      }
    } else {
      data = new WorkSteps035860BB9D4F4D08878CED2F371D7201Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(WorkSteps035860BB9D4F4D08878CED2F371D7201Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.selectOrg(this, strPzssm_productionorder_v_id);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "WorkSteps035860BB9D4F4D08878CED2F371D7201", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpzssmWorkstepVId", "", "../workstep/print.html", "N".equals("Y"), "ProductionOrder", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strZssm_Workstep_V_ID));
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
  
    void printPageButtonBeginTask4093D1303F674DB6812B1852AF66660C(HttpServletResponse response, VariablesSecureApp vars, String strZssm_Workstep_V_ID, String strbegintask, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "4093D1303F674DB6812B1852AF66660C",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "4093D1303F674DB6812B1852AF66660C" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"4093D1303F674DB6812B1852AF66660C" );
        String isDocAction=UtilsData.isProcessDocAction(this, "4093D1303F674DB6812B1852AF66660C");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "5ACEF6CF329D4BC09C05FCE78775454C",strZssm_Workstep_V_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "5ACEF6CF329D4BC09C05FCE78775454C", strZssm_Workstep_V_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strbegintask, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "4093D1303F674DB6812B1852AF66660C");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONBeginTask" + "4093D1303F674DB6812B1852AF66660C" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","WorkSteps035860BB9D4F4D08878CED2F371D7201_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "4093D1303F674DB6812B1852AF66660C");
        script.addHiddenfield("inpKey",strZssm_Workstep_V_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("4093D1303F674DB6812B1852AF66660C");
        vars.removeMessage("4093D1303F674DB6812B1852AF66660C");
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
    void printPageButtonEndtask70BF56CEF42F475DB46995FC019D754A(HttpServletResponse response, VariablesSecureApp vars, String strZssm_Workstep_V_ID, String strendtask, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "70BF56CEF42F475DB46995FC019D754A",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "70BF56CEF42F475DB46995FC019D754A" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"70BF56CEF42F475DB46995FC019D754A" );
        String isDocAction=UtilsData.isProcessDocAction(this, "70BF56CEF42F475DB46995FC019D754A");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "5ACEF6CF329D4BC09C05FCE78775454C",strZssm_Workstep_V_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "5ACEF6CF329D4BC09C05FCE78775454C", strZssm_Workstep_V_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strendtask, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "70BF56CEF42F475DB46995FC019D754A");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONEndtask" + "70BF56CEF42F475DB46995FC019D754A" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","WorkSteps035860BB9D4F4D08878CED2F371D7201_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "70BF56CEF42F475DB46995FC019D754A");
        script.addHiddenfield("inpKey",strZssm_Workstep_V_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("70BF56CEF42F475DB46995FC019D754A");
        vars.removeMessage("70BF56CEF42F475DB46995FC019D754A");
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPzssm_productionorder_v_id) throws IOException, ServletException {
    WorkSteps035860BB9D4F4D08878CED2F371D7201Data data = null;
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
            data = getEditVariables(con, vars, strPzssm_productionorder_v_id);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.zssmWorkstepVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (WorkSteps035860BB9D4F4D08878CED2F371D7201Data.getCurrentDBTimestamp(this, data.zssmWorkstepVId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.zssmWorkstepVId, vars, this);
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
                    data.zssmWorkstepVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", data.zssmWorkstepVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet WorkSteps035860BB9D4F4D08878CED2F371D7201. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
