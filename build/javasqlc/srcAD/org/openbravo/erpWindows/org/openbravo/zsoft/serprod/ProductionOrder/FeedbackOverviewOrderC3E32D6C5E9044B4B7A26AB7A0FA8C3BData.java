//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.ProductionOrder;

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
class FeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData implements FieldProvider {
static Logger log4j = Logger.getLogger(FeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssmFeedbackVId;
  public String zssmProductionorderVId;
  public String zssmProductionorderVIdr;
  public String adClientId;
  public String zssmWorkstepVId;
  public String zssmWorkstepVIdr;
  public String workdate;
  public String adOrgId;
  public String hours;
  public String isactive;
  public String adUserId;
  public String adUserIdr;
  public String cSalaryCategoryId;
  public String cSalaryCategoryIdr;
  public String maMachineId;
  public String maMachineIdr;
  public String description;
  public String url;
  public String actualcostamount;
  public String hourFrom;
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
    else if (fieldName.equalsIgnoreCase("zssm_feedback_v_id") || fieldName.equals("zssmFeedbackVId"))
      return zssmFeedbackVId;
    else if (fieldName.equalsIgnoreCase("zssm_productionorder_v_id") || fieldName.equals("zssmProductionorderVId"))
      return zssmProductionorderVId;
    else if (fieldName.equalsIgnoreCase("zssm_productionorder_v_idr") || fieldName.equals("zssmProductionorderVIdr"))
      return zssmProductionorderVIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("zssm_workstep_v_id") || fieldName.equals("zssmWorkstepVId"))
      return zssmWorkstepVId;
    else if (fieldName.equalsIgnoreCase("zssm_workstep_v_idr") || fieldName.equals("zssmWorkstepVIdr"))
      return zssmWorkstepVIdr;
    else if (fieldName.equalsIgnoreCase("workdate"))
      return workdate;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("hours"))
      return hours;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("c_salary_category_id") || fieldName.equals("cSalaryCategoryId"))
      return cSalaryCategoryId;
    else if (fieldName.equalsIgnoreCase("c_salary_category_idr") || fieldName.equals("cSalaryCategoryIdr"))
      return cSalaryCategoryIdr;
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
    else if (fieldName.equalsIgnoreCase("ma_machine_idr") || fieldName.equals("maMachineIdr"))
      return maMachineIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("url"))
      return url;
    else if (fieldName.equalsIgnoreCase("actualcostamount"))
      return actualcostamount;
    else if (fieldName.equalsIgnoreCase("hour_from") || fieldName.equals("hourFrom"))
      return hourFrom;
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
  public static FeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmProductionorderVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zssmProductionorderVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static FeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmProductionorderVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssm_feedback_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_feedback_v.CreatedBy) as CreatedByR, " +
      "        to_char(zssm_feedback_v.Updated, ?) as updated, " +
      "        to_char(zssm_feedback_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssm_feedback_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_feedback_v.UpdatedBy) as UpdatedByR," +
      "        zssm_feedback_v.Zssm_Feedback_V_ID, " +
      "zssm_feedback_v.Zssm_Productionorder_V_ID, " +
      "(CASE WHEN zssm_feedback_v.Zssm_Productionorder_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS Zssm_Productionorder_V_IDR, " +
      "zssm_feedback_v.AD_Client_ID, " +
      "zssm_feedback_v.Zssm_Workstep_V_ID, " +
      "(CASE WHEN zssm_feedback_v.Zssm_Workstep_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Zssm_Prj_Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.SeqNo), ''))),'') ) END) AS Zssm_Workstep_V_IDR, " +
      "zssm_feedback_v.Workdate, " +
      "zssm_feedback_v.AD_Org_ID, " +
      "zssm_feedback_v.Hours, " +
      "COALESCE(zssm_feedback_v.Isactive, 'N') AS Isactive, " +
      "zssm_feedback_v.AD_User_ID, " +
      "(CASE WHEN zssm_feedback_v.AD_User_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "zssm_feedback_v.C_Salary_Category_ID, " +
      "(CASE WHEN zssm_feedback_v.C_Salary_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Salary_Category_IDR, " +
      "zssm_feedback_v.MA_Machine_ID, " +
      "(CASE WHEN zssm_feedback_v.MA_Machine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS MA_Machine_IDR, " +
      "zssm_feedback_v.Description, " +
      "zssm_feedback_v.Url, " +
      "zssm_feedback_v.Actualcostamount, " +
      "TO_CHAR(zssm_feedback_v.Hour_From, 'HH24:MI:SS') AS Hour_From, " +
      "TO_CHAR(zssm_feedback_v.Hour_To, 'HH24:MI:SS') AS Hour_To, " +
      "        ? AS LANGUAGE " +
      "        FROM zssm_feedback_v left join (select Zssm_Productionorder_V_ID, Value, Name from Zssm_Productionorder_V) table1 on (zssm_feedback_v.Zssm_Productionorder_V_ID = table1.Zssm_Productionorder_V_ID) left join (select Zssm_Workstep_V_ID, Value, Name, Zssm_Prj_Name, SeqNo from Zssm_Workstep_V) table2 on (zssm_feedback_v.Zssm_Workstep_V_ID = table2.Zssm_Workstep_V_ID) left join (select AD_User_ID, Name from AD_User) table3 on (zssm_feedback_v.AD_User_ID =  table3.AD_User_ID) left join (select C_Salary_Category_ID, Name from C_Salary_Category) table4 on (zssm_feedback_v.C_Salary_Category_ID = table4.C_Salary_Category_ID) left join (select MA_Machine_ID, Value, Name from MA_Machine) table5 on (zssm_feedback_v.MA_Machine_ID = table5.MA_Machine_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zssmProductionorderVId==null || zssmProductionorderVId.equals(""))?"":"  AND zssm_feedback_v.Zssm_Productionorder_V_ID = ?  ");
    strSql = strSql + 
      "        AND zssm_feedback_v.Zssm_Feedback_V_ID = ? " +
      "        AND zssm_feedback_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssm_feedback_v.AD_Org_ID IN (";
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
      if (zssmProductionorderVId != null && !(zssmProductionorderVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
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
        FeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData = new FeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData();
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.created = UtilSql.getValue(result, "created");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.updated = UtilSql.getValue(result, "updated");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.updatedby = UtilSql.getValue(result, "updatedby");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.zssmFeedbackVId = UtilSql.getValue(result, "zssm_feedback_v_id");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.zssmProductionorderVId = UtilSql.getValue(result, "zssm_productionorder_v_id");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.zssmProductionorderVIdr = UtilSql.getValue(result, "zssm_productionorder_v_idr");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.zssmWorkstepVId = UtilSql.getValue(result, "zssm_workstep_v_id");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.zssmWorkstepVIdr = UtilSql.getValue(result, "zssm_workstep_v_idr");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.workdate = UtilSql.getDateValue(result, "workdate", "dd-MM-yyyy");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.hours = UtilSql.getValue(result, "hours");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.isactive = UtilSql.getValue(result, "isactive");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.cSalaryCategoryIdr = UtilSql.getValue(result, "c_salary_category_idr");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.maMachineIdr = UtilSql.getValue(result, "ma_machine_idr");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.description = UtilSql.getValue(result, "description");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.url = UtilSql.getValue(result, "url");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.actualcostamount = UtilSql.getValue(result, "actualcostamount");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.hourFrom = UtilSql.getValue(result, "hour_from");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.hourTo = UtilSql.getValue(result, "hour_to");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.language = UtilSql.getValue(result, "language");
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.adUserClient = "";
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.adOrgClient = "";
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.createdby = "";
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.trBgcolor = "";
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.totalCount = "";
        objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData);
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
    FeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[] = new FeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[vector.size()];
    vector.copyInto(objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData);
    return(objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData);
  }

/**
Create a registry
 */
  public static FeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[] set(String zssmProductionorderVId, String adClientId, String zssmFeedbackVId, String zssmWorkstepVId, String updatedby, String updatedbyr, String actualcostamount, String isactive, String workdate, String maMachineId, String url, String adOrgId, String createdby, String createdbyr, String hours, String hourFrom, String description, String cSalaryCategoryId, String hourTo, String adUserId)    throws ServletException {
    FeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[] = new FeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[1];
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0] = new FeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData();
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].created = "";
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].createdbyr = createdbyr;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].updated = "";
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].updatedTimeStamp = "";
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].updatedby = updatedby;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].updatedbyr = updatedbyr;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].zssmFeedbackVId = zssmFeedbackVId;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].zssmProductionorderVId = zssmProductionorderVId;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].zssmProductionorderVIdr = "";
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].adClientId = adClientId;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].zssmWorkstepVId = zssmWorkstepVId;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].zssmWorkstepVIdr = "";
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].workdate = workdate;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].adOrgId = adOrgId;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].hours = hours;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].isactive = isactive;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].adUserId = adUserId;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].adUserIdr = "";
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].cSalaryCategoryId = cSalaryCategoryId;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].cSalaryCategoryIdr = "";
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].maMachineId = maMachineId;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].maMachineIdr = "";
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].description = description;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].url = url;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].actualcostamount = actualcostamount;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].hourFrom = hourFrom;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].hourTo = hourTo;
    objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData[0].language = "";
    return objectFeedbackOverviewOrderC3E32D6C5E9044B4B7A26AB7A0FA8C3BData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef6DF1DBCDF7414D599E6D831563111F5C_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefF025FC1B7D2E4F18A0332BD422842C69_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT zssm_feedback_v.Zssm_Productionorder_V_ID AS NAME" +
      "        FROM zssm_feedback_v" +
      "        WHERE zssm_feedback_v.Zssm_Feedback_V_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String zssmProductionorderVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM zssm_productionorder_v left join (select Zssm_Productionorder_V_ID, Value, Name from Zssm_Productionorder_V) table1 on (zssm_productionorder_v.Zssm_Productionorder_V_ID = table1.Zssm_Productionorder_V_ID) WHERE zssm_productionorder_v.Zssm_Productionorder_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String zssmProductionorderVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM zssm_productionorder_v left join (select Zssm_Productionorder_V_ID, Value, Name from Zssm_Productionorder_V) table1 on (zssm_productionorder_v.Zssm_Productionorder_V_ID = table1.Zssm_Productionorder_V_ID) WHERE zssm_productionorder_v.Zssm_Productionorder_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);

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
      "        UPDATE zssm_feedback_v" +
      "        SET Zssm_Feedback_V_ID = (?) , Zssm_Productionorder_V_ID = (?) , AD_Client_ID = (?) , Zssm_Workstep_V_ID = (?) , Workdate = TO_DATE(?) , AD_Org_ID = (?) , Hours = TO_NUMBER(?) , Isactive = (?) , AD_User_ID = (?) , C_Salary_Category_ID = (?) , MA_Machine_ID = (?) , Description = (?) , Url = (?) , Actualcostamount = TO_NUMBER(?) , Hour_From = TO_TIMESTAMP(?,'HH24:MI:SS') , Hour_To = TO_TIMESTAMP(?,'HH24:MI:SS') , updated = now(), updatedby = ? " +
      "        WHERE zssm_feedback_v.Zssm_Feedback_V_ID = ? " +
      "                 AND zssm_feedback_v.Zssm_Productionorder_V_ID = ? " +
      "        AND zssm_feedback_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_feedback_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmFeedbackVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, url);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmFeedbackVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
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
      "        INSERT INTO zssm_feedback_v " +
      "        (Zssm_Feedback_V_ID, Zssm_Productionorder_V_ID, AD_Client_ID, Zssm_Workstep_V_ID, Workdate, AD_Org_ID, Hours, Isactive, AD_User_ID, C_Salary_Category_ID, MA_Machine_ID, Description, Url, Actualcostamount, Hour_From, Hour_To, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_DATE(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_TIMESTAMP(?, 'HH24:MI:SS'), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmFeedbackVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, url);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourFrom);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zssmProductionorderVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_feedback_v" +
      "        WHERE zssm_feedback_v.Zssm_Feedback_V_ID = ? " +
      "                 AND zssm_feedback_v.Zssm_Productionorder_V_ID = ? " +
      "        AND zssm_feedback_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_feedback_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zssmProductionorderVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_feedback_v" +
      "        WHERE zssm_feedback_v.Zssm_Feedback_V_ID = ? " +
      "                 AND zssm_feedback_v.Zssm_Productionorder_V_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);

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
      "          FROM zssm_feedback_v" +
      "         WHERE zssm_feedback_v.Zssm_Feedback_V_ID = ? ";

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
      "          FROM zssm_feedback_v" +
      "         WHERE zssm_feedback_v.Zssm_Feedback_V_ID = ? ";

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
