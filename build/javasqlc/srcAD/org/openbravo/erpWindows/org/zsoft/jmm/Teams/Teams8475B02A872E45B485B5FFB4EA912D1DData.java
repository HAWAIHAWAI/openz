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
class Teams8475B02A872E45B485B5FFB4EA912D1DData implements FieldProvider {
static Logger log4j = Logger.getLogger(Teams8475B02A872E45B485B5FFB4EA912D1DData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String juwimmTeamId;
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
    else if (fieldName.equalsIgnoreCase("juwimm_team_id") || fieldName.equals("juwimmTeamId"))
      return juwimmTeamId;
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
  public static Teams8475B02A872E45B485B5FFB4EA912D1DData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Teams8475B02A872E45B485B5FFB4EA912D1DData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(juwimm_team.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = juwimm_team.CreatedBy) as CreatedByR, " +
      "        to_char(juwimm_team.Updated, ?) as updated, " +
      "        to_char(juwimm_team.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        juwimm_team.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = juwimm_team.UpdatedBy) as UpdatedByR," +
      "        juwimm_team.Juwimm_Team_ID, " +
      "juwimm_team.AD_Client_ID, " +
      "(CASE WHEN juwimm_team.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "juwimm_team.AD_Org_ID, " +
      "(CASE WHEN juwimm_team.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "juwimm_team.Name, " +
      "juwimm_team.Description, " +
      "COALESCE(juwimm_team.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM juwimm_team left join (select AD_Client_ID, Name from AD_Client) table1 on (juwimm_team.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (juwimm_team.AD_Org_ID = table2.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND juwimm_team.Juwimm_Team_ID = ? " +
      "        AND juwimm_team.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND juwimm_team.AD_Org_ID IN (";
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
        Teams8475B02A872E45B485B5FFB4EA912D1DData objectTeams8475B02A872E45B485B5FFB4EA912D1DData = new Teams8475B02A872E45B485B5FFB4EA912D1DData();
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.created = UtilSql.getValue(result, "created");
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.updated = UtilSql.getValue(result, "updated");
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.juwimmTeamId = UtilSql.getValue(result, "juwimm_team_id");
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.name = UtilSql.getValue(result, "name");
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.description = UtilSql.getValue(result, "description");
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.isactive = UtilSql.getValue(result, "isactive");
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.language = UtilSql.getValue(result, "language");
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.adUserClient = "";
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.adOrgClient = "";
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.createdby = "";
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.trBgcolor = "";
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.totalCount = "";
        objectTeams8475B02A872E45B485B5FFB4EA912D1DData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTeams8475B02A872E45B485B5FFB4EA912D1DData);
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
    Teams8475B02A872E45B485B5FFB4EA912D1DData objectTeams8475B02A872E45B485B5FFB4EA912D1DData[] = new Teams8475B02A872E45B485B5FFB4EA912D1DData[vector.size()];
    vector.copyInto(objectTeams8475B02A872E45B485B5FFB4EA912D1DData);
    return(objectTeams8475B02A872E45B485B5FFB4EA912D1DData);
  }

/**
Create a registry
 */
  public static Teams8475B02A872E45B485B5FFB4EA912D1DData[] set(String name, String juwimmTeamId, String adClientId, String description, String createdby, String createdbyr, String updatedby, String updatedbyr, String adOrgId, String isactive)    throws ServletException {
    Teams8475B02A872E45B485B5FFB4EA912D1DData objectTeams8475B02A872E45B485B5FFB4EA912D1DData[] = new Teams8475B02A872E45B485B5FFB4EA912D1DData[1];
    objectTeams8475B02A872E45B485B5FFB4EA912D1DData[0] = new Teams8475B02A872E45B485B5FFB4EA912D1DData();
    objectTeams8475B02A872E45B485B5FFB4EA912D1DData[0].created = "";
    objectTeams8475B02A872E45B485B5FFB4EA912D1DData[0].createdbyr = createdbyr;
    objectTeams8475B02A872E45B485B5FFB4EA912D1DData[0].updated = "";
    objectTeams8475B02A872E45B485B5FFB4EA912D1DData[0].updatedTimeStamp = "";
    objectTeams8475B02A872E45B485B5FFB4EA912D1DData[0].updatedby = updatedby;
    objectTeams8475B02A872E45B485B5FFB4EA912D1DData[0].updatedbyr = updatedbyr;
    objectTeams8475B02A872E45B485B5FFB4EA912D1DData[0].juwimmTeamId = juwimmTeamId;
    objectTeams8475B02A872E45B485B5FFB4EA912D1DData[0].adClientId = adClientId;
    objectTeams8475B02A872E45B485B5FFB4EA912D1DData[0].adClientIdr = "";
    objectTeams8475B02A872E45B485B5FFB4EA912D1DData[0].adOrgId = adOrgId;
    objectTeams8475B02A872E45B485B5FFB4EA912D1DData[0].adOrgIdr = "";
    objectTeams8475B02A872E45B485B5FFB4EA912D1DData[0].name = name;
    objectTeams8475B02A872E45B485B5FFB4EA912D1DData[0].description = description;
    objectTeams8475B02A872E45B485B5FFB4EA912D1DData[0].isactive = isactive;
    objectTeams8475B02A872E45B485B5FFB4EA912D1DData[0].language = "";
    return objectTeams8475B02A872E45B485B5FFB4EA912D1DData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefCA8DCC0257A7439B8D8D067BA35BD19E_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefD90AE445DAAB466F9BA76693B1346EE2_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE juwimm_team" +
      "        SET Juwimm_Team_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Name = (?) , Description = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE juwimm_team.Juwimm_Team_ID = ? " +
      "        AND juwimm_team.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND juwimm_team.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
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
      "        INSERT INTO juwimm_team " +
      "        (Juwimm_Team_ID, AD_Client_ID, AD_Org_ID, Name, Description, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamId);
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
      "        DELETE FROM juwimm_team" +
      "        WHERE juwimm_team.Juwimm_Team_ID = ? " +
      "        AND juwimm_team.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND juwimm_team.AD_Org_ID IN (";
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
      "        DELETE FROM juwimm_team" +
      "        WHERE juwimm_team.Juwimm_Team_ID = ? ";

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
      "          FROM juwimm_team" +
      "         WHERE juwimm_team.Juwimm_Team_ID = ? ";

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
      "          FROM juwimm_team" +
      "         WHERE juwimm_team.Juwimm_Team_ID = ? ";

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
