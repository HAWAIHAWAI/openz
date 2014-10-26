//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Alert;

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
class AlertRecipientData implements FieldProvider {
static Logger log4j = Logger.getLogger(AlertRecipientData.class);
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
  public String adAlertruleId;
  public String adAlertruleIdr;
  public String isactive;
  public String adRoleId;
  public String adRoleIdr;
  public String adUserId;
  public String adUserIdr;
  public String sendemail;
  public String adAlertrecipientId;
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
    else if (fieldName.equalsIgnoreCase("ad_alertrule_id") || fieldName.equals("adAlertruleId"))
      return adAlertruleId;
    else if (fieldName.equalsIgnoreCase("ad_alertrule_idr") || fieldName.equals("adAlertruleIdr"))
      return adAlertruleIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_role_id") || fieldName.equals("adRoleId"))
      return adRoleId;
    else if (fieldName.equalsIgnoreCase("ad_role_idr") || fieldName.equals("adRoleIdr"))
      return adRoleIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("sendemail"))
      return sendemail;
    else if (fieldName.equalsIgnoreCase("ad_alertrecipient_id") || fieldName.equals("adAlertrecipientId"))
      return adAlertrecipientId;
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
  public static AlertRecipientData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adAlertruleId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adAlertruleId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static AlertRecipientData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adAlertruleId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_AlertRecipient.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_AlertRecipient.CreatedBy) as CreatedByR, " +
      "        to_char(AD_AlertRecipient.Updated, ?) as updated, " +
      "        to_char(AD_AlertRecipient.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_AlertRecipient.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_AlertRecipient.UpdatedBy) as UpdatedByR," +
      "        AD_AlertRecipient.AD_Client_ID, " +
      "(CASE WHEN AD_AlertRecipient.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_AlertRecipient.AD_Org_ID, " +
      "(CASE WHEN AD_AlertRecipient.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_AlertRecipient.AD_AlertRule_ID, " +
      "(CASE WHEN AD_AlertRecipient.AD_AlertRule_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS AD_AlertRule_IDR, " +
      "COALESCE(AD_AlertRecipient.IsActive, 'N') AS IsActive, " +
      "AD_AlertRecipient.AD_Role_ID, " +
      "(CASE WHEN AD_AlertRecipient.AD_Role_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_Role_IDR, " +
      "AD_AlertRecipient.AD_User_ID, " +
      "(CASE WHEN AD_AlertRecipient.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "COALESCE(AD_AlertRecipient.Sendemail, 'N') AS Sendemail, " +
      "AD_AlertRecipient.AD_Alertrecipient_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_AlertRecipient left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_AlertRecipient.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_AlertRecipient.AD_Org_ID = table2.AD_Org_ID) left join (select AD_AlertRule_ID, Name from AD_AlertRule) table3 on (AD_AlertRecipient.AD_AlertRule_ID = table3.AD_AlertRule_ID) left join (select AD_AlertRule_ID,AD_Language, Name from AD_AlertRule_TRL) tableTRL3 on (table3.AD_AlertRule_ID = tableTRL3.AD_AlertRule_ID and tableTRL3.AD_Language = ?)  left join (select AD_Role_ID, Name from AD_Role) table4 on (AD_AlertRecipient.AD_Role_ID = table4.AD_Role_ID) left join (select AD_User_ID, Name from AD_User) table5 on (AD_AlertRecipient.AD_User_ID = table5.AD_User_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adAlertruleId==null || adAlertruleId.equals(""))?"":"  AND AD_AlertRecipient.AD_AlertRule_ID = ?  ");
    strSql = strSql + 
      "        AND AD_AlertRecipient.AD_Alertrecipient_ID = ? " +
      "        AND AD_AlertRecipient.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_AlertRecipient.AD_Org_ID IN (";
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
      if (adAlertruleId != null && !(adAlertruleId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertruleId);
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
        AlertRecipientData objectAlertRecipientData = new AlertRecipientData();
        objectAlertRecipientData.created = UtilSql.getValue(result, "created");
        objectAlertRecipientData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectAlertRecipientData.updated = UtilSql.getValue(result, "updated");
        objectAlertRecipientData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectAlertRecipientData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAlertRecipientData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectAlertRecipientData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAlertRecipientData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectAlertRecipientData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAlertRecipientData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectAlertRecipientData.adAlertruleId = UtilSql.getValue(result, "ad_alertrule_id");
        objectAlertRecipientData.adAlertruleIdr = UtilSql.getValue(result, "ad_alertrule_idr");
        objectAlertRecipientData.isactive = UtilSql.getValue(result, "isactive");
        objectAlertRecipientData.adRoleId = UtilSql.getValue(result, "ad_role_id");
        objectAlertRecipientData.adRoleIdr = UtilSql.getValue(result, "ad_role_idr");
        objectAlertRecipientData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectAlertRecipientData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectAlertRecipientData.sendemail = UtilSql.getValue(result, "sendemail");
        objectAlertRecipientData.adAlertrecipientId = UtilSql.getValue(result, "ad_alertrecipient_id");
        objectAlertRecipientData.language = UtilSql.getValue(result, "language");
        objectAlertRecipientData.adUserClient = "";
        objectAlertRecipientData.adOrgClient = "";
        objectAlertRecipientData.createdby = "";
        objectAlertRecipientData.trBgcolor = "";
        objectAlertRecipientData.totalCount = "";
        objectAlertRecipientData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAlertRecipientData);
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
    AlertRecipientData objectAlertRecipientData[] = new AlertRecipientData[vector.size()];
    vector.copyInto(objectAlertRecipientData);
    return(objectAlertRecipientData);
  }

/**
Create a registry
 */
  public static AlertRecipientData[] set(String adAlertruleId, String isactive, String adClientId, String createdby, String createdbyr, String adAlertrecipientId, String adOrgId, String sendemail, String adUserId, String adRoleId, String updatedby, String updatedbyr)    throws ServletException {
    AlertRecipientData objectAlertRecipientData[] = new AlertRecipientData[1];
    objectAlertRecipientData[0] = new AlertRecipientData();
    objectAlertRecipientData[0].created = "";
    objectAlertRecipientData[0].createdbyr = createdbyr;
    objectAlertRecipientData[0].updated = "";
    objectAlertRecipientData[0].updatedTimeStamp = "";
    objectAlertRecipientData[0].updatedby = updatedby;
    objectAlertRecipientData[0].updatedbyr = updatedbyr;
    objectAlertRecipientData[0].adClientId = adClientId;
    objectAlertRecipientData[0].adClientIdr = "";
    objectAlertRecipientData[0].adOrgId = adOrgId;
    objectAlertRecipientData[0].adOrgIdr = "";
    objectAlertRecipientData[0].adAlertruleId = adAlertruleId;
    objectAlertRecipientData[0].adAlertruleIdr = "";
    objectAlertRecipientData[0].isactive = isactive;
    objectAlertRecipientData[0].adRoleId = adRoleId;
    objectAlertRecipientData[0].adRoleIdr = "";
    objectAlertRecipientData[0].adUserId = adUserId;
    objectAlertRecipientData[0].adUserIdr = "";
    objectAlertRecipientData[0].sendemail = sendemail;
    objectAlertRecipientData[0].adAlertrecipientId = adAlertrecipientId;
    objectAlertRecipientData[0].language = "";
    return objectAlertRecipientData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef803846_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef803848_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_AlertRecipient.AD_AlertRule_ID AS NAME" +
      "        FROM AD_AlertRecipient" +
      "        WHERE AD_AlertRecipient.AD_Alertrecipient_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adAlertruleId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM AD_AlertRule left join (select AD_AlertRule_ID, Name from AD_AlertRule) table1 on (AD_AlertRule.AD_AlertRule_ID = table1.AD_AlertRule_ID) left join (select AD_AlertRule_ID,AD_Language, Name from AD_AlertRule_TRL) tableTRL1 on (table1.AD_AlertRule_ID = tableTRL1.AD_AlertRule_ID and tableTRL1.AD_Language = ?)  WHERE AD_AlertRule.AD_AlertRule_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertruleId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adAlertruleId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM AD_AlertRule left join (select AD_AlertRule_ID, Name from AD_AlertRule) table1 on (AD_AlertRule.AD_AlertRule_ID = table1.AD_AlertRule_ID) left join (select AD_AlertRule_ID,AD_Language, Name from AD_AlertRule_TRL) tableTRL1 on (table1.AD_AlertRule_ID = tableTRL1.AD_AlertRule_ID and tableTRL1.AD_Language = ?)  WHERE AD_AlertRule.AD_AlertRule_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertruleId);

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
      "        UPDATE AD_AlertRecipient" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , AD_AlertRule_ID = (?) , IsActive = (?) , AD_Role_ID = (?) , AD_User_ID = (?) , Sendemail = (?) , AD_Alertrecipient_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_AlertRecipient.AD_Alertrecipient_ID = ? " +
      "                 AND AD_AlertRecipient.AD_AlertRule_ID = ? " +
      "        AND AD_AlertRecipient.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_AlertRecipient.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertruleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sendemail);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertrecipientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertrecipientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertruleId);
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
      "        INSERT INTO AD_AlertRecipient " +
      "        (AD_Client_ID, AD_Org_ID, AD_AlertRule_ID, IsActive, AD_Role_ID, AD_User_ID, Sendemail, AD_Alertrecipient_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertruleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sendemail);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertrecipientId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adAlertruleId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_AlertRecipient" +
      "        WHERE AD_AlertRecipient.AD_Alertrecipient_ID = ? " +
      "                 AND AD_AlertRecipient.AD_AlertRule_ID = ? " +
      "        AND AD_AlertRecipient.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_AlertRecipient.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertruleId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adAlertruleId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_AlertRecipient" +
      "        WHERE AD_AlertRecipient.AD_Alertrecipient_ID = ? " +
      "                 AND AD_AlertRecipient.AD_AlertRule_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertruleId);

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
      "          FROM AD_AlertRecipient" +
      "         WHERE AD_AlertRecipient.AD_Alertrecipient_ID = ? ";

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
      "          FROM AD_AlertRecipient" +
      "         WHERE AD_AlertRecipient.AD_Alertrecipient_ID = ? ";

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
