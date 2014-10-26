//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.TablesandColumns;

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
class ColumnData implements FieldProvider {
static Logger log4j = Logger.getLogger(ColumnData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String adTableId;
  public String adTableIdr;
  public String adModuleId;
  public String adModuleIdr;
  public String columnname;
  public String adElementId;
  public String adElementIdr;
  public String description;
  public String help;
  public String isactive;
  public String fieldlength;
  public String adReferenceId;
  public String adReferenceIdr;
  public String adValRuleId;
  public String adValRuleIdr;
  public String adProcessId;
  public String adProcessIdr;
  public String adReferenceValueId;
  public String adReferenceValueIdr;
  public String defaultvalue;
  public String iskey;
  public String isparent;
  public String readonlylogic;
  public String isidentifier;
  public String seqno;
  public String adCalloutId;
  public String adCalloutIdr;
  public String issessionattr;
  public String isencrypted;
  public String istranslated;
  public String developmentstatus;
  public String developmentstatusr;
  public String adColumnVId;
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
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("ad_table_idr") || fieldName.equals("adTableIdr"))
      return adTableIdr;
    else if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
    else if (fieldName.equalsIgnoreCase("ad_module_idr") || fieldName.equals("adModuleIdr"))
      return adModuleIdr;
    else if (fieldName.equalsIgnoreCase("columnname"))
      return columnname;
    else if (fieldName.equalsIgnoreCase("ad_element_id") || fieldName.equals("adElementId"))
      return adElementId;
    else if (fieldName.equalsIgnoreCase("ad_element_idr") || fieldName.equals("adElementIdr"))
      return adElementIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("fieldlength"))
      return fieldlength;
    else if (fieldName.equalsIgnoreCase("ad_reference_id") || fieldName.equals("adReferenceId"))
      return adReferenceId;
    else if (fieldName.equalsIgnoreCase("ad_reference_idr") || fieldName.equals("adReferenceIdr"))
      return adReferenceIdr;
    else if (fieldName.equalsIgnoreCase("ad_val_rule_id") || fieldName.equals("adValRuleId"))
      return adValRuleId;
    else if (fieldName.equalsIgnoreCase("ad_val_rule_idr") || fieldName.equals("adValRuleIdr"))
      return adValRuleIdr;
    else if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
    else if (fieldName.equalsIgnoreCase("ad_process_idr") || fieldName.equals("adProcessIdr"))
      return adProcessIdr;
    else if (fieldName.equalsIgnoreCase("ad_reference_value_id") || fieldName.equals("adReferenceValueId"))
      return adReferenceValueId;
    else if (fieldName.equalsIgnoreCase("ad_reference_value_idr") || fieldName.equals("adReferenceValueIdr"))
      return adReferenceValueIdr;
    else if (fieldName.equalsIgnoreCase("defaultvalue"))
      return defaultvalue;
    else if (fieldName.equalsIgnoreCase("iskey"))
      return iskey;
    else if (fieldName.equalsIgnoreCase("isparent"))
      return isparent;
    else if (fieldName.equalsIgnoreCase("readonlylogic"))
      return readonlylogic;
    else if (fieldName.equalsIgnoreCase("isidentifier"))
      return isidentifier;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("ad_callout_id") || fieldName.equals("adCalloutId"))
      return adCalloutId;
    else if (fieldName.equalsIgnoreCase("ad_callout_idr") || fieldName.equals("adCalloutIdr"))
      return adCalloutIdr;
    else if (fieldName.equalsIgnoreCase("issessionattr"))
      return issessionattr;
    else if (fieldName.equalsIgnoreCase("isencrypted"))
      return isencrypted;
    else if (fieldName.equalsIgnoreCase("istranslated"))
      return istranslated;
    else if (fieldName.equalsIgnoreCase("developmentstatus"))
      return developmentstatus;
    else if (fieldName.equalsIgnoreCase("developmentstatusr"))
      return developmentstatusr;
    else if (fieldName.equalsIgnoreCase("ad_column_v_id") || fieldName.equals("adColumnVId"))
      return adColumnVId;
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
  public static ColumnData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adTableId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adTableId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ColumnData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adTableId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_column_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_column_v.CreatedBy) as CreatedByR, " +
      "        to_char(ad_column_v.Updated, ?) as updated, " +
      "        to_char(ad_column_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_column_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_column_v.UpdatedBy) as UpdatedByR," +
      "        ad_column_v.AD_Client_ID, " +
      "(CASE WHEN ad_column_v.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "ad_column_v.AD_Org_ID, " +
      "(CASE WHEN ad_column_v.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "ad_column_v.AD_Table_ID, " +
      "(CASE WHEN ad_column_v.AD_Table_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.TableName), ''))),'') ) END) AS AD_Table_IDR, " +
      "ad_column_v.AD_Module_ID, " +
      "(CASE WHEN ad_column_v.AD_Module_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Version), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_Module_IDR, " +
      "ad_column_v.Columnname, " +
      "ad_column_v.AD_Element_ID, " +
      "(CASE WHEN ad_column_v.AD_Element_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.ColumnName), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS AD_Element_IDR, " +
      "ad_column_v.Description, " +
      "ad_column_v.Help, " +
      "COALESCE(ad_column_v.Isactive, 'N') AS Isactive, " +
      "ad_column_v.Fieldlength, " +
      "ad_column_v.AD_Reference_ID, " +
      "(CASE WHEN ad_column_v.AD_Reference_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL7.Name IS NULL THEN TO_CHAR(table7.Name) ELSE TO_CHAR(tableTRL7.Name) END)), ''))),'') ) END) AS AD_Reference_IDR, " +
      "ad_column_v.AD_Val_Rule_ID, " +
      "(CASE WHEN ad_column_v.AD_Val_Rule_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS AD_Val_Rule_IDR, " +
      "ad_column_v.AD_Process_ID, " +
      "(CASE WHEN ad_column_v.AD_Process_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL9.Name IS NULL THEN TO_CHAR(table9.Name) ELSE TO_CHAR(tableTRL9.Name) END)), ''))),'') ) END) AS AD_Process_IDR, " +
      "ad_column_v.AD_Reference_Value_ID, " +
      "(CASE WHEN ad_column_v.AD_Reference_Value_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL10.Name IS NULL THEN TO_CHAR(table10.Name) ELSE TO_CHAR(tableTRL10.Name) END)), ''))),'') ) END) AS AD_Reference_Value_IDR, " +
      "ad_column_v.Defaultvalue, " +
      "COALESCE(ad_column_v.Iskey, 'N') AS Iskey, " +
      "COALESCE(ad_column_v.Isparent, 'N') AS Isparent, " +
      "ad_column_v.Readonlylogic, " +
      "COALESCE(ad_column_v.Isidentifier, 'N') AS Isidentifier, " +
      "ad_column_v.Seqno, " +
      "ad_column_v.AD_Callout_ID, " +
      "(CASE WHEN ad_column_v.AD_Callout_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS AD_Callout_IDR, " +
      "COALESCE(ad_column_v.Issessionattr, 'N') AS Issessionattr, " +
      "COALESCE(ad_column_v.Isencrypted, 'N') AS Isencrypted, " +
      "COALESCE(ad_column_v.Istranslated, 'N') AS Istranslated, " +
      "ad_column_v.Developmentstatus, " +
      "(CASE WHEN ad_column_v.Developmentstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DevelopmentstatusR, " +
      "ad_column_v.AD_Column_V_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_column_v left join (select AD_Client_ID, Name from AD_Client) table1 on (ad_column_v.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (ad_column_v.AD_Org_ID = table2.AD_Org_ID) left join (select AD_Table_ID, TableName from AD_Table) table3 on (ad_column_v.AD_Table_ID = table3.AD_Table_ID) left join (select AD_Module_ID, Name, Version, AD_Language from AD_Module) table4 on (ad_column_v.AD_Module_ID = table4.AD_Module_ID) left join (select AD_Language, Name from AD_Language) table5 on (table4.AD_Language =  table5.AD_Language) left join (select AD_Element_ID, ColumnName, Name from AD_Element) table6 on (ad_column_v.AD_Element_ID = table6.AD_Element_ID) left join (select AD_Reference_ID, Name from AD_Reference) table7 on (ad_column_v.AD_Reference_ID =  table7.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL7 on (table7.AD_Reference_ID = tableTRL7.AD_Reference_ID and tableTRL7.AD_Language = ?)  left join (select AD_Val_Rule_ID, Name from AD_Val_Rule) table8 on (ad_column_v.AD_Val_Rule_ID = table8.AD_Val_Rule_ID) left join (select AD_Process_ID, Name from AD_Process) table9 on (ad_column_v.AD_Process_ID = table9.AD_Process_ID) left join (select AD_Process_ID,AD_Language, Name from AD_Process_TRL) tableTRL9 on (table9.AD_Process_ID = tableTRL9.AD_Process_ID and tableTRL9.AD_Language = ?)  left join (select AD_Reference_ID, Name from AD_Reference) table10 on (ad_column_v.AD_Reference_Value_ID =  table10.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL10 on (table10.AD_Reference_ID = tableTRL10.AD_Reference_ID and tableTRL10.AD_Language = ?)  left join (select AD_Callout_ID, Name from AD_Callout) table11 on (ad_column_v.AD_Callout_ID = table11.AD_Callout_ID) left join ad_ref_list_v list1 on (ad_column_v.Developmentstatus = list1.value and list1.ad_reference_id = '800103' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adTableId==null || adTableId.equals(""))?"":"  AND ad_column_v.AD_Table_ID = ?  ");
    strSql = strSql + 
      "        AND ad_column_v.AD_Column_V_ID = ? " +
      "        AND ad_column_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_column_v.AD_Org_ID IN (";
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
      if (adTableId != null && !(adTableId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
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
        ColumnData objectColumnData = new ColumnData();
        objectColumnData.created = UtilSql.getValue(result, "created");
        objectColumnData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectColumnData.updated = UtilSql.getValue(result, "updated");
        objectColumnData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectColumnData.updatedby = UtilSql.getValue(result, "updatedby");
        objectColumnData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectColumnData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectColumnData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectColumnData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectColumnData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectColumnData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectColumnData.adTableIdr = UtilSql.getValue(result, "ad_table_idr");
        objectColumnData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectColumnData.adModuleIdr = UtilSql.getValue(result, "ad_module_idr");
        objectColumnData.columnname = UtilSql.getValue(result, "columnname");
        objectColumnData.adElementId = UtilSql.getValue(result, "ad_element_id");
        objectColumnData.adElementIdr = UtilSql.getValue(result, "ad_element_idr");
        objectColumnData.description = UtilSql.getValue(result, "description");
        objectColumnData.help = UtilSql.getValue(result, "help");
        objectColumnData.isactive = UtilSql.getValue(result, "isactive");
        objectColumnData.fieldlength = UtilSql.getValue(result, "fieldlength");
        objectColumnData.adReferenceId = UtilSql.getValue(result, "ad_reference_id");
        objectColumnData.adReferenceIdr = UtilSql.getValue(result, "ad_reference_idr");
        objectColumnData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectColumnData.adValRuleIdr = UtilSql.getValue(result, "ad_val_rule_idr");
        objectColumnData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectColumnData.adProcessIdr = UtilSql.getValue(result, "ad_process_idr");
        objectColumnData.adReferenceValueId = UtilSql.getValue(result, "ad_reference_value_id");
        objectColumnData.adReferenceValueIdr = UtilSql.getValue(result, "ad_reference_value_idr");
        objectColumnData.defaultvalue = UtilSql.getValue(result, "defaultvalue");
        objectColumnData.iskey = UtilSql.getValue(result, "iskey");
        objectColumnData.isparent = UtilSql.getValue(result, "isparent");
        objectColumnData.readonlylogic = UtilSql.getValue(result, "readonlylogic");
        objectColumnData.isidentifier = UtilSql.getValue(result, "isidentifier");
        objectColumnData.seqno = UtilSql.getValue(result, "seqno");
        objectColumnData.adCalloutId = UtilSql.getValue(result, "ad_callout_id");
        objectColumnData.adCalloutIdr = UtilSql.getValue(result, "ad_callout_idr");
        objectColumnData.issessionattr = UtilSql.getValue(result, "issessionattr");
        objectColumnData.isencrypted = UtilSql.getValue(result, "isencrypted");
        objectColumnData.istranslated = UtilSql.getValue(result, "istranslated");
        objectColumnData.developmentstatus = UtilSql.getValue(result, "developmentstatus");
        objectColumnData.developmentstatusr = UtilSql.getValue(result, "developmentstatusr");
        objectColumnData.adColumnVId = UtilSql.getValue(result, "ad_column_v_id");
        objectColumnData.language = UtilSql.getValue(result, "language");
        objectColumnData.adUserClient = "";
        objectColumnData.adOrgClient = "";
        objectColumnData.createdby = "";
        objectColumnData.trBgcolor = "";
        objectColumnData.totalCount = "";
        objectColumnData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectColumnData);
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
    ColumnData objectColumnData[] = new ColumnData[vector.size()];
    vector.copyInto(objectColumnData);
    return(objectColumnData);
  }

/**
Create a registry
 */
  public static ColumnData[] set(String adTableId, String help, String createdby, String createdbyr, String columnname, String isactive, String developmentstatus, String fieldlength, String adClientId, String readonlylogic, String adReferenceValueId, String iskey, String istranslated, String adProcessId, String isparent, String updatedby, String updatedbyr, String description, String adModuleId, String isencrypted, String isidentifier, String adCalloutId, String adReferenceId, String adValRuleId, String seqno, String issessionattr, String defaultvalue, String adElementId, String adColumnVId, String adOrgId)    throws ServletException {
    ColumnData objectColumnData[] = new ColumnData[1];
    objectColumnData[0] = new ColumnData();
    objectColumnData[0].created = "";
    objectColumnData[0].createdbyr = createdbyr;
    objectColumnData[0].updated = "";
    objectColumnData[0].updatedTimeStamp = "";
    objectColumnData[0].updatedby = updatedby;
    objectColumnData[0].updatedbyr = updatedbyr;
    objectColumnData[0].adClientId = adClientId;
    objectColumnData[0].adClientIdr = "";
    objectColumnData[0].adOrgId = adOrgId;
    objectColumnData[0].adOrgIdr = "";
    objectColumnData[0].adTableId = adTableId;
    objectColumnData[0].adTableIdr = "";
    objectColumnData[0].adModuleId = adModuleId;
    objectColumnData[0].adModuleIdr = "";
    objectColumnData[0].columnname = columnname;
    objectColumnData[0].adElementId = adElementId;
    objectColumnData[0].adElementIdr = "";
    objectColumnData[0].description = description;
    objectColumnData[0].help = help;
    objectColumnData[0].isactive = isactive;
    objectColumnData[0].fieldlength = fieldlength;
    objectColumnData[0].adReferenceId = adReferenceId;
    objectColumnData[0].adReferenceIdr = "";
    objectColumnData[0].adValRuleId = adValRuleId;
    objectColumnData[0].adValRuleIdr = "";
    objectColumnData[0].adProcessId = adProcessId;
    objectColumnData[0].adProcessIdr = "";
    objectColumnData[0].adReferenceValueId = adReferenceValueId;
    objectColumnData[0].adReferenceValueIdr = "";
    objectColumnData[0].defaultvalue = defaultvalue;
    objectColumnData[0].iskey = iskey;
    objectColumnData[0].isparent = isparent;
    objectColumnData[0].readonlylogic = readonlylogic;
    objectColumnData[0].isidentifier = isidentifier;
    objectColumnData[0].seqno = seqno;
    objectColumnData[0].adCalloutId = adCalloutId;
    objectColumnData[0].adCalloutIdr = "";
    objectColumnData[0].issessionattr = issessionattr;
    objectColumnData[0].isencrypted = isencrypted;
    objectColumnData[0].istranslated = istranslated;
    objectColumnData[0].developmentstatus = developmentstatus;
    objectColumnData[0].developmentstatusr = "";
    objectColumnData[0].adColumnVId = adColumnVId;
    objectColumnData[0].language = "";
    return objectColumnData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef54CC6B15716A4B44AC6D54895C12F0BE_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefEE6C0FB6408A4FE3B5E8C84C3253A5F0_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef53353617840E4B04BE043A222D8ED463(ConnectionProvider connectionProvider, String AD_Table_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT P.AD_MODULE_ID FROM AD_PACKAGE P, AD_TABLE T WHERE AD_TABLE_ID = ? AND P.AD_PACKAGE_ID = T.AD_PACKAGE_ID ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Table_ID);

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
      "        SELECT ad_column_v.AD_Table_ID AS NAME" +
      "        FROM ad_column_v" +
      "        WHERE ad_column_v.AD_Column_V_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adTableId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.TableName), ''))) AS NAME FROM AD_Table left join (select AD_Table_ID, TableName from AD_Table) table1 on (AD_Table.AD_Table_ID = table1.AD_Table_ID) WHERE AD_Table.AD_Table_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adTableId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.TableName), ''))) AS NAME FROM AD_Table left join (select AD_Table_ID, TableName from AD_Table) table1 on (AD_Table.AD_Table_ID = table1.AD_Table_ID) WHERE AD_Table.AD_Table_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);

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
      "        UPDATE ad_column_v" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , AD_Table_ID = (?) , AD_Module_ID = (?) , Columnname = (?) , AD_Element_ID = (?) , Description = (?) , Help = (?) , Isactive = (?) , Fieldlength = TO_NUMBER(?) , AD_Reference_ID = (?) , AD_Val_Rule_ID = (?) , AD_Process_ID = (?) , AD_Reference_Value_ID = (?) , Defaultvalue = (?) , Iskey = (?) , Isparent = (?) , Readonlylogic = (?) , Isidentifier = (?) , Seqno = TO_NUMBER(?) , AD_Callout_ID = (?) , Issessionattr = (?) , Isencrypted = (?) , Istranslated = (?) , Developmentstatus = (?) , AD_Column_V_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_column_v.AD_Column_V_ID = ? " +
      "                 AND ad_column_v.AD_Table_ID = ? " +
      "        AND ad_column_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_column_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, columnname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fieldlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceValueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iskey);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isparent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isidentifier);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adCalloutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issessionattr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isencrypted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, developmentstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
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
      "        INSERT INTO ad_column_v " +
      "        (AD_Client_ID, AD_Org_ID, AD_Table_ID, AD_Module_ID, Columnname, AD_Element_ID, Description, Help, Isactive, Fieldlength, AD_Reference_ID, AD_Val_Rule_ID, AD_Process_ID, AD_Reference_Value_ID, Defaultvalue, Iskey, Isparent, Readonlylogic, Isidentifier, Seqno, AD_Callout_ID, Issessionattr, Isencrypted, Istranslated, Developmentstatus, AD_Column_V_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, columnname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fieldlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceValueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iskey);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isparent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isidentifier);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adCalloutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issessionattr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isencrypted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, developmentstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnVId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adTableId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_column_v" +
      "        WHERE ad_column_v.AD_Column_V_ID = ? " +
      "                 AND ad_column_v.AD_Table_ID = ? " +
      "        AND ad_column_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_column_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adTableId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_column_v" +
      "        WHERE ad_column_v.AD_Column_V_ID = ? " +
      "                 AND ad_column_v.AD_Table_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);

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
      "          FROM ad_column_v" +
      "         WHERE ad_column_v.AD_Column_V_ID = ? ";

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
      "          FROM ad_column_v" +
      "         WHERE ad_column_v.AD_Column_V_ID = ? ";

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
