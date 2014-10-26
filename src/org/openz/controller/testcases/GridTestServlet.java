package org.openz.controller.testcases;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.filter.IsIDFilter;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.erpCommon.utility.ComboTableDataWrapper;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.utils.Replace;
import org.openz.view.FormhelperData;
import org.openz.view.Scripthelper;
import org.openz.view.EditableGrid;
import org.openz.view.templates.*;


public class GridTestServlet  extends HttpSecureAppServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
        ServletException {
      VariablesSecureApp vars = new VariablesSecureApp(request);
      Vector <String> retval;
      
      
      Scripthelper script= new Scripthelper();
      response.setContentType("text/html; charset=UTF-8");
     
      String strOutput ="" ;
     
      
      
     
      // INIT by AD
      try{
        String strToolbar=FormhelperData.getFormToolbar(this, this.getClass().getName());
        strOutput =ConfigureFrameWindow.doConfigure(this,vars,"","", "Test Editable Grid Window",strToolbar,"NONE",null); 
        String strTableStructure = ConfigureTableStructure.doConfigure(this,vars,"6","100%" ,"Main");
        String strTableCells=ConfigureFieldgroup.doConfigure(this,vars,script,"Save","6", "","");
        strTableCells=strTableCells + "<tr>" ;
        String strAction="submitCommandForm('SAVE', true, null,'" + this.strDireccion + "/org.openz.controller.ad_forms/GUIGridTest.html', 'appFrame', false, true)";
        strTableCells=strTableCells + ConfigureButton.doConfigure(this, vars,script, "Aktion", 1, 3,false,  "save", strAction, "Aktion","");
        strTableCells=strTableCells + "</tr>" ;
        strTableCells=strTableCells + "<tr></tr>" ;
        strTableCells=strTableCells + "<tr></tr>" ;
        strTableStructure = Replace.replace(strTableStructure, "@CONTENT@", strTableCells);  
        // Initialize the Grid
        EditableGrid grid = new EditableGrid("Grid Test", vars, this);

       
       if (vars.commandIn("SAVE")) {
         retval = grid.getSelectedIds(this, vars, "C_Bpartner_Id");
         retval = grid.getSelectedIds(this, vars, "C_Order_Id");
         retval = grid.getSelectedIds(this, vars, "orderlineId");
         String test="";
         for (int i = 0; i < retval.size(); i++) {
           test=grid.getValue(this, vars, retval.elementAt(i), "qtyordered");
         }
         
       }
        // Get the DATA from Model.
        GridTestData[] data=GridTestData.select(this, vars.getLanguage(), "Y");
        String strGrid=grid.printGrid(this, vars, script, data);
        script.addHiddenfield("inpadOrgId",vars.getOrg());
        
        strOutput = script.doScript(strOutput, "",this,vars);
        strOutput=Replace.replace(strOutput, "@CONTENT@", strTableStructure + strGrid);  
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

