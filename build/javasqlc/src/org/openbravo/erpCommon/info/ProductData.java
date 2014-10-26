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

class ProductData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductData.class);
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

  public static ProductData[] select(ConnectionProvider connectionProvider, String adClientID, String priceListVersion, String warehouse, String language, String key, String name, String adUserClient, String adUserOrg, String isPurchase, String isSold, String cBpartnerId, String mProductCategoryId, String selectMachines, String vendorproductno, String TypeOfProduct, String WindwID, String pgLimit, String orderBy)    throws ServletException {
    return select(connectionProvider, adClientID, priceListVersion, warehouse, language, key, name, adUserClient, adUserOrg, isPurchase, isSold, cBpartnerId, mProductCategoryId, selectMachines, vendorproductno, TypeOfProduct, WindwID, pgLimit, orderBy, 0, 0);
  }

  public static ProductData[] select(ConnectionProvider connectionProvider, String adClientID, String priceListVersion, String warehouse, String language, String key, String name, String adUserClient, String adUserOrg, String isPurchase, String isSold, String cBpartnerId, String mProductCategoryId, String selectMachines, String vendorproductno, String TypeOfProduct, String WindwID, String pgLimit, String orderBy, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT A.*," +
      "        PriceStd-PriceLimit AS Margin" +
      "      FROM (" +
      "        SELECT p.M_Product_ID, p.Discontinued, p.Value, " +
      "        case when ((select count(*) from ad_client where ad_client_id= ? and ismultilingualdocument='Y')=0) then p.name else coalesce(ptrl.name,p.Name) end as name, " +
      "        M_BOM_PriceList(p.M_Product_ID, ?) AS PriceList," +
      "        M_BOM_PriceStd(p.M_Product_ID, ?) AS PriceStd, " +
      "        M_BOM_PriceLimit(p.M_Product_ID, ?) AS PriceLimit," +
      "        M_BOM_Qty_OnHand(p.M_Product_ID,?, NULL) AS QtyOnHand, " +
      "        coalesce(SUM(ohq.qtyinflow),0) AS qtyinflow, " +
      "        coalesce(SUM(ohq.qtyoutflow),0) AS qtyoutflow," +
      "        coalesce(SUM(qtyonhand)-SUM(qtyoutflow),0) AS QtyAvailable, " +
      "        p.C_UOM_ID, pl.C_Currency_ID" +
      "        FROM M_Product p left join m_product_trl ptrl on ptrl.m_product_id=p.m_product_id and ptrl.ad_language=?" +
      "                         left join zssi_onhanqty ohq on ohq.m_warehouse_id = ? and ohq.M_Product_id=p.m_product_id, " +
      "        m_pricelist pl " +
      "        WHERE" +
      "              pl.m_pricelist_id=(select m_pricelist_id from m_pricelist_version where m_pricelist_version_id=?)" +
      "              AND p.isactive ='Y' " +
      "              AND 1=1";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(p.Value) LIKE UPPER(?) ");
    strSql = strSql + 
      "              AND case when ((select count(*) from ad_client where ad_client_id= ? and ismultilingualdocument='Y')=0) then 2=2";
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  AND UPPER(p.Name) LIKE UPPER(?) ");
    strSql = strSql + 
      " else 3=3";
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  AND UPPER(ptrl.Name) LIKE UPPER(?) ");
    strSql = strSql + 
      "  end" +
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
      "              and case when ? = 'N' then not exists (select 0 from snr_masterdata snr,ma_machine ma where ma.snr_masterdata_id=snr.snr_masterdata_id and snr.m_product_id=p.m_product_id) else 6=6 end" +
      "              AND 5=5";
    strSql = strSql + ((vendorproductno==null || vendorproductno.equals("") || vendorproductno.equals("%") )?"":" and p.m_product_id in (select m_product_id from m_product_po po where coalesce(po.vendorproductno,'%') like ?) ");
    strSql = strSql + 
      "              and p.typeofproduct  like ?" +
      "              AND zssi_isProductSelectableinWindow(?,p.m_product_id)='Y'" +
      "              AND 4=4     " +
      "              GROUP BY p.M_Product_ID, p.Discontinued, p.Value,p.name,ptrl.name,p.C_UOM_ID, pl.C_Currency_ID";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceListVersion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceListVersion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceListVersion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceListVersion);
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientID);
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, selectMachines);
      if (vendorproductno != null && !(vendorproductno.equals("")) && !(vendorproductno.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorproductno);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, TypeOfProduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, WindwID);
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
        ProductData objectProductData = new ProductData();
        objectProductData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductData.discontinued = UtilSql.getValue(result, "discontinued");
        objectProductData.value = UtilSql.getValue(result, "value");
        objectProductData.name = UtilSql.getValue(result, "name");
        objectProductData.pricelist = UtilSql.getValue(result, "pricelist");
        objectProductData.pricestd = UtilSql.getValue(result, "pricestd");
        objectProductData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectProductData.qtyonhand = UtilSql.getValue(result, "qtyonhand");
        objectProductData.qtyinflow = UtilSql.getValue(result, "qtyinflow");
        objectProductData.qtyoutflow = UtilSql.getValue(result, "qtyoutflow");
        objectProductData.qtyavailable = UtilSql.getValue(result, "qtyavailable");
        objectProductData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectProductData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectProductData.margin = UtilSql.getValue(result, "margin");
        objectProductData.position = Long.toString(countRecord);
        objectProductData.rowKey = "";
        objectProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductData);
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
    ProductData objectProductData[] = new ProductData[vector.size()];
    vector.copyInto(objectProductData);
    return(objectProductData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String language, String priceListVersion, String key, String adClientID, String name, String adUserClient, String adUserOrg, String isPurchase, String isSold, String cBpartnerId, String mProductCategoryId, String selectMachines, String vendorproductno, String TypeOfProduct, String WindwID, String pgLimit)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT count(*) AS value FROM (" +
      "        select p.m_product_id FROM M_Product p left join m_product_trl ptrl on ptrl.m_product_id=p.m_product_id and ptrl.ad_language=?, " +
      "        m_pricelist pl " +
      "        WHERE" +
      "              pl.m_pricelist_id=(select m_pricelist_id from m_pricelist_version where m_pricelist_version_id=?)" +
      "              AND p.isactive ='Y' " +
      "              AND 1=1";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(p.Value) LIKE UPPER(?) ");
    strSql = strSql + 
      "              AND case when ((select count(*) from ad_client where ad_client_id= ? and ismultilingualdocument='Y')=0) then 2=2";
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  AND UPPER(p.Name) LIKE UPPER(?) ");
    strSql = strSql + 
      " else 3=3";
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  AND UPPER(ptrl.Name) LIKE UPPER(?) ");
    strSql = strSql + 
      "  end" +
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
      "              and case when ? = 'N' then not exists (select 0 from snr_masterdata snr,ma_machine ma where ma.snr_masterdata_id=snr.snr_masterdata_id and snr.m_product_id=p.m_product_id) else 6=6 end" +
      "              AND 5=5";
    strSql = strSql + ((vendorproductno==null || vendorproductno.equals("") || vendorproductno.equals("%") )?"":" and p.m_product_id in (select m_product_id from m_product_po po where coalesce(po.vendorproductno,'%') like ?) ");
    strSql = strSql + 
      "              and p.typeofproduct  like ?" +
      "              AND zssi_isProductSelectableinWindow(?,p.m_product_id)='Y'" +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientID);
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, selectMachines);
      if (vendorproductno != null && !(vendorproductno.equals("")) && !(vendorproductno.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorproductno);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, TypeOfProduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, WindwID);
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

  public static ProductData[] set()    throws ServletException {
    ProductData objectProductData[] = new ProductData[1];
    objectProductData[0] = new ProductData();
    objectProductData[0].value = "";
    return objectProductData;
  }

  public static String priceListDefault(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String issotrx)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_PRICELIST_ID FROM M_PRICELIST " +
      "        WHERE AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND CASE when ?='Y' then  isdefault='Y' and issopricelist='Y' else issopricelist='N' end" +
      "        order by isdefault desc";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_pricelist_id");
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

  public static String existsActual(ConnectionProvider connectionProvider, String language, String description, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT name as name" +
      "        FROM M_Product " +
      "        WHERE UPPER(AD_COLUMN_IDENTIFIER(TO_CHAR('M_Product'), TO_CHAR(M_Product_ID), TO_CHAR(?))) = UPPER(?)" +
      "        AND M_Product_ID = ? " +
      "        ORDER BY name";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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

  public static String existsActualValue(ConnectionProvider connectionProvider, String language, String description, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT value as value" +
      "        FROM M_Product " +
      "        WHERE UPPER(AD_COLUMN_IDENTIFIER(TO_CHAR('M_Product'), TO_CHAR(M_Product_ID), TO_CHAR(?))) = UPPER(?)" +
      "        AND M_Product_ID = ? " +
      "        ORDER BY value";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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

  public static String getValue(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT value as value" +
      "        FROM M_Product " +
      "        WHERE  M_Product_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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

  public static String getValueCount(ConnectionProvider connectionProvider, String PValue)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT count(*) as count" +
      "        FROM M_Product " +
      "        WHERE  value like ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, PValue);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static String getNameCount(ConnectionProvider connectionProvider, String PName)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT count(*) as count" +
      "        FROM M_Product " +
      "        WHERE  upper(name) like upper(?) ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, PName);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static String isSOPricelist(ConnectionProvider connectionProvider, String priceListVersion)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT issopricelist FROM M_PRICELIST " +
      "        WHERE M_PRICELIST_ID=(select m_pricelist_id from m_pricelist_version where m_pricelist_version_id=?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceListVersion);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "issopricelist");
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

  public static String getActivatePOBPartnerPreselection(ConnectionProvider connectionProvider, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT c_getconfigoption('activatepobpartnerpreselection', ?) from dual";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_getconfigoption");
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
