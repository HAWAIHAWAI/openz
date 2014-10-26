package org.openz.view.templates;
/*
****************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
*/


import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.utils.Replace;
import org.openz.util.FileUtils;
import org.openz.view.SelectBoxhelper;
import org.openz.view.Scripthelper;

public class ConfigurePopupSelectBox {
 
  public static StringBuilder doConfigureNoLink(HttpSecureAppServlet servlet,VariablesSecureApp vars,Scripthelper script,String fieldname, int leadingemptycols,int colstotal,boolean required,boolean readonly,String selector,String currentidvalue,String callout,String tooltip, String adReferenceId,String elementId) throws Exception{
    if (currentidvalue==null)
      currentidvalue="";
    return doConfigureAll(servlet,vars,script,fieldname, leadingemptycols,colstotal,required,readonly,selector,currentidvalue,callout,"",false,"",tooltip,adReferenceId,false,elementId);
  }
  public static StringBuilder doConfigureLink(HttpSecureAppServlet servlet,VariablesSecureApp vars,Scripthelper script,String fieldname, int leadingemptycols,int colstotal,boolean required,boolean readonly,String selector,String currentidvalue,String callout,String tooltip, String adReferenceId,String elementId) throws Exception{
    if (currentidvalue==null)
      currentidvalue="";
    return doConfigureAll(servlet,vars,script,fieldname, leadingemptycols,colstotal,required,readonly,selector,currentidvalue,callout,"",false,"",tooltip,adReferenceId,true,elementId);
  }
  public static StringBuilder doConfigureGrid(HttpSecureAppServlet servlet,VariablesSecureApp vars,Scripthelper script,String fieldname, int colspan,boolean required,boolean readonly,String selector,String currentidvalue, String callout, String jssettings, String tooltip, String adReferenceId) throws Exception{
    if (currentidvalue==null)
      currentidvalue="";
    return doConfigureAll(servlet,vars,script,fieldname, 0,colspan+1,required,readonly,selector,currentidvalue,callout,"",true,jssettings,tooltip,adReferenceId,false,"");
  }
  private static StringBuilder doConfigureAll(HttpSecureAppServlet servlet,VariablesSecureApp vars,Scripthelper script,String fieldname, int leadingemptycols,int colstotal,boolean required,boolean readonly,String selector,String currentidvalue, String callout,String labeltext,boolean isGrid, String jssettings, String title, String adReferenceId, Boolean link,String elementId) throws Exception{
    StringBuilder retval= new StringBuilder();
    String   currenttextvalue="";
    if (jssettings==null)
      jssettings="";
    if (! currentidvalue.equals(""))
      currenttextvalue=SelectBoxhelper.getSelectorValueByID(servlet, vars, selector, currentidvalue);
    final String directory= servlet.strBasePath;
    String strrequired=Utility.messageBD(servlet, "JSMissing", vars.getLanguage());
    String icon=SelectBoxhelper.getSelectorICON(servlet,vars,selector);
    String url= ".." + SelectBoxhelper.getSelectorURL(servlet,vars,selector);
    String formname="frmMain";
    String stdJSSettings = jssettings;
    if (jssettings.equals(""))
      stdJSSettings =  "onkeydown=\"changeToEditingMode('onkeydown');\" onkeypress=\"changeToEditingMode('onkeypress');\" oncut=\"changeToEditingMode('oncut');\" onpaste=\"changeToEditingMode('onpaste');\" oncontextmenu=\"changeToEditingMode('oncontextmenu');\" onchange=\"validateTextBox(this.id);logChanges(this); @CALLOUT@ displayLogic(); return true;\"";
    for (int i = 0; i < leadingemptycols; i++) {
      retval.append("<td></td>");
    }
    if (! isGrid && ! readonly)
      if (link)
        retval.append(ConfigureLabel.doConfigureLink(servlet,vars,fieldname,"TitleCell",labeltext,adReferenceId,null,elementId));
      else
        retval.append(ConfigureLabel.doConfigure(servlet,vars,fieldname,"TitleCell",labeltext,elementId));
    if (! isGrid &&  readonly)
      if (link)
        retval.append(ConfigureLabel.doConfigureLink(servlet,vars,fieldname,"Label_ContentCell",labeltext,adReferenceId,null,elementId));
      else
        retval.append(ConfigureLabel.doConfigure(servlet,vars,fieldname,"Label_ContentCell",labeltext,elementId));
    Object template =  servlet.getServletContext().getAttribute("popupSelectboxTEMPLATE");
    if (template==null) {
      template = new String(FileUtils.readFile("PopupSelectbox.xml", directory + "/src-loc/design/org/openz/view/templates/"));
      servlet.getServletContext().setAttribute("popupSelectboxTEMPLATE", template);
    }
    retval.append(template.toString());
    template =  servlet.getServletContext().getAttribute("popupSelectboxButtonTEMPLATE");
    if (template==null) {
      template = new String(FileUtils.readFile("PopupSelectboxButton.xml", directory + "/src-loc/design/org/openz/view/templates/"));
      servlet.getServletContext().setAttribute("popupSelectboxButtonTEMPLATE", template);
    }
    String button = template.toString();
      
    if (readonly){
      Replace.replace(retval, "@BUTTON@","");
      Replace.replace(retval, "@CONTENTWIDTH@","100%");
    }
    else{
      Replace.replace(retval, "@BUTTON@", button);
      Replace.replace(retval, "@CONTENTWIDTH@","100%");
      Replace.replace(retval, "@BUTTONWIDTH@","27px");
    }
    if (isGrid)
       Replace.replace(retval, "@CONTENTCELLCLASS@","DataGrid_Content");
    else
       Replace.replace(retval, "@CONTENTCELLCLASS@", "Form_ContentCell");
    Replace.replace(retval, "@CLASS@", "inputWidth");
    Replace.replace(retval, "@JSSETTINGS@",stdJSSettings);
    Replace.replace(retval, "@NUMCOLS@", Integer.toString(colstotal-1));
    Replace.replace(retval, "@FIELDNAME@", fieldname);
    Replace.replace(retval, "@CURRENTTEXTVALUE@", currenttextvalue);
    Replace.replace(retval, "@CURRENTIDVALUE@", currentidvalue);
    Replace.replace(retval, "@TITLE@", title);
    Replace.replace(retval, "@CALLOUT@", callout);
    Replace.replace(retval, "@REQUIREDMESSAGE@",strrequired);
    if (required){
      Replace.replace(retval, "@REQUIREDTAG@", "required=\"true\"");
      Replace.replace(retval, "@REQUIRED@", "required");
    } else {
      Replace.replace(retval, "@REQUIREDTAG@", "");
      if (readonly)
        Replace.replace(retval, "@REQUIRED@", "cellreadonly");
      else
        Replace.replace(retval, "@REQUIRED@", "");
    }
    Replace.replace(retval, "@SELECTORURL@",url);
    Replace.replace(retval, "@SELECTORNAME@",selector);
    Replace.replace(retval, "@ICON@", icon);
    Replace.replace(retval, "@FORMNAME@",formname);
    if (readonly)
      Replace.replace(retval, "@READONLY@", "readonly=\"true\"");
    else
      Replace.replace(retval, "@READONLY@", "");
    Replace.replace(retval, "@MESSAGE@", "");
    // Add Opener Button-Shortcut
    script.addSearchButtonConfig(servlet, fieldname, selector);
    return retval;
  }
    
}
