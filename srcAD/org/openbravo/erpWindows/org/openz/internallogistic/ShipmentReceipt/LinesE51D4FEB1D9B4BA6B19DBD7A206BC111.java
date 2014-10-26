
package org.openbravo.erpWindows.org.openz.internallogistic.ShipmentReceipt;





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

public class LinesE51D4FEB1D9B4BA6B19DBD7A206BC111 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(LinesE51D4FEB1D9B4BA6B19DBD7A206BC111.class);
  
  private static final String windowId = "C1E552E422A54C8AB7AF8F6625AB75F6";
  private static final String tabId = "E51D4FEB1D9B4BA6B19DBD7A206BC111";
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
        String strilsInoutlineVId = request.getParameter("inpilsInoutlineVId");
         String strPILS_Inout_V_ID = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strilsInoutlineVId.equals(""))
              total = saveRecord(vars, myError, 'U', strPILS_Inout_V_ID);
          else
              total = saveRecord(vars, myError, 'I', strPILS_Inout_V_ID);
          
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
      String strPILS_Inout_V_ID = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID", "");

      String strILS_Inoutline_V_ID = vars.getGlobalVariable("inpilsInoutlineVId", windowId + "|ILS_Inoutline_V_ID", "");
            if (strPILS_Inout_V_ID.equals("")) {
        strPILS_Inout_V_ID = getParentID(vars, strILS_Inoutline_V_ID);
        if (strPILS_Inout_V_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|ILS_Inout_V_ID");
        vars.setSessionValue(windowId + "|ILS_Inout_V_ID", strPILS_Inout_V_ID);

        refreshParentSession(vars, strPILS_Inout_V_ID);
      }


      String strView = vars.getSessionValue(tabId + "|LinesE51D4FEB1D9B4BA6B19DBD7A206BC111.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strILS_Inoutline_V_ID.equals("")) strILS_Inoutline_V_ID = firstElement(vars, tableSQL);
          if (strILS_Inoutline_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strILS_Inoutline_V_ID, strPILS_Inout_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strPILS_Inout_V_ID, strILS_Inoutline_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strILS_Inoutline_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strILS_Inoutline_V_ID.equals("")) strILS_Inoutline_V_ID = vars.getRequiredGlobalVariable("inpilsInoutlineVId", windowId + "|ILS_Inoutline_V_ID");
      else vars.setSessionValue(windowId + "|ILS_Inoutline_V_ID", strILS_Inoutline_V_ID);
      
      
      String strPILS_Inout_V_ID = getParentID(vars, strILS_Inoutline_V_ID);
      
      vars.setSessionValue(windowId + "|ILS_Inout_V_ID", strPILS_Inout_V_ID);
      vars.setSessionValue("E84FBB2BD89E44ED92B252F674DB3DFC|Shipment Receipt.view", "EDIT");

      refreshParentSession(vars, strPILS_Inout_V_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|LinesE51D4FEB1D9B4BA6B19DBD7A206BC111.view", "EDIT");

        printPageEdit(response, request, vars, false, strILS_Inoutline_V_ID, strPILS_Inout_V_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|LinesE51D4FEB1D9B4BA6B19DBD7A206BC111.view", "RELATION");
        printPageDataSheet(response, vars, strPILS_Inout_V_ID, strILS_Inoutline_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPILS_Inout_V_ID = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|ILS_Inoutline_V_ID");
      refreshParentSession(vars, strPILS_Inout_V_ID);


      String strView = vars.getSessionValue(tabId + "|LinesE51D4FEB1D9B4BA6B19DBD7A206BC111.view");
      String strILS_Inoutline_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strILS_Inoutline_V_ID = firstElement(vars, tableSQL);
          if (strILS_Inoutline_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strILS_Inoutline_V_ID.equals("")) strILS_Inoutline_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strILS_Inoutline_V_ID, strPILS_Inout_V_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPILS_Inout_V_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamLine", tabId + "|paramLine");
vars.getRequestGlobalVariable("inpParamM_Product_ID", tabId + "|paramM_Product_ID");
vars.getRequestGlobalVariable("inpParamILS_Inout_V_ID", tabId + "|paramILS_Inout_V_ID");
vars.getRequestGlobalVariable("inpParamLine_f", tabId + "|paramLine_f");

            String strPILS_Inout_V_ID = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID");

      
      vars.removeSessionValue(windowId + "|ILS_Inoutline_V_ID");
      String strILS_Inoutline_V_ID="";

      String strView = vars.getSessionValue(tabId + "|LinesE51D4FEB1D9B4BA6B19DBD7A206BC111.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strILS_Inoutline_V_ID = firstElement(vars, tableSQL);
        if (strILS_Inoutline_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|LinesE51D4FEB1D9B4BA6B19DBD7A206BC111.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strILS_Inoutline_V_ID, strPILS_Inout_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strPILS_Inout_V_ID, strILS_Inoutline_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPILS_Inout_V_ID = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID");
      

      String strILS_Inoutline_V_ID = vars.getGlobalVariable("inpilsInoutlineVId", windowId + "|ILS_Inoutline_V_ID", "");
      vars.setSessionValue(tabId + "|LinesE51D4FEB1D9B4BA6B19DBD7A206BC111.view", "RELATION");
      printPageDataSheet(response, vars, strPILS_Inout_V_ID, strILS_Inoutline_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPILS_Inout_V_ID = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID");


      printPageEdit(response, request, vars, true, "", strPILS_Inout_V_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPILS_Inout_V_ID = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strILS_Inoutline_V_ID = vars.getGlobalVariable("inpilsInoutlineVId", windowId + "|ILS_Inoutline_V_ID", "");
      vars.setSessionValue(tabId + "|LinesE51D4FEB1D9B4BA6B19DBD7A206BC111.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strILS_Inoutline_V_ID, strPILS_Inout_V_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPILS_Inout_V_ID = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID");
      String strILS_Inoutline_V_ID = vars.getRequiredStringParameter("inpilsInoutlineVId");
      
      String strNext = nextElement(vars, strILS_Inoutline_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPILS_Inout_V_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPILS_Inout_V_ID = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID");
      String strILS_Inoutline_V_ID = vars.getRequiredStringParameter("inpilsInoutlineVId");
      
      String strPrevious = previousElement(vars, strILS_Inoutline_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPILS_Inout_V_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID");

      vars.setSessionValue(tabId + "|LinesE51D4FEB1D9B4BA6B19DBD7A206BC111.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPILS_Inout_V_ID = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|LinesE51D4FEB1D9B4BA6B19DBD7A206BC111.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|LinesE51D4FEB1D9B4BA6B19DBD7A206BC111.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|LinesE51D4FEB1D9B4BA6B19DBD7A206BC111.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|ILS_Inoutline_V_ID");
      vars.setSessionValue(windowId + "|ILS_Inout_V_ID", strPILS_Inout_V_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPILS_Inout_V_ID = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|LinesE51D4FEB1D9B4BA6B19DBD7A206BC111.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|LinesE51D4FEB1D9B4BA6B19DBD7A206BC111.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|ILS_Inoutline_V_ID");
      vars.setSessionValue(windowId + "|ILS_Inout_V_ID", strPILS_Inout_V_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPILS_Inout_V_ID = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPILS_Inout_V_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPILS_Inout_V_ID = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPILS_Inout_V_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPILS_Inout_V_ID = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPILS_Inout_V_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPILS_Inout_V_ID = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPILS_Inout_V_ID);      
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
      String strPILS_Inout_V_ID = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID");
      String strILS_Inoutline_V_ID = vars.getRequiredGlobalVariable("inpilsInoutlineVId", windowId + "|ILS_Inoutline_V_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPILS_Inout_V_ID);      
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
          String strNext = nextElement(vars, strILS_Inoutline_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|ILS_Inoutline_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPILS_Inout_V_ID = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID");

      String strILS_Inoutline_V_ID = vars.getRequiredInStringParameter("inpilsInoutlineVId");
      String message = deleteRelation(vars, strILS_Inoutline_V_ID, strPILS_Inout_V_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|ilsInoutlineVId");
        vars.setSessionValue(tabId + "|LinesE51D4FEB1D9B4BA6B19DBD7A206BC111.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPILS_Inout_V_ID = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID");

      String strILS_Inoutline_V_ID = vars.getRequiredStringParameter("inpilsInoutlineVId");
      //LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data data = getEditVariables(vars, strPILS_Inout_V_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.delete(this, strILS_Inoutline_V_ID, strPILS_Inout_V_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|ilsInoutlineVId");
        vars.setSessionValue(tabId + "|LinesE51D4FEB1D9B4BA6B19DBD7A206BC111.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strILS_Inoutline_V_ID, String strPILS_Inout_V_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strILS_Inoutline_V_ID.startsWith("(")) strILS_Inoutline_V_ID = strILS_Inoutline_V_ID.substring(1, strILS_Inoutline_V_ID.length()-1);
      if (!strILS_Inoutline_V_ID.equals("")) {
        strILS_Inoutline_V_ID = Replace.replace(strILS_Inoutline_V_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strILS_Inoutline_V_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.deleteTransactional(conn, this, strKey, strPILS_Inout_V_ID)==0) {
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
  private LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data getEditVariables(Connection con, VariablesSecureApp vars, String strPILS_Inout_V_ID) throws IOException,ServletException {
    LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data data = new LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data();
    ServletException ex = null;
    try {
    data.mAttributesetinstanceId = vars.getStringParameter("inpmAttributesetinstanceId");     data.ilsInoutVId = vars.getStringParameter("inpilsInoutVId");     data.ilsInoutVIdr = vars.getStringParameter("inpilsInoutVId_R");    try {   data.line = vars.getNumericParameter("inpline");  } catch (ServletException paramEx) { ex = paramEx; }     data.mLocatorId = vars.getRequestGlobalVariable("inpmLocatorId", windowId + "|M_Locator_ID");     data.mLocatorIdr = vars.getStringParameter("inpmLocatorId_R");     data.aAssetId = vars.getStringParameter("inpaAssetId");     data.mProductId = vars.getRequestGlobalVariable("inpmProductId", windowId + "|M_Product_ID");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");    try {   data.movementqty = vars.getNumericParameter("inpmovementqty", vars.getSessionValue(windowId + "|MovementQty"));  } catch (ServletException paramEx) { ex = paramEx; }     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cUomId = vars.getRequestGlobalVariable("inpcUomId", windowId + "|C_UOM_ID");     data.cUomIdr = vars.getStringParameter("inpcUomId_R");     data.adUserId = vars.getStringParameter("inpadUserId");     data.adUserIdr = vars.getStringParameter("inpadUserId_R");     data.ilsInoutlineVId = vars.getRequestGlobalVariable("inpilsInoutlineVId", windowId + "|ILS_Inoutline_V_ID");     data.description = vars.getRequestGlobalVariable("inpdescription", windowId + "|Description");     data.isinvoiced = vars.getStringParameter("inpisinvoiced", "N");     data.cOrderlineId = vars.getRequestGlobalVariable("inpcOrderlineId", windowId + "|C_OrderLine_ID");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.adOrgId = vars.getStringParameter("inpadOrgId"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.ilsInoutVId = vars.getGlobalVariable("inpilsInoutVId", windowId + "|ILS_Inout_V_ID");


    
    

    
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

   private LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[] getRelationData(LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].mAttributesetinstanceId = FormatUtilities.truncate(data[i].mAttributesetinstanceId, 22);        data[i].ilsInoutVId = FormatUtilities.truncate(data[i].ilsInoutVId, 32);        data[i].mLocatorId = FormatUtilities.truncate(data[i].mLocatorId, 30);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, 32);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 30);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 32);        data[i].cUomId = FormatUtilities.truncate(data[i].cUomId, 22);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 32);        data[i].ilsInoutlineVId = FormatUtilities.truncate(data[i].ilsInoutlineVId, 32);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].cOrderlineId = FormatUtilities.truncate(data[i].cOrderlineId, 50);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 22);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 22);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPILS_Inout_V_ID) throws IOException,ServletException {
      ShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[] data = ShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPILS_Inout_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|C_DocType_ID", data[0].cDoctypeId);    vars.setSessionValue(windowId + "|ILS_Inout_V_ID", data[0].ilsInoutVId);    vars.setSessionValue(windowId + "|IsSOTrx", data[0].issotrx);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);
      vars.setSessionValue(windowId + "|ILS_Inout_V_ID", strPILS_Inout_V_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strILS_Inoutline_V_ID) throws ServletException {
    String strPILS_Inout_V_ID = LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.selectParentID(this, strILS_Inoutline_V_ID);
    if (strPILS_Inout_V_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strILS_Inoutline_V_ID);
      throw new ServletException("Parent record not found");
    }
    return strPILS_Inout_V_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|M_Locator_ID", data[0].getField("mLocatorId"));    vars.setSessionValue(windowId + "|M_Product_ID", data[0].getField("mProductId"));    vars.setSessionValue(windowId + "|MovementQty", data[0].getField("movementqty"));    vars.setSessionValue(windowId + "|C_UOM_ID", data[0].getField("cUomId"));    vars.setSessionValue(windowId + "|ILS_Inoutline_V_ID", data[0].getField("ilsInoutlineVId"));    vars.setSessionValue(windowId + "|Description", data[0].getField("description"));    vars.setSessionValue(windowId + "|C_OrderLine_ID", data[0].getField("cOrderlineId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPILS_Inout_V_ID) throws IOException,ServletException {
      LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[] data = LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPILS_Inout_V_ID, vars.getStringParameter("inpilsInoutlineVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPILS_Inout_V_ID, String strILS_Inoutline_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamLine = vars.getSessionValue(tabId + "|paramLine");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamILS_Inout_V_ID = vars.getSessionValue(tabId + "|paramILS_Inout_V_ID");
String strParamLine_f = vars.getSessionValue(tabId + "|paramLine_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamLine.equals("") && strParamM_Product_ID.equals("") && strParamILS_Inout_V_ID.equals("") && strParamLine_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strILS_Inoutline_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strILS_Inoutline_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openz/internallogistic/ShipmentReceipt/LinesE51D4FEB1D9B4BA6B19DBD7A206BC111_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "LinesE51D4FEB1D9B4BA6B19DBD7A206BC111", false, "document.frmMain.inpilsInoutlineVId", "grid", "..", "".equals("Y"), "ShipmentReceipt", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPILS_Inout_V_ID);

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
    xmlDocument.setParameter("KeyName", "ilsInoutlineVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "LinesE51D4FEB1D9B4BA6B19DBD7A206BC111_Relation.html", "ShipmentReceipt", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "LinesE51D4FEB1D9B4BA6B19DBD7A206BC111_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.selectParent(this, strPILS_Inout_V_ID));
    else xmlDocument.setParameter("parent", LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.selectParentTrl(this, strPILS_Inout_V_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strILS_Inoutline_V_ID, String strPILS_Inout_V_ID, TableSQLData tableSQL)
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
    LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamLine = vars.getSessionValue(tabId + "|paramLine");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamILS_Inout_V_ID = vars.getSessionValue(tabId + "|paramILS_Inout_V_ID");
String strParamLine_f = vars.getSessionValue(tabId + "|paramLine_f");

    boolean hasSearchCondition=false;
    if (!(strParamLine.equals("") && strParamM_Product_ID.equals("") && strParamILS_Inout_V_ID.equals("") && strParamLine_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPILS_Inout_V_ID, strILS_Inoutline_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strILS_Inoutline_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("ilsInoutlineVId") == null || dataField.getField("ilsInoutlineVId").equals("")) {
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
        refreshSessionNew(vars, strPILS_Inout_V_ID);
        data = LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.set(strPILS_Inout_V_ID, Utility.getDefault(this, vars, "AD_Client_ID", "@AD_Client_ID@", "C1E552E422A54C8AB7AF8F6625AB75F6", "E51D4FEB1D9B4BA6B19DBD7A206BC111", "", dataField), LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.selectDefED78F84708C449D9B720A7FB2E1A6321(this, Utility.getContext(this, vars, "m_inout_ID", "C1E552E422A54C8AB7AF8F6625AB75F6")), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "C1E552E422A54C8AB7AF8F6625AB75F6", "E51D4FEB1D9B4BA6B19DBD7A206BC111", "", dataField), Utility.getDefault(this, vars, "M_AttributeSetInstance_ID", "", "C1E552E422A54C8AB7AF8F6625AB75F6", "E51D4FEB1D9B4BA6B19DBD7A206BC111", "", dataField), LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.selectDef4DFC21ADAE854C1AA794BFB0A3619BD3(this, Utility.getContext(this, vars, "m_inout_ID", "C1E552E422A54C8AB7AF8F6625AB75F6")), LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.selectDefD8643C706693453E8F6A6C87FBACA1A0(this, strPILS_Inout_V_ID), LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.selectDefD8643C706693453E8F6A6C87FBACA1A0_0(this, LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.selectDefD8643C706693453E8F6A6C87FBACA1A0(this, strPILS_Inout_V_ID)), Utility.getDefault(this, vars, "AD_User_ID", "@ad_user_id@", "C1E552E422A54C8AB7AF8F6625AB75F6", "E51D4FEB1D9B4BA6B19DBD7A206BC111", "", dataField), LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.selectDefB13074C9A2F342E992B270F7B9A47D89(this), LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.selectDefB13074C9A2F342E992B270F7B9A47D89_1(this, LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.selectDefB13074C9A2F342E992B270F7B9A47D89(this)), Utility.getDefault(this, vars, "Isinvoiced", "", "C1E552E422A54C8AB7AF8F6625AB75F6", "E51D4FEB1D9B4BA6B19DBD7A206BC111", "N", dataField), LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.selectDef69B22AA407364CE28BFD2F797CB2A46F(this, Utility.getContext(this, vars, "M_InOut_ID", "C1E552E422A54C8AB7AF8F6625AB75F6")), Utility.getDefault(this, vars, "C_OrderLine_ID", "", "C1E552E422A54C8AB7AF8F6625AB75F6", "E51D4FEB1D9B4BA6B19DBD7A206BC111", "", dataField), "", Utility.getDefault(this, vars, "CreatedBy", "", "C1E552E422A54C8AB7AF8F6625AB75F6", "E51D4FEB1D9B4BA6B19DBD7A206BC111", "", dataField), LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.selectDefE5A7431919714CD68661AB01D3C2586C_2(this, Utility.getDefault(this, vars, "CreatedBy", "", "C1E552E422A54C8AB7AF8F6625AB75F6", "E51D4FEB1D9B4BA6B19DBD7A206BC111", "", dataField)), "Y", Utility.getDefault(this, vars, "MovementQty", "1", "C1E552E422A54C8AB7AF8F6625AB75F6", "E51D4FEB1D9B4BA6B19DBD7A206BC111", "", dataField), Utility.getDefault(this, vars, "Description", "", "C1E552E422A54C8AB7AF8F6625AB75F6", "E51D4FEB1D9B4BA6B19DBD7A206BC111", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "C1E552E422A54C8AB7AF8F6625AB75F6", "E51D4FEB1D9B4BA6B19DBD7A206BC111", "", dataField), LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.selectDefD1DC1492C7C14374AC6EB8438506F7CD_3(this, Utility.getDefault(this, vars, "UpdatedBy", "", "C1E552E422A54C8AB7AF8F6625AB75F6", "E51D4FEB1D9B4BA6B19DBD7A206BC111", "", dataField)), Utility.getDefault(this, vars, "C_UOM_ID", "", "C1E552E422A54C8AB7AF8F6625AB75F6", "E51D4FEB1D9B4BA6B19DBD7A206BC111", "", dataField), LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.selectDefC39651F7A7934C2FAB6150AC8591C7EB(this, Utility.getContext(this, vars, "m_inout_ID", "C1E552E422A54C8AB7AF8F6625AB75F6")));
        
      }
    } else {
      data = new LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=ShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.selectOrg(this, strPILS_Inout_V_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "LinesE51D4FEB1D9B4BA6B19DBD7A206BC111", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpilsInoutlineVId", "", "..", "".equals("Y"), "ShipmentReceipt", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strILS_Inoutline_V_ID));
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
      String result = "var strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\nvar strProcessed=\"" + Utility.getContext(this, vars, "Processed", windowId) + "\";\n";
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPILS_Inout_V_ID) throws IOException, ServletException {
    LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data data = null;
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
            data = getEditVariables(con, vars, strPILS_Inout_V_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.ilsInoutlineVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.getCurrentDBTimestamp(this, data.ilsInoutlineVId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.ilsInoutlineVId, vars, this);
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
                    data.ilsInoutlineVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|ILS_Inoutline_V_ID", data.ilsInoutlineVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet LinesE51D4FEB1D9B4BA6B19DBD7A206BC111. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
