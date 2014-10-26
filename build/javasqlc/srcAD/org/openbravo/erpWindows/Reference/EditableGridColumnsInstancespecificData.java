//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Reference;

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
class EditableGridColumnsInstancespecificData implements FieldProvider {
static Logger log4j = Logger.getLogger(EditableGridColumnsInstancespecificData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adRefGridcolumnId;
  public String adRefGridcolumnIdr;
  public String line;
  public String adElementId;
  public String adElementIdr;
  public String visiblesetting;
  public String visiblesettingr;
  public String editsetting;
  public String editsettingr;
  public String isactive;
  public String colspan;
  public String required;
  public String requiredr;
  public String issecondheader;
  public String issecondheaderr;
  public String maxlength;
  public String isinheader;
  public String isinheaderr;
  public String colreference;
  public String colreferencer;
  public String referenceurl;
  public String adTableId;
  public String adTableIdr;
  public String adValRuleId;
  public String adValRuleIdr;
  public String includesemptyitem;
  public String includesemptyitemr;
  public String template;
  public String templater;
  public String issplitgroup;
  public String issplitgroupr;
  public String defaultvalue;
  public String onchangeevent;
  public String adRefGridcolumninstanceId;
  public String adClientId;
  public String issortable;
  public String readonlylogic;
  public String isrowkey;
  public String name;
  public String isdisplayed;
  public String headertext;
  public String readonly;
  public String adOrgId;
  public String mandantorylogic;
  public String rowkeysuffix;
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
    else if (fieldName.equalsIgnoreCase("ad_ref_gridcolumn_id") || fieldName.equals("adRefGridcolumnId"))
      return adRefGridcolumnId;
    else if (fieldName.equalsIgnoreCase("ad_ref_gridcolumn_idr") || fieldName.equals("adRefGridcolumnIdr"))
      return adRefGridcolumnIdr;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("ad_element_id") || fieldName.equals("adElementId"))
      return adElementId;
    else if (fieldName.equalsIgnoreCase("ad_element_idr") || fieldName.equals("adElementIdr"))
      return adElementIdr;
    else if (fieldName.equalsIgnoreCase("visiblesetting"))
      return visiblesetting;
    else if (fieldName.equalsIgnoreCase("visiblesettingr"))
      return visiblesettingr;
    else if (fieldName.equalsIgnoreCase("editsetting"))
      return editsetting;
    else if (fieldName.equalsIgnoreCase("editsettingr"))
      return editsettingr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("colspan"))
      return colspan;
    else if (fieldName.equalsIgnoreCase("required"))
      return required;
    else if (fieldName.equalsIgnoreCase("requiredr"))
      return requiredr;
    else if (fieldName.equalsIgnoreCase("issecondheader"))
      return issecondheader;
    else if (fieldName.equalsIgnoreCase("issecondheaderr"))
      return issecondheaderr;
    else if (fieldName.equalsIgnoreCase("maxlength"))
      return maxlength;
    else if (fieldName.equalsIgnoreCase("isinheader"))
      return isinheader;
    else if (fieldName.equalsIgnoreCase("isinheaderr"))
      return isinheaderr;
    else if (fieldName.equalsIgnoreCase("colreference"))
      return colreference;
    else if (fieldName.equalsIgnoreCase("colreferencer"))
      return colreferencer;
    else if (fieldName.equalsIgnoreCase("referenceurl"))
      return referenceurl;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("ad_table_idr") || fieldName.equals("adTableIdr"))
      return adTableIdr;
    else if (fieldName.equalsIgnoreCase("ad_val_rule_id") || fieldName.equals("adValRuleId"))
      return adValRuleId;
    else if (fieldName.equalsIgnoreCase("ad_val_rule_idr") || fieldName.equals("adValRuleIdr"))
      return adValRuleIdr;
    else if (fieldName.equalsIgnoreCase("includesemptyitem"))
      return includesemptyitem;
    else if (fieldName.equalsIgnoreCase("includesemptyitemr"))
      return includesemptyitemr;
    else if (fieldName.equalsIgnoreCase("template"))
      return template;
    else if (fieldName.equalsIgnoreCase("templater"))
      return templater;
    else if (fieldName.equalsIgnoreCase("issplitgroup"))
      return issplitgroup;
    else if (fieldName.equalsIgnoreCase("issplitgroupr"))
      return issplitgroupr;
    else if (fieldName.equalsIgnoreCase("defaultvalue"))
      return defaultvalue;
    else if (fieldName.equalsIgnoreCase("onchangeevent"))
      return onchangeevent;
    else if (fieldName.equalsIgnoreCase("ad_ref_gridcolumninstance_id") || fieldName.equals("adRefGridcolumninstanceId"))
      return adRefGridcolumninstanceId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("issortable"))
      return issortable;
    else if (fieldName.equalsIgnoreCase("readonlylogic"))
      return readonlylogic;
    else if (fieldName.equalsIgnoreCase("isrowkey"))
      return isrowkey;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("isdisplayed"))
      return isdisplayed;
    else if (fieldName.equalsIgnoreCase("headertext"))
      return headertext;
    else if (fieldName.equalsIgnoreCase("readonly"))
      return readonly;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("mandantorylogic"))
      return mandantorylogic;
    else if (fieldName.equalsIgnoreCase("rowkeysuffix"))
      return rowkeysuffix;
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
  public static EditableGridColumnsInstancespecificData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRefGridcolumnId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adRefGridcolumnId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static EditableGridColumnsInstancespecificData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRefGridcolumnId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_ref_gridcolumninstance.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_gridcolumninstance.CreatedBy) as CreatedByR, " +
      "        to_char(ad_ref_gridcolumninstance.Updated, ?) as updated, " +
      "        to_char(ad_ref_gridcolumninstance.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_ref_gridcolumninstance.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_gridcolumninstance.UpdatedBy) as UpdatedByR," +
      "        ad_ref_gridcolumninstance.AD_Ref_Gridcolumn_ID, " +
      "(CASE WHEN ad_ref_gridcolumninstance.AD_Ref_Gridcolumn_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Ref_Gridcolumn_IDR, " +
      "ad_ref_gridcolumninstance.Line, " +
      "ad_ref_gridcolumninstance.AD_Element_ID, " +
      "(CASE WHEN ad_ref_gridcolumninstance.AD_Element_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.ColumnName), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Element_IDR, " +
      "ad_ref_gridcolumninstance.Visiblesetting, " +
      "(CASE WHEN ad_ref_gridcolumninstance.Visiblesetting IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS VisiblesettingR, " +
      "ad_ref_gridcolumninstance.Editsetting, " +
      "(CASE WHEN ad_ref_gridcolumninstance.Editsetting IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS EditsettingR, " +
      "COALESCE(ad_ref_gridcolumninstance.Isactive, 'N') AS Isactive, " +
      "ad_ref_gridcolumninstance.Colspan, " +
      "ad_ref_gridcolumninstance.Required, " +
      "(CASE WHEN ad_ref_gridcolumninstance.Required IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS RequiredR, " +
      "ad_ref_gridcolumninstance.Issecondheader, " +
      "(CASE WHEN ad_ref_gridcolumninstance.Issecondheader IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS IssecondheaderR, " +
      "ad_ref_gridcolumninstance.Maxlength, " +
      "ad_ref_gridcolumninstance.Isinheader, " +
      "(CASE WHEN ad_ref_gridcolumninstance.Isinheader IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list5.name),'') ) END) AS IsinheaderR, " +
      "ad_ref_gridcolumninstance.Colreference, " +
      "(CASE WHEN ad_ref_gridcolumninstance.Colreference IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS ColreferenceR, " +
      "ad_ref_gridcolumninstance.Referenceurl, " +
      "ad_ref_gridcolumninstance.AD_Table_ID, " +
      "(CASE WHEN ad_ref_gridcolumninstance.AD_Table_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.TableName), ''))),'') ) END) AS AD_Table_IDR, " +
      "ad_ref_gridcolumninstance.AD_Val_Rule_ID, " +
      "(CASE WHEN ad_ref_gridcolumninstance.AD_Val_Rule_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_Val_Rule_IDR, " +
      "ad_ref_gridcolumninstance.Includesemptyitem, " +
      "(CASE WHEN ad_ref_gridcolumninstance.Includesemptyitem IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list6.name),'') ) END) AS IncludesemptyitemR, " +
      "ad_ref_gridcolumninstance.Template, " +
      "(CASE WHEN ad_ref_gridcolumninstance.Template IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list7.name),'') ) END) AS TemplateR, " +
      "ad_ref_gridcolumninstance.Issplitgroup, " +
      "(CASE WHEN ad_ref_gridcolumninstance.Issplitgroup IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list8.name),'') ) END) AS IssplitgroupR, " +
      "ad_ref_gridcolumninstance.Defaultvalue, " +
      "ad_ref_gridcolumninstance.Onchangeevent, " +
      "ad_ref_gridcolumninstance.AD_Ref_Gridcolumninstance_ID, " +
      "ad_ref_gridcolumninstance.AD_Client_ID, " +
      "ad_ref_gridcolumninstance.Issortable, " +
      "ad_ref_gridcolumninstance.Readonlylogic, " +
      "COALESCE(ad_ref_gridcolumninstance.Isrowkey, 'N') AS Isrowkey, " +
      "ad_ref_gridcolumninstance.Name, " +
      "COALESCE(ad_ref_gridcolumninstance.Isdisplayed, 'N') AS Isdisplayed, " +
      "ad_ref_gridcolumninstance.Headertext, " +
      "COALESCE(ad_ref_gridcolumninstance.Readonly, 'N') AS Readonly, " +
      "ad_ref_gridcolumninstance.AD_Org_ID, " +
      "ad_ref_gridcolumninstance.Mandantorylogic, " +
      "ad_ref_gridcolumninstance.Rowkeysuffix, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_ref_gridcolumninstance left join (select AD_Ref_Gridcolumn_ID, Name from AD_Ref_Gridcolumn) table1 on (ad_ref_gridcolumninstance.AD_Ref_Gridcolumn_ID = table1.AD_Ref_Gridcolumn_ID) left join (select AD_Element_ID, ColumnName, Name from AD_Element) table2 on (ad_ref_gridcolumninstance.AD_Element_ID = table2.AD_Element_ID) left join ad_ref_list_v list1 on (ad_ref_gridcolumninstance.Visiblesetting = list1.value and list1.ad_reference_id = 'A4801B9D7ADB4BB69EBF727B71C8AB45' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (ad_ref_gridcolumninstance.Editsetting = list2.value and list2.ad_reference_id = '0765914076274AD79BACA01E75F4D0A1' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (ad_ref_gridcolumninstance.Required = list3.value and list3.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list3.ad_language = ?)  left join ad_ref_list_v list4 on (ad_ref_gridcolumninstance.Issecondheader = list4.value and list4.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list4.ad_language = ?)  left join ad_ref_list_v list5 on (ad_ref_gridcolumninstance.Isinheader = list5.value and list5.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list5.ad_language = ?)  left join (select AD_Reference_ID, Name from AD_Reference) table3 on (ad_ref_gridcolumninstance.Colreference =  table3.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL3 on (table3.AD_Reference_ID = tableTRL3.AD_Reference_ID and tableTRL3.AD_Language = ?)  left join (select AD_Table_ID, TableName from AD_Table) table4 on (ad_ref_gridcolumninstance.AD_Table_ID = table4.AD_Table_ID) left join (select AD_Val_Rule_ID, Name from AD_Val_Rule) table5 on (ad_ref_gridcolumninstance.AD_Val_Rule_ID = table5.AD_Val_Rule_ID) left join ad_ref_list_v list6 on (ad_ref_gridcolumninstance.Includesemptyitem = list6.value and list6.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list6.ad_language = ?)  left join ad_ref_list_v list7 on (ad_ref_gridcolumninstance.Template = list7.value and list7.ad_reference_id = '93AAB50006A24AA4ADC854D6A0D8B716' and list7.ad_language = ?)  left join ad_ref_list_v list8 on (ad_ref_gridcolumninstance.Issplitgroup = list8.value and list8.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list8.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adRefGridcolumnId==null || adRefGridcolumnId.equals(""))?"":"  AND ad_ref_gridcolumninstance.AD_Ref_Gridcolumn_ID = ?  ");
    strSql = strSql + 
      "        AND ad_ref_gridcolumninstance.AD_Ref_Gridcolumninstance_ID = ? " +
      "        AND ad_ref_gridcolumninstance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_ref_gridcolumninstance.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (adRefGridcolumnId != null && !(adRefGridcolumnId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);
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
        EditableGridColumnsInstancespecificData objectEditableGridColumnsInstancespecificData = new EditableGridColumnsInstancespecificData();
        objectEditableGridColumnsInstancespecificData.created = UtilSql.getValue(result, "created");
        objectEditableGridColumnsInstancespecificData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectEditableGridColumnsInstancespecificData.updated = UtilSql.getValue(result, "updated");
        objectEditableGridColumnsInstancespecificData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectEditableGridColumnsInstancespecificData.updatedby = UtilSql.getValue(result, "updatedby");
        objectEditableGridColumnsInstancespecificData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectEditableGridColumnsInstancespecificData.adRefGridcolumnId = UtilSql.getValue(result, "ad_ref_gridcolumn_id");
        objectEditableGridColumnsInstancespecificData.adRefGridcolumnIdr = UtilSql.getValue(result, "ad_ref_gridcolumn_idr");
        objectEditableGridColumnsInstancespecificData.line = UtilSql.getValue(result, "line");
        objectEditableGridColumnsInstancespecificData.adElementId = UtilSql.getValue(result, "ad_element_id");
        objectEditableGridColumnsInstancespecificData.adElementIdr = UtilSql.getValue(result, "ad_element_idr");
        objectEditableGridColumnsInstancespecificData.visiblesetting = UtilSql.getValue(result, "visiblesetting");
        objectEditableGridColumnsInstancespecificData.visiblesettingr = UtilSql.getValue(result, "visiblesettingr");
        objectEditableGridColumnsInstancespecificData.editsetting = UtilSql.getValue(result, "editsetting");
        objectEditableGridColumnsInstancespecificData.editsettingr = UtilSql.getValue(result, "editsettingr");
        objectEditableGridColumnsInstancespecificData.isactive = UtilSql.getValue(result, "isactive");
        objectEditableGridColumnsInstancespecificData.colspan = UtilSql.getValue(result, "colspan");
        objectEditableGridColumnsInstancespecificData.required = UtilSql.getValue(result, "required");
        objectEditableGridColumnsInstancespecificData.requiredr = UtilSql.getValue(result, "requiredr");
        objectEditableGridColumnsInstancespecificData.issecondheader = UtilSql.getValue(result, "issecondheader");
        objectEditableGridColumnsInstancespecificData.issecondheaderr = UtilSql.getValue(result, "issecondheaderr");
        objectEditableGridColumnsInstancespecificData.maxlength = UtilSql.getValue(result, "maxlength");
        objectEditableGridColumnsInstancespecificData.isinheader = UtilSql.getValue(result, "isinheader");
        objectEditableGridColumnsInstancespecificData.isinheaderr = UtilSql.getValue(result, "isinheaderr");
        objectEditableGridColumnsInstancespecificData.colreference = UtilSql.getValue(result, "colreference");
        objectEditableGridColumnsInstancespecificData.colreferencer = UtilSql.getValue(result, "colreferencer");
        objectEditableGridColumnsInstancespecificData.referenceurl = UtilSql.getValue(result, "referenceurl");
        objectEditableGridColumnsInstancespecificData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectEditableGridColumnsInstancespecificData.adTableIdr = UtilSql.getValue(result, "ad_table_idr");
        objectEditableGridColumnsInstancespecificData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectEditableGridColumnsInstancespecificData.adValRuleIdr = UtilSql.getValue(result, "ad_val_rule_idr");
        objectEditableGridColumnsInstancespecificData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectEditableGridColumnsInstancespecificData.includesemptyitemr = UtilSql.getValue(result, "includesemptyitemr");
        objectEditableGridColumnsInstancespecificData.template = UtilSql.getValue(result, "template");
        objectEditableGridColumnsInstancespecificData.templater = UtilSql.getValue(result, "templater");
        objectEditableGridColumnsInstancespecificData.issplitgroup = UtilSql.getValue(result, "issplitgroup");
        objectEditableGridColumnsInstancespecificData.issplitgroupr = UtilSql.getValue(result, "issplitgroupr");
        objectEditableGridColumnsInstancespecificData.defaultvalue = UtilSql.getValue(result, "defaultvalue");
        objectEditableGridColumnsInstancespecificData.onchangeevent = UtilSql.getValue(result, "onchangeevent");
        objectEditableGridColumnsInstancespecificData.adRefGridcolumninstanceId = UtilSql.getValue(result, "ad_ref_gridcolumninstance_id");
        objectEditableGridColumnsInstancespecificData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectEditableGridColumnsInstancespecificData.issortable = UtilSql.getValue(result, "issortable");
        objectEditableGridColumnsInstancespecificData.readonlylogic = UtilSql.getValue(result, "readonlylogic");
        objectEditableGridColumnsInstancespecificData.isrowkey = UtilSql.getValue(result, "isrowkey");
        objectEditableGridColumnsInstancespecificData.name = UtilSql.getValue(result, "name");
        objectEditableGridColumnsInstancespecificData.isdisplayed = UtilSql.getValue(result, "isdisplayed");
        objectEditableGridColumnsInstancespecificData.headertext = UtilSql.getValue(result, "headertext");
        objectEditableGridColumnsInstancespecificData.readonly = UtilSql.getValue(result, "readonly");
        objectEditableGridColumnsInstancespecificData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectEditableGridColumnsInstancespecificData.mandantorylogic = UtilSql.getValue(result, "mandantorylogic");
        objectEditableGridColumnsInstancespecificData.rowkeysuffix = UtilSql.getValue(result, "rowkeysuffix");
        objectEditableGridColumnsInstancespecificData.language = UtilSql.getValue(result, "language");
        objectEditableGridColumnsInstancespecificData.adUserClient = "";
        objectEditableGridColumnsInstancespecificData.adOrgClient = "";
        objectEditableGridColumnsInstancespecificData.createdby = "";
        objectEditableGridColumnsInstancespecificData.trBgcolor = "";
        objectEditableGridColumnsInstancespecificData.totalCount = "";
        objectEditableGridColumnsInstancespecificData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEditableGridColumnsInstancespecificData);
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
    EditableGridColumnsInstancespecificData objectEditableGridColumnsInstancespecificData[] = new EditableGridColumnsInstancespecificData[vector.size()];
    vector.copyInto(objectEditableGridColumnsInstancespecificData);
    return(objectEditableGridColumnsInstancespecificData);
  }

/**
Create a registry
 */
  public static EditableGridColumnsInstancespecificData[] set(String adRefGridcolumnId, String colspan, String defaultvalue, String headertext, String template, String isactive, String required, String createdby, String createdbyr, String updatedby, String updatedbyr, String isrowkey, String visiblesetting, String adTableId, String includesemptyitem, String mandantorylogic, String adValRuleId, String adElementId, String readonlylogic, String isdisplayed, String issplitgroup, String colreference, String name, String maxlength, String referenceurl, String adRefGridcolumninstanceId, String readonly, String editsetting, String adClientId, String onchangeevent, String issecondheader, String issortable, String adOrgId, String line, String rowkeysuffix, String isinheader)    throws ServletException {
    EditableGridColumnsInstancespecificData objectEditableGridColumnsInstancespecificData[] = new EditableGridColumnsInstancespecificData[1];
    objectEditableGridColumnsInstancespecificData[0] = new EditableGridColumnsInstancespecificData();
    objectEditableGridColumnsInstancespecificData[0].created = "";
    objectEditableGridColumnsInstancespecificData[0].createdbyr = createdbyr;
    objectEditableGridColumnsInstancespecificData[0].updated = "";
    objectEditableGridColumnsInstancespecificData[0].updatedTimeStamp = "";
    objectEditableGridColumnsInstancespecificData[0].updatedby = updatedby;
    objectEditableGridColumnsInstancespecificData[0].updatedbyr = updatedbyr;
    objectEditableGridColumnsInstancespecificData[0].adRefGridcolumnId = adRefGridcolumnId;
    objectEditableGridColumnsInstancespecificData[0].adRefGridcolumnIdr = "";
    objectEditableGridColumnsInstancespecificData[0].line = line;
    objectEditableGridColumnsInstancespecificData[0].adElementId = adElementId;
    objectEditableGridColumnsInstancespecificData[0].adElementIdr = "";
    objectEditableGridColumnsInstancespecificData[0].visiblesetting = visiblesetting;
    objectEditableGridColumnsInstancespecificData[0].visiblesettingr = "";
    objectEditableGridColumnsInstancespecificData[0].editsetting = editsetting;
    objectEditableGridColumnsInstancespecificData[0].editsettingr = "";
    objectEditableGridColumnsInstancespecificData[0].isactive = isactive;
    objectEditableGridColumnsInstancespecificData[0].colspan = colspan;
    objectEditableGridColumnsInstancespecificData[0].required = required;
    objectEditableGridColumnsInstancespecificData[0].requiredr = "";
    objectEditableGridColumnsInstancespecificData[0].issecondheader = issecondheader;
    objectEditableGridColumnsInstancespecificData[0].issecondheaderr = "";
    objectEditableGridColumnsInstancespecificData[0].maxlength = maxlength;
    objectEditableGridColumnsInstancespecificData[0].isinheader = isinheader;
    objectEditableGridColumnsInstancespecificData[0].isinheaderr = "";
    objectEditableGridColumnsInstancespecificData[0].colreference = colreference;
    objectEditableGridColumnsInstancespecificData[0].colreferencer = "";
    objectEditableGridColumnsInstancespecificData[0].referenceurl = referenceurl;
    objectEditableGridColumnsInstancespecificData[0].adTableId = adTableId;
    objectEditableGridColumnsInstancespecificData[0].adTableIdr = "";
    objectEditableGridColumnsInstancespecificData[0].adValRuleId = adValRuleId;
    objectEditableGridColumnsInstancespecificData[0].adValRuleIdr = "";
    objectEditableGridColumnsInstancespecificData[0].includesemptyitem = includesemptyitem;
    objectEditableGridColumnsInstancespecificData[0].includesemptyitemr = "";
    objectEditableGridColumnsInstancespecificData[0].template = template;
    objectEditableGridColumnsInstancespecificData[0].templater = "";
    objectEditableGridColumnsInstancespecificData[0].issplitgroup = issplitgroup;
    objectEditableGridColumnsInstancespecificData[0].issplitgroupr = "";
    objectEditableGridColumnsInstancespecificData[0].defaultvalue = defaultvalue;
    objectEditableGridColumnsInstancespecificData[0].onchangeevent = onchangeevent;
    objectEditableGridColumnsInstancespecificData[0].adRefGridcolumninstanceId = adRefGridcolumninstanceId;
    objectEditableGridColumnsInstancespecificData[0].adClientId = adClientId;
    objectEditableGridColumnsInstancespecificData[0].issortable = issortable;
    objectEditableGridColumnsInstancespecificData[0].readonlylogic = readonlylogic;
    objectEditableGridColumnsInstancespecificData[0].isrowkey = isrowkey;
    objectEditableGridColumnsInstancespecificData[0].name = name;
    objectEditableGridColumnsInstancespecificData[0].isdisplayed = isdisplayed;
    objectEditableGridColumnsInstancespecificData[0].headertext = headertext;
    objectEditableGridColumnsInstancespecificData[0].readonly = readonly;
    objectEditableGridColumnsInstancespecificData[0].adOrgId = adOrgId;
    objectEditableGridColumnsInstancespecificData[0].mandantorylogic = mandantorylogic;
    objectEditableGridColumnsInstancespecificData[0].rowkeysuffix = rowkeysuffix;
    objectEditableGridColumnsInstancespecificData[0].language = "";
    return objectEditableGridColumnsInstancespecificData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefDA259AB1C5404BF28209DD6044B06665_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef3DDD02B35DF144DAB8EA2AD0B560A0D9_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_ref_gridcolumninstance.AD_Ref_Gridcolumn_ID AS NAME" +
      "        FROM ad_ref_gridcolumninstance" +
      "        WHERE ad_ref_gridcolumninstance.AD_Ref_Gridcolumninstance_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adRefGridcolumnId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM ad_ref_gridcolumn left join (select AD_Ref_Gridcolumn_ID, Name from AD_Ref_Gridcolumn) table1 on (ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID = table1.AD_Ref_Gridcolumn_ID) WHERE ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adRefGridcolumnId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM ad_ref_gridcolumn left join (select AD_Ref_Gridcolumn_ID, Name from AD_Ref_Gridcolumn) table1 on (ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID = table1.AD_Ref_Gridcolumn_ID) WHERE ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);

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
      "        UPDATE ad_ref_gridcolumninstance" +
      "        SET AD_Ref_Gridcolumn_ID = (?) , Line = TO_NUMBER(?) , AD_Element_ID = (?) , Visiblesetting = (?) , Editsetting = (?) , Isactive = (?) , Colspan = TO_NUMBER(?) , Required = (?) , Issecondheader = (?) , Maxlength = TO_NUMBER(?) , Isinheader = (?) , Colreference = (?) , Referenceurl = (?) , AD_Table_ID = (?) , AD_Val_Rule_ID = (?) , Includesemptyitem = (?) , Template = (?) , Issplitgroup = (?) , Defaultvalue = (?) , Onchangeevent = (?) , AD_Ref_Gridcolumninstance_ID = (?) , AD_Client_ID = (?) , Issortable = (?) , Readonlylogic = (?) , Isrowkey = (?) , Name = (?) , Isdisplayed = (?) , Headertext = (?) , Readonly = (?) , AD_Org_ID = (?) , Mandantorylogic = (?) , Rowkeysuffix = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_ref_gridcolumninstance.AD_Ref_Gridcolumninstance_ID = ? " +
      "                 AND ad_ref_gridcolumninstance.AD_Ref_Gridcolumn_ID = ? " +
      "        AND ad_ref_gridcolumninstance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_gridcolumninstance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, visiblesetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, editsetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colspan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, required);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issecondheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issplitgroup);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onchangeevent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumninstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issortable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrowkey);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisplayed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, headertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rowkeysuffix);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumninstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);
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
      "        INSERT INTO ad_ref_gridcolumninstance " +
      "        (AD_Ref_Gridcolumn_ID, Line, AD_Element_ID, Visiblesetting, Editsetting, Isactive, Colspan, Required, Issecondheader, Maxlength, Isinheader, Colreference, Referenceurl, AD_Table_ID, AD_Val_Rule_ID, Includesemptyitem, Template, Issplitgroup, Defaultvalue, Onchangeevent, AD_Ref_Gridcolumninstance_ID, AD_Client_ID, Issortable, Readonlylogic, Isrowkey, Name, Isdisplayed, Headertext, Readonly, AD_Org_ID, Mandantorylogic, Rowkeysuffix, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, visiblesetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, editsetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colspan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, required);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issecondheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issplitgroup);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onchangeevent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumninstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issortable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrowkey);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisplayed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, headertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rowkeysuffix);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adRefGridcolumnId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_gridcolumninstance" +
      "        WHERE ad_ref_gridcolumninstance.AD_Ref_Gridcolumninstance_ID = ? " +
      "                 AND ad_ref_gridcolumninstance.AD_Ref_Gridcolumn_ID = ? " +
      "        AND ad_ref_gridcolumninstance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_gridcolumninstance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adRefGridcolumnId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_gridcolumninstance" +
      "        WHERE ad_ref_gridcolumninstance.AD_Ref_Gridcolumninstance_ID = ? " +
      "                 AND ad_ref_gridcolumninstance.AD_Ref_Gridcolumn_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);

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
      "          FROM ad_ref_gridcolumninstance" +
      "         WHERE ad_ref_gridcolumninstance.AD_Ref_Gridcolumninstance_ID = ? ";

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
      "          FROM ad_ref_gridcolumninstance" +
      "         WHERE ad_ref_gridcolumninstance.AD_Ref_Gridcolumninstance_ID = ? ";

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
