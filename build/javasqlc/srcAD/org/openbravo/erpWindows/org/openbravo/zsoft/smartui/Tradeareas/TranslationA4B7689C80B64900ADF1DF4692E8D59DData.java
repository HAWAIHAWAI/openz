//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.Tradeareas;

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
class TranslationA4B7689C80B64900ADF1DF4692E8D59DData implements FieldProvider {
static Logger log4j = Logger.getLogger(TranslationA4B7689C80B64900ADF1DF4692E8D59DData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssiTradeareaTrlId;
  public String adClientId;
  public String adClientIdr;
  public String zssiTradeareaId;
  public String adOrgId;
  public String adOrgIdr;
  public String adLanguage;
  public String adLanguager;
  public String text;
  public String istranslated;
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
    else if (fieldName.equalsIgnoreCase("zssi_tradearea_trl_id") || fieldName.equals("zssiTradeareaTrlId"))
      return zssiTradeareaTrlId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("zssi_tradearea_id") || fieldName.equals("zssiTradeareaId"))
      return zssiTradeareaId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
    else if (fieldName.equalsIgnoreCase("text"))
      return text;
    else if (fieldName.equalsIgnoreCase("istranslated"))
      return istranslated;
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
  public static TranslationA4B7689C80B64900ADF1DF4692E8D59DData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssiTradeareaId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zssiTradeareaId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TranslationA4B7689C80B64900ADF1DF4692E8D59DData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssiTradeareaId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_tradearea_trl.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_tradearea_trl.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_tradearea_trl.Updated, ?) as updated, " +
      "        to_char(zssi_tradearea_trl.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_tradearea_trl.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_tradearea_trl.UpdatedBy) as UpdatedByR," +
      "        zssi_tradearea_trl.Zssi_Tradearea_Trl_ID, " +
      "zssi_tradearea_trl.AD_Client_ID, " +
      "(CASE WHEN zssi_tradearea_trl.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "zssi_tradearea_trl.Zssi_Tradearea_ID, " +
      "zssi_tradearea_trl.AD_Org_ID, " +
      "(CASE WHEN zssi_tradearea_trl.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zssi_tradearea_trl.AD_Language, " +
      "(CASE WHEN zssi_tradearea_trl.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "zssi_tradearea_trl.Text, " +
      "COALESCE(zssi_tradearea_trl.Istranslated, 'N') AS Istranslated, " +
      "COALESCE(zssi_tradearea_trl.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_tradearea_trl left join (select AD_Client_ID, Name from AD_Client) table1 on (zssi_tradearea_trl.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (zssi_tradearea_trl.AD_Org_ID = table2.AD_Org_ID) left join (select AD_Language, Name from AD_Language) table3 on (zssi_tradearea_trl.AD_Language =  table3.AD_Language)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zssiTradeareaId==null || zssiTradeareaId.equals(""))?"":"  AND zssi_tradearea_trl.Zssi_Tradearea_ID = ?  ");
    strSql = strSql + 
      "        AND zssi_tradearea_trl.Zssi_Tradearea_Trl_ID = ? " +
      "        AND zssi_tradearea_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_tradearea_trl.AD_Org_ID IN (";
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
      if (zssiTradeareaId != null && !(zssiTradeareaId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaId);
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
        TranslationA4B7689C80B64900ADF1DF4692E8D59DData objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData = new TranslationA4B7689C80B64900ADF1DF4692E8D59DData();
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.created = UtilSql.getValue(result, "created");
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.updated = UtilSql.getValue(result, "updated");
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.zssiTradeareaTrlId = UtilSql.getValue(result, "zssi_tradearea_trl_id");
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.zssiTradeareaId = UtilSql.getValue(result, "zssi_tradearea_id");
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.text = UtilSql.getValue(result, "text");
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.istranslated = UtilSql.getValue(result, "istranslated");
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.isactive = UtilSql.getValue(result, "isactive");
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.language = UtilSql.getValue(result, "language");
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.adUserClient = "";
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.adOrgClient = "";
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.createdby = "";
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.trBgcolor = "";
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.totalCount = "";
        objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData);
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
    TranslationA4B7689C80B64900ADF1DF4692E8D59DData objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[] = new TranslationA4B7689C80B64900ADF1DF4692E8D59DData[vector.size()];
    vector.copyInto(objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData);
    return(objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData);
  }

/**
Create a registry
 */
  public static TranslationA4B7689C80B64900ADF1DF4692E8D59DData[] set(String zssiTradeareaId, String zssiTradeareaTrlId, String adLanguage, String isactive, String createdby, String createdbyr, String istranslated, String updatedby, String updatedbyr, String adOrgId, String text, String adClientId)    throws ServletException {
    TranslationA4B7689C80B64900ADF1DF4692E8D59DData objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[] = new TranslationA4B7689C80B64900ADF1DF4692E8D59DData[1];
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0] = new TranslationA4B7689C80B64900ADF1DF4692E8D59DData();
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0].created = "";
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0].createdbyr = createdbyr;
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0].updated = "";
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0].updatedTimeStamp = "";
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0].updatedby = updatedby;
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0].updatedbyr = updatedbyr;
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0].zssiTradeareaTrlId = zssiTradeareaTrlId;
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0].adClientId = adClientId;
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0].adClientIdr = "";
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0].zssiTradeareaId = zssiTradeareaId;
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0].adOrgId = adOrgId;
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0].adOrgIdr = "";
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0].adLanguage = adLanguage;
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0].adLanguager = "";
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0].text = text;
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0].istranslated = istranslated;
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0].isactive = isactive;
    objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData[0].language = "";
    return objectTranslationA4B7689C80B64900ADF1DF4692E8D59DData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef06F7E1FFF5EB40A2809AD577703C4C89_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef9198B7B535F64B069B41F956720517F1_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT zssi_tradearea_trl.Zssi_Tradearea_ID AS NAME" +
      "        FROM zssi_tradearea_trl" +
      "        WHERE zssi_tradearea_trl.Zssi_Tradearea_Trl_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String zssiTradeareaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM zssi_tradearea left join (select Zssi_Tradearea_ID, Name from Zssi_Tradearea) table1 on (zssi_tradearea.Zssi_Tradearea_ID = table1.Zssi_Tradearea_ID) WHERE zssi_tradearea.Zssi_Tradearea_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String zssiTradeareaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM zssi_tradearea left join (select Zssi_Tradearea_ID, Name from Zssi_Tradearea) table1 on (zssi_tradearea.Zssi_Tradearea_ID = table1.Zssi_Tradearea_ID) WHERE zssi_tradearea.Zssi_Tradearea_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaId);

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
      "        UPDATE zssi_tradearea_trl" +
      "        SET Zssi_Tradearea_Trl_ID = (?) , AD_Client_ID = (?) , Zssi_Tradearea_ID = (?) , AD_Org_ID = (?) , AD_Language = (?) , Text = (?) , Istranslated = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_tradearea_trl.Zssi_Tradearea_Trl_ID = ? " +
      "                 AND zssi_tradearea_trl.Zssi_Tradearea_ID = ? " +
      "        AND zssi_tradearea_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_tradearea_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaId);
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
      "        INSERT INTO zssi_tradearea_trl " +
      "        (Zssi_Tradearea_Trl_ID, AD_Client_ID, Zssi_Tradearea_ID, AD_Org_ID, AD_Language, Text, Istranslated, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zssiTradeareaId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_tradearea_trl" +
      "        WHERE zssi_tradearea_trl.Zssi_Tradearea_Trl_ID = ? " +
      "                 AND zssi_tradearea_trl.Zssi_Tradearea_ID = ? " +
      "        AND zssi_tradearea_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_tradearea_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zssiTradeareaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_tradearea_trl" +
      "        WHERE zssi_tradearea_trl.Zssi_Tradearea_Trl_ID = ? " +
      "                 AND zssi_tradearea_trl.Zssi_Tradearea_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTradeareaId);

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
      "          FROM zssi_tradearea_trl" +
      "         WHERE zssi_tradearea_trl.Zssi_Tradearea_Trl_ID = ? ";

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
      "          FROM zssi_tradearea_trl" +
      "         WHERE zssi_tradearea_trl.Zssi_Tradearea_Trl_ID = ? ";

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
