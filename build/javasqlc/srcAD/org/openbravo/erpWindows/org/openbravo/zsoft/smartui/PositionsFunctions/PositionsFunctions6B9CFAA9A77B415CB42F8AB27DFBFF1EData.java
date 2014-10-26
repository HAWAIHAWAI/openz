//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.PositionsFunctions;

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
class PositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData implements FieldProvider {
static Logger log4j = Logger.getLogger(PositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cUserPositionId;
  public String adOrgId;
  public String adOrgIdr;
  public String adClientId;
  public String name;
  public String description;
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
    else if (fieldName.equalsIgnoreCase("c_user_position_id") || fieldName.equals("cUserPositionId"))
      return cUserPositionId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
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
  public static PositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_user_position.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_user_position.CreatedBy) as CreatedByR, " +
      "        to_char(c_user_position.Updated, ?) as updated, " +
      "        to_char(c_user_position.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_user_position.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_user_position.UpdatedBy) as UpdatedByR," +
      "        c_user_position.C_User_Position_ID, " +
      "c_user_position.AD_Org_ID, " +
      "(CASE WHEN c_user_position.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "c_user_position.AD_Client_ID, " +
      "c_user_position.Name, " +
      "c_user_position.Description, " +
      "COALESCE(c_user_position.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM c_user_position left join (select AD_Org_ID, Name from AD_Org) table1 on (c_user_position.AD_Org_ID = table1.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND c_user_position.C_User_Position_ID = ? " +
      "        AND c_user_position.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_user_position.AD_Org_ID IN (";
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
        PositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData = new PositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData();
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.created = UtilSql.getValue(result, "created");
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.updated = UtilSql.getValue(result, "updated");
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.cUserPositionId = UtilSql.getValue(result, "c_user_position_id");
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.name = UtilSql.getValue(result, "name");
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.description = UtilSql.getValue(result, "description");
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.isactive = UtilSql.getValue(result, "isactive");
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.language = UtilSql.getValue(result, "language");
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.adUserClient = "";
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.adOrgClient = "";
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.createdby = "";
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.trBgcolor = "";
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.totalCount = "";
        objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData);
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
    PositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[] = new PositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[vector.size()];
    vector.copyInto(objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData);
    return(objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData);
  }

/**
Create a registry
 */
  public static PositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[] set(String isactive, String name, String updatedby, String updatedbyr, String adClientId, String cUserPositionId, String adOrgId, String description, String createdby, String createdbyr)    throws ServletException {
    PositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[] = new PositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[1];
    objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[0] = new PositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData();
    objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[0].created = "";
    objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[0].createdbyr = createdbyr;
    objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[0].updated = "";
    objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[0].updatedTimeStamp = "";
    objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[0].updatedby = updatedby;
    objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[0].updatedbyr = updatedbyr;
    objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[0].cUserPositionId = cUserPositionId;
    objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[0].adOrgId = adOrgId;
    objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[0].adOrgIdr = "";
    objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[0].adClientId = adClientId;
    objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[0].name = name;
    objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[0].description = description;
    objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[0].isactive = isactive;
    objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData[0].language = "";
    return objectPositionsFunctions6B9CFAA9A77B415CB42F8AB27DFBFF1EData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1212071DB9F1498EAD0A453A4CCD74ED_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefBECF471536F148A5A494FFA996589121_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        UPDATE c_user_position" +
      "        SET C_User_Position_ID = (?) , AD_Org_ID = (?) , AD_Client_ID = (?) , Name = (?) , Description = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE c_user_position.C_User_Position_ID = ? " +
      "        AND c_user_position.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_user_position.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserPositionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserPositionId);
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
      "        INSERT INTO c_user_position " +
      "        (C_User_Position_ID, AD_Org_ID, AD_Client_ID, Name, Description, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserPositionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
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
      "        DELETE FROM c_user_position" +
      "        WHERE c_user_position.C_User_Position_ID = ? " +
      "        AND c_user_position.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_user_position.AD_Org_ID IN (";
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
      "        DELETE FROM c_user_position" +
      "        WHERE c_user_position.C_User_Position_ID = ? ";

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
      "          FROM c_user_position" +
      "         WHERE c_user_position.C_User_Position_ID = ? ";

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
      "          FROM c_user_position" +
      "         WHERE c_user_position.C_User_Position_ID = ? ";

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
