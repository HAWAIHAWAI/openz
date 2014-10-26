//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.asset.Machine;

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
class CalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data implements FieldProvider {
static Logger log4j = Logger.getLogger(CalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String maMachineId;
  public String maMachineIdr;
  public String cMachinecalendarVId;
  public String adOrgId;
  public String workdate;
  public String adClientId;
  public String worktimeplan;
  public String workbegintime;
  public String percentplanned;
  public String projectsplan;
  public String event;
  public String projectsworked;
  public String isactive;
  public String worktime;
  public String percentused;
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
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
    else if (fieldName.equalsIgnoreCase("ma_machine_idr") || fieldName.equals("maMachineIdr"))
      return maMachineIdr;
    else if (fieldName.equalsIgnoreCase("c_machinecalendar_v_id") || fieldName.equals("cMachinecalendarVId"))
      return cMachinecalendarVId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("workdate"))
      return workdate;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("worktimeplan"))
      return worktimeplan;
    else if (fieldName.equalsIgnoreCase("workbegintime"))
      return workbegintime;
    else if (fieldName.equalsIgnoreCase("percentplanned"))
      return percentplanned;
    else if (fieldName.equalsIgnoreCase("projectsplan"))
      return projectsplan;
    else if (fieldName.equalsIgnoreCase("event"))
      return event;
    else if (fieldName.equalsIgnoreCase("projectsworked"))
      return projectsworked;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("worktime"))
      return worktime;
    else if (fieldName.equalsIgnoreCase("percentused"))
      return percentused;
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
  public static CalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMachineId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maMachineId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMachineId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_machinecalendar_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_machinecalendar_v.CreatedBy) as CreatedByR, " +
      "        to_char(c_machinecalendar_v.Updated, ?) as updated, " +
      "        to_char(c_machinecalendar_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_machinecalendar_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_machinecalendar_v.UpdatedBy) as UpdatedByR," +
      "        c_machinecalendar_v.MA_Machine_ID, " +
      "(CASE WHEN c_machinecalendar_v.MA_Machine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS MA_Machine_IDR, " +
      "c_machinecalendar_v.C_Machinecalendar_V_ID, " +
      "c_machinecalendar_v.AD_Org_ID, " +
      "c_machinecalendar_v.Workdate, " +
      "c_machinecalendar_v.AD_Client_ID, " +
      "c_machinecalendar_v.Worktimeplan, " +
      "c_machinecalendar_v.Workbegintime, " +
      "c_machinecalendar_v.Percentplanned, " +
      "c_machinecalendar_v.Projectsplan, " +
      "c_machinecalendar_v.Event, " +
      "c_machinecalendar_v.Projectsworked, " +
      "COALESCE(c_machinecalendar_v.Isactive, 'N') AS Isactive, " +
      "c_machinecalendar_v.Worktime, " +
      "c_machinecalendar_v.Percentused, " +
      "        ? AS LANGUAGE " +
      "        FROM c_machinecalendar_v left join (select MA_Machine_ID, Value, Name from MA_Machine) table1 on (c_machinecalendar_v.MA_Machine_ID = table1.MA_Machine_ID)" +
      "        WHERE 2=2 " +
      " AND workdate>=now()-730 AND workdate<=now()+365" +
      "        AND 1=1 ";
    strSql = strSql + ((maMachineId==null || maMachineId.equals(""))?"":"  AND c_machinecalendar_v.MA_Machine_ID = ?  ");
    strSql = strSql + 
      "        AND c_machinecalendar_v.C_Machinecalendar_V_ID = ? " +
      "        AND c_machinecalendar_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_machinecalendar_v.AD_Org_ID IN (";
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
      if (maMachineId != null && !(maMachineId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
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
        CalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data = new CalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data();
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.created = UtilSql.getValue(result, "created");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.updated = UtilSql.getValue(result, "updated");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.maMachineIdr = UtilSql.getValue(result, "ma_machine_idr");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.cMachinecalendarVId = UtilSql.getValue(result, "c_machinecalendar_v_id");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.workdate = UtilSql.getDateValue(result, "workdate", "dd-MM-yyyy");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.worktimeplan = UtilSql.getValue(result, "worktimeplan");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.workbegintime = UtilSql.getValue(result, "workbegintime");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.percentplanned = UtilSql.getValue(result, "percentplanned");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.projectsplan = UtilSql.getValue(result, "projectsplan");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.event = UtilSql.getValue(result, "event");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.projectsworked = UtilSql.getValue(result, "projectsworked");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.isactive = UtilSql.getValue(result, "isactive");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.worktime = UtilSql.getValue(result, "worktime");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.percentused = UtilSql.getValue(result, "percentused");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.language = UtilSql.getValue(result, "language");
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.adUserClient = "";
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.adOrgClient = "";
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.createdby = "";
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.trBgcolor = "";
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.totalCount = "";
        objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data);
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
    CalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[] = new CalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[vector.size()];
    vector.copyInto(objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data);
    return(objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data);
  }

/**
Create a registry
 */
  public static CalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[] set(String maMachineId, String percentused, String event, String workbegintime, String adClientId, String isactive, String worktime, String percentplanned, String projectsplan, String projectsworked, String cMachinecalendarVId, String adOrgId, String updatedby, String updatedbyr, String workdate, String createdby, String createdbyr, String worktimeplan)    throws ServletException {
    CalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[] = new CalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[1];
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0] = new CalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data();
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].created = "";
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].createdbyr = createdbyr;
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].updated = "";
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].updatedTimeStamp = "";
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].updatedby = updatedby;
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].updatedbyr = updatedbyr;
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].maMachineId = maMachineId;
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].maMachineIdr = "";
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].cMachinecalendarVId = cMachinecalendarVId;
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].adOrgId = adOrgId;
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].workdate = workdate;
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].adClientId = adClientId;
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].worktimeplan = worktimeplan;
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].workbegintime = workbegintime;
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].percentplanned = percentplanned;
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].projectsplan = projectsplan;
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].event = event;
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].projectsworked = projectsworked;
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].isactive = isactive;
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].worktime = worktime;
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].percentused = percentused;
    objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data[0].language = "";
    return objectCalendarOverview1015B3795A5D47759E1C72EFC2FD51A7Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef9EC5DDA70A874AB7BF02FDEAA89F77EB_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef4DA5D14BAAE5400BB1F8EEFD7D0C9544_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT c_machinecalendar_v.MA_Machine_ID AS NAME" +
      "        FROM c_machinecalendar_v" +
      "        WHERE c_machinecalendar_v.C_Machinecalendar_V_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String maMachineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM MA_Machine left join (select MA_Machine_ID, Value, Name from MA_Machine) table1 on (MA_Machine.MA_Machine_ID = table1.MA_Machine_ID) WHERE MA_Machine.MA_Machine_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String maMachineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM MA_Machine left join (select MA_Machine_ID, Value, Name from MA_Machine) table1 on (MA_Machine.MA_Machine_ID = table1.MA_Machine_ID) WHERE MA_Machine.MA_Machine_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);

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
      "        UPDATE c_machinecalendar_v" +
      "        SET MA_Machine_ID = (?) , C_Machinecalendar_V_ID = (?) , AD_Org_ID = (?) , Workdate = TO_DATE(?) , AD_Client_ID = (?) , Worktimeplan = TO_NUMBER(?) , Workbegintime = (?) , Percentplanned = TO_NUMBER(?) , Projectsplan = (?) , Event = (?) , Projectsworked = (?) , Isactive = (?) , Worktime = TO_NUMBER(?) , Percentused = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE c_machinecalendar_v.C_Machinecalendar_V_ID = ? " +
      "                 AND c_machinecalendar_v.MA_Machine_ID = ? " +
      "        AND c_machinecalendar_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_machinecalendar_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cMachinecalendarVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktimeplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workbegintime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectsplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, event);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectsworked);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentused);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cMachinecalendarVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
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
      "        INSERT INTO c_machinecalendar_v " +
      "        (MA_Machine_ID, C_Machinecalendar_V_ID, AD_Org_ID, Workdate, AD_Client_ID, Worktimeplan, Workbegintime, Percentplanned, Projectsplan, Event, Projectsworked, Isactive, Worktime, Percentused, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_DATE(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cMachinecalendarVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktimeplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workbegintime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectsplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, event);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectsworked);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentused);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String maMachineId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_machinecalendar_v" +
      "        WHERE c_machinecalendar_v.C_Machinecalendar_V_ID = ? " +
      "                 AND c_machinecalendar_v.MA_Machine_ID = ? " +
      "        AND c_machinecalendar_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_machinecalendar_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String maMachineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_machinecalendar_v" +
      "        WHERE c_machinecalendar_v.C_Machinecalendar_V_ID = ? " +
      "                 AND c_machinecalendar_v.MA_Machine_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);

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
      "          FROM c_machinecalendar_v" +
      "         WHERE c_machinecalendar_v.C_Machinecalendar_V_ID = ? ";

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
      "          FROM c_machinecalendar_v" +
      "         WHERE c_machinecalendar_v.C_Machinecalendar_V_ID = ? ";

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
