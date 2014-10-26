//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.DepartmentsAreas;

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
class Translation50252C0870B240EE9921D1D0911517EBData implements FieldProvider {
static Logger log4j = Logger.getLogger(Translation50252C0870B240EE9921D1D0911517EBData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cUserDepartmentTrlId;
  public String cUserDepartmentId;
  public String cUserDepartmentIdr;
  public String adClientId;
  public String adLanguage;
  public String adLanguager;
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
    else if (fieldName.equalsIgnoreCase("c_user_department_trl_id") || fieldName.equals("cUserDepartmentTrlId"))
      return cUserDepartmentTrlId;
    else if (fieldName.equalsIgnoreCase("c_user_department_id") || fieldName.equals("cUserDepartmentId"))
      return cUserDepartmentId;
    else if (fieldName.equalsIgnoreCase("c_user_department_idr") || fieldName.equals("cUserDepartmentIdr"))
      return cUserDepartmentIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
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
  public static Translation50252C0870B240EE9921D1D0911517EBData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cUserDepartmentId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cUserDepartmentId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Translation50252C0870B240EE9921D1D0911517EBData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cUserDepartmentId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_User_Department_trl.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_User_Department_trl.CreatedBy) as CreatedByR, " +
      "        to_char(C_User_Department_trl.Updated, ?) as updated, " +
      "        to_char(C_User_Department_trl.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_User_Department_trl.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_User_Department_trl.UpdatedBy) as UpdatedByR," +
      "        C_User_Department_trl.C_User_Department_Trl_ID, " +
      "C_User_Department_trl.C_User_Department_ID, " +
      "(CASE WHEN C_User_Department_trl.C_User_Department_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS C_User_Department_IDR, " +
      "C_User_Department_trl.AD_Client_ID, " +
      "C_User_Department_trl.AD_Language, " +
      "(CASE WHEN C_User_Department_trl.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "C_User_Department_trl.Name, " +
      "C_User_Department_trl.AD_Org_ID, " +
      "COALESCE(C_User_Department_trl.Isactive, 'N') AS Isactive, " +
      "COALESCE(C_User_Department_trl.Istranslated, 'N') AS Istranslated, " +
      "        ? AS LANGUAGE " +
      "        FROM C_User_Department_trl left join (select C_User_Department_ID, Name from C_User_Department) table1 on (C_User_Department_trl.C_User_Department_ID = table1.C_User_Department_ID) left join (select C_User_Department_ID,AD_Language, Name from C_User_Department_TRL) tableTRL1 on (table1.C_User_Department_ID = tableTRL1.C_User_Department_ID and tableTRL1.AD_Language = ?)  left join (select AD_Language, Name from AD_Language) table2 on (C_User_Department_trl.AD_Language =  table2.AD_Language)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cUserDepartmentId==null || cUserDepartmentId.equals(""))?"":"  AND C_User_Department_trl.C_User_Department_ID = ?  ");
    strSql = strSql + 
      "        AND C_User_Department_trl.C_User_Department_Trl_ID = ? " +
      "        AND C_User_Department_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_User_Department_trl.AD_Org_ID IN (";
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
      if (cUserDepartmentId != null && !(cUserDepartmentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentId);
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
        Translation50252C0870B240EE9921D1D0911517EBData objectTranslation50252C0870B240EE9921D1D0911517EBData = new Translation50252C0870B240EE9921D1D0911517EBData();
        objectTranslation50252C0870B240EE9921D1D0911517EBData.created = UtilSql.getValue(result, "created");
        objectTranslation50252C0870B240EE9921D1D0911517EBData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTranslation50252C0870B240EE9921D1D0911517EBData.updated = UtilSql.getValue(result, "updated");
        objectTranslation50252C0870B240EE9921D1D0911517EBData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTranslation50252C0870B240EE9921D1D0911517EBData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTranslation50252C0870B240EE9921D1D0911517EBData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTranslation50252C0870B240EE9921D1D0911517EBData.cUserDepartmentTrlId = UtilSql.getValue(result, "c_user_department_trl_id");
        objectTranslation50252C0870B240EE9921D1D0911517EBData.cUserDepartmentId = UtilSql.getValue(result, "c_user_department_id");
        objectTranslation50252C0870B240EE9921D1D0911517EBData.cUserDepartmentIdr = UtilSql.getValue(result, "c_user_department_idr");
        objectTranslation50252C0870B240EE9921D1D0911517EBData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTranslation50252C0870B240EE9921D1D0911517EBData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectTranslation50252C0870B240EE9921D1D0911517EBData.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectTranslation50252C0870B240EE9921D1D0911517EBData.name = UtilSql.getValue(result, "name");
        objectTranslation50252C0870B240EE9921D1D0911517EBData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTranslation50252C0870B240EE9921D1D0911517EBData.isactive = UtilSql.getValue(result, "isactive");
        objectTranslation50252C0870B240EE9921D1D0911517EBData.istranslated = UtilSql.getValue(result, "istranslated");
        objectTranslation50252C0870B240EE9921D1D0911517EBData.language = UtilSql.getValue(result, "language");
        objectTranslation50252C0870B240EE9921D1D0911517EBData.adUserClient = "";
        objectTranslation50252C0870B240EE9921D1D0911517EBData.adOrgClient = "";
        objectTranslation50252C0870B240EE9921D1D0911517EBData.createdby = "";
        objectTranslation50252C0870B240EE9921D1D0911517EBData.trBgcolor = "";
        objectTranslation50252C0870B240EE9921D1D0911517EBData.totalCount = "";
        objectTranslation50252C0870B240EE9921D1D0911517EBData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTranslation50252C0870B240EE9921D1D0911517EBData);
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
    Translation50252C0870B240EE9921D1D0911517EBData objectTranslation50252C0870B240EE9921D1D0911517EBData[] = new Translation50252C0870B240EE9921D1D0911517EBData[vector.size()];
    vector.copyInto(objectTranslation50252C0870B240EE9921D1D0911517EBData);
    return(objectTranslation50252C0870B240EE9921D1D0911517EBData);
  }

/**
Create a registry
 */
  public static Translation50252C0870B240EE9921D1D0911517EBData[] set(String cUserDepartmentId, String adClientId, String istranslated, String cUserDepartmentTrlId, String adLanguage, String adOrgId, String updatedby, String updatedbyr, String createdby, String createdbyr, String isactive, String name)    throws ServletException {
    Translation50252C0870B240EE9921D1D0911517EBData objectTranslation50252C0870B240EE9921D1D0911517EBData[] = new Translation50252C0870B240EE9921D1D0911517EBData[1];
    objectTranslation50252C0870B240EE9921D1D0911517EBData[0] = new Translation50252C0870B240EE9921D1D0911517EBData();
    objectTranslation50252C0870B240EE9921D1D0911517EBData[0].created = "";
    objectTranslation50252C0870B240EE9921D1D0911517EBData[0].createdbyr = createdbyr;
    objectTranslation50252C0870B240EE9921D1D0911517EBData[0].updated = "";
    objectTranslation50252C0870B240EE9921D1D0911517EBData[0].updatedTimeStamp = "";
    objectTranslation50252C0870B240EE9921D1D0911517EBData[0].updatedby = updatedby;
    objectTranslation50252C0870B240EE9921D1D0911517EBData[0].updatedbyr = updatedbyr;
    objectTranslation50252C0870B240EE9921D1D0911517EBData[0].cUserDepartmentTrlId = cUserDepartmentTrlId;
    objectTranslation50252C0870B240EE9921D1D0911517EBData[0].cUserDepartmentId = cUserDepartmentId;
    objectTranslation50252C0870B240EE9921D1D0911517EBData[0].cUserDepartmentIdr = "";
    objectTranslation50252C0870B240EE9921D1D0911517EBData[0].adClientId = adClientId;
    objectTranslation50252C0870B240EE9921D1D0911517EBData[0].adLanguage = adLanguage;
    objectTranslation50252C0870B240EE9921D1D0911517EBData[0].adLanguager = "";
    objectTranslation50252C0870B240EE9921D1D0911517EBData[0].name = name;
    objectTranslation50252C0870B240EE9921D1D0911517EBData[0].adOrgId = adOrgId;
    objectTranslation50252C0870B240EE9921D1D0911517EBData[0].isactive = isactive;
    objectTranslation50252C0870B240EE9921D1D0911517EBData[0].istranslated = istranslated;
    objectTranslation50252C0870B240EE9921D1D0911517EBData[0].language = "";
    return objectTranslation50252C0870B240EE9921D1D0911517EBData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef777EED95DD894512A88F86B32E102A50_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef87D3B38AA17B48BD9F2332FC30D852EF_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT C_User_Department_trl.C_User_Department_ID AS NAME" +
      "        FROM C_User_Department_trl" +
      "        WHERE C_User_Department_trl.C_User_Department_Trl_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String cUserDepartmentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_User_Department left join (select C_User_Department_ID, Name from C_User_Department) table1 on (C_User_Department.C_User_Department_ID = table1.C_User_Department_ID) left join (select C_User_Department_ID,AD_Language, Name from C_User_Department_TRL) tableTRL1 on (table1.C_User_Department_ID = tableTRL1.C_User_Department_ID and tableTRL1.AD_Language = ?)  WHERE C_User_Department.C_User_Department_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String cUserDepartmentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_User_Department left join (select C_User_Department_ID, Name from C_User_Department) table1 on (C_User_Department.C_User_Department_ID = table1.C_User_Department_ID) left join (select C_User_Department_ID,AD_Language, Name from C_User_Department_TRL) tableTRL1 on (table1.C_User_Department_ID = tableTRL1.C_User_Department_ID and tableTRL1.AD_Language = ?)  WHERE C_User_Department.C_User_Department_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentId);

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
      "        UPDATE C_User_Department_trl" +
      "        SET C_User_Department_Trl_ID = (?) , C_User_Department_ID = (?) , AD_Client_ID = (?) , AD_Language = (?) , Name = (?) , AD_Org_ID = (?) , Isactive = (?) , Istranslated = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_User_Department_trl.C_User_Department_Trl_ID = ? " +
      "                 AND C_User_Department_trl.C_User_Department_ID = ? " +
      "        AND C_User_Department_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_User_Department_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentId);
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
      "        INSERT INTO C_User_Department_trl " +
      "        (C_User_Department_Trl_ID, C_User_Department_ID, AD_Client_ID, AD_Language, Name, AD_Org_ID, Isactive, Istranslated, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cUserDepartmentId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_User_Department_trl" +
      "        WHERE C_User_Department_trl.C_User_Department_Trl_ID = ? " +
      "                 AND C_User_Department_trl.C_User_Department_ID = ? " +
      "        AND C_User_Department_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_User_Department_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cUserDepartmentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_User_Department_trl" +
      "        WHERE C_User_Department_trl.C_User_Department_Trl_ID = ? " +
      "                 AND C_User_Department_trl.C_User_Department_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentId);

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
      "          FROM C_User_Department_trl" +
      "         WHERE C_User_Department_trl.C_User_Department_Trl_ID = ? ";

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
      "          FROM C_User_Department_trl" +
      "         WHERE C_User_Department_trl.C_User_Department_Trl_ID = ? ";

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
