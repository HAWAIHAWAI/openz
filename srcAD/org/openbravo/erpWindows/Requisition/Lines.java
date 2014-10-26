
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

public class Lines extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Lines.class);
  
  private static final String windowId = "800092";
  private static final String tabId = "800251";
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
        String strmRequisitionlineId = request.getParameter("inpmRequisitionlineId");
         String strPM_Requisition_ID = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strmRequisitionlineId.equals(""))
              total = saveRecord(vars, myError, 'U', strPM_Requisition_ID);
          else
              total = saveRecord(vars, myError, 'I', strPM_Requisition_ID);
          
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
      String strPM_Requisition_ID = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID", "");

      String strM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID", "");
            if (strPM_Requisition_ID.equals("")) {
        strPM_Requisition_ID = getParentID(vars, strM_Requisitionline_ID);
        if (strPM_Requisition_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|M_Requisition_ID");
        vars.setSessionValue(windowId + "|M_Requisition_ID", strPM_Requisition_ID);

        refreshParentSession(vars, strPM_Requisition_ID);
      }


      String strView = vars.getSessionValue(tabId + "|Lines.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strM_Requisitionline_ID.equals("")) strM_Requisitionline_ID = firstElement(vars, tableSQL);
          if (strM_Requisitionline_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strM_Requisitionline_ID, strPM_Requisition_ID, tableSQL);

      else printPageDataSheet(response, vars, strPM_Requisition_ID, strM_Requisitionline_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strM_Requisitionline_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strM_Requisitionline_ID.equals("")) strM_Requisitionline_ID = vars.getRequiredGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");
      else vars.setSessionValue(windowId + "|M_Requisitionline_ID", strM_Requisitionline_ID);
      
      
      String strPM_Requisition_ID = getParentID(vars, strM_Requisitionline_ID);
      
      vars.setSessionValue(windowId + "|M_Requisition_ID", strPM_Requisition_ID);
      vars.setSessionValue("800249|Header.view", "EDIT");

      refreshParentSession(vars, strPM_Requisition_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Lines.view", "EDIT");

        printPageEdit(response, request, vars, false, strM_Requisitionline_ID, strPM_Requisition_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Lines.view", "RELATION");
        printPageDataSheet(response, vars, strPM_Requisition_ID, strM_Requisitionline_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPM_Requisition_ID = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|M_Requisitionline_ID");
      refreshParentSession(vars, strPM_Requisition_ID);


      String strView = vars.getSessionValue(tabId + "|Lines.view");
      String strM_Requisitionline_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strM_Requisitionline_ID = firstElement(vars, tableSQL);
          if (strM_Requisitionline_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strM_Requisitionline_ID.equals("")) strM_Requisitionline_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strM_Requisitionline_ID, strPM_Requisition_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPM_Requisition_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamM_Requisition_ID", tabId + "|paramM_Requisition_ID");
vars.getRequestGlobalVariable("inpParamM_Product_ID", tabId + "|paramM_Product_ID");
vars.getRequestGlobalVariable("inpParamQty", tabId + "|paramQty");
vars.getRequestGlobalVariable("inpParamNeedbydate", tabId + "|paramNeedbydate");
vars.getRequestGlobalVariable("inpParamQty_f", tabId + "|paramQty_f");
vars.getRequestGlobalVariable("inpParamNeedbydate_f", tabId + "|paramNeedbydate_f");

            String strPM_Requisition_ID = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID");

      
      vars.removeSessionValue(windowId + "|M_Requisitionline_ID");
      String strM_Requisitionline_ID="";

      String strView = vars.getSessionValue(tabId + "|Lines.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strM_Requisitionline_ID = firstElement(vars, tableSQL);
        if (strM_Requisitionline_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Lines.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strM_Requisitionline_ID, strPM_Requisition_ID, tableSQL);

      else printPageDataSheet(response, vars, strPM_Requisition_ID, strM_Requisitionline_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPM_Requisition_ID = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID");
      

      String strM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID", "");
      vars.setSessionValue(tabId + "|Lines.view", "RELATION");
      printPageDataSheet(response, vars, strPM_Requisition_ID, strM_Requisitionline_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPM_Requisition_ID = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID");


      printPageEdit(response, request, vars, true, "", strPM_Requisition_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPM_Requisition_ID = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strM_Requisitionline_ID = vars.getGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID", "");
      vars.setSessionValue(tabId + "|Lines.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strM_Requisitionline_ID, strPM_Requisition_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPM_Requisition_ID = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID");
      String strM_Requisitionline_ID = vars.getRequiredStringParameter("inpmRequisitionlineId");
      
      String strNext = nextElement(vars, strM_Requisitionline_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPM_Requisition_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPM_Requisition_ID = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID");
      String strM_Requisitionline_ID = vars.getRequiredStringParameter("inpmRequisitionlineId");
      
      String strPrevious = previousElement(vars, strM_Requisitionline_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPM_Requisition_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID");

      vars.setSessionValue(tabId + "|Lines.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPM_Requisition_ID = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Lines.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Lines.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Lines.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|M_Requisitionline_ID");
      vars.setSessionValue(windowId + "|M_Requisition_ID", strPM_Requisition_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPM_Requisition_ID = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Lines.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Lines.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|M_Requisitionline_ID");
      vars.setSessionValue(windowId + "|M_Requisition_ID", strPM_Requisition_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPM_Requisition_ID = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPM_Requisition_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPM_Requisition_ID = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPM_Requisition_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPM_Requisition_ID = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPM_Requisition_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPM_Requisition_ID = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPM_Requisition_ID);      
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
      String strPM_Requisition_ID = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID");
      String strM_Requisitionline_ID = vars.getRequiredGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPM_Requisition_ID);      
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
          String strNext = nextElement(vars, strM_Requisitionline_ID, tableSQL);
          vars.setSessionValue(windowId + "|M_Requisitionline_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPM_Requisition_ID = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID");

      String strM_Requisitionline_ID = vars.getRequiredInStringParameter("inpmRequisitionlineId");
      String message = deleteRelation(vars, strM_Requisitionline_ID, strPM_Requisition_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|mRequisitionlineId");
        vars.setSessionValue(tabId + "|Lines.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPM_Requisition_ID = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID");

      String strM_Requisitionline_ID = vars.getRequiredStringParameter("inpmRequisitionlineId");
      //LinesData data = getEditVariables(vars, strPM_Requisition_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = LinesData.delete(this, strM_Requisitionline_ID, strPM_Requisition_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|mRequisitionlineId");
        vars.setSessionValue(tabId + "|Lines.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strM_Requisitionline_ID, String strPM_Requisition_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strM_Requisitionline_ID.startsWith("(")) strM_Requisitionline_ID = strM_Requisitionline_ID.substring(1, strM_Requisitionline_ID.length()-1);
      if (!strM_Requisitionline_ID.equals("")) {
        strM_Requisitionline_ID = Replace.replace(strM_Requisitionline_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strM_Requisitionline_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (LinesData.deleteTransactional(conn, this, strKey, strPM_Requisition_ID)==0) {
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
  private LinesData getEditVariables(Connection con, VariablesSecureApp vars, String strPM_Requisition_ID) throws IOException,ServletException {
    LinesData data = new LinesData();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.mRequisitionlineId = vars.getRequestGlobalVariable("inpmRequisitionlineId", windowId + "|M_Requisitionline_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.mRequisitionId = vars.getStringParameter("inpmRequisitionId");     data.mRequisitionIdr = vars.getStringParameter("inpmRequisitionId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");    try {   data.line = vars.getNumericParameter("inpline");  } catch (ServletException paramEx) { ex = paramEx; }     data.reqstatus = vars.getStringParameter("inpreqstatus");     data.reqstatusr = vars.getStringParameter("inpreqstatus_R");     data.needbydate = vars.getStringParameter("inpneedbydate");     data.mProductId = vars.getRequestGlobalVariable("inpmProductId", windowId + "|M_Product_ID");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.suppliernotes = vars.getStringParameter("inpsuppliernotes");     data.internalnotes = vars.getStringParameter("inpinternalnotes");     data.mAttributesetinstanceId = vars.getStringParameter("inpmAttributesetinstanceId");     data.mAttributesetinstanceIdr = vars.getStringParameter("inpmAttributesetinstanceId_R");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.aAssetId = vars.getStringParameter("inpaAssetId");     data.aAssetIdr = vars.getStringParameter("inpaAssetId_R");     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");    try {   data.pricelist = vars.getNumericParameter("inppricelist");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.priceactual = vars.getNumericParameter("inppriceactual");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.linenetamt = vars.getNumericParameter("inplinenetamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.quantityorder = vars.getNumericParameter("inpquantityorder");  } catch (ServletException paramEx) { ex = paramEx; }     data.mProductUomId = vars.getStringParameter("inpmProductUomId");     data.mProductUomIdr = vars.getStringParameter("inpmProductUomId_R");    try {   data.qty = vars.getNumericParameter("inpqty");  } catch (ServletException paramEx) { ex = paramEx; }     data.cUomId = vars.getStringParameter("inpcUomId");     data.cUomIdr = vars.getStringParameter("inpcUomId_R");    try {   data.orderedqty = vars.getNumericParameter("inporderedqty");  } catch (ServletException paramEx) { ex = paramEx; }     data.lockedby = vars.getStringParameter("inplockedby");     data.lockedbyr = vars.getStringParameter("inplockedby_R");     data.lockdate = vars.getStringParameter("inplockdate");     data.rejected = vars.getStringParameter("inprejected", "N");     data.description = vars.getStringParameter("inpdescription");     data.changestatus = vars.getStringParameter("inpchangestatus");    try {   data.discount = vars.getNumericParameter("inpdiscount");  } catch (ServletException paramEx) { ex = paramEx; }     data.cCurrencyId = vars.getStringParameter("inpcCurrencyId");    try {   data.lockqty = vars.getNumericParameter("inplockqty");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.lockprice = vars.getNumericParameter("inplockprice");  } catch (ServletException paramEx) { ex = paramEx; }     data.mPricelistId = vars.getStringParameter("inpmPricelistId");     data.lockcause = vars.getStringParameter("inplockcause");     data.cProjectphaseId = vars.getStringParameter("inpcProjectphaseId"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.mRequisitionId = vars.getGlobalVariable("inpmRequisitionId", windowId + "|M_Requisition_ID");


          vars.getGlobalVariable("inphasseconduom", windowId + "|HASSECONDUOM", "");
    
    

    
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

   private LinesData[] getRelationData(LinesData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].mRequisitionlineId = FormatUtilities.truncate(data[i].mRequisitionlineId, 10);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].mRequisitionId = FormatUtilities.truncate(data[i].mRequisitionId, 44);        data[i].reqstatus = FormatUtilities.truncate(data[i].reqstatus, 8);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 40);        data[i].suppliernotes = FormatUtilities.truncate(data[i].suppliernotes, 50);        data[i].internalnotes = FormatUtilities.truncate(data[i].internalnotes, 50);        data[i].mAttributesetinstanceId = FormatUtilities.truncate(data[i].mAttributesetinstanceId, 20);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 40);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, 32);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 32);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].mProductUomId = FormatUtilities.truncate(data[i].mProductUomId, 10);        data[i].cUomId = FormatUtilities.truncate(data[i].cUomId, 10);        data[i].lockedby = FormatUtilities.truncate(data[i].lockedby, 12);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 5);        data[i].mPricelistId = FormatUtilities.truncate(data[i].mPricelistId, 12);        data[i].lockcause = FormatUtilities.truncate(data[i].lockcause, 1);        data[i].cProjectphaseId = FormatUtilities.truncate(data[i].cProjectphaseId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPM_Requisition_ID) throws IOException,ServletException {
      HeaderData[] data = HeaderData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Requisition_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].mPricelistId);    vars.setSessionValue(windowId + "|M_Requisition_ID", data[0].mRequisitionId);    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].cCurrencyId);
      vars.setSessionValue(windowId + "|M_Requisition_ID", strPM_Requisition_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strM_Requisitionline_ID) throws ServletException {
    String strPM_Requisition_ID = LinesData.selectParentID(this, strM_Requisitionline_ID);
    if (strPM_Requisition_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strM_Requisitionline_ID);
      throw new ServletException("Parent record not found");
    }
    return strPM_Requisition_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|M_Requisitionline_ID", data[0].getField("mRequisitionlineId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|M_Product_ID", data[0].getField("mProductId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPM_Requisition_ID) throws IOException,ServletException {
      LinesData[] data = LinesData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Requisition_ID, vars.getStringParameter("inpmRequisitionlineId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPM_Requisition_ID, String strM_Requisitionline_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamM_Requisition_ID = vars.getSessionValue(tabId + "|paramM_Requisition_ID");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamQty = vars.getSessionValue(tabId + "|paramQty");
String strParamNeedbydate = vars.getSessionValue(tabId + "|paramNeedbydate");
String strParamQty_f = vars.getSessionValue(tabId + "|paramQty_f");
String strParamNeedbydate_f = vars.getSessionValue(tabId + "|paramNeedbydate_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamM_Requisition_ID.equals("") && strParamM_Product_ID.equals("") && strParamQty.equals("") && strParamNeedbydate.equals("") && strParamQty_f.equals("") && strParamNeedbydate_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strM_Requisitionline_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strM_Requisitionline_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/Requisition/Lines_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Lines", false, "document.frmMain.inpmRequisitionlineId", "grid", "..", "".equals("Y"), "Requisition", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPM_Requisition_ID);

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
    xmlDocument.setParameter("KeyName", "mRequisitionlineId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Lines_Relation.html", "Requisition", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Lines_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", LinesData.selectParent(this, strPM_Requisition_ID));
    else xmlDocument.setParameter("parent", LinesData.selectParentTrl(this, strPM_Requisition_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strM_Requisitionline_ID, String strPM_Requisition_ID, TableSQLData tableSQL)
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
    LinesData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamM_Requisition_ID = vars.getSessionValue(tabId + "|paramM_Requisition_ID");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamQty = vars.getSessionValue(tabId + "|paramQty");
String strParamNeedbydate = vars.getSessionValue(tabId + "|paramNeedbydate");
String strParamQty_f = vars.getSessionValue(tabId + "|paramQty_f");
String strParamNeedbydate_f = vars.getSessionValue(tabId + "|paramNeedbydate_f");

    boolean hasSearchCondition=false;
    if (!(strParamM_Requisition_ID.equals("") && strParamM_Product_ID.equals("") && strParamQty.equals("") && strParamNeedbydate.equals("") && strParamQty_f.equals("") && strParamNeedbydate_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = LinesData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Requisition_ID, strM_Requisitionline_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strM_Requisitionline_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new LinesData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("mRequisitionlineId") == null || dataField.getField("mRequisitionlineId").equals("")) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        boolNew = true;
      } else {
        discard[0] = new String ("newDiscard");
        strCommand = "EDIT";
      }
    }
    
        String strHASSECONDUOM = LinesData.selectAux1004400000(this, ((dataField!=null)?dataField.getField("mProductId"):((data==null || data.length==0)?"":data[0].mProductId)));
    vars.setSessionValue(windowId + "|HASSECONDUOM", strHASSECONDUOM);
    
    
    if (dataField==null) {
      if (boolNew || data==null || data.length==0) {
        refreshSessionNew(vars, strPM_Requisition_ID);
        data = LinesData.set(strPM_Requisition_ID, Utility.getDefault(this, vars, "Qty", "1", "800092", "800251", "", dataField), Utility.getDefault(this, vars, "Lockdate", "", "800092", "800251", "", dataField), Utility.getDefault(this, vars, "C_UOM_ID", "", "800092", "800251", "", dataField), Utility.getDefault(this, vars, "PriceActual", "", "800092", "800251", "", dataField), Utility.getDefault(this, vars, "LineNetAmt", "", "800092", "800251", "", dataField), Utility.getDefault(this, vars, "Lockcause", "", "800092", "800251", "", dataField), Utility.getDefault(this, vars, "Suppliernotes", "", "800092", "800251", "", dataField), LinesData.selectDef39CA956F7EC448C6878FDBC4F1EDE761(this, strPM_Requisition_ID), LinesData.selectDef1004400040(this, strPM_Requisition_ID), Utility.getDefault(this, vars, "Rejected", "N", "800092", "800251", "N", dataField), "", Utility.getDefault(this, vars, "Description", "", "800092", "800251", "", dataField), Utility.getDefault(this, vars, "Lockqty", "", "800092", "800251", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "800092", "800251", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "800092", "800251", "", dataField), LinesData.selectDef803549_0(this, Utility.getDefault(this, vars, "Updatedby", "", "800092", "800251", "", dataField)), Utility.getDefault(this, vars, "Reqstatus", "O", "800092", "800251", "", dataField), LinesData.selectDefF51AEEAF9B12444A9DD7F520811CAAC6(this, strPM_Requisition_ID), LinesData.selectDefF51AEEAF9B12444A9DD7F520811CAAC6_1(this, LinesData.selectDefF51AEEAF9B12444A9DD7F520811CAAC6(this, strPM_Requisition_ID)), Utility.getDefault(this, vars, "PriceList", "", "800092", "800251", "", dataField), Utility.getDefault(this, vars, "Needbydate", "", "800092", "800251", "", dataField), "Y", Utility.getDefault(this, vars, "C_Currency_ID", "@C_Currency_ID@", "800092", "800251", "", dataField), Utility.getDefault(this, vars, "M_AttributeSetInstance_ID", "", "800092", "800251", "", dataField), LinesData.selectDef1004400004_2(this, Utility.getDefault(this, vars, "M_AttributeSetInstance_ID", "", "800092", "800251", "", dataField)), Utility.getDefault(this, vars, "Changestatus", "", "800092", "800251", "N", dataField), Utility.getDefault(this, vars, "Internalnotes", "", "800092", "800251", "", dataField), Utility.getDefault(this, vars, "M_Product_Uom_Id", "", "800092", "800251", "", dataField), Utility.getDefault(this, vars, "Discount", "", "800092", "800251", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "800092", "800251", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "800092", "800251", "", dataField), LinesData.selectDef803547_3(this, Utility.getDefault(this, vars, "Createdby", "", "800092", "800251", "", dataField)), Utility.getDefault(this, vars, "C_BPartner_ID", "", "800092", "800251", "", dataField), LinesData.selectDef1004400000_4(this, Utility.getDefault(this, vars, "C_BPartner_ID", "", "800092", "800251", "", dataField)), Utility.getDefault(this, vars, "Lockedby", "", "800092", "800251", "", dataField), Utility.getDefault(this, vars, "QuantityOrder", "", "800092", "800251", "", dataField), Utility.getDefault(this, vars, "M_PriceList_ID", "@mPricelistId@", "800092", "800251", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "800092", "800251", "", dataField), LinesData.selectDef803552_5(this, Utility.getDefault(this, vars, "M_Product_ID", "", "800092", "800251", "", dataField)), Utility.getDefault(this, vars, "Lockprice", "", "800092", "800251", "", dataField), LinesData.selectDef90ED670C8D404D79A1C0B560146CEB41(this, strPM_Requisition_ID), Utility.getDefault(this, vars, "Orderedqty", "0", "800092", "800251", "", dataField), LinesData.selectDef8F6E73C87E184ACC98C52058BC9216B0(this, strPM_Requisition_ID));
        
      }
    } else {
      data = new LinesData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(LinesData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=HeaderData.selectOrg(this, strPM_Requisition_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Lines", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpmRequisitionlineId", "", "..", "".equals("Y"), "Requisition", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strM_Requisitionline_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPM_Requisition_ID) throws IOException, ServletException {
    LinesData data = null;
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
            data = getEditVariables(con, vars, strPM_Requisition_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.mRequisitionlineId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (LinesData.getCurrentDBTimestamp(this, data.mRequisitionlineId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.mRequisitionlineId, vars, this);
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
                    data.mRequisitionlineId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|M_Requisitionline_ID", data.mRequisitionlineId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Lines. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
