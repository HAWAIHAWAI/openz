package org.openz.controller.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.filter.IsIDFilter;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
//import org.openbravo.erpCommon.ad_forms.RequisitionToOrderData;
import org.openbravo.erpCommon.businessUtility.Tree;
import org.openbravo.erpCommon.businessUtility.WindowTabs;
import org.openbravo.erpCommon.reference.ActionButtonData;
import org.openbravo.erpCommon.reference.PInstanceProcessData;
import org.openbravo.erpCommon.utility.ComboTableDataWrapper;
import org.openbravo.erpCommon.utility.DateTimeData;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.SequenceIdData;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.utils.Replace;
import org.openz.util.LocalizationUtils;
import org.openz.view.Formhelper;
import org.openz.view.FormhelperData;
import org.openz.view.Scripthelper;
import org.openz.view.EditableGrid;
import org.openz.view.templates.*;


public class GenerateMinoutmanual  extends HttpSecureAppServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
        ServletException {
      VariablesSecureApp vars = new VariablesSecureApp(request);
      Connection conn = null;
      Vector <String> retval;
      Integer line=0;
            
      
      Scripthelper script= new Scripthelper();
      // After Changes ask the user for discarding them or remain on the site
      script.addHiddenfieldWithID("enabledautosave", "N");
      response.setContentType("text/html; charset=UTF-8");
      script.addHiddenfield("inpadOrgId",vars.getOrg());
      String strOutput ="" ;
     
      OBError myMessage = new OBError();
      
      String strIsSOtrx=vars.getSessionValue("issotrx");
      
      // INIT by AD
      try{
        if (vars.commandIn("FIND")||vars.commandIn("DEFAULT") ){
          if (vars.commandIn("FIND"))
            // New Filter defined: Remove old Session Vars
            removeSessionValues(vars);
          // Set session  and read filter
          String strProductId = vars.getGlobalVariable("inpmProductId",
              this.getClass().getName() + "|M_Product_ID", "");
          String strDateFrom = vars.getGlobalVariable("inpdatefrom", this.getClass().getName() + "|DateFrom", "");
          String strDateTo = vars.getGlobalVariable("inpdateto", this.getClass().getName() + "|DateTo", "");
          String strBusinesspartnerId = vars.getGlobalVariable("inpcBpartnerId", this.getClass().getName() + "|C_Bpartner_ID","");
          
          String strToolbar=FormhelperData.getFormToolbar(this, this.getClass().getName());
          WindowTabs tabs;
          if (strIsSOtrx.equals("Y"))
            tabs = new WindowTabs(this, vars, "org.openz.controller.form.GenerateMinoutmanualSO");
          else
            tabs=new WindowTabs(this, vars, "org.openz.controller.form.GenerateMinoutmanualPO");
          String title=LocalizationUtils.getElementTextByElementName(this, strIsSOtrx.equals("Y") ? "Generate Shipments manual" : "Generate material receipts manual", vars.getLanguage());
          strOutput =ConfigureFrameWindow.doConfigure(this,vars,"",null, title,strToolbar,"NONE",tabs); 
          String strTableStructure = ConfigureTableStructure.doConfigure(this,vars,"6","100%" ,"Main");
         // String strTableCells=ConfigureFieldgroup.doConfigure(this,vars,script,"Process","6", "");
          String strTableCells="" ;
          // Filter structure   
          Formhelper fh = new Formhelper();
          String filterStructure=fh.prepareFieldgroup(this, vars, script, "Generate Shipments manual filter", null,false);
          String buttonprocess=fh.prepareFieldgroup(this, vars, script, "Generate Shipments Manual Process", null,false);
          strTableCells=strTableCells + "<tr>" ;
          //String strAction="submitCommandForm('SAVE', true, null,'" + this.strDireccion + "/org.openz.controller.ad_forms/GenerateMinoutmanual.html', 'appFrame', false, true)";
          //strTableCells=strTableCells + ConfigureButton.doConfigure(this, vars,script, "Process", 1, 3,false,  "process", strAction, "Process");
          strTableCells=strTableCells + "</tr>" ;
          strTableCells=strTableCells + "<tr></tr>" ;
          strTableCells=strTableCells + "<tr></tr>" ;
          strTableStructure = Replace.replace(strTableStructure, "@CONTENT@", strTableCells);  
          // Initialize the Grid
          EditableGrid grid = new EditableGrid("Generate Shipments manual Grid", vars, this);
          //GenerateMinoutmanualData[] data=GenerateMinoutmanualData.select(this);
          //String strGrid=grid.printGrid(this, vars, script, data);
          String strTreeOrg = GenerateMinoutmanualData.treeOrg(this, vars.getClient());
           
          String orglist=Tree.getMembers(this, strTreeOrg, vars.getOrg());
          GenerateMinoutmanualData[] datalines=GenerateMinoutmanualData.select(this, vars.getLanguage(),strProductId, strDateFrom, strDateTo, strBusinesspartnerId,orglist, strIsSOtrx);
          String strGrid1=grid.printGrid(this, vars, script, datalines);
          strOutput=Replace.replace(strOutput, "@CONTENT@",  filterStructure + strGrid1 + strTableStructure + buttonprocess);
          strOutput = script.doScript(strOutput, "",this,vars);
          PrintWriter out = response.getWriter();
          out.println(strOutput);
          out.close(); 
        }
        
        
        
        
       if (vars.commandIn("SAVE")) {
         conn= this.getTransactionConnection();
         
         EditableGrid grid = new EditableGrid("Generate Shipments manual Grid", vars, this);
         retval=grid.getSelectedIds(null, vars, "c_orderline_id");
         String ordline,strOrderId,ordlineQty,ordlineLocatorId,ordlineComplete;
         conn= this.getTransactionConnection();
         String pinstance = SequenceIdData.getUUID();
         for (int i = 0; i < retval.size(); i++) {
           ordline=retval.elementAt(i);
           strOrderId=GenerateMinoutmanualData.getOrder(myPool, ordline);
           //grid.getValue(this, vars, retval.elementAt(i), "C_Order_ID");
           ordlineQty=grid.getValue(this, vars, retval.elementAt(i), "qty2deliver");
           ordlineLocatorId=grid.getValue(this, vars, retval.elementAt(i), "m_locator_id");
           ordlineComplete=grid.getValue(this, vars, retval.elementAt(i), "completed");

                         
                         GenerateMinoutmanualData.insert(conn,this, 
                          ordline,
                          strOrderId,
                          vars.getClient(), vars.getOrg(), vars.getUser(), vars.getUser(),
                          ordlineQty,
                          ordlineLocatorId,
                          ordlineComplete,
                          pinstance); 
         }   
         releaseCommitConnection(conn);
         

         PInstanceProcessData.insertPInstance(this, pinstance, "199", "0", "N", vars.getUser(), vars
             .getClient(), vars.getOrg());
         PInstanceProcessData.insertPInstanceParam(this, pinstance, "1", "Selection", "Y", vars
             .getClient(), vars.getOrg(), vars.getUser());
         ActionButtonData.process199(this, pinstance);

         try {
           PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
           myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
         } catch (Exception e) {
           myMessage = Utility.translateError(this, vars, vars.getLanguage(), e.getMessage());
           e.printStackTrace();
           log4j.warn("Error");
         }
         //GenerateShipmentsmanualData.updateReset(this, strSalesOrder);

         if (log4j.isDebugEnabled())
           log4j.debug(myMessage.getMessage());
         // new message system
         vars.setMessage(this.getClass().getName(), myMessage);
         response.sendRedirect(strDireccion + request.getServletPath());
         GenerateMinoutmanualData.deleteerror(this, pinstance);
       }
      } 
      catch (Exception e) { 
        log4j.error("Error in : " + this.getClass().getName() +"\n" + e.getMessage());
        e.printStackTrace();
        throw new ServletException(e);
      }
      
    }
  

    private void removeSessionValues(VariablesSecureApp vars ){
      vars.removeSessionValue(this.getClass().getName() + "|M_Product_ID");
      vars.removeSessionValue(this.getClass().getName() + "|DateFrom");
      vars.removeSessionValue(this.getClass().getName() + "|DateTo");
      vars.removeSessionValue(this.getClass().getName() + "|c_bpartner_id");
      
    }
    public String getServletInfo() {
      return this.getClass().getName();
    } // end of getServletInfo() method
  }

