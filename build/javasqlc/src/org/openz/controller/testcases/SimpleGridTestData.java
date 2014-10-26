//Sqlc generated V1.O00-1
package org.openz.controller.testcases;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class SimpleGridTestData implements FieldProvider {
static Logger log4j = Logger.getLogger(SimpleGridTestData.class);
  private String InitRecordNumber="0";
  public String mProductId;
  public String discontinued;
  public String value;
  public String name;
  public String pricelist;
  public String pricestd;
  public String pricelimit;
  public String qtyonhand;
  public String qtyreserved;
  public String qtyordered;
  public String qtyavailable;
  public String cUomId;
  public String cCurrencyId;
  public String position;
  public String rowKey;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("discontinued"))
      return discontinued;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("qtyonhand"))
      return qtyonhand;
    else if (fieldName.equalsIgnoreCase("qtyreserved"))
      return qtyreserved;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("qtyavailable"))
      return qtyavailable;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equals("position"))
      return position;
    else if (fieldName.equals("rowKey"))
      return rowKey;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SimpleGridTestData[] select(ConnectionProvider connectionProvider, String language, String pgLimit, String orderBy)    throws ServletException {
    return select(connectionProvider, language, pgLimit, orderBy, 0, 0);
  }

  public static SimpleGridTestData[] select(ConnectionProvider connectionProvider, String language, String pgLimit, String orderBy, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT p.M_Product_ID, p.Discontinued, p.Value, " +
      "        coalesce(ptrl.name,p.Name) as name, " +
      "        '0' AS PriceList," +
      "       '0' AS PriceStd, " +
      "       '0' AS PriceLimit," +
      "       '0' AS QtyOnHand, " +
      "       '0' AS QtyReserved, " +
      "        '0' AS QtyOrdered," +
      "        '0' AS QtyAvailable, " +
      "        '0' as C_UOM_ID, '0' as C_Currency_ID" +
      "        FROM M_Product p left join m_product_trl ptrl on ptrl.m_product_id=p.m_product_id and ptrl.ad_language=?" +
      "        AND 4=4";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":"  LIMIT " + pgLimit);
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + 
      "        ORDER BY Value";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (orderBy != null && !(orderBy.equals(""))) {
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
        SimpleGridTestData objectSimpleGridTestData = new SimpleGridTestData();
        objectSimpleGridTestData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectSimpleGridTestData.discontinued = UtilSql.getValue(result, "discontinued");
        objectSimpleGridTestData.value = UtilSql.getValue(result, "value");
        objectSimpleGridTestData.name = UtilSql.getValue(result, "name");
        objectSimpleGridTestData.pricelist = UtilSql.getValue(result, "pricelist");
        objectSimpleGridTestData.pricestd = UtilSql.getValue(result, "pricestd");
        objectSimpleGridTestData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectSimpleGridTestData.qtyonhand = UtilSql.getValue(result, "qtyonhand");
        objectSimpleGridTestData.qtyreserved = UtilSql.getValue(result, "qtyreserved");
        objectSimpleGridTestData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectSimpleGridTestData.qtyavailable = UtilSql.getValue(result, "qtyavailable");
        objectSimpleGridTestData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectSimpleGridTestData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectSimpleGridTestData.position = Long.toString(countRecord);
        objectSimpleGridTestData.rowKey = "";
        objectSimpleGridTestData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSimpleGridTestData);
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
    SimpleGridTestData objectSimpleGridTestData[] = new SimpleGridTestData[vector.size()];
    vector.copyInto(objectSimpleGridTestData);
    return(objectSimpleGridTestData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String language, String pgLimit)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT count(*) AS value FROM M_Product p left join m_product_trl ptrl on ptrl.m_product_id=p.m_product_id and ptrl.ad_language=?" +
      "      AND 4=4";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":"  LIMIT " + pgLimit);

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "value");
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
