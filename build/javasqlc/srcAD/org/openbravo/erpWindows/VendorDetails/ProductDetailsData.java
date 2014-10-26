//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.VendorDetails;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

/**
WAD Generated class
 */
class ProductDetailsData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductDetailsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mProductPoId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String qualityrating;
  public String mProductId;
  public String mProductIdr;
  public String isactive;
  public String iscurrentvendor;
  public String upc;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String pricelist;
  public String priceeffective;
  public String pricepo;
  public String royaltyamt;
  public String pricelastpo;
  public String pricelastinv;
  public String cUomId;
  public String cUomIdr;
  public String orderMin;
  public String orderPack;
  public String deliverytimePromised;
  public String deliverytimeActual;
  public String costperorder;
  public String vendorproductno;
  public String vendorcategory;
  public String manufacturer;
  public String discontinued;
  public String discontinuedby;
  public String language;
  public String adUserClient;
  public String adOrgClient;
  public String createdby;
  public String trBgcolor;
  public String totalCount;
  public String dateTimeFormat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdbyr"))
      return createdbyr;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updated_time_stamp") || fieldName.equals("updatedTimeStamp"))
      return updatedTimeStamp;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("updatedbyr"))
      return updatedbyr;
    else if (fieldName.equalsIgnoreCase("m_product_po_id") || fieldName.equals("mProductPoId"))
      return mProductPoId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("qualityrating"))
      return qualityrating;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("iscurrentvendor"))
      return iscurrentvendor;
    else if (fieldName.equalsIgnoreCase("upc"))
      return upc;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("priceeffective"))
      return priceeffective;
    else if (fieldName.equalsIgnoreCase("pricepo"))
      return pricepo;
    else if (fieldName.equalsIgnoreCase("royaltyamt"))
      return royaltyamt;
    else if (fieldName.equalsIgnoreCase("pricelastpo"))
      return pricelastpo;
    else if (fieldName.equalsIgnoreCase("pricelastinv"))
      return pricelastinv;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("order_min") || fieldName.equals("orderMin"))
      return orderMin;
    else if (fieldName.equalsIgnoreCase("order_pack") || fieldName.equals("orderPack"))
      return orderPack;
    else if (fieldName.equalsIgnoreCase("deliverytime_promised") || fieldName.equals("deliverytimePromised"))
      return deliverytimePromised;
    else if (fieldName.equalsIgnoreCase("deliverytime_actual") || fieldName.equals("deliverytimeActual"))
      return deliverytimeActual;
    else if (fieldName.equalsIgnoreCase("costperorder"))
      return costperorder;
    else if (fieldName.equalsIgnoreCase("vendorproductno"))
      return vendorproductno;
    else if (fieldName.equalsIgnoreCase("vendorcategory"))
      return vendorcategory;
    else if (fieldName.equalsIgnoreCase("manufacturer"))
      return manufacturer;
    else if (fieldName.equalsIgnoreCase("discontinued"))
      return discontinued;
    else if (fieldName.equalsIgnoreCase("discontinuedby"))
      return discontinuedby;
    else if (fieldName.equalsIgnoreCase("language"))
      return language;
    else if (fieldName.equals("adUserClient"))
      return adUserClient;
    else if (fieldName.equals("adOrgClient"))
      return adOrgClient;
    else if (fieldName.equals("createdby"))
      return createdby;
    else if (fieldName.equals("trBgcolor"))
      return trBgcolor;
    else if (fieldName.equals("totalCount"))
      return totalCount;
    else if (fieldName.equals("dateTimeFormat"))
      return dateTimeFormat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for edit
 */
  public static ProductDetailsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cBpartnerId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ProductDetailsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_Product_PO.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Product_PO.CreatedBy) as CreatedByR, " +
      "        to_char(M_Product_PO.Updated, ?) as updated, " +
      "        to_char(M_Product_PO.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_Product_PO.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Product_PO.UpdatedBy) as UpdatedByR," +
      "        M_Product_PO.M_Product_PO_ID, " +
      "M_Product_PO.AD_Client_ID, " +
      "(CASE WHEN M_Product_PO.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "M_Product_PO.AD_Org_ID, " +
      "(CASE WHEN M_Product_PO.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "M_Product_PO.C_BPartner_ID, " +
      "(CASE WHEN M_Product_PO.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "M_Product_PO.QualityRating, " +
      "M_Product_PO.M_Product_ID, " +
      "(CASE WHEN M_Product_PO.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "COALESCE(M_Product_PO.IsActive, 'N') AS IsActive, " +
      "COALESCE(M_Product_PO.IsCurrentVendor, 'N') AS IsCurrentVendor, " +
      "M_Product_PO.UPC, " +
      "M_Product_PO.C_Currency_ID, " +
      "(CASE WHEN M_Product_PO.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "M_Product_PO.PriceList, " +
      "M_Product_PO.PriceEffective, " +
      "M_Product_PO.PricePO, " +
      "M_Product_PO.RoyaltyAmt, " +
      "M_Product_PO.PriceLastPO, " +
      "M_Product_PO.PriceLastInv, " +
      "M_Product_PO.C_UOM_ID, " +
      "(CASE WHEN M_Product_PO.C_UOM_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'') ) END) AS C_UOM_IDR, " +
      "M_Product_PO.Order_Min, " +
      "M_Product_PO.Order_Pack, " +
      "M_Product_PO.DeliveryTime_Promised, " +
      "M_Product_PO.DeliveryTime_Actual, " +
      "M_Product_PO.CostPerOrder, " +
      "M_Product_PO.VendorProductNo, " +
      "M_Product_PO.VendorCategory, " +
      "M_Product_PO.Manufacturer, " +
      "COALESCE(M_Product_PO.Discontinued, 'N') AS Discontinued, " +
      "M_Product_PO.DiscontinuedBy, " +
      "        ? AS LANGUAGE " +
      "        FROM M_Product_PO left join (select AD_Client_ID, Name from AD_Client) table1 on (M_Product_PO.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (M_Product_PO.AD_Org_ID = table2.AD_Org_ID) left join (select C_BPartner_ID, Name from C_BPartner) table3 on (M_Product_PO.C_BPartner_ID = table3.C_BPartner_ID) left join (select M_Product_ID, Value, Name from M_Product) table4 on (M_Product_PO.M_Product_ID = table4.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL4 on (table4.M_Product_ID = tableTRL4.M_Product_ID and tableTRL4.AD_Language = ?)  left join (select C_Currency_ID, ISO_Code from C_Currency) table5 on (M_Product_PO.C_Currency_ID = table5.C_Currency_ID) left join (select C_UOM_ID, Name from C_UOM) table6 on (M_Product_PO.C_UOM_ID =  table6.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL6 on (table6.C_UOM_ID = tableTRL6.C_UOM_ID and tableTRL6.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND M_Product_PO.C_BPartner_ID = ?  ");
    strSql = strSql + 
      "        AND M_Product_PO.M_Product_PO_ID = ? " +
      "        AND M_Product_PO.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND M_Product_PO.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
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
        ProductDetailsData objectProductDetailsData = new ProductDetailsData();
        objectProductDetailsData.created = UtilSql.getValue(result, "created");
        objectProductDetailsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectProductDetailsData.updated = UtilSql.getValue(result, "updated");
        objectProductDetailsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectProductDetailsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectProductDetailsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectProductDetailsData.mProductPoId = UtilSql.getValue(result, "m_product_po_id");
        objectProductDetailsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProductDetailsData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectProductDetailsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductDetailsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectProductDetailsData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectProductDetailsData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectProductDetailsData.qualityrating = UtilSql.getValue(result, "qualityrating");
        objectProductDetailsData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductDetailsData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectProductDetailsData.isactive = UtilSql.getValue(result, "isactive");
        objectProductDetailsData.iscurrentvendor = UtilSql.getValue(result, "iscurrentvendor");
        objectProductDetailsData.upc = UtilSql.getValue(result, "upc");
        objectProductDetailsData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectProductDetailsData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectProductDetailsData.pricelist = UtilSql.getValue(result, "pricelist");
        objectProductDetailsData.priceeffective = UtilSql.getDateValue(result, "priceeffective", "dd-MM-yyyy");
        objectProductDetailsData.pricepo = UtilSql.getValue(result, "pricepo");
        objectProductDetailsData.royaltyamt = UtilSql.getValue(result, "royaltyamt");
        objectProductDetailsData.pricelastpo = UtilSql.getValue(result, "pricelastpo");
        objectProductDetailsData.pricelastinv = UtilSql.getValue(result, "pricelastinv");
        objectProductDetailsData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectProductDetailsData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectProductDetailsData.orderMin = UtilSql.getValue(result, "order_min");
        objectProductDetailsData.orderPack = UtilSql.getValue(result, "order_pack");
        objectProductDetailsData.deliverytimePromised = UtilSql.getValue(result, "deliverytime_promised");
        objectProductDetailsData.deliverytimeActual = UtilSql.getValue(result, "deliverytime_actual");
        objectProductDetailsData.costperorder = UtilSql.getValue(result, "costperorder");
        objectProductDetailsData.vendorproductno = UtilSql.getValue(result, "vendorproductno");
        objectProductDetailsData.vendorcategory = UtilSql.getValue(result, "vendorcategory");
        objectProductDetailsData.manufacturer = UtilSql.getValue(result, "manufacturer");
        objectProductDetailsData.discontinued = UtilSql.getValue(result, "discontinued");
        objectProductDetailsData.discontinuedby = UtilSql.getDateValue(result, "discontinuedby", "dd-MM-yyyy");
        objectProductDetailsData.language = UtilSql.getValue(result, "language");
        objectProductDetailsData.adUserClient = "";
        objectProductDetailsData.adOrgClient = "";
        objectProductDetailsData.createdby = "";
        objectProductDetailsData.trBgcolor = "";
        objectProductDetailsData.totalCount = "";
        objectProductDetailsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductDetailsData);
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
    ProductDetailsData objectProductDetailsData[] = new ProductDetailsData[vector.size()];
    vector.copyInto(objectProductDetailsData);
    return(objectProductDetailsData);
  }

/**
Create a registry
 */
  public static ProductDetailsData[] set(String cBpartnerId, String createdby, String createdbyr, String cBpartnerIdr, String cUomId, String discontinuedby, String orderMin, String iscurrentvendor, String mProductPoId, String mProductId, String mProductIdr, String vendorcategory, String pricelastinv, String pricelist, String isactive, String pricepo, String adOrgId, String updatedby, String updatedbyr, String deliverytimeActual, String manufacturer, String adClientId, String discontinued, String deliverytimePromised, String pricelastpo, String priceeffective, String vendorproductno, String cCurrencyId, String costperorder, String upc, String qualityrating, String royaltyamt, String orderPack)    throws ServletException {
    ProductDetailsData objectProductDetailsData[] = new ProductDetailsData[1];
    objectProductDetailsData[0] = new ProductDetailsData();
    objectProductDetailsData[0].created = "";
    objectProductDetailsData[0].createdbyr = createdbyr;
    objectProductDetailsData[0].updated = "";
    objectProductDetailsData[0].updatedTimeStamp = "";
    objectProductDetailsData[0].updatedby = updatedby;
    objectProductDetailsData[0].updatedbyr = updatedbyr;
    objectProductDetailsData[0].mProductPoId = mProductPoId;
    objectProductDetailsData[0].adClientId = adClientId;
    objectProductDetailsData[0].adClientIdr = "";
    objectProductDetailsData[0].adOrgId = adOrgId;
    objectProductDetailsData[0].adOrgIdr = "";
    objectProductDetailsData[0].cBpartnerId = cBpartnerId;
    objectProductDetailsData[0].cBpartnerIdr = cBpartnerIdr;
    objectProductDetailsData[0].qualityrating = qualityrating;
    objectProductDetailsData[0].mProductId = mProductId;
    objectProductDetailsData[0].mProductIdr = mProductIdr;
    objectProductDetailsData[0].isactive = isactive;
    objectProductDetailsData[0].iscurrentvendor = iscurrentvendor;
    objectProductDetailsData[0].upc = upc;
    objectProductDetailsData[0].cCurrencyId = cCurrencyId;
    objectProductDetailsData[0].cCurrencyIdr = "";
    objectProductDetailsData[0].pricelist = pricelist;
    objectProductDetailsData[0].priceeffective = priceeffective;
    objectProductDetailsData[0].pricepo = pricepo;
    objectProductDetailsData[0].royaltyamt = royaltyamt;
    objectProductDetailsData[0].pricelastpo = pricelastpo;
    objectProductDetailsData[0].pricelastinv = pricelastinv;
    objectProductDetailsData[0].cUomId = cUomId;
    objectProductDetailsData[0].cUomIdr = "";
    objectProductDetailsData[0].orderMin = orderMin;
    objectProductDetailsData[0].orderPack = orderPack;
    objectProductDetailsData[0].deliverytimePromised = deliverytimePromised;
    objectProductDetailsData[0].deliverytimeActual = deliverytimeActual;
    objectProductDetailsData[0].costperorder = costperorder;
    objectProductDetailsData[0].vendorproductno = vendorproductno;
    objectProductDetailsData[0].vendorcategory = vendorcategory;
    objectProductDetailsData[0].manufacturer = manufacturer;
    objectProductDetailsData[0].discontinued = discontinued;
    objectProductDetailsData[0].discontinuedby = discontinuedby;
    objectProductDetailsData[0].language = "";
    return objectProductDetailsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2314_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as CreatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "createdby");
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

/**
Select for auxiliar field
 */
  public static String selectDef2705_1(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as C_BPartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_bpartner_id");
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

/**
Select for auxiliar field
 */
  public static String selectDef1420_2(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as M_Product_ID FROM M_Product table1 WHERE table1.isActive='Y' AND table1.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_product_id");
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

/**
Select for auxiliar field
 */
  public static String selectDef2316_3(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as UpdatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updatedby");
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

/**
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_Product_PO.C_BPartner_ID AS NAME" +
      "        FROM M_Product_PO" +
      "        WHERE M_Product_PO.M_Product_PO_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

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

/**
Select for parent field
 */
  public static String selectParent(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_BPartner left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_BPartner.C_BPartner_ID = table1.C_BPartner_ID) WHERE C_BPartner.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
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

/**
Select for parent field
 */
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_BPartner left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_BPartner.C_BPartner_ID = table1.C_BPartner_ID) WHERE C_BPartner.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_Product_PO" +
      "        SET M_Product_PO_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_BPartner_ID = (?) , QualityRating = TO_NUMBER(?) , M_Product_ID = (?) , IsActive = (?) , IsCurrentVendor = (?) , UPC = (?) , C_Currency_ID = (?) , PriceList = TO_NUMBER(?) , PriceEffective = TO_DATE(?) , PricePO = TO_NUMBER(?) , RoyaltyAmt = TO_NUMBER(?) , PriceLastPO = TO_NUMBER(?) , PriceLastInv = TO_NUMBER(?) , C_UOM_ID = (?) , Order_Min = TO_NUMBER(?) , Order_Pack = TO_NUMBER(?) , DeliveryTime_Promised = TO_NUMBER(?) , DeliveryTime_Actual = TO_NUMBER(?) , CostPerOrder = TO_NUMBER(?) , VendorProductNo = (?) , VendorCategory = (?) , Manufacturer = (?) , Discontinued = (?) , DiscontinuedBy = TO_DATE(?) , updated = now(), updatedby = ? " +
      "        WHERE M_Product_PO.M_Product_PO_ID = ? " +
      "                 AND M_Product_PO.C_BPartner_ID = ? " +
      "        AND M_Product_PO.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_Product_PO.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductPoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qualityrating);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscurrentvendor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceeffective);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricepo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, royaltyamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelastpo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelastinv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderMin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderPack);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverytimePromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverytimeActual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costperorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorproductno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, manufacturer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinued);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinuedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductPoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO M_Product_PO " +
      "        (M_Product_PO_ID, AD_Client_ID, AD_Org_ID, C_BPartner_ID, QualityRating, M_Product_ID, IsActive, IsCurrentVendor, UPC, C_Currency_ID, PriceList, PriceEffective, PricePO, RoyaltyAmt, PriceLastPO, PriceLastInv, C_UOM_ID, Order_Min, Order_Pack, DeliveryTime_Promised, DeliveryTime_Actual, CostPerOrder, VendorProductNo, VendorCategory, Manufacturer, Discontinued, DiscontinuedBy, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), TO_DATE(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductPoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qualityrating);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscurrentvendor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceeffective);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricepo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, royaltyamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelastpo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelastinv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderMin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderPack);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverytimePromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverytimeActual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costperorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorproductno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, manufacturer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinued);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinuedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int delete(ConnectionProvider connectionProvider, String param1, String cBpartnerId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM M_Product_PO" +
      "        WHERE M_Product_PO.M_Product_PO_ID = ? " +
      "                 AND M_Product_PO.C_BPartner_ID = ? " +
      "        AND M_Product_PO.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_Product_PO.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
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
    return(updateCount);
  }

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM M_Product_PO" +
      "        WHERE M_Product_PO.M_Product_PO_ID = ? " +
      "                 AND M_Product_PO.C_BPartner_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

/**
Select for relation
 */
  public static String selectOrg(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_ID" +
      "          FROM M_Product_PO" +
      "         WHERE M_Product_PO.M_Product_PO_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_id");
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

  public static String getCurrentDBTimestamp(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp" +
      "          FROM M_Product_PO" +
      "         WHERE M_Product_PO.M_Product_PO_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updated_time_stamp");
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
