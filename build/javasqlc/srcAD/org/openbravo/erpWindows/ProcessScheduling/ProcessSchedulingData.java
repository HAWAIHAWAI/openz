//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ProcessScheduling;

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
class ProcessSchedulingData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProcessSchedulingData.class);
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
  public String adProcessId;
  public String adProcessIdr;
  public String description;
  public String weekday;
  public String weekdayr;
  public String timefrom;
  public String timeto;
  public String isfulltime;
  public String adProcessSchedulingId;
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
    else if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
    else if (fieldName.equalsIgnoreCase("ad_process_idr") || fieldName.equals("adProcessIdr"))
      return adProcessIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("weekday"))
      return weekday;
    else if (fieldName.equalsIgnoreCase("weekdayr"))
      return weekdayr;
    else if (fieldName.equalsIgnoreCase("timefrom"))
      return timefrom;
    else if (fieldName.equalsIgnoreCase("timeto"))
      return timeto;
    else if (fieldName.equalsIgnoreCase("isfulltime"))
      return isfulltime;
    else if (fieldName.equalsIgnoreCase("ad_process_scheduling_id") || fieldName.equals("adProcessSchedulingId"))
      return adProcessSchedulingId;
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
  public static ProcessSchedulingData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ProcessSchedulingData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Process_Scheduling.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Process_Scheduling.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Process_Scheduling.Updated, ?) as updated, " +
      "        to_char(AD_Process_Scheduling.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Process_Scheduling.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Process_Scheduling.UpdatedBy) as UpdatedByR," +
      "        AD_Process_Scheduling.AD_Client_ID, " +
      "(CASE WHEN AD_Process_Scheduling.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Process_Scheduling.AD_Org_ID, " +
      "(CASE WHEN AD_Process_Scheduling.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(AD_Process_Scheduling.IsActive, 'N') AS IsActive, " +
      "AD_Process_Scheduling.AD_Process_ID, " +
      "(CASE WHEN AD_Process_Scheduling.AD_Process_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS AD_Process_IDR, " +
      "AD_Process_Scheduling.Description, " +
      "AD_Process_Scheduling.WeekDay, " +
      "(CASE WHEN AD_Process_Scheduling.WeekDay IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS WeekDayR, " +
      "TO_CHAR(AD_Process_Scheduling.TimeFrom, 'HH24:MI:SS') AS TimeFrom, " +
      "TO_CHAR(AD_Process_Scheduling.TimeTo, 'HH24:MI:SS') AS TimeTo, " +
      "COALESCE(AD_Process_Scheduling.IsFullTime, 'N') AS IsFullTime, " +
      "AD_Process_Scheduling.AD_Process_Scheduling_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Process_Scheduling left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Process_Scheduling.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_Process_Scheduling.AD_Org_ID = table2.AD_Org_ID) left join (select AD_Process_ID, Name from AD_Process) table3 on (AD_Process_Scheduling.AD_Process_ID = table3.AD_Process_ID) left join (select AD_Process_ID,AD_Language, Name from AD_Process_TRL) tableTRL3 on (table3.AD_Process_ID = tableTRL3.AD_Process_ID and tableTRL3.AD_Language = ?)  left join ad_ref_list_v list1 on (AD_Process_Scheduling.WeekDay = list1.value and list1.ad_reference_id = '167' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND AD_Process_Scheduling.AD_Process_Scheduling_ID = ? " +
      "        AND AD_Process_Scheduling.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Process_Scheduling.AD_Org_ID IN (";
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
        ProcessSchedulingData objectProcessSchedulingData = new ProcessSchedulingData();
        objectProcessSchedulingData.created = UtilSql.getValue(result, "created");
        objectProcessSchedulingData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectProcessSchedulingData.updated = UtilSql.getValue(result, "updated");
        objectProcessSchedulingData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectProcessSchedulingData.updatedby = UtilSql.getValue(result, "updatedby");
        objectProcessSchedulingData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectProcessSchedulingData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProcessSchedulingData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectProcessSchedulingData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProcessSchedulingData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectProcessSchedulingData.isactive = UtilSql.getValue(result, "isactive");
        objectProcessSchedulingData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectProcessSchedulingData.adProcessIdr = UtilSql.getValue(result, "ad_process_idr");
        objectProcessSchedulingData.description = UtilSql.getValue(result, "description");
        objectProcessSchedulingData.weekday = UtilSql.getValue(result, "weekday");
        objectProcessSchedulingData.weekdayr = UtilSql.getValue(result, "weekdayr");
        objectProcessSchedulingData.timefrom = UtilSql.getValue(result, "timefrom");
        objectProcessSchedulingData.timeto = UtilSql.getValue(result, "timeto");
        objectProcessSchedulingData.isfulltime = UtilSql.getValue(result, "isfulltime");
        objectProcessSchedulingData.adProcessSchedulingId = UtilSql.getValue(result, "ad_process_scheduling_id");
        objectProcessSchedulingData.language = UtilSql.getValue(result, "language");
        objectProcessSchedulingData.adUserClient = "";
        objectProcessSchedulingData.adOrgClient = "";
        objectProcessSchedulingData.createdby = "";
        objectProcessSchedulingData.trBgcolor = "";
        objectProcessSchedulingData.totalCount = "";
        objectProcessSchedulingData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProcessSchedulingData);
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
    ProcessSchedulingData objectProcessSchedulingData[] = new ProcessSchedulingData[vector.size()];
    vector.copyInto(objectProcessSchedulingData);
    return(objectProcessSchedulingData);
  }

/**
Create a registry
 */
  public static ProcessSchedulingData[] set(String adProcessSchedulingId, String isactive, String timefrom, String createdby, String createdbyr, String updatedby, String updatedbyr, String description, String weekday, String adClientId, String isfulltime, String adOrgId, String adProcessId, String timeto)    throws ServletException {
    ProcessSchedulingData objectProcessSchedulingData[] = new ProcessSchedulingData[1];
    objectProcessSchedulingData[0] = new ProcessSchedulingData();
    objectProcessSchedulingData[0].created = "";
    objectProcessSchedulingData[0].createdbyr = createdbyr;
    objectProcessSchedulingData[0].updated = "";
    objectProcessSchedulingData[0].updatedTimeStamp = "";
    objectProcessSchedulingData[0].updatedby = updatedby;
    objectProcessSchedulingData[0].updatedbyr = updatedbyr;
    objectProcessSchedulingData[0].adClientId = adClientId;
    objectProcessSchedulingData[0].adClientIdr = "";
    objectProcessSchedulingData[0].adOrgId = adOrgId;
    objectProcessSchedulingData[0].adOrgIdr = "";
    objectProcessSchedulingData[0].isactive = isactive;
    objectProcessSchedulingData[0].adProcessId = adProcessId;
    objectProcessSchedulingData[0].adProcessIdr = "";
    objectProcessSchedulingData[0].description = description;
    objectProcessSchedulingData[0].weekday = weekday;
    objectProcessSchedulingData[0].weekdayr = "";
    objectProcessSchedulingData[0].timefrom = timefrom;
    objectProcessSchedulingData[0].timeto = timeto;
    objectProcessSchedulingData[0].isfulltime = isfulltime;
    objectProcessSchedulingData[0].adProcessSchedulingId = adProcessSchedulingId;
    objectProcessSchedulingData[0].language = "";
    return objectProcessSchedulingData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef800704_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef800706_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        UPDATE AD_Process_Scheduling" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , IsActive = (?) , AD_Process_ID = (?) , Description = (?) , WeekDay = (?) , TimeFrom = TO_TIMESTAMP(?,'HH24:MI:SS') , TimeTo = TO_TIMESTAMP(?,'HH24:MI:SS') , IsFullTime = (?) , AD_Process_Scheduling_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Process_Scheduling.AD_Process_Scheduling_ID = ? " +
      "        AND AD_Process_Scheduling.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Process_Scheduling.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weekday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timeto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfulltime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessSchedulingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessSchedulingId);
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
      "        INSERT INTO AD_Process_Scheduling " +
      "        (AD_Client_ID, AD_Org_ID, IsActive, AD_Process_ID, Description, WeekDay, TimeFrom, TimeTo, IsFullTime, AD_Process_Scheduling_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_TIMESTAMP(?, 'HH24:MI:SS'), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weekday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timeto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfulltime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessSchedulingId);
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
      "        DELETE FROM AD_Process_Scheduling" +
      "        WHERE AD_Process_Scheduling.AD_Process_Scheduling_ID = ? " +
      "        AND AD_Process_Scheduling.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Process_Scheduling.AD_Org_ID IN (";
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
      "        DELETE FROM AD_Process_Scheduling" +
      "        WHERE AD_Process_Scheduling.AD_Process_Scheduling_ID = ? ";

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
      "          FROM AD_Process_Scheduling" +
      "         WHERE AD_Process_Scheduling.AD_Process_Scheduling_ID = ? ";

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
      "          FROM AD_Process_Scheduling" +
      "         WHERE AD_Process_Scheduling.AD_Process_Scheduling_ID = ? ";

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
