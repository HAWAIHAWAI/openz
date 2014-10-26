//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_workflow;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class WorkflowControlData implements FieldProvider {
static Logger log4j = Logger.getLogger(WorkflowControlData.class);
  private String InitRecordNumber="0";
  public String adWfNodeId;
  public String action;
  public String name;
  public String adFormId;
  public String adProcessId;
  public String adTaskId;
  public String adWindowId;
  public String workflowId;
  public String xposition;
  public String yposition;
  public String help;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_wf_node_id") || fieldName.equals("adWfNodeId"))
      return adWfNodeId;
    else if (fieldName.equalsIgnoreCase("action"))
      return action;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("ad_form_id") || fieldName.equals("adFormId"))
      return adFormId;
    else if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
    else if (fieldName.equalsIgnoreCase("ad_task_id") || fieldName.equals("adTaskId"))
      return adTaskId;
    else if (fieldName.equalsIgnoreCase("ad_window_id") || fieldName.equals("adWindowId"))
      return adWindowId;
    else if (fieldName.equalsIgnoreCase("workflow_id") || fieldName.equals("workflowId"))
      return workflowId;
    else if (fieldName.equalsIgnoreCase("xposition"))
      return xposition;
    else if (fieldName.equalsIgnoreCase("yposition"))
      return yposition;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static WorkflowControlData[] select(ConnectionProvider connectionProvider, String adClientId, String adOrgId, String adWfNodeId)    throws ServletException {
    return select(connectionProvider, adClientId, adOrgId, adWfNodeId, 0, 0);
  }

  public static WorkflowControlData[] select(ConnectionProvider connectionProvider, String adClientId, String adOrgId, String adWfNodeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT W.AD_WF_NODE_ID, W.ACTION, W.NAME, W.AD_FORM_ID, W.AD_PROCESS_ID, W.AD_TASK_ID, " +
      "        W.AD_WINDOW_ID, W.WORKFLOW_ID, XPOSITION, YPOSITION, W.HELP" +
      "        FROM AD_WF_NODENEXT WN, AD_WF_NODE W " +
      "        WHERE WN.AD_WF_NEXT_ID = W.AD_WF_NODE_ID " +
      "        AND WN.ISACTIVE = 'Y' " +
      "        AND WN.AD_CLIENT_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ") " +
      "        AND WN.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ") " +
      "        AND WN.AD_WF_NODE_ID = ? ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNodeId);

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
        WorkflowControlData objectWorkflowControlData = new WorkflowControlData();
        objectWorkflowControlData.adWfNodeId = UtilSql.getValue(result, "ad_wf_node_id");
        objectWorkflowControlData.action = UtilSql.getValue(result, "action");
        objectWorkflowControlData.name = UtilSql.getValue(result, "name");
        objectWorkflowControlData.adFormId = UtilSql.getValue(result, "ad_form_id");
        objectWorkflowControlData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectWorkflowControlData.adTaskId = UtilSql.getValue(result, "ad_task_id");
        objectWorkflowControlData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectWorkflowControlData.workflowId = UtilSql.getValue(result, "workflow_id");
        objectWorkflowControlData.xposition = UtilSql.getValue(result, "xposition");
        objectWorkflowControlData.yposition = UtilSql.getValue(result, "yposition");
        objectWorkflowControlData.help = UtilSql.getValue(result, "help");
        objectWorkflowControlData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWorkflowControlData);
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
    WorkflowControlData objectWorkflowControlData[] = new WorkflowControlData[vector.size()];
    vector.copyInto(objectWorkflowControlData);
    return(objectWorkflowControlData);
  }

  public static WorkflowControlData[] selectTrl(ConnectionProvider connectionProvider, String adLanguage, String adClientId, String adOrgId, String adWfNodeId)    throws ServletException {
    return selectTrl(connectionProvider, adLanguage, adClientId, adOrgId, adWfNodeId, 0, 0);
  }

  public static WorkflowControlData[] selectTrl(ConnectionProvider connectionProvider, String adLanguage, String adClientId, String adOrgId, String adWfNodeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT W.AD_WF_NODE_ID, W.ACTION, COALESCE(WT.NAME, W.NAME) AS NAME, W.AD_FORM_ID, W.AD_PROCESS_ID, W.AD_TASK_ID, " +
      "        W.AD_WINDOW_ID, W.WORKFLOW_ID, XPOSITION, YPOSITION, COALESCE(WT.HELP, W.HELP) AS HELP " +
      "        FROM AD_WF_NODENEXT WN, " +
      "             AD_WF_NODE W left join AD_WF_NODE_TRL WT on W.AD_WF_NODE_ID = WT.AD_WF_NODE_ID " +
      "                                                      AND WT.AD_LANGUAGE  = ? " +
      "        WHERE WN.AD_WF_NEXT_ID = W.AD_WF_NODE_ID " +
      "        AND WN.ISACTIVE = 'Y' " +
      "        AND WN.AD_CLIENT_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ") " +
      "        AND WN.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ") " +
      "        AND WN.AD_WF_NODE_ID = ? ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNodeId);

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
        WorkflowControlData objectWorkflowControlData = new WorkflowControlData();
        objectWorkflowControlData.adWfNodeId = UtilSql.getValue(result, "ad_wf_node_id");
        objectWorkflowControlData.action = UtilSql.getValue(result, "action");
        objectWorkflowControlData.name = UtilSql.getValue(result, "name");
        objectWorkflowControlData.adFormId = UtilSql.getValue(result, "ad_form_id");
        objectWorkflowControlData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectWorkflowControlData.adTaskId = UtilSql.getValue(result, "ad_task_id");
        objectWorkflowControlData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectWorkflowControlData.workflowId = UtilSql.getValue(result, "workflow_id");
        objectWorkflowControlData.xposition = UtilSql.getValue(result, "xposition");
        objectWorkflowControlData.yposition = UtilSql.getValue(result, "yposition");
        objectWorkflowControlData.help = UtilSql.getValue(result, "help");
        objectWorkflowControlData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWorkflowControlData);
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
    WorkflowControlData objectWorkflowControlData[] = new WorkflowControlData[vector.size()];
    vector.copyInto(objectWorkflowControlData);
    return(objectWorkflowControlData);
  }

  public static String selectFirstNode(ConnectionProvider connectionProvider, String adWorkflowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_WF_NODE_ID FROM AD_WORKFLOW WHERE AD_WORKFLOW_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWorkflowId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_wf_node_id");
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

  public static WorkflowControlData[] selectFirstNodeData(ConnectionProvider connectionProvider, String adWfNodeId)    throws ServletException {
    return selectFirstNodeData(connectionProvider, adWfNodeId, 0, 0);
  }

  public static WorkflowControlData[] selectFirstNodeData(ConnectionProvider connectionProvider, String adWfNodeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT W.AD_WF_NODE_ID, W.ACTION, W.NAME, W.AD_FORM_ID, W.AD_PROCESS_ID, W.AD_TASK_ID, " +
      "        W.AD_WINDOW_ID, W.WORKFLOW_ID, XPOSITION, YPOSITION" +
      "        FROM AD_WF_NODE W" +
      "        WHERE W.AD_WF_NODE_ID = ? ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNodeId);

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
        WorkflowControlData objectWorkflowControlData = new WorkflowControlData();
        objectWorkflowControlData.adWfNodeId = UtilSql.getValue(result, "ad_wf_node_id");
        objectWorkflowControlData.action = UtilSql.getValue(result, "action");
        objectWorkflowControlData.name = UtilSql.getValue(result, "name");
        objectWorkflowControlData.adFormId = UtilSql.getValue(result, "ad_form_id");
        objectWorkflowControlData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectWorkflowControlData.adTaskId = UtilSql.getValue(result, "ad_task_id");
        objectWorkflowControlData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectWorkflowControlData.workflowId = UtilSql.getValue(result, "workflow_id");
        objectWorkflowControlData.xposition = UtilSql.getValue(result, "xposition");
        objectWorkflowControlData.yposition = UtilSql.getValue(result, "yposition");
        objectWorkflowControlData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWorkflowControlData);
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
    WorkflowControlData objectWorkflowControlData[] = new WorkflowControlData[vector.size()];
    vector.copyInto(objectWorkflowControlData);
    return(objectWorkflowControlData);
  }

  public static WorkflowControlData[] selectFirstNodeDataTrl(ConnectionProvider connectionProvider, String adLanguage, String adWfNodeId)    throws ServletException {
    return selectFirstNodeDataTrl(connectionProvider, adLanguage, adWfNodeId, 0, 0);
  }

  public static WorkflowControlData[] selectFirstNodeDataTrl(ConnectionProvider connectionProvider, String adLanguage, String adWfNodeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT W.AD_WF_NODE_ID, W.ACTION, COALESCE(WT.NAME, W.NAME) AS NAME, W.AD_FORM_ID, W.AD_PROCESS_ID, W.AD_TASK_ID, " +
      "        W.AD_WINDOW_ID, W.WORKFLOW_ID, XPOSITION, YPOSITION" +
      "        FROM AD_WF_NODE W left join AD_WF_NODE_TRL WT on W.AD_WF_NODE_ID = WT.AD_WF_NODE_ID " +
      "                                                    AND WT.AD_LANGUAGE  = ? " +
      "        WHERE  W.AD_WF_NODE_ID = ? ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWfNodeId);

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
        WorkflowControlData objectWorkflowControlData = new WorkflowControlData();
        objectWorkflowControlData.adWfNodeId = UtilSql.getValue(result, "ad_wf_node_id");
        objectWorkflowControlData.action = UtilSql.getValue(result, "action");
        objectWorkflowControlData.name = UtilSql.getValue(result, "name");
        objectWorkflowControlData.adFormId = UtilSql.getValue(result, "ad_form_id");
        objectWorkflowControlData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectWorkflowControlData.adTaskId = UtilSql.getValue(result, "ad_task_id");
        objectWorkflowControlData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectWorkflowControlData.workflowId = UtilSql.getValue(result, "workflow_id");
        objectWorkflowControlData.xposition = UtilSql.getValue(result, "xposition");
        objectWorkflowControlData.yposition = UtilSql.getValue(result, "yposition");
        objectWorkflowControlData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWorkflowControlData);
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
    WorkflowControlData objectWorkflowControlData[] = new WorkflowControlData[vector.size()];
    vector.copyInto(objectWorkflowControlData);
    return(objectWorkflowControlData);
  }

  public static WorkflowControlData[] selectWorkflowName(ConnectionProvider connectionProvider, String adWorkflowId)    throws ServletException {
    return selectWorkflowName(connectionProvider, adWorkflowId, 0, 0);
  }

  public static WorkflowControlData[] selectWorkflowName(ConnectionProvider connectionProvider, String adWorkflowId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME, HELP FROM AD_WORKFLOW WHERE AD_WORKFLOW_ID = ? ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWorkflowId);

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
        WorkflowControlData objectWorkflowControlData = new WorkflowControlData();
        objectWorkflowControlData.name = UtilSql.getValue(result, "name");
        objectWorkflowControlData.help = UtilSql.getValue(result, "help");
        objectWorkflowControlData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWorkflowControlData);
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
    WorkflowControlData objectWorkflowControlData[] = new WorkflowControlData[vector.size()];
    vector.copyInto(objectWorkflowControlData);
    return(objectWorkflowControlData);
  }

  public static WorkflowControlData[] selectWorkflowNameTrl(ConnectionProvider connectionProvider, String adLanguage, String adWorkflowId)    throws ServletException {
    return selectWorkflowNameTrl(connectionProvider, adLanguage, adWorkflowId, 0, 0);
  }

  public static WorkflowControlData[] selectWorkflowNameTrl(ConnectionProvider connectionProvider, String adLanguage, String adWorkflowId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(WT.NAME, W.NAME) AS NAME, COALESCE(WT.HELP, W.HELP) AS HELP " +
      "        FROM AD_WORKFLOW W left join AD_WORKFLOW_TRL WT on W.AD_WORKFLOW_ID = WT.AD_WORKFLOW_ID " +
      "                                                      AND WT.AD_LANGUAGE = ? " +
      "        WHERE W.AD_WORKFLOW_ID = ? ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWorkflowId);

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
        WorkflowControlData objectWorkflowControlData = new WorkflowControlData();
        objectWorkflowControlData.name = UtilSql.getValue(result, "name");
        objectWorkflowControlData.help = UtilSql.getValue(result, "help");
        objectWorkflowControlData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWorkflowControlData);
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
    WorkflowControlData objectWorkflowControlData[] = new WorkflowControlData[vector.size()];
    vector.copyInto(objectWorkflowControlData);
    return(objectWorkflowControlData);
  }
}
