
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.ProductionOrder;


import org.openbravo.erpCommon.reference.*;


import org.openbravo.erpCommon.ad_actionButton.*;



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

public class ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71.class);
  
  private static final String windowId = "A2BEBB9B07564D2AAA372B4CB2D01165";
  private static final String tabId = "CF6D6BC0255A47DFBD4FF6F8BEBA0C71";
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
        String strzssmProductionorderVId = request.getParameter("inpzssmProductionorderVId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strzssmProductionorderVId.equals(""))
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

      String strZssm_Productionorder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_Productionorder_V_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strZssm_Productionorder_V_ID.equals("")) strZssm_Productionorder_V_ID = firstElement(vars, tableSQL);
          if (strZssm_Productionorder_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssm_Productionorder_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strZssm_Productionorder_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strZssm_Productionorder_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strZssm_Productionorder_V_ID.equals("")) strZssm_Productionorder_V_ID = vars.getRequiredGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_Productionorder_V_ID");
      else vars.setSessionValue(windowId + "|Zssm_Productionorder_V_ID", strZssm_Productionorder_V_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71.view", "EDIT");

        printPageEdit(response, request, vars, false, strZssm_Productionorder_V_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71.view", "RELATION");
        printPageDataSheet(response, vars, strZssm_Productionorder_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71.view");
      String strZssm_Productionorder_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strZssm_Productionorder_V_ID = firstElement(vars, tableSQL);
          if (strZssm_Productionorder_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strZssm_Productionorder_V_ID.equals("")) strZssm_Productionorder_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strZssm_Productionorder_V_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamValue", tabId + "|paramValue");
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamDescription", tabId + "|paramDescription");
vars.getRequestGlobalVariable("inpParamNote", tabId + "|paramNote");
vars.getRequestGlobalVariable("inpParamIsActive", tabId + "|paramIsActive");
vars.getRequestGlobalVariable("inpParamProjectStatus", tabId + "|paramProjectStatus");
vars.getRequestGlobalVariable("inpParamStartdate", tabId + "|paramStartdate");
vars.getRequestGlobalVariable("inpParamDateFinish", tabId + "|paramDateFinish");
vars.getRequestGlobalVariable("inpParamResponsible_ID", tabId + "|paramResponsible_ID");
vars.getRequestGlobalVariable("inpParamM_Warehouse_ID", tabId + "|paramM_Warehouse_ID");
vars.getRequestGlobalVariable("inpParamStartdate_f", tabId + "|paramStartdate_f");
vars.getRequestGlobalVariable("inpParamDateFinish_f", tabId + "|paramDateFinish_f");

      
      
      vars.removeSessionValue(windowId + "|Zssm_Productionorder_V_ID");
      String strZssm_Productionorder_V_ID="";

      String strView = vars.getSessionValue(tabId + "|ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strZssm_Productionorder_V_ID = firstElement(vars, tableSQL);
        if (strZssm_Productionorder_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssm_Productionorder_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strZssm_Productionorder_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strZssm_Productionorder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_Productionorder_V_ID", "");
      vars.setSessionValue(tabId + "|ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71.view", "RELATION");
      printPageDataSheet(response, vars, strZssm_Productionorder_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strZssm_Productionorder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_Productionorder_V_ID", "");
      vars.setSessionValue(tabId + "|ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strZssm_Productionorder_V_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strZssm_Productionorder_V_ID = vars.getRequiredStringParameter("inpzssmProductionorderVId");
      
      String strNext = nextElement(vars, strZssm_Productionorder_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strZssm_Productionorder_V_ID = vars.getRequiredStringParameter("inpzssmProductionorderVId");
      
      String strPrevious = previousElement(vars, strZssm_Productionorder_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Zssm_Productionorder_V_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Zssm_Productionorder_V_ID");

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

      String strZssm_Productionorder_V_ID = vars.getRequiredGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_Productionorder_V_ID");
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
          String strNext = nextElement(vars, strZssm_Productionorder_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|Zssm_Productionorder_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strZssm_Productionorder_V_ID = vars.getRequiredInStringParameter("inpzssmProductionorderVId");
      String message = deleteRelation(vars, strZssm_Productionorder_V_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|zssmProductionorderVId");
        vars.setSessionValue(tabId + "|ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strZssm_Productionorder_V_ID = vars.getRequiredStringParameter("inpzssmProductionorderVId");
      //ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.delete(this, strZssm_Productionorder_V_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|zssmProductionorderVId");
        vars.setSessionValue(tabId + "|ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONChangeProjectStatus800002")) {
        vars.setSessionValue("button800002.strchangeprojectstatus", vars.getStringParameter("inpchangeprojectstatus"));
        vars.setSessionValue("button800002.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button800002.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button800002.strClient", vars.getStringParameter("inpadClientId"));
        vars.setSessionValue("button800002.inpprojectstatus", vars.getRequiredStringParameter("inpprojectstatus"));

        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button800002.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "800002", request.getServletPath());    
     } else if (vars.commandIn("BUTTON800002")) {
        String strZssm_Productionorder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_Productionorder_V_ID", "");
        String strchangeprojectstatus = vars.getSessionValue("button800002.strchangeprojectstatus");
        String strProcessing = vars.getSessionValue("button800002.strProcessing");
        String strOrg = vars.getSessionValue("button800002.strOrg");
        String strClient = vars.getSessionValue("button800002.strClient");
        
        String strprojectstatus = vars.getSessionValue("button800002.inpprojectstatus");

        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonChangeProjectStatus800002(response, vars, strZssm_Productionorder_V_ID, strchangeprojectstatus, strProcessing);
        }

     } else if (vars.commandIn("BUTTONCloseProject34018D4E2BFA4A06A59C305D02D634EA")) {
        vars.setSessionValue("button34018D4E2BFA4A06A59C305D02D634EA.strcloseproject", vars.getStringParameter("inpcloseproject"));
        vars.setSessionValue("button34018D4E2BFA4A06A59C305D02D634EA.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button34018D4E2BFA4A06A59C305D02D634EA.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button34018D4E2BFA4A06A59C305D02D634EA.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button34018D4E2BFA4A06A59C305D02D634EA.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "34018D4E2BFA4A06A59C305D02D634EA", request.getServletPath());    
     } else if (vars.commandIn("BUTTON34018D4E2BFA4A06A59C305D02D634EA")) {
        String strZssm_Productionorder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_Productionorder_V_ID", "");
        String strcloseproject = vars.getSessionValue("button34018D4E2BFA4A06A59C305D02D634EA.strcloseproject");
        String strProcessing = vars.getSessionValue("button34018D4E2BFA4A06A59C305D02D634EA.strProcessing");
        String strOrg = vars.getSessionValue("button34018D4E2BFA4A06A59C305D02D634EA.strOrg");
        String strClient = vars.getSessionValue("button34018D4E2BFA4A06A59C305D02D634EA.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCloseProject34018D4E2BFA4A06A59C305D02D634EA(response, vars, strZssm_Productionorder_V_ID, strcloseproject, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONChangeProjectStatus800002")) {
        String strZssm_Productionorder_V_ID = vars.getGlobalVariable("inpKey", windowId + "|Zssm_Productionorder_V_ID", "");
        @SuppressWarnings("unused")
        String strchangeprojectstatus = vars.getStringParameter("inpchangeprojectstatus");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "800002", (("Zssm_Productionorder_V_ID".equalsIgnoreCase("AD_Language"))?"0":strZssm_Productionorder_V_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          PInstanceProcessData.insertPInstanceParam(this, pinstance, "0", "ChangeProjectStatus", strchangeprojectstatus, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
    } else if (vars.commandIn("SAVE_BUTTONCloseProject34018D4E2BFA4A06A59C305D02D634EA")) {
        String strZssm_Productionorder_V_ID = vars.getGlobalVariable("inpKey", windowId + "|Zssm_Productionorder_V_ID", "");
        @SuppressWarnings("unused")
        String strcloseproject = vars.getStringParameter("inpcloseproject");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "34018D4E2BFA4A06A59C305D02D634EA", (("Zssm_Productionorder_V_ID".equalsIgnoreCase("AD_Language"))?"0":strZssm_Productionorder_V_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
  String deleteRelation(VariablesSecureApp vars, String strZssm_Productionorder_V_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strZssm_Productionorder_V_ID.startsWith("(")) strZssm_Productionorder_V_ID = strZssm_Productionorder_V_ID.substring(1, strZssm_Productionorder_V_ID.length()-1);
      if (!strZssm_Productionorder_V_ID.equals("")) {
        strZssm_Productionorder_V_ID = Replace.replace(strZssm_Productionorder_V_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strZssm_Productionorder_V_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.deleteTransactional(conn, this, strKey)==0) {
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
  private ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data data = new ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data();
    ServletException ex = null;
    try {
    data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.value = vars.getStringParameter("inpvalue");     data.name = vars.getStringParameter("inpname");     data.description = vars.getStringParameter("inpdescription");     data.note = vars.getStringParameter("inpnote");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.projectstatus = vars.getStringParameter("inpprojectstatus");     data.projectstatusr = vars.getStringParameter("inpprojectstatus_R");     data.startdate = vars.getStringParameter("inpstartdate");     data.datefinish = vars.getStringParameter("inpdatefinish");     data.mWarehouseId = vars.getRequestGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");     data.mWarehouseIdr = vars.getStringParameter("inpmWarehouseId_R");     data.responsibleId = vars.getStringParameter("inpresponsibleId");     data.responsibleIdr = vars.getStringParameter("inpresponsibleId_R");    try {   data.actualcostamount = vars.getNumericParameter("inpactualcostamount");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.machinecost = vars.getNumericParameter("inpmachinecost");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.materialcost = vars.getNumericParameter("inpmaterialcost");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.servcost = vars.getNumericParameter("inpservcost");  } catch (ServletException paramEx) { ex = paramEx; }     data.changeprojectstatus = vars.getStringParameter("inpchangeprojectstatus");     data.closeproject = vars.getStringParameter("inpcloseproject");     data.adUserId = vars.getStringParameter("inpadUserId");     data.mPricelistId = vars.getRequestGlobalVariable("inpmPricelistId", windowId + "|M_PriceList_ID");     data.cLocationId = vars.getStringParameter("inpcLocationId");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");    try {   data.expmargin = vars.getNumericParameter("inpexpmargin");  } catch (ServletException paramEx) { ex = paramEx; }     data.schedulestatus = vars.getStringParameter("inpschedulestatus");    try {   data.expenses = vars.getNumericParameter("inpexpenses");  } catch (ServletException paramEx) { ex = paramEx; }     data.copyfrom = vars.getStringParameter("inpcopyfrom");     data.cCurrencyId = vars.getRequestGlobalVariable("inpcCurrencyId", windowId + "|C_Currency_ID");     data.cProjecttypeId = vars.getStringParameter("inpcProjecttypeId");     data.lastplannedproposaldate = vars.getStringParameter("inplastplannedproposaldate");     data.paymentrule = vars.getStringParameter("inppaymentrule");    try {   data.projectbalanceamt = vars.getNumericParameter("inpprojectbalanceamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.projectkind = vars.getStringParameter("inpprojectkind");     data.generateorder = vars.getStringParameter("inpgenerateorder");     data.processing = vars.getStringParameter("inpprocessing");    try {   data.servrevenue = vars.getNumericParameter("inpservrevenue");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.documentCopies = vars.getNumericParameter("inpdocumentCopies");  } catch (ServletException paramEx) { ex = paramEx; }     data.processed = vars.getStringParameter("inpprocessed", "N");     data.poreference = vars.getStringParameter("inpporeference");     data.projectphase = vars.getStringParameter("inpprojectphase");     data.mPricelistVersionId = vars.getStringParameter("inpmPricelistVersionId");    try {   data.percentdoneyet = vars.getNumericParameter("inppercentdoneyet");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.invoicedqty = vars.getNumericParameter("inpinvoicedqty");  } catch (ServletException paramEx) { ex = paramEx; }     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.setprojecttype = vars.getStringParameter("inpsetprojecttype");     data.mProductId = vars.getStringParameter("inpmProductId");     data.projectcategory = vars.getRequestGlobalVariable("inpprojectcategory", windowId + "|ProjectCategory");    try {   data.qtyofproduct = vars.getNumericParameter("inpqtyofproduct");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.estimatedamt = vars.getNumericParameter("inpestimatedamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.accountno = vars.getStringParameter("inpaccountno");     data.cBpartnerLocationId = vars.getStringParameter("inpcBpartnerLocationId");     data.aAssetId = vars.getStringParameter("inpaAssetId");     data.cPaymenttermId = vars.getStringParameter("inpcPaymenttermId");     data.issummary = vars.getStringParameter("inpissummary", "N");    try {   data.committedamt = vars.getNumericParameter("inpcommittedamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.plannedqty = vars.getNumericParameter("inpplannedqty");  } catch (ServletException paramEx) { ex = paramEx; }     data.createtemppricelist = vars.getStringParameter("inpcreatetemppricelist", "N");    try {   data.indirectcost = vars.getNumericParameter("inpindirectcost");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.committedqty = vars.getNumericParameter("inpcommittedqty");  } catch (ServletException paramEx) { ex = paramEx; }     data.cBpartnerId = vars.getRequestGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");    try {   data.servmargin = vars.getNumericParameter("inpservmargin");  } catch (ServletException paramEx) { ex = paramEx; }     data.zssmProductionorderVId = vars.getRequestGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_Productionorder_V_ID");     data.datecontract = vars.getStringParameter("inpdatecontract");     data.billtoId = vars.getStringParameter("inpbilltoId");     data.generateto = vars.getStringParameter("inpgenerateto");    try {   data.plannedmarginamt = vars.getNumericParameter("inpplannedmarginamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.salesrepId = vars.getStringParameter("inpsalesrepId");    try {   data.plannedpoamt = vars.getNumericParameter("inpplannedpoamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.publicprivate = vars.getStringParameter("inppublicprivate");    try {   data.invoicedamt = vars.getNumericParameter("inpinvoicedamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.iscommitceiling = vars.getStringParameter("inpiscommitceiling", "N");    try {   data.expexpenses = vars.getNumericParameter("inpexpexpenses");  } catch (ServletException paramEx) { ex = paramEx; }     data.cCampaignId = vars.getStringParameter("inpcCampaignId");    try {   data.plannedamt = vars.getNumericParameter("inpplannedamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.expreinvoicing = vars.getNumericParameter("inpexpreinvoicing");  } catch (ServletException paramEx) { ex = paramEx; }     data.iscommitment = vars.getRequiredInputGlobalVariable("inpiscommitment", windowId + "|IsCommitment", "N");     data.reopenproject = vars.getStringParameter("inpreopenproject");     data.invoiceToproject = vars.getStringParameter("inpinvoiceToproject", "N"); 
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

   private ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[] getRelationData(ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].value = FormatUtilities.truncate(data[i].value, 44);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].note = FormatUtilities.truncate(data[i].note, 50);        data[i].projectstatus = FormatUtilities.truncate(data[i].projectstatus, 45);        data[i].mWarehouseId = FormatUtilities.truncate(data[i].mWarehouseId, 44);        data[i].responsibleId = FormatUtilities.truncate(data[i].responsibleId, 44);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 44);        data[i].mPricelistId = FormatUtilities.truncate(data[i].mPricelistId, 44);        data[i].cLocationId = FormatUtilities.truncate(data[i].cLocationId, 50);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].schedulestatus = FormatUtilities.truncate(data[i].schedulestatus, 50);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 44);        data[i].cProjecttypeId = FormatUtilities.truncate(data[i].cProjecttypeId, 44);        data[i].paymentrule = FormatUtilities.truncate(data[i].paymentrule, 21);        data[i].projectkind = FormatUtilities.truncate(data[i].projectkind, 50);        data[i].poreference = FormatUtilities.truncate(data[i].poreference, 20);        data[i].projectphase = FormatUtilities.truncate(data[i].projectphase, 21);        data[i].mPricelistVersionId = FormatUtilities.truncate(data[i].mPricelistVersionId, 44);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 0);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].projectcategory = FormatUtilities.truncate(data[i].projectcategory, 45);        data[i].accountno = FormatUtilities.truncate(data[i].accountno, 20);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 44);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, 32);        data[i].cPaymenttermId = FormatUtilities.truncate(data[i].cPaymenttermId, 44);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 44);        data[i].zssmProductionorderVId = FormatUtilities.truncate(data[i].zssmProductionorderVId, 32);        data[i].billtoId = FormatUtilities.truncate(data[i].billtoId, 44);        data[i].salesrepId = FormatUtilities.truncate(data[i].salesrepId, 44);        data[i].publicprivate = FormatUtilities.truncate(data[i].publicprivate, 50);        data[i].cCampaignId = FormatUtilities.truncate(data[i].cCampaignId, 44);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].getField("mWarehouseId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].getField("cCurrencyId"));    vars.setSessionValue(windowId + "|IsCommitment", data[0].getField("iscommitment"));    vars.setSessionValue(windowId + "|Zssm_Productionorder_V_ID", data[0].getField("zssmProductionorderVId"));    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].getField("cBpartnerId"));    vars.setSessionValue(windowId + "|ProjectCategory", data[0].getField("projectcategory"));    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].getField("mPricelistId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[] data = ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpzssmProductionorderVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strZssm_Productionorder_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamNote = vars.getSessionValue(tabId + "|paramNote");
String strParamIsActive = vars.getSessionValue(tabId + "|paramIsActive");
String strParamProjectStatus = vars.getSessionValue(tabId + "|paramProjectStatus");
String strParamStartdate = vars.getSessionValue(tabId + "|paramStartdate");
String strParamDateFinish = vars.getSessionValue(tabId + "|paramDateFinish");
String strParamResponsible_ID = vars.getSessionValue(tabId + "|paramResponsible_ID");
String strParamM_Warehouse_ID = vars.getSessionValue(tabId + "|paramM_Warehouse_ID");
String strParamStartdate_f = vars.getSessionValue(tabId + "|paramStartdate_f");
String strParamDateFinish_f = vars.getSessionValue(tabId + "|paramDateFinish_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamValue.equals("") && strParamName.equals("") && strParamDescription.equals("") && strParamNote.equals("") && strParamIsActive.equals("") && strParamProjectStatus.equals("") && strParamStartdate.equals("") && strParamDateFinish.equals("") && strParamResponsible_ID.equals("") && strParamM_Warehouse_ID.equals("") && strParamStartdate_f.equals("") && strParamDateFinish_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strZssm_Productionorder_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strZssm_Productionorder_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/serprod/ProductionOrder/ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71", false, "document.frmMain.inpzssmProductionorderVId", "grid", "../productionorders/print.html", "N".equals("Y"), "ProductionOrder", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "zssmProductionorderVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71_Relation.html", "ProductionOrder", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strZssm_Productionorder_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " zssm_productionorder_v.value";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamNote = vars.getSessionValue(tabId + "|paramNote");
String strParamIsActive = vars.getSessionValue(tabId + "|paramIsActive");
String strParamProjectStatus = vars.getSessionValue(tabId + "|paramProjectStatus");
String strParamStartdate = vars.getSessionValue(tabId + "|paramStartdate");
String strParamDateFinish = vars.getSessionValue(tabId + "|paramDateFinish");
String strParamResponsible_ID = vars.getSessionValue(tabId + "|paramResponsible_ID");
String strParamM_Warehouse_ID = vars.getSessionValue(tabId + "|paramM_Warehouse_ID");
String strParamStartdate_f = vars.getSessionValue(tabId + "|paramStartdate_f");
String strParamDateFinish_f = vars.getSessionValue(tabId + "|paramDateFinish_f");

    boolean hasSearchCondition=false;
    if (!(strParamValue.equals("") && strParamName.equals("") && strParamDescription.equals("") && strParamNote.equals("") && strParamIsActive.equals("") && strParamProjectStatus.equals("") && strParamStartdate.equals("") && strParamDateFinish.equals("") && strParamResponsible_ID.equals("") && strParamM_Warehouse_ID.equals("") && strParamStartdate_f.equals("") && strParamDateFinish_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strZssm_Productionorder_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strZssm_Productionorder_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("zssmProductionorderVId") == null || dataField.getField("zssmProductionorderVId").equals("")) {
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
        data = ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.set(Utility.getDefault(this, vars, "C_Location_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Expenses", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "GenerateOrder", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "N", dataField), Utility.getDefault(this, vars, "M_Warehouse_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Expmargin", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "C_Campaign_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "C_ProjectType_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "C_BPartner_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Name", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Servmargin", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Schedulestatus", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Projectphase", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "M_PriceList_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), "Y", Utility.getDefault(this, vars, "InvoicedQty", "0", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Responsible_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "IsCommitCeiling", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "N", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Indirectcost", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Reopenproject", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "N", dataField), ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.selectDefC04C197FCAB0495284A6BFFCDE5C0480(this, Utility.getContext(this, vars, "#ad_client_ID", windowId)), Utility.getDefault(this, vars, "Servrevenue", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "BillTo_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "LastPlannedProposalDate", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "ChangeProjectStatus", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "N", dataField), (vars.getLanguage().equals("en_US")?ListData.selectName(this, "800002", Utility.getDefault(this, vars, "ChangeProjectStatus", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "N", dataField)):ListData.selectNameTrl(this, vars.getLanguage(), "800002", Utility.getDefault(this, vars, "ChangeProjectStatus", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "N", dataField))), Utility.getDefault(this, vars, "ProjectStatus", "OP", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "GenerateTo", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "N", dataField), Utility.getDefault(this, vars, "Expexpenses", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "C_Project_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Machinecost", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Processed", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "N", dataField), Utility.getDefault(this, vars, "Actualcostamount", "0", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Description", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.selectDef8B5C2BB077454B65AAC32F77F9A73D76_0(this, Utility.getDefault(this, vars, "CreatedBy", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField)), Utility.getDefault(this, vars, "PlannedPOAmt", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "SalesRep_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "PlannedAmt", "0", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "AccountNo", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "InvoicedAmt", "0", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Publicprivate", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "AD_User_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Document_Copies", "1", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "CloseProject", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "N", dataField), Utility.getDefault(this, vars, "ProjectBalanceAmt", "0", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "DateContract", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "A_Asset_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "DateFinish", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "POReference", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Invoice_ToProject", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "N", dataField), Utility.getDefault(this, vars, "Expreinvoicing", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "IsCommitment", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "N", dataField), Utility.getDefault(this, vars, "PlannedQty", "0", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "C_PaymentTerm_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Startdate", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "CommittedQty", "0", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Projectkind", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.selectDef7EBCB8A1D65343F597BFAB1415EA0C74_1(this, Utility.getDefault(this, vars, "UpdatedBy", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField)), Utility.getDefault(this, vars, "Setprojecttype", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "N", dataField), Utility.getDefault(this, vars, "Materialcost", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Servcost", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Createtemppricelist", "N", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "N", dataField), Utility.getDefault(this, vars, "PaymentRule", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Percentdoneyet", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "PlannedMarginAmt", "0", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "ProjectCategory", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Qtyofproduct", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Value", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "Processing", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "N", dataField), Utility.getDefault(this, vars, "C_BPartner_Location_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "CopyFrom", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "N", dataField), Utility.getDefault(this, vars, "M_PriceList_Version_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "CommittedAmt", "0", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), "", Utility.getDefault(this, vars, "Estimatedamt", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField), Utility.getDefault(this, vars, "IsSummary", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "N", dataField), Utility.getDefault(this, vars, "Note", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "CF6D6BC0255A47DFBD4FF6F8BEBA0C71", "", dataField));
        
      }
    } else {
      data = new ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpzssmProductionorderVId", "", "../productionorders/print.html", "N".equals("Y"), "ProductionOrder", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strZssm_Productionorder_V_ID));
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
  
    void printPageButtonChangeProjectStatus800002(HttpServletResponse response, VariablesSecureApp vars, String strZssm_Productionorder_V_ID, String strchangeprojectstatus, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "800002",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "800002" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"800002" );
        String isDocAction=UtilsData.isProcessDocAction(this, "800002");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "32854A6CD107446F88172D884020C26E",strZssm_Productionorder_V_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "32854A6CD107446F88172D884020C26E", strZssm_Productionorder_V_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strchangeprojectstatus, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "800002");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONChangeProjectStatus" + "800002" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "800002");
        script.addHiddenfield("inpKey",strZssm_Productionorder_V_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("800002");
        vars.removeMessage("800002");
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
    void printPageButtonCloseProject34018D4E2BFA4A06A59C305D02D634EA(HttpServletResponse response, VariablesSecureApp vars, String strZssm_Productionorder_V_ID, String strcloseproject, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "34018D4E2BFA4A06A59C305D02D634EA",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "34018D4E2BFA4A06A59C305D02D634EA" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"34018D4E2BFA4A06A59C305D02D634EA" );
        String isDocAction=UtilsData.isProcessDocAction(this, "34018D4E2BFA4A06A59C305D02D634EA");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "32854A6CD107446F88172D884020C26E",strZssm_Productionorder_V_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "32854A6CD107446F88172D884020C26E", strZssm_Productionorder_V_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strcloseproject, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "34018D4E2BFA4A06A59C305D02D634EA");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONCloseProject" + "34018D4E2BFA4A06A59C305D02D634EA" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "34018D4E2BFA4A06A59C305D02D634EA");
        script.addHiddenfield("inpKey",strZssm_Productionorder_V_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("34018D4E2BFA4A06A59C305D02D634EA");
        vars.removeMessage("34018D4E2BFA4A06A59C305D02D634EA");
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
    ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data data = null;
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
                data.zssmProductionorderVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.getCurrentDBTimestamp(this, data.zssmProductionorderVId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.zssmProductionorderVId, vars, this);
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
                    data.zssmProductionorderVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Zssm_Productionorder_V_ID", data.zssmProductionorderVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
