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

class WindowTreeUtilityClientData implements FieldProvider {
static Logger log4j = Logger.getLogger(WindowTreeUtilityClientData.class);
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
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static WindowTreeUtilityClientData[] selectInstructions(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adUserId, String adTreeId)    throws ServletException {
    return selectInstructions(connectionProvider, editable, parentId, nodeId, adUserId, adTreeId, 0, 0);
  }

  public static WindowTreeUtilityClientData[] selectInstructions(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adUserId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo,tb.IsActive, null AS ID, null as Name, null as Description, null as IsSummary, " +
      "          null as Action" +
      "        FROM AD_TreeNode tn left join AD_TreeBar tb on tn.AD_Tree_ID=tb.AD_Tree_ID" +
      "                                                      AND tn.Node_ID=tb.Node_ID" +
      "                                                      AND tb.AD_User_ID  = ? " +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "0 = 1 " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
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
        WindowTreeUtilityClientData objectWindowTreeUtilityClientData = new WindowTreeUtilityClientData();
        objectWindowTreeUtilityClientData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeUtilityClientData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeUtilityClientData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeUtilityClientData.isactive = UtilSql.getValue(result, "isactive");
        objectWindowTreeUtilityClientData.id = UtilSql.getValue(result, "id");
        objectWindowTreeUtilityClientData.name = UtilSql.getValue(result, "name");
        objectWindowTreeUtilityClientData.description = UtilSql.getValue(result, "description");
        objectWindowTreeUtilityClientData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeUtilityClientData.action = UtilSql.getValue(result, "action");
        objectWindowTreeUtilityClientData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeUtilityClientData);
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
    WindowTreeUtilityClientData objectWindowTreeUtilityClientData[] = new WindowTreeUtilityClientData[vector.size()];
    vector.copyInto(objectWindowTreeUtilityClientData);
    return(objectWindowTreeUtilityClientData);
  }
}
