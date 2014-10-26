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

class ReportInventoryData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportInventoryData.class);
  private String InitRecordNumber="0";
  public String mLocatorId;
  public String locator;
  public String mProductId;
  public String product;
  public String productQty;
  public String cUomId;
  public String productUom;
  public String mProductUomId;
  public String orderUom;
  public String orderQty;
  public String lot;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("locator"))
      return locator;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("product_qty") || fieldName.equals("productQty"))
      return productQty;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("product_uom") || fieldName.equals("productUom"))
      return productUom;
    else if (fieldName.equalsIgnoreCase("m_product_uom_id") || fieldName.equals("mProductUomId"))
      return mProductUomId;
    else if (fieldName.equalsIgnoreCase("order_uom") || fieldName.equals("orderUom"))
      return orderUom;
    else if (fieldName.equalsIgnoreCase("order_qty") || fieldName.equals("orderQty"))
      return orderQty;
    else if (fieldName.equalsIgnoreCase("lot"))
      return lot;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportInventoryData[] select(ConnectionProvider connectionProvider, String mProductId, String mProductUom, String mLocatorId, String adClientId, String adOrgId)    throws ServletException {
    return select(connectionProvider, mProductId, mProductUom, mLocatorId, adClientId, adOrgId, 0, 0);
  }

  public static ReportInventoryData[] select(ConnectionProvider connectionProvider, String mProductId, String mProductUom, String mLocatorId, String adClientId, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT T.M_LOCATOR_ID, M.VALUE AS LOCATOR, T.M_PRODUCT_ID, P.NAME AS PRODUCT, " +
      "      ROUND(SUM(T.QTYONHAND), 2) AS PRODUCT_QTY, T.C_UOM_ID, C1.NAME AS PRODUCT_UOM, " +
      "      T.M_PRODUCT_UOM_ID, C2.NAME AS ORDER_UOM, " +
      "      ROUND(SUM(T.QTYORDERONHAND), 2) AS ORDER_QTY, " +
      "      ATT.DESCRIPTION AS LOT" +
      "      FROM M_STORAGE_DETAIL T left join M_ATTRIBUTESETINSTANCE ATT on T.M_ATTRIBUTESETINSTANCE_ID = ATT.M_ATTRIBUTESETINSTANCE_ID " +
      "                              right join M_PRODUCT_UOM P_UOM        on T.M_PRODUCT_UOM_ID = P_UOM.M_PRODUCT_UOM_ID " +
      "                              left join C_UOM C2                   on P_UOM.C_UOM_ID = C2.C_UOM_ID," +
      "           M_LOCATOR M, M_PRODUCT P,  C_UOM C1" +
      "      WHERE T.M_PRODUCT_ID = ? " +
      "      AND T.M_PRODUCT_ID = P.M_PRODUCT_ID " +
      "      AND T.M_LOCATOR_ID = M.M_LOCATOR_ID " +
      "      AND T.C_UOM_ID = C1.C_UOM_ID " +
      "      AND COALESCE(C1.C_UOM_ID,'0') = COALESCE(?, '0')" +
      "      AND T.M_LOCATOR_ID = ? " +
      "      AND T.AD_CLIENT_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ") " +
      "      AND T.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ") " +
      "      AND 1=1" +
      "      AND ROUND(T.QTYONHAND, 2) <> 0 " +
      "      GROUP BY T.M_LOCATOR_ID, M.VALUE, T.M_PRODUCT_ID, P.NAME, T.C_UOM_ID, C1.NAME, T.M_PRODUCT_UOM_ID, C2.NAME, ATT.DESCRIPTION" +
      "      ORDER BY M.VALUE, P.NAME , ATT.DESCRIPTION ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
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
        ReportInventoryData objectReportInventoryData = new ReportInventoryData();
        objectReportInventoryData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectReportInventoryData.locator = UtilSql.getValue(result, "locator");
        objectReportInventoryData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectReportInventoryData.product = UtilSql.getValue(result, "product");
        objectReportInventoryData.productQty = UtilSql.getValue(result, "product_qty");
        objectReportInventoryData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectReportInventoryData.productUom = UtilSql.getValue(result, "product_uom");
        objectReportInventoryData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectReportInventoryData.orderUom = UtilSql.getValue(result, "order_uom");
        objectReportInventoryData.orderQty = UtilSql.getValue(result, "order_qty");
        objectReportInventoryData.lot = UtilSql.getValue(result, "lot");
        objectReportInventoryData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInventoryData);
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
    ReportInventoryData objectReportInventoryData[] = new ReportInventoryData[vector.size()];
    vector.copyInto(objectReportInventoryData);
    return(objectReportInventoryData);
  }

  public static ReportInventoryData[] selectSinDetalle(ConnectionProvider connectionProvider, String mWarehouseId, String adClientId, String adOrgId)    throws ServletException {
    return selectSinDetalle(connectionProvider, mWarehouseId, adClientId, adOrgId, 0, 0);
  }

  public static ReportInventoryData[] selectSinDetalle(ConnectionProvider connectionProvider, String mWarehouseId, String adClientId, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT  T.M_LOCATOR_ID, M.VALUE AS LOCATOR, T.M_PRODUCT_ID, P.NAME AS PRODUCT, " +
      "      ROUND(SUM(T.QTYONHAND), 2) AS PRODUCT_QTY, T.C_UOM_ID, C1.NAME AS PRODUCT_UOM, " +
      "      T.M_PRODUCT_UOM_ID, C2.NAME AS ORDER_UOM, " +
      "      ROUND(SUM(T.QTYORDERONHAND), 2) AS ORDER_QTY " +
      "      FROM M_PRODUCT_UOM P_UOM left join C_UOM C2 on P_UOM.C_UOM_ID = C2.C_UOM_ID " +
      "                               right join M_STORAGE_DETAIL T on T.M_PRODUCT_UOM_ID = P_UOM.M_PRODUCT_UOM_ID," +
      "           M_LOCATOR M, M_WAREHOUSE MW, M_PRODUCT P,  C_UOM C1" +
      "      WHERE ";
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":"  MW.M_WAREHOUSE_ID = ? AND  ");
    strSql = strSql + 
      "T.M_PRODUCT_ID = P.M_PRODUCT_ID " +
      "      AND T.M_LOCATOR_ID = M.M_LOCATOR_ID " +
      "      AND MW.M_WAREHOUSE_ID = M.M_WAREHOUSE_ID" +
      "      AND T.C_UOM_ID = C1.C_UOM_ID " +
      "      AND T.AD_CLIENT_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ") " +
      "      AND T.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ") " +
      "      AND (ROUND(T.QTYONHAND, 2) <> 0 OR ROUND(T.QTYORDERONHAND, 2) <> 0)" +
      "      GROUP BY T.M_LOCATOR_ID, M.VALUE, T.M_PRODUCT_ID, P.NAME, T.C_UOM_ID, C1.NAME, T.M_PRODUCT_UOM_ID, C2.NAME" +
      "      ORDER BY LOCATOR, PRODUCT";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
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
        ReportInventoryData objectReportInventoryData = new ReportInventoryData();
        objectReportInventoryData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectReportInventoryData.locator = UtilSql.getValue(result, "locator");
        objectReportInventoryData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectReportInventoryData.product = UtilSql.getValue(result, "product");
        objectReportInventoryData.productQty = UtilSql.getValue(result, "product_qty");
        objectReportInventoryData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectReportInventoryData.productUom = UtilSql.getValue(result, "product_uom");
        objectReportInventoryData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectReportInventoryData.orderUom = UtilSql.getValue(result, "order_uom");
        objectReportInventoryData.orderQty = UtilSql.getValue(result, "order_qty");
        objectReportInventoryData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInventoryData);
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
    ReportInventoryData objectReportInventoryData[] = new ReportInventoryData[vector.size()];
    vector.copyInto(objectReportInventoryData);
    return(objectReportInventoryData);
  }

  public static ReportInventoryData[] set()    throws ServletException {
    ReportInventoryData objectReportInventoryData[] = new ReportInventoryData[1];
    objectReportInventoryData[0] = new ReportInventoryData();
    objectReportInventoryData[0].mLocatorId = "";
    objectReportInventoryData[0].locator = "";
    objectReportInventoryData[0].mProductId = "";
    objectReportInventoryData[0].product = "";
    objectReportInventoryData[0].productQty = "";
    objectReportInventoryData[0].cUomId = "";
    objectReportInventoryData[0].productUom = "";
    objectReportInventoryData[0].mProductUomId = "";
    objectReportInventoryData[0].orderUom = "";
    objectReportInventoryData[0].orderQty = "";
    return objectReportInventoryData;
  }

  public static String warehouseDescription(ConnectionProvider connectionProvider, String mLocatorId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT VALUE FROM M_WAREHOUSE" +
      "    WHERE M_WAREHOUSE_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);

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
