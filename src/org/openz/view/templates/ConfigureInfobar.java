package org.openz.view.templates;
/*
****************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.
Contributor(s): Danny A. Heuduk_.
***************************************************************************************************************************************************
*/
import java.io.IOException;
import org.openbravo.utils.Replace;
import org.openz.util.FileUtils;
import org.openz.util.LocalizationUtils;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openz.view.Scripthelper;

public class ConfigureInfobar {
 
  
  public static String doConfigure(HttpSecureAppServlet servlet,VariablesSecureApp vars,Scripthelper script, String infomessage, String additionalstyle) throws Exception{
    String retval="";
    final String directory= servlet.strBasePath;
    Object template =  servlet.getServletContext().getAttribute("infobarTEMPLATE");
    if (template==null) {
      template = new String(FileUtils.readFile("Infobar.xml", directory + "/src-loc/design/org/openz/view/templates/"));
      servlet.getServletContext().setAttribute("infobarTEMPLATE", template);
    }
    retval=retval + template.toString();
    retval=FileUtils.readFile("Infobar.xml", directory + "/src-loc/design/org/openz/view/templates/");
    retval=Replace.replace(retval, "@INFOMESSAGE@", infomessage);
    retval=Replace.replace(retval, "@ADDITIONALSTYLE@", additionalstyle);
    return retval;
  }
    
}
