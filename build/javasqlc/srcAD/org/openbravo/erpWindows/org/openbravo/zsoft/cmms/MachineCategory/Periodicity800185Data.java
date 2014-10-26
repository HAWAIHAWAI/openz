//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.cmms.MachineCategory;

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
class Periodicity800185Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Periodicity800185Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String maMaintPeriodicityId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String maMaintenanceId;
  public String maMaintenanceIdr;
  public String isactive;
  public String periodicityType;
  public String periodicityTyper;
  public String shift;
  public String shiftr;
  public String monthday;
  public String initdate;
  public String weekday;
  public String weekdayr;
  public String excludeweekend;
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
    else if (fieldName.equalsIgnoreCase("ma_maint_periodicity_id") || fieldName.equals("maMaintPeriodicityId"))
      return maMaintPeriodicityId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ma_maintenance_id") || fieldName.equals("maMaintenanceId"))
      return maMaintenanceId;
    else if (fieldName.equalsIgnoreCase("ma_maintenance_idr") || fieldName.equals("maMaintenanceIdr"))
      return maMaintenanceIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("periodicity_type") || fieldName.equals("periodicityType"))
      return periodicityType;
    else if (fieldName.equalsIgnoreCase("periodicity_typer") || fieldName.equals("periodicityTyper"))
      return periodicityTyper;
    else if (fieldName.equalsIgnoreCase("shift"))
      return shift;
    else if (fieldName.equalsIgnoreCase("shiftr"))
      return shiftr;
    else if (fieldName.equalsIgnoreCase("monthday"))
      return monthday;
    else if (fieldName.equalsIgnoreCase("initdate"))
      return initdate;
    else if (fieldName.equalsIgnoreCase("weekday"))
      return weekday;
    else if (fieldName.equalsIgnoreCase("weekdayr"))
      return weekdayr;
    else if (fieldName.equalsIgnoreCase("excludeweekend"))
      return excludeweekend;
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
  public static Periodicity800185Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMaintenanceId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maMaintenanceId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Periodicity800185Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMaintenanceId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_Maint_Periodicity.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Maint_Periodicity.CreatedBy) as CreatedByR, " +
      "        to_char(MA_Maint_Periodicity.Updated, ?) as updated, " +
      "        to_char(MA_Maint_Periodicity.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_Maint_Periodicity.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Maint_Periodicity.UpdatedBy) as UpdatedByR," +
      "        MA_Maint_Periodicity.MA_Maint_Periodicity_ID, " +
      "MA_Maint_Periodicity.AD_Client_ID, " +
      "(CASE WHEN MA_Maint_Periodicity.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MA_Maint_Periodicity.AD_Org_ID, " +
      "(CASE WHEN MA_Maint_Periodicity.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "MA_Maint_Periodicity.MA_Maintenance_ID, " +
      "(CASE WHEN MA_Maint_Periodicity.MA_Maintenance_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS MA_Maintenance_IDR, " +
      "COALESCE(MA_Maint_Periodicity.IsActive, 'N') AS IsActive, " +
      "MA_Maint_Periodicity.Periodicity_Type, " +
      "(CASE WHEN MA_Maint_Periodicity.Periodicity_Type IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS Periodicity_TypeR, " +
      "MA_Maint_Periodicity.Shift, " +
      "(CASE WHEN MA_Maint_Periodicity.Shift IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS ShiftR, " +
      "MA_Maint_Periodicity.Monthday, " +
      "MA_Maint_Periodicity.Initdate, " +
      "MA_Maint_Periodicity.WeekDay, " +
      "(CASE WHEN MA_Maint_Periodicity.WeekDay IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS WeekDayR, " +
      "COALESCE(MA_Maint_Periodicity.Excludeweekend, 'N') AS Excludeweekend, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_Maint_Periodicity left join (select AD_Client_ID, Name from AD_Client) table1 on (MA_Maint_Periodicity.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MA_Maint_Periodicity.AD_Org_ID = table2.AD_Org_ID) left join (select MA_Maintenance_ID, Name from MA_Maintenance) table3 on (MA_Maint_Periodicity.MA_Maintenance_ID = table3.MA_Maintenance_ID) left join ad_ref_list_v list1 on (MA_Maint_Periodicity.Periodicity_Type = list1.value and list1.ad_reference_id = '800065' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (MA_Maint_Periodicity.Shift = list2.value and list2.ad_reference_id = '800038' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (MA_Maint_Periodicity.WeekDay = list3.value and list3.ad_reference_id = '167' and list3.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((maMaintenanceId==null || maMaintenanceId.equals(""))?"":"  AND MA_Maint_Periodicity.MA_Maintenance_ID = ?  ");
    strSql = strSql + 
      "        AND MA_Maint_Periodicity.MA_Maint_Periodicity_ID = ? " +
      "        AND MA_Maint_Periodicity.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_Maint_Periodicity.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (maMaintenanceId != null && !(maMaintenanceId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintenanceId);
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
        Periodicity800185Data objectPeriodicity800185Data = new Periodicity800185Data();
        objectPeriodicity800185Data.created = UtilSql.getValue(result, "created");
        objectPeriodicity800185Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPeriodicity800185Data.updated = UtilSql.getValue(result, "updated");
        objectPeriodicity800185Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPeriodicity800185Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectPeriodicity800185Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPeriodicity800185Data.maMaintPeriodicityId = UtilSql.getValue(result, "ma_maint_periodicity_id");
        objectPeriodicity800185Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPeriodicity800185Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectPeriodicity800185Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPeriodicity800185Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPeriodicity800185Data.maMaintenanceId = UtilSql.getValue(result, "ma_maintenance_id");
        objectPeriodicity800185Data.maMaintenanceIdr = UtilSql.getValue(result, "ma_maintenance_idr");
        objectPeriodicity800185Data.isactive = UtilSql.getValue(result, "isactive");
        objectPeriodicity800185Data.periodicityType = UtilSql.getValue(result, "periodicity_type");
        objectPeriodicity800185Data.periodicityTyper = UtilSql.getValue(result, "periodicity_typer");
        objectPeriodicity800185Data.shift = UtilSql.getValue(result, "shift");
        objectPeriodicity800185Data.shiftr = UtilSql.getValue(result, "shiftr");
        objectPeriodicity800185Data.monthday = UtilSql.getValue(result, "monthday");
        objectPeriodicity800185Data.initdate = UtilSql.getDateValue(result, "initdate", "dd-MM-yyyy");
        objectPeriodicity800185Data.weekday = UtilSql.getValue(result, "weekday");
        objectPeriodicity800185Data.weekdayr = UtilSql.getValue(result, "weekdayr");
        objectPeriodicity800185Data.excludeweekend = UtilSql.getValue(result, "excludeweekend");
        objectPeriodicity800185Data.language = UtilSql.getValue(result, "language");
        objectPeriodicity800185Data.adUserClient = "";
        objectPeriodicity800185Data.adOrgClient = "";
        objectPeriodicity800185Data.createdby = "";
        objectPeriodicity800185Data.trBgcolor = "";
        objectPeriodicity800185Data.totalCount = "";
        objectPeriodicity800185Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPeriodicity800185Data);
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
    Periodicity800185Data objectPeriodicity800185Data[] = new Periodicity800185Data[vector.size()];
    vector.copyInto(objectPeriodicity800185Data);
    return(objectPeriodicity800185Data);
  }

/**
Create a registry
 */
  public static Periodicity800185Data[] set(String maMaintenanceId, String adOrgId, String createdby, String createdbyr, String maMaintPeriodicityId, String updatedby, String updatedbyr, String periodicityType, String shift, String initdate, String adClientId, String monthday, String excludeweekend, String weekday, String isactive)    throws ServletException {
    Periodicity800185Data objectPeriodicity800185Data[] = new Periodicity800185Data[1];
    objectPeriodicity800185Data[0] = new Periodicity800185Data();
    objectPeriodicity800185Data[0].created = "";
    objectPeriodicity800185Data[0].createdbyr = createdbyr;
    objectPeriodicity800185Data[0].updated = "";
    objectPeriodicity800185Data[0].updatedTimeStamp = "";
    objectPeriodicity800185Data[0].updatedby = updatedby;
    objectPeriodicity800185Data[0].updatedbyr = updatedbyr;
    objectPeriodicity800185Data[0].maMaintPeriodicityId = maMaintPeriodicityId;
    objectPeriodicity800185Data[0].adClientId = adClientId;
    objectPeriodicity800185Data[0].adClientIdr = "";
    objectPeriodicity800185Data[0].adOrgId = adOrgId;
    objectPeriodicity800185Data[0].adOrgIdr = "";
    objectPeriodicity800185Data[0].maMaintenanceId = maMaintenanceId;
    objectPeriodicity800185Data[0].maMaintenanceIdr = "";
    objectPeriodicity800185Data[0].isactive = isactive;
    objectPeriodicity800185Data[0].periodicityType = periodicityType;
    objectPeriodicity800185Data[0].periodicityTyper = "";
    objectPeriodicity800185Data[0].shift = shift;
    objectPeriodicity800185Data[0].shiftr = "";
    objectPeriodicity800185Data[0].monthday = monthday;
    objectPeriodicity800185Data[0].initdate = initdate;
    objectPeriodicity800185Data[0].weekday = weekday;
    objectPeriodicity800185Data[0].weekdayr = "";
    objectPeriodicity800185Data[0].excludeweekend = excludeweekend;
    objectPeriodicity800185Data[0].language = "";
    return objectPeriodicity800185Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef802628_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef802630_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT MA_Maint_Periodicity.MA_Maintenance_ID AS NAME" +
      "        FROM MA_Maint_Periodicity" +
      "        WHERE MA_Maint_Periodicity.MA_Maint_Periodicity_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String maMaintenanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM MA_Maintenance left join (select MA_Maintenance_ID, Name from MA_Maintenance) table1 on (MA_Maintenance.MA_Maintenance_ID = table1.MA_Maintenance_ID) WHERE MA_Maintenance.MA_Maintenance_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintenanceId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String maMaintenanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM MA_Maintenance left join (select MA_Maintenance_ID, Name from MA_Maintenance) table1 on (MA_Maintenance.MA_Maintenance_ID = table1.MA_Maintenance_ID) WHERE MA_Maintenance.MA_Maintenance_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintenanceId);

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
      "        UPDATE MA_Maint_Periodicity" +
      "        SET MA_Maint_Periodicity_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , MA_Maintenance_ID = (?) , IsActive = (?) , Periodicity_Type = (?) , Shift = (?) , Monthday = TO_NUMBER(?) , Initdate = TO_DATE(?) , WeekDay = (?) , Excludeweekend = (?) , updated = now(), updatedby = ? " +
      "        WHERE MA_Maint_Periodicity.MA_Maint_Periodicity_ID = ? " +
      "                 AND MA_Maint_Periodicity.MA_Maintenance_ID = ? " +
      "        AND MA_Maint_Periodicity.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Maint_Periodicity.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintPeriodicityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintenanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodicityType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shift);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, monthday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, initdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weekday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, excludeweekend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintPeriodicityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintenanceId);
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
      "        INSERT INTO MA_Maint_Periodicity " +
      "        (MA_Maint_Periodicity_ID, AD_Client_ID, AD_Org_ID, MA_Maintenance_ID, IsActive, Periodicity_Type, Shift, Monthday, Initdate, WeekDay, Excludeweekend, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_DATE(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintPeriodicityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintenanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodicityType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shift);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, monthday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, initdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weekday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, excludeweekend);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String maMaintenanceId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Maint_Periodicity" +
      "        WHERE MA_Maint_Periodicity.MA_Maint_Periodicity_ID = ? " +
      "                 AND MA_Maint_Periodicity.MA_Maintenance_ID = ? " +
      "        AND MA_Maint_Periodicity.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Maint_Periodicity.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintenanceId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String maMaintenanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Maint_Periodicity" +
      "        WHERE MA_Maint_Periodicity.MA_Maint_Periodicity_ID = ? " +
      "                 AND MA_Maint_Periodicity.MA_Maintenance_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintenanceId);

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
      "          FROM MA_Maint_Periodicity" +
      "         WHERE MA_Maint_Periodicity.MA_Maint_Periodicity_ID = ? ";

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
      "          FROM MA_Maint_Periodicity" +
      "         WHERE MA_Maint_Periodicity.MA_Maint_Periodicity_ID = ? ";

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
