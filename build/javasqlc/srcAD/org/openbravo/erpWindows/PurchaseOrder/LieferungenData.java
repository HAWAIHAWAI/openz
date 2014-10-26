//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.PurchaseOrder;

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
class LieferungenData implements FieldProvider {
static Logger log4j = Logger.getLogger(LieferungenData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String user2Id;
  public String user1Id;
  public String adOrgtrxId;
  public String posted;
  public String poreference;
  public String updatelines;
  public String documentno;
  public String islogistic;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String generatelines;
  public String description;
  public String movementdate;
  public String deliveryLocationId;
  public String deliveryLocationIdr;
  public String cProjectId;
  public String cProjectIdr;
  public String adOrgId;
  public String cCampaignId;
  public String cCampaignIdr;
  public String cActivityId;
  public String cActivityIdr;
  public String shipdate;
  public String pickdate;
  public String qty;
  public String trackingno;
  public String salesrepId;
  public String salesrepIdr;
  public String dateordered;
  public String priorityrule;
  public String priorityruler;
  public String chargeamt;
  public String cChargeId;
  public String cChargeIdr;
  public String mShipperId;
  public String mShipperIdr;
  public String deliveryviarule;
  public String deliveryviaruler;
  public String deliveryrule;
  public String deliveryruler;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String adUserId;
  public String adUserIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cBpartnerLocationId;
  public String dateacct;
  public String cOrderId;
  public String cOrderIdr;
  public String dateprinted;
  public String freightamt;
  public String freightcostrule;
  public String freightcostruler;
  public String issotrx;
  public String isactive;
  public String movementtype;
  public String movementtyper;
  public String docstatus;
  public String docstatusr;
  public String cInvoiceId;
  public String cInvoiceIdr;
  public String createfrom;
  public String isprinted;
  public String generateto;
  public String docaction;
  public String processed;
  public String processing;
  public String mInoutId;
  public String adClientId;
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
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("updatelines"))
      return updatelines;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("islogistic"))
      return islogistic;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("generatelines"))
      return generatelines;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("delivery_location_id") || fieldName.equals("deliveryLocationId"))
      return deliveryLocationId;
    else if (fieldName.equalsIgnoreCase("delivery_location_idr") || fieldName.equals("deliveryLocationIdr"))
      return deliveryLocationIdr;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_campaign_idr") || fieldName.equals("cCampaignIdr"))
      return cCampaignIdr;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("c_activity_idr") || fieldName.equals("cActivityIdr"))
      return cActivityIdr;
    else if (fieldName.equalsIgnoreCase("shipdate"))
      return shipdate;
    else if (fieldName.equalsIgnoreCase("pickdate"))
      return pickdate;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("trackingno"))
      return trackingno;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("priorityrule"))
      return priorityrule;
    else if (fieldName.equalsIgnoreCase("priorityruler"))
      return priorityruler;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("c_charge_idr") || fieldName.equals("cChargeIdr"))
      return cChargeIdr;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("m_shipper_idr") || fieldName.equals("mShipperIdr"))
      return mShipperIdr;
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
    else if (fieldName.equalsIgnoreCase("deliveryviaruler"))
      return deliveryviaruler;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("deliveryruler"))
      return deliveryruler;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_order_idr") || fieldName.equals("cOrderIdr"))
      return cOrderIdr;
    else if (fieldName.equalsIgnoreCase("dateprinted"))
      return dateprinted;
    else if (fieldName.equalsIgnoreCase("freightamt"))
      return freightamt;
    else if (fieldName.equalsIgnoreCase("freightcostrule"))
      return freightcostrule;
    else if (fieldName.equalsIgnoreCase("freightcostruler"))
      return freightcostruler;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("movementtype"))
      return movementtype;
    else if (fieldName.equalsIgnoreCase("movementtyper"))
      return movementtyper;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("c_invoice_idr") || fieldName.equals("cInvoiceIdr"))
      return cInvoiceIdr;
    else if (fieldName.equalsIgnoreCase("createfrom"))
      return createfrom;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("generateto"))
      return generateto;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("m_inout_id") || fieldName.equals("mInoutId"))
      return mInoutId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
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
  public static LieferungenData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cOrderId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cOrderId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static LieferungenData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cOrderId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_InOut.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_InOut.CreatedBy) as CreatedByR, " +
      "        to_char(M_InOut.Updated, ?) as updated, " +
      "        to_char(M_InOut.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_InOut.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_InOut.UpdatedBy) as UpdatedByR," +
      "        M_InOut.User2_ID, " +
      "M_InOut.User1_ID, " +
      "M_InOut.AD_OrgTrx_ID, " +
      "M_InOut.Posted, " +
      "M_InOut.POReference, " +
      "M_InOut.UpdateLines, " +
      "M_InOut.DocumentNo, " +
      "COALESCE(M_InOut.Islogistic, 'N') AS Islogistic, " +
      "M_InOut.C_DocType_ID, " +
      "(CASE WHEN M_InOut.C_DocType_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS C_DocType_IDR, " +
      "M_InOut.GenerateLines, " +
      "M_InOut.Description, " +
      "M_InOut.MovementDate, " +
      "M_InOut.Delivery_Location_ID, " +
      "(CASE WHEN M_InOut.Delivery_Location_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS Delivery_Location_IDR, " +
      "M_InOut.C_Project_ID, " +
      "(CASE WHEN M_InOut.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "M_InOut.AD_Org_ID, " +
      "M_InOut.C_Campaign_ID, " +
      "(CASE WHEN M_InOut.C_Campaign_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Campaign_IDR, " +
      "M_InOut.C_Activity_ID, " +
      "(CASE WHEN M_InOut.C_Activity_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_Activity_IDR, " +
      "M_InOut.ShipDate, " +
      "M_InOut.PickDate, " +
      "M_InOut.Qty, " +
      "M_InOut.TrackingNo, " +
      "M_InOut.SalesRep_ID, " +
      "(CASE WHEN M_InOut.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "M_InOut.DateOrdered, " +
      "M_InOut.PriorityRule, " +
      "(CASE WHEN M_InOut.PriorityRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS PriorityRuleR, " +
      "M_InOut.ChargeAmt, " +
      "M_InOut.C_Charge_ID, " +
      "(CASE WHEN M_InOut.C_Charge_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_Charge_IDR, " +
      "M_InOut.M_Shipper_ID, " +
      "(CASE WHEN M_InOut.M_Shipper_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS M_Shipper_IDR, " +
      "M_InOut.DeliveryViaRule, " +
      "(CASE WHEN M_InOut.DeliveryViaRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS DeliveryViaRuleR, " +
      "M_InOut.DeliveryRule, " +
      "(CASE WHEN M_InOut.DeliveryRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS DeliveryRuleR, " +
      "M_InOut.M_Warehouse_ID, " +
      "(CASE WHEN M_InOut.M_Warehouse_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "M_InOut.AD_User_ID, " +
      "(CASE WHEN M_InOut.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "M_InOut.C_BPartner_ID, " +
      "(CASE WHEN M_InOut.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "M_InOut.C_BPartner_Location_ID, " +
      "M_InOut.DateAcct, " +
      "M_InOut.C_Order_ID, " +
      "(CASE WHEN M_InOut.C_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table12.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.GrandTotal), ''))),'') ) END) AS C_Order_IDR, " +
      "M_InOut.DatePrinted, " +
      "M_InOut.FreightAmt, " +
      "M_InOut.FreightCostRule, " +
      "(CASE WHEN M_InOut.FreightCostRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS FreightCostRuleR, " +
      "COALESCE(M_InOut.IsSOTrx, 'N') AS IsSOTrx, " +
      "COALESCE(M_InOut.IsActive, 'N') AS IsActive, " +
      "M_InOut.MovementType, " +
      "(CASE WHEN M_InOut.MovementType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list5.name),'') ) END) AS MovementTypeR, " +
      "M_InOut.DocStatus, " +
      "(CASE WHEN M_InOut.DocStatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list6.name),'') ) END) AS DocStatusR, " +
      "M_InOut.C_Invoice_ID, " +
      "(CASE WHEN M_InOut.C_Invoice_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table13.DateInvoiced, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.GrandTotal), ''))),'') ) END) AS C_Invoice_IDR, " +
      "M_InOut.CreateFrom, " +
      "COALESCE(M_InOut.IsPrinted, 'N') AS IsPrinted, " +
      "M_InOut.GenerateTo, " +
      "M_InOut.DocAction, " +
      "COALESCE(M_InOut.Processed, 'N') AS Processed, " +
      "COALESCE(M_InOut.Processing, 'N') AS Processing, " +
      "M_InOut.M_InOut_ID, " +
      "M_InOut.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM M_InOut left join (select C_DocType_ID, Name from C_DocType) table1 on (M_InOut.C_DocType_ID =  table1.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL1 on (table1.C_DocType_ID = tableTRL1.C_DocType_ID and tableTRL1.AD_Language = ?)  left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table2 on (M_InOut.Delivery_Location_ID =  table2.C_BPartner_Location_ID) left join (select C_Project_ID, Value, Name from C_Project) table3 on (M_InOut.C_Project_ID = table3.C_Project_ID) left join (select C_Campaign_ID, Name from C_Campaign) table4 on (M_InOut.C_Campaign_ID = table4.C_Campaign_ID) left join (select C_Activity_ID, Name from C_Activity) table5 on (M_InOut.C_Activity_ID = table5.C_Activity_ID) left join (select AD_User_ID, Name from AD_User) table6 on (M_InOut.SalesRep_ID =  table6.AD_User_ID) left join ad_ref_list_v list1 on (M_InOut.PriorityRule = list1.value and list1.ad_reference_id = '154' and list1.ad_language = ?)  left join (select C_Charge_ID, Name from C_Charge) table7 on (M_InOut.C_Charge_ID =  table7.C_Charge_ID) left join (select M_Shipper_ID, Name from M_Shipper) table8 on (M_InOut.M_Shipper_ID = table8.M_Shipper_ID) left join ad_ref_list_v list2 on (M_InOut.DeliveryViaRule = list2.value and list2.ad_reference_id = '152' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (M_InOut.DeliveryRule = list3.value and list3.ad_reference_id = '151' and list3.ad_language = ?)  left join (select M_Warehouse_ID, Name from M_Warehouse) table9 on (M_InOut.M_Warehouse_ID =  table9.M_Warehouse_ID) left join (select AD_User_ID, Name from AD_User) table10 on (M_InOut.AD_User_ID = table10.AD_User_ID) left join (select C_BPartner_ID, Name from C_BPartner) table11 on (M_InOut.C_BPartner_ID = table11.C_BPartner_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table12 on (M_InOut.C_Order_ID = table12.C_Order_ID) left join ad_ref_list_v list4 on (M_InOut.FreightCostRule = list4.value and list4.ad_reference_id = '153' and list4.ad_language = ?)  left join ad_ref_list_v list5 on (M_InOut.MovementType = list5.value and list5.ad_reference_id = '189' and list5.ad_language = ?)  left join ad_ref_list_v list6 on (M_InOut.DocStatus = list6.value and list6.ad_reference_id = '131' and list6.ad_language = ?)  left join (select C_Invoice_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice) table13 on (M_InOut.C_Invoice_ID = table13.C_Invoice_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cOrderId==null || cOrderId.equals(""))?"":"  AND M_InOut.C_Order_ID = ?  ");
    strSql = strSql + 
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
        LieferungenData objectLieferungenData = new LieferungenData();
        objectLieferungenData.created = UtilSql.getValue(result, "created");
        objectLieferungenData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectLieferungenData.updated = UtilSql.getValue(result, "updated");
        objectLieferungenData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectLieferungenData.updatedby = UtilSql.getValue(result, "updatedby");
        objectLieferungenData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectLieferungenData.user2Id = UtilSql.getValue(result, "user2_id");
        objectLieferungenData.user1Id = UtilSql.getValue(result, "user1_id");
        objectLieferungenData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectLieferungenData.posted = UtilSql.getValue(result, "posted");
        objectLieferungenData.poreference = UtilSql.getValue(result, "poreference");
        objectLieferungenData.updatelines = UtilSql.getValue(result, "updatelines");
        objectLieferungenData.documentno = UtilSql.getValue(result, "documentno");
        objectLieferungenData.islogistic = UtilSql.getValue(result, "islogistic");
        objectLieferungenData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectLieferungenData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectLieferungenData.generatelines = UtilSql.getValue(result, "generatelines");
        objectLieferungenData.description = UtilSql.getValue(result, "description");
        objectLieferungenData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectLieferungenData.deliveryLocationId = UtilSql.getValue(result, "delivery_location_id");
        objectLieferungenData.deliveryLocationIdr = UtilSql.getValue(result, "delivery_location_idr");
        objectLieferungenData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectLieferungenData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectLieferungenData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectLieferungenData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectLieferungenData.cCampaignIdr = UtilSql.getValue(result, "c_campaign_idr");
        objectLieferungenData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectLieferungenData.cActivityIdr = UtilSql.getValue(result, "c_activity_idr");
        objectLieferungenData.shipdate = UtilSql.getDateValue(result, "shipdate", "dd-MM-yyyy");
        objectLieferungenData.pickdate = UtilSql.getDateValue(result, "pickdate", "dd-MM-yyyy");
        objectLieferungenData.qty = UtilSql.getValue(result, "qty");
        objectLieferungenData.trackingno = UtilSql.getValue(result, "trackingno");
        objectLieferungenData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectLieferungenData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectLieferungenData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectLieferungenData.priorityrule = UtilSql.getValue(result, "priorityrule");
        objectLieferungenData.priorityruler = UtilSql.getValue(result, "priorityruler");
        objectLieferungenData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectLieferungenData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectLieferungenData.cChargeIdr = UtilSql.getValue(result, "c_charge_idr");
        objectLieferungenData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectLieferungenData.mShipperIdr = UtilSql.getValue(result, "m_shipper_idr");
        objectLieferungenData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectLieferungenData.deliveryviaruler = UtilSql.getValue(result, "deliveryviaruler");
        objectLieferungenData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectLieferungenData.deliveryruler = UtilSql.getValue(result, "deliveryruler");
        objectLieferungenData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectLieferungenData.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectLieferungenData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectLieferungenData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectLieferungenData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectLieferungenData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectLieferungenData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectLieferungenData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectLieferungenData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectLieferungenData.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectLieferungenData.dateprinted = UtilSql.getDateValue(result, "dateprinted", "dd-MM-yyyy");
        objectLieferungenData.freightamt = UtilSql.getValue(result, "freightamt");
        objectLieferungenData.freightcostrule = UtilSql.getValue(result, "freightcostrule");
        objectLieferungenData.freightcostruler = UtilSql.getValue(result, "freightcostruler");
        objectLieferungenData.issotrx = UtilSql.getValue(result, "issotrx");
        objectLieferungenData.isactive = UtilSql.getValue(result, "isactive");
        objectLieferungenData.movementtype = UtilSql.getValue(result, "movementtype");
        objectLieferungenData.movementtyper = UtilSql.getValue(result, "movementtyper");
        objectLieferungenData.docstatus = UtilSql.getValue(result, "docstatus");
        objectLieferungenData.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectLieferungenData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectLieferungenData.cInvoiceIdr = UtilSql.getValue(result, "c_invoice_idr");
        objectLieferungenData.createfrom = UtilSql.getValue(result, "createfrom");
        objectLieferungenData.isprinted = UtilSql.getValue(result, "isprinted");
        objectLieferungenData.generateto = UtilSql.getValue(result, "generateto");
        objectLieferungenData.docaction = UtilSql.getValue(result, "docaction");
        objectLieferungenData.processed = UtilSql.getValue(result, "processed");
        objectLieferungenData.processing = UtilSql.getValue(result, "processing");
        objectLieferungenData.mInoutId = UtilSql.getValue(result, "m_inout_id");
        objectLieferungenData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectLieferungenData.language = UtilSql.getValue(result, "language");
        objectLieferungenData.adUserClient = "";
        objectLieferungenData.adOrgClient = "";
        objectLieferungenData.createdby = "";
        objectLieferungenData.trBgcolor = "";
        objectLieferungenData.totalCount = "";
        objectLieferungenData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLieferungenData);
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
    LieferungenData objectLieferungenData[] = new LieferungenData[vector.size()];
    vector.copyInto(objectLieferungenData);
    return(objectLieferungenData);
  }

/**
Create a registry
 */
  public static LieferungenData[] set(String cOrderId, String cActivityId, String updatelines, String deliveryLocationId, String user1Id, String generateto, String docaction, String chargeamt, String movementtype, String deliveryviarule, String adUserId, String islogistic, String docstatus, String pickdate, String isprinted, String deliveryrule, String createfrom, String qty, String adOrgId, String generatelines, String updatedby, String updatedbyr, String dateordered, String createdby, String createdbyr, String cChargeId, String processed, String issotrx, String adOrgtrxId, String mWarehouseId, String salesrepId, String cBpartnerId, String cBpartnerIdr, String trackingno, String cInvoiceId, String cInvoiceIdr, String cBpartnerLocationId, String dateacct, String priorityrule, String cOrderIdr, String mInoutId, String dateprinted, String freightcostrule, String user2Id, String isactive, String processing, String adClientId, String poreference, String documentno, String cProjectId, String cProjectIdr, String cDoctypeId, String freightamt, String movementdate, String description, String mShipperId, String cCampaignId, String posted, String shipdate)    throws ServletException {
    LieferungenData objectLieferungenData[] = new LieferungenData[1];
    objectLieferungenData[0] = new LieferungenData();
    objectLieferungenData[0].created = "";
    objectLieferungenData[0].createdbyr = createdbyr;
    objectLieferungenData[0].updated = "";
    objectLieferungenData[0].updatedTimeStamp = "";
    objectLieferungenData[0].updatedby = updatedby;
    objectLieferungenData[0].updatedbyr = updatedbyr;
    objectLieferungenData[0].user2Id = user2Id;
    objectLieferungenData[0].user1Id = user1Id;
    objectLieferungenData[0].adOrgtrxId = adOrgtrxId;
    objectLieferungenData[0].posted = posted;
    objectLieferungenData[0].poreference = poreference;
    objectLieferungenData[0].updatelines = updatelines;
    objectLieferungenData[0].documentno = documentno;
    objectLieferungenData[0].islogistic = islogistic;
    objectLieferungenData[0].cDoctypeId = cDoctypeId;
    objectLieferungenData[0].cDoctypeIdr = "";
    objectLieferungenData[0].generatelines = generatelines;
    objectLieferungenData[0].description = description;
    objectLieferungenData[0].movementdate = movementdate;
    objectLieferungenData[0].deliveryLocationId = deliveryLocationId;
    objectLieferungenData[0].deliveryLocationIdr = "";
    objectLieferungenData[0].cProjectId = cProjectId;
    objectLieferungenData[0].cProjectIdr = cProjectIdr;
    objectLieferungenData[0].adOrgId = adOrgId;
    objectLieferungenData[0].cCampaignId = cCampaignId;
    objectLieferungenData[0].cCampaignIdr = "";
    objectLieferungenData[0].cActivityId = cActivityId;
    objectLieferungenData[0].cActivityIdr = "";
    objectLieferungenData[0].shipdate = shipdate;
    objectLieferungenData[0].pickdate = pickdate;
    objectLieferungenData[0].qty = qty;
    objectLieferungenData[0].trackingno = trackingno;
    objectLieferungenData[0].salesrepId = salesrepId;
    objectLieferungenData[0].salesrepIdr = "";
    objectLieferungenData[0].dateordered = dateordered;
    objectLieferungenData[0].priorityrule = priorityrule;
    objectLieferungenData[0].priorityruler = "";
    objectLieferungenData[0].chargeamt = chargeamt;
    objectLieferungenData[0].cChargeId = cChargeId;
    objectLieferungenData[0].cChargeIdr = "";
    objectLieferungenData[0].mShipperId = mShipperId;
    objectLieferungenData[0].mShipperIdr = "";
    objectLieferungenData[0].deliveryviarule = deliveryviarule;
    objectLieferungenData[0].deliveryviaruler = "";
    objectLieferungenData[0].deliveryrule = deliveryrule;
    objectLieferungenData[0].deliveryruler = "";
    objectLieferungenData[0].mWarehouseId = mWarehouseId;
    objectLieferungenData[0].mWarehouseIdr = "";
    objectLieferungenData[0].adUserId = adUserId;
    objectLieferungenData[0].adUserIdr = "";
    objectLieferungenData[0].cBpartnerId = cBpartnerId;
    objectLieferungenData[0].cBpartnerIdr = cBpartnerIdr;
    objectLieferungenData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectLieferungenData[0].dateacct = dateacct;
    objectLieferungenData[0].cOrderId = cOrderId;
    objectLieferungenData[0].cOrderIdr = cOrderIdr;
    objectLieferungenData[0].dateprinted = dateprinted;
    objectLieferungenData[0].freightamt = freightamt;
    objectLieferungenData[0].freightcostrule = freightcostrule;
    objectLieferungenData[0].freightcostruler = "";
    objectLieferungenData[0].issotrx = issotrx;
    objectLieferungenData[0].isactive = isactive;
    objectLieferungenData[0].movementtype = movementtype;
    objectLieferungenData[0].movementtyper = "";
    objectLieferungenData[0].docstatus = docstatus;
    objectLieferungenData[0].docstatusr = "";
    objectLieferungenData[0].cInvoiceId = cInvoiceId;
    objectLieferungenData[0].cInvoiceIdr = cInvoiceIdr;
    objectLieferungenData[0].createfrom = createfrom;
    objectLieferungenData[0].isprinted = isprinted;
    objectLieferungenData[0].generateto = generateto;
    objectLieferungenData[0].docaction = docaction;
    objectLieferungenData[0].processed = processed;
    objectLieferungenData[0].processing = processing;
    objectLieferungenData[0].mInoutId = mInoutId;
    objectLieferungenData[0].adClientId = adClientId;
    objectLieferungenData[0].language = "";
    return objectLieferungenData;
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
  public static String selectDef5402_3(ConnectionProvider connectionProvider, String C_Invoice_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.DocumentNo), '')  || ' - ' || COALESCE(TO_CHAR(table1.DateInvoiced), '')  || ' - ' || COALESCE(TO_CHAR(table1.GrandTotal), '') ) as C_Invoice_ID FROM C_Invoice table1 WHERE table1.isActive='Y' AND table1.C_Invoice_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Invoice_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_invoice_id");
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
  public static String selectDef3809_4(ConnectionProvider connectionProvider, String C_Order_IDR)    throws ServletException {
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
  public static String selectDef9585_5(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_InOut.C_Order_ID AS NAME" +
      "        FROM M_InOut" +
      "        WHERE M_InOut.M_InOut_ID = ?";

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
      "        SET User2_ID = (?) , User1_ID = (?) , AD_OrgTrx_ID = (?) , Posted = (?) , POReference = (?) , UpdateLines = (?) , DocumentNo = (?) , Islogistic = (?) , C_DocType_ID = (?) , GenerateLines = (?) , Description = (?) , MovementDate = TO_DATE(?) , Delivery_Location_ID = (?) , C_Project_ID = (?) , AD_Org_ID = (?) , C_Campaign_ID = (?) , C_Activity_ID = (?) , ShipDate = TO_DATE(?) , PickDate = TO_DATE(?) , Qty = TO_NUMBER(?) , TrackingNo = (?) , SalesRep_ID = (?) , DateOrdered = TO_DATE(?) , PriorityRule = (?) , ChargeAmt = TO_NUMBER(?) , C_Charge_ID = (?) , M_Shipper_ID = (?) , DeliveryViaRule = (?) , DeliveryRule = (?) , M_Warehouse_ID = (?) , AD_User_ID = (?) , C_BPartner_ID = (?) , C_BPartner_Location_ID = (?) , DateAcct = TO_DATE(?) , C_Order_ID = (?) , DatePrinted = TO_DATE(?) , FreightAmt = TO_NUMBER(?) , FreightCostRule = (?) , IsSOTrx = (?) , IsActive = (?) , MovementType = (?) , DocStatus = (?) , C_Invoice_ID = (?) , CreateFrom = (?) , IsPrinted = (?) , GenerateTo = (?) , DocAction = (?) , Processed = (?) , Processing = (?) , M_InOut_ID = (?) , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE M_InOut.M_InOut_ID = ? " +
      "                 AND M_InOut.C_Order_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatelines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islogistic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatelines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pickdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, trackingno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priorityrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
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
      "        INSERT INTO M_InOut " +
      "        (User2_ID, User1_ID, AD_OrgTrx_ID, Posted, POReference, UpdateLines, DocumentNo, Islogistic, C_DocType_ID, GenerateLines, Description, MovementDate, Delivery_Location_ID, C_Project_ID, AD_Org_ID, C_Campaign_ID, C_Activity_ID, ShipDate, PickDate, Qty, TrackingNo, SalesRep_ID, DateOrdered, PriorityRule, ChargeAmt, C_Charge_ID, M_Shipper_ID, DeliveryViaRule, DeliveryRule, M_Warehouse_ID, AD_User_ID, C_BPartner_ID, C_BPartner_Location_ID, DateAcct, C_Order_ID, DatePrinted, FreightAmt, FreightCostRule, IsSOTrx, IsActive, MovementType, DocStatus, C_Invoice_ID, CreateFrom, IsPrinted, GenerateTo, DocAction, Processed, Processing, M_InOut_ID, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?), (?), (?), TO_DATE(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), TO_DATE(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatelines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islogistic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatelines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pickdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, trackingno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priorityrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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
      "        DELETE FROM M_InOut" +
      "        WHERE M_InOut.M_InOut_ID = ? " +
      "                 AND M_InOut.C_Order_ID = ? " +
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
      "        DELETE FROM M_InOut" +
      "        WHERE M_InOut.M_InOut_ID = ? " +
      "                 AND M_InOut.C_Order_ID = ? ";

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
