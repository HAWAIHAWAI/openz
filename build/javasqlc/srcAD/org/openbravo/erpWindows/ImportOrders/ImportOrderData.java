//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ImportOrders;

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
class ImportOrderData implements FieldProvider {
static Logger log4j = Logger.getLogger(ImportOrderData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String isactive;
  public String iOrderId;
  public String iIsimported;
  public String cOrderId;
  public String cOrderIdr;
  public String cOrderlineId;
  public String cOrderlineIdr;
  public String iErrormsg;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String doctypename;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String documentno;
  public String issotrx;
  public String description;
  public String vendorUpc;
  public String salesrepId;
  public String salesrepIdr;
  public String orderReferenceno;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String mPricelistId;
  public String mPricelistIdr;
  public String paymenttermvalue;
  public String cPaymenttermId;
  public String cPaymenttermIdr;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String mShipperId;
  public String mShipperIdr;
  public String dateordered;
  public String datepromised;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String bpartnerupc;
  public String name;
  public String bpartnervalue;
  public String billtoId;
  public String billtoIdr;
  public String billtoUpc;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String cBpartnerLocationUpc;
  public String cLocationId;
  public String cLocationIdr;
  public String address1;
  public String address2;
  public String city;
  public String postal;
  public String regionname;
  public String cRegionId;
  public String cRegionIdr;
  public String countrycode;
  public String cCountryId;
  public String cCountryIdr;
  public String adUserId;
  public String adUserIdr;
  public String contactname;
  public String phone;
  public String email;
  public String mProductId;
  public String mProductIdr;
  public String upc;
  public String productvalue;
  public String sku;
  public String cUomId;
  public String cUomIdr;
  public String qtyordered;
  public String priceactual;
  public String linedescription;
  public String taxindicator;
  public String cTaxId;
  public String cTaxIdr;
  public String taxamt;
  public String cProjectId;
  public String cProjectIdr;
  public String cCampaignId;
  public String cCampaignIdr;
  public String cActivityId;
  public String cActivityIdr;
  public String adOrgtrxId;
  public String adOrgtrxIdr;
  public String processing;
  public String processed;
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
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("i_order_id") || fieldName.equals("iOrderId"))
      return iOrderId;
    else if (fieldName.equalsIgnoreCase("i_isimported") || fieldName.equals("iIsimported"))
      return iIsimported;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_order_idr") || fieldName.equals("cOrderIdr"))
      return cOrderIdr;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("c_orderline_idr") || fieldName.equals("cOrderlineIdr"))
      return cOrderlineIdr;
    else if (fieldName.equalsIgnoreCase("i_errormsg") || fieldName.equals("iErrormsg"))
      return iErrormsg;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("doctypename"))
      return doctypename;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("vendor_upc") || fieldName.equals("vendorUpc"))
      return vendorUpc;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("order_referenceno") || fieldName.equals("orderReferenceno"))
      return orderReferenceno;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_idr") || fieldName.equals("mPricelistIdr"))
      return mPricelistIdr;
    else if (fieldName.equalsIgnoreCase("paymenttermvalue"))
      return paymenttermvalue;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_idr") || fieldName.equals("cPaymenttermIdr"))
      return cPaymenttermIdr;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("m_shipper_idr") || fieldName.equals("mShipperIdr"))
      return mShipperIdr;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("bpartnerupc"))
      return bpartnerupc;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("bpartnervalue"))
      return bpartnervalue;
    else if (fieldName.equalsIgnoreCase("billto_id") || fieldName.equals("billtoId"))
      return billtoId;
    else if (fieldName.equalsIgnoreCase("billto_idr") || fieldName.equals("billtoIdr"))
      return billtoIdr;
    else if (fieldName.equalsIgnoreCase("billto_upc") || fieldName.equals("billtoUpc"))
      return billtoUpc;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_upc") || fieldName.equals("cBpartnerLocationUpc"))
      return cBpartnerLocationUpc;
    else if (fieldName.equalsIgnoreCase("c_location_id") || fieldName.equals("cLocationId"))
      return cLocationId;
    else if (fieldName.equalsIgnoreCase("c_location_idr") || fieldName.equals("cLocationIdr"))
      return cLocationIdr;
    else if (fieldName.equalsIgnoreCase("address1"))
      return address1;
    else if (fieldName.equalsIgnoreCase("address2"))
      return address2;
    else if (fieldName.equalsIgnoreCase("city"))
      return city;
    else if (fieldName.equalsIgnoreCase("postal"))
      return postal;
    else if (fieldName.equalsIgnoreCase("regionname"))
      return regionname;
    else if (fieldName.equalsIgnoreCase("c_region_id") || fieldName.equals("cRegionId"))
      return cRegionId;
    else if (fieldName.equalsIgnoreCase("c_region_idr") || fieldName.equals("cRegionIdr"))
      return cRegionIdr;
    else if (fieldName.equalsIgnoreCase("countrycode"))
      return countrycode;
    else if (fieldName.equalsIgnoreCase("c_country_id") || fieldName.equals("cCountryId"))
      return cCountryId;
    else if (fieldName.equalsIgnoreCase("c_country_idr") || fieldName.equals("cCountryIdr"))
      return cCountryIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("contactname"))
      return contactname;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("email"))
      return email;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("upc"))
      return upc;
    else if (fieldName.equalsIgnoreCase("productvalue"))
      return productvalue;
    else if (fieldName.equalsIgnoreCase("sku"))
      return sku;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("linedescription"))
      return linedescription;
    else if (fieldName.equalsIgnoreCase("taxindicator"))
      return taxindicator;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("c_tax_idr") || fieldName.equals("cTaxIdr"))
      return cTaxIdr;
    else if (fieldName.equalsIgnoreCase("taxamt"))
      return taxamt;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_campaign_idr") || fieldName.equals("cCampaignIdr"))
      return cCampaignIdr;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("c_activity_idr") || fieldName.equals("cActivityIdr"))
      return cActivityIdr;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_idr") || fieldName.equals("adOrgtrxIdr"))
      return adOrgtrxIdr;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
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
  public static ImportOrderData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ImportOrderData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(I_Order.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = I_Order.CreatedBy) as CreatedByR, " +
      "        to_char(I_Order.Updated, ?) as updated, " +
      "        to_char(I_Order.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        I_Order.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = I_Order.UpdatedBy) as UpdatedByR," +
      "        COALESCE(I_Order.IsActive, 'N') AS IsActive, " +
      "I_Order.I_Order_ID, " +
      "COALESCE(I_Order.I_IsImported, 'N') AS I_IsImported, " +
      "I_Order.C_Order_ID, " +
      "(CASE WHEN I_Order.C_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table1.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.GrandTotal), ''))),'') ) END) AS C_Order_IDR, " +
      "I_Order.C_OrderLine_ID, " +
      "(CASE WHEN I_Order.C_OrderLine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.GrandTotal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.LineNetAmt), ''))),'') ) END) AS C_OrderLine_IDR, " +
      "I_Order.I_ErrorMsg, " +
      "I_Order.AD_Client_ID, " +
      "(CASE WHEN I_Order.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "I_Order.AD_Org_ID, " +
      "(CASE WHEN I_Order.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "I_Order.DocTypeName, " +
      "I_Order.C_DocType_ID, " +
      "(CASE WHEN I_Order.C_DocType_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'') ) END) AS C_DocType_IDR, " +
      "I_Order.DocumentNo, " +
      "COALESCE(I_Order.IsSOTrx, 'N') AS IsSOTrx, " +
      "I_Order.Description, " +
      "I_Order.Vendor_Upc, " +
      "I_Order.SalesRep_ID, " +
      "(CASE WHEN I_Order.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "I_Order.Order_Referenceno, " +
      "I_Order.C_Currency_ID, " +
      "(CASE WHEN I_Order.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "I_Order.M_PriceList_ID, " +
      "(CASE WHEN I_Order.M_PriceList_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS M_PriceList_IDR, " +
      "I_Order.PaymentTermValue, " +
      "I_Order.C_PaymentTerm_ID, " +
      "(CASE WHEN I_Order.C_PaymentTerm_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL10.Name IS NULL THEN TO_CHAR(table10.Name) ELSE TO_CHAR(tableTRL10.Name) END)), ''))),'') ) END) AS C_PaymentTerm_IDR, " +
      "I_Order.M_Warehouse_ID, " +
      "(CASE WHEN I_Order.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "I_Order.M_Shipper_ID, " +
      "(CASE WHEN I_Order.M_Shipper_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Name), ''))),'') ) END) AS M_Shipper_IDR, " +
      "I_Order.DateOrdered, " +
      "I_Order.DatePromised, " +
      "I_Order.C_BPartner_ID, " +
      "(CASE WHEN I_Order.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "I_Order.Bpartnerupc, " +
      "I_Order.Name, " +
      "I_Order.BPartnerValue, " +
      "I_Order.BillTo_ID, " +
      "(CASE WHEN I_Order.BillTo_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Name), ''))),'') ) END) AS BillTo_IDR, " +
      "I_Order.Billto_Upc, " +
      "I_Order.C_BPartner_Location_ID, " +
      "(CASE WHEN I_Order.C_BPartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Name), ''))),'') ) END) AS C_BPartner_Location_IDR, " +
      "I_Order.C_Bpartner_Location_Upc, " +
      "I_Order.C_Location_ID, " +
      "(CASE WHEN I_Order.C_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Address1), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Address2), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Postal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.City), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table17.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL18.Name IS NULL THEN TO_CHAR(table18.Name) ELSE TO_CHAR(tableTRL18.Name) END)), ''))),'') ) END) AS C_Location_IDR, " +
      "I_Order.Address1, " +
      "I_Order.Address2, " +
      "I_Order.City, " +
      "I_Order.Postal, " +
      "I_Order.RegionName, " +
      "I_Order.C_Region_ID, " +
      "(CASE WHEN I_Order.C_Region_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.Name), ''))),'') ) END) AS C_Region_IDR, " +
      "I_Order.CountryCode, " +
      "I_Order.C_Country_ID, " +
      "(CASE WHEN I_Order.C_Country_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL20.Name IS NULL THEN TO_CHAR(table20.Name) ELSE TO_CHAR(tableTRL20.Name) END)), ''))),'') ) END) AS C_Country_IDR, " +
      "I_Order.AD_User_ID, " +
      "(CASE WHEN I_Order.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table21.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "I_Order.ContactName, " +
      "I_Order.Phone, " +
      "I_Order.Email, " +
      "I_Order.M_Product_ID, " +
      "(CASE WHEN I_Order.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table22.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL22.Name IS NULL THEN TO_CHAR(table22.Name) ELSE TO_CHAR(tableTRL22.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "I_Order.UPC, " +
      "I_Order.ProductValue, " +
      "I_Order.SKU, " +
      "I_Order.C_UOM_ID, " +
      "(CASE WHEN I_Order.C_UOM_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL23.Name IS NULL THEN TO_CHAR(table23.Name) ELSE TO_CHAR(tableTRL23.Name) END)), ''))),'') ) END) AS C_UOM_IDR, " +
      "I_Order.QtyOrdered, " +
      "I_Order.PriceActual, " +
      "I_Order.LineDescription, " +
      "I_Order.TaxIndicator, " +
      "I_Order.C_Tax_ID, " +
      "(CASE WHEN I_Order.C_Tax_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL24.Name IS NULL THEN TO_CHAR(table24.Name) ELSE TO_CHAR(tableTRL24.Name) END)), ''))),'') ) END) AS C_Tax_IDR, " +
      "I_Order.TaxAmt, " +
      "I_Order.C_Project_ID, " +
      "(CASE WHEN I_Order.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table25.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table25.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "I_Order.C_Campaign_ID, " +
      "(CASE WHEN I_Order.C_Campaign_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table26.Name), ''))),'') ) END) AS C_Campaign_IDR, " +
      "I_Order.C_Activity_ID, " +
      "(CASE WHEN I_Order.C_Activity_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table27.Name), ''))),'') ) END) AS C_Activity_IDR, " +
      "I_Order.AD_OrgTrx_ID, " +
      "(CASE WHEN I_Order.AD_OrgTrx_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table28.Name), ''))),'') ) END) AS AD_OrgTrx_IDR, " +
      "I_Order.Processing, " +
      "COALESCE(I_Order.Processed, 'N') AS Processed, " +
      "        ? AS LANGUAGE " +
      "        FROM I_Order left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table1 on (I_Order.C_Order_ID = table1.C_Order_ID) left join (select C_OrderLine_ID, C_Order_ID, Line, LineNetAmt from C_OrderLine) table2 on (I_Order.C_OrderLine_ID = table2.C_OrderLine_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table3 on (table2.C_Order_ID = table3.C_Order_ID) left join (select AD_Client_ID, Name from AD_Client) table4 on (I_Order.AD_Client_ID = table4.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table5 on (I_Order.AD_Org_ID = table5.AD_Org_ID) left join (select C_DocType_ID, Name from C_DocType) table6 on (I_Order.C_DocType_ID = table6.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL6 on (table6.C_DocType_ID = tableTRL6.C_DocType_ID and tableTRL6.AD_Language = ?)  left join (select AD_User_ID, Name from AD_User) table7 on (I_Order.SalesRep_ID =  table7.AD_User_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table8 on (I_Order.C_Currency_ID = table8.C_Currency_ID) left join (select M_PriceList_ID, Name from M_PriceList) table9 on (I_Order.M_PriceList_ID = table9.M_PriceList_ID) left join (select C_PaymentTerm_ID, Name from C_PaymentTerm) table10 on (I_Order.C_PaymentTerm_ID = table10.C_PaymentTerm_ID) left join (select C_PaymentTerm_ID,AD_Language, Name from C_PaymentTerm_TRL) tableTRL10 on (table10.C_PaymentTerm_ID = tableTRL10.C_PaymentTerm_ID and tableTRL10.AD_Language = ?)  left join (select M_Warehouse_ID, Name from M_Warehouse) table11 on (I_Order.M_Warehouse_ID = table11.M_Warehouse_ID) left join (select M_Shipper_ID, Name from M_Shipper) table12 on (I_Order.M_Shipper_ID = table12.M_Shipper_ID) left join (select C_BPartner_ID, Name from C_BPartner) table13 on (I_Order.C_BPartner_ID = table13.C_BPartner_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table14 on (I_Order.BillTo_ID =  table14.C_BPartner_Location_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table15 on (I_Order.C_BPartner_Location_ID = table15.C_BPartner_Location_ID) left join (select C_Location_ID, Address1, Address2, Postal, City, C_Region_ID, C_Country_ID from C_Location) table16 on (I_Order.C_Location_ID = table16.C_Location_ID) left join (select C_Region_ID, Name from C_Region) table17 on (table16.C_Region_ID = table17.C_Region_ID) left join (select C_Country_ID, Name from C_Country) table18 on (table16.C_Country_ID = table18.C_Country_ID) left join (select C_Country_ID,AD_Language, Name from C_Country_TRL) tableTRL18 on (table18.C_Country_ID = tableTRL18.C_Country_ID and tableTRL18.AD_Language = ?)  left join (select C_Region_ID, Name from C_Region) table19 on (I_Order.C_Region_ID = table19.C_Region_ID) left join (select C_Country_ID, Name from C_Country) table20 on (I_Order.C_Country_ID = table20.C_Country_ID) left join (select C_Country_ID,AD_Language, Name from C_Country_TRL) tableTRL20 on (table20.C_Country_ID = tableTRL20.C_Country_ID and tableTRL20.AD_Language = ?)  left join (select AD_User_ID, Name from AD_User) table21 on (I_Order.AD_User_ID = table21.AD_User_ID) left join (select M_Product_ID, Value, Name from M_Product) table22 on (I_Order.M_Product_ID = table22.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL22 on (table22.M_Product_ID = tableTRL22.M_Product_ID and tableTRL22.AD_Language = ?)  left join (select C_UOM_ID, Name from C_UOM) table23 on (I_Order.C_UOM_ID = table23.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL23 on (table23.C_UOM_ID = tableTRL23.C_UOM_ID and tableTRL23.AD_Language = ?)  left join (select C_Tax_ID, Name from C_Tax) table24 on (I_Order.C_Tax_ID = table24.C_Tax_ID) left join (select C_Tax_ID,AD_Language, Name from C_Tax_TRL) tableTRL24 on (table24.C_Tax_ID = tableTRL24.C_Tax_ID and tableTRL24.AD_Language = ?)  left join (select C_Project_ID, Value, Name from C_Project) table25 on (I_Order.C_Project_ID = table25.C_Project_ID) left join (select C_Campaign_ID, Name from C_Campaign) table26 on (I_Order.C_Campaign_ID = table26.C_Campaign_ID) left join (select C_Activity_ID, Name from C_Activity) table27 on (I_Order.C_Activity_ID = table27.C_Activity_ID) left join (select AD_Org_ID, value, Name from AD_Org) table28 on (I_Order.AD_OrgTrx_ID =  table28.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND I_Order.I_Order_ID = ? " +
      "        AND I_Order.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND I_Order.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
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
        ImportOrderData objectImportOrderData = new ImportOrderData();
        objectImportOrderData.created = UtilSql.getValue(result, "created");
        objectImportOrderData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectImportOrderData.updated = UtilSql.getValue(result, "updated");
        objectImportOrderData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectImportOrderData.updatedby = UtilSql.getValue(result, "updatedby");
        objectImportOrderData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectImportOrderData.isactive = UtilSql.getValue(result, "isactive");
        objectImportOrderData.iOrderId = UtilSql.getValue(result, "i_order_id");
        objectImportOrderData.iIsimported = UtilSql.getValue(result, "i_isimported");
        objectImportOrderData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectImportOrderData.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectImportOrderData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectImportOrderData.cOrderlineIdr = UtilSql.getValue(result, "c_orderline_idr");
        objectImportOrderData.iErrormsg = UtilSql.getValue(result, "i_errormsg");
        objectImportOrderData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectImportOrderData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectImportOrderData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectImportOrderData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectImportOrderData.doctypename = UtilSql.getValue(result, "doctypename");
        objectImportOrderData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectImportOrderData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectImportOrderData.documentno = UtilSql.getValue(result, "documentno");
        objectImportOrderData.issotrx = UtilSql.getValue(result, "issotrx");
        objectImportOrderData.description = UtilSql.getValue(result, "description");
        objectImportOrderData.vendorUpc = UtilSql.getValue(result, "vendor_upc");
        objectImportOrderData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectImportOrderData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectImportOrderData.orderReferenceno = UtilSql.getValue(result, "order_referenceno");
        objectImportOrderData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectImportOrderData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectImportOrderData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectImportOrderData.mPricelistIdr = UtilSql.getValue(result, "m_pricelist_idr");
        objectImportOrderData.paymenttermvalue = UtilSql.getValue(result, "paymenttermvalue");
        objectImportOrderData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectImportOrderData.cPaymenttermIdr = UtilSql.getValue(result, "c_paymentterm_idr");
        objectImportOrderData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectImportOrderData.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectImportOrderData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectImportOrderData.mShipperIdr = UtilSql.getValue(result, "m_shipper_idr");
        objectImportOrderData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectImportOrderData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectImportOrderData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectImportOrderData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectImportOrderData.bpartnerupc = UtilSql.getValue(result, "bpartnerupc");
        objectImportOrderData.name = UtilSql.getValue(result, "name");
        objectImportOrderData.bpartnervalue = UtilSql.getValue(result, "bpartnervalue");
        objectImportOrderData.billtoId = UtilSql.getValue(result, "billto_id");
        objectImportOrderData.billtoIdr = UtilSql.getValue(result, "billto_idr");
        objectImportOrderData.billtoUpc = UtilSql.getValue(result, "billto_upc");
        objectImportOrderData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectImportOrderData.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectImportOrderData.cBpartnerLocationUpc = UtilSql.getValue(result, "c_bpartner_location_upc");
        objectImportOrderData.cLocationId = UtilSql.getValue(result, "c_location_id");
        objectImportOrderData.cLocationIdr = UtilSql.getValue(result, "c_location_idr");
        objectImportOrderData.address1 = UtilSql.getValue(result, "address1");
        objectImportOrderData.address2 = UtilSql.getValue(result, "address2");
        objectImportOrderData.city = UtilSql.getValue(result, "city");
        objectImportOrderData.postal = UtilSql.getValue(result, "postal");
        objectImportOrderData.regionname = UtilSql.getValue(result, "regionname");
        objectImportOrderData.cRegionId = UtilSql.getValue(result, "c_region_id");
        objectImportOrderData.cRegionIdr = UtilSql.getValue(result, "c_region_idr");
        objectImportOrderData.countrycode = UtilSql.getValue(result, "countrycode");
        objectImportOrderData.cCountryId = UtilSql.getValue(result, "c_country_id");
        objectImportOrderData.cCountryIdr = UtilSql.getValue(result, "c_country_idr");
        objectImportOrderData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectImportOrderData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectImportOrderData.contactname = UtilSql.getValue(result, "contactname");
        objectImportOrderData.phone = UtilSql.getValue(result, "phone");
        objectImportOrderData.email = UtilSql.getValue(result, "email");
        objectImportOrderData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectImportOrderData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectImportOrderData.upc = UtilSql.getValue(result, "upc");
        objectImportOrderData.productvalue = UtilSql.getValue(result, "productvalue");
        objectImportOrderData.sku = UtilSql.getValue(result, "sku");
        objectImportOrderData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectImportOrderData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectImportOrderData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectImportOrderData.priceactual = UtilSql.getValue(result, "priceactual");
        objectImportOrderData.linedescription = UtilSql.getValue(result, "linedescription");
        objectImportOrderData.taxindicator = UtilSql.getValue(result, "taxindicator");
        objectImportOrderData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectImportOrderData.cTaxIdr = UtilSql.getValue(result, "c_tax_idr");
        objectImportOrderData.taxamt = UtilSql.getValue(result, "taxamt");
        objectImportOrderData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectImportOrderData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectImportOrderData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectImportOrderData.cCampaignIdr = UtilSql.getValue(result, "c_campaign_idr");
        objectImportOrderData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectImportOrderData.cActivityIdr = UtilSql.getValue(result, "c_activity_idr");
        objectImportOrderData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectImportOrderData.adOrgtrxIdr = UtilSql.getValue(result, "ad_orgtrx_idr");
        objectImportOrderData.processing = UtilSql.getValue(result, "processing");
        objectImportOrderData.processed = UtilSql.getValue(result, "processed");
        objectImportOrderData.language = UtilSql.getValue(result, "language");
        objectImportOrderData.adUserClient = "";
        objectImportOrderData.adOrgClient = "";
        objectImportOrderData.createdby = "";
        objectImportOrderData.trBgcolor = "";
        objectImportOrderData.totalCount = "";
        objectImportOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectImportOrderData);
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
    ImportOrderData objectImportOrderData[] = new ImportOrderData[vector.size()];
    vector.copyInto(objectImportOrderData);
    return(objectImportOrderData);
  }

/**
Create a registry
 */
  public static ImportOrderData[] set(String cDoctypeId, String taxindicator, String isactive, String cOrderId, String cOrderIdr, String iOrderId, String cPaymenttermId, String linedescription, String postal, String vendorUpc, String paymenttermvalue, String mProductId, String mProductIdr, String address1, String cRegionId, String iIsimported, String productvalue, String contactname, String processed, String cBpartnerLocationId, String updatedby, String updatedbyr, String cUomId, String cOrderlineId, String cOrderlineIdr, String sku, String bpartnerupc, String mWarehouseId, String countrycode, String adOrgId, String issotrx, String processing, String cBpartnerId, String cBpartnerIdr, String orderReferenceno, String cCampaignId, String cTaxId, String address2, String datepromised, String cCurrencyId, String billtoId, String name, String adOrgtrxId, String billtoUpc, String cBpartnerLocationUpc, String mShipperId, String doctypename, String salesrepId, String email, String cLocationId, String cLocationIdr, String dateordered, String cActivityId, String documentno, String createdby, String createdbyr, String cCountryId, String taxamt, String city, String description, String iErrormsg, String mPricelistId, String regionname, String cProjectId, String cProjectIdr, String adClientId, String upc, String bpartnervalue, String priceactual, String adUserId, String phone, String qtyordered)    throws ServletException {
    ImportOrderData objectImportOrderData[] = new ImportOrderData[1];
    objectImportOrderData[0] = new ImportOrderData();
    objectImportOrderData[0].created = "";
    objectImportOrderData[0].createdbyr = createdbyr;
    objectImportOrderData[0].updated = "";
    objectImportOrderData[0].updatedTimeStamp = "";
    objectImportOrderData[0].updatedby = updatedby;
    objectImportOrderData[0].updatedbyr = updatedbyr;
    objectImportOrderData[0].isactive = isactive;
    objectImportOrderData[0].iOrderId = iOrderId;
    objectImportOrderData[0].iIsimported = iIsimported;
    objectImportOrderData[0].cOrderId = cOrderId;
    objectImportOrderData[0].cOrderIdr = cOrderIdr;
    objectImportOrderData[0].cOrderlineId = cOrderlineId;
    objectImportOrderData[0].cOrderlineIdr = cOrderlineIdr;
    objectImportOrderData[0].iErrormsg = iErrormsg;
    objectImportOrderData[0].adClientId = adClientId;
    objectImportOrderData[0].adClientIdr = "";
    objectImportOrderData[0].adOrgId = adOrgId;
    objectImportOrderData[0].adOrgIdr = "";
    objectImportOrderData[0].doctypename = doctypename;
    objectImportOrderData[0].cDoctypeId = cDoctypeId;
    objectImportOrderData[0].cDoctypeIdr = "";
    objectImportOrderData[0].documentno = documentno;
    objectImportOrderData[0].issotrx = issotrx;
    objectImportOrderData[0].description = description;
    objectImportOrderData[0].vendorUpc = vendorUpc;
    objectImportOrderData[0].salesrepId = salesrepId;
    objectImportOrderData[0].salesrepIdr = "";
    objectImportOrderData[0].orderReferenceno = orderReferenceno;
    objectImportOrderData[0].cCurrencyId = cCurrencyId;
    objectImportOrderData[0].cCurrencyIdr = "";
    objectImportOrderData[0].mPricelistId = mPricelistId;
    objectImportOrderData[0].mPricelistIdr = "";
    objectImportOrderData[0].paymenttermvalue = paymenttermvalue;
    objectImportOrderData[0].cPaymenttermId = cPaymenttermId;
    objectImportOrderData[0].cPaymenttermIdr = "";
    objectImportOrderData[0].mWarehouseId = mWarehouseId;
    objectImportOrderData[0].mWarehouseIdr = "";
    objectImportOrderData[0].mShipperId = mShipperId;
    objectImportOrderData[0].mShipperIdr = "";
    objectImportOrderData[0].dateordered = dateordered;
    objectImportOrderData[0].datepromised = datepromised;
    objectImportOrderData[0].cBpartnerId = cBpartnerId;
    objectImportOrderData[0].cBpartnerIdr = cBpartnerIdr;
    objectImportOrderData[0].bpartnerupc = bpartnerupc;
    objectImportOrderData[0].name = name;
    objectImportOrderData[0].bpartnervalue = bpartnervalue;
    objectImportOrderData[0].billtoId = billtoId;
    objectImportOrderData[0].billtoIdr = "";
    objectImportOrderData[0].billtoUpc = billtoUpc;
    objectImportOrderData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectImportOrderData[0].cBpartnerLocationIdr = "";
    objectImportOrderData[0].cBpartnerLocationUpc = cBpartnerLocationUpc;
    objectImportOrderData[0].cLocationId = cLocationId;
    objectImportOrderData[0].cLocationIdr = cLocationIdr;
    objectImportOrderData[0].address1 = address1;
    objectImportOrderData[0].address2 = address2;
    objectImportOrderData[0].city = city;
    objectImportOrderData[0].postal = postal;
    objectImportOrderData[0].regionname = regionname;
    objectImportOrderData[0].cRegionId = cRegionId;
    objectImportOrderData[0].cRegionIdr = "";
    objectImportOrderData[0].countrycode = countrycode;
    objectImportOrderData[0].cCountryId = cCountryId;
    objectImportOrderData[0].cCountryIdr = "";
    objectImportOrderData[0].adUserId = adUserId;
    objectImportOrderData[0].adUserIdr = "";
    objectImportOrderData[0].contactname = contactname;
    objectImportOrderData[0].phone = phone;
    objectImportOrderData[0].email = email;
    objectImportOrderData[0].mProductId = mProductId;
    objectImportOrderData[0].mProductIdr = mProductIdr;
    objectImportOrderData[0].upc = upc;
    objectImportOrderData[0].productvalue = productvalue;
    objectImportOrderData[0].sku = sku;
    objectImportOrderData[0].cUomId = cUomId;
    objectImportOrderData[0].cUomIdr = "";
    objectImportOrderData[0].qtyordered = qtyordered;
    objectImportOrderData[0].priceactual = priceactual;
    objectImportOrderData[0].linedescription = linedescription;
    objectImportOrderData[0].taxindicator = taxindicator;
    objectImportOrderData[0].cTaxId = cTaxId;
    objectImportOrderData[0].cTaxIdr = "";
    objectImportOrderData[0].taxamt = taxamt;
    objectImportOrderData[0].cProjectId = cProjectId;
    objectImportOrderData[0].cProjectIdr = cProjectIdr;
    objectImportOrderData[0].cCampaignId = cCampaignId;
    objectImportOrderData[0].cCampaignIdr = "";
    objectImportOrderData[0].cActivityId = cActivityId;
    objectImportOrderData[0].cActivityIdr = "";
    objectImportOrderData[0].adOrgtrxId = adOrgtrxId;
    objectImportOrderData[0].adOrgtrxIdr = "";
    objectImportOrderData[0].processing = processing;
    objectImportOrderData[0].processed = processed;
    objectImportOrderData[0].language = "";
    return objectImportOrderData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef9000_0(ConnectionProvider connectionProvider, String C_Order_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.DocumentNo), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '')  || ' - ' || COALESCE(TO_CHAR(table1.DateOrdered), '')  || ' - ' || COALESCE(TO_CHAR(table1.GrandTotal), '') ) as C_Order_ID FROM C_Order table1 WHERE table1.isActive='Y' AND table1.C_Order_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Order_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_order_id");
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
  public static String selectDef9008_1(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef9019_2(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDef9001_3(ConnectionProvider connectionProvider, String C_OrderLine_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table2.DocumentNo), '')  || ' - ' || COALESCE(TO_CHAR(table2.Name), '')  || ' - ' || COALESCE(TO_CHAR(table2.DateOrdered), '')  || ' - ' || COALESCE(TO_CHAR(table2.GrandTotal), '')  || ' - ' || COALESCE(TO_CHAR(table1.Line), '')  || ' - ' || COALESCE(TO_CHAR(table1.LineNetAmt), '') ) as C_OrderLine_ID FROM C_OrderLine table1 left join C_Order table2 on (table1.C_Order_ID = table2.C_Order_ID) WHERE table1.isActive='Y' AND table1.C_OrderLine_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_OrderLine_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_orderline_id");
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
  public static String selectDef9010_4(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
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
  public static String selectDef9408_5(ConnectionProvider connectionProvider, String C_Location_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Address1), '')  || ' - ' || COALESCE(TO_CHAR(table1.Address2), '')  || ' - ' || COALESCE(TO_CHAR(table1.Postal), '')  || ' - ' || COALESCE(TO_CHAR(table1.City), '')  || ' - ' || COALESCE(TO_CHAR(table1.C_Region_ID), '')  || ' - ' || COALESCE(TO_CHAR(table1.C_Country_ID), '') ) as C_Location_ID FROM C_Location table1 WHERE table1.isActive='Y' AND table1.C_Location_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Location_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_location_id");
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
  public static String selectDef9004_6(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef9012_7(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as C_Project_ID FROM C_Project table1 WHERE table1.isActive='Y' AND table1.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_project_id");
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
      "        UPDATE I_Order" +
      "        SET IsActive = (?) , I_Order_ID = (?) , I_IsImported = (?) , C_Order_ID = (?) , C_OrderLine_ID = (?) , I_ErrorMsg = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , DocTypeName = (?) , C_DocType_ID = (?) , DocumentNo = (?) , IsSOTrx = (?) , Description = (?) , Vendor_Upc = (?) , SalesRep_ID = (?) , Order_Referenceno = (?) , C_Currency_ID = (?) , M_PriceList_ID = (?) , PaymentTermValue = (?) , C_PaymentTerm_ID = (?) , M_Warehouse_ID = (?) , M_Shipper_ID = (?) , DateOrdered = TO_DATE(?) , DatePromised = TO_DATE(?) , C_BPartner_ID = (?) , Bpartnerupc = (?) , Name = (?) , BPartnerValue = (?) , BillTo_ID = (?) , Billto_Upc = (?) , C_BPartner_Location_ID = (?) , C_Bpartner_Location_Upc = (?) , C_Location_ID = (?) , Address1 = (?) , Address2 = (?) , City = (?) , Postal = (?) , RegionName = (?) , C_Region_ID = (?) , CountryCode = (?) , C_Country_ID = (?) , AD_User_ID = (?) , ContactName = (?) , Phone = (?) , Email = (?) , M_Product_ID = (?) , UPC = (?) , ProductValue = (?) , SKU = (?) , C_UOM_ID = (?) , QtyOrdered = TO_NUMBER(?) , PriceActual = TO_NUMBER(?) , LineDescription = (?) , TaxIndicator = (?) , C_Tax_ID = (?) , TaxAmt = TO_NUMBER(?) , C_Project_ID = (?) , C_Campaign_ID = (?) , C_Activity_ID = (?) , AD_OrgTrx_ID = (?) , Processing = (?) , Processed = (?) , updated = now(), updatedby = ? " +
      "        WHERE I_Order.I_Order_ID = ? " +
      "        AND I_Order.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND I_Order.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iIsimported);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iErrormsg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, doctypename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorUpc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderReferenceno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymenttermvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnerupc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnervalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoUpc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationUpc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, city);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, regionname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRegionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, countrycode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contactname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, email);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sku);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linedescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxindicator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iOrderId);
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
      "        INSERT INTO I_Order " +
      "        (IsActive, I_Order_ID, I_IsImported, C_Order_ID, C_OrderLine_ID, I_ErrorMsg, AD_Client_ID, AD_Org_ID, DocTypeName, C_DocType_ID, DocumentNo, IsSOTrx, Description, Vendor_Upc, SalesRep_ID, Order_Referenceno, C_Currency_ID, M_PriceList_ID, PaymentTermValue, C_PaymentTerm_ID, M_Warehouse_ID, M_Shipper_ID, DateOrdered, DatePromised, C_BPartner_ID, Bpartnerupc, Name, BPartnerValue, BillTo_ID, Billto_Upc, C_BPartner_Location_ID, C_Bpartner_Location_Upc, C_Location_ID, Address1, Address2, City, Postal, RegionName, C_Region_ID, CountryCode, C_Country_ID, AD_User_ID, ContactName, Phone, Email, M_Product_ID, UPC, ProductValue, SKU, C_UOM_ID, QtyOrdered, PriceActual, LineDescription, TaxIndicator, C_Tax_ID, TaxAmt, C_Project_ID, C_Campaign_ID, C_Activity_ID, AD_OrgTrx_ID, Processing, Processed, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iIsimported);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iErrormsg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, doctypename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorUpc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderReferenceno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymenttermvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnerupc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnervalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoUpc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationUpc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, city);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, regionname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRegionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, countrycode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contactname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, email);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sku);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linedescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxindicator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM I_Order" +
      "        WHERE I_Order.I_Order_ID = ? " +
      "        AND I_Order.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND I_Order.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM I_Order" +
      "        WHERE I_Order.I_Order_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);

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
      "          FROM I_Order" +
      "         WHERE I_Order.I_Order_ID = ? ";

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
      "          FROM I_Order" +
      "         WHERE I_Order.I_Order_ID = ? ";

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
