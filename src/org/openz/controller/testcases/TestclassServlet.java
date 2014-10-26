package org.openz.controller.testcases;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openz.view.*;
import org.openz.view.templates.*;
import org.openbravo.utils.Replace;

public class TestclassServlet extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    String strOutput="";
    try{
      
      VariablesSecureApp vars = new VariablesSecureApp(request);
      String strValue="";
      if (vars.commandIn("FIND")) {
        strValue=vars.getStringParameter("inptext");
      }
      response.setContentType("text/html; charset=UTF-8");
      Scripthelper script= new Scripthelper();
      // Frame Window and Toolbar (empty toolbar, if no toolbar defined)
      String strToolbar=FormhelperData.getFormToolbar(this, this.getClass().getName());
      String strSkeleton = ConfigureFrameWindow.doConfigure(this,vars,"buttonSearch",null, "Test Form Window",strToolbar,"NONE",null);
      // Form Helper needed for Fieldgroups
      Formhelper fh=new Formhelper();
      String strTableStructure2=fh.prepareFieldgroup(this, vars, script, "Test 2 Fieldgroup", null,false);
      strOutput=Replace.replace(strSkeleton, "@CONTENT@", strTableStructure2);
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
}
