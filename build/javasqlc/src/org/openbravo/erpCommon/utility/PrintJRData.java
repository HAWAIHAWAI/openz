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

public class PrintJRData implements FieldProvider {
static Logger log4j = Logger.getLogger(PrintJRData.class);
  private String InitRecordNumber="0";
  public String dateend;
  public String datebegin;
  public String paramname;
  public String reference;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("dateend"))
      return dateend;
    else if (fieldName.equalsIgnoreCase("datebegin"))
      return datebegin;
    else if (fieldName.equalsIgnoreCase("paramname"))
      return paramname;
    else if (fieldName.equalsIgnoreCase("reference"))
      return reference;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PrintJRData[] init(ConnectionProvider connectionProvider)    throws ServletException {
    return init(connectionProvider, 0, 0);
  }

  public static PrintJRData[] init(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     SELECT '' as dateend, '' as datebegin, '' as paramname, '' as reference from dual";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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
        PrintJRData objectPrintJRData = new PrintJRData();
        objectPrintJRData.dateend = UtilSql.getValue(result, "dateend");
        objectPrintJRData.datebegin = UtilSql.getValue(result, "datebegin");
        objectPrintJRData.paramname = UtilSql.getValue(result, "paramname");
        objectPrintJRData.reference = UtilSql.getValue(result, "reference");
        objectPrintJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPrintJRData);
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
    PrintJRData objectPrintJRData[] = new PrintJRData[vector.size()];
    vector.copyInto(objectPrintJRData);
    return(objectPrintJRData);
  }

  public static PrintJRData[] getProcessParams(ConnectionProvider connectionProvider, String adProcessId)    throws ServletException {
    return getProcessParams(connectionProvider, adProcessId, 0, 0);
  }

  public static PrintJRData[] getProcessParams(ConnectionProvider connectionProvider, String adProcessId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select columnname AS paramname, AD_Reference_ID AS reference " +
      "        FROM AD_Process_Para " +
      "        WHERE AD_Process_ID = ? ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);

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
        PrintJRData objectPrintJRData = new PrintJRData();
        objectPrintJRData.paramname = UtilSql.getValue(result, "paramname");
        objectPrintJRData.reference = UtilSql.getValue(result, "reference");
        objectPrintJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPrintJRData);
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
    PrintJRData objectPrintJRData[] = new PrintJRData[vector.size()];
    vector.copyInto(objectPrintJRData);
    return(objectPrintJRData);
  }

  public static String getReportName(ConnectionProvider connectionProvider, String adProcessId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select JRName AS paramname" +
      "        FROM AD_Process " +
      "        WHERE AD_Process_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "paramname");
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

  public static String getReportTitle(ConnectionProvider connectionProvider, String adLanguage, String adProcessId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select COALESCE(t.name, m.name) AS paramname" +
      "        FROM AD_Menu M LEFT JOIN AD_Menu_Trl t ON m.AD_Menu_ID  = t.AD_Menu_ID" +
      "                                              AND t.AD_Language = ?   " +
      "        WHERE M.AD_Process_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "paramname");
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

  public static PrintJRData[] getDates(ConnectionProvider connectionProvider, String DateFrom, String format, String DateTo)    throws ServletException {
    return getDates(connectionProvider, DateFrom, format, DateTo, 0, 0);
  }

  public static PrintJRData[] getDates(ConnectionProvider connectionProvider, String DateFrom, String format, String DateTo, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     select datebegin,dateend from c_timesegment(to_timestamp(?,?)::timestamp without time zone,to_timestamp(?,?)::timestamp without time zone)";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, format);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, format);

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
        PrintJRData objectPrintJRData = new PrintJRData();
        objectPrintJRData.datebegin = UtilSql.getDateValue(result, "datebegin", "dd-MM-yyyy");
        objectPrintJRData.dateend = UtilSql.getDateValue(result, "dateend", "dd-MM-yyyy");
        objectPrintJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPrintJRData);
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
    PrintJRData objectPrintJRData[] = new PrintJRData[vector.size()];
    vector.copyInto(objectPrintJRData);
    return(objectPrintJRData);
  }
}
