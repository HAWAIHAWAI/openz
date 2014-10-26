//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Element;

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
class ColumnusedintablesData implements FieldProvider {
static Logger log4j = Logger.getLogger(ColumnusedintablesData.class);
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
  public String adCalloutId;
  public String columnname;
  public String adTableId;
  public String adTableIdr;
  public String description;
  public String isactive;
  public String defaultvalue;
  public String adReferenceId;
  public String adReferenceIdr;
  public String isidentifier;
  public String istranslated;
  public String readonlylogic;
  public String isparent;
  public String iskey;
  public String adReferenceValueId;
  public String adColumnId;
  public String adElementId;
  public String adProcessId;
  public String fieldlength;
  public String adValRuleId;
  public String help;
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
    else if (fieldName.equalsIgnoreCase("ad_callout_id") || fieldName.equals("adCalloutId"))
      return adCalloutId;
    else if (fieldName.equalsIgnoreCase("columnname"))
      return columnname;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("ad_table_idr") || fieldName.equals("adTableIdr"))
      return adTableIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("defaultvalue"))
      return defaultvalue;
    else if (fieldName.equalsIgnoreCase("ad_reference_id") || fieldName.equals("adReferenceId"))
      return adReferenceId;
    else if (fieldName.equalsIgnoreCase("ad_reference_idr") || fieldName.equals("adReferenceIdr"))
      return adReferenceIdr;
    else if (fieldName.equalsIgnoreCase("isidentifier"))
      return isidentifier;
    else if (fieldName.equalsIgnoreCase("istranslated"))
      return istranslated;
    else if (fieldName.equalsIgnoreCase("readonlylogic"))
      return readonlylogic;
    else if (fieldName.equalsIgnoreCase("isparent"))
      return isparent;
    else if (fieldName.equalsIgnoreCase("iskey"))
      return iskey;
    else if (fieldName.equalsIgnoreCase("ad_reference_value_id") || fieldName.equals("adReferenceValueId"))
      return adReferenceValueId;
    else if (fieldName.equalsIgnoreCase("ad_column_id") || fieldName.equals("adColumnId"))
      return adColumnId;
    else if (fieldName.equalsIgnoreCase("ad_element_id") || fieldName.equals("adElementId"))
      return adElementId;
    else if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
    else if (fieldName.equalsIgnoreCase("fieldlength"))
      return fieldlength;
    else if (fieldName.equalsIgnoreCase("ad_val_rule_id") || fieldName.equals("adValRuleId"))
      return adValRuleId;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
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
  public static ColumnusedintablesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adElementId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adElementId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ColumnusedintablesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adElementId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Column.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Column.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Column.Updated, ?) as updated, " +
      "        to_char(AD_Column.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Column.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Column.UpdatedBy) as UpdatedByR," +
      "        AD_Column.AD_Client_ID, " +
      "(CASE WHEN AD_Column.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Column.AD_Org_ID, " +
      "(CASE WHEN AD_Column.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_Column.AD_Callout_ID, " +
      "AD_Column.ColumnName, " +
      "AD_Column.AD_Table_ID, " +
      "(CASE WHEN AD_Column.AD_Table_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.TableName), ''))),'') ) END) AS AD_Table_IDR, " +
      "AD_Column.Description, " +
      "COALESCE(AD_Column.IsActive, 'N') AS IsActive, " +
      "AD_Column.DefaultValue, " +
      "AD_Column.AD_Reference_ID, " +
      "(CASE WHEN AD_Column.AD_Reference_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS AD_Reference_IDR, " +
      "COALESCE(AD_Column.IsIdentifier, 'N') AS IsIdentifier, " +
      "COALESCE(AD_Column.IsTranslated, 'N') AS IsTranslated, " +
      "AD_Column.ReadOnlyLogic, " +
      "COALESCE(AD_Column.IsParent, 'N') AS IsParent, " +
      "COALESCE(AD_Column.IsKey, 'N') AS IsKey, " +
      "AD_Column.AD_Reference_Value_ID, " +
      "AD_Column.AD_Column_ID, " +
      "AD_Column.AD_Element_ID, " +
      "AD_Column.AD_Process_ID, " +
      "AD_Column.FieldLength, " +
      "AD_Column.AD_Val_Rule_ID, " +
      "AD_Column.Help, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Column left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Column.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_Column.AD_Org_ID = table2.AD_Org_ID) left join (select AD_Table_ID, TableName from AD_Table) table3 on (AD_Column.AD_Table_ID = table3.AD_Table_ID) left join (select AD_Reference_ID, Name from AD_Reference) table4 on (AD_Column.AD_Reference_ID =  table4.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL4 on (table4.AD_Reference_ID = tableTRL4.AD_Reference_ID and tableTRL4.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adElementId==null || adElementId.equals(""))?"":"  AND AD_Column.AD_Element_ID = ?  ");
    strSql = strSql + 
      "        AND AD_Column.AD_Column_ID = ? " +
      "        AND AD_Column.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Column.AD_Org_ID IN (";
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
      if (adElementId != null && !(adElementId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
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
        ColumnusedintablesData objectColumnusedintablesData = new ColumnusedintablesData();
        objectColumnusedintablesData.created = UtilSql.getValue(result, "created");
        objectColumnusedintablesData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectColumnusedintablesData.updated = UtilSql.getValue(result, "updated");
        objectColumnusedintablesData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectColumnusedintablesData.updatedby = UtilSql.getValue(result, "updatedby");
        objectColumnusedintablesData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectColumnusedintablesData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectColumnusedintablesData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectColumnusedintablesData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectColumnusedintablesData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectColumnusedintablesData.adCalloutId = UtilSql.getValue(result, "ad_callout_id");
        objectColumnusedintablesData.columnname = UtilSql.getValue(result, "columnname");
        objectColumnusedintablesData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectColumnusedintablesData.adTableIdr = UtilSql.getValue(result, "ad_table_idr");
        objectColumnusedintablesData.description = UtilSql.getValue(result, "description");
        objectColumnusedintablesData.isactive = UtilSql.getValue(result, "isactive");
        objectColumnusedintablesData.defaultvalue = UtilSql.getValue(result, "defaultvalue");
        objectColumnusedintablesData.adReferenceId = UtilSql.getValue(result, "ad_reference_id");
        objectColumnusedintablesData.adReferenceIdr = UtilSql.getValue(result, "ad_reference_idr");
        objectColumnusedintablesData.isidentifier = UtilSql.getValue(result, "isidentifier");
        objectColumnusedintablesData.istranslated = UtilSql.getValue(result, "istranslated");
        objectColumnusedintablesData.readonlylogic = UtilSql.getValue(result, "readonlylogic");
        objectColumnusedintablesData.isparent = UtilSql.getValue(result, "isparent");
        objectColumnusedintablesData.iskey = UtilSql.getValue(result, "iskey");
        objectColumnusedintablesData.adReferenceValueId = UtilSql.getValue(result, "ad_reference_value_id");
        objectColumnusedintablesData.adColumnId = UtilSql.getValue(result, "ad_column_id");
        objectColumnusedintablesData.adElementId = UtilSql.getValue(result, "ad_element_id");
        objectColumnusedintablesData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectColumnusedintablesData.fieldlength = UtilSql.getValue(result, "fieldlength");
        objectColumnusedintablesData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectColumnusedintablesData.help = UtilSql.getValue(result, "help");
        objectColumnusedintablesData.language = UtilSql.getValue(result, "language");
        objectColumnusedintablesData.adUserClient = "";
        objectColumnusedintablesData.adOrgClient = "";
        objectColumnusedintablesData.createdby = "";
        objectColumnusedintablesData.trBgcolor = "";
        objectColumnusedintablesData.totalCount = "";
        objectColumnusedintablesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectColumnusedintablesData);
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
    ColumnusedintablesData objectColumnusedintablesData[] = new ColumnusedintablesData[vector.size()];
    vector.copyInto(objectColumnusedintablesData);
    return(objectColumnusedintablesData);
  }

/**
Create a registry
 */
  public static ColumnusedintablesData[] set(String adElementId, String readonlylogic, String adValRuleId, String fieldlength, String istranslated, String adProcessId, String iskey, String adCalloutId, String help, String defaultvalue, String description, String adOrgId, String columnname, String updatedby, String updatedbyr, String adClientId, String isparent, String adReferenceId, String adColumnId, String isactive, String adTableId, String adReferenceValueId, String isidentifier, String createdby, String createdbyr)    throws ServletException {
    ColumnusedintablesData objectColumnusedintablesData[] = new ColumnusedintablesData[1];
    objectColumnusedintablesData[0] = new ColumnusedintablesData();
    objectColumnusedintablesData[0].created = "";
    objectColumnusedintablesData[0].createdbyr = createdbyr;
    objectColumnusedintablesData[0].updated = "";
    objectColumnusedintablesData[0].updatedTimeStamp = "";
    objectColumnusedintablesData[0].updatedby = updatedby;
    objectColumnusedintablesData[0].updatedbyr = updatedbyr;
    objectColumnusedintablesData[0].adClientId = adClientId;
    objectColumnusedintablesData[0].adClientIdr = "";
    objectColumnusedintablesData[0].adOrgId = adOrgId;
    objectColumnusedintablesData[0].adOrgIdr = "";
    objectColumnusedintablesData[0].adCalloutId = adCalloutId;
    objectColumnusedintablesData[0].columnname = columnname;
    objectColumnusedintablesData[0].adTableId = adTableId;
    objectColumnusedintablesData[0].adTableIdr = "";
    objectColumnusedintablesData[0].description = description;
    objectColumnusedintablesData[0].isactive = isactive;
    objectColumnusedintablesData[0].defaultvalue = defaultvalue;
    objectColumnusedintablesData[0].adReferenceId = adReferenceId;
    objectColumnusedintablesData[0].adReferenceIdr = "";
    objectColumnusedintablesData[0].isidentifier = isidentifier;
    objectColumnusedintablesData[0].istranslated = istranslated;
    objectColumnusedintablesData[0].readonlylogic = readonlylogic;
    objectColumnusedintablesData[0].isparent = isparent;
    objectColumnusedintablesData[0].iskey = iskey;
    objectColumnusedintablesData[0].adReferenceValueId = adReferenceValueId;
    objectColumnusedintablesData[0].adColumnId = adColumnId;
    objectColumnusedintablesData[0].adElementId = adElementId;
    objectColumnusedintablesData[0].adProcessId = adProcessId;
    objectColumnusedintablesData[0].fieldlength = fieldlength;
    objectColumnusedintablesData[0].adValRuleId = adValRuleId;
    objectColumnusedintablesData[0].help = help;
    objectColumnusedintablesData[0].language = "";
    return objectColumnusedintablesData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef552_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef550_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
      "        SELECT AD_Column.AD_Element_ID AS NAME" +
      "        FROM AD_Column" +
      "        WHERE AD_Column.AD_Column_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adElementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.ColumnName), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Element left join (select AD_Element_ID, ColumnName, Name from AD_Element) table1 on (AD_Element.AD_Element_ID = table1.AD_Element_ID) WHERE AD_Element.AD_Element_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adElementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.ColumnName), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Element left join (select AD_Element_ID, ColumnName, Name from AD_Element) table1 on (AD_Element.AD_Element_ID = table1.AD_Element_ID) WHERE AD_Element.AD_Element_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);

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
      "        UPDATE AD_Column" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , AD_Callout_ID = (?) , ColumnName = (?) , AD_Table_ID = (?) , Description = (?) , IsActive = (?) , DefaultValue = (?) , AD_Reference_ID = (?) , IsIdentifier = (?) , IsTranslated = (?) , ReadOnlyLogic = (?) , IsParent = (?) , IsKey = (?) , AD_Reference_Value_ID = (?) , AD_Column_ID = (?) , AD_Element_ID = (?) , AD_Process_ID = (?) , FieldLength = TO_NUMBER(?) , AD_Val_Rule_ID = (?) , Help = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Column.AD_Column_ID = ? " +
      "                 AND AD_Column.AD_Element_ID = ? " +
      "        AND AD_Column.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Column.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adCalloutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, columnname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isidentifier);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isparent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iskey);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceValueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fieldlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
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
      "        INSERT INTO AD_Column " +
      "        (AD_Client_ID, AD_Org_ID, AD_Callout_ID, ColumnName, AD_Table_ID, Description, IsActive, DefaultValue, AD_Reference_ID, IsIdentifier, IsTranslated, ReadOnlyLogic, IsParent, IsKey, AD_Reference_Value_ID, AD_Column_ID, AD_Element_ID, AD_Process_ID, FieldLength, AD_Val_Rule_ID, Help, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adCalloutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, columnname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isidentifier);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isparent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iskey);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceValueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fieldlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adElementId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Column" +
      "        WHERE AD_Column.AD_Column_ID = ? " +
      "                 AND AD_Column.AD_Element_ID = ? " +
      "        AND AD_Column.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Column.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adElementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Column" +
      "        WHERE AD_Column.AD_Column_ID = ? " +
      "                 AND AD_Column.AD_Element_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);

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
      "          FROM AD_Column" +
      "         WHERE AD_Column.AD_Column_ID = ? ";

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
      "          FROM AD_Column" +
      "         WHERE AD_Column.AD_Column_ID = ? ";

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
