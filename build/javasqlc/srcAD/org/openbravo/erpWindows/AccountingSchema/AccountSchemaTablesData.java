//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.AccountingSchema;

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
class AccountSchemaTablesData implements FieldProvider {
static Logger log4j = Logger.getLogger(AccountSchemaTablesData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cAcctschemaTableId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String cAcctschemaId;
  public String cAcctschemaIdr;
  public String adTableId;
  public String adTableIdr;
  public String adCreatefactTemplateId;
  public String adCreatefactTemplateIdr;
  public String acctdescription;
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
    else if (fieldName.equalsIgnoreCase("c_acctschema_table_id") || fieldName.equals("cAcctschemaTableId"))
      return cAcctschemaTableId;
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
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_idr") || fieldName.equals("cAcctschemaIdr"))
      return cAcctschemaIdr;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("ad_table_idr") || fieldName.equals("adTableIdr"))
      return adTableIdr;
    else if (fieldName.equalsIgnoreCase("ad_createfact_template_id") || fieldName.equals("adCreatefactTemplateId"))
      return adCreatefactTemplateId;
    else if (fieldName.equalsIgnoreCase("ad_createfact_template_idr") || fieldName.equals("adCreatefactTemplateIdr"))
      return adCreatefactTemplateIdr;
    else if (fieldName.equalsIgnoreCase("acctdescription"))
      return acctdescription;
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
  public static AccountSchemaTablesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cAcctschemaId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cAcctschemaId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static AccountSchemaTablesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cAcctschemaId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_AcctSchema_Table.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_AcctSchema_Table.CreatedBy) as CreatedByR, " +
      "        to_char(C_AcctSchema_Table.Updated, ?) as updated, " +
      "        to_char(C_AcctSchema_Table.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_AcctSchema_Table.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_AcctSchema_Table.UpdatedBy) as UpdatedByR," +
      "        C_AcctSchema_Table.C_Acctschema_Table_ID, " +
      "C_AcctSchema_Table.AD_Client_ID, " +
      "(CASE WHEN C_AcctSchema_Table.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_AcctSchema_Table.AD_Org_ID, " +
      "(CASE WHEN C_AcctSchema_Table.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(C_AcctSchema_Table.IsActive, 'N') AS IsActive, " +
      "C_AcctSchema_Table.C_AcctSchema_ID, " +
      "(CASE WHEN C_AcctSchema_Table.C_AcctSchema_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_AcctSchema_IDR, " +
      "C_AcctSchema_Table.AD_Table_ID, " +
      "(CASE WHEN C_AcctSchema_Table.AD_Table_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_Table_IDR, " +
      "C_AcctSchema_Table.AD_Createfact_Template_ID, " +
      "(CASE WHEN C_AcctSchema_Table.AD_Createfact_Template_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_Createfact_Template_IDR, " +
      "C_AcctSchema_Table.Acctdescription, " +
      "        ? AS LANGUAGE " +
      "        FROM C_AcctSchema_Table left join (select AD_Client_ID, Name from AD_Client) table1 on (C_AcctSchema_Table.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_AcctSchema_Table.AD_Org_ID = table2.AD_Org_ID) left join (select C_AcctSchema_ID, Name from C_AcctSchema) table3 on (C_AcctSchema_Table.C_AcctSchema_ID = table3.C_AcctSchema_ID) left join (select AD_Table_ID, Name from AD_Table) table4 on (C_AcctSchema_Table.AD_Table_ID =  table4.AD_Table_ID) left join (select AD_Createfact_Template_ID, Name from AD_Createfact_Template) table5 on (C_AcctSchema_Table.AD_Createfact_Template_ID = table5.AD_Createfact_Template_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cAcctschemaId==null || cAcctschemaId.equals(""))?"":"  AND C_AcctSchema_Table.C_AcctSchema_ID = ?  ");
    strSql = strSql + 
      "        AND C_AcctSchema_Table.C_Acctschema_Table_ID = ? " +
      "        AND C_AcctSchema_Table.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_AcctSchema_Table.AD_Org_ID IN (";
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
      if (cAcctschemaId != null && !(cAcctschemaId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
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
        AccountSchemaTablesData objectAccountSchemaTablesData = new AccountSchemaTablesData();
        objectAccountSchemaTablesData.created = UtilSql.getValue(result, "created");
        objectAccountSchemaTablesData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectAccountSchemaTablesData.updated = UtilSql.getValue(result, "updated");
        objectAccountSchemaTablesData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectAccountSchemaTablesData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAccountSchemaTablesData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectAccountSchemaTablesData.cAcctschemaTableId = UtilSql.getValue(result, "c_acctschema_table_id");
        objectAccountSchemaTablesData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAccountSchemaTablesData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectAccountSchemaTablesData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAccountSchemaTablesData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectAccountSchemaTablesData.isactive = UtilSql.getValue(result, "isactive");
        objectAccountSchemaTablesData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectAccountSchemaTablesData.cAcctschemaIdr = UtilSql.getValue(result, "c_acctschema_idr");
        objectAccountSchemaTablesData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectAccountSchemaTablesData.adTableIdr = UtilSql.getValue(result, "ad_table_idr");
        objectAccountSchemaTablesData.adCreatefactTemplateId = UtilSql.getValue(result, "ad_createfact_template_id");
        objectAccountSchemaTablesData.adCreatefactTemplateIdr = UtilSql.getValue(result, "ad_createfact_template_idr");
        objectAccountSchemaTablesData.acctdescription = UtilSql.getValue(result, "acctdescription");
        objectAccountSchemaTablesData.language = UtilSql.getValue(result, "language");
        objectAccountSchemaTablesData.adUserClient = "";
        objectAccountSchemaTablesData.adOrgClient = "";
        objectAccountSchemaTablesData.createdby = "";
        objectAccountSchemaTablesData.trBgcolor = "";
        objectAccountSchemaTablesData.totalCount = "";
        objectAccountSchemaTablesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountSchemaTablesData);
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
    AccountSchemaTablesData objectAccountSchemaTablesData[] = new AccountSchemaTablesData[vector.size()];
    vector.copyInto(objectAccountSchemaTablesData);
    return(objectAccountSchemaTablesData);
  }

/**
Create a registry
 */
  public static AccountSchemaTablesData[] set(String cAcctschemaId, String adCreatefactTemplateId, String adTableId, String adOrgId, String cAcctschemaTableId, String adClientId, String updatedby, String updatedbyr, String acctdescription, String isactive, String createdby, String createdbyr)    throws ServletException {
    AccountSchemaTablesData objectAccountSchemaTablesData[] = new AccountSchemaTablesData[1];
    objectAccountSchemaTablesData[0] = new AccountSchemaTablesData();
    objectAccountSchemaTablesData[0].created = "";
    objectAccountSchemaTablesData[0].createdbyr = createdbyr;
    objectAccountSchemaTablesData[0].updated = "";
    objectAccountSchemaTablesData[0].updatedTimeStamp = "";
    objectAccountSchemaTablesData[0].updatedby = updatedby;
    objectAccountSchemaTablesData[0].updatedbyr = updatedbyr;
    objectAccountSchemaTablesData[0].cAcctschemaTableId = cAcctschemaTableId;
    objectAccountSchemaTablesData[0].adClientId = adClientId;
    objectAccountSchemaTablesData[0].adClientIdr = "";
    objectAccountSchemaTablesData[0].adOrgId = adOrgId;
    objectAccountSchemaTablesData[0].adOrgIdr = "";
    objectAccountSchemaTablesData[0].isactive = isactive;
    objectAccountSchemaTablesData[0].cAcctschemaId = cAcctschemaId;
    objectAccountSchemaTablesData[0].cAcctschemaIdr = "";
    objectAccountSchemaTablesData[0].adTableId = adTableId;
    objectAccountSchemaTablesData[0].adTableIdr = "";
    objectAccountSchemaTablesData[0].adCreatefactTemplateId = adCreatefactTemplateId;
    objectAccountSchemaTablesData[0].adCreatefactTemplateIdr = "";
    objectAccountSchemaTablesData[0].acctdescription = acctdescription;
    objectAccountSchemaTablesData[0].language = "";
    return objectAccountSchemaTablesData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef800518_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef800516_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_AcctSchema_Table.C_AcctSchema_ID AS NAME" +
      "        FROM C_AcctSchema_Table" +
      "        WHERE C_AcctSchema_Table.C_Acctschema_Table_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cAcctschemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_AcctSchema left join (select C_AcctSchema_ID, Name from C_AcctSchema) table1 on (C_AcctSchema.C_AcctSchema_ID = table1.C_AcctSchema_ID) WHERE C_AcctSchema.C_AcctSchema_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cAcctschemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_AcctSchema left join (select C_AcctSchema_ID, Name from C_AcctSchema) table1 on (C_AcctSchema.C_AcctSchema_ID = table1.C_AcctSchema_ID) WHERE C_AcctSchema.C_AcctSchema_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

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
      "        UPDATE C_AcctSchema_Table" +
      "        SET C_Acctschema_Table_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , IsActive = (?) , C_AcctSchema_ID = (?) , AD_Table_ID = (?) , AD_Createfact_Template_ID = (?) , Acctdescription = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_AcctSchema_Table.C_Acctschema_Table_ID = ? " +
      "                 AND C_AcctSchema_Table.C_AcctSchema_ID = ? " +
      "        AND C_AcctSchema_Table.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_AcctSchema_Table.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adCreatefactTemplateId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
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
      "        INSERT INTO C_AcctSchema_Table " +
      "        (C_Acctschema_Table_ID, AD_Client_ID, AD_Org_ID, IsActive, C_AcctSchema_ID, AD_Table_ID, AD_Createfact_Template_ID, Acctdescription, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adCreatefactTemplateId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctdescription);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cAcctschemaId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_AcctSchema_Table" +
      "        WHERE C_AcctSchema_Table.C_Acctschema_Table_ID = ? " +
      "                 AND C_AcctSchema_Table.C_AcctSchema_ID = ? " +
      "        AND C_AcctSchema_Table.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_AcctSchema_Table.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cAcctschemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_AcctSchema_Table" +
      "        WHERE C_AcctSchema_Table.C_Acctschema_Table_ID = ? " +
      "                 AND C_AcctSchema_Table.C_AcctSchema_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

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
      "          FROM C_AcctSchema_Table" +
      "         WHERE C_AcctSchema_Table.C_Acctschema_Table_ID = ? ";

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
      "          FROM C_AcctSchema_Table" +
      "         WHERE C_AcctSchema_Table.C_Acctschema_Table_ID = ? ";

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
