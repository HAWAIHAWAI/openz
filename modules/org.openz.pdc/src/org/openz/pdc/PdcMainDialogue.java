/*
****************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2013 Stefan Zimmermann All Rights Reserved.
Contributor(s): Danny Heuduk, Stefan Zimmermann.
***************************************************************************************************************************************************
*/
package org.openz.pdc;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.openz.view.DataGrid;
import org.openz.view.Formhelper;
import org.openz.view.FormhelperData;
import org.openz.view.Scripthelper;
import org.openz.view.EditableGrid;
import org.openz.view.templates.*;
import org.openz.pdc.controller.PdcStatusBar;
import org.openz.util.*;


public class PdcMainDialogue  extends HttpSecureAppServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
        ServletException {
      VariablesSecureApp vars = new VariablesSecureApp(request);
      Vector <String> retval;
      
      Scripthelper script= new Scripthelper();
      response.setContentType("text/html; charset=UTF-8");
      OBError myMessage = new OBError();
      if (vars.getOrg().equals("0"))
        throw new ServletException("@needOrg2UseFunction@");
      // INIT by AD
      try{
        //Delete the SessionVariables
        
        removePageSessionVariables(vars);
        //Local Variables for Template
        //Getting the barcode
        String strpdcFormerDialogue=vars.getSessionValue("PDCFORMERDIALOGUE");
        String strbarcode = vars.getStringParameter("inpbarcode");
        String strPdcInfobar=""; //Area for further Information of the Servlet
        //Initializing the Fieldgroups
        String strPdcNavigationFG=""; //Navigation Fieldgroup (Barcode Field and Buttons)
        String ilNavigation="";
        String strStatusFG="";        //Status Fieldgroup (Statustext and Statusmessage)
        //Initializing the Template Structure
        String strSkeleton=""; //Structure
        String strOutput ="" ; //The html-code as Output
        //CommandIn Decisions
       //if (strpdcFormerDialogue.equals("")){
    	   vars.setSessionValue("PDCFORMERDIALOGUE","/org.openz.pdc.ad_forms/PdcMainDialogue.html");
    	   strpdcFormerDialogue=vars.getSessionValue("PDCFORMERDIALOGUE");
       //}
        if (vars.commandIn("SAVE_NEW_NEW")){
          
          PdcMainDialogueData data[] = PdcMainDialogueData.selectbarcode(this, strbarcode);
        if (data.length==1){
          PdcMainDialogueData mydatarow =data[0];
          
          String bcbarcode=mydatarow.barcode;
          String bcmess=mydatarow.mess;
          String bctype=mydatarow.type;
          String bcadmessage=mydatarow.adMessageValue;
          String bcid=mydatarow.id;     
          //Workstep --> MaterialReturn
          if (bctype.equals("WORKSTEP")){
        	  vars.setSessionValue("pdcWorkstepID",bcid);
        	  response.sendRedirect(strDireccion + "/org.openz.pdc.ad_forms/PdcMaterialReturn.html");
          }
                    //Time Feedback
          if (bctype.equals("EMPLOYEE")){
            vars.setSessionValue("pdcUserID",bcid);
           // vars.setSessionValue("pdcStatus", "Employee");
            vars.setSessionValue("pdcStatustext", bctype);
            vars.setSessionValue("pdcStatustext", "Barcode: "+ LocalizationUtils.getElementTextByElementName(this,bctype,vars.getLanguage())+"\r\n"+vars.getStringParameter("inpbarcode"));
            response.sendRedirect(strDireccion + "/org.openz.pdc.ad_forms/TimeFeedback.html");
          } else if (bctype.equals("CONTROL")){
          // Time Feedback
          if (bcid.equals("872C3C326AB64D1EBABDD49A1E138136")) {
              vars.setSessionValue("pdcStatus", "OK");
              vars.setSessionValue("pdcStatustext", "Barcode: "+ LocalizationUtils.getElementTextByElementName(this,bctype,vars.getLanguage())+"\r\n"+vars.getStringParameter("inpbarcode"));
              //vars.setSessionValue("pdcStatustext", "Barcode: Control");
              response.sendRedirect(strDireccion + "/org.openz.pdc.ad_forms/TimeFeedback.html");
          }
          //Production Feedback
          if (bcid.equals("56BA860751594541972B4CFF06CB0FC5")){
            vars.setSessionValue("pdcStatus", "OK");
            vars.setSessionValue("pdcStatustext", "Barcode: "+ LocalizationUtils.getElementTextByElementName(this,bctype,vars.getLanguage())+"\r\n"+vars.getStringParameter("inpbarcode"));
            //vars.setSessionValue("pdcStatustext", "Barcode: Control");
            response.sendRedirect(strDireccion + "/org.openz.pdc.ad_forms/DoProduction.html");
          }
          //Material Consumption
          if (bcid.equals("ADA36B3EF12E4E50BC40A88E4233C330")){
            vars.setSessionValue("pdcStatus", "OK");
            vars.setSessionValue("pdcStatustext", "Barcode: "+ LocalizationUtils.getElementTextByElementName(this,bctype,vars.getLanguage())+"\r\n"+vars.getStringParameter("inpbarcode"));
            //vars.setSessionValue("pdcStatustext", "Barcode: Control");
            response.sendRedirect(strDireccion + "/org.openz.pdc.ad_forms/PdcMaterialConsumption.html");
          }
          //Material Return
          if (bcid.equals("EDD4E08D4C324816AE3C1B09155A51A6")){
            vars.setSessionValue("pdcStatus", "OK");
            vars.setSessionValue("pdcStatustext", "Barcode: "+ LocalizationUtils.getElementTextByElementName(this,bctype,vars.getLanguage())+"\r\n"+vars.getStringParameter("inpbarcode"));
            //vars.setSessionValue("pdcStatustext", "Barcode: Control");
            response.sendRedirect(strDireccion + "/org.openz.pdc.ad_forms/PdcMaterialReturn.html");
          }
          //Internal Consumption
          if (bcid.equals("27AA698F27A84E85BD513FBB72CD6269")){
            vars.setSessionValue("pdcStatus", "OK");
            vars.setSessionValue("pdcStatustext", "Barcode: "+ LocalizationUtils.getElementTextByElementName(this,bctype,vars.getLanguage())+"\r\n"+vars.getStringParameter("inpbarcode"));
            //vars.setSessionValue("pdcStatustext", "Barcode: Control");
            response.sendRedirect(strDireccion + "/org.openz.internallogistic.ad_forms/InternalConsumption.html");
          }
          //Internal Transport Inbound
          if (bcid.equals("D37230F812BB4295AFFBDB3F1FF98851")){
            vars.setSessionValue("pdcStatus", "OK");
            vars.setSessionValue("pdcStatustext", "Barcode: "+ LocalizationUtils.getElementTextByElementName(this,bctype,vars.getLanguage())+"\r\n"+vars.getStringParameter("inpbarcode"));
            //vars.setSessionValue("pdcStatustext", "Barcode: Control");
            response.sendRedirect(strDireccion + "/org.openz.internallogistic.ad_forms/InternalTransportInbound.html");
          }
          //Internal Transport Outbound
          if (bcid.equals("F156F0DD11DF4F44AA391A73C0160DDF")){
            vars.setSessionValue("pdcStatus", "OK");
            vars.setSessionValue("pdcStatustext", "Barcode: "+ LocalizationUtils.getElementTextByElementName(this,bctype,vars.getLanguage())+"\r\n"+vars.getStringParameter("inpbarcode"));
            //vars.setSessionValue("pdcStatustext", "Barcode: Control");
            response.sendRedirect(strDireccion + "/org.openz.internallogistic.ad_forms/InternalTransportOutbound.html");
          }
        
        } else if (bctype.equals("PRODUCT")){
          vars.setSessionValue("pdcStatus",  "OK");
          vars.setSessionValue("pdcStatustext", "Barcode: "+ LocalizationUtils.getElementTextByElementName(this,bctype,vars.getLanguage())+"\r\n"+vars.getStringParameter("inpbarcode"));
          //vars.setSessionValue("pdcStatustext", "Barcode: Product");
          myMessage.setType("Warning");
          myMessage.setMessage(Utility.messageBD(this, "pdc_bcnotapplicable",vars.getLanguage())+"\r\n"+vars.getStringParameter("inpbarcode"));       
          vars.setMessage(this.getClass().getName(), myMessage);
        }
        else{
          vars.setSessionValue("pdcStatus", "OK");
          vars.setSessionValue("pdcStatustext",Utility.messageBD(this, "pdc_bcunknown",vars.getLanguage())+"\r\n"+vars.getStringParameter("inpbarcode"));       
          myMessage.setType("Warning");
          myMessage.setMessage(Utility.messageBD(this, "pdc_bcunknown",vars.getLanguage()));       
          vars.setMessage(this.getClass().getName(), myMessage);
      } }  
      } 
        
        // Set Status Session Vars
        vars.setSessionValue(getServletInfo() + "|STATUS",vars.getSessionValue("PDCSTATUS"));
        vars.setSessionValue(getServletInfo() + "|STATUSTEXT",vars.getSessionValue("PDCSTATUSTEXT"));
        //Declaring the toolbar (Default no toolbar)
        String strToolbar=FormhelperData.getFormToolbar(this, this.getClass().getName());
        //Window Tabs (Default Declaration)
        WindowTabs tabs;                  //The Servlet Name generated automatically
        tabs = new WindowTabs(this, vars, this.getClass().getName());
        //Configuring the Structure                                                   Title of Site  Toolbar  
        strSkeleton = ConfigureFrameWindow.doConfigure(this,vars,"inpbarcode",null, "PDC Main Dialogue",strToolbar,"NONE",tabs);
       



        //Calling the Formhelper to Configure the Data inside the Servlet
        Formhelper fh=new Formhelper();
        //Declaration of the Infobar                         Text inside the Infobar
        strPdcInfobar=fh.prepareInfobar(this, vars, script, Utility.messageBD(this, "pdc_ScanInitial",vars.getLanguage()),"font-size: 32pt; color: #000000;");
        //Saving the Fieldgroups into Variables
        //Navigation Fieldgroup
        strPdcNavigationFG=fh.prepareFieldgroup(this, vars, script, "PdcNavigationFG", null,false);
        if (UtilsData.isModuleActive(this, "F2101ADEF06E45CAA2A50B714B738F61").equals("Y")){
        ilNavigation=fh.prepareFieldgroup(this, vars, script, "ILNavigation", null,false);}
        else{
        ilNavigation="";}

        //Status Fieldgroup
        strStatusFG=PdcStatusBar.getStatusBar(this, vars, script);//fh.prepareFieldgroup(this, vars, script, "PdcStatusFG", null,false);
        
        //Generating the html output - Replacing the @Content@ with called areas in this case INFOBAR, NAVIGATION, STATUS
        strOutput=Replace.replace(strSkeleton, "@CONTENT@",strPdcInfobar+ strPdcNavigationFG + ilNavigation + strStatusFG);
        // Enable Shortcuts
        script.addHiddenShortcut("linkButtonSave_New");
        script.enableshortcuts("EDITION");
        //Creating the Output
        strOutput = script.doScript(strOutput, "",this,vars);

        vars.setSessionValue("PDCSTATUS","OK");
        vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_Scan",vars.getLanguage())+"\r\n");

        //Sending the Output
          PrintWriter out = response.getWriter();
          out.println(strOutput);
          out.close();
      }
        
      catch (Exception e) { 
        log4j.error("Error in : " + this.getClass().getName() +"\n" + e.getMessage());
        e.printStackTrace();
        vars.setSessionValue("PDCSTATUS","ERROR");
        //vars.setSessionValue("PDCSTATUSTEXT","Error in BDE Main Screen");
        vars.setSessionValue("PDCSTATUSTEXT",Utility.messageBD(this, "pdc_ErrorOnPage"+getServletInfo(),vars.getLanguage()));

         throw new ServletException(e);
 
      } 
}
    
    private void removePageSessionVariables(VariablesSecureApp vars) { //Removing the Sessionvariables
      vars.removeSessionValue("pdcWorkstepID");
      vars.removeSessionValue("pdcTimestamp");
      if (! vars.getSessionValue("pdcConsumptionID").isEmpty())
        vars.setSessionValue("pdcLASTConsumptionID", vars.getSessionValue("pdcConsumptionID"));
      vars.removeSessionValue("pdcConsumptionID");
      vars.removeSessionValue("pdcInOutID");
      vars.removeSessionValue("pdcProductionID");
      vars.removeSessionValue("pdcUserID");
      vars.removeSessionValue("PDCINVOKESERIAL");
      vars.removeSessionValue("PDCINVOKECONSUMPTION");
    }

    public String getServletInfo() {
      return this.getClass().getName();
    } // end of getServletInfo() method
  }

