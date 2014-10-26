//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openz.amphos.TimeRecording;

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
class TimeRecording3E365A7090CF4AB4A42C61CC13811D68Data implements FieldProvider {
static Logger log4j = Logger.getLogger(TimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String workdate;
  public String zspmPtaskfeedbacklineId;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String adClientId;
  public String adOrgId;
  public String adUserId;
  public String adUserIdr;
  public String isactive;
  public String cSalaryCategoryId;
  public String cSalaryCategoryIdr;
  public String dayhours;
  public String dayhoursr;
  public String maMachineId;
  public String actualcostamount;
  public String isprocessed;
  public String description;
  public String hourFrom;
  public String hourTo;
  public String hours;
  public String url;
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
    else if (fieldName.equalsIgnoreCase("workdate"))
      return workdate;
    else if (fieldName.equalsIgnoreCase("zspm_ptaskfeedbackline_id") || fieldName.equals("zspmPtaskfeedbacklineId"))
      return zspmPtaskfeedbacklineId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_salary_category_id") || fieldName.equals("cSalaryCategoryId"))
      return cSalaryCategoryId;
    else if (fieldName.equalsIgnoreCase("c_salary_category_idr") || fieldName.equals("cSalaryCategoryIdr"))
      return cSalaryCategoryIdr;
    else if (fieldName.equalsIgnoreCase("dayhours"))
      return dayhours;
    else if (fieldName.equalsIgnoreCase("dayhoursr"))
      return dayhoursr;
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
    else if (fieldName.equalsIgnoreCase("actualcostamount"))
      return actualcostamount;
    else if (fieldName.equalsIgnoreCase("isprocessed"))
      return isprocessed;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("hour_from") || fieldName.equals("hourFrom"))
      return hourFrom;
    else if (fieldName.equalsIgnoreCase("hour_to") || fieldName.equals("hourTo"))
      return hourTo;
    else if (fieldName.equalsIgnoreCase("hours"))
      return hours;
    else if (fieldName.equalsIgnoreCase("url"))
      return url;
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
  public static TimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String AD_User_ID, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, AD_User_ID, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String AD_User_ID, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspm_ptaskfeedbackline.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_ptaskfeedbackline.CreatedBy) as CreatedByR, " +
      "        to_char(zspm_ptaskfeedbackline.Updated, ?) as updated, " +
      "        to_char(zspm_ptaskfeedbackline.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspm_ptaskfeedbackline.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_ptaskfeedbackline.UpdatedBy) as UpdatedByR," +
      "        zspm_ptaskfeedbackline.Workdate, " +
      "zspm_ptaskfeedbackline.Zspm_Ptaskfeedbackline_ID, " +
      "zspm_ptaskfeedbackline.C_Project_ID, " +
      "(CASE WHEN zspm_ptaskfeedbackline.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "zspm_ptaskfeedbackline.C_Projecttask_ID, " +
      "(CASE WHEN zspm_ptaskfeedbackline.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "zspm_ptaskfeedbackline.AD_Client_ID, " +
      "zspm_ptaskfeedbackline.AD_Org_ID, " +
      "zspm_ptaskfeedbackline.AD_User_ID, " +
      "(CASE WHEN zspm_ptaskfeedbackline.AD_User_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "COALESCE(zspm_ptaskfeedbackline.Isactive, 'N') AS Isactive, " +
      "zspm_ptaskfeedbackline.C_Salary_Category_ID, " +
      "(CASE WHEN zspm_ptaskfeedbackline.C_Salary_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_Salary_Category_IDR, " +
      "zspm_ptaskfeedbackline.Dayhours, " +
      "(CASE WHEN zspm_ptaskfeedbackline.Dayhours IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DayhoursR, " +
      "zspm_ptaskfeedbackline.MA_Machine_ID, " +
      "zspm_ptaskfeedbackline.Actualcostamount, " +
      "COALESCE(zspm_ptaskfeedbackline.Isprocessed, 'N') AS Isprocessed, " +
      "zspm_ptaskfeedbackline.Description, " +
      "TO_CHAR(zspm_ptaskfeedbackline.Hour_From, 'HH24:MI:SS') AS Hour_From, " +
      "TO_CHAR(zspm_ptaskfeedbackline.Hour_To, 'HH24:MI:SS') AS Hour_To, " +
      "zspm_ptaskfeedbackline.Hours, " +
      "zspm_ptaskfeedbackline.Url, " +
      "        ? AS LANGUAGE " +
      "        FROM zspm_ptaskfeedbackline left join (select C_Project_ID, Value, Name from C_Project) table1 on (zspm_ptaskfeedbackline.C_Project_ID = table1.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table2 on (zspm_ptaskfeedbackline.C_Projecttask_ID = table2.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table3 on (table2.C_Project_ID = table3.C_Project_ID) left join (select AD_User_ID, Name from AD_User) table4 on (zspm_ptaskfeedbackline.AD_User_ID =  table4.AD_User_ID) left join (select C_Salary_Category_ID, Name from C_Salary_Category) table5 on (zspm_ptaskfeedbackline.C_Salary_Category_ID = table5.C_Salary_Category_ID) left join ad_ref_list_v list1 on (zspm_ptaskfeedbackline.Dayhours = list1.value and list1.ad_reference_id = '8BC5BFA77C1B4BB9B03EB87EDFEA12C4' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      " AND zspm_ptaskfeedbackline.created >= zspm_standardFeedbacklineFilter() and zspm_ptaskfeedbackline.ad_user_id=?" +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_User_ID);
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
        TimeRecording3E365A7090CF4AB4A42C61CC13811D68Data objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data = new TimeRecording3E365A7090CF4AB4A42C61CC13811D68Data();
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.created = UtilSql.getValue(result, "created");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.updated = UtilSql.getValue(result, "updated");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.workdate = UtilSql.getDateValue(result, "workdate", "dd-MM-yyyy");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.zspmPtaskfeedbacklineId = UtilSql.getValue(result, "zspm_ptaskfeedbackline_id");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.isactive = UtilSql.getValue(result, "isactive");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.cSalaryCategoryIdr = UtilSql.getValue(result, "c_salary_category_idr");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.dayhours = UtilSql.getValue(result, "dayhours");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.dayhoursr = UtilSql.getValue(result, "dayhoursr");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.actualcostamount = UtilSql.getValue(result, "actualcostamount");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.isprocessed = UtilSql.getValue(result, "isprocessed");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.description = UtilSql.getValue(result, "description");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.hourFrom = UtilSql.getValue(result, "hour_from");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.hourTo = UtilSql.getValue(result, "hour_to");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.hours = UtilSql.getValue(result, "hours");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.url = UtilSql.getValue(result, "url");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.language = UtilSql.getValue(result, "language");
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.adUserClient = "";
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.adOrgClient = "";
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.createdby = "";
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.trBgcolor = "";
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.totalCount = "";
        objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data);
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
    TimeRecording3E365A7090CF4AB4A42C61CC13811D68Data objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[] = new TimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[vector.size()];
    vector.copyInto(objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data);
    return(objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data);
  }

/**
Create a registry
 */
  public static TimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[] set(String cSalaryCategoryId, String workdate, String cProjectId, String cProjectIdr, String maMachineId, String isactive, String adUserId, String actualcostamount, String adClientId, String updatedby, String updatedbyr, String isprocessed, String zspmPtaskfeedbacklineId, String createdby, String createdbyr, String url, String adOrgId, String dayhours, String cProjecttaskId, String hours, String hourFrom, String description, String hourTo)    throws ServletException {
    TimeRecording3E365A7090CF4AB4A42C61CC13811D68Data objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[] = new TimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[1];
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0] = new TimeRecording3E365A7090CF4AB4A42C61CC13811D68Data();
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].created = "";
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].createdbyr = createdbyr;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].updated = "";
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].updatedTimeStamp = "";
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].updatedby = updatedby;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].updatedbyr = updatedbyr;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].workdate = workdate;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].zspmPtaskfeedbacklineId = zspmPtaskfeedbacklineId;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].cProjectId = cProjectId;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].cProjectIdr = cProjectIdr;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].cProjecttaskId = cProjecttaskId;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].cProjecttaskIdr = "";
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].adClientId = adClientId;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].adOrgId = adOrgId;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].adUserId = adUserId;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].adUserIdr = "";
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].isactive = isactive;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].cSalaryCategoryId = cSalaryCategoryId;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].cSalaryCategoryIdr = "";
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].dayhours = dayhours;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].dayhoursr = "";
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].maMachineId = maMachineId;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].actualcostamount = actualcostamount;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].isprocessed = isprocessed;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].description = description;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].hourFrom = hourFrom;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].hourTo = hourTo;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].hours = hours;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].url = url;
    objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data[0].language = "";
    return objectTimeRecording3E365A7090CF4AB4A42C61CC13811D68Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefA269F2A3179B450D9A11DD12494B2B0E(ConnectionProvider connectionProvider, String AD_User_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_salary_category_id FROM c_bpartner WHERE c_bpartner_id = (SELECT c_bpartner_id FROM ad_user WHERE ad_user_id =?) ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_User_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_salary_category_id");
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
      "        SET Workdate = TO_DATE(?) , Zspm_Ptaskfeedbackline_ID = (?) , C_Project_ID = (?) , C_Projecttask_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , AD_User_ID = (?) , Isactive = (?) , C_Salary_Category_ID = (?) , Dayhours = (?) , MA_Machine_ID = (?) , Actualcostamount = TO_NUMBER(?) , Isprocessed = (?) , Description = (?) , Hour_From = TO_TIMESTAMP(?,'HH24:MI:SS') , Hour_To = TO_TIMESTAMP(?,'HH24:MI:SS') , Hours = TO_NUMBER(?) , Url = (?) , updated = now(), updatedby = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskfeedbacklineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayhours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprocessed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, url);
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
      "        (Workdate, Zspm_Ptaskfeedbackline_ID, C_Project_ID, C_Projecttask_ID, AD_Client_ID, AD_Org_ID, AD_User_ID, Isactive, C_Salary_Category_ID, Dayhours, MA_Machine_ID, Actualcostamount, Isprocessed, Description, Hour_From, Hour_To, Hours, Url, created, createdby, updated, updatedBy)" +
      "        VALUES (TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskfeedbacklineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayhours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprocessed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, url);
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
