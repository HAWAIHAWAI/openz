//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility.reporting.printing;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class PrintControllerData implements FieldProvider {
static Logger log4j = Logger.getLogger(PrintControllerData.class);
  private String InitRecordNumber="0";
  public String id;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PrintControllerData[] selectInvoices(ConnectionProvider connectionProvider, String Id)    throws ServletException {
    return selectInvoices(connectionProvider, Id, 0, 0);
  }

  public static PrintControllerData[] selectInvoices(ConnectionProvider connectionProvider, String Id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT C_Invoice_ID as ID" +
      "            FROM C_Invoice" +
      "            WHERE C_Invoice_ID IN (";
    strSql = strSql + ((Id==null || Id.equals(""))?"":Id);
    strSql = strSql + 
      ")" +
      "            ORDER BY DocumentNo ASC";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (Id != null && !(Id.equals(""))) {
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
        PrintControllerData objectPrintControllerData = new PrintControllerData();
        objectPrintControllerData.id = UtilSql.getValue(result, "id");
        objectPrintControllerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPrintControllerData);
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
    PrintControllerData objectPrintControllerData[] = new PrintControllerData[vector.size()];
    vector.copyInto(objectPrintControllerData);
    return(objectPrintControllerData);
  }

  public static PrintControllerData[] selectOrders(ConnectionProvider connectionProvider, String Id)    throws ServletException {
    return selectOrders(connectionProvider, Id, 0, 0);
  }

  public static PrintControllerData[] selectOrders(ConnectionProvider connectionProvider, String Id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT C_Order_ID as ID" +
      "            FROM C_Order" +
      "            WHERE C_Order_ID IN (";
    strSql = strSql + ((Id==null || Id.equals(""))?"":Id);
    strSql = strSql + 
      ")" +
      "            ORDER BY DocumentNo ASC";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (Id != null && !(Id.equals(""))) {
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
        PrintControllerData objectPrintControllerData = new PrintControllerData();
        objectPrintControllerData.id = UtilSql.getValue(result, "id");
        objectPrintControllerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPrintControllerData);
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
    PrintControllerData objectPrintControllerData[] = new PrintControllerData[vector.size()];
    vector.copyInto(objectPrintControllerData);
    return(objectPrintControllerData);
  }

  public static String GetDefaultDoctypeTempate(ConnectionProvider connectionProvider, String cDocTypeID, String adOrgID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT ad_get_defaultDocTypeTemplate(?, ?)  from dual";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDocTypeID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_get_defaultdoctypetemplate");
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

  public static String IsMultilanguage(ConnectionProvider connectionProvider, String ClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT ismultilingualdocument from ad_client" +
      "            WHERE AD_Client_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ClientId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ismultilingualdocument");
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

  public static String getDocTypeId(ConnectionProvider connectionProvider, String dummytable, String dummyfield, String DocumentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT c_doctype_id from ";
    strSql = strSql + ((dummytable==null || dummytable.equals(""))?"":dummytable);
    strSql = strSql + 
      "            WHERE ";
    strSql = strSql + ((dummyfield==null || dummyfield.equals(""))?"":dummyfield);
    strSql = strSql + 
      " = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (dummytable != null && !(dummytable.equals(""))) {
        }
      if (dummyfield != null && !(dummyfield.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DocumentId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_doctype_id");
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

  public static String getDocTypeByName(ConnectionProvider connectionProvider, String name)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT c_doctype_id from c_doctype where name = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_doctype_id");
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
