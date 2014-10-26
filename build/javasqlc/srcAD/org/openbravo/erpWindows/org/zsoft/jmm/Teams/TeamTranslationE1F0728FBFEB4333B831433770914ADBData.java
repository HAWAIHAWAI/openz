//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.zsoft.jmm.Teams;

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
class TeamTranslationE1F0728FBFEB4333B831433770914ADBData implements FieldProvider {
static Logger log4j = Logger.getLogger(TeamTranslationE1F0728FBFEB4333B831433770914ADBData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String juwimmTeamTrlId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String juwimmTeamId;
  public String juwimmTeamIdr;
  public String adLanguage;
  public String adLanguager;
  public String name;
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
    else if (fieldName.equalsIgnoreCase("juwimm_team_trl_id") || fieldName.equals("juwimmTeamTrlId"))
      return juwimmTeamTrlId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("juwimm_team_id") || fieldName.equals("juwimmTeamId"))
      return juwimmTeamId;
    else if (fieldName.equalsIgnoreCase("juwimm_team_idr") || fieldName.equals("juwimmTeamIdr"))
      return juwimmTeamIdr;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
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
  public static TeamTranslationE1F0728FBFEB4333B831433770914ADBData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String juwimmTeamId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, juwimmTeamId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TeamTranslationE1F0728FBFEB4333B831433770914ADBData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String juwimmTeamId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(juwimm_team_trl.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = juwimm_team_trl.CreatedBy) as CreatedByR, " +
      "        to_char(juwimm_team_trl.Updated, ?) as updated, " +
      "        to_char(juwimm_team_trl.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        juwimm_team_trl.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = juwimm_team_trl.UpdatedBy) as UpdatedByR," +
      "        juwimm_team_trl.Juwimm_Team_Trl_ID, " +
      "juwimm_team_trl.AD_Client_ID, " +
      "(CASE WHEN juwimm_team_trl.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "juwimm_team_trl.AD_Org_ID, " +
      "(CASE WHEN juwimm_team_trl.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "juwimm_team_trl.Juwimm_Team_ID, " +
      "(CASE WHEN juwimm_team_trl.Juwimm_Team_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS Juwimm_Team_IDR, " +
      "juwimm_team_trl.AD_Language, " +
      "(CASE WHEN juwimm_team_trl.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "juwimm_team_trl.Name, " +
      "COALESCE(juwimm_team_trl.Istranslated, 'N') AS Istranslated, " +
      "COALESCE(juwimm_team_trl.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM juwimm_team_trl left join (select AD_Client_ID, Name from AD_Client) table1 on (juwimm_team_trl.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (juwimm_team_trl.AD_Org_ID = table2.AD_Org_ID) left join (select Juwimm_Team_ID, Name from Juwimm_Team) table3 on (juwimm_team_trl.Juwimm_Team_ID = table3.Juwimm_Team_ID) left join (select Juwimm_Team_ID,AD_Language, Name from juwimm_team_TRL) tableTRL3 on (table3.Juwimm_Team_ID = tableTRL3.Juwimm_Team_ID and tableTRL3.AD_Language = ?)  left join (select AD_Language, Name from AD_Language) table4 on (juwimm_team_trl.AD_Language =  table4.AD_Language)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((juwimmTeamId==null || juwimmTeamId.equals(""))?"":"  AND juwimm_team_trl.Juwimm_Team_ID = ?  ");
    strSql = strSql + 
      "        AND juwimm_team_trl.Juwimm_Team_Trl_ID = ? " +
      "        AND juwimm_team_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND juwimm_team_trl.AD_Org_ID IN (";
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
      if (juwimmTeamId != null && !(juwimmTeamId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamId);
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
        TeamTranslationE1F0728FBFEB4333B831433770914ADBData objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData = new TeamTranslationE1F0728FBFEB4333B831433770914ADBData();
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.created = UtilSql.getValue(result, "created");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.updated = UtilSql.getValue(result, "updated");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.juwimmTeamTrlId = UtilSql.getValue(result, "juwimm_team_trl_id");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.juwimmTeamId = UtilSql.getValue(result, "juwimm_team_id");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.juwimmTeamIdr = UtilSql.getValue(result, "juwimm_team_idr");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.name = UtilSql.getValue(result, "name");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.istranslated = UtilSql.getValue(result, "istranslated");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.isactive = UtilSql.getValue(result, "isactive");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.language = UtilSql.getValue(result, "language");
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.adUserClient = "";
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.adOrgClient = "";
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.createdby = "";
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.trBgcolor = "";
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.totalCount = "";
        objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData);
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
    TeamTranslationE1F0728FBFEB4333B831433770914ADBData objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[] = new TeamTranslationE1F0728FBFEB4333B831433770914ADBData[vector.size()];
    vector.copyInto(objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData);
    return(objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData);
  }

/**
Create a registry
 */
  public static TeamTranslationE1F0728FBFEB4333B831433770914ADBData[] set(String juwimmTeamId, String updatedby, String updatedbyr, String istranslated, String adClientId, String adOrgId, String createdby, String createdbyr, String juwimmTeamTrlId, String name, String adLanguage, String isactive)    throws ServletException {
    TeamTranslationE1F0728FBFEB4333B831433770914ADBData objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[] = new TeamTranslationE1F0728FBFEB4333B831433770914ADBData[1];
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0] = new TeamTranslationE1F0728FBFEB4333B831433770914ADBData();
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].created = "";
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].createdbyr = createdbyr;
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].updated = "";
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].updatedTimeStamp = "";
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].updatedby = updatedby;
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].updatedbyr = updatedbyr;
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].juwimmTeamTrlId = juwimmTeamTrlId;
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].adClientId = adClientId;
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].adClientIdr = "";
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].adOrgId = adOrgId;
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].adOrgIdr = "";
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].juwimmTeamId = juwimmTeamId;
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].juwimmTeamIdr = "";
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].adLanguage = adLanguage;
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].adLanguager = "";
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].name = name;
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].istranslated = istranslated;
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].isactive = isactive;
    objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData[0].language = "";
    return objectTeamTranslationE1F0728FBFEB4333B831433770914ADBData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1B9D6FE592894355815DE864ABEC451F_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef5DB40466B81D42839F1C1DF921ED57A4_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT juwimm_team_trl.Juwimm_Team_ID AS NAME" +
      "        FROM juwimm_team_trl" +
      "        WHERE juwimm_team_trl.Juwimm_Team_Trl_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String juwimmTeamId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM juwimm_team left join (select Juwimm_Team_ID, Name from Juwimm_Team) table1 on (juwimm_team.Juwimm_Team_ID = table1.Juwimm_Team_ID) left join (select Juwimm_Team_ID,AD_Language, Name from juwimm_team_TRL) tableTRL1 on (table1.Juwimm_Team_ID = tableTRL1.Juwimm_Team_ID and tableTRL1.AD_Language = ?)  WHERE juwimm_team.Juwimm_Team_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String juwimmTeamId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM juwimm_team left join (select Juwimm_Team_ID, Name from Juwimm_Team) table1 on (juwimm_team.Juwimm_Team_ID = table1.Juwimm_Team_ID) left join (select Juwimm_Team_ID,AD_Language, Name from juwimm_team_TRL) tableTRL1 on (table1.Juwimm_Team_ID = tableTRL1.Juwimm_Team_ID and tableTRL1.AD_Language = ?)  WHERE juwimm_team.Juwimm_Team_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamId);

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
      "        UPDATE juwimm_team_trl" +
      "        SET Juwimm_Team_Trl_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Juwimm_Team_ID = (?) , AD_Language = (?) , Name = (?) , Istranslated = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE juwimm_team_trl.Juwimm_Team_Trl_ID = ? " +
      "                 AND juwimm_team_trl.Juwimm_Team_ID = ? " +
      "        AND juwimm_team_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND juwimm_team_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamId);
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
      "        INSERT INTO juwimm_team_trl " +
      "        (Juwimm_Team_Trl_ID, AD_Client_ID, AD_Org_ID, Juwimm_Team_ID, AD_Language, Name, Istranslated, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String juwimmTeamId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM juwimm_team_trl" +
      "        WHERE juwimm_team_trl.Juwimm_Team_Trl_ID = ? " +
      "                 AND juwimm_team_trl.Juwimm_Team_ID = ? " +
      "        AND juwimm_team_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND juwimm_team_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String juwimmTeamId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM juwimm_team_trl" +
      "        WHERE juwimm_team_trl.Juwimm_Team_Trl_ID = ? " +
      "                 AND juwimm_team_trl.Juwimm_Team_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamId);

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
      "          FROM juwimm_team_trl" +
      "         WHERE juwimm_team_trl.Juwimm_Team_Trl_ID = ? ";

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
      "          FROM juwimm_team_trl" +
      "         WHERE juwimm_team_trl.Juwimm_Team_Trl_ID = ? ";

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
