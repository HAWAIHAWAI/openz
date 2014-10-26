//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;

public class WindowAccessData implements FieldProvider {
static Logger log4j = Logger.getLogger(WindowAccessData.class);
  private String InitRecordNumber="0";
  public String total;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("total"))
      return total;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static boolean hasWindowAccess(ConnectionProvider connectionProvider, String adRoleId, String adWindowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select Count(*) AS TOTAL" +
      "			FROM AD_Window_Access" +
      "			WHERE AD_Role_ID = ?" +
      "			AND AD_Window_ID = ?" +
      "			AND IsActive = 'Y'";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
    return(boolReturn);
  }

  public static boolean hasNoTableAccess(ConnectionProvider connectionProvider, String adRoleId, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select Count(*) AS TOTAL" +
      "			FROM AD_Table_Access t, AD_Tab tb" +
      "			WHERE t.AD_Table_ID = tb.AD_Table_ID" +
      "			AND t.AD_Role_ID = ?" +
      "			AND tb.AD_Tab_ID = ?" +
      "			AND t.IsActive = 'Y'" +
      "			AND t.IsExclude = 'Y'";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
    return(boolReturn);
  }

  public static boolean hasReadOnlyAccess(ConnectionProvider connectionProvider, String adRoleId, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT(*) AS TOTAL" +
      "      FROM (" +
      "         SELECT 1 " +
      "           FROM AD_Table_Access t, " +
      "                AD_Tab tb" +
      "          WHERE t.AD_Table_ID = tb.AD_Table_ID" +
      "            AND t.AD_Role_ID = ?" +
      "            AND tb.AD_Tab_ID = ?" +
      "            AND t.IsActive = 'Y'" +
      "            AND t.IsExclude = 'N'" +
      "            AND (t.IsReadOnly = 'Y' OR tb.UIPattern = 'RO')" +
      "        UNION" +
      "        SELECT 1" +
      "          FROM AD_Window_Access w," +
      "               AD_Tab t" +
      "         WHERE w.IsActive='Y'" +
      "           AND w.AD_Window_ID = t.AD_Window_ID" +
      "           AND w.AD_Role_ID = ?" +
      "           AND t.AD_Tab_ID = ?" +
      "           AND w.isReadWrite = 'N'" +
      "           AND w.isActive='Y') t";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
    return(boolReturn);
  }

  public static boolean hasNotDeleteAccess(ConnectionProvider connectionProvider, String adRoleId, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT(*) AS TOTAL" +
      "      FROM (" +
      "         SELECT 1 " +
      "           FROM AD_Table_Access t, " +
      "                AD_Tab tb" +
      "          WHERE t.AD_Table_ID = tb.AD_Table_ID" +
      "            AND t.AD_Role_ID = ?" +
      "            AND tb.AD_Tab_ID = ?" +
      "            AND t.IsActive = 'Y'" +
      "            AND t.IsExclude = 'N'" +
      "            AND (t.IsReadOnly = 'Y' OR tb.UIPattern IN ('RO', 'SR'))" +
      "        UNION" +
      "        SELECT 1" +
      "          FROM AD_Window_Access w," +
      "               AD_Tab t" +
      "         WHERE w.IsActive='Y'" +
      "           AND w.AD_Window_ID = t.AD_Window_ID" +
      "           AND w.AD_Role_ID = ?" +
      "           AND t.AD_Tab_ID = ?" +
      "           AND w.isReadWrite = 'N'" +
      "           AND w.isActive='Y') t";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
    return(boolReturn);
  }

  public static boolean hasProcessAccess(ConnectionProvider connectionProvider, String adRoleId, String adProcessId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select Count(*) AS TOTAL" +
      "			FROM AD_Process_Access" +
      "			WHERE AD_Role_ID = ?" +
      "			AND AD_Process_ID = ?" +
      "			AND IsActive = 'Y'";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
    return(boolReturn);
  }

  public static boolean hasProcessAccessName(ConnectionProvider connectionProvider, String adRoleId, String name)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select Count(*) AS TOTAL" +
      "			FROM AD_Process_Access a, AD_Process p" +
      "			WHERE a.AD_Role_ID = ?" +
      "			AND a.AD_Process_ID = p.AD_Process_ID" +
      "			AND UPPER(p.Value) = UPPER(?)" +
      "			AND a.IsActive = 'Y'";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
    return(boolReturn);
  }

  public static boolean hasWorkflowAccess(ConnectionProvider connectionProvider, String adRoleId, String adWorkflowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select Count(*) AS TOTAL" +
      "			FROM AD_Workflow_Access" +
      "			WHERE AD_Role_ID = ?" +
      "			AND AD_Workflow_ID = ?" +
      "			AND IsActive = 'Y'";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWorkflowId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
    return(boolReturn);
  }

  public static boolean hasFormAccess(ConnectionProvider connectionProvider, String adRoleId, String adFormId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select Count(*) AS TOTAL" +
      "			FROM AD_Form_Access" +
      "			WHERE AD_Role_ID = ?" +
      "			AND AD_Form_ID = ?" +
      "			AND IsActive = 'Y'";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFormId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
    return(boolReturn);
  }

  public static boolean hasFormAccessName(ConnectionProvider connectionProvider, String adRoleId, String name)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select Count(*) AS TOTAL" +
      "			FROM AD_Form_Access a, AD_Form f" +
      "			WHERE a.AD_Role_ID = ?" +
      "			AND a.AD_Form_ID = f.AD_Form_ID" +
      "			AND UPPER(f.ClassName) = UPPER(?)" +
      "			AND a.IsActive = 'Y'";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
    return(boolReturn);
  }

  public static boolean hasTaskAccess(ConnectionProvider connectionProvider, String adRoleId, String adTaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select Count(*) AS TOTAL" +
      "			FROM AD_Task_Access" +
      "			WHERE AD_Role_ID = ?" +
      "			AND AD_Task_ID = ?" +
      "			AND IsActive = to_char('Y')";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTaskId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
    return(boolReturn);
  }

  public static boolean hasTaskAccessName(ConnectionProvider connectionProvider, String adRoleId, String taskName)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select Count(*) AS TOTAL" +
      "			FROM AD_Task t, AD_Task_Access ta" +
      "			WHERE ta.AD_Role_ID = ?" +
      "			AND t.AD_Task_ID = ta.AD_Task_ID" +
      "			AND ta.IsActive = 'Y'" +
      "			AND UPPER(t.ClassName) = UPPER(?)";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taskName);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
    return(boolReturn);
  }

  public static boolean hasWriteAccess(ConnectionProvider connectionProvider, String adWindowId, String adRoleId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	     select Count(*) AS TOTAL " +
      "	     FROM AD_Window_Access " +
      "	     WHERE AD_Window_ID = ?" +
      "	     AND AD_Role_ID = ? " +
      "	     AND IsActive = 'Y' ";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
    return(boolReturn);
  }
}
