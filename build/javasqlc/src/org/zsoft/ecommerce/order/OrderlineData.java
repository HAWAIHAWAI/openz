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

class OrderlineData implements FieldProvider {
static Logger log4j = Logger.getLogger(OrderlineData.class);
  private String InitRecordNumber="0";
  public String cOrderlineId;
  public String cOrderId;
  public String line;
  public String datepromised;
  public String datedelivered;
  public String dateinvoiced;
  public String description;
  public String mProductId;
  public String qtyordered;
  public String qtydelivered;
  public String qtyinvoiced;
  public String priceactual;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("datedelivered"))
      return datedelivered;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("qtydelivered"))
      return qtydelivered;
    else if (fieldName.equalsIgnoreCase("qtyinvoiced"))
      return qtyinvoiced;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static OrderlineData[] select(ConnectionProvider connectionProvider, String OrderId)    throws ServletException {
    return select(connectionProvider, OrderId, 0, 0);
  }

  public static OrderlineData[] select(ConnectionProvider connectionProvider, String OrderId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "              select c_orderline_id,c_order_id," +
      "                       coalesce(line,0) as line," +
      "                       datepromised," +
      "                       datedelivered," +
      "                       dateinvoiced," +
      "                       description," +
      "                       m_product_id," +
      "                       coalesce(qtyordered,0) as qtyordered," +
      "                       coalesce(qtydelivered,0) as qtydelivered," +
      "                       coalesce(qtyinvoiced,0) as qtyinvoiced," +
      "                       coalesce(priceactual,0) as priceactual" +
      "                       from c_orderline" +
      "                       where c_order_id=?            ";

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
        OrderlineData objectOrderlineData = new OrderlineData();
        objectOrderlineData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectOrderlineData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectOrderlineData.line = UtilSql.getValue(result, "line");
        objectOrderlineData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectOrderlineData.datedelivered = UtilSql.getDateValue(result, "datedelivered", "dd-MM-yyyy");
        objectOrderlineData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectOrderlineData.description = UtilSql.getValue(result, "description");
        objectOrderlineData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectOrderlineData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectOrderlineData.qtydelivered = UtilSql.getValue(result, "qtydelivered");
        objectOrderlineData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectOrderlineData.priceactual = UtilSql.getValue(result, "priceactual");
        objectOrderlineData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOrderlineData);
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
    OrderlineData objectOrderlineData[] = new OrderlineData[vector.size()];
    vector.copyInto(objectOrderlineData);
    return(objectOrderlineData);
  }
}
