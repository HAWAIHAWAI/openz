//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.GoodsMovementVendor;

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
class GoodsMovementVendorData implements FieldProvider {
static Logger log4j = Logger.getLogger(GoodsMovementVendorData.class);
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
  public String deliveryviarule;
  public String deliveryviaruler;
  public String salesrepId;
  public String salesrepIdr;
  public String deliveryrule;
  public String deliveryruler;
  public String qty;
  public String cChargeId;
  public String cChargeIdr;
  public String chargeamt;
  public String createfrom;
  public String generateto;
  public String aAssetId;
  public String aAssetIdr;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String cActivityId;
  public String cActivityIdr;
  public String cCampaignId;
  public String cCampaignIdr;
  public String adOrgtrxId;
  public String adOrgtrxIdr;
  public String user1Id;
  public String user2Id;
  public String docstatus;
  public String docstatusr;
  public String movementtype;
  public String movementtyper;
  public String docaction;
  public String docactionBtn;
  public String posted;
  public String postedBtn;
  public String issotrx;
  public String pickdate;
  public String trackingno;
  public String freightcostrule;
  public String shipdate;
  public String freightamt;
  public String processed;
  public String dateordered;
  public String islogistic;
  public String updatelines;
  public String generatelines;
  public String dateprinted;
  public String mShipperId;
  public String processing;
  public String isactive;
  public String mInoutId;
  public String mWarehouseId;
  public String cInvoiceId;
  public String isprinted;
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
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
    else if (fieldName.equalsIgnoreCase("deliveryviaruler"))
      return deliveryviaruler;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("deliveryruler"))
      return deliveryruler;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("c_charge_idr") || fieldName.equals("cChargeIdr"))
      return cChargeIdr;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("createfrom"))
      return createfrom;
    else if (fieldName.equalsIgnoreCase("generateto"))
      return generateto;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_idr") || fieldName.equals("aAssetIdr"))
      return aAssetIdr;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("c_activity_idr") || fieldName.equals("cActivityIdr"))
      return cActivityIdr;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_campaign_idr") || fieldName.equals("cCampaignIdr"))
      return cCampaignIdr;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_idr") || fieldName.equals("adOrgtrxIdr"))
      return adOrgtrxIdr;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("movementtype"))
      return movementtype;
    else if (fieldName.equalsIgnoreCase("movementtyper"))
      return movementtyper;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("docaction_btn") || fieldName.equals("docactionBtn"))
      return docactionBtn;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("posted_btn") || fieldName.equals("postedBtn"))
      return postedBtn;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("pickdate"))
      return pickdate;
    else if (fieldName.equalsIgnoreCase("trackingno"))
      return trackingno;
    else if (fieldName.equalsIgnoreCase("freightcostrule"))
      return freightcostrule;
    else if (fieldName.equalsIgnoreCase("shipdate"))
      return shipdate;
    else if (fieldName.equalsIgnoreCase("freightamt"))
      return freightamt;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("islogistic"))
      return islogistic;
    else if (fieldName.equalsIgnoreCase("updatelines"))
      return updatelines;
    else if (fieldName.equalsIgnoreCase("generatelines"))
      return generatelines;
    else if (fieldName.equalsIgnoreCase("dateprinted"))
      return dateprinted;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("m_inout_id") || fieldName.equals("mInoutId"))
      return mInoutId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
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
  public static GoodsMovementVendorData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static GoodsMovementVendorData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
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
      "M_InOut.DeliveryViaRule, " +
      "(CASE WHEN M_InOut.DeliveryViaRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS DeliveryViaRuleR, " +
      "M_InOut.SalesRep_ID, " +
      "(CASE WHEN M_InOut.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "M_InOut.DeliveryRule, " +
      "(CASE WHEN M_InOut.DeliveryRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS DeliveryRuleR, " +
      "M_InOut.Qty, " +
      "M_InOut.C_Charge_ID, " +
      "(CASE WHEN M_InOut.C_Charge_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS C_Charge_IDR, " +
      "M_InOut.ChargeAmt, " +
      "M_InOut.CreateFrom, " +
      "M_InOut.GenerateTo, " +
      "M_InOut.A_Asset_ID, " +
      "(CASE WHEN M_InOut.A_Asset_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "M_InOut.C_Project_ID, " +
      "(CASE WHEN M_InOut.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "M_InOut.C_Projecttask_ID, " +
      "(CASE WHEN M_InOut.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "M_InOut.C_Activity_ID, " +
      "(CASE WHEN M_InOut.C_Activity_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Name), ''))),'') ) END) AS C_Activity_IDR, " +
      "M_InOut.C_Campaign_ID, " +
      "(CASE WHEN M_InOut.C_Campaign_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Name), ''))),'') ) END) AS C_Campaign_IDR, " +
      "M_InOut.AD_OrgTrx_ID, " +
      "(CASE WHEN M_InOut.AD_OrgTrx_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table17.Name), ''))),'') ) END) AS AD_OrgTrx_IDR, " +
      "M_InOut.User1_ID, " +
      "M_InOut.User2_ID, " +
      "M_InOut.DocStatus, " +
      "(CASE WHEN M_InOut.DocStatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS DocStatusR, " +
      "M_InOut.MovementType, " +
      "(CASE WHEN M_InOut.MovementType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list5.name),'') ) END) AS MovementTypeR, " +
      "M_InOut.DocAction, " +
      "list6.name as DocAction_BTN, " +
      "M_InOut.Posted, " +
      "list7.name as Posted_BTN, " +
      "COALESCE(M_InOut.IsSOTrx, 'N') AS IsSOTrx, " +
      "M_InOut.PickDate, " +
      "M_InOut.TrackingNo, " +
      "M_InOut.FreightCostRule, " +
      "M_InOut.ShipDate, " +
      "M_InOut.FreightAmt, " +
      "COALESCE(M_InOut.Processed, 'N') AS Processed, " +
      "M_InOut.DateOrdered, " +
      "COALESCE(M_InOut.Islogistic, 'N') AS Islogistic, " +
      "M_InOut.UpdateLines, " +
      "M_InOut.GenerateLines, " +
      "M_InOut.DatePrinted, " +
      "M_InOut.M_Shipper_ID, " +
      "COALESCE(M_InOut.Processing, 'N') AS Processing, " +
      "COALESCE(M_InOut.IsActive, 'N') AS IsActive, " +
      "M_InOut.M_InOut_ID, " +
      "M_InOut.M_Warehouse_ID, " +
      "M_InOut.C_Invoice_ID, " +
      "COALESCE(M_InOut.IsPrinted, 'N') AS IsPrinted, " +
      "        ? AS LANGUAGE " +
      "        FROM M_InOut left join (select AD_Client_ID, Name from AD_Client) table1 on (M_InOut.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (M_InOut.AD_Org_ID = table2.AD_Org_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table3 on (M_InOut.C_Order_ID = table3.C_Order_ID) left join (select C_DocType_ID, Name from C_DocType) table4 on (M_InOut.C_DocType_ID =  table4.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL4 on (table4.C_DocType_ID = tableTRL4.C_DocType_ID and tableTRL4.AD_Language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table5 on (M_InOut.C_BPartner_ID = table5.C_BPartner_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table6 on (M_InOut.C_BPartner_Location_ID = table6.C_BPartner_Location_ID) left join (select AD_User_ID, Name from AD_User) table7 on (M_InOut.AD_User_ID = table7.AD_User_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table8 on (M_InOut.Delivery_Location_ID =  table8.C_BPartner_Location_ID) left join ad_ref_list_v list1 on (M_InOut.PriorityRule = list1.value and list1.ad_reference_id = '154' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (M_InOut.DeliveryViaRule = list2.value and list2.ad_reference_id = '152' and list2.ad_language = ?)  left join (select AD_User_ID, Name from AD_User) table9 on (M_InOut.SalesRep_ID =  table9.AD_User_ID) left join ad_ref_list_v list3 on (M_InOut.DeliveryRule = list3.value and list3.ad_reference_id = '151' and list3.ad_language = ?)  left join (select C_Charge_ID, Name from C_Charge) table10 on (M_InOut.C_Charge_ID =  table10.C_Charge_ID) left join (select A_Asset_ID, Name from A_Asset) table11 on (M_InOut.A_Asset_ID = table11.A_Asset_ID) left join (select C_Project_ID, Value, Name from C_Project) table12 on (M_InOut.C_Project_ID = table12.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table13 on (M_InOut.C_Projecttask_ID = table13.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table14 on (table13.C_Project_ID = table14.C_Project_ID) left join (select C_Activity_ID, Name from C_Activity) table15 on (M_InOut.C_Activity_ID = table15.C_Activity_ID) left join (select C_Campaign_ID, Name from C_Campaign) table16 on (M_InOut.C_Campaign_ID = table16.C_Campaign_ID) left join (select AD_Org_ID, value, Name from AD_Org) table17 on (M_InOut.AD_OrgTrx_ID =  table17.AD_Org_ID) left join ad_ref_list_v list4 on (M_InOut.DocStatus = list4.value and list4.ad_reference_id = '131' and list4.ad_language = ?)  left join ad_ref_list_v list5 on (M_InOut.MovementType = list5.value and list5.ad_reference_id = '189' and list5.ad_language = ?)  left join ad_ref_list_v list6 on (list6.ad_reference_id = '135' and list6.ad_language = ?  AND (CASE M_InOut.DocAction WHEN '--' THEN 'CL' ELSE TO_CHAR(M_InOut.DocAction) END) = list6.value) left join ad_ref_list_v list7 on (list7.ad_reference_id = '234' and list7.ad_language = ?  AND M_InOut.Posted = TO_CHAR(list7.value))" +
      "        WHERE 2=2 " +
      " AND M_InOut.MovementType IN ('V-', 'V+') and M_InOut.isLogistic = 'N'" +
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
        GoodsMovementVendorData objectGoodsMovementVendorData = new GoodsMovementVendorData();
        objectGoodsMovementVendorData.created = UtilSql.getValue(result, "created");
        objectGoodsMovementVendorData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectGoodsMovementVendorData.updated = UtilSql.getValue(result, "updated");
        objectGoodsMovementVendorData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectGoodsMovementVendorData.updatedby = UtilSql.getValue(result, "updatedby");
        objectGoodsMovementVendorData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectGoodsMovementVendorData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectGoodsMovementVendorData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectGoodsMovementVendorData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectGoodsMovementVendorData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectGoodsMovementVendorData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectGoodsMovementVendorData.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectGoodsMovementVendorData.documentno = UtilSql.getValue(result, "documentno");
        objectGoodsMovementVendorData.poreference = UtilSql.getValue(result, "poreference");
        objectGoodsMovementVendorData.description = UtilSql.getValue(result, "description");
        objectGoodsMovementVendorData.internalnote = UtilSql.getValue(result, "internalnote");
        objectGoodsMovementVendorData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectGoodsMovementVendorData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectGoodsMovementVendorData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectGoodsMovementVendorData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectGoodsMovementVendorData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectGoodsMovementVendorData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectGoodsMovementVendorData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectGoodsMovementVendorData.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectGoodsMovementVendorData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectGoodsMovementVendorData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectGoodsMovementVendorData.deliveryLocationId = UtilSql.getValue(result, "delivery_location_id");
        objectGoodsMovementVendorData.deliveryLocationIdr = UtilSql.getValue(result, "delivery_location_idr");
        objectGoodsMovementVendorData.priorityrule = UtilSql.getValue(result, "priorityrule");
        objectGoodsMovementVendorData.priorityruler = UtilSql.getValue(result, "priorityruler");
        objectGoodsMovementVendorData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectGoodsMovementVendorData.deliveryviaruler = UtilSql.getValue(result, "deliveryviaruler");
        objectGoodsMovementVendorData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectGoodsMovementVendorData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectGoodsMovementVendorData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectGoodsMovementVendorData.deliveryruler = UtilSql.getValue(result, "deliveryruler");
        objectGoodsMovementVendorData.qty = UtilSql.getValue(result, "qty");
        objectGoodsMovementVendorData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectGoodsMovementVendorData.cChargeIdr = UtilSql.getValue(result, "c_charge_idr");
        objectGoodsMovementVendorData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectGoodsMovementVendorData.createfrom = UtilSql.getValue(result, "createfrom");
        objectGoodsMovementVendorData.generateto = UtilSql.getValue(result, "generateto");
        objectGoodsMovementVendorData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectGoodsMovementVendorData.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectGoodsMovementVendorData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectGoodsMovementVendorData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectGoodsMovementVendorData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectGoodsMovementVendorData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectGoodsMovementVendorData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectGoodsMovementVendorData.cActivityIdr = UtilSql.getValue(result, "c_activity_idr");
        objectGoodsMovementVendorData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectGoodsMovementVendorData.cCampaignIdr = UtilSql.getValue(result, "c_campaign_idr");
        objectGoodsMovementVendorData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectGoodsMovementVendorData.adOrgtrxIdr = UtilSql.getValue(result, "ad_orgtrx_idr");
        objectGoodsMovementVendorData.user1Id = UtilSql.getValue(result, "user1_id");
        objectGoodsMovementVendorData.user2Id = UtilSql.getValue(result, "user2_id");
        objectGoodsMovementVendorData.docstatus = UtilSql.getValue(result, "docstatus");
        objectGoodsMovementVendorData.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectGoodsMovementVendorData.movementtype = UtilSql.getValue(result, "movementtype");
        objectGoodsMovementVendorData.movementtyper = UtilSql.getValue(result, "movementtyper");
        objectGoodsMovementVendorData.docaction = UtilSql.getValue(result, "docaction");
        objectGoodsMovementVendorData.docactionBtn = UtilSql.getValue(result, "docaction_btn");
        objectGoodsMovementVendorData.posted = UtilSql.getValue(result, "posted");
        objectGoodsMovementVendorData.postedBtn = UtilSql.getValue(result, "posted_btn");
        objectGoodsMovementVendorData.issotrx = UtilSql.getValue(result, "issotrx");
        objectGoodsMovementVendorData.pickdate = UtilSql.getDateValue(result, "pickdate", "dd-MM-yyyy");
        objectGoodsMovementVendorData.trackingno = UtilSql.getValue(result, "trackingno");
        objectGoodsMovementVendorData.freightcostrule = UtilSql.getValue(result, "freightcostrule");
        objectGoodsMovementVendorData.shipdate = UtilSql.getDateValue(result, "shipdate", "dd-MM-yyyy");
        objectGoodsMovementVendorData.freightamt = UtilSql.getValue(result, "freightamt");
        objectGoodsMovementVendorData.processed = UtilSql.getValue(result, "processed");
        objectGoodsMovementVendorData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectGoodsMovementVendorData.islogistic = UtilSql.getValue(result, "islogistic");
        objectGoodsMovementVendorData.updatelines = UtilSql.getValue(result, "updatelines");
        objectGoodsMovementVendorData.generatelines = UtilSql.getValue(result, "generatelines");
        objectGoodsMovementVendorData.dateprinted = UtilSql.getDateValue(result, "dateprinted", "dd-MM-yyyy");
        objectGoodsMovementVendorData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectGoodsMovementVendorData.processing = UtilSql.getValue(result, "processing");
        objectGoodsMovementVendorData.isactive = UtilSql.getValue(result, "isactive");
        objectGoodsMovementVendorData.mInoutId = UtilSql.getValue(result, "m_inout_id");
        objectGoodsMovementVendorData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectGoodsMovementVendorData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectGoodsMovementVendorData.isprinted = UtilSql.getValue(result, "isprinted");
        objectGoodsMovementVendorData.language = UtilSql.getValue(result, "language");
        objectGoodsMovementVendorData.adUserClient = "";
        objectGoodsMovementVendorData.adOrgClient = "";
        objectGoodsMovementVendorData.createdby = "";
        objectGoodsMovementVendorData.trBgcolor = "";
        objectGoodsMovementVendorData.totalCount = "";
        objectGoodsMovementVendorData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGoodsMovementVendorData);
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
    GoodsMovementVendorData objectGoodsMovementVendorData[] = new GoodsMovementVendorData[vector.size()];
    vector.copyInto(objectGoodsMovementVendorData);
    return(objectGoodsMovementVendorData);
  }

/**
Create a registry
 */
  public static GoodsMovementVendorData[] set(String cActivityId, String updatelines, String freightamt, String adClientId, String deliveryLocationId, String movementtype, String chargeamt, String posted, String postedBtn, String deliveryviarule, String shipdate, String adUserId, String aAssetId, String docstatus, String islogistic, String isprinted, String mShipperId, String deliveryrule, String qty, String cBpartnerLocationId, String cInvoiceId, String trackingno, String generatelines, String updatedby, String updatedbyr, String createdby, String createdbyr, String cChargeId, String processed, String issotrx, String dateprinted, String freightcostrule, String user2Id, String isactive, String internalnote, String salesrepId, String cBpartnerId, String cBpartnerIdr, String createfrom, String cProjecttaskId, String adOrgId, String cOrderId, String cOrderIdr, String dateacct, String priorityrule, String mInoutId, String mWarehouseId, String adOrgtrxId, String dateordered, String processing, String poreference, String user1Id, String documentno, String docaction, String docactionBtn, String generateto, String cProjectId, String cProjectIdr, String cDoctypeId, String movementdate, String pickdate, String description, String cCampaignId)    throws ServletException {
    GoodsMovementVendorData objectGoodsMovementVendorData[] = new GoodsMovementVendorData[1];
    objectGoodsMovementVendorData[0] = new GoodsMovementVendorData();
    objectGoodsMovementVendorData[0].created = "";
    objectGoodsMovementVendorData[0].createdbyr = createdbyr;
    objectGoodsMovementVendorData[0].updated = "";
    objectGoodsMovementVendorData[0].updatedTimeStamp = "";
    objectGoodsMovementVendorData[0].updatedby = updatedby;
    objectGoodsMovementVendorData[0].updatedbyr = updatedbyr;
    objectGoodsMovementVendorData[0].adClientId = adClientId;
    objectGoodsMovementVendorData[0].adClientIdr = "";
    objectGoodsMovementVendorData[0].adOrgId = adOrgId;
    objectGoodsMovementVendorData[0].adOrgIdr = "";
    objectGoodsMovementVendorData[0].cOrderId = cOrderId;
    objectGoodsMovementVendorData[0].cOrderIdr = cOrderIdr;
    objectGoodsMovementVendorData[0].documentno = documentno;
    objectGoodsMovementVendorData[0].poreference = poreference;
    objectGoodsMovementVendorData[0].description = description;
    objectGoodsMovementVendorData[0].internalnote = internalnote;
    objectGoodsMovementVendorData[0].cDoctypeId = cDoctypeId;
    objectGoodsMovementVendorData[0].cDoctypeIdr = "";
    objectGoodsMovementVendorData[0].movementdate = movementdate;
    objectGoodsMovementVendorData[0].dateacct = dateacct;
    objectGoodsMovementVendorData[0].cBpartnerId = cBpartnerId;
    objectGoodsMovementVendorData[0].cBpartnerIdr = cBpartnerIdr;
    objectGoodsMovementVendorData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectGoodsMovementVendorData[0].cBpartnerLocationIdr = "";
    objectGoodsMovementVendorData[0].adUserId = adUserId;
    objectGoodsMovementVendorData[0].adUserIdr = "";
    objectGoodsMovementVendorData[0].deliveryLocationId = deliveryLocationId;
    objectGoodsMovementVendorData[0].deliveryLocationIdr = "";
    objectGoodsMovementVendorData[0].priorityrule = priorityrule;
    objectGoodsMovementVendorData[0].priorityruler = "";
    objectGoodsMovementVendorData[0].deliveryviarule = deliveryviarule;
    objectGoodsMovementVendorData[0].deliveryviaruler = "";
    objectGoodsMovementVendorData[0].salesrepId = salesrepId;
    objectGoodsMovementVendorData[0].salesrepIdr = "";
    objectGoodsMovementVendorData[0].deliveryrule = deliveryrule;
    objectGoodsMovementVendorData[0].deliveryruler = "";
    objectGoodsMovementVendorData[0].qty = qty;
    objectGoodsMovementVendorData[0].cChargeId = cChargeId;
    objectGoodsMovementVendorData[0].cChargeIdr = "";
    objectGoodsMovementVendorData[0].chargeamt = chargeamt;
    objectGoodsMovementVendorData[0].createfrom = createfrom;
    objectGoodsMovementVendorData[0].generateto = generateto;
    objectGoodsMovementVendorData[0].aAssetId = aAssetId;
    objectGoodsMovementVendorData[0].aAssetIdr = "";
    objectGoodsMovementVendorData[0].cProjectId = cProjectId;
    objectGoodsMovementVendorData[0].cProjectIdr = cProjectIdr;
    objectGoodsMovementVendorData[0].cProjecttaskId = cProjecttaskId;
    objectGoodsMovementVendorData[0].cProjecttaskIdr = "";
    objectGoodsMovementVendorData[0].cActivityId = cActivityId;
    objectGoodsMovementVendorData[0].cActivityIdr = "";
    objectGoodsMovementVendorData[0].cCampaignId = cCampaignId;
    objectGoodsMovementVendorData[0].cCampaignIdr = "";
    objectGoodsMovementVendorData[0].adOrgtrxId = adOrgtrxId;
    objectGoodsMovementVendorData[0].adOrgtrxIdr = "";
    objectGoodsMovementVendorData[0].user1Id = user1Id;
    objectGoodsMovementVendorData[0].user2Id = user2Id;
    objectGoodsMovementVendorData[0].docstatus = docstatus;
    objectGoodsMovementVendorData[0].docstatusr = "";
    objectGoodsMovementVendorData[0].movementtype = movementtype;
    objectGoodsMovementVendorData[0].movementtyper = "";
    objectGoodsMovementVendorData[0].docaction = docaction;
    objectGoodsMovementVendorData[0].docactionBtn = docactionBtn;
    objectGoodsMovementVendorData[0].posted = posted;
    objectGoodsMovementVendorData[0].postedBtn = postedBtn;
    objectGoodsMovementVendorData[0].issotrx = issotrx;
    objectGoodsMovementVendorData[0].pickdate = pickdate;
    objectGoodsMovementVendorData[0].trackingno = trackingno;
    objectGoodsMovementVendorData[0].freightcostrule = freightcostrule;
    objectGoodsMovementVendorData[0].shipdate = shipdate;
    objectGoodsMovementVendorData[0].freightamt = freightamt;
    objectGoodsMovementVendorData[0].processed = processed;
    objectGoodsMovementVendorData[0].dateordered = dateordered;
    objectGoodsMovementVendorData[0].islogistic = islogistic;
    objectGoodsMovementVendorData[0].updatelines = updatelines;
    objectGoodsMovementVendorData[0].generatelines = generatelines;
    objectGoodsMovementVendorData[0].dateprinted = dateprinted;
    objectGoodsMovementVendorData[0].mShipperId = mShipperId;
    objectGoodsMovementVendorData[0].processing = processing;
    objectGoodsMovementVendorData[0].isactive = isactive;
    objectGoodsMovementVendorData[0].mInoutId = mInoutId;
    objectGoodsMovementVendorData[0].mWarehouseId = mWarehouseId;
    objectGoodsMovementVendorData[0].cInvoiceId = cInvoiceId;
    objectGoodsMovementVendorData[0].isprinted = isprinted;
    objectGoodsMovementVendorData[0].language = "";
    return objectGoodsMovementVendorData;
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
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , C_Order_ID = (?) , DocumentNo = (?) , POReference = (?) , Description = (?) , Internalnote = (?) , C_DocType_ID = (?) , MovementDate = TO_DATE(?) , DateAcct = TO_DATE(?) , C_BPartner_ID = (?) , C_BPartner_Location_ID = (?) , AD_User_ID = (?) , Delivery_Location_ID = (?) , PriorityRule = (?) , DeliveryViaRule = (?) , SalesRep_ID = (?) , DeliveryRule = (?) , Qty = TO_NUMBER(?) , C_Charge_ID = (?) , ChargeAmt = TO_NUMBER(?) , CreateFrom = (?) , GenerateTo = (?) , A_Asset_ID = (?) , C_Project_ID = (?) , C_Projecttask_ID = (?) , C_Activity_ID = (?) , C_Campaign_ID = (?) , AD_OrgTrx_ID = (?) , User1_ID = (?) , User2_ID = (?) , DocStatus = (?) , MovementType = (?) , DocAction = (?) , Posted = (?) , IsSOTrx = (?) , PickDate = TO_DATE(?) , TrackingNo = (?) , FreightCostRule = (?) , ShipDate = TO_DATE(?) , FreightAmt = TO_NUMBER(?) , Processed = (?) , DateOrdered = TO_DATE(?) , Islogistic = (?) , UpdateLines = (?) , GenerateLines = (?) , DatePrinted = TO_DATE(?) , M_Shipper_ID = (?) , Processing = (?) , IsActive = (?) , M_InOut_ID = (?) , M_Warehouse_ID = (?) , C_Invoice_ID = (?) , IsPrinted = (?) , updated = now(), updatedby = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pickdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, trackingno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islogistic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatelines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatelines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
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
      "        (AD_Client_ID, AD_Org_ID, C_Order_ID, DocumentNo, POReference, Description, Internalnote, C_DocType_ID, MovementDate, DateAcct, C_BPartner_ID, C_BPartner_Location_ID, AD_User_ID, Delivery_Location_ID, PriorityRule, DeliveryViaRule, SalesRep_ID, DeliveryRule, Qty, C_Charge_ID, ChargeAmt, CreateFrom, GenerateTo, A_Asset_ID, C_Project_ID, C_Projecttask_ID, C_Activity_ID, C_Campaign_ID, AD_OrgTrx_ID, User1_ID, User2_ID, DocStatus, MovementType, DocAction, Posted, IsSOTrx, PickDate, TrackingNo, FreightCostRule, ShipDate, FreightAmt, Processed, DateOrdered, Islogistic, UpdateLines, GenerateLines, DatePrinted, M_Shipper_ID, Processing, IsActive, M_InOut_ID, M_Warehouse_ID, C_Invoice_ID, IsPrinted, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), TO_DATE(?), TO_NUMBER(?), (?), TO_DATE(?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pickdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, trackingno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islogistic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatelines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatelines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
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
