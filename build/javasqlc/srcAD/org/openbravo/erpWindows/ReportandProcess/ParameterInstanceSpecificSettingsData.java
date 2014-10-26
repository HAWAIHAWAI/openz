//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ReportandProcess;

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
class ParameterInstanceSpecificSettingsData implements FieldProvider {
static Logger log4j = Logger.getLogger(ParameterInstanceSpecificSettingsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adProcessParaId;
  public String adProcessParaIdr;
  public String seqno;
  public String colstotal;
  public String colstotalr;
  public String editsetting;
  public String editsettingr;
  public String fieldlength;
  public String adReferenceValueId;
  public String adReferenceValueIdr;
  public String adTableId;
  public String adTableIdr;
  public String adValRuleId;
  public String adValRuleIdr;
  public String includesemptyitem;
  public String includesemptyitemr;
  public String template;
  public String templater;
  public String isactive;
  public String visiblesetting;
  public String visiblesettingr;
  public String displaylogic;
  public String readonlylogic;
  public String mandantorylogic;
  public String defaultvalue;
  public String adOrgId;
  public String isfirstfocusedfield;
  public String adClientId;
  public String adProcessParaInstanceId;
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
    else if (fieldName.equalsIgnoreCase("ad_process_para_id") || fieldName.equals("adProcessParaId"))
      return adProcessParaId;
    else if (fieldName.equalsIgnoreCase("ad_process_para_idr") || fieldName.equals("adProcessParaIdr"))
      return adProcessParaIdr;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("colstotal"))
      return colstotal;
    else if (fieldName.equalsIgnoreCase("colstotalr"))
      return colstotalr;
    else if (fieldName.equalsIgnoreCase("editsetting"))
      return editsetting;
    else if (fieldName.equalsIgnoreCase("editsettingr"))
      return editsettingr;
    else if (fieldName.equalsIgnoreCase("fieldlength"))
      return fieldlength;
    else if (fieldName.equalsIgnoreCase("ad_reference_value_id") || fieldName.equals("adReferenceValueId"))
      return adReferenceValueId;
    else if (fieldName.equalsIgnoreCase("ad_reference_value_idr") || fieldName.equals("adReferenceValueIdr"))
      return adReferenceValueIdr;
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
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("visiblesetting"))
      return visiblesetting;
    else if (fieldName.equalsIgnoreCase("visiblesettingr"))
      return visiblesettingr;
    else if (fieldName.equalsIgnoreCase("displaylogic"))
      return displaylogic;
    else if (fieldName.equalsIgnoreCase("readonlylogic"))
      return readonlylogic;
    else if (fieldName.equalsIgnoreCase("mandantorylogic"))
      return mandantorylogic;
    else if (fieldName.equalsIgnoreCase("defaultvalue"))
      return defaultvalue;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isfirstfocusedfield"))
      return isfirstfocusedfield;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_process_para_instance_id") || fieldName.equals("adProcessParaInstanceId"))
      return adProcessParaInstanceId;
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
  public static ParameterInstanceSpecificSettingsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adProcessParaId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adProcessParaId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ParameterInstanceSpecificSettingsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adProcessParaId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_process_para_instance.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_process_para_instance.CreatedBy) as CreatedByR, " +
      "        to_char(ad_process_para_instance.Updated, ?) as updated, " +
      "        to_char(ad_process_para_instance.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_process_para_instance.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_process_para_instance.UpdatedBy) as UpdatedByR," +
      "        ad_process_para_instance.AD_Process_Para_ID, " +
      "(CASE WHEN ad_process_para_instance.AD_Process_Para_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Process_Para_IDR, " +
      "ad_process_para_instance.Seqno, " +
      "ad_process_para_instance.Colstotal, " +
      "(CASE WHEN ad_process_para_instance.Colstotal IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ColstotalR, " +
      "ad_process_para_instance.Editsetting, " +
      "(CASE WHEN ad_process_para_instance.Editsetting IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS EditsettingR, " +
      "ad_process_para_instance.Fieldlength, " +
      "ad_process_para_instance.AD_Reference_Value_ID, " +
      "(CASE WHEN ad_process_para_instance.AD_Reference_Value_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS AD_Reference_Value_IDR, " +
      "ad_process_para_instance.AD_Table_ID, " +
      "(CASE WHEN ad_process_para_instance.AD_Table_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.TableName), ''))),'') ) END) AS AD_Table_IDR, " +
      "ad_process_para_instance.AD_Val_Rule_ID, " +
      "(CASE WHEN ad_process_para_instance.AD_Val_Rule_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_Val_Rule_IDR, " +
      "ad_process_para_instance.Includesemptyitem, " +
      "(CASE WHEN ad_process_para_instance.Includesemptyitem IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS IncludesemptyitemR, " +
      "ad_process_para_instance.Template, " +
      "(CASE WHEN ad_process_para_instance.Template IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS TemplateR, " +
      "COALESCE(ad_process_para_instance.Isactive, 'N') AS Isactive, " +
      "ad_process_para_instance.Visiblesetting, " +
      "(CASE WHEN ad_process_para_instance.Visiblesetting IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list5.name),'') ) END) AS VisiblesettingR, " +
      "ad_process_para_instance.Displaylogic, " +
      "ad_process_para_instance.Readonlylogic, " +
      "ad_process_para_instance.Mandantorylogic, " +
      "ad_process_para_instance.Defaultvalue, " +
      "ad_process_para_instance.AD_Org_ID, " +
      "ad_process_para_instance.Isfirstfocusedfield, " +
      "ad_process_para_instance.AD_Client_ID, " +
      "ad_process_para_instance.AD_Process_Para_Instance_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_process_para_instance left join (select AD_Process_Para_ID, Name from AD_Process_Para) table1 on (ad_process_para_instance.AD_Process_Para_ID = table1.AD_Process_Para_ID) left join ad_ref_list_v list1 on (ad_process_para_instance.Colstotal = list1.value and list1.ad_reference_id = '90234A91172D442B839E332DEE305E6F' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (ad_process_para_instance.Editsetting = list2.value and list2.ad_reference_id = '0765914076274AD79BACA01E75F4D0A1' and list2.ad_language = ?)  left join (select AD_Reference_ID, Name from AD_Reference) table2 on (ad_process_para_instance.AD_Reference_Value_ID =  table2.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL2 on (table2.AD_Reference_ID = tableTRL2.AD_Reference_ID and tableTRL2.AD_Language = ?)  left join (select AD_Table_ID, TableName from AD_Table) table3 on (ad_process_para_instance.AD_Table_ID = table3.AD_Table_ID) left join (select AD_Val_Rule_ID, Name from AD_Val_Rule) table4 on (ad_process_para_instance.AD_Val_Rule_ID = table4.AD_Val_Rule_ID) left join ad_ref_list_v list3 on (ad_process_para_instance.Includesemptyitem = list3.value and list3.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list3.ad_language = ?)  left join ad_ref_list_v list4 on (ad_process_para_instance.Template = list4.value and list4.ad_reference_id = '029984D63BCA4F67AD81C93DCF486DFE' and list4.ad_language = ?)  left join ad_ref_list_v list5 on (ad_process_para_instance.Visiblesetting = list5.value and list5.ad_reference_id = 'A4801B9D7ADB4BB69EBF727B71C8AB45' and list5.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adProcessParaId==null || adProcessParaId.equals(""))?"":"  AND ad_process_para_instance.AD_Process_Para_ID = ?  ");
    strSql = strSql + 
      "        AND ad_process_para_instance.AD_Process_Para_Instance_ID = ? " +
      "        AND ad_process_para_instance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_process_para_instance.AD_Org_ID IN (";
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
      if (adProcessParaId != null && !(adProcessParaId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessParaId);
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
        ParameterInstanceSpecificSettingsData objectParameterInstanceSpecificSettingsData = new ParameterInstanceSpecificSettingsData();
        objectParameterInstanceSpecificSettingsData.created = UtilSql.getValue(result, "created");
        objectParameterInstanceSpecificSettingsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectParameterInstanceSpecificSettingsData.updated = UtilSql.getValue(result, "updated");
        objectParameterInstanceSpecificSettingsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectParameterInstanceSpecificSettingsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectParameterInstanceSpecificSettingsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectParameterInstanceSpecificSettingsData.adProcessParaId = UtilSql.getValue(result, "ad_process_para_id");
        objectParameterInstanceSpecificSettingsData.adProcessParaIdr = UtilSql.getValue(result, "ad_process_para_idr");
        objectParameterInstanceSpecificSettingsData.seqno = UtilSql.getValue(result, "seqno");
        objectParameterInstanceSpecificSettingsData.colstotal = UtilSql.getValue(result, "colstotal");
        objectParameterInstanceSpecificSettingsData.colstotalr = UtilSql.getValue(result, "colstotalr");
        objectParameterInstanceSpecificSettingsData.editsetting = UtilSql.getValue(result, "editsetting");
        objectParameterInstanceSpecificSettingsData.editsettingr = UtilSql.getValue(result, "editsettingr");
        objectParameterInstanceSpecificSettingsData.fieldlength = UtilSql.getValue(result, "fieldlength");
        objectParameterInstanceSpecificSettingsData.adReferenceValueId = UtilSql.getValue(result, "ad_reference_value_id");
        objectParameterInstanceSpecificSettingsData.adReferenceValueIdr = UtilSql.getValue(result, "ad_reference_value_idr");
        objectParameterInstanceSpecificSettingsData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectParameterInstanceSpecificSettingsData.adTableIdr = UtilSql.getValue(result, "ad_table_idr");
        objectParameterInstanceSpecificSettingsData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectParameterInstanceSpecificSettingsData.adValRuleIdr = UtilSql.getValue(result, "ad_val_rule_idr");
        objectParameterInstanceSpecificSettingsData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectParameterInstanceSpecificSettingsData.includesemptyitemr = UtilSql.getValue(result, "includesemptyitemr");
        objectParameterInstanceSpecificSettingsData.template = UtilSql.getValue(result, "template");
        objectParameterInstanceSpecificSettingsData.templater = UtilSql.getValue(result, "templater");
        objectParameterInstanceSpecificSettingsData.isactive = UtilSql.getValue(result, "isactive");
        objectParameterInstanceSpecificSettingsData.visiblesetting = UtilSql.getValue(result, "visiblesetting");
        objectParameterInstanceSpecificSettingsData.visiblesettingr = UtilSql.getValue(result, "visiblesettingr");
        objectParameterInstanceSpecificSettingsData.displaylogic = UtilSql.getValue(result, "displaylogic");
        objectParameterInstanceSpecificSettingsData.readonlylogic = UtilSql.getValue(result, "readonlylogic");
        objectParameterInstanceSpecificSettingsData.mandantorylogic = UtilSql.getValue(result, "mandantorylogic");
        objectParameterInstanceSpecificSettingsData.defaultvalue = UtilSql.getValue(result, "defaultvalue");
        objectParameterInstanceSpecificSettingsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectParameterInstanceSpecificSettingsData.isfirstfocusedfield = UtilSql.getValue(result, "isfirstfocusedfield");
        objectParameterInstanceSpecificSettingsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectParameterInstanceSpecificSettingsData.adProcessParaInstanceId = UtilSql.getValue(result, "ad_process_para_instance_id");
        objectParameterInstanceSpecificSettingsData.language = UtilSql.getValue(result, "language");
        objectParameterInstanceSpecificSettingsData.adUserClient = "";
        objectParameterInstanceSpecificSettingsData.adOrgClient = "";
        objectParameterInstanceSpecificSettingsData.createdby = "";
        objectParameterInstanceSpecificSettingsData.trBgcolor = "";
        objectParameterInstanceSpecificSettingsData.totalCount = "";
        objectParameterInstanceSpecificSettingsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectParameterInstanceSpecificSettingsData);
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
    ParameterInstanceSpecificSettingsData objectParameterInstanceSpecificSettingsData[] = new ParameterInstanceSpecificSettingsData[vector.size()];
    vector.copyInto(objectParameterInstanceSpecificSettingsData);
    return(objectParameterInstanceSpecificSettingsData);
  }

/**
Create a registry
 */
  public static ParameterInstanceSpecificSettingsData[] set(String adProcessParaId, String adOrgId, String visiblesetting, String seqno, String updatedby, String updatedbyr, String adTableId, String readonlylogic, String displaylogic, String isactive, String adProcessParaInstanceId, String fieldlength, String editsetting, String template, String includesemptyitem, String adReferenceValueId, String mandantorylogic, String defaultvalue, String isfirstfocusedfield, String adValRuleId, String adClientId, String createdby, String createdbyr, String colstotal)    throws ServletException {
    ParameterInstanceSpecificSettingsData objectParameterInstanceSpecificSettingsData[] = new ParameterInstanceSpecificSettingsData[1];
    objectParameterInstanceSpecificSettingsData[0] = new ParameterInstanceSpecificSettingsData();
    objectParameterInstanceSpecificSettingsData[0].created = "";
    objectParameterInstanceSpecificSettingsData[0].createdbyr = createdbyr;
    objectParameterInstanceSpecificSettingsData[0].updated = "";
    objectParameterInstanceSpecificSettingsData[0].updatedTimeStamp = "";
    objectParameterInstanceSpecificSettingsData[0].updatedby = updatedby;
    objectParameterInstanceSpecificSettingsData[0].updatedbyr = updatedbyr;
    objectParameterInstanceSpecificSettingsData[0].adProcessParaId = adProcessParaId;
    objectParameterInstanceSpecificSettingsData[0].adProcessParaIdr = "";
    objectParameterInstanceSpecificSettingsData[0].seqno = seqno;
    objectParameterInstanceSpecificSettingsData[0].colstotal = colstotal;
    objectParameterInstanceSpecificSettingsData[0].colstotalr = "";
    objectParameterInstanceSpecificSettingsData[0].editsetting = editsetting;
    objectParameterInstanceSpecificSettingsData[0].editsettingr = "";
    objectParameterInstanceSpecificSettingsData[0].fieldlength = fieldlength;
    objectParameterInstanceSpecificSettingsData[0].adReferenceValueId = adReferenceValueId;
    objectParameterInstanceSpecificSettingsData[0].adReferenceValueIdr = "";
    objectParameterInstanceSpecificSettingsData[0].adTableId = adTableId;
    objectParameterInstanceSpecificSettingsData[0].adTableIdr = "";
    objectParameterInstanceSpecificSettingsData[0].adValRuleId = adValRuleId;
    objectParameterInstanceSpecificSettingsData[0].adValRuleIdr = "";
    objectParameterInstanceSpecificSettingsData[0].includesemptyitem = includesemptyitem;
    objectParameterInstanceSpecificSettingsData[0].includesemptyitemr = "";
    objectParameterInstanceSpecificSettingsData[0].template = template;
    objectParameterInstanceSpecificSettingsData[0].templater = "";
    objectParameterInstanceSpecificSettingsData[0].isactive = isactive;
    objectParameterInstanceSpecificSettingsData[0].visiblesetting = visiblesetting;
    objectParameterInstanceSpecificSettingsData[0].visiblesettingr = "";
    objectParameterInstanceSpecificSettingsData[0].displaylogic = displaylogic;
    objectParameterInstanceSpecificSettingsData[0].readonlylogic = readonlylogic;
    objectParameterInstanceSpecificSettingsData[0].mandantorylogic = mandantorylogic;
    objectParameterInstanceSpecificSettingsData[0].defaultvalue = defaultvalue;
    objectParameterInstanceSpecificSettingsData[0].adOrgId = adOrgId;
    objectParameterInstanceSpecificSettingsData[0].isfirstfocusedfield = isfirstfocusedfield;
    objectParameterInstanceSpecificSettingsData[0].adClientId = adClientId;
    objectParameterInstanceSpecificSettingsData[0].adProcessParaInstanceId = adProcessParaInstanceId;
    objectParameterInstanceSpecificSettingsData[0].language = "";
    return objectParameterInstanceSpecificSettingsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefD00871BE97DD46D19747F0BF82F1527E_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefA97FFE82A94D421FA3CE03E14E6B8F37_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT ad_process_para_instance.AD_Process_Para_ID AS NAME" +
      "        FROM ad_process_para_instance" +
      "        WHERE ad_process_para_instance.AD_Process_Para_Instance_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adProcessParaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Process_Para left join (select AD_Process_Para_ID, Name from AD_Process_Para) table1 on (AD_Process_Para.AD_Process_Para_ID = table1.AD_Process_Para_ID) WHERE AD_Process_Para.AD_Process_Para_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessParaId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adProcessParaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Process_Para left join (select AD_Process_Para_ID, Name from AD_Process_Para) table1 on (AD_Process_Para.AD_Process_Para_ID = table1.AD_Process_Para_ID) WHERE AD_Process_Para.AD_Process_Para_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessParaId);

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
      "        UPDATE ad_process_para_instance" +
      "        SET AD_Process_Para_ID = (?) , Seqno = TO_NUMBER(?) , Colstotal = (?) , Editsetting = (?) , Fieldlength = TO_NUMBER(?) , AD_Reference_Value_ID = (?) , AD_Table_ID = (?) , AD_Val_Rule_ID = (?) , Includesemptyitem = (?) , Template = (?) , Isactive = (?) , Visiblesetting = (?) , Displaylogic = (?) , Readonlylogic = (?) , Mandantorylogic = (?) , Defaultvalue = (?) , AD_Org_ID = (?) , Isfirstfocusedfield = (?) , AD_Client_ID = (?) , AD_Process_Para_Instance_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_process_para_instance.AD_Process_Para_Instance_ID = ? " +
      "                 AND ad_process_para_instance.AD_Process_Para_ID = ? " +
      "        AND ad_process_para_instance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_process_para_instance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessParaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colstotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, editsetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fieldlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceValueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, visiblesetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displaylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfirstfocusedfield);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessParaInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessParaInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessParaId);
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
      "        INSERT INTO ad_process_para_instance " +
      "        (AD_Process_Para_ID, Seqno, Colstotal, Editsetting, Fieldlength, AD_Reference_Value_ID, AD_Table_ID, AD_Val_Rule_ID, Includesemptyitem, Template, Isactive, Visiblesetting, Displaylogic, Readonlylogic, Mandantorylogic, Defaultvalue, AD_Org_ID, Isfirstfocusedfield, AD_Client_ID, AD_Process_Para_Instance_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessParaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colstotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, editsetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fieldlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceValueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, visiblesetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displaylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfirstfocusedfield);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessParaInstanceId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adProcessParaId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_process_para_instance" +
      "        WHERE ad_process_para_instance.AD_Process_Para_Instance_ID = ? " +
      "                 AND ad_process_para_instance.AD_Process_Para_ID = ? " +
      "        AND ad_process_para_instance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_process_para_instance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessParaId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adProcessParaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_process_para_instance" +
      "        WHERE ad_process_para_instance.AD_Process_Para_Instance_ID = ? " +
      "                 AND ad_process_para_instance.AD_Process_Para_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessParaId);

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
      "          FROM ad_process_para_instance" +
      "         WHERE ad_process_para_instance.AD_Process_Para_Instance_ID = ? ";

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
      "          FROM ad_process_para_instance" +
      "         WHERE ad_process_para_instance.AD_Process_Para_Instance_ID = ? ";

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
