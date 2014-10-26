//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ProductInfoData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductInfoData.class);
  private String InitRecordNumber="0";
  public String producttype;
  public String value;
  public String cUomId;
  public String adClientId;
  public String adOrgId;
  public String revenue;
  public String expense;
  public String asset;
  public String cogs;
  public String purchasepricevariance;
  public String invoicepricevariance;
  public String discountrec;
  public String discountgrant;
  public String converted;
  public String currentcostprice;
  public String costaverage;
  public String pricelastpo;
  public String coststandard;
  public String cCurrencyId;
  public String pricelist;
  public String pricestd;
  public String pricelimit;
  public String pricepo;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("producttype"))
      return producttype;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("revenue"))
      return revenue;
    else if (fieldName.equalsIgnoreCase("expense"))
      return expense;
    else if (fieldName.equalsIgnoreCase("asset"))
      return asset;
    else if (fieldName.equalsIgnoreCase("cogs"))
      return cogs;
    else if (fieldName.equalsIgnoreCase("purchasepricevariance"))
      return purchasepricevariance;
    else if (fieldName.equalsIgnoreCase("invoicepricevariance"))
      return invoicepricevariance;
    else if (fieldName.equalsIgnoreCase("discountrec"))
      return discountrec;
    else if (fieldName.equalsIgnoreCase("discountgrant"))
      return discountgrant;
    else if (fieldName.equalsIgnoreCase("converted"))
      return converted;
    else if (fieldName.equalsIgnoreCase("currentcostprice"))
      return currentcostprice;
    else if (fieldName.equalsIgnoreCase("costaverage"))
      return costaverage;
    else if (fieldName.equalsIgnoreCase("pricelastpo"))
      return pricelastpo;
    else if (fieldName.equalsIgnoreCase("coststandard"))
      return coststandard;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("pricepo"))
      return pricepo;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductInfoData[] select(ConnectionProvider connectionProvider, String Product)    throws ServletException {
    return select(connectionProvider, Product, 0, 0);
  }

  public static ProductInfoData[] select(ConnectionProvider connectionProvider, String Product, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "              SELECT P.PRODUCTTYPE, PC.VALUE,P.C_UOM_ID,P.AD_CLIENT_ID,P.AD_ORG_ID," +
      "              '' AS REVENUE, '' AS EXPENSE, '' AS ASSET, '' AS COGS, '' AS PURCHASEPRICEVARIANCE, '' AS INVOICEPRICEVARIANCE," +
      "              '' AS DISCOUNTREC, '' AS DISCOUNTGRANT, '' AS CONVERTED, '' AS CURRENTCOSTPRICE, '' AS COSTAVERAGE, '' AS PRICELASTPO," +
      "              '' AS COSTSTANDARD, '' AS C_CURRENCY_ID, '' AS PRICELIST, '' AS PRICESTD, '' AS PRICELIMIT, '' AS PRICEPO" +
      "              FROM M_PRODUCT_CATEGORY PC, M_PRODUCT P " +
      "              WHERE PC.M_PRODUCT_CATEGORY_ID=P.M_PRODUCT_CATEGORY_ID" +
      "              AND P.M_PRODUCT_ID=?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Product);

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
        ProductInfoData objectProductInfoData = new ProductInfoData();
        objectProductInfoData.producttype = UtilSql.getValue(result, "producttype");
        objectProductInfoData.value = UtilSql.getValue(result, "value");
        objectProductInfoData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectProductInfoData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProductInfoData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductInfoData.revenue = UtilSql.getValue(result, "revenue");
        objectProductInfoData.expense = UtilSql.getValue(result, "expense");
        objectProductInfoData.asset = UtilSql.getValue(result, "asset");
        objectProductInfoData.cogs = UtilSql.getValue(result, "cogs");
        objectProductInfoData.purchasepricevariance = UtilSql.getValue(result, "purchasepricevariance");
        objectProductInfoData.invoicepricevariance = UtilSql.getValue(result, "invoicepricevariance");
        objectProductInfoData.discountrec = UtilSql.getValue(result, "discountrec");
        objectProductInfoData.discountgrant = UtilSql.getValue(result, "discountgrant");
        objectProductInfoData.converted = UtilSql.getValue(result, "converted");
        objectProductInfoData.currentcostprice = UtilSql.getValue(result, "currentcostprice");
        objectProductInfoData.costaverage = UtilSql.getValue(result, "costaverage");
        objectProductInfoData.pricelastpo = UtilSql.getValue(result, "pricelastpo");
        objectProductInfoData.coststandard = UtilSql.getValue(result, "coststandard");
        objectProductInfoData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectProductInfoData.pricelist = UtilSql.getValue(result, "pricelist");
        objectProductInfoData.pricestd = UtilSql.getValue(result, "pricestd");
        objectProductInfoData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectProductInfoData.pricepo = UtilSql.getValue(result, "pricepo");
        objectProductInfoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductInfoData);
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
    ProductInfoData objectProductInfoData[] = new ProductInfoData[vector.size()];
    vector.copyInto(objectProductInfoData);
    return(objectProductInfoData);
  }

  public static ProductInfoData[] UOMConvert(ConnectionProvider connectionProvider, String qty, String C_UOM_From_ID, String C_UOM_To_ID, String StdPrecision)    throws ServletException {
    return UOMConvert(connectionProvider, qty, C_UOM_From_ID, C_UOM_To_ID, StdPrecision, 0, 0);
  }

  public static ProductInfoData[] UOMConvert(ConnectionProvider connectionProvider, String qty, String C_UOM_From_ID, String C_UOM_To_ID, String StdPrecision, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select C_UOM_Convert (TO_NUMBER(?), ?, ?, ?) as converted from dual";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_UOM_From_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_UOM_To_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, StdPrecision);

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
        ProductInfoData objectProductInfoData = new ProductInfoData();
        objectProductInfoData.converted = UtilSql.getValue(result, "converted");
        objectProductInfoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductInfoData);
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
    ProductInfoData objectProductInfoData[] = new ProductInfoData[vector.size()];
    vector.copyInto(objectProductInfoData);
    return(objectProductInfoData);
  }

  public static String selectProductAverageCost(ConnectionProvider connectionProvider, String M_Product_ID, String date, String AdOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(M_GET_PRODUCT_COST(?, TO_DATE(?), TO_CHAR(NULL),?),0) FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AdOrgId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "coalesce");
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

  public static ProductInfoData[] selectPriceList(ConnectionProvider connectionProvider, String M_Product_ID, String onlyPOPriceList)    throws ServletException {
    return selectPriceList(connectionProvider, M_Product_ID, onlyPOPriceList, 0, 0);
  }

  public static ProductInfoData[] selectPriceList(ConnectionProvider connectionProvider, String M_Product_ID, String onlyPOPriceList, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "              SELECT pl.C_Currency_ID, pp.PriceList, pp.PriceStd, pp.PriceLimit " +
      "              FROM M_PriceList pl, M_PriceList_Version plv, M_ProductPrice pp " +
      "              WHERE pl.M_PriceList_ID = plv.M_PriceList_ID" +
      "              AND plv.M_PriceList_Version_ID = pp.M_PriceList_Version_ID" +
      "              AND pp.M_Product_ID=?" +
      "              AND 1=1";
    strSql = strSql + ((onlyPOPriceList.equals("onlyPOPriceList"))?"  AND pl.IsSOPriceList='N' ":"");
    strSql = strSql + 
      "              ORDER BY pl.IsSOPriceList ASC, plv.ValidFrom DESC";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_ID);
      if (onlyPOPriceList != null && !(onlyPOPriceList.equals(""))) {
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
        ProductInfoData objectProductInfoData = new ProductInfoData();
        objectProductInfoData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectProductInfoData.pricelist = UtilSql.getValue(result, "pricelist");
        objectProductInfoData.pricestd = UtilSql.getValue(result, "pricestd");
        objectProductInfoData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectProductInfoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductInfoData);
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
    ProductInfoData objectProductInfoData[] = new ProductInfoData[vector.size()];
    vector.copyInto(objectProductInfoData);
    return(objectProductInfoData);
  }

  public static ProductInfoData[] selectPOCost(ConnectionProvider connectionProvider, String M_Product_ID)    throws ServletException {
    return selectPOCost(connectionProvider, M_Product_ID, 0, 0);
  }

  public static ProductInfoData[] selectPOCost(ConnectionProvider connectionProvider, String M_Product_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "             SELECT C_Currency_ID, PriceList,PricePO,PriceLastPO " +
      "             FROM M_Product_PO " +
      "             WHERE M_Product_ID = ? " +
      "             ORDER BY IsCurrentVendor DESC";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_ID);

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
        ProductInfoData objectProductInfoData = new ProductInfoData();
        objectProductInfoData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectProductInfoData.pricelist = UtilSql.getValue(result, "pricelist");
        objectProductInfoData.pricepo = UtilSql.getValue(result, "pricepo");
        objectProductInfoData.pricelastpo = UtilSql.getValue(result, "pricelastpo");
        objectProductInfoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductInfoData);
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
    ProductInfoData objectProductInfoData[] = new ProductInfoData[vector.size()];
    vector.copyInto(objectProductInfoData);
    return(objectProductInfoData);
  }

  public static String selectProductAcctWithTax(ConnectionProvider connectionProvider, String AccountType, String M_Product_ID, String AcctSchema, String InvoiceLine_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "           SELECT zsfi_GetPAccount(?,?,?,?)  from dual";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AccountType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AcctSchema);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, InvoiceLine_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zsfi_getpaccount");
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

  public static String selectProductAcct(ConnectionProvider connectionProvider, String AccountType, String M_Product_ID, String AcctSchema)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "           SELECT zsfi_GetPAccount(?,?,?) from dual";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AccountType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AcctSchema);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zsfi_getpaccount");
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
