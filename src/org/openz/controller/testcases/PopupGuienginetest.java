package org.openz.controller.testcases;

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
import org.openbravo.data.FieldProvider;
import org.openbravo.erpCommon.businessUtility.WindowTabs;
import org.openbravo.erpCommon.info.SelectorUtility;
import org.openbravo.erpCommon.utility.ComboTableDataWrapper;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.utils.Replace;
import org.openz.controller.testcases.GuienginetestData;
import org.openz.view.DataGrid;
import org.openz.view.Formhelper;
import org.openz.view.FormhelperData;
import org.openz.view.Scripthelper;
import org.openz.view.EditableGrid;
import org.openz.view.templates.*;
import org.openbravo.data.FResponse;


public class PopupGuienginetest  extends HttpSecureAppServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
        ServletException {
      VariablesSecureApp vars = new VariablesSecureApp(request);
      Connection conn = null;
     
      
      try{
        // Get and Set Session Variables here
        //Getting
        String strOrg=vars.getOrg();
        String strtextbox=vars.getStringParameter("inptextbox");
        String strdatebox=vars.getStringParameter("inpdatebox");
        String strcheckbox=vars.getStringParameter("inpcheckbox");
        String strdecbox=vars.getStringParameter("inpdecbox");
        String streuro=vars.getStringParameter("inpeuro");
        String strintbox=vars.getStringParameter("inpintbox");
        String strlist1=vars.getStringParameter("inpadUserId21");
        String strmulti=vars.getStringParameter("inpmultiselector");
        String strsearch=vars.getStringParameter("inppopupsearch");
        String strprice=vars.getStringParameter("inpprice");
        String strrefcombo=vars.getStringParameter("inprefcombo");
        String strimage=vars.getStringParameter("inpimage");
        String strnoedit=vars.getStringParameter("inpnoedittextbox");
        String strurl=vars.getStringParameter("inpurl");
        String strtsimple=vars.getStringParameter("inptextareasimple");
        String strtadv=vars.getStringParameter("inpcontainer");
        String strlist2=vars.getStringParameter("inpadUserId32");
        
        //Setting 
        //To set Inputboxes etc use 
        //set                     the docname          fieldname without inp    content/value
        //vars.setSessionValue(this.getClass().getName() + "|Statustext", "content of the Field");
        // Initialize Global Structues
        String strPdcInfobar=""; //Area for further Information of the Servlet
        Scripthelper script= new Scripthelper();
        script.addHiddenfield("inpadOrgId", vars.getOrg());
        script.addHiddencontainer("inpcontainer", "", "container");
        script.addHiddenShortcut("linkButtonSave_New"); // Adds shortcut for save & new
        script.enableshortcuts("EDITION");              // Enable shortcut for the servlet

        // Add Org ID as hidden field (there is none in our Fieldgroups and org is needed By popups)
        script.addHiddenfield("inpadOrgId", strOrg);
        //initialize the grids
        String strGrid ="";

        //initialize the Fieldgroups
        //Header Fieldgroup
        String strHeaderFG="";
        
        //The Structure of the Servlet
        String strSkeleton="";
        //Html Output of the Servlet
        String strOutput ="" ;
        //Calling the Formhelper to create the Fieldgroups and Grids
        Formhelper fh=new Formhelper();
        ComboTableDataWrapper comboTableData = new ComboTableDataWrapper(this, vars, "AD_User all Sales Rep",null, "ReportSalesDimensionalAnalyzeJR","",null);

        fh.addcombodata(comboTableData.select(false), "AD_User_Id11", null);
        fh.addcombodata(comboTableData.select(false), "AD_User_Id31", null);

        FieldProvider[] upperGridData;
        upperGridData = GuienginetestData.selectupper(this, vars.getLanguage());
        strHeaderFG=fh.prepareFieldgroup(this, vars, script, "PopupHeaderFG", upperGridData[0],false);
        //The lower grid
       // Do the Business Logic HERE
        if (vars.commandIn("SAVE_NEW_NEW")){
        	 conn= this.getTransactionConnection();
        	 
        	 strtextbox=vars.getStringParameter("inptextbox");
             strdatebox=vars.getStringParameter("inpdatebox");
             strcheckbox=vars.getStringParameter("inpcheckbox");
             strdecbox=vars.getStringParameter("inpdecbox");
             streuro=vars.getStringParameter("inpeuro");
             strintbox=vars.getStringParameter("inpintbox");
             strlist1=vars.getInStringParameter("inpadUserId21");
             strmulti=vars.getInStringParameter("inpmultiselector");
             strsearch=vars.getStringParameter("inppopupsearch");
             strprice=vars.getStringParameter("inpprice");
             strrefcombo=vars.getStringParameter("inprefcombo");
             strimage=vars.getStringParameter("inpimage");
             strnoedit=vars.getStringParameter("inpnoedittextbox");
             strurl=vars.getStringParameter("inpurl");
             strtsimple=vars.getStringParameter("inptextareasimple");
             strtadv=vars.getStringParameter("inpcontainer");
             strlist2=vars.getInStringParameter("inpadUserId32");
             
             GuienginetestData.updateTestdata(this,strtextbox,strdatebox,strcheckbox,strdecbox, streuro,strintbox, strlist1, strmulti,strsearch, strprice, strrefcombo, strnoedit,strimage, strurl,strtsimple,strtadv,strlist2 );
             upperGridData = GuienginetestData.selectupper(this, vars.getLanguage());
             EditableGrid uppergrid = new EditableGrid("Popupdatagrid",vars,this);
             strGrid=uppergrid.printGrid(this, vars, script, upperGridData);
             strHeaderFG=fh.prepareFieldgroup(this, vars, script, "PopupHeaderFG", upperGridData[0],false);
             
        }
        // Loading the Data for the grid - requires valid xsql Files
        //loading the upper grid  with language parameter                                             
        upperGridData = GuienginetestData.selectupper(this, vars.getLanguage());
        //loading the lower grid  with language parameter

        // Build the User Interface.
        // Load Upper Grid from AD                  Enter here the name of the grid
        EditableGrid uppergrid = new EditableGrid("Popupdatagrid",vars,this);
        //save the grid in variable                
        strGrid=uppergrid.printGrid(this, vars, script, upperGridData);
        //Declaration of the Infobar                         Text inside the Infobar
        strPdcInfobar=fh.prepareInfobar(this, vars, script, "test","");

        // Prepare the Fieldgroups from AD                    Name of the Fieldgroup
        //Fieldgroups below are Default for PDC
        //Header Fieldgroup

        // Load Form-Skeleton 
        //Defining the toolbar default no toolbar
        String strToolbar=FormhelperData.getFormToolbar(this, this.getClass().getName());
         //Loading the structure                                                       Name of the Servlet              
        strSkeleton = ConfigurePopup.doConfigure(this,vars,script,"Popup", "inptextbox");
        // Fit all the content together to html     optional Infobar  default loading Header Fieldgroup, Upper Grid, Button Fieldgroup, Lower Grid, Status Fieldgroup
        //Make the Grids scrollable with these lines
        strOutput=Replace.replace(strSkeleton, "@CONTENT@",strHeaderFG+strGrid); 
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
         throw new ServletException(e);
 
       }  
 }
    //Remove Sessionvariables
    private void removePageSessionVariables(VariablesSecureApp vars) { //Removing the Sessionvariables
      // remove saved adorgid only when called from DEFAULT,KEY
      // but not when called by clicking search in the selector
      if (!vars.getStringParameter("newFilter").equals("1")) {
        vars.removeSessionValue("adorgid");
      }}
    public String getServletInfo() {
      return this.getClass().getName();
    } // end of getServletInfo() method
  }

