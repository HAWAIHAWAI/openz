
package org.openbravo.erpWindows.org.openbravo.zsoft.mrp.PlanningMethod;





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

public class Lines800253 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Lines800253.class);
  
  private static final String windowId = "800094";
  private static final String tabId = "800253";
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
        String strmrpPlanningmethodlineId = request.getParameter("inpmrpPlanningmethodlineId");
         String strPMRP_Planningmethod_ID = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strmrpPlanningmethodlineId.equals(""))
              total = saveRecord(vars, myError, 'U', strPMRP_Planningmethod_ID);
          else
              total = saveRecord(vars, myError, 'I', strPMRP_Planningmethod_ID);
          
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
      String strPMRP_Planningmethod_ID = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID", "");

      String strMRP_Planningmethodline_ID = vars.getGlobalVariable("inpmrpPlanningmethodlineId", windowId + "|MRP_Planningmethodline_ID", "");
            if (strPMRP_Planningmethod_ID.equals("")) {
        strPMRP_Planningmethod_ID = getParentID(vars, strMRP_Planningmethodline_ID);
        if (strPMRP_Planningmethod_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|MRP_Planningmethod_ID");
        vars.setSessionValue(windowId + "|MRP_Planningmethod_ID", strPMRP_Planningmethod_ID);

        refreshParentSession(vars, strPMRP_Planningmethod_ID);
      }


      String strView = vars.getSessionValue(tabId + "|Lines800253.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strMRP_Planningmethodline_ID.equals("")) strMRP_Planningmethodline_ID = firstElement(vars, tableSQL);
          if (strMRP_Planningmethodline_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strMRP_Planningmethodline_ID, strPMRP_Planningmethod_ID, tableSQL);

      else printPageDataSheet(response, vars, strPMRP_Planningmethod_ID, strMRP_Planningmethodline_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strMRP_Planningmethodline_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strMRP_Planningmethodline_ID.equals("")) strMRP_Planningmethodline_ID = vars.getRequiredGlobalVariable("inpmrpPlanningmethodlineId", windowId + "|MRP_Planningmethodline_ID");
      else vars.setSessionValue(windowId + "|MRP_Planningmethodline_ID", strMRP_Planningmethodline_ID);
      
      
      String strPMRP_Planningmethod_ID = getParentID(vars, strMRP_Planningmethodline_ID);
      
      vars.setSessionValue(windowId + "|MRP_Planningmethod_ID", strPMRP_Planningmethod_ID);
      vars.setSessionValue("800252|Header.view", "EDIT");

      refreshParentSession(vars, strPMRP_Planningmethod_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Lines800253.view", "EDIT");

        printPageEdit(response, request, vars, false, strMRP_Planningmethodline_ID, strPMRP_Planningmethod_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Lines800253.view", "RELATION");
        printPageDataSheet(response, vars, strPMRP_Planningmethod_ID, strMRP_Planningmethodline_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPMRP_Planningmethod_ID = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|MRP_Planningmethodline_ID");
      refreshParentSession(vars, strPMRP_Planningmethod_ID);


      String strView = vars.getSessionValue(tabId + "|Lines800253.view");
      String strMRP_Planningmethodline_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strMRP_Planningmethodline_ID = firstElement(vars, tableSQL);
          if (strMRP_Planningmethodline_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strMRP_Planningmethodline_ID.equals("")) strMRP_Planningmethodline_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strMRP_Planningmethodline_ID, strPMRP_Planningmethod_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPMRP_Planningmethod_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamMRP_Planningmethod_ID", tabId + "|paramMRP_Planningmethod_ID");
vars.getRequestGlobalVariable("inpParamInouttrxtype", tabId + "|paramInouttrxtype");
vars.getRequestGlobalVariable("inpParamDaysfrom", tabId + "|paramDaysfrom");
vars.getRequestGlobalVariable("inpParamDaysto", tabId + "|paramDaysto");
vars.getRequestGlobalVariable("inpParamDaysfrom_f", tabId + "|paramDaysfrom_f");
vars.getRequestGlobalVariable("inpParamDaysto_f", tabId + "|paramDaysto_f");

            String strPMRP_Planningmethod_ID = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID");

      
      vars.removeSessionValue(windowId + "|MRP_Planningmethodline_ID");
      String strMRP_Planningmethodline_ID="";

      String strView = vars.getSessionValue(tabId + "|Lines800253.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strMRP_Planningmethodline_ID = firstElement(vars, tableSQL);
        if (strMRP_Planningmethodline_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Lines800253.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strMRP_Planningmethodline_ID, strPMRP_Planningmethod_ID, tableSQL);

      else printPageDataSheet(response, vars, strPMRP_Planningmethod_ID, strMRP_Planningmethodline_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPMRP_Planningmethod_ID = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID");
      

      String strMRP_Planningmethodline_ID = vars.getGlobalVariable("inpmrpPlanningmethodlineId", windowId + "|MRP_Planningmethodline_ID", "");
      vars.setSessionValue(tabId + "|Lines800253.view", "RELATION");
      printPageDataSheet(response, vars, strPMRP_Planningmethod_ID, strMRP_Planningmethodline_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPMRP_Planningmethod_ID = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID");


      printPageEdit(response, request, vars, true, "", strPMRP_Planningmethod_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPMRP_Planningmethod_ID = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strMRP_Planningmethodline_ID = vars.getGlobalVariable("inpmrpPlanningmethodlineId", windowId + "|MRP_Planningmethodline_ID", "");
      vars.setSessionValue(tabId + "|Lines800253.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strMRP_Planningmethodline_ID, strPMRP_Planningmethod_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPMRP_Planningmethod_ID = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID");
      String strMRP_Planningmethodline_ID = vars.getRequiredStringParameter("inpmrpPlanningmethodlineId");
      
      String strNext = nextElement(vars, strMRP_Planningmethodline_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPMRP_Planningmethod_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPMRP_Planningmethod_ID = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID");
      String strMRP_Planningmethodline_ID = vars.getRequiredStringParameter("inpmrpPlanningmethodlineId");
      
      String strPrevious = previousElement(vars, strMRP_Planningmethodline_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPMRP_Planningmethod_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID");

      vars.setSessionValue(tabId + "|Lines800253.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPMRP_Planningmethod_ID = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Lines800253.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Lines800253.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Lines800253.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|MRP_Planningmethodline_ID");
      vars.setSessionValue(windowId + "|MRP_Planningmethod_ID", strPMRP_Planningmethod_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPMRP_Planningmethod_ID = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Lines800253.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Lines800253.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|MRP_Planningmethodline_ID");
      vars.setSessionValue(windowId + "|MRP_Planningmethod_ID", strPMRP_Planningmethod_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPMRP_Planningmethod_ID = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPMRP_Planningmethod_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPMRP_Planningmethod_ID = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPMRP_Planningmethod_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPMRP_Planningmethod_ID = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPMRP_Planningmethod_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPMRP_Planningmethod_ID = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPMRP_Planningmethod_ID);      
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
      String strPMRP_Planningmethod_ID = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID");
      String strMRP_Planningmethodline_ID = vars.getRequiredGlobalVariable("inpmrpPlanningmethodlineId", windowId + "|MRP_Planningmethodline_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPMRP_Planningmethod_ID);      
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
          String strNext = nextElement(vars, strMRP_Planningmethodline_ID, tableSQL);
          vars.setSessionValue(windowId + "|MRP_Planningmethodline_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPMRP_Planningmethod_ID = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID");

      String strMRP_Planningmethodline_ID = vars.getRequiredInStringParameter("inpmrpPlanningmethodlineId");
      String message = deleteRelation(vars, strMRP_Planningmethodline_ID, strPMRP_Planningmethod_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|mrpPlanningmethodlineId");
        vars.setSessionValue(tabId + "|Lines800253.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPMRP_Planningmethod_ID = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID");

      String strMRP_Planningmethodline_ID = vars.getRequiredStringParameter("inpmrpPlanningmethodlineId");
      //Lines800253Data data = getEditVariables(vars, strPMRP_Planningmethod_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = Lines800253Data.delete(this, strMRP_Planningmethodline_ID, strPMRP_Planningmethod_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|mrpPlanningmethodlineId");
        vars.setSessionValue(tabId + "|Lines800253.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strMRP_Planningmethodline_ID, String strPMRP_Planningmethod_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strMRP_Planningmethodline_ID.startsWith("(")) strMRP_Planningmethodline_ID = strMRP_Planningmethodline_ID.substring(1, strMRP_Planningmethodline_ID.length()-1);
      if (!strMRP_Planningmethodline_ID.equals("")) {
        strMRP_Planningmethodline_ID = Replace.replace(strMRP_Planningmethodline_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strMRP_Planningmethodline_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (Lines800253Data.deleteTransactional(conn, this, strKey, strPMRP_Planningmethod_ID)==0) {
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
  private Lines800253Data getEditVariables(Connection con, VariablesSecureApp vars, String strPMRP_Planningmethod_ID) throws IOException,ServletException {
    Lines800253Data data = new Lines800253Data();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.mrpPlanningmethodlineId = vars.getRequestGlobalVariable("inpmrpPlanningmethodlineId", windowId + "|MRP_Planningmethodline_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.mrpPlanningmethodId = vars.getStringParameter("inpmrpPlanningmethodId");     data.mrpPlanningmethodIdr = vars.getStringParameter("inpmrpPlanningmethodId_R");    try {   data.line = vars.getNumericParameter("inpline");  } catch (ServletException paramEx) { ex = paramEx; }     data.isactive = vars.getStringParameter("inpisactive", "N");     data.inouttrxtype = vars.getStringParameter("inpinouttrxtype");     data.inouttrxtyper = vars.getStringParameter("inpinouttrxtype_R");    try {   data.weighting = vars.getNumericParameter("inpweighting");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.daysfrom = vars.getNumericParameter("inpdaysfrom");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.daysto = vars.getNumericParameter("inpdaysto");  } catch (ServletException paramEx) { ex = paramEx; } 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.mrpPlanningmethodId = vars.getGlobalVariable("inpmrpPlanningmethodId", windowId + "|MRP_Planningmethod_ID");


    
    

    
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

   private Lines800253Data[] getRelationData(Lines800253Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].mrpPlanningmethodlineId = FormatUtilities.truncate(data[i].mrpPlanningmethodlineId, 10);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].mrpPlanningmethodId = FormatUtilities.truncate(data[i].mrpPlanningmethodId, 44);        data[i].inouttrxtype = FormatUtilities.truncate(data[i].inouttrxtype, 44);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPMRP_Planningmethod_ID) throws IOException,ServletException {
      Header800252Data[] data = Header800252Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPMRP_Planningmethod_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|MRP_Planningmethod_ID", data[0].mrpPlanningmethodId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);
      vars.setSessionValue(windowId + "|MRP_Planningmethod_ID", strPMRP_Planningmethod_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strMRP_Planningmethodline_ID) throws ServletException {
    String strPMRP_Planningmethod_ID = Lines800253Data.selectParentID(this, strMRP_Planningmethodline_ID);
    if (strPMRP_Planningmethod_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strMRP_Planningmethodline_ID);
      throw new ServletException("Parent record not found");
    }
    return strPMRP_Planningmethod_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|MRP_Planningmethodline_ID", data[0].getField("mrpPlanningmethodlineId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPMRP_Planningmethod_ID) throws IOException,ServletException {
      Lines800253Data[] data = Lines800253Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPMRP_Planningmethod_ID, vars.getStringParameter("inpmrpPlanningmethodlineId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPMRP_Planningmethod_ID, String strMRP_Planningmethodline_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamMRP_Planningmethod_ID = vars.getSessionValue(tabId + "|paramMRP_Planningmethod_ID");
String strParamInouttrxtype = vars.getSessionValue(tabId + "|paramInouttrxtype");
String strParamDaysfrom = vars.getSessionValue(tabId + "|paramDaysfrom");
String strParamDaysto = vars.getSessionValue(tabId + "|paramDaysto");
String strParamDaysfrom_f = vars.getSessionValue(tabId + "|paramDaysfrom_f");
String strParamDaysto_f = vars.getSessionValue(tabId + "|paramDaysto_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamMRP_Planningmethod_ID.equals("") && strParamInouttrxtype.equals("") && strParamDaysfrom.equals("") && strParamDaysto.equals("") && strParamDaysfrom_f.equals("") && strParamDaysto_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strMRP_Planningmethodline_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strMRP_Planningmethodline_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/mrp/PlanningMethod/Lines800253_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Lines800253", false, "document.frmMain.inpmrpPlanningmethodlineId", "grid", "..", "".equals("Y"), "PlanningMethod", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPMRP_Planningmethod_ID);

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
    xmlDocument.setParameter("KeyName", "mrpPlanningmethodlineId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Lines800253_Relation.html", "PlanningMethod", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Lines800253_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", Lines800253Data.selectParent(this, strPMRP_Planningmethod_ID));
    else xmlDocument.setParameter("parent", Lines800253Data.selectParentTrl(this, strPMRP_Planningmethod_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strMRP_Planningmethodline_ID, String strPMRP_Planningmethod_ID, TableSQLData tableSQL)
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
    Lines800253Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamMRP_Planningmethod_ID = vars.getSessionValue(tabId + "|paramMRP_Planningmethod_ID");
String strParamInouttrxtype = vars.getSessionValue(tabId + "|paramInouttrxtype");
String strParamDaysfrom = vars.getSessionValue(tabId + "|paramDaysfrom");
String strParamDaysto = vars.getSessionValue(tabId + "|paramDaysto");
String strParamDaysfrom_f = vars.getSessionValue(tabId + "|paramDaysfrom_f");
String strParamDaysto_f = vars.getSessionValue(tabId + "|paramDaysto_f");

    boolean hasSearchCondition=false;
    if (!(strParamMRP_Planningmethod_ID.equals("") && strParamInouttrxtype.equals("") && strParamDaysfrom.equals("") && strParamDaysto.equals("") && strParamDaysfrom_f.equals("") && strParamDaysto_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = Lines800253Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPMRP_Planningmethod_ID, strMRP_Planningmethodline_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strMRP_Planningmethodline_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new Lines800253Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("mrpPlanningmethodlineId") == null || dataField.getField("mrpPlanningmethodlineId").equals("")) {
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
        refreshSessionNew(vars, strPMRP_Planningmethod_ID);
        data = Lines800253Data.set(strPMRP_Planningmethod_ID, "", Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "800094", "800253", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "800094", "800253", "", dataField), Lines800253Data.selectDef803574_0(this, Utility.getDefault(this, vars, "Createdby", "", "800094", "800253", "", dataField)), Utility.getDefault(this, vars, "Daysto", "", "800094", "800253", "", dataField), Utility.getDefault(this, vars, "Inouttrxtype", "", "800094", "800253", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "800094", "800253", "", dataField), Lines800253Data.selectDef803576_1(this, Utility.getDefault(this, vars, "Updatedby", "", "800094", "800253", "", dataField)), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "800094", "800253", "", dataField), Utility.getDefault(this, vars, "Weighting", "1", "800094", "800253", "", dataField), Lines800253Data.selectDef803578(this, Utility.getContext(this, vars, "MRP_Planningmethodline_ID", "800094")), "Y", Utility.getDefault(this, vars, "Daysfrom", "", "800094", "800253", "", dataField));
        
      }
    } else {
      data = new Lines800253Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(Lines800253Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=Header800252Data.selectOrg(this, strPMRP_Planningmethod_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Lines800253", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpmrpPlanningmethodlineId", "", "..", "".equals("Y"), "PlanningMethod", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strMRP_Planningmethodline_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPMRP_Planningmethod_ID) throws IOException, ServletException {
    Lines800253Data data = null;
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
            data = getEditVariables(con, vars, strPMRP_Planningmethod_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.mrpPlanningmethodlineId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (Lines800253Data.getCurrentDBTimestamp(this, data.mrpPlanningmethodlineId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.mrpPlanningmethodlineId, vars, this);
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
                    data.mrpPlanningmethodlineId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|MRP_Planningmethodline_ID", data.mrpPlanningmethodlineId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Lines800253. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
