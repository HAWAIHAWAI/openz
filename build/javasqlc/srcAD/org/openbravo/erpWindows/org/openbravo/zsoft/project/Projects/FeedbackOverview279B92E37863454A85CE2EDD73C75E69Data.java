//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.project.Projects;

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
class FeedbackOverview279B92E37863454A85CE2EDD73C75E69Data implements FieldProvider {
static Logger log4j = Logger.getLogger(FeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String zspmPtaskfeedbacklineId;
  public String workdate;
  public String adClientId;
  public String hours;
  public String cSalaryCategoryId;
  public String cSalaryCategoryIdr;
  public String adOrgId;
  public String adUserId;
  public String adUserIdr;
  public String isactive;
  public String maMachineId;
  public String maMachineIdr;
  public String description;
  public String actualcostamount;
  public String url;
  public String hourFrom;
  public String cProjectId;
  public String hourTo;
  public String isprocessed;
  public String dayhours;
  public String costuom;
  public String cCalendareventId;
  public String specialtime;
  public String specialtime2;
  public String triggeramt;
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
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("zspm_ptaskfeedbackline_id") || fieldName.equals("zspmPtaskfeedbacklineId"))
      return zspmPtaskfeedbacklineId;
    else if (fieldName.equalsIgnoreCase("workdate"))
      return workdate;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("hours"))
      return hours;
    else if (fieldName.equalsIgnoreCase("c_salary_category_id") || fieldName.equals("cSalaryCategoryId"))
      return cSalaryCategoryId;
    else if (fieldName.equalsIgnoreCase("c_salary_category_idr") || fieldName.equals("cSalaryCategoryIdr"))
      return cSalaryCategoryIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
    else if (fieldName.equalsIgnoreCase("ma_machine_idr") || fieldName.equals("maMachineIdr"))
      return maMachineIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("actualcostamount"))
      return actualcostamount;
    else if (fieldName.equalsIgnoreCase("url"))
      return url;
    else if (fieldName.equalsIgnoreCase("hour_from") || fieldName.equals("hourFrom"))
      return hourFrom;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("hour_to") || fieldName.equals("hourTo"))
      return hourTo;
    else if (fieldName.equalsIgnoreCase("isprocessed"))
      return isprocessed;
    else if (fieldName.equalsIgnoreCase("dayhours"))
      return dayhours;
    else if (fieldName.equalsIgnoreCase("costuom"))
      return costuom;
    else if (fieldName.equalsIgnoreCase("c_calendarevent_id") || fieldName.equals("cCalendareventId"))
      return cCalendareventId;
    else if (fieldName.equalsIgnoreCase("specialtime"))
      return specialtime;
    else if (fieldName.equalsIgnoreCase("specialtime2"))
      return specialtime2;
    else if (fieldName.equalsIgnoreCase("triggeramt"))
      return triggeramt;
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
  public static FeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjecttaskId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cProjecttaskId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static FeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjecttaskId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspm_ptaskfeedbackline.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_ptaskfeedbackline.CreatedBy) as CreatedByR, " +
      "        to_char(zspm_ptaskfeedbackline.Updated, ?) as updated, " +
      "        to_char(zspm_ptaskfeedbackline.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspm_ptaskfeedbackline.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_ptaskfeedbackline.UpdatedBy) as UpdatedByR," +
      "        zspm_ptaskfeedbackline.C_Projecttask_ID, " +
      "(CASE WHEN zspm_ptaskfeedbackline.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "zspm_ptaskfeedbackline.Zspm_Ptaskfeedbackline_ID, " +
      "zspm_ptaskfeedbackline.Workdate, " +
      "zspm_ptaskfeedbackline.AD_Client_ID, " +
      "zspm_ptaskfeedbackline.Hours, " +
      "zspm_ptaskfeedbackline.C_Salary_Category_ID, " +
      "(CASE WHEN zspm_ptaskfeedbackline.C_Salary_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Salary_Category_IDR, " +
      "zspm_ptaskfeedbackline.AD_Org_ID, " +
      "zspm_ptaskfeedbackline.AD_User_ID, " +
      "(CASE WHEN zspm_ptaskfeedbackline.AD_User_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "COALESCE(zspm_ptaskfeedbackline.Isactive, 'N') AS Isactive, " +
      "zspm_ptaskfeedbackline.MA_Machine_ID, " +
      "(CASE WHEN zspm_ptaskfeedbackline.MA_Machine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS MA_Machine_IDR, " +
      "zspm_ptaskfeedbackline.Description, " +
      "zspm_ptaskfeedbackline.Actualcostamount, " +
      "zspm_ptaskfeedbackline.Url, " +
      "TO_CHAR(zspm_ptaskfeedbackline.Hour_From, 'HH24:MI:SS') AS Hour_From, " +
      "zspm_ptaskfeedbackline.C_Project_ID, " +
      "TO_CHAR(zspm_ptaskfeedbackline.Hour_To, 'HH24:MI:SS') AS Hour_To, " +
      "COALESCE(zspm_ptaskfeedbackline.Isprocessed, 'N') AS Isprocessed, " +
      "zspm_ptaskfeedbackline.Dayhours, " +
      "zspm_ptaskfeedbackline.Costuom, " +
      "zspm_ptaskfeedbackline.C_Calendarevent_ID, " +
      "zspm_ptaskfeedbackline.Specialtime, " +
      "zspm_ptaskfeedbackline.Specialtime2, " +
      "zspm_ptaskfeedbackline.Triggeramt, " +
      "        ? AS LANGUAGE " +
      "        FROM zspm_ptaskfeedbackline left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table1 on (zspm_ptaskfeedbackline.C_Projecttask_ID = table1.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (table1.C_Project_ID = table2.C_Project_ID) left join (select C_Salary_Category_ID, Name from C_Salary_Category) table3 on (zspm_ptaskfeedbackline.C_Salary_Category_ID = table3.C_Salary_Category_ID) left join (select AD_User_ID, Name from AD_User) table4 on (zspm_ptaskfeedbackline.AD_User_ID =  table4.AD_User_ID) left join (select MA_Machine_ID, Value, Name from MA_Machine) table5 on (zspm_ptaskfeedbackline.MA_Machine_ID = table5.MA_Machine_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cProjecttaskId==null || cProjecttaskId.equals(""))?"":"  AND zspm_ptaskfeedbackline.C_Projecttask_ID = ?  ");
    strSql = strSql + 
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
      if (cProjecttaskId != null && !(cProjecttaskId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
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
        FeedbackOverview279B92E37863454A85CE2EDD73C75E69Data objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data = new FeedbackOverview279B92E37863454A85CE2EDD73C75E69Data();
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.created = UtilSql.getValue(result, "created");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.updated = UtilSql.getValue(result, "updated");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.zspmPtaskfeedbacklineId = UtilSql.getValue(result, "zspm_ptaskfeedbackline_id");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.workdate = UtilSql.getDateValue(result, "workdate", "dd-MM-yyyy");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.hours = UtilSql.getValue(result, "hours");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.cSalaryCategoryIdr = UtilSql.getValue(result, "c_salary_category_idr");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.isactive = UtilSql.getValue(result, "isactive");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.maMachineIdr = UtilSql.getValue(result, "ma_machine_idr");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.description = UtilSql.getValue(result, "description");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.actualcostamount = UtilSql.getValue(result, "actualcostamount");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.url = UtilSql.getValue(result, "url");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.hourFrom = UtilSql.getValue(result, "hour_from");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.hourTo = UtilSql.getValue(result, "hour_to");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.isprocessed = UtilSql.getValue(result, "isprocessed");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.dayhours = UtilSql.getValue(result, "dayhours");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.costuom = UtilSql.getValue(result, "costuom");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.cCalendareventId = UtilSql.getValue(result, "c_calendarevent_id");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.specialtime = UtilSql.getValue(result, "specialtime");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.specialtime2 = UtilSql.getValue(result, "specialtime2");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.triggeramt = UtilSql.getValue(result, "triggeramt");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.language = UtilSql.getValue(result, "language");
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.adUserClient = "";
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.adOrgClient = "";
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.createdby = "";
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.trBgcolor = "";
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.totalCount = "";
        objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data);
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
    FeedbackOverview279B92E37863454A85CE2EDD73C75E69Data objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[] = new FeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[vector.size()];
    vector.copyInto(objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data);
    return(objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data);
  }

/**
Create a registry
 */
  public static FeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[] set(String cProjecttaskId, String cSalaryCategoryId, String workdate, String description, String specialtime, String hourTo, String triggeramt, String adClientId, String dayhours, String updatedby, String updatedbyr, String isprocessed, String zspmPtaskfeedbacklineId, String hours, String createdby, String createdbyr, String costuom, String adOrgId, String hourFrom, String actualcostamount, String specialtime2, String url, String maMachineId, String isactive, String cProjectId, String cCalendareventId, String adUserId)    throws ServletException {
    FeedbackOverview279B92E37863454A85CE2EDD73C75E69Data objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[] = new FeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[1];
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0] = new FeedbackOverview279B92E37863454A85CE2EDD73C75E69Data();
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].created = "";
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].createdbyr = createdbyr;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].updated = "";
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].updatedTimeStamp = "";
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].updatedby = updatedby;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].updatedbyr = updatedbyr;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].cProjecttaskId = cProjecttaskId;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].cProjecttaskIdr = "";
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].zspmPtaskfeedbacklineId = zspmPtaskfeedbacklineId;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].workdate = workdate;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].adClientId = adClientId;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].hours = hours;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].cSalaryCategoryId = cSalaryCategoryId;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].cSalaryCategoryIdr = "";
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].adOrgId = adOrgId;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].adUserId = adUserId;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].adUserIdr = "";
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].isactive = isactive;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].maMachineId = maMachineId;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].maMachineIdr = "";
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].description = description;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].actualcostamount = actualcostamount;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].url = url;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].hourFrom = hourFrom;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].cProjectId = cProjectId;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].hourTo = hourTo;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].isprocessed = isprocessed;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].dayhours = dayhours;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].costuom = costuom;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].cCalendareventId = cCalendareventId;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].specialtime = specialtime;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].specialtime2 = specialtime2;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].triggeramt = triggeramt;
    objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data[0].language = "";
    return objectFeedbackOverview279B92E37863454A85CE2EDD73C75E69Data;
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
  public static String selectDef91F75684F9FA4CFE9AFFA6E3A4C52E7A_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefECFFEA70E45840F78F27B8164CFB6BA6_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT zspm_ptaskfeedbackline.C_Projecttask_ID AS NAME" +
      "        FROM zspm_ptaskfeedbackline" +
      "        WHERE zspm_ptaskfeedbackline.Zspm_Ptaskfeedbackline_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cProjecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))) AS NAME FROM C_ProjectTask left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table1 on (C_ProjectTask.C_Projecttask_ID = table1.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (table1.C_Project_ID = table2.C_Project_ID) WHERE C_ProjectTask.C_Projecttask_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cProjecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))) AS NAME FROM C_ProjectTask left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table1 on (C_ProjectTask.C_Projecttask_ID = table1.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (table1.C_Project_ID = table2.C_Project_ID) WHERE C_ProjectTask.C_Projecttask_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);

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
      "        UPDATE zspm_ptaskfeedbackline" +
      "        SET C_Projecttask_ID = (?) , Zspm_Ptaskfeedbackline_ID = (?) , Workdate = TO_DATE(?) , AD_Client_ID = (?) , Hours = TO_NUMBER(?) , C_Salary_Category_ID = (?) , AD_Org_ID = (?) , AD_User_ID = (?) , Isactive = (?) , MA_Machine_ID = (?) , Description = (?) , Actualcostamount = TO_NUMBER(?) , Url = (?) , Hour_From = TO_TIMESTAMP(?,'HH24:MI:SS') , C_Project_ID = (?) , Hour_To = TO_TIMESTAMP(?,'HH24:MI:SS') , Isprocessed = (?) , Dayhours = (?) , Costuom = (?) , C_Calendarevent_ID = (?) , Specialtime = TO_NUMBER(?) , Specialtime2 = TO_NUMBER(?) , Triggeramt = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE zspm_ptaskfeedbackline.Zspm_Ptaskfeedbackline_ID = ? " +
      "                 AND zspm_ptaskfeedbackline.C_Projecttask_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskfeedbacklineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, url);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprocessed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayhours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, specialtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, specialtime2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, triggeramt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskfeedbacklineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
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
      "        (C_Projecttask_ID, Zspm_Ptaskfeedbackline_ID, Workdate, AD_Client_ID, Hours, C_Salary_Category_ID, AD_Org_ID, AD_User_ID, Isactive, MA_Machine_ID, Description, Actualcostamount, Url, Hour_From, C_Project_ID, Hour_To, Isprocessed, Dayhours, Costuom, C_Calendarevent_ID, Specialtime, Specialtime2, Triggeramt, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_DATE(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_TIMESTAMP(?, 'HH24:MI:SS'), (?), TO_TIMESTAMP(?, 'HH24:MI:SS'), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskfeedbacklineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, url);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprocessed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayhours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, specialtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, specialtime2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, triggeramt);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cProjecttaskId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspm_ptaskfeedbackline" +
      "        WHERE zspm_ptaskfeedbackline.Zspm_Ptaskfeedbackline_ID = ? " +
      "                 AND zspm_ptaskfeedbackline.C_Projecttask_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cProjecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspm_ptaskfeedbackline" +
      "        WHERE zspm_ptaskfeedbackline.Zspm_Ptaskfeedbackline_ID = ? " +
      "                 AND zspm_ptaskfeedbackline.C_Projecttask_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);

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
