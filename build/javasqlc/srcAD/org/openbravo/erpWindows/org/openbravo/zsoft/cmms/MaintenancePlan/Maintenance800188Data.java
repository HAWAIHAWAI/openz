//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.cmms.MaintenancePlan;

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
class Maintenance800188Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Maintenance800188Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String maMaintScheduledId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String maMaintenanceId;
  public String maMaintenanceIdr;
  public String isactive;
  public String scheduleddate;
  public String shift;
  public String shiftr;
  public String maintenanceType;
  public String maintenanceTyper;
  public String maMachineTypeId;
  public String maMachineTypeIdr;
  public String maMachineId;
  public String maMachineIdr;
  public String maMaintOperationId;
  public String maMaintOperationIdr;
  public String description;
  public String confirmed;
  public String maMaintPartId;
  public String maMaintPartIdr;
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
    else if (fieldName.equalsIgnoreCase("ma_maint_scheduled_id") || fieldName.equals("maMaintScheduledId"))
      return maMaintScheduledId;
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
    else if (fieldName.equalsIgnoreCase("ma_machine_type_id") || fieldName.equals("maMachineTypeId"))
      return maMachineTypeId;
    else if (fieldName.equalsIgnoreCase("ma_machine_type_idr") || fieldName.equals("maMachineTypeIdr"))
      return maMachineTypeIdr;
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
    else if (fieldName.equalsIgnoreCase("ma_machine_idr") || fieldName.equals("maMachineIdr"))
      return maMachineIdr;
    else if (fieldName.equalsIgnoreCase("ma_maint_operation_id") || fieldName.equals("maMaintOperationId"))
      return maMaintOperationId;
    else if (fieldName.equalsIgnoreCase("ma_maint_operation_idr") || fieldName.equals("maMaintOperationIdr"))
      return maMaintOperationIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("confirmed"))
      return confirmed;
    else if (fieldName.equalsIgnoreCase("ma_maint_part_id") || fieldName.equals("maMaintPartId"))
      return maMaintPartId;
    else if (fieldName.equalsIgnoreCase("ma_maint_part_idr") || fieldName.equals("maMaintPartIdr"))
      return maMaintPartIdr;
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
  public static Maintenance800188Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Maintenance800188Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_Maint_Scheduled.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Maint_Scheduled.CreatedBy) as CreatedByR, " +
      "        to_char(MA_Maint_Scheduled.Updated, ?) as updated, " +
      "        to_char(MA_Maint_Scheduled.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_Maint_Scheduled.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Maint_Scheduled.UpdatedBy) as UpdatedByR," +
      "        MA_Maint_Scheduled.MA_Maint_Scheduled_ID, " +
      "MA_Maint_Scheduled.AD_Client_ID, " +
      "(CASE WHEN MA_Maint_Scheduled.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MA_Maint_Scheduled.AD_Org_ID, " +
      "(CASE WHEN MA_Maint_Scheduled.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "MA_Maint_Scheduled.MA_Maintenance_ID, " +
      "(CASE WHEN MA_Maint_Scheduled.MA_Maintenance_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS MA_Maintenance_IDR, " +
      "COALESCE(MA_Maint_Scheduled.IsActive, 'N') AS IsActive, " +
      "MA_Maint_Scheduled.Scheduleddate, " +
      "MA_Maint_Scheduled.Shift, " +
      "(CASE WHEN MA_Maint_Scheduled.Shift IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ShiftR, " +
      "MA_Maint_Scheduled.Maintenance_Type, " +
      "(CASE WHEN MA_Maint_Scheduled.Maintenance_Type IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS Maintenance_TypeR, " +
      "MA_Maint_Scheduled.MA_Machine_Type_ID, " +
      "(CASE WHEN MA_Maint_Scheduled.MA_Machine_Type_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS MA_Machine_Type_IDR, " +
      "MA_Maint_Scheduled.MA_Machine_ID, " +
      "(CASE WHEN MA_Maint_Scheduled.MA_Machine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS MA_Machine_IDR, " +
      "MA_Maint_Scheduled.MA_Maint_Operation_ID, " +
      "(CASE WHEN MA_Maint_Scheduled.MA_Maint_Operation_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS MA_Maint_Operation_IDR, " +
      "MA_Maint_Scheduled.Description, " +
      "COALESCE(MA_Maint_Scheduled.Confirmed, 'N') AS Confirmed, " +
      "MA_Maint_Scheduled.MA_Maint_Part_ID, " +
      "(CASE WHEN MA_Maint_Scheduled.MA_Maint_Part_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.DocumentNo), ''))),'') ) END) AS MA_Maint_Part_IDR, " +
      "COALESCE(MA_Maint_Scheduled.Result, 'N') AS Result, " +
      "MA_Maint_Scheduled.Usedtime, " +
      "MA_Maint_Scheduled.Observation, " +
      "MA_Maint_Scheduled.M_Internal_Consumption_ID, " +
      "(CASE WHEN MA_Maint_Scheduled.M_Internal_Consumption_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS M_Internal_Consumption_IDR, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_Maint_Scheduled left join (select AD_Client_ID, Name from AD_Client) table1 on (MA_Maint_Scheduled.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MA_Maint_Scheduled.AD_Org_ID = table2.AD_Org_ID) left join (select MA_Maintenance_ID, Name from MA_Maintenance) table3 on (MA_Maint_Scheduled.MA_Maintenance_ID = table3.MA_Maintenance_ID) left join ad_ref_list_v list1 on (MA_Maint_Scheduled.Shift = list1.value and list1.ad_reference_id = '800038' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (MA_Maint_Scheduled.Maintenance_Type = list2.value and list2.ad_reference_id = '800033' and list2.ad_language = ?)  left join (select MA_Machine_Type_ID, Name from MA_Machine_Type) table4 on (MA_Maint_Scheduled.MA_Machine_Type_ID = table4.MA_Machine_Type_ID) left join (select MA_Machine_ID, Value, Name from MA_Machine) table5 on (MA_Maint_Scheduled.MA_Machine_ID = table5.MA_Machine_ID) left join (select MA_Maint_Operation_ID, Name from MA_Maint_Operation) table6 on (MA_Maint_Scheduled.MA_Maint_Operation_ID = table6.MA_Maint_Operation_ID) left join (select MA_Maint_Part_ID, DocumentNo from MA_Maint_Part) table7 on (MA_Maint_Scheduled.MA_Maint_Part_ID = table7.MA_Maint_Part_ID) left join (select M_Internal_Consumption_ID, Name from M_Internal_Consumption) table8 on (MA_Maint_Scheduled.M_Internal_Consumption_ID = table8.M_Internal_Consumption_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
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
        Maintenance800188Data objectMaintenance800188Data = new Maintenance800188Data();
        objectMaintenance800188Data.created = UtilSql.getValue(result, "created");
        objectMaintenance800188Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectMaintenance800188Data.updated = UtilSql.getValue(result, "updated");
        objectMaintenance800188Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectMaintenance800188Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectMaintenance800188Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectMaintenance800188Data.maMaintScheduledId = UtilSql.getValue(result, "ma_maint_scheduled_id");
        objectMaintenance800188Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMaintenance800188Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectMaintenance800188Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMaintenance800188Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectMaintenance800188Data.maMaintenanceId = UtilSql.getValue(result, "ma_maintenance_id");
        objectMaintenance800188Data.maMaintenanceIdr = UtilSql.getValue(result, "ma_maintenance_idr");
        objectMaintenance800188Data.isactive = UtilSql.getValue(result, "isactive");
        objectMaintenance800188Data.scheduleddate = UtilSql.getDateValue(result, "scheduleddate", "dd-MM-yyyy");
        objectMaintenance800188Data.shift = UtilSql.getValue(result, "shift");
        objectMaintenance800188Data.shiftr = UtilSql.getValue(result, "shiftr");
        objectMaintenance800188Data.maintenanceType = UtilSql.getValue(result, "maintenance_type");
        objectMaintenance800188Data.maintenanceTyper = UtilSql.getValue(result, "maintenance_typer");
        objectMaintenance800188Data.maMachineTypeId = UtilSql.getValue(result, "ma_machine_type_id");
        objectMaintenance800188Data.maMachineTypeIdr = UtilSql.getValue(result, "ma_machine_type_idr");
        objectMaintenance800188Data.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectMaintenance800188Data.maMachineIdr = UtilSql.getValue(result, "ma_machine_idr");
        objectMaintenance800188Data.maMaintOperationId = UtilSql.getValue(result, "ma_maint_operation_id");
        objectMaintenance800188Data.maMaintOperationIdr = UtilSql.getValue(result, "ma_maint_operation_idr");
        objectMaintenance800188Data.description = UtilSql.getValue(result, "description");
        objectMaintenance800188Data.confirmed = UtilSql.getValue(result, "confirmed");
        objectMaintenance800188Data.maMaintPartId = UtilSql.getValue(result, "ma_maint_part_id");
        objectMaintenance800188Data.maMaintPartIdr = UtilSql.getValue(result, "ma_maint_part_idr");
        objectMaintenance800188Data.result = UtilSql.getValue(result, "result");
        objectMaintenance800188Data.usedtime = UtilSql.getValue(result, "usedtime");
        objectMaintenance800188Data.observation = UtilSql.getValue(result, "observation");
        objectMaintenance800188Data.mInternalConsumptionId = UtilSql.getValue(result, "m_internal_consumption_id");
        objectMaintenance800188Data.mInternalConsumptionIdr = UtilSql.getValue(result, "m_internal_consumption_idr");
        objectMaintenance800188Data.language = UtilSql.getValue(result, "language");
        objectMaintenance800188Data.adUserClient = "";
        objectMaintenance800188Data.adOrgClient = "";
        objectMaintenance800188Data.createdby = "";
        objectMaintenance800188Data.trBgcolor = "";
        objectMaintenance800188Data.totalCount = "";
        objectMaintenance800188Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMaintenance800188Data);
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
    Maintenance800188Data objectMaintenance800188Data[] = new Maintenance800188Data[vector.size()];
    vector.copyInto(objectMaintenance800188Data);
    return(objectMaintenance800188Data);
  }

/**
Create a registry
 */
  public static Maintenance800188Data[] set(String maMaintOperationId, String confirmed, String maMaintenanceId, String shift, String observation, String mInternalConsumptionId, String adClientId, String maMaintPartId, String result, String maintenanceType, String isactive, String createdby, String createdbyr, String maMaintScheduledId, String maMachineId, String scheduleddate, String adOrgId, String updatedby, String updatedbyr, String maMachineTypeId, String usedtime, String description)    throws ServletException {
    Maintenance800188Data objectMaintenance800188Data[] = new Maintenance800188Data[1];
    objectMaintenance800188Data[0] = new Maintenance800188Data();
    objectMaintenance800188Data[0].created = "";
    objectMaintenance800188Data[0].createdbyr = createdbyr;
    objectMaintenance800188Data[0].updated = "";
    objectMaintenance800188Data[0].updatedTimeStamp = "";
    objectMaintenance800188Data[0].updatedby = updatedby;
    objectMaintenance800188Data[0].updatedbyr = updatedbyr;
    objectMaintenance800188Data[0].maMaintScheduledId = maMaintScheduledId;
    objectMaintenance800188Data[0].adClientId = adClientId;
    objectMaintenance800188Data[0].adClientIdr = "";
    objectMaintenance800188Data[0].adOrgId = adOrgId;
    objectMaintenance800188Data[0].adOrgIdr = "";
    objectMaintenance800188Data[0].maMaintenanceId = maMaintenanceId;
    objectMaintenance800188Data[0].maMaintenanceIdr = "";
    objectMaintenance800188Data[0].isactive = isactive;
    objectMaintenance800188Data[0].scheduleddate = scheduleddate;
    objectMaintenance800188Data[0].shift = shift;
    objectMaintenance800188Data[0].shiftr = "";
    objectMaintenance800188Data[0].maintenanceType = maintenanceType;
    objectMaintenance800188Data[0].maintenanceTyper = "";
    objectMaintenance800188Data[0].maMachineTypeId = maMachineTypeId;
    objectMaintenance800188Data[0].maMachineTypeIdr = "";
    objectMaintenance800188Data[0].maMachineId = maMachineId;
    objectMaintenance800188Data[0].maMachineIdr = "";
    objectMaintenance800188Data[0].maMaintOperationId = maMaintOperationId;
    objectMaintenance800188Data[0].maMaintOperationIdr = "";
    objectMaintenance800188Data[0].description = description;
    objectMaintenance800188Data[0].confirmed = confirmed;
    objectMaintenance800188Data[0].maMaintPartId = maMaintPartId;
    objectMaintenance800188Data[0].maMaintPartIdr = "";
    objectMaintenance800188Data[0].result = result;
    objectMaintenance800188Data[0].usedtime = usedtime;
    objectMaintenance800188Data[0].observation = observation;
    objectMaintenance800188Data[0].mInternalConsumptionId = mInternalConsumptionId;
    objectMaintenance800188Data[0].mInternalConsumptionIdr = "";
    objectMaintenance800188Data[0].language = "";
    return objectMaintenance800188Data;
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE MA_Maint_Scheduled" +
      "        SET MA_Maint_Scheduled_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , MA_Maintenance_ID = (?) , IsActive = (?) , Scheduleddate = TO_DATE(?) , Shift = (?) , Maintenance_Type = (?) , MA_Machine_Type_ID = (?) , MA_Machine_ID = (?) , MA_Maint_Operation_ID = (?) , Description = (?) , Confirmed = (?) , MA_Maint_Part_ID = (?) , Result = (?) , Usedtime = TO_NUMBER(?) , Observation = (?) , M_Internal_Consumption_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE MA_Maint_Scheduled.MA_Maint_Scheduled_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintScheduledId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintenanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheduleddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shift);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maintenanceType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineTypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintOperationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, confirmed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintPartId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, result);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usedtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, observation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintScheduledId);
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
      "        (MA_Maint_Scheduled_ID, AD_Client_ID, AD_Org_ID, MA_Maintenance_ID, IsActive, Scheduleddate, Shift, Maintenance_Type, MA_Machine_Type_ID, MA_Machine_ID, MA_Maint_Operation_ID, Description, Confirmed, MA_Maint_Part_ID, Result, Usedtime, Observation, M_Internal_Consumption_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintScheduledId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintenanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheduleddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shift);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maintenanceType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineTypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintOperationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, confirmed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintPartId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Maint_Scheduled" +
      "        WHERE MA_Maint_Scheduled.MA_Maint_Scheduled_ID = ? " +
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Maint_Scheduled" +
      "        WHERE MA_Maint_Scheduled.MA_Maint_Scheduled_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);

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
