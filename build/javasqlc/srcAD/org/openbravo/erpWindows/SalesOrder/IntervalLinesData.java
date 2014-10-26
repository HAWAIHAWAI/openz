//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.SalesOrder;

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
class IntervalLinesData implements FieldProvider {
static Logger log4j = Logger.getLogger(IntervalLinesData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String isdescription;
  public String refOrderlineId;
  public String adClientId;
  public String adClientIdr;
  public String mOfferId;
  public String adOrgId;
  public String adOrgIdr;
  public String cSubscriptionintervalViewId;
  public String cSubscriptionintervalViewIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String dateordered;
  public String linetaxamt;
  public String line;
  public String isgrossprice;
  public String datepromised;
  public String cProjectphaseId;
  public String scheddeliverydate;
  public String directship;
  public String aAssetId;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String isonetimeposition;
  public String mProductId;
  public String mProductIdr;
  public String issummaryitem;
  public String mAttributesetinstanceId;
  public String mAttributesetinstanceIdr;
  public String sResourceassignmentId;
  public String description;
  public String quantityorder;
  public String cSubscriptionintervallinesViewId;
  public String mProductUomId;
  public String mProductUomIdr;
  public String qtyordered;
  public String cUomId;
  public String cUomIdr;
  public String qtydelivered;
  public String qtyreserved;
  public String qtyinvoiced;
  public String invoicedamt;
  public String ignoreresidue;
  public String mShipperId;
  public String mShipperIdr;
  public String priceactual;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String pricestd;
  public String cancelpricead;
  public String pricelist;
  public String discount;
  public String freightamt;
  public String cTaxId;
  public String cTaxIdr;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String linenetamt;
  public String linegrossamt;
  public String cChargeId;
  public String datedelivered;
  public String dateinvoiced;
  public String pricelimit;
  public String isactive;
  public String chargeamt;
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
    else if (fieldName.equalsIgnoreCase("isdescription"))
      return isdescription;
    else if (fieldName.equalsIgnoreCase("ref_orderline_id") || fieldName.equals("refOrderlineId"))
      return refOrderlineId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("m_offer_id") || fieldName.equals("mOfferId"))
      return mOfferId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_subscriptioninterval_view_id") || fieldName.equals("cSubscriptionintervalViewId"))
      return cSubscriptionintervalViewId;
    else if (fieldName.equalsIgnoreCase("c_subscriptioninterval_view_idr") || fieldName.equals("cSubscriptionintervalViewIdr"))
      return cSubscriptionintervalViewIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("linetaxamt"))
      return linetaxamt;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("isgrossprice"))
      return isgrossprice;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
    else if (fieldName.equalsIgnoreCase("scheddeliverydate"))
      return scheddeliverydate;
    else if (fieldName.equalsIgnoreCase("directship"))
      return directship;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("isonetimeposition"))
      return isonetimeposition;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("issummaryitem"))
      return issummaryitem;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_idr") || fieldName.equals("mAttributesetinstanceIdr"))
      return mAttributesetinstanceIdr;
    else if (fieldName.equalsIgnoreCase("s_resourceassignment_id") || fieldName.equals("sResourceassignmentId"))
      return sResourceassignmentId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("quantityorder"))
      return quantityorder;
    else if (fieldName.equalsIgnoreCase("c_subscriptionintervallines_view_id") || fieldName.equals("cSubscriptionintervallinesViewId"))
      return cSubscriptionintervallinesViewId;
    else if (fieldName.equalsIgnoreCase("m_product_uom_id") || fieldName.equals("mProductUomId"))
      return mProductUomId;
    else if (fieldName.equalsIgnoreCase("m_product_uom_idr") || fieldName.equals("mProductUomIdr"))
      return mProductUomIdr;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("qtydelivered"))
      return qtydelivered;
    else if (fieldName.equalsIgnoreCase("qtyreserved"))
      return qtyreserved;
    else if (fieldName.equalsIgnoreCase("qtyinvoiced"))
      return qtyinvoiced;
    else if (fieldName.equalsIgnoreCase("invoicedamt"))
      return invoicedamt;
    else if (fieldName.equalsIgnoreCase("ignoreresidue"))
      return ignoreresidue;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("m_shipper_idr") || fieldName.equals("mShipperIdr"))
      return mShipperIdr;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("cancelpricead"))
      return cancelpricead;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("discount"))
      return discount;
    else if (fieldName.equalsIgnoreCase("freightamt"))
      return freightamt;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("c_tax_idr") || fieldName.equals("cTaxIdr"))
      return cTaxIdr;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("linegrossamt"))
      return linegrossamt;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("datedelivered"))
      return datedelivered;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
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
  public static IntervalLinesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cSubscriptionintervalViewId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cSubscriptionintervalViewId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static IntervalLinesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cSubscriptionintervalViewId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_subscriptionintervallines_view.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_subscriptionintervallines_view.CreatedBy) as CreatedByR, " +
      "        to_char(c_subscriptionintervallines_view.Updated, ?) as updated, " +
      "        to_char(c_subscriptionintervallines_view.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_subscriptionintervallines_view.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_subscriptionintervallines_view.UpdatedBy) as UpdatedByR," +
      "        COALESCE(c_subscriptionintervallines_view.IsDescription, 'N') AS IsDescription, " +
      "c_subscriptionintervallines_view.Ref_OrderLine_ID, " +
      "c_subscriptionintervallines_view.AD_Client_ID, " +
      "(CASE WHEN c_subscriptionintervallines_view.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "c_subscriptionintervallines_view.M_Offer_ID, " +
      "c_subscriptionintervallines_view.AD_Org_ID, " +
      "(CASE WHEN c_subscriptionintervallines_view.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "c_subscriptionintervallines_view.C_Subscriptioninterval_View_ID, " +
      "(CASE WHEN c_subscriptionintervallines_view.C_Subscriptioninterval_View_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.GrandTotal), ''))),'') ) END) AS C_Subscriptioninterval_View_IDR, " +
      "c_subscriptionintervallines_view.C_BPartner_ID, " +
      "(CASE WHEN c_subscriptionintervallines_view.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "c_subscriptionintervallines_view.C_BPartner_Location_ID, " +
      "(CASE WHEN c_subscriptionintervallines_view.C_BPartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_BPartner_Location_IDR, " +
      "c_subscriptionintervallines_view.DateOrdered, " +
      "c_subscriptionintervallines_view.Linetaxamt, " +
      "c_subscriptionintervallines_view.Line, " +
      "COALESCE(c_subscriptionintervallines_view.Isgrossprice, 'N') AS Isgrossprice, " +
      "c_subscriptionintervallines_view.DatePromised, " +
      "c_subscriptionintervallines_view.C_Projectphase_ID, " +
      "c_subscriptionintervallines_view.Scheddeliverydate, " +
      "COALESCE(c_subscriptionintervallines_view.DirectShip, 'N') AS DirectShip, " +
      "c_subscriptionintervallines_view.A_Asset_ID, " +
      "c_subscriptionintervallines_view.M_Warehouse_ID, " +
      "(CASE WHEN c_subscriptionintervallines_view.M_Warehouse_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "COALESCE(c_subscriptionintervallines_view.Isonetimeposition, 'N') AS Isonetimeposition, " +
      "c_subscriptionintervallines_view.M_Product_ID, " +
      "(CASE WHEN c_subscriptionintervallines_view.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL7.Name IS NULL THEN TO_CHAR(table7.Name) ELSE TO_CHAR(tableTRL7.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "COALESCE(c_subscriptionintervallines_view.Issummaryitem, 'N') AS Issummaryitem, " +
      "c_subscriptionintervallines_view.M_AttributeSetInstance_ID, " +
      "(CASE WHEN c_subscriptionintervallines_view.M_AttributeSetInstance_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Description), ''))),'') ) END) AS M_AttributeSetInstance_IDR, " +
      "c_subscriptionintervallines_view.S_ResourceAssignment_ID, " +
      "c_subscriptionintervallines_view.Description, " +
      "c_subscriptionintervallines_view.QuantityOrder, " +
      "c_subscriptionintervallines_view.C_Subscriptionintervallines_View_ID, " +
      "c_subscriptionintervallines_view.M_Product_Uom_Id, " +
      "(CASE WHEN c_subscriptionintervallines_view.M_Product_Uom_Id IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL10.Name IS NULL THEN TO_CHAR(table10.Name) ELSE TO_CHAR(tableTRL10.Name) END)), ''))),'') ) END) AS M_Product_Uom_IdR, " +
      "c_subscriptionintervallines_view.QtyOrdered, " +
      "c_subscriptionintervallines_view.C_UOM_ID, " +
      "(CASE WHEN c_subscriptionintervallines_view.C_UOM_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL11.Name IS NULL THEN TO_CHAR(table11.Name) ELSE TO_CHAR(tableTRL11.Name) END)), ''))),'') ) END) AS C_UOM_IDR, " +
      "c_subscriptionintervallines_view.QtyDelivered, " +
      "c_subscriptionintervallines_view.QtyReserved, " +
      "c_subscriptionintervallines_view.QtyInvoiced, " +
      "c_subscriptionintervallines_view.Invoicedamt, " +
      "COALESCE(c_subscriptionintervallines_view.Ignoreresidue, 'N') AS Ignoreresidue, " +
      "c_subscriptionintervallines_view.M_Shipper_ID, " +
      "(CASE WHEN c_subscriptionintervallines_view.M_Shipper_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Name), ''))),'') ) END) AS M_Shipper_IDR, " +
      "c_subscriptionintervallines_view.PriceActual, " +
      "c_subscriptionintervallines_view.C_Currency_ID, " +
      "(CASE WHEN c_subscriptionintervallines_view.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "c_subscriptionintervallines_view.PriceStd, " +
      "COALESCE(c_subscriptionintervallines_view.CANCELPRICEAD, 'N') AS CANCELPRICEAD, " +
      "c_subscriptionintervallines_view.PriceList, " +
      "c_subscriptionintervallines_view.Discount, " +
      "c_subscriptionintervallines_view.FreightAmt, " +
      "c_subscriptionintervallines_view.C_Tax_ID, " +
      "(CASE WHEN c_subscriptionintervallines_view.C_Tax_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL14.Name IS NULL THEN TO_CHAR(table14.Name) ELSE TO_CHAR(tableTRL14.Name) END)), ''))),'') ) END) AS C_Tax_IDR, " +
      "c_subscriptionintervallines_view.C_Project_ID, " +
      "(CASE WHEN c_subscriptionintervallines_view.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "c_subscriptionintervallines_view.C_Projecttask_ID, " +
      "(CASE WHEN c_subscriptionintervallines_view.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table17.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table17.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "c_subscriptionintervallines_view.LineNetAmt, " +
      "c_subscriptionintervallines_view.Linegrossamt, " +
      "c_subscriptionintervallines_view.C_Charge_ID, " +
      "c_subscriptionintervallines_view.DateDelivered, " +
      "c_subscriptionintervallines_view.DateInvoiced, " +
      "c_subscriptionintervallines_view.PriceLimit, " +
      "COALESCE(c_subscriptionintervallines_view.IsActive, 'N') AS IsActive, " +
      "c_subscriptionintervallines_view.ChargeAmt, " +
      "        ? AS LANGUAGE " +
      "        FROM c_subscriptionintervallines_view left join (select AD_Client_ID, Name from AD_Client) table1 on (c_subscriptionintervallines_view.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (c_subscriptionintervallines_view.AD_Org_ID = table2.AD_Org_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table3 on (c_subscriptionintervallines_view.C_Subscriptioninterval_View_ID = table3.C_Order_ID) left join (select C_BPartner_ID, Name from C_BPartner) table4 on (c_subscriptionintervallines_view.C_BPartner_ID = table4.C_BPartner_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table5 on (c_subscriptionintervallines_view.C_BPartner_Location_ID = table5.C_BPartner_Location_ID) left join (select M_Warehouse_ID, Name from M_Warehouse) table6 on (c_subscriptionintervallines_view.M_Warehouse_ID =  table6.M_Warehouse_ID) left join (select M_Product_ID, Value, Name from M_Product) table7 on (c_subscriptionintervallines_view.M_Product_ID = table7.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL7 on (table7.M_Product_ID = tableTRL7.M_Product_ID and tableTRL7.AD_Language = ?)  left join (select M_AttributeSetInstance_ID, Description from M_AttributeSetInstance) table8 on (c_subscriptionintervallines_view.M_AttributeSetInstance_ID = table8.M_AttributeSetInstance_ID) left join (select M_Product_Uom_Id, C_UOM_ID from M_Product_UOM) table9 on (c_subscriptionintervallines_view.M_Product_Uom_Id =  table9.M_Product_Uom_Id) left join (select C_UOM_ID, Name from C_UOM) table10 on (table9.C_UOM_ID = table10.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL10 on (table10.C_UOM_ID = tableTRL10.C_UOM_ID and tableTRL10.AD_Language = ?)  left join (select C_UOM_ID, Name from C_UOM) table11 on (c_subscriptionintervallines_view.C_UOM_ID = table11.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL11 on (table11.C_UOM_ID = tableTRL11.C_UOM_ID and tableTRL11.AD_Language = ?)  left join (select M_Shipper_ID, Name from M_Shipper) table12 on (c_subscriptionintervallines_view.M_Shipper_ID = table12.M_Shipper_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table13 on (c_subscriptionintervallines_view.C_Currency_ID = table13.C_Currency_ID) left join (select C_Tax_ID, Name from C_Tax) table14 on (c_subscriptionintervallines_view.C_Tax_ID =  table14.C_Tax_ID) left join (select C_Tax_ID,AD_Language, Name from C_Tax_TRL) tableTRL14 on (table14.C_Tax_ID = tableTRL14.C_Tax_ID and tableTRL14.AD_Language = ?)  left join (select C_Project_ID, Value, Name from C_Project) table15 on (c_subscriptionintervallines_view.C_Project_ID = table15.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table16 on (c_subscriptionintervallines_view.C_Projecttask_ID = table16.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table17 on (table16.C_Project_ID = table17.C_Project_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cSubscriptionintervalViewId==null || cSubscriptionintervalViewId.equals(""))?"":"  AND c_subscriptionintervallines_view.C_Subscriptioninterval_View_ID = ?  ");
    strSql = strSql + 
      "        AND c_subscriptionintervallines_view.C_Subscriptionintervallines_View_ID = ? " +
      "        AND c_subscriptionintervallines_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_subscriptionintervallines_view.AD_Org_ID IN (";
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
      if (cSubscriptionintervalViewId != null && !(cSubscriptionintervalViewId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSubscriptionintervalViewId);
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
        IntervalLinesData objectIntervalLinesData = new IntervalLinesData();
        objectIntervalLinesData.created = UtilSql.getValue(result, "created");
        objectIntervalLinesData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectIntervalLinesData.updated = UtilSql.getValue(result, "updated");
        objectIntervalLinesData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectIntervalLinesData.updatedby = UtilSql.getValue(result, "updatedby");
        objectIntervalLinesData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectIntervalLinesData.isdescription = UtilSql.getValue(result, "isdescription");
        objectIntervalLinesData.refOrderlineId = UtilSql.getValue(result, "ref_orderline_id");
        objectIntervalLinesData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectIntervalLinesData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectIntervalLinesData.mOfferId = UtilSql.getValue(result, "m_offer_id");
        objectIntervalLinesData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectIntervalLinesData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectIntervalLinesData.cSubscriptionintervalViewId = UtilSql.getValue(result, "c_subscriptioninterval_view_id");
        objectIntervalLinesData.cSubscriptionintervalViewIdr = UtilSql.getValue(result, "c_subscriptioninterval_view_idr");
        objectIntervalLinesData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectIntervalLinesData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectIntervalLinesData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectIntervalLinesData.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectIntervalLinesData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectIntervalLinesData.linetaxamt = UtilSql.getValue(result, "linetaxamt");
        objectIntervalLinesData.line = UtilSql.getValue(result, "line");
        objectIntervalLinesData.isgrossprice = UtilSql.getValue(result, "isgrossprice");
        objectIntervalLinesData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectIntervalLinesData.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectIntervalLinesData.scheddeliverydate = UtilSql.getDateValue(result, "scheddeliverydate", "dd-MM-yyyy");
        objectIntervalLinesData.directship = UtilSql.getValue(result, "directship");
        objectIntervalLinesData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectIntervalLinesData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectIntervalLinesData.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectIntervalLinesData.isonetimeposition = UtilSql.getValue(result, "isonetimeposition");
        objectIntervalLinesData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectIntervalLinesData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectIntervalLinesData.issummaryitem = UtilSql.getValue(result, "issummaryitem");
        objectIntervalLinesData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectIntervalLinesData.mAttributesetinstanceIdr = UtilSql.getValue(result, "m_attributesetinstance_idr");
        objectIntervalLinesData.sResourceassignmentId = UtilSql.getValue(result, "s_resourceassignment_id");
        objectIntervalLinesData.description = UtilSql.getValue(result, "description");
        objectIntervalLinesData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectIntervalLinesData.cSubscriptionintervallinesViewId = UtilSql.getValue(result, "c_subscriptionintervallines_view_id");
        objectIntervalLinesData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectIntervalLinesData.mProductUomIdr = UtilSql.getValue(result, "m_product_uom_idr");
        objectIntervalLinesData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectIntervalLinesData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectIntervalLinesData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectIntervalLinesData.qtydelivered = UtilSql.getValue(result, "qtydelivered");
        objectIntervalLinesData.qtyreserved = UtilSql.getValue(result, "qtyreserved");
        objectIntervalLinesData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectIntervalLinesData.invoicedamt = UtilSql.getValue(result, "invoicedamt");
        objectIntervalLinesData.ignoreresidue = UtilSql.getValue(result, "ignoreresidue");
        objectIntervalLinesData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectIntervalLinesData.mShipperIdr = UtilSql.getValue(result, "m_shipper_idr");
        objectIntervalLinesData.priceactual = UtilSql.getValue(result, "priceactual");
        objectIntervalLinesData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectIntervalLinesData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectIntervalLinesData.pricestd = UtilSql.getValue(result, "pricestd");
        objectIntervalLinesData.cancelpricead = UtilSql.getValue(result, "cancelpricead");
        objectIntervalLinesData.pricelist = UtilSql.getValue(result, "pricelist");
        objectIntervalLinesData.discount = UtilSql.getValue(result, "discount");
        objectIntervalLinesData.freightamt = UtilSql.getValue(result, "freightamt");
        objectIntervalLinesData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectIntervalLinesData.cTaxIdr = UtilSql.getValue(result, "c_tax_idr");
        objectIntervalLinesData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectIntervalLinesData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectIntervalLinesData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectIntervalLinesData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectIntervalLinesData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectIntervalLinesData.linegrossamt = UtilSql.getValue(result, "linegrossamt");
        objectIntervalLinesData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectIntervalLinesData.datedelivered = UtilSql.getDateValue(result, "datedelivered", "dd-MM-yyyy");
        objectIntervalLinesData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectIntervalLinesData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectIntervalLinesData.isactive = UtilSql.getValue(result, "isactive");
        objectIntervalLinesData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectIntervalLinesData.language = UtilSql.getValue(result, "language");
        objectIntervalLinesData.adUserClient = "";
        objectIntervalLinesData.adOrgClient = "";
        objectIntervalLinesData.createdby = "";
        objectIntervalLinesData.trBgcolor = "";
        objectIntervalLinesData.totalCount = "";
        objectIntervalLinesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectIntervalLinesData);
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
    IntervalLinesData objectIntervalLinesData[] = new IntervalLinesData[vector.size()];
    vector.copyInto(objectIntervalLinesData);
    return(objectIntervalLinesData);
  }

/**
Create a registry
 */
  public static IntervalLinesData[] set(String cSubscriptionintervalViewId, String updatedby, String updatedbyr, String discount, String scheddeliverydate, String cCurrencyId, String dateordered, String ignoreresidue, String cSubscriptionintervallinesViewId, String refOrderlineId, String linegrossamt, String quantityorder, String linenetamt, String mShipperId, String cProjectphaseId, String datepromised, String pricestd, String adOrgId, String aAssetId, String description, String qtydelivered, String cBpartnerLocationId, String issummaryitem, String datedelivered, String pricelimit, String isgrossprice, String cUomId, String qtyreserved, String invoicedamt, String createdby, String createdbyr, String mAttributesetinstanceId, String mAttributesetinstanceIdr, String pricelist, String mProductId, String mProductIdr, String isdescription, String cSubscriptionintervalViewIdr, String freightamt, String mOfferId, String qtyinvoiced, String sResourceassignmentId, String cProjecttaskId, String cancelpricead, String priceactual, String linetaxamt, String mProductUomId, String chargeamt, String directship, String cProjectId, String cProjectIdr, String qtyordered, String adClientId, String isactive, String isonetimeposition, String cChargeId, String mWarehouseId, String dateinvoiced, String line, String cTaxId, String cBpartnerId, String cBpartnerIdr)    throws ServletException {
    IntervalLinesData objectIntervalLinesData[] = new IntervalLinesData[1];
    objectIntervalLinesData[0] = new IntervalLinesData();
    objectIntervalLinesData[0].created = "";
    objectIntervalLinesData[0].createdbyr = createdbyr;
    objectIntervalLinesData[0].updated = "";
    objectIntervalLinesData[0].updatedTimeStamp = "";
    objectIntervalLinesData[0].updatedby = updatedby;
    objectIntervalLinesData[0].updatedbyr = updatedbyr;
    objectIntervalLinesData[0].isdescription = isdescription;
    objectIntervalLinesData[0].refOrderlineId = refOrderlineId;
    objectIntervalLinesData[0].adClientId = adClientId;
    objectIntervalLinesData[0].adClientIdr = "";
    objectIntervalLinesData[0].mOfferId = mOfferId;
    objectIntervalLinesData[0].adOrgId = adOrgId;
    objectIntervalLinesData[0].adOrgIdr = "";
    objectIntervalLinesData[0].cSubscriptionintervalViewId = cSubscriptionintervalViewId;
    objectIntervalLinesData[0].cSubscriptionintervalViewIdr = cSubscriptionintervalViewIdr;
    objectIntervalLinesData[0].cBpartnerId = cBpartnerId;
    objectIntervalLinesData[0].cBpartnerIdr = cBpartnerIdr;
    objectIntervalLinesData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectIntervalLinesData[0].cBpartnerLocationIdr = "";
    objectIntervalLinesData[0].dateordered = dateordered;
    objectIntervalLinesData[0].linetaxamt = linetaxamt;
    objectIntervalLinesData[0].line = line;
    objectIntervalLinesData[0].isgrossprice = isgrossprice;
    objectIntervalLinesData[0].datepromised = datepromised;
    objectIntervalLinesData[0].cProjectphaseId = cProjectphaseId;
    objectIntervalLinesData[0].scheddeliverydate = scheddeliverydate;
    objectIntervalLinesData[0].directship = directship;
    objectIntervalLinesData[0].aAssetId = aAssetId;
    objectIntervalLinesData[0].mWarehouseId = mWarehouseId;
    objectIntervalLinesData[0].mWarehouseIdr = "";
    objectIntervalLinesData[0].isonetimeposition = isonetimeposition;
    objectIntervalLinesData[0].mProductId = mProductId;
    objectIntervalLinesData[0].mProductIdr = mProductIdr;
    objectIntervalLinesData[0].issummaryitem = issummaryitem;
    objectIntervalLinesData[0].mAttributesetinstanceId = mAttributesetinstanceId;
    objectIntervalLinesData[0].mAttributesetinstanceIdr = mAttributesetinstanceIdr;
    objectIntervalLinesData[0].sResourceassignmentId = sResourceassignmentId;
    objectIntervalLinesData[0].description = description;
    objectIntervalLinesData[0].quantityorder = quantityorder;
    objectIntervalLinesData[0].cSubscriptionintervallinesViewId = cSubscriptionintervallinesViewId;
    objectIntervalLinesData[0].mProductUomId = mProductUomId;
    objectIntervalLinesData[0].mProductUomIdr = "";
    objectIntervalLinesData[0].qtyordered = qtyordered;
    objectIntervalLinesData[0].cUomId = cUomId;
    objectIntervalLinesData[0].cUomIdr = "";
    objectIntervalLinesData[0].qtydelivered = qtydelivered;
    objectIntervalLinesData[0].qtyreserved = qtyreserved;
    objectIntervalLinesData[0].qtyinvoiced = qtyinvoiced;
    objectIntervalLinesData[0].invoicedamt = invoicedamt;
    objectIntervalLinesData[0].ignoreresidue = ignoreresidue;
    objectIntervalLinesData[0].mShipperId = mShipperId;
    objectIntervalLinesData[0].mShipperIdr = "";
    objectIntervalLinesData[0].priceactual = priceactual;
    objectIntervalLinesData[0].cCurrencyId = cCurrencyId;
    objectIntervalLinesData[0].cCurrencyIdr = "";
    objectIntervalLinesData[0].pricestd = pricestd;
    objectIntervalLinesData[0].cancelpricead = cancelpricead;
    objectIntervalLinesData[0].pricelist = pricelist;
    objectIntervalLinesData[0].discount = discount;
    objectIntervalLinesData[0].freightamt = freightamt;
    objectIntervalLinesData[0].cTaxId = cTaxId;
    objectIntervalLinesData[0].cTaxIdr = "";
    objectIntervalLinesData[0].cProjectId = cProjectId;
    objectIntervalLinesData[0].cProjectIdr = cProjectIdr;
    objectIntervalLinesData[0].cProjecttaskId = cProjecttaskId;
    objectIntervalLinesData[0].cProjecttaskIdr = "";
    objectIntervalLinesData[0].linenetamt = linenetamt;
    objectIntervalLinesData[0].linegrossamt = linegrossamt;
    objectIntervalLinesData[0].cChargeId = cChargeId;
    objectIntervalLinesData[0].datedelivered = datedelivered;
    objectIntervalLinesData[0].dateinvoiced = dateinvoiced;
    objectIntervalLinesData[0].pricelimit = pricelimit;
    objectIntervalLinesData[0].isactive = isactive;
    objectIntervalLinesData[0].chargeamt = chargeamt;
    objectIntervalLinesData[0].language = "";
    return objectIntervalLinesData;
  }

/**
Select for auxiliar field
 */
  public static String selectAuxFC17DFE42B964D5A9AF556A2F1A13492(ConnectionProvider connectionProvider, String c_doctype_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_get_docbasetype(?) ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_doctype_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_get_docbasetype");
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
  public static String selectDef5B279745ED3748BA9F47AE8CF7429546_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDefFF567F89E6E44BE0B9635230964D3AAA(ConnectionProvider connectionProvider, String c_order_ID)    throws ServletException {
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
  public static String selectDef400514558EEC48B89EB53EDF4B132CA1(ConnectionProvider connectionProvider, String c_order_ID)    throws ServletException {
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
  public static String selectDef685B417ACB3044BDB4EBA1272388DFE2_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef2E892DA4D3134858A87CA976B303A3F1_2(ConnectionProvider connectionProvider, String M_AttributeSetInstance_IDR)    throws ServletException {
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
  public static String selectDef0D22CCF0AC2749A4A4F41B7472042F2A_3(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef3D84E9048403492EB9C62DD777F65845_4(ConnectionProvider connectionProvider, String C_Subscriptioninterval_View_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.DocumentNo), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '')  || ' - ' || COALESCE(TO_CHAR(table1.DateOrdered), '')  || ' - ' || COALESCE(TO_CHAR(table1.GrandTotal), '') ) as C_Subscriptioninterval_View_ID FROM C_Order table1 WHERE table1.isActive='Y' AND table1.C_Order_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Subscriptioninterval_View_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_subscriptioninterval_view_id");
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
  public static String selectDef1B89E4F709F4492B814FCFD40B326C34(ConnectionProvider connectionProvider, String c_order_ID)    throws ServletException {
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
  public static String selectDef0ADC146B62014DDEB36538C37BF4B744(ConnectionProvider connectionProvider, String c_order_ID)    throws ServletException {
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
  public static String selectDef0ADC146B62014DDEB36538C37BF4B744_5(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
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
  public static String selectDefABCCB98672FD49109BAF16F9A0A0710F(ConnectionProvider connectionProvider, String C_Order_ID)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDefD501463B963F43BFAEDC2E411D9535B8(ConnectionProvider connectionProvider, String C_Order_ID)    throws ServletException {
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
  public static String selectDefD501463B963F43BFAEDC2E411D9535B8_6(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_subscriptionintervallines_view.C_Subscriptioninterval_View_ID AS NAME" +
      "        FROM c_subscriptionintervallines_view" +
      "        WHERE c_subscriptionintervallines_view.C_Subscriptionintervallines_View_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cSubscriptionintervalViewId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(table1.DateOrdered, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.GrandTotal), ''))) AS NAME FROM c_subscriptioninterval_view left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table1 on (c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = table1.C_Order_ID) WHERE c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSubscriptionintervalViewId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cSubscriptionintervalViewId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(table1.DateOrdered, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.GrandTotal), ''))) AS NAME FROM c_subscriptioninterval_view left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table1 on (c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = table1.C_Order_ID) WHERE c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSubscriptionintervalViewId);

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
      "        UPDATE c_subscriptionintervallines_view" +
      "        SET IsDescription = (?) , Ref_OrderLine_ID = (?) , AD_Client_ID = (?) , M_Offer_ID = (?) , AD_Org_ID = (?) , C_Subscriptioninterval_View_ID = (?) , C_BPartner_ID = (?) , C_BPartner_Location_ID = (?) , DateOrdered = TO_DATE(?) , Linetaxamt = TO_NUMBER(?) , Line = TO_NUMBER(?) , Isgrossprice = (?) , DatePromised = TO_DATE(?) , C_Projectphase_ID = (?) , Scheddeliverydate = TO_DATE(?) , DirectShip = (?) , A_Asset_ID = (?) , M_Warehouse_ID = (?) , Isonetimeposition = (?) , M_Product_ID = (?) , Issummaryitem = (?) , M_AttributeSetInstance_ID = (?) , S_ResourceAssignment_ID = (?) , Description = (?) , QuantityOrder = TO_NUMBER(?) , C_Subscriptionintervallines_View_ID = (?) , M_Product_Uom_Id = (?) , QtyOrdered = TO_NUMBER(?) , C_UOM_ID = (?) , QtyDelivered = TO_NUMBER(?) , QtyReserved = TO_NUMBER(?) , QtyInvoiced = TO_NUMBER(?) , Invoicedamt = TO_NUMBER(?) , Ignoreresidue = (?) , M_Shipper_ID = (?) , PriceActual = TO_NUMBER(?) , C_Currency_ID = (?) , PriceStd = TO_NUMBER(?) , CANCELPRICEAD = (?) , PriceList = TO_NUMBER(?) , Discount = TO_NUMBER(?) , FreightAmt = TO_NUMBER(?) , C_Tax_ID = (?) , C_Project_ID = (?) , C_Projecttask_ID = (?) , LineNetAmt = TO_NUMBER(?) , Linegrossamt = TO_NUMBER(?) , C_Charge_ID = (?) , DateDelivered = TO_DATE(?) , DateInvoiced = TO_DATE(?) , PriceLimit = TO_NUMBER(?) , IsActive = (?) , ChargeAmt = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE c_subscriptionintervallines_view.C_Subscriptionintervallines_View_ID = ? " +
      "                 AND c_subscriptionintervallines_view.C_Subscriptioninterval_View_ID = ? " +
      "        AND c_subscriptionintervallines_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_subscriptionintervallines_view.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, refOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mOfferId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSubscriptionintervalViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linetaxamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isgrossprice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, directship);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isonetimeposition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummaryitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceassignmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSubscriptionintervallinesViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtydelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreserved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ignoreresidue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricestd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancelpricead);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linegrossamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datedelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSubscriptionintervallinesViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSubscriptionintervalViewId);
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
      "        INSERT INTO c_subscriptionintervallines_view " +
      "        (IsDescription, Ref_OrderLine_ID, AD_Client_ID, M_Offer_ID, AD_Org_ID, C_Subscriptioninterval_View_ID, C_BPartner_ID, C_BPartner_Location_ID, DateOrdered, Linetaxamt, Line, Isgrossprice, DatePromised, C_Projectphase_ID, Scheddeliverydate, DirectShip, A_Asset_ID, M_Warehouse_ID, Isonetimeposition, M_Product_ID, Issummaryitem, M_AttributeSetInstance_ID, S_ResourceAssignment_ID, Description, QuantityOrder, C_Subscriptionintervallines_View_ID, M_Product_Uom_Id, QtyOrdered, C_UOM_ID, QtyDelivered, QtyReserved, QtyInvoiced, Invoicedamt, Ignoreresidue, M_Shipper_ID, PriceActual, C_Currency_ID, PriceStd, CANCELPRICEAD, PriceList, Discount, FreightAmt, C_Tax_ID, C_Project_ID, C_Projecttask_ID, LineNetAmt, Linegrossamt, C_Charge_ID, DateDelivered, DateInvoiced, PriceLimit, IsActive, ChargeAmt, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_DATE(?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?), (?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, refOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mOfferId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSubscriptionintervalViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linetaxamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isgrossprice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, directship);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isonetimeposition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummaryitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceassignmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSubscriptionintervallinesViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtydelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreserved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ignoreresidue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricestd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancelpricead);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linegrossamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datedelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cSubscriptionintervalViewId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_subscriptionintervallines_view" +
      "        WHERE c_subscriptionintervallines_view.C_Subscriptionintervallines_View_ID = ? " +
      "                 AND c_subscriptionintervallines_view.C_Subscriptioninterval_View_ID = ? " +
      "        AND c_subscriptionintervallines_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_subscriptionintervallines_view.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSubscriptionintervalViewId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cSubscriptionintervalViewId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_subscriptionintervallines_view" +
      "        WHERE c_subscriptionintervallines_view.C_Subscriptionintervallines_View_ID = ? " +
      "                 AND c_subscriptionintervallines_view.C_Subscriptioninterval_View_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSubscriptionintervalViewId);

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
      "          FROM c_subscriptionintervallines_view" +
      "         WHERE c_subscriptionintervallines_view.C_Subscriptionintervallines_View_ID = ? ";

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
      "          FROM c_subscriptionintervallines_view" +
      "         WHERE c_subscriptionintervallines_view.C_Subscriptionintervallines_View_ID = ? ";

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
