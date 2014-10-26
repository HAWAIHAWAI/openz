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
class FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData implements FieldProvider {
static Logger log4j = Logger.getLogger(FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssmWorkstepVId;
  public String zssmWorkstepVIdr;
  public String zssmFeedbackVId;
  public String adClientId;
  public String workdate;
  public String hours;
  public String adOrgId;
  public String isactive;
  public String adUserId;
  public String adUserIdr;
  public String cSalaryCategoryId;
  public String cSalaryCategoryIdr;
  public String maMachineId;
  public String maMachineIdr;
  public String description;
  public String url;
  public String zssmProductionorderVId;
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
    else if (fieldName.equalsIgnoreCase("zssm_workstep_v_id") || fieldName.equals("zssmWorkstepVId"))
      return zssmWorkstepVId;
    else if (fieldName.equalsIgnoreCase("zssm_workstep_v_idr") || fieldName.equals("zssmWorkstepVIdr"))
      return zssmWorkstepVIdr;
    else if (fieldName.equalsIgnoreCase("zssm_feedback_v_id") || fieldName.equals("zssmFeedbackVId"))
      return zssmFeedbackVId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("workdate"))
      return workdate;
    else if (fieldName.equalsIgnoreCase("hours"))
      return hours;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
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
    else if (fieldName.equalsIgnoreCase("zssm_productionorder_v_id") || fieldName.equals("zssmProductionorderVId"))
      return zssmProductionorderVId;
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
  public static FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmWorkstepVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zssmWorkstepVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmWorkstepVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssm_feedback_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_feedback_v.CreatedBy) as CreatedByR, " +
      "        to_char(zssm_feedback_v.Updated, ?) as updated, " +
      "        to_char(zssm_feedback_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssm_feedback_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_feedback_v.UpdatedBy) as UpdatedByR," +
      "        zssm_feedback_v.Zssm_Workstep_V_ID, " +
      "(CASE WHEN zssm_feedback_v.Zssm_Workstep_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Zssm_Prj_Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.SeqNo), ''))),'') ) END) AS Zssm_Workstep_V_IDR, " +
      "zssm_feedback_v.Zssm_Feedback_V_ID, " +
      "zssm_feedback_v.AD_Client_ID, " +
      "zssm_feedback_v.Workdate, " +
      "zssm_feedback_v.Hours, " +
      "zssm_feedback_v.AD_Org_ID, " +
      "COALESCE(zssm_feedback_v.Isactive, 'N') AS Isactive, " +
      "zssm_feedback_v.AD_User_ID, " +
      "(CASE WHEN zssm_feedback_v.AD_User_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "zssm_feedback_v.C_Salary_Category_ID, " +
      "(CASE WHEN zssm_feedback_v.C_Salary_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Salary_Category_IDR, " +
      "zssm_feedback_v.MA_Machine_ID, " +
      "(CASE WHEN zssm_feedback_v.MA_Machine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS MA_Machine_IDR, " +
      "zssm_feedback_v.Description, " +
      "zssm_feedback_v.Url, " +
      "zssm_feedback_v.Zssm_Productionorder_V_ID, " +
      "zssm_feedback_v.Actualcostamount, " +
      "TO_CHAR(zssm_feedback_v.Hour_From, 'HH24:MI:SS') AS Hour_From, " +
      "TO_CHAR(zssm_feedback_v.Hour_To, 'HH24:MI:SS') AS Hour_To, " +
      "        ? AS LANGUAGE " +
      "        FROM zssm_feedback_v left join (select Zssm_Workstep_V_ID, Value, Name, Zssm_Prj_Name, SeqNo from Zssm_Workstep_V) table1 on (zssm_feedback_v.Zssm_Workstep_V_ID = table1.Zssm_Workstep_V_ID) left join (select AD_User_ID, Name from AD_User) table2 on (zssm_feedback_v.AD_User_ID =  table2.AD_User_ID) left join (select C_Salary_Category_ID, Name from C_Salary_Category) table3 on (zssm_feedback_v.C_Salary_Category_ID = table3.C_Salary_Category_ID) left join (select MA_Machine_ID, Value, Name from MA_Machine) table4 on (zssm_feedback_v.MA_Machine_ID = table4.MA_Machine_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zssmWorkstepVId==null || zssmWorkstepVId.equals(""))?"":"  AND zssm_feedback_v.Zssm_Workstep_V_ID = ?  ");
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
      if (zssmWorkstepVId != null && !(zssmWorkstepVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
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
        FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData = new FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData();
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.created = UtilSql.getValue(result, "created");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.updated = UtilSql.getValue(result, "updated");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.updatedby = UtilSql.getValue(result, "updatedby");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.zssmWorkstepVId = UtilSql.getValue(result, "zssm_workstep_v_id");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.zssmWorkstepVIdr = UtilSql.getValue(result, "zssm_workstep_v_idr");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.zssmFeedbackVId = UtilSql.getValue(result, "zssm_feedback_v_id");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.workdate = UtilSql.getDateValue(result, "workdate", "dd-MM-yyyy");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.hours = UtilSql.getValue(result, "hours");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.isactive = UtilSql.getValue(result, "isactive");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.cSalaryCategoryIdr = UtilSql.getValue(result, "c_salary_category_idr");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.maMachineIdr = UtilSql.getValue(result, "ma_machine_idr");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.description = UtilSql.getValue(result, "description");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.url = UtilSql.getValue(result, "url");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.zssmProductionorderVId = UtilSql.getValue(result, "zssm_productionorder_v_id");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.actualcostamount = UtilSql.getValue(result, "actualcostamount");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.hourFrom = UtilSql.getValue(result, "hour_from");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.hourTo = UtilSql.getValue(result, "hour_to");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.language = UtilSql.getValue(result, "language");
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.adUserClient = "";
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.adOrgClient = "";
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.createdby = "";
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.trBgcolor = "";
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.totalCount = "";
        objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData);
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
    FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[] = new FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[vector.size()];
    vector.copyInto(objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData);
    return(objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData);
  }

/**
Create a registry
 */
  public static FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[] set(String zssmWorkstepVId, String adClientId, String zssmFeedbackVId, String zssmProductionorderVId, String updatedby, String updatedbyr, String actualcostamount, String workdate, String isactive, String adOrgId, String maMachineId, String url, String createdby, String createdbyr, String hours, String hourFrom, String description, String cSalaryCategoryId, String hourTo, String adUserId)    throws ServletException {
    FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[] = new FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[1];
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0] = new FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData();
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].created = "";
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].createdbyr = createdbyr;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].updated = "";
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].updatedTimeStamp = "";
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].updatedby = updatedby;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].updatedbyr = updatedbyr;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].zssmWorkstepVId = zssmWorkstepVId;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].zssmWorkstepVIdr = "";
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].zssmFeedbackVId = zssmFeedbackVId;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].adClientId = adClientId;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].workdate = workdate;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].hours = hours;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].adOrgId = adOrgId;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].isactive = isactive;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].adUserId = adUserId;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].adUserIdr = "";
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].cSalaryCategoryId = cSalaryCategoryId;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].cSalaryCategoryIdr = "";
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].maMachineId = maMachineId;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].maMachineIdr = "";
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].description = description;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].url = url;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].zssmProductionorderVId = zssmProductionorderVId;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].actualcostamount = actualcostamount;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].hourFrom = hourFrom;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].hourTo = hourTo;
    objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0].language = "";
    return objectFeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData;
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
      "        SELECT zssm_feedback_v.Zssm_Workstep_V_ID AS NAME" +
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
  public static String selectParent(ConnectionProvider connectionProvider, String zssmWorkstepVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Zssm_Prj_Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.SeqNo), ''))) AS NAME FROM zssm_workstep_v left join (select Zssm_Workstep_V_ID, Value, Name, Zssm_Prj_Name, SeqNo from Zssm_Workstep_V) table1 on (zssm_workstep_v.Zssm_Workstep_V_ID = table1.Zssm_Workstep_V_ID) WHERE zssm_workstep_v.Zssm_Workstep_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String zssmWorkstepVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Zssm_Prj_Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.SeqNo), ''))) AS NAME FROM zssm_workstep_v left join (select Zssm_Workstep_V_ID, Value, Name, Zssm_Prj_Name, SeqNo from Zssm_Workstep_V) table1 on (zssm_workstep_v.Zssm_Workstep_V_ID = table1.Zssm_Workstep_V_ID) WHERE zssm_workstep_v.Zssm_Workstep_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);

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
      "        SET Zssm_Workstep_V_ID = (?) , Zssm_Feedback_V_ID = (?) , AD_Client_ID = (?) , Workdate = TO_DATE(?) , Hours = TO_NUMBER(?) , AD_Org_ID = (?) , Isactive = (?) , AD_User_ID = (?) , C_Salary_Category_ID = (?) , MA_Machine_ID = (?) , Description = (?) , Url = (?) , Zssm_Productionorder_V_ID = (?) , Actualcostamount = TO_NUMBER(?) , Hour_From = TO_TIMESTAMP(?,'HH24:MI:SS') , Hour_To = TO_TIMESTAMP(?,'HH24:MI:SS') , updated = now(), updatedby = ? " +
      "        WHERE zssm_feedback_v.Zssm_Feedback_V_ID = ? " +
      "                 AND zssm_feedback_v.Zssm_Workstep_V_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmFeedbackVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, url);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmFeedbackVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
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
      "        (Zssm_Workstep_V_ID, Zssm_Feedback_V_ID, AD_Client_ID, Workdate, Hours, AD_Org_ID, Isactive, AD_User_ID, C_Salary_Category_ID, MA_Machine_ID, Description, Url, Zssm_Productionorder_V_ID, Actualcostamount, Hour_From, Hour_To, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_DATE(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_TIMESTAMP(?, 'HH24:MI:SS'), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmFeedbackVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, url);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zssmWorkstepVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_feedback_v" +
      "        WHERE zssm_feedback_v.Zssm_Feedback_V_ID = ? " +
      "                 AND zssm_feedback_v.Zssm_Workstep_V_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zssmWorkstepVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_feedback_v" +
      "        WHERE zssm_feedback_v.Zssm_Feedback_V_ID = ? " +
      "                 AND zssm_feedback_v.Zssm_Workstep_V_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);

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
