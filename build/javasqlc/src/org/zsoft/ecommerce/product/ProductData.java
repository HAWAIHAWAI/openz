//Sqlc generated V1.O00-1
package org.zsoft.ecommerce.product;

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
  public String adOrgId;
  public String lastupdated;
  public String value;
  public String name;
  public String eancode;
  public String description;
  public String documentnote;
  public String productCategoryKey;
  public String uomKey;
  public String isfreightproduct;
  public String eccategory;
  public String isorderable;
  public String ecpriority;
  public String weight;
  public String imageurl;
  public String descriptionurl;
  public String taxname;
  public String taxrate;
  public String curronhandqty;
  public String nextdeliveryqty;
  public String nextdeliverydate;
  public String isgrossprice;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("lastupdated"))
      return lastupdated;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("eancode"))
      return eancode;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("documentnote"))
      return documentnote;
    else if (fieldName.equalsIgnoreCase("product_category_key") || fieldName.equals("productCategoryKey"))
      return productCategoryKey;
    else if (fieldName.equalsIgnoreCase("uom_key") || fieldName.equals("uomKey"))
      return uomKey;
    else if (fieldName.equalsIgnoreCase("isfreightproduct"))
      return isfreightproduct;
    else if (fieldName.equalsIgnoreCase("eccategory"))
      return eccategory;
    else if (fieldName.equalsIgnoreCase("isorderable"))
      return isorderable;
    else if (fieldName.equalsIgnoreCase("ecpriority"))
      return ecpriority;
    else if (fieldName.equalsIgnoreCase("weight"))
      return weight;
    else if (fieldName.equalsIgnoreCase("imageurl"))
      return imageurl;
    else if (fieldName.equalsIgnoreCase("descriptionurl"))
      return descriptionurl;
    else if (fieldName.equalsIgnoreCase("taxname"))
      return taxname;
    else if (fieldName.equalsIgnoreCase("taxrate"))
      return taxrate;
    else if (fieldName.equalsIgnoreCase("curronhandqty"))
      return curronhandqty;
    else if (fieldName.equalsIgnoreCase("nextdeliveryqty"))
      return nextdeliveryqty;
    else if (fieldName.equalsIgnoreCase("nextdeliverydate"))
      return nextdeliverydate;
    else if (fieldName.equalsIgnoreCase("isgrossprice"))
      return isgrossprice;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductData[] select(ConnectionProvider connectionProvider, String adOrgId)    throws ServletException {
    return select(connectionProvider, adOrgId, 0, 0);
  }

  public static ProductData[] select(ConnectionProvider connectionProvider, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "              select p.m_product_ID,p.AD_ORG_ID, p.updated as LASTUPDATED, value," +
      "                    name,upc as eancode,description,documentnote," +
      "                    (select value from m_product_category where m_product_category.m_product_category_id=p.m_product_category_id) as product_category_key," +
      "                    (select name from c_uom where c_uom.c_uom_id=p.c_uom_id) as uom_key,isfreightproduct," +
      "                    s.eccategory,s.isorderable,coalesce(s.ecpriority,0) as ecpriority," +
      "                    coalesce(weight,0) as weight,imageurl,descriptionurl," +
      "                    (select  name from c_tax where c_tax_id=zsfi_gettax(null,p.m_product_ID,?)) as taxname," +
      "                    (select  rate from c_tax where c_tax_id=zsfi_gettax(null,p.m_product_ID,?)) as taxrate," +
      "                    '' as curronhandqty, '' as nextdeliveryqty, '' as nextdeliverydate," +
      "                    coalesce((SELECT istaxincluded  FROM M_PRICELIST    WHERE ISDEFAULT = 'Y'  AND AD_ORG_ID in ('0', ?) and issopricelist='Y' AND ISACTIVE = 'Y'),'N') as isgrossprice" +
      "                    from m_product p,zse_product_shop s" +
      "                    where p.m_product_id=s.m_product_id and p.isactive='Y' and s.isactive='Y' and" +
      "                    p.ad_org_id in ('0',?)              ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
        objectProductData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductData.lastupdated = UtilSql.getDateValue(result, "lastupdated", "dd-MM-yyyy");
        objectProductData.value = UtilSql.getValue(result, "value");
        objectProductData.name = UtilSql.getValue(result, "name");
        objectProductData.eancode = UtilSql.getValue(result, "eancode");
        objectProductData.description = UtilSql.getValue(result, "description");
        objectProductData.documentnote = UtilSql.getValue(result, "documentnote");
        objectProductData.productCategoryKey = UtilSql.getValue(result, "product_category_key");
        objectProductData.uomKey = UtilSql.getValue(result, "uom_key");
        objectProductData.isfreightproduct = UtilSql.getValue(result, "isfreightproduct");
        objectProductData.eccategory = UtilSql.getValue(result, "eccategory");
        objectProductData.isorderable = UtilSql.getValue(result, "isorderable");
        objectProductData.ecpriority = UtilSql.getValue(result, "ecpriority");
        objectProductData.weight = UtilSql.getValue(result, "weight");
        objectProductData.imageurl = UtilSql.getValue(result, "imageurl");
        objectProductData.descriptionurl = UtilSql.getValue(result, "descriptionurl");
        objectProductData.taxname = UtilSql.getValue(result, "taxname");
        objectProductData.taxrate = UtilSql.getValue(result, "taxrate");
        objectProductData.curronhandqty = UtilSql.getValue(result, "curronhandqty");
        objectProductData.nextdeliveryqty = UtilSql.getValue(result, "nextdeliveryqty");
        objectProductData.nextdeliverydate = UtilSql.getValue(result, "nextdeliverydate");
        objectProductData.isgrossprice = UtilSql.getValue(result, "isgrossprice");
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

  public static String getStockQty(ConnectionProvider connectionProvider, String mProductId, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                SELECT coalesce(to_char(sum(coalesce(qtyonhand,0)-coalesce(qtyreserved,0))),'0') as qtyavail from zssi_onhanqty" +
      "                where m_product_id= ? and ad_org_id in ('0',?) and" +
      "                m_warehouse_id in (select m_warehouse_id from zse_warehouse_shop)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "qtyavail");
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

  public static ProductData[] getQuantities(ConnectionProvider connectionProvider, String mProductId, String adOrgId)    throws ServletException {
    return getQuantities(connectionProvider, mProductId, adOrgId, 0, 0);
  }

  public static ProductData[] getQuantities(ConnectionProvider connectionProvider, String mProductId, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                SELECT coalesce(to_char(sum(coalesce(qtyonhand,0)-coalesce(qtyreserved,0))),'0') as curronhandqty," +
      "                zssi_get_nextdeliverydate(?,?,m_warehouse_id) as nextdeliverydate," +
      "                coalesce(zssi_get_nextdeliveryqty(?,?,m_warehouse_id),0) as nextdeliveryqty" +
      "                from zssi_onhanqty" +
      "                where m_product_id= ? and ad_org_id in ('0',?) and" +
      "                m_warehouse_id in (select m_warehouse_id from zse_warehouse_shop where ad_org_id in ('0',?) )" +
      "                group by zssi_onhanqty.m_warehouse_id";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
        objectProductData.curronhandqty = UtilSql.getValue(result, "curronhandqty");
        objectProductData.nextdeliverydate = UtilSql.getDateValue(result, "nextdeliverydate", "dd-MM-yyyy");
        objectProductData.nextdeliveryqty = UtilSql.getValue(result, "nextdeliveryqty");
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

  public static String getProductPrice(ConnectionProvider connectionProvider, String adOrgd, String cBpaernerId, String mProductId, String quantity)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                SELECT zsco_prod_offerpricestdplist(?, ?, ?,?)                ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpaernerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zsco_prod_offerpricestdplist");
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
