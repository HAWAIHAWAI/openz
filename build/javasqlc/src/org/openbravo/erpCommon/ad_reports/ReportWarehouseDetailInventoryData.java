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

class ReportWarehouseDetailInventoryData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportWarehouseDetailInventoryData.class);
  private String InitRecordNumber="0";
  public String inmovement;
  public String inorder;
  public String outmovement;
  public String outorder;
  public String initialmovement;
  public String initialorder;
  public String warehouse;
  public String product;
  public String uom;
  public String categoryId;
  public String outerorder;
  public String multiplyrate;
  public String outermovement;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("inmovement"))
      return inmovement;
    else if (fieldName.equalsIgnoreCase("inorder"))
      return inorder;
    else if (fieldName.equalsIgnoreCase("outmovement"))
      return outmovement;
    else if (fieldName.equalsIgnoreCase("outorder"))
      return outorder;
    else if (fieldName.equalsIgnoreCase("initialmovement"))
      return initialmovement;
    else if (fieldName.equalsIgnoreCase("initialorder"))
      return initialorder;
    else if (fieldName.equalsIgnoreCase("warehouse"))
      return warehouse;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("uom"))
      return uom;
    else if (fieldName.equalsIgnoreCase("category_id") || fieldName.equals("categoryId"))
      return categoryId;
    else if (fieldName.equalsIgnoreCase("outerorder"))
      return outerorder;
    else if (fieldName.equalsIgnoreCase("multiplyrate"))
      return multiplyrate;
    else if (fieldName.equalsIgnoreCase("outermovement"))
      return outermovement;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportWarehouseDetailInventoryData[] select(ConnectionProvider connectionProvider, String adUserClient, String adOrgClient, String parDateFrom, String parDateTo, String mWarehouseId)    throws ServletException {
    return select(connectionProvider, adUserClient, adOrgClient, parDateFrom, parDateTo, mWarehouseId, 0, 0);
  }

  public static ReportWarehouseDetailInventoryData[] select(ConnectionProvider connectionProvider, String adUserClient, String adOrgClient, String parDateFrom, String parDateTo, String mWarehouseId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT SUM(INMOVEMENT) AS INMOVEMENT, SUM(INORDER) AS INORDER, SUM(OUTMOVEMENT) AS OUTMOVEMENT, SUM(OUTORDER) AS OUTORDER, " +
      "      SUM(INITIALMOVEMENT) AS INITIALMOVEMENT, SUM(INITIALORDER) AS INITIALORDER, " +
      "      A.WAREHOUSE, A.PRODUCT, A.UOM, A.CATEGORY_ID, (SUM(INITIALORDER) + SUM(INORDER) + SUM(OUTORDER)) AS OUTERORDER, A.MULTIPLYRATE, ((SUM(INITIALORDER) + SUM(INORDER) + SUM(OUTORDER))*A.MULTIPLYRATE) AS OUTERMOVEMENT" +
      "      FROM (SELECT SUM(M_T_A.MOVEMENTQTY) AS INMOVEMENT, SUM(M_T_A.QUANTITYORDER) AS INORDER," +
      "      0 AS OUTMOVEMENT, 0 AS OUTORDER, 0 AS INITIALMOVEMENT, 0 AS INITIALORDER, " +
      "      M_WAREHOUSE.NAME AS WAREHOUSE, M_PRODUCT.NAME AS PRODUCT, C_UOM.NAME AS UOM, " +
      "      M_WAREHOUSE.M_WAREHOUSE_ID, M_PRODUCT.M_PRODUCT_ID, M_PRODUCT.M_PRODUCT_CATEGORY_ID AS CATEGORY_ID, C_UOM_CONVERSION.MULTIPLYRATE" +
      "      FROM M_TRANSACTION M_T_A, M_LOCATOR, M_WAREHOUSE, M_PRODUCT, M_PRODUCT_UOM, C_UOM, C_UOM_CONVERSION" +
      "      WHERE M_T_A.M_LOCATOR_ID = M_LOCATOR.M_LOCATOR_ID" +
      "      AND M_LOCATOR.M_WAREHOUSE_ID = M_WAREHOUSE.M_WAREHOUSE_ID" +
      "      AND M_T_A.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_T_A.M_PRODUCT_UOM_ID = M_PRODUCT_UOM.M_PRODUCT_UOM_ID" +
      "      AND M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND C_UOM.C_UOM_ID = C_UOM_CONVERSION.C_UOM_ID" +
      "      AND M_T_A.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND M_T_A.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND M_T_A.MOVEMENTDATE >= to_date(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND M_T_A.MOVEMENTDATE < to_date(?) ");
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":"  AND M_WAREHOUSE.M_WAREHOUSE_ID = ? ");
    strSql = strSql + 
      "      AND M_T_A.MOVEMENTQTY > 0" +
      "      GROUP BY M_WAREHOUSE.NAME, M_PRODUCT.NAME, C_UOM.NAME, M_WAREHOUSE.M_WAREHOUSE_ID, M_PRODUCT.M_PRODUCT_ID, " +
      "      M_PRODUCT.M_PRODUCT_CATEGORY_ID, C_UOM_CONVERSION.MULTIPLYRATE" +
      "      UNION" +
      "      SELECT 0 AS INMOVEMENT, 0 AS INORDER, SUM(M_T_B.MOVEMENTQTY) AS OUTMOVEMENT, " +
      "      SUM(M_T_B.QUANTITYORDER) AS OUTORDER, 0 AS INITIALMOVEMENT, 0 AS INITIALORDER, " +
      "      M_WAREHOUSE.NAME AS WAREHOUSE, M_PRODUCT.NAME AS PRODUCT, C_UOM.NAME AS UOM, " +
      "      M_WAREHOUSE.M_WAREHOUSE_ID, M_PRODUCT.M_PRODUCT_ID, M_PRODUCT.M_PRODUCT_CATEGORY_ID AS CATEGORY_ID, C_UOM_CONVERSION.MULTIPLYRATE" +
      "      FROM M_TRANSACTION M_T_B, M_LOCATOR, M_WAREHOUSE, M_PRODUCT, M_PRODUCT_UOM, C_UOM, C_UOM_CONVERSION" +
      "      WHERE M_T_B.M_LOCATOR_ID = M_LOCATOR.M_LOCATOR_ID" +
      "      AND M_LOCATOR.M_WAREHOUSE_ID = M_WAREHOUSE.M_WAREHOUSE_ID" +
      "      AND M_T_B.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_T_B.M_PRODUCT_UOM_ID = M_PRODUCT_UOM.M_PRODUCT_UOM_ID" +
      "      AND M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND C_UOM.C_UOM_ID = C_UOM_CONVERSION.C_UOM_ID" +
      "      AND M_T_B.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND M_T_B.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "      AND 2=2";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND M_T_B.MOVEMENTDATE >= to_date(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND M_T_B.MOVEMENTDATE < to_date(?) ");
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":"  AND M_WAREHOUSE.M_WAREHOUSE_ID = ? ");
    strSql = strSql + 
      "      AND M_T_B.MOVEMENTQTY < 0" +
      "      GROUP BY M_WAREHOUSE.NAME, M_PRODUCT.NAME, C_UOM.NAME, M_WAREHOUSE.M_WAREHOUSE_ID, M_PRODUCT.M_PRODUCT_ID, " +
      "      M_PRODUCT.M_PRODUCT_CATEGORY_ID, C_UOM_CONVERSION.MULTIPLYRATE" +
      "      UNION" +
      "      SELECT 0 AS INMOVEMENT, 0 AS INORDER, 0 AS OUTMOVEMENT, 0 AS OUTORDER, " +
      "      SUM(M_T_C.MOVEMENTQTY) AS INITIALMOVEMENT, SUM(M_T_C.QUANTITYORDER) AS INITIALORDER, " +
      "      M_WAREHOUSE.NAME AS WAREHOUSE, M_PRODUCT.NAME AS PRODUCT, C_UOM.NAME AS NAME, " +
      "      M_WAREHOUSE.M_WAREHOUSE_ID, M_PRODUCT.M_PRODUCT_ID, M_PRODUCT.M_PRODUCT_CATEGORY_ID AS CATEGORY_ID, C_UOM_CONVERSION.MULTIPLYRATE" +
      "      FROM M_TRANSACTION M_T_C, M_LOCATOR, M_WAREHOUSE, M_PRODUCT, M_PRODUCT_UOM, C_UOM, C_UOM_CONVERSION" +
      "      WHERE M_T_C.M_LOCATOR_ID = M_LOCATOR.M_LOCATOR_ID" +
      "      AND M_LOCATOR.M_WAREHOUSE_ID = M_WAREHOUSE.M_WAREHOUSE_ID" +
      "      AND M_T_C.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_T_C.M_PRODUCT_UOM_ID = M_PRODUCT_UOM.M_PRODUCT_UOM_ID" +
      "      AND M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND C_UOM.C_UOM_ID = C_UOM_CONVERSION.C_UOM_ID" +
      "      AND M_T_C.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND M_T_C.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "      AND 3=3";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND M_T_C.MOVEMENTDATE < to_date(?) ");
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":"  AND M_WAREHOUSE.M_WAREHOUSE_ID = ? ");
    strSql = strSql + 
      "      GROUP BY M_WAREHOUSE.NAME, M_PRODUCT.NAME, C_UOM.NAME, M_WAREHOUSE.M_WAREHOUSE_ID, M_PRODUCT.M_PRODUCT_ID, " +
      "      M_PRODUCT.M_PRODUCT_CATEGORY_ID, C_UOM_CONVERSION.MULTIPLYRATE) A" +
      "      GROUP BY A.PRODUCT, A.WAREHOUSE, A.UOM, A.CATEGORY_ID, A.MULTIPLYRATE" +
      "      HAVING (CASE SUM(INORDER) WHEN 0 THEN (CASE SUM(INITIALORDER) WHEN 0 THEN (CASE SUM(OUTORDER) WHEN 0 THEN (CASE (SUM(INITIALORDER)+SUM(INORDER)+SUM(OUTORDER)) WHEN 0 THEN 0 ELSE 1 END) ELSE 1 END) ELSE 1 END) ELSE 1 END)<>0";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
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
        ReportWarehouseDetailInventoryData objectReportWarehouseDetailInventoryData = new ReportWarehouseDetailInventoryData();
        objectReportWarehouseDetailInventoryData.inmovement = UtilSql.getValue(result, "inmovement");
        objectReportWarehouseDetailInventoryData.inorder = UtilSql.getValue(result, "inorder");
        objectReportWarehouseDetailInventoryData.outmovement = UtilSql.getValue(result, "outmovement");
        objectReportWarehouseDetailInventoryData.outorder = UtilSql.getValue(result, "outorder");
        objectReportWarehouseDetailInventoryData.initialmovement = UtilSql.getValue(result, "initialmovement");
        objectReportWarehouseDetailInventoryData.initialorder = UtilSql.getValue(result, "initialorder");
        objectReportWarehouseDetailInventoryData.warehouse = UtilSql.getValue(result, "warehouse");
        objectReportWarehouseDetailInventoryData.product = UtilSql.getValue(result, "product");
        objectReportWarehouseDetailInventoryData.uom = UtilSql.getValue(result, "uom");
        objectReportWarehouseDetailInventoryData.categoryId = UtilSql.getValue(result, "category_id");
        objectReportWarehouseDetailInventoryData.outerorder = UtilSql.getValue(result, "outerorder");
        objectReportWarehouseDetailInventoryData.multiplyrate = UtilSql.getValue(result, "multiplyrate");
        objectReportWarehouseDetailInventoryData.outermovement = UtilSql.getValue(result, "outermovement");
        objectReportWarehouseDetailInventoryData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportWarehouseDetailInventoryData);
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
    ReportWarehouseDetailInventoryData objectReportWarehouseDetailInventoryData[] = new ReportWarehouseDetailInventoryData[vector.size()];
    vector.copyInto(objectReportWarehouseDetailInventoryData);
    return(objectReportWarehouseDetailInventoryData);
  }

  public static ReportWarehouseDetailInventoryData[] set()    throws ServletException {
    ReportWarehouseDetailInventoryData objectReportWarehouseDetailInventoryData[] = new ReportWarehouseDetailInventoryData[1];
    objectReportWarehouseDetailInventoryData[0] = new ReportWarehouseDetailInventoryData();
    objectReportWarehouseDetailInventoryData[0].inmovement = "";
    objectReportWarehouseDetailInventoryData[0].inorder = "";
    objectReportWarehouseDetailInventoryData[0].outmovement = "";
    objectReportWarehouseDetailInventoryData[0].outorder = "";
    objectReportWarehouseDetailInventoryData[0].initialmovement = "";
    objectReportWarehouseDetailInventoryData[0].initialorder = "";
    objectReportWarehouseDetailInventoryData[0].warehouse = "";
    objectReportWarehouseDetailInventoryData[0].product = "";
    objectReportWarehouseDetailInventoryData[0].uom = "";
    objectReportWarehouseDetailInventoryData[0].categoryId = "";
    objectReportWarehouseDetailInventoryData[0].outerorder = "";
    objectReportWarehouseDetailInventoryData[0].multiplyrate = "";
    objectReportWarehouseDetailInventoryData[0].outermovement = "";
    return objectReportWarehouseDetailInventoryData;
  }
}
