//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openz.timeservice.MachineFeedback;

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
class MachineFeedback01AD76C0516B4D5591C348C6A118F21FData implements FieldProvider {
static Logger log4j = Logger.getLogger(MachineFeedback01AD76C0516B4D5591C348C6A118F21FData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String zspmPtaskfeedbacklineId;
  public String workdate;
  public String cProjectId;
  public String cProjectIdr;
  public String adClientId;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String maMachineId;
  public String maMachineIdr;
  public String isactive;
  public String hours;
  public String costuom;
  public String costuomr;
  public String cCalendareventId;
  public String cCalendareventIdr;
  public String description;
  public String actualcostamount;
  public String hourFrom;
  public String hourTo;
  public String dayhours;
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
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("zspm_ptaskfeedbackline_id") || fieldName.equals("zspmPtaskfeedbacklineId"))
      return zspmPtaskfeedbacklineId;
    else if (fieldName.equalsIgnoreCase("workdate"))
      return workdate;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
    else if (fieldName.equalsIgnoreCase("ma_machine_idr") || fieldName.equals("maMachineIdr"))
      return maMachineIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("hours"))
      return hours;
    else if (fieldName.equalsIgnoreCase("costuom"))
      return costuom;
    else if (fieldName.equalsIgnoreCase("costuomr"))
      return costuomr;
    else if (fieldName.equalsIgnoreCase("c_calendarevent_id") || fieldName.equals("cCalendareventId"))
      return cCalendareventId;
    else if (fieldName.equalsIgnoreCase("c_calendarevent_idr") || fieldName.equals("cCalendareventIdr"))
      return cCalendareventIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("actualcostamount"))
      return actualcostamount;
    else if (fieldName.equalsIgnoreCase("hour_from") || fieldName.equals("hourFrom"))
      return hourFrom;
    else if (fieldName.equalsIgnoreCase("hour_to") || fieldName.equals("hourTo"))
      return hourTo;
    else if (fieldName.equalsIgnoreCase("dayhours"))
      return dayhours;
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
  public static MachineFeedback01AD76C0516B4D5591C348C6A118F21FData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static MachineFeedback01AD76C0516B4D5591C348C6A118F21FData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspm_ptaskfeedbackline.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_ptaskfeedbackline.CreatedBy) as CreatedByR, " +
      "        to_char(zspm_ptaskfeedbackline.Updated, ?) as updated, " +
      "        to_char(zspm_ptaskfeedbackline.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspm_ptaskfeedbackline.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_ptaskfeedbackline.UpdatedBy) as UpdatedByR," +
      "        zspm_ptaskfeedbackline.AD_Org_ID, " +
      "(CASE WHEN zspm_ptaskfeedbackline.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zspm_ptaskfeedbackline.Zspm_Ptaskfeedbackline_ID, " +
      "zspm_ptaskfeedbackline.Workdate, " +
      "zspm_ptaskfeedbackline.C_Project_ID, " +
      "(CASE WHEN zspm_ptaskfeedbackline.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "zspm_ptaskfeedbackline.AD_Client_ID, " +
      "zspm_ptaskfeedbackline.C_Projecttask_ID, " +
      "(CASE WHEN zspm_ptaskfeedbackline.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "zspm_ptaskfeedbackline.MA_Machine_ID, " +
      "(CASE WHEN zspm_ptaskfeedbackline.MA_Machine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS MA_Machine_IDR, " +
      "COALESCE(zspm_ptaskfeedbackline.Isactive, 'N') AS Isactive, " +
      "zspm_ptaskfeedbackline.Hours, " +
      "zspm_ptaskfeedbackline.Costuom, " +
      "(CASE WHEN zspm_ptaskfeedbackline.Costuom IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS CostuomR, " +
      "zspm_ptaskfeedbackline.C_Calendarevent_ID, " +
      "(CASE WHEN zspm_ptaskfeedbackline.C_Calendarevent_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_Calendarevent_IDR, " +
      "zspm_ptaskfeedbackline.Description, " +
      "zspm_ptaskfeedbackline.Actualcostamount, " +
      "TO_CHAR(zspm_ptaskfeedbackline.Hour_From, 'HH24:MI:SS') AS Hour_From, " +
      "TO_CHAR(zspm_ptaskfeedbackline.Hour_To, 'HH24:MI:SS') AS Hour_To, " +
      "zspm_ptaskfeedbackline.Dayhours, " +
      "        ? AS LANGUAGE " +
      "        FROM zspm_ptaskfeedbackline left join (select AD_Org_ID, Name from AD_Org) table1 on (zspm_ptaskfeedbackline.AD_Org_ID = table1.AD_Org_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (zspm_ptaskfeedbackline.C_Project_ID = table2.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table3 on (zspm_ptaskfeedbackline.C_Projecttask_ID = table3.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table4 on (table3.C_Project_ID = table4.C_Project_ID) left join (select MA_Machine_ID, Value, Name from MA_Machine) table5 on (zspm_ptaskfeedbackline.MA_Machine_ID = table5.MA_Machine_ID) left join ad_ref_list_v list1 on (zspm_ptaskfeedbackline.Costuom = list1.value and list1.ad_reference_id = 'DE781226949D4A9F8782BA610C3621C6' and list1.ad_language = ?)  left join (select C_Calendarevent_ID, Name from C_CALENDAREVENT) table6 on (zspm_ptaskfeedbackline.C_Calendarevent_ID =  table6.C_Calendarevent_ID)" +
      "        WHERE 2=2 " +
      " AND zspm_ptaskfeedbackline.ma_machine_id is not null" +
      "        AND 1=1 " +
      "        AND zspm_ptaskfeedbackline.Zspm_Ptaskfeedbackline_ID = ? " +
      "        AND zspm_ptaskfeedbackline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zspm_ptaskfeedbackline.AD_Org_ID IN (";
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
        MachineFeedback01AD76C0516B4D5591C348C6A118F21FData objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData = new MachineFeedback01AD76C0516B4D5591C348C6A118F21FData();
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.created = UtilSql.getValue(result, "created");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.updated = UtilSql.getValue(result, "updated");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.updatedby = UtilSql.getValue(result, "updatedby");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.zspmPtaskfeedbacklineId = UtilSql.getValue(result, "zspm_ptaskfeedbackline_id");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.workdate = UtilSql.getDateValue(result, "workdate", "dd-MM-yyyy");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.maMachineIdr = UtilSql.getValue(result, "ma_machine_idr");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.isactive = UtilSql.getValue(result, "isactive");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.hours = UtilSql.getValue(result, "hours");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.costuom = UtilSql.getValue(result, "costuom");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.costuomr = UtilSql.getValue(result, "costuomr");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.cCalendareventId = UtilSql.getValue(result, "c_calendarevent_id");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.cCalendareventIdr = UtilSql.getValue(result, "c_calendarevent_idr");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.description = UtilSql.getValue(result, "description");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.actualcostamount = UtilSql.getValue(result, "actualcostamount");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.hourFrom = UtilSql.getValue(result, "hour_from");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.hourTo = UtilSql.getValue(result, "hour_to");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.dayhours = UtilSql.getValue(result, "dayhours");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.language = UtilSql.getValue(result, "language");
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.adUserClient = "";
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.adOrgClient = "";
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.createdby = "";
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.trBgcolor = "";
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.totalCount = "";
        objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData);
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
    MachineFeedback01AD76C0516B4D5591C348C6A118F21FData objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[] = new MachineFeedback01AD76C0516B4D5591C348C6A118F21FData[vector.size()];
    vector.copyInto(objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData);
    return(objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData);
  }

/**
Create a registry
 */
  public static MachineFeedback01AD76C0516B4D5591C348C6A118F21FData[] set(String workdate, String hourTo, String cProjectId, String cProjectIdr, String cCalendareventId, String description, String isactive, String dayhours, String adClientId, String actualcostamount, String updatedby, String updatedbyr, String zspmPtaskfeedbacklineId, String hours, String createdby, String createdbyr, String cProjecttaskId, String hourFrom, String adOrgId, String costuom, String maMachineId)    throws ServletException {
    MachineFeedback01AD76C0516B4D5591C348C6A118F21FData objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[] = new MachineFeedback01AD76C0516B4D5591C348C6A118F21FData[1];
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0] = new MachineFeedback01AD76C0516B4D5591C348C6A118F21FData();
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].created = "";
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].createdbyr = createdbyr;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].updated = "";
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].updatedTimeStamp = "";
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].updatedby = updatedby;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].updatedbyr = updatedbyr;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].adOrgId = adOrgId;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].adOrgIdr = "";
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].zspmPtaskfeedbacklineId = zspmPtaskfeedbacklineId;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].workdate = workdate;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].cProjectId = cProjectId;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].cProjectIdr = cProjectIdr;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].adClientId = adClientId;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].cProjecttaskId = cProjecttaskId;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].cProjecttaskIdr = "";
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].maMachineId = maMachineId;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].maMachineIdr = "";
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].isactive = isactive;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].hours = hours;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].costuom = costuom;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].costuomr = "";
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].cCalendareventId = cCalendareventId;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].cCalendareventIdr = "";
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].description = description;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].actualcostamount = actualcostamount;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].hourFrom = hourFrom;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].hourTo = hourTo;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].dayhours = dayhours;
    objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData[0].language = "";
    return objectMachineFeedback01AD76C0516B4D5591C348C6A118F21FData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef0F48330170E44E77BA40C4084A431884_0(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as C_Project_ID FROM C_Project table1 WHERE table1.isActive='Y' AND table1.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_project_id");
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
  public static String selectDef91F75684F9FA4CFE9AFFA6E3A4C52E7A_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefECFFEA70E45840F78F27B8164CFB6BA6_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE zspm_ptaskfeedbackline" +
      "        SET AD_Org_ID = (?) , Zspm_Ptaskfeedbackline_ID = (?) , Workdate = TO_DATE(?) , C_Project_ID = (?) , AD_Client_ID = (?) , C_Projecttask_ID = (?) , MA_Machine_ID = (?) , Isactive = (?) , Hours = TO_NUMBER(?) , Costuom = (?) , C_Calendarevent_ID = (?) , Description = (?) , Actualcostamount = TO_NUMBER(?) , Hour_From = TO_TIMESTAMP(?,'HH24:MI:SS') , Hour_To = TO_TIMESTAMP(?,'HH24:MI:SS') , Dayhours = (?) , updated = now(), updatedby = ? " +
      "        WHERE zspm_ptaskfeedbackline.Zspm_Ptaskfeedbackline_ID = ? " +
      "        AND zspm_ptaskfeedbackline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspm_ptaskfeedbackline.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskfeedbacklineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayhours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskfeedbacklineId);
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
      "        INSERT INTO zspm_ptaskfeedbackline " +
      "        (AD_Org_ID, Zspm_Ptaskfeedbackline_ID, Workdate, C_Project_ID, AD_Client_ID, C_Projecttask_ID, MA_Machine_ID, Isactive, Hours, Costuom, C_Calendarevent_ID, Description, Actualcostamount, Hour_From, Hour_To, Dayhours, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_DATE(?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_TIMESTAMP(?, 'HH24:MI:SS'), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskfeedbacklineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayhours);
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
      "        DELETE FROM zspm_ptaskfeedbackline" +
      "        WHERE zspm_ptaskfeedbackline.Zspm_Ptaskfeedbackline_ID = ? " +
      "        AND zspm_ptaskfeedbackline.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspm_ptaskfeedbackline.AD_Org_ID IN (";
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
      "        DELETE FROM zspm_ptaskfeedbackline" +
      "        WHERE zspm_ptaskfeedbackline.Zspm_Ptaskfeedbackline_ID = ? ";

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
      "          FROM zspm_ptaskfeedbackline" +
      "         WHERE zspm_ptaskfeedbackline.Zspm_Ptaskfeedbackline_ID = ? ";

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
      "          FROM zspm_ptaskfeedbackline" +
      "         WHERE zspm_ptaskfeedbackline.Zspm_Ptaskfeedbackline_ID = ? ";

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
