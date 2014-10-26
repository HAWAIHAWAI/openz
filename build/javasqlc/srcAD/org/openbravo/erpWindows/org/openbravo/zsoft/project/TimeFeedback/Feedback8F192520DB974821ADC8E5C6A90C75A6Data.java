//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.project.TimeFeedback;

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
class Feedback8F192520DB974821ADC8E5C6A90C75A6Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Feedback8F192520DB974821ADC8E5C6A90C75A6Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String workdate;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String adUserId;
  public String adUserIdr;
  public String maMachineId;
  public String maMachineIdr;
  public String cSalaryCategoryId;
  public String cSalaryCategoryIdr;
  public String hours;
  public String url;
  public String description;
  public String dayhours;
  public String zspmPtaskfeedbacklineId;
  public String isprocessed;
  public String hourFrom;
  public String adClientId;
  public String adOrgId;
  public String actualcostamount;
  public String isactive;
  public String hourTo;
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
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
    else if (fieldName.equalsIgnoreCase("ma_machine_idr") || fieldName.equals("maMachineIdr"))
      return maMachineIdr;
    else if (fieldName.equalsIgnoreCase("c_salary_category_id") || fieldName.equals("cSalaryCategoryId"))
      return cSalaryCategoryId;
    else if (fieldName.equalsIgnoreCase("c_salary_category_idr") || fieldName.equals("cSalaryCategoryIdr"))
      return cSalaryCategoryIdr;
    else if (fieldName.equalsIgnoreCase("hours"))
      return hours;
    else if (fieldName.equalsIgnoreCase("url"))
      return url;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("dayhours"))
      return dayhours;
    else if (fieldName.equalsIgnoreCase("zspm_ptaskfeedbackline_id") || fieldName.equals("zspmPtaskfeedbacklineId"))
      return zspmPtaskfeedbacklineId;
    else if (fieldName.equalsIgnoreCase("isprocessed"))
      return isprocessed;
    else if (fieldName.equalsIgnoreCase("hour_from") || fieldName.equals("hourFrom"))
      return hourFrom;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("actualcostamount"))
      return actualcostamount;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("hour_to") || fieldName.equals("hourTo"))
      return hourTo;
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
  public static Feedback8F192520DB974821ADC8E5C6A90C75A6Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Feedback8F192520DB974821ADC8E5C6A90C75A6Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspm_ptaskfeedbackline.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_ptaskfeedbackline.CreatedBy) as CreatedByR, " +
      "        to_char(zspm_ptaskfeedbackline.Updated, ?) as updated, " +
      "        to_char(zspm_ptaskfeedbackline.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspm_ptaskfeedbackline.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_ptaskfeedbackline.UpdatedBy) as UpdatedByR," +
      "        zspm_ptaskfeedbackline.Workdate, " +
      "zspm_ptaskfeedbackline.C_Project_ID, " +
      "(CASE WHEN zspm_ptaskfeedbackline.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "zspm_ptaskfeedbackline.C_Projecttask_ID, " +
      "(CASE WHEN zspm_ptaskfeedbackline.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "zspm_ptaskfeedbackline.AD_User_ID, " +
      "(CASE WHEN zspm_ptaskfeedbackline.AD_User_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "zspm_ptaskfeedbackline.MA_Machine_ID, " +
      "(CASE WHEN zspm_ptaskfeedbackline.MA_Machine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS MA_Machine_IDR, " +
      "zspm_ptaskfeedbackline.C_Salary_Category_ID, " +
      "(CASE WHEN zspm_ptaskfeedbackline.C_Salary_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_Salary_Category_IDR, " +
      "zspm_ptaskfeedbackline.Hours, " +
      "zspm_ptaskfeedbackline.Url, " +
      "zspm_ptaskfeedbackline.Description, " +
      "zspm_ptaskfeedbackline.Dayhours, " +
      "zspm_ptaskfeedbackline.Zspm_Ptaskfeedbackline_ID, " +
      "COALESCE(zspm_ptaskfeedbackline.Isprocessed, 'N') AS Isprocessed, " +
      "TO_CHAR(zspm_ptaskfeedbackline.Hour_From, 'HH24:MI:SS') AS Hour_From, " +
      "zspm_ptaskfeedbackline.AD_Client_ID, " +
      "zspm_ptaskfeedbackline.AD_Org_ID, " +
      "zspm_ptaskfeedbackline.Actualcostamount, " +
      "COALESCE(zspm_ptaskfeedbackline.Isactive, 'N') AS Isactive, " +
      "TO_CHAR(zspm_ptaskfeedbackline.Hour_To, 'HH24:MI:SS') AS Hour_To, " +
      "        ? AS LANGUAGE " +
      "        FROM zspm_ptaskfeedbackline left join (select C_Project_ID, Value, Name from C_Project) table1 on (zspm_ptaskfeedbackline.C_Project_ID = table1.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table2 on (zspm_ptaskfeedbackline.C_Projecttask_ID = table2.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table3 on (table2.C_Project_ID = table3.C_Project_ID) left join (select AD_User_ID, Name from AD_User) table4 on (zspm_ptaskfeedbackline.AD_User_ID =  table4.AD_User_ID) left join (select MA_Machine_ID, Value, Name from MA_Machine) table5 on (zspm_ptaskfeedbackline.MA_Machine_ID = table5.MA_Machine_ID) left join (select C_Salary_Category_ID, Name from C_Salary_Category) table6 on (zspm_ptaskfeedbackline.C_Salary_Category_ID = table6.C_Salary_Category_ID)" +
      "        WHERE 2=2 " +
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
        Feedback8F192520DB974821ADC8E5C6A90C75A6Data objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data = new Feedback8F192520DB974821ADC8E5C6A90C75A6Data();
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.created = UtilSql.getValue(result, "created");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.updated = UtilSql.getValue(result, "updated");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.workdate = UtilSql.getDateValue(result, "workdate", "dd-MM-yyyy");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.maMachineIdr = UtilSql.getValue(result, "ma_machine_idr");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.cSalaryCategoryIdr = UtilSql.getValue(result, "c_salary_category_idr");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.hours = UtilSql.getValue(result, "hours");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.url = UtilSql.getValue(result, "url");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.description = UtilSql.getValue(result, "description");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.dayhours = UtilSql.getValue(result, "dayhours");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.zspmPtaskfeedbacklineId = UtilSql.getValue(result, "zspm_ptaskfeedbackline_id");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.isprocessed = UtilSql.getValue(result, "isprocessed");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.hourFrom = UtilSql.getValue(result, "hour_from");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.actualcostamount = UtilSql.getValue(result, "actualcostamount");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.isactive = UtilSql.getValue(result, "isactive");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.hourTo = UtilSql.getValue(result, "hour_to");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.language = UtilSql.getValue(result, "language");
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.adUserClient = "";
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.adOrgClient = "";
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.createdby = "";
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.trBgcolor = "";
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.totalCount = "";
        objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data);
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
    Feedback8F192520DB974821ADC8E5C6A90C75A6Data objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[] = new Feedback8F192520DB974821ADC8E5C6A90C75A6Data[vector.size()];
    vector.copyInto(objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data);
    return(objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data);
  }

/**
Create a registry
 */
  public static Feedback8F192520DB974821ADC8E5C6A90C75A6Data[] set(String cSalaryCategoryId, String workdate, String cProjectId, String cProjectIdr, String description, String isactive, String adUserId, String adClientId, String dayhours, String actualcostamount, String updatedby, String updatedbyr, String zspmPtaskfeedbacklineId, String isprocessed, String hours, String createdby, String createdbyr, String adOrgId, String cProjecttaskId, String url, String hourFrom, String maMachineId, String hourTo)    throws ServletException {
    Feedback8F192520DB974821ADC8E5C6A90C75A6Data objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[] = new Feedback8F192520DB974821ADC8E5C6A90C75A6Data[1];
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0] = new Feedback8F192520DB974821ADC8E5C6A90C75A6Data();
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].created = "";
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].createdbyr = createdbyr;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].updated = "";
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].updatedTimeStamp = "";
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].updatedby = updatedby;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].updatedbyr = updatedbyr;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].workdate = workdate;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].cProjectId = cProjectId;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].cProjectIdr = cProjectIdr;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].cProjecttaskId = cProjecttaskId;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].cProjecttaskIdr = "";
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].adUserId = adUserId;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].adUserIdr = "";
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].maMachineId = maMachineId;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].maMachineIdr = "";
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].cSalaryCategoryId = cSalaryCategoryId;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].cSalaryCategoryIdr = "";
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].hours = hours;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].url = url;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].description = description;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].dayhours = dayhours;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].zspmPtaskfeedbacklineId = zspmPtaskfeedbacklineId;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].isprocessed = isprocessed;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].hourFrom = hourFrom;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].adClientId = adClientId;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].adOrgId = adOrgId;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].actualcostamount = actualcostamount;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].isactive = isactive;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].hourTo = hourTo;
    objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data[0].language = "";
    return objectFeedback8F192520DB974821ADC8E5C6A90C75A6Data;
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
      "        SET Workdate = TO_DATE(?) , C_Project_ID = (?) , C_Projecttask_ID = (?) , AD_User_ID = (?) , MA_Machine_ID = (?) , C_Salary_Category_ID = (?) , Hours = TO_NUMBER(?) , Url = (?) , Description = (?) , Dayhours = (?) , Zspm_Ptaskfeedbackline_ID = (?) , Isprocessed = (?) , Hour_From = TO_TIMESTAMP(?,'HH24:MI:SS') , AD_Client_ID = (?) , AD_Org_ID = (?) , Actualcostamount = TO_NUMBER(?) , Isactive = (?) , Hour_To = TO_TIMESTAMP(?,'HH24:MI:SS') , updated = now(), updatedby = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, url);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayhours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskfeedbacklineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprocessed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourTo);
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
      "        (Workdate, C_Project_ID, C_Projecttask_ID, AD_User_ID, MA_Machine_ID, C_Salary_Category_ID, Hours, Url, Description, Dayhours, Zspm_Ptaskfeedbackline_ID, Isprocessed, Hour_From, AD_Client_ID, AD_Org_ID, Actualcostamount, Isactive, Hour_To, created, createdby, updated, updatedBy)" +
      "        VALUES (TO_DATE(?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_TIMESTAMP(?, 'HH24:MI:SS'), (?), (?), TO_NUMBER(?), (?), TO_TIMESTAMP(?, 'HH24:MI:SS'), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, url);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayhours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskfeedbacklineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprocessed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourTo);
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
