//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.ProductionPlan;

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
class SequencePlan9A80ADE423C244619A871098853BF405Data implements FieldProvider {
static Logger log4j = Logger.getLogger(SequencePlan9A80ADE423C244619A871098853BF405Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String zssmProductionplanVId;
  public String zssmProductionplanVIdr;
  public String isactive;
  public String sortno;
  public String dependsontask;
  public String dependsontaskr;
  public String zssmProductionplanTaskId;
  public String zssmProductionplanTaskIdr;
  public String description;
  public String stockrotation;
  public String dependentstatuscheck;
  public String adClientId;
  public String zssmProductionplanTaskdepId;
  public String zssmProductionplanTaskdepVId;
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
    else if (fieldName.equalsIgnoreCase("zssm_productionplan_v_id") || fieldName.equals("zssmProductionplanVId"))
      return zssmProductionplanVId;
    else if (fieldName.equalsIgnoreCase("zssm_productionplan_v_idr") || fieldName.equals("zssmProductionplanVIdr"))
      return zssmProductionplanVIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("sortno"))
      return sortno;
    else if (fieldName.equalsIgnoreCase("dependsontask"))
      return dependsontask;
    else if (fieldName.equalsIgnoreCase("dependsontaskr"))
      return dependsontaskr;
    else if (fieldName.equalsIgnoreCase("zssm_productionplan_task_id") || fieldName.equals("zssmProductionplanTaskId"))
      return zssmProductionplanTaskId;
    else if (fieldName.equalsIgnoreCase("zssm_productionplan_task_idr") || fieldName.equals("zssmProductionplanTaskIdr"))
      return zssmProductionplanTaskIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("stockrotation"))
      return stockrotation;
    else if (fieldName.equalsIgnoreCase("dependentstatuscheck"))
      return dependentstatuscheck;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("zssm_productionplan_taskdep_id") || fieldName.equals("zssmProductionplanTaskdepId"))
      return zssmProductionplanTaskdepId;
    else if (fieldName.equalsIgnoreCase("zssm_productionplan_taskdep_v_id") || fieldName.equals("zssmProductionplanTaskdepVId"))
      return zssmProductionplanTaskdepVId;
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
  public static SequencePlan9A80ADE423C244619A871098853BF405Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmProductionplanVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zssmProductionplanVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static SequencePlan9A80ADE423C244619A871098853BF405Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmProductionplanVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssm_productionplan_taskdep_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_productionplan_taskdep_v.CreatedBy) as CreatedByR, " +
      "        to_char(zssm_productionplan_taskdep_v.Updated, ?) as updated, " +
      "        to_char(zssm_productionplan_taskdep_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssm_productionplan_taskdep_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_productionplan_taskdep_v.UpdatedBy) as UpdatedByR," +
      "        zssm_productionplan_taskdep_v.AD_Org_ID, " +
      "(CASE WHEN zssm_productionplan_taskdep_v.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zssm_productionplan_taskdep_v.Zssm_Productionplan_V_ID, " +
      "(CASE WHEN zssm_productionplan_taskdep_v.Zssm_Productionplan_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS Zssm_Productionplan_V_IDR, " +
      "COALESCE(zssm_productionplan_taskdep_v.Isactive, 'N') AS Isactive, " +
      "zssm_productionplan_taskdep_v.SortNo, " +
      "zssm_productionplan_taskdep_v.DependsOnTask, " +
      "(CASE WHEN zssm_productionplan_taskdep_v.DependsOnTask IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS DependsOnTaskR, " +
      "zssm_productionplan_taskdep_v.Zssm_Productionplan_Task_ID, " +
      "(CASE WHEN zssm_productionplan_taskdep_v.Zssm_Productionplan_Task_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS Zssm_Productionplan_Task_IDR, " +
      "zssm_productionplan_taskdep_v.Description, " +
      "COALESCE(zssm_productionplan_taskdep_v.StockRotation, 'N') AS StockRotation, " +
      "COALESCE(zssm_productionplan_taskdep_v.DependentStatusCheck, 'N') AS DependentStatusCheck, " +
      "zssm_productionplan_taskdep_v.AD_Client_ID, " +
      "zssm_productionplan_taskdep_v.Zssm_Productionplan_Taskdep_ID, " +
      "zssm_productionplan_taskdep_v.Zssm_Productionplan_Taskdep_V_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM zssm_productionplan_taskdep_v left join (select AD_Org_ID, Name from AD_Org) table1 on (zssm_productionplan_taskdep_v.AD_Org_ID = table1.AD_Org_ID) left join (select Zssm_Productionplan_V_ID, Value, Name from Zssm_Productionplan_V) table2 on (zssm_productionplan_taskdep_v.Zssm_Productionplan_V_ID = table2.Zssm_Productionplan_V_ID) left join (select Zssm_Productionplan_Task_V_ID, Name from zssm_productionplan_task_v) table3 on (zssm_productionplan_taskdep_v.DependsOnTask =  table3.Zssm_Productionplan_Task_V_ID) left join (select Zssm_Productionplan_Task_V_ID, Name from zssm_productionplan_task_v) table4 on (zssm_productionplan_taskdep_v.Zssm_Productionplan_Task_ID =  table4.Zssm_Productionplan_Task_V_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zssmProductionplanVId==null || zssmProductionplanVId.equals(""))?"":"  AND zssm_productionplan_taskdep_v.Zssm_Productionplan_V_ID = ?  ");
    strSql = strSql + 
      "        AND zssm_productionplan_taskdep_v.Zssm_Productionplan_Taskdep_V_ID = ? " +
      "        AND zssm_productionplan_taskdep_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssm_productionplan_taskdep_v.AD_Org_ID IN (";
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
      if (zssmProductionplanVId != null && !(zssmProductionplanVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);
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
        SequencePlan9A80ADE423C244619A871098853BF405Data objectSequencePlan9A80ADE423C244619A871098853BF405Data = new SequencePlan9A80ADE423C244619A871098853BF405Data();
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.created = UtilSql.getValue(result, "created");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.updated = UtilSql.getValue(result, "updated");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.zssmProductionplanVId = UtilSql.getValue(result, "zssm_productionplan_v_id");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.zssmProductionplanVIdr = UtilSql.getValue(result, "zssm_productionplan_v_idr");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.isactive = UtilSql.getValue(result, "isactive");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.sortno = UtilSql.getValue(result, "sortno");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.dependsontask = UtilSql.getValue(result, "dependsontask");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.dependsontaskr = UtilSql.getValue(result, "dependsontaskr");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.zssmProductionplanTaskId = UtilSql.getValue(result, "zssm_productionplan_task_id");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.zssmProductionplanTaskIdr = UtilSql.getValue(result, "zssm_productionplan_task_idr");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.description = UtilSql.getValue(result, "description");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.stockrotation = UtilSql.getValue(result, "stockrotation");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.dependentstatuscheck = UtilSql.getValue(result, "dependentstatuscheck");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.zssmProductionplanTaskdepId = UtilSql.getValue(result, "zssm_productionplan_taskdep_id");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.zssmProductionplanTaskdepVId = UtilSql.getValue(result, "zssm_productionplan_taskdep_v_id");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.language = UtilSql.getValue(result, "language");
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.adUserClient = "";
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.adOrgClient = "";
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.createdby = "";
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.trBgcolor = "";
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.totalCount = "";
        objectSequencePlan9A80ADE423C244619A871098853BF405Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSequencePlan9A80ADE423C244619A871098853BF405Data);
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
    SequencePlan9A80ADE423C244619A871098853BF405Data objectSequencePlan9A80ADE423C244619A871098853BF405Data[] = new SequencePlan9A80ADE423C244619A871098853BF405Data[vector.size()];
    vector.copyInto(objectSequencePlan9A80ADE423C244619A871098853BF405Data);
    return(objectSequencePlan9A80ADE423C244619A871098853BF405Data);
  }

/**
Create a registry
 */
  public static SequencePlan9A80ADE423C244619A871098853BF405Data[] set(String zssmProductionplanVId, String sortno, String dependsontask, String adClientId, String zssmProductionplanTaskdepVId, String description, String createdby, String createdbyr, String isactive, String updatedby, String updatedbyr, String zssmProductionplanTaskId, String adOrgId, String zssmProductionplanTaskdepId, String stockrotation, String dependentstatuscheck)    throws ServletException {
    SequencePlan9A80ADE423C244619A871098853BF405Data objectSequencePlan9A80ADE423C244619A871098853BF405Data[] = new SequencePlan9A80ADE423C244619A871098853BF405Data[1];
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0] = new SequencePlan9A80ADE423C244619A871098853BF405Data();
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].created = "";
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].createdbyr = createdbyr;
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].updated = "";
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].updatedTimeStamp = "";
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].updatedby = updatedby;
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].updatedbyr = updatedbyr;
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].adOrgId = adOrgId;
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].adOrgIdr = "";
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].zssmProductionplanVId = zssmProductionplanVId;
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].zssmProductionplanVIdr = "";
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].isactive = isactive;
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].sortno = sortno;
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].dependsontask = dependsontask;
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].dependsontaskr = "";
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].zssmProductionplanTaskId = zssmProductionplanTaskId;
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].zssmProductionplanTaskIdr = "";
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].description = description;
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].stockrotation = stockrotation;
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].dependentstatuscheck = dependentstatuscheck;
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].adClientId = adClientId;
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].zssmProductionplanTaskdepId = zssmProductionplanTaskdepId;
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].zssmProductionplanTaskdepVId = zssmProductionplanTaskdepVId;
    objectSequencePlan9A80ADE423C244619A871098853BF405Data[0].language = "";
    return objectSequencePlan9A80ADE423C244619A871098853BF405Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefF9145FCD0A1F40088F3006878AD6AF1B_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef4695D1D7CBCF42CA9FA9E9B79F01F3FB_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zssm_productionplan_taskdep_v.Zssm_Productionplan_V_ID AS NAME" +
      "        FROM zssm_productionplan_taskdep_v" +
      "        WHERE zssm_productionplan_taskdep_v.Zssm_Productionplan_Taskdep_V_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String zssmProductionplanVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM zssm_productionplan_v left join (select Zssm_Productionplan_V_ID, Value, Name from Zssm_Productionplan_V) table1 on (zssm_productionplan_v.Zssm_Productionplan_V_ID = table1.Zssm_Productionplan_V_ID) WHERE zssm_productionplan_v.Zssm_Productionplan_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String zssmProductionplanVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM zssm_productionplan_v left join (select Zssm_Productionplan_V_ID, Value, Name from Zssm_Productionplan_V) table1 on (zssm_productionplan_v.Zssm_Productionplan_V_ID = table1.Zssm_Productionplan_V_ID) WHERE zssm_productionplan_v.Zssm_Productionplan_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);

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
      "        UPDATE zssm_productionplan_taskdep_v" +
      "        SET AD_Org_ID = (?) , Zssm_Productionplan_V_ID = (?) , Isactive = (?) , SortNo = TO_NUMBER(?) , DependsOnTask = (?) , Zssm_Productionplan_Task_ID = (?) , Description = (?) , StockRotation = (?) , DependentStatusCheck = (?) , AD_Client_ID = (?) , Zssm_Productionplan_Taskdep_ID = (?) , Zssm_Productionplan_Taskdep_V_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssm_productionplan_taskdep_v.Zssm_Productionplan_Taskdep_V_ID = ? " +
      "                 AND zssm_productionplan_taskdep_v.Zssm_Productionplan_V_ID = ? " +
      "        AND zssm_productionplan_taskdep_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_productionplan_taskdep_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sortno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dependsontask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stockrotation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dependentstatuscheck);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanTaskdepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanTaskdepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanTaskdepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);
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
      "        INSERT INTO zssm_productionplan_taskdep_v " +
      "        (AD_Org_ID, Zssm_Productionplan_V_ID, Isactive, SortNo, DependsOnTask, Zssm_Productionplan_Task_ID, Description, StockRotation, DependentStatusCheck, AD_Client_ID, Zssm_Productionplan_Taskdep_ID, Zssm_Productionplan_Taskdep_V_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sortno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dependsontask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stockrotation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dependentstatuscheck);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanTaskdepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanTaskdepVId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zssmProductionplanVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_productionplan_taskdep_v" +
      "        WHERE zssm_productionplan_taskdep_v.Zssm_Productionplan_Taskdep_V_ID = ? " +
      "                 AND zssm_productionplan_taskdep_v.Zssm_Productionplan_V_ID = ? " +
      "        AND zssm_productionplan_taskdep_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_productionplan_taskdep_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zssmProductionplanVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_productionplan_taskdep_v" +
      "        WHERE zssm_productionplan_taskdep_v.Zssm_Productionplan_Taskdep_V_ID = ? " +
      "                 AND zssm_productionplan_taskdep_v.Zssm_Productionplan_V_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);

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
      "          FROM zssm_productionplan_taskdep_v" +
      "         WHERE zssm_productionplan_taskdep_v.Zssm_Productionplan_Taskdep_V_ID = ? ";

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
      "          FROM zssm_productionplan_taskdep_v" +
      "         WHERE zssm_productionplan_taskdep_v.Zssm_Productionplan_Taskdep_V_ID = ? ";

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
