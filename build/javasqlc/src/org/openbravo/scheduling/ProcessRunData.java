//Sqlc generated V1.O00-1
package org.openbravo.scheduling;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;

class ProcessRunData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProcessRunData.class);
  private String InitRecordNumber="0";
  public String adProcessRunId;
  public String status;
  public String startTime;
  public String endTime;
  public String runtime;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_process_run_id") || fieldName.equals("adProcessRunId"))
      return adProcessRunId;
    else if (fieldName.equalsIgnoreCase("status"))
      return status;
    else if (fieldName.equalsIgnoreCase("start_time") || fieldName.equals("startTime"))
      return startTime;
    else if (fieldName.equalsIgnoreCase("end_time") || fieldName.equals("endTime"))
      return endTime;
    else if (fieldName.equalsIgnoreCase("runtime"))
      return runtime;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProcessRunData select(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      	SELECT AD_Process_Run_ID, Status, Start_Time, End_Time, Runtime	 " +
      "      	FROM AD_Process_Run" +
      "      	WHERE AD_Process_Run_ID = ?";

    ResultSet result;
    ProcessRunData objectProcessRunData = new ProcessRunData();
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        objectProcessRunData.adProcessRunId = UtilSql.getValue(result, "ad_process_run_id");
        objectProcessRunData.status = UtilSql.getValue(result, "status");
        objectProcessRunData.startTime = UtilSql.getDateValue(result, "start_time", "dd-MM-yyyy");
        objectProcessRunData.endTime = UtilSql.getDateValue(result, "end_time", "dd-MM-yyyy");
        objectProcessRunData.runtime = UtilSql.getValue(result, "runtime");
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
    return(objectProcessRunData);
  }

  public static int insert(ConnectionProvider connectionProvider, String adOrgId, String adClientId, String createdby, String updatedby, String id, String status, String runtime, String log, String processRequestId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      	INSERT INTO AD_Process_Run " +
      "        (AD_Org_ID, AD_Client_ID, Isactive, Created, Createdby, Updated, UpdatedBy, " +
      "        AD_Process_Run_ID, Status, Start_Time, Runtime, Log, AD_Process_Request_ID)" +
      "        VALUES (?, ?, 'Y', NOW(), ?, NOW(), ?, ?, ?, NOW(), ?, ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, runtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, log);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processRequestId);

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

  public static int update(ConnectionProvider connectionProvider, String updatedby, String status, String runtime, String log, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      	UPDATE AD_Process_Run " +
      "        SET Updated = NOW(), UpdatedBy = ?, Status = ?, End_Time = NOW()," +
      "        Runtime = ?, Log = ?" +
      "        WHERE AD_Process_Run_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, runtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, log);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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
}
