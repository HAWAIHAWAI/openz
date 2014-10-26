//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

public class WindowTreeData implements FieldProvider {
static Logger log4j = Logger.getLogger(WindowTreeData.class);
  private String InitRecordNumber="0";
  public String nodeId;
  public String parentId;
  public String seqno;
  public String isactive;
  public String id;
  public String name;
  public String description;
  public String issummary;
  public String action;
  public String adWindowId;
  public String adProcessId;
  public String adFormId;
  public String adWorkflowId;
  public String adTaskId;
  public String isindevelopment;
  public String isready;
  public String adOrgtypeId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("node_id") || fieldName.equals("nodeId"))
      return nodeId;
    else if (fieldName.equalsIgnoreCase("parent_id") || fieldName.equals("parentId"))
      return parentId;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("action"))
      return action;
    else if (fieldName.equalsIgnoreCase("ad_window_id") || fieldName.equals("adWindowId"))
      return adWindowId;
    else if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
    else if (fieldName.equalsIgnoreCase("ad_form_id") || fieldName.equals("adFormId"))
      return adFormId;
    else if (fieldName.equalsIgnoreCase("ad_workflow_id") || fieldName.equals("adWorkflowId"))
      return adWorkflowId;
    else if (fieldName.equalsIgnoreCase("ad_task_id") || fieldName.equals("adTaskId"))
      return adTaskId;
    else if (fieldName.equalsIgnoreCase("isindevelopment"))
      return isindevelopment;
    else if (fieldName.equalsIgnoreCase("isready"))
      return isready;
    else if (fieldName.equalsIgnoreCase("ad_orgtype_id") || fieldName.equals("adOrgtypeId"))
      return adOrgtypeId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static WindowTreeData[] select(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return select(connectionProvider, adUserId, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] select(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo,tb.IsActive, m.AD_Menu_ID AS ID, m.Name,m.Description,m.IsSummary," +
      "        m.Action, m.AD_Window_ID, m.AD_Process_ID, m.AD_Form_ID, m.AD_Workflow_ID, m.AD_Task_ID, Mo.ISINDEVELOPMENT, " +
      "        '' as IsReady, '' as AD_OrgType_ID" +
      "        FROM AD_TreeNode tn left join AD_TreeBar tb on tn.AD_Tree_ID=tb.AD_Tree_ID " +
      "                                                  AND tn.Node_ID=tb.Node_ID " +
      "                                                  AND tb.AD_User_ID  = ?,          " +
      "             AD_Menu m," +
      "             AD_Module Mo" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = m.AD_Menu_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        AND Mo.AD_Module_ID = m.AD_Module_ID" +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.isactive = UtilSql.getValue(result, "isactive");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.action = UtilSql.getValue(result, "action");
        objectWindowTreeData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectWindowTreeData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectWindowTreeData.adFormId = UtilSql.getValue(result, "ad_form_id");
        objectWindowTreeData.adWorkflowId = UtilSql.getValue(result, "ad_workflow_id");
        objectWindowTreeData.adTaskId = UtilSql.getValue(result, "ad_task_id");
        objectWindowTreeData.isindevelopment = UtilSql.getValue(result, "isindevelopment");
        objectWindowTreeData.isready = UtilSql.getValue(result, "isready");
        objectWindowTreeData.adOrgtypeId = UtilSql.getValue(result, "ad_orgtype_id");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectTrl(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId, String adLanguage)    throws ServletException {
    return selectTrl(connectionProvider, adUserId, editable, parentId, nodeId, adTreeId, adLanguage, 0, 0);
  }

  public static WindowTreeData[] selectTrl(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId, String adLanguage, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo,tb.IsActive, m.AD_Menu_ID AS ID, t.Name,t.Description,m.IsSummary," +
      "        m.Action, m.AD_Window_ID, m.AD_Process_ID, m.AD_Form_ID, m.AD_Workflow_ID, m.AD_Task_ID, Mo.ISINDEVELOPMENT" +
      "        FROM AD_TreeNode tn left join AD_TreeBar tb on tn.AD_Tree_ID=tb.AD_Tree_ID  " +
      "                                                      AND tn.Node_ID=tb.Node_ID" +
      "                                                      AND tb.AD_User_ID  = ? , " +
      "             AD_Menu m, AD_Menu_Trl t," +
      "             AD_Module Mo" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      " m.AD_Menu_ID = t.AD_Menu_ID    " +
      "        AND tn.Node_ID = m.AD_Menu_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        AND t.AD_Language = ? " +
      "        AND Mo.AD_Module_ID = m.AD_Module_ID" +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.isactive = UtilSql.getValue(result, "isactive");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.action = UtilSql.getValue(result, "action");
        objectWindowTreeData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectWindowTreeData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectWindowTreeData.adFormId = UtilSql.getValue(result, "ad_form_id");
        objectWindowTreeData.adWorkflowId = UtilSql.getValue(result, "ad_workflow_id");
        objectWindowTreeData.adTaskId = UtilSql.getValue(result, "ad_task_id");
        objectWindowTreeData.isindevelopment = UtilSql.getValue(result, "isindevelopment");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectOrg(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectOrg(connectionProvider, adUserId, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectOrg(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo,tb.IsActive, m.AD_Org_ID AS ID, m.Name,m.Description,m.IsSummary,m.IsReady, m.AD_OrgType_ID" +
      "        FROM AD_TreeNode tn left join AD_TreeBar tb on tn.AD_Tree_ID=tb.AD_Tree_ID " +
      "                                            AND tn.Node_ID=tb.Node_ID " +
      "                                            AND tb.AD_User_ID  = ? ," +
      "         AD_Org m" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = m.AD_Org_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.isactive = UtilSql.getValue(result, "isactive");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.isready = UtilSql.getValue(result, "isready");
        objectWindowTreeData.adOrgtypeId = UtilSql.getValue(result, "ad_orgtype_id");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectProduct(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectProduct(connectionProvider, adUserId, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectProduct(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo,tb.IsActive, m.M_Product_ID AS ID, m.Name,m.Description,m.IsSummary " +
      "        FROM AD_TreeNodePR tn left join AD_TreeBar tb on tn.AD_Tree_ID=tb.AD_Tree_ID" +
      "                              AND tn.Node_ID=tb.Node_ID " +
      "                              AND tb.AD_User_ID  = ? , M_Product m" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = m.M_Product_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.isactive = UtilSql.getValue(result, "isactive");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectProductCategory(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectProductCategory(connectionProvider, adUserId, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectProductCategory(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo,tb.IsActive, m.M_Product_Category_ID AS ID, m.Name,m.Description, 'N' AS IsSummary " +
      "        FROM AD_TreeNode tn left join AD_TreeBar tb on tn.AD_Tree_ID=tb.AD_Tree_ID  " +
      "                                            AND tn.Node_ID=tb.Node_ID " +
      "                                            AND tb.AD_User_ID  = ? , " +
      "          M_Product_Category m" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = m.M_Product_Category_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.isactive = UtilSql.getValue(result, "isactive");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectBOM(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectBOM(connectionProvider, adUserId, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectBOM(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo,tb.IsActive, m.M_Product_BOM_ID AS ID, p.Name,p.Description, p.IsBOM AS IsSummary " +
      "        FROM AD_TreeNode tn left join AD_TreeBar tb on  tn.AD_Tree_ID=tb.AD_Tree_ID " +
      "                                AND tn.Node_ID=tb.Node_ID " +
      "                                AND tb.AD_User_ID = ? , " +
      "          M_Product_BOM m, M_Product p" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = m.M_Product_BOM_ID " +
      "        AND m.M_ProductBOM_ID = p.M_Product_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.isactive = UtilSql.getValue(result, "isactive");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectElementValue(ConnectionProvider connectionProvider, String adLanguage, String adUserId, String editable, String parentId, String nodeId, String adTreeId, String cElementId)    throws ServletException {
    return selectElementValue(connectionProvider, adLanguage, adUserId, editable, parentId, nodeId, adTreeId, cElementId, 0, 0);
  }

  public static WindowTreeData[] selectElementValue(ConnectionProvider connectionProvider, String adLanguage, String adUserId, String editable, String parentId, String nodeId, String adTreeId, String cElementId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo,tb.IsActive, m.C_ElementValue_ID AS ID, " +
      "                m.value||' - '||coalesce(mt.name, m.name) as Name,m.Description,m.IsSummary " +
      "        FROM C_ElementValue m left join c_elementvalue_trl mt on mt.c_elementvalue_id = m.c_elementvalue_id" +
      "                                  and mt.ad_language = ?," +
      "             AD_TreeNode tn left join AD_TreeBar tb on tn.AD_Tree_ID=tb.AD_Tree_ID " +
      "                                AND tn.Node_ID=tb.Node_ID " +
      "                                AND tb.AD_User_ID = ?  " +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = m.C_ElementValue_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        AND m.C_Element_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.isactive = UtilSql.getValue(result, "isactive");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectBPartner(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectBPartner(connectionProvider, adUserId, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectBPartner(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo,tb.IsActive, m.C_BPartner_ID AS ID, m.Name,m.Description,m.IsSummary " +
      "        FROM AD_TreeNodeBP tn left join AD_TreeBar tb on tn.AD_Tree_ID=tb.AD_Tree_ID " +
      "                              AND tn.Node_ID=tb.Node_ID " +
      "                              AND tb.AD_User_ID  = ?  , " +
      "             C_BPartner m" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = m.C_BPartner_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.isactive = UtilSql.getValue(result, "isactive");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectCampaign(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectCampaign(connectionProvider, adUserId, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectCampaign(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo,tb.IsActive, m.C_Campaign_ID AS ID, m.Name,m.Description, 'N' AS IsSummary " +
      "        FROM AD_TreeNode tn left join AD_TreeBar tb on tn.AD_Tree_ID=tb.AD_Tree_ID " +
      "                            AND tn.Node_ID=tb.Node_ID " +
      "                            AND tb.AD_User_ID = ? , " +
      "              C_Campaign m" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      " tn.Node_ID = m.C_Campaign_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.isactive = UtilSql.getValue(result, "isactive");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectProject(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectProject(connectionProvider, adUserId, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectProject(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo,tb.IsActive, m.C_Project_ID AS ID, m.Name,m.Description,m.IsSummary " +
      "        FROM AD_TreeNode tn left join AD_TreeBar tb on  tn.AD_Tree_ID=tb.AD_Tree_ID " +
      "                            AND tn.Node_ID=tb.Node_ID " +
      "                            AND tb.AD_User_ID  = ?  , " +
      "              C_Project m" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = m.C_Project_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.isactive = UtilSql.getValue(result, "isactive");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectActivity(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectActivity(connectionProvider, adUserId, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectActivity(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo,tb.IsActive, m.C_Activity_ID AS ID, m.Name,m.Description,m.IsSummary " +
      "        FROM AD_TreeNode tn left join AD_TreeBar tb on tn.AD_Tree_ID=tb.AD_Tree_ID " +
      "                            AND tn.Node_ID=tb.Node_ID " +
      "                            AND tb.AD_User_ID  = ?  , " +
      "                        C_Activity m" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      " tn.Node_ID = m.C_Activity_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.isactive = UtilSql.getValue(result, "isactive");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectSalesRegion(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectSalesRegion(connectionProvider, adUserId, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectSalesRegion(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo,tb.IsActive, m.C_SalesRegion_ID AS ID, m.Name,m.Description,m.IsSummary " +
      "        FROM AD_TreeNode tn left join AD_TreeBar tb on  tn.AD_Tree_ID=tb.AD_Tree_ID" +
      "                                  AND tn.Node_ID=tb.Node_ID " +
      "                                  AND tb.AD_User_ID = ?  , " +
      "            C_SalesRegion m" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = m.C_SalesRegion_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.isactive = UtilSql.getValue(result, "isactive");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectAccountingReport(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectAccountingReport(connectionProvider, adUserId, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectAccountingReport(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo,tb.IsActive, ar.AD_AccountingRpt_Element_ID AS ID, ar.Name,ar.Description,ar.IsSummary " +
      "        FROM AD_TreeNode tn left join AD_TreeBar tb on  tn.AD_Tree_ID=tb.AD_Tree_ID" +
      "                                  AND tn.Node_ID=tb.Node_ID " +
      "                                  AND tb.AD_User_ID = ?  , " +
      "            AD_AccountingRpt_Element ar" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND ar.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = ar.AD_AccountingRpt_Element_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.isactive = UtilSql.getValue(result, "isactive");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectTaxReport(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectTaxReport(connectionProvider, adUserId, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectTaxReport(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo,tb.IsActive, tr.C_TAX_REPORT_ID AS ID, tr.NAME,tr.Description,tr.IsSummary " +
      "        FROM AD_TREENODE tn LEFT JOIN AD_TREEBAR tb ON  tn.AD_Tree_ID=tb.AD_Tree_ID" +
      "                                  AND tn.Node_ID=tb.Node_ID " +
      "                                  AND tb.AD_User_ID = ?  , " +
      "            C_TAX_REPORT tr" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND tr.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = tr.C_TAX_REPORT_ID" +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.isactive = UtilSql.getValue(result, "isactive");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectCostCenterAsset(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectCostCenterAsset(connectionProvider, adUserId, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectCostCenterAsset(ConnectionProvider connectionProvider, String adUserId, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo,tb.IsActive, tr.A_ASSET_ID AS ID, tr.NAME,tr.Description,tr.IsSummary " +
      "        FROM AD_TREENODE tn LEFT JOIN AD_TREEBAR tb ON  tn.AD_Tree_ID=tb.AD_Tree_ID" +
      "                                  AND tn.Node_ID=tb.Node_ID " +
      "                                  AND tb.AD_User_ID = ?  , " +
      "            A_ASSET tr" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND tr.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = tr.A_ASSET_ID" +
      "        AND tn.AD_Tree_ID = ? " +
      "        AND tr.iscostcenter='Y'" +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.isactive = UtilSql.getValue(result, "isactive");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectTreeID(ConnectionProvider connectionProvider, String adClientId, String treetype)    throws ServletException {
    return selectTreeID(connectionProvider, adClientId, treetype, 0, 0);
  }

  public static WindowTreeData[] selectTreeID(ConnectionProvider connectionProvider, String adClientId, String treetype, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NODE_ID, ID, NAME " +
      "        FROM (" +
      "         SELECT AD_Client_ID as Node_ID, AD_Tree_ID AS ID, NAME, 1 AS SEQNO" +
      "        FROM AD_Tree t1" +
      "        WHERE t1.AD_Client_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ")  " +
      "        AND AD_Client_ID != '0'" +
      "        AND TreeType = ? " +
      "        AND IsActive = 'Y'" +
      "      UNION" +
      "       SELECT AD_Client_ID as Node_ID, AD_Tree_ID AS ID, NAME, 2 AS SEQNO" +
      "        FROM AD_Tree t2" +
      "        WHERE t2.AD_Client_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ") " +
      "        AND AD_Client_id = '0'" +
      "        AND TreeType = ?" +
      "        AND IsActive = 'Y') f" +
      "        ORDER BY SEQNO";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, treetype);
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, treetype);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] TreeName(ConnectionProvider connectionProvider, String adTreeId, String adClientId, String treetype)    throws ServletException {
    return TreeName(connectionProvider, adTreeId, adClientId, treetype, 0, 0);
  }

  public static WindowTreeData[] TreeName(ConnectionProvider connectionProvider, String adTreeId, String adClientId, String treetype, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME, DESCRIPTION " +
      "        FROM AD_Tree " +
      "        WHERE AD_Tree_ID = ? " +
      "        AND AD_Org_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ") " +
      "        AND TreeType = ? " +
      "        AND IsActive = 'Y'";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, treetype);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static String selectKey(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C.COLUMNNAME" +
      "        FROM AD_TAB T, AD_COLUMN C " +
      "        WHERE T.AD_TABLE_ID = C.AD_TABLE_ID" +
      "        AND (C.ISKEY = 'Y'" +
      "        OR C.ISSECONDARYKEY='Y')" +
      "        AND T.AD_TAB_ID = ? " +
      "        AND C.ISACTIVE='Y'" +
      "        ORDER BY C.SEQNO";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "columnname");
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

  public static String selectTableName(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT TB.TABLENAME" +
      "        FROM AD_TAB T, AD_TABLE TB " +
      "        WHERE T.AD_TABLE_ID = TB.AD_TABLE_ID" +
      "        AND T.AD_TAB_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "tablename");
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

  public static String selectEditable(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ISREADONLY" +
      "        FROM AD_TAB " +
      "        WHERE AD_TAB_ID = ? ";

    ResultSet result;
    String strReturn = "N";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "isreadonly");
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

  public static WindowTreeData[] selectTabName(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    return selectTabName(connectionProvider, adTabId, 0, 0);
  }

  public static WindowTreeData[] selectTabName(ConnectionProvider connectionProvider, String adTabId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT w.Name as Description, t.Name as NAME" +
      "        FROM AD_Window w, AD_TAB t" +
      "        WHERE w.AD_Window_ID = t.AD_Window_ID " +
      "        AND t.AD_TAB_ID = ? " +
      "        AND t.isActive = 'Y'";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectParents(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    return selectParents(connectionProvider, adTabId, 0, 0);
  }

  public static WindowTreeData[] selectParents(ConnectionProvider connectionProvider, String adTabId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COLUMNNAME AS Name, ad_window_id AS node_Id" +
      "        FROM AD_COLUMN c, AD_FIELD f, AD_TAB t " +
      "        WHERE t.ad_tab_id = f.ad_tab_id " +
      "        AND f.ad_column_id = c.ad_column_id " +
      "        AND t.ad_tab_id = ?" +
      "        AND c.isparent='Y' " +
      "        ORDER BY f.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static int update(ConnectionProvider connectionProvider, String updatedby, String parentId, String seqno, String adTreeId, String nodeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_TREENODE SET UPDATED=now(), UPDATEDBY = ?, PARENT_id = ?, SEQNO=TO_NUMBER(?) " +
      "        WHERE AD_TREE_ID = ? " +
      "        AND NODE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);

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

  public static int updatePR(ConnectionProvider connectionProvider, String updatedby, String parentId, String seqno, String adTreeId, String nodeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_TREENODEPR SET UPDATED=now(), UPDATEDBY = ?, PARENT_id = ?, SEQNO=TO_NUMBER(?) " +
      "        WHERE AD_TREE_ID = ? " +
      "        AND NODE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);

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

  public static int updateBP(ConnectionProvider connectionProvider, String updatedby, String parentId, String seqno, String adTreeId, String nodeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_TREENODEBP SET UPDATED=now(), UPDATEDBY = ?, PARENT_id = ?, SEQNO=TO_NUMBER(?) " +
      "        WHERE AD_TREE_ID = ? " +
      "        AND NODE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);

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
}
