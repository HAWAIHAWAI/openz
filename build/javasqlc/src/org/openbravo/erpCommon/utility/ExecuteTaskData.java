//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ExecuteTaskData implements FieldProvider {
static Logger log4j = Logger.getLogger(ExecuteTaskData.class);
  private String InitRecordNumber="0";
  public String name;
  public String osCommand;
  public String accesslevel;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("os_command") || fieldName.equals("osCommand"))
      return osCommand;
    else if (fieldName.equalsIgnoreCase("accesslevel"))
      return accesslevel;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ExecuteTaskData[] select(ConnectionProvider connectionProvider, String adTaskId)    throws ServletException {
    return select(connectionProvider, adTaskId, 0, 0);
  }

  public static ExecuteTaskData[] select(ConnectionProvider connectionProvider, String adTaskId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME, OS_COMMAND, ACCESSLEVEL " +
      "        FROM AD_TASK " +
      "        WHERE AD_TASK_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTaskId);

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
        ExecuteTaskData objectExecuteTaskData = new ExecuteTaskData();
        objectExecuteTaskData.name = UtilSql.getValue(result, "name");
        objectExecuteTaskData.osCommand = UtilSql.getValue(result, "os_command");
        objectExecuteTaskData.accesslevel = UtilSql.getValue(result, "accesslevel");
        objectExecuteTaskData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExecuteTaskData);
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
    ExecuteTaskData objectExecuteTaskData[] = new ExecuteTaskData[vector.size()];
    vector.copyInto(objectExecuteTaskData);
    return(objectExecuteTaskData);
  }

  public static ExecuteTaskData[] selectTrl(ConnectionProvider connectionProvider, String adLanguage, String adTaskId)    throws ServletException {
    return selectTrl(connectionProvider, adLanguage, adTaskId, 0, 0);
  }

  public static ExecuteTaskData[] selectTrl(ConnectionProvider connectionProvider, String adLanguage, String adTaskId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(TRL.NAME, T.NAME) AS NAME, T.OS_COMMAND, ACCESSLEVEL " +
      "        FROM AD_TASK T left join AD_TASK_TRL TRL on T.AD_TASK_ID = TRL.AD_TASK_ID " +
      "                                                AND TRL.AD_LANGUAGE = ?" +
      "        WHERE T.AD_TASK_ID = ?  ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTaskId);

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
        ExecuteTaskData objectExecuteTaskData = new ExecuteTaskData();
        objectExecuteTaskData.name = UtilSql.getValue(result, "name");
        objectExecuteTaskData.osCommand = UtilSql.getValue(result, "os_command");
        objectExecuteTaskData.accesslevel = UtilSql.getValue(result, "accesslevel");
        objectExecuteTaskData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExecuteTaskData);
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
    ExecuteTaskData objectExecuteTaskData[] = new ExecuteTaskData[vector.size()];
    vector.copyInto(objectExecuteTaskData);
    return(objectExecuteTaskData);
  }

  public static int insert(ConnectionProvider connectionProvider, String adTaskInstanceId, String adClientId, String adOrgId, String adUserId, String adTaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO AD_TASKINSTANCE (AD_TASKINSTANCE_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, " +
      "        UPDATED, UPDATEDBY, AD_TASK_ID) " +
      "        VALUES(?, ?, ?, 'Y', now(), ?, now(), ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTaskInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTaskId);

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
