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
class IndividualSettingsData implements FieldProvider {
static Logger log4j = Logger.getLogger(IndividualSettingsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adFieldVId;
  public String adFieldVIdr;
  public String isactive;
  public String line;
  public String adFieldgroupId;
  public String adFieldgroupIdr;
  public String isfiltercolumn;
  public String isfiltercolumnr;
  public String colstotal;
  public String colstotalr;
  public String maxlength;
  public String adCalloutId;
  public String adCalloutIdr;
  public String fieldreference;
  public String fieldreferencer;
  public String referenceurl;
  public String adTableId;
  public String adTableIdr;
  public String adValRuleId;
  public String adValRuleIdr;
  public String includesemptyitem;
  public String includesemptyitemr;
  public String template;
  public String templater;
  public String buttonclass;
  public String visiblesetting;
  public String visiblesettingr;
  public String editsetting;
  public String editsettingr;
  public String displaylogic;
  public String readonlylogic;
  public String mandantorylogic;
  public String defaultvalue;
  public String onchangeevent;
  public String style;
  public String issameline;
  public String issameliner;
  public String isfirstfocusedfield;
  public String isfirstfocusedfieldr;
  public String gridlength;
  public String showinrelation;
  public String showinrelationr;
  public String gridseqno;
  public String adProcessId;
  public String adOrgId;
  public String adClientId;
  public String seqno;
  public String adFieldinstanceId;
  public String identsequence;
  public String isidentifiercolumn;
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
    else if (fieldName.equalsIgnoreCase("ad_field_v_id") || fieldName.equals("adFieldVId"))
      return adFieldVId;
    else if (fieldName.equalsIgnoreCase("ad_field_v_idr") || fieldName.equals("adFieldVIdr"))
      return adFieldVIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("ad_fieldgroup_id") || fieldName.equals("adFieldgroupId"))
      return adFieldgroupId;
    else if (fieldName.equalsIgnoreCase("ad_fieldgroup_idr") || fieldName.equals("adFieldgroupIdr"))
      return adFieldgroupIdr;
    else if (fieldName.equalsIgnoreCase("isfiltercolumn"))
      return isfiltercolumn;
    else if (fieldName.equalsIgnoreCase("isfiltercolumnr"))
      return isfiltercolumnr;
    else if (fieldName.equalsIgnoreCase("colstotal"))
      return colstotal;
    else if (fieldName.equalsIgnoreCase("colstotalr"))
      return colstotalr;
    else if (fieldName.equalsIgnoreCase("maxlength"))
      return maxlength;
    else if (fieldName.equalsIgnoreCase("ad_callout_id") || fieldName.equals("adCalloutId"))
      return adCalloutId;
    else if (fieldName.equalsIgnoreCase("ad_callout_idr") || fieldName.equals("adCalloutIdr"))
      return adCalloutIdr;
    else if (fieldName.equalsIgnoreCase("fieldreference"))
      return fieldreference;
    else if (fieldName.equalsIgnoreCase("fieldreferencer"))
      return fieldreferencer;
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
    else if (fieldName.equalsIgnoreCase("buttonclass"))
      return buttonclass;
    else if (fieldName.equalsIgnoreCase("visiblesetting"))
      return visiblesetting;
    else if (fieldName.equalsIgnoreCase("visiblesettingr"))
      return visiblesettingr;
    else if (fieldName.equalsIgnoreCase("editsetting"))
      return editsetting;
    else if (fieldName.equalsIgnoreCase("editsettingr"))
      return editsettingr;
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
    else if (fieldName.equalsIgnoreCase("issameline"))
      return issameline;
    else if (fieldName.equalsIgnoreCase("issameliner"))
      return issameliner;
    else if (fieldName.equalsIgnoreCase("isfirstfocusedfield"))
      return isfirstfocusedfield;
    else if (fieldName.equalsIgnoreCase("isfirstfocusedfieldr"))
      return isfirstfocusedfieldr;
    else if (fieldName.equalsIgnoreCase("gridlength"))
      return gridlength;
    else if (fieldName.equalsIgnoreCase("showinrelation"))
      return showinrelation;
    else if (fieldName.equalsIgnoreCase("showinrelationr"))
      return showinrelationr;
    else if (fieldName.equalsIgnoreCase("gridseqno"))
      return gridseqno;
    else if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("ad_fieldinstance_id") || fieldName.equals("adFieldinstanceId"))
      return adFieldinstanceId;
    else if (fieldName.equalsIgnoreCase("identsequence"))
      return identsequence;
    else if (fieldName.equalsIgnoreCase("isidentifiercolumn"))
      return isidentifiercolumn;
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
  public static IndividualSettingsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adFieldVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adFieldVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static IndividualSettingsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adFieldVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_fieldinstance.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_fieldinstance.CreatedBy) as CreatedByR, " +
      "        to_char(ad_fieldinstance.Updated, ?) as updated, " +
      "        to_char(ad_fieldinstance.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_fieldinstance.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_fieldinstance.UpdatedBy) as UpdatedByR," +
      "        ad_fieldinstance.AD_Field_V_ID, " +
      "(CASE WHEN ad_fieldinstance.AD_Field_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Field_V_IDR, " +
      "COALESCE(ad_fieldinstance.Isactive, 'N') AS Isactive, " +
      "ad_fieldinstance.Line, " +
      "ad_fieldinstance.AD_Fieldgroup_ID, " +
      "(CASE WHEN ad_fieldinstance.AD_Fieldgroup_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Fieldgroup_IDR, " +
      "ad_fieldinstance.Isfiltercolumn, " +
      "(CASE WHEN ad_fieldinstance.Isfiltercolumn IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS IsfiltercolumnR, " +
      "ad_fieldinstance.Colstotal, " +
      "(CASE WHEN ad_fieldinstance.Colstotal IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS ColstotalR, " +
      "ad_fieldinstance.Maxlength, " +
      "ad_fieldinstance.AD_Callout_ID, " +
      "(CASE WHEN ad_fieldinstance.AD_Callout_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_Callout_IDR, " +
      "ad_fieldinstance.Fieldreference, " +
      "(CASE WHEN ad_fieldinstance.Fieldreference IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS FieldreferenceR, " +
      "ad_fieldinstance.Referenceurl, " +
      "ad_fieldinstance.AD_Table_ID, " +
      "(CASE WHEN ad_fieldinstance.AD_Table_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.TableName), ''))),'') ) END) AS AD_Table_IDR, " +
      "ad_fieldinstance.AD_Val_Rule_ID, " +
      "(CASE WHEN ad_fieldinstance.AD_Val_Rule_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS AD_Val_Rule_IDR, " +
      "ad_fieldinstance.Includesemptyitem, " +
      "(CASE WHEN ad_fieldinstance.Includesemptyitem IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS IncludesemptyitemR, " +
      "ad_fieldinstance.Template, " +
      "(CASE WHEN ad_fieldinstance.Template IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS TemplateR, " +
      "ad_fieldinstance.Buttonclass, " +
      "ad_fieldinstance.Visiblesetting, " +
      "(CASE WHEN ad_fieldinstance.Visiblesetting IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list5.name),'') ) END) AS VisiblesettingR, " +
      "ad_fieldinstance.Editsetting, " +
      "(CASE WHEN ad_fieldinstance.Editsetting IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list6.name),'') ) END) AS EditsettingR, " +
      "ad_fieldinstance.Displaylogic, " +
      "ad_fieldinstance.Readonlylogic, " +
      "ad_fieldinstance.Mandantorylogic, " +
      "ad_fieldinstance.Defaultvalue, " +
      "ad_fieldinstance.Onchangeevent, " +
      "ad_fieldinstance.Style, " +
      "ad_fieldinstance.Issameline, " +
      "(CASE WHEN ad_fieldinstance.Issameline IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list7.name),'') ) END) AS IssamelineR, " +
      "ad_fieldinstance.Isfirstfocusedfield, " +
      "(CASE WHEN ad_fieldinstance.Isfirstfocusedfield IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list8.name),'') ) END) AS IsfirstfocusedfieldR, " +
      "ad_fieldinstance.Gridlength, " +
      "ad_fieldinstance.Showinrelation, " +
      "(CASE WHEN ad_fieldinstance.Showinrelation IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list9.name),'') ) END) AS ShowinrelationR, " +
      "ad_fieldinstance.Gridseqno, " +
      "ad_fieldinstance.AD_Process_ID, " +
      "ad_fieldinstance.AD_Org_ID, " +
      "ad_fieldinstance.AD_Client_ID, " +
      "ad_fieldinstance.Seqno, " +
      "ad_fieldinstance.AD_Fieldinstance_ID, " +
      "ad_fieldinstance.Identsequence, " +
      "ad_fieldinstance.Isidentifiercolumn, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_fieldinstance left join (select AD_Field_V_ID, Name from AD_Field_V) table1 on (ad_fieldinstance.AD_Field_V_ID = table1.AD_Field_V_ID) left join (select AD_Fieldgroup_ID, Name from AD_Fieldgroup) table2 on (ad_fieldinstance.AD_Fieldgroup_ID = table2.AD_Fieldgroup_ID) left join ad_ref_list_v list1 on (ad_fieldinstance.Isfiltercolumn = list1.value and list1.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (ad_fieldinstance.Colstotal = list2.value and list2.ad_reference_id = '7FFBAD874C6F463D866894F42ECAE6BD' and list2.ad_language = ?)  left join (select AD_Callout_ID, Name from AD_Callout) table3 on (ad_fieldinstance.AD_Callout_ID = table3.AD_Callout_ID) left join (select AD_Reference_ID, Name from AD_Reference) table4 on (ad_fieldinstance.Fieldreference =  table4.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL4 on (table4.AD_Reference_ID = tableTRL4.AD_Reference_ID and tableTRL4.AD_Language = ?)  left join (select AD_Table_ID, TableName from AD_Table) table5 on (ad_fieldinstance.AD_Table_ID = table5.AD_Table_ID) left join (select AD_Val_Rule_ID, Name from AD_Val_Rule) table6 on (ad_fieldinstance.AD_Val_Rule_ID = table6.AD_Val_Rule_ID) left join ad_ref_list_v list3 on (ad_fieldinstance.Includesemptyitem = list3.value and list3.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list3.ad_language = ?)  left join ad_ref_list_v list4 on (ad_fieldinstance.Template = list4.value and list4.ad_reference_id = '029984D63BCA4F67AD81C93DCF486DFE' and list4.ad_language = ?)  left join ad_ref_list_v list5 on (ad_fieldinstance.Visiblesetting = list5.value and list5.ad_reference_id = 'A4801B9D7ADB4BB69EBF727B71C8AB45' and list5.ad_language = ?)  left join ad_ref_list_v list6 on (ad_fieldinstance.Editsetting = list6.value and list6.ad_reference_id = '0765914076274AD79BACA01E75F4D0A1' and list6.ad_language = ?)  left join ad_ref_list_v list7 on (ad_fieldinstance.Issameline = list7.value and list7.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list7.ad_language = ?)  left join ad_ref_list_v list8 on (ad_fieldinstance.Isfirstfocusedfield = list8.value and list8.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list8.ad_language = ?)  left join ad_ref_list_v list9 on (ad_fieldinstance.Showinrelation = list9.value and list9.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list9.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adFieldVId==null || adFieldVId.equals(""))?"":"  AND ad_fieldinstance.AD_Field_V_ID = ?  ");
    strSql = strSql + 
      "        AND ad_fieldinstance.AD_Fieldinstance_ID = ? " +
      "        AND ad_fieldinstance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_fieldinstance.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (adFieldVId != null && !(adFieldVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldVId);
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
        IndividualSettingsData objectIndividualSettingsData = new IndividualSettingsData();
        objectIndividualSettingsData.created = UtilSql.getValue(result, "created");
        objectIndividualSettingsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectIndividualSettingsData.updated = UtilSql.getValue(result, "updated");
        objectIndividualSettingsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectIndividualSettingsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectIndividualSettingsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectIndividualSettingsData.adFieldVId = UtilSql.getValue(result, "ad_field_v_id");
        objectIndividualSettingsData.adFieldVIdr = UtilSql.getValue(result, "ad_field_v_idr");
        objectIndividualSettingsData.isactive = UtilSql.getValue(result, "isactive");
        objectIndividualSettingsData.line = UtilSql.getValue(result, "line");
        objectIndividualSettingsData.adFieldgroupId = UtilSql.getValue(result, "ad_fieldgroup_id");
        objectIndividualSettingsData.adFieldgroupIdr = UtilSql.getValue(result, "ad_fieldgroup_idr");
        objectIndividualSettingsData.isfiltercolumn = UtilSql.getValue(result, "isfiltercolumn");
        objectIndividualSettingsData.isfiltercolumnr = UtilSql.getValue(result, "isfiltercolumnr");
        objectIndividualSettingsData.colstotal = UtilSql.getValue(result, "colstotal");
        objectIndividualSettingsData.colstotalr = UtilSql.getValue(result, "colstotalr");
        objectIndividualSettingsData.maxlength = UtilSql.getValue(result, "maxlength");
        objectIndividualSettingsData.adCalloutId = UtilSql.getValue(result, "ad_callout_id");
        objectIndividualSettingsData.adCalloutIdr = UtilSql.getValue(result, "ad_callout_idr");
        objectIndividualSettingsData.fieldreference = UtilSql.getValue(result, "fieldreference");
        objectIndividualSettingsData.fieldreferencer = UtilSql.getValue(result, "fieldreferencer");
        objectIndividualSettingsData.referenceurl = UtilSql.getValue(result, "referenceurl");
        objectIndividualSettingsData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectIndividualSettingsData.adTableIdr = UtilSql.getValue(result, "ad_table_idr");
        objectIndividualSettingsData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectIndividualSettingsData.adValRuleIdr = UtilSql.getValue(result, "ad_val_rule_idr");
        objectIndividualSettingsData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectIndividualSettingsData.includesemptyitemr = UtilSql.getValue(result, "includesemptyitemr");
        objectIndividualSettingsData.template = UtilSql.getValue(result, "template");
        objectIndividualSettingsData.templater = UtilSql.getValue(result, "templater");
        objectIndividualSettingsData.buttonclass = UtilSql.getValue(result, "buttonclass");
        objectIndividualSettingsData.visiblesetting = UtilSql.getValue(result, "visiblesetting");
        objectIndividualSettingsData.visiblesettingr = UtilSql.getValue(result, "visiblesettingr");
        objectIndividualSettingsData.editsetting = UtilSql.getValue(result, "editsetting");
        objectIndividualSettingsData.editsettingr = UtilSql.getValue(result, "editsettingr");
        objectIndividualSettingsData.displaylogic = UtilSql.getValue(result, "displaylogic");
        objectIndividualSettingsData.readonlylogic = UtilSql.getValue(result, "readonlylogic");
        objectIndividualSettingsData.mandantorylogic = UtilSql.getValue(result, "mandantorylogic");
        objectIndividualSettingsData.defaultvalue = UtilSql.getValue(result, "defaultvalue");
        objectIndividualSettingsData.onchangeevent = UtilSql.getValue(result, "onchangeevent");
        objectIndividualSettingsData.style = UtilSql.getValue(result, "style");
        objectIndividualSettingsData.issameline = UtilSql.getValue(result, "issameline");
        objectIndividualSettingsData.issameliner = UtilSql.getValue(result, "issameliner");
        objectIndividualSettingsData.isfirstfocusedfield = UtilSql.getValue(result, "isfirstfocusedfield");
        objectIndividualSettingsData.isfirstfocusedfieldr = UtilSql.getValue(result, "isfirstfocusedfieldr");
        objectIndividualSettingsData.gridlength = UtilSql.getValue(result, "gridlength");
        objectIndividualSettingsData.showinrelation = UtilSql.getValue(result, "showinrelation");
        objectIndividualSettingsData.showinrelationr = UtilSql.getValue(result, "showinrelationr");
        objectIndividualSettingsData.gridseqno = UtilSql.getValue(result, "gridseqno");
        objectIndividualSettingsData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectIndividualSettingsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectIndividualSettingsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectIndividualSettingsData.seqno = UtilSql.getValue(result, "seqno");
        objectIndividualSettingsData.adFieldinstanceId = UtilSql.getValue(result, "ad_fieldinstance_id");
        objectIndividualSettingsData.identsequence = UtilSql.getValue(result, "identsequence");
        objectIndividualSettingsData.isidentifiercolumn = UtilSql.getValue(result, "isidentifiercolumn");
        objectIndividualSettingsData.language = UtilSql.getValue(result, "language");
        objectIndividualSettingsData.adUserClient = "";
        objectIndividualSettingsData.adOrgClient = "";
        objectIndividualSettingsData.createdby = "";
        objectIndividualSettingsData.trBgcolor = "";
        objectIndividualSettingsData.totalCount = "";
        objectIndividualSettingsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectIndividualSettingsData);
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
    IndividualSettingsData objectIndividualSettingsData[] = new IndividualSettingsData[vector.size()];
    vector.copyInto(objectIndividualSettingsData);
    return(objectIndividualSettingsData);
  }

/**
Create a registry
 */
  public static IndividualSettingsData[] set(String adFieldVId, String gridlength, String identsequence, String template, String style, String issameline, String onchangeevent, String maxlength, String updatedby, String updatedbyr, String line, String isidentifiercolumn, String referenceurl, String showinrelation, String adOrgId, String buttonclass, String defaultvalue, String colstotal, String isfiltercolumn, String includesemptyitem, String mandantorylogic, String seqno, String fieldreference, String visiblesetting, String adClientId, String editsetting, String adTableId, String adFieldinstanceId, String adCalloutId, String readonlylogic, String gridseqno, String adProcessId, String isactive, String createdby, String createdbyr, String adValRuleId, String adFieldgroupId, String displaylogic, String isfirstfocusedfield)    throws ServletException {
    IndividualSettingsData objectIndividualSettingsData[] = new IndividualSettingsData[1];
    objectIndividualSettingsData[0] = new IndividualSettingsData();
    objectIndividualSettingsData[0].created = "";
    objectIndividualSettingsData[0].createdbyr = createdbyr;
    objectIndividualSettingsData[0].updated = "";
    objectIndividualSettingsData[0].updatedTimeStamp = "";
    objectIndividualSettingsData[0].updatedby = updatedby;
    objectIndividualSettingsData[0].updatedbyr = updatedbyr;
    objectIndividualSettingsData[0].adFieldVId = adFieldVId;
    objectIndividualSettingsData[0].adFieldVIdr = "";
    objectIndividualSettingsData[0].isactive = isactive;
    objectIndividualSettingsData[0].line = line;
    objectIndividualSettingsData[0].adFieldgroupId = adFieldgroupId;
    objectIndividualSettingsData[0].adFieldgroupIdr = "";
    objectIndividualSettingsData[0].isfiltercolumn = isfiltercolumn;
    objectIndividualSettingsData[0].isfiltercolumnr = "";
    objectIndividualSettingsData[0].colstotal = colstotal;
    objectIndividualSettingsData[0].colstotalr = "";
    objectIndividualSettingsData[0].maxlength = maxlength;
    objectIndividualSettingsData[0].adCalloutId = adCalloutId;
    objectIndividualSettingsData[0].adCalloutIdr = "";
    objectIndividualSettingsData[0].fieldreference = fieldreference;
    objectIndividualSettingsData[0].fieldreferencer = "";
    objectIndividualSettingsData[0].referenceurl = referenceurl;
    objectIndividualSettingsData[0].adTableId = adTableId;
    objectIndividualSettingsData[0].adTableIdr = "";
    objectIndividualSettingsData[0].adValRuleId = adValRuleId;
    objectIndividualSettingsData[0].adValRuleIdr = "";
    objectIndividualSettingsData[0].includesemptyitem = includesemptyitem;
    objectIndividualSettingsData[0].includesemptyitemr = "";
    objectIndividualSettingsData[0].template = template;
    objectIndividualSettingsData[0].templater = "";
    objectIndividualSettingsData[0].buttonclass = buttonclass;
    objectIndividualSettingsData[0].visiblesetting = visiblesetting;
    objectIndividualSettingsData[0].visiblesettingr = "";
    objectIndividualSettingsData[0].editsetting = editsetting;
    objectIndividualSettingsData[0].editsettingr = "";
    objectIndividualSettingsData[0].displaylogic = displaylogic;
    objectIndividualSettingsData[0].readonlylogic = readonlylogic;
    objectIndividualSettingsData[0].mandantorylogic = mandantorylogic;
    objectIndividualSettingsData[0].defaultvalue = defaultvalue;
    objectIndividualSettingsData[0].onchangeevent = onchangeevent;
    objectIndividualSettingsData[0].style = style;
    objectIndividualSettingsData[0].issameline = issameline;
    objectIndividualSettingsData[0].issameliner = "";
    objectIndividualSettingsData[0].isfirstfocusedfield = isfirstfocusedfield;
    objectIndividualSettingsData[0].isfirstfocusedfieldr = "";
    objectIndividualSettingsData[0].gridlength = gridlength;
    objectIndividualSettingsData[0].showinrelation = showinrelation;
    objectIndividualSettingsData[0].showinrelationr = "";
    objectIndividualSettingsData[0].gridseqno = gridseqno;
    objectIndividualSettingsData[0].adProcessId = adProcessId;
    objectIndividualSettingsData[0].adOrgId = adOrgId;
    objectIndividualSettingsData[0].adClientId = adClientId;
    objectIndividualSettingsData[0].seqno = seqno;
    objectIndividualSettingsData[0].adFieldinstanceId = adFieldinstanceId;
    objectIndividualSettingsData[0].identsequence = identsequence;
    objectIndividualSettingsData[0].isidentifiercolumn = isidentifiercolumn;
    objectIndividualSettingsData[0].language = "";
    return objectIndividualSettingsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefC3A3B90DC0DE436091FB10FA3E050296_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef94E16FC559E2412EB47D848790CE3C65_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_fieldinstance.AD_Field_V_ID AS NAME" +
      "        FROM ad_fieldinstance" +
      "        WHERE ad_fieldinstance.AD_Fieldinstance_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adFieldVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM ad_field_v left join (select AD_Field_V_ID, Name from AD_Field_V) table1 on (ad_field_v.AD_Field_V_ID = table1.AD_Field_V_ID) WHERE ad_field_v.AD_Field_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldVId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adFieldVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM ad_field_v left join (select AD_Field_V_ID, Name from AD_Field_V) table1 on (ad_field_v.AD_Field_V_ID = table1.AD_Field_V_ID) WHERE ad_field_v.AD_Field_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldVId);

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
      "        UPDATE ad_fieldinstance" +
      "        SET AD_Field_V_ID = (?) , Isactive = (?) , Line = TO_NUMBER(?) , AD_Fieldgroup_ID = (?) , Isfiltercolumn = (?) , Colstotal = (?) , Maxlength = TO_NUMBER(?) , AD_Callout_ID = (?) , Fieldreference = (?) , Referenceurl = (?) , AD_Table_ID = (?) , AD_Val_Rule_ID = (?) , Includesemptyitem = (?) , Template = (?) , Buttonclass = (?) , Visiblesetting = (?) , Editsetting = (?) , Displaylogic = (?) , Readonlylogic = (?) , Mandantorylogic = (?) , Defaultvalue = (?) , Onchangeevent = (?) , Style = (?) , Issameline = (?) , Isfirstfocusedfield = (?) , Gridlength = TO_NUMBER(?) , Showinrelation = (?) , Gridseqno = TO_NUMBER(?) , AD_Process_ID = (?) , AD_Org_ID = (?) , AD_Client_ID = (?) , Seqno = TO_NUMBER(?) , AD_Fieldinstance_ID = (?) , Identsequence = TO_NUMBER(?) , Isidentifiercolumn = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_fieldinstance.AD_Fieldinstance_ID = ? " +
      "                 AND ad_fieldinstance.AD_Field_V_ID = ? " +
      "        AND ad_fieldinstance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_fieldinstance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldgroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfiltercolumn);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colstotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adCalloutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fieldreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, buttonclass);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, visiblesetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, editsetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displaylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onchangeevent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, style);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issameline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfirstfocusedfield);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gridlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showinrelation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gridseqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, identsequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isidentifiercolumn);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldVId);
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
      "        INSERT INTO ad_fieldinstance " +
      "        (AD_Field_V_ID, Isactive, Line, AD_Fieldgroup_ID, Isfiltercolumn, Colstotal, Maxlength, AD_Callout_ID, Fieldreference, Referenceurl, AD_Table_ID, AD_Val_Rule_ID, Includesemptyitem, Template, Buttonclass, Visiblesetting, Editsetting, Displaylogic, Readonlylogic, Mandantorylogic, Defaultvalue, Onchangeevent, Style, Issameline, Isfirstfocusedfield, Gridlength, Showinrelation, Gridseqno, AD_Process_ID, AD_Org_ID, AD_Client_ID, Seqno, AD_Fieldinstance_ID, Identsequence, Isidentifiercolumn, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldgroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfiltercolumn);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colstotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adCalloutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fieldreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, buttonclass);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, visiblesetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, editsetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displaylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onchangeevent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, style);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issameline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfirstfocusedfield);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gridlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showinrelation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gridseqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, identsequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isidentifiercolumn);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adFieldVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_fieldinstance" +
      "        WHERE ad_fieldinstance.AD_Fieldinstance_ID = ? " +
      "                 AND ad_fieldinstance.AD_Field_V_ID = ? " +
      "        AND ad_fieldinstance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_fieldinstance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adFieldVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_fieldinstance" +
      "        WHERE ad_fieldinstance.AD_Fieldinstance_ID = ? " +
      "                 AND ad_fieldinstance.AD_Field_V_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldVId);

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
      "          FROM ad_fieldinstance" +
      "         WHERE ad_fieldinstance.AD_Fieldinstance_ID = ? ";

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
      "          FROM ad_fieldinstance" +
      "         WHERE ad_fieldinstance.AD_Fieldinstance_ID = ? ";

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
