//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.info;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ProductExtendedData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductExtendedData.class);
  private String InitRecordNumber="0";
  public String mProductId;
  public String discontinued;
  public String value;
  public String name;
  public String pricelist;
  public String pricestd;
  public String pricelimit;
  public String qtyonhand;
  public String qtyinflow;
  public String qtyoutflow;
  public String qtyavailable;
  public String width;
  public String theme;
  public String customerproductno;
  public String cUomId;
  public String cCurrencyId;
  public String margin;
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
    else if (fieldName.equalsIgnoreCase("qtyinflow"))
      return qtyinflow;
    else if (fieldName.equalsIgnoreCase("qtyoutflow"))
      return qtyoutflow;
    else if (fieldName.equalsIgnoreCase("qtyavailable"))
      return qtyavailable;
    else if (fieldName.equalsIgnoreCase("width"))
      return width;
    else if (fieldName.equalsIgnoreCase("theme"))
      return theme;
    else if (fieldName.equalsIgnoreCase("customerproductno"))
      return customerproductno;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("margin"))
      return margin;
    else if (fieldName.equals("position"))
      return position;
    else if (fieldName.equals("rowKey"))
      return rowKey;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductExtendedData[] select(ConnectionProvider connectionProvider, String language, String adClientID, String priceListVersion, String warehouse, String key, String name, String adUserClient, String adUserOrg, String isPurchase, String isSold, String cBpartnerId, String mProductCategoryId, String mTheme, String mCustomerproductno, String mWtdthFrom, String mWtdthTo, String vendorproductno, String TypeOfProduct, String pgLimit, String orderBy)    throws ServletException {
    return select(connectionProvider, language, adClientID, priceListVersion, warehouse, key, name, adUserClient, adUserOrg, isPurchase, isSold, cBpartnerId, mProductCategoryId, mTheme, mCustomerproductno, mWtdthFrom, mWtdthTo, vendorproductno, TypeOfProduct, pgLimit, orderBy, 0, 0);
  }

  public static ProductExtendedData[] select(ConnectionProvider connectionProvider, String language, String adClientID, String priceListVersion, String warehouse, String key, String name, String adUserClient, String adUserOrg, String isPurchase, String isSold, String cBpartnerId, String mProductCategoryId, String mTheme, String mCustomerproductno, String mWtdthFrom, String mWtdthTo, String vendorproductno, String TypeOfProduct, String pgLimit, String orderBy, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT A.*," +
      "        PriceStd-PriceLimit AS Margin" +
      "      FROM (" +
      "        SELECT p.M_Product_ID, p.Discontinued, p.Value, " +
      "        case when (? = 'en_US' or (select count(*) from ad_client where ad_client_id= ? and ismultilingualdocument='Y')=0) then p.name else coalesce(ptrl.name,p.Name) end as name, " +
      "        M_BOM_PriceList(p.M_Product_ID, ?) AS PriceList," +
      "        M_BOM_PriceStd(p.M_Product_ID, ?) AS PriceStd, " +
      "        M_BOM_PriceLimit(p.M_Product_ID, ?) AS PriceLimit," +
      "        M_BOM_Qty_OnHand(p.M_Product_ID,?, NULL) AS QtyOnHand, " +
      "        M_BOM_Qty_Incomming(p.M_Product_ID,?, null) AS qtyinflow, " +
      "        M_BOM_Qty_Outgoing(p.M_Product_ID,?, NULL) AS qtyoutflow," +
      "        M_BOM_Qty_Available(p.M_Product_ID,?, NULL) AS QtyAvailable, " +
      "        coalesce(p.Width,0) as width," +
      "        p.theme," +
      "        p.customerproductno," +
      "        p.C_UOM_ID, pl.C_Currency_ID" +
      "        FROM m_product p left join m_product_trl ptrl on ptrl.m_product_id=p.m_product_id and ptrl.ad_language=?, " +
      "        m_pricelist pl " +
      "        WHERE" +
      "              pl.m_pricelist_id=(select m_pricelist_id from m_pricelist_version where m_pricelist_version_id=?)" +
      "              AND p.isactive ='Y' " +
      "              AND 1=1";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(p.Value) LIKE UPPER(?) ");
    strSql = strSql + 
      "              AND case when (? = 'en_US' or (select count(*) from ad_client where ad_client_id= ? and ismultilingualdocument='Y')=0) then 2=2";
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  AND UPPER(p.Name) LIKE UPPER(?) ");
    strSql = strSql + 
      " else 3=3";
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  AND UPPER(ptrl.Name) LIKE UPPER(?) ");
    strSql = strSql + 
      " AND ptrl.ad_language=? end" +
      "              AND p.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "              AND p.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "              AND p.ispurchased in (";
    strSql = strSql + ((isPurchase==null || isPurchase.equals(""))?"":isPurchase);
    strSql = strSql + 
      ")" +
      "              AND p.issold in (";
    strSql = strSql + ((isSold==null || isSold.equals(""))?"":isSold);
    strSql = strSql + 
      ") " +
      "              ANd coalesce(p.c_bpartner_id,'%')  like ?" +
      "              and p.m_product_category_id like ?" +
      "              and coalesce(p.theme,'%') like ?" +
      "              and coalesce(p.customerproductno,'%') like ?" +
      "              and coalesce(p.Width,0) between coalesce(to_number(?),0) and coalesce(to_number(?),99999999)" +
      "              AND 5=5";
    strSql = strSql + ((vendorproductno==null || vendorproductno.equals("") || vendorproductno.equals("%") )?"":" and p.m_product_id in (select m_product_id from m_product_po po where coalesce(po.vendorproductno,'%') like ?) ");
    strSql = strSql + 
      "              and p.typeofproduct  like ?" +
      "              AND 4=4";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":"  LIMIT " + pgLimit);
    strSql = strSql + 
      "        ) A ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceListVersion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceListVersion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceListVersion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceListVersion);
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientID);
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (isPurchase != null && !(isPurchase.equals(""))) {
        }
      if (isSold != null && !(isSold.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mTheme);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mCustomerproductno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWtdthFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWtdthTo);
      if (vendorproductno != null && !(vendorproductno.equals("")) && !(vendorproductno.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorproductno);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, TypeOfProduct);
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
        ProductExtendedData objectProductExtendedData = new ProductExtendedData();
        objectProductExtendedData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductExtendedData.discontinued = UtilSql.getValue(result, "discontinued");
        objectProductExtendedData.value = UtilSql.getValue(result, "value");
        objectProductExtendedData.name = UtilSql.getValue(result, "name");
        objectProductExtendedData.pricelist = UtilSql.getValue(result, "pricelist");
        objectProductExtendedData.pricestd = UtilSql.getValue(result, "pricestd");
        objectProductExtendedData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectProductExtendedData.qtyonhand = UtilSql.getValue(result, "qtyonhand");
        objectProductExtendedData.qtyinflow = UtilSql.getValue(result, "qtyinflow");
        objectProductExtendedData.qtyoutflow = UtilSql.getValue(result, "qtyoutflow");
        objectProductExtendedData.qtyavailable = UtilSql.getValue(result, "qtyavailable");
        objectProductExtendedData.width = UtilSql.getValue(result, "width");
        objectProductExtendedData.theme = UtilSql.getValue(result, "theme");
        objectProductExtendedData.customerproductno = UtilSql.getValue(result, "customerproductno");
        objectProductExtendedData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectProductExtendedData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectProductExtendedData.margin = UtilSql.getValue(result, "margin");
        objectProductExtendedData.position = Long.toString(countRecord);
        objectProductExtendedData.rowKey = "";
        objectProductExtendedData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductExtendedData);
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
    ProductExtendedData objectProductExtendedData[] = new ProductExtendedData[vector.size()];
    vector.copyInto(objectProductExtendedData);
    return(objectProductExtendedData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String language, String priceListVersion, String key, String adClientID, String name, String adUserClient, String adUserOrg, String isPurchase, String isSold, String cBpartnerId, String mProductCategoryId, String Theme, String Customerproductno, String WidthFrom, String WidthTo, String vendorproductno, String TypeOfProduct, String pgLimit)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT count(*) AS value FROM (" +
      "        select p.m_product_id FROM m_product p left join m_product_trl ptrl on ptrl.m_product_id=p.m_product_id and ptrl.ad_language=?, " +
      "        m_pricelist pl " +
      "        WHERE" +
      "              pl.m_pricelist_id=(select m_pricelist_id from m_pricelist_version where m_pricelist_version_id=?)" +
      "              AND p.isactive ='Y' " +
      "              AND 1=1";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(p.Value) LIKE UPPER(?) ");
    strSql = strSql + 
      "              AND case when (? = 'en_US' or (select count(*) from ad_client where ad_client_id= ? and ismultilingualdocument='Y')=0) then 2=2";
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  AND UPPER(p.Name) LIKE UPPER(?) ");
    strSql = strSql + 
      " else 3=3";
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  AND UPPER(ptrl.Name) LIKE UPPER(?) ");
    strSql = strSql + 
      " AND ptrl.ad_language=? end" +
      "              AND p.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "              AND p.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "              AND p.ispurchased in (";
    strSql = strSql + ((isPurchase==null || isPurchase.equals(""))?"":isPurchase);
    strSql = strSql + 
      ")" +
      "              AND p.issold in (";
    strSql = strSql + ((isSold==null || isSold.equals(""))?"":isSold);
    strSql = strSql + 
      ") " +
      "              ANd coalesce(p.c_bpartner_id,'%')  like ?" +
      "              and p.m_product_category_id like ?" +
      "              and coalesce(p.theme,'%') like ?" +
      "              and coalesce(p.customerproductno,'%') like ?" +
      "              and coalesce(p.Width,0) between coalesce(to_number(?),0) and coalesce(to_number(?),99999999)" +
      "              AND 5=5";
    strSql = strSql + ((vendorproductno==null || vendorproductno.equals("") || vendorproductno.equals("%") )?"":" and p.m_product_id in (select m_product_id from m_product_po po where coalesce(po.vendorproductno,'%') like ?) ");
    strSql = strSql + 
      "              and p.typeofproduct  like ?" +
      "              AND 4=4";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":"  LIMIT " + pgLimit);
    strSql = strSql + 
      "        )  A ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceListVersion);
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientID);
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (isPurchase != null && !(isPurchase.equals(""))) {
        }
      if (isSold != null && !(isSold.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Theme);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Customerproductno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, WidthFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, WidthTo);
      if (vendorproductno != null && !(vendorproductno.equals("")) && !(vendorproductno.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorproductno);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, TypeOfProduct);
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

  public static ProductExtendedData[] set()    throws ServletException {
    ProductExtendedData objectProductExtendedData[] = new ProductExtendedData[1];
    objectProductExtendedData[0] = new ProductExtendedData();
    objectProductExtendedData[0].value = "";
    return objectProductExtendedData;
  }
}
