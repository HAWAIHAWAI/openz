//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openz.controller.TestWindowGuiEngine;

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
class ManualTAB785B16E4ABD64BFC8BECB45146D8D644Data implements FieldProvider {
static Logger log4j = Logger.getLogger(ManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mProductId;
  public String mProductIdr;
  public String aAssetId;
  public String aAssetIdr;
  public String datepromised;
  public String isgrossprice;
  public String cancelpricead;
  public String issummaryitem;
  public String line;
  public String dateordered;
  public String datedelivered;
  public String dateinvoiced;
  public String description;
  public String linegrossamt;
  public String cUomId;
  public String cUomIdr;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String qtyordered;
  public String qtyreserved;
  public String qtydelivered;
  public String qtyinvoiced;
  public String mShipperId;
  public String mShipperIdr;
  public String linetaxamt;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String mProductUomId;
  public String mProductUomIdr;
  public String mOfferId;
  public String mOfferIdr;
  public String pricestd;
  public String mAttributesetinstanceId;
  public String mAttributesetinstanceIdr;
  public String isonetimeposition;
  public String cProjectphaseId;
  public String cProjectphaseIdr;
  public String isdescription;
  public String cProjectId;
  public String cProjectIdr;
  public String invoicedamt;
  public String quantityorder;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String pricelist;
  public String priceactual;
  public String cTaxId;
  public String cTaxIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String directship;
  public String freightamt;
  public String cChargeId;
  public String cChargeIdr;
  public String chargeamt;
  public String scheddeliverydate;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String ignoreresidue;
  public String linenetamt;
  public String pricelimit;
  public String discount;
  public String adClientId;
  public String adClientIdr;
  public String isactive;
  public String adOrgId;
  public String adOrgIdr;
  public String cOrderId;
  public String cOrderIdr;
  public String cOrderlineId;
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
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_idr") || fieldName.equals("aAssetIdr"))
      return aAssetIdr;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("isgrossprice"))
      return isgrossprice;
    else if (fieldName.equalsIgnoreCase("cancelpricead"))
      return cancelpricead;
    else if (fieldName.equalsIgnoreCase("issummaryitem"))
      return issummaryitem;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("datedelivered"))
      return datedelivered;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("linegrossamt"))
      return linegrossamt;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("qtyreserved"))
      return qtyreserved;
    else if (fieldName.equalsIgnoreCase("qtydelivered"))
      return qtydelivered;
    else if (fieldName.equalsIgnoreCase("qtyinvoiced"))
      return qtyinvoiced;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("m_shipper_idr") || fieldName.equals("mShipperIdr"))
      return mShipperIdr;
    else if (fieldName.equalsIgnoreCase("linetaxamt"))
      return linetaxamt;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("m_product_uom_id") || fieldName.equals("mProductUomId"))
      return mProductUomId;
    else if (fieldName.equalsIgnoreCase("m_product_uom_idr") || fieldName.equals("mProductUomIdr"))
      return mProductUomIdr;
    else if (fieldName.equalsIgnoreCase("m_offer_id") || fieldName.equals("mOfferId"))
      return mOfferId;
    else if (fieldName.equalsIgnoreCase("m_offer_idr") || fieldName.equals("mOfferIdr"))
      return mOfferIdr;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_idr") || fieldName.equals("mAttributesetinstanceIdr"))
      return mAttributesetinstanceIdr;
    else if (fieldName.equalsIgnoreCase("isonetimeposition"))
      return isonetimeposition;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
    else if (fieldName.equalsIgnoreCase("c_projectphase_idr") || fieldName.equals("cProjectphaseIdr"))
      return cProjectphaseIdr;
    else if (fieldName.equalsIgnoreCase("isdescription"))
      return isdescription;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("invoicedamt"))
      return invoicedamt;
    else if (fieldName.equalsIgnoreCase("quantityorder"))
      return quantityorder;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("c_tax_idr") || fieldName.equals("cTaxIdr"))
      return cTaxIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("directship"))
      return directship;
    else if (fieldName.equalsIgnoreCase("freightamt"))
      return freightamt;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("c_charge_idr") || fieldName.equals("cChargeIdr"))
      return cChargeIdr;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("scheddeliverydate"))
      return scheddeliverydate;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("ignoreresidue"))
      return ignoreresidue;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("discount"))
      return discount;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_order_idr") || fieldName.equals("cOrderIdr"))
      return cOrderIdr;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
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
  public static ManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cOrderId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cOrderId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cOrderId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_OrderLine.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_OrderLine.CreatedBy) as CreatedByR, " +
      "        to_char(C_OrderLine.Updated, ?) as updated, " +
      "        to_char(C_OrderLine.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_OrderLine.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_OrderLine.UpdatedBy) as UpdatedByR," +
      "        C_OrderLine.M_Product_ID, " +
      "(CASE WHEN C_OrderLine.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "C_OrderLine.A_Asset_ID, " +
      "(CASE WHEN C_OrderLine.A_Asset_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "C_OrderLine.DatePromised, " +
      "COALESCE(C_OrderLine.Isgrossprice, 'N') AS Isgrossprice, " +
      "COALESCE(C_OrderLine.CANCELPRICEAD, 'N') AS CANCELPRICEAD, " +
      "COALESCE(C_OrderLine.Issummaryitem, 'N') AS Issummaryitem, " +
      "C_OrderLine.Line, " +
      "C_OrderLine.DateOrdered, " +
      "C_OrderLine.DateDelivered, " +
      "C_OrderLine.DateInvoiced, " +
      "C_OrderLine.Description, " +
      "C_OrderLine.Linegrossamt, " +
      "C_OrderLine.C_UOM_ID, " +
      "(CASE WHEN C_OrderLine.C_UOM_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_UOM_IDR, " +
      "C_OrderLine.M_Warehouse_ID, " +
      "(CASE WHEN C_OrderLine.M_Warehouse_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "C_OrderLine.QtyOrdered, " +
      "C_OrderLine.QtyReserved, " +
      "C_OrderLine.QtyDelivered, " +
      "C_OrderLine.QtyInvoiced, " +
      "C_OrderLine.M_Shipper_ID, " +
      "(CASE WHEN C_OrderLine.M_Shipper_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS M_Shipper_IDR, " +
      "C_OrderLine.Linetaxamt, " +
      "C_OrderLine.C_Projecttask_ID, " +
      "(CASE WHEN C_OrderLine.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "C_OrderLine.M_Product_Uom_Id, " +
      "(CASE WHEN C_OrderLine.M_Product_Uom_Id IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL9.Name IS NULL THEN TO_CHAR(table9.Name) ELSE TO_CHAR(tableTRL9.Name) END)), ''))),'') ) END) AS M_Product_Uom_IdR, " +
      "C_OrderLine.M_Offer_ID, " +
      "(CASE WHEN C_OrderLine.M_Offer_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS M_Offer_IDR, " +
      "C_OrderLine.PriceStd, " +
      "C_OrderLine.M_AttributeSetInstance_ID, " +
      "(CASE WHEN C_OrderLine.M_AttributeSetInstance_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Description), ''))),'') ) END) AS M_AttributeSetInstance_IDR, " +
      "COALESCE(C_OrderLine.IsOneTimePosition, 'N') AS IsOneTimePosition, " +
      "C_OrderLine.C_Projectphase_ID, " +
      "(CASE WHEN C_OrderLine.C_Projectphase_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.SeqNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Name), ''))),'') ) END) AS C_Projectphase_IDR, " +
      "COALESCE(C_OrderLine.IsDescription, 'N') AS IsDescription, " +
      "C_OrderLine.C_Project_ID, " +
      "(CASE WHEN C_OrderLine.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "C_OrderLine.Invoicedamt, " +
      "C_OrderLine.QuantityOrder, " +
      "C_OrderLine.C_Currency_ID, " +
      "(CASE WHEN C_OrderLine.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "C_OrderLine.PriceList, " +
      "C_OrderLine.PriceActual, " +
      "C_OrderLine.C_Tax_ID, " +
      "(CASE WHEN C_OrderLine.C_Tax_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL15.Name IS NULL THEN TO_CHAR(table15.Name) ELSE TO_CHAR(tableTRL15.Name) END)), ''))),'') ) END) AS C_Tax_IDR, " +
      "C_OrderLine.C_BPartner_ID, " +
      "(CASE WHEN C_OrderLine.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "COALESCE(C_OrderLine.DirectShip, 'N') AS DirectShip, " +
      "C_OrderLine.FreightAmt, " +
      "C_OrderLine.C_Charge_ID, " +
      "(CASE WHEN C_OrderLine.C_Charge_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table17.Name), ''))),'') ) END) AS C_Charge_IDR, " +
      "C_OrderLine.ChargeAmt, " +
      "C_OrderLine.Scheddeliverydate, " +
      "C_OrderLine.C_BPartner_Location_ID, " +
      "(CASE WHEN C_OrderLine.C_BPartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table18.Name), ''))),'') ) END) AS C_BPartner_Location_IDR, " +
      "COALESCE(C_OrderLine.Ignoreresidue, 'N') AS Ignoreresidue, " +
      "C_OrderLine.LineNetAmt, " +
      "C_OrderLine.PriceLimit, " +
      "C_OrderLine.Discount, " +
      "C_OrderLine.AD_Client_ID, " +
      "(CASE WHEN C_OrderLine.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "COALESCE(C_OrderLine.IsActive, 'N') AS IsActive, " +
      "C_OrderLine.AD_Org_ID, " +
      "(CASE WHEN C_OrderLine.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table20.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_OrderLine.C_Order_ID, " +
      "(CASE WHEN C_OrderLine.C_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table21.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table21.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table21.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table21.GrandTotal), ''))),'') ) END) AS C_Order_IDR, " +
      "C_OrderLine.C_OrderLine_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_OrderLine left join (select M_Product_ID, Value, Name from M_Product) table1 on (C_OrderLine.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  left join (select A_Asset_ID, Name from A_Asset) table2 on (C_OrderLine.A_Asset_ID = table2.A_Asset_ID) left join (select C_UOM_ID, Name from C_UOM) table3 on (C_OrderLine.C_UOM_ID = table3.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL3 on (table3.C_UOM_ID = tableTRL3.C_UOM_ID and tableTRL3.AD_Language = ?)  left join (select M_Warehouse_ID, Name from M_Warehouse) table4 on (C_OrderLine.M_Warehouse_ID =  table4.M_Warehouse_ID) left join (select M_Shipper_ID, Name from M_Shipper) table5 on (C_OrderLine.M_Shipper_ID = table5.M_Shipper_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table6 on (C_OrderLine.C_Projecttask_ID = table6.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table7 on (table6.C_Project_ID = table7.C_Project_ID) left join (select M_Product_Uom_Id, C_UOM_ID from M_Product_UOM) table8 on (C_OrderLine.M_Product_Uom_Id =  table8.M_Product_Uom_Id) left join (select C_UOM_ID, Name from C_UOM) table9 on (table8.C_UOM_ID = table9.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL9 on (table9.C_UOM_ID = tableTRL9.C_UOM_ID and tableTRL9.AD_Language = ?)  left join (select M_Offer_ID, Name from M_Offer) table10 on (C_OrderLine.M_Offer_ID = table10.M_Offer_ID) left join (select M_AttributeSetInstance_ID, Description from M_AttributeSetInstance) table11 on (C_OrderLine.M_AttributeSetInstance_ID = table11.M_AttributeSetInstance_ID) left join (select C_Projectphase_ID, SeqNo, Name from C_Projectphase) table12 on (C_OrderLine.C_Projectphase_ID = table12.C_Projectphase_ID) left join (select C_Project_ID, Value, Name from C_Project) table13 on (C_OrderLine.C_Project_ID = table13.C_Project_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table14 on (C_OrderLine.C_Currency_ID = table14.C_Currency_ID) left join (select C_Tax_ID, Name from C_Tax) table15 on (C_OrderLine.C_Tax_ID =  table15.C_Tax_ID) left join (select C_Tax_ID,AD_Language, Name from C_Tax_TRL) tableTRL15 on (table15.C_Tax_ID = tableTRL15.C_Tax_ID and tableTRL15.AD_Language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table16 on (C_OrderLine.C_BPartner_ID = table16.C_BPartner_ID) left join (select C_Charge_ID, Name from C_Charge) table17 on (C_OrderLine.C_Charge_ID = table17.C_Charge_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table18 on (C_OrderLine.C_BPartner_Location_ID = table18.C_BPartner_Location_ID) left join (select AD_Client_ID, Name from AD_Client) table19 on (C_OrderLine.AD_Client_ID = table19.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table20 on (C_OrderLine.AD_Org_ID = table20.AD_Org_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table21 on (C_OrderLine.C_Order_ID = table21.C_Order_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cOrderId==null || cOrderId.equals(""))?"":"  AND C_OrderLine.C_Order_ID = ?  ");
    strSql = strSql + 
      "        AND C_OrderLine.C_OrderLine_ID = ? " +
      "        AND C_OrderLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_OrderLine.AD_Org_ID IN (";
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
      if (cOrderId != null && !(cOrderId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
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
        ManualTAB785B16E4ABD64BFC8BECB45146D8D644Data objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data = new ManualTAB785B16E4ABD64BFC8BECB45146D8D644Data();
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.created = UtilSql.getValue(result, "created");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.updated = UtilSql.getValue(result, "updated");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.isgrossprice = UtilSql.getValue(result, "isgrossprice");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cancelpricead = UtilSql.getValue(result, "cancelpricead");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.issummaryitem = UtilSql.getValue(result, "issummaryitem");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.line = UtilSql.getValue(result, "line");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.datedelivered = UtilSql.getDateValue(result, "datedelivered", "dd-MM-yyyy");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.description = UtilSql.getValue(result, "description");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.linegrossamt = UtilSql.getValue(result, "linegrossamt");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.qtyreserved = UtilSql.getValue(result, "qtyreserved");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.qtydelivered = UtilSql.getValue(result, "qtydelivered");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.mShipperIdr = UtilSql.getValue(result, "m_shipper_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.linetaxamt = UtilSql.getValue(result, "linetaxamt");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.mProductUomIdr = UtilSql.getValue(result, "m_product_uom_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.mOfferId = UtilSql.getValue(result, "m_offer_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.mOfferIdr = UtilSql.getValue(result, "m_offer_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.pricestd = UtilSql.getValue(result, "pricestd");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.mAttributesetinstanceIdr = UtilSql.getValue(result, "m_attributesetinstance_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.isonetimeposition = UtilSql.getValue(result, "isonetimeposition");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cProjectphaseIdr = UtilSql.getValue(result, "c_projectphase_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.isdescription = UtilSql.getValue(result, "isdescription");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.invoicedamt = UtilSql.getValue(result, "invoicedamt");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.pricelist = UtilSql.getValue(result, "pricelist");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.priceactual = UtilSql.getValue(result, "priceactual");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cTaxIdr = UtilSql.getValue(result, "c_tax_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.directship = UtilSql.getValue(result, "directship");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.freightamt = UtilSql.getValue(result, "freightamt");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cChargeIdr = UtilSql.getValue(result, "c_charge_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.scheddeliverydate = UtilSql.getDateValue(result, "scheddeliverydate", "dd-MM-yyyy");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.ignoreresidue = UtilSql.getValue(result, "ignoreresidue");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.discount = UtilSql.getValue(result, "discount");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.isactive = UtilSql.getValue(result, "isactive");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.language = UtilSql.getValue(result, "language");
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.adUserClient = "";
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.adOrgClient = "";
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.createdby = "";
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.trBgcolor = "";
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.totalCount = "";
        objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data);
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
    ManualTAB785B16E4ABD64BFC8BECB45146D8D644Data objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[] = new ManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[vector.size()];
    vector.copyInto(objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data);
    return(objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data);
  }

/**
Create a registry
 */
  public static ManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[] set(String cOrderId, String mProductUomId, String datepromised, String aAssetId, String qtyinvoiced, String linetaxamt, String qtyreserved, String issummaryitem, String adClientId, String invoicedamt, String createdby, String createdbyr, String quantityorder, String datedelivered, String isdescription, String discount, String isonetimeposition, String linenetamt, String dateinvoiced, String linegrossamt, String updatedby, String updatedbyr, String cOrderIdr, String qtydelivered, String cProjecttaskId, String qtyordered, String chargeamt, String cProjectId, String cProjectIdr, String cProjectphaseId, String mAttributesetinstanceId, String mAttributesetinstanceIdr, String cBpartnerLocationId, String mOfferId, String cancelpricead, String pricelimit, String priceactual, String mShipperId, String cOrderlineId, String cChargeId, String cBpartnerId, String cBpartnerIdr, String cUomId, String directship, String scheddeliverydate, String adOrgId, String freightamt, String mProductId, String mProductIdr, String isgrossprice, String dateordered, String pricestd, String isactive, String mWarehouseId, String line, String cCurrencyId, String pricelist, String cTaxId, String description, String ignoreresidue)    throws ServletException {
    ManualTAB785B16E4ABD64BFC8BECB45146D8D644Data objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[] = new ManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[1];
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0] = new ManualTAB785B16E4ABD64BFC8BECB45146D8D644Data();
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].created = "";
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].createdbyr = createdbyr;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].updated = "";
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].updatedTimeStamp = "";
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].updatedby = updatedby;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].updatedbyr = updatedbyr;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].mProductId = mProductId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].mProductIdr = mProductIdr;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].aAssetId = aAssetId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].aAssetIdr = "";
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].datepromised = datepromised;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].isgrossprice = isgrossprice;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cancelpricead = cancelpricead;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].issummaryitem = issummaryitem;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].line = line;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].dateordered = dateordered;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].datedelivered = datedelivered;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].dateinvoiced = dateinvoiced;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].description = description;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].linegrossamt = linegrossamt;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cUomId = cUomId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cUomIdr = "";
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].mWarehouseId = mWarehouseId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].mWarehouseIdr = "";
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].qtyordered = qtyordered;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].qtyreserved = qtyreserved;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].qtydelivered = qtydelivered;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].qtyinvoiced = qtyinvoiced;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].mShipperId = mShipperId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].mShipperIdr = "";
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].linetaxamt = linetaxamt;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cProjecttaskId = cProjecttaskId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cProjecttaskIdr = "";
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].mProductUomId = mProductUomId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].mProductUomIdr = "";
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].mOfferId = mOfferId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].mOfferIdr = "";
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].pricestd = pricestd;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].mAttributesetinstanceId = mAttributesetinstanceId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].mAttributesetinstanceIdr = mAttributesetinstanceIdr;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].isonetimeposition = isonetimeposition;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cProjectphaseId = cProjectphaseId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cProjectphaseIdr = "";
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].isdescription = isdescription;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cProjectId = cProjectId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cProjectIdr = cProjectIdr;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].invoicedamt = invoicedamt;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].quantityorder = quantityorder;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cCurrencyId = cCurrencyId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cCurrencyIdr = "";
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].pricelist = pricelist;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].priceactual = priceactual;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cTaxId = cTaxId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cTaxIdr = "";
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cBpartnerId = cBpartnerId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cBpartnerIdr = cBpartnerIdr;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].directship = directship;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].freightamt = freightamt;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cChargeId = cChargeId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cChargeIdr = "";
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].chargeamt = chargeamt;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].scheddeliverydate = scheddeliverydate;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cBpartnerLocationId = cBpartnerLocationId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cBpartnerLocationIdr = "";
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].ignoreresidue = ignoreresidue;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].linenetamt = linenetamt;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].pricelimit = pricelimit;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].discount = discount;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].adClientId = adClientId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].adClientIdr = "";
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].isactive = isactive;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].adOrgId = adOrgId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].adOrgIdr = "";
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cOrderId = cOrderId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cOrderIdr = cOrderIdr;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].cOrderlineId = cOrderlineId;
    objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data[0].language = "";
    return objectManualTAB785B16E4ABD64BFC8BECB45146D8D644Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef01D5706503CE49D6ABDE8345B5DB4642(ConnectionProvider connectionProvider, String c_order_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT a_asset_id AS DefaultValue FROM c_order WHERE c_order_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_order_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
  public static String selectDef2210_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef2212_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef2213_2(ConnectionProvider connectionProvider, String C_Order_IDR)    throws ServletException {
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
  public static String selectDef6F7344EDD9904E5A94A709DE5BFE09D6(ConnectionProvider connectionProvider, String c_order_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_projecttask_id AS DefaultValue FROM c_order WHERE c_order_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_order_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
  public static String selectDefA48DE71600FC4CC7A352989D54135EDD(ConnectionProvider connectionProvider, String c_order_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_project_id AS DefaultValue FROM c_order WHERE c_order_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_order_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
  public static String selectDefA48DE71600FC4CC7A352989D54135EDD_3(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
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

/**
Select for auxiliar field
 */
  public static String selectDef94A94EC8613E4F9187409A87297DEB74(ConnectionProvider connectionProvider, String c_order_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_projectphase_id AS DefaultValue FROM c_order WHERE c_order_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_order_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
  public static String selectDef8767_4(ConnectionProvider connectionProvider, String M_AttributeSetInstance_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Description), '') ) as M_AttributeSetInstance_ID FROM M_AttributeSetInstance table1 WHERE table1.isActive='Y' AND table1.M_AttributeSetInstance_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_AttributeSetInstance_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_attributesetinstance_id");
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
  public static String selectDef2764(ConnectionProvider connectionProvider, String C_Order_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_BPartner_ID AS DefaultValue FROM C_Order WHERE C_Order_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Order_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
  public static String selectDef2764_5(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
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
  public static String selectDef2221_6(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef2214(ConnectionProvider connectionProvider, String C_Order_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(Line),0)+10 AS DefaultValue FROM C_OrderLine WHERE C_Order_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Order_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
      "        SELECT C_OrderLine.C_Order_ID AS NAME" +
      "        FROM C_OrderLine" +
      "        WHERE C_OrderLine.C_OrderLine_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(table1.DateOrdered, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.GrandTotal), ''))) AS NAME FROM C_Order left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table1 on (C_Order.C_Order_ID = table1.C_Order_ID) WHERE C_Order.C_Order_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(table1.DateOrdered, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.GrandTotal), ''))) AS NAME FROM C_Order left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table1 on (C_Order.C_Order_ID = table1.C_Order_ID) WHERE C_Order.C_Order_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

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
      "        UPDATE C_OrderLine" +
      "        SET M_Product_ID = (?) , A_Asset_ID = (?) , DatePromised = TO_DATE(?) , Isgrossprice = (?) , CANCELPRICEAD = (?) , Issummaryitem = (?) , Line = TO_NUMBER(?) , DateOrdered = TO_DATE(?) , DateDelivered = TO_DATE(?) , DateInvoiced = TO_DATE(?) , Description = (?) , Linegrossamt = TO_NUMBER(?) , C_UOM_ID = (?) , M_Warehouse_ID = (?) , QtyOrdered = TO_NUMBER(?) , QtyReserved = TO_NUMBER(?) , QtyDelivered = TO_NUMBER(?) , QtyInvoiced = TO_NUMBER(?) , M_Shipper_ID = (?) , Linetaxamt = TO_NUMBER(?) , C_Projecttask_ID = (?) , M_Product_Uom_Id = (?) , M_Offer_ID = (?) , PriceStd = TO_NUMBER(?) , M_AttributeSetInstance_ID = (?) , IsOneTimePosition = (?) , C_Projectphase_ID = (?) , IsDescription = (?) , C_Project_ID = (?) , Invoicedamt = TO_NUMBER(?) , QuantityOrder = TO_NUMBER(?) , C_Currency_ID = (?) , PriceList = TO_NUMBER(?) , PriceActual = TO_NUMBER(?) , C_Tax_ID = (?) , C_BPartner_ID = (?) , DirectShip = (?) , FreightAmt = TO_NUMBER(?) , C_Charge_ID = (?) , ChargeAmt = TO_NUMBER(?) , Scheddeliverydate = TO_DATE(?) , C_BPartner_Location_ID = (?) , Ignoreresidue = (?) , LineNetAmt = TO_NUMBER(?) , PriceLimit = TO_NUMBER(?) , Discount = TO_NUMBER(?) , AD_Client_ID = (?) , IsActive = (?) , AD_Org_ID = (?) , C_Order_ID = (?) , C_OrderLine_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_OrderLine.C_OrderLine_ID = ? " +
      "                 AND C_OrderLine.C_Order_ID = ? " +
      "        AND C_OrderLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_OrderLine.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isgrossprice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancelpricead);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummaryitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datedelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linegrossamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreserved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtydelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linetaxamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mOfferId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricestd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isonetimeposition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, directship);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ignoreresidue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
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
      "        INSERT INTO C_OrderLine " +
      "        (M_Product_ID, A_Asset_ID, DatePromised, Isgrossprice, CANCELPRICEAD, Issummaryitem, Line, DateOrdered, DateDelivered, DateInvoiced, Description, Linegrossamt, C_UOM_ID, M_Warehouse_ID, QtyOrdered, QtyReserved, QtyDelivered, QtyInvoiced, M_Shipper_ID, Linetaxamt, C_Projecttask_ID, M_Product_Uom_Id, M_Offer_ID, PriceStd, M_AttributeSetInstance_ID, IsOneTimePosition, C_Projectphase_ID, IsDescription, C_Project_ID, Invoicedamt, QuantityOrder, C_Currency_ID, PriceList, PriceActual, C_Tax_ID, C_BPartner_ID, DirectShip, FreightAmt, C_Charge_ID, ChargeAmt, Scheddeliverydate, C_BPartner_Location_ID, Ignoreresidue, LineNetAmt, PriceLimit, Discount, AD_Client_ID, IsActive, AD_Org_ID, C_Order_ID, C_OrderLine_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_DATE(?), (?), (?), (?), TO_NUMBER(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_DATE(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isgrossprice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancelpricead);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummaryitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datedelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linegrossamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreserved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtydelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linetaxamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mOfferId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricestd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isonetimeposition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, directship);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ignoreresidue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cOrderId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_OrderLine" +
      "        WHERE C_OrderLine.C_OrderLine_ID = ? " +
      "                 AND C_OrderLine.C_Order_ID = ? " +
      "        AND C_OrderLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_OrderLine.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_OrderLine" +
      "        WHERE C_OrderLine.C_OrderLine_ID = ? " +
      "                 AND C_OrderLine.C_Order_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

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
      "          FROM C_OrderLine" +
      "         WHERE C_OrderLine.C_OrderLine_ID = ? ";

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
      "          FROM C_OrderLine" +
      "         WHERE C_OrderLine.C_OrderLine_ID = ? ";

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
