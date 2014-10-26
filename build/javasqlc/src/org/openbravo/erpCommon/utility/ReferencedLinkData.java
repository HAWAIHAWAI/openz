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

class ReferencedLinkData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReferencedLinkData.class);
  private String InitRecordNumber="0";
  public String adTabId;
  public String adWindowId;
  public String seqno;
  public String name;
  public String adTableId;
  public String poWindowId;
  public String windowname;
  public String tabname;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_tab_id") || fieldName.equals("adTabId"))
      return adTabId;
    else if (fieldName.equalsIgnoreCase("ad_window_id") || fieldName.equals("adWindowId"))
      return adWindowId;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("po_window_id") || fieldName.equals("poWindowId"))
      return poWindowId;
    else if (fieldName.equalsIgnoreCase("windowname"))
      return windowname;
    else if (fieldName.equalsIgnoreCase("tabname"))
      return tabname;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReferencedLinkData[] selectTabs(ConnectionProvider connectionProvider, String adTabId, String tablevel)    throws ServletException {
    return selectTabs(connectionProvider, adTabId, tablevel, 0, 0);
  }

  public static ReferencedLinkData[] selectTabs(ConnectionProvider connectionProvider, String adTabId, String tablevel, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_TAB_ID, AD_WINDOW_ID, SEQNO, NAME, AD_TABLE_ID, " +
      "      '' AS PO_WINDOW_ID, '' AS WINDOWNAME, NAME AS TABNAME " +
      "      FROM AD_TAB" +
      "      WHERE AD_WINDOW_ID = (SELECT AD_WINDOW_ID FROM AD_TAB WHERE AD_TAB_ID = ?) " +
      "      AND TABLEVEL = ? " +
      "      ORDER BY SEQNO";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tablevel);

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
        ReferencedLinkData objectReferencedLinkData = new ReferencedLinkData();
        objectReferencedLinkData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectReferencedLinkData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectReferencedLinkData.seqno = UtilSql.getValue(result, "seqno");
        objectReferencedLinkData.name = UtilSql.getValue(result, "name");
        objectReferencedLinkData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectReferencedLinkData.poWindowId = UtilSql.getValue(result, "po_window_id");
        objectReferencedLinkData.windowname = UtilSql.getValue(result, "windowname");
        objectReferencedLinkData.tabname = UtilSql.getValue(result, "tabname");
        objectReferencedLinkData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReferencedLinkData);
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
    ReferencedLinkData objectReferencedLinkData[] = new ReferencedLinkData[vector.size()];
    vector.copyInto(objectReferencedLinkData);
    return(objectReferencedLinkData);
  }

  public static ReferencedLinkData[] select(ConnectionProvider connectionProvider, String adWindowId, String adTableId)    throws ServletException {
    return select(connectionProvider, adWindowId, adTableId, 0, 0);
  }

  public static ReferencedLinkData[] select(ConnectionProvider connectionProvider, String adWindowId, String adTableId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT W.AD_WINDOW_ID, '' AS PO_WINDOW_ID, W.NAME AS WINDOWNAME, T.NAME AS TABNAME, '' as NAME, t.AD_TAB_ID" +
      "      FROM AD_WINDOW W, AD_TAB T " +
      "      WHERE W.AD_WINDOW_ID = T.AD_WINDOW_ID " +
      "      AND W.ISACTIVE = 'Y' " +
      "      AND T.ISACTIVE = 'Y' " +
      "      AND W.AD_WINDOW_ID = ? " +
      "      AND T.AD_TABLE_ID = ? ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);

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
        ReferencedLinkData objectReferencedLinkData = new ReferencedLinkData();
        objectReferencedLinkData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectReferencedLinkData.poWindowId = UtilSql.getValue(result, "po_window_id");
        objectReferencedLinkData.windowname = UtilSql.getValue(result, "windowname");
        objectReferencedLinkData.tabname = UtilSql.getValue(result, "tabname");
        objectReferencedLinkData.name = UtilSql.getValue(result, "name");
        objectReferencedLinkData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectReferencedLinkData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReferencedLinkData);
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
    ReferencedLinkData objectReferencedLinkData[] = new ReferencedLinkData[vector.size()];
    vector.copyInto(objectReferencedLinkData);
    return(objectReferencedLinkData);
  }

  public static ReferencedLinkData[] selectWindows(ConnectionProvider connectionProvider, String adTableId)    throws ServletException {
    return selectWindows(connectionProvider, adTableId, 0, 0);
  }

  public static ReferencedLinkData[] selectWindows(ConnectionProvider connectionProvider, String adTableId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT t.AD_WINDOW_ID, t.PO_WINDOW_ID" +
      "        FROM AD_TABLE t,ad_window w,ad_module m" +
      "        WHERE  t.ad_window_id=w.ad_window_id and w.isactive='Y'" +
      "        and t.isactive='Y' and m.ad_module_id=w.ad_module_id and m.isactive='Y'" +
      "        and t.AD_TABLE_ID = ? and t.AD_WINDOW_ID is not null" +
      "        UNION" +
      "        SELECT t.AD_WINDOW_ID, null as PO_WINDOW_ID" +
      "        FROM AD_TAB t, ad_window w,ad_module m" +
      "        where t.ad_window_id=w.ad_window_id and m.ad_module_id=w.ad_module_id and m.isactive='Y'" +
      "        and t.isactive='Y' and w.isactive='Y'" +
      "        and t.AD_TABLE_ID = ?     ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);

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
        ReferencedLinkData objectReferencedLinkData = new ReferencedLinkData();
        objectReferencedLinkData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectReferencedLinkData.poWindowId = UtilSql.getValue(result, "po_window_id");
        objectReferencedLinkData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReferencedLinkData);
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
    ReferencedLinkData objectReferencedLinkData[] = new ReferencedLinkData[vector.size()];
    vector.copyInto(objectReferencedLinkData);
    return(objectReferencedLinkData);
  }

  public static ReferencedLinkData[] selectParent(ConnectionProvider connectionProvider, String adWindowId)    throws ServletException {
    return selectParent(connectionProvider, adWindowId, 0, 0);
  }

  public static ReferencedLinkData[] selectParent(ConnectionProvider connectionProvider, String adWindowId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT W.AD_WINDOW_ID, '' AS PO_WINDOW_ID, W.NAME AS WINDOWNAME, T.NAME AS TABNAME, t.ad_tab_id " +
      "      FROM AD_WINDOW W, AD_TAB T " +
      "      WHERE W.AD_WINDOW_ID = T.AD_WINDOW_ID " +
      "      AND W.ISACTIVE = 'Y' " +
      "      AND T.ISACTIVE = 'Y' " +
      "      AND T.tablevel = 0 " +
      "      AND W.AD_WINDOW_ID = ?" +
      "      ORDER BY T.SEQNO ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);

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
        ReferencedLinkData objectReferencedLinkData = new ReferencedLinkData();
        objectReferencedLinkData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectReferencedLinkData.poWindowId = UtilSql.getValue(result, "po_window_id");
        objectReferencedLinkData.windowname = UtilSql.getValue(result, "windowname");
        objectReferencedLinkData.tabname = UtilSql.getValue(result, "tabname");
        objectReferencedLinkData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectReferencedLinkData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReferencedLinkData);
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
    ReferencedLinkData objectReferencedLinkData[] = new ReferencedLinkData[vector.size()];
    vector.copyInto(objectReferencedLinkData);
    return(objectReferencedLinkData);
  }

  public static boolean selectSOTrx(ConnectionProvider connectionProvider, String table, String keyName, String keyId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (case ISSOTRX when 'Y' then 1 else 0 end) AS ISSOTRX " +
      "        FROM ";
    strSql = strSql + ((table==null || table.equals(""))?"":table);
    strSql = strSql + 
      "        WHERE ";
    strSql = strSql + ((keyName==null || keyName.equals(""))?"":keyName);
    strSql = strSql + 
      " = ?";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (table != null && !(table.equals(""))) {
        }
      if (keyName != null && !(keyName.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, keyId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "issotrx").equals("0");
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

  public static boolean hasIsSOTrx(ConnectionProvider connectionProvider, String adTableId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) AS TOTAL " +
      "        FROM AD_COLUMN " +
      "        WHERE AD_TABLE_ID = ? " +
      "        AND UPPER(COLUMNNAME) = 'ISSOTRX'";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);

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

  public static String selectTableName(ConnectionProvider connectionProvider, String adTableId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT TABLENAME" +
      "        FROM AD_TABLE " +
      "        WHERE AD_TABLE_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);

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

  public static String selectTabLevel(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT TABLEVEL " +
      "        FROM AD_TAB " +
      "        WHERE AD_TAB_ID = ?";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "tablevel");
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

  public static String selectKeyColumn(ConnectionProvider connectionProvider, String adTableId, String columnName)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(COLUMNNAME) AS NAME" +
      "        FROM AD_COLUMN " +
      "        WHERE AD_TABLE_ID = ?" +
      "        AND (ISKEY='Y' OR ISSECONDARYKEY='Y')" +
      "        AND COLUMNNAME <> COALESCE(?,'XXX')";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, columnName);

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

  public static String selectKeyID(ConnectionProvider connectionProvider, String keyName, String table, String parentTable, String parentKey, String parentKeyId, String parentKey2, String parentKey2Id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ";
    strSql = strSql + ((keyName==null || keyName.equals(""))?"":keyName);
    strSql = strSql + 
      " AS NAME " +
      "        FROM ";
    strSql = strSql + ((table==null || table.equals(""))?"":table);
    strSql = strSql + 
      "        WHERE ";
    strSql = strSql + ((keyName==null || keyName.equals(""))?"":keyName);
    strSql = strSql + 
      " = (SELECT ";
    strSql = strSql + ((keyName==null || keyName.equals(""))?"":keyName);
    strSql = strSql + 
      " FROM  ";
    strSql = strSql + ((parentTable==null || parentTable.equals(""))?"":parentTable);
    strSql = strSql + 
      " WHERE  ";
    strSql = strSql + ((parentKey==null || parentKey.equals(""))?"":parentKey);
    strSql = strSql + 
      "=? AND ";
    strSql = strSql + ((parentKey2==null || parentKey2.equals(""))?"":parentKey2);
    strSql = strSql + 
      "=  ";
    strSql = strSql + ((parentKey2Id==null || parentKey2Id.equals(""))?"":parentKey2Id);
    strSql = strSql + 
      ")";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (keyName != null && !(keyName.equals(""))) {
        }
      if (table != null && !(table.equals(""))) {
        }
      if (keyName != null && !(keyName.equals(""))) {
        }
      if (keyName != null && !(keyName.equals(""))) {
        }
      if (parentTable != null && !(parentTable.equals(""))) {
        }
      if (parentKey != null && !(parentKey.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentKeyId);
      if (parentKey2 != null && !(parentKey2.equals(""))) {
        }
      if (parentKey2Id != null && !(parentKey2Id.equals(""))) {
        }

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

  public static boolean isChild(ConnectionProvider connectionProvider, String initseqno, String endseqno, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) AS TOTAL " +
      "        FROM AD_TAB " +
      "        WHERE SEQNO > TO_NUMBER(?) " +
      "        AND 1=1";
    strSql = strSql + ((endseqno==null || endseqno.equals(""))?"":"  AND SEQNO < TO_NUMBER(?)  ");
    strSql = strSql + 
      "        AND AD_TAB_ID = ? ";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, initseqno);
      if (endseqno != null && !(endseqno.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, endseqno);
      }
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

  public static ReferencedLinkData[] parentsColumnName(ConnectionProvider connectionProvider, String tab, String parentTab)    throws ServletException {
    return parentsColumnName(connectionProvider, tab, parentTab, 0, 0);
  }

  public static ReferencedLinkData[] parentsColumnName(ConnectionProvider connectionProvider, String tab, String parentTab, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ColumnName AS NAME " +
      "        FROM AD_FIELD, AD_COLUMN " +
      "        WHERE AD_FIELD.ad_column_id = AD_COLUMN.ad_column_id " +
      "        AND ad_tab_id = ? AND isParent='Y' " +
      "        AND EXISTS(SELECT 1 FROM AD_COLUMN c, AD_FIELD f WHERE c.ad_column_id = f.ad_column_id AND c.iskey='Y'" +
      "        AND ad_tab_id=? AND UPPER(c.columnname) = UPPER(AD_COLUMN.columnname))";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tab);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentTab);

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
        ReferencedLinkData objectReferencedLinkData = new ReferencedLinkData();
        objectReferencedLinkData.name = UtilSql.getValue(result, "name");
        objectReferencedLinkData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReferencedLinkData);
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
    ReferencedLinkData objectReferencedLinkData[] = new ReferencedLinkData[vector.size()];
    vector.copyInto(objectReferencedLinkData);
    return(objectReferencedLinkData);
  }

  public static ReferencedLinkData[] selectTabName(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    return selectTabName(connectionProvider, adTabId, 0, 0);
  }

  public static ReferencedLinkData[] selectTabName(ConnectionProvider connectionProvider, String adTabId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT t.AD_TAB_ID, t.AD_WINDOW_ID, t.NAME AS TABNAME, w.NAME AS WINDOWNAME " +
      "      FROM AD_TAB t, AD_WINDOW w" +
      "      WHERE t.AD_Window_ID = w.AD_Window_ID " +
      "      AND t.AD_Tab_ID = ? ";

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
        ReferencedLinkData objectReferencedLinkData = new ReferencedLinkData();
        objectReferencedLinkData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectReferencedLinkData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectReferencedLinkData.tabname = UtilSql.getValue(result, "tabname");
        objectReferencedLinkData.windowname = UtilSql.getValue(result, "windowname");
        objectReferencedLinkData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReferencedLinkData);
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
    ReferencedLinkData objectReferencedLinkData[] = new ReferencedLinkData[vector.size()];
    vector.copyInto(objectReferencedLinkData);
    return(objectReferencedLinkData);
  }

  public static String getReferenceLinkTargetTab(ConnectionProvider connectionProvider, String adTableId, String currentvalue)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ad_getReferenceLinkTargetTab(?,?) from dual";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currentvalue);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_getreferencelinktargettab");
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
