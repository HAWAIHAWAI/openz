//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.cmms.MaintenanceOrder;

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
class Task800192Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Task800192Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String maMaintScheduledId;
  public String adOrgId;
  public String adOrgIdr;
  public String maMaintPartId;
  public String maMaintPartIdr;
  public String isactive;
  public String maMaintenanceId;
  public String maMaintenanceIdr;
  public String scheduleddate;
  public String shift;
  public String shiftr;
  public String maintenanceType;
  public String maintenanceTyper;
  public String maMachineId;
  public String maMachineIdr;
  public String maMachineTypeId;
  public String maMachineTypeIdr;
  public String maMaintOperationId;
  public String maMaintOperationIdr;
  public String description;
  public String confirmed;
  public String result;
  public String usedtime;
  public String observation;
  public String mInternalConsumptionId;
  public String mInternalConsumptionIdr;
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
    else if (fieldName.equalsIgnoreCase("ma_maint_scheduled_id") || fieldName.equals("maMaintScheduledId"))
      return maMaintScheduledId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ma_maint_part_id") || fieldName.equals("maMaintPartId"))
      return maMaintPartId;
    else if (fieldName.equalsIgnoreCase("ma_maint_part_idr") || fieldName.equals("maMaintPartIdr"))
      return maMaintPartIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ma_maintenance_id") || fieldName.equals("maMaintenanceId"))
      return maMaintenanceId;
    else if (fieldName.equalsIgnoreCase("ma_maintenance_idr") || fieldName.equals("maMaintenanceIdr"))
      return maMaintenanceIdr;
    else if (fieldName.equalsIgnoreCase("scheduleddate"))
      return scheduleddate;
    else if (fieldName.equalsIgnoreCase("shift"))
      return shift;
    else if (fieldName.equalsIgnoreCase("shiftr"))
      return shiftr;
    else if (fieldName.equalsIgnoreCase("maintenance_type") || fieldName.equals("maintenanceType"))
      return maintenanceType;
    else if (fieldName.equalsIgnoreCase("maintenance_typer") || fieldName.equals("maintenanceTyper"))
      return maintenanceTyper;
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
    else if (fieldName.equalsIgnoreCase("ma_machine_idr") || fieldName.equals("maMachineIdr"))
      return maMachineIdr;
    else if (fieldName.equalsIgnoreCase("ma_machine_type_id") || fieldName.equals("maMachineTypeId"))
      return maMachineTypeId;
    else if (fieldName.equalsIgnoreCase("ma_machine_type_idr") || fieldName.equals("maMachineTypeIdr"))
      return maMachineTypeIdr;
    else if (fieldName.equalsIgnoreCase("ma_maint_operation_id") || fieldName.equals("maMaintOperationId"))
      return maMaintOperationId;
    else if (fieldName.equalsIgnoreCase("ma_maint_operation_idr") || fieldName.equals("maMaintOperationIdr"))
      return maMaintOperationIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("confirmed"))
      return confirmed;
    else if (fieldName.equalsIgnoreCase("result"))
      return result;
    else if (fieldName.equalsIgnoreCase("usedtime"))
      return usedtime;
    else if (fieldName.equalsIgnoreCase("observation"))
      return observation;
    else if (fieldName.equalsIgnoreCase("m_internal_consumption_id") || fieldName.equals("mInternalConsumptionId"))
      return mInternalConsumptionId;
    else if (fieldName.equalsIgnoreCase("m_internal_consumption_idr") || fieldName.equals("mInternalConsumptionIdr"))
      return mInternalConsumptionIdr;
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
  public static Task800192Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMaintPartId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maMaintPartId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Task800192Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMaintPartId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_Maint_Scheduled.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Maint_Scheduled.CreatedBy) as CreatedByR, " +
      "        to_char(MA_Maint_Scheduled.Updated, ?) as updated, " +
      "        to_char(MA_Maint_Scheduled.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_Maint_Scheduled.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Maint_Scheduled.UpdatedBy) as UpdatedByR," +
      "        MA_Maint_Scheduled.AD_Client_ID, " +
      "(CASE WHEN MA_Maint_Scheduled.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MA_Maint_Scheduled.MA_Maint_Scheduled_ID, " +
      "MA_Maint_Scheduled.AD_Org_ID, " +
      "(CASE WHEN MA_Maint_Scheduled.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "MA_Maint_Scheduled.MA_Maint_Part_ID, " +
      "(CASE WHEN MA_Maint_Scheduled.MA_Maint_Part_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'') ) END) AS MA_Maint_Part_IDR, " +
      "COALESCE(MA_Maint_Scheduled.IsActive, 'N') AS IsActive, " +
      "MA_Maint_Scheduled.MA_Maintenance_ID, " +
      "(CASE WHEN MA_Maint_Scheduled.MA_Maintenance_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS MA_Maintenance_IDR, " +
      "MA_Maint_Scheduled.Scheduleddate, " +
      "MA_Maint_Scheduled.Shift, " +
      "(CASE WHEN MA_Maint_Scheduled.Shift IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ShiftR, " +
      "MA_Maint_Scheduled.Maintenance_Type, " +
      "(CASE WHEN MA_Maint_Scheduled.Maintenance_Type IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS Maintenance_TypeR, " +
      "MA_Maint_Scheduled.MA_Machine_ID, " +
      "(CASE WHEN MA_Maint_Scheduled.MA_Machine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS MA_Machine_IDR, " +
      "MA_Maint_Scheduled.MA_Machine_Type_ID, " +
      "(CASE WHEN MA_Maint_Scheduled.MA_Machine_Type_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS MA_Machine_Type_IDR, " +
      "MA_Maint_Scheduled.MA_Maint_Operation_ID, " +
      "(CASE WHEN MA_Maint_Scheduled.MA_Maint_Operation_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS MA_Maint_Operation_IDR, " +
      "MA_Maint_Scheduled.Description, " +
      "COALESCE(MA_Maint_Scheduled.Confirmed, 'N') AS Confirmed, " +
      "COALESCE(MA_Maint_Scheduled.Result, 'N') AS Result, " +
      "MA_Maint_Scheduled.Usedtime, " +
      "MA_Maint_Scheduled.Observation, " +
      "MA_Maint_Scheduled.M_Internal_Consumption_ID, " +
      "(CASE WHEN MA_Maint_Scheduled.M_Internal_Consumption_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS M_Internal_Consumption_IDR, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_Maint_Scheduled left join (select AD_Client_ID, Name from AD_Client) table1 on (MA_Maint_Scheduled.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MA_Maint_Scheduled.AD_Org_ID = table2.AD_Org_ID) left join (select MA_Maint_Part_ID, DocumentNo from MA_Maint_Part) table3 on (MA_Maint_Scheduled.MA_Maint_Part_ID = table3.MA_Maint_Part_ID) left join (select MA_Maintenance_ID, Name from MA_Maintenance) table4 on (MA_Maint_Scheduled.MA_Maintenance_ID = table4.MA_Maintenance_ID) left join ad_ref_list_v list1 on (MA_Maint_Scheduled.Shift = list1.value and list1.ad_reference_id = '800038' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (MA_Maint_Scheduled.Maintenance_Type = list2.value and list2.ad_reference_id = '800033' and list2.ad_language = ?)  left join (select MA_Machine_ID, Value, Name from MA_Machine) table5 on (MA_Maint_Scheduled.MA_Machine_ID = table5.MA_Machine_ID) left join (select MA_Machine_Type_ID, Name from MA_Machine_Type) table6 on (MA_Maint_Scheduled.MA_Machine_Type_ID = table6.MA_Machine_Type_ID) left join (select MA_Maint_Operation_ID, Name from MA_Maint_Operation) table7 on (MA_Maint_Scheduled.MA_Maint_Operation_ID = table7.MA_Maint_Operation_ID) left join (select M_Internal_Consumption_ID, Name from M_Internal_Consumption) table8 on (MA_Maint_Scheduled.M_Internal_Consumption_ID = table8.M_Internal_Consumption_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((maMaintPartId==null || maMaintPartId.equals(""))?"":"  AND MA_Maint_Scheduled.MA_Maint_Part_ID = ?  ");
    strSql = strSql + 
      "        AND MA_Maint_Scheduled.MA_Maint_Scheduled_ID = ? " +
      "        AND MA_Maint_Scheduled.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_Maint_Scheduled.AD_Org_ID IN (";
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
      if (maMaintPartId != null && !(maMaintPartId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintPartId);
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
        Task800192Data objectTask800192Data = new Task800192Data();
        objectTask800192Data.created = UtilSql.getValue(result, "created");
        objectTask800192Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTask800192Data.updated = UtilSql.getValue(result, "updated");
        objectTask800192Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTask800192Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectTask800192Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTask800192Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTask800192Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectTask800192Data.maMaintScheduledId = UtilSql.getValue(result, "ma_maint_scheduled_id");
        objectTask800192Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTask800192Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectTask800192Data.maMaintPartId = UtilSql.getValue(result, "ma_maint_part_id");
        objectTask800192Data.maMaintPartIdr = UtilSql.getValue(result, "ma_maint_part_idr");
        objectTask800192Data.isactive = UtilSql.getValue(result, "isactive");
        objectTask800192Data.maMaintenanceId = UtilSql.getValue(result, "ma_maintenance_id");
        objectTask800192Data.maMaintenanceIdr = UtilSql.getValue(result, "ma_maintenance_idr");
        objectTask800192Data.scheduleddate = UtilSql.getDateValue(result, "scheduleddate", "dd-MM-yyyy");
        objectTask800192Data.shift = UtilSql.getValue(result, "shift");
        objectTask800192Data.shiftr = UtilSql.getValue(result, "shiftr");
        objectTask800192Data.maintenanceType = UtilSql.getValue(result, "maintenance_type");
        objectTask800192Data.maintenanceTyper = UtilSql.getValue(result, "maintenance_typer");
        objectTask800192Data.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectTask800192Data.maMachineIdr = UtilSql.getValue(result, "ma_machine_idr");
        objectTask800192Data.maMachineTypeId = UtilSql.getValue(result, "ma_machine_type_id");
        objectTask800192Data.maMachineTypeIdr = UtilSql.getValue(result, "ma_machine_type_idr");
        objectTask800192Data.maMaintOperationId = UtilSql.getValue(result, "ma_maint_operation_id");
        objectTask800192Data.maMaintOperationIdr = UtilSql.getValue(result, "ma_maint_operation_idr");
        objectTask800192Data.description = UtilSql.getValue(result, "description");
        objectTask800192Data.confirmed = UtilSql.getValue(result, "confirmed");
        objectTask800192Data.result = UtilSql.getValue(result, "result");
        objectTask800192Data.usedtime = UtilSql.getValue(result, "usedtime");
        objectTask800192Data.observation = UtilSql.getValue(result, "observation");
        objectTask800192Data.mInternalConsumptionId = UtilSql.getValue(result, "m_internal_consumption_id");
        objectTask800192Data.mInternalConsumptionIdr = UtilSql.getValue(result, "m_internal_consumption_idr");
        objectTask800192Data.language = UtilSql.getValue(result, "language");
        objectTask800192Data.adUserClient = "";
        objectTask800192Data.adOrgClient = "";
        objectTask800192Data.createdby = "";
        objectTask800192Data.trBgcolor = "";
        objectTask800192Data.totalCount = "";
        objectTask800192Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTask800192Data);
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
    Task800192Data objectTask800192Data[] = new Task800192Data[vector.size()];
    vector.copyInto(objectTask800192Data);
    return(objectTask800192Data);
  }

/**
Create a registry
 */
  public static Task800192Data[] set(String maMaintPartId, String maMaintOperationId, String confirmed, String maMaintenanceId, String shift, String observation, String mInternalConsumptionId, String adClientId, String result, String isactive, String maintenanceType, String createdby, String createdbyr, String maMaintScheduledId, String maMachineId, String adOrgId, String scheduleddate, String updatedby, String updatedbyr, String maMachineTypeId, String usedtime, String description)    throws ServletException {
    Task800192Data objectTask800192Data[] = new Task800192Data[1];
    objectTask800192Data[0] = new Task800192Data();
    objectTask800192Data[0].created = "";
    objectTask800192Data[0].createdbyr = createdbyr;
    objectTask800192Data[0].updated = "";
    objectTask800192Data[0].updatedTimeStamp = "";
    objectTask800192Data[0].updatedby = updatedby;
    objectTask800192Data[0].updatedbyr = updatedbyr;
    objectTask800192Data[0].adClientId = adClientId;
    objectTask800192Data[0].adClientIdr = "";
    objectTask800192Data[0].maMaintScheduledId = maMaintScheduledId;
    objectTask800192Data[0].adOrgId = adOrgId;
    objectTask800192Data[0].adOrgIdr = "";
    objectTask800192Data[0].maMaintPartId = maMaintPartId;
    objectTask800192Data[0].maMaintPartIdr = "";
    objectTask800192Data[0].isactive = isactive;
    objectTask800192Data[0].maMaintenanceId = maMaintenanceId;
    objectTask800192Data[0].maMaintenanceIdr = "";
    objectTask800192Data[0].scheduleddate = scheduleddate;
    objectTask800192Data[0].shift = shift;
    objectTask800192Data[0].shiftr = "";
    objectTask800192Data[0].maintenanceType = maintenanceType;
    objectTask800192Data[0].maintenanceTyper = "";
    objectTask800192Data[0].maMachineId = maMachineId;
    objectTask800192Data[0].maMachineIdr = "";
    objectTask800192Data[0].maMachineTypeId = maMachineTypeId;
    objectTask800192Data[0].maMachineTypeIdr = "";
    objectTask800192Data[0].maMaintOperationId = maMaintOperationId;
    objectTask800192Data[0].maMaintOperationIdr = "";
    objectTask800192Data[0].description = description;
    objectTask800192Data[0].confirmed = confirmed;
    objectTask800192Data[0].result = result;
    objectTask800192Data[0].usedtime = usedtime;
    objectTask800192Data[0].observation = observation;
    objectTask800192Data[0].mInternalConsumptionId = mInternalConsumptionId;
    objectTask800192Data[0].mInternalConsumptionIdr = "";
    objectTask800192Data[0].language = "";
    return objectTask800192Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef802642_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef802644_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT MA_Maint_Scheduled.MA_Maint_Part_ID AS NAME" +
      "        FROM MA_Maint_Scheduled" +
      "        WHERE MA_Maint_Scheduled.MA_Maint_Scheduled_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String maMaintPartId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), ''))) AS NAME FROM MA_Maint_Part left join (select MA_Maint_Part_ID, DocumentNo from MA_Maint_Part) table1 on (MA_Maint_Part.MA_Maint_Part_ID = table1.MA_Maint_Part_ID) WHERE MA_Maint_Part.MA_Maint_Part_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintPartId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String maMaintPartId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), ''))) AS NAME FROM MA_Maint_Part left join (select MA_Maint_Part_ID, DocumentNo from MA_Maint_Part) table1 on (MA_Maint_Part.MA_Maint_Part_ID = table1.MA_Maint_Part_ID) WHERE MA_Maint_Part.MA_Maint_Part_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintPartId);

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
      "        UPDATE MA_Maint_Scheduled" +
      "        SET AD_Client_ID = (?) , MA_Maint_Scheduled_ID = (?) , AD_Org_ID = (?) , MA_Maint_Part_ID = (?) , IsActive = (?) , MA_Maintenance_ID = (?) , Scheduleddate = TO_DATE(?) , Shift = (?) , Maintenance_Type = (?) , MA_Machine_ID = (?) , MA_Machine_Type_ID = (?) , MA_Maint_Operation_ID = (?) , Description = (?) , Confirmed = (?) , Result = (?) , Usedtime = TO_NUMBER(?) , Observation = (?) , M_Internal_Consumption_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE MA_Maint_Scheduled.MA_Maint_Scheduled_ID = ? " +
      "                 AND MA_Maint_Scheduled.MA_Maint_Part_ID = ? " +
      "        AND MA_Maint_Scheduled.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Maint_Scheduled.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintScheduledId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintPartId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintenanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheduleddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shift);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maintenanceType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineTypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintOperationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, confirmed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, result);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usedtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, observation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintScheduledId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintPartId);
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
      "        INSERT INTO MA_Maint_Scheduled " +
      "        (AD_Client_ID, MA_Maint_Scheduled_ID, AD_Org_ID, MA_Maint_Part_ID, IsActive, MA_Maintenance_ID, Scheduleddate, Shift, Maintenance_Type, MA_Machine_ID, MA_Machine_Type_ID, MA_Maint_Operation_ID, Description, Confirmed, Result, Usedtime, Observation, M_Internal_Consumption_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintScheduledId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintPartId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintenanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheduleddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shift);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maintenanceType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineTypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintOperationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, confirmed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, result);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usedtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, observation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String maMaintPartId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Maint_Scheduled" +
      "        WHERE MA_Maint_Scheduled.MA_Maint_Scheduled_ID = ? " +
      "                 AND MA_Maint_Scheduled.MA_Maint_Part_ID = ? " +
      "        AND MA_Maint_Scheduled.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Maint_Scheduled.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintPartId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String maMaintPartId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Maint_Scheduled" +
      "        WHERE MA_Maint_Scheduled.MA_Maint_Scheduled_ID = ? " +
      "                 AND MA_Maint_Scheduled.MA_Maint_Part_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintPartId);

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
      "          FROM MA_Maint_Scheduled" +
      "         WHERE MA_Maint_Scheduled.MA_Maint_Scheduled_ID = ? ";

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
      "          FROM MA_Maint_Scheduled" +
      "         WHERE MA_Maint_Scheduled.MA_Maint_Scheduled_ID = ? ";

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
