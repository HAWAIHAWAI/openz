//Sqlc generated V1.O00-1
package org.openz.pdc.controller;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class TimeFeedbackData implements FieldProvider {
static Logger log4j = Logger.getLogger(TimeFeedbackData.class);
  private String InitRecordNumber="0";
  public String cProjecttaskId;
  public String zspmPtaskfeedbacklineId;
  public String adUserId;
  public String hourFrom;
  public String hourTo;
  public String outMessagetext;
  public String outCreatedid;
  public String barcode;
  public String type;
  public String id;
  public String mess;
  public String adMessageValue;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("zspm_ptaskfeedbackline_id") || fieldName.equals("zspmPtaskfeedbacklineId"))
      return zspmPtaskfeedbacklineId;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("hour_from") || fieldName.equals("hourFrom"))
      return hourFrom;
    else if (fieldName.equalsIgnoreCase("hour_to") || fieldName.equals("hourTo"))
      return hourTo;
    else if (fieldName.equalsIgnoreCase("out_messagetext") || fieldName.equals("outMessagetext"))
      return outMessagetext;
    else if (fieldName.equalsIgnoreCase("out_createdid") || fieldName.equals("outCreatedid"))
      return outCreatedid;
    else if (fieldName.equalsIgnoreCase("barcode"))
      return barcode;
    else if (fieldName.equalsIgnoreCase("type"))
      return type;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("mess"))
      return mess;
    else if (fieldName.equalsIgnoreCase("ad_message_value") || fieldName.equals("adMessageValue"))
      return adMessageValue;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static TimeFeedbackData[] initialize(ConnectionProvider connectionProvider)    throws ServletException {
    return initialize(connectionProvider, 0, 0);
  }

  public static TimeFeedbackData[] initialize(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            Select " +
      "            -- selectupper" +
      "                '' as c_projecttask_id, " +
      "                '' as zspm_ptaskfeedbackline_id, " +
      "                '' as ad_user_id, " +
      "                '' as hour_from, " +
      "                '' as hour_to, " +
      "                '' as out_messagetext, " +
      "                '' as out_createdId," +
      "                -- selectlower, same as selectupper" +
      "            -- selectbarcode" +
      "                '' as barcode," +
      "                '' as type," +
      "                '' as id," +
      "                '' as mess," +
      "                '' as ad_message_value";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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
        TimeFeedbackData objectTimeFeedbackData = new TimeFeedbackData();
        objectTimeFeedbackData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectTimeFeedbackData.zspmPtaskfeedbacklineId = UtilSql.getValue(result, "zspm_ptaskfeedbackline_id");
        objectTimeFeedbackData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectTimeFeedbackData.hourFrom = UtilSql.getValue(result, "hour_from");
        objectTimeFeedbackData.hourTo = UtilSql.getValue(result, "hour_to");
        objectTimeFeedbackData.outMessagetext = UtilSql.getValue(result, "out_messagetext");
        objectTimeFeedbackData.outCreatedid = UtilSql.getValue(result, "out_createdid");
        objectTimeFeedbackData.barcode = UtilSql.getValue(result, "barcode");
        objectTimeFeedbackData.type = UtilSql.getValue(result, "type");
        objectTimeFeedbackData.id = UtilSql.getValue(result, "id");
        objectTimeFeedbackData.mess = UtilSql.getValue(result, "mess");
        objectTimeFeedbackData.adMessageValue = UtilSql.getValue(result, "ad_message_value");
        objectTimeFeedbackData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTimeFeedbackData);
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
    TimeFeedbackData objectTimeFeedbackData[] = new TimeFeedbackData[vector.size()];
    vector.copyInto(objectTimeFeedbackData);
    return(objectTimeFeedbackData);
  }

  public static TimeFeedbackData[] selectupper(ConnectionProvider connectionProvider, String user)    throws ServletException {
    return selectupper(connectionProvider, user, 0, 0);
  }

  public static TimeFeedbackData[] selectupper(ConnectionProvider connectionProvider, String user, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            select " +
      "                a.zspm_ptaskfeedbackline_id, " +
      "                b.name as c_projecttask_id," +
      "                a.ad_user_id, " +
      "                to_char(a.hour_from,'dd.mm.yy hh24:mi') as hour_from," +
      "                a.hour_to" +
      "            from " +
      "                zspm_ptaskfeedbackline a,c_projecttask b" +
      "                where a.c_projecttask_id=b.c_projecttask_id and" +
      "                a.hour_to is null and" +
      "                a.ad_user_id = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);

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
        TimeFeedbackData objectTimeFeedbackData = new TimeFeedbackData();
        objectTimeFeedbackData.zspmPtaskfeedbacklineId = UtilSql.getValue(result, "zspm_ptaskfeedbackline_id");
        objectTimeFeedbackData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectTimeFeedbackData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectTimeFeedbackData.hourFrom = UtilSql.getValue(result, "hour_from");
        objectTimeFeedbackData.hourTo = UtilSql.getDateValue(result, "hour_to", "dd-MM-yyyy");
        objectTimeFeedbackData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTimeFeedbackData);
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
    TimeFeedbackData objectTimeFeedbackData[] = new TimeFeedbackData[vector.size()];
    vector.copyInto(objectTimeFeedbackData);
    return(objectTimeFeedbackData);
  }

  public static TimeFeedbackData[] selectlower(ConnectionProvider connectionProvider, String user)    throws ServletException {
    return selectlower(connectionProvider, user, 0, 0);
  }

  public static TimeFeedbackData[] selectlower(ConnectionProvider connectionProvider, String user, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "           select " +
      "                a.zspm_ptaskfeedbackline_id, " +
      "                b.name as c_projecttask_id," +
      "                a.ad_user_id, " +
      "                to_char(a.hour_from,'dd.mm.yy hh24:mi') as hour_from," +
      "                to_char(a.hour_to,'dd.mm.yy hh24:mi') as hour_to" +
      "            from " +
      "                zspm_ptaskfeedbackline a,c_projecttask b" +
      "                where a.c_projecttask_id=b.c_projecttask_id and" +
      "                coalesce(a.hour_to,now()-30)>now()-20 and" +
      "                a.ad_user_id = ?" +
      "            order by hour_from desc";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);

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
        TimeFeedbackData objectTimeFeedbackData = new TimeFeedbackData();
        objectTimeFeedbackData.zspmPtaskfeedbacklineId = UtilSql.getValue(result, "zspm_ptaskfeedbackline_id");
        objectTimeFeedbackData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectTimeFeedbackData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectTimeFeedbackData.hourFrom = UtilSql.getValue(result, "hour_from");
        objectTimeFeedbackData.hourTo = UtilSql.getValue(result, "hour_to");
        objectTimeFeedbackData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTimeFeedbackData);
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
    TimeFeedbackData objectTimeFeedbackData[] = new TimeFeedbackData[vector.size()];
    vector.copyInto(objectTimeFeedbackData);
    return(objectTimeFeedbackData);
  }

  public static String getOpenWorkstep(ConnectionProvider connectionProvider, String userid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT pdc_getopenworkstep(?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "pdc_getopenworkstep");
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

  public static String isWorstepStarted(ConnectionProvider connectionProvider, String workstepid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT taskbegun from c_projecttask where c_projecttask_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workstepid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "taskbegun");
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

  public static String setTimeFeedback(ConnectionProvider connectionProvider, String orgid, String workstepid, String userid, String timestamp, String format)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT pdc_settimefeedback(?,?,?,to_timestamp(?,?)::timestamp without time zone)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workstepid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timestamp);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, format);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "pdc_settimefeedback");
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

  public static TimeFeedbackData[] beginWorkstepWithMat(ConnectionProvider connectionProvider, String workstepId, String userId, String adOrgId)    throws ServletException {
    return beginWorkstepWithMat(connectionProvider, workstepId, userId, adOrgId, 0, 0);
  }

  public static TimeFeedbackData[] beginWorkstepWithMat(ConnectionProvider connectionProvider, String workstepId, String userId, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select out_createdId,out_messagetext from zssm_beginworkstep(?, ?, ?,'Y')";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workstepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
        TimeFeedbackData objectTimeFeedbackData = new TimeFeedbackData();
        objectTimeFeedbackData.outCreatedid = UtilSql.getValue(result, "out_createdid");
        objectTimeFeedbackData.outMessagetext = UtilSql.getValue(result, "out_messagetext");
        objectTimeFeedbackData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTimeFeedbackData);
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
    TimeFeedbackData objectTimeFeedbackData[] = new TimeFeedbackData[vector.size()];
    vector.copyInto(objectTimeFeedbackData);
    return(objectTimeFeedbackData);
  }

  public static TimeFeedbackData[] beginWorkstepNoMat(ConnectionProvider connectionProvider, String workstepId, String userId, String adOrgId)    throws ServletException {
    return beginWorkstepNoMat(connectionProvider, workstepId, userId, adOrgId, 0, 0);
  }

  public static TimeFeedbackData[] beginWorkstepNoMat(ConnectionProvider connectionProvider, String workstepId, String userId, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select out_createdId,out_messagetext from zssm_beginworkstep(?, ?, ?,'N')";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workstepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
        TimeFeedbackData objectTimeFeedbackData = new TimeFeedbackData();
        objectTimeFeedbackData.outCreatedid = UtilSql.getValue(result, "out_createdid");
        objectTimeFeedbackData.outMessagetext = UtilSql.getValue(result, "out_messagetext");
        objectTimeFeedbackData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTimeFeedbackData);
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
    TimeFeedbackData objectTimeFeedbackData[] = new TimeFeedbackData[vector.size()];
    vector.copyInto(objectTimeFeedbackData);
    return(objectTimeFeedbackData);
  }
}
