//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openz.dms.DocumentFiling;

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
class Files1AE43FA2AC3049DE94230EB71D5CBD65Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Files1AE43FA2AC3049DE94230EB71D5CBD65Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String dmsDocumentfilingId;
  public String adOrgId;
  public String adOrgIdr;
  public String name;
  public String description;
  public String adClientId;
  public String isactive;
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
    else if (fieldName.equalsIgnoreCase("dms_documentfiling_id") || fieldName.equals("dmsDocumentfilingId"))
      return dmsDocumentfilingId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
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
  public static Files1AE43FA2AC3049DE94230EB71D5CBD65Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Files1AE43FA2AC3049DE94230EB71D5CBD65Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(dms_documentfiling.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = dms_documentfiling.CreatedBy) as CreatedByR, " +
      "        to_char(dms_documentfiling.Updated, ?) as updated, " +
      "        to_char(dms_documentfiling.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        dms_documentfiling.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = dms_documentfiling.UpdatedBy) as UpdatedByR," +
      "        dms_documentfiling.DMS_Documentfiling_ID, " +
      "dms_documentfiling.AD_Org_ID, " +
      "(CASE WHEN dms_documentfiling.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "dms_documentfiling.Name, " +
      "dms_documentfiling.Description, " +
      "dms_documentfiling.AD_Client_ID, " +
      "COALESCE(dms_documentfiling.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM dms_documentfiling left join (select AD_Org_ID, Name from AD_Org) table1 on (dms_documentfiling.AD_Org_ID = table1.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND dms_documentfiling.DMS_Documentfiling_ID = ? " +
      "        AND dms_documentfiling.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND dms_documentfiling.AD_Org_ID IN (";
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
        Files1AE43FA2AC3049DE94230EB71D5CBD65Data objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data = new Files1AE43FA2AC3049DE94230EB71D5CBD65Data();
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.created = UtilSql.getValue(result, "created");
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.updated = UtilSql.getValue(result, "updated");
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.dmsDocumentfilingId = UtilSql.getValue(result, "dms_documentfiling_id");
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.name = UtilSql.getValue(result, "name");
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.description = UtilSql.getValue(result, "description");
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.isactive = UtilSql.getValue(result, "isactive");
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.language = UtilSql.getValue(result, "language");
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.adUserClient = "";
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.adOrgClient = "";
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.createdby = "";
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.trBgcolor = "";
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.totalCount = "";
        objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data);
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
    Files1AE43FA2AC3049DE94230EB71D5CBD65Data objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data[] = new Files1AE43FA2AC3049DE94230EB71D5CBD65Data[vector.size()];
    vector.copyInto(objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data);
    return(objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data);
  }

/**
Create a registry
 */
  public static Files1AE43FA2AC3049DE94230EB71D5CBD65Data[] set(String name, String adOrgId, String adClientId, String dmsDocumentfilingId, String updatedby, String updatedbyr, String isactive, String description, String createdby, String createdbyr)    throws ServletException {
    Files1AE43FA2AC3049DE94230EB71D5CBD65Data objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data[] = new Files1AE43FA2AC3049DE94230EB71D5CBD65Data[1];
    objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data[0] = new Files1AE43FA2AC3049DE94230EB71D5CBD65Data();
    objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data[0].created = "";
    objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data[0].createdbyr = createdbyr;
    objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data[0].updated = "";
    objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data[0].updatedTimeStamp = "";
    objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data[0].updatedby = updatedby;
    objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data[0].updatedbyr = updatedbyr;
    objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data[0].dmsDocumentfilingId = dmsDocumentfilingId;
    objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data[0].adOrgId = adOrgId;
    objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data[0].adOrgIdr = "";
    objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data[0].name = name;
    objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data[0].description = description;
    objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data[0].adClientId = adClientId;
    objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data[0].isactive = isactive;
    objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data[0].language = "";
    return objectFiles1AE43FA2AC3049DE94230EB71D5CBD65Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef5DB2E516121F41EF834EA3C8DCD08BA5_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef368CEAB688A14FB59D10C9F021CE41D7_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE dms_documentfiling" +
      "        SET DMS_Documentfiling_ID = (?) , AD_Org_ID = (?) , Name = (?) , Description = (?) , AD_Client_ID = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE dms_documentfiling.DMS_Documentfiling_ID = ? " +
      "        AND dms_documentfiling.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND dms_documentfiling.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dmsDocumentfilingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dmsDocumentfilingId);
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
      "        INSERT INTO dms_documentfiling " +
      "        (DMS_Documentfiling_ID, AD_Org_ID, Name, Description, AD_Client_ID, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dmsDocumentfilingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
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
      "        DELETE FROM dms_documentfiling" +
      "        WHERE dms_documentfiling.DMS_Documentfiling_ID = ? " +
      "        AND dms_documentfiling.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND dms_documentfiling.AD_Org_ID IN (";
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
      "        DELETE FROM dms_documentfiling" +
      "        WHERE dms_documentfiling.DMS_Documentfiling_ID = ? ";

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
      "          FROM dms_documentfiling" +
      "         WHERE dms_documentfiling.DMS_Documentfiling_ID = ? ";

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
      "          FROM dms_documentfiling" +
      "         WHERE dms_documentfiling.DMS_Documentfiling_ID = ? ";

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
