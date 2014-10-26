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
class CalendarEventsB3BA21DE3A024A3CA849DE67F525341DData implements FieldProvider {
static Logger log4j = Logger.getLogger(CalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String maMachineId;
  public String maMachineIdr;
  public String maMachineeventId;
  public String datefrom;
  public String dateto;
  public String cCalendareventId;
  public String cCalendareventIdr;
  public String reminder;
  public String worktime;
  public String note;
  public String isactive;
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
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
    else if (fieldName.equalsIgnoreCase("ma_machine_idr") || fieldName.equals("maMachineIdr"))
      return maMachineIdr;
    else if (fieldName.equalsIgnoreCase("ma_machineevent_id") || fieldName.equals("maMachineeventId"))
      return maMachineeventId;
    else if (fieldName.equalsIgnoreCase("datefrom"))
      return datefrom;
    else if (fieldName.equalsIgnoreCase("dateto"))
      return dateto;
    else if (fieldName.equalsIgnoreCase("c_calendarevent_id") || fieldName.equals("cCalendareventId"))
      return cCalendareventId;
    else if (fieldName.equalsIgnoreCase("c_calendarevent_idr") || fieldName.equals("cCalendareventIdr"))
      return cCalendareventIdr;
    else if (fieldName.equalsIgnoreCase("reminder"))
      return reminder;
    else if (fieldName.equalsIgnoreCase("worktime"))
      return worktime;
    else if (fieldName.equalsIgnoreCase("note"))
      return note;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
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
  public static CalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMachineId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maMachineId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMachineId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ma_machineEVENT.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ma_machineEVENT.CreatedBy) as CreatedByR, " +
      "        to_char(ma_machineEVENT.Updated, ?) as updated, " +
      "        to_char(ma_machineEVENT.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ma_machineEVENT.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ma_machineEVENT.UpdatedBy) as UpdatedByR," +
      "        ma_machineEVENT.MA_Machine_ID, " +
      "(CASE WHEN ma_machineEVENT.MA_Machine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS MA_Machine_IDR, " +
      "ma_machineEVENT.MA_Machineevent_ID, " +
      "ma_machineEVENT.Datefrom, " +
      "ma_machineEVENT.Dateto, " +
      "ma_machineEVENT.C_Calendarevent_ID, " +
      "(CASE WHEN ma_machineEVENT.C_Calendarevent_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Calendarevent_IDR, " +
      "COALESCE(ma_machineEVENT.Reminder, 'N') AS Reminder, " +
      "ma_machineEVENT.Worktime, " +
      "ma_machineEVENT.Note, " +
      "COALESCE(ma_machineEVENT.Isactive, 'N') AS Isactive, " +
      "ma_machineEVENT.AD_Client_ID, " +
      "ma_machineEVENT.AD_Org_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM ma_machineEVENT left join (select MA_Machine_ID, Value, Name from MA_Machine) table1 on (ma_machineEVENT.MA_Machine_ID = table1.MA_Machine_ID) left join (select C_Calendarevent_ID, Name from C_CALENDAREVENT) table2 on (ma_machineEVENT.C_Calendarevent_ID =  table2.C_Calendarevent_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((maMachineId==null || maMachineId.equals(""))?"":"  AND ma_machineEVENT.MA_Machine_ID = ?  ");
    strSql = strSql + 
      "        AND ma_machineEVENT.MA_Machineevent_ID = ? " +
      "        AND ma_machineEVENT.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ma_machineEVENT.AD_Org_ID IN (";
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
        CalendarEventsB3BA21DE3A024A3CA849DE67F525341DData objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData = new CalendarEventsB3BA21DE3A024A3CA849DE67F525341DData();
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.created = UtilSql.getValue(result, "created");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.updated = UtilSql.getValue(result, "updated");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.updatedby = UtilSql.getValue(result, "updatedby");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.maMachineIdr = UtilSql.getValue(result, "ma_machine_idr");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.maMachineeventId = UtilSql.getValue(result, "ma_machineevent_id");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.dateto = UtilSql.getDateValue(result, "dateto", "dd-MM-yyyy");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.cCalendareventId = UtilSql.getValue(result, "c_calendarevent_id");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.cCalendareventIdr = UtilSql.getValue(result, "c_calendarevent_idr");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.reminder = UtilSql.getValue(result, "reminder");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.worktime = UtilSql.getValue(result, "worktime");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.note = UtilSql.getValue(result, "note");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.isactive = UtilSql.getValue(result, "isactive");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.language = UtilSql.getValue(result, "language");
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.adUserClient = "";
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.adOrgClient = "";
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.createdby = "";
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.trBgcolor = "";
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.totalCount = "";
        objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData);
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
    CalendarEventsB3BA21DE3A024A3CA849DE67F525341DData objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[] = new CalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[vector.size()];
    vector.copyInto(objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData);
    return(objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData);
  }

/**
Create a registry
 */
  public static CalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[] set(String maMachineId, String adOrgId, String note, String reminder, String updatedby, String updatedbyr, String worktime, String createdby, String createdbyr, String cCalendareventId, String dateto, String adClientId, String datefrom, String isactive, String maMachineeventId)    throws ServletException {
    CalendarEventsB3BA21DE3A024A3CA849DE67F525341DData objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[] = new CalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[1];
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0] = new CalendarEventsB3BA21DE3A024A3CA849DE67F525341DData();
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].created = "";
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].createdbyr = createdbyr;
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].updated = "";
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].updatedTimeStamp = "";
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].updatedby = updatedby;
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].updatedbyr = updatedbyr;
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].maMachineId = maMachineId;
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].maMachineIdr = "";
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].maMachineeventId = maMachineeventId;
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].datefrom = datefrom;
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].dateto = dateto;
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].cCalendareventId = cCalendareventId;
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].cCalendareventIdr = "";
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].reminder = reminder;
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].worktime = worktime;
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].note = note;
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].isactive = isactive;
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].adClientId = adClientId;
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].adOrgId = adOrgId;
    objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData[0].language = "";
    return objectCalendarEventsB3BA21DE3A024A3CA849DE67F525341DData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefA74C2A2DE5A1433BA2FBD3B2FAE70201_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef61E4D72A54CC4EE490833944A2971DAF_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT ma_machineEVENT.MA_Machine_ID AS NAME" +
      "        FROM ma_machineEVENT" +
      "        WHERE ma_machineEVENT.MA_Machineevent_ID = ?";

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
      "        UPDATE ma_machineEVENT" +
      "        SET MA_Machine_ID = (?) , MA_Machineevent_ID = (?) , Datefrom = TO_DATE(?) , Dateto = TO_DATE(?) , C_Calendarevent_ID = (?) , Reminder = (?) , Worktime = TO_NUMBER(?) , Note = (?) , Isactive = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE ma_machineEVENT.MA_Machineevent_ID = ? " +
      "                 AND ma_machineEVENT.MA_Machine_ID = ? " +
      "        AND ma_machineEVENT.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ma_machineEVENT.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineeventId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reminder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineeventId);
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
      "        INSERT INTO ma_machineEVENT " +
      "        (MA_Machine_ID, MA_Machineevent_ID, Datefrom, Dateto, C_Calendarevent_ID, Reminder, Worktime, Note, Isactive, AD_Client_ID, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_DATE(?), TO_DATE(?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineeventId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reminder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String maMachineId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ma_machineEVENT" +
      "        WHERE ma_machineEVENT.MA_Machineevent_ID = ? " +
      "                 AND ma_machineEVENT.MA_Machine_ID = ? " +
      "        AND ma_machineEVENT.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ma_machineEVENT.AD_Org_ID IN (";
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
      "        DELETE FROM ma_machineEVENT" +
      "        WHERE ma_machineEVENT.MA_Machineevent_ID = ? " +
      "                 AND ma_machineEVENT.MA_Machine_ID = ? ";

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
      "          FROM ma_machineEVENT" +
      "         WHERE ma_machineEVENT.MA_Machineevent_ID = ? ";

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
      "          FROM ma_machineEVENT" +
      "         WHERE ma_machineEVENT.MA_Machineevent_ID = ? ";

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
