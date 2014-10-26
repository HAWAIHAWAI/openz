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
class PeriodControlData implements FieldProvider {
static Logger log4j = Logger.getLogger(PeriodControlData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cPeriodcontrolVId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cCalendarId;
  public String cCalendarIdr;
  public String isactive;
  public String cPeriodId;
  public String cPeriodIdr;
  public String year;
  public String startdate;
  public String enddate;
  public String docbasetype;
  public String docbasetyper;
  public String periodstatus;
  public String periodstatusr;
  public String periodaction;
  public String processing;
  public String name;
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
    else if (fieldName.equalsIgnoreCase("c_periodcontrol_v_id") || fieldName.equals("cPeriodcontrolVId"))
      return cPeriodcontrolVId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_calendar_id") || fieldName.equals("cCalendarId"))
      return cCalendarId;
    else if (fieldName.equalsIgnoreCase("c_calendar_idr") || fieldName.equals("cCalendarIdr"))
      return cCalendarIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_period_id") || fieldName.equals("cPeriodId"))
      return cPeriodId;
    else if (fieldName.equalsIgnoreCase("c_period_idr") || fieldName.equals("cPeriodIdr"))
      return cPeriodIdr;
    else if (fieldName.equalsIgnoreCase("year"))
      return year;
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("enddate"))
      return enddate;
    else if (fieldName.equalsIgnoreCase("docbasetype"))
      return docbasetype;
    else if (fieldName.equalsIgnoreCase("docbasetyper"))
      return docbasetyper;
    else if (fieldName.equalsIgnoreCase("periodstatus"))
      return periodstatus;
    else if (fieldName.equalsIgnoreCase("periodstatusr"))
      return periodstatusr;
    else if (fieldName.equalsIgnoreCase("periodaction"))
      return periodaction;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
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
  public static PeriodControlData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adOrgId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adOrgId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PeriodControlData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adOrgId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_PeriodControl_V.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_PeriodControl_V.CreatedBy) as CreatedByR, " +
      "        to_char(C_PeriodControl_V.Updated, ?) as updated, " +
      "        to_char(C_PeriodControl_V.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_PeriodControl_V.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_PeriodControl_V.UpdatedBy) as UpdatedByR," +
      "        C_PeriodControl_V.C_Periodcontrol_V_ID, " +
      "C_PeriodControl_V.AD_Client_ID, " +
      "(CASE WHEN C_PeriodControl_V.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_PeriodControl_V.AD_Org_ID, " +
      "(CASE WHEN C_PeriodControl_V.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_PeriodControl_V.C_Calendar_ID, " +
      "(CASE WHEN C_PeriodControl_V.C_Calendar_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Calendar_IDR, " +
      "COALESCE(C_PeriodControl_V.Isactive, 'N') AS Isactive, " +
      "C_PeriodControl_V.C_Period_ID, " +
      "(CASE WHEN C_PeriodControl_V.C_Period_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Period_IDR, " +
      "C_PeriodControl_V.Year, " +
      "C_PeriodControl_V.Startdate, " +
      "C_PeriodControl_V.Enddate, " +
      "C_PeriodControl_V.Docbasetype, " +
      "(CASE WHEN C_PeriodControl_V.Docbasetype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DocbasetypeR, " +
      "C_PeriodControl_V.Periodstatus, " +
      "(CASE WHEN C_PeriodControl_V.Periodstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS PeriodstatusR, " +
      "C_PeriodControl_V.Periodaction, " +
      "C_PeriodControl_V.Processing, " +
      "C_PeriodControl_V.Name, " +
      "        ? AS LANGUAGE " +
      "        FROM C_PeriodControl_V left join (select AD_Client_ID, Name from AD_Client) table1 on (C_PeriodControl_V.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_PeriodControl_V.AD_Org_ID = table2.AD_Org_ID) left join (select C_Calendar_ID, Name from C_Calendar) table3 on (C_PeriodControl_V.C_Calendar_ID = table3.C_Calendar_ID) left join (select C_Period_ID, Name from C_Period) table4 on (C_PeriodControl_V.C_Period_ID = table4.C_Period_ID) left join ad_ref_list_v list1 on (C_PeriodControl_V.Docbasetype = list1.value and list1.ad_reference_id = '183' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (C_PeriodControl_V.Periodstatus = list2.value and list2.ad_reference_id = '177' and list2.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":"  AND C_PeriodControl_V.AD_Org_ID = ?  ");
    strSql = strSql + 
      "        AND C_PeriodControl_V.C_Periodcontrol_V_ID = ? " +
      "        AND C_PeriodControl_V.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_PeriodControl_V.AD_Org_ID IN (";
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
        PeriodControlData objectPeriodControlData = new PeriodControlData();
        objectPeriodControlData.created = UtilSql.getValue(result, "created");
        objectPeriodControlData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPeriodControlData.updated = UtilSql.getValue(result, "updated");
        objectPeriodControlData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPeriodControlData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPeriodControlData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPeriodControlData.cPeriodcontrolVId = UtilSql.getValue(result, "c_periodcontrol_v_id");
        objectPeriodControlData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPeriodControlData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectPeriodControlData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPeriodControlData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPeriodControlData.cCalendarId = UtilSql.getValue(result, "c_calendar_id");
        objectPeriodControlData.cCalendarIdr = UtilSql.getValue(result, "c_calendar_idr");
        objectPeriodControlData.isactive = UtilSql.getValue(result, "isactive");
        objectPeriodControlData.cPeriodId = UtilSql.getValue(result, "c_period_id");
        objectPeriodControlData.cPeriodIdr = UtilSql.getValue(result, "c_period_idr");
        objectPeriodControlData.year = UtilSql.getValue(result, "year");
        objectPeriodControlData.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectPeriodControlData.enddate = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
        objectPeriodControlData.docbasetype = UtilSql.getValue(result, "docbasetype");
        objectPeriodControlData.docbasetyper = UtilSql.getValue(result, "docbasetyper");
        objectPeriodControlData.periodstatus = UtilSql.getValue(result, "periodstatus");
        objectPeriodControlData.periodstatusr = UtilSql.getValue(result, "periodstatusr");
        objectPeriodControlData.periodaction = UtilSql.getValue(result, "periodaction");
        objectPeriodControlData.processing = UtilSql.getValue(result, "processing");
        objectPeriodControlData.name = UtilSql.getValue(result, "name");
        objectPeriodControlData.language = UtilSql.getValue(result, "language");
        objectPeriodControlData.adUserClient = "";
        objectPeriodControlData.adOrgClient = "";
        objectPeriodControlData.createdby = "";
        objectPeriodControlData.trBgcolor = "";
        objectPeriodControlData.totalCount = "";
        objectPeriodControlData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPeriodControlData);
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
    PeriodControlData objectPeriodControlData[] = new PeriodControlData[vector.size()];
    vector.copyInto(objectPeriodControlData);
    return(objectPeriodControlData);
  }

/**
Create a registry
 */
  public static PeriodControlData[] set(String adOrgId, String periodstatus, String periodaction, String docbasetype, String cPeriodcontrolVId, String enddate, String startdate, String adClientId, String isactive, String processing, String year, String createdby, String createdbyr, String updatedby, String updatedbyr, String cPeriodId, String name, String cCalendarId)    throws ServletException {
    PeriodControlData objectPeriodControlData[] = new PeriodControlData[1];
    objectPeriodControlData[0] = new PeriodControlData();
    objectPeriodControlData[0].created = "";
    objectPeriodControlData[0].createdbyr = createdbyr;
    objectPeriodControlData[0].updated = "";
    objectPeriodControlData[0].updatedTimeStamp = "";
    objectPeriodControlData[0].updatedby = updatedby;
    objectPeriodControlData[0].updatedbyr = updatedbyr;
    objectPeriodControlData[0].cPeriodcontrolVId = cPeriodcontrolVId;
    objectPeriodControlData[0].adClientId = adClientId;
    objectPeriodControlData[0].adClientIdr = "";
    objectPeriodControlData[0].adOrgId = adOrgId;
    objectPeriodControlData[0].adOrgIdr = "";
    objectPeriodControlData[0].cCalendarId = cCalendarId;
    objectPeriodControlData[0].cCalendarIdr = "";
    objectPeriodControlData[0].isactive = isactive;
    objectPeriodControlData[0].cPeriodId = cPeriodId;
    objectPeriodControlData[0].cPeriodIdr = "";
    objectPeriodControlData[0].year = year;
    objectPeriodControlData[0].startdate = startdate;
    objectPeriodControlData[0].enddate = enddate;
    objectPeriodControlData[0].docbasetype = docbasetype;
    objectPeriodControlData[0].docbasetyper = "";
    objectPeriodControlData[0].periodstatus = periodstatus;
    objectPeriodControlData[0].periodstatusr = "";
    objectPeriodControlData[0].periodaction = periodaction;
    objectPeriodControlData[0].processing = processing;
    objectPeriodControlData[0].name = name;
    objectPeriodControlData[0].language = "";
    return objectPeriodControlData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef60FCCD631EA7EDF8E040007F01013AD4_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef60FCCD631EA9EDF8E040007F01013AD4_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_PeriodControl_V.AD_Org_ID AS NAME" +
      "        FROM C_PeriodControl_V" +
      "        WHERE C_PeriodControl_V.C_Periodcontrol_V_ID = ?";

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
      "        UPDATE C_PeriodControl_V" +
      "        SET C_Periodcontrol_V_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_Calendar_ID = (?) , Isactive = (?) , C_Period_ID = (?) , Year = (?) , Startdate = TO_DATE(?) , Enddate = TO_DATE(?) , Docbasetype = (?) , Periodstatus = (?) , Periodaction = (?) , Processing = (?) , Name = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_PeriodControl_V.C_Periodcontrol_V_ID = ? " +
      "                 AND C_PeriodControl_V.AD_Org_ID = ? " +
      "        AND C_PeriodControl_V.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_PeriodControl_V.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodcontrolVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendarId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, year);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbasetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodcontrolVId);
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
      "        INSERT INTO C_PeriodControl_V " +
      "        (C_Periodcontrol_V_ID, AD_Client_ID, AD_Org_ID, C_Calendar_ID, Isactive, C_Period_ID, Year, Startdate, Enddate, Docbasetype, Periodstatus, Periodaction, Processing, Name, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodcontrolVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendarId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, year);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbasetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
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
      "        DELETE FROM C_PeriodControl_V" +
      "        WHERE C_PeriodControl_V.C_Periodcontrol_V_ID = ? " +
      "                 AND C_PeriodControl_V.AD_Org_ID = ? " +
      "        AND C_PeriodControl_V.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_PeriodControl_V.AD_Org_ID IN (";
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
      "        DELETE FROM C_PeriodControl_V" +
      "        WHERE C_PeriodControl_V.C_Periodcontrol_V_ID = ? " +
      "                 AND C_PeriodControl_V.AD_Org_ID = ? ";

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
      "          FROM C_PeriodControl_V" +
      "         WHERE C_PeriodControl_V.C_Periodcontrol_V_ID = ? ";

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
      "          FROM C_PeriodControl_V" +
      "         WHERE C_PeriodControl_V.C_Periodcontrol_V_ID = ? ";

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
