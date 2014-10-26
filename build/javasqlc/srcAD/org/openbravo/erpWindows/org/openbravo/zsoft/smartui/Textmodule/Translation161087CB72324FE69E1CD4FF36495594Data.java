//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.Textmodule;

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
class Translation161087CB72324FE69E1CD4FF36495594Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Translation161087CB72324FE69E1CD4FF36495594Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssiTextmoduleTrlId;
  public String zssiTextmoduleId;
  public String zssiTextmoduleIdr;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String istranslated;
  public String adLanguage;
  public String adLanguager;
  public String isactive;
  public String text;
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
    else if (fieldName.equalsIgnoreCase("zssi_textmodule_trl_id") || fieldName.equals("zssiTextmoduleTrlId"))
      return zssiTextmoduleTrlId;
    else if (fieldName.equalsIgnoreCase("zssi_textmodule_id") || fieldName.equals("zssiTextmoduleId"))
      return zssiTextmoduleId;
    else if (fieldName.equalsIgnoreCase("zssi_textmodule_idr") || fieldName.equals("zssiTextmoduleIdr"))
      return zssiTextmoduleIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("istranslated"))
      return istranslated;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("text"))
      return text;
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
  public static Translation161087CB72324FE69E1CD4FF36495594Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssiTextmoduleId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zssiTextmoduleId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Translation161087CB72324FE69E1CD4FF36495594Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssiTextmoduleId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_textmodule_trl.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_textmodule_trl.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_textmodule_trl.Updated, ?) as updated, " +
      "        to_char(zssi_textmodule_trl.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_textmodule_trl.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_textmodule_trl.UpdatedBy) as UpdatedByR," +
      "        zssi_textmodule_trl.Zssi_Textmodule_Trl_ID, " +
      "zssi_textmodule_trl.Zssi_Textmodule_ID, " +
      "(CASE WHEN zssi_textmodule_trl.Zssi_Textmodule_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Position), ''))),'') ) END) AS Zssi_Textmodule_IDR, " +
      "zssi_textmodule_trl.AD_Client_ID, " +
      "(CASE WHEN zssi_textmodule_trl.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "zssi_textmodule_trl.AD_Org_ID, " +
      "(CASE WHEN zssi_textmodule_trl.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(zssi_textmodule_trl.Istranslated, 'N') AS Istranslated, " +
      "zssi_textmodule_trl.AD_Language, " +
      "(CASE WHEN zssi_textmodule_trl.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "COALESCE(zssi_textmodule_trl.Isactive, 'N') AS Isactive, " +
      "zssi_textmodule_trl.Text, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_textmodule_trl left join (select Zssi_Textmodule_ID, Name, Position from Zssi_Textmodule) table1 on (zssi_textmodule_trl.Zssi_Textmodule_ID = table1.Zssi_Textmodule_ID) left join (select AD_Client_ID, Name from AD_Client) table2 on (zssi_textmodule_trl.AD_Client_ID = table2.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table3 on (zssi_textmodule_trl.AD_Org_ID = table3.AD_Org_ID) left join (select AD_Language, Name from AD_Language) table4 on (zssi_textmodule_trl.AD_Language =  table4.AD_Language)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zssiTextmoduleId==null || zssiTextmoduleId.equals(""))?"":"  AND zssi_textmodule_trl.Zssi_Textmodule_ID = ?  ");
    strSql = strSql + 
      "        AND zssi_textmodule_trl.Zssi_Textmodule_Trl_ID = ? " +
      "        AND zssi_textmodule_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_textmodule_trl.AD_Org_ID IN (";
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
      if (zssiTextmoduleId != null && !(zssiTextmoduleId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleId);
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
        Translation161087CB72324FE69E1CD4FF36495594Data objectTranslation161087CB72324FE69E1CD4FF36495594Data = new Translation161087CB72324FE69E1CD4FF36495594Data();
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.created = UtilSql.getValue(result, "created");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.updated = UtilSql.getValue(result, "updated");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.zssiTextmoduleTrlId = UtilSql.getValue(result, "zssi_textmodule_trl_id");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.zssiTextmoduleId = UtilSql.getValue(result, "zssi_textmodule_id");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.zssiTextmoduleIdr = UtilSql.getValue(result, "zssi_textmodule_idr");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.istranslated = UtilSql.getValue(result, "istranslated");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.adLanguage = UtilSql.getValue(result, "ad_language");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.isactive = UtilSql.getValue(result, "isactive");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.text = UtilSql.getValue(result, "text");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.language = UtilSql.getValue(result, "language");
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.adUserClient = "";
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.adOrgClient = "";
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.createdby = "";
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.trBgcolor = "";
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.totalCount = "";
        objectTranslation161087CB72324FE69E1CD4FF36495594Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTranslation161087CB72324FE69E1CD4FF36495594Data);
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
    Translation161087CB72324FE69E1CD4FF36495594Data objectTranslation161087CB72324FE69E1CD4FF36495594Data[] = new Translation161087CB72324FE69E1CD4FF36495594Data[vector.size()];
    vector.copyInto(objectTranslation161087CB72324FE69E1CD4FF36495594Data);
    return(objectTranslation161087CB72324FE69E1CD4FF36495594Data);
  }

/**
Create a registry
 */
  public static Translation161087CB72324FE69E1CD4FF36495594Data[] set(String zssiTextmoduleId, String adOrgId, String createdby, String createdbyr, String text, String zssiTextmoduleTrlId, String adLanguage, String isactive, String updatedby, String updatedbyr, String istranslated, String adClientId)    throws ServletException {
    Translation161087CB72324FE69E1CD4FF36495594Data objectTranslation161087CB72324FE69E1CD4FF36495594Data[] = new Translation161087CB72324FE69E1CD4FF36495594Data[1];
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0] = new Translation161087CB72324FE69E1CD4FF36495594Data();
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].created = "";
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].createdbyr = createdbyr;
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].updated = "";
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].updatedTimeStamp = "";
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].updatedby = updatedby;
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].updatedbyr = updatedbyr;
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].zssiTextmoduleTrlId = zssiTextmoduleTrlId;
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].zssiTextmoduleId = zssiTextmoduleId;
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].zssiTextmoduleIdr = "";
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].adClientId = adClientId;
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].adClientIdr = "";
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].adOrgId = adOrgId;
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].adOrgIdr = "";
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].istranslated = istranslated;
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].adLanguage = adLanguage;
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].adLanguager = "";
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].isactive = isactive;
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].text = text;
    objectTranslation161087CB72324FE69E1CD4FF36495594Data[0].language = "";
    return objectTranslation161087CB72324FE69E1CD4FF36495594Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefB3A270171B96473A87B6670F108299BD_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef7C38D615AA944865853512AF0EE7C35C_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT zssi_textmodule_trl.Zssi_Textmodule_ID AS NAME" +
      "        FROM zssi_textmodule_trl" +
      "        WHERE zssi_textmodule_trl.Zssi_Textmodule_Trl_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String zssiTextmoduleId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Position), ''))) AS NAME FROM zssi_textmodule left join (select Zssi_Textmodule_ID, Name, Position from Zssi_Textmodule) table1 on (zssi_textmodule.Zssi_Textmodule_ID = table1.Zssi_Textmodule_ID) WHERE zssi_textmodule.Zssi_Textmodule_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String zssiTextmoduleId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Position), ''))) AS NAME FROM zssi_textmodule left join (select Zssi_Textmodule_ID, Name, Position from Zssi_Textmodule) table1 on (zssi_textmodule.Zssi_Textmodule_ID = table1.Zssi_Textmodule_ID) WHERE zssi_textmodule.Zssi_Textmodule_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleId);

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
      "        UPDATE zssi_textmodule_trl" +
      "        SET Zssi_Textmodule_Trl_ID = (?) , Zssi_Textmodule_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Istranslated = (?) , AD_Language = (?) , Isactive = (?) , Text = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_textmodule_trl.Zssi_Textmodule_Trl_ID = ? " +
      "                 AND zssi_textmodule_trl.Zssi_Textmodule_ID = ? " +
      "        AND zssi_textmodule_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_textmodule_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleId);
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
      "        INSERT INTO zssi_textmodule_trl " +
      "        (Zssi_Textmodule_Trl_ID, Zssi_Textmodule_ID, AD_Client_ID, AD_Org_ID, Istranslated, AD_Language, Isactive, Text, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zssiTextmoduleId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_textmodule_trl" +
      "        WHERE zssi_textmodule_trl.Zssi_Textmodule_Trl_ID = ? " +
      "                 AND zssi_textmodule_trl.Zssi_Textmodule_ID = ? " +
      "        AND zssi_textmodule_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_textmodule_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zssiTextmoduleId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_textmodule_trl" +
      "        WHERE zssi_textmodule_trl.Zssi_Textmodule_Trl_ID = ? " +
      "                 AND zssi_textmodule_trl.Zssi_Textmodule_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleId);

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
      "          FROM zssi_textmodule_trl" +
      "         WHERE zssi_textmodule_trl.Zssi_Textmodule_Trl_ID = ? ";

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
      "          FROM zssi_textmodule_trl" +
      "         WHERE zssi_textmodule_trl.Zssi_Textmodule_Trl_ID = ? ";

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
