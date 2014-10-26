//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.BusinessPartnerInfo;

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
class PartnerOrdersData implements FieldProvider {
static Logger log4j = Logger.getLogger(PartnerOrdersData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String user1Id;
  public String cBpartnerId;
  public String adUserId;
  public String cProjectId;
  public String processing;
  public String issotrx;
  public String istaxincluded;
  public String paymentrule;
  public String processed;
  public String dropshipUserId;
  public String dropshipBpartnerId;
  public String copyfrom;
  public String dropshipLocationId;
  public String adOrgtrxId;
  public String user2Id;
  public String isdelivered;
  public String deliveryrule;
  public String chargeamt;
  public String isdiscountprinted;
  public String cActivityId;
  public String freightcostrule;
  public String dateprinted;
  public String isactive;
  public String isselected;
  public String posted;
  public String cBpartnerLocationId;
  public String dateacct;
  public String cDoctypetargetId;
  public String datepromised;
  public String cPaymenttermId;
  public String freightamt;
  public String mPricelistId;
  public String isprinted;
  public String isinvoiced;
  public String invoicerule;
  public String docaction;
  public String mWarehouseId;
  public String totallines;
  public String poreference;
  public String cCampaignId;
  public String deliveryviarule;
  public String mShipperId;
  public String billtoId;
  public String cChargeId;
  public String priorityrule;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String documentno;
  public String docstatus;
  public String docstatusr;
  public String isselfservice;
  public String dateordered;
  public String salesrepId;
  public String salesrepIdr;
  public String description;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String grandtotal;
  public String cOrderId;
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
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("istaxincluded"))
      return istaxincluded;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("dropship_user_id") || fieldName.equals("dropshipUserId"))
      return dropshipUserId;
    else if (fieldName.equalsIgnoreCase("dropship_bpartner_id") || fieldName.equals("dropshipBpartnerId"))
      return dropshipBpartnerId;
    else if (fieldName.equalsIgnoreCase("copyfrom"))
      return copyfrom;
    else if (fieldName.equalsIgnoreCase("dropship_location_id") || fieldName.equals("dropshipLocationId"))
      return dropshipLocationId;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("isdelivered"))
      return isdelivered;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("isdiscountprinted"))
      return isdiscountprinted;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("freightcostrule"))
      return freightcostrule;
    else if (fieldName.equalsIgnoreCase("dateprinted"))
      return dateprinted;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isselected"))
      return isselected;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_id") || fieldName.equals("cDoctypetargetId"))
      return cDoctypetargetId;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("freightamt"))
      return freightamt;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("isinvoiced"))
      return isinvoiced;
    else if (fieldName.equalsIgnoreCase("invoicerule"))
      return invoicerule;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("totallines"))
      return totallines;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("billto_id") || fieldName.equals("billtoId"))
      return billtoId;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("priorityrule"))
      return priorityrule;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("isselfservice"))
      return isselfservice;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
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
  public static PartnerOrdersData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String C_BPartner_ID, String cBpartnerId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, C_BPartner_ID, cBpartnerId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PartnerOrdersData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String C_BPartner_ID, String cBpartnerId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Order.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Order.CreatedBy) as CreatedByR, " +
      "        to_char(C_Order.Updated, ?) as updated, " +
      "        to_char(C_Order.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Order.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Order.UpdatedBy) as UpdatedByR," +
      "        C_Order.User1_ID, " +
      "C_Order.C_BPartner_ID, " +
      "C_Order.AD_User_ID, " +
      "C_Order.C_Project_ID, " +
      "C_Order.Processing, " +
      "COALESCE(C_Order.IsSOTrx, 'N') AS IsSOTrx, " +
      "COALESCE(C_Order.IsTaxIncluded, 'N') AS IsTaxIncluded, " +
      "C_Order.PaymentRule, " +
      "COALESCE(C_Order.Processed, 'N') AS Processed, " +
      "C_Order.DropShip_User_ID, " +
      "C_Order.DropShip_BPartner_ID, " +
      "C_Order.CopyFrom, " +
      "C_Order.DropShip_Location_ID, " +
      "C_Order.AD_OrgTrx_ID, " +
      "C_Order.User2_ID, " +
      "COALESCE(C_Order.IsDelivered, 'N') AS IsDelivered, " +
      "C_Order.DeliveryRule, " +
      "C_Order.ChargeAmt, " +
      "COALESCE(C_Order.IsDiscountPrinted, 'N') AS IsDiscountPrinted, " +
      "C_Order.C_Activity_ID, " +
      "C_Order.FreightCostRule, " +
      "C_Order.DatePrinted, " +
      "COALESCE(C_Order.IsActive, 'N') AS IsActive, " +
      "COALESCE(C_Order.IsSelected, 'N') AS IsSelected, " +
      "C_Order.Posted, " +
      "C_Order.C_BPartner_Location_ID, " +
      "C_Order.DateAcct, " +
      "C_Order.C_DocTypeTarget_ID, " +
      "C_Order.DatePromised, " +
      "C_Order.C_PaymentTerm_ID, " +
      "C_Order.FreightAmt, " +
      "C_Order.M_PriceList_ID, " +
      "COALESCE(C_Order.IsPrinted, 'N') AS IsPrinted, " +
      "COALESCE(C_Order.IsInvoiced, 'N') AS IsInvoiced, " +
      "C_Order.InvoiceRule, " +
      "C_Order.DocAction, " +
      "C_Order.M_Warehouse_ID, " +
      "C_Order.TotalLines, " +
      "C_Order.POReference, " +
      "C_Order.C_Campaign_ID, " +
      "C_Order.DeliveryViaRule, " +
      "C_Order.M_Shipper_ID, " +
      "C_Order.BillTo_ID, " +
      "C_Order.C_Charge_ID, " +
      "C_Order.PriorityRule, " +
      "C_Order.AD_Client_ID, " +
      "(CASE WHEN C_Order.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_Order.AD_Org_ID, " +
      "(CASE WHEN C_Order.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_Order.C_DocType_ID, " +
      "(CASE WHEN C_Order.C_DocType_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_DocType_IDR, " +
      "C_Order.DocumentNo, " +
      "C_Order.DocStatus, " +
      "(CASE WHEN C_Order.DocStatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DocStatusR, " +
      "COALESCE(C_Order.IsSelfService, 'N') AS IsSelfService, " +
      "C_Order.DateOrdered, " +
      "C_Order.SalesRep_ID, " +
      "(CASE WHEN C_Order.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "C_Order.Description, " +
      "C_Order.C_Currency_ID, " +
      "(CASE WHEN C_Order.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "C_Order.GrandTotal, " +
      "C_Order.C_Order_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Order left join (select AD_Client_ID, Name from AD_Client) table1 on (C_Order.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_Order.AD_Org_ID = table2.AD_Org_ID) left join (select C_DocType_ID, Name from C_DocType) table3 on (C_Order.C_DocType_ID = table3.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL3 on (table3.C_DocType_ID = tableTRL3.C_DocType_ID and tableTRL3.AD_Language = ?)  left join ad_ref_list_v list1 on (C_Order.DocStatus = list1.value and list1.ad_reference_id = '131' and list1.ad_language = ?)  left join (select AD_User_ID, Name from AD_User) table4 on (C_Order.SalesRep_ID =  table4.AD_User_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table5 on (C_Order.C_Currency_ID = table5.C_Currency_ID)" +
      "        WHERE 2=2 " +
      " AND C_Order.C_BPartner_ID=?" +
      "        AND 1=1 ";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_Order.C_BPartner_ID = ?  ");
    strSql = strSql + 
      "        AND C_Order.C_Order_ID = ? " +
      "        AND C_Order.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Order.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_ID);
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
        PartnerOrdersData objectPartnerOrdersData = new PartnerOrdersData();
        objectPartnerOrdersData.created = UtilSql.getValue(result, "created");
        objectPartnerOrdersData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPartnerOrdersData.updated = UtilSql.getValue(result, "updated");
        objectPartnerOrdersData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPartnerOrdersData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPartnerOrdersData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPartnerOrdersData.user1Id = UtilSql.getValue(result, "user1_id");
        objectPartnerOrdersData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectPartnerOrdersData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectPartnerOrdersData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectPartnerOrdersData.processing = UtilSql.getValue(result, "processing");
        objectPartnerOrdersData.issotrx = UtilSql.getValue(result, "issotrx");
        objectPartnerOrdersData.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectPartnerOrdersData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectPartnerOrdersData.processed = UtilSql.getValue(result, "processed");
        objectPartnerOrdersData.dropshipUserId = UtilSql.getValue(result, "dropship_user_id");
        objectPartnerOrdersData.dropshipBpartnerId = UtilSql.getValue(result, "dropship_bpartner_id");
        objectPartnerOrdersData.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectPartnerOrdersData.dropshipLocationId = UtilSql.getValue(result, "dropship_location_id");
        objectPartnerOrdersData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectPartnerOrdersData.user2Id = UtilSql.getValue(result, "user2_id");
        objectPartnerOrdersData.isdelivered = UtilSql.getValue(result, "isdelivered");
        objectPartnerOrdersData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectPartnerOrdersData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectPartnerOrdersData.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectPartnerOrdersData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectPartnerOrdersData.freightcostrule = UtilSql.getValue(result, "freightcostrule");
        objectPartnerOrdersData.dateprinted = UtilSql.getDateValue(result, "dateprinted", "dd-MM-yyyy");
        objectPartnerOrdersData.isactive = UtilSql.getValue(result, "isactive");
        objectPartnerOrdersData.isselected = UtilSql.getValue(result, "isselected");
        objectPartnerOrdersData.posted = UtilSql.getValue(result, "posted");
        objectPartnerOrdersData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectPartnerOrdersData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectPartnerOrdersData.cDoctypetargetId = UtilSql.getValue(result, "c_doctypetarget_id");
        objectPartnerOrdersData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectPartnerOrdersData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectPartnerOrdersData.freightamt = UtilSql.getValue(result, "freightamt");
        objectPartnerOrdersData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectPartnerOrdersData.isprinted = UtilSql.getValue(result, "isprinted");
        objectPartnerOrdersData.isinvoiced = UtilSql.getValue(result, "isinvoiced");
        objectPartnerOrdersData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectPartnerOrdersData.docaction = UtilSql.getValue(result, "docaction");
        objectPartnerOrdersData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectPartnerOrdersData.totallines = UtilSql.getValue(result, "totallines");
        objectPartnerOrdersData.poreference = UtilSql.getValue(result, "poreference");
        objectPartnerOrdersData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectPartnerOrdersData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectPartnerOrdersData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectPartnerOrdersData.billtoId = UtilSql.getValue(result, "billto_id");
        objectPartnerOrdersData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectPartnerOrdersData.priorityrule = UtilSql.getValue(result, "priorityrule");
        objectPartnerOrdersData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPartnerOrdersData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectPartnerOrdersData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPartnerOrdersData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPartnerOrdersData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectPartnerOrdersData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectPartnerOrdersData.documentno = UtilSql.getValue(result, "documentno");
        objectPartnerOrdersData.docstatus = UtilSql.getValue(result, "docstatus");
        objectPartnerOrdersData.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectPartnerOrdersData.isselfservice = UtilSql.getValue(result, "isselfservice");
        objectPartnerOrdersData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectPartnerOrdersData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectPartnerOrdersData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectPartnerOrdersData.description = UtilSql.getValue(result, "description");
        objectPartnerOrdersData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectPartnerOrdersData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectPartnerOrdersData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectPartnerOrdersData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectPartnerOrdersData.language = UtilSql.getValue(result, "language");
        objectPartnerOrdersData.adUserClient = "";
        objectPartnerOrdersData.adOrgClient = "";
        objectPartnerOrdersData.createdby = "";
        objectPartnerOrdersData.trBgcolor = "";
        objectPartnerOrdersData.totalCount = "";
        objectPartnerOrdersData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPartnerOrdersData);
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
    PartnerOrdersData objectPartnerOrdersData[] = new PartnerOrdersData[vector.size()];
    vector.copyInto(objectPartnerOrdersData);
    return(objectPartnerOrdersData);
  }

/**
Create a registry
 */
  public static PartnerOrdersData[] set(String cBpartnerId, String adUserId, String isdelivered, String issotrx, String dropshipLocationId, String createdby, String createdbyr, String adClientId, String cPaymenttermId, String isselected, String dateordered, String cProjectId, String cActivityId, String paymentrule, String documentno, String poreference, String mWarehouseId, String dropshipUserId, String dateacct, String cCurrencyId, String istaxincluded, String adOrgId, String user2Id, String cChargeId, String docaction, String cBpartnerLocationId, String posted, String processed, String datepromised, String isdiscountprinted, String freightcostrule, String description, String user1Id, String chargeamt, String dateprinted, String isprinted, String totallines, String cCampaignId, String grandtotal, String isinvoiced, String cDoctypetargetId, String invoicerule, String dropshipBpartnerId, String deliveryviarule, String mPricelistId, String isactive, String cDoctypeId, String isselfservice, String adOrgtrxId, String billtoId, String docstatus, String cOrderId, String copyfrom, String updatedby, String updatedbyr, String deliveryrule, String priorityrule, String processing, String salesrepId, String freightamt, String mShipperId)    throws ServletException {
    PartnerOrdersData objectPartnerOrdersData[] = new PartnerOrdersData[1];
    objectPartnerOrdersData[0] = new PartnerOrdersData();
    objectPartnerOrdersData[0].created = "";
    objectPartnerOrdersData[0].createdbyr = createdbyr;
    objectPartnerOrdersData[0].updated = "";
    objectPartnerOrdersData[0].updatedTimeStamp = "";
    objectPartnerOrdersData[0].updatedby = updatedby;
    objectPartnerOrdersData[0].updatedbyr = updatedbyr;
    objectPartnerOrdersData[0].user1Id = user1Id;
    objectPartnerOrdersData[0].cBpartnerId = cBpartnerId;
    objectPartnerOrdersData[0].adUserId = adUserId;
    objectPartnerOrdersData[0].cProjectId = cProjectId;
    objectPartnerOrdersData[0].processing = processing;
    objectPartnerOrdersData[0].issotrx = issotrx;
    objectPartnerOrdersData[0].istaxincluded = istaxincluded;
    objectPartnerOrdersData[0].paymentrule = paymentrule;
    objectPartnerOrdersData[0].processed = processed;
    objectPartnerOrdersData[0].dropshipUserId = dropshipUserId;
    objectPartnerOrdersData[0].dropshipBpartnerId = dropshipBpartnerId;
    objectPartnerOrdersData[0].copyfrom = copyfrom;
    objectPartnerOrdersData[0].dropshipLocationId = dropshipLocationId;
    objectPartnerOrdersData[0].adOrgtrxId = adOrgtrxId;
    objectPartnerOrdersData[0].user2Id = user2Id;
    objectPartnerOrdersData[0].isdelivered = isdelivered;
    objectPartnerOrdersData[0].deliveryrule = deliveryrule;
    objectPartnerOrdersData[0].chargeamt = chargeamt;
    objectPartnerOrdersData[0].isdiscountprinted = isdiscountprinted;
    objectPartnerOrdersData[0].cActivityId = cActivityId;
    objectPartnerOrdersData[0].freightcostrule = freightcostrule;
    objectPartnerOrdersData[0].dateprinted = dateprinted;
    objectPartnerOrdersData[0].isactive = isactive;
    objectPartnerOrdersData[0].isselected = isselected;
    objectPartnerOrdersData[0].posted = posted;
    objectPartnerOrdersData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectPartnerOrdersData[0].dateacct = dateacct;
    objectPartnerOrdersData[0].cDoctypetargetId = cDoctypetargetId;
    objectPartnerOrdersData[0].datepromised = datepromised;
    objectPartnerOrdersData[0].cPaymenttermId = cPaymenttermId;
    objectPartnerOrdersData[0].freightamt = freightamt;
    objectPartnerOrdersData[0].mPricelistId = mPricelistId;
    objectPartnerOrdersData[0].isprinted = isprinted;
    objectPartnerOrdersData[0].isinvoiced = isinvoiced;
    objectPartnerOrdersData[0].invoicerule = invoicerule;
    objectPartnerOrdersData[0].docaction = docaction;
    objectPartnerOrdersData[0].mWarehouseId = mWarehouseId;
    objectPartnerOrdersData[0].totallines = totallines;
    objectPartnerOrdersData[0].poreference = poreference;
    objectPartnerOrdersData[0].cCampaignId = cCampaignId;
    objectPartnerOrdersData[0].deliveryviarule = deliveryviarule;
    objectPartnerOrdersData[0].mShipperId = mShipperId;
    objectPartnerOrdersData[0].billtoId = billtoId;
    objectPartnerOrdersData[0].cChargeId = cChargeId;
    objectPartnerOrdersData[0].priorityrule = priorityrule;
    objectPartnerOrdersData[0].adClientId = adClientId;
    objectPartnerOrdersData[0].adClientIdr = "";
    objectPartnerOrdersData[0].adOrgId = adOrgId;
    objectPartnerOrdersData[0].adOrgIdr = "";
    objectPartnerOrdersData[0].cDoctypeId = cDoctypeId;
    objectPartnerOrdersData[0].cDoctypeIdr = "";
    objectPartnerOrdersData[0].documentno = documentno;
    objectPartnerOrdersData[0].docstatus = docstatus;
    objectPartnerOrdersData[0].docstatusr = "";
    objectPartnerOrdersData[0].isselfservice = isselfservice;
    objectPartnerOrdersData[0].dateordered = dateordered;
    objectPartnerOrdersData[0].salesrepId = salesrepId;
    objectPartnerOrdersData[0].salesrepIdr = "";
    objectPartnerOrdersData[0].description = description;
    objectPartnerOrdersData[0].cCurrencyId = cCurrencyId;
    objectPartnerOrdersData[0].cCurrencyIdr = "";
    objectPartnerOrdersData[0].grandtotal = grandtotal;
    objectPartnerOrdersData[0].cOrderId = cOrderId;
    objectPartnerOrdersData[0].language = "";
    return objectPartnerOrdersData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2166_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef2168_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
      "        SELECT C_Order.C_BPartner_ID AS NAME" +
      "        FROM C_Order" +
      "        WHERE C_Order.C_Order_ID = ?";

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
      "        UPDATE C_Order" +
      "        SET User1_ID = (?) , C_BPartner_ID = (?) , AD_User_ID = (?) , C_Project_ID = (?) , Processing = (?) , IsSOTrx = (?) , IsTaxIncluded = (?) , PaymentRule = (?) , Processed = (?) , DropShip_User_ID = (?) , DropShip_BPartner_ID = (?) , CopyFrom = (?) , DropShip_Location_ID = (?) , AD_OrgTrx_ID = (?) , User2_ID = (?) , IsDelivered = (?) , DeliveryRule = (?) , ChargeAmt = TO_NUMBER(?) , IsDiscountPrinted = (?) , C_Activity_ID = (?) , FreightCostRule = (?) , DatePrinted = TO_DATE(?) , IsActive = (?) , IsSelected = (?) , Posted = (?) , C_BPartner_Location_ID = (?) , DateAcct = TO_DATE(?) , C_DocTypeTarget_ID = (?) , DatePromised = TO_DATE(?) , C_PaymentTerm_ID = (?) , FreightAmt = TO_NUMBER(?) , M_PriceList_ID = (?) , IsPrinted = (?) , IsInvoiced = (?) , InvoiceRule = (?) , DocAction = (?) , M_Warehouse_ID = (?) , TotalLines = TO_NUMBER(?) , POReference = (?) , C_Campaign_ID = (?) , DeliveryViaRule = (?) , M_Shipper_ID = (?) , BillTo_ID = (?) , C_Charge_ID = (?) , PriorityRule = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_DocType_ID = (?) , DocumentNo = (?) , DocStatus = (?) , IsSelfService = (?) , DateOrdered = TO_DATE(?) , SalesRep_ID = (?) , Description = (?) , C_Currency_ID = (?) , GrandTotal = TO_NUMBER(?) , C_Order_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Order.C_Order_ID = ? " +
      "                 AND C_Order.C_BPartner_ID = ? " +
      "        AND C_Order.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Order.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselected);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priorityrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselfservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
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
      "        INSERT INTO C_Order " +
      "        (User1_ID, C_BPartner_ID, AD_User_ID, C_Project_ID, Processing, IsSOTrx, IsTaxIncluded, PaymentRule, Processed, DropShip_User_ID, DropShip_BPartner_ID, CopyFrom, DropShip_Location_ID, AD_OrgTrx_ID, User2_ID, IsDelivered, DeliveryRule, ChargeAmt, IsDiscountPrinted, C_Activity_ID, FreightCostRule, DatePrinted, IsActive, IsSelected, Posted, C_BPartner_Location_ID, DateAcct, C_DocTypeTarget_ID, DatePromised, C_PaymentTerm_ID, FreightAmt, M_PriceList_ID, IsPrinted, IsInvoiced, InvoiceRule, DocAction, M_Warehouse_ID, TotalLines, POReference, C_Campaign_ID, DeliveryViaRule, M_Shipper_ID, BillTo_ID, C_Charge_ID, PriorityRule, AD_Client_ID, AD_Org_ID, C_DocType_ID, DocumentNo, DocStatus, IsSelfService, DateOrdered, SalesRep_ID, Description, C_Currency_ID, GrandTotal, C_Order_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), TO_DATE(?), (?), TO_DATE(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselected);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priorityrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselfservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
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
      "        DELETE FROM C_Order" +
      "        WHERE C_Order.C_Order_ID = ? " +
      "                 AND C_Order.C_BPartner_ID = ? " +
      "        AND C_Order.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Order.AD_Org_ID IN (";
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
      "        DELETE FROM C_Order" +
      "        WHERE C_Order.C_Order_ID = ? " +
      "                 AND C_Order.C_BPartner_ID = ? ";

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
      "          FROM C_Order" +
      "         WHERE C_Order.C_Order_ID = ? ";

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
      "          FROM C_Order" +
      "         WHERE C_Order.C_Order_ID = ? ";

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
