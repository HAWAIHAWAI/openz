package org.openz.view;
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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.openz.util.*;
import org.openz.view.templates.*;
import org.openbravo.data.FieldProvider;
import java.util.*;
import org.openz.model.*;

import javax.servlet.ServletException;

import org.openbravo.utils.FormatUtilities;
import org.openbravo.utils.Replace;
import org.openbravo.data.Sqlc;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;


public class Formhelper{
  private Vector <ComboDatastore> combodatastore;
  class ComboDatastore {
    public String columnName;
    public String fpIdColumn;
    public FieldProvider[] data;
  }
  
  
  public Formhelper(){
    combodatastore=new Vector<ComboDatastore>();
    
  }
  
  public void addcombodata(FieldProvider[] fielddata, String fieldname, String fieldProviderIDColumn){
    ComboDatastore ds=new ComboDatastore();
    ds.data=fielddata;
    ds.columnName=fieldname;
    ds.fpIdColumn=fieldProviderIDColumn;
    combodatastore.add(ds);
  }
  
  
 
  
  public  String prepareFieldgroup(HttpSecureAppServlet servlet,VariablesSecureApp vars,Scripthelper script,String refname, FieldProvider fielddata, Boolean auditfields)  throws Exception {
    String refid=GridData.getReferenceID(servlet, refname);
    script.addHiddenfield("inpadRefFieldcolumnId", refid);
    String refcolcount=FormhelperData.getReferenceColumns(servlet, refid);
    FormhelperData[] data = FormhelperData.select(servlet, refid);
    return fieldgroupProcessor(servlet,vars,script,data,fielddata,refcolcount,auditfields,false,false,"",true,null,false);
  }
  
  public  String prepareProcessParameters(HttpSecureAppServlet servlet,VariablesSecureApp vars,Scripthelper script,String adProcessId)  throws Exception { 
    String refcolcount="4";
    FormhelperData[] data = FormhelperData.selectProcessParameter(servlet, vars.getLanguage(), adProcessId);
    return fieldgroupProcessor(servlet,vars,script,data,null,refcolcount,false,false,false,"",false,null,true);
   }
  
  public  String prepareTabFields(HttpSecureAppServlet servlet,VariablesSecureApp vars,Scripthelper script,String adTabId, FieldProvider fielddata, Boolean auditfields)  throws Exception { 
    String refcolcount="6";
    FormhelperData[] data = FormhelperData.selectTabFields(servlet, vars.getLanguage(), adTabId);
    String strTableID=CrudOperationsData.getTableIDFromTab(servlet, adTabId);
    String keyFieldname=CrudOperationsData.getIdColumnFromTable(servlet,  strTableID);
    String idValue=fielddata.getField(keyFieldname);
    CustomFieldData customfields= new CustomFieldData();
    customfields.select(servlet,idValue , adTabId, keyFieldname);
    return fieldgroupProcessor(servlet,vars,script,data,fielddata,refcolcount,true,false,false,"",true,customfields,false);
   }
  
  public  String prepareTabFieldsRO(HttpSecureAppServlet servlet,VariablesSecureApp vars,Scripthelper script,String adTabId, FieldProvider fielddata, Boolean auditfields)  throws Exception { 
    String refcolcount="6";
    FormhelperData[] data = FormhelperData.selectTabFields(servlet, vars.getLanguage(), adTabId);
    String strTableID=CrudOperationsData.getTableIDFromTab(servlet, adTabId);
    String keyFieldname=CrudOperationsData.getIdColumnFromTable(servlet,  strTableID);
    String idValue=fielddata.getField(keyFieldname);
    CustomFieldData customfields= new CustomFieldData();
    customfields.select(servlet,idValue , adTabId, keyFieldname);
    return fieldgroupProcessor(servlet,vars,script,data,fielddata,refcolcount,true,true,false,"",true,customfields,false);
   }
  
  public  String prepareBuscadorFields(HttpSecureAppServlet servlet,VariablesSecureApp vars,Scripthelper script,String adTabId)  throws Exception { 
    String refcolcount="4";
    String strWindowId = vars.getSessionValue("Buscador.inpWindowId");
    String strShowAudit = Utility.getContext(servlet, vars, "ShowAudit", strWindowId);
    FormhelperData[] data = FormhelperData.ad_selecttabBuscadorFields(servlet, vars.getLanguage(),adTabId,strShowAudit);
    return fieldgroupProcessor(servlet,vars,script,data,null,refcolcount,true,false,true,adTabId,false,null,false);
   }
 
  public  String TabGetFirstFocusField(HttpSecureAppServlet servlet,String adTabId)  throws Exception { 
    
    return FormhelperData.getFocusField(servlet, adTabId);
   }
  public static boolean isTabReadOnly(HttpSecureAppServlet servlet,VariablesSecureApp vars,String tabId)  {
    try {
    String test=SelectBoxhelperData.isTabReadOnly(servlet, tabId);
    if (test.equals("RO"))
      return true;
    else
      return false;
    } catch (Exception ex) {
      return false;
    }
  }  
  
 
  private String fieldgroupProcessor(HttpSecureAppServlet servlet,VariablesSecureApp vars,Scripthelper script,FormhelperData[] data,FieldProvider fielddata, String refcolcount,Boolean auditfields, Boolean globalreadonly,Boolean isBuscador,String buscadorTabId,Boolean createWithLinks, FieldProvider customfielddata, Boolean isProcess)  throws Exception    {
      String fieldvalue1="";
      String onchangeevent="";
      String fieldvalue2="";
      String fieldgroupid="";
      int totalcols=0;
      StringBuilder strTableCells= new StringBuilder(250000);
      int colsused=1000;
      Boolean isfirst=true;
      String tooltip="";
      String strTableStructure=ConfigureTableStructure.doConfigure(servlet,vars,refcolcount,"100%" ,"Main");
      String textelement="";
    for (int i = 0; i < data.length; i++){
      // First get the Fields Value
      fieldvalue1="";
      fieldvalue2="";
      tooltip="";
      // Get Values from field Provider
      if (fielddata!=null){
        fieldvalue1=fielddata.getField(data[i].name);
        fieldvalue2=fielddata.getField(data[i].name2);
         // get Tooltip
        tooltip=fielddata.getField("TOOLTIP" + data[i].name);
        if (tooltip==null)
          if (! (data[i].template.equals("PASSWORD") || data[i].template.equals("CHECKBOX") || data[i].template.equals("PATTRIBUTE") || data[i].template.equals("MULTISELECTOR") || data[i].template.equals("POPUPSEARCH")|| data[i].template.equals("REFCOMBO")|| data[i].template.equals("IMAGE")|| data[i].template.equals("LISTSORTER")|| data[i].template.equals("LISTSORTER_SIMPLE")))
          tooltip=fieldvalue1;
        if (fieldvalue1==null) {
          if (customfielddata!=null && !servlet.getCommandtype().equals("NEW"))
            fieldvalue1=customfielddata.getField(data[i].name);
          if (customfielddata!=null && servlet.getCommandtype().equals("NEW"))
            fieldvalue1=FormDisplayLogic.getFieldDefaultValue(servlet, vars, data[i].adRefFieldcolumnId);
          if (fieldvalue1==null) 
            fieldvalue1="";
        }
        if (fieldvalue2==null)
          fieldvalue2="";
      } 
      //
      // Implements the Display Logic.
      Boolean readonly = true;
      if (isBuscador)
        readonly = false;
      Boolean newfieldgroup = false;
      String visblelogic;
      if (isBuscador)
        visblelogic =FormDisplayLogic.fieldVisibleLogic(servlet, vars, script, data[i].adRefFieldcolumnId,fieldvalue1,false);
      else
        visblelogic =FormDisplayLogic.fieldVisibleLogic(servlet, vars, script, data[i].adRefFieldcolumnId,fieldvalue1,true);
      if (! globalreadonly && ! visblelogic.equals("HIDDEN") && ! isBuscador) {
         readonly =FormDisplayLogic.fieldReadOnlyLogic(servlet, vars, script, data[i].adRefFieldcolumnId,true);
      }
      Boolean required;
      if (isBuscador || readonly || visblelogic.equals("HIDDEN"))
        required= false;
      else
        required= FormDisplayLogic.fieldMandantoryLogic(servlet, vars, script, data[i].adRefFieldcolumnId,true);
      
      if (visblelogic.equals("DONOTGENERATE")) 
        data[i].template="DONOTGENERATE";
      // Used for Buscador
      if (isBuscador && ! data[i].template.equals("DONOTGENERATE")){
        String value=vars.getSessionValue(buscadorTabId + "|param" + data[i].name);
        if (data[i].template.equals("TEXT") && value.isEmpty())
          value="%";
        vars.setSessionValue(servlet.getClass().getName() + "|" + data[i].name, value);        
        script.addBuscador(servlet, vars, data[i].name, data[i].template);
      }
      // Genarate a new Table ROW on the Form, evtl. with fieldgroup
      if (!data[i].template.equals("DONOTGENERATE") &&
          (colsused >= Integer.parseInt(refcolcount) || data[i].islinebreak.equals("Y") || isfirst)){
        colsused=0;
        // get the fieldgroup
        if (! data[i].fieldgroupid.isEmpty() && ! data[i].fieldgroupid.equals(fieldgroupid)  ) {
          fieldgroupid=data[i].fieldgroupid;
          newfieldgroup=true;
          if (! isfirst )
            strTableCells=strTableCells.append("</tr>");
          if (FormhelperData.isFieldgrouphidden(servlet, fieldgroupid).equals("Y"))
            script.addOnload("zeige('" + data[i].fieldgroupid + "');");
          strTableCells=strTableCells.append(ConfigureFieldgroup.doConfigure(servlet,vars,script,FormhelperData.getFieldgroupname(servlet, fieldgroupid),refcolcount, LocalizationUtils.getFieldgroupText(servlet, fieldgroupid, vars.getLanguage()),fieldgroupid));
        } else
          newfieldgroup=false;
        if (! isfirst && ! newfieldgroup)
          strTableCells=strTableCells.append("</tr>");
        if (! fieldgroupid.isEmpty())
          strTableCells=strTableCells.append("<tr style=\"display: table-row;\" class=\"" + fieldgroupid + "\">");
        else
          strTableCells=strTableCells.append("<tr>");
        isfirst=false;
      } // Table ROW
      //
      // Get the Element or the Transalation Text
      if (data[i].translation.isEmpty())
        textelement=data[i].adElementId;
      else
        textelement=data[i].translation;
      onchangeevent= data[i].onchangeevent==null ? "" : data[i].onchangeevent;
      if (FormDisplayLogic.triggersComboReload(servlet,data[i].adRefFieldcolumnId ))
          onchangeevent="reloadCombos(this.name);" + onchangeevent  ;
      
      if (fielddata==null) {
        if (!servlet.getCommandtype().equals("NEW")){
          // If no data found, maybe there is something stored in the session....
          // Used esp. for setting Filters
          if (!servlet.getWindowId().equals(""))
            fieldvalue1=vars.getSessionValue(servlet.getWindowId() + "|" + data[i].name);
          else
            fieldvalue1=vars.getSessionValue(servlet.getClass().getName() + "|" + data[i].name);
        }
        if (servlet.getCommandtype().equals("NEW") || isProcess)
          // Get the Default Value
          fieldvalue1=FormDisplayLogic.getFieldDefaultValue(servlet, vars, data[i].adRefFieldcolumnId);
      }
      // Fires Callout on NEW 
      /*
      if (! data[i].template.equals("DONOTGENERATE") && servlet.getCommandtype().equals("NEW") && ! readonly && !fieldvalue1.isEmpty()) {
        OBError oe = vars.getMessage(servlet.getTabId());
        if (oe==null)
          script.addOnload("updateOnChange(frm.inp" + Sqlc.TransformaNombreColumna(data[i].name) + ");");
      }
      */
       // script.addOnload("frm." + Sqlc.TransformaNombreColumna(data[i].name) + ".onchange();");
      // Implements The Fields Structure
      totalcols=Integer.parseInt(data[i].colstotal)+Integer.parseInt(data[i].leadingemptycols);
      colsused=colsused+totalcols;
      if (data[i].template.equals("IDFIELD")){
        script.addHiddenfield("inp" + Sqlc.TransformaNombreColumna(data[i].name),fieldvalue1);
        script.addHiddenfield("inpKeyName","inp" + Sqlc.TransformaNombreColumna(data[i].name));
      }
      
      if (data[i].template.equals("BUTTON")){
        strTableCells=strTableCells.append(ConfigureButton.doConfigure(servlet, vars,script, Sqlc.TransformaNombreColumna(data[i].name), Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal), readonly, data[i].buttonclass, data[i].referenceurl.replace("@PATH@", servlet.strDireccion), fieldvalue1,textelement));
      }
      if (data[i].template.equals("CHECKBOX")){
        strTableCells=strTableCells.append(ConfigureCheckbox.doConfigure(servlet,vars,script,Sqlc.TransformaNombreColumna(data[i].name), Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal),  onchangeevent, "Y",fieldvalue1.equals("Y") ? true : false, readonly, tooltip,textelement));
      }
      if (data[i].template.equals("PATTRIBUTE")){
        strTableCells=strTableCells.append(ConfigurePAttribute.doConfigure(servlet, vars,script, Sqlc.TransformaNombreColumna(data[i].name),Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal), required, readonly,  fieldvalue1, onchangeevent,tooltip,textelement));
      }
      if (data[i].template.equals("DATE")){
        strTableCells=strTableCells.append(ConfigureDatebox.doConfigure(servlet, vars,script, Sqlc.TransformaNombreColumna(data[i].name),Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal), required, readonly,  fieldvalue1, onchangeevent,tooltip,textelement));
      }
      if (data[i].template.equals("TIME")){                                                                                                                                                                                                                                                                                                    
        strTableCells=strTableCells.append(ConfigureTimebox.doConfigure(servlet,vars,script,Sqlc.TransformaNombreColumna(data[i].name),Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal),Integer.parseInt(data[i].maxlength),required, readonly, onchangeevent ,fieldvalue1,tooltip,textelement));
      }
      if (data[i].template.equals("DECIMAL") || data[i].template.equals("EURO") || data[i].template.equals("INTEGER") || data[i].template.equals("PRICE")){
        strTableCells=strTableCells.append(ConfigureNumberbox.doConfigure(servlet, vars,script, Sqlc.TransformaNombreColumna(data[i].name), Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal), Integer.parseInt(data[i].maxlength), required, readonly, onchangeevent,data[i].template, fieldvalue1, tooltip,textelement));
      }
      if (data[i].template.equals("FIELDGROUP")){
        strTableCells=strTableCells.append(ConfigureFieldgroup.doConfigure(servlet,vars,script,Sqlc.TransformaNombreColumna(data[i].name),data[i].colstotal, "",""));
      }
      
      if (data[i].template.equals("MULTISELECTOR")){
        FieldProvider[] fp=null;
        String fpidcol="ID";
        for (int j = 0; j < combodatastore.size(); j++){
          if (combodatastore.elementAt(j).columnName.equals(data[i].name)){
            fp= combodatastore.elementAt(j).data;
            if (combodatastore.elementAt(j).fpIdColumn!=null)
              fpidcol=combodatastore.elementAt(j).fpIdColumn;
          }
        }
        
        String refName=GridData.getReferenceName(servlet, data[i].fieldreference);
        addselectorhiddenfields(servlet,script,data[i].fieldreference);
        strTableCells=strTableCells.append(ConfigureMultiSelector.doConfigure(servlet, vars,script, Sqlc.TransformaNombreColumna(data[i].name), Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal), required, readonly,  refName,"",fp,fpidcol,tooltip,textelement,onchangeevent));
      }
      if (data[i].template.equals("POPUPSEARCH")){
        String refName=GridData.getReferenceName(servlet, data[i].fieldreference);
        addselectorhiddenfields(servlet,script,data[i].fieldreference);
        if (createWithLinks)
          strTableCells=strTableCells.append(ConfigurePopupSelectBox.doConfigureLink(servlet, vars,script, Sqlc.TransformaNombreColumna(data[i].name), Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal), required, readonly,  refName, fieldvalue1,  onchangeevent, tooltip,data[i].fieldreference,textelement));
        else
          strTableCells=strTableCells.append(ConfigurePopupSelectBox.doConfigureNoLink(servlet, vars,script, Sqlc.TransformaNombreColumna(data[i].name), Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal), required, readonly,  refName, fieldvalue1,  onchangeevent, tooltip,data[i].fieldreference,textelement));
        if (isProcess) {
          String fname=Sqlc.TransformaNombreColumna(data[i].name) ;
          Replace.replace(strTableCells, "'inp" +fname + "_DES', document." + fname + ".inp" + fname + "_DES.value,","");
          Replace.replace(strTableCells, "'inpadOrgId', document.frmMain.inpadOrgId.value);","'inpadOrgId', inputValue(document.frmMain.inpadOrgId));");
        }
      }
      if (data[i].template.equals("RADIOBUTTON")){
        FormhelperData[] datar = FormhelperData.selectRadiogroup(servlet,data[i].adRefFieldcolumnId);
        for (int k = 0; k < Integer.parseInt(data[i].leadingemptycols); k++) {
          strTableCells=strTableCells.append("<td></td>");
        }
        Boolean checked=false;
        String value="";
        for (int j = 0; j < datar.length; j++){
          value=fieldvalue1;
          if (value.equals(datar[j].name))
            checked=true;
          else
            checked=false;
          strTableCells=strTableCells.append(ConfigureRadioButton.doConfigure(servlet, vars,script,datar[j].name, Sqlc.TransformaNombreColumna(data[i].name), checked, readonly, onchangeevent, "" ,textelement));
        } 
      }
      if (data[i].template.equals("REFCOMBO")){
        FieldProvider[] fp=null;
        String fpidcol="ID";
        for (int j = 0; j < combodatastore.size(); j++){
          if (combodatastore.elementAt(j).columnName.equals(data[i].name)){
            fp= combodatastore.elementAt(j).data;
            if (combodatastore.elementAt(j).fpIdColumn!=null)
              fpidcol=combodatastore.elementAt(j).fpIdColumn;
          }
        }
        String tableID="";
        if (fp==null && !data[i].fieldreference.isEmpty()) {
          fp=SelectBoxhelper.getReferenceDataByRefName(servlet, vars, GridData.getReferenceName(servlet, data[i].fieldreference),data[i].adValRuleId,fielddata,fieldvalue1,readonly);
          tableID=SelectBoxhelperData.getReferenceTableIDByRefID(servlet, data[i].fieldreference);
        }
        if (fp==null && !data[i].adTableId.isEmpty()) {
          fp=SelectBoxhelper.getReferenceDataByRefName(servlet, vars, GridData.getKeyColumnbyTable(servlet, data[i].adTableId),data[i].adValRuleId,fielddata,fieldvalue1,readonly);
          tableID=data[i].adTableId;
        }
        if (createWithLinks)
          strTableCells=strTableCells.append(ConfigureSelectBox.doConfigureLink(servlet, vars, script,  Sqlc.TransformaNombreColumna(data[i].name), Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal), required, readonly, onchangeevent, fieldvalue1, fp, fpidcol,tooltip,data[i].includesemptyitem.equals("Y") ? true : false, data[i].fieldreference , tableID,textelement));
        else
          strTableCells=strTableCells.append(ConfigureSelectBox.doConfigureNoLink(servlet, vars, script,  Sqlc.TransformaNombreColumna(data[i].name), Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal), required, readonly, onchangeevent, fieldvalue1, fp, fpidcol,tooltip,data[i].includesemptyitem.equals("Y") ? true : false, data[i].fieldreference , tableID,textelement));
      }
      if (data[i].template.equals("LISTSORTER")){
        FieldProvider[] fp1=null;
        FieldProvider[] fp2=null;
        String fpidcol1="ID";
        String fpidcol2="ID";
        for (int j = 0; j < combodatastore.size(); j++){
          if (combodatastore.elementAt(j).columnName.equals(data[i].name)){
            fp1= combodatastore.elementAt(j).data;
            if (combodatastore.elementAt(j).fpIdColumn!=null)
              fpidcol1=combodatastore.elementAt(j).fpIdColumn;
          }
          if (combodatastore.elementAt(j).columnName.equals(data[i].name2)){
            fp2= combodatastore.elementAt(j).data;
            if (combodatastore.elementAt(j).fpIdColumn!=null)
              fpidcol2=combodatastore.elementAt(j).fpIdColumn;
          }
        }
        
        strTableCells=strTableCells.append(ConfigureListSorter.doConfigure(servlet, vars,script, Sqlc.TransformaNombreColumna(data[i].name), Sqlc.TransformaNombreColumna(data[i].name2), Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal), fieldvalue1, fieldvalue2, fp1,fpidcol1, fp2,fpidcol2, readonly, "",tooltip,textelement));
      }
      if (data[i].template.equals("LISTSORTER_SIMPLE")){
        FieldProvider[] fp1=null;
        FieldProvider[] fp2=null;
        String fpidcol1="ID";
        String fpidcol2="ID";
        for (int j = 0; j < combodatastore.size(); j++){
          if (combodatastore.elementAt(j).columnName.equals(data[i].name)){
            fp1= combodatastore.elementAt(j).data;
            if (combodatastore.elementAt(j).fpIdColumn!=null)
              fpidcol1=combodatastore.elementAt(j).fpIdColumn;
          }
          if (combodatastore.elementAt(j).columnName.equals(data[i].name2)){
            fp2= combodatastore.elementAt(j).data;
            if (combodatastore.elementAt(j).fpIdColumn!=null)
              fpidcol2=combodatastore.elementAt(j).fpIdColumn;
          }
        }
        strTableCells=strTableCells.append(ConfigureListSorterSimple.doConfigure(servlet, vars,script, Sqlc.TransformaNombreColumna(data[i].name), Sqlc.TransformaNombreColumna(data[i].name2), Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal), fieldvalue1, fieldvalue2, fp1,fpidcol1, fp2,fpidcol2, readonly, "",tooltip,textelement));
      }
      if (data[i].template.equals("TEXT")){
        strTableCells=strTableCells.append(ConfigureTextbox.doConfigure(servlet,vars,script,Sqlc.TransformaNombreColumna(data[i].name),Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal),Integer.parseInt(data[i].maxlength),required, readonly, onchangeevent ,fieldvalue1,tooltip,textelement));
      }
      if (data[i].template.equals("PASSWORD")){
        strTableCells=strTableCells.append(ConfigurePassword.doConfigure(servlet, vars,script, data[i].name,Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal), required, readonly,  fieldvalue1, onchangeevent,tooltip,textelement));
      }
      if (data[i].template.equals("LABEL")){
        strTableCells=strTableCells.append(ConfigureLabel.doConfigure(servlet, vars, Sqlc.TransformaNombreColumna(data[i].name), "Label_ContentCell","",textelement,Integer.parseInt(data[i].colstotal)));
      }
      if (data[i].template.equals("NOEDIT_TEXTBOX")){
        strTableCells=strTableCells.append(ConfigureTextarea.doConfigure(servlet,vars,script,Sqlc.TransformaNombreColumna(data[i].name),Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal),Integer.parseInt(data[i].maxlength),required, readonly, "" ,fieldvalue1,tooltip, data[i].style,textelement));
      }
      if (data[i].template.equals("IMAGE")){
        strTableCells=strTableCells.append(ConfigureImage.doConfigure(servlet,vars,script,data[i].name,Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal),Integer.parseInt(data[i].maxlength),required, readonly, onchangeevent ,fieldvalue1,tooltip, data[i].style,textelement));
      }
      if (data[i].template.equals("URL")){
        strTableCells=strTableCells.append(ConfigureUrlbox.doConfigure(servlet, vars,script, Sqlc.TransformaNombreColumna(data[i].name),Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal),Integer.parseInt(data[i].maxlength), required, readonly,  fieldvalue1, onchangeevent,tooltip,textelement));
      }
      if (data[i].template.equals("TEXTAREA_EDIT_SIMPLE")){
        strTableCells=strTableCells.append(ConfigureTextareaEditableSimple.doConfigure(servlet,vars,script,Sqlc.TransformaNombreColumna(data[i].name),Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal),Integer.parseInt(data[i].maxlength),required, readonly, onchangeevent ,fieldvalue1,tooltip, data[i].style,textelement));
      }
      if (data[i].template.equals("TEXTAREA_EDIT_ADV")){
        strTableCells=strTableCells.append(ConfigureTextareaEditableAdvanced.doConfigure(servlet,vars,script,Sqlc.TransformaNombreColumna(data[i].name),Integer.parseInt(data[i].leadingemptycols), Integer.parseInt(data[i].colstotal),Integer.parseInt(data[i].maxlength),required, readonly, onchangeevent ,fieldvalue1,tooltip, data[i].style,textelement));
      }
      if (data[i].template.equals("EMPTYLINE")){
        if (! isfirst)
          strTableCells=strTableCells.append("</tr>");
        strTableCells=strTableCells.append("<tr><td class=\"emptyrow\">&nbsp;</td></tr>\n<tr>");
      }
    }
    if (auditfields && fielddata!=null){
      strTableCells=strTableCells.append(ConfigureFieldgroup.doConfigure(servlet,vars,script,"audit",refcolcount, "Audit",""));
      strTableCells=strTableCells.append("<tr class=\"auditfieldclass\" style=\"display: table-row;\">");
      strTableCells=strTableCells.append(ConfigureTextbox.doConfigure(servlet,vars,script,Sqlc.TransformaNombreColumna("created"),0, 2,250,false, true, "" ,fielddata.getField("created"),"",""));
      strTableCells=strTableCells.append(ConfigureTextbox.doConfigure(servlet,vars,script,Sqlc.TransformaNombreColumna("createdby"),1, 2,250,false, true, "" ,fielddata.getField("createdbyr"),"",""));
      strTableCells=strTableCells.append("</tr><tr class=\"auditfieldclass2\" style=\"display: table-row;\">");
      strTableCells=strTableCells.append(ConfigureTextbox.doConfigure(servlet,vars,script,Sqlc.TransformaNombreColumna("updated"),0, 2,250,false, true, "" ,fielddata.getField("updated"),"",""));
      strTableCells=strTableCells.append(ConfigureTextbox.doConfigure(servlet,vars,script,Sqlc.TransformaNombreColumna("updatedby"),1, 2,250,false, true, "" ,fielddata.getField("updatedbyr"),"",""));
      String logic="if (strShowAudit == 'Y'){\n"; 
      logic=logic +"         fieldDisplaySettings('audit', true);\n";
      logic=logic +"         setclassdidplaymode(\"auditfieldclass\",true);\n";
      logic=logic +"         setclassdidplaymode(\"auditfieldclass2\",true);\n";
      logic=logic+"     } else {\n";
      
      logic=logic +"         fieldDisplaySettings('audit', false);";
      logic=logic +"         setclassdidplaymode(\"auditfieldclass\",false);\n";
      logic=logic +"         setclassdidplaymode(\"auditfieldclass2\",false);\n";
      logic=logic +"}\n";
      script.addDisplayLogic(logic);

    }
    if (!strTableCells.toString().isEmpty()) {
        strTableCells=strTableCells.append("</tr>");
        strTableStructure = strTableStructure.replace("@CONTENT@", strTableCells.toString());
        return strTableStructure;   
    } else
      return "";
  }
  // End Of Fieldgroup Procesor
  
  
  private void addselectorhiddenfields(HttpSecureAppServlet servlet,Scripthelper script,String selectorRefID)  throws Exception    {
    FormhelperData[] datar = FormhelperData.getHiddenSelectorColumns(servlet, selectorRefID);
    for (int i=0;i<datar.length; i++){
      String hiddefield="inp" + Sqlc.TransformaNombreColumna(datar[i].selectorcolumnname) + datar[i].selectorcolumnsuffix;
      script.addHiddenfield(hiddefield, "");
    }
  }
  public static String getTabAccessLevel(HttpSecureAppServlet servlet,VariablesSecureApp vars,String tabId) throws Exception {
    return SelectBoxhelperData.getTabAccessLevel(servlet, tabId);
  }  
  public static String prepareToolbar(HttpSecureAppServlet servlet,VariablesSecureApp vars,String toolbarID) throws Exception{
    
    String msg="";
    String toolbar="<table class=\"Main_ContentPane_ToolBar Main_ToolBar_bg\" id=\"tdToolBar\"><tr>\n";
    final String directory= servlet.strBasePath; 
    String sep="<td class=\"Main_ToolBar_Separator_cell\" ><img src=\"../web/images/blank.gif\" class=\"Main_ToolBar_Separator\"></td>\n";
    String linkeditems=FileUtils.readFile("ToolbarLinkedItems.xml",directory + "/src-loc/design/org/openz/view/templates/");
    String sql = "SELECT toolbaritem,codesnippet,message from ad_toolbaritems where ad_toolbar_id = '" + toolbarID + "' order by seqno";
    Connection conn = servlet.getConnection();
    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    ResultSet res = stmt.executeQuery(sql);
    while (res.next()) {
      if (res.getString("toolbaritem").equals("SEPERATOR"))
        toolbar=toolbar+sep;
      if (res.getString("toolbaritem").equals("LINKEDITEMS"))
        toolbar=toolbar+linkeditems;
      if (!res.getString("toolbaritem").equals("SEPERATOR") && !res.getString("toolbaritem").equals("LINKEDITEMS")) {
        msg=LocalizationUtils.getMessageText(servlet,res.getString("message") , vars.getLanguage());
        toolbar=toolbar+Replace.replace(res.getString("codesnippet"), "@MESSAGE@", msg);
      }
    }
    conn.close();
    return toolbar + " </tr>\n</table>";
  }
  
  public String prepareInfobar(HttpSecureAppServlet servlet,VariablesSecureApp vars,Scripthelper script,String infomessage, String additionalstyle) throws Exception{
      
        String infobar=ConfigureInfobar.doConfigure(servlet,vars,script, infomessage, additionalstyle);
        return infobar;
      }
 
 }
