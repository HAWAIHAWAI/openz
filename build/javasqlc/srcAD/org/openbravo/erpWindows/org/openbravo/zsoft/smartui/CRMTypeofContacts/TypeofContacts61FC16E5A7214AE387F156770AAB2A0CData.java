//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.CRMTypeofContacts;

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
class TypeofContacts61FC16E5A7214AE387F156770AAB2A0CData implements FieldProvider {
static Logger log4j = Logger.getLogger(TypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssiCrmactionsId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
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
    else if (fieldName.equalsIgnoreCase("zssi_crmactions_id") || fieldName.equals("zssiCrmactionsId"))
      return zssiCrmactionsId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
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
  public static TypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_crmactions.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_crmactions.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_crmactions.Updated, ?) as updated, " +
      "        to_char(zssi_crmactions.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_crmactions.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_crmactions.UpdatedBy) as UpdatedByR," +
      "        zssi_crmactions.Zssi_Crmactions_ID, " +
      "zssi_crmactions.AD_Client_ID, " +
      "(CASE WHEN zssi_crmactions.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "zssi_crmactions.AD_Org_ID, " +
      "(CASE WHEN zssi_crmactions.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zssi_crmactions.Name, " +
      "zssi_crmactions.Description, " +
      "COALESCE(zssi_crmactions.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_crmactions left join (select AD_Client_ID, Name from AD_Client) table1 on (zssi_crmactions.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (zssi_crmactions.AD_Org_ID = table2.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND zssi_crmactions.Zssi_Crmactions_ID = ? " +
      "        AND zssi_crmactions.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_crmactions.AD_Org_ID IN (";
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
        TypeofContacts61FC16E5A7214AE387F156770AAB2A0CData objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData = new TypeofContacts61FC16E5A7214AE387F156770AAB2A0CData();
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.created = UtilSql.getValue(result, "created");
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.updated = UtilSql.getValue(result, "updated");
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.zssiCrmactionsId = UtilSql.getValue(result, "zssi_crmactions_id");
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.name = UtilSql.getValue(result, "name");
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.description = UtilSql.getValue(result, "description");
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.isactive = UtilSql.getValue(result, "isactive");
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.language = UtilSql.getValue(result, "language");
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.adUserClient = "";
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.adOrgClient = "";
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.createdby = "";
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.trBgcolor = "";
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.totalCount = "";
        objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData);
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
    TypeofContacts61FC16E5A7214AE387F156770AAB2A0CData objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[] = new TypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[vector.size()];
    vector.copyInto(objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData);
    return(objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData);
  }

/**
Create a registry
 */
  public static TypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[] set(String updatedby, String updatedbyr, String description, String adOrgId, String isactive, String createdby, String createdbyr, String name, String zssiCrmactionsId, String adClientId)    throws ServletException {
    TypeofContacts61FC16E5A7214AE387F156770AAB2A0CData objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[] = new TypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[1];
    objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[0] = new TypeofContacts61FC16E5A7214AE387F156770AAB2A0CData();
    objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[0].created = "";
    objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[0].createdbyr = createdbyr;
    objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[0].updated = "";
    objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[0].updatedTimeStamp = "";
    objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[0].updatedby = updatedby;
    objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[0].updatedbyr = updatedbyr;
    objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[0].zssiCrmactionsId = zssiCrmactionsId;
    objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[0].adClientId = adClientId;
    objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[0].adClientIdr = "";
    objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[0].adOrgId = adOrgId;
    objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[0].adOrgIdr = "";
    objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[0].name = name;
    objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[0].description = description;
    objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[0].isactive = isactive;
    objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData[0].language = "";
    return objectTypeofContacts61FC16E5A7214AE387F156770AAB2A0CData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef27F15ABA10234BD4A82633EC9C4D7D79_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefD521CEFAB0E946B8AF9A671645A65561_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        UPDATE zssi_crmactions" +
      "        SET Zssi_Crmactions_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Name = (?) , Description = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_crmactions.Zssi_Crmactions_ID = ? " +
      "        AND zssi_crmactions.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_crmactions.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiCrmactionsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiCrmactionsId);
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
      "        INSERT INTO zssi_crmactions " +
      "        (Zssi_Crmactions_ID, AD_Client_ID, AD_Org_ID, Name, Description, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiCrmactionsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
      "        DELETE FROM zssi_crmactions" +
      "        WHERE zssi_crmactions.Zssi_Crmactions_ID = ? " +
      "        AND zssi_crmactions.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_crmactions.AD_Org_ID IN (";
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
      "        DELETE FROM zssi_crmactions" +
      "        WHERE zssi_crmactions.Zssi_Crmactions_ID = ? ";

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
      "          FROM zssi_crmactions" +
      "         WHERE zssi_crmactions.Zssi_Crmactions_ID = ? ";

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
      "          FROM zssi_crmactions" +
      "         WHERE zssi_crmactions.Zssi_Crmactions_ID = ? ";

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
