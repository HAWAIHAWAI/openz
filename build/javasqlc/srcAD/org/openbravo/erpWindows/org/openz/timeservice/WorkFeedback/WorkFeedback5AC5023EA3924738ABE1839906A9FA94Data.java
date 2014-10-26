//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openz.timeservice.WorkFeedback;

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
class WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data implements FieldProvider {
static Logger log4j = Logger.getLogger(WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String tsrvFeedbackVId;
  public String adClientId;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String isactive;
  public String employeeId;
  public String employeeIdr;
  public String cSalaryCategoryId;
  public String cSalaryCategoryIdr;
  public String workdate;
  public String hourFrom;
  public String hourTo;
  public String breaktime;
  public String traveltime;
  public String timeunderhelmet;
  public String timeunderhelmet2;
  public String triggeramt;
  public String cCalendareventId;
  public String cCalendareventIdr;
  public String description;
  public String hours;
  public String actualcostamount;
  public String issaturday;
  public String issunday;
  public String isholiday;
  public String overtimehours;
  public String nighthours;
  public String maMachineId;
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
    else if (fieldName.equalsIgnoreCase("tsrv_feedback_v_id") || fieldName.equals("tsrvFeedbackVId"))
      return tsrvFeedbackVId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("employee_id") || fieldName.equals("employeeId"))
      return employeeId;
    else if (fieldName.equalsIgnoreCase("employee_idr") || fieldName.equals("employeeIdr"))
      return employeeIdr;
    else if (fieldName.equalsIgnoreCase("c_salary_category_id") || fieldName.equals("cSalaryCategoryId"))
      return cSalaryCategoryId;
    else if (fieldName.equalsIgnoreCase("c_salary_category_idr") || fieldName.equals("cSalaryCategoryIdr"))
      return cSalaryCategoryIdr;
    else if (fieldName.equalsIgnoreCase("workdate"))
      return workdate;
    else if (fieldName.equalsIgnoreCase("hour_from") || fieldName.equals("hourFrom"))
      return hourFrom;
    else if (fieldName.equalsIgnoreCase("hour_to") || fieldName.equals("hourTo"))
      return hourTo;
    else if (fieldName.equalsIgnoreCase("breaktime"))
      return breaktime;
    else if (fieldName.equalsIgnoreCase("traveltime"))
      return traveltime;
    else if (fieldName.equalsIgnoreCase("timeunderhelmet"))
      return timeunderhelmet;
    else if (fieldName.equalsIgnoreCase("timeunderhelmet2"))
      return timeunderhelmet2;
    else if (fieldName.equalsIgnoreCase("triggeramt"))
      return triggeramt;
    else if (fieldName.equalsIgnoreCase("c_calendarevent_id") || fieldName.equals("cCalendareventId"))
      return cCalendareventId;
    else if (fieldName.equalsIgnoreCase("c_calendarevent_idr") || fieldName.equals("cCalendareventIdr"))
      return cCalendareventIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("hours"))
      return hours;
    else if (fieldName.equalsIgnoreCase("actualcostamount"))
      return actualcostamount;
    else if (fieldName.equalsIgnoreCase("issaturday"))
      return issaturday;
    else if (fieldName.equalsIgnoreCase("issunday"))
      return issunday;
    else if (fieldName.equalsIgnoreCase("isholiday"))
      return isholiday;
    else if (fieldName.equalsIgnoreCase("overtimehours"))
      return overtimehours;
    else if (fieldName.equalsIgnoreCase("nighthours"))
      return nighthours;
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
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
  public static WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(tsrv_feedback_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = tsrv_feedback_v.CreatedBy) as CreatedByR, " +
      "        to_char(tsrv_feedback_v.Updated, ?) as updated, " +
      "        to_char(tsrv_feedback_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        tsrv_feedback_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = tsrv_feedback_v.UpdatedBy) as UpdatedByR," +
      "        tsrv_feedback_v.AD_Org_ID, " +
      "(CASE WHEN tsrv_feedback_v.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "tsrv_feedback_v.Tsrv_Feedback_V_ID, " +
      "tsrv_feedback_v.AD_Client_ID, " +
      "tsrv_feedback_v.c_project_id, " +
      "(CASE WHEN tsrv_feedback_v.c_project_id IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS c_project_idR, " +
      "tsrv_feedback_v.c_projecttask_id, " +
      "(CASE WHEN tsrv_feedback_v.c_projecttask_id IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS c_projecttask_idR, " +
      "COALESCE(tsrv_feedback_v.Isactive, 'N') AS Isactive, " +
      "tsrv_feedback_v.employee_id, " +
      "(CASE WHEN tsrv_feedback_v.employee_id IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS employee_idR, " +
      "tsrv_feedback_v.C_Salary_Category_ID, " +
      "(CASE WHEN tsrv_feedback_v.C_Salary_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_Salary_Category_IDR, " +
      "tsrv_feedback_v.Workdate, " +
      "TO_CHAR(tsrv_feedback_v.Hour_From, 'HH24:MI:SS') AS Hour_From, " +
      "TO_CHAR(tsrv_feedback_v.Hour_To, 'HH24:MI:SS') AS Hour_To, " +
      "tsrv_feedback_v.Breaktime, " +
      "tsrv_feedback_v.Traveltime, " +
      "tsrv_feedback_v.Timeunderhelmet, " +
      "tsrv_feedback_v.Timeunderhelmet2, " +
      "tsrv_feedback_v.Triggeramt, " +
      "tsrv_feedback_v.C_Calendarevent_ID, " +
      "(CASE WHEN tsrv_feedback_v.C_Calendarevent_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_Calendarevent_IDR, " +
      "tsrv_feedback_v.Description, " +
      "tsrv_feedback_v.Hours, " +
      "tsrv_feedback_v.Actualcostamount, " +
      "COALESCE(tsrv_feedback_v.Issaturday, 'N') AS Issaturday, " +
      "COALESCE(tsrv_feedback_v.Issunday, 'N') AS Issunday, " +
      "COALESCE(tsrv_feedback_v.Isholiday, 'N') AS Isholiday, " +
      "tsrv_feedback_v.Overtimehours, " +
      "tsrv_feedback_v.Nighthours, " +
      "tsrv_feedback_v.MA_Machine_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM tsrv_feedback_v left join (select AD_Org_ID, Name from AD_Org) table1 on (tsrv_feedback_v.AD_Org_ID = table1.AD_Org_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (tsrv_feedback_v.c_project_id = table2.C_Project_ID) left join (select c_projecttask_id, Name, C_Project_ID from c_projecttask) table3 on (tsrv_feedback_v.c_projecttask_id = table3.c_projecttask_id) left join (select C_Project_ID, Value, Name from C_Project) table4 on (table3.C_Project_ID = table4.C_Project_ID) left join (select AD_User_ID, Name from AD_User) table5 on (tsrv_feedback_v.employee_id =  table5.AD_User_ID) left join (select C_Salary_Category_ID, Name from C_Salary_Category) table6 on (tsrv_feedback_v.C_Salary_Category_ID = table6.C_Salary_Category_ID) left join (select C_Calendarevent_ID, Name from C_CALENDAREVENT) table7 on (tsrv_feedback_v.C_Calendarevent_ID =  table7.C_Calendarevent_ID)" +
      "        WHERE 2=2 " +
      " AND employee_id is not null" +
      "        AND 1=1 " +
      "        AND tsrv_feedback_v.Tsrv_Feedback_V_ID = ? " +
      "        AND tsrv_feedback_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND tsrv_feedback_v.AD_Org_ID IN (";
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
        WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data = new WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data();
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.created = UtilSql.getValue(result, "created");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.updated = UtilSql.getValue(result, "updated");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.tsrvFeedbackVId = UtilSql.getValue(result, "tsrv_feedback_v_id");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.isactive = UtilSql.getValue(result, "isactive");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.employeeId = UtilSql.getValue(result, "employee_id");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.employeeIdr = UtilSql.getValue(result, "employee_idr");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.cSalaryCategoryIdr = UtilSql.getValue(result, "c_salary_category_idr");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.workdate = UtilSql.getDateValue(result, "workdate", "dd-MM-yyyy");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.hourFrom = UtilSql.getValue(result, "hour_from");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.hourTo = UtilSql.getValue(result, "hour_to");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.breaktime = UtilSql.getValue(result, "breaktime");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.traveltime = UtilSql.getValue(result, "traveltime");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.timeunderhelmet = UtilSql.getValue(result, "timeunderhelmet");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.timeunderhelmet2 = UtilSql.getValue(result, "timeunderhelmet2");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.triggeramt = UtilSql.getValue(result, "triggeramt");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.cCalendareventId = UtilSql.getValue(result, "c_calendarevent_id");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.cCalendareventIdr = UtilSql.getValue(result, "c_calendarevent_idr");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.description = UtilSql.getValue(result, "description");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.hours = UtilSql.getValue(result, "hours");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.actualcostamount = UtilSql.getValue(result, "actualcostamount");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.issaturday = UtilSql.getValue(result, "issaturday");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.issunday = UtilSql.getValue(result, "issunday");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.isholiday = UtilSql.getValue(result, "isholiday");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.overtimehours = UtilSql.getValue(result, "overtimehours");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.nighthours = UtilSql.getValue(result, "nighthours");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.language = UtilSql.getValue(result, "language");
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.adUserClient = "";
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.adOrgClient = "";
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.createdby = "";
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.trBgcolor = "";
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.totalCount = "";
        objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data);
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
    WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[] = new WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[vector.size()];
    vector.copyInto(objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data);
    return(objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data);
  }

/**
Create a registry
 */
  public static WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[] set(String tsrvFeedbackVId, String hourFrom, String adClientId, String triggeramt, String description, String nighthours, String actualcostamount, String isholiday, String issaturday, String isactive, String overtimehours, String maMachineId, String workdate, String issunday, String breaktime, String cCalendareventId, String timeunderhelmet, String cProjectId, String cProjectIdr, String cProjecttaskId, String timeunderhelmet2, String createdby, String createdbyr, String hourTo, String updatedby, String updatedbyr, String traveltime, String adOrgId, String employeeId, String cSalaryCategoryId, String hours)    throws ServletException {
    WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[] = new WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[1];
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0] = new WorkFeedback5AC5023EA3924738ABE1839906A9FA94Data();
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].created = "";
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].createdbyr = createdbyr;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].updated = "";
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].updatedTimeStamp = "";
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].updatedby = updatedby;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].updatedbyr = updatedbyr;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].adOrgId = adOrgId;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].adOrgIdr = "";
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].tsrvFeedbackVId = tsrvFeedbackVId;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].adClientId = adClientId;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].cProjectId = cProjectId;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].cProjectIdr = cProjectIdr;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].cProjecttaskId = cProjecttaskId;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].cProjecttaskIdr = "";
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].isactive = isactive;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].employeeId = employeeId;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].employeeIdr = "";
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].cSalaryCategoryId = cSalaryCategoryId;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].cSalaryCategoryIdr = "";
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].workdate = workdate;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].hourFrom = hourFrom;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].hourTo = hourTo;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].breaktime = breaktime;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].traveltime = traveltime;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].timeunderhelmet = timeunderhelmet;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].timeunderhelmet2 = timeunderhelmet2;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].triggeramt = triggeramt;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].cCalendareventId = cCalendareventId;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].cCalendareventIdr = "";
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].description = description;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].hours = hours;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].actualcostamount = actualcostamount;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].issaturday = issaturday;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].issunday = issunday;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].isholiday = isholiday;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].overtimehours = overtimehours;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].nighthours = nighthours;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].maMachineId = maMachineId;
    objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data[0].language = "";
    return objectWorkFeedback5AC5023EA3924738ABE1839906A9FA94Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefD9982ED00D794A11A00DA0C095BB82A7_0(ConnectionProvider connectionProvider, String c_project_idR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as c_project_id FROM C_Project table1 WHERE table1.isActive='Y' AND table1.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_project_idR);

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
  public static String selectDef995FEA97D55B4F6795734CA0820FB547_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef979476B70FBB4159A7BCD7644A835106_2(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        UPDATE tsrv_feedback_v" +
      "        SET AD_Org_ID = (?) , Tsrv_Feedback_V_ID = (?) , AD_Client_ID = (?) , c_project_id = (?) , c_projecttask_id = (?) , Isactive = (?) , employee_id = (?) , C_Salary_Category_ID = (?) , Workdate = TO_DATE(?) , Hour_From = TO_TIMESTAMP(?,'HH24:MI:SS') , Hour_To = TO_TIMESTAMP(?,'HH24:MI:SS') , Breaktime = TO_NUMBER(?) , Traveltime = TO_NUMBER(?) , Timeunderhelmet = TO_NUMBER(?) , Timeunderhelmet2 = TO_NUMBER(?) , Triggeramt = TO_NUMBER(?) , C_Calendarevent_ID = (?) , Description = (?) , Hours = TO_NUMBER(?) , Actualcostamount = TO_NUMBER(?) , Issaturday = (?) , Issunday = (?) , Isholiday = (?) , Overtimehours = TO_NUMBER(?) , Nighthours = TO_NUMBER(?) , MA_Machine_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE tsrv_feedback_v.Tsrv_Feedback_V_ID = ? " +
      "        AND tsrv_feedback_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND tsrv_feedback_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tsrvFeedbackVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, employeeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, breaktime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, traveltime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timeunderhelmet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timeunderhelmet2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, triggeramt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issaturday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issunday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isholiday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, overtimehours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nighthours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tsrvFeedbackVId);
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
      "        INSERT INTO tsrv_feedback_v " +
      "        (AD_Org_ID, Tsrv_Feedback_V_ID, AD_Client_ID, c_project_id, c_projecttask_id, Isactive, employee_id, C_Salary_Category_ID, Workdate, Hour_From, Hour_To, Breaktime, Traveltime, Timeunderhelmet, Timeunderhelmet2, Triggeramt, C_Calendarevent_ID, Description, Hours, Actualcostamount, Issaturday, Issunday, Isholiday, Overtimehours, Nighthours, MA_Machine_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_TIMESTAMP(?, 'HH24:MI:SS'), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tsrvFeedbackVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, employeeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, breaktime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, traveltime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timeunderhelmet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timeunderhelmet2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, triggeramt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issaturday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issunday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isholiday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, overtimehours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nighthours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
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
      "        DELETE FROM tsrv_feedback_v" +
      "        WHERE tsrv_feedback_v.Tsrv_Feedback_V_ID = ? " +
      "        AND tsrv_feedback_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND tsrv_feedback_v.AD_Org_ID IN (";
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
      "        DELETE FROM tsrv_feedback_v" +
      "        WHERE tsrv_feedback_v.Tsrv_Feedback_V_ID = ? ";

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
      "          FROM tsrv_feedback_v" +
      "         WHERE tsrv_feedback_v.Tsrv_Feedback_V_ID = ? ";

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
      "          FROM tsrv_feedback_v" +
      "         WHERE tsrv_feedback_v.Tsrv_Feedback_V_ID = ? ";

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
