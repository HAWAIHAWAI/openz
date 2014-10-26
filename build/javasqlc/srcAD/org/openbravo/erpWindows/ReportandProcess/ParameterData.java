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
class ParameterData implements FieldProvider {
static Logger log4j = Logger.getLogger(ParameterData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adProcessId;
  public String adProcessIdr;
  public String seqno;
  public String columnname;
  public String adElementId;
  public String adElementIdr;
  public String iscentrallymaintained;
  public String colstotal;
  public String colstotalr;
  public String readonly;
  public String ismandatory;
  public String fieldlength;
  public String adReferenceValueId;
  public String adReferenceValueIdr;
  public String adTableId;
  public String adTableIdr;
  public String adValRuleId;
  public String adValRuleIdr;
  public String includesemptyitem;
  public String template;
  public String templater;
  public String isactive;
  public String isdisplayed;
  public String displaylogic;
  public String readonlylogic;
  public String mandantorylogic;
  public String defaultvalue;
  public String description;
  public String help;
  public String name;
  public String vformat;
  public String isfirstfocusedfield;
  public String valuemin;
  public String adReferenceId;
  public String adProcessParaId;
  public String adOrgId;
  public String adClientId;
  public String valuemax;
  public String defaultvalue2;
  public String isrange;
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
    else if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
    else if (fieldName.equalsIgnoreCase("ad_process_idr") || fieldName.equals("adProcessIdr"))
      return adProcessIdr;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("columnname"))
      return columnname;
    else if (fieldName.equalsIgnoreCase("ad_element_id") || fieldName.equals("adElementId"))
      return adElementId;
    else if (fieldName.equalsIgnoreCase("ad_element_idr") || fieldName.equals("adElementIdr"))
      return adElementIdr;
    else if (fieldName.equalsIgnoreCase("iscentrallymaintained"))
      return iscentrallymaintained;
    else if (fieldName.equalsIgnoreCase("colstotal"))
      return colstotal;
    else if (fieldName.equalsIgnoreCase("colstotalr"))
      return colstotalr;
    else if (fieldName.equalsIgnoreCase("readonly"))
      return readonly;
    else if (fieldName.equalsIgnoreCase("ismandatory"))
      return ismandatory;
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
    else if (fieldName.equalsIgnoreCase("template"))
      return template;
    else if (fieldName.equalsIgnoreCase("templater"))
      return templater;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isdisplayed"))
      return isdisplayed;
    else if (fieldName.equalsIgnoreCase("displaylogic"))
      return displaylogic;
    else if (fieldName.equalsIgnoreCase("readonlylogic"))
      return readonlylogic;
    else if (fieldName.equalsIgnoreCase("mandantorylogic"))
      return mandantorylogic;
    else if (fieldName.equalsIgnoreCase("defaultvalue"))
      return defaultvalue;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("vformat"))
      return vformat;
    else if (fieldName.equalsIgnoreCase("isfirstfocusedfield"))
      return isfirstfocusedfield;
    else if (fieldName.equalsIgnoreCase("valuemin"))
      return valuemin;
    else if (fieldName.equalsIgnoreCase("ad_reference_id") || fieldName.equals("adReferenceId"))
      return adReferenceId;
    else if (fieldName.equalsIgnoreCase("ad_process_para_id") || fieldName.equals("adProcessParaId"))
      return adProcessParaId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("valuemax"))
      return valuemax;
    else if (fieldName.equalsIgnoreCase("defaultvalue2"))
      return defaultvalue2;
    else if (fieldName.equalsIgnoreCase("isrange"))
      return isrange;
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
  public static ParameterData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adProcessId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adProcessId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ParameterData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adProcessId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Process_Para.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Process_Para.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Process_Para.Updated, ?) as updated, " +
      "        to_char(AD_Process_Para.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Process_Para.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Process_Para.UpdatedBy) as UpdatedByR," +
      "        AD_Process_Para.AD_Process_ID, " +
      "(CASE WHEN AD_Process_Para.AD_Process_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS AD_Process_IDR, " +
      "AD_Process_Para.SeqNo, " +
      "AD_Process_Para.ColumnName, " +
      "AD_Process_Para.AD_Element_ID, " +
      "(CASE WHEN AD_Process_Para.AD_Element_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.ColumnName), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Element_IDR, " +
      "COALESCE(AD_Process_Para.IsCentrallyMaintained, 'N') AS IsCentrallyMaintained, " +
      "AD_Process_Para.Colstotal, " +
      "(CASE WHEN AD_Process_Para.Colstotal IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ColstotalR, " +
      "COALESCE(AD_Process_Para.Readonly, 'N') AS Readonly, " +
      "COALESCE(AD_Process_Para.IsMandatory, 'N') AS IsMandatory, " +
      "AD_Process_Para.FieldLength, " +
      "AD_Process_Para.AD_Reference_Value_ID, " +
      "(CASE WHEN AD_Process_Para.AD_Reference_Value_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS AD_Reference_Value_IDR, " +
      "AD_Process_Para.AD_Table_ID, " +
      "(CASE WHEN AD_Process_Para.AD_Table_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.TableName), ''))),'') ) END) AS AD_Table_IDR, " +
      "AD_Process_Para.AD_Val_Rule_ID, " +
      "(CASE WHEN AD_Process_Para.AD_Val_Rule_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_Val_Rule_IDR, " +
      "COALESCE(AD_Process_Para.Includesemptyitem, 'N') AS Includesemptyitem, " +
      "AD_Process_Para.Template, " +
      "(CASE WHEN AD_Process_Para.Template IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS TemplateR, " +
      "COALESCE(AD_Process_Para.IsActive, 'N') AS IsActive, " +
      "COALESCE(AD_Process_Para.Isdisplayed, 'N') AS Isdisplayed, " +
      "AD_Process_Para.Displaylogic, " +
      "AD_Process_Para.Readonlylogic, " +
      "AD_Process_Para.Mandantorylogic, " +
      "AD_Process_Para.DefaultValue, " +
      "AD_Process_Para.Description, " +
      "AD_Process_Para.Help, " +
      "AD_Process_Para.Name, " +
      "AD_Process_Para.VFormat, " +
      "COALESCE(AD_Process_Para.Isfirstfocusedfield, 'N') AS Isfirstfocusedfield, " +
      "AD_Process_Para.ValueMin, " +
      "AD_Process_Para.AD_Reference_ID, " +
      "AD_Process_Para.AD_Process_Para_ID, " +
      "AD_Process_Para.AD_Org_ID, " +
      "AD_Process_Para.AD_Client_ID, " +
      "AD_Process_Para.ValueMax, " +
      "AD_Process_Para.DefaultValue2, " +
      "COALESCE(AD_Process_Para.IsRange, 'N') AS IsRange, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Process_Para left join (select AD_Process_ID, Name from AD_Process) table1 on (AD_Process_Para.AD_Process_ID = table1.AD_Process_ID) left join (select AD_Process_ID,AD_Language, Name from AD_Process_TRL) tableTRL1 on (table1.AD_Process_ID = tableTRL1.AD_Process_ID and tableTRL1.AD_Language = ?)  left join (select AD_Element_ID, ColumnName, Name from AD_Element) table2 on (AD_Process_Para.AD_Element_ID = table2.AD_Element_ID) left join ad_ref_list_v list1 on (AD_Process_Para.Colstotal = list1.value and list1.ad_reference_id = '90234A91172D442B839E332DEE305E6F' and list1.ad_language = ?)  left join (select AD_Reference_ID, Name from AD_Reference) table3 on (AD_Process_Para.AD_Reference_Value_ID =  table3.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL3 on (table3.AD_Reference_ID = tableTRL3.AD_Reference_ID and tableTRL3.AD_Language = ?)  left join (select AD_Table_ID, TableName from AD_Table) table4 on (AD_Process_Para.AD_Table_ID = table4.AD_Table_ID) left join (select AD_Val_Rule_ID, Name from AD_Val_Rule) table5 on (AD_Process_Para.AD_Val_Rule_ID = table5.AD_Val_Rule_ID) left join ad_ref_list_v list2 on (AD_Process_Para.Template = list2.value and list2.ad_reference_id = '029984D63BCA4F67AD81C93DCF486DFE' and list2.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adProcessId==null || adProcessId.equals(""))?"":"  AND AD_Process_Para.AD_Process_ID = ?  ");
    strSql = strSql + 
      "        AND AD_Process_Para.AD_Process_Para_ID = ? " +
      "        AND AD_Process_Para.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Process_Para.AD_Org_ID IN (";
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
      if (adProcessId != null && !(adProcessId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
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
        ParameterData objectParameterData = new ParameterData();
        objectParameterData.created = UtilSql.getValue(result, "created");
        objectParameterData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectParameterData.updated = UtilSql.getValue(result, "updated");
        objectParameterData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectParameterData.updatedby = UtilSql.getValue(result, "updatedby");
        objectParameterData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectParameterData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectParameterData.adProcessIdr = UtilSql.getValue(result, "ad_process_idr");
        objectParameterData.seqno = UtilSql.getValue(result, "seqno");
        objectParameterData.columnname = UtilSql.getValue(result, "columnname");
        objectParameterData.adElementId = UtilSql.getValue(result, "ad_element_id");
        objectParameterData.adElementIdr = UtilSql.getValue(result, "ad_element_idr");
        objectParameterData.iscentrallymaintained = UtilSql.getValue(result, "iscentrallymaintained");
        objectParameterData.colstotal = UtilSql.getValue(result, "colstotal");
        objectParameterData.colstotalr = UtilSql.getValue(result, "colstotalr");
        objectParameterData.readonly = UtilSql.getValue(result, "readonly");
        objectParameterData.ismandatory = UtilSql.getValue(result, "ismandatory");
        objectParameterData.fieldlength = UtilSql.getValue(result, "fieldlength");
        objectParameterData.adReferenceValueId = UtilSql.getValue(result, "ad_reference_value_id");
        objectParameterData.adReferenceValueIdr = UtilSql.getValue(result, "ad_reference_value_idr");
        objectParameterData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectParameterData.adTableIdr = UtilSql.getValue(result, "ad_table_idr");
        objectParameterData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectParameterData.adValRuleIdr = UtilSql.getValue(result, "ad_val_rule_idr");
        objectParameterData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectParameterData.template = UtilSql.getValue(result, "template");
        objectParameterData.templater = UtilSql.getValue(result, "templater");
        objectParameterData.isactive = UtilSql.getValue(result, "isactive");
        objectParameterData.isdisplayed = UtilSql.getValue(result, "isdisplayed");
        objectParameterData.displaylogic = UtilSql.getValue(result, "displaylogic");
        objectParameterData.readonlylogic = UtilSql.getValue(result, "readonlylogic");
        objectParameterData.mandantorylogic = UtilSql.getValue(result, "mandantorylogic");
        objectParameterData.defaultvalue = UtilSql.getValue(result, "defaultvalue");
        objectParameterData.description = UtilSql.getValue(result, "description");
        objectParameterData.help = UtilSql.getValue(result, "help");
        objectParameterData.name = UtilSql.getValue(result, "name");
        objectParameterData.vformat = UtilSql.getValue(result, "vformat");
        objectParameterData.isfirstfocusedfield = UtilSql.getValue(result, "isfirstfocusedfield");
        objectParameterData.valuemin = UtilSql.getValue(result, "valuemin");
        objectParameterData.adReferenceId = UtilSql.getValue(result, "ad_reference_id");
        objectParameterData.adProcessParaId = UtilSql.getValue(result, "ad_process_para_id");
        objectParameterData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectParameterData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectParameterData.valuemax = UtilSql.getValue(result, "valuemax");
        objectParameterData.defaultvalue2 = UtilSql.getValue(result, "defaultvalue2");
        objectParameterData.isrange = UtilSql.getValue(result, "isrange");
        objectParameterData.language = UtilSql.getValue(result, "language");
        objectParameterData.adUserClient = "";
        objectParameterData.adOrgClient = "";
        objectParameterData.createdby = "";
        objectParameterData.trBgcolor = "";
        objectParameterData.totalCount = "";
        objectParameterData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectParameterData);
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
    ParameterData objectParameterData[] = new ParameterData[vector.size()];
    vector.copyInto(objectParameterData);
    return(objectParameterData);
  }

/**
Create a registry
 */
  public static ParameterData[] set(String adProcessId, String colstotal, String adReferenceValueId, String adValRuleId, String fieldlength, String valuemax, String iscentrallymaintained, String adReferenceId, String isrange, String adTableId, String adOrgId, String name, String mandantorylogic, String defaultvalue, String displaylogic, String readonly, String adProcessParaId, String ismandatory, String includesemptyitem, String updatedby, String updatedbyr, String readonlylogic, String seqno, String help, String adClientId, String template, String isactive, String createdby, String createdbyr, String isdisplayed, String defaultvalue2, String adElementId, String columnname, String isfirstfocusedfield, String description, String vformat, String valuemin)    throws ServletException {
    ParameterData objectParameterData[] = new ParameterData[1];
    objectParameterData[0] = new ParameterData();
    objectParameterData[0].created = "";
    objectParameterData[0].createdbyr = createdbyr;
    objectParameterData[0].updated = "";
    objectParameterData[0].updatedTimeStamp = "";
    objectParameterData[0].updatedby = updatedby;
    objectParameterData[0].updatedbyr = updatedbyr;
    objectParameterData[0].adProcessId = adProcessId;
    objectParameterData[0].adProcessIdr = "";
    objectParameterData[0].seqno = seqno;
    objectParameterData[0].columnname = columnname;
    objectParameterData[0].adElementId = adElementId;
    objectParameterData[0].adElementIdr = "";
    objectParameterData[0].iscentrallymaintained = iscentrallymaintained;
    objectParameterData[0].colstotal = colstotal;
    objectParameterData[0].colstotalr = "";
    objectParameterData[0].readonly = readonly;
    objectParameterData[0].ismandatory = ismandatory;
    objectParameterData[0].fieldlength = fieldlength;
    objectParameterData[0].adReferenceValueId = adReferenceValueId;
    objectParameterData[0].adReferenceValueIdr = "";
    objectParameterData[0].adTableId = adTableId;
    objectParameterData[0].adTableIdr = "";
    objectParameterData[0].adValRuleId = adValRuleId;
    objectParameterData[0].adValRuleIdr = "";
    objectParameterData[0].includesemptyitem = includesemptyitem;
    objectParameterData[0].template = template;
    objectParameterData[0].templater = "";
    objectParameterData[0].isactive = isactive;
    objectParameterData[0].isdisplayed = isdisplayed;
    objectParameterData[0].displaylogic = displaylogic;
    objectParameterData[0].readonlylogic = readonlylogic;
    objectParameterData[0].mandantorylogic = mandantorylogic;
    objectParameterData[0].defaultvalue = defaultvalue;
    objectParameterData[0].description = description;
    objectParameterData[0].help = help;
    objectParameterData[0].name = name;
    objectParameterData[0].vformat = vformat;
    objectParameterData[0].isfirstfocusedfield = isfirstfocusedfield;
    objectParameterData[0].valuemin = valuemin;
    objectParameterData[0].adReferenceId = adReferenceId;
    objectParameterData[0].adProcessParaId = adProcessParaId;
    objectParameterData[0].adOrgId = adOrgId;
    objectParameterData[0].adClientId = adClientId;
    objectParameterData[0].valuemax = valuemax;
    objectParameterData[0].defaultvalue2 = defaultvalue2;
    objectParameterData[0].isrange = isrange;
    objectParameterData[0].language = "";
    return objectParameterData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2821_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as UpdatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

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
  public static String selectDef2826(ConnectionProvider connectionProvider, String AD_Process_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(SeqNo),0)+10 AS DefaultValue FROM AD_Process_Para WHERE AD_Process_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Process_ID);

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
  public static String selectDef2819_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as CreatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

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
      "        SELECT AD_Process_Para.AD_Process_ID AS NAME" +
      "        FROM AD_Process_Para" +
      "        WHERE AD_Process_Para.AD_Process_Para_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adProcessId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM AD_Process left join (select AD_Process_ID, Name from AD_Process) table1 on (AD_Process.AD_Process_ID = table1.AD_Process_ID) left join (select AD_Process_ID,AD_Language, Name from AD_Process_TRL) tableTRL1 on (table1.AD_Process_ID = tableTRL1.AD_Process_ID and tableTRL1.AD_Language = ?)  WHERE AD_Process.AD_Process_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adProcessId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM AD_Process left join (select AD_Process_ID, Name from AD_Process) table1 on (AD_Process.AD_Process_ID = table1.AD_Process_ID) left join (select AD_Process_ID,AD_Language, Name from AD_Process_TRL) tableTRL1 on (table1.AD_Process_ID = tableTRL1.AD_Process_ID and tableTRL1.AD_Language = ?)  WHERE AD_Process.AD_Process_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);

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
      "        UPDATE AD_Process_Para" +
      "        SET AD_Process_ID = (?) , SeqNo = TO_NUMBER(?) , ColumnName = (?) , AD_Element_ID = (?) , IsCentrallyMaintained = (?) , Colstotal = (?) , Readonly = (?) , IsMandatory = (?) , FieldLength = TO_NUMBER(?) , AD_Reference_Value_ID = (?) , AD_Table_ID = (?) , AD_Val_Rule_ID = (?) , Includesemptyitem = (?) , Template = (?) , IsActive = (?) , Isdisplayed = (?) , Displaylogic = (?) , Readonlylogic = (?) , Mandantorylogic = (?) , DefaultValue = (?) , Description = (?) , Help = (?) , Name = (?) , VFormat = (?) , Isfirstfocusedfield = (?) , ValueMin = (?) , AD_Reference_ID = (?) , AD_Process_Para_ID = (?) , AD_Org_ID = (?) , AD_Client_ID = (?) , ValueMax = (?) , DefaultValue2 = (?) , IsRange = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Process_Para.AD_Process_Para_ID = ? " +
      "                 AND AD_Process_Para.AD_Process_ID = ? " +
      "        AND AD_Process_Para.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Process_Para.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, columnname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscentrallymaintained);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colstotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismandatory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fieldlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceValueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisplayed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displaylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vformat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfirstfocusedfield);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, valuemin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessParaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, valuemax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrange);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessParaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
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
      "        INSERT INTO AD_Process_Para " +
      "        (AD_Process_ID, SeqNo, ColumnName, AD_Element_ID, IsCentrallyMaintained, Colstotal, Readonly, IsMandatory, FieldLength, AD_Reference_Value_ID, AD_Table_ID, AD_Val_Rule_ID, Includesemptyitem, Template, IsActive, Isdisplayed, Displaylogic, Readonlylogic, Mandantorylogic, DefaultValue, Description, Help, Name, VFormat, Isfirstfocusedfield, ValueMin, AD_Reference_ID, AD_Process_Para_ID, AD_Org_ID, AD_Client_ID, ValueMax, DefaultValue2, IsRange, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, columnname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscentrallymaintained);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colstotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismandatory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fieldlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceValueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisplayed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displaylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vformat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfirstfocusedfield);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, valuemin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessParaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, valuemax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrange);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adProcessId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Process_Para" +
      "        WHERE AD_Process_Para.AD_Process_Para_ID = ? " +
      "                 AND AD_Process_Para.AD_Process_ID = ? " +
      "        AND AD_Process_Para.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Process_Para.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adProcessId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Process_Para" +
      "        WHERE AD_Process_Para.AD_Process_Para_ID = ? " +
      "                 AND AD_Process_Para.AD_Process_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);

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
      "          FROM AD_Process_Para" +
      "         WHERE AD_Process_Para.AD_Process_Para_ID = ? ";

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
      "          FROM AD_Process_Para" +
      "         WHERE AD_Process_Para.AD_Process_Para_ID = ? ";

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
