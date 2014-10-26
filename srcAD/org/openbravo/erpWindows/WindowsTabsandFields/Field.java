
package org.openbravo.erpWindows.WindowsTabsandFields;





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

public class Field extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Field.class);
  
  private static final String windowId = "102";
  private static final String tabId = "95E902F80FFE44D396D8F12657C27DD5";
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
        String stradFieldVId = request.getParameter("inpadFieldVId");
         String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !stradFieldVId.equals(""))
              total = saveRecord(vars, myError, 'U', strPAD_Tab_ID);
          else
              total = saveRecord(vars, myError, 'I', strPAD_Tab_ID);
          
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
      String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID", "");

      String strAD_Field_V_ID = vars.getGlobalVariable("inpadFieldVId", windowId + "|AD_Field_V_ID", "");
            if (strPAD_Tab_ID.equals("")) {
        strPAD_Tab_ID = getParentID(vars, strAD_Field_V_ID);
        if (strPAD_Tab_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|AD_Tab_ID");
        vars.setSessionValue(windowId + "|AD_Tab_ID", strPAD_Tab_ID);
      vars.removeSessionValue(windowId + "|AD_Window_ID");
        refreshParentSession(vars, strPAD_Tab_ID);
      }


      String strView = vars.getSessionValue(tabId + "|Field.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strAD_Field_V_ID.equals("")) strAD_Field_V_ID = firstElement(vars, tableSQL);
          if (strAD_Field_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strAD_Field_V_ID, strPAD_Tab_ID, tableSQL);

      else printPageDataSheet(response, vars, strPAD_Tab_ID, strAD_Field_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strAD_Field_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strAD_Field_V_ID.equals("")) strAD_Field_V_ID = vars.getRequiredGlobalVariable("inpadFieldVId", windowId + "|AD_Field_V_ID");
      else vars.setSessionValue(windowId + "|AD_Field_V_ID", strAD_Field_V_ID);
      
      
      String strPAD_Tab_ID = getParentID(vars, strAD_Field_V_ID);
      
      vars.setSessionValue(windowId + "|AD_Tab_ID", strPAD_Tab_ID);
      vars.setSessionValue("106|Tab.view", "EDIT");
      vars.removeSessionValue(windowId + "|AD_Window_ID");
      refreshParentSession(vars, strPAD_Tab_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Field.view", "EDIT");

        printPageEdit(response, request, vars, false, strAD_Field_V_ID, strPAD_Tab_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Field.view", "RELATION");
        printPageDataSheet(response, vars, strPAD_Tab_ID, strAD_Field_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|AD_Field_V_ID");
      refreshParentSession(vars, strPAD_Tab_ID);


      String strView = vars.getSessionValue(tabId + "|Field.view");
      String strAD_Field_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strAD_Field_V_ID = firstElement(vars, tableSQL);
          if (strAD_Field_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strAD_Field_V_ID.equals("")) strAD_Field_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strAD_Field_V_ID, strPAD_Tab_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPAD_Tab_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");

            String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");

      
      vars.removeSessionValue(windowId + "|AD_Field_V_ID");
      String strAD_Field_V_ID="";

      String strView = vars.getSessionValue(tabId + "|Field.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strAD_Field_V_ID = firstElement(vars, tableSQL);
        if (strAD_Field_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Field.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strAD_Field_V_ID, strPAD_Tab_ID, tableSQL);

      else printPageDataSheet(response, vars, strPAD_Tab_ID, strAD_Field_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");
      

      String strAD_Field_V_ID = vars.getGlobalVariable("inpadFieldVId", windowId + "|AD_Field_V_ID", "");
      vars.setSessionValue(tabId + "|Field.view", "RELATION");
      printPageDataSheet(response, vars, strPAD_Tab_ID, strAD_Field_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");


      printPageEdit(response, request, vars, true, "", strPAD_Tab_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strAD_Field_V_ID = vars.getGlobalVariable("inpadFieldVId", windowId + "|AD_Field_V_ID", "");
      vars.setSessionValue(tabId + "|Field.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strAD_Field_V_ID, strPAD_Tab_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");
      String strAD_Field_V_ID = vars.getRequiredStringParameter("inpadFieldVId");
      
      String strNext = nextElement(vars, strAD_Field_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPAD_Tab_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");
      String strAD_Field_V_ID = vars.getRequiredStringParameter("inpadFieldVId");
      
      String strPrevious = previousElement(vars, strAD_Field_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPAD_Tab_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");

      vars.setSessionValue(tabId + "|Field.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Field.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Field.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Field.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|AD_Field_V_ID");
      vars.setSessionValue(windowId + "|AD_Tab_ID", strPAD_Tab_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Field.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Field.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|AD_Field_V_ID");
      vars.setSessionValue(windowId + "|AD_Tab_ID", strPAD_Tab_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPAD_Tab_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPAD_Tab_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPAD_Tab_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPAD_Tab_ID);      
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
      String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");
      String strAD_Field_V_ID = vars.getRequiredGlobalVariable("inpadFieldVId", windowId + "|AD_Field_V_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPAD_Tab_ID);      
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
          String strNext = nextElement(vars, strAD_Field_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|AD_Field_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");

      String strAD_Field_V_ID = vars.getRequiredInStringParameter("inpadFieldVId");
      String message = deleteRelation(vars, strAD_Field_V_ID, strPAD_Tab_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|adFieldVId");
        vars.setSessionValue(tabId + "|Field.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");

      String strAD_Field_V_ID = vars.getRequiredStringParameter("inpadFieldVId");
      //FieldData data = getEditVariables(vars, strPAD_Tab_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = FieldData.delete(this, strAD_Field_V_ID, strPAD_Tab_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|adFieldVId");
        vars.setSessionValue(tabId + "|Field.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strAD_Field_V_ID, String strPAD_Tab_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strAD_Field_V_ID.startsWith("(")) strAD_Field_V_ID = strAD_Field_V_ID.substring(1, strAD_Field_V_ID.length()-1);
      if (!strAD_Field_V_ID.equals("")) {
        strAD_Field_V_ID = Replace.replace(strAD_Field_V_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strAD_Field_V_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (FieldData.deleteTransactional(conn, this, strKey, strPAD_Tab_ID)==0) {
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
  private FieldData getEditVariables(Connection con, VariablesSecureApp vars, String strPAD_Tab_ID) throws IOException,ServletException {
    FieldData data = new FieldData();
    ServletException ex = null;
    try {
    data.adTabId = vars.getStringParameter("inpadTabId");     data.adTabIdr = vars.getStringParameter("inpadTabId_R");     data.adModuleId = vars.getStringParameter("inpadModuleId");     data.adModuleIdr = vars.getStringParameter("inpadModuleId_R");     data.name = vars.getStringParameter("inpname");     data.description = vars.getStringParameter("inpdescription");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.adColumnVId = vars.getStringParameter("inpadColumnVId");     data.adColumnVIdr = vars.getStringParameter("inpadColumnVId_R");     data.adFieldgroupId = vars.getStringParameter("inpadFieldgroupId");     data.adFieldgroupIdr = vars.getStringParameter("inpadFieldgroupId_R");     data.iscentrallymaintained = vars.getStringParameter("inpiscentrallymaintained", "N");     data.isfiltercolumn = vars.getStringParameter("inpisfiltercolumn", "N");     data.colstotal = vars.getStringParameter("inpcolstotal");     data.colstotalr = vars.getStringParameter("inpcolstotal_R");    try {   data.maxlength = vars.getNumericParameter("inpmaxlength");  } catch (ServletException paramEx) { ex = paramEx; }     data.adProcessId = vars.getStringParameter("inpadProcessId");     data.adProcessIdr = vars.getStringParameter("inpadProcessId_R");     data.adCalloutId = vars.getStringParameter("inpadCalloutId");     data.adCalloutIdr = vars.getStringParameter("inpadCalloutId_R");     data.fieldreference = vars.getStringParameter("inpfieldreference");     data.fieldreferencer = vars.getStringParameter("inpfieldreference_R");     data.tablereference = vars.getStringParameter("inptablereference");     data.tablereferencer = vars.getStringParameter("inptablereference_R");     data.validationrule = vars.getStringParameter("inpvalidationrule");     data.validationruler = vars.getStringParameter("inpvalidationrule_R");     data.includesemptyitem = vars.getStringParameter("inpincludesemptyitem", "N");     data.template = vars.getStringParameter("inptemplate");     data.templater = vars.getStringParameter("inptemplate_R");     data.buttonclass = vars.getStringParameter("inpbuttonclass");     data.isdisplayed = vars.getStringParameter("inpisdisplayed", "N");     data.isreadonly = vars.getStringParameter("inpisreadonly", "N");     data.required = vars.getStringParameter("inprequired", "N");     data.displaylogic = vars.getStringParameter("inpdisplaylogic");     data.readonlylogic = vars.getStringParameter("inpreadonlylogic");     data.mandantorylogic = vars.getStringParameter("inpmandantorylogic");     data.defaultvalue = vars.getStringParameter("inpdefaultvalue");     data.onchangeevent = vars.getStringParameter("inponchangeevent");     data.style = vars.getStringParameter("inpstyle");    try {   data.seqno = vars.getNumericParameter("inpseqno");  } catch (ServletException paramEx) { ex = paramEx; }     data.issameline = vars.getStringParameter("inpissameline", "N");    try {   data.displaylength = vars.getNumericParameter("inpdisplaylength");  } catch (ServletException paramEx) { ex = paramEx; }     data.isfirstfocusedfield = vars.getStringParameter("inpisfirstfocusedfield", "N");     data.isfieldonly = vars.getStringParameter("inpisfieldonly", "N");     data.showinrelation = vars.getStringParameter("inpshowinrelation", "N");    try {   data.gridseqno = vars.getNumericParameter("inpgridseqno");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.gridlength = vars.getNumericParameter("inpgridlength");  } catch (ServletException paramEx) { ex = paramEx; }     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.referenceurl = vars.getStringParameter("inpreferenceurl");     data.isidentifiercolumn = vars.getStringParameter("inpisidentifiercolumn", "N");     data.adFieldVId = vars.getRequestGlobalVariable("inpadFieldVId", windowId + "|AD_Field_V_ID");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.adTabId = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");


    
    

    
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

   private FieldData[] getRelationData(FieldData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adTabId = FormatUtilities.truncate(data[i].adTabId, 44);        data[i].adModuleId = FormatUtilities.truncate(data[i].adModuleId, 32);        data[i].name = FormatUtilities.truncate(data[i].name, 30);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].adColumnVId = FormatUtilities.truncate(data[i].adColumnVId, 30);        data[i].adFieldgroupId = FormatUtilities.truncate(data[i].adFieldgroupId, 30);        data[i].colstotal = FormatUtilities.truncate(data[i].colstotal, 50);        data[i].adProcessId = FormatUtilities.truncate(data[i].adProcessId, 32);        data[i].adCalloutId = FormatUtilities.truncate(data[i].adCalloutId, 32);        data[i].fieldreference = FormatUtilities.truncate(data[i].fieldreference, 32);        data[i].tablereference = FormatUtilities.truncate(data[i].tablereference, 32);        data[i].validationrule = FormatUtilities.truncate(data[i].validationrule, 32);        data[i].template = FormatUtilities.truncate(data[i].template, 50);        data[i].buttonclass = FormatUtilities.truncate(data[i].buttonclass, 50);        data[i].displaylogic = FormatUtilities.truncate(data[i].displaylogic, 50);        data[i].readonlylogic = FormatUtilities.truncate(data[i].readonlylogic, 50);        data[i].mandantorylogic = FormatUtilities.truncate(data[i].mandantorylogic, 50);        data[i].defaultvalue = FormatUtilities.truncate(data[i].defaultvalue, 50);        data[i].onchangeevent = FormatUtilities.truncate(data[i].onchangeevent, 50);        data[i].style = FormatUtilities.truncate(data[i].style, 50);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].referenceurl = FormatUtilities.truncate(data[i].referenceurl, 50);        data[i].adFieldVId = FormatUtilities.truncate(data[i].adFieldVId, 10);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPAD_Tab_ID) throws IOException,ServletException {
      TabData[] data = TabData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getSessionValue(windowId + "|AD_Window_ID"), strPAD_Tab_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|AD_Table_ID", data[0].adTableId);    vars.setSessionValue(windowId + "|AD_Tab_ID", data[0].adTabId);
      vars.setSessionValue(windowId + "|AD_Tab_ID", strPAD_Tab_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strAD_Field_V_ID) throws ServletException {
    String strPAD_Tab_ID = FieldData.selectParentID(this, strAD_Field_V_ID);
    if (strPAD_Tab_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strAD_Field_V_ID);
      throw new ServletException("Parent record not found");
    }
    return strPAD_Tab_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Field_V_ID", data[0].getField("adFieldVId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPAD_Tab_ID) throws IOException,ServletException {
      FieldData[] data = FieldData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPAD_Tab_ID, vars.getStringParameter("inpadFieldVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPAD_Tab_ID, String strAD_Field_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamName = vars.getSessionValue(tabId + "|paramName");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamName.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strAD_Field_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strAD_Field_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/WindowsTabsandFields/Field_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Field", false, "document.frmMain.inpadFieldVId", "grid", "..", "".equals("Y"), "WindowsTabsandFields", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPAD_Tab_ID);

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
    xmlDocument.setParameter("KeyName", "adFieldVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Field_Relation.html", "WindowsTabsandFields", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Field_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", FieldData.selectParent(this, vars.getLanguage(), strPAD_Tab_ID));
    else xmlDocument.setParameter("parent", FieldData.selectParentTrl(this, vars.getLanguage(), strPAD_Tab_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strAD_Field_V_ID, String strPAD_Tab_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " ad_field_v.seqno";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    FieldData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamName = vars.getSessionValue(tabId + "|paramName");

    boolean hasSearchCondition=false;
    if (!(strParamName.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = FieldData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPAD_Tab_ID, strAD_Field_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strAD_Field_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new FieldData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("adFieldVId") == null || dataField.getField("adFieldVId").equals("")) {
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
        refreshSessionNew(vars, strPAD_Tab_ID);
        data = FieldData.set(strPAD_Tab_ID, Utility.getDefault(this, vars, "Gridlength", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "Includesemptyitem", "N", "102", "95E902F80FFE44D396D8F12657C27DD5", "N", dataField), FieldData.selectDefEEAFCC7B49FE47D1865D991FD4CEB9BC(this, strPAD_Tab_ID), Utility.getDefault(this, vars, "Maxlength", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "Onchangeevent", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "Buttonclass", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), "", Utility.getDefault(this, vars, "Isdisplayed", "Y", "102", "95E902F80FFE44D396D8F12657C27DD5", "N", dataField), Utility.getDefault(this, vars, "Description", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "Validationrule", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), "Y", Utility.getDefault(this, vars, "Createdby", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), FieldData.selectDef4EC6BE0244F94AE5939B67363E60372D_0(this, Utility.getDefault(this, vars, "Createdby", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField)), Utility.getDefault(this, vars, "Gridseqno", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "Defaultvalue", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "Readonlylogic", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "Created", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), "0", "0", Utility.getDefault(this, vars, "Name", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "AD_Column_V_ID", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "Required", "N", "102", "95E902F80FFE44D396D8F12657C27DD5", "N", dataField), Utility.getDefault(this, vars, "Isreadonly", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "N", dataField), Utility.getDefault(this, vars, "Referenceurl", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "Fieldreference", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "Tablereference", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "Template", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), FieldData.selectDefFF872D2CDF5149DDA335EFC05F0CDA71_1(this, Utility.getDefault(this, vars, "Updatedby", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField)), Utility.getDefault(this, vars, "AD_Process_ID", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "Isidentifiercolumn", "N", "102", "95E902F80FFE44D396D8F12657C27DD5", "N", dataField), Utility.getDefault(this, vars, "Iscentrallymaintained", "N", "102", "95E902F80FFE44D396D8F12657C27DD5", "N", dataField), Utility.getDefault(this, vars, "Displaylogic", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "Mandantorylogic", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "Style", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "Colstotal", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "AD_Fieldgroup_ID", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "Showinrelation", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "N", dataField), Utility.getDefault(this, vars, "Isfieldonly", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "N", dataField), Utility.getDefault(this, vars, "Isfirstfocusedfield", "N", "102", "95E902F80FFE44D396D8F12657C27DD5", "N", dataField), FieldData.selectDef4D94EE4A22F14335BB280644DD90CA87(this, strPAD_Tab_ID), Utility.getDefault(this, vars, "Issameline", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "N", dataField), Utility.getDefault(this, vars, "Isfiltercolumn", "N", "102", "95E902F80FFE44D396D8F12657C27DD5", "N", dataField), Utility.getDefault(this, vars, "AD_Callout_ID", "", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField), Utility.getDefault(this, vars, "Displaylength", "0", "102", "95E902F80FFE44D396D8F12657C27DD5", "", dataField));
        
      }
    } else {
      data = new FieldData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(FieldData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=TabData.selectOrg(this, strPAD_Tab_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Field", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpadFieldVId", "", "..", "".equals("Y"), "WindowsTabsandFields", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strAD_Field_V_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPAD_Tab_ID) throws IOException, ServletException {
    FieldData data = null;
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
            data = getEditVariables(con, vars, strPAD_Tab_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.adFieldVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (FieldData.getCurrentDBTimestamp(this, data.adFieldVId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.adFieldVId, vars, this);
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
                    data.adFieldVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|AD_Field_V_ID", data.adFieldVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Field. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
