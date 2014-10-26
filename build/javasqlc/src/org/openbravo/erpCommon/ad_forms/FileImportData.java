//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class FileImportData implements FieldProvider {
static Logger log4j = Logger.getLogger(FileImportData.class);
  private String InitRecordNumber="0";
  public String seqno;
  public String columnname;
  public String startno;
  public String endno;
  public String datatype;
  public String fieldlength;
  public String dataformat;
  public String decimalpoint;
  public String divideby100;
  public String constantvalue;
  public String callout;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("columnname"))
      return columnname;
    else if (fieldName.equalsIgnoreCase("startno"))
      return startno;
    else if (fieldName.equalsIgnoreCase("endno"))
      return endno;
    else if (fieldName.equalsIgnoreCase("datatype"))
      return datatype;
    else if (fieldName.equalsIgnoreCase("fieldlength"))
      return fieldlength;
    else if (fieldName.equalsIgnoreCase("dataformat"))
      return dataformat;
    else if (fieldName.equalsIgnoreCase("decimalpoint"))
      return decimalpoint;
    else if (fieldName.equalsIgnoreCase("divideby100"))
      return divideby100;
    else if (fieldName.equalsIgnoreCase("constantvalue"))
      return constantvalue;
    else if (fieldName.equalsIgnoreCase("callout"))
      return callout;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static FileImportData[] select(ConnectionProvider connectionProvider, String adImpformatId)    throws ServletException {
    return select(connectionProvider, adImpformatId, 0, 0);
  }

  public static FileImportData[] select(ConnectionProvider connectionProvider, String adImpformatId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT f.SeqNo,c.ColumnName,f.StartNo,f.EndNo,f.DataType,c.FieldLength," +
      "        f.DataFormat,f.DecimalPoint,f.DivideBy100,f.ConstantValue,f.Callout, f.Name" +
      "        FROM AD_ImpFormat_Row f,AD_Column c" +
      "        WHERE AD_ImpFormat_ID = ?" +
      "        AND f.AD_Column_ID=c.AD_Column_ID" +
      "        ORDER BY SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImpformatId);

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
        FileImportData objectFileImportData = new FileImportData();
        objectFileImportData.seqno = UtilSql.getValue(result, "seqno");
        objectFileImportData.columnname = UtilSql.getValue(result, "columnname");
        objectFileImportData.startno = UtilSql.getValue(result, "startno");
        objectFileImportData.endno = UtilSql.getValue(result, "endno");
        objectFileImportData.datatype = UtilSql.getValue(result, "datatype");
        objectFileImportData.fieldlength = UtilSql.getValue(result, "fieldlength");
        objectFileImportData.dataformat = UtilSql.getValue(result, "dataformat");
        objectFileImportData.decimalpoint = UtilSql.getValue(result, "decimalpoint");
        objectFileImportData.divideby100 = UtilSql.getValue(result, "divideby100");
        objectFileImportData.constantvalue = UtilSql.getValue(result, "constantvalue");
        objectFileImportData.callout = UtilSql.getValue(result, "callout");
        objectFileImportData.name = UtilSql.getValue(result, "name");
        objectFileImportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFileImportData);
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
    FileImportData objectFileImportData[] = new FileImportData[vector.size()];
    vector.copyInto(objectFileImportData);
    return(objectFileImportData);
  }

  public static FileImportData[] set()    throws ServletException {
    FileImportData objectFileImportData[] = new FileImportData[1];
    objectFileImportData[0] = new FileImportData();
    objectFileImportData[0].seqno = "";
    objectFileImportData[0].columnname = "";
    objectFileImportData[0].startno = "";
    objectFileImportData[0].endno = "";
    objectFileImportData[0].datatype = "";
    objectFileImportData[0].fieldlength = "";
    objectFileImportData[0].dataformat = "";
    objectFileImportData[0].decimalpoint = "";
    objectFileImportData[0].divideby100 = "";
    objectFileImportData[0].constantvalue = "";
    objectFileImportData[0].callout = "";
    objectFileImportData[0].name = "";
    return objectFileImportData;
  }

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String tableName, String fieldId, String valueId, String client, String org, String user)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO ";
    strSql = strSql + ((tableName==null || tableName.equals(""))?"":tableName);
    strSql = strSql + 
      " (";
    strSql = strSql + ((fieldId==null || fieldId.equals(""))?"":fieldId);
    strSql = strSql + 
      ", ad_client_id, ad_org_id, created, createdby, updated, updatedby)" +
      "        VALUES(?, ?, ?, now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      if (tableName != null && !(tableName.equals(""))) {
        }
      if (fieldId != null && !(fieldId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, valueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);

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

  public static int update(Connection conn, ConnectionProvider connectionProvider, String tableName, String fields, String values)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE ";
    strSql = strSql + ((tableName==null || tableName.equals(""))?"":tableName);
    strSql = strSql + 
      " SET ";
    strSql = strSql + ((fields==null || fields.equals(""))?"":fields);
    strSql = strSql + 
      "        WHERE ";
    strSql = strSql + ((values==null || values.equals(""))?"":values);

    int updateCount = 0;
    Statement st = null;

    try {
    st = connectionProvider.getStatement(conn);
      if (tableName != null && !(tableName.equals(""))) {
        }
      if (fields != null && !(fields.equals(""))) {
        }
      if (values != null && !(values.equals(""))) {
        }

      updateCount = st.executeUpdate(strSql);
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static String table(ConnectionProvider connectionProvider, String adImpformatId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT t.TableName" +
      "      FROM AD_Table t" +
      "      WHERE t.AD_Table_ID in (SELECT ad_table_id FROM AD_ImpFormat WHERE ad_impformat_id = ?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImpformatId);

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

  public static String keyColumn(ConnectionProvider connectionProvider, String adImpformatId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT c.ColumnName" +
      "      FROM AD_Table t, AD_Column c " +
      "      WHERE t.AD_Table_ID=c.AD_Table_ID " +
      "      AND c.IsKey='Y' " +
      "      and t.AD_Table_ID in (SELECT ad_table_id FROM AD_ImpFormat WHERE ad_impformat_id = ?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImpformatId);

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

  public static String parse(ConnectionProvider connectionProvider, String text, String length)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select substr(to_char(?),to_number(0), to_number(?)) AS FIELD from dual";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, length);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "field");
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

  public static String parseDate(ConnectionProvider connectionProvider, String text, String format)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select to_char(to_date(?, 'dd/mm/yyyy hh24:mi:ss'), ?) AS FIELD from dual";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, format);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "field");
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

  public static String selectSeparator(ConnectionProvider connectionProvider, String impFormat)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT FORMATTYPE FROM AD_IMPFORMAT" +
      "      WHERE AD_IMPFORMAT_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, impFormat);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "formattype");
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

  public static String countrows(ConnectionProvider connectionProvider, String adImpformatId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT count(*)  " +
      "      FROM AD_ImpFormat_row WHERE ad_impformat_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImpformatId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static String zsdv_insertDatevImport_01(ConnectionProvider connectionProvider, String impFileName)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zsdv_insertDatevImport_01(?) AS plresult FROM dual";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, impFileName);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "plresult");
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

  public static String zsdv_insertDatevImport_02(ConnectionProvider connectionProvider, String impFileName)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zsdv_insertDatevImport_02(?) AS plresult FROM dual";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, impFileName);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "plresult");
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

  public static String zsdv_insertDatevImport_03(ConnectionProvider connectionProvider, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zsdv_insertDatevImport_03(?) AS plresult FROM dual";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "plresult");
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
