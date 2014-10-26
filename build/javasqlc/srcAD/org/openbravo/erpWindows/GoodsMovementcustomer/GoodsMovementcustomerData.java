//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.GoodsMovementcustomer;

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
class GoodsMovementcustomerData implements FieldProvider {
static Logger log4j = Logger.getLogger(GoodsMovementcustomerData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cOrderId;
  public String cOrderIdr;
  public String dateordered;
  public String documentno;
  public String poreference;
  public String description;
  public String internalnote;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String movementdate;
  public String dateacct;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String adUserId;
  public String adUserIdr;
  public String deliveryLocationId;
  public String deliveryLocationIdr;
  public String priorityrule;
  public String priorityruler;
  public String deliveryrule;
  public String deliveryruler;
  public String salesrepId;
  public String salesrepIdr;
  public String pickdate;
  public String cIncotermsId;
  public String cIncotermsIdr;
  public String shippingto;
  public String deliveryviarule;
  public String deliveryviaruler;
  public String mShipperId;
  public String mShipperIdr;
  public String trackingno;
  public String shipdate;
  public String weight;
  public String weightUom;
  public String weightUomr;
  public String freightcostrule;
  public String freightcostruler;
  public String mProductId;
  public String mProductIdr;
  public String qty;
  public String freightamt;
  public String cChargeId;
  public String cChargeIdr;
  public String chargeamt;
  public String qtyofpallets;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String docstatus;
  public String docstatusr;
  public String movementtype;
  public String movementtyper;
  public String createfrom;
  public String docaction;
  public String docactionBtn;
  public String posted;
  public String postedBtn;
  public String isprinted;
  public String issotrx;
  public String dateprinted;
  public String updatelines;
  public String islogistic;
  public String generatelines;
  public String processing;
  public String processed;
  public String cInvoiceId;
  public String mInoutId;
  public String generateto;
  public String isactive;
  public String mWarehouseId;
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
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_order_idr") || fieldName.equals("cOrderIdr"))
      return cOrderIdr;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("internalnote"))
      return internalnote;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("delivery_location_id") || fieldName.equals("deliveryLocationId"))
      return deliveryLocationId;
    else if (fieldName.equalsIgnoreCase("delivery_location_idr") || fieldName.equals("deliveryLocationIdr"))
      return deliveryLocationIdr;
    else if (fieldName.equalsIgnoreCase("priorityrule"))
      return priorityrule;
    else if (fieldName.equalsIgnoreCase("priorityruler"))
      return priorityruler;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("deliveryruler"))
      return deliveryruler;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("pickdate"))
      return pickdate;
    else if (fieldName.equalsIgnoreCase("c_incoterms_id") || fieldName.equals("cIncotermsId"))
      return cIncotermsId;
    else if (fieldName.equalsIgnoreCase("c_incoterms_idr") || fieldName.equals("cIncotermsIdr"))
      return cIncotermsIdr;
    else if (fieldName.equalsIgnoreCase("shippingto"))
      return shippingto;
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
    else if (fieldName.equalsIgnoreCase("deliveryviaruler"))
      return deliveryviaruler;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("m_shipper_idr") || fieldName.equals("mShipperIdr"))
      return mShipperIdr;
    else if (fieldName.equalsIgnoreCase("trackingno"))
      return trackingno;
    else if (fieldName.equalsIgnoreCase("shipdate"))
      return shipdate;
    else if (fieldName.equalsIgnoreCase("weight"))
      return weight;
    else if (fieldName.equalsIgnoreCase("weight_uom") || fieldName.equals("weightUom"))
      return weightUom;
    else if (fieldName.equalsIgnoreCase("weight_uomr") || fieldName.equals("weightUomr"))
      return weightUomr;
    else if (fieldName.equalsIgnoreCase("freightcostrule"))
      return freightcostrule;
    else if (fieldName.equalsIgnoreCase("freightcostruler"))
      return freightcostruler;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("freightamt"))
      return freightamt;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("c_charge_idr") || fieldName.equals("cChargeIdr"))
      return cChargeIdr;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("qtyofpallets"))
      return qtyofpallets;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("movementtype"))
      return movementtype;
    else if (fieldName.equalsIgnoreCase("movementtyper"))
      return movementtyper;
    else if (fieldName.equalsIgnoreCase("createfrom"))
      return createfrom;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("docaction_btn") || fieldName.equals("docactionBtn"))
      return docactionBtn;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("posted_btn") || fieldName.equals("postedBtn"))
      return postedBtn;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("dateprinted"))
      return dateprinted;
    else if (fieldName.equalsIgnoreCase("updatelines"))
      return updatelines;
    else if (fieldName.equalsIgnoreCase("islogistic"))
      return islogistic;
    else if (fieldName.equalsIgnoreCase("generatelines"))
      return generatelines;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("m_inout_id") || fieldName.equals("mInoutId"))
      return mInoutId;
    else if (fieldName.equalsIgnoreCase("generateto"))
      return generateto;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
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
  public static GoodsMovementcustomerData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static GoodsMovementcustomerData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_InOut.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_InOut.CreatedBy) as CreatedByR, " +
      "        to_char(M_InOut.Updated, ?) as updated, " +
      "        to_char(M_InOut.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_InOut.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_InOut.UpdatedBy) as UpdatedByR," +
      "        M_InOut.AD_Client_ID, " +
      "(CASE WHEN M_InOut.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "M_InOut.AD_Org_ID, " +
      "(CASE WHEN M_InOut.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "M_InOut.C_Order_ID, " +
      "(CASE WHEN M_InOut.C_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.GrandTotal), ''))),'') ) END) AS C_Order_IDR, " +
      "M_InOut.DateOrdered, " +
      "M_InOut.DocumentNo, " +
      "M_InOut.POReference, " +
      "M_InOut.Description, " +
      "M_InOut.Internalnote, " +
      "M_InOut.C_DocType_ID, " +
      "(CASE WHEN M_InOut.C_DocType_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS C_DocType_IDR, " +
      "M_InOut.MovementDate, " +
      "M_InOut.DateAcct, " +
      "M_InOut.C_BPartner_ID, " +
      "(CASE WHEN M_InOut.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "M_InOut.C_BPartner_Location_ID, " +
      "(CASE WHEN M_InOut.C_BPartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_BPartner_Location_IDR, " +
      "M_InOut.AD_User_ID, " +
      "(CASE WHEN M_InOut.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "M_InOut.Delivery_Location_ID, " +
      "(CASE WHEN M_InOut.Delivery_Location_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS Delivery_Location_IDR, " +
      "M_InOut.PriorityRule, " +
      "(CASE WHEN M_InOut.PriorityRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS PriorityRuleR, " +
      "M_InOut.DeliveryRule, " +
      "(CASE WHEN M_InOut.DeliveryRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS DeliveryRuleR, " +
      "M_InOut.SalesRep_ID, " +
      "(CASE WHEN M_InOut.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "M_InOut.PickDate, " +
      "M_InOut.C_Incoterms_ID, " +
      "(CASE WHEN M_InOut.C_Incoterms_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS C_Incoterms_IDR, " +
      "M_InOut.shippingto, " +
      "M_InOut.DeliveryViaRule, " +
      "(CASE WHEN M_InOut.DeliveryViaRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS DeliveryViaRuleR, " +
      "M_InOut.M_Shipper_ID, " +
      "(CASE WHEN M_InOut.M_Shipper_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS M_Shipper_IDR, " +
      "M_InOut.TrackingNo, " +
      "M_InOut.ShipDate, " +
      "M_InOut.Weight, " +
      "M_InOut.Weight_Uom, " +
      "(CASE WHEN M_InOut.Weight_Uom IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL12.Name IS NULL THEN TO_CHAR(table12.Name) ELSE TO_CHAR(tableTRL12.Name) END)), ''))),'') ) END) AS Weight_UomR, " +
      "M_InOut.FreightCostRule, " +
      "(CASE WHEN M_InOut.FreightCostRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS FreightCostRuleR, " +
      "M_InOut.M_Product_ID, " +
      "(CASE WHEN M_InOut.M_Product_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL13.Name IS NULL THEN TO_CHAR(table13.Name) ELSE TO_CHAR(tableTRL13.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "M_InOut.Qty, " +
      "M_InOut.FreightAmt, " +
      "M_InOut.C_Charge_ID, " +
      "(CASE WHEN M_InOut.C_Charge_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Name), ''))),'') ) END) AS C_Charge_IDR, " +
      "M_InOut.ChargeAmt, " +
      "M_InOut.Qtyofpallets, " +
      "M_InOut.C_Project_ID, " +
      "(CASE WHEN M_InOut.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "M_InOut.C_Projecttask_ID, " +
      "(CASE WHEN M_InOut.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table17.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table17.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "M_InOut.DocStatus, " +
      "(CASE WHEN M_InOut.DocStatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list5.name),'') ) END) AS DocStatusR, " +
      "M_InOut.MovementType, " +
      "(CASE WHEN M_InOut.MovementType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list6.name),'') ) END) AS MovementTypeR, " +
      "M_InOut.CreateFrom, " +
      "M_InOut.DocAction, " +
      "list7.name as DocAction_BTN, " +
      "M_InOut.Posted, " +
      "list8.name as Posted_BTN, " +
      "COALESCE(M_InOut.IsPrinted, 'N') AS IsPrinted, " +
      "COALESCE(M_InOut.IsSOTrx, 'N') AS IsSOTrx, " +
      "M_InOut.DatePrinted, " +
      "M_InOut.UpdateLines, " +
      "COALESCE(M_InOut.Islogistic, 'N') AS Islogistic, " +
      "M_InOut.GenerateLines, " +
      "COALESCE(M_InOut.Processing, 'N') AS Processing, " +
      "COALESCE(M_InOut.Processed, 'N') AS Processed, " +
      "M_InOut.C_Invoice_ID, " +
      "M_InOut.M_InOut_ID, " +
      "M_InOut.GenerateTo, " +
      "COALESCE(M_InOut.IsActive, 'N') AS IsActive, " +
      "M_InOut.M_Warehouse_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM M_InOut left join (select AD_Client_ID, Name from AD_Client) table1 on (M_InOut.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (M_InOut.AD_Org_ID = table2.AD_Org_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table3 on (M_InOut.C_Order_ID = table3.C_Order_ID) left join (select C_DocType_ID, Name from C_DocType) table4 on (M_InOut.C_DocType_ID =  table4.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL4 on (table4.C_DocType_ID = tableTRL4.C_DocType_ID and tableTRL4.AD_Language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table5 on (M_InOut.C_BPartner_ID = table5.C_BPartner_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table6 on (M_InOut.C_BPartner_Location_ID = table6.C_BPartner_Location_ID) left join (select AD_User_ID, Name from AD_User) table7 on (M_InOut.AD_User_ID = table7.AD_User_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table8 on (M_InOut.Delivery_Location_ID =  table8.C_BPartner_Location_ID) left join ad_ref_list_v list1 on (M_InOut.PriorityRule = list1.value and list1.ad_reference_id = '154' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (M_InOut.DeliveryRule = list2.value and list2.ad_reference_id = '151' and list2.ad_language = ?)  left join (select AD_User_ID, Name from AD_User) table9 on (M_InOut.SalesRep_ID =  table9.AD_User_ID) left join (select C_Incoterms_ID, Name from C_Incoterms) table10 on (M_InOut.C_Incoterms_ID = table10.C_Incoterms_ID) left join ad_ref_list_v list3 on (M_InOut.DeliveryViaRule = list3.value and list3.ad_reference_id = '152' and list3.ad_language = ?)  left join (select M_Shipper_ID, Name from M_Shipper) table11 on (M_InOut.M_Shipper_ID = table11.M_Shipper_ID) left join (select C_UOM_ID, Name from C_UOM) table12 on (M_InOut.Weight_Uom =  table12.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL12 on (table12.C_UOM_ID = tableTRL12.C_UOM_ID and tableTRL12.AD_Language = ?)  left join ad_ref_list_v list4 on (M_InOut.FreightCostRule = list4.value and list4.ad_reference_id = '153' and list4.ad_language = ?)  left join (select M_Product_ID, value, Name from M_Product) table13 on (M_InOut.M_Product_ID =  table13.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL13 on (table13.M_Product_ID = tableTRL13.M_Product_ID and tableTRL13.AD_Language = ?)  left join (select C_Charge_ID, Name from C_Charge) table14 on (M_InOut.C_Charge_ID =  table14.C_Charge_ID) left join (select C_Project_ID, Value, Name from C_Project) table15 on (M_InOut.C_Project_ID = table15.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table16 on (M_InOut.C_Projecttask_ID = table16.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table17 on (table16.C_Project_ID = table17.C_Project_ID) left join ad_ref_list_v list5 on (M_InOut.DocStatus = list5.value and list5.ad_reference_id = '131' and list5.ad_language = ?)  left join ad_ref_list_v list6 on (M_InOut.MovementType = list6.value and list6.ad_reference_id = '189' and list6.ad_language = ?)  left join ad_ref_list_v list7 on (list7.ad_reference_id = '135' and list7.ad_language = ?  AND (CASE M_InOut.DocAction WHEN '--' THEN 'CL' ELSE TO_CHAR(M_InOut.DocAction) END) = list7.value) left join ad_ref_list_v list8 on (list8.ad_reference_id = '234' and list8.ad_language = ?  AND M_InOut.Posted = TO_CHAR(list8.value))" +
      "        WHERE 2=2 " +
      " AND M_InOut.MovementType IN ('C-', 'C+') and M_InOut.isLogistic = 'N'" +
      "        AND 1=1 " +
      "        AND M_InOut.M_InOut_ID = ? " +
      "        AND M_InOut.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND M_InOut.AD_Org_ID IN (";
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
        GoodsMovementcustomerData objectGoodsMovementcustomerData = new GoodsMovementcustomerData();
        objectGoodsMovementcustomerData.created = UtilSql.getValue(result, "created");
        objectGoodsMovementcustomerData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectGoodsMovementcustomerData.updated = UtilSql.getValue(result, "updated");
        objectGoodsMovementcustomerData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectGoodsMovementcustomerData.updatedby = UtilSql.getValue(result, "updatedby");
        objectGoodsMovementcustomerData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectGoodsMovementcustomerData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectGoodsMovementcustomerData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectGoodsMovementcustomerData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectGoodsMovementcustomerData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectGoodsMovementcustomerData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectGoodsMovementcustomerData.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectGoodsMovementcustomerData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectGoodsMovementcustomerData.documentno = UtilSql.getValue(result, "documentno");
        objectGoodsMovementcustomerData.poreference = UtilSql.getValue(result, "poreference");
        objectGoodsMovementcustomerData.description = UtilSql.getValue(result, "description");
        objectGoodsMovementcustomerData.internalnote = UtilSql.getValue(result, "internalnote");
        objectGoodsMovementcustomerData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectGoodsMovementcustomerData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectGoodsMovementcustomerData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectGoodsMovementcustomerData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectGoodsMovementcustomerData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectGoodsMovementcustomerData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectGoodsMovementcustomerData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectGoodsMovementcustomerData.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectGoodsMovementcustomerData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectGoodsMovementcustomerData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectGoodsMovementcustomerData.deliveryLocationId = UtilSql.getValue(result, "delivery_location_id");
        objectGoodsMovementcustomerData.deliveryLocationIdr = UtilSql.getValue(result, "delivery_location_idr");
        objectGoodsMovementcustomerData.priorityrule = UtilSql.getValue(result, "priorityrule");
        objectGoodsMovementcustomerData.priorityruler = UtilSql.getValue(result, "priorityruler");
        objectGoodsMovementcustomerData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectGoodsMovementcustomerData.deliveryruler = UtilSql.getValue(result, "deliveryruler");
        objectGoodsMovementcustomerData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectGoodsMovementcustomerData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectGoodsMovementcustomerData.pickdate = UtilSql.getDateValue(result, "pickdate", "dd-MM-yyyy");
        objectGoodsMovementcustomerData.cIncotermsId = UtilSql.getValue(result, "c_incoterms_id");
        objectGoodsMovementcustomerData.cIncotermsIdr = UtilSql.getValue(result, "c_incoterms_idr");
        objectGoodsMovementcustomerData.shippingto = UtilSql.getValue(result, "shippingto");
        objectGoodsMovementcustomerData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectGoodsMovementcustomerData.deliveryviaruler = UtilSql.getValue(result, "deliveryviaruler");
        objectGoodsMovementcustomerData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectGoodsMovementcustomerData.mShipperIdr = UtilSql.getValue(result, "m_shipper_idr");
        objectGoodsMovementcustomerData.trackingno = UtilSql.getValue(result, "trackingno");
        objectGoodsMovementcustomerData.shipdate = UtilSql.getDateValue(result, "shipdate", "dd-MM-yyyy");
        objectGoodsMovementcustomerData.weight = UtilSql.getValue(result, "weight");
        objectGoodsMovementcustomerData.weightUom = UtilSql.getValue(result, "weight_uom");
        objectGoodsMovementcustomerData.weightUomr = UtilSql.getValue(result, "weight_uomr");
        objectGoodsMovementcustomerData.freightcostrule = UtilSql.getValue(result, "freightcostrule");
        objectGoodsMovementcustomerData.freightcostruler = UtilSql.getValue(result, "freightcostruler");
        objectGoodsMovementcustomerData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectGoodsMovementcustomerData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectGoodsMovementcustomerData.qty = UtilSql.getValue(result, "qty");
        objectGoodsMovementcustomerData.freightamt = UtilSql.getValue(result, "freightamt");
        objectGoodsMovementcustomerData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectGoodsMovementcustomerData.cChargeIdr = UtilSql.getValue(result, "c_charge_idr");
        objectGoodsMovementcustomerData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectGoodsMovementcustomerData.qtyofpallets = UtilSql.getValue(result, "qtyofpallets");
        objectGoodsMovementcustomerData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectGoodsMovementcustomerData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectGoodsMovementcustomerData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectGoodsMovementcustomerData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectGoodsMovementcustomerData.docstatus = UtilSql.getValue(result, "docstatus");
        objectGoodsMovementcustomerData.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectGoodsMovementcustomerData.movementtype = UtilSql.getValue(result, "movementtype");
        objectGoodsMovementcustomerData.movementtyper = UtilSql.getValue(result, "movementtyper");
        objectGoodsMovementcustomerData.createfrom = UtilSql.getValue(result, "createfrom");
        objectGoodsMovementcustomerData.docaction = UtilSql.getValue(result, "docaction");
        objectGoodsMovementcustomerData.docactionBtn = UtilSql.getValue(result, "docaction_btn");
        objectGoodsMovementcustomerData.posted = UtilSql.getValue(result, "posted");
        objectGoodsMovementcustomerData.postedBtn = UtilSql.getValue(result, "posted_btn");
        objectGoodsMovementcustomerData.isprinted = UtilSql.getValue(result, "isprinted");
        objectGoodsMovementcustomerData.issotrx = UtilSql.getValue(result, "issotrx");
        objectGoodsMovementcustomerData.dateprinted = UtilSql.getDateValue(result, "dateprinted", "dd-MM-yyyy");
        objectGoodsMovementcustomerData.updatelines = UtilSql.getValue(result, "updatelines");
        objectGoodsMovementcustomerData.islogistic = UtilSql.getValue(result, "islogistic");
        objectGoodsMovementcustomerData.generatelines = UtilSql.getValue(result, "generatelines");
        objectGoodsMovementcustomerData.processing = UtilSql.getValue(result, "processing");
        objectGoodsMovementcustomerData.processed = UtilSql.getValue(result, "processed");
        objectGoodsMovementcustomerData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectGoodsMovementcustomerData.mInoutId = UtilSql.getValue(result, "m_inout_id");
        objectGoodsMovementcustomerData.generateto = UtilSql.getValue(result, "generateto");
        objectGoodsMovementcustomerData.isactive = UtilSql.getValue(result, "isactive");
        objectGoodsMovementcustomerData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectGoodsMovementcustomerData.language = UtilSql.getValue(result, "language");
        objectGoodsMovementcustomerData.adUserClient = "";
        objectGoodsMovementcustomerData.adOrgClient = "";
        objectGoodsMovementcustomerData.createdby = "";
        objectGoodsMovementcustomerData.trBgcolor = "";
        objectGoodsMovementcustomerData.totalCount = "";
        objectGoodsMovementcustomerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGoodsMovementcustomerData);
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
    GoodsMovementcustomerData objectGoodsMovementcustomerData[] = new GoodsMovementcustomerData[vector.size()];
    vector.copyInto(objectGoodsMovementcustomerData);
    return(objectGoodsMovementcustomerData);
  }

/**
Create a registry
 */
  public static GoodsMovementcustomerData[] set(String updatelines, String adClientId, String deliveryLocationId, String generateto, String movementtype, String chargeamt, String posted, String postedBtn, String deliveryviarule, String adUserId, String docstatus, String islogistic, String pickdate, String isprinted, String cIncotermsId, String deliveryrule, String qty, String cBpartnerLocationId, String cInvoiceId, String generatelines, String updatedby, String updatedbyr, String dateordered, String createdby, String createdbyr, String shippingto, String cChargeId, String processed, String weightUom, String issotrx, String dateprinted, String internalnote, String isactive, String salesrepId, String cBpartnerId, String cBpartnerIdr, String createfrom, String cProjecttaskId, String adOrgId, String trackingno, String cOrderId, String cOrderIdr, String dateacct, String priorityrule, String mInoutId, String freightcostrule, String mWarehouseId, String processing, String qtyofpallets, String poreference, String mProductId, String documentno, String docaction, String docactionBtn, String cProjectId, String cProjectIdr, String cDoctypeId, String freightamt, String movementdate, String description, String mShipperId, String weight, String shipdate)    throws ServletException {
    GoodsMovementcustomerData objectGoodsMovementcustomerData[] = new GoodsMovementcustomerData[1];
    objectGoodsMovementcustomerData[0] = new GoodsMovementcustomerData();
    objectGoodsMovementcustomerData[0].created = "";
    objectGoodsMovementcustomerData[0].createdbyr = createdbyr;
    objectGoodsMovementcustomerData[0].updated = "";
    objectGoodsMovementcustomerData[0].updatedTimeStamp = "";
    objectGoodsMovementcustomerData[0].updatedby = updatedby;
    objectGoodsMovementcustomerData[0].updatedbyr = updatedbyr;
    objectGoodsMovementcustomerData[0].adClientId = adClientId;
    objectGoodsMovementcustomerData[0].adClientIdr = "";
    objectGoodsMovementcustomerData[0].adOrgId = adOrgId;
    objectGoodsMovementcustomerData[0].adOrgIdr = "";
    objectGoodsMovementcustomerData[0].cOrderId = cOrderId;
    objectGoodsMovementcustomerData[0].cOrderIdr = cOrderIdr;
    objectGoodsMovementcustomerData[0].dateordered = dateordered;
    objectGoodsMovementcustomerData[0].documentno = documentno;
    objectGoodsMovementcustomerData[0].poreference = poreference;
    objectGoodsMovementcustomerData[0].description = description;
    objectGoodsMovementcustomerData[0].internalnote = internalnote;
    objectGoodsMovementcustomerData[0].cDoctypeId = cDoctypeId;
    objectGoodsMovementcustomerData[0].cDoctypeIdr = "";
    objectGoodsMovementcustomerData[0].movementdate = movementdate;
    objectGoodsMovementcustomerData[0].dateacct = dateacct;
    objectGoodsMovementcustomerData[0].cBpartnerId = cBpartnerId;
    objectGoodsMovementcustomerData[0].cBpartnerIdr = cBpartnerIdr;
    objectGoodsMovementcustomerData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectGoodsMovementcustomerData[0].cBpartnerLocationIdr = "";
    objectGoodsMovementcustomerData[0].adUserId = adUserId;
    objectGoodsMovementcustomerData[0].adUserIdr = "";
    objectGoodsMovementcustomerData[0].deliveryLocationId = deliveryLocationId;
    objectGoodsMovementcustomerData[0].deliveryLocationIdr = "";
    objectGoodsMovementcustomerData[0].priorityrule = priorityrule;
    objectGoodsMovementcustomerData[0].priorityruler = "";
    objectGoodsMovementcustomerData[0].deliveryrule = deliveryrule;
    objectGoodsMovementcustomerData[0].deliveryruler = "";
    objectGoodsMovementcustomerData[0].salesrepId = salesrepId;
    objectGoodsMovementcustomerData[0].salesrepIdr = "";
    objectGoodsMovementcustomerData[0].pickdate = pickdate;
    objectGoodsMovementcustomerData[0].cIncotermsId = cIncotermsId;
    objectGoodsMovementcustomerData[0].cIncotermsIdr = "";
    objectGoodsMovementcustomerData[0].shippingto = shippingto;
    objectGoodsMovementcustomerData[0].deliveryviarule = deliveryviarule;
    objectGoodsMovementcustomerData[0].deliveryviaruler = "";
    objectGoodsMovementcustomerData[0].mShipperId = mShipperId;
    objectGoodsMovementcustomerData[0].mShipperIdr = "";
    objectGoodsMovementcustomerData[0].trackingno = trackingno;
    objectGoodsMovementcustomerData[0].shipdate = shipdate;
    objectGoodsMovementcustomerData[0].weight = weight;
    objectGoodsMovementcustomerData[0].weightUom = weightUom;
    objectGoodsMovementcustomerData[0].weightUomr = "";
    objectGoodsMovementcustomerData[0].freightcostrule = freightcostrule;
    objectGoodsMovementcustomerData[0].freightcostruler = "";
    objectGoodsMovementcustomerData[0].mProductId = mProductId;
    objectGoodsMovementcustomerData[0].mProductIdr = "";
    objectGoodsMovementcustomerData[0].qty = qty;
    objectGoodsMovementcustomerData[0].freightamt = freightamt;
    objectGoodsMovementcustomerData[0].cChargeId = cChargeId;
    objectGoodsMovementcustomerData[0].cChargeIdr = "";
    objectGoodsMovementcustomerData[0].chargeamt = chargeamt;
    objectGoodsMovementcustomerData[0].qtyofpallets = qtyofpallets;
    objectGoodsMovementcustomerData[0].cProjectId = cProjectId;
    objectGoodsMovementcustomerData[0].cProjectIdr = cProjectIdr;
    objectGoodsMovementcustomerData[0].cProjecttaskId = cProjecttaskId;
    objectGoodsMovementcustomerData[0].cProjecttaskIdr = "";
    objectGoodsMovementcustomerData[0].docstatus = docstatus;
    objectGoodsMovementcustomerData[0].docstatusr = "";
    objectGoodsMovementcustomerData[0].movementtype = movementtype;
    objectGoodsMovementcustomerData[0].movementtyper = "";
    objectGoodsMovementcustomerData[0].createfrom = createfrom;
    objectGoodsMovementcustomerData[0].docaction = docaction;
    objectGoodsMovementcustomerData[0].docactionBtn = docactionBtn;
    objectGoodsMovementcustomerData[0].posted = posted;
    objectGoodsMovementcustomerData[0].postedBtn = postedBtn;
    objectGoodsMovementcustomerData[0].isprinted = isprinted;
    objectGoodsMovementcustomerData[0].issotrx = issotrx;
    objectGoodsMovementcustomerData[0].dateprinted = dateprinted;
    objectGoodsMovementcustomerData[0].updatelines = updatelines;
    objectGoodsMovementcustomerData[0].islogistic = islogistic;
    objectGoodsMovementcustomerData[0].generatelines = generatelines;
    objectGoodsMovementcustomerData[0].processing = processing;
    objectGoodsMovementcustomerData[0].processed = processed;
    objectGoodsMovementcustomerData[0].cInvoiceId = cInvoiceId;
    objectGoodsMovementcustomerData[0].mInoutId = mInoutId;
    objectGoodsMovementcustomerData[0].generateto = generateto;
    objectGoodsMovementcustomerData[0].isactive = isactive;
    objectGoodsMovementcustomerData[0].mWarehouseId = mWarehouseId;
    objectGoodsMovementcustomerData[0].language = "";
    return objectGoodsMovementcustomerData;
  }

/**
Select for auxiliar field
 */
  public static String selectActP154_M_PriceList_Version_ID(ConnectionProvider connectionProvider, String isSOTrx, String C_BPARTNER_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MIN(M_PRICELIST_VERSION_ID) AS TOTAL FROM M_PRICELIST_VERSION M, C_BPARTNER B WHERE M.M_PRICELIST_ID = (CASE ? WHEN 'Y' THEN B.M_PRICELIST_ID ELSE COALESCE(B.PO_PRICELIST_ID, B.M_PRICELIST_ID) END) AND M.ISACTIVE = 'Y' AND B.C_BPARTNER_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isSOTrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPARTNER_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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
  public static String selectDef3528_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef3526_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef3795_2(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
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
  public static String selectDef3809_3(ConnectionProvider connectionProvider, String C_Order_IDR)    throws ServletException {
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
  public static String selectDef9585_4(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
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

  public static int updateDocAction(ConnectionProvider connectionProvider, String docaction, String mInoutId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_InOut" +
      "        SET docaction = ? " +
      "        WHERE M_InOut.M_InOut_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);

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

/**
Select for action search
 */
  public static String selectActDefM_InOut_ID(ConnectionProvider connectionProvider, String M_InOut_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DocumentNo FROM M_InOut WHERE isActive='Y' AND M_InOut_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_InOut_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "documentno");
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
      "        UPDATE M_InOut" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , C_Order_ID = (?) , DateOrdered = TO_DATE(?) , DocumentNo = (?) , POReference = (?) , Description = (?) , Internalnote = (?) , C_DocType_ID = (?) , MovementDate = TO_DATE(?) , DateAcct = TO_DATE(?) , C_BPartner_ID = (?) , C_BPartner_Location_ID = (?) , AD_User_ID = (?) , Delivery_Location_ID = (?) , PriorityRule = (?) , DeliveryRule = (?) , SalesRep_ID = (?) , PickDate = TO_DATE(?) , C_Incoterms_ID = (?) , shippingto = (?) , DeliveryViaRule = (?) , M_Shipper_ID = (?) , TrackingNo = (?) , ShipDate = TO_DATE(?) , Weight = TO_NUMBER(?) , Weight_Uom = (?) , FreightCostRule = (?) , M_Product_ID = (?) , Qty = TO_NUMBER(?) , FreightAmt = TO_NUMBER(?) , C_Charge_ID = (?) , ChargeAmt = TO_NUMBER(?) , Qtyofpallets = TO_NUMBER(?) , C_Project_ID = (?) , C_Projecttask_ID = (?) , DocStatus = (?) , MovementType = (?) , CreateFrom = (?) , DocAction = (?) , Posted = (?) , IsPrinted = (?) , IsSOTrx = (?) , DatePrinted = TO_DATE(?) , UpdateLines = (?) , Islogistic = (?) , GenerateLines = (?) , Processing = (?) , Processed = (?) , C_Invoice_ID = (?) , M_InOut_ID = (?) , GenerateTo = (?) , IsActive = (?) , M_Warehouse_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE M_InOut.M_InOut_ID = ? " +
      "        AND M_InOut.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_InOut.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, internalnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priorityrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pickdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cIncotermsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shippingto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, trackingno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weightUom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyofpallets);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatelines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islogistic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatelines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
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
      "        INSERT INTO M_InOut " +
      "        (AD_Client_ID, AD_Org_ID, C_Order_ID, DateOrdered, DocumentNo, POReference, Description, Internalnote, C_DocType_ID, MovementDate, DateAcct, C_BPartner_ID, C_BPartner_Location_ID, AD_User_ID, Delivery_Location_ID, PriorityRule, DeliveryRule, SalesRep_ID, PickDate, C_Incoterms_ID, shippingto, DeliveryViaRule, M_Shipper_ID, TrackingNo, ShipDate, Weight, Weight_Uom, FreightCostRule, M_Product_ID, Qty, FreightAmt, C_Charge_ID, ChargeAmt, Qtyofpallets, C_Project_ID, C_Projecttask_ID, DocStatus, MovementType, CreateFrom, DocAction, Posted, IsPrinted, IsSOTrx, DatePrinted, UpdateLines, Islogistic, GenerateLines, Processing, Processed, C_Invoice_ID, M_InOut_ID, GenerateTo, IsActive, M_Warehouse_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), TO_DATE(?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, internalnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priorityrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pickdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cIncotermsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shippingto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, trackingno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weightUom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyofpallets);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatelines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islogistic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatelines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
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
      "        DELETE FROM M_InOut" +
      "        WHERE M_InOut.M_InOut_ID = ? " +
      "        AND M_InOut.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_InOut.AD_Org_ID IN (";
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
      "        DELETE FROM M_InOut" +
      "        WHERE M_InOut.M_InOut_ID = ? ";

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
      "          FROM M_InOut" +
      "         WHERE M_InOut.M_InOut_ID = ? ";

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
      "          FROM M_InOut" +
      "         WHERE M_InOut.M_InOut_ID = ? ";

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
