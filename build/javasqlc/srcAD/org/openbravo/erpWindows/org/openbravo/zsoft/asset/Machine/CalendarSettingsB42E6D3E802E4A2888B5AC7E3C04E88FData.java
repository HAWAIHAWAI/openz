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
class CalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData implements FieldProvider {
static Logger log4j = Logger.getLogger(CalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String maMachinecalendarsettingsId;
  public String maMachineId;
  public String maMachineIdr;
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
    else if (fieldName.equalsIgnoreCase("ma_machinecalendarsettings_id") || fieldName.equals("maMachinecalendarsettingsId"))
      return maMachinecalendarsettingsId;
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
    else if (fieldName.equalsIgnoreCase("ma_machine_idr") || fieldName.equals("maMachineIdr"))
      return maMachineIdr;
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
  public static CalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMachineId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maMachineId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMachineId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ma_machineCALENDARSETTINGS.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ma_machineCALENDARSETTINGS.CreatedBy) as CreatedByR, " +
      "        to_char(ma_machineCALENDARSETTINGS.Updated, ?) as updated, " +
      "        to_char(ma_machineCALENDARSETTINGS.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ma_machineCALENDARSETTINGS.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ma_machineCALENDARSETTINGS.UpdatedBy) as UpdatedByR," +
      "        ma_machineCALENDARSETTINGS.MA_Machinecalendarsettings_ID, " +
      "ma_machineCALENDARSETTINGS.MA_Machine_ID, " +
      "(CASE WHEN ma_machineCALENDARSETTINGS.MA_Machine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS MA_Machine_IDR, " +
      "ma_machineCALENDARSETTINGS.Validfrom, " +
      "COALESCE(ma_machineCALENDARSETTINGS.Isactive, 'N') AS Isactive, " +
      "ma_machineCALENDARSETTINGS.Worktimemonday, " +
      "TO_CHAR(ma_machineCALENDARSETTINGS.Workbegintimemonday, 'HH24:MI:SS') AS Workbegintimemonday, " +
      "ma_machineCALENDARSETTINGS.Worktimetuesday, " +
      "TO_CHAR(ma_machineCALENDARSETTINGS.Workbegintimetuesday, 'HH24:MI:SS') AS Workbegintimetuesday, " +
      "ma_machineCALENDARSETTINGS.Worktimewednesday, " +
      "TO_CHAR(ma_machineCALENDARSETTINGS.Workbegintimewednesday, 'HH24:MI:SS') AS Workbegintimewednesday, " +
      "ma_machineCALENDARSETTINGS.Worktimethursday, " +
      "TO_CHAR(ma_machineCALENDARSETTINGS.Workbegintimethursday, 'HH24:MI:SS') AS Workbegintimethursday, " +
      "ma_machineCALENDARSETTINGS.Worktimefriday, " +
      "TO_CHAR(ma_machineCALENDARSETTINGS.Workbegintimefriday, 'HH24:MI:SS') AS Workbegintimefriday, " +
      "ma_machineCALENDARSETTINGS.Worktimesaturday, " +
      "TO_CHAR(ma_machineCALENDARSETTINGS.Workbegintimesaturday, 'HH24:MI:SS') AS Workbegintimesaturday, " +
      "ma_machineCALENDARSETTINGS.Worktimesunday, " +
      "TO_CHAR(ma_machineCALENDARSETTINGS.Workbegintimesunday, 'HH24:MI:SS') AS Workbegintimesunday, " +
      "ma_machineCALENDARSETTINGS.AD_Client_ID, " +
      "ma_machineCALENDARSETTINGS.AD_Org_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM ma_machineCALENDARSETTINGS left join (select MA_Machine_ID, Value, Name from MA_Machine) table1 on (ma_machineCALENDARSETTINGS.MA_Machine_ID = table1.MA_Machine_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((maMachineId==null || maMachineId.equals(""))?"":"  AND ma_machineCALENDARSETTINGS.MA_Machine_ID = ?  ");
    strSql = strSql + 
      "        AND ma_machineCALENDARSETTINGS.MA_Machinecalendarsettings_ID = ? " +
      "        AND ma_machineCALENDARSETTINGS.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ma_machineCALENDARSETTINGS.AD_Org_ID IN (";
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
        CalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData = new CalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData();
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.created = UtilSql.getValue(result, "created");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.updated = UtilSql.getValue(result, "updated");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.updatedby = UtilSql.getValue(result, "updatedby");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.maMachinecalendarsettingsId = UtilSql.getValue(result, "ma_machinecalendarsettings_id");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.maMachineIdr = UtilSql.getValue(result, "ma_machine_idr");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.validfrom = UtilSql.getDateValue(result, "validfrom", "dd-MM-yyyy");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.isactive = UtilSql.getValue(result, "isactive");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.worktimemonday = UtilSql.getValue(result, "worktimemonday");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.workbegintimemonday = UtilSql.getValue(result, "workbegintimemonday");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.worktimetuesday = UtilSql.getValue(result, "worktimetuesday");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.workbegintimetuesday = UtilSql.getValue(result, "workbegintimetuesday");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.worktimewednesday = UtilSql.getValue(result, "worktimewednesday");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.workbegintimewednesday = UtilSql.getValue(result, "workbegintimewednesday");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.worktimethursday = UtilSql.getValue(result, "worktimethursday");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.workbegintimethursday = UtilSql.getValue(result, "workbegintimethursday");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.worktimefriday = UtilSql.getValue(result, "worktimefriday");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.workbegintimefriday = UtilSql.getValue(result, "workbegintimefriday");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.worktimesaturday = UtilSql.getValue(result, "worktimesaturday");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.workbegintimesaturday = UtilSql.getValue(result, "workbegintimesaturday");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.worktimesunday = UtilSql.getValue(result, "worktimesunday");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.workbegintimesunday = UtilSql.getValue(result, "workbegintimesunday");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.language = UtilSql.getValue(result, "language");
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.adUserClient = "";
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.adOrgClient = "";
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.createdby = "";
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.trBgcolor = "";
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.totalCount = "";
        objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData);
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
    CalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[] = new CalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[vector.size()];
    vector.copyInto(objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData);
    return(objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData);
  }

/**
Create a registry
 */
  public static CalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[] set(String maMachineId, String workbegintimesunday, String worktimewednesday, String adClientId, String worktimetuesday, String workbegintimefriday, String worktimethursday, String workbegintimewednesday, String worktimemonday, String worktimefriday, String worktimesaturday, String validfrom, String adOrgId, String workbegintimethursday, String workbegintimesaturday, String isactive, String maMachinecalendarsettingsId, String worktimesunday, String workbegintimemonday, String createdby, String createdbyr, String workbegintimetuesday, String updatedby, String updatedbyr)    throws ServletException {
    CalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[] = new CalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[1];
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0] = new CalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData();
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].created = "";
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].createdbyr = createdbyr;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].updated = "";
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].updatedTimeStamp = "";
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].updatedby = updatedby;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].updatedbyr = updatedbyr;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].maMachinecalendarsettingsId = maMachinecalendarsettingsId;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].maMachineId = maMachineId;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].maMachineIdr = "";
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].validfrom = validfrom;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].isactive = isactive;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].worktimemonday = worktimemonday;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].workbegintimemonday = workbegintimemonday;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].worktimetuesday = worktimetuesday;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].workbegintimetuesday = workbegintimetuesday;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].worktimewednesday = worktimewednesday;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].workbegintimewednesday = workbegintimewednesday;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].worktimethursday = worktimethursday;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].workbegintimethursday = workbegintimethursday;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].worktimefriday = worktimefriday;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].workbegintimefriday = workbegintimefriday;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].worktimesaturday = worktimesaturday;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].workbegintimesaturday = workbegintimesaturday;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].worktimesunday = worktimesunday;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].workbegintimesunday = workbegintimesunday;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].adClientId = adClientId;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].adOrgId = adOrgId;
    objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData[0].language = "";
    return objectCalendarSettingsB42E6D3E802E4A2888B5AC7E3C04E88FData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef4CB4FC98B1034D5CA50FAC31BCE68A5A_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefC6AAECB9D2CE4BABBDB9F2E53DA381C7_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT ma_machineCALENDARSETTINGS.MA_Machine_ID AS NAME" +
      "        FROM ma_machineCALENDARSETTINGS" +
      "        WHERE ma_machineCALENDARSETTINGS.MA_Machinecalendarsettings_ID = ?";

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
      "        UPDATE ma_machineCALENDARSETTINGS" +
      "        SET MA_Machinecalendarsettings_ID = (?) , MA_Machine_ID = (?) , Validfrom = TO_DATE(?) , Isactive = (?) , Worktimemonday = TO_NUMBER(?) , Workbegintimemonday = TO_TIMESTAMP(?,'HH24:MI:SS') , Worktimetuesday = TO_NUMBER(?) , Workbegintimetuesday = TO_TIMESTAMP(?,'HH24:MI:SS') , Worktimewednesday = TO_NUMBER(?) , Workbegintimewednesday = TO_TIMESTAMP(?,'HH24:MI:SS') , Worktimethursday = TO_NUMBER(?) , Workbegintimethursday = TO_TIMESTAMP(?,'HH24:MI:SS') , Worktimefriday = TO_NUMBER(?) , Workbegintimefriday = TO_TIMESTAMP(?,'HH24:MI:SS') , Worktimesaturday = TO_NUMBER(?) , Workbegintimesaturday = TO_TIMESTAMP(?,'HH24:MI:SS') , Worktimesunday = TO_NUMBER(?) , Workbegintimesunday = TO_TIMESTAMP(?,'HH24:MI:SS') , AD_Client_ID = (?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE ma_machineCALENDARSETTINGS.MA_Machinecalendarsettings_ID = ? " +
      "                 AND ma_machineCALENDARSETTINGS.MA_Machine_ID = ? " +
      "        AND ma_machineCALENDARSETTINGS.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ma_machineCALENDARSETTINGS.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachinecalendarsettingsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachinecalendarsettingsId);
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
      "        INSERT INTO ma_machineCALENDARSETTINGS " +
      "        (MA_Machinecalendarsettings_ID, MA_Machine_ID, Validfrom, Isactive, Worktimemonday, Workbegintimemonday, Worktimetuesday, Workbegintimetuesday, Worktimewednesday, Workbegintimewednesday, Worktimethursday, Workbegintimethursday, Worktimefriday, Workbegintimefriday, Worktimesaturday, Workbegintimesaturday, Worktimesunday, Workbegintimesunday, AD_Client_ID, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_DATE(?), (?), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachinecalendarsettingsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String maMachineId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ma_machineCALENDARSETTINGS" +
      "        WHERE ma_machineCALENDARSETTINGS.MA_Machinecalendarsettings_ID = ? " +
      "                 AND ma_machineCALENDARSETTINGS.MA_Machine_ID = ? " +
      "        AND ma_machineCALENDARSETTINGS.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ma_machineCALENDARSETTINGS.AD_Org_ID IN (";
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
      "        DELETE FROM ma_machineCALENDARSETTINGS" +
      "        WHERE ma_machineCALENDARSETTINGS.MA_Machinecalendarsettings_ID = ? " +
      "                 AND ma_machineCALENDARSETTINGS.MA_Machine_ID = ? ";

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
      "          FROM ma_machineCALENDARSETTINGS" +
      "         WHERE ma_machineCALENDARSETTINGS.MA_Machinecalendarsettings_ID = ? ";

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
      "          FROM ma_machineCALENDARSETTINGS" +
      "         WHERE ma_machineCALENDARSETTINGS.MA_Machinecalendarsettings_ID = ? ";

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
