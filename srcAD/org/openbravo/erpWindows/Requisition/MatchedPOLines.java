
package org.openbravo.erpWindows.Requisition;





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

public class MatchedPOLines extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(MatchedPOLines.class);
  
  private static final String windowId = "800092";
  private static final String tabId = "1004400000";
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
        String strmRequisitionorderId = request.getParameter("inpmRequisitionorderId");
         String strPM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strmRequisitionorderId.equals(""))
              total = saveRecord(vars, myError, 'U', strPM_Requisitionline_ID);
          else
              total = saveRecord(vars, myError, 'I', strPM_Requisitionline_ID);
          
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
      String strPM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID", "");

      String strM_Requisitionorder_ID = vars.getGlobalVariable("inpmRequisitionorderId", windowId + "|M_Requisitionorder_ID", "");
            if (strPM_Requisitionline_ID.equals("")) {
        strPM_Requisitionline_ID = getParentID(vars, strM_Requisitionorder_ID);
        if (strPM_Requisitionline_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|M_Requisitionline_ID");
        vars.setSessionValue(windowId + "|M_Requisitionline_ID", strPM_Requisitionline_ID);
      vars.removeSessionValue(windowId + "|M_Requisition_ID");
        refreshParentSession(vars, strPM_Requisitionline_ID);
      }


      String strView = vars.getSessionValue(tabId + "|MatchedPOLines.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strM_Requisitionorder_ID.equals("")) strM_Requisitionorder_ID = firstElement(vars, tableSQL);
          if (strM_Requisitionorder_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strM_Requisitionorder_ID, strPM_Requisitionline_ID, tableSQL);

      else printPageDataSheet(response, vars, strPM_Requisitionline_ID, strM_Requisitionorder_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strM_Requisitionorder_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strM_Requisitionorder_ID.equals("")) strM_Requisitionorder_ID = vars.getRequiredGlobalVariable("inpmRequisitionorderId", windowId + "|M_Requisitionorder_ID");
      else vars.setSessionValue(windowId + "|M_Requisitionorder_ID", strM_Requisitionorder_ID);
      
      
      String strPM_Requisitionline_ID = getParentID(vars, strM_Requisitionorder_ID);
      
      vars.setSessionValue(windowId + "|M_Requisitionline_ID", strPM_Requisitionline_ID);
      vars.setSessionValue("800251|Lines.view", "EDIT");
      vars.removeSessionValue(windowId + "|M_Requisition_ID");
      refreshParentSession(vars, strPM_Requisitionline_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|MatchedPOLines.view", "EDIT");

        printPageEdit(response, request, vars, false, strM_Requisitionorder_ID, strPM_Requisitionline_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|MatchedPOLines.view", "RELATION");
        printPageDataSheet(response, vars, strPM_Requisitionline_ID, strM_Requisitionorder_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|M_Requisitionorder_ID");
      refreshParentSession(vars, strPM_Requisitionline_ID);


      String strView = vars.getSessionValue(tabId + "|MatchedPOLines.view");
      String strM_Requisitionorder_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strM_Requisitionorder_ID = firstElement(vars, tableSQL);
          if (strM_Requisitionorder_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strM_Requisitionorder_ID.equals("")) strM_Requisitionorder_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strM_Requisitionorder_ID, strPM_Requisitionline_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPM_Requisitionline_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamM_Requisitionline_ID", tabId + "|paramM_Requisitionline_ID");
vars.getRequestGlobalVariable("inpParamC_OrderLine_ID", tabId + "|paramC_OrderLine_ID");

            String strPM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");

      
      vars.removeSessionValue(windowId + "|M_Requisitionorder_ID");
      String strM_Requisitionorder_ID="";

      String strView = vars.getSessionValue(tabId + "|MatchedPOLines.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strM_Requisitionorder_ID = firstElement(vars, tableSQL);
        if (strM_Requisitionorder_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|MatchedPOLines.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strM_Requisitionorder_ID, strPM_Requisitionline_ID, tableSQL);

      else printPageDataSheet(response, vars, strPM_Requisitionline_ID, strM_Requisitionorder_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");
      

      String strM_Requisitionorder_ID = vars.getGlobalVariable("inpmRequisitionorderId", windowId + "|M_Requisitionorder_ID", "");
      vars.setSessionValue(tabId + "|MatchedPOLines.view", "RELATION");
      printPageDataSheet(response, vars, strPM_Requisitionline_ID, strM_Requisitionorder_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");


      printPageEdit(response, request, vars, true, "", strPM_Requisitionline_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strM_Requisitionorder_ID = vars.getGlobalVariable("inpmRequisitionorderId", windowId + "|M_Requisitionorder_ID", "");
      vars.setSessionValue(tabId + "|MatchedPOLines.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strM_Requisitionorder_ID, strPM_Requisitionline_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");
      String strM_Requisitionorder_ID = vars.getRequiredStringParameter("inpmRequisitionorderId");
      
      String strNext = nextElement(vars, strM_Requisitionorder_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPM_Requisitionline_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");
      String strM_Requisitionorder_ID = vars.getRequiredStringParameter("inpmRequisitionorderId");
      
      String strPrevious = previousElement(vars, strM_Requisitionorder_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPM_Requisitionline_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");

      vars.setSessionValue(tabId + "|MatchedPOLines.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|MatchedPOLines.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|MatchedPOLines.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|MatchedPOLines.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|M_Requisitionorder_ID");
      vars.setSessionValue(windowId + "|M_Requisitionline_ID", strPM_Requisitionline_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|MatchedPOLines.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|MatchedPOLines.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|M_Requisitionorder_ID");
      vars.setSessionValue(windowId + "|M_Requisitionline_ID", strPM_Requisitionline_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPM_Requisitionline_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPM_Requisitionline_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPM_Requisitionline_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPM_Requisitionline_ID);      
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
      String strPM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");
      String strM_Requisitionorder_ID = vars.getRequiredGlobalVariable("inpmRequisitionorderId", windowId + "|M_Requisitionorder_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPM_Requisitionline_ID);      
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
          String strNext = nextElement(vars, strM_Requisitionorder_ID, tableSQL);
          vars.setSessionValue(windowId + "|M_Requisitionorder_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");

      String strM_Requisitionorder_ID = vars.getRequiredInStringParameter("inpmRequisitionorderId");
      String message = deleteRelation(vars, strM_Requisitionorder_ID, strPM_Requisitionline_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|mRequisitionorderId");
        vars.setSessionValue(tabId + "|MatchedPOLines.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");

      String strM_Requisitionorder_ID = vars.getRequiredStringParameter("inpmRequisitionorderId");
      //MatchedPOLinesData data = getEditVariables(vars, strPM_Requisitionline_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = MatchedPOLinesData.delete(this, strM_Requisitionorder_ID, strPM_Requisitionline_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|mRequisitionorderId");
        vars.setSessionValue(tabId + "|MatchedPOLines.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strM_Requisitionorder_ID, String strPM_Requisitionline_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strM_Requisitionorder_ID.startsWith("(")) strM_Requisitionorder_ID = strM_Requisitionorder_ID.substring(1, strM_Requisitionorder_ID.length()-1);
      if (!strM_Requisitionorder_ID.equals("")) {
        strM_Requisitionorder_ID = Replace.replace(strM_Requisitionorder_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strM_Requisitionorder_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (MatchedPOLinesData.deleteTransactional(conn, this, strKey, strPM_Requisitionline_ID)==0) {
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
  private MatchedPOLinesData getEditVariables(Connection con, VariablesSecureApp vars, String strPM_Requisitionline_ID) throws IOException,ServletException {
    MatchedPOLinesData data = new MatchedPOLinesData();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.mRequisitionorderId = vars.getRequestGlobalVariable("inpmRequisitionorderId", windowId + "|M_Requisitionorder_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.mRequisitionlineId = vars.getStringParameter("inpmRequisitionlineId");     data.mRequisitionlineIdr = vars.getStringParameter("inpmRequisitionlineId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.cOrderlineId = vars.getStringParameter("inpcOrderlineId");     data.cOrderlineIdr = vars.getStringParameter("inpcOrderlineId_R");    try {   data.qty = vars.getNumericParameter("inpqty");  } catch (ServletException paramEx) { ex = paramEx; } 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.mRequisitionlineId = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");


          vars.getGlobalVariable("inpmProductId", windowId + "|M_PRODUCT_ID", "");
          vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPARTNER_ID", "");
    
    

    
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

   private MatchedPOLinesData[] getRelationData(MatchedPOLinesData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 12);        data[i].mRequisitionorderId = FormatUtilities.truncate(data[i].mRequisitionorderId, 12);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 12);        data[i].mRequisitionlineId = FormatUtilities.truncate(data[i].mRequisitionlineId, 40);        data[i].cOrderlineId = FormatUtilities.truncate(data[i].cOrderlineId, 40);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPM_Requisitionline_ID) throws IOException,ServletException {
      LinesData[] data = LinesData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getSessionValue(windowId + "|M_Requisition_ID"), strPM_Requisitionline_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|M_Requisitionline_ID", data[0].mRequisitionlineId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|M_Product_ID", data[0].mProductId);
      vars.setSessionValue(windowId + "|M_Requisitionline_ID", strPM_Requisitionline_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
      vars.setSessionValue(windowId + "|HASSECONDUOM", LinesData.selectAux1004400000(this, Utility.getContext(this, vars, "M_Product_ID", "800092")));
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strM_Requisitionorder_ID) throws ServletException {
    String strPM_Requisitionline_ID = MatchedPOLinesData.selectParentID(this, strM_Requisitionorder_ID);
    if (strPM_Requisitionline_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strM_Requisitionorder_ID);
      throw new ServletException("Parent record not found");
    }
    return strPM_Requisitionline_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|M_Requisitionorder_ID", data[0].getField("mRequisitionorderId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPM_Requisitionline_ID) throws IOException,ServletException {
      MatchedPOLinesData[] data = MatchedPOLinesData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Requisitionline_ID, vars.getStringParameter("inpmRequisitionorderId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPM_Requisitionline_ID, String strM_Requisitionorder_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamM_Requisitionline_ID = vars.getSessionValue(tabId + "|paramM_Requisitionline_ID");
String strParamC_OrderLine_ID = vars.getSessionValue(tabId + "|paramC_OrderLine_ID");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamM_Requisitionline_ID.equals("") && strParamC_OrderLine_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strM_Requisitionorder_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strM_Requisitionorder_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/Requisition/MatchedPOLines_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "MatchedPOLines", false, "document.frmMain.inpmRequisitionorderId", "grid", "..", "".equals("Y"), "Requisition", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), true, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPM_Requisitionline_ID);

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
    xmlDocument.setParameter("KeyName", "mRequisitionorderId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "MatchedPOLines_Relation.html", "Requisition", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "MatchedPOLines_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", MatchedPOLinesData.selectParent(this, vars.getLanguage(), strPM_Requisitionline_ID));
    else xmlDocument.setParameter("parent", MatchedPOLinesData.selectParentTrl(this, vars.getLanguage(), strPM_Requisitionline_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strM_Requisitionorder_ID, String strPM_Requisitionline_ID, TableSQLData tableSQL)
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
    MatchedPOLinesData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamM_Requisitionline_ID = vars.getSessionValue(tabId + "|paramM_Requisitionline_ID");
String strParamC_OrderLine_ID = vars.getSessionValue(tabId + "|paramC_OrderLine_ID");

    boolean hasSearchCondition=false;
    if (!(strParamM_Requisitionline_ID.equals("") && strParamC_OrderLine_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = MatchedPOLinesData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Requisitionline_ID, strM_Requisitionorder_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strM_Requisitionorder_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (data==null || data.length==0) {
        strM_Requisitionorder_ID = firstElement(vars, tableSQL);
        if (strM_Requisitionorder_ID.equals("")) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        } else {
          data = MatchedPOLinesData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Requisitionline_ID, strM_Requisitionorder_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
        }
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new MatchedPOLinesData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("mRequisitionorderId") == null || dataField.getField("mRequisitionorderId").equals("")) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        boolNew = true;
      } else {
        discard[0] = new String ("newDiscard");
        strCommand = "EDIT";
      }
    }
    
        String strM_PRODUCT_ID = Utility.getContext(this, vars, "M_PRODUCT_ID", "800092");
    vars.setSessionValue(windowId + "|M_PRODUCT_ID", strM_PRODUCT_ID);
        String strC_BPARTNER_ID = MatchedPOLinesData.selectAux1004400002(this, strPM_Requisitionline_ID);
    vars.setSessionValue(windowId + "|C_BPARTNER_ID", strC_BPARTNER_ID);
    
    
    if (dataField==null) {
      if (boolNew || data==null || data.length==0) {
        refreshSessionNew(vars, strPM_Requisitionline_ID);
        data = MatchedPOLinesData.set(strPM_Requisitionline_ID, Utility.getDefault(this, vars, "C_OrderLine_ID", "", "800092", "1004400000", "", dataField), MatchedPOLinesData.selectDef1004400015_0(this, Utility.getDefault(this, vars, "C_OrderLine_ID", "", "800092", "1004400000", "", dataField)), Utility.getDefault(this, vars, "Qty", "0", "800092", "1004400000", "", dataField), "Y", Utility.getDefault(this, vars, "Updatedby", "", "800092", "1004400000", "", dataField), MatchedPOLinesData.selectDef1004400012_1(this, Utility.getDefault(this, vars, "Updatedby", "", "800092", "1004400000", "", dataField)), Utility.getDefault(this, vars, "Createdby", "", "800092", "1004400000", "", dataField), MatchedPOLinesData.selectDef1004400010_2(this, Utility.getDefault(this, vars, "Createdby", "", "800092", "1004400000", "", dataField)), "", Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "800092", "1004400000", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "800092", "1004400000", "", dataField));
        
      }
    } else {
      data = new MatchedPOLinesData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(MatchedPOLinesData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=LinesData.selectOrg(this, strPM_Requisitionline_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "MatchedPOLines", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpmRequisitionorderId", "", "..", "".equals("Y"), "Requisition", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strM_Requisitionorder_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPM_Requisitionline_ID) throws IOException, ServletException {
    MatchedPOLinesData data = null;
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
            data = getEditVariables(con, vars, strPM_Requisitionline_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.mRequisitionorderId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (MatchedPOLinesData.getCurrentDBTimestamp(this, data.mRequisitionorderId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.mRequisitionorderId, vars, this);
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
                    data.mRequisitionorderId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|M_Requisitionorder_ID", data.mRequisitionorderId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet MatchedPOLines. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
