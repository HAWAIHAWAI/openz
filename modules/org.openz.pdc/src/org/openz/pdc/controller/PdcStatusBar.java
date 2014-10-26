package org.openz.pdc.controller;

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openz.util.LocalizationUtils;
import org.openz.view.Formhelper;
import org.openz.view.Scripthelper;

public class PdcStatusBar {
  public static String getStatusBar(HttpSecureAppServlet servlet,VariablesSecureApp vars,Scripthelper script) {
    String color,text="";
    Formhelper fh= new Formhelper();
    if (! vars.getSessionValue("PDCSTATUS").equals("OK") && ! vars.getSessionValue("PDCSTATUS").isEmpty()) {
      color = "#B40404;";
      try {
        
        text=LocalizationUtils.getElementTextByElementName(servlet, vars.getSessionValue("PDCSTATUS") , vars.getLanguage());
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      text= text + " - " +  vars.getSessionValue("PDCSTATUSTEXT");
    }
    else {
      color="#000000;";
      text=vars.getSessionValue("PDCSTATUSTEXT");
    }
    try {
      return fh.prepareInfobar(servlet, vars, script,text,"font-size: 24pt; color: " + color);
    } catch (Exception e) { 
      return "";
    }
  }
  
}
