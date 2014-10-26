/*__________| PDC - Material Return |_______________________________________________________
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * Copyright:           OpenZ
 * Author:              Frank.Wohlers@OpenZ.de          (2013)
 * Contributor(s):      Danny.Heuduk@OpenZ.de           (2013)
 *_________________________________________________________________________| MPL1.1 |___fw_*/

package org.openz.pdc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.data.FieldProvider;
import org.openbravo.erpCommon.businessUtility.WindowTabs;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.utils.Replace;
import org.openz.util.ProcessUtils;
import org.openz.util.UtilsData;
import org.openz.view.Formhelper;
import org.openz.view.FormhelperData;
import org.openz.view.Scripthelper;
import org.openz.view.EditableGrid;
import org.openz.view.templates.*;
import org.openz.util.*;
import java.math.BigDecimal;

public class PdcMaterialReturn extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);      
    try {
      // Define AD fieldgroup names
      String HeaderADName = "PdcMaterialConsumptionHeader";
      String UpperGridADName = "PdcMaterialReturnUpperGrid";
      String ButtonADName = "PdcMaterialReturnButtons";
      String LowerGridADName = "PdcMaterialReturnLowerGrid";
      String StatusADName = "PdcStatusFG";
      
      // Define AD field names, do NOT use capitals or special characters here
      String BarcodeADName = "pdcmaterialconsumptionbarcode";
      String UserIDADName = "pdcmaterialconsumptionuserid";
      String WorkstepIDADName = "pdcmaterialconsumptionworkstepid";
      String ProductIDADName = "pdcmaterialconsumptionproductid";
      String QuantityADName = "pdcmaterialconsumptionquantity";
      String LocatorIDADName = "pdcmaterialconsumptionlocatorid";
      if (vars.getOrg().equals("0"))
        throw new ServletException("@needOrg2UseFunction@");
  

      // Initialize global structure
      Scripthelper script = new Scripthelper(); // Injects Javascript, hidden fields, etc into the generated html
      Formhelper fh = new Formhelper();         // Injects the styles of fields, grids, etc
      String strOutput = "" ;                   // Resulting html output
      String strSkeleton = "";                  // Structure of the servlet
      String strToolbar = "";                   // Toolbar
      String strPdcInfobar = "";                // Infobar
      String strHeaderFG = "";                  // Header fieldgroup (defined in AD)
      String strUpperGrid = "";                 // Upper grid (defined in AD)
      String strButtonsFG = "";                 // Button fieldgroup (defined in AD)
      String strLowerGrid = "";                 // Lower grid (defined in AD)
      String strStatusFG = "";                  // Status fieldgroup (defined in AD)
      
      // Initialize fieldproviders - they provide data for the grids
      FieldProvider[] upperGridData;    // Data for the upper grid
      FieldProvider[] lowerGridData;    // Data for the lower grid
      
      // Initialize DB dialogue datafield
      PdcCommonData[] data;
      
      // Loading global session variables
      String GlobalUserID = vars.getSessionValue("pdcUserID");
      String GlobalWorkstepID = vars.getSessionValue("pdcWorkStepID");
      String GlobalConsumptionID = vars.getSessionValue("pdcConsumptionID");
    //setting History
      String strpdcFormerDialogue=vars.getSessionValue("PDCFORMERDIALOGUE");
      if ((strpdcFormerDialogue.equals(""))||(strpdcFormerDialogue.equals("/org.openz.pdc.ad_forms/PdcMaterialReturn.html"))){
      	vars.setSessionValue("PDCFORMERDIALOGUE","/org.openz.pdc.ad_forms/PdcMainDialogue.html");
      	strpdcFormerDialogue=vars.getSessionValue("PDCFORMERDIALOGUE");
      }
              
      // Initialize local session variables with user input
      if (vars.getStringParameter("inp" + UserIDADName).equals("")) {
        setLocalSessionVariable(vars, UserIDADName, GlobalUserID);
      } else {
        setLocalSessionVariable(vars, UserIDADName);
        vars.setSessionValue("pdcUserID",getLocalSessionVariable(vars, UserIDADName));
        GlobalUserID = getLocalSessionVariable(vars, UserIDADName);
      }
      if (vars.getStringParameter("inp" + WorkstepIDADName).equals("")) {
        setLocalSessionVariable(vars, WorkstepIDADName, GlobalWorkstepID);
      } else {
        setLocalSessionVariable(vars, WorkstepIDADName);
        vars.setSessionValue("PDCWORKSTEPID",getLocalSessionVariable(vars, WorkstepIDADName));
        GlobalWorkstepID = getLocalSessionVariable(vars, WorkstepIDADName);
      }
      setLocalSessionVariable(vars, ProductIDADName);
      setLocalSessionVariable(vars, QuantityADName);
      setLocalSessionVariable(vars, LocatorIDADName);
      
      // Initialize Infobar helper variables
      String InfobarPrefix = "<span style=\"font-size: 32pt; color: #000000;\">";
      String InfobarText = "";
      String InfobarSuffix = "</span>";
      String Infobar = "";
      
      String BcCommand = "";
      
      // Business logic
      
      if (vars.commandIn("DEFAULT")) {
        // Look if we come from serial Number Tracking...
        String commandserial=vars.getSessionValue("PDCINVOKESERIAL");
        vars.removeSessionValue("PDCINVOKESERIAL");
        if (!commandserial.isEmpty())
          BcCommand=commandserial;
      }
      if (vars.commandIn("SAVE_NEW_NEW")) {
        if (!vars.getStringParameter("inp" + BarcodeADName).isEmpty()) {
          data = PdcCommonData.selectbarcode(this, vars.getStringParameter("inp" + BarcodeADName));
          // In this Servlet CONTROL, EMPLOYEE or PRODUCT or CALCULATION, LOCATOR, WORKSTEP can be scanned,
          // The First found will be used...
          String bctype="UNKNOWN";
          String bcid="";
          for (int i=0;i<data.length;i++){
            if (data[i].type.equals("CONTROL")||data[i].type.equals("EMPLOYEE")||data[i].type.equals("PRODUCT")||data[i].type.equals("CALCULATION")||data[i].type.equals("LOCATOR")||data[i].type.equals("WORKSTEP")) {
              bcid=data[i].id;  
              bctype=data[i].type;
              break;
            }             
          }         
          if (bctype.equals("EMPLOYEE")) {
            if (GlobalConsumptionID.isEmpty()){
              setLocalSessionVariable(vars, UserIDADName, bcid);
              GlobalUserID=bcid;
              vars.setSessionValue("PDCSTATUS","OK");
              vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_sucessful",vars.getLanguage())+"-"+vars.getStringParameter("inp" + BarcodeADName));
            } else{
              vars.setSessionValue("PDCSTATUS","ERROR");
              vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_cannotchangeuserorworkstep",vars.getLanguage())+"-"+vars.getStringParameter("inp" + BarcodeADName));
            }

          } else if (bctype.equals("LOCATOR")) {
            setLocalSessionVariable(vars, LocatorIDADName, bcid);
            vars.setSessionValue("PDCSTATUS","OK");
            vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_sucessful",vars.getLanguage())+"-"+vars.getStringParameter("inp" + BarcodeADName));
          } else if (bctype.equals("PRODUCT")) {
            setLocalSessionVariable(vars, ProductIDADName, bcid);
            String locator=PdcMaterialReturnData.getLocatorReturn(this, GlobalConsumptionID, GlobalWorkstepID, bcid);
            if (locator!=null) {
              if (!locator.isEmpty()){
                setLocalSessionVariable(vars, LocatorIDADName,locator);
              }
            }
            String qty=PdcMaterialReturnData.getQty(this, GlobalConsumptionID, GlobalWorkstepID, bcid, locator);
            if (qty.isEmpty())
              qty="1";
            setLocalSessionVariable(vars, QuantityADName,qty);
            vars.setSessionValue("PDCSTATUS","OK");
            vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_sucessful",vars.getLanguage())+"-"+vars.getStringParameter("inp" + BarcodeADName));
            
          } else if (bctype.equals("WORKSTEP")) {
            if  (GlobalConsumptionID.isEmpty()){
              setLocalSessionVariable(vars, WorkstepIDADName, bcid);
              GlobalWorkstepID=bcid;
              vars.setSessionValue("PDCSTATUS","OK");
              vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_sucessful",vars.getLanguage())+"-"+vars.getStringParameter("inp" + BarcodeADName));
              
            } else{
              vars.setSessionValue("PDCSTATUS","ERROR");
              vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_cannotchangeuserorworkstep",vars.getLanguage())+"-"+vars.getStringParameter("inp" + BarcodeADName));
            }
            
          } else if (bctype.equals("CONTROL")) {
            if (bcid.equals("57C99C3D7CB5459BADEC665F78D3D6BC"))
              BcCommand = "CANCEL";
            else if (bcid.equals("8521E358B73444A6A999C55CBCCACC75"))
              BcCommand = "NEXT";
            else if (bcid.equals("B28DAF284EA249C48F932C98F211F257"))
              BcCommand = "DONE";
            else if (bcid.equals("10D3B97A3089447C9A4F04FF792A5246"))
              BcCommand = "ALLPOSITIONS";
            else {
              vars.setSessionValue("PDCSTATUS", "ERROR");
              vars.setSessionValue("PDCSTATUSTEXT", Utility.messageBD(this, "pdc_bcnotapplicable", vars.getLanguage()));
            }
          }else if (bctype.equals("CALCULATION")) {
        	  int scanqty= Integer.parseInt(vars.getStringParameter("inp" + BarcodeADName));  
        	  String qtynow=getLocalSessionVariable(vars, QuantityADName);
        	  if (qtynow.isEmpty()){
        	  qtynow="0";}
        	  int qtnow=Integer.parseInt(qtynow);
          	  int qtysum=(qtnow + scanqty);
        	  vars.setSessionValue(getServletInfo() + "|" + QuantityADName, String.valueOf(qtysum));
              vars.setSessionValue("PDCSTATUS","OK");
              vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_sucessful",vars.getLanguage())+"-"+vars.getStringParameter("inp" + BarcodeADName));
            }
          else if (bctype.equals("UNKNOWN")) {
            vars.setSessionValue("PDCSTATUS","ERROR");
            vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_bcunknown",vars.getLanguage())+"-"+vars.getStringParameter("inp" + BarcodeADName));
            
          } 
        }
      }
      if (vars.commandIn("ALLPOSITIONS")||BcCommand.equals("ALLPOSITIONS")){
        if (getLocalSessionVariable(vars, WorkstepIDADName).equals("")||
            getLocalSessionVariable(vars, UserIDADName).equals("")){
          
          vars.setSessionValue("PDCSTATUS","ERROR");
          vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_MustSetProductQtyAndLocator",vars.getLanguage()));
        } else { 
          Connection conn=this.getConnection();
          if (GlobalConsumptionID.equals("")) {
            GlobalConsumptionID = UtilsData.getUUID(this);
            PdcMaterialReturnData.insertConsumption(
                this.getConnection(),
                this,
                GlobalConsumptionID,
                vars.getClient(),
                vars.getOrg(),
                getLocalSessionVariable(vars, UserIDADName),
                PdcCommonData.getProductionOrderFromWorkstep(this,getLocalSessionVariable(vars, WorkstepIDADName)),
                getLocalSessionVariable(vars, WorkstepIDADName));
            vars.setSessionValue("pdcConsumptionID", GlobalConsumptionID);
          }
          upperGridData = PdcMaterialReturnData.selectupper(this, vars.getLanguage(),GlobalConsumptionID, getLocalSessionVariable(vars, WorkstepIDADName)); 
          for (int i=0;i<upperGridData.length;i++){
            if (upperGridData[i].getField("pdcmaterialreturnlocator").isEmpty()) {
              vars.setSessionValue("PDCSTATUS","ERROR");
              vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_MustSetProductQtyAndLocator",vars.getLanguage())+"\r\n"+vars.getStringParameter("inp" + BarcodeADName));
            } else {
              String qty=PdcMaterialReturnData.getQty(this, GlobalConsumptionID, GlobalWorkstepID, upperGridData[i].getField("m_product_id"), upperGridData[i].getField("m_locator_id"));
              if (! qty.isEmpty()) {
                if (new BigDecimal(qty).compareTo(BigDecimal.ZERO)==1) {
                  PdcCommonData.insertMaterialLine(conn, this, vars.getClient(), vars.getOrg(), 
                    getLocalSessionVariable(vars, UserIDADName),GlobalConsumptionID,upperGridData[i].getField("m_locator_id"),upperGridData[i].getField("m_product_id"),
                    PdcCommonData.getNextLineFromConsumption(this, GlobalConsumptionID),
                    qty,
                    PdcCommonData.getProductStdUOM(this, upperGridData[i].getField("m_product_id")),
                    PdcCommonData.getProductionOrderFromWorkstep(this,getLocalSessionVariable(vars, WorkstepIDADName)),
                    getLocalSessionVariable(vars, WorkstepIDADName));
                }
              }
            }
          }
        }
      }
      if (vars.commandIn("NEXT")||BcCommand.equals("NEXT")) {
        if (getLocalSessionVariable(vars, LocatorIDADName).equals("")||
            getLocalSessionVariable(vars, ProductIDADName).equals("")||
            getLocalSessionVariable(vars, QuantityADName).equals("")||
            getLocalSessionVariable(vars, WorkstepIDADName).equals("")||
            getLocalSessionVariable(vars, UserIDADName).equals("")){
          
          vars.setSessionValue("PDCSTATUS","ERROR");
          vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_MustSetProductQtyAndLocator",vars.getLanguage())+"\r\n"+vars.getStringParameter("inp" + BarcodeADName));
        } else { 
          Connection conn=this.getConnection();
          if (GlobalConsumptionID.equals("")) {
            GlobalConsumptionID = UtilsData.getUUID(this);
            PdcMaterialReturnData.insertConsumption(
                this.getConnection(),
                this,
                GlobalConsumptionID,
                vars.getClient(),
                vars.getOrg(),
                getLocalSessionVariable(vars, UserIDADName),
                PdcCommonData.getProductionOrderFromWorkstep(this,getLocalSessionVariable(vars, WorkstepIDADName)),
                getLocalSessionVariable(vars, WorkstepIDADName));
            vars.setSessionValue("pdcConsumptionID", GlobalConsumptionID);
          }
          
         // Check if Value Updates a line or deletes a line
          String sameline=PdcCommonData.getIDWhenScannedSameLine(this, GlobalConsumptionID, getLocalSessionVariable(vars, ProductIDADName), getLocalSessionVariable(vars, LocatorIDADName));
          if (sameline==null) sameline="";
          // Qty > 0 and new line
          if (sameline.equals("") && new BigDecimal(getLocalSessionVariable(vars, QuantityADName)).compareTo(BigDecimal.ZERO)==1) {
            PdcCommonData.insertMaterialLine(conn, this, vars.getClient(), vars.getOrg(), 
                getLocalSessionVariable(vars, UserIDADName),GlobalConsumptionID,getLocalSessionVariable(vars, LocatorIDADName),getLocalSessionVariable(vars, ProductIDADName),
                PdcCommonData.getNextLineFromConsumption(this, GlobalConsumptionID),
                getLocalSessionVariable(vars, QuantityADName),PdcCommonData.getProductStdUOM(this, getLocalSessionVariable(vars, ProductIDADName)),PdcCommonData.getProductionOrderFromWorkstep(this,getLocalSessionVariable(vars, WorkstepIDADName)),
                getLocalSessionVariable(vars, WorkstepIDADName));
            vars.setSessionValue("PDCSTATUS","OK");
            vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_ProductScannedCorrectly",vars.getLanguage())+"\r\n"+vars.getStringParameter("inp" + BarcodeADName));
            if (PdcCommonData.isbatchorserialnumber(this, GlobalConsumptionID).equals("Y")){
              vars.setSessionValue("PDCSTATUS","OK");
              vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_TransactionPreparedSerialNumberNecessary",vars.getLanguage())+"\r\n"+vars.getStringParameter("inp" + BarcodeADName));
              vars.setSessionValue("PDCINVOKESERIAL","DONE");
            //second layer
              if (strpdcFormerDialogue.equals("/org.openz.pdc.ad_forms/PdcMainDialogue.html")){
                       vars.setSessionValue("PDCFORMERDIALOGUE","/org.openz.pdc.ad_forms/PdcMaterialReturn.html");
                       strpdcFormerDialogue=vars.getSessionValue("PDCFORMERDIALOGUE");
               }
              response.sendRedirect(strDireccion + "/org.openz.pdc.ad_forms/SerialAndBatchNumbers.html");
            }
          }
          else if (new BigDecimal(getLocalSessionVariable(vars, QuantityADName)).compareTo(BigDecimal.ZERO)==1) {
            // Update existing Line with new QTY
            PdcCommonData.updateMaterialLine(conn, this,  getLocalSessionVariable(vars, QuantityADName),sameline);
            vars.setSessionValue("PDCSTATUS","OK");
            vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_ProductQtyUpdated",vars.getLanguage())+"\r\n"+vars.getStringParameter("inp" + BarcodeADName));
          }
          else {
            // Delete line (QTY<=0)
            PdcCommonData.deleteMaterialLine(conn, this, sameline);
            vars.setSessionValue("PDCSTATUS","OK");
            vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_ProductLineDeletedQtyZERO",vars.getLanguage())+"\r\n"+vars.getStringParameter("inp" + BarcodeADName));
          }
          
          
          deleteLocalSessionVariable(vars,ProductIDADName);
          deleteLocalSessionVariable(vars,QuantityADName);
          
        }
      }
      
      if (vars.commandIn("DONE")||BcCommand.equals("DONE")) {
        if (PdcCommonData.isbatchorserialnumber(this, GlobalConsumptionID).equals("N")){
          OBError mymess=null;
          boolean iserror=false;
          String msgtext="\n";
          if (!GlobalConsumptionID.equals("")) {
            if (TimeFeedbackData.isWorstepStarted(this, GlobalWorkstepID).equals("N")) {
              TimeFeedbackData[] res=TimeFeedbackData.beginWorkstepNoMat(this, GlobalWorkstepID, GlobalUserID, vars.getOrg());
              if (res.length>0){
                msgtext=Replace.replace(res[0].outMessagetext,"@","");
                Utility.messageBD(this, msgtext,vars.getLanguage());
                }
            }
            // Start internal Consumption Post Process directly
            ProcessUtils.startProcessDirectly(GlobalConsumptionID, "800131", vars, this); 
            // PdcCommonData.doConsumptionPost(this, strConsumptionid);
            vars.setSessionValue("PDCSTATUS","OK");
            vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_MaterialReturnSucessful",vars.getLanguage())+"\r\n"+vars.getStringParameter("inp" + BarcodeADName)+msgtext);
            // If the Process brings an error, stay in this servlet and diplay the message to the user
            mymess=vars.getMessage(getServletInfo());
            if (mymess!=null) {
              if (mymess.getType().equals("Error")) {
                iserror=true;
                vars.setSessionValue("PDCSTATUS","ERROR");
                vars.setSessionValue("PDCSTATUSTEXT",mymess.getMessage());
              }
            }
          } else {
            vars.setSessionValue("PDCSTATUS","OK");
            vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_NoData",vars.getLanguage())+"\r\n"+vars.getStringParameter("inp" + BarcodeADName));
          }
          if (! iserror)
            response.sendRedirect(strDireccion + strpdcFormerDialogue);
        } else {
          vars.setSessionValue("PDCSTATUS","OK");
          vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_TransactionPreparedSerialNumberNecessary",vars.getLanguage())+"\r\n"+vars.getStringParameter("inp" + BarcodeADName));
          vars.setSessionValue("PDCINVOKESERIAL","DONE");
        //second layer
          if (strpdcFormerDialogue.equals("/org.openz.pdc.ad_forms/PdcMainDialogue.html")){
        	   vars.setSessionValue("PDCFORMERDIALOGUE","/org.openz.pdc.ad_forms/PdcMaterialReturn.html");
        	   strpdcFormerDialogue=vars.getSessionValue("PDCFORMERDIALOGUE");
           }
          response.sendRedirect(strDireccion + "/org.openz.pdc.ad_forms/SerialAndBatchNumbers.html");
        }
      }
      
      if (vars.commandIn("CANCEL")||BcCommand.equals("CANCEL")) {
        Connection conn=this.getConnection();
        PdcCommonData.deleteAllMaterialLines(conn, this, GlobalConsumptionID);
        PdcCommonData.deleteMaterialTransaction(conn, this, GlobalConsumptionID);
        conn.close();
        vars.setSessionValue("PDCSTATUS","OK");
        vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_TransactionAborted",vars.getLanguage())+"\r\n"+vars.getStringParameter("inp" + BarcodeADName));
        response.sendRedirect(strDireccion + strpdcFormerDialogue);
      }
     
      
      if (getLocalSessionVariable(vars, UserIDADName) == "") {
    	InfobarText = Utility.messageBD(this, "pdc_ScanUser",vars.getLanguage());
      } else if (getLocalSessionVariable(vars, WorkstepIDADName) == "") {
    	InfobarText = Utility.messageBD(this, "pdc_ScanWorkstep",vars.getLanguage());
      } else if (getLocalSessionVariable(vars, LocatorIDADName) == "") {
    	InfobarText = Utility.messageBD(this, "pdc_ScanLocator",vars.getLanguage());
      } else if (getLocalSessionVariable(vars, ProductIDADName) == "") {
        InfobarText = Utility.messageBD(this, "pdc_ScanProduct",vars.getLanguage());
      } else if (getLocalSessionVariable(vars, QuantityADName) == "") {
        InfobarText = Utility.messageBD(this, "pdc_ScanQty",vars.getLanguage());
      } else
    	InfobarText = Utility.messageBD(this, "pdc_ScanNCCA",vars.getLanguage());
      
      // Setting global session variables
      vars.setSessionValue("pdcUserID", GlobalUserID);
      vars.setSessionValue("pdcWorkStepID", GlobalWorkstepID);
      //vars.setSessionValue("pdcConsumptionID", GlobalConsumptionID);
      
      // Set Status Session Vars
      vars.setSessionValue(getServletInfo() + "|STATUS",vars.getSessionValue("PDCSTATUS"));
      vars.setSessionValue(getServletInfo() + "|STATUSTEXT",vars.getSessionValue("PDCSTATUSTEXT"));

      // Load grid structure
      EditableGrid uppergrid = new EditableGrid(UpperGridADName, vars, this);  // Load upper grid structure from AD (use AD name)
      upperGridData = PdcMaterialReturnData.selectupper(this, vars.getLanguage(), vars.getSessionValue("pdcConsumptionID"), getLocalSessionVariable(vars, WorkstepIDADName));   // Load upper grid date with language for translation
      strUpperGrid = uppergrid.printGrid(this, vars, script, upperGridData);                    // Generate upper grid html code
      
      EditableGrid lowergrid = new EditableGrid(LowerGridADName, vars, this);  // Load lower grid structure from AD (use AD name)
      
      // Load grid data - requires valid xsql file
      lowerGridData =PdcMaterialReturnData.selectlower(this, vars.getLanguage(), vars.getSessionValue("pdcConsumptionID"));   // Load lower grid date with language for translation
      
      // Generate servlet skeleton html code
      strToolbar = FormhelperData.getFormToolbar(this, this.getClass().getName());      
      //Window Tabs (Default Declaration)
      WindowTabs tabs;                  //The Servlet Name generated automatically
      tabs = new WindowTabs(this, vars, this.getClass().getName());// Load toolbar ID
      strSkeleton = ConfigureFrameWindow.doConfigure(this, vars, "UserID", null, "Material Return", strToolbar, "NONE", tabs);   // Generate skeleton
       
      // Generate Infobar
      Infobar = InfobarPrefix + InfobarText + InfobarSuffix;
      
      // Generate servlet elements html code
      strPdcInfobar = fh.prepareInfobar(this, vars, script, Infobar, "");                       // Generate infobar html code
      strHeaderFG = fh.prepareFieldgroup(this, vars, script, HeaderADName, null, false);        // Generate header html code
    
      strButtonsFG = fh.prepareFieldgroup(this, vars, script, ButtonADName, null, false);       // Generate buttons html code
      strLowerGrid = lowergrid.printGrid(this, vars, script, lowerGridData);                    // Generate lower grid html code
      strStatusFG = PdcStatusBar.getStatusBar(this, vars, script);//fh.prepareFieldgroup(this, vars, script, StatusADName, null, false);        // Generate status html code
          
      // Manual injections - both grids with defined height and scrollbar
      strUpperGrid = Replace.replace(strUpperGrid, "<TABLE cellspacing=\"0\" class=\"DataGrid_Table\">","<DIV style=\"height:150px;overflow:auto;\">\n<TABLE cellspacing=\"0\" class=\"DataGrid_Table\">\n"); 
      strUpperGrid = Replace.replace(strUpperGrid, "</TABLE>","</TABLE>\n</DIV>");
      strLowerGrid = Replace.replace(strLowerGrid, "<TABLE cellspacing=\"0\" class=\"DataGrid_Table\">","<DIV style=\"height:150px;overflow:auto;\">\n<TABLE cellspacing=\"0\" class=\"DataGrid_Table\">\n"); 
      strLowerGrid = Replace.replace(strLowerGrid, "</TABLE>","</TABLE>\n</DIV>");
      
      // Fit all the content together
      strOutput = Replace.replace(strSkeleton, "@CONTENT@", strPdcInfobar + strHeaderFG + strUpperGrid + strButtonsFG + strLowerGrid + strStatusFG);
      
      // Script operations
      script.addHiddenfield("inpadOrgId", vars.getOrg());
      script.addHiddenShortcut("linkButtonSave_New"); // Adds shortcut for save & new
      script.enableshortcuts("EDITION");              // Enable shortcut for the servlet
      
      // Generating final html code including scripts
      strOutput = script.doScript(strOutput, "", this, vars);
      
      // Generate response
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println(strOutput);
      out.close();
    }
    catch (Exception e) { 
      log4j.error("Error in : " + this.getClass().getName() +"\n" + e.getMessage());
      e.printStackTrace();
      throw new ServletException(e);
    }  
 }

  public String getServletInfo() {
    return this.getClass().getName();
  }
  
  public void setLocalSessionVariable(VariablesSecureApp vars, String ADName) {
    vars.setSessionValue(getServletInfo() + "|" + ADName, vars.getStringParameter("inp" + ADName));
  }
  
  public void setLocalSessionVariable(VariablesSecureApp vars, String ADName, String Value) {
    vars.setSessionValue(getServletInfo() + "|" + ADName, Value);
  }
  
  public String getLocalSessionVariable(VariablesSecureApp vars, String ADName) {
    return vars.getSessionValue(getServletInfo() + "|" + ADName);
  }
  
  public void deleteLocalSessionVariable(VariablesSecureApp vars, String ADName) {
    vars.removeSessionValue(getServletInfo() + "|" + ADName);
  }
}

