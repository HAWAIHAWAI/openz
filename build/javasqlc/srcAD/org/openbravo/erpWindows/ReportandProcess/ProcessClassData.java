//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ReportandProcess;

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
class ProcessClassData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProcessClassData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adModuleId;
  public String adModuleIdr;
  public String adModelObjectId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String adProcessId;
  public String adProcessIdr;
  public String action;
  public String actionr;
  public String isdefault;
  public String classname;
  public String adTabId;
  public String adTaskId;
  public String adWorkflowId;
  public String adFormId;
  public String adReferenceId;
  public String adCalloutId;
  public String objectType;
  public String loadonstartup;
  public String seqno;
  public String name;
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
    else if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
    else if (fieldName.equalsIgnoreCase("ad_module_idr") || fieldName.equals("adModuleIdr"))
      return adModuleIdr;
    else if (fieldName.equalsIgnoreCase("ad_model_object_id") || fieldName.equals("adModelObjectId"))
      return adModelObjectId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
    else if (fieldName.equalsIgnoreCase("ad_process_idr") || fieldName.equals("adProcessIdr"))
      return adProcessIdr;
    else if (fieldName.equalsIgnoreCase("action"))
      return action;
    else if (fieldName.equalsIgnoreCase("actionr"))
      return actionr;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("classname"))
      return classname;
    else if (fieldName.equalsIgnoreCase("ad_tab_id") || fieldName.equals("adTabId"))
      return adTabId;
    else if (fieldName.equalsIgnoreCase("ad_task_id") || fieldName.equals("adTaskId"))
      return adTaskId;
    else if (fieldName.equalsIgnoreCase("ad_workflow_id") || fieldName.equals("adWorkflowId"))
      return adWorkflowId;
    else if (fieldName.equalsIgnoreCase("ad_form_id") || fieldName.equals("adFormId"))
      return adFormId;
    else if (fieldName.equalsIgnoreCase("ad_reference_id") || fieldName.equals("adReferenceId"))
      return adReferenceId;
    else if (fieldName.equalsIgnoreCase("ad_callout_id") || fieldName.equals("adCalloutId"))
      return adCalloutId;
    else if (fieldName.equalsIgnoreCase("object_type") || fieldName.equals("objectType"))
      return objectType;
    else if (fieldName.equalsIgnoreCase("loadonstartup"))
      return loadonstartup;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
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
  public static ProcessClassData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adProcessId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adProcessId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ProcessClassData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adProcessId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Model_Object.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Model_Object.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Model_Object.Updated, ?) as updated, " +
      "        to_char(AD_Model_Object.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Model_Object.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Model_Object.UpdatedBy) as UpdatedByR," +
      "        AD_Model_Object.AD_Module_ID, " +
      "(CASE WHEN AD_Model_Object.AD_Module_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Version), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Module_IDR, " +
      "AD_Model_Object.AD_Model_Object_ID, " +
      "AD_Model_Object.AD_Client_ID, " +
      "(CASE WHEN AD_Model_Object.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Model_Object.AD_Org_ID, " +
      "(CASE WHEN AD_Model_Object.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(AD_Model_Object.IsActive, 'N') AS IsActive, " +
      "AD_Model_Object.AD_Process_ID, " +
      "(CASE WHEN AD_Model_Object.AD_Process_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS AD_Process_IDR, " +
      "AD_Model_Object.Action, " +
      "(CASE WHEN AD_Model_Object.Action IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ActionR, " +
      "COALESCE(AD_Model_Object.IsDefault, 'N') AS IsDefault, " +
      "AD_Model_Object.Classname, " +
      "AD_Model_Object.AD_Tab_ID, " +
      "AD_Model_Object.AD_Task_ID, " +
      "AD_Model_Object.AD_Workflow_ID, " +
      "AD_Model_Object.AD_Form_ID, " +
      "AD_Model_Object.AD_Reference_ID, " +
      "AD_Model_Object.AD_Callout_ID, " +
      "AD_Model_Object.Object_Type, " +
      "AD_Model_Object.Loadonstartup, " +
      "AD_Model_Object.Seqno, " +
      "AD_Model_Object.Name, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Model_Object left join (select AD_Module_ID, Name, Version, AD_Language from AD_Module) table1 on (AD_Model_Object.AD_Module_ID = table1.AD_Module_ID) left join (select AD_Language, Name from AD_Language) table2 on (table1.AD_Language =  table2.AD_Language) left join (select AD_Client_ID, Name from AD_Client) table3 on (AD_Model_Object.AD_Client_ID = table3.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table4 on (AD_Model_Object.AD_Org_ID = table4.AD_Org_ID) left join (select AD_Process_ID, Name from AD_Process) table5 on (AD_Model_Object.AD_Process_ID = table5.AD_Process_ID) left join (select AD_Process_ID,AD_Language, Name from AD_Process_TRL) tableTRL5 on (table5.AD_Process_ID = tableTRL5.AD_Process_ID and tableTRL5.AD_Language = ?)  left join ad_ref_list_v list1 on (AD_Model_Object.Action = list1.value and list1.ad_reference_id = '104' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      " AND AD_Model_Object.Action IN ('P', 'R')" +
      "        AND 1=1 ";
    strSql = strSql + ((adProcessId==null || adProcessId.equals(""))?"":"  AND AD_Model_Object.AD_Process_ID = ?  ");
    strSql = strSql + 
      "        AND AD_Model_Object.AD_Model_Object_ID = ? " +
      "        AND AD_Model_Object.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Model_Object.AD_Org_ID IN (";
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
      if (adProcessId != null && !(adProcessId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
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
        ProcessClassData objectProcessClassData = new ProcessClassData();
        objectProcessClassData.created = UtilSql.getValue(result, "created");
        objectProcessClassData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectProcessClassData.updated = UtilSql.getValue(result, "updated");
        objectProcessClassData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectProcessClassData.updatedby = UtilSql.getValue(result, "updatedby");
        objectProcessClassData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectProcessClassData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectProcessClassData.adModuleIdr = UtilSql.getValue(result, "ad_module_idr");
        objectProcessClassData.adModelObjectId = UtilSql.getValue(result, "ad_model_object_id");
        objectProcessClassData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProcessClassData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectProcessClassData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProcessClassData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectProcessClassData.isactive = UtilSql.getValue(result, "isactive");
        objectProcessClassData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectProcessClassData.adProcessIdr = UtilSql.getValue(result, "ad_process_idr");
        objectProcessClassData.action = UtilSql.getValue(result, "action");
        objectProcessClassData.actionr = UtilSql.getValue(result, "actionr");
        objectProcessClassData.isdefault = UtilSql.getValue(result, "isdefault");
        objectProcessClassData.classname = UtilSql.getValue(result, "classname");
        objectProcessClassData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectProcessClassData.adTaskId = UtilSql.getValue(result, "ad_task_id");
        objectProcessClassData.adWorkflowId = UtilSql.getValue(result, "ad_workflow_id");
        objectProcessClassData.adFormId = UtilSql.getValue(result, "ad_form_id");
        objectProcessClassData.adReferenceId = UtilSql.getValue(result, "ad_reference_id");
        objectProcessClassData.adCalloutId = UtilSql.getValue(result, "ad_callout_id");
        objectProcessClassData.objectType = UtilSql.getValue(result, "object_type");
        objectProcessClassData.loadonstartup = UtilSql.getValue(result, "loadonstartup");
        objectProcessClassData.seqno = UtilSql.getValue(result, "seqno");
        objectProcessClassData.name = UtilSql.getValue(result, "name");
        objectProcessClassData.language = UtilSql.getValue(result, "language");
        objectProcessClassData.adUserClient = "";
        objectProcessClassData.adOrgClient = "";
        objectProcessClassData.createdby = "";
        objectProcessClassData.trBgcolor = "";
        objectProcessClassData.totalCount = "";
        objectProcessClassData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProcessClassData);
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
    ProcessClassData objectProcessClassData[] = new ProcessClassData[vector.size()];
    vector.copyInto(objectProcessClassData);
    return(objectProcessClassData);
  }

/**
Create a registry
 */
  public static ProcessClassData[] set(String adProcessId, String adTaskId, String adTabId, String adWorkflowId, String adFormId, String adReferenceId, String action, String isactive, String isdefault, String adCalloutId, String adModuleId, String classname, String adModelObjectId, String adOrgId, String adClientId, String updatedby, String updatedbyr, String objectType, String loadonstartup, String createdby, String createdbyr, String name, String seqno)    throws ServletException {
    ProcessClassData objectProcessClassData[] = new ProcessClassData[1];
    objectProcessClassData[0] = new ProcessClassData();
    objectProcessClassData[0].created = "";
    objectProcessClassData[0].createdbyr = createdbyr;
    objectProcessClassData[0].updated = "";
    objectProcessClassData[0].updatedTimeStamp = "";
    objectProcessClassData[0].updatedby = updatedby;
    objectProcessClassData[0].updatedbyr = updatedbyr;
    objectProcessClassData[0].adModuleId = adModuleId;
    objectProcessClassData[0].adModuleIdr = "";
    objectProcessClassData[0].adModelObjectId = adModelObjectId;
    objectProcessClassData[0].adClientId = adClientId;
    objectProcessClassData[0].adClientIdr = "";
    objectProcessClassData[0].adOrgId = adOrgId;
    objectProcessClassData[0].adOrgIdr = "";
    objectProcessClassData[0].isactive = isactive;
    objectProcessClassData[0].adProcessId = adProcessId;
    objectProcessClassData[0].adProcessIdr = "";
    objectProcessClassData[0].action = action;
    objectProcessClassData[0].actionr = "";
    objectProcessClassData[0].isdefault = isdefault;
    objectProcessClassData[0].classname = classname;
    objectProcessClassData[0].adTabId = adTabId;
    objectProcessClassData[0].adTaskId = adTaskId;
    objectProcessClassData[0].adWorkflowId = adWorkflowId;
    objectProcessClassData[0].adFormId = adFormId;
    objectProcessClassData[0].adReferenceId = adReferenceId;
    objectProcessClassData[0].adCalloutId = adCalloutId;
    objectProcessClassData[0].objectType = objectType;
    objectProcessClassData[0].loadonstartup = loadonstartup;
    objectProcessClassData[0].seqno = seqno;
    objectProcessClassData[0].name = name;
    objectProcessClassData[0].language = "";
    return objectProcessClassData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef802453(ConnectionProvider connectionProvider, String IsReport, String IsJasper)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (CASE WHEN ?='Y' OR ?='Y' THEN 'R' ELSE 'P' END) FROM DUAL ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IsReport);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IsJasper);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "case");
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
  public static String selectDef802452_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef802450_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT AD_Model_Object.AD_Process_ID AS NAME" +
      "        FROM AD_Model_Object" +
      "        WHERE AD_Model_Object.AD_Model_Object_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adProcessId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM AD_Process left join (select AD_Process_ID, Name from AD_Process) table1 on (AD_Process.AD_Process_ID = table1.AD_Process_ID) left join (select AD_Process_ID,AD_Language, Name from AD_Process_TRL) tableTRL1 on (table1.AD_Process_ID = tableTRL1.AD_Process_ID and tableTRL1.AD_Language = ?)  WHERE AD_Process.AD_Process_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adProcessId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM AD_Process left join (select AD_Process_ID, Name from AD_Process) table1 on (AD_Process.AD_Process_ID = table1.AD_Process_ID) left join (select AD_Process_ID,AD_Language, Name from AD_Process_TRL) tableTRL1 on (table1.AD_Process_ID = tableTRL1.AD_Process_ID and tableTRL1.AD_Language = ?)  WHERE AD_Process.AD_Process_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);

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
      "        UPDATE AD_Model_Object" +
      "        SET AD_Module_ID = (?) , AD_Model_Object_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , IsActive = (?) , AD_Process_ID = (?) , Action = (?) , IsDefault = (?) , Classname = (?) , AD_Tab_ID = (?) , AD_Task_ID = (?) , AD_Workflow_ID = (?) , AD_Form_ID = (?) , AD_Reference_ID = (?) , AD_Callout_ID = (?) , Object_Type = (?) , Loadonstartup = TO_NUMBER(?) , Seqno = TO_NUMBER(?) , Name = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Model_Object.AD_Model_Object_ID = ? " +
      "                 AND AD_Model_Object.AD_Process_ID = ? " +
      "        AND AD_Model_Object.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Model_Object.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModelObjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, action);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, classname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWorkflowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFormId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adCalloutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, objectType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, loadonstartup);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModelObjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
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
      "        INSERT INTO AD_Model_Object " +
      "        (AD_Module_ID, AD_Model_Object_ID, AD_Client_ID, AD_Org_ID, IsActive, AD_Process_ID, Action, IsDefault, Classname, AD_Tab_ID, AD_Task_ID, AD_Workflow_ID, AD_Form_ID, AD_Reference_ID, AD_Callout_ID, Object_Type, Loadonstartup, Seqno, Name, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModelObjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, action);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, classname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWorkflowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFormId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adCalloutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, objectType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, loadonstartup);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adProcessId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Model_Object" +
      "        WHERE AD_Model_Object.AD_Model_Object_ID = ? " +
      "                 AND AD_Model_Object.AD_Process_ID = ? " +
      "        AND AD_Model_Object.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Model_Object.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adProcessId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Model_Object" +
      "        WHERE AD_Model_Object.AD_Model_Object_ID = ? " +
      "                 AND AD_Model_Object.AD_Process_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);

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
      "          FROM AD_Model_Object" +
      "         WHERE AD_Model_Object.AD_Model_Object_ID = ? ";

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
      "          FROM AD_Model_Object" +
      "         WHERE AD_Model_Object.AD_Model_Object_ID = ? ";

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
