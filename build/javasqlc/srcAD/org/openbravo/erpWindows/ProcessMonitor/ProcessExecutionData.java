//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ProcessMonitor;

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
class ProcessExecutionData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProcessExecutionData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adProcessRunId;
  public String adOrgId;
  public String adOrgIdr;
  public String adProcessId;
  public String adProcessIdr;
  public String adUserId;
  public String adUserIdr;
  public String isactive;
  public String startTime;
  public String endTime;
  public String runtime;
  public String status;
  public String statusr;
  public String channel;
  public String log;
  public String result;
  public String adProcessRequestId;
  public String report;
  public String params;
  public String isrolesecurity;
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
    else if (fieldName.equalsIgnoreCase("ad_process_run_id") || fieldName.equals("adProcessRunId"))
      return adProcessRunId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
    else if (fieldName.equalsIgnoreCase("ad_process_idr") || fieldName.equals("adProcessIdr"))
      return adProcessIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("start_time") || fieldName.equals("startTime"))
      return startTime;
    else if (fieldName.equalsIgnoreCase("end_time") || fieldName.equals("endTime"))
      return endTime;
    else if (fieldName.equalsIgnoreCase("runtime"))
      return runtime;
    else if (fieldName.equalsIgnoreCase("status"))
      return status;
    else if (fieldName.equalsIgnoreCase("statusr"))
      return statusr;
    else if (fieldName.equalsIgnoreCase("channel"))
      return channel;
    else if (fieldName.equalsIgnoreCase("log"))
      return log;
    else if (fieldName.equalsIgnoreCase("result"))
      return result;
    else if (fieldName.equalsIgnoreCase("ad_process_request_id") || fieldName.equals("adProcessRequestId"))
      return adProcessRequestId;
    else if (fieldName.equalsIgnoreCase("report"))
      return report;
    else if (fieldName.equalsIgnoreCase("params"))
      return params;
    else if (fieldName.equalsIgnoreCase("isrolesecurity"))
      return isrolesecurity;
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
  public static ProcessExecutionData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ProcessExecutionData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Process_Execution_V.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Process_Execution_V.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Process_Execution_V.Updated, ?) as updated, " +
      "        to_char(AD_Process_Execution_V.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Process_Execution_V.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Process_Execution_V.UpdatedBy) as UpdatedByR," +
      "        AD_Process_Execution_V.AD_Client_ID, " +
      "(CASE WHEN AD_Process_Execution_V.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Process_Execution_V.AD_Process_Run_ID, " +
      "AD_Process_Execution_V.AD_Org_ID, " +
      "(CASE WHEN AD_Process_Execution_V.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_Process_Execution_V.AD_Process_ID, " +
      "(CASE WHEN AD_Process_Execution_V.AD_Process_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS AD_Process_IDR, " +
      "AD_Process_Execution_V.AD_User_ID, " +
      "(CASE WHEN AD_Process_Execution_V.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "COALESCE(AD_Process_Execution_V.Isactive, 'N') AS Isactive, " +
      "AD_Process_Execution_V.Start_Time, " +
      "AD_Process_Execution_V.End_Time, " +
      "AD_Process_Execution_V.Runtime, " +
      "AD_Process_Execution_V.Status, " +
      "(CASE WHEN AD_Process_Execution_V.Status IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS StatusR, " +
      "AD_Process_Execution_V.Channel, " +
      "AD_Process_Execution_V.Log, " +
      "AD_Process_Execution_V.Result, " +
      "AD_Process_Execution_V.AD_Process_Request_ID, " +
      "AD_Process_Execution_V.Report, " +
      "AD_Process_Execution_V.Params, " +
      "COALESCE(AD_Process_Execution_V.Isrolesecurity, 'N') AS Isrolesecurity, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Process_Execution_V left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Process_Execution_V.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_Process_Execution_V.AD_Org_ID = table2.AD_Org_ID) left join (select AD_Process_ID, Name from AD_Process) table3 on (AD_Process_Execution_V.AD_Process_ID = table3.AD_Process_ID) left join (select AD_Process_ID,AD_Language, Name from AD_Process_TRL) tableTRL3 on (table3.AD_Process_ID = tableTRL3.AD_Process_ID and tableTRL3.AD_Language = ?)  left join (select AD_User_ID, Name from AD_User) table4 on (AD_Process_Execution_V.AD_User_ID = table4.AD_User_ID) left join ad_ref_list_v list1 on (AD_Process_Execution_V.Status = list1.value and list1.ad_reference_id = '7DB6D4792CDC4ED297C70A4F4282A52E' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND AD_Process_Execution_V.AD_Process_Run_ID = ? " +
      "        AND AD_Process_Execution_V.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Process_Execution_V.AD_Org_ID IN (";
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
        ProcessExecutionData objectProcessExecutionData = new ProcessExecutionData();
        objectProcessExecutionData.created = UtilSql.getValue(result, "created");
        objectProcessExecutionData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectProcessExecutionData.updated = UtilSql.getValue(result, "updated");
        objectProcessExecutionData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectProcessExecutionData.updatedby = UtilSql.getValue(result, "updatedby");
        objectProcessExecutionData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectProcessExecutionData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProcessExecutionData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectProcessExecutionData.adProcessRunId = UtilSql.getValue(result, "ad_process_run_id");
        objectProcessExecutionData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProcessExecutionData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectProcessExecutionData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectProcessExecutionData.adProcessIdr = UtilSql.getValue(result, "ad_process_idr");
        objectProcessExecutionData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectProcessExecutionData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectProcessExecutionData.isactive = UtilSql.getValue(result, "isactive");
        objectProcessExecutionData.startTime = UtilSql.getDateValue(result, "start_time", "dd-MM-yyyy");
        objectProcessExecutionData.endTime = UtilSql.getDateValue(result, "end_time", "dd-MM-yyyy");
        objectProcessExecutionData.runtime = UtilSql.getValue(result, "runtime");
        objectProcessExecutionData.status = UtilSql.getValue(result, "status");
        objectProcessExecutionData.statusr = UtilSql.getValue(result, "statusr");
        objectProcessExecutionData.channel = UtilSql.getValue(result, "channel");
        objectProcessExecutionData.log = UtilSql.getValue(result, "log");
        objectProcessExecutionData.result = UtilSql.getValue(result, "result");
        objectProcessExecutionData.adProcessRequestId = UtilSql.getValue(result, "ad_process_request_id");
        objectProcessExecutionData.report = UtilSql.getValue(result, "report");
        objectProcessExecutionData.params = UtilSql.getValue(result, "params");
        objectProcessExecutionData.isrolesecurity = UtilSql.getValue(result, "isrolesecurity");
        objectProcessExecutionData.language = UtilSql.getValue(result, "language");
        objectProcessExecutionData.adUserClient = "";
        objectProcessExecutionData.adOrgClient = "";
        objectProcessExecutionData.createdby = "";
        objectProcessExecutionData.trBgcolor = "";
        objectProcessExecutionData.totalCount = "";
        objectProcessExecutionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProcessExecutionData);
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
    ProcessExecutionData objectProcessExecutionData[] = new ProcessExecutionData[vector.size()];
    vector.copyInto(objectProcessExecutionData);
    return(objectProcessExecutionData);
  }

/**
Create a registry
 */
  public static ProcessExecutionData[] set(String isactive, String status, String adUserId, String adProcessId, String updatedby, String updatedbyr, String log, String isrolesecurity, String adProcessRunId, String report, String endTime, String adProcessRequestId, String startTime, String channel, String params, String result, String createdby, String createdbyr, String adClientId, String adOrgId, String runtime)    throws ServletException {
    ProcessExecutionData objectProcessExecutionData[] = new ProcessExecutionData[1];
    objectProcessExecutionData[0] = new ProcessExecutionData();
    objectProcessExecutionData[0].created = "";
    objectProcessExecutionData[0].createdbyr = createdbyr;
    objectProcessExecutionData[0].updated = "";
    objectProcessExecutionData[0].updatedTimeStamp = "";
    objectProcessExecutionData[0].updatedby = updatedby;
    objectProcessExecutionData[0].updatedbyr = updatedbyr;
    objectProcessExecutionData[0].adClientId = adClientId;
    objectProcessExecutionData[0].adClientIdr = "";
    objectProcessExecutionData[0].adProcessRunId = adProcessRunId;
    objectProcessExecutionData[0].adOrgId = adOrgId;
    objectProcessExecutionData[0].adOrgIdr = "";
    objectProcessExecutionData[0].adProcessId = adProcessId;
    objectProcessExecutionData[0].adProcessIdr = "";
    objectProcessExecutionData[0].adUserId = adUserId;
    objectProcessExecutionData[0].adUserIdr = "";
    objectProcessExecutionData[0].isactive = isactive;
    objectProcessExecutionData[0].startTime = startTime;
    objectProcessExecutionData[0].endTime = endTime;
    objectProcessExecutionData[0].runtime = runtime;
    objectProcessExecutionData[0].status = status;
    objectProcessExecutionData[0].statusr = "";
    objectProcessExecutionData[0].channel = channel;
    objectProcessExecutionData[0].log = log;
    objectProcessExecutionData[0].result = result;
    objectProcessExecutionData[0].adProcessRequestId = adProcessRequestId;
    objectProcessExecutionData[0].report = report;
    objectProcessExecutionData[0].params = params;
    objectProcessExecutionData[0].isrolesecurity = isrolesecurity;
    objectProcessExecutionData[0].language = "";
    return objectProcessExecutionData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef57B98D87940FA967E040007F01013153_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef57B98D87940DA967E040007F01013153_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_Process_Execution_V" +
      "        SET AD_Client_ID = (?) , AD_Process_Run_ID = (?) , AD_Org_ID = (?) , AD_Process_ID = (?) , AD_User_ID = (?) , Isactive = (?) , Start_Time = TO_DATE(?) , End_Time = TO_DATE(?) , Runtime = (?) , Status = (?) , Channel = (?) , Log = (?) , Result = (?) , AD_Process_Request_ID = (?) , Report = (?) , Params = (?) , Isrolesecurity = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Process_Execution_V.AD_Process_Run_ID = ? " +
      "        AND AD_Process_Execution_V.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Process_Execution_V.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessRunId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, endTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, runtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, channel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, log);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, result);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessRequestId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, report);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, params);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrolesecurity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessRunId);
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
      "        INSERT INTO AD_Process_Execution_V " +
      "        (AD_Client_ID, AD_Process_Run_ID, AD_Org_ID, AD_Process_ID, AD_User_ID, Isactive, Start_Time, End_Time, Runtime, Status, Channel, Log, Result, AD_Process_Request_ID, Report, Params, Isrolesecurity, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessRunId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, endTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, runtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, channel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, log);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, result);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessRequestId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, report);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, params);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrolesecurity);
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
      "        DELETE FROM AD_Process_Execution_V" +
      "        WHERE AD_Process_Execution_V.AD_Process_Run_ID = ? " +
      "        AND AD_Process_Execution_V.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Process_Execution_V.AD_Org_ID IN (";
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
      "        DELETE FROM AD_Process_Execution_V" +
      "        WHERE AD_Process_Execution_V.AD_Process_Run_ID = ? ";

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
      "          FROM AD_Process_Execution_V" +
      "         WHERE AD_Process_Execution_V.AD_Process_Run_ID = ? ";

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
      "          FROM AD_Process_Execution_V" +
      "         WHERE AD_Process_Execution_V.AD_Process_Run_ID = ? ";

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
