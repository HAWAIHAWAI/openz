/*
***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
 */
package org.openz.controller.testcases;

import java.io.IOException;
import org.openbravo.erpCommon.utility.ComboTableDataWrapper;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;

import org.openz.view.*;
import org.openz.view.templates.*;
import org.openbravo.utils.Replace;
import org.openbravo.base.filter.IsIDFilter;

public class TemplateTestServlet extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    String strValue="";
    String strName="";
    String strradio1="";
    String strCheck="";
    String multi="";
    String sortsel="";
    String sortunsel="";
    if (vars.commandIn("EDIT")) {
      strValue=vars.getStringParameter("inpvalue");
      strName=vars.getStringParameter("inpname");
      strradio1=vars.getStringParameter("inprg1");
      strCheck=vars.getStringParameter("inpcheck1");
      multi=vars.getInStringParameter("inpmulti1", IsIDFilter.instance);
      sortunsel=vars.getInStringParameter("inpAD_User_Id1", IsIDFilter.instance);
      sortsel=vars.getInStringParameter("inpAD_User_Id2", IsIDFilter.instance);
    }
    Scripthelper script= new Scripthelper();
    response.setContentType("text/html; charset=UTF-8");
    String strSkeleton ="" ;
    String strOutput ="" ;
    String strTableStructure ="" ;
    String strTableStructure2 ="" ;
    String strTableCells ="";
   
    try{
    ComboTableDataWrapper comboTableData = new ComboTableDataWrapper(this, vars, "AD_User all Sales Rep",null, "ReportSalesDimensionalAnalyzeJR","",null);
    String strToolbar=FormhelperData.getFormToolbar(this, this.getClass().getName());
    strSkeleton = ConfigureFrameWindow.doConfigure(this,vars,"buttonSearch",null, "Test Form Window",strToolbar,"NONE",null);
    
    // Configure Manually
   /* strTableStructure = ConfigureTableStructure.doConfigure(this,vars,"6","100%" ,"Main");
    
    strTableCells=ConfigureFieldgroup.doConfigure(this,vars,script,"Filter","6", "");
    strTableCells=strTableCells + "<tr>" ;
    strTableCells=strTableCells + ConfigureTextbox.doConfigure(this,vars,script,"value1",0,3,40,false,false, "" ,strValue,"value");
    strTableCells=strTableCells + ConfigureTextbox.doConfigure(this,vars,script,"name1",0,3,120,true,false,"", strName,"name");
    strTableCells=strTableCells + "</tr>" ;
    strTableCells=strTableCells + "<tr>" ;
    strTableCells=strTableCells + ConfigureCheckbox.doConfigure(this,vars,script,"check1", 0,  "", "Y",true, false, "Checkbox 1");
    strTableCells=strTableCells + ConfigureDatebox.doConfigure(this, vars,script, "date1", 1, 2,  true, false,  "30-06-2012", "","Test Date 1");
    strTableCells=strTableCells + "</tr>" ;
    strTableCells=strTableCells + "<tr>" ;
    strTableCells=strTableCells + ConfigureListSorter.doConfigure(this, vars,script, "AD_User_Id1", "AD_User_Id2", 0, 6,  "", "", comboTableData.select(false),"ID", null,"", false, "Test Sorter","");
    strTableCells=strTableCells + "</tr>" ;
    strTableCells=strTableCells + "<tr>" ;
    strTableCells=strTableCells + ConfigureMultiSelector.doConfigure(this, vars,script, "multi1", 0,  2, false,false, "Product", null, comboTableData.select(false),"ID",  "Test Multiselector");
    strTableCells=strTableCells + "</tr>" ;
    strTableCells=strTableCells + "<tr>" ;
    strTableCells=strTableCells + ConfigurePopupSelectBox.doConfigure(this, vars,script, "psel1", 0,  3, false, false,  "Product", null,  "", "Test Selector Popup");
    strTableCells=strTableCells + ConfigureNumberbox.doConfigure(this, vars,script, "number1", 0, 2, 3, false, false, "","qtyEdition", "22", "Number");
    strTableCells=strTableCells + "</tr>" ;
    strTableCells=strTableCells + "<tr>" ;
    strTableCells=strTableCells + ConfigureSelectBox.doConfigure(this, vars, script, "sel1", 0, 3,  true, false, "", "EMPTY", comboTableData.select(false), "ID","Select Box",true);
    strTableCells=strTableCells + "</tr>" ;
    strTableCells=strTableCells + "<tr>" ;
    strTableCells=strTableCells + ConfigureRadioButton.doConfigure(this, vars,script,"rad1",  "rg1", true, false, "", "Radio 1" );
    strTableCells=strTableCells + ConfigureRadioButton.doConfigure(this, vars,script,"rad2",  "rg1", false, false, "",  "Radio 2");
    strTableCells=strTableCells + "</tr>" ;
    strTableCells=strTableCells + "<tr>" ;
    String strAction="submitCommandForm('EDIT', true, null,'" + this.strDireccion + "/org.openz.controller.ad_forms/GUITemplatesTest.html', 'appFrame', false, true)";
    strTableCells=strTableCells + ConfigureButton.doConfigure(this, vars,script, "Aktion", 1, 3,false, "save", strAction, "Aktion");
    strTableCells=strTableCells + "</tr>" ;
    strTableCells=strTableCells + "<tr>" ;
    strTableCells=strTableCells + ConfigureButton.doConfigure(this, vars,script, "Valid", 1, 3,false, "clear", "validate(null,null,null)", "Validiere");
    strTableCells=strTableCells + "</tr>" ;
    strTableCells=strTableCells + "<tr>" ;
    strTableStructure = Replace.replace(strTableStructure, "@CONTENT@", strTableCells);  
    */
    
    // Configure  Automatically from a fieldgroup
    
    
    Formhelper fh=new Formhelper();
    fh.addcombodata(comboTableData.select(false), "AD_User_Id11", null);
    strTableStructure2=fh.prepareFieldgroup(this, vars, script, "GUI Tempate Test", null,false);
    
    
    
    
    strOutput=Replace.replace(strSkeleton, "@CONTENT@", strTableStructure + strTableStructure2);
    script.addHiddenfield("inpadOrgId",vars.getOrg());
    strOutput = script.doScript(strOutput, "",this,vars);
    }
    catch (Exception e) { 
      log4j.error("Error in : " + this.getClass().getName() +"\n" + e.getMessage());
      e.printStackTrace();
      throw new ServletException(e);
    }
    PrintWriter out = response.getWriter();
    out.println(strOutput);
    out.close(); 
  }

  public String getServletInfo() {
    return this.getClass().getName();
  } // end of getServletInfo() method
}
