//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ws.externalSales;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ExternalSalesOrderData implements FieldProvider {
static Logger log4j = Logger.getLogger(ExternalSalesOrderData.class);
  private String InitRecordNumber="0";
  public String id;
  public String documentno;
  public String dateNew;
  public String status;
  public String cBpartnerId;
  public String cBpartnerName;
  public String bpartnervalue;
  public String amount;
  public String paymentType;
  public String orderLineId;
  public String productId;
  public String units;
  public String price;
  public String taxId;
  public String debtPaymentIdId;
  public String paymentrule;
  public String acc;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("date_new") || fieldName.equals("dateNew"))
      return dateNew;
    else if (fieldName.equalsIgnoreCase("status"))
      return status;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_name") || fieldName.equals("cBpartnerName"))
      return cBpartnerName;
    else if (fieldName.equalsIgnoreCase("bpartnervalue"))
      return bpartnervalue;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("payment_type") || fieldName.equals("paymentType"))
      return paymentType;
    else if (fieldName.equalsIgnoreCase("order_line_id") || fieldName.equals("orderLineId"))
      return orderLineId;
    else if (fieldName.equalsIgnoreCase("product_id") || fieldName.equals("productId"))
      return productId;
    else if (fieldName.equalsIgnoreCase("units"))
      return units;
    else if (fieldName.equalsIgnoreCase("price"))
      return price;
    else if (fieldName.equalsIgnoreCase("tax_id") || fieldName.equals("taxId"))
      return taxId;
    else if (fieldName.equalsIgnoreCase("debt_payment_id_id") || fieldName.equals("debtPaymentIdId"))
      return debtPaymentIdId;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("acc"))
      return acc;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ExternalSalesOrderData[] select(ConnectionProvider connectionProvider, String client, String date, String doc)    throws ServletException {
    return select(connectionProvider, client, date, doc, 0, 0);
  }

  public static ExternalSalesOrderData[] select(ConnectionProvider connectionProvider, String client, String date, String doc, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_ORDER.C_ORDER_ID AS ID, C_ORDER.DOCUMENTNO, C_ORDER.DATEORDERED AS DATE_NEW, " +
      "        C_ORDER_STATUS(C_ORDER.C_ORDER_ID) AS STATUS, " +
      "        C_BPARTNER.C_BPARTNER_ID, C_BPARTNER.NAME AS C_BPARTNER_NAME, C_BPARTNER.VALUE AS BPARTNERVALUE, " +
      "        C_ORDER.GRANDTOTAL AS AMOUNT, C_PAYMENTTERM.C_PAYMENTTERM_ID AS PAYMENT_TYPE," +
      "        '' AS ORDER_LINE_ID, '' AS PRODUCT_ID, '' AS UNITS, '' AS PRICE, '' AS TAX_ID," +
      "        '' AS DEBT_PAYMENT_ID_ID, '' AS PAYMENTRULE, '' AS ACC" +
      "        FROM C_ORDER, C_BPARTNER, C_PAYMENTTERM" +
      "        WHERE C_ORDER.AD_CLIENT_ID = ?" +
      "        AND TO_CHAR(C_ORDER.DATEORDERED, 'DD-MM-YYYY') = TO_CHAR(to_date(?,'DD-MM-YYYY HH24:MI:SS'), 'DD-MM-YYYY')" +
      "        AND C_ORDER.DOCUMENTNO = ?" +
      "        AND C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "        AND C_ORDER.C_PAYMENTTERM_ID = C_PAYMENTTERM.C_PAYMENTTERM_ID ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, doc);

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
        ExternalSalesOrderData objectExternalSalesOrderData = new ExternalSalesOrderData();
        objectExternalSalesOrderData.id = UtilSql.getValue(result, "id");
        objectExternalSalesOrderData.documentno = UtilSql.getValue(result, "documentno");
        objectExternalSalesOrderData.dateNew = UtilSql.getDateValue(result, "date_new", "dd-MM-yyyy");
        objectExternalSalesOrderData.status = UtilSql.getValue(result, "status");
        objectExternalSalesOrderData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectExternalSalesOrderData.cBpartnerName = UtilSql.getValue(result, "c_bpartner_name");
        objectExternalSalesOrderData.bpartnervalue = UtilSql.getValue(result, "bpartnervalue");
        objectExternalSalesOrderData.amount = UtilSql.getValue(result, "amount");
        objectExternalSalesOrderData.paymentType = UtilSql.getValue(result, "payment_type");
        objectExternalSalesOrderData.orderLineId = UtilSql.getValue(result, "order_line_id");
        objectExternalSalesOrderData.productId = UtilSql.getValue(result, "product_id");
        objectExternalSalesOrderData.units = UtilSql.getValue(result, "units");
        objectExternalSalesOrderData.price = UtilSql.getValue(result, "price");
        objectExternalSalesOrderData.taxId = UtilSql.getValue(result, "tax_id");
        objectExternalSalesOrderData.debtPaymentIdId = UtilSql.getValue(result, "debt_payment_id_id");
        objectExternalSalesOrderData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectExternalSalesOrderData.acc = UtilSql.getValue(result, "acc");
        objectExternalSalesOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExternalSalesOrderData);
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
    ExternalSalesOrderData objectExternalSalesOrderData[] = new ExternalSalesOrderData[vector.size()];
    vector.copyInto(objectExternalSalesOrderData);
    return(objectExternalSalesOrderData);
  }

  public static ExternalSalesOrderData[] selectLines(ConnectionProvider connectionProvider, String client, String order)    throws ServletException {
    return selectLines(connectionProvider, client, order, 0, 0);
  }

  public static ExternalSalesOrderData[] selectLines(ConnectionProvider connectionProvider, String client, String order, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_ORDERLINE_ID AS ORDER_LINE_ID, M_PRODUCT_ID AS PRODUCT_ID, QTYORDERED AS UNITS, PRICEACTUAL AS PRICE, C_TAX_ID AS TAX_ID" +
      "        FROM C_ORDERLINE" +
      "        WHERE AD_CLIENT_ID = ?" +
      "        AND C_ORDER_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, order);

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
        ExternalSalesOrderData objectExternalSalesOrderData = new ExternalSalesOrderData();
        objectExternalSalesOrderData.orderLineId = UtilSql.getValue(result, "order_line_id");
        objectExternalSalesOrderData.productId = UtilSql.getValue(result, "product_id");
        objectExternalSalesOrderData.units = UtilSql.getValue(result, "units");
        objectExternalSalesOrderData.price = UtilSql.getValue(result, "price");
        objectExternalSalesOrderData.taxId = UtilSql.getValue(result, "tax_id");
        objectExternalSalesOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExternalSalesOrderData);
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
    ExternalSalesOrderData objectExternalSalesOrderData[] = new ExternalSalesOrderData[vector.size()];
    vector.copyInto(objectExternalSalesOrderData);
    return(objectExternalSalesOrderData);
  }

  public static ExternalSalesOrderData[] selectPayment(ConnectionProvider connectionProvider, String client, String order)    throws ServletException {
    return selectPayment(connectionProvider, client, order, 0, 0);
  }

  public static ExternalSalesOrderData[] selectPayment(ConnectionProvider connectionProvider, String client, String order, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_DEBT_PAYMENT_ID AS DEBT_PAYMENT_ID_ID, AMOUNT, PAYMENTRULE" +
      "        FROM C_DEBT_PAYMENT" +
      "        WHERE AD_CLIENT_ID = ?" +
      "        AND C_ORDER_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, order);

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
        ExternalSalesOrderData objectExternalSalesOrderData = new ExternalSalesOrderData();
        objectExternalSalesOrderData.debtPaymentIdId = UtilSql.getValue(result, "debt_payment_id_id");
        objectExternalSalesOrderData.amount = UtilSql.getValue(result, "amount");
        objectExternalSalesOrderData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectExternalSalesOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExternalSalesOrderData);
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
    ExternalSalesOrderData objectExternalSalesOrderData[] = new ExternalSalesOrderData[vector.size()];
    vector.copyInto(objectExternalSalesOrderData);
    return(objectExternalSalesOrderData);
  }

  public static ExternalSalesOrderData[] selectIOrder(ConnectionProvider connectionProvider, String client, String date, String doc)    throws ServletException {
    return selectIOrder(connectionProvider, client, date, doc, 0, 0);
  }

  public static ExternalSalesOrderData[] selectIOrder(ConnectionProvider connectionProvider, String client, String date, String doc, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT '' AS ID, I_ORDER.DOCUMENTNO, I_ORDER.DATEORDERED AS DATE_NEW, " +
      "        1 AS STATUS, I_ORDER.C_BPARTNER_ID, I_ORDER.NAME AS C_BPARTNER_NAME, I_ORDER.BPARTNERVALUE AS BPARTNERVALUE " +
      "        FROM I_ORDER" +
      "        WHERE I_ORDER.AD_CLIENT_ID = ?" +
      "        AND TO_CHAR(I_ORDER.DATEORDERED, 'DD-MM-YYYY') =  TO_CHAR(to_date(?,'DD-MM-YYYY HH24:MI:SS'), 'DD-MM-YYYY')" +
      "        AND I_ORDER.DOCUMENTNO = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, doc);

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
        ExternalSalesOrderData objectExternalSalesOrderData = new ExternalSalesOrderData();
        objectExternalSalesOrderData.id = UtilSql.getValue(result, "id");
        objectExternalSalesOrderData.documentno = UtilSql.getValue(result, "documentno");
        objectExternalSalesOrderData.dateNew = UtilSql.getDateValue(result, "date_new", "dd-MM-yyyy");
        objectExternalSalesOrderData.status = UtilSql.getValue(result, "status");
        objectExternalSalesOrderData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectExternalSalesOrderData.cBpartnerName = UtilSql.getValue(result, "c_bpartner_name");
        objectExternalSalesOrderData.bpartnervalue = UtilSql.getValue(result, "bpartnervalue");
        objectExternalSalesOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExternalSalesOrderData);
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
    ExternalSalesOrderData objectExternalSalesOrderData[] = new ExternalSalesOrderData[vector.size()];
    vector.copyInto(objectExternalSalesOrderData);
    return(objectExternalSalesOrderData);
  }

  public static ExternalSalesOrderData[] selectLinesIOrder(ConnectionProvider connectionProvider, String client, String date, String doc)    throws ServletException {
    return selectLinesIOrder(connectionProvider, client, date, doc, 0, 0);
  }

  public static ExternalSalesOrderData[] selectLinesIOrder(ConnectionProvider connectionProvider, String client, String date, String doc, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT C_ORDERLINE_ID AS ORDER_LINE_ID, M_PRODUCT_ID AS PRODUCT_ID, QTYORDERED AS UNITS, PRICEACTUAL AS PRICE, C_TAX_ID AS TAX_ID" +
      "        FROM I_ORDER" +
      "        WHERE AD_CLIENT_ID = ?" +
      "        AND TO_CHAR(I_ORDER.DATEORDERED, 'DD-MM-YYYY') =  TO_CHAR(to_date(?,'DD-MM-YYYY HH24:MI:SS'), 'DD-MM-YYYY')" +
      "        AND DOCUMENTNO = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, doc);

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
        ExternalSalesOrderData objectExternalSalesOrderData = new ExternalSalesOrderData();
        objectExternalSalesOrderData.orderLineId = UtilSql.getValue(result, "order_line_id");
        objectExternalSalesOrderData.productId = UtilSql.getValue(result, "product_id");
        objectExternalSalesOrderData.units = UtilSql.getValue(result, "units");
        objectExternalSalesOrderData.price = UtilSql.getValue(result, "price");
        objectExternalSalesOrderData.taxId = UtilSql.getValue(result, "tax_id");
        objectExternalSalesOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExternalSalesOrderData);
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
    ExternalSalesOrderData objectExternalSalesOrderData[] = new ExternalSalesOrderData[vector.size()];
    vector.copyInto(objectExternalSalesOrderData);
    return(objectExternalSalesOrderData);
  }

  public static ExternalSalesOrderData[] selectPaymentIOrder(ConnectionProvider connectionProvider, String client, String date, String doc)    throws ServletException {
    return selectPaymentIOrder(connectionProvider, client, date, doc, 0, 0);
  }

  public static ExternalSalesOrderData[] selectPaymentIOrder(ConnectionProvider connectionProvider, String client, String date, String doc, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DOCUMENTNO, DATEORDERED AS DATE_NEW, PAYMENTRULE1 AS PAYMENTRULE ,PAYMENTAMOUNT1 AS AMOUNT" +
      "           FROM I_ORDER" +
      "        WHERE AD_CLIENT_ID = ?" +
      "        AND TO_CHAR(DATEORDERED, 'DD-MM-YYYY') =  TO_CHAR(to_date(?,'DD-MM-YYYY HH24:MI:SS'), 'DD-MM-YYYY')" +
      "        AND DOCUMENTNO = ?" +
      "           AND PAYMENTRULE1 IS NOT NULL" +
      "        UNION " +
      "        SELECT I_ORDER.DOCUMENTNO, I_ORDER.DATEORDERED AS DATE_NEW,PAYMENTRULE2, PAYMENTAMOUNT2 AS AMOUNT" +
      "           FROM I_ORDER" +
      "        WHERE AD_CLIENT_ID = ?" +
      "        AND TO_CHAR(DATEORDERED, 'DD-MM-YYYY') =  TO_CHAR(to_date(?,'DD-MM-YYYY HH24:MI:SS'), 'DD-MM-YYYY')" +
      "        AND DOCUMENTNO = ?" +
      "           AND PAYMENTRULE2 IS NOT NULL";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, doc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, doc);

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
        ExternalSalesOrderData objectExternalSalesOrderData = new ExternalSalesOrderData();
        objectExternalSalesOrderData.documentno = UtilSql.getValue(result, "documentno");
        objectExternalSalesOrderData.dateNew = UtilSql.getDateValue(result, "date_new", "dd-MM-yyyy");
        objectExternalSalesOrderData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectExternalSalesOrderData.amount = UtilSql.getValue(result, "amount");
        objectExternalSalesOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExternalSalesOrderData);
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
    ExternalSalesOrderData objectExternalSalesOrderData[] = new ExternalSalesOrderData[vector.size()];
    vector.copyInto(objectExternalSalesOrderData);
    return(objectExternalSalesOrderData);
  }

  public static String access(ConnectionProvider connectionProvider, String username, String password)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT COUNT(*) AS ACC" +
      "				   FROM AD_USER       U, " +
      "					      AD_USER_ROLES R," +
      "								AD_TASK_ACCESS A," +
      "								AD_TASK T" +
      "					 WHERE USERNAME = ? " +
      "             AND PASSWORD = ?" +
      "					   AND  U.AD_USER_ID = R.AD_USER_ID" +
      "						 AND A.AD_ROLE_ID = R.AD_ROLE_ID" +
      "						 AND T.AD_TASK_ID = A.AD_TASK_ID" +
      "             AND T.CLASSNAME = 'org.openbravo.erpCommon.ws.externalSales.ExternalSales'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, username);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, password);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "acc");
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
