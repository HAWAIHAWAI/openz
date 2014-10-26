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
class TableReferenceData implements FieldProvider {
static Logger log4j = Logger.getLogger(TableReferenceData.class);
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
  public String adReferenceId;
  public String adReferenceIdr;
  public String adTableId;
  public String adTableIdr;
  public String adKey;
  public String adKeyr;
  public String adDisplay;
  public String adDisplayr;
  public String isvaluedisplayed;
  public String isactive;
  public String whereclause;
  public String orderbyclause;
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
    else if (fieldName.equalsIgnoreCase("ad_reference_id") || fieldName.equals("adReferenceId"))
      return adReferenceId;
    else if (fieldName.equalsIgnoreCase("ad_reference_idr") || fieldName.equals("adReferenceIdr"))
      return adReferenceIdr;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("ad_table_idr") || fieldName.equals("adTableIdr"))
      return adTableIdr;
    else if (fieldName.equalsIgnoreCase("ad_key") || fieldName.equals("adKey"))
      return adKey;
    else if (fieldName.equalsIgnoreCase("ad_keyr") || fieldName.equals("adKeyr"))
      return adKeyr;
    else if (fieldName.equalsIgnoreCase("ad_display") || fieldName.equals("adDisplay"))
      return adDisplay;
    else if (fieldName.equalsIgnoreCase("ad_displayr") || fieldName.equals("adDisplayr"))
      return adDisplayr;
    else if (fieldName.equalsIgnoreCase("isvaluedisplayed"))
      return isvaluedisplayed;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("whereclause"))
      return whereclause;
    else if (fieldName.equalsIgnoreCase("orderbyclause"))
      return orderbyclause;
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
  public static TableReferenceData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adReferenceId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adReferenceId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TableReferenceData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adReferenceId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Ref_Table.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Ref_Table.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Ref_Table.Updated, ?) as updated, " +
      "        to_char(AD_Ref_Table.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Ref_Table.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Ref_Table.UpdatedBy) as UpdatedByR," +
      "        AD_Ref_Table.AD_Client_ID, " +
      "(CASE WHEN AD_Ref_Table.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Ref_Table.AD_Org_ID, " +
      "(CASE WHEN AD_Ref_Table.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_Ref_Table.AD_Reference_ID, " +
      "(CASE WHEN AD_Ref_Table.AD_Reference_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(list1.name),'') ) END) AS AD_Reference_IDR, " +
      "AD_Ref_Table.AD_Table_ID, " +
      "(CASE WHEN AD_Ref_Table.AD_Table_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.TableName), ''))),'') ) END) AS AD_Table_IDR, " +
      "AD_Ref_Table.AD_Key, " +
      "(CASE WHEN AD_Ref_Table.AD_Key IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.ColumnName), ''))),'') ) END) AS AD_KeyR, " +
      "AD_Ref_Table.AD_Display, " +
      "(CASE WHEN AD_Ref_Table.AD_Display IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.ColumnName), ''))),'') ) END) AS AD_DisplayR, " +
      "COALESCE(AD_Ref_Table.IsValueDisplayed, 'N') AS IsValueDisplayed, " +
      "COALESCE(AD_Ref_Table.IsActive, 'N') AS IsActive, " +
      "AD_Ref_Table.WhereClause, " +
      "AD_Ref_Table.OrderByClause, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Ref_Table left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Ref_Table.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_Ref_Table.AD_Org_ID = table2.AD_Org_ID) left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table3 on (AD_Ref_Table.AD_Reference_ID = table3.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL3 on (table3.AD_Reference_ID = tableTRL3.AD_Reference_ID and tableTRL3.AD_Language = ?)  left join ad_ref_list_v list1 on (table3.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  left join (select AD_Table_ID, TableName from AD_Table) table4 on (AD_Ref_Table.AD_Table_ID = table4.AD_Table_ID) left join (select AD_Column_ID, ColumnName from AD_Column) table5 on (AD_Ref_Table.AD_Key =  table5.AD_Column_ID) left join (select AD_Column_ID, ColumnName from AD_Column) table6 on (AD_Ref_Table.AD_Display =  table6.AD_Column_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adReferenceId==null || adReferenceId.equals(""))?"":"  AND AD_Ref_Table.AD_Reference_ID = ?  ");
    strSql = strSql + 
      "        AND AD_Ref_Table.AD_Reference_ID = ? " +
      "        AND AD_Ref_Table.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Ref_Table.AD_Org_ID IN (";
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
      if (adReferenceId != null && !(adReferenceId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
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
        TableReferenceData objectTableReferenceData = new TableReferenceData();
        objectTableReferenceData.created = UtilSql.getValue(result, "created");
        objectTableReferenceData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTableReferenceData.updated = UtilSql.getValue(result, "updated");
        objectTableReferenceData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTableReferenceData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTableReferenceData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTableReferenceData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTableReferenceData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectTableReferenceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTableReferenceData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectTableReferenceData.adReferenceId = UtilSql.getValue(result, "ad_reference_id");
        objectTableReferenceData.adReferenceIdr = UtilSql.getValue(result, "ad_reference_idr");
        objectTableReferenceData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectTableReferenceData.adTableIdr = UtilSql.getValue(result, "ad_table_idr");
        objectTableReferenceData.adKey = UtilSql.getValue(result, "ad_key");
        objectTableReferenceData.adKeyr = UtilSql.getValue(result, "ad_keyr");
        objectTableReferenceData.adDisplay = UtilSql.getValue(result, "ad_display");
        objectTableReferenceData.adDisplayr = UtilSql.getValue(result, "ad_displayr");
        objectTableReferenceData.isvaluedisplayed = UtilSql.getValue(result, "isvaluedisplayed");
        objectTableReferenceData.isactive = UtilSql.getValue(result, "isactive");
        objectTableReferenceData.whereclause = UtilSql.getValue(result, "whereclause");
        objectTableReferenceData.orderbyclause = UtilSql.getValue(result, "orderbyclause");
        objectTableReferenceData.language = UtilSql.getValue(result, "language");
        objectTableReferenceData.adUserClient = "";
        objectTableReferenceData.adOrgClient = "";
        objectTableReferenceData.createdby = "";
        objectTableReferenceData.trBgcolor = "";
        objectTableReferenceData.totalCount = "";
        objectTableReferenceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTableReferenceData);
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
    TableReferenceData objectTableReferenceData[] = new TableReferenceData[vector.size()];
    vector.copyInto(objectTableReferenceData);
    return(objectTableReferenceData);
  }

/**
Create a registry
 */
  public static TableReferenceData[] set(String adReferenceId, String adKey, String isvaluedisplayed, String orderbyclause, String adOrgId, String whereclause, String adDisplay, String adClientId, String adTableId, String isactive, String createdby, String createdbyr, String updatedby, String updatedbyr)    throws ServletException {
    TableReferenceData objectTableReferenceData[] = new TableReferenceData[1];
    objectTableReferenceData[0] = new TableReferenceData();
    objectTableReferenceData[0].created = "";
    objectTableReferenceData[0].createdbyr = createdbyr;
    objectTableReferenceData[0].updated = "";
    objectTableReferenceData[0].updatedTimeStamp = "";
    objectTableReferenceData[0].updatedby = updatedby;
    objectTableReferenceData[0].updatedbyr = updatedbyr;
    objectTableReferenceData[0].adClientId = adClientId;
    objectTableReferenceData[0].adClientIdr = "";
    objectTableReferenceData[0].adOrgId = adOrgId;
    objectTableReferenceData[0].adOrgIdr = "";
    objectTableReferenceData[0].adReferenceId = adReferenceId;
    objectTableReferenceData[0].adReferenceIdr = "";
    objectTableReferenceData[0].adTableId = adTableId;
    objectTableReferenceData[0].adTableIdr = "";
    objectTableReferenceData[0].adKey = adKey;
    objectTableReferenceData[0].adKeyr = "";
    objectTableReferenceData[0].adDisplay = adDisplay;
    objectTableReferenceData[0].adDisplayr = "";
    objectTableReferenceData[0].isvaluedisplayed = isvaluedisplayed;
    objectTableReferenceData[0].isactive = isactive;
    objectTableReferenceData[0].whereclause = whereclause;
    objectTableReferenceData[0].orderbyclause = orderbyclause;
    objectTableReferenceData[0].language = "";
    return objectTableReferenceData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef560_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDef562_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_Ref_Table.AD_Reference_ID AS NAME" +
      "        FROM AD_Ref_Table" +
      "        WHERE AD_Ref_Table.AD_Reference_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adReferenceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), '')) || ' - ' || list1.name) AS NAME FROM AD_Reference left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table1 on (AD_Reference.AD_Reference_ID = table1.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL1 on (table1.AD_Reference_ID = tableTRL1.AD_Reference_ID and tableTRL1.AD_Language = ?)  left join ad_ref_list_v list1 on (table1.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  WHERE AD_Reference.AD_Reference_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adReferenceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), '')) || ' - ' || list1.name) AS NAME FROM AD_Reference left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table1 on (AD_Reference.AD_Reference_ID = table1.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL1 on (table1.AD_Reference_ID = tableTRL1.AD_Reference_ID and tableTRL1.AD_Language = ?)  left join ad_ref_list_v list1 on (table1.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  WHERE AD_Reference.AD_Reference_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);

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
      "        UPDATE AD_Ref_Table" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , AD_Reference_ID = (?) , AD_Table_ID = (?) , AD_Key = (?) , AD_Display = (?) , IsValueDisplayed = (?) , IsActive = (?) , WhereClause = (?) , OrderByClause = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Ref_Table.AD_Reference_ID = ? " +
      "                 AND AD_Ref_Table.AD_Reference_ID = ? " +
      "        AND AD_Ref_Table.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Ref_Table.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adKey);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDisplay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvaluedisplayed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, whereclause);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderbyclause);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
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
      "        INSERT INTO AD_Ref_Table " +
      "        (AD_Client_ID, AD_Org_ID, AD_Reference_ID, AD_Table_ID, AD_Key, AD_Display, IsValueDisplayed, IsActive, WhereClause, OrderByClause, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adKey);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDisplay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvaluedisplayed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, whereclause);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderbyclause);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adReferenceId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Ref_Table" +
      "        WHERE AD_Ref_Table.AD_Reference_ID = ? " +
      "                 AND AD_Ref_Table.AD_Reference_ID = ? " +
      "        AND AD_Ref_Table.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Ref_Table.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adReferenceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Ref_Table" +
      "        WHERE AD_Ref_Table.AD_Reference_ID = ? " +
      "                 AND AD_Ref_Table.AD_Reference_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);

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
      "          FROM AD_Ref_Table" +
      "         WHERE AD_Ref_Table.AD_Reference_ID = ? ";

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
      "          FROM AD_Ref_Table" +
      "         WHERE AD_Ref_Table.AD_Reference_ID = ? ";

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
