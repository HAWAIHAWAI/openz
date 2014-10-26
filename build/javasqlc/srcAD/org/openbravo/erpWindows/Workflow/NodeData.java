//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Workflow;

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
class NodeData implements FieldProvider {
static Logger log4j = Logger.getLogger(NodeData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adWfNodeId;
  public String yposition;
  public String xposition;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String adWorkflowId;
  public String adWorkflowIdr;
  public String name;
  public String description;
  public String help;
  public String isactive;
  public String iscentrallymaintained;
  public String action;
  public String actionr;
  public String adWindowId;
  public String adWindowIdr;
  public String workflowId;
  public String workflowIdr;
  public String adProcessId;
  public String adProcessIdr;
  public String adTaskId;
  public String adTaskIdr;
  public String adFormId;
  public String adFormIdr;
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
    else if (fieldName.equalsIgnoreCase("ad_wf_node_id") || fieldName.equals("adWfNodeId"))
      return adWfNodeId;
    else if (fieldName.equalsIgnoreCase("yposition"))
      return yposition;
    else if (fieldName.equalsIgnoreCase("xposition"))
      return xposition;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_workflow_id") || fieldName.equals("adWorkflowId"))
      return adWorkflowId;
    else if (fieldName.equalsIgnoreCase("ad_workflow_idr") || fieldName.equals("adWorkflowIdr"))
      return adWorkflowIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("iscentrallymaintained"))
      return iscentrallymaintained;
    else if (fieldName.equalsIgnoreCase("action"))
      return action;
    else if (fieldName.equalsIgnoreCase("actionr"))
      return actionr;
    else if (fieldName.equalsIgnoreCase("ad_window_id") || fieldName.equals("adWindowId"))
      return adWindowId;
    else if (fieldName.equalsIgnoreCase("ad_window_idr") || fieldName.equals("adWindowIdr"))
      return adWindowIdr;
    else if (fieldName.equalsIgnoreCase("workflow_id") || fieldName.equals("workflowId"))
      return workflowId;
    else if (fieldName.equalsIgnoreCase("workflow_idr") || fieldName.equals("workflowIdr"))
      return workflowIdr;
    else if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
    else if (fieldName.equalsIgnoreCase("ad_process_idr") || fieldName.equals("adProcessIdr"))
      return adProcessIdr;
    else if (fieldName.equalsIgnoreCase("ad_task_id") || fieldName.equals("adTaskId"))
      return adTaskId;
    else if (fieldName.equalsIgnoreCase("ad_task_idr") || fieldName.equals("adTaskIdr"))
      return adTaskIdr;
    else if (fieldName.equalsIgnoreCase("ad_form_id") || fieldName.equals("adFormId"))
      return adFormId;
    else if (fieldName.equalsIgnoreCase("ad_form_idr") || fieldName.equals("adFormIdr"))
      return adFormIdr;
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
  public static NodeData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adWorkflowId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adWorkflowId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static NodeData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adWorkflowId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_WF_Node.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_WF_Node.CreatedBy) as CreatedByR, " +
      "        to_char(AD_WF_Node.Updated, ?) as updated, " +
      "        to_char(AD_WF_Node.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_WF_Node.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_WF_Node.UpdatedBy) as UpdatedByR," +
      "        AD_WF_Node.AD_WF_Node_ID, " +
      "AD_WF_Node.Yposition, " +
      "AD_WF_Node.Xposition, " +
      "AD_WF_Node.AD_Client_ID, " +
      "(CASE WHEN AD_WF_Node.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_WF_Node.AD_Org_ID, " +
      "(CASE WHEN AD_WF_Node.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_WF_Node.AD_Workflow_ID, " +
      "(CASE WHEN AD_WF_Node.AD_Workflow_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS AD_Workflow_IDR, " +
      "AD_WF_Node.Name, " +
      "AD_WF_Node.Description, " +
      "AD_WF_Node.Help, " +
      "COALESCE(AD_WF_Node.IsActive, 'N') AS IsActive, " +
      "COALESCE(AD_WF_Node.IsCentrallyMaintained, 'N') AS IsCentrallyMaintained, " +
      "AD_WF_Node.Action, " +
      "(CASE WHEN AD_WF_Node.Action IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ActionR, " +
      "AD_WF_Node.AD_Window_ID, " +
      "(CASE WHEN AD_WF_Node.AD_Window_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS AD_Window_IDR, " +
      "AD_WF_Node.Workflow_ID, " +
      "(CASE WHEN AD_WF_Node.Workflow_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS Workflow_IDR, " +
      "AD_WF_Node.AD_Process_ID, " +
      "(CASE WHEN AD_WF_Node.AD_Process_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'') ) END) AS AD_Process_IDR, " +
      "AD_WF_Node.AD_Task_ID, " +
      "(CASE WHEN AD_WF_Node.AD_Task_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL7.Name IS NULL THEN TO_CHAR(table7.Name) ELSE TO_CHAR(tableTRL7.Name) END)), ''))),'') ) END) AS AD_Task_IDR, " +
      "AD_WF_Node.AD_Form_ID, " +
      "(CASE WHEN AD_WF_Node.AD_Form_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS AD_Form_IDR, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_WF_Node left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_WF_Node.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_WF_Node.AD_Org_ID = table2.AD_Org_ID) left join (select AD_Workflow_ID, Name from AD_Workflow) table3 on (AD_WF_Node.AD_Workflow_ID = table3.AD_Workflow_ID) left join (select AD_Workflow_ID,AD_Language, Name from AD_Workflow_TRL) tableTRL3 on (table3.AD_Workflow_ID = tableTRL3.AD_Workflow_ID and tableTRL3.AD_Language = ?)  left join ad_ref_list_v list1 on (AD_WF_Node.Action = list1.value and list1.ad_reference_id = '104' and list1.ad_language = ?)  left join (select AD_Window_ID, Name from AD_Window) table4 on (AD_WF_Node.AD_Window_ID = table4.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL4 on (table4.AD_Window_ID = tableTRL4.AD_Window_ID and tableTRL4.AD_Language = ?)  left join (select AD_Workflow_ID, Name from AD_Workflow) table5 on (AD_WF_Node.Workflow_ID =  table5.AD_Workflow_ID) left join (select AD_Workflow_ID,AD_Language, Name from AD_Workflow_TRL) tableTRL5 on (table5.AD_Workflow_ID = tableTRL5.AD_Workflow_ID and tableTRL5.AD_Language = ?)  left join (select AD_Process_ID, Name from AD_Process) table6 on (AD_WF_Node.AD_Process_ID = table6.AD_Process_ID) left join (select AD_Process_ID,AD_Language, Name from AD_Process_TRL) tableTRL6 on (table6.AD_Process_ID = tableTRL6.AD_Process_ID and tableTRL6.AD_Language = ?)  left join (select AD_Task_ID, Name from AD_Task) table7 on (AD_WF_Node.AD_Task_ID = table7.AD_Task_ID) left join (select AD_Task_ID,AD_Language, Name from AD_Task_TRL) tableTRL7 on (table7.AD_Task_ID = tableTRL7.AD_Task_ID and tableTRL7.AD_Language = ?)  left join (select AD_Form_ID, Name from AD_Form) table8 on (AD_WF_Node.AD_Form_ID = table8.AD_Form_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adWorkflowId==null || adWorkflowId.equals(""))?"":"  AND AD_WF_Node.AD_Workflow_ID = ?  ");
    strSql = strSql + 
      "        AND AD_WF_Node.AD_WF_Node_ID = ? " +
      "        AND AD_WF_Node.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_WF_Node.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (adWorkflowId != null && !(adWorkflowId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWorkflowId);
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
        NodeData objectNodeData = new NodeData();
        objectNodeData.created = UtilSql.getValue(result, "created");
        objectNodeData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectNodeData.updated = UtilSql.getValue(result, "updated");
        objectNodeData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectNodeData.updatedby = UtilSql.getValue(result, "updatedby");
        objectNodeData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectNodeData.adWfNodeId = UtilSql.getValue(result, "ad_wf_node_id");
        objectNodeData.yposition = UtilSql.getValue(result, "yposition");
        objectNodeData.xposition = UtilSql.getValue(result, "xposition");
        objectNodeData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectNodeData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectNodeData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectNodeData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectNodeData.adWorkflowId = UtilSql.getValue(result, "ad_workflow_id");
        objectNodeData.adWorkflowIdr = UtilSql.getValue(result, "ad_workflow_idr");
        objectNodeData.name = UtilSql.getValue(result, "name");
        objectNodeData.description = UtilSql.getValue(result, "description");
        objectNodeData.help = UtilSql.getValue(result, "help");
        objectNodeData.isactive = UtilSql.getValue(result, "isactive");
        objectNodeData.iscentrallymaintained = UtilSql.getValue(result, "iscentrallymaintained");
        objectNodeData.action = UtilSql.getValue(result, "action");
        objectNodeData.actionr = UtilSql.getValue(result, "actionr");
        objectNodeData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectNodeData.adWindowIdr = UtilSql.getValue(result, "ad_window_idr");
        objectNodeData.workflowId = UtilSql.getValue(result, "workflow_id");
        objectNodeData.workflowIdr = UtilSql.getValue(result, "workflow_idr");
        objectNodeData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectNodeData.adProcessIdr = UtilSql.getValue(result, "ad_process_idr");
        objectNodeData.adTaskId = UtilSql.getValue(result, "ad_task_id");
        objectNodeData.adTaskIdr = UtilSql.getValue(result, "ad_task_idr");
        objectNodeData.adFormId = UtilSql.getValue(result, "ad_form_id");
        objectNodeData.adFormIdr = UtilSql.getValue(result, "ad_form_idr");
        objectNodeData.language = UtilSql.getValue(result, "language");
        objectNodeData.adUserClient = "";
        objectNodeData.adOrgClient = "";
        objectNodeData.createdby = "";
        objectNodeData.trBgcolor = "";
        objectNodeData.totalCount = "";
        objectNodeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectNodeData);
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
    NodeData objectNodeData[] = new NodeData[vector.size()];
    vector.copyInto(objectNodeData);
    return(objectNodeData);
  }

/**
Create a registry
 */
  public static NodeData[] set(String adWorkflowId, String description, String help, String action, String workflowId, String adProcessId, String iscentrallymaintained, String adClientId, String xposition, String adWfNodeId, String adWindowId, String yposition, String isactive, String adFormId, String updatedby, String updatedbyr, String name, String createdby, String createdbyr, String adTaskId, String adOrgId)    throws ServletException {
    NodeData objectNodeData[] = new NodeData[1];
    objectNodeData[0] = new NodeData();
    objectNodeData[0].created = "";
    objectNodeData[0].createdbyr = createdbyr;
    objectNodeData[0].updated = "";
    objectNodeData[0].updatedTimeStamp = "";
    objectNodeData[0].updatedby = updatedby;
    objectNodeData[0].updatedbyr = updatedbyr;
    objectNodeData[0].adWfNodeId = adWfNodeId;
    objectNodeData[0].yposition = yposition;
    objectNodeData[0].xposition = xposition;
    objectNodeData[0].adClientId = adClientId;
    objectNodeData[0].adClientIdr = "";
    objectNodeData[0].adOrgId = adOrgId;
    objectNodeData[0].adOrgIdr = "";
    objectNodeData[0].adWorkflowId = adWorkflowId;
    objectNodeData[0].adWorkflowIdr = "";
    objectNodeData[0].name = name;
    objectNodeData[0].description = description;
    objectNodeData[0].help = help;
    objectNodeData[0].isactive = isactive;
    objectNodeData[0].iscentrallymaintained = iscentrallymaintained;
    objectNodeData[0].action = action;
    objectNodeData[0].actionr = "";
    objectNodeData[0].adWindowId = adWindowId;
    objectNodeData[0].adWindowIdr = "";
    objectNodeData[0].workflowId = workflowId;
    objectNodeData[0].workflowIdr = "";
    objectNodeData[0].adProcessId = adProcessId;
    objectNodeData[0].adProcessIdr = "";
    objectNodeData[0].adTaskId = adTaskId;
    objectNodeData[0].adTaskIdr = "";
    objectNodeData[0].adFormId = adFormId;
    objectNodeData[0].adFormIdr = "";
    objectNodeData[0].language = "";
    return objectNodeData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef685_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as UpdatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

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
  public static String selectDef683_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as CreatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

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
      "        SELECT AD_WF_Node.AD_Workflow_ID AS NAME" +
      "        FROM AD_WF_Node" +
      "        WHERE AD_WF_Node.AD_WF_Node_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adWorkflowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM AD_Workflow left join (select AD_Workflow_ID, Name from AD_Workflow) table1 on (AD_Workflow.AD_Workflow_ID = table1.AD_Workflow_ID) left join (select AD_Workflow_ID,AD_Language, Name from AD_Workflow_TRL) tableTRL1 on (table1.AD_Workflow_ID = tableTRL1.AD_Workflow_ID and tableTRL1.AD_Language = ?)  WHERE AD_Workflow.AD_Workflow_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWorkflowId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adWorkflowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM AD_Workflow left join (select AD_Workflow_ID, Name from AD_Workflow) table1 on (AD_Workflow.AD_Workflow_ID = table1.AD_Workflow_ID) left join (select AD_Workflow_ID,AD_Language, Name from AD_Workflow_TRL) tableTRL1 on (table1.AD_Workflow_ID = tableTRL1.AD_Workflow_ID and tableTRL1.AD_Language = ?)  WHERE AD_Workflow.AD_Workflow_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWorkflowId);

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
      "        UPDATE AD_WF_Node" +
      "        SET AD_WF_Node_ID = (?) , Yposition = TO_NUMBER(?) , Xposition = TO_NUMBER(?) , AD_Client_ID = (?) , AD_Org_ID = (?) , AD_Workflow_ID = (?) , Name = (?) , Description = (?) , Help = (?) , IsActive = (?) , IsCentrallyMaintained = (?) , Action = (?) , AD_Window_ID = (?) , Workflow_ID = (?) , AD_Process_ID = (?) , AD_Task_ID = (?) , AD_Form_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_WF_Node.AD_WF_Node_ID = ? " +
      "                 AND AD_WF_Node.AD_Workflow_ID = ? " +
      "        AND AD_WF_Node.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_WF_Node.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNodeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yposition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, xposition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWorkflowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscentrallymaintained);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, action);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workflowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFormId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNodeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWorkflowId);
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
      "        INSERT INTO AD_WF_Node " +
      "        (AD_WF_Node_ID, Yposition, Xposition, AD_Client_ID, AD_Org_ID, AD_Workflow_ID, Name, Description, Help, IsActive, IsCentrallyMaintained, Action, AD_Window_ID, Workflow_ID, AD_Process_ID, AD_Task_ID, AD_Form_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNodeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yposition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, xposition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWorkflowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscentrallymaintained);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, action);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workflowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFormId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adWorkflowId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_WF_Node" +
      "        WHERE AD_WF_Node.AD_WF_Node_ID = ? " +
      "                 AND AD_WF_Node.AD_Workflow_ID = ? " +
      "        AND AD_WF_Node.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_WF_Node.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWorkflowId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adWorkflowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_WF_Node" +
      "        WHERE AD_WF_Node.AD_WF_Node_ID = ? " +
      "                 AND AD_WF_Node.AD_Workflow_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWorkflowId);

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
      "          FROM AD_WF_Node" +
      "         WHERE AD_WF_Node.AD_WF_Node_ID = ? ";

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
      "          FROM AD_WF_Node" +
      "         WHERE AD_WF_Node.AD_WF_Node_ID = ? ";

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
