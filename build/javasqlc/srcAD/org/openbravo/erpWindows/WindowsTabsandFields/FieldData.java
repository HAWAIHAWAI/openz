//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.WindowsTabsandFields;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

/**
WAD Generated class
 */
class FieldData implements FieldProvider {
static Logger log4j = Logger.getLogger(FieldData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adTabId;
  public String adTabIdr;
  public String adModuleId;
  public String adModuleIdr;
  public String name;
  public String description;
  public String isactive;
  public String adColumnVId;
  public String adColumnVIdr;
  public String adFieldgroupId;
  public String adFieldgroupIdr;
  public String iscentrallymaintained;
  public String isfiltercolumn;
  public String colstotal;
  public String colstotalr;
  public String maxlength;
  public String adProcessId;
  public String adProcessIdr;
  public String adCalloutId;
  public String adCalloutIdr;
  public String fieldreference;
  public String fieldreferencer;
  public String tablereference;
  public String tablereferencer;
  public String validationrule;
  public String validationruler;
  public String includesemptyitem;
  public String template;
  public String templater;
  public String buttonclass;
  public String isdisplayed;
  public String isreadonly;
  public String required;
  public String displaylogic;
  public String readonlylogic;
  public String mandantorylogic;
  public String defaultvalue;
  public String onchangeevent;
  public String style;
  public String seqno;
  public String issameline;
  public String displaylength;
  public String isfirstfocusedfield;
  public String isfieldonly;
  public String showinrelation;
  public String gridseqno;
  public String gridlength;
  public String adOrgId;
  public String referenceurl;
  public String isidentifiercolumn;
  public String adFieldVId;
  public String adClientId;
  public String language;
  public String adUserClient;
  public String adOrgClient;
  public String createdby;
  public String trBgcolor;
  public String totalCount;
  public String dateTimeFormat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdbyr"))
      return createdbyr;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updated_time_stamp") || fieldName.equals("updatedTimeStamp"))
      return updatedTimeStamp;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("updatedbyr"))
      return updatedbyr;
    else if (fieldName.equalsIgnoreCase("ad_tab_id") || fieldName.equals("adTabId"))
      return adTabId;
    else if (fieldName.equalsIgnoreCase("ad_tab_idr") || fieldName.equals("adTabIdr"))
      return adTabIdr;
    else if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
    else if (fieldName.equalsIgnoreCase("ad_module_idr") || fieldName.equals("adModuleIdr"))
      return adModuleIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_column_v_id") || fieldName.equals("adColumnVId"))
      return adColumnVId;
    else if (fieldName.equalsIgnoreCase("ad_column_v_idr") || fieldName.equals("adColumnVIdr"))
      return adColumnVIdr;
    else if (fieldName.equalsIgnoreCase("ad_fieldgroup_id") || fieldName.equals("adFieldgroupId"))
      return adFieldgroupId;
    else if (fieldName.equalsIgnoreCase("ad_fieldgroup_idr") || fieldName.equals("adFieldgroupIdr"))
      return adFieldgroupIdr;
    else if (fieldName.equalsIgnoreCase("iscentrallymaintained"))
      return iscentrallymaintained;
    else if (fieldName.equalsIgnoreCase("isfiltercolumn"))
      return isfiltercolumn;
    else if (fieldName.equalsIgnoreCase("colstotal"))
      return colstotal;
    else if (fieldName.equalsIgnoreCase("colstotalr"))
      return colstotalr;
    else if (fieldName.equalsIgnoreCase("maxlength"))
      return maxlength;
    else if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
    else if (fieldName.equalsIgnoreCase("ad_process_idr") || fieldName.equals("adProcessIdr"))
      return adProcessIdr;
    else if (fieldName.equalsIgnoreCase("ad_callout_id") || fieldName.equals("adCalloutId"))
      return adCalloutId;
    else if (fieldName.equalsIgnoreCase("ad_callout_idr") || fieldName.equals("adCalloutIdr"))
      return adCalloutIdr;
    else if (fieldName.equalsIgnoreCase("fieldreference"))
      return fieldreference;
    else if (fieldName.equalsIgnoreCase("fieldreferencer"))
      return fieldreferencer;
    else if (fieldName.equalsIgnoreCase("tablereference"))
      return tablereference;
    else if (fieldName.equalsIgnoreCase("tablereferencer"))
      return tablereferencer;
    else if (fieldName.equalsIgnoreCase("validationrule"))
      return validationrule;
    else if (fieldName.equalsIgnoreCase("validationruler"))
      return validationruler;
    else if (fieldName.equalsIgnoreCase("includesemptyitem"))
      return includesemptyitem;
    else if (fieldName.equalsIgnoreCase("template"))
      return template;
    else if (fieldName.equalsIgnoreCase("templater"))
      return templater;
    else if (fieldName.equalsIgnoreCase("buttonclass"))
      return buttonclass;
    else if (fieldName.equalsIgnoreCase("isdisplayed"))
      return isdisplayed;
    else if (fieldName.equalsIgnoreCase("isreadonly"))
      return isreadonly;
    else if (fieldName.equalsIgnoreCase("required"))
      return required;
    else if (fieldName.equalsIgnoreCase("displaylogic"))
      return displaylogic;
    else if (fieldName.equalsIgnoreCase("readonlylogic"))
      return readonlylogic;
    else if (fieldName.equalsIgnoreCase("mandantorylogic"))
      return mandantorylogic;
    else if (fieldName.equalsIgnoreCase("defaultvalue"))
      return defaultvalue;
    else if (fieldName.equalsIgnoreCase("onchangeevent"))
      return onchangeevent;
    else if (fieldName.equalsIgnoreCase("style"))
      return style;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("issameline"))
      return issameline;
    else if (fieldName.equalsIgnoreCase("displaylength"))
      return displaylength;
    else if (fieldName.equalsIgnoreCase("isfirstfocusedfield"))
      return isfirstfocusedfield;
    else if (fieldName.equalsIgnoreCase("isfieldonly"))
      return isfieldonly;
    else if (fieldName.equalsIgnoreCase("showinrelation"))
      return showinrelation;
    else if (fieldName.equalsIgnoreCase("gridseqno"))
      return gridseqno;
    else if (fieldName.equalsIgnoreCase("gridlength"))
      return gridlength;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("referenceurl"))
      return referenceurl;
    else if (fieldName.equalsIgnoreCase("isidentifiercolumn"))
      return isidentifiercolumn;
    else if (fieldName.equalsIgnoreCase("ad_field_v_id") || fieldName.equals("adFieldVId"))
      return adFieldVId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("language"))
      return language;
    else if (fieldName.equals("adUserClient"))
      return adUserClient;
    else if (fieldName.equals("adOrgClient"))
      return adOrgClient;
    else if (fieldName.equals("createdby"))
      return createdby;
    else if (fieldName.equals("trBgcolor"))
      return trBgcolor;
    else if (fieldName.equals("totalCount"))
      return totalCount;
    else if (fieldName.equals("dateTimeFormat"))
      return dateTimeFormat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for edit
 */
  public static FieldData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adTabId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adTabId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static FieldData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adTabId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_field_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_field_v.CreatedBy) as CreatedByR, " +
      "        to_char(ad_field_v.Updated, ?) as updated, " +
      "        to_char(ad_field_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_field_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_field_v.UpdatedBy) as UpdatedByR," +
      "        ad_field_v.AD_Tab_ID, " +
      "(CASE WHEN ad_field_v.AD_Tab_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS AD_Tab_IDR, " +
      "ad_field_v.AD_Module_ID, " +
      "(CASE WHEN ad_field_v.AD_Module_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Version), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_Module_IDR, " +
      "ad_field_v.Name, " +
      "ad_field_v.Description, " +
      "COALESCE(ad_field_v.Isactive, 'N') AS Isactive, " +
      "ad_field_v.AD_Column_V_ID, " +
      "(CASE WHEN ad_field_v.AD_Column_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Columnname), ''))),'') ) END) AS AD_Column_V_IDR, " +
      "ad_field_v.AD_Fieldgroup_ID, " +
      "(CASE WHEN ad_field_v.AD_Fieldgroup_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS AD_Fieldgroup_IDR, " +
      "COALESCE(ad_field_v.Iscentrallymaintained, 'N') AS Iscentrallymaintained, " +
      "COALESCE(ad_field_v.Isfiltercolumn, 'N') AS Isfiltercolumn, " +
      "ad_field_v.Colstotal, " +
      "(CASE WHEN ad_field_v.Colstotal IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ColstotalR, " +
      "ad_field_v.Maxlength, " +
      "ad_field_v.AD_Process_ID, " +
      "(CASE WHEN ad_field_v.AD_Process_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL7.Name IS NULL THEN TO_CHAR(table7.Name) ELSE TO_CHAR(tableTRL7.Name) END)), ''))),'') ) END) AS AD_Process_IDR, " +
      "ad_field_v.AD_Callout_ID, " +
      "(CASE WHEN ad_field_v.AD_Callout_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS AD_Callout_IDR, " +
      "ad_field_v.Fieldreference, " +
      "(CASE WHEN ad_field_v.Fieldreference IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL9.Name IS NULL THEN TO_CHAR(table9.Name) ELSE TO_CHAR(tableTRL9.Name) END)), ''))),'') ) END) AS FieldreferenceR, " +
      "ad_field_v.Tablereference, " +
      "(CASE WHEN ad_field_v.Tablereference IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.TableName), ''))),'') ) END) AS TablereferenceR, " +
      "ad_field_v.Validationrule, " +
      "(CASE WHEN ad_field_v.Validationrule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS ValidationruleR, " +
      "COALESCE(ad_field_v.Includesemptyitem, 'N') AS Includesemptyitem, " +
      "ad_field_v.Template, " +
      "(CASE WHEN ad_field_v.Template IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS TemplateR, " +
      "ad_field_v.Buttonclass, " +
      "COALESCE(ad_field_v.Isdisplayed, 'N') AS Isdisplayed, " +
      "COALESCE(ad_field_v.Isreadonly, 'N') AS Isreadonly, " +
      "COALESCE(ad_field_v.Required, 'N') AS Required, " +
      "ad_field_v.Displaylogic, " +
      "ad_field_v.Readonlylogic, " +
      "ad_field_v.Mandantorylogic, " +
      "ad_field_v.Defaultvalue, " +
      "ad_field_v.Onchangeevent, " +
      "ad_field_v.Style, " +
      "ad_field_v.Seqno, " +
      "COALESCE(ad_field_v.Issameline, 'N') AS Issameline, " +
      "ad_field_v.Displaylength, " +
      "COALESCE(ad_field_v.Isfirstfocusedfield, 'N') AS Isfirstfocusedfield, " +
      "COALESCE(ad_field_v.Isfieldonly, 'N') AS Isfieldonly, " +
      "COALESCE(ad_field_v.Showinrelation, 'N') AS Showinrelation, " +
      "ad_field_v.Gridseqno, " +
      "ad_field_v.Gridlength, " +
      "ad_field_v.AD_Org_ID, " +
      "ad_field_v.Referenceurl, " +
      "COALESCE(ad_field_v.Isidentifiercolumn, 'N') AS Isidentifiercolumn, " +
      "ad_field_v.AD_Field_V_ID, " +
      "ad_field_v.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_field_v left join (select AD_Tab_ID, Name, AD_Window_ID from AD_Tab) table1 on (ad_field_v.AD_Tab_ID = table1.AD_Tab_ID) left join (select AD_Tab_ID,AD_Language, Name from AD_Tab_TRL) tableTRL1 on (table1.AD_Tab_ID = tableTRL1.AD_Tab_ID and tableTRL1.AD_Language = ?)  left join (select AD_Window_ID, Name from AD_Window) table2 on (table1.AD_Window_ID = table2.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL2 on (table2.AD_Window_ID = tableTRL2.AD_Window_ID and tableTRL2.AD_Language = ?)  left join (select AD_Module_ID, Name, Version, AD_Language from AD_Module) table3 on (ad_field_v.AD_Module_ID = table3.AD_Module_ID) left join (select AD_Language, Name from AD_Language) table4 on (table3.AD_Language =  table4.AD_Language) left join (select AD_Column_V_ID, Columnname from AD_Column_V) table5 on (ad_field_v.AD_Column_V_ID = table5.AD_Column_V_ID) left join (select AD_Fieldgroup_ID, Name from AD_Fieldgroup) table6 on (ad_field_v.AD_Fieldgroup_ID = table6.AD_Fieldgroup_ID) left join ad_ref_list_v list1 on (ad_field_v.Colstotal = list1.value and list1.ad_reference_id = '7FFBAD874C6F463D866894F42ECAE6BD' and list1.ad_language = ?)  left join (select AD_Process_ID, Name from AD_Process) table7 on (ad_field_v.AD_Process_ID = table7.AD_Process_ID) left join (select AD_Process_ID,AD_Language, Name from AD_Process_TRL) tableTRL7 on (table7.AD_Process_ID = tableTRL7.AD_Process_ID and tableTRL7.AD_Language = ?)  left join (select AD_Callout_ID, Name from AD_Callout) table8 on (ad_field_v.AD_Callout_ID = table8.AD_Callout_ID) left join (select AD_Reference_ID, Name from AD_Reference) table9 on (ad_field_v.Fieldreference =  table9.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL9 on (table9.AD_Reference_ID = tableTRL9.AD_Reference_ID and tableTRL9.AD_Language = ?)  left join (select AD_Table_ID, TableName from AD_Table) table10 on (ad_field_v.Tablereference =  table10.AD_Table_ID) left join (select AD_Val_Rule_ID, Name from AD_Val_Rule) table11 on (ad_field_v.Validationrule =  table11.AD_Val_Rule_ID) left join ad_ref_list_v list2 on (ad_field_v.Template = list2.value and list2.ad_reference_id = '029984D63BCA4F67AD81C93DCF486DFE' and list2.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adTabId==null || adTabId.equals(""))?"":"  AND ad_field_v.AD_Tab_ID = ?  ");
    strSql = strSql + 
      "        AND ad_field_v.AD_Field_V_ID = ? " +
      "        AND ad_field_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_field_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (adTabId != null && !(adTabId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        FieldData objectFieldData = new FieldData();
        objectFieldData.created = UtilSql.getValue(result, "created");
        objectFieldData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectFieldData.updated = UtilSql.getValue(result, "updated");
        objectFieldData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectFieldData.updatedby = UtilSql.getValue(result, "updatedby");
        objectFieldData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectFieldData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectFieldData.adTabIdr = UtilSql.getValue(result, "ad_tab_idr");
        objectFieldData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectFieldData.adModuleIdr = UtilSql.getValue(result, "ad_module_idr");
        objectFieldData.name = UtilSql.getValue(result, "name");
        objectFieldData.description = UtilSql.getValue(result, "description");
        objectFieldData.isactive = UtilSql.getValue(result, "isactive");
        objectFieldData.adColumnVId = UtilSql.getValue(result, "ad_column_v_id");
        objectFieldData.adColumnVIdr = UtilSql.getValue(result, "ad_column_v_idr");
        objectFieldData.adFieldgroupId = UtilSql.getValue(result, "ad_fieldgroup_id");
        objectFieldData.adFieldgroupIdr = UtilSql.getValue(result, "ad_fieldgroup_idr");
        objectFieldData.iscentrallymaintained = UtilSql.getValue(result, "iscentrallymaintained");
        objectFieldData.isfiltercolumn = UtilSql.getValue(result, "isfiltercolumn");
        objectFieldData.colstotal = UtilSql.getValue(result, "colstotal");
        objectFieldData.colstotalr = UtilSql.getValue(result, "colstotalr");
        objectFieldData.maxlength = UtilSql.getValue(result, "maxlength");
        objectFieldData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectFieldData.adProcessIdr = UtilSql.getValue(result, "ad_process_idr");
        objectFieldData.adCalloutId = UtilSql.getValue(result, "ad_callout_id");
        objectFieldData.adCalloutIdr = UtilSql.getValue(result, "ad_callout_idr");
        objectFieldData.fieldreference = UtilSql.getValue(result, "fieldreference");
        objectFieldData.fieldreferencer = UtilSql.getValue(result, "fieldreferencer");
        objectFieldData.tablereference = UtilSql.getValue(result, "tablereference");
        objectFieldData.tablereferencer = UtilSql.getValue(result, "tablereferencer");
        objectFieldData.validationrule = UtilSql.getValue(result, "validationrule");
        objectFieldData.validationruler = UtilSql.getValue(result, "validationruler");
        objectFieldData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectFieldData.template = UtilSql.getValue(result, "template");
        objectFieldData.templater = UtilSql.getValue(result, "templater");
        objectFieldData.buttonclass = UtilSql.getValue(result, "buttonclass");
        objectFieldData.isdisplayed = UtilSql.getValue(result, "isdisplayed");
        objectFieldData.isreadonly = UtilSql.getValue(result, "isreadonly");
        objectFieldData.required = UtilSql.getValue(result, "required");
        objectFieldData.displaylogic = UtilSql.getValue(result, "displaylogic");
        objectFieldData.readonlylogic = UtilSql.getValue(result, "readonlylogic");
        objectFieldData.mandantorylogic = UtilSql.getValue(result, "mandantorylogic");
        objectFieldData.defaultvalue = UtilSql.getValue(result, "defaultvalue");
        objectFieldData.onchangeevent = UtilSql.getValue(result, "onchangeevent");
        objectFieldData.style = UtilSql.getValue(result, "style");
        objectFieldData.seqno = UtilSql.getValue(result, "seqno");
        objectFieldData.issameline = UtilSql.getValue(result, "issameline");
        objectFieldData.displaylength = UtilSql.getValue(result, "displaylength");
        objectFieldData.isfirstfocusedfield = UtilSql.getValue(result, "isfirstfocusedfield");
        objectFieldData.isfieldonly = UtilSql.getValue(result, "isfieldonly");
        objectFieldData.showinrelation = UtilSql.getValue(result, "showinrelation");
        objectFieldData.gridseqno = UtilSql.getValue(result, "gridseqno");
        objectFieldData.gridlength = UtilSql.getValue(result, "gridlength");
        objectFieldData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectFieldData.referenceurl = UtilSql.getValue(result, "referenceurl");
        objectFieldData.isidentifiercolumn = UtilSql.getValue(result, "isidentifiercolumn");
        objectFieldData.adFieldVId = UtilSql.getValue(result, "ad_field_v_id");
        objectFieldData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectFieldData.language = UtilSql.getValue(result, "language");
        objectFieldData.adUserClient = "";
        objectFieldData.adOrgClient = "";
        objectFieldData.createdby = "";
        objectFieldData.trBgcolor = "";
        objectFieldData.totalCount = "";
        objectFieldData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFieldData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    FieldData objectFieldData[] = new FieldData[vector.size()];
    vector.copyInto(objectFieldData);
    return(objectFieldData);
  }

/**
Create a registry
 */
  public static FieldData[] set(String adTabId, String gridlength, String includesemptyitem, String seqno, String maxlength, String onchangeevent, String buttonclass, String adFieldVId, String isdisplayed, String description, String validationrule, String isactive, String createdby, String createdbyr, String gridseqno, String defaultvalue, String readonlylogic, String created, String adOrgId, String adClientId, String name, String adColumnVId, String required, String isreadonly, String referenceurl, String fieldreference, String tablereference, String template, String updatedby, String updatedbyr, String adProcessId, String isidentifiercolumn, String iscentrallymaintained, String displaylogic, String mandantorylogic, String style, String colstotal, String adFieldgroupId, String showinrelation, String isfieldonly, String isfirstfocusedfield, String adModuleId, String issameline, String isfiltercolumn, String adCalloutId, String displaylength)    throws ServletException {
    FieldData objectFieldData[] = new FieldData[1];
    objectFieldData[0] = new FieldData();
    objectFieldData[0].created = created;
    objectFieldData[0].createdbyr = createdbyr;
    objectFieldData[0].updated = "";
    objectFieldData[0].updatedTimeStamp = "";
    objectFieldData[0].updatedby = updatedby;
    objectFieldData[0].updatedbyr = updatedbyr;
    objectFieldData[0].adTabId = adTabId;
    objectFieldData[0].adTabIdr = "";
    objectFieldData[0].adModuleId = adModuleId;
    objectFieldData[0].adModuleIdr = "";
    objectFieldData[0].name = name;
    objectFieldData[0].description = description;
    objectFieldData[0].isactive = isactive;
    objectFieldData[0].adColumnVId = adColumnVId;
    objectFieldData[0].adColumnVIdr = "";
    objectFieldData[0].adFieldgroupId = adFieldgroupId;
    objectFieldData[0].adFieldgroupIdr = "";
    objectFieldData[0].iscentrallymaintained = iscentrallymaintained;
    objectFieldData[0].isfiltercolumn = isfiltercolumn;
    objectFieldData[0].colstotal = colstotal;
    objectFieldData[0].colstotalr = "";
    objectFieldData[0].maxlength = maxlength;
    objectFieldData[0].adProcessId = adProcessId;
    objectFieldData[0].adProcessIdr = "";
    objectFieldData[0].adCalloutId = adCalloutId;
    objectFieldData[0].adCalloutIdr = "";
    objectFieldData[0].fieldreference = fieldreference;
    objectFieldData[0].fieldreferencer = "";
    objectFieldData[0].tablereference = tablereference;
    objectFieldData[0].tablereferencer = "";
    objectFieldData[0].validationrule = validationrule;
    objectFieldData[0].validationruler = "";
    objectFieldData[0].includesemptyitem = includesemptyitem;
    objectFieldData[0].template = template;
    objectFieldData[0].templater = "";
    objectFieldData[0].buttonclass = buttonclass;
    objectFieldData[0].isdisplayed = isdisplayed;
    objectFieldData[0].isreadonly = isreadonly;
    objectFieldData[0].required = required;
    objectFieldData[0].displaylogic = displaylogic;
    objectFieldData[0].readonlylogic = readonlylogic;
    objectFieldData[0].mandantorylogic = mandantorylogic;
    objectFieldData[0].defaultvalue = defaultvalue;
    objectFieldData[0].onchangeevent = onchangeevent;
    objectFieldData[0].style = style;
    objectFieldData[0].seqno = seqno;
    objectFieldData[0].issameline = issameline;
    objectFieldData[0].displaylength = displaylength;
    objectFieldData[0].isfirstfocusedfield = isfirstfocusedfield;
    objectFieldData[0].isfieldonly = isfieldonly;
    objectFieldData[0].showinrelation = showinrelation;
    objectFieldData[0].gridseqno = gridseqno;
    objectFieldData[0].gridlength = gridlength;
    objectFieldData[0].adOrgId = adOrgId;
    objectFieldData[0].referenceurl = referenceurl;
    objectFieldData[0].isidentifiercolumn = isidentifiercolumn;
    objectFieldData[0].adFieldVId = adFieldVId;
    objectFieldData[0].adClientId = adClientId;
    objectFieldData[0].language = "";
    return objectFieldData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefEEAFCC7B49FE47D1865D991FD4CEB9BC(ConnectionProvider connectionProvider, String AD_Tab_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(SeqNo),0)+10 AS DefaultValue FROM AD_Field WHERE AD_Tab_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Tab_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef4EC6BE0244F94AE5939B67363E60372D_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Createdby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedbyR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "createdby");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDefFF872D2CDF5149DDA335EFC05F0CDA71_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Updatedby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedbyR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updatedby");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef4D94EE4A22F14335BB280644DD90CA87(ConnectionProvider connectionProvider, String AD_Tab_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_MODULE_ID FROM AD_TAB WHERE AD_TAB_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Tab_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_module_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_field_v.AD_Tab_ID AS NAME" +
      "        FROM ad_field_v" +
      "        WHERE ad_field_v.AD_Field_V_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for parent field
 */
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))) AS NAME FROM AD_Tab left join (select AD_Tab_ID, Name, AD_Window_ID from AD_Tab) table1 on (AD_Tab.AD_Tab_ID = table1.AD_Tab_ID) left join (select AD_Tab_ID,AD_Language, Name from AD_Tab_TRL) tableTRL1 on (table1.AD_Tab_ID = tableTRL1.AD_Tab_ID and tableTRL1.AD_Language = ?)  left join (select AD_Window_ID, Name from AD_Window) table2 on (table1.AD_Window_ID = table2.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL2 on (table2.AD_Window_ID = tableTRL2.AD_Window_ID and tableTRL2.AD_Language = ?)  WHERE AD_Tab.AD_Tab_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for parent field
 */
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))) AS NAME FROM AD_Tab left join (select AD_Tab_ID, Name, AD_Window_ID from AD_Tab) table1 on (AD_Tab.AD_Tab_ID = table1.AD_Tab_ID) left join (select AD_Tab_ID,AD_Language, Name from AD_Tab_TRL) tableTRL1 on (table1.AD_Tab_ID = tableTRL1.AD_Tab_ID and tableTRL1.AD_Language = ?)  left join (select AD_Window_ID, Name from AD_Window) table2 on (table1.AD_Window_ID = table2.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL2 on (table2.AD_Window_ID = tableTRL2.AD_Window_ID and tableTRL2.AD_Language = ?)  WHERE AD_Tab.AD_Tab_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE ad_field_v" +
      "        SET AD_Tab_ID = (?) , AD_Module_ID = (?) , Name = (?) , Description = (?) , Isactive = (?) , AD_Column_V_ID = (?) , AD_Fieldgroup_ID = (?) , Iscentrallymaintained = (?) , Isfiltercolumn = (?) , Colstotal = (?) , Maxlength = TO_NUMBER(?) , AD_Process_ID = (?) , AD_Callout_ID = (?) , Fieldreference = (?) , Tablereference = (?) , Validationrule = (?) , Includesemptyitem = (?) , Template = (?) , Buttonclass = (?) , Isdisplayed = (?) , Isreadonly = (?) , Required = (?) , Displaylogic = (?) , Readonlylogic = (?) , Mandantorylogic = (?) , Defaultvalue = (?) , Onchangeevent = (?) , Style = (?) , Seqno = TO_NUMBER(?) , Issameline = (?) , Displaylength = TO_NUMBER(?) , Isfirstfocusedfield = (?) , Isfieldonly = (?) , Showinrelation = (?) , Gridseqno = TO_NUMBER(?) , Gridlength = TO_NUMBER(?) , AD_Org_ID = (?) , Isidentifiercolumn = (?) , AD_Client_ID = (?) , AD_Field_V_ID = (?) , Referenceurl = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_field_v.AD_Field_V_ID = ? " +
      "                 AND ad_field_v.AD_Tab_ID = ? " +
      "        AND ad_field_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_field_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldgroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscentrallymaintained);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfiltercolumn);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colstotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adCalloutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fieldreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tablereference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validationrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, buttonclass);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisplayed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreadonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, required);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displaylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onchangeevent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, style);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issameline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displaylength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfirstfocusedfield);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfieldonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showinrelation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gridseqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gridlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isidentifiercolumn);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO ad_field_v " +
      "        (AD_Tab_ID, AD_Module_ID, Name, Description, Isactive, AD_Column_V_ID, AD_Fieldgroup_ID, Iscentrallymaintained, Isfiltercolumn, Colstotal, Maxlength, AD_Process_ID, AD_Callout_ID, Fieldreference, Tablereference, Validationrule, Includesemptyitem, Template, Buttonclass, Isdisplayed, Isreadonly, Required, Displaylogic, Readonlylogic, Mandantorylogic, Defaultvalue, Onchangeevent, Style, Seqno, Issameline, Displaylength, Isfirstfocusedfield, Isfieldonly, Showinrelation, Gridseqno, Gridlength, AD_Org_ID, Referenceurl, Isidentifiercolumn, AD_Field_V_ID, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldgroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscentrallymaintained);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfiltercolumn);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colstotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adCalloutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fieldreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tablereference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validationrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, buttonclass);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisplayed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreadonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, required);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displaylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onchangeevent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, style);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issameline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displaylength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfirstfocusedfield);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfieldonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showinrelation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gridseqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gridlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isidentifiercolumn);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int delete(ConnectionProvider connectionProvider, String param1, String adTabId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_field_v" +
      "        WHERE ad_field_v.AD_Field_V_ID = ? " +
      "                 AND ad_field_v.AD_Tab_ID = ? " +
      "        AND ad_field_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_field_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_field_v" +
      "        WHERE ad_field_v.AD_Field_V_ID = ? " +
      "                 AND ad_field_v.AD_Tab_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

/**
Select for relation
 */
  public static String selectOrg(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_ID" +
      "          FROM ad_field_v" +
      "         WHERE ad_field_v.AD_Field_V_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String getCurrentDBTimestamp(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp" +
      "          FROM ad_field_v" +
      "         WHERE ad_field_v.AD_Field_V_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updated_time_stamp");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }
}
