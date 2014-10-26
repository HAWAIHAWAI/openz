//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Dataset;

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
  public String adDatasetColumnId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String adDatasetTableId;
  public String adDatasetTableIdr;
  public String adColumnId;
  public String adColumnIdr;
  public String isactive;
  public String adModuleId;
  public String adModuleIdr;
  public String isexcluded;
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
    else if (fieldName.equalsIgnoreCase("ad_dataset_column_id") || fieldName.equals("adDatasetColumnId"))
      return adDatasetColumnId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_dataset_table_id") || fieldName.equals("adDatasetTableId"))
      return adDatasetTableId;
    else if (fieldName.equalsIgnoreCase("ad_dataset_table_idr") || fieldName.equals("adDatasetTableIdr"))
      return adDatasetTableIdr;
    else if (fieldName.equalsIgnoreCase("ad_column_id") || fieldName.equals("adColumnId"))
      return adColumnId;
    else if (fieldName.equalsIgnoreCase("ad_column_idr") || fieldName.equals("adColumnIdr"))
      return adColumnIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
    else if (fieldName.equalsIgnoreCase("ad_module_idr") || fieldName.equals("adModuleIdr"))
      return adModuleIdr;
    else if (fieldName.equalsIgnoreCase("isexcluded"))
      return isexcluded;
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
  public static ColumnData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adDatasetTableId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adDatasetTableId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ColumnData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adDatasetTableId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Dataset_Column.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Dataset_Column.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Dataset_Column.Updated, ?) as updated, " +
      "        to_char(AD_Dataset_Column.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Dataset_Column.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Dataset_Column.UpdatedBy) as UpdatedByR," +
      "        AD_Dataset_Column.AD_Dataset_Column_ID, " +
      "AD_Dataset_Column.AD_Client_ID, " +
      "(CASE WHEN AD_Dataset_Column.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Dataset_Column.AD_Org_ID, " +
      "(CASE WHEN AD_Dataset_Column.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_Dataset_Column.AD_Dataset_Table_ID, " +
      "(CASE WHEN AD_Dataset_Column.AD_Dataset_Table_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.TableName), ''))),'') ) END) AS AD_Dataset_Table_IDR, " +
      "AD_Dataset_Column.AD_Column_ID, " +
      "(CASE WHEN AD_Dataset_Column.AD_Column_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.ColumnName), ''))),'') ) END) AS AD_Column_IDR, " +
      "COALESCE(AD_Dataset_Column.IsActive, 'N') AS IsActive, " +
      "AD_Dataset_Column.AD_Module_ID, " +
      "(CASE WHEN AD_Dataset_Column.AD_Module_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Version), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS AD_Module_IDR, " +
      "COALESCE(AD_Dataset_Column.IsExcluded, 'N') AS IsExcluded, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Dataset_Column left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Dataset_Column.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_Dataset_Column.AD_Org_ID = table2.AD_Org_ID) left join (select AD_Dataset_Table_ID, AD_Table_ID from AD_Dataset_Table) table3 on (AD_Dataset_Column.AD_Dataset_Table_ID = table3.AD_Dataset_Table_ID) left join (select AD_Table_ID, TableName from AD_Table) table4 on (table3.AD_Table_ID = table4.AD_Table_ID) left join (select AD_Column_ID, ColumnName from AD_Column) table5 on (AD_Dataset_Column.AD_Column_ID = table5.AD_Column_ID) left join (select AD_Module_ID, Name, Version, AD_Language from AD_Module) table6 on (AD_Dataset_Column.AD_Module_ID = table6.AD_Module_ID) left join (select AD_Language, Name from AD_Language) table7 on (table6.AD_Language =  table7.AD_Language)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adDatasetTableId==null || adDatasetTableId.equals(""))?"":"  AND AD_Dataset_Column.AD_Dataset_Table_ID = ?  ");
    strSql = strSql + 
      "        AND AD_Dataset_Column.AD_Dataset_Column_ID = ? " +
      "        AND AD_Dataset_Column.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Dataset_Column.AD_Org_ID IN (";
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
      if (adDatasetTableId != null && !(adDatasetTableId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetTableId);
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
        objectColumnData.adDatasetColumnId = UtilSql.getValue(result, "ad_dataset_column_id");
        objectColumnData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectColumnData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectColumnData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectColumnData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectColumnData.adDatasetTableId = UtilSql.getValue(result, "ad_dataset_table_id");
        objectColumnData.adDatasetTableIdr = UtilSql.getValue(result, "ad_dataset_table_idr");
        objectColumnData.adColumnId = UtilSql.getValue(result, "ad_column_id");
        objectColumnData.adColumnIdr = UtilSql.getValue(result, "ad_column_idr");
        objectColumnData.isactive = UtilSql.getValue(result, "isactive");
        objectColumnData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectColumnData.adModuleIdr = UtilSql.getValue(result, "ad_module_idr");
        objectColumnData.isexcluded = UtilSql.getValue(result, "isexcluded");
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
  public static ColumnData[] set(String adDatasetTableId, String adClientId, String adDatasetColumnId, String adModuleId, String createdby, String adOrgId, String adColumnId, String updatedby, String isactive, String isexcluded)    throws ServletException {
    ColumnData objectColumnData[] = new ColumnData[1];
    objectColumnData[0] = new ColumnData();
    objectColumnData[0].created = "";
    objectColumnData[0].createdbyr = "";
    objectColumnData[0].updated = "";
    objectColumnData[0].updatedTimeStamp = "";
    objectColumnData[0].updatedby = updatedby;
    objectColumnData[0].updatedbyr = "";
    objectColumnData[0].adDatasetColumnId = adDatasetColumnId;
    objectColumnData[0].adClientId = adClientId;
    objectColumnData[0].adClientIdr = "";
    objectColumnData[0].adOrgId = adOrgId;
    objectColumnData[0].adOrgIdr = "";
    objectColumnData[0].adDatasetTableId = adDatasetTableId;
    objectColumnData[0].adDatasetTableIdr = "";
    objectColumnData[0].adColumnId = adColumnId;
    objectColumnData[0].adColumnIdr = "";
    objectColumnData[0].isactive = isactive;
    objectColumnData[0].adModuleId = adModuleId;
    objectColumnData[0].adModuleIdr = "";
    objectColumnData[0].isexcluded = isexcluded;
    objectColumnData[0].language = "";
    return objectColumnData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1057799CBF9311DDB9CF001B388C61A4(ConnectionProvider connectionProvider, String AD_Dataset_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT P.AD_MODULE_ID FROM AD_DATASET_TABLE P WHERE AD_DATASET_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Dataset_ID);

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
      "        SELECT AD_Dataset_Column.AD_Dataset_Table_ID AS NAME" +
      "        FROM AD_Dataset_Column" +
      "        WHERE AD_Dataset_Column.AD_Dataset_Column_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adDatasetTableId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.TableName), ''))) AS NAME FROM AD_Dataset_Table left join (select AD_Dataset_Table_ID, AD_Table_ID from AD_Dataset_Table) table1 on (AD_Dataset_Table.AD_Dataset_Table_ID = table1.AD_Dataset_Table_ID) left join (select AD_Table_ID, TableName from AD_Table) table2 on (table1.AD_Table_ID = table2.AD_Table_ID) WHERE AD_Dataset_Table.AD_Dataset_Table_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetTableId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adDatasetTableId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.TableName), ''))) AS NAME FROM AD_Dataset_Table left join (select AD_Dataset_Table_ID, AD_Table_ID from AD_Dataset_Table) table1 on (AD_Dataset_Table.AD_Dataset_Table_ID = table1.AD_Dataset_Table_ID) left join (select AD_Table_ID, TableName from AD_Table) table2 on (table1.AD_Table_ID = table2.AD_Table_ID) WHERE AD_Dataset_Table.AD_Dataset_Table_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetTableId);

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
      "        UPDATE AD_Dataset_Column" +
      "        SET AD_Dataset_Column_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , AD_Dataset_Table_ID = (?) , AD_Column_ID = (?) , IsActive = (?) , AD_Module_ID = (?) , IsExcluded = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Dataset_Column.AD_Dataset_Column_ID = ? " +
      "                 AND AD_Dataset_Column.AD_Dataset_Table_ID = ? " +
      "        AND AD_Dataset_Column.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Dataset_Column.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetColumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isexcluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetColumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetTableId);
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
      "        INSERT INTO AD_Dataset_Column " +
      "        (AD_Dataset_Column_ID, AD_Client_ID, AD_Org_ID, AD_Dataset_Table_ID, AD_Column_ID, IsActive, AD_Module_ID, IsExcluded, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetColumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isexcluded);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adDatasetTableId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Dataset_Column" +
      "        WHERE AD_Dataset_Column.AD_Dataset_Column_ID = ? " +
      "                 AND AD_Dataset_Column.AD_Dataset_Table_ID = ? " +
      "        AND AD_Dataset_Column.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Dataset_Column.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetTableId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adDatasetTableId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Dataset_Column" +
      "        WHERE AD_Dataset_Column.AD_Dataset_Column_ID = ? " +
      "                 AND AD_Dataset_Column.AD_Dataset_Table_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetTableId);

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
      "          FROM AD_Dataset_Column" +
      "         WHERE AD_Dataset_Column.AD_Dataset_Column_ID = ? ";

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
      "          FROM AD_Dataset_Column" +
      "         WHERE AD_Dataset_Column.AD_Dataset_Column_ID = ? ";

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
