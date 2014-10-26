//Sqlc generated V1.O00-1
package org.zsoft.ecommerce.order;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class OrderData implements FieldProvider {
static Logger log4j = Logger.getLogger(OrderData.class);
  private String InitRecordNumber="0";
  public String cOrderId;
  public String documentno;
  public String docstatus;
  public String isdelivered;
  public String isinvoiced;
  public String cBpartnerId;
  public String paymentrule;
  public String deliveryviarule;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("isdelivered"))
      return isdelivered;
    else if (fieldName.equalsIgnoreCase("isinvoiced"))
      return isinvoiced;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static OrderData[] select(ConnectionProvider connectionProvider, String OrderId)    throws ServletException {
    return select(connectionProvider, OrderId, 0, 0);
  }

  public static OrderData[] select(ConnectionProvider connectionProvider, String OrderId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "              select c_order_id,documentno,docstatus,isdelivered,isinvoiced,c_bpartner_id,paymentrule,deliveryviarule from c_order" +
      "                        where c_order_id=?        ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, OrderId);

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
        OrderData objectOrderData = new OrderData();
        objectOrderData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectOrderData.documentno = UtilSql.getValue(result, "documentno");
        objectOrderData.docstatus = UtilSql.getValue(result, "docstatus");
        objectOrderData.isdelivered = UtilSql.getValue(result, "isdelivered");
        objectOrderData.isinvoiced = UtilSql.getValue(result, "isinvoiced");
        objectOrderData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectOrderData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectOrderData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOrderData);
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
    OrderData objectOrderData[] = new OrderData[vector.size()];
    vector.copyInto(objectOrderData);
    return(objectOrderData);
  }

  public static String InsertOrderHeader(Connection conn, ConnectionProvider connectionProvider, String OrgId, String adUser, String customerId, String paymentrule, String deliveryviarule, String locationId, String customerContactId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                SELECT zsse_createOrderHeader(?,?,?,?,?,?,?) FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, OrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, customerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, locationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, customerContactId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zsse_createorderheader");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String InsertOrderLine(Connection conn, ConnectionProvider connectionProvider, String OrderId, String ProductId, String qty, String price, String description)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                SELECT zsse_createOrderLine(?,?,?,?,?) FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, OrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, price);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zsse_createorderline");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String CommitOrder(Connection conn, ConnectionProvider connectionProvider, String OrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                SELECT zsse_commitOrder(?) FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, OrderId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zsse_commitorder");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }
}
