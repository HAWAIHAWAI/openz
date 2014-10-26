package org.openz.pdc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.data.FieldProvider;
import org.openbravo.erpCommon.businessUtility.WindowTabs;


import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.utils.Replace;

import org.openz.view.Formhelper;
import org.openz.view.FormhelperData;
import org.openz.view.Scripthelper;
import org.openz.view.EditableGrid;
import org.openz.view.templates.*;

import org.openz.util.*;



public class DoProduction  extends HttpSecureAppServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
        ServletException {
      VariablesSecureApp vars = new VariablesSecureApp(request);
      if (vars.getOrg().equals("0"))
        throw new ServletException("@needOrg2UseFunction@");
     
      
      try{
        
        //Getting Session Values
        String strConsumptionid=vars.getSessionValue("pdcConsumptionID");
        String strProductionid=vars.getSessionValue("pdcProductionID");
        // Getting Form Fields
        String strpdcWorkstepID=vars.getStringParameter("inppdcmaterialconsumptionworkstepid");
        String strpdcUserID=vars.getStringParameter("inppdcmaterialconsumptionuserid");
        String strBarcode=vars.getStringParameter("inppdcmaterialconsumptionbarcode");
        String strProductID=vars.getStringParameter("inppdcmaterialconsumptionproductid");
        String strQty=vars.getNumericParameter("inppdcmaterialconsumptionquantity");
        String strLocatorID=vars.getStringParameter("inppdcmaterialconsumptionlocatorid");
        //setting History
        String strpdcFormerDialogue=vars.getSessionValue("PDCFORMERDIALOGUE");
        if ((strpdcFormerDialogue.equals(""))||(strpdcFormerDialogue.equals("/org.openz.pdc.ad_forms/DoProduction.html"))){
        	vars.setSessionValue("PDCFORMERDIALOGUE","/org.openz.pdc.ad_forms/PdcMainDialogue.html");
        	strpdcFormerDialogue=vars.getSessionValue("PDCFORMERDIALOGUE");
        }
        if (strpdcWorkstepID.equals(""))
          strpdcWorkstepID=vars.getSessionValue("PDCWORKSTEPID");
        if (strpdcUserID.equals(""))
          strpdcUserID=vars.getSessionValue("pdcUserID");
        // Evaluate Barcode Field - Determin if it is a command
        String bcCommand=""; // Command issued via Barcode
        if (vars.commandIn("SAVE_NEW_NEW")){
          if (!strBarcode.isEmpty()) {
            // Analyze Scanned Barcode..
            PdcCommonData[] data  = PdcCommonData.selectbarcode(this, strBarcode);
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
            // The Function to Scan Serial and Batch Numbers direct was implemented later.
            // This Servlet does not use it and determins SERIAL and Batches in own querys.
            //TODO: Implement direct scan and determination of Serial and Batch (Will make Servlet more readable)               
            //Scannes a User
            if (bctype.equals("EMPLOYEE")){
              if (strConsumptionid.isEmpty() && strProductionid.isEmpty())
                strpdcUserID=bcid;
              else {
                vars.setSessionValue("PDCSTATUS","ERROR");
                vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_cannotchangeuserorworkstep",vars.getLanguage())+"-"+vars.getStringParameter("inppdcmaterialconsumptionbarcode"));
              }
            }
            // Scanned a Control Barcode
            if (bctype.equals("CONTROL")){
              if (bcid.equals("57C99C3D7CB5459BADEC665F78D3D6BC")) // Cancel
                bcCommand="CANCEL";
              else if (bcid.equals("8521E358B73444A6A999C55CBCCACC75")) // Next
                bcCommand="NEXT";
              else if (bcid.equals("B28DAF284EA249C48F932C98F211F257")) // Ready (Finished)
                bcCommand="DONE";
              else if (bcid.equals("48AE377FD5224514A54E9AE666BE5CC7")) // Close Workstep
                bcCommand="CLOSEWS";
              else {
                vars.setSessionValue("PDCSTATUS","ERROR");
                vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_bcnotapplicable",vars.getLanguage()));
              }
             
            } //End of  Control BC 
            if (bctype.equals("PRODUCT") ){
              strProductID=bcid;
              strLocatorID=DoProductionData.getLocator(this, strpdcWorkstepID, strProductionid, strConsumptionid, strProductID);
              strQty=DoProductionData.getQty(this, strpdcWorkstepID, strProductionid, strConsumptionid, strProductID,strLocatorID);
              String trxqty=DoProductionData.getTrxQty(this, strProductionid, strConsumptionid, strProductID,strLocatorID);
              if (strQty!=null)
                strQty= new BigDecimal(strQty).add(new BigDecimal(trxqty)).toString();
              vars.setSessionValue("PDCSTATUS","OK");
              vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_sucessful",vars.getLanguage())+"-"+vars.getStringParameter("inppdcmaterialconsumptionbarcode"));
            }
            if (bctype.equals("LOCATOR")){
              strLocatorID=bcid;
              vars.setSessionValue("PDCSTATUS","OK");
              vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_sucessful",vars.getLanguage())+"-"+vars.getStringParameter("inppdcmaterialconsumptionbarcode"));
            }
            if (bctype.equals("WORKSTEP")){
              if (strConsumptionid.isEmpty() && strProductionid.isEmpty())
                strpdcWorkstepID=bcid;
              else {
                vars.setSessionValue("PDCSTATUS","ERROR");
                vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_cannotchangeuserorworkstep",vars.getLanguage())+"-"+vars.getStringParameter("inppdcmaterialconsumptionbarcode"));
              }
            } 
            else if (bctype.equals("CALCULATION")) {
          	  int scanqty= Integer.parseInt(strBarcode);  
          	  String qtynow=vars.getSessionValue(getServletInfo() + "|" +"pdcmaterialconsumptionquantity");
          	  if (qtynow.isEmpty()){                                      
          	  qtynow="0";}
          	  int qtnow=Integer.parseInt(qtynow);
            	  int qtysum=(qtnow + scanqty);
            	  strQty=String.valueOf(qtysum);
                vars.setSessionValue(getServletInfo() + "|" + "inppdcmaterialconsumptionquantity", strQty);
                vars.setSessionValue("PDCSTATUS","OK");
                vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_sucessful",vars.getLanguage())+"-"+vars.getStringParameter("inppdcmaterialconsumptionbarcode"));
              }
            if (bctype.equals("UNKNOWN")){
              vars.setSessionValue("PDCSTATUS","ERROR");
              vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_bcunknown",vars.getLanguage())+"-"+vars.getStringParameter("inppdcmaterialconsumptionbarcode"));
            }
          } // Empty Barcode
            
          if (bcCommand.isEmpty())
            bcCommand="DEFAULT";
          vars.setSessionValue(getServletInfo() + "|" + "pdcmaterialconsumptionproductid", strProductID);
          vars.setSessionValue(getServletInfo() + "|" + "pdcmaterialconsumptionquantity", strQty);
          vars.setSessionValue(getServletInfo() + "|" + "pdcmaterialconsumptionlocatorid", strLocatorID);
        } else { // command not save_new_new
          vars.removeSessionValue(getServletInfo() + "|" + "pdcmaterialconsumptionproductid");
          vars.removeSessionValue(getServletInfo() + "|" + "pdcmaterialconsumptionquantity");
          vars.removeSessionValue(getServletInfo() + "|" + "pdcmaterialconsumptionlocatorid");
          if (vars.commandIn("DEFAULT")) {
            // Look if we come from serial Number Tracking...
            String commandserial=vars.getSessionValue("PDCINVOKESERIAL");
            vars.removeSessionValue("PDCINVOKESERIAL");
            if (!commandserial.isEmpty())
              bcCommand=commandserial;
            else
              bcCommand=vars.getCommand();
          } else
            bcCommand=vars.getCommand();
        }
        
        vars.setSessionValue("PDCWORKSTEPID",strpdcWorkstepID);
        vars.setSessionValue(getServletInfo() + "|" + "pdcmaterialconsumptionworkstepid",strpdcWorkstepID);
        vars.setSessionValue("pdcUserID",strpdcUserID);
        vars.setSessionValue(getServletInfo() + "|" + "pdcmaterialconsumptionuserid",strpdcUserID);
        //
        // Initialize Global Structues
        String strPdcInfobar=""; //Area for further Information of the Servlet
        Scripthelper script= new Scripthelper();
        //initialize the grids
        String strUpperGrid ="";
        String strLowerGrid ="";
        //initialize the Fieldgroups
        //Header Fieldgroup
        String strHeaderFG="";
        //Button Fieldgroup
        String strButtonsFG="";
        //Status Fieldgroup
        String strStatusFG="";
        //The Structure of the Servlet
        String strSkeleton="";
        //Html Output of the Servlet
        String strOutput ="" ;
        //Calling the Formhelper to create the Fieldgroups and Grids
        Formhelper fh=new Formhelper();
        //>Setting up the Fieldproviders - they provide Data for the Grids
        //The upper Grid
        FieldProvider[] upperGridData;
        //The lower grid
        FieldProvider[] lowerGridData;
        // Do the Business Logic HERE
       
        // Determin, if workstep and user is set.
        Boolean loadDataOK=false;
        if (strpdcWorkstepID.equals("") && strpdcUserID.equals(""))
          strPdcInfobar=fh.prepareInfobar(this, vars, script, Utility.messageBD(this, "pdc_ScanUser",vars.getLanguage()), "font-size: 32pt; color: #000000;");
        else if (strpdcWorkstepID.equals(""))
          strPdcInfobar=fh.prepareInfobar(this, vars, script, Utility.messageBD(this, "pdc_ScanWorkstep",vars.getLanguage()), "font-size: 32pt; color: #000000;");
        else if (strpdcUserID.equals(""))
          strPdcInfobar=fh.prepareInfobar(this, vars, script, Utility.messageBD(this, "pdc_ScanUser",vars.getLanguage()), "font-size: 32pt; color: #000000;");
        else
          loadDataOK=true;
        
        if (bcCommand.equals("NEXT") && loadDataOK){
          if (strProductID.equals("")||strQty.equals("")||strLocatorID.equals("")){
            vars.setSessionValue(getServletInfo() + "|" + "pdcmaterialconsumptionproductid", strProductID);
            vars.setSessionValue(getServletInfo() + "|" + "pdcmaterialconsumptionquantity", strQty);
            vars.setSessionValue(getServletInfo() + "|" + "pdcmaterialconsumptionlocatorid", strLocatorID);
            vars.setSessionValue("PDCSTATUS","ERROR");
            vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_MustSetProductQtyAndLocator",vars.getLanguage()));
          } else { 
              // 1st Test QTY is Correct?
              boolean correctqty =false;
              String tqty=DoProductionData.getQty(this, strpdcWorkstepID, strProductionid, strConsumptionid, strProductID,strLocatorID);
              String trxqty=DoProductionData.getTrxQty(this, strProductionid, strConsumptionid, strProductID,strLocatorID);
              if (tqty!=null && trxqty!=null)
                if (new BigDecimal(tqty).add(new BigDecimal(trxqty)).compareTo(new BigDecimal(strQty))>=0)
                  correctqty =true;
              if (correctqty){
                Connection conn=this.getConnection();
                String strRelevantConsumptionid="";
                // What kind of Product was scanned? - Produced Assembly?
                if (DoProductionData.getAssemblyProductFromWorkstep(this, strpdcWorkstepID).equals(strProductID)) {
                  // Create a new P+ Transaction, if we have none
                  if (strProductionid.equals("")) {
                    strProductionid=UtilsData.getUUID(this);
                    PdcCommonData.insertProduction(conn, this, strProductionid, vars.getClient(), vars.getOrg(), 
                        strpdcUserID, PdcCommonData.getProductionOrderFromWorkstep(this,strpdcWorkstepID ),strpdcWorkstepID);
                    vars.setSessionValue("pdcProductionID", strProductionid);
                    
                  }
                  strRelevantConsumptionid=strProductionid;
                } // A Product from the BOM was scanned
                  else{
                    // Create a new D- Transaction, if we have none
                    if (strConsumptionid.equals("")) {
                      strConsumptionid=UtilsData.getUUID(this);
                      PdcCommonData.insertMaterailReturn(conn, this, strConsumptionid, vars.getClient(), vars.getOrg(), 
                          strpdcUserID, PdcCommonData.getProductionOrderFromWorkstep(this,strpdcWorkstepID ),strpdcWorkstepID);
                      vars.setSessionValue("pdcConsumptionID", strConsumptionid);
                    }
                    strRelevantConsumptionid=strConsumptionid;
                  }
                  // Check if Value Updates a line or deletes a line
                  String sameline=PdcCommonData.getIDWhenScannedSameLine(this, strRelevantConsumptionid, strProductID, strLocatorID);
                  if (sameline==null) sameline="";
                  // Qty > 0 and new line
                  if (sameline.equals("") && new BigDecimal(strQty).compareTo(BigDecimal.ZERO)==1) {
                    PdcCommonData.insertMaterialLine(conn, this, vars.getClient(), vars.getOrg(), 
                        strpdcUserID,strRelevantConsumptionid,strLocatorID,strProductID,
                        PdcCommonData.getNextLineFromConsumption(this, strRelevantConsumptionid),
                        strQty,PdcCommonData.getProductStdUOM(this, strProductID),PdcCommonData.getProductionOrderFromWorkstep(this,strpdcWorkstepID ),
                        strpdcWorkstepID);
                    vars.setSessionValue("PDCSTATUS","OK");
                    vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_ProductScannedCorrectly",vars.getLanguage())+"-"+vars.getStringParameter("inppdcmaterialconsumptionbarcode"));
                  }
                  else if (new BigDecimal(strQty).compareTo(BigDecimal.ZERO)==1) {
                    // Update existing Line with new QTY
                    PdcCommonData.updateMaterialLine(conn, this,  strQty,sameline);
                    vars.setSessionValue("PDCSTATUS","OK");
                    vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_ProductQtyUpdated",vars.getLanguage())+"-"+vars.getStringParameter("inppdcmaterialconsumptionbarcode"));
                  }
                  else {
                    // Delete line (QTY<=0)
                    PdcCommonData.deleteMaterialLine(conn, this, sameline);
                    vars.setSessionValue("PDCSTATUS","OK");
                    vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_ProductLineDeletedQtyZERO",vars.getLanguage())+"-"+vars.getStringParameter("inppdcmaterialconsumptionbarcode"));
                  }
              vars.removeSessionValue(getServletInfo() + "|" + "pdcmaterialconsumptionproductid");
              vars.removeSessionValue(getServletInfo() + "|" + "pdcmaterialconsumptionquantity");
              vars.removeSessionValue(getServletInfo() + "|" + "pdcmaterialconsumptionlocatorid");
              conn.close();
              } else {
                vars.setSessionValue("PDCSTATUS","ERROR");
                vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_QtyOrProductProvidedIsNotReturnable",vars.getLanguage())+"-"+vars.getStringParameter("inppdcmaterialconsumptionbarcode"));
              }
          }
            
        }
        if (bcCommand.equals("CANCEL")){
          Connection conn=this.getConnection();
          PdcCommonData.deleteAllMaterialLines(conn, this, strConsumptionid);
          PdcCommonData.deleteAllMaterialLines(conn, this, strProductionid);
          PdcCommonData.deleteMaterialTransaction(conn, this, strConsumptionid);
          PdcCommonData.deleteMaterialTransaction(conn, this, strProductionid);
          conn.close();
          vars.setSessionValue("PDCSTATUS","OK");
          vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_TransactionAborted",vars.getLanguage()));
          response.sendRedirect(strDireccion + strpdcFormerDialogue);
        }
        if (bcCommand.equals("CLOSEWS")||bcCommand.equals("DONE")){
          if (PdcCommonData.isbatchorserialnumber(this, strConsumptionid).equals("N") && 
              PdcCommonData.isbatchorserialnumber(this, strProductionid).equals("N")){
            String message="";
            OBError mymess=null;
            boolean iserror=false;
            upperGridData = DoProductionData.selectupper(this,vars.getLanguage(),strpdcWorkstepID,strProductionid,strConsumptionid);
            int matleft=upperGridData.length;
            if (!strConsumptionid.equals("")) {
              // Start internal Consumption Post Process directly
              ProcessUtils.startProcessDirectly(strConsumptionid, "800131", vars, this); 
              // PdcCommonData.doConsumptionPost(this, strConsumptionid);
              message=Utility.messageBD(this, "pdc_MaterialReturnSucessful",vars.getLanguage());
            }
            if (!strProductionid.equals("")) {
              //PdcCommonData.doConsumptionPost(this, strProductionid);
              ProcessUtils.startProcessDirectly(strProductionid, "800131", vars, this);   
              message=message + Utility.messageBD(this, "pdc_ProductionTransactionSucessful",vars.getLanguage()) ;
            }
            // If the Process brings an error, stay in this servlet and diplay the message to the user
            mymess=vars.getMessage(getServletInfo());
            if (mymess!=null) {
              if (mymess.getType().equals("Error")) {
                bcCommand="DEFAULT";
                message=mymess.getMessage();
                iserror=true;
              }
            }
            if (bcCommand.equals("CLOSEWS")){
              Connection conn=this.getConnection();
              message=message + PdcCommonData.closeWorkstep(conn, this, strpdcWorkstepID,strpdcUserID,vars.getLanguage());
              if (matleft>0)
                message=message + Utility.messageBD(this, "pdc_MaterialLeftInWokstep",vars.getLanguage());
              else
                message=message + Utility.messageBD(this, "pdc_NoMaterialLeftInWokstep",vars.getLanguage());
            }
            /*
            if (bcCommand.equals("DONE") && matleft==0 && ! (strConsumptionid.isEmpty() && strProductionid.isEmpty())){
              Connection conn=this.getConnection();
              message=message + PdcCommonData.closeWorkstep(conn, this, strpdcWorkstepID,strpdcUserID,vars.getLanguage());
              conn.close();
              message=message + Utility.messageBD(this, "pdc_WokstepAutoClosed",vars.getLanguage()) ;
            }*/
            if (strConsumptionid.isEmpty() && strProductionid.isEmpty()  && ! bcCommand.equals("CLOSEWS"))
              vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_NoData",vars.getLanguage()));
            else 
              vars.setSessionValue("PDCSTATUSTEXT",message);
            if (iserror)
              vars.setSessionValue("PDCSTATUS","ERROR");
            else {
              vars.setSessionValue("PDCSTATUS","OK");
              response.sendRedirect(strDireccion + strpdcFormerDialogue);
            }
          } else {
            vars.setSessionValue("PDCSTATUS","OK");
            vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_TransactionPreparedSerialNumberNecessary",vars.getLanguage()));
            vars.setSessionValue("PDCINVOKESERIAL",bcCommand);
            //second layer
            if (strpdcFormerDialogue.equals("/org.openz.pdc.ad_forms/PdcMainDialogue.html")){
         	   vars.setSessionValue("PDCFORMERDIALOGUE","/org.openz.pdc.ad_forms/DoProduction.html");
         	   strpdcFormerDialogue=vars.getSessionValue("PDCFORMERDIALOGUE");
            }
            response.sendRedirect(strDireccion + "/org.openz.pdc.ad_forms/SerialAndBatchNumbers.html");
          }
        }
        
        if ((bcCommand.equals("NEXT")||bcCommand.equals("DEFAULT")) && loadDataOK){
          upperGridData = DoProductionData.selectupper(this,vars.getLanguage(),strpdcWorkstepID,strProductionid,strConsumptionid);
          lowerGridData = DoProductionData.selectlower(this,vars.getLanguage(),strProductionid,strConsumptionid);
          EditableGrid lowergrid = new EditableGrid("PdcDoProductionLowerGrid",vars,this);
          strLowerGrid=lowergrid.printGrid(this, vars, script, lowerGridData);
          if (upperGridData.length>0) {
            strPdcInfobar=fh.prepareInfobar(this, vars, script, Utility.messageBD(this, "pdc_ProductionScan",vars.getLanguage()), "font-size: 32pt; color: #000000;");
          }
          else
            strPdcInfobar=fh.prepareInfobar(this, vars, script, Utility.messageBD(this, "pdc_NothingToDo",vars.getLanguage()), "font-size: 32pt; color: #000000;");
        } else {
          upperGridData = DoProductionData.set();
          lowerGridData = DoProductionData.set();
        }
        
        
        

        // Build the User Interface    
        script.addHiddenfield("inpadOrgId", vars.getOrg());
        script.addHiddenShortcut("linkButtonSave_New"); // Adds shortcut for save & new
        script.enableshortcuts("EDITION");              // Enable shortcut for the servlet
        // Set Status Session Vars
        vars.setSessionValue(getServletInfo() + "|STATUS",vars.getSessionValue("PDCSTATUS"));
        vars.setSessionValue(getServletInfo() + "|STATUSTEXT",vars.getSessionValue("PDCSTATUSTEXT"));
        //Header Fieldgroup
        strHeaderFG=fh.prepareFieldgroup(this, vars, script, "PdcDoProductionHeader", null,false);
        //Button Fieldgroup
        strButtonsFG=fh.prepareFieldgroup(this, vars, script, "PdcDoProductionButtons", null,false);
        //Status Fieldgroup
        strStatusFG=PdcStatusBar.getStatusBar(this, vars, script);//fh.prepareFieldgroup(this, vars, script, "PdcStatusFG", null,false);
        // Grid Structures
        EditableGrid uppergrid = new EditableGrid("PdcDoProductionUpperGrid",vars,this);
        strUpperGrid=uppergrid.printGrid(this, vars, script, upperGridData);
        EditableGrid lowergrid = new EditableGrid("PdcDoProductionLowerGrid",vars,this);
        strLowerGrid=lowergrid.printGrid(this, vars, script, lowerGridData);
        //Defining the toolbar default no toolbar
        String strToolbar=FormhelperData.getFormToolbar(this, this.getClass().getName());
         //Loading the structure                                                       Name of the Servlet   
        WindowTabs tabs = new WindowTabs(this, vars, this.getClass().getName());
        strSkeleton = ConfigureFrameWindow.doConfigure(this,vars,"inpbarcode",null,"Production Feedback",strToolbar,"NONE",tabs);
        // Fit all the content together to html     optional Infobar  default loading Header Fieldgroup, Upper Grid, Button Fieldgroup, Lower Grid, Status Fieldgroup
        //Make the Grids scrollable with these lines
        //we are going to the old table structure into a scrollable area, if the table is bigger than the provided area
        strUpperGrid=Replace.replace(strUpperGrid, "<TABLE cellspacing=\"0\" class=\"DataGrid_Table\">","<DIV style=\"height:150px;overflow:auto;\">\n<TABLE cellspacing=\"0\" class=\"DataGrid_Table\">\n"); 
        strUpperGrid=Replace.replace(strUpperGrid, "</TABLE>","</TABLE>\n</DIV>");
        strLowerGrid=Replace.replace(strLowerGrid, "<TABLE cellspacing=\"0\" class=\"DataGrid_Table\">","<DIV style=\"height:150px;overflow:auto;\">\n<TABLE cellspacing=\"0\" class=\"DataGrid_Table\">\n"); 
        strLowerGrid=Replace.replace(strLowerGrid, "</TABLE>","</TABLE>\n</DIV>"); 
        strOutput=Replace.replace(strSkeleton, "@CONTENT@",strPdcInfobar+ strHeaderFG + strUpperGrid + strButtonsFG + strLowerGrid +  strStatusFG); 
        //Generating html source


        strOutput = script.doScript(strOutput, "",this,vars);
        // Gerenrate response
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(strOutput);
        out.close();
      }
      catch (Exception e) { 
        log4j.error("Error in : " + this.getClass().getName() +"\n" + e.getMessage());
        e.printStackTrace();
        vars.setSessionValue("PDCSTATUS","ERROR");
        //vars.setSessionValue("PDCSTATUSTEXT","Error in Production Feedback");
        vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_ErrorOnPage"+"\r\n"+getServletInfo(),vars.getLanguage()));

         throw new ServletException(e);
 
       }  
 }
    
    public String getServletInfo() {
      return this.getClass().getName();
    } // end of getServletInfo() method
  }

