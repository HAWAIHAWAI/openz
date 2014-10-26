package org.openz.controller.callouts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;


import org.openz.view.SelectBoxhelper;

public class TimefeedbackCO extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;

  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    if (vars.commandIn("DEFAULT")) {
      String strUserID = vars.getStringParameter("inpemployeeId");
      String strMachineID = vars.getStringParameter("inpmaMachineId");  // request-variable      
      String strChanged = vars.getStringParameter("inpLastFieldChanged");

      // New Callout Structure
      CalloutStructure callout = new CalloutStructure(this, this.getClass().getSimpleName() );
      
      try {
        
        if (strChanged.equals("inpemployeeId")&& ! strUserID.equals("")){
          callout.appendComboTable("inpcCalendareventId", SelectBoxhelper.getReferenceDataByRefName(this, vars, "EmployeeCalendarEvent",null,null,"",false), "empty");
          callout.appendComboTable("inpmaMachineId",SelectBoxhelper.getReferenceDataByRefName(this, vars, "ma_machine_ID", null,null,"",false),"empty");
          vars.setSessionValue(this.getClass().getName()+ "|inpadUserId", strUserID);
          vars.removeSessionValue(this.getClass().getName()+ "|inpmaMachineId");
        }
        if (strChanged.equals("inpmaMachineId") && ! strMachineID.equals("")){
          callout.appendComboTable("inpcCalendareventId", SelectBoxhelper.getReferenceDataByRefName(this, vars, "MachineCalendarEvent", null,null,"",false),"empty");
          callout.appendComboTable("inpemployeeId",SelectBoxhelper.getReferenceDataByRefName(this, vars, "AD_User - Internal", null,null,"",false),"empty");
          vars.setSessionValue(this.getClass().getName()+ "|inpmaMachineId", strMachineID);
          vars.removeSessionValue(this.getClass().getName()+ "|inpadUserId");
        } 
        
        // NEW Dataset
        if (strMachineID.equals("") && strUserID.equals("")){
          if ( ! vars.getSessionValue(this.getClass().getName()+ "|inpadUserId").equals("")) {
            callout.appendComboTable("inpemployeeId",SelectBoxhelper.getReferenceDataByRefName(this, vars, "AD_User - Internal", null,null,"",false),vars.getSessionValue(this.getClass().getName()+ "|inpadUserId"));
          }
          if ( ! vars.getSessionValue(this.getClass().getName()+ "|inpmaMachineId").equals("")) {
            callout.appendComboTable("inpmaMachineId",SelectBoxhelper.getReferenceDataByRefName(this, vars, "ma_machine_ID", null,null,"",false),vars.getSessionValue(this.getClass().getName()+ "|inpmaMachineId"));
          }
        }
     
        


           // callout.appendMessage("NoLocationNoTaxCalculated", this, vars);

        
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(callout.returnCalloutAppFrame());
        out.close();
      } catch (Exception ex) {
        pageErrorCallOut(response);
      }
    } else
      pageError(response);
  }




}
