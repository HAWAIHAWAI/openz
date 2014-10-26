//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.WorkSteps;

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
class Activities714AC0CA3AB0466A953B779E536E5A20Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Activities714AC0CA3AB0466A953B779E536E5A20Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssmWorkstepPrpVId;
  public String zssmWorkstepPrpVIdr;
  public String isactive;
  public String cSalaryCategoryId;
  public String cSalaryCategoryIdr;
  public String averageduration;
  public String durationunit;
  public String durationunitr;
  public String zssmSectionId;
  public String zssmWorkstepactivitiesVId;
  public String adClientId;
  public String plannedDurationunit;
  public String costuom;
  public String plannedAverageduration;
  public String plannedQuantity;
  public String adOrgId;
  public String quantity;
  public String zspmPtaskhrplanId;
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
    else if (fieldName.equalsIgnoreCase("zssm_workstep_prp_v_id") || fieldName.equals("zssmWorkstepPrpVId"))
      return zssmWorkstepPrpVId;
    else if (fieldName.equalsIgnoreCase("zssm_workstep_prp_v_idr") || fieldName.equals("zssmWorkstepPrpVIdr"))
      return zssmWorkstepPrpVIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_salary_category_id") || fieldName.equals("cSalaryCategoryId"))
      return cSalaryCategoryId;
    else if (fieldName.equalsIgnoreCase("c_salary_category_idr") || fieldName.equals("cSalaryCategoryIdr"))
      return cSalaryCategoryIdr;
    else if (fieldName.equalsIgnoreCase("averageduration"))
      return averageduration;
    else if (fieldName.equalsIgnoreCase("durationunit"))
      return durationunit;
    else if (fieldName.equalsIgnoreCase("durationunitr"))
      return durationunitr;
    else if (fieldName.equalsIgnoreCase("zssm_section_id") || fieldName.equals("zssmSectionId"))
      return zssmSectionId;
    else if (fieldName.equalsIgnoreCase("zssm_workstepactivities_v_id") || fieldName.equals("zssmWorkstepactivitiesVId"))
      return zssmWorkstepactivitiesVId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("planned_durationunit") || fieldName.equals("plannedDurationunit"))
      return plannedDurationunit;
    else if (fieldName.equalsIgnoreCase("costuom"))
      return costuom;
    else if (fieldName.equalsIgnoreCase("planned_averageduration") || fieldName.equals("plannedAverageduration"))
      return plannedAverageduration;
    else if (fieldName.equalsIgnoreCase("planned_quantity") || fieldName.equals("plannedQuantity"))
      return plannedQuantity;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("zspm_ptaskhrplan_id") || fieldName.equals("zspmPtaskhrplanId"))
      return zspmPtaskhrplanId;
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
  public static Activities714AC0CA3AB0466A953B779E536E5A20Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmWorkstepPrpVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zssmWorkstepPrpVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Activities714AC0CA3AB0466A953B779E536E5A20Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmWorkstepPrpVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssm_workstepactivities_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_workstepactivities_v.CreatedBy) as CreatedByR, " +
      "        to_char(zssm_workstepactivities_v.Updated, ?) as updated, " +
      "        to_char(zssm_workstepactivities_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssm_workstepactivities_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_workstepactivities_v.UpdatedBy) as UpdatedByR," +
      "        zssm_workstepactivities_v.Zssm_Workstep_Prp_V_ID, " +
      "(CASE WHEN zssm_workstepactivities_v.Zssm_Workstep_Prp_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.IsActive), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS Zssm_Workstep_Prp_V_IDR, " +
      "COALESCE(zssm_workstepactivities_v.IsActive, 'N') AS IsActive, " +
      "zssm_workstepactivities_v.C_Salary_Category_ID, " +
      "(CASE WHEN zssm_workstepactivities_v.C_Salary_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Salary_Category_IDR, " +
      "zssm_workstepactivities_v.AverageDuration, " +
      "zssm_workstepactivities_v.DurationUnit, " +
      "(CASE WHEN zssm_workstepactivities_v.DurationUnit IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DurationUnitR, " +
      "zssm_workstepactivities_v.zssm_section_id, " +
      "zssm_workstepactivities_v.Zssm_WorkstepActivities_V_ID, " +
      "zssm_workstepactivities_v.AD_Client_ID, " +
      "zssm_workstepactivities_v.Planned_Durationunit, " +
      "zssm_workstepactivities_v.Costuom, " +
      "zssm_workstepactivities_v.Planned_Averageduration, " +
      "zssm_workstepactivities_v.Planned_Quantity, " +
      "zssm_workstepactivities_v.AD_Org_ID, " +
      "zssm_workstepactivities_v.Quantity, " +
      "zssm_workstepactivities_v.Zspm_PTaskHRPlan_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM zssm_workstepactivities_v left join (select Zssm_Workstep_Prp_V_ID, IsActive, Name, M_Product_ID from Zssm_Workstep_Prp_V) table1 on (zssm_workstepactivities_v.Zssm_Workstep_Prp_V_ID = table1.Zssm_Workstep_Prp_V_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  left join (select C_Salary_Category_ID, Name from C_Salary_Category) table3 on (zssm_workstepactivities_v.C_Salary_Category_ID = table3.C_Salary_Category_ID) left join ad_ref_list_v list1 on (zssm_workstepactivities_v.DurationUnit = list1.value and list1.ad_reference_id = 'E05D7AF076184420BE4F7A0CF8CCF806' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zssmWorkstepPrpVId==null || zssmWorkstepPrpVId.equals(""))?"":"  AND zssm_workstepactivities_v.Zssm_Workstep_Prp_V_ID = ?  ");
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
      if (zssmWorkstepPrpVId != null && !(zssmWorkstepPrpVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);
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
        Activities714AC0CA3AB0466A953B779E536E5A20Data objectActivities714AC0CA3AB0466A953B779E536E5A20Data = new Activities714AC0CA3AB0466A953B779E536E5A20Data();
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.created = UtilSql.getValue(result, "created");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.updated = UtilSql.getValue(result, "updated");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.zssmWorkstepPrpVId = UtilSql.getValue(result, "zssm_workstep_prp_v_id");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.zssmWorkstepPrpVIdr = UtilSql.getValue(result, "zssm_workstep_prp_v_idr");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.isactive = UtilSql.getValue(result, "isactive");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.cSalaryCategoryIdr = UtilSql.getValue(result, "c_salary_category_idr");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.averageduration = UtilSql.getValue(result, "averageduration");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.durationunit = UtilSql.getValue(result, "durationunit");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.durationunitr = UtilSql.getValue(result, "durationunitr");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.zssmSectionId = UtilSql.getValue(result, "zssm_section_id");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.zssmWorkstepactivitiesVId = UtilSql.getValue(result, "zssm_workstepactivities_v_id");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.plannedDurationunit = UtilSql.getValue(result, "planned_durationunit");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.costuom = UtilSql.getValue(result, "costuom");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.plannedAverageduration = UtilSql.getValue(result, "planned_averageduration");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.plannedQuantity = UtilSql.getValue(result, "planned_quantity");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.quantity = UtilSql.getValue(result, "quantity");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.zspmPtaskhrplanId = UtilSql.getValue(result, "zspm_ptaskhrplan_id");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.language = UtilSql.getValue(result, "language");
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.adUserClient = "";
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.adOrgClient = "";
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.createdby = "";
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.trBgcolor = "";
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.totalCount = "";
        objectActivities714AC0CA3AB0466A953B779E536E5A20Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectActivities714AC0CA3AB0466A953B779E536E5A20Data);
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
    Activities714AC0CA3AB0466A953B779E536E5A20Data objectActivities714AC0CA3AB0466A953B779E536E5A20Data[] = new Activities714AC0CA3AB0466A953B779E536E5A20Data[vector.size()];
    vector.copyInto(objectActivities714AC0CA3AB0466A953B779E536E5A20Data);
    return(objectActivities714AC0CA3AB0466A953B779E536E5A20Data);
  }

/**
Create a registry
 */
  public static Activities714AC0CA3AB0466A953B779E536E5A20Data[] set(String zssmWorkstepPrpVId, String isactive, String updatedby, String updatedbyr, String cSalaryCategoryId, String zssmWorkstepactivitiesVId, String zssmSectionId, String plannedAverageduration, String quantity, String adOrgId, String zspmPtaskhrplanId, String durationunit, String costuom, String plannedQuantity, String createdby, String createdbyr, String plannedDurationunit, String averageduration, String adClientId)    throws ServletException {
    Activities714AC0CA3AB0466A953B779E536E5A20Data objectActivities714AC0CA3AB0466A953B779E536E5A20Data[] = new Activities714AC0CA3AB0466A953B779E536E5A20Data[1];
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0] = new Activities714AC0CA3AB0466A953B779E536E5A20Data();
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].created = "";
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].createdbyr = createdbyr;
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].updated = "";
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].updatedTimeStamp = "";
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].updatedby = updatedby;
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].updatedbyr = updatedbyr;
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].zssmWorkstepPrpVId = zssmWorkstepPrpVId;
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].zssmWorkstepPrpVIdr = "";
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].isactive = isactive;
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].cSalaryCategoryId = cSalaryCategoryId;
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].cSalaryCategoryIdr = "";
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].averageduration = averageduration;
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].durationunit = durationunit;
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].durationunitr = "";
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].zssmSectionId = zssmSectionId;
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].zssmWorkstepactivitiesVId = zssmWorkstepactivitiesVId;
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].adClientId = adClientId;
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].plannedDurationunit = plannedDurationunit;
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].costuom = costuom;
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].plannedAverageduration = plannedAverageduration;
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].plannedQuantity = plannedQuantity;
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].adOrgId = adOrgId;
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].quantity = quantity;
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].zspmPtaskhrplanId = zspmPtaskhrplanId;
    objectActivities714AC0CA3AB0466A953B779E536E5A20Data[0].language = "";
    return objectActivities714AC0CA3AB0466A953B779E536E5A20Data;
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
      "        SELECT zssm_workstepactivities_v.Zssm_Workstep_Prp_V_ID AS NAME" +
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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String zssmWorkstepPrpVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.IsActive), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))) AS NAME FROM zssm_workstep_prp_v left join (select Zssm_Workstep_Prp_V_ID, IsActive, Name, M_Product_ID from Zssm_Workstep_Prp_V) table1 on (zssm_workstep_prp_v.Zssm_Workstep_Prp_V_ID = table1.Zssm_Workstep_Prp_V_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  WHERE zssm_workstep_prp_v.Zssm_Workstep_Prp_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String zssmWorkstepPrpVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.IsActive), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))) AS NAME FROM zssm_workstep_prp_v left join (select Zssm_Workstep_Prp_V_ID, IsActive, Name, M_Product_ID from Zssm_Workstep_Prp_V) table1 on (zssm_workstep_prp_v.Zssm_Workstep_Prp_V_ID = table1.Zssm_Workstep_Prp_V_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  WHERE zssm_workstep_prp_v.Zssm_Workstep_Prp_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);

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
      "        SET Zssm_Workstep_Prp_V_ID = (?) , IsActive = (?) , C_Salary_Category_ID = (?) , AverageDuration = TO_NUMBER(?) , DurationUnit = (?) , zssm_section_id = (?) , Zssm_WorkstepActivities_V_ID = (?) , AD_Client_ID = (?) , Planned_Durationunit = (?) , Costuom = (?) , Planned_Averageduration = TO_NUMBER(?) , Planned_Quantity = TO_NUMBER(?) , AD_Org_ID = (?) , Quantity = TO_NUMBER(?) , Zspm_PTaskHRPlan_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssm_workstepactivities_v.Zssm_WorkstepActivities_V_ID = ? " +
      "                 AND zssm_workstepactivities_v.Zssm_Workstep_Prp_V_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, averageduration);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, durationunit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmSectionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepactivitiesVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedDurationunit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedAverageduration);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedQuantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskhrplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepactivitiesVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);
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
      "        (Zssm_Workstep_Prp_V_ID, IsActive, C_Salary_Category_ID, AverageDuration, DurationUnit, zssm_section_id, Zssm_WorkstepActivities_V_ID, AD_Client_ID, Planned_Durationunit, Costuom, Planned_Averageduration, Planned_Quantity, AD_Org_ID, Quantity, Zspm_PTaskHRPlan_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, averageduration);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, durationunit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmSectionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepactivitiesVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedDurationunit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedAverageduration);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedQuantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskhrplanId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zssmWorkstepPrpVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_workstepactivities_v" +
      "        WHERE zssm_workstepactivities_v.Zssm_WorkstepActivities_V_ID = ? " +
      "                 AND zssm_workstepactivities_v.Zssm_Workstep_Prp_V_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zssmWorkstepPrpVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_workstepactivities_v" +
      "        WHERE zssm_workstepactivities_v.Zssm_WorkstepActivities_V_ID = ? " +
      "                 AND zssm_workstepactivities_v.Zssm_Workstep_Prp_V_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);

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
