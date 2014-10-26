//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Organization;

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
class CalendarSettingsData implements FieldProvider {
static Logger log4j = Logger.getLogger(CalendarSettingsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cWorkcalendarsettingsId;
  public String validfrom;
  public String isactive;
  public String worktimemonday;
  public String workbegintimemonday;
  public String worktimetuesday;
  public String workbegintimetuesday;
  public String worktimewednesday;
  public String workbegintimewednesday;
  public String worktimethursday;
  public String workbegintimethursday;
  public String worktimefriday;
  public String workbegintimefriday;
  public String worktimesaturday;
  public String workbegintimesaturday;
  public String worktimesunday;
  public String workbegintimesunday;
  public String adClientId;
  public String adOrgId;
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
    else if (fieldName.equalsIgnoreCase("c_workcalendarsettings_id") || fieldName.equals("cWorkcalendarsettingsId"))
      return cWorkcalendarsettingsId;
    else if (fieldName.equalsIgnoreCase("validfrom"))
      return validfrom;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("worktimemonday"))
      return worktimemonday;
    else if (fieldName.equalsIgnoreCase("workbegintimemonday"))
      return workbegintimemonday;
    else if (fieldName.equalsIgnoreCase("worktimetuesday"))
      return worktimetuesday;
    else if (fieldName.equalsIgnoreCase("workbegintimetuesday"))
      return workbegintimetuesday;
    else if (fieldName.equalsIgnoreCase("worktimewednesday"))
      return worktimewednesday;
    else if (fieldName.equalsIgnoreCase("workbegintimewednesday"))
      return workbegintimewednesday;
    else if (fieldName.equalsIgnoreCase("worktimethursday"))
      return worktimethursday;
    else if (fieldName.equalsIgnoreCase("workbegintimethursday"))
      return workbegintimethursday;
    else if (fieldName.equalsIgnoreCase("worktimefriday"))
      return worktimefriday;
    else if (fieldName.equalsIgnoreCase("workbegintimefriday"))
      return workbegintimefriday;
    else if (fieldName.equalsIgnoreCase("worktimesaturday"))
      return worktimesaturday;
    else if (fieldName.equalsIgnoreCase("workbegintimesaturday"))
      return workbegintimesaturday;
    else if (fieldName.equalsIgnoreCase("worktimesunday"))
      return worktimesunday;
    else if (fieldName.equalsIgnoreCase("workbegintimesunday"))
      return workbegintimesunday;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
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
  public static CalendarSettingsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adOrgId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adOrgId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CalendarSettingsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adOrgId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_WORKCALENDARSETTINGS.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_WORKCALENDARSETTINGS.CreatedBy) as CreatedByR, " +
      "        to_char(C_WORKCALENDARSETTINGS.Updated, ?) as updated, " +
      "        to_char(C_WORKCALENDARSETTINGS.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_WORKCALENDARSETTINGS.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_WORKCALENDARSETTINGS.UpdatedBy) as UpdatedByR," +
      "        C_WORKCALENDARSETTINGS.C_Workcalendarsettings_ID, " +
      "C_WORKCALENDARSETTINGS.Validfrom, " +
      "COALESCE(C_WORKCALENDARSETTINGS.Isactive, 'N') AS Isactive, " +
      "C_WORKCALENDARSETTINGS.Worktimemonday, " +
      "TO_CHAR(C_WORKCALENDARSETTINGS.Workbegintimemonday, 'HH24:MI:SS') AS Workbegintimemonday, " +
      "C_WORKCALENDARSETTINGS.Worktimetuesday, " +
      "TO_CHAR(C_WORKCALENDARSETTINGS.Workbegintimetuesday, 'HH24:MI:SS') AS Workbegintimetuesday, " +
      "C_WORKCALENDARSETTINGS.Worktimewednesday, " +
      "TO_CHAR(C_WORKCALENDARSETTINGS.Workbegintimewednesday, 'HH24:MI:SS') AS Workbegintimewednesday, " +
      "C_WORKCALENDARSETTINGS.Worktimethursday, " +
      "TO_CHAR(C_WORKCALENDARSETTINGS.Workbegintimethursday, 'HH24:MI:SS') AS Workbegintimethursday, " +
      "C_WORKCALENDARSETTINGS.Worktimefriday, " +
      "TO_CHAR(C_WORKCALENDARSETTINGS.Workbegintimefriday, 'HH24:MI:SS') AS Workbegintimefriday, " +
      "C_WORKCALENDARSETTINGS.Worktimesaturday, " +
      "TO_CHAR(C_WORKCALENDARSETTINGS.Workbegintimesaturday, 'HH24:MI:SS') AS Workbegintimesaturday, " +
      "C_WORKCALENDARSETTINGS.Worktimesunday, " +
      "TO_CHAR(C_WORKCALENDARSETTINGS.Workbegintimesunday, 'HH24:MI:SS') AS Workbegintimesunday, " +
      "C_WORKCALENDARSETTINGS.AD_Client_ID, " +
      "C_WORKCALENDARSETTINGS.AD_Org_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_WORKCALENDARSETTINGS" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":"  AND C_WORKCALENDARSETTINGS.AD_Org_ID = ?  ");
    strSql = strSql + 
      "        AND C_WORKCALENDARSETTINGS.C_Workcalendarsettings_ID = ? " +
      "        AND C_WORKCALENDARSETTINGS.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_WORKCALENDARSETTINGS.AD_Org_ID IN (";
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
      if (adOrgId != null && !(adOrgId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
        CalendarSettingsData objectCalendarSettingsData = new CalendarSettingsData();
        objectCalendarSettingsData.created = UtilSql.getValue(result, "created");
        objectCalendarSettingsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCalendarSettingsData.updated = UtilSql.getValue(result, "updated");
        objectCalendarSettingsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCalendarSettingsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectCalendarSettingsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCalendarSettingsData.cWorkcalendarsettingsId = UtilSql.getValue(result, "c_workcalendarsettings_id");
        objectCalendarSettingsData.validfrom = UtilSql.getDateValue(result, "validfrom", "dd-MM-yyyy");
        objectCalendarSettingsData.isactive = UtilSql.getValue(result, "isactive");
        objectCalendarSettingsData.worktimemonday = UtilSql.getValue(result, "worktimemonday");
        objectCalendarSettingsData.workbegintimemonday = UtilSql.getValue(result, "workbegintimemonday");
        objectCalendarSettingsData.worktimetuesday = UtilSql.getValue(result, "worktimetuesday");
        objectCalendarSettingsData.workbegintimetuesday = UtilSql.getValue(result, "workbegintimetuesday");
        objectCalendarSettingsData.worktimewednesday = UtilSql.getValue(result, "worktimewednesday");
        objectCalendarSettingsData.workbegintimewednesday = UtilSql.getValue(result, "workbegintimewednesday");
        objectCalendarSettingsData.worktimethursday = UtilSql.getValue(result, "worktimethursday");
        objectCalendarSettingsData.workbegintimethursday = UtilSql.getValue(result, "workbegintimethursday");
        objectCalendarSettingsData.worktimefriday = UtilSql.getValue(result, "worktimefriday");
        objectCalendarSettingsData.workbegintimefriday = UtilSql.getValue(result, "workbegintimefriday");
        objectCalendarSettingsData.worktimesaturday = UtilSql.getValue(result, "worktimesaturday");
        objectCalendarSettingsData.workbegintimesaturday = UtilSql.getValue(result, "workbegintimesaturday");
        objectCalendarSettingsData.worktimesunday = UtilSql.getValue(result, "worktimesunday");
        objectCalendarSettingsData.workbegintimesunday = UtilSql.getValue(result, "workbegintimesunday");
        objectCalendarSettingsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCalendarSettingsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCalendarSettingsData.language = UtilSql.getValue(result, "language");
        objectCalendarSettingsData.adUserClient = "";
        objectCalendarSettingsData.adOrgClient = "";
        objectCalendarSettingsData.createdby = "";
        objectCalendarSettingsData.trBgcolor = "";
        objectCalendarSettingsData.totalCount = "";
        objectCalendarSettingsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCalendarSettingsData);
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
    CalendarSettingsData objectCalendarSettingsData[] = new CalendarSettingsData[vector.size()];
    vector.copyInto(objectCalendarSettingsData);
    return(objectCalendarSettingsData);
  }

/**
Create a registry
 */
  public static CalendarSettingsData[] set(String adOrgId, String updatedby, String updatedbyr, String workbegintimesaturday, String worktimewednesday, String worktimemonday, String workbegintimethursday, String worktimetuesday, String validfrom, String isactive, String adClientId, String createdby, String createdbyr, String workbegintimesunday, String worktimefriday, String workbegintimewednesday, String cWorkcalendarsettingsId, String workbegintimefriday, String worktimesaturday, String worktimethursday, String worktimesunday, String workbegintimemonday, String workbegintimetuesday)    throws ServletException {
    CalendarSettingsData objectCalendarSettingsData[] = new CalendarSettingsData[1];
    objectCalendarSettingsData[0] = new CalendarSettingsData();
    objectCalendarSettingsData[0].created = "";
    objectCalendarSettingsData[0].createdbyr = createdbyr;
    objectCalendarSettingsData[0].updated = "";
    objectCalendarSettingsData[0].updatedTimeStamp = "";
    objectCalendarSettingsData[0].updatedby = updatedby;
    objectCalendarSettingsData[0].updatedbyr = updatedbyr;
    objectCalendarSettingsData[0].cWorkcalendarsettingsId = cWorkcalendarsettingsId;
    objectCalendarSettingsData[0].validfrom = validfrom;
    objectCalendarSettingsData[0].isactive = isactive;
    objectCalendarSettingsData[0].worktimemonday = worktimemonday;
    objectCalendarSettingsData[0].workbegintimemonday = workbegintimemonday;
    objectCalendarSettingsData[0].worktimetuesday = worktimetuesday;
    objectCalendarSettingsData[0].workbegintimetuesday = workbegintimetuesday;
    objectCalendarSettingsData[0].worktimewednesday = worktimewednesday;
    objectCalendarSettingsData[0].workbegintimewednesday = workbegintimewednesday;
    objectCalendarSettingsData[0].worktimethursday = worktimethursday;
    objectCalendarSettingsData[0].workbegintimethursday = workbegintimethursday;
    objectCalendarSettingsData[0].worktimefriday = worktimefriday;
    objectCalendarSettingsData[0].workbegintimefriday = workbegintimefriday;
    objectCalendarSettingsData[0].worktimesaturday = worktimesaturday;
    objectCalendarSettingsData[0].workbegintimesaturday = workbegintimesaturday;
    objectCalendarSettingsData[0].worktimesunday = worktimesunday;
    objectCalendarSettingsData[0].workbegintimesunday = workbegintimesunday;
    objectCalendarSettingsData[0].adClientId = adClientId;
    objectCalendarSettingsData[0].adOrgId = adOrgId;
    objectCalendarSettingsData[0].language = "";
    return objectCalendarSettingsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef50AE782B0ACB4EDFB29D44B544BFCBF8_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef8D9D62329EC24703AC22005A8A86C4CF_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT C_WORKCALENDARSETTINGS.AD_Org_ID AS NAME" +
      "        FROM C_WORKCALENDARSETTINGS" +
      "        WHERE C_WORKCALENDARSETTINGS.C_Workcalendarsettings_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Org left join (select AD_Org_ID, Name from AD_Org) table1 on (AD_Org.AD_Org_ID = table1.AD_Org_ID) WHERE AD_Org.AD_Org_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Org left join (select AD_Org_ID, Name from AD_Org) table1 on (AD_Org.AD_Org_ID = table1.AD_Org_ID) WHERE AD_Org.AD_Org_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
      "        UPDATE C_WORKCALENDARSETTINGS" +
      "        SET C_Workcalendarsettings_ID = (?) , Validfrom = TO_DATE(?) , Isactive = (?) , Worktimemonday = TO_NUMBER(?) , Workbegintimemonday = TO_TIMESTAMP(?,'HH24:MI:SS') , Worktimetuesday = TO_NUMBER(?) , Workbegintimetuesday = TO_TIMESTAMP(?,'HH24:MI:SS') , Worktimewednesday = TO_NUMBER(?) , Workbegintimewednesday = TO_TIMESTAMP(?,'HH24:MI:SS') , Worktimethursday = TO_NUMBER(?) , Workbegintimethursday = TO_TIMESTAMP(?,'HH24:MI:SS') , Worktimefriday = TO_NUMBER(?) , Workbegintimefriday = TO_TIMESTAMP(?,'HH24:MI:SS') , Worktimesaturday = TO_NUMBER(?) , Workbegintimesaturday = TO_TIMESTAMP(?,'HH24:MI:SS') , Worktimesunday = TO_NUMBER(?) , Workbegintimesunday = TO_TIMESTAMP(?,'HH24:MI:SS') , AD_Client_ID = (?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_WORKCALENDARSETTINGS.C_Workcalendarsettings_ID = ? " +
      "                 AND C_WORKCALENDARSETTINGS.AD_Org_ID = ? " +
      "        AND C_WORKCALENDARSETTINGS.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_WORKCALENDARSETTINGS.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cWorkcalendarsettingsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktimemonday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workbegintimemonday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktimetuesday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workbegintimetuesday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktimewednesday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workbegintimewednesday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktimethursday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workbegintimethursday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktimefriday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workbegintimefriday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktimesaturday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workbegintimesaturday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktimesunday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workbegintimesunday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cWorkcalendarsettingsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
      "        INSERT INTO C_WORKCALENDARSETTINGS " +
      "        (C_Workcalendarsettings_ID, Validfrom, Isactive, Worktimemonday, Workbegintimemonday, Worktimetuesday, Workbegintimetuesday, Worktimewednesday, Workbegintimewednesday, Worktimethursday, Workbegintimethursday, Worktimefriday, Workbegintimefriday, Worktimesaturday, Workbegintimesaturday, Worktimesunday, Workbegintimesunday, AD_Client_ID, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), TO_DATE(?), (?), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cWorkcalendarsettingsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktimemonday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workbegintimemonday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktimetuesday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workbegintimetuesday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktimewednesday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workbegintimewednesday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktimethursday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workbegintimethursday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktimefriday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workbegintimefriday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktimesaturday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workbegintimesaturday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktimesunday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workbegintimesunday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adOrgId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_WORKCALENDARSETTINGS" +
      "        WHERE C_WORKCALENDARSETTINGS.C_Workcalendarsettings_ID = ? " +
      "                 AND C_WORKCALENDARSETTINGS.AD_Org_ID = ? " +
      "        AND C_WORKCALENDARSETTINGS.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_WORKCALENDARSETTINGS.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_WORKCALENDARSETTINGS" +
      "        WHERE C_WORKCALENDARSETTINGS.C_Workcalendarsettings_ID = ? " +
      "                 AND C_WORKCALENDARSETTINGS.AD_Org_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
      "          FROM C_WORKCALENDARSETTINGS" +
      "         WHERE C_WORKCALENDARSETTINGS.C_Workcalendarsettings_ID = ? ";

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
      "          FROM C_WORKCALENDARSETTINGS" +
      "         WHERE C_WORKCALENDARSETTINGS.C_Workcalendarsettings_ID = ? ";

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
