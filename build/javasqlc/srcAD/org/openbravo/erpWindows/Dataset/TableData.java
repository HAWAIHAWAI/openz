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
class TableData implements FieldProvider {
static Logger log4j = Logger.getLogger(TableData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adDatasetTableId;
  public String adOrgId;
  public String adOrgIdr;
  public String adDatasetId;
  public String adDatasetIdr;
  public String adTableId;
  public String adTableIdr;
  public String isactive;
  public String adModuleId;
  public String adModuleIdr;
  public String whereclause;
  public String includeallcolumns;
  public String excludeauditinfo;
  public String isbusinessobject;
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
    else if (fieldName.equalsIgnoreCase("ad_dataset_table_id") || fieldName.equals("adDatasetTableId"))
      return adDatasetTableId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_dataset_id") || fieldName.equals("adDatasetId"))
      return adDatasetId;
    else if (fieldName.equalsIgnoreCase("ad_dataset_idr") || fieldName.equals("adDatasetIdr"))
      return adDatasetIdr;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("ad_table_idr") || fieldName.equals("adTableIdr"))
      return adTableIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
    else if (fieldName.equalsIgnoreCase("ad_module_idr") || fieldName.equals("adModuleIdr"))
      return adModuleIdr;
    else if (fieldName.equalsIgnoreCase("whereclause"))
      return whereclause;
    else if (fieldName.equalsIgnoreCase("includeallcolumns"))
      return includeallcolumns;
    else if (fieldName.equalsIgnoreCase("excludeauditinfo"))
      return excludeauditinfo;
    else if (fieldName.equalsIgnoreCase("isbusinessobject"))
      return isbusinessobject;
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
  public static TableData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adDatasetId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adDatasetId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TableData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adDatasetId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Dataset_Table.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Dataset_Table.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Dataset_Table.Updated, ?) as updated, " +
      "        to_char(AD_Dataset_Table.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Dataset_Table.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Dataset_Table.UpdatedBy) as UpdatedByR," +
      "        AD_Dataset_Table.AD_Client_ID, " +
      "(CASE WHEN AD_Dataset_Table.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Dataset_Table.AD_Dataset_Table_ID, " +
      "AD_Dataset_Table.AD_Org_ID, " +
      "(CASE WHEN AD_Dataset_Table.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_Dataset_Table.AD_Dataset_ID, " +
      "(CASE WHEN AD_Dataset_Table.AD_Dataset_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_Dataset_IDR, " +
      "AD_Dataset_Table.AD_Table_ID, " +
      "(CASE WHEN AD_Dataset_Table.AD_Table_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.TableName), ''))),'') ) END) AS AD_Table_IDR, " +
      "COALESCE(AD_Dataset_Table.IsActive, 'N') AS IsActive, " +
      "AD_Dataset_Table.AD_Module_ID, " +
      "(CASE WHEN AD_Dataset_Table.AD_Module_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Version), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS AD_Module_IDR, " +
      "AD_Dataset_Table.WhereClause, " +
      "COALESCE(AD_Dataset_Table.IncludeAllColumns, 'N') AS IncludeAllColumns, " +
      "COALESCE(AD_Dataset_Table.excludeAuditInfo, 'N') AS excludeAuditInfo, " +
      "COALESCE(AD_Dataset_Table.IsBusinessObject, 'N') AS IsBusinessObject, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Dataset_Table left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Dataset_Table.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_Dataset_Table.AD_Org_ID = table2.AD_Org_ID) left join (select AD_Dataset_ID, Name from AD_Dataset) table3 on (AD_Dataset_Table.AD_Dataset_ID = table3.AD_Dataset_ID) left join (select AD_Table_ID, TableName from AD_Table) table4 on (AD_Dataset_Table.AD_Table_ID = table4.AD_Table_ID) left join (select AD_Module_ID, Name, Version, AD_Language from AD_Module) table5 on (AD_Dataset_Table.AD_Module_ID = table5.AD_Module_ID) left join (select AD_Language, Name from AD_Language) table6 on (table5.AD_Language =  table6.AD_Language)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adDatasetId==null || adDatasetId.equals(""))?"":"  AND AD_Dataset_Table.AD_Dataset_ID = ?  ");
    strSql = strSql + 
      "        AND AD_Dataset_Table.AD_Dataset_Table_ID = ? " +
      "        AND AD_Dataset_Table.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Dataset_Table.AD_Org_ID IN (";
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
      if (adDatasetId != null && !(adDatasetId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetId);
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
        TableData objectTableData = new TableData();
        objectTableData.created = UtilSql.getValue(result, "created");
        objectTableData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTableData.updated = UtilSql.getValue(result, "updated");
        objectTableData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTableData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTableData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTableData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTableData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectTableData.adDatasetTableId = UtilSql.getValue(result, "ad_dataset_table_id");
        objectTableData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTableData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectTableData.adDatasetId = UtilSql.getValue(result, "ad_dataset_id");
        objectTableData.adDatasetIdr = UtilSql.getValue(result, "ad_dataset_idr");
        objectTableData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectTableData.adTableIdr = UtilSql.getValue(result, "ad_table_idr");
        objectTableData.isactive = UtilSql.getValue(result, "isactive");
        objectTableData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectTableData.adModuleIdr = UtilSql.getValue(result, "ad_module_idr");
        objectTableData.whereclause = UtilSql.getValue(result, "whereclause");
        objectTableData.includeallcolumns = UtilSql.getValue(result, "includeallcolumns");
        objectTableData.excludeauditinfo = UtilSql.getValue(result, "excludeauditinfo");
        objectTableData.isbusinessobject = UtilSql.getValue(result, "isbusinessobject");
        objectTableData.language = UtilSql.getValue(result, "language");
        objectTableData.adUserClient = "";
        objectTableData.adOrgClient = "";
        objectTableData.createdby = "";
        objectTableData.trBgcolor = "";
        objectTableData.totalCount = "";
        objectTableData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTableData);
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
    TableData objectTableData[] = new TableData[vector.size()];
    vector.copyInto(objectTableData);
    return(objectTableData);
  }

/**
Create a registry
 */
  public static TableData[] set(String adDatasetId, String createdby, String adOrgId, String updatedby, String adTableId, String adDatasetTableId, String isbusinessobject, String includeallcolumns, String adModuleId, String adClientId, String excludeauditinfo, String isactive, String whereclause)    throws ServletException {
    TableData objectTableData[] = new TableData[1];
    objectTableData[0] = new TableData();
    objectTableData[0].created = "";
    objectTableData[0].createdbyr = "";
    objectTableData[0].updated = "";
    objectTableData[0].updatedTimeStamp = "";
    objectTableData[0].updatedby = updatedby;
    objectTableData[0].updatedbyr = "";
    objectTableData[0].adClientId = adClientId;
    objectTableData[0].adClientIdr = "";
    objectTableData[0].adDatasetTableId = adDatasetTableId;
    objectTableData[0].adOrgId = adOrgId;
    objectTableData[0].adOrgIdr = "";
    objectTableData[0].adDatasetId = adDatasetId;
    objectTableData[0].adDatasetIdr = "";
    objectTableData[0].adTableId = adTableId;
    objectTableData[0].adTableIdr = "";
    objectTableData[0].isactive = isactive;
    objectTableData[0].adModuleId = adModuleId;
    objectTableData[0].adModuleIdr = "";
    objectTableData[0].whereclause = whereclause;
    objectTableData[0].includeallcolumns = includeallcolumns;
    objectTableData[0].excludeauditinfo = excludeauditinfo;
    objectTableData[0].isbusinessobject = isbusinessobject;
    objectTableData[0].language = "";
    return objectTableData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef03824184BF9311DD8055001B388C61A4(ConnectionProvider connectionProvider, String AD_Dataset_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT P.AD_MODULE_ID FROM AD_DATASET P WHERE AD_DATASET_ID = ? ";

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
      "        SELECT AD_Dataset_Table.AD_Dataset_ID AS NAME" +
      "        FROM AD_Dataset_Table" +
      "        WHERE AD_Dataset_Table.AD_Dataset_Table_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adDatasetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Dataset left join (select AD_Dataset_ID, Name from AD_Dataset) table1 on (AD_Dataset.AD_Dataset_ID = table1.AD_Dataset_ID) WHERE AD_Dataset.AD_Dataset_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adDatasetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Dataset left join (select AD_Dataset_ID, Name from AD_Dataset) table1 on (AD_Dataset.AD_Dataset_ID = table1.AD_Dataset_ID) WHERE AD_Dataset.AD_Dataset_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetId);

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
      "        UPDATE AD_Dataset_Table" +
      "        SET AD_Client_ID = (?) , AD_Dataset_Table_ID = (?) , AD_Org_ID = (?) , AD_Dataset_ID = (?) , AD_Table_ID = (?) , IsActive = (?) , AD_Module_ID = (?) , WhereClause = (?) , IncludeAllColumns = (?) , excludeAuditInfo = (?) , IsBusinessObject = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Dataset_Table.AD_Dataset_Table_ID = ? " +
      "                 AND AD_Dataset_Table.AD_Dataset_ID = ? " +
      "        AND AD_Dataset_Table.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Dataset_Table.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, whereclause);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includeallcolumns);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, excludeauditinfo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbusinessobject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetId);
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
      "        INSERT INTO AD_Dataset_Table " +
      "        (AD_Client_ID, AD_Dataset_Table_ID, AD_Org_ID, AD_Dataset_ID, AD_Table_ID, IsActive, AD_Module_ID, WhereClause, IncludeAllColumns, excludeAuditInfo, IsBusinessObject, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, whereclause);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includeallcolumns);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, excludeauditinfo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbusinessobject);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adDatasetId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Dataset_Table" +
      "        WHERE AD_Dataset_Table.AD_Dataset_Table_ID = ? " +
      "                 AND AD_Dataset_Table.AD_Dataset_ID = ? " +
      "        AND AD_Dataset_Table.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Dataset_Table.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adDatasetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Dataset_Table" +
      "        WHERE AD_Dataset_Table.AD_Dataset_Table_ID = ? " +
      "                 AND AD_Dataset_Table.AD_Dataset_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adDatasetId);

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
      "          FROM AD_Dataset_Table" +
      "         WHERE AD_Dataset_Table.AD_Dataset_Table_ID = ? ";

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
      "          FROM AD_Dataset_Table" +
      "         WHERE AD_Dataset_Table.AD_Dataset_Table_ID = ? ";

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
