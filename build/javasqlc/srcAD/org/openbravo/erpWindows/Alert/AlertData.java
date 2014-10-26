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
class AlertData implements FieldProvider {
static Logger log4j = Logger.getLogger(AlertData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adAlertId;
  public String adOrgId;
  public String adOrgIdr;
  public String adAlertruleId;
  public String adAlertruleIdr;
  public String isactive;
  public String description;
  public String isfixed;
  public String note;
  public String referencekeyId;
  public String recordId;
  public String adRoleId;
  public String adRoleIdr;
  public String adUserId;
  public String adUserIdr;
  public String mWarehouseId;
  public String mWarehouseIdr;
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
    else if (fieldName.equalsIgnoreCase("ad_alert_id") || fieldName.equals("adAlertId"))
      return adAlertId;
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
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isfixed"))
      return isfixed;
    else if (fieldName.equalsIgnoreCase("note"))
      return note;
    else if (fieldName.equalsIgnoreCase("referencekey_id") || fieldName.equals("referencekeyId"))
      return referencekeyId;
    else if (fieldName.equalsIgnoreCase("record_id") || fieldName.equals("recordId"))
      return recordId;
    else if (fieldName.equalsIgnoreCase("ad_role_id") || fieldName.equals("adRoleId"))
      return adRoleId;
    else if (fieldName.equalsIgnoreCase("ad_role_idr") || fieldName.equals("adRoleIdr"))
      return adRoleIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
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
  public static AlertData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adAlertruleId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adAlertruleId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static AlertData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adAlertruleId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Alert.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Alert.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Alert.Updated, ?) as updated, " +
      "        to_char(AD_Alert.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Alert.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Alert.UpdatedBy) as UpdatedByR," +
      "        AD_Alert.AD_Client_ID, " +
      "(CASE WHEN AD_Alert.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Alert.AD_Alert_ID, " +
      "AD_Alert.AD_Org_ID, " +
      "(CASE WHEN AD_Alert.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_Alert.AD_AlertRule_ID, " +
      "(CASE WHEN AD_Alert.AD_AlertRule_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS AD_AlertRule_IDR, " +
      "COALESCE(AD_Alert.IsActive, 'N') AS IsActive, " +
      "AD_Alert.Description, " +
      "COALESCE(AD_Alert.Isfixed, 'N') AS Isfixed, " +
      "AD_Alert.Note, " +
      "AD_Alert.Referencekey_ID, " +
      "AD_Alert.Record_ID, " +
      "AD_Alert.AD_Role_ID, " +
      "(CASE WHEN AD_Alert.AD_Role_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_Role_IDR, " +
      "AD_Alert.AD_User_ID, " +
      "(CASE WHEN AD_Alert.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "AD_Alert.M_Warehouse_ID, " +
      "(CASE WHEN AD_Alert.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Alert left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Alert.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_Alert.AD_Org_ID = table2.AD_Org_ID) left join (select AD_AlertRule_ID, Name from AD_AlertRule) table3 on (AD_Alert.AD_AlertRule_ID = table3.AD_AlertRule_ID) left join (select AD_AlertRule_ID,AD_Language, Name from AD_AlertRule_TRL) tableTRL3 on (table3.AD_AlertRule_ID = tableTRL3.AD_AlertRule_ID and tableTRL3.AD_Language = ?)  left join (select AD_Role_ID, Name from AD_Role) table4 on (AD_Alert.AD_Role_ID = table4.AD_Role_ID) left join (select AD_User_ID, Name from AD_User) table5 on (AD_Alert.AD_User_ID = table5.AD_User_ID) left join (select M_Warehouse_ID, Name from M_Warehouse) table6 on (AD_Alert.M_Warehouse_ID = table6.M_Warehouse_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adAlertruleId==null || adAlertruleId.equals(""))?"":"  AND AD_Alert.AD_AlertRule_ID = ?  ");
    strSql = strSql + 
      "        AND AD_Alert.AD_Alert_ID = ? " +
      "        AND AD_Alert.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Alert.AD_Org_ID IN (";
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
        AlertData objectAlertData = new AlertData();
        objectAlertData.created = UtilSql.getValue(result, "created");
        objectAlertData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectAlertData.updated = UtilSql.getValue(result, "updated");
        objectAlertData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectAlertData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAlertData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectAlertData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAlertData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectAlertData.adAlertId = UtilSql.getValue(result, "ad_alert_id");
        objectAlertData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAlertData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectAlertData.adAlertruleId = UtilSql.getValue(result, "ad_alertrule_id");
        objectAlertData.adAlertruleIdr = UtilSql.getValue(result, "ad_alertrule_idr");
        objectAlertData.isactive = UtilSql.getValue(result, "isactive");
        objectAlertData.description = UtilSql.getValue(result, "description");
        objectAlertData.isfixed = UtilSql.getValue(result, "isfixed");
        objectAlertData.note = UtilSql.getValue(result, "note");
        objectAlertData.referencekeyId = UtilSql.getValue(result, "referencekey_id");
        objectAlertData.recordId = UtilSql.getValue(result, "record_id");
        objectAlertData.adRoleId = UtilSql.getValue(result, "ad_role_id");
        objectAlertData.adRoleIdr = UtilSql.getValue(result, "ad_role_idr");
        objectAlertData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectAlertData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectAlertData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectAlertData.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectAlertData.language = UtilSql.getValue(result, "language");
        objectAlertData.adUserClient = "";
        objectAlertData.adOrgClient = "";
        objectAlertData.createdby = "";
        objectAlertData.trBgcolor = "";
        objectAlertData.totalCount = "";
        objectAlertData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAlertData);
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
    AlertData objectAlertData[] = new AlertData[vector.size()];
    vector.copyInto(objectAlertData);
    return(objectAlertData);
  }

/**
Create a registry
 */
  public static AlertData[] set(String adAlertruleId, String createdby, String createdbyr, String note, String recordId, String adRoleId, String adOrgId, String updatedby, String updatedbyr, String isfixed, String description, String referencekeyId, String adUserId, String mWarehouseId, String adClientId, String isactive, String adAlertId)    throws ServletException {
    AlertData objectAlertData[] = new AlertData[1];
    objectAlertData[0] = new AlertData();
    objectAlertData[0].created = "";
    objectAlertData[0].createdbyr = createdbyr;
    objectAlertData[0].updated = "";
    objectAlertData[0].updatedTimeStamp = "";
    objectAlertData[0].updatedby = updatedby;
    objectAlertData[0].updatedbyr = updatedbyr;
    objectAlertData[0].adClientId = adClientId;
    objectAlertData[0].adClientIdr = "";
    objectAlertData[0].adAlertId = adAlertId;
    objectAlertData[0].adOrgId = adOrgId;
    objectAlertData[0].adOrgIdr = "";
    objectAlertData[0].adAlertruleId = adAlertruleId;
    objectAlertData[0].adAlertruleIdr = "";
    objectAlertData[0].isactive = isactive;
    objectAlertData[0].description = description;
    objectAlertData[0].isfixed = isfixed;
    objectAlertData[0].note = note;
    objectAlertData[0].referencekeyId = referencekeyId;
    objectAlertData[0].recordId = recordId;
    objectAlertData[0].adRoleId = adRoleId;
    objectAlertData[0].adRoleIdr = "";
    objectAlertData[0].adUserId = adUserId;
    objectAlertData[0].adUserIdr = "";
    objectAlertData[0].mWarehouseId = mWarehouseId;
    objectAlertData[0].mWarehouseIdr = "";
    objectAlertData[0].language = "";
    return objectAlertData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef803828_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef803830_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT AD_Alert.AD_AlertRule_ID AS NAME" +
      "        FROM AD_Alert" +
      "        WHERE AD_Alert.AD_Alert_ID = ?";

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
      "        UPDATE AD_Alert" +
      "        SET AD_Client_ID = (?) , AD_Alert_ID = (?) , AD_Org_ID = (?) , AD_AlertRule_ID = (?) , IsActive = (?) , Description = (?) , Isfixed = (?) , Note = (?) , Referencekey_ID = (?) , Record_ID = (?) , AD_Role_ID = (?) , AD_User_ID = (?) , M_Warehouse_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Alert.AD_Alert_ID = ? " +
      "                 AND AD_Alert.AD_AlertRule_ID = ? " +
      "        AND AD_Alert.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Alert.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertruleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfixed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referencekeyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recordId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertId);
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
      "        INSERT INTO AD_Alert " +
      "        (AD_Client_ID, AD_Alert_ID, AD_Org_ID, AD_AlertRule_ID, IsActive, Description, Isfixed, Note, Referencekey_ID, Record_ID, AD_Role_ID, AD_User_ID, M_Warehouse_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertruleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfixed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referencekeyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recordId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
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
      "        DELETE FROM AD_Alert" +
      "        WHERE AD_Alert.AD_Alert_ID = ? " +
      "                 AND AD_Alert.AD_AlertRule_ID = ? " +
      "        AND AD_Alert.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Alert.AD_Org_ID IN (";
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
      "        DELETE FROM AD_Alert" +
      "        WHERE AD_Alert.AD_Alert_ID = ? " +
      "                 AND AD_Alert.AD_AlertRule_ID = ? ";

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
      "          FROM AD_Alert" +
      "         WHERE AD_Alert.AD_Alert_ID = ? ";

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
      "          FROM AD_Alert" +
      "         WHERE AD_Alert.AD_Alert_ID = ? ";

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
