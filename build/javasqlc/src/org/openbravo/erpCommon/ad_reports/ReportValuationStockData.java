//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ReportValuationStockData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportValuationStockData.class);
  private String InitRecordNumber="0";
  public String categoryName;
  public String mProductId;
  public String productName;
  public String qty;
  public String uomName;
  public String averageCost;
  public String totalCost;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("category_name") || fieldName.equals("categoryName"))
      return categoryName;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("product_name") || fieldName.equals("productName"))
      return productName;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("uom_name") || fieldName.equals("uomName"))
      return uomName;
    else if (fieldName.equalsIgnoreCase("average_cost") || fieldName.equals("averageCost"))
      return averageCost;
    else if (fieldName.equalsIgnoreCase("total_cost") || fieldName.equals("totalCost"))
      return totalCost;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportValuationStockData[] select(ConnectionProvider connectionProvider, String adLanguage, String date, String cCurrencyBase, String cCurrencyConv, String datePlus, String warehouse, String categoryProduct)    throws ServletException {
    return select(connectionProvider, adLanguage, date, cCurrencyBase, cCurrencyConv, datePlus, warehouse, categoryProduct, 0, 0);
  }

  public static ReportValuationStockData[] select(ConnectionProvider connectionProvider, String adLanguage, String date, String cCurrencyBase, String cCurrencyConv, String datePlus, String warehouse, String categoryProduct, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT CATEGORY_NAME, M_PRODUCT_ID, PRODUCT_NAME, QTY, UOM_NAME, AVERAGE_COST, TOTAL_COST FROM (" +
      "      SELECT M_PRODUCT_CATEGORY.NAME AS CATEGORY_NAME, A.M_PRODUCT_ID, AD_COLUMN_IDENTIFIER(TO_CHAR('M_Product'), TO_CHAR(M_PRODUCT.M_PRODUCT_ID), TO_CHAR(?)) AS PRODUCT_NAME, " +
      "      A.QTY, C_UOM.NAME AS UOM_NAME, " +
      "      C_CURRENCY_CONVERT(M_GET_PRODUCT_COST(A.M_PRODUCT_ID,TO_DATE(?), NULL,A.AD_ORG_ID), ?, ?, COALESCE(MC.DATEFROM,TO_DATE(?)), NULL, MC.AD_CLIENT_ID, A.AD_ORG_ID) AS AVERAGE_COST,       " +
      "	  A.QTY * C_CURRENCY_CONVERT(M_GET_PRODUCT_COST(A.M_PRODUCT_ID,TO_DATE(?), NULL,A.AD_ORG_ID), ?, ?, COALESCE(MC.DATEFROM,TO_DATE(?)), NULL, MC.AD_CLIENT_ID, A.AD_ORG_ID) AS TOTAL_COST" +
      "      FROM M_PRODUCT_CATEGORY," +
      "      (SELECT M_PRODUCT_ID, MAX(M_TRANSACTION.AD_ORG_ID) as ad_org_id,SUM(MOVEMENTQTY) AS QTY, C_UOM_ID FROM M_TRANSACTION, M_LOCATOR" +
      "      WHERE M_TRANSACTION.M_LOCATOR_ID = M_LOCATOR.M_LOCATOR_ID" +
      "      AND MOVEMENTDATE < to_date(?)" +
      "      AND M_LOCATOR.M_WAREHOUSE_ID = ?" +
      "      GROUP BY M_PRODUCT_ID, C_UOM_ID) A, C_UOM," +
      "      M_PRODUCT LEFT JOIN M_COSTING MC ON MC.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      WHERE A.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND A.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "      AND 1=1";
    strSql = strSql + ((categoryProduct==null || categoryProduct.equals(""))?"":"  AND M_PRODUCT.M_PRODUCT_CATEGORY_ID= ?  ");
    strSql = strSql + 
      "      AND A.QTY <>0) ZZ" +
      "      GROUP BY M_PRODUCT_ID, CATEGORY_NAME , PRODUCT_NAME, QTY, UOM_NAME, AVERAGE_COST, TOTAL_COST" +
      "      ORDER BY CATEGORY_NAME, PRODUCT_NAME";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      if (categoryProduct != null && !(categoryProduct.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, categoryProduct);
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
        ReportValuationStockData objectReportValuationStockData = new ReportValuationStockData();
        objectReportValuationStockData.categoryName = UtilSql.getValue(result, "category_name");
        objectReportValuationStockData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectReportValuationStockData.productName = UtilSql.getValue(result, "product_name");
        objectReportValuationStockData.qty = UtilSql.getValue(result, "qty");
        objectReportValuationStockData.uomName = UtilSql.getValue(result, "uom_name");
        objectReportValuationStockData.averageCost = UtilSql.getValue(result, "average_cost");
        objectReportValuationStockData.totalCost = UtilSql.getValue(result, "total_cost");
        objectReportValuationStockData.rownum = Long.toString(countRecord);
        objectReportValuationStockData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportValuationStockData);
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
    ReportValuationStockData objectReportValuationStockData[] = new ReportValuationStockData[vector.size()];
    vector.copyInto(objectReportValuationStockData);
    return(objectReportValuationStockData);
  }

  public static ReportValuationStockData[] set()    throws ServletException {
    ReportValuationStockData objectReportValuationStockData[] = new ReportValuationStockData[1];
    objectReportValuationStockData[0] = new ReportValuationStockData();
    objectReportValuationStockData[0].categoryName = "";
    objectReportValuationStockData[0].mProductId = "";
    objectReportValuationStockData[0].productName = "";
    objectReportValuationStockData[0].qty = "";
    objectReportValuationStockData[0].uomName = "";
    objectReportValuationStockData[0].averageCost = "";
    objectReportValuationStockData[0].totalCost = "";
    return objectReportValuationStockData;
  }
}
