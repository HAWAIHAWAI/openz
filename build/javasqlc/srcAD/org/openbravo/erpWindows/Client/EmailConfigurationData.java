//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Client;

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
class EmailConfigurationData implements FieldProvider {
static Logger log4j = Logger.getLogger(EmailConfigurationData.class);
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
  public String isactive;
  public String smtpserver;
  public String issmtpauthorization;
  public String smtpserveraccount;
  public String smtpserverpassword;
  public String smtpserversenderaddress;
  public String cPocConfigurationId;
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
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("smtpserver"))
      return smtpserver;
    else if (fieldName.equalsIgnoreCase("issmtpauthorization"))
      return issmtpauthorization;
    else if (fieldName.equalsIgnoreCase("smtpserveraccount"))
      return smtpserveraccount;
    else if (fieldName.equalsIgnoreCase("smtpserverpassword"))
      return smtpserverpassword;
    else if (fieldName.equalsIgnoreCase("smtpserversenderaddress"))
      return smtpserversenderaddress;
    else if (fieldName.equalsIgnoreCase("c_poc_configuration_id") || fieldName.equals("cPocConfigurationId"))
      return cPocConfigurationId;
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
  public static EmailConfigurationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String AD_Client_ID, String adClientId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, AD_Client_ID, adClientId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static EmailConfigurationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String AD_Client_ID, String adClientId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_POC_CONFIGURATION.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_POC_CONFIGURATION.CreatedBy) as CreatedByR, " +
      "        to_char(C_POC_CONFIGURATION.Updated, ?) as updated, " +
      "        to_char(C_POC_CONFIGURATION.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_POC_CONFIGURATION.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_POC_CONFIGURATION.UpdatedBy) as UpdatedByR," +
      "        C_POC_CONFIGURATION.AD_Client_ID, " +
      "(CASE WHEN C_POC_CONFIGURATION.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_POC_CONFIGURATION.AD_Org_ID, " +
      "(CASE WHEN C_POC_CONFIGURATION.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(C_POC_CONFIGURATION.Isactive, 'N') AS Isactive, " +
      "C_POC_CONFIGURATION.Smtpserver, " +
      "COALESCE(C_POC_CONFIGURATION.IsSmtpAuthorization, 'N') AS IsSmtpAuthorization, " +
      "C_POC_CONFIGURATION.Smtpserveraccount, " +
      "C_POC_CONFIGURATION.Smtpserverpassword, " +
      "C_POC_CONFIGURATION.Smtpserversenderaddress, " +
      "C_POC_CONFIGURATION.C_Poc_Configuration_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_POC_CONFIGURATION left join (select AD_Client_ID, Name from AD_Client) table1 on (C_POC_CONFIGURATION.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_POC_CONFIGURATION.AD_Org_ID = table2.AD_Org_ID)" +
      "        WHERE 2=2 " +
      " AND C_POC_CONFIGURATION.AD_Client_ID = ?" +
      "        AND 1=1 ";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":"  AND C_POC_CONFIGURATION.AD_Client_ID = ?  ");
    strSql = strSql + 
      "        AND C_POC_CONFIGURATION.C_Poc_Configuration_ID = ? " +
      "        AND C_POC_CONFIGURATION.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_POC_CONFIGURATION.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Client_ID);
      if (adClientId != null && !(adClientId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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
        EmailConfigurationData objectEmailConfigurationData = new EmailConfigurationData();
        objectEmailConfigurationData.created = UtilSql.getValue(result, "created");
        objectEmailConfigurationData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectEmailConfigurationData.updated = UtilSql.getValue(result, "updated");
        objectEmailConfigurationData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectEmailConfigurationData.updatedby = UtilSql.getValue(result, "updatedby");
        objectEmailConfigurationData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectEmailConfigurationData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectEmailConfigurationData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectEmailConfigurationData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectEmailConfigurationData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectEmailConfigurationData.isactive = UtilSql.getValue(result, "isactive");
        objectEmailConfigurationData.smtpserver = UtilSql.getValue(result, "smtpserver");
        objectEmailConfigurationData.issmtpauthorization = UtilSql.getValue(result, "issmtpauthorization");
        objectEmailConfigurationData.smtpserveraccount = UtilSql.getValue(result, "smtpserveraccount");
        objectEmailConfigurationData.smtpserverpassword = UtilSql.getValue(result, "smtpserverpassword");
        objectEmailConfigurationData.smtpserversenderaddress = UtilSql.getValue(result, "smtpserversenderaddress");
        objectEmailConfigurationData.cPocConfigurationId = UtilSql.getValue(result, "c_poc_configuration_id");
        objectEmailConfigurationData.language = UtilSql.getValue(result, "language");
        objectEmailConfigurationData.adUserClient = "";
        objectEmailConfigurationData.adOrgClient = "";
        objectEmailConfigurationData.createdby = "";
        objectEmailConfigurationData.trBgcolor = "";
        objectEmailConfigurationData.totalCount = "";
        objectEmailConfigurationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEmailConfigurationData);
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
    EmailConfigurationData objectEmailConfigurationData[] = new EmailConfigurationData[vector.size()];
    vector.copyInto(objectEmailConfigurationData);
    return(objectEmailConfigurationData);
  }

/**
Create a registry
 */
  public static EmailConfigurationData[] set(String adClientId, String adOrgId, String smtpserverpassword, String smtpserversenderaddress, String cPocConfigurationId, String isactive, String smtpserver, String createdby, String createdbyr, String smtpserveraccount, String updatedby, String updatedbyr, String issmtpauthorization)    throws ServletException {
    EmailConfigurationData objectEmailConfigurationData[] = new EmailConfigurationData[1];
    objectEmailConfigurationData[0] = new EmailConfigurationData();
    objectEmailConfigurationData[0].created = "";
    objectEmailConfigurationData[0].createdbyr = createdbyr;
    objectEmailConfigurationData[0].updated = "";
    objectEmailConfigurationData[0].updatedTimeStamp = "";
    objectEmailConfigurationData[0].updatedby = updatedby;
    objectEmailConfigurationData[0].updatedbyr = updatedbyr;
    objectEmailConfigurationData[0].adClientId = adClientId;
    objectEmailConfigurationData[0].adClientIdr = "";
    objectEmailConfigurationData[0].adOrgId = adOrgId;
    objectEmailConfigurationData[0].adOrgIdr = "";
    objectEmailConfigurationData[0].isactive = isactive;
    objectEmailConfigurationData[0].smtpserver = smtpserver;
    objectEmailConfigurationData[0].issmtpauthorization = issmtpauthorization;
    objectEmailConfigurationData[0].smtpserveraccount = smtpserveraccount;
    objectEmailConfigurationData[0].smtpserverpassword = smtpserverpassword;
    objectEmailConfigurationData[0].smtpserversenderaddress = smtpserversenderaddress;
    objectEmailConfigurationData[0].cPocConfigurationId = cPocConfigurationId;
    objectEmailConfigurationData[0].language = "";
    return objectEmailConfigurationData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1000500007_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef1000500009_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT C_POC_CONFIGURATION.AD_Client_ID AS NAME" +
      "        FROM C_POC_CONFIGURATION" +
      "        WHERE C_POC_CONFIGURATION.C_Poc_Configuration_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Client left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Client.AD_Client_ID = table1.AD_Client_ID) WHERE AD_Client.AD_Client_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Client left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Client.AD_Client_ID = table1.AD_Client_ID) WHERE AD_Client.AD_Client_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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
      "        UPDATE C_POC_CONFIGURATION" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , Isactive = (?) , Smtpserver = (?) , IsSmtpAuthorization = (?) , Smtpserveraccount = (?) , Smtpserverpassword = (?) , Smtpserversenderaddress = (?) , C_Poc_Configuration_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_POC_CONFIGURATION.C_Poc_Configuration_ID = ? " +
      "                 AND C_POC_CONFIGURATION.AD_Client_ID = ? " +
      "        AND C_POC_CONFIGURATION.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_POC_CONFIGURATION.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, smtpserver);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issmtpauthorization);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, smtpserveraccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, smtpserverpassword);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, smtpserversenderaddress);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocConfigurationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocConfigurationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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
      "        INSERT INTO C_POC_CONFIGURATION " +
      "        (AD_Client_ID, AD_Org_ID, Isactive, Smtpserver, IsSmtpAuthorization, Smtpserveraccount, Smtpserverpassword, Smtpserversenderaddress, C_Poc_Configuration_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, smtpserver);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issmtpauthorization);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, smtpserveraccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, smtpserverpassword);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, smtpserversenderaddress);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocConfigurationId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adClientId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_POC_CONFIGURATION" +
      "        WHERE C_POC_CONFIGURATION.C_Poc_Configuration_ID = ? " +
      "                 AND C_POC_CONFIGURATION.AD_Client_ID = ? " +
      "        AND C_POC_CONFIGURATION.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_POC_CONFIGURATION.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_POC_CONFIGURATION" +
      "        WHERE C_POC_CONFIGURATION.C_Poc_Configuration_ID = ? " +
      "                 AND C_POC_CONFIGURATION.AD_Client_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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
      "          FROM C_POC_CONFIGURATION" +
      "         WHERE C_POC_CONFIGURATION.C_Poc_Configuration_ID = ? ";

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
      "          FROM C_POC_CONFIGURATION" +
      "         WHERE C_POC_CONFIGURATION.C_Poc_Configuration_ID = ? ";

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
