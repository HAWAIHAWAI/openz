package org.openz.controller.testcases;
/*****************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
*/
import org.openz.view.*;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.data.FieldProvider;
import org.openz.view.templates.*;
import org.openbravo.utils.Replace;
import org.openbravo.erpCommon.businessUtility.WindowTabs;

public class ManualTabPaneTest implements ManualTabPane{

  public String getFormEdit(HttpSecureAppServlet servlet,VariablesSecureApp vars,FieldProvider data,WindowTabs tabs) throws Exception{
    String toolbarid=FormhelperData.getTabEditionToolbar(servlet,servlet.getClass().getName());
    
    Scripthelper script = new Scripthelper();
    String strLeftabsmode=FormhelperData.getLeftTabsMode4Tab(servlet,servlet.getClass().getName());
    String strSkeleton = ConfigureFrameWindow.doConfigure(servlet,vars,"description",tabs.breadcrumb(), "Test Form Window",toolbarid,strLeftabsmode,tabs);
    Formhelper fh=new Formhelper();
    String strTableStructure=fh.prepareFieldgroup(servlet, vars, script, "OrderlineManualTabPane", data,true);
    strSkeleton=Replace.replace(strSkeleton, "@CONTENT@", strTableStructure);  
    strSkeleton = script.doScript(strSkeleton, "",servlet,vars);
    return strSkeleton;
  }
  
}
