//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.MetadataTables;

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
class TablesData implements FieldProvider {
static Logger log4j = Logger.getLogger(TablesData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adMetadataTablename;
  public String adMetadataTableId;
  public String isactive;
  public String adClientId;
  public String adOrgId;
  public String sort4upgrade;
  public String sort4import;
  public String upgradeAd;
  public String moduleWhereclause;
  public String adModuleId;
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
    else if (fieldName.equalsIgnoreCase("ad_metadata_tablename") || fieldName.equals("adMetadataTablename"))
      return adMetadataTablename;
    else if (fieldName.equalsIgnoreCase("ad_metadata_table_id") || fieldName.equals("adMetadataTableId"))
      return adMetadataTableId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("sort4upgrade"))
      return sort4upgrade;
    else if (fieldName.equalsIgnoreCase("sort4import"))
      return sort4import;
    else if (fieldName.equalsIgnoreCase("upgrade_ad") || fieldName.equals("upgradeAd"))
      return upgradeAd;
    else if (fieldName.equalsIgnoreCase("module_whereclause") || fieldName.equals("moduleWhereclause"))
      return moduleWhereclause;
    else if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
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
  public static TablesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TablesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_metadata_table.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_metadata_table.CreatedBy) as CreatedByR, " +
      "        to_char(ad_metadata_table.Updated, ?) as updated, " +
      "        to_char(ad_metadata_table.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_metadata_table.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_metadata_table.UpdatedBy) as UpdatedByR," +
      "        ad_metadata_table.AD_Metadata_Tablename, " +
      "ad_metadata_table.AD_Metadata_Table_ID, " +
      "COALESCE(ad_metadata_table.Isactive, 'N') AS Isactive, " +
      "ad_metadata_table.AD_Client_ID, " +
      "ad_metadata_table.AD_Org_ID, " +
      "ad_metadata_table.Sort4upgrade, " +
      "ad_metadata_table.Sort4import, " +
      "ad_metadata_table.Upgrade_Ad, " +
      "ad_metadata_table.Module_Whereclause, " +
      "ad_metadata_table.AD_Module_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_metadata_table" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND ad_metadata_table.AD_Metadata_Table_ID = ? " +
      "        AND ad_metadata_table.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_metadata_table.AD_Org_ID IN (";
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
        TablesData objectTablesData = new TablesData();
        objectTablesData.created = UtilSql.getValue(result, "created");
        objectTablesData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTablesData.updated = UtilSql.getValue(result, "updated");
        objectTablesData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTablesData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTablesData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTablesData.adMetadataTablename = UtilSql.getValue(result, "ad_metadata_tablename");
        objectTablesData.adMetadataTableId = UtilSql.getValue(result, "ad_metadata_table_id");
        objectTablesData.isactive = UtilSql.getValue(result, "isactive");
        objectTablesData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTablesData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTablesData.sort4upgrade = UtilSql.getValue(result, "sort4upgrade");
        objectTablesData.sort4import = UtilSql.getValue(result, "sort4import");
        objectTablesData.upgradeAd = UtilSql.getValue(result, "upgrade_ad");
        objectTablesData.moduleWhereclause = UtilSql.getValue(result, "module_whereclause");
        objectTablesData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectTablesData.language = UtilSql.getValue(result, "language");
        objectTablesData.adUserClient = "";
        objectTablesData.adOrgClient = "";
        objectTablesData.createdby = "";
        objectTablesData.trBgcolor = "";
        objectTablesData.totalCount = "";
        objectTablesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTablesData);
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
    TablesData objectTablesData[] = new TablesData[vector.size()];
    vector.copyInto(objectTablesData);
    return(objectTablesData);
  }

/**
Create a registry
 */
  public static TablesData[] set(String adOrgId, String upgradeAd, String adMetadataTableId, String moduleWhereclause, String isactive, String sort4import, String createdby, String createdbyr, String updatedby, String updatedbyr, String sort4upgrade, String adMetadataTablename, String adClientId, String adModuleId)    throws ServletException {
    TablesData objectTablesData[] = new TablesData[1];
    objectTablesData[0] = new TablesData();
    objectTablesData[0].created = "";
    objectTablesData[0].createdbyr = createdbyr;
    objectTablesData[0].updated = "";
    objectTablesData[0].updatedTimeStamp = "";
    objectTablesData[0].updatedby = updatedby;
    objectTablesData[0].updatedbyr = updatedbyr;
    objectTablesData[0].adMetadataTablename = adMetadataTablename;
    objectTablesData[0].adMetadataTableId = adMetadataTableId;
    objectTablesData[0].isactive = isactive;
    objectTablesData[0].adClientId = adClientId;
    objectTablesData[0].adOrgId = adOrgId;
    objectTablesData[0].sort4upgrade = sort4upgrade;
    objectTablesData[0].sort4import = sort4import;
    objectTablesData[0].upgradeAd = upgradeAd;
    objectTablesData[0].moduleWhereclause = moduleWhereclause;
    objectTablesData[0].adModuleId = adModuleId;
    objectTablesData[0].language = "";
    return objectTablesData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef069E5D9D7247460AB09A3511ECBF3280_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef398BDC7DD3314018922F043E39861BF0_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE ad_metadata_table" +
      "        SET AD_Metadata_Tablename = (?) , AD_Metadata_Table_ID = (?) , Isactive = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Sort4upgrade = TO_NUMBER(?) , Sort4import = TO_NUMBER(?) , Upgrade_Ad = TO_NUMBER(?) , Module_Whereclause = (?) , AD_Module_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_metadata_table.AD_Metadata_Table_ID = ? " +
      "        AND ad_metadata_table.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_metadata_table.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMetadataTablename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMetadataTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sort4upgrade);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sort4import);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upgradeAd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, moduleWhereclause);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMetadataTableId);
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
      "        INSERT INTO ad_metadata_table " +
      "        (AD_Metadata_Tablename, AD_Metadata_Table_ID, Isactive, AD_Client_ID, AD_Org_ID, Sort4upgrade, Sort4import, Upgrade_Ad, Module_Whereclause, AD_Module_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMetadataTablename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMetadataTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sort4upgrade);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sort4import);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upgradeAd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, moduleWhereclause);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_metadata_table" +
      "        WHERE ad_metadata_table.AD_Metadata_Table_ID = ? " +
      "        AND ad_metadata_table.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_metadata_table.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_metadata_table" +
      "        WHERE ad_metadata_table.AD_Metadata_Table_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);

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
      "          FROM ad_metadata_table" +
      "         WHERE ad_metadata_table.AD_Metadata_Table_ID = ? ";

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
      "          FROM ad_metadata_table" +
      "         WHERE ad_metadata_table.AD_Metadata_Table_ID = ? ";

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
