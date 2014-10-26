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
class SelectorReferenceCalloutColumnsData implements FieldProvider {
static Logger log4j = Logger.getLogger(SelectorReferenceCalloutColumnsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adRefSearchColumnId;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String adRefSearchId;
  public String adRefSearchIdr;
  public String name;
  public String columnname;
  public String columntype;
  public String columntyper;
  public String columnSuffix;
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
    else if (fieldName.equalsIgnoreCase("ad_ref_search_column_id") || fieldName.equals("adRefSearchColumnId"))
      return adRefSearchColumnId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_ref_search_id") || fieldName.equals("adRefSearchId"))
      return adRefSearchId;
    else if (fieldName.equalsIgnoreCase("ad_ref_search_idr") || fieldName.equals("adRefSearchIdr"))
      return adRefSearchIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("columnname"))
      return columnname;
    else if (fieldName.equalsIgnoreCase("columntype"))
      return columntype;
    else if (fieldName.equalsIgnoreCase("columntyper"))
      return columntyper;
    else if (fieldName.equalsIgnoreCase("column_suffix") || fieldName.equals("columnSuffix"))
      return columnSuffix;
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
  public static SelectorReferenceCalloutColumnsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRefSearchId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adRefSearchId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static SelectorReferenceCalloutColumnsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRefSearchId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Ref_Search_Column.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Ref_Search_Column.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Ref_Search_Column.Updated, ?) as updated, " +
      "        to_char(AD_Ref_Search_Column.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Ref_Search_Column.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Ref_Search_Column.UpdatedBy) as UpdatedByR," +
      "        AD_Ref_Search_Column.AD_Client_ID, " +
      "(CASE WHEN AD_Ref_Search_Column.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Ref_Search_Column.AD_Ref_Search_Column_ID, " +
      "AD_Ref_Search_Column.AD_Org_ID, " +
      "(CASE WHEN AD_Ref_Search_Column.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(AD_Ref_Search_Column.IsActive, 'N') AS IsActive, " +
      "AD_Ref_Search_Column.AD_Ref_Search_ID, " +
      "(CASE WHEN AD_Ref_Search_Column.AD_Ref_Search_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(list1.name),'') ) END) AS AD_Ref_Search_IDR, " +
      "AD_Ref_Search_Column.Name, " +
      "AD_Ref_Search_Column.ColumnName, " +
      "AD_Ref_Search_Column.Columntype, " +
      "(CASE WHEN AD_Ref_Search_Column.Columntype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS ColumntypeR, " +
      "AD_Ref_Search_Column.Column_Suffix, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Ref_Search_Column left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Ref_Search_Column.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_Ref_Search_Column.AD_Org_ID = table2.AD_Org_ID) left join (select AD_Ref_Search_ID, AD_Reference_ID from AD_Ref_Search) table3 on (AD_Ref_Search_Column.AD_Ref_Search_ID = table3.AD_Ref_Search_ID) left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table4 on (table3.AD_Reference_ID = table4.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL4 on (table4.AD_Reference_ID = tableTRL4.AD_Reference_ID and tableTRL4.AD_Language = ?)  left join ad_ref_list_v list1 on (table4.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (AD_Ref_Search_Column.Columntype = list2.value and list2.ad_reference_id = '800066' and list2.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adRefSearchId==null || adRefSearchId.equals(""))?"":"  AND AD_Ref_Search_Column.AD_Ref_Search_ID = ?  ");
    strSql = strSql + 
      "        AND AD_Ref_Search_Column.AD_Ref_Search_Column_ID = ? " +
      "        AND AD_Ref_Search_Column.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Ref_Search_Column.AD_Org_ID IN (";
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
      if (adRefSearchId != null && !(adRefSearchId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefSearchId);
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
        SelectorReferenceCalloutColumnsData objectSelectorReferenceCalloutColumnsData = new SelectorReferenceCalloutColumnsData();
        objectSelectorReferenceCalloutColumnsData.created = UtilSql.getValue(result, "created");
        objectSelectorReferenceCalloutColumnsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSelectorReferenceCalloutColumnsData.updated = UtilSql.getValue(result, "updated");
        objectSelectorReferenceCalloutColumnsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSelectorReferenceCalloutColumnsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectSelectorReferenceCalloutColumnsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSelectorReferenceCalloutColumnsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSelectorReferenceCalloutColumnsData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectSelectorReferenceCalloutColumnsData.adRefSearchColumnId = UtilSql.getValue(result, "ad_ref_search_column_id");
        objectSelectorReferenceCalloutColumnsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSelectorReferenceCalloutColumnsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectSelectorReferenceCalloutColumnsData.isactive = UtilSql.getValue(result, "isactive");
        objectSelectorReferenceCalloutColumnsData.adRefSearchId = UtilSql.getValue(result, "ad_ref_search_id");
        objectSelectorReferenceCalloutColumnsData.adRefSearchIdr = UtilSql.getValue(result, "ad_ref_search_idr");
        objectSelectorReferenceCalloutColumnsData.name = UtilSql.getValue(result, "name");
        objectSelectorReferenceCalloutColumnsData.columnname = UtilSql.getValue(result, "columnname");
        objectSelectorReferenceCalloutColumnsData.columntype = UtilSql.getValue(result, "columntype");
        objectSelectorReferenceCalloutColumnsData.columntyper = UtilSql.getValue(result, "columntyper");
        objectSelectorReferenceCalloutColumnsData.columnSuffix = UtilSql.getValue(result, "column_suffix");
        objectSelectorReferenceCalloutColumnsData.language = UtilSql.getValue(result, "language");
        objectSelectorReferenceCalloutColumnsData.adUserClient = "";
        objectSelectorReferenceCalloutColumnsData.adOrgClient = "";
        objectSelectorReferenceCalloutColumnsData.createdby = "";
        objectSelectorReferenceCalloutColumnsData.trBgcolor = "";
        objectSelectorReferenceCalloutColumnsData.totalCount = "";
        objectSelectorReferenceCalloutColumnsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSelectorReferenceCalloutColumnsData);
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
    SelectorReferenceCalloutColumnsData objectSelectorReferenceCalloutColumnsData[] = new SelectorReferenceCalloutColumnsData[vector.size()];
    vector.copyInto(objectSelectorReferenceCalloutColumnsData);
    return(objectSelectorReferenceCalloutColumnsData);
  }

/**
Create a registry
 */
  public static SelectorReferenceCalloutColumnsData[] set(String adRefSearchId, String adClientId, String isactive, String updatedby, String updatedbyr, String adRefSearchColumnId, String name, String columnSuffix, String columnname, String createdby, String createdbyr, String adOrgId, String columntype)    throws ServletException {
    SelectorReferenceCalloutColumnsData objectSelectorReferenceCalloutColumnsData[] = new SelectorReferenceCalloutColumnsData[1];
    objectSelectorReferenceCalloutColumnsData[0] = new SelectorReferenceCalloutColumnsData();
    objectSelectorReferenceCalloutColumnsData[0].created = "";
    objectSelectorReferenceCalloutColumnsData[0].createdbyr = createdbyr;
    objectSelectorReferenceCalloutColumnsData[0].updated = "";
    objectSelectorReferenceCalloutColumnsData[0].updatedTimeStamp = "";
    objectSelectorReferenceCalloutColumnsData[0].updatedby = updatedby;
    objectSelectorReferenceCalloutColumnsData[0].updatedbyr = updatedbyr;
    objectSelectorReferenceCalloutColumnsData[0].adClientId = adClientId;
    objectSelectorReferenceCalloutColumnsData[0].adClientIdr = "";
    objectSelectorReferenceCalloutColumnsData[0].adRefSearchColumnId = adRefSearchColumnId;
    objectSelectorReferenceCalloutColumnsData[0].adOrgId = adOrgId;
    objectSelectorReferenceCalloutColumnsData[0].adOrgIdr = "";
    objectSelectorReferenceCalloutColumnsData[0].isactive = isactive;
    objectSelectorReferenceCalloutColumnsData[0].adRefSearchId = adRefSearchId;
    objectSelectorReferenceCalloutColumnsData[0].adRefSearchIdr = "";
    objectSelectorReferenceCalloutColumnsData[0].name = name;
    objectSelectorReferenceCalloutColumnsData[0].columnname = columnname;
    objectSelectorReferenceCalloutColumnsData[0].columntype = columntype;
    objectSelectorReferenceCalloutColumnsData[0].columntyper = "";
    objectSelectorReferenceCalloutColumnsData[0].columnSuffix = columnSuffix;
    objectSelectorReferenceCalloutColumnsData[0].language = "";
    return objectSelectorReferenceCalloutColumnsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef802713_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef802711_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT AD_Ref_Search_Column.AD_Ref_Search_ID AS NAME" +
      "        FROM AD_Ref_Search_Column" +
      "        WHERE AD_Ref_Search_Column.AD_Ref_Search_Column_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adRefSearchId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), '')) || ' - ' || list1.name) AS NAME FROM AD_Ref_Search left join (select AD_Ref_Search_ID, AD_Reference_ID from AD_Ref_Search) table1 on (AD_Ref_Search.AD_Ref_Search_ID = table1.AD_Ref_Search_ID) left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table2 on (table1.AD_Reference_ID = table2.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL2 on (table2.AD_Reference_ID = tableTRL2.AD_Reference_ID and tableTRL2.AD_Language = ?)  left join ad_ref_list_v list1 on (table2.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  WHERE AD_Ref_Search.AD_Ref_Search_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefSearchId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adRefSearchId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), '')) || ' - ' || list1.name) AS NAME FROM AD_Ref_Search left join (select AD_Ref_Search_ID, AD_Reference_ID from AD_Ref_Search) table1 on (AD_Ref_Search.AD_Ref_Search_ID = table1.AD_Ref_Search_ID) left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table2 on (table1.AD_Reference_ID = table2.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL2 on (table2.AD_Reference_ID = tableTRL2.AD_Reference_ID and tableTRL2.AD_Language = ?)  left join ad_ref_list_v list1 on (table2.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  WHERE AD_Ref_Search.AD_Ref_Search_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefSearchId);

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
      "        UPDATE AD_Ref_Search_Column" +
      "        SET AD_Client_ID = (?) , AD_Ref_Search_Column_ID = (?) , AD_Org_ID = (?) , IsActive = (?) , AD_Ref_Search_ID = (?) , Name = (?) , ColumnName = (?) , Columntype = (?) , Column_Suffix = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Ref_Search_Column.AD_Ref_Search_Column_ID = ? " +
      "                 AND AD_Ref_Search_Column.AD_Ref_Search_ID = ? " +
      "        AND AD_Ref_Search_Column.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Ref_Search_Column.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefSearchColumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefSearchId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, columnname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, columntype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, columnSuffix);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefSearchColumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefSearchId);
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
      "        INSERT INTO AD_Ref_Search_Column " +
      "        (AD_Client_ID, AD_Ref_Search_Column_ID, AD_Org_ID, IsActive, AD_Ref_Search_ID, Name, ColumnName, Columntype, Column_Suffix, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefSearchColumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefSearchId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, columnname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, columntype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, columnSuffix);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adRefSearchId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Ref_Search_Column" +
      "        WHERE AD_Ref_Search_Column.AD_Ref_Search_Column_ID = ? " +
      "                 AND AD_Ref_Search_Column.AD_Ref_Search_ID = ? " +
      "        AND AD_Ref_Search_Column.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Ref_Search_Column.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefSearchId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adRefSearchId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Ref_Search_Column" +
      "        WHERE AD_Ref_Search_Column.AD_Ref_Search_Column_ID = ? " +
      "                 AND AD_Ref_Search_Column.AD_Ref_Search_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefSearchId);

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
      "          FROM AD_Ref_Search_Column" +
      "         WHERE AD_Ref_Search_Column.AD_Ref_Search_Column_ID = ? ";

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
      "          FROM AD_Ref_Search_Column" +
      "         WHERE AD_Ref_Search_Column.AD_Ref_Search_Column_ID = ? ";

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
