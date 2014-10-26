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

class ExternalSalesProductData implements FieldProvider {
static Logger log4j = Logger.getLogger(ExternalSalesProductData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;
  public String number1;
  public String description;
  public String listPrice;
  public String purchasePrice;
  public String taxId;
  public String taxName;
  public String percentage;
  public String imageUrl;
  public String ean;
  public String mProductCategoryId;
  public String mProductCategoryName;
  public String mProductCategoryDescription;
  public String qtyonhand;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("number1"))
      return number1;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("list_price") || fieldName.equals("listPrice"))
      return listPrice;
    else if (fieldName.equalsIgnoreCase("purchase_price") || fieldName.equals("purchasePrice"))
      return purchasePrice;
    else if (fieldName.equalsIgnoreCase("tax_id") || fieldName.equals("taxId"))
      return taxId;
    else if (fieldName.equalsIgnoreCase("tax_name") || fieldName.equals("taxName"))
      return taxName;
    else if (fieldName.equalsIgnoreCase("percentage"))
      return percentage;
    else if (fieldName.equalsIgnoreCase("image_url") || fieldName.equals("imageUrl"))
      return imageUrl;
    else if (fieldName.equalsIgnoreCase("ean"))
      return ean;
    else if (fieldName.equalsIgnoreCase("m_product_category_id") || fieldName.equals("mProductCategoryId"))
      return mProductCategoryId;
    else if (fieldName.equalsIgnoreCase("m_product_category_name") || fieldName.equals("mProductCategoryName"))
      return mProductCategoryName;
    else if (fieldName.equalsIgnoreCase("m_product_category_description") || fieldName.equals("mProductCategoryDescription"))
      return mProductCategoryDescription;
    else if (fieldName.equalsIgnoreCase("qtyonhand"))
      return qtyonhand;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ExternalSalesProductData[] select(ConnectionProvider connectionProvider, String client, String salesChannel, String organizationId)    throws ServletException {
    return select(connectionProvider, client, salesChannel, organizationId, 0, 0);
  }

  public static ExternalSalesProductData[] select(ConnectionProvider connectionProvider, String client, String salesChannel, String organizationId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_PRODUCT.M_PRODUCT_ID AS ID, M_PRODUCT.NAME AS NAME," +
      "        M_PRODUCT.VALUE AS NUMBER1, M_PRODUCT.DESCRIPTION AS DESCRIPTION, " +
      "        M_PRODUCTPRICE.PRICESTD AS LIST_PRICE, COALESCE(M_Get_Purchase_Price(M_PRODUCT.M_PRODUCT_ID),0) AS PURCHASE_PRICE, " +
      "        C_TAX.C_TAX_ID AS TAX_ID, C_TAX.NAME AS TAX_NAME, C_TAX.RATE AS PERCENTAGE," +
      "        M_PRODUCT.IMAGEURL AS IMAGE_URL, M_PRODUCT.UPC AS EAN, " +
      "        M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID AS M_PRODUCT_CATEGORY_ID, M_PRODUCT_CATEGORY.NAME AS M_PRODUCT_CATEGORY_NAME, " +
      "        M_PRODUCT_CATEGORY.DESCRIPTION AS M_PRODUCT_CATEGORY_DESCRIPTION," +
      "				(SELECT SUM(S.QTYONHAND)" +
      "						FROM M_STORAGE_DETAIL S, M_LOCATOR L" +
      "						WHERE S.M_LOCATOR_ID = L.M_LOCATOR_ID" +
      "						AND S.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID AND L.M_WAREHOUSE_ID = CEPOS.M_WAREHOUSE_ID) AS QTYONHAND        " +
      "        FROM C_EXTERNALPOS CEPOS, M_PRODUCT, M_PRODUCT_CATEGORY, C_TAX,  M_PRODUCTPRICE" +
      "        WHERE CEPOS.AD_CLIENT_ID = ?" +
      "        AND CEPOS.VALUE = ?" +
      "        AND CEPOS.AD_ORG_ID = ?" +
      "        AND CEPOS.AD_ORG_ID = ?" +
      "        AND CEPOS.ISACTIVE = 'Y'" +
      "        AND C_TAX.C_TAX_ID = M_PRODUCT.C_TAX_ID" +
      "        AND M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "        AND M_PRODUCTPRICE.AD_CLIENT_ID= CEPOS.AD_CLIENT_ID " +
      "        AND M_PRODUCTPRICE.ISACTIVE = 'Y'" +
      "        AND M_PRODUCTPRICE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "        AND M_PRODUCTPRICE.M_PRICELIST_VERSION_ID = M_Get_Pricelist_Version(CEPOS.M_PRICELIST_ID, TO_DATE(now()))" +
      "        AND ((COALESCE(CEPOS.INCLUDE_PRODUCT_CATEGORY,'Y') = 'N' " +
      "              AND EXISTS (SELECT 1 FROM C_EXTERNALPOS_CATEGORY CEPOS_CAT" +
      "                          WHERE CEPOS_CAT.C_EXTERNALPOS_ID = CEPOS.C_EXTERNALPOS_ID" +
      "                          AND CEPOS_CAT.M_PRODUCT_CATEGORY_ID = M_PRODUCT.M_PRODUCT_CATEGORY_ID)) OR " +
      "             (COALESCE(CEPOS.INCLUDE_PRODUCT_CATEGORY,'Y') = 'Y' " +
      "             AND NOT EXISTS (SELECT 1 FROM C_EXTERNALPOS_CATEGORY CEPOS_CAT" +
      "                             WHERE CEPOS_CAT.C_EXTERNALPOS_ID = CEPOS.C_EXTERNALPOS_ID" +
      "                             AND CEPOS_CAT.M_PRODUCT_CATEGORY_ID = M_PRODUCT.M_PRODUCT_CATEGORY_ID)))" +
      "        AND ((COALESCE(CEPOS.INCLUDE_PRODUCT,'Y') = 'N' " +
      "              AND EXISTS (SELECT 1 FROM C_EXTERNALPOS_PRODUCT CEPOS_PROD" +
      "                          WHERE CEPOS_PROD.C_EXTERNALPOS_ID = CEPOS.C_EXTERNALPOS_ID" +
      "                          AND CEPOS_PROD.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID)) OR " +
      "             (COALESCE(CEPOS.INCLUDE_PRODUCT,'Y') = 'Y' " +
      "              AND NOT EXISTS (SELECT 1 FROM C_EXTERNALPOS_PRODUCT CEPOS_PROD" +
      "                              WHERE CEPOS_PROD.C_EXTERNALPOS_ID = CEPOS.C_EXTERNALPOS_ID" +
      "                              AND CEPOS_PROD.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID)))";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesChannel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, organizationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, organizationId);

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
        ExternalSalesProductData objectExternalSalesProductData = new ExternalSalesProductData();
        objectExternalSalesProductData.id = UtilSql.getValue(result, "id");
        objectExternalSalesProductData.name = UtilSql.getValue(result, "name");
        objectExternalSalesProductData.number1 = UtilSql.getValue(result, "number1");
        objectExternalSalesProductData.description = UtilSql.getValue(result, "description");
        objectExternalSalesProductData.listPrice = UtilSql.getValue(result, "list_price");
        objectExternalSalesProductData.purchasePrice = UtilSql.getValue(result, "purchase_price");
        objectExternalSalesProductData.taxId = UtilSql.getValue(result, "tax_id");
        objectExternalSalesProductData.taxName = UtilSql.getValue(result, "tax_name");
        objectExternalSalesProductData.percentage = UtilSql.getValue(result, "percentage");
        objectExternalSalesProductData.imageUrl = UtilSql.getValue(result, "image_url");
        objectExternalSalesProductData.ean = UtilSql.getValue(result, "ean");
        objectExternalSalesProductData.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectExternalSalesProductData.mProductCategoryName = UtilSql.getValue(result, "m_product_category_name");
        objectExternalSalesProductData.mProductCategoryDescription = UtilSql.getValue(result, "m_product_category_description");
        objectExternalSalesProductData.qtyonhand = UtilSql.getValue(result, "qtyonhand");
        objectExternalSalesProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExternalSalesProductData);
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
    ExternalSalesProductData objectExternalSalesProductData[] = new ExternalSalesProductData[vector.size()];
    vector.copyInto(objectExternalSalesProductData);
    return(objectExternalSalesProductData);
  }
}
