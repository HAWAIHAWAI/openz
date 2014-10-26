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
class Activities6F92F616B40C49FD9F2E8DE87216DD55Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Activities6F92F616B40C49FD9F2E8DE87216DD55Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zspmPtaskhrplanId;
  public String zssmWorkstepVId;
  public String zssmWorkstepVIdr;
  public String adClientId;
  public String cSalaryCategoryId;
  public String cSalaryCategoryIdr;
  public String averageduration;
  public String adOrgId;
  public String durationunit;
  public String durationunitr;
  public String quantity;
  public String employeeId;
  public String employeeIdr;
  public String shift;
  public String shiftr;
  public String datefrom;
  public String specification;
  public String isactive;
  public String plannedAverageduration;
  public String plannedDurationunit;
  public String plannedDurationunitr;
  public String costuom;
  public String plannedQuantity;
  public String zssmWorkstepactivitiesVId;
  public String zssmSectionId;
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
    else if (fieldName.equalsIgnoreCase("zspm_ptaskhrplan_id") || fieldName.equals("zspmPtaskhrplanId"))
      return zspmPtaskhrplanId;
    else if (fieldName.equalsIgnoreCase("zssm_workstep_v_id") || fieldName.equals("zssmWorkstepVId"))
      return zssmWorkstepVId;
    else if (fieldName.equalsIgnoreCase("zssm_workstep_v_idr") || fieldName.equals("zssmWorkstepVIdr"))
      return zssmWorkstepVIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("c_salary_category_id") || fieldName.equals("cSalaryCategoryId"))
      return cSalaryCategoryId;
    else if (fieldName.equalsIgnoreCase("c_salary_category_idr") || fieldName.equals("cSalaryCategoryIdr"))
      return cSalaryCategoryIdr;
    else if (fieldName.equalsIgnoreCase("averageduration"))
      return averageduration;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("durationunit"))
      return durationunit;
    else if (fieldName.equalsIgnoreCase("durationunitr"))
      return durationunitr;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("employee_id") || fieldName.equals("employeeId"))
      return employeeId;
    else if (fieldName.equalsIgnoreCase("employee_idr") || fieldName.equals("employeeIdr"))
      return employeeIdr;
    else if (fieldName.equalsIgnoreCase("shift"))
      return shift;
    else if (fieldName.equalsIgnoreCase("shiftr"))
      return shiftr;
    else if (fieldName.equalsIgnoreCase("datefrom"))
      return datefrom;
    else if (fieldName.equalsIgnoreCase("specification"))
      return specification;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("planned_averageduration") || fieldName.equals("plannedAverageduration"))
      return plannedAverageduration;
    else if (fieldName.equalsIgnoreCase("planned_durationunit") || fieldName.equals("plannedDurationunit"))
      return plannedDurationunit;
    else if (fieldName.equalsIgnoreCase("planned_durationunitr") || fieldName.equals("plannedDurationunitr"))
      return plannedDurationunitr;
    else if (fieldName.equalsIgnoreCase("costuom"))
      return costuom;
    else if (fieldName.equalsIgnoreCase("planned_quantity") || fieldName.equals("plannedQuantity"))
      return plannedQuantity;
    else if (fieldName.equalsIgnoreCase("zssm_workstepactivities_v_id") || fieldName.equals("zssmWorkstepactivitiesVId"))
      return zssmWorkstepactivitiesVId;
    else if (fieldName.equalsIgnoreCase("zssm_section_id") || fieldName.equals("zssmSectionId"))
      return zssmSectionId;
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
  public static Activities6F92F616B40C49FD9F2E8DE87216DD55Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmWorkstepVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zssmWorkstepVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Activities6F92F616B40C49FD9F2E8DE87216DD55Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmWorkstepVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssm_workstepactivities_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_workstepactivities_v.CreatedBy) as CreatedByR, " +
      "        to_char(zssm_workstepactivities_v.Updated, ?) as updated, " +
      "        to_char(zssm_workstepactivities_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssm_workstepactivities_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_workstepactivities_v.UpdatedBy) as UpdatedByR," +
      "        zssm_workstepactivities_v.Zspm_PTaskHRPlan_ID, " +
      "zssm_workstepactivities_v.zssm_workstep_v_id, " +
      "(CASE WHEN zssm_workstepactivities_v.zssm_workstep_v_id IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Zssm_Prj_Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.SeqNo), ''))),'') ) END) AS zssm_workstep_v_idR, " +
      "zssm_workstepactivities_v.AD_Client_ID, " +
      "zssm_workstepactivities_v.C_Salary_Category_ID, " +
      "(CASE WHEN zssm_workstepactivities_v.C_Salary_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Salary_Category_IDR, " +
      "zssm_workstepactivities_v.AverageDuration, " +
      "zssm_workstepactivities_v.AD_Org_ID, " +
      "zssm_workstepactivities_v.DurationUnit, " +
      "(CASE WHEN zssm_workstepactivities_v.DurationUnit IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DurationUnitR, " +
      "zssm_workstepactivities_v.Quantity, " +
      "zssm_workstepactivities_v.Employee_ID, " +
      "(CASE WHEN zssm_workstepactivities_v.Employee_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS Employee_IDR, " +
      "zssm_workstepactivities_v.Shift, " +
      "(CASE WHEN zssm_workstepactivities_v.Shift IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS ShiftR, " +
      "zssm_workstepactivities_v.Datefrom, " +
      "zssm_workstepactivities_v.Specification, " +
      "COALESCE(zssm_workstepactivities_v.IsActive, 'N') AS IsActive, " +
      "zssm_workstepactivities_v.Planned_Averageduration, " +
      "zssm_workstepactivities_v.Planned_Durationunit, " +
      "(CASE WHEN zssm_workstepactivities_v.Planned_Durationunit IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS Planned_DurationunitR, " +
      "zssm_workstepactivities_v.Costuom, " +
      "zssm_workstepactivities_v.Planned_Quantity, " +
      "zssm_workstepactivities_v.Zssm_WorkstepActivities_V_ID, " +
      "zssm_workstepactivities_v.zssm_section_id, " +
      "        ? AS LANGUAGE " +
      "        FROM zssm_workstepactivities_v left join (select zssm_workstep_v_id, Value, Name, Zssm_Prj_Name, SeqNo from zssm_workstep_v) table1 on (zssm_workstepactivities_v.zssm_workstep_v_id = table1.zssm_workstep_v_id) left join (select C_Salary_Category_ID, Name from C_Salary_Category) table2 on (zssm_workstepactivities_v.C_Salary_Category_ID = table2.C_Salary_Category_ID) left join ad_ref_list_v list1 on (zssm_workstepactivities_v.DurationUnit = list1.value and list1.ad_reference_id = 'E05D7AF076184420BE4F7A0CF8CCF806' and list1.ad_language = ?)  left join (select AD_User_ID, Name from AD_User) table3 on (zssm_workstepactivities_v.Employee_ID =  table3.AD_User_ID) left join ad_ref_list_v list2 on (zssm_workstepactivities_v.Shift = list2.value and list2.ad_reference_id = '6F17D18E0C374F479087E9F1AF405655' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (zssm_workstepactivities_v.Planned_Durationunit = list3.value and list3.ad_reference_id = 'E05D7AF076184420BE4F7A0CF8CCF806' and list3.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zssmWorkstepVId==null || zssmWorkstepVId.equals(""))?"":"  AND zssm_workstepactivities_v.zssm_workstep_v_id = ?  ");
    strSql = strSql + 
      "        AND zssm_workstepactivities_v.Zssm_WorkstepActivities_V_ID = ? " +
      "        AND zssm_workstepactivities_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssm_workstepactivities_v.AD_Org_ID IN (";
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
        Activities6F92F616B40C49FD9F2E8DE87216DD55Data objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data = new Activities6F92F616B40C49FD9F2E8DE87216DD55Data();
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.created = UtilSql.getValue(result, "created");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.updated = UtilSql.getValue(result, "updated");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.zspmPtaskhrplanId = UtilSql.getValue(result, "zspm_ptaskhrplan_id");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.zssmWorkstepVId = UtilSql.getValue(result, "zssm_workstep_v_id");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.zssmWorkstepVIdr = UtilSql.getValue(result, "zssm_workstep_v_idr");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.cSalaryCategoryIdr = UtilSql.getValue(result, "c_salary_category_idr");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.averageduration = UtilSql.getValue(result, "averageduration");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.durationunit = UtilSql.getValue(result, "durationunit");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.durationunitr = UtilSql.getValue(result, "durationunitr");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.quantity = UtilSql.getValue(result, "quantity");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.employeeId = UtilSql.getValue(result, "employee_id");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.employeeIdr = UtilSql.getValue(result, "employee_idr");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.shift = UtilSql.getValue(result, "shift");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.shiftr = UtilSql.getValue(result, "shiftr");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.specification = UtilSql.getValue(result, "specification");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.isactive = UtilSql.getValue(result, "isactive");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.plannedAverageduration = UtilSql.getValue(result, "planned_averageduration");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.plannedDurationunit = UtilSql.getValue(result, "planned_durationunit");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.plannedDurationunitr = UtilSql.getValue(result, "planned_durationunitr");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.costuom = UtilSql.getValue(result, "costuom");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.plannedQuantity = UtilSql.getValue(result, "planned_quantity");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.zssmWorkstepactivitiesVId = UtilSql.getValue(result, "zssm_workstepactivities_v_id");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.zssmSectionId = UtilSql.getValue(result, "zssm_section_id");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.language = UtilSql.getValue(result, "language");
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.adUserClient = "";
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.adOrgClient = "";
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.createdby = "";
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.trBgcolor = "";
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.totalCount = "";
        objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data);
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
    Activities6F92F616B40C49FD9F2E8DE87216DD55Data objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[] = new Activities6F92F616B40C49FD9F2E8DE87216DD55Data[vector.size()];
    vector.copyInto(objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data);
    return(objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data);
  }

/**
Create a registry
 */
  public static Activities6F92F616B40C49FD9F2E8DE87216DD55Data[] set(String zssmWorkstepVId, String isactive, String updatedby, String updatedbyr, String zssmWorkstepactivitiesVId, String plannedAverageduration, String shift, String zssmSectionId, String plannedQuantity, String plannedDurationunit, String adOrgId, String durationunit, String zspmPtaskhrplanId, String costuom, String createdby, String createdbyr, String employeeId, String quantity, String datefrom, String adClientId, String averageduration, String specification, String cSalaryCategoryId)    throws ServletException {
    Activities6F92F616B40C49FD9F2E8DE87216DD55Data objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[] = new Activities6F92F616B40C49FD9F2E8DE87216DD55Data[1];
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0] = new Activities6F92F616B40C49FD9F2E8DE87216DD55Data();
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].created = "";
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].createdbyr = createdbyr;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].updated = "";
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].updatedTimeStamp = "";
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].updatedby = updatedby;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].updatedbyr = updatedbyr;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].zspmPtaskhrplanId = zspmPtaskhrplanId;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].zssmWorkstepVId = zssmWorkstepVId;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].zssmWorkstepVIdr = "";
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].adClientId = adClientId;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].cSalaryCategoryId = cSalaryCategoryId;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].cSalaryCategoryIdr = "";
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].averageduration = averageduration;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].adOrgId = adOrgId;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].durationunit = durationunit;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].durationunitr = "";
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].quantity = quantity;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].employeeId = employeeId;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].employeeIdr = "";
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].shift = shift;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].shiftr = "";
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].datefrom = datefrom;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].specification = specification;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].isactive = isactive;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].plannedAverageduration = plannedAverageduration;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].plannedDurationunit = plannedDurationunit;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].plannedDurationunitr = "";
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].costuom = costuom;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].plannedQuantity = plannedQuantity;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].zssmWorkstepactivitiesVId = zssmWorkstepactivitiesVId;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].zssmSectionId = zssmSectionId;
    objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data[0].language = "";
    return objectActivities6F92F616B40C49FD9F2E8DE87216DD55Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefC6C292E1AEAE4A559C10CBDBF8022602_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef51C91E3724AD42D5982C8CB4C92ABFBF_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT zssm_workstepactivities_v.zssm_workstep_v_id AS NAME" +
      "        FROM zssm_workstepactivities_v" +
      "        WHERE zssm_workstepactivities_v.Zssm_WorkstepActivities_V_ID = ?";

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
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Zssm_Prj_Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.SeqNo), ''))) AS NAME FROM zssm_workstep_v left join (select zssm_workstep_v_id, Value, Name, Zssm_Prj_Name, SeqNo from zssm_workstep_v) table1 on (zssm_workstep_v.zssm_workstep_v_id = table1.zssm_workstep_v_id) WHERE zssm_workstep_v.zssm_workstep_v_id = ?  ";

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
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Zssm_Prj_Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.SeqNo), ''))) AS NAME FROM zssm_workstep_v left join (select zssm_workstep_v_id, Value, Name, Zssm_Prj_Name, SeqNo from zssm_workstep_v) table1 on (zssm_workstep_v.zssm_workstep_v_id = table1.zssm_workstep_v_id) WHERE zssm_workstep_v.zssm_workstep_v_id = ?  ";

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
      "        UPDATE zssm_workstepactivities_v" +
      "        SET Zspm_PTaskHRPlan_ID = (?) , zssm_workstep_v_id = (?) , AD_Client_ID = (?) , C_Salary_Category_ID = (?) , AverageDuration = TO_NUMBER(?) , AD_Org_ID = (?) , DurationUnit = (?) , Quantity = TO_NUMBER(?) , Employee_ID = (?) , Shift = (?) , Datefrom = TO_DATE(?) , Specification = TO_NUMBER(?) , IsActive = (?) , Planned_Averageduration = TO_NUMBER(?) , Planned_Durationunit = (?) , Costuom = (?) , Planned_Quantity = TO_NUMBER(?) , Zssm_WorkstepActivities_V_ID = (?) , zssm_section_id = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssm_workstepactivities_v.Zssm_WorkstepActivities_V_ID = ? " +
      "                 AND zssm_workstepactivities_v.zssm_workstep_v_id = ? " +
      "        AND zssm_workstepactivities_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_workstepactivities_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskhrplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, averageduration);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, durationunit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, employeeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shift);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, specification);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedAverageduration);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedDurationunit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedQuantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepactivitiesVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmSectionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepactivitiesVId);
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
      "        INSERT INTO zssm_workstepactivities_v " +
      "        (Zspm_PTaskHRPlan_ID, zssm_workstep_v_id, AD_Client_ID, C_Salary_Category_ID, AverageDuration, AD_Org_ID, DurationUnit, Quantity, Employee_ID, Shift, Datefrom, Specification, IsActive, Planned_Averageduration, Planned_Durationunit, Costuom, Planned_Quantity, Zssm_WorkstepActivities_V_ID, zssm_section_id, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), (?), TO_DATE(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskhrplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, averageduration);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, durationunit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, employeeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shift);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, specification);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedAverageduration);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedDurationunit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedQuantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepactivitiesVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmSectionId);
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
      "        DELETE FROM zssm_workstepactivities_v" +
      "        WHERE zssm_workstepactivities_v.Zssm_WorkstepActivities_V_ID = ? " +
      "                 AND zssm_workstepactivities_v.zssm_workstep_v_id = ? " +
      "        AND zssm_workstepactivities_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_workstepactivities_v.AD_Org_ID IN (";
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
      "        DELETE FROM zssm_workstepactivities_v" +
      "        WHERE zssm_workstepactivities_v.Zssm_WorkstepActivities_V_ID = ? " +
      "                 AND zssm_workstepactivities_v.zssm_workstep_v_id = ? ";

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
      "          FROM zssm_workstepactivities_v" +
      "         WHERE zssm_workstepactivities_v.Zssm_WorkstepActivities_V_ID = ? ";

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
      "          FROM zssm_workstepactivities_v" +
      "         WHERE zssm_workstepactivities_v.Zssm_WorkstepActivities_V_ID = ? ";

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
