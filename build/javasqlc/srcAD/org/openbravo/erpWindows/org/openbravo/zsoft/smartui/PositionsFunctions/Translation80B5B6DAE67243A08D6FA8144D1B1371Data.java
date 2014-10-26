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
class Translation80B5B6DAE67243A08D6FA8144D1B1371Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Translation80B5B6DAE67243A08D6FA8144D1B1371Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cUserPositionTrlId;
  public String cUserPositionId;
  public String cUserPositionIdr;
  public String adLanguage;
  public String adLanguager;
  public String adClientId;
  public String name;
  public String adOrgId;
  public String isactive;
  public String istranslated;
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
    else if (fieldName.equalsIgnoreCase("c_user_position_trl_id") || fieldName.equals("cUserPositionTrlId"))
      return cUserPositionTrlId;
    else if (fieldName.equalsIgnoreCase("c_user_position_id") || fieldName.equals("cUserPositionId"))
      return cUserPositionId;
    else if (fieldName.equalsIgnoreCase("c_user_position_idr") || fieldName.equals("cUserPositionIdr"))
      return cUserPositionIdr;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("istranslated"))
      return istranslated;
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
  public static Translation80B5B6DAE67243A08D6FA8144D1B1371Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cUserPositionId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cUserPositionId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Translation80B5B6DAE67243A08D6FA8144D1B1371Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cUserPositionId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_user_position_trl.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_user_position_trl.CreatedBy) as CreatedByR, " +
      "        to_char(c_user_position_trl.Updated, ?) as updated, " +
      "        to_char(c_user_position_trl.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_user_position_trl.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_user_position_trl.UpdatedBy) as UpdatedByR," +
      "        c_user_position_trl.C_User_Position_Trl_ID, " +
      "c_user_position_trl.C_User_Position_ID, " +
      "(CASE WHEN c_user_position_trl.C_User_Position_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS C_User_Position_IDR, " +
      "c_user_position_trl.AD_Language, " +
      "(CASE WHEN c_user_position_trl.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "c_user_position_trl.AD_Client_ID, " +
      "c_user_position_trl.Name, " +
      "c_user_position_trl.AD_Org_ID, " +
      "COALESCE(c_user_position_trl.Isactive, 'N') AS Isactive, " +
      "COALESCE(c_user_position_trl.Istranslated, 'N') AS Istranslated, " +
      "        ? AS LANGUAGE " +
      "        FROM c_user_position_trl left join (select C_User_Position_ID, Name from C_User_Position) table1 on (c_user_position_trl.C_User_Position_ID = table1.C_User_Position_ID) left join (select C_User_Position_ID,AD_Language, Name from c_user_position_TRL) tableTRL1 on (table1.C_User_Position_ID = tableTRL1.C_User_Position_ID and tableTRL1.AD_Language = ?)  left join (select AD_Language, Name from AD_Language) table2 on (c_user_position_trl.AD_Language =  table2.AD_Language)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cUserPositionId==null || cUserPositionId.equals(""))?"":"  AND c_user_position_trl.C_User_Position_ID = ?  ");
    strSql = strSql + 
      "        AND c_user_position_trl.C_User_Position_Trl_ID = ? " +
      "        AND c_user_position_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_user_position_trl.AD_Org_ID IN (";
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
      if (cUserPositionId != null && !(cUserPositionId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserPositionId);
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
        Translation80B5B6DAE67243A08D6FA8144D1B1371Data objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data = new Translation80B5B6DAE67243A08D6FA8144D1B1371Data();
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.created = UtilSql.getValue(result, "created");
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.updated = UtilSql.getValue(result, "updated");
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.cUserPositionTrlId = UtilSql.getValue(result, "c_user_position_trl_id");
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.cUserPositionId = UtilSql.getValue(result, "c_user_position_id");
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.cUserPositionIdr = UtilSql.getValue(result, "c_user_position_idr");
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.adLanguage = UtilSql.getValue(result, "ad_language");
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.name = UtilSql.getValue(result, "name");
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.isactive = UtilSql.getValue(result, "isactive");
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.istranslated = UtilSql.getValue(result, "istranslated");
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.language = UtilSql.getValue(result, "language");
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.adUserClient = "";
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.adOrgClient = "";
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.createdby = "";
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.trBgcolor = "";
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.totalCount = "";
        objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data);
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
    Translation80B5B6DAE67243A08D6FA8144D1B1371Data objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[] = new Translation80B5B6DAE67243A08D6FA8144D1B1371Data[vector.size()];
    vector.copyInto(objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data);
    return(objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data);
  }

/**
Create a registry
 */
  public static Translation80B5B6DAE67243A08D6FA8144D1B1371Data[] set(String cUserPositionId, String createdby, String createdbyr, String name, String adLanguage, String adClientId, String isactive, String istranslated, String adOrgId, String updatedby, String updatedbyr, String cUserPositionTrlId)    throws ServletException {
    Translation80B5B6DAE67243A08D6FA8144D1B1371Data objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[] = new Translation80B5B6DAE67243A08D6FA8144D1B1371Data[1];
    objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[0] = new Translation80B5B6DAE67243A08D6FA8144D1B1371Data();
    objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[0].created = "";
    objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[0].createdbyr = createdbyr;
    objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[0].updated = "";
    objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[0].updatedTimeStamp = "";
    objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[0].updatedby = updatedby;
    objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[0].updatedbyr = updatedbyr;
    objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[0].cUserPositionTrlId = cUserPositionTrlId;
    objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[0].cUserPositionId = cUserPositionId;
    objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[0].cUserPositionIdr = "";
    objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[0].adLanguage = adLanguage;
    objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[0].adLanguager = "";
    objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[0].adClientId = adClientId;
    objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[0].name = name;
    objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[0].adOrgId = adOrgId;
    objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[0].isactive = isactive;
    objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[0].istranslated = istranslated;
    objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data[0].language = "";
    return objectTranslation80B5B6DAE67243A08D6FA8144D1B1371Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef305B947E379445DABF787B559C2EEFFD_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef7843D27F68F04C77AEE60EA1ABC90982_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT c_user_position_trl.C_User_Position_ID AS NAME" +
      "        FROM c_user_position_trl" +
      "        WHERE c_user_position_trl.C_User_Position_Trl_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String cUserPositionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM c_user_position left join (select C_User_Position_ID, Name from C_User_Position) table1 on (c_user_position.C_User_Position_ID = table1.C_User_Position_ID) left join (select C_User_Position_ID,AD_Language, Name from c_user_position_TRL) tableTRL1 on (table1.C_User_Position_ID = tableTRL1.C_User_Position_ID and tableTRL1.AD_Language = ?)  WHERE c_user_position.C_User_Position_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserPositionId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String cUserPositionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM c_user_position left join (select C_User_Position_ID, Name from C_User_Position) table1 on (c_user_position.C_User_Position_ID = table1.C_User_Position_ID) left join (select C_User_Position_ID,AD_Language, Name from c_user_position_TRL) tableTRL1 on (table1.C_User_Position_ID = tableTRL1.C_User_Position_ID and tableTRL1.AD_Language = ?)  WHERE c_user_position.C_User_Position_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserPositionId);

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
      "        UPDATE c_user_position_trl" +
      "        SET C_User_Position_Trl_ID = (?) , C_User_Position_ID = (?) , AD_Language = (?) , AD_Client_ID = (?) , Name = (?) , AD_Org_ID = (?) , Isactive = (?) , Istranslated = (?) , updated = now(), updatedby = ? " +
      "        WHERE c_user_position_trl.C_User_Position_Trl_ID = ? " +
      "                 AND c_user_position_trl.C_User_Position_ID = ? " +
      "        AND c_user_position_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_user_position_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserPositionTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserPositionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserPositionTrlId);
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
      "        INSERT INTO c_user_position_trl " +
      "        (C_User_Position_Trl_ID, C_User_Position_ID, AD_Language, AD_Client_ID, Name, AD_Org_ID, Isactive, Istranslated, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserPositionTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserPositionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cUserPositionId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_user_position_trl" +
      "        WHERE c_user_position_trl.C_User_Position_Trl_ID = ? " +
      "                 AND c_user_position_trl.C_User_Position_ID = ? " +
      "        AND c_user_position_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_user_position_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cUserPositionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_user_position_trl" +
      "        WHERE c_user_position_trl.C_User_Position_Trl_ID = ? " +
      "                 AND c_user_position_trl.C_User_Position_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserPositionId);

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
      "          FROM c_user_position_trl" +
      "         WHERE c_user_position_trl.C_User_Position_Trl_ID = ? ";

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
      "          FROM c_user_position_trl" +
      "         WHERE c_user_position_trl.C_User_Position_Trl_ID = ? ";

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
