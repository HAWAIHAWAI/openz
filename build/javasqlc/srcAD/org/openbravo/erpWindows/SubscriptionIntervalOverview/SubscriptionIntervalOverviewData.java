//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.SubscriptionIntervalOverview;

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
class SubscriptionIntervalOverviewData implements FieldProvider {
static Logger log4j = Logger.getLogger(SubscriptionIntervalOverviewData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cSubscriptionintervalViewId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String documentno;
  public String poreference;
  public String dateordered;
  public String isactive;
  public String cDoctypetargetId;
  public String cDoctypetargetIdr;
  public String aAssetId;
  public String name;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String docstatus;
  public String docstatusr;
  public String description;
  public String deliverynotes;
  public String internalnote;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String bpzipcode;
  public String billtoId;
  public String billtoIdr;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String adUserId;
  public String adUserIdr;
  public String salesrepId;
  public String salesrepIdr;
  public String mPricelistId;
  public String mPricelistIdr;
  public String isdiscountprinted;
  public String invoicerule;
  public String invoiceruler;
  public String estpropability;
  public String estpropabilityr;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String deliveryrule;
  public String deliveryruler;
  public String priorityrule;
  public String priorityruler;
  public String paymentrule;
  public String paymentruler;
  public String cPaymenttermId;
  public String cPaymenttermIdr;
  public String cIncotermsId;
  public String cIncotermsIdr;
  public String deliveryLocationId;
  public String deliveryLocationIdr;
  public String deliveryviarule;
  public String deliveryviaruler;
  public String mShipperId;
  public String mShipperIdr;
  public String weight;
  public String weightUom;
  public String weightUomr;
  public String freightcostrule;
  public String freightcostruler;
  public String mProductId;
  public String mProductIdr;
  public String qty;
  public String freightamt;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String orderselfjoin;
  public String orderselfjoinr;
  public String firstschedinvoicedate;
  public String datepromised;
  public String scheddeliverydate;
  public String schedtransactiondate;
  public String transactiondate;
  public String contractdate;
  public String enddate;
  public String invoicefrequence;
  public String invoicefrequencer;
  public String isinvoiceafterfirstcycle;
  public String quarterlyMonth;
  public String quarterlyMonthr;
  public String yearlyMonth;
  public String yearlyMonthr;
  public String weeklyDay;
  public String weeklyDayr;
  public String monthlyDay;
  public String proposalstatus;
  public String proposalstatusr;
  public String lostproposalfixedreason;
  public String lostproposalfixedreasonr;
  public String lostproposalreason;
  public String totallinesonetime;
  public String grandtotalonetime;
  public String totallines;
  public String grandtotal;
  public String invoicedamt;
  public String totalpaid;
  public String completeordervalue;
  public String iscompletelyinvoiced;
  public String docaction;
  public String docactionBtn;
  public String generatetemplate;
  public String copyfrom;
  public String copyfrompo;
  public String generateproject;
  public String closeproject;
  public String cOrderId;
  public String issotrx;
  public String processing;
  public String processed;
  public String isdelivered;
  public String isinvoiced;
  public String isprinted;
  public String isselected;
  public String dateprinted;
  public String dateacct;
  public String cChargeId;
  public String chargeamt;
  public String istaxincluded;
  public String cCampaignId;
  public String cActivityId;
  public String posted;
  public String dropshipBpartnerId;
  public String dropshipLocationId;
  public String dropshipUserId;
  public String isselfservice;
  public String adOrgtrxId;
  public String user1Id;
  public String user2Id;
  public String incotermsdescription;
  public String cBidprojectId;
  public String cProjectphaseId;
  public String ispaid;
  public String isrecharge;
  public String btncopytemplate;
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
    else if (fieldName.equalsIgnoreCase("c_subscriptioninterval_view_id") || fieldName.equals("cSubscriptionintervalViewId"))
      return cSubscriptionintervalViewId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_id") || fieldName.equals("cDoctypetargetId"))
      return cDoctypetargetId;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_idr") || fieldName.equals("cDoctypetargetIdr"))
      return cDoctypetargetIdr;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("deliverynotes"))
      return deliverynotes;
    else if (fieldName.equalsIgnoreCase("internalnote"))
      return internalnote;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("bpzipcode"))
      return bpzipcode;
    else if (fieldName.equalsIgnoreCase("billto_id") || fieldName.equals("billtoId"))
      return billtoId;
    else if (fieldName.equalsIgnoreCase("billto_idr") || fieldName.equals("billtoIdr"))
      return billtoIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_idr") || fieldName.equals("mPricelistIdr"))
      return mPricelistIdr;
    else if (fieldName.equalsIgnoreCase("isdiscountprinted"))
      return isdiscountprinted;
    else if (fieldName.equalsIgnoreCase("invoicerule"))
      return invoicerule;
    else if (fieldName.equalsIgnoreCase("invoiceruler"))
      return invoiceruler;
    else if (fieldName.equalsIgnoreCase("estpropability"))
      return estpropability;
    else if (fieldName.equalsIgnoreCase("estpropabilityr"))
      return estpropabilityr;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("deliveryruler"))
      return deliveryruler;
    else if (fieldName.equalsIgnoreCase("priorityrule"))
      return priorityrule;
    else if (fieldName.equalsIgnoreCase("priorityruler"))
      return priorityruler;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("paymentruler"))
      return paymentruler;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_idr") || fieldName.equals("cPaymenttermIdr"))
      return cPaymenttermIdr;
    else if (fieldName.equalsIgnoreCase("c_incoterms_id") || fieldName.equals("cIncotermsId"))
      return cIncotermsId;
    else if (fieldName.equalsIgnoreCase("c_incoterms_idr") || fieldName.equals("cIncotermsIdr"))
      return cIncotermsIdr;
    else if (fieldName.equalsIgnoreCase("delivery_location_id") || fieldName.equals("deliveryLocationId"))
      return deliveryLocationId;
    else if (fieldName.equalsIgnoreCase("delivery_location_idr") || fieldName.equals("deliveryLocationIdr"))
      return deliveryLocationIdr;
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
    else if (fieldName.equalsIgnoreCase("deliveryviaruler"))
      return deliveryviaruler;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("m_shipper_idr") || fieldName.equals("mShipperIdr"))
      return mShipperIdr;
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
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("orderselfjoin"))
      return orderselfjoin;
    else if (fieldName.equalsIgnoreCase("orderselfjoinr"))
      return orderselfjoinr;
    else if (fieldName.equalsIgnoreCase("firstschedinvoicedate"))
      return firstschedinvoicedate;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("scheddeliverydate"))
      return scheddeliverydate;
    else if (fieldName.equalsIgnoreCase("schedtransactiondate"))
      return schedtransactiondate;
    else if (fieldName.equalsIgnoreCase("transactiondate"))
      return transactiondate;
    else if (fieldName.equalsIgnoreCase("contractdate"))
      return contractdate;
    else if (fieldName.equalsIgnoreCase("enddate"))
      return enddate;
    else if (fieldName.equalsIgnoreCase("invoicefrequence"))
      return invoicefrequence;
    else if (fieldName.equalsIgnoreCase("invoicefrequencer"))
      return invoicefrequencer;
    else if (fieldName.equalsIgnoreCase("isinvoiceafterfirstcycle"))
      return isinvoiceafterfirstcycle;
    else if (fieldName.equalsIgnoreCase("quarterly_month") || fieldName.equals("quarterlyMonth"))
      return quarterlyMonth;
    else if (fieldName.equalsIgnoreCase("quarterly_monthr") || fieldName.equals("quarterlyMonthr"))
      return quarterlyMonthr;
    else if (fieldName.equalsIgnoreCase("yearly_month") || fieldName.equals("yearlyMonth"))
      return yearlyMonth;
    else if (fieldName.equalsIgnoreCase("yearly_monthr") || fieldName.equals("yearlyMonthr"))
      return yearlyMonthr;
    else if (fieldName.equalsIgnoreCase("weekly_day") || fieldName.equals("weeklyDay"))
      return weeklyDay;
    else if (fieldName.equalsIgnoreCase("weekly_dayr") || fieldName.equals("weeklyDayr"))
      return weeklyDayr;
    else if (fieldName.equalsIgnoreCase("monthly_day") || fieldName.equals("monthlyDay"))
      return monthlyDay;
    else if (fieldName.equalsIgnoreCase("proposalstatus"))
      return proposalstatus;
    else if (fieldName.equalsIgnoreCase("proposalstatusr"))
      return proposalstatusr;
    else if (fieldName.equalsIgnoreCase("lostproposalfixedreason"))
      return lostproposalfixedreason;
    else if (fieldName.equalsIgnoreCase("lostproposalfixedreasonr"))
      return lostproposalfixedreasonr;
    else if (fieldName.equalsIgnoreCase("lostproposalreason"))
      return lostproposalreason;
    else if (fieldName.equalsIgnoreCase("totallinesonetime"))
      return totallinesonetime;
    else if (fieldName.equalsIgnoreCase("grandtotalonetime"))
      return grandtotalonetime;
    else if (fieldName.equalsIgnoreCase("totallines"))
      return totallines;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("invoicedamt"))
      return invoicedamt;
    else if (fieldName.equalsIgnoreCase("totalpaid"))
      return totalpaid;
    else if (fieldName.equalsIgnoreCase("completeordervalue"))
      return completeordervalue;
    else if (fieldName.equalsIgnoreCase("iscompletelyinvoiced"))
      return iscompletelyinvoiced;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("docaction_btn") || fieldName.equals("docactionBtn"))
      return docactionBtn;
    else if (fieldName.equalsIgnoreCase("generatetemplate"))
      return generatetemplate;
    else if (fieldName.equalsIgnoreCase("copyfrom"))
      return copyfrom;
    else if (fieldName.equalsIgnoreCase("copyfrompo"))
      return copyfrompo;
    else if (fieldName.equalsIgnoreCase("generateproject"))
      return generateproject;
    else if (fieldName.equalsIgnoreCase("closeproject"))
      return closeproject;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("isdelivered"))
      return isdelivered;
    else if (fieldName.equalsIgnoreCase("isinvoiced"))
      return isinvoiced;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("isselected"))
      return isselected;
    else if (fieldName.equalsIgnoreCase("dateprinted"))
      return dateprinted;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("istaxincluded"))
      return istaxincluded;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("dropship_bpartner_id") || fieldName.equals("dropshipBpartnerId"))
      return dropshipBpartnerId;
    else if (fieldName.equalsIgnoreCase("dropship_location_id") || fieldName.equals("dropshipLocationId"))
      return dropshipLocationId;
    else if (fieldName.equalsIgnoreCase("dropship_user_id") || fieldName.equals("dropshipUserId"))
      return dropshipUserId;
    else if (fieldName.equalsIgnoreCase("isselfservice"))
      return isselfservice;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("incotermsdescription"))
      return incotermsdescription;
    else if (fieldName.equalsIgnoreCase("c_bidproject_id") || fieldName.equals("cBidprojectId"))
      return cBidprojectId;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
    else if (fieldName.equalsIgnoreCase("ispaid"))
      return ispaid;
    else if (fieldName.equalsIgnoreCase("isrecharge"))
      return isrecharge;
    else if (fieldName.equalsIgnoreCase("btncopytemplate"))
      return btncopytemplate;
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
  public static SubscriptionIntervalOverviewData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static SubscriptionIntervalOverviewData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_subscriptioninterval_view.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_subscriptioninterval_view.CreatedBy) as CreatedByR, " +
      "        to_char(c_subscriptioninterval_view.Updated, ?) as updated, " +
      "        to_char(c_subscriptioninterval_view.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_subscriptioninterval_view.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_subscriptioninterval_view.UpdatedBy) as UpdatedByR," +
      "        c_subscriptioninterval_view.C_Subscriptioninterval_View_ID, " +
      "c_subscriptioninterval_view.AD_Client_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "c_subscriptioninterval_view.AD_Org_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "c_subscriptioninterval_view.Documentno, " +
      "c_subscriptioninterval_view.Poreference, " +
      "c_subscriptioninterval_view.Dateordered, " +
      "COALESCE(c_subscriptioninterval_view.Isactive, 'N') AS Isactive, " +
      "c_subscriptioninterval_view.C_Doctypetarget_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.C_Doctypetarget_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_Doctypetarget_IDR, " +
      "c_subscriptioninterval_view.A_Asset_ID, " +
      "c_subscriptioninterval_view.Name, " +
      "c_subscriptioninterval_view.C_Doctype_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.C_Doctype_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS C_Doctype_IDR, " +
      "c_subscriptioninterval_view.Docstatus, " +
      "(CASE WHEN c_subscriptioninterval_view.Docstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DocstatusR, " +
      "c_subscriptioninterval_view.Description, " +
      "c_subscriptioninterval_view.Deliverynotes, " +
      "c_subscriptioninterval_view.Internalnote, " +
      "c_subscriptioninterval_view.C_Bpartner_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "c_subscriptioninterval_view.bpzipcode, " +
      "c_subscriptioninterval_view.Billto_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.Billto_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS Billto_IDR, " +
      "c_subscriptioninterval_view.C_Bpartner_Location_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.C_Bpartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_Bpartner_Location_IDR, " +
      "c_subscriptioninterval_view.AD_User_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "c_subscriptioninterval_view.Salesrep_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.Salesrep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS Salesrep_IDR, " +
      "c_subscriptioninterval_view.M_Pricelist_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.M_Pricelist_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS M_Pricelist_IDR, " +
      "COALESCE(c_subscriptioninterval_view.Isdiscountprinted, 'N') AS Isdiscountprinted, " +
      "c_subscriptioninterval_view.Invoicerule, " +
      "(CASE WHEN c_subscriptioninterval_view.Invoicerule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS InvoiceruleR, " +
      "c_subscriptioninterval_view.Estpropability, " +
      "(CASE WHEN c_subscriptioninterval_view.Estpropability IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS EstpropabilityR, " +
      "c_subscriptioninterval_view.M_Warehouse_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.M_Warehouse_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "c_subscriptioninterval_view.C_Currency_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "c_subscriptioninterval_view.Deliveryrule, " +
      "(CASE WHEN c_subscriptioninterval_view.Deliveryrule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS DeliveryruleR, " +
      "c_subscriptioninterval_view.Priorityrule, " +
      "(CASE WHEN c_subscriptioninterval_view.Priorityrule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list5.name),'') ) END) AS PriorityruleR, " +
      "c_subscriptioninterval_view.Paymentrule, " +
      "(CASE WHEN c_subscriptioninterval_view.Paymentrule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list6.name),'') ) END) AS PaymentruleR, " +
      "c_subscriptioninterval_view.C_Paymentterm_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.C_Paymentterm_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL13.Name IS NULL THEN TO_CHAR(table13.Name) ELSE TO_CHAR(tableTRL13.Name) END)), ''))),'') ) END) AS C_Paymentterm_IDR, " +
      "c_subscriptioninterval_view.C_Incoterms_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.C_Incoterms_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Name), ''))),'') ) END) AS C_Incoterms_IDR, " +
      "c_subscriptioninterval_view.Delivery_Location_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.Delivery_Location_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Name), ''))),'') ) END) AS Delivery_Location_IDR, " +
      "c_subscriptioninterval_view.Deliveryviarule, " +
      "(CASE WHEN c_subscriptioninterval_view.Deliveryviarule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list7.name),'') ) END) AS DeliveryviaruleR, " +
      "c_subscriptioninterval_view.M_Shipper_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.M_Shipper_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Name), ''))),'') ) END) AS M_Shipper_IDR, " +
      "c_subscriptioninterval_view.Weight, " +
      "c_subscriptioninterval_view.Weight_Uom, " +
      "(CASE WHEN c_subscriptioninterval_view.Weight_Uom IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL17.Name IS NULL THEN TO_CHAR(table17.Name) ELSE TO_CHAR(tableTRL17.Name) END)), ''))),'') ) END) AS Weight_UomR, " +
      "c_subscriptioninterval_view.Freightcostrule, " +
      "(CASE WHEN c_subscriptioninterval_view.Freightcostrule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list8.name),'') ) END) AS FreightcostruleR, " +
      "c_subscriptioninterval_view.M_Product_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.M_Product_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL18.Name IS NULL THEN TO_CHAR(table18.Name) ELSE TO_CHAR(tableTRL18.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "c_subscriptioninterval_view.Qty, " +
      "c_subscriptioninterval_view.Freightamt, " +
      "c_subscriptioninterval_view.C_Project_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "c_subscriptioninterval_view.C_Projecttask_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table20.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table21.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table21.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "c_subscriptioninterval_view.Orderselfjoin, " +
      "(CASE WHEN c_subscriptioninterval_view.Orderselfjoin IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table22.DocumentNo), ''))),'') ) END) AS OrderselfjoinR, " +
      "c_subscriptioninterval_view.Firstschedinvoicedate, " +
      "c_subscriptioninterval_view.Datepromised, " +
      "c_subscriptioninterval_view.Scheddeliverydate, " +
      "c_subscriptioninterval_view.Schedtransactiondate, " +
      "c_subscriptioninterval_view.Transactiondate, " +
      "c_subscriptioninterval_view.Contractdate, " +
      "c_subscriptioninterval_view.Enddate, " +
      "c_subscriptioninterval_view.Invoicefrequence, " +
      "(CASE WHEN c_subscriptioninterval_view.Invoicefrequence IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list9.name),'') ) END) AS InvoicefrequenceR, " +
      "COALESCE(c_subscriptioninterval_view.Isinvoiceafterfirstcycle, 'N') AS Isinvoiceafterfirstcycle, " +
      "c_subscriptioninterval_view.Quarterly_Month, " +
      "(CASE WHEN c_subscriptioninterval_view.Quarterly_Month IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list10.name),'') ) END) AS Quarterly_MonthR, " +
      "c_subscriptioninterval_view.Yearly_Month, " +
      "(CASE WHEN c_subscriptioninterval_view.Yearly_Month IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list11.name),'') ) END) AS Yearly_MonthR, " +
      "c_subscriptioninterval_view.Weekly_Day, " +
      "(CASE WHEN c_subscriptioninterval_view.Weekly_Day IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list12.name),'') ) END) AS Weekly_DayR, " +
      "c_subscriptioninterval_view.Monthly_Day, " +
      "c_subscriptioninterval_view.Proposalstatus, " +
      "(CASE WHEN c_subscriptioninterval_view.Proposalstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list13.name),'') ) END) AS ProposalstatusR, " +
      "c_subscriptioninterval_view.Lostproposalfixedreason, " +
      "(CASE WHEN c_subscriptioninterval_view.Lostproposalfixedreason IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list14.name),'') ) END) AS LostproposalfixedreasonR, " +
      "c_subscriptioninterval_view.Lostproposalreason, " +
      "c_subscriptioninterval_view.Totallinesonetime, " +
      "c_subscriptioninterval_view.Grandtotalonetime, " +
      "c_subscriptioninterval_view.Totallines, " +
      "c_subscriptioninterval_view.Grandtotal, " +
      "c_subscriptioninterval_view.Invoicedamt, " +
      "c_subscriptioninterval_view.Totalpaid, " +
      "c_subscriptioninterval_view.Completeordervalue, " +
      "COALESCE(c_subscriptioninterval_view.Iscompletelyinvoiced, 'N') AS Iscompletelyinvoiced, " +
      "c_subscriptioninterval_view.DocAction, " +
      "list15.name as DocAction_BTN, " +
      "c_subscriptioninterval_view.Generatetemplate, " +
      "c_subscriptioninterval_view.Copyfrom, " +
      "c_subscriptioninterval_view.Copyfrompo, " +
      "c_subscriptioninterval_view.Generateproject, " +
      "c_subscriptioninterval_view.Closeproject, " +
      "c_subscriptioninterval_view.C_Order_ID, " +
      "COALESCE(c_subscriptioninterval_view.Issotrx, 'N') AS Issotrx, " +
      "c_subscriptioninterval_view.Processing, " +
      "COALESCE(c_subscriptioninterval_view.Processed, 'N') AS Processed, " +
      "COALESCE(c_subscriptioninterval_view.Isdelivered, 'N') AS Isdelivered, " +
      "COALESCE(c_subscriptioninterval_view.Isinvoiced, 'N') AS Isinvoiced, " +
      "COALESCE(c_subscriptioninterval_view.Isprinted, 'N') AS Isprinted, " +
      "COALESCE(c_subscriptioninterval_view.Isselected, 'N') AS Isselected, " +
      "c_subscriptioninterval_view.Dateprinted, " +
      "c_subscriptioninterval_view.Dateacct, " +
      "c_subscriptioninterval_view.C_Charge_ID, " +
      "c_subscriptioninterval_view.Chargeamt, " +
      "COALESCE(c_subscriptioninterval_view.Istaxincluded, 'N') AS Istaxincluded, " +
      "c_subscriptioninterval_view.C_Campaign_ID, " +
      "c_subscriptioninterval_view.C_Activity_ID, " +
      "c_subscriptioninterval_view.Posted, " +
      "c_subscriptioninterval_view.Dropship_Bpartner_ID, " +
      "c_subscriptioninterval_view.Dropship_Location_ID, " +
      "c_subscriptioninterval_view.Dropship_User_ID, " +
      "COALESCE(c_subscriptioninterval_view.Isselfservice, 'N') AS Isselfservice, " +
      "c_subscriptioninterval_view.AD_Orgtrx_ID, " +
      "c_subscriptioninterval_view.User1_ID, " +
      "c_subscriptioninterval_view.User2_ID, " +
      "c_subscriptioninterval_view.Incotermsdescription, " +
      "c_subscriptioninterval_view.C_Bidproject_ID, " +
      "c_subscriptioninterval_view.C_Projectphase_ID, " +
      "COALESCE(c_subscriptioninterval_view.Ispaid, 'N') AS Ispaid, " +
      "COALESCE(c_subscriptioninterval_view.Isrecharge, 'N') AS Isrecharge, " +
      "COALESCE(c_subscriptioninterval_view.btncopytemplate, 'N') AS btncopytemplate, " +
      "        ? AS LANGUAGE " +
      "        FROM c_subscriptioninterval_view left join (select AD_Client_ID, Name from AD_Client) table1 on (c_subscriptioninterval_view.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (c_subscriptioninterval_view.AD_Org_ID = table2.AD_Org_ID) left join (select C_DocType_ID, Name from C_DocType) table3 on (c_subscriptioninterval_view.C_Doctypetarget_ID =  table3.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL3 on (table3.C_DocType_ID = tableTRL3.C_DocType_ID and tableTRL3.AD_Language = ?)  left join (select C_Doctype_ID, Name from C_Doctype) table4 on (c_subscriptioninterval_view.C_Doctype_ID = table4.C_Doctype_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL4 on (table4.C_DocType_ID = tableTRL4.C_DocType_ID and tableTRL4.AD_Language = ?)  left join ad_ref_list_v list1 on (c_subscriptioninterval_view.Docstatus = list1.value and list1.ad_reference_id = '131' and list1.ad_language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table5 on (c_subscriptioninterval_view.C_Bpartner_ID = table5.C_BPartner_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table6 on (c_subscriptioninterval_view.Billto_ID =  table6.C_BPartner_Location_ID) left join (select C_Bpartner_Location_ID, Name from C_Bpartner_Location) table7 on (c_subscriptioninterval_view.C_Bpartner_Location_ID = table7.C_Bpartner_Location_ID) left join (select AD_User_ID, Name from AD_User) table8 on (c_subscriptioninterval_view.AD_User_ID = table8.AD_User_ID) left join (select AD_User_ID, Name from AD_User) table9 on (c_subscriptioninterval_view.Salesrep_ID =  table9.AD_User_ID) left join (select M_Pricelist_ID, Name from M_Pricelist) table10 on (c_subscriptioninterval_view.M_Pricelist_ID = table10.M_Pricelist_ID) left join ad_ref_list_v list2 on (c_subscriptioninterval_view.Invoicerule = list2.value and list2.ad_reference_id = '150' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (c_subscriptioninterval_view.Estpropability = list3.value and list3.ad_reference_id = 'DD6AA16AB1DD4DF5AD11A2665AE665BC' and list3.ad_language = ?)  left join (select M_Warehouse_ID, Name from M_Warehouse) table11 on (c_subscriptioninterval_view.M_Warehouse_ID =  table11.M_Warehouse_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table12 on (c_subscriptioninterval_view.C_Currency_ID = table12.C_Currency_ID) left join ad_ref_list_v list4 on (c_subscriptioninterval_view.Deliveryrule = list4.value and list4.ad_reference_id = '151' and list4.ad_language = ?)  left join ad_ref_list_v list5 on (c_subscriptioninterval_view.Priorityrule = list5.value and list5.ad_reference_id = '154' and list5.ad_language = ?)  left join ad_ref_list_v list6 on (c_subscriptioninterval_view.Paymentrule = list6.value and list6.ad_reference_id = '195' and list6.ad_language = ?)  left join (select C_Paymentterm_ID, Name from C_Paymentterm) table13 on (c_subscriptioninterval_view.C_Paymentterm_ID = table13.C_Paymentterm_ID) left join (select C_PaymentTerm_ID,AD_Language, Name from C_PaymentTerm_TRL) tableTRL13 on (table13.C_PaymentTerm_ID = tableTRL13.C_PaymentTerm_ID and tableTRL13.AD_Language = ?)  left join (select C_Incoterms_ID, Name from C_Incoterms) table14 on (c_subscriptioninterval_view.C_Incoterms_ID = table14.C_Incoterms_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table15 on (c_subscriptioninterval_view.Delivery_Location_ID =  table15.C_BPartner_Location_ID) left join ad_ref_list_v list7 on (c_subscriptioninterval_view.Deliveryviarule = list7.value and list7.ad_reference_id = '152' and list7.ad_language = ?)  left join (select M_Shipper_ID, Name from M_Shipper) table16 on (c_subscriptioninterval_view.M_Shipper_ID = table16.M_Shipper_ID) left join (select C_UOM_ID, Name from C_UOM) table17 on (c_subscriptioninterval_view.Weight_Uom =  table17.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL17 on (table17.C_UOM_ID = tableTRL17.C_UOM_ID and tableTRL17.AD_Language = ?)  left join ad_ref_list_v list8 on (c_subscriptioninterval_view.Freightcostrule = list8.value and list8.ad_reference_id = '153' and list8.ad_language = ?)  left join (select M_Product_ID, value, Name from M_Product) table18 on (c_subscriptioninterval_view.M_Product_ID =  table18.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL18 on (table18.M_Product_ID = tableTRL18.M_Product_ID and tableTRL18.AD_Language = ?)  left join (select C_Project_ID, Value, Name from C_Project) table19 on (c_subscriptioninterval_view.C_Project_ID = table19.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table20 on (c_subscriptioninterval_view.C_Projecttask_ID = table20.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table21 on (table20.C_Project_ID = table21.C_Project_ID) left join (select C_Order_ID, DocumentNo from C_Order) table22 on (c_subscriptioninterval_view.Orderselfjoin =  table22.C_Order_ID) left join ad_ref_list_v list9 on (c_subscriptioninterval_view.Invoicefrequence = list9.value and list9.ad_reference_id = 'F17BFE71276743BBB6105EE61D9FD666' and list9.ad_language = ?)  left join ad_ref_list_v list10 on (c_subscriptioninterval_view.Quarterly_Month = list10.value and list10.ad_reference_id = '99780AA6C1644A329162A8AF74602925' and list10.ad_language = ?)  left join ad_ref_list_v list11 on (c_subscriptioninterval_view.Yearly_Month = list11.value and list11.ad_reference_id = 'B849337BE90242BEB0B230808EDC0CEE' and list11.ad_language = ?)  left join ad_ref_list_v list12 on (c_subscriptioninterval_view.Weekly_Day = list12.value and list12.ad_reference_id = '167' and list12.ad_language = ?)  left join ad_ref_list_v list13 on (c_subscriptioninterval_view.Proposalstatus = list13.value and list13.ad_reference_id = 'B00D78B6B154404A831F25F11ABD867E' and list13.ad_language = ?)  left join ad_ref_list_v list14 on (c_subscriptioninterval_view.Lostproposalfixedreason = list14.value and list14.ad_reference_id = 'B51F770E9FA84F5B8FC0FFD7B3848317' and list14.ad_language = ?)  left join ad_ref_list_v list15 on (list15.ad_reference_id = '135' and list15.ad_language = ?  AND (CASE c_subscriptioninterval_view.DocAction WHEN '--' THEN 'CL' ELSE TO_CHAR(c_subscriptioninterval_view.DocAction) END) = list15.value)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = ? " +
      "        AND c_subscriptioninterval_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_subscriptioninterval_view.AD_Org_ID IN (";
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
        SubscriptionIntervalOverviewData objectSubscriptionIntervalOverviewData = new SubscriptionIntervalOverviewData();
        objectSubscriptionIntervalOverviewData.created = UtilSql.getValue(result, "created");
        objectSubscriptionIntervalOverviewData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSubscriptionIntervalOverviewData.updated = UtilSql.getValue(result, "updated");
        objectSubscriptionIntervalOverviewData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSubscriptionIntervalOverviewData.updatedby = UtilSql.getValue(result, "updatedby");
        objectSubscriptionIntervalOverviewData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSubscriptionIntervalOverviewData.cSubscriptionintervalViewId = UtilSql.getValue(result, "c_subscriptioninterval_view_id");
        objectSubscriptionIntervalOverviewData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSubscriptionIntervalOverviewData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectSubscriptionIntervalOverviewData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSubscriptionIntervalOverviewData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectSubscriptionIntervalOverviewData.documentno = UtilSql.getValue(result, "documentno");
        objectSubscriptionIntervalOverviewData.poreference = UtilSql.getValue(result, "poreference");
        objectSubscriptionIntervalOverviewData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectSubscriptionIntervalOverviewData.isactive = UtilSql.getValue(result, "isactive");
        objectSubscriptionIntervalOverviewData.cDoctypetargetId = UtilSql.getValue(result, "c_doctypetarget_id");
        objectSubscriptionIntervalOverviewData.cDoctypetargetIdr = UtilSql.getValue(result, "c_doctypetarget_idr");
        objectSubscriptionIntervalOverviewData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectSubscriptionIntervalOverviewData.name = UtilSql.getValue(result, "name");
        objectSubscriptionIntervalOverviewData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectSubscriptionIntervalOverviewData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectSubscriptionIntervalOverviewData.docstatus = UtilSql.getValue(result, "docstatus");
        objectSubscriptionIntervalOverviewData.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectSubscriptionIntervalOverviewData.description = UtilSql.getValue(result, "description");
        objectSubscriptionIntervalOverviewData.deliverynotes = UtilSql.getValue(result, "deliverynotes");
        objectSubscriptionIntervalOverviewData.internalnote = UtilSql.getValue(result, "internalnote");
        objectSubscriptionIntervalOverviewData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectSubscriptionIntervalOverviewData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectSubscriptionIntervalOverviewData.bpzipcode = UtilSql.getValue(result, "bpzipcode");
        objectSubscriptionIntervalOverviewData.billtoId = UtilSql.getValue(result, "billto_id");
        objectSubscriptionIntervalOverviewData.billtoIdr = UtilSql.getValue(result, "billto_idr");
        objectSubscriptionIntervalOverviewData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectSubscriptionIntervalOverviewData.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectSubscriptionIntervalOverviewData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectSubscriptionIntervalOverviewData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectSubscriptionIntervalOverviewData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectSubscriptionIntervalOverviewData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectSubscriptionIntervalOverviewData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectSubscriptionIntervalOverviewData.mPricelistIdr = UtilSql.getValue(result, "m_pricelist_idr");
        objectSubscriptionIntervalOverviewData.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectSubscriptionIntervalOverviewData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectSubscriptionIntervalOverviewData.invoiceruler = UtilSql.getValue(result, "invoiceruler");
        objectSubscriptionIntervalOverviewData.estpropability = UtilSql.getValue(result, "estpropability");
        objectSubscriptionIntervalOverviewData.estpropabilityr = UtilSql.getValue(result, "estpropabilityr");
        objectSubscriptionIntervalOverviewData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectSubscriptionIntervalOverviewData.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectSubscriptionIntervalOverviewData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectSubscriptionIntervalOverviewData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectSubscriptionIntervalOverviewData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectSubscriptionIntervalOverviewData.deliveryruler = UtilSql.getValue(result, "deliveryruler");
        objectSubscriptionIntervalOverviewData.priorityrule = UtilSql.getValue(result, "priorityrule");
        objectSubscriptionIntervalOverviewData.priorityruler = UtilSql.getValue(result, "priorityruler");
        objectSubscriptionIntervalOverviewData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectSubscriptionIntervalOverviewData.paymentruler = UtilSql.getValue(result, "paymentruler");
        objectSubscriptionIntervalOverviewData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectSubscriptionIntervalOverviewData.cPaymenttermIdr = UtilSql.getValue(result, "c_paymentterm_idr");
        objectSubscriptionIntervalOverviewData.cIncotermsId = UtilSql.getValue(result, "c_incoterms_id");
        objectSubscriptionIntervalOverviewData.cIncotermsIdr = UtilSql.getValue(result, "c_incoterms_idr");
        objectSubscriptionIntervalOverviewData.deliveryLocationId = UtilSql.getValue(result, "delivery_location_id");
        objectSubscriptionIntervalOverviewData.deliveryLocationIdr = UtilSql.getValue(result, "delivery_location_idr");
        objectSubscriptionIntervalOverviewData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectSubscriptionIntervalOverviewData.deliveryviaruler = UtilSql.getValue(result, "deliveryviaruler");
        objectSubscriptionIntervalOverviewData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectSubscriptionIntervalOverviewData.mShipperIdr = UtilSql.getValue(result, "m_shipper_idr");
        objectSubscriptionIntervalOverviewData.weight = UtilSql.getValue(result, "weight");
        objectSubscriptionIntervalOverviewData.weightUom = UtilSql.getValue(result, "weight_uom");
        objectSubscriptionIntervalOverviewData.weightUomr = UtilSql.getValue(result, "weight_uomr");
        objectSubscriptionIntervalOverviewData.freightcostrule = UtilSql.getValue(result, "freightcostrule");
        objectSubscriptionIntervalOverviewData.freightcostruler = UtilSql.getValue(result, "freightcostruler");
        objectSubscriptionIntervalOverviewData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectSubscriptionIntervalOverviewData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectSubscriptionIntervalOverviewData.qty = UtilSql.getValue(result, "qty");
        objectSubscriptionIntervalOverviewData.freightamt = UtilSql.getValue(result, "freightamt");
        objectSubscriptionIntervalOverviewData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectSubscriptionIntervalOverviewData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectSubscriptionIntervalOverviewData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectSubscriptionIntervalOverviewData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectSubscriptionIntervalOverviewData.orderselfjoin = UtilSql.getValue(result, "orderselfjoin");
        objectSubscriptionIntervalOverviewData.orderselfjoinr = UtilSql.getValue(result, "orderselfjoinr");
        objectSubscriptionIntervalOverviewData.firstschedinvoicedate = UtilSql.getDateValue(result, "firstschedinvoicedate", "dd-MM-yyyy");
        objectSubscriptionIntervalOverviewData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectSubscriptionIntervalOverviewData.scheddeliverydate = UtilSql.getDateValue(result, "scheddeliverydate", "dd-MM-yyyy");
        objectSubscriptionIntervalOverviewData.schedtransactiondate = UtilSql.getDateValue(result, "schedtransactiondate", "dd-MM-yyyy");
        objectSubscriptionIntervalOverviewData.transactiondate = UtilSql.getDateValue(result, "transactiondate", "dd-MM-yyyy");
        objectSubscriptionIntervalOverviewData.contractdate = UtilSql.getDateValue(result, "contractdate", "dd-MM-yyyy");
        objectSubscriptionIntervalOverviewData.enddate = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
        objectSubscriptionIntervalOverviewData.invoicefrequence = UtilSql.getValue(result, "invoicefrequence");
        objectSubscriptionIntervalOverviewData.invoicefrequencer = UtilSql.getValue(result, "invoicefrequencer");
        objectSubscriptionIntervalOverviewData.isinvoiceafterfirstcycle = UtilSql.getValue(result, "isinvoiceafterfirstcycle");
        objectSubscriptionIntervalOverviewData.quarterlyMonth = UtilSql.getValue(result, "quarterly_month");
        objectSubscriptionIntervalOverviewData.quarterlyMonthr = UtilSql.getValue(result, "quarterly_monthr");
        objectSubscriptionIntervalOverviewData.yearlyMonth = UtilSql.getValue(result, "yearly_month");
        objectSubscriptionIntervalOverviewData.yearlyMonthr = UtilSql.getValue(result, "yearly_monthr");
        objectSubscriptionIntervalOverviewData.weeklyDay = UtilSql.getValue(result, "weekly_day");
        objectSubscriptionIntervalOverviewData.weeklyDayr = UtilSql.getValue(result, "weekly_dayr");
        objectSubscriptionIntervalOverviewData.monthlyDay = UtilSql.getValue(result, "monthly_day");
        objectSubscriptionIntervalOverviewData.proposalstatus = UtilSql.getValue(result, "proposalstatus");
        objectSubscriptionIntervalOverviewData.proposalstatusr = UtilSql.getValue(result, "proposalstatusr");
        objectSubscriptionIntervalOverviewData.lostproposalfixedreason = UtilSql.getValue(result, "lostproposalfixedreason");
        objectSubscriptionIntervalOverviewData.lostproposalfixedreasonr = UtilSql.getValue(result, "lostproposalfixedreasonr");
        objectSubscriptionIntervalOverviewData.lostproposalreason = UtilSql.getValue(result, "lostproposalreason");
        objectSubscriptionIntervalOverviewData.totallinesonetime = UtilSql.getValue(result, "totallinesonetime");
        objectSubscriptionIntervalOverviewData.grandtotalonetime = UtilSql.getValue(result, "grandtotalonetime");
        objectSubscriptionIntervalOverviewData.totallines = UtilSql.getValue(result, "totallines");
        objectSubscriptionIntervalOverviewData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectSubscriptionIntervalOverviewData.invoicedamt = UtilSql.getValue(result, "invoicedamt");
        objectSubscriptionIntervalOverviewData.totalpaid = UtilSql.getValue(result, "totalpaid");
        objectSubscriptionIntervalOverviewData.completeordervalue = UtilSql.getValue(result, "completeordervalue");
        objectSubscriptionIntervalOverviewData.iscompletelyinvoiced = UtilSql.getValue(result, "iscompletelyinvoiced");
        objectSubscriptionIntervalOverviewData.docaction = UtilSql.getValue(result, "docaction");
        objectSubscriptionIntervalOverviewData.docactionBtn = UtilSql.getValue(result, "docaction_btn");
        objectSubscriptionIntervalOverviewData.generatetemplate = UtilSql.getValue(result, "generatetemplate");
        objectSubscriptionIntervalOverviewData.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectSubscriptionIntervalOverviewData.copyfrompo = UtilSql.getValue(result, "copyfrompo");
        objectSubscriptionIntervalOverviewData.generateproject = UtilSql.getValue(result, "generateproject");
        objectSubscriptionIntervalOverviewData.closeproject = UtilSql.getValue(result, "closeproject");
        objectSubscriptionIntervalOverviewData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectSubscriptionIntervalOverviewData.issotrx = UtilSql.getValue(result, "issotrx");
        objectSubscriptionIntervalOverviewData.processing = UtilSql.getValue(result, "processing");
        objectSubscriptionIntervalOverviewData.processed = UtilSql.getValue(result, "processed");
        objectSubscriptionIntervalOverviewData.isdelivered = UtilSql.getValue(result, "isdelivered");
        objectSubscriptionIntervalOverviewData.isinvoiced = UtilSql.getValue(result, "isinvoiced");
        objectSubscriptionIntervalOverviewData.isprinted = UtilSql.getValue(result, "isprinted");
        objectSubscriptionIntervalOverviewData.isselected = UtilSql.getValue(result, "isselected");
        objectSubscriptionIntervalOverviewData.dateprinted = UtilSql.getDateValue(result, "dateprinted", "dd-MM-yyyy");
        objectSubscriptionIntervalOverviewData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectSubscriptionIntervalOverviewData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectSubscriptionIntervalOverviewData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectSubscriptionIntervalOverviewData.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectSubscriptionIntervalOverviewData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectSubscriptionIntervalOverviewData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectSubscriptionIntervalOverviewData.posted = UtilSql.getValue(result, "posted");
        objectSubscriptionIntervalOverviewData.dropshipBpartnerId = UtilSql.getValue(result, "dropship_bpartner_id");
        objectSubscriptionIntervalOverviewData.dropshipLocationId = UtilSql.getValue(result, "dropship_location_id");
        objectSubscriptionIntervalOverviewData.dropshipUserId = UtilSql.getValue(result, "dropship_user_id");
        objectSubscriptionIntervalOverviewData.isselfservice = UtilSql.getValue(result, "isselfservice");
        objectSubscriptionIntervalOverviewData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectSubscriptionIntervalOverviewData.user1Id = UtilSql.getValue(result, "user1_id");
        objectSubscriptionIntervalOverviewData.user2Id = UtilSql.getValue(result, "user2_id");
        objectSubscriptionIntervalOverviewData.incotermsdescription = UtilSql.getValue(result, "incotermsdescription");
        objectSubscriptionIntervalOverviewData.cBidprojectId = UtilSql.getValue(result, "c_bidproject_id");
        objectSubscriptionIntervalOverviewData.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectSubscriptionIntervalOverviewData.ispaid = UtilSql.getValue(result, "ispaid");
        objectSubscriptionIntervalOverviewData.isrecharge = UtilSql.getValue(result, "isrecharge");
        objectSubscriptionIntervalOverviewData.btncopytemplate = UtilSql.getValue(result, "btncopytemplate");
        objectSubscriptionIntervalOverviewData.language = UtilSql.getValue(result, "language");
        objectSubscriptionIntervalOverviewData.adUserClient = "";
        objectSubscriptionIntervalOverviewData.adOrgClient = "";
        objectSubscriptionIntervalOverviewData.createdby = "";
        objectSubscriptionIntervalOverviewData.trBgcolor = "";
        objectSubscriptionIntervalOverviewData.totalCount = "";
        objectSubscriptionIntervalOverviewData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSubscriptionIntervalOverviewData);
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
    SubscriptionIntervalOverviewData objectSubscriptionIntervalOverviewData[] = new SubscriptionIntervalOverviewData[vector.size()];
    vector.copyInto(objectSubscriptionIntervalOverviewData);
    return(objectSubscriptionIntervalOverviewData);
  }

/**
Create a registry
 */
  public static SubscriptionIntervalOverviewData[] set(String lostproposalreason, String poreference, String freightamt, String transactiondate, String cBpartnerLocationId, String description, String isinvoiced, String processed, String totallines, String totalpaid, String chargeamt, String deliveryLocationId, String dateacct, String completeordervalue, String generatetemplate, String cCampaignId, String isselected, String weeklyDay, String mPricelistId, String freightcostrule, String adOrgtrxId, String cProjectId, String cProjectIdr, String istaxincluded, String ispaid, String issotrx, String internalnote, String btncopytemplate, String docaction, String docactionBtn, String isinvoiceafterfirstcycle, String grandtotalonetime, String dateordered, String isactive, String name, String mShipperId, String bpzipcode, String invoicefrequence, String cChargeId, String invoicerule, String user1Id, String weightUom, String dropshipBpartnerId, String schedtransactiondate, String cSubscriptionintervalViewId, String mWarehouseId, String quarterlyMonth, String qty, String processing, String closeproject, String aAssetId, String isdiscountprinted, String createdby, String createdbyr, String dropshipLocationId, String cIncotermsId, String paymentrule, String user2Id, String priorityrule, String enddate, String salesrepId, String updatedby, String updatedbyr, String cActivityId, String cDoctypeId, String firstschedinvoicedate, String cProjectphaseId, String datepromised, String cOrderId, String cDoctypetargetId, String iscompletelyinvoiced, String cPaymenttermId, String lostproposalfixedreason, String cProjecttaskId, String dateprinted, String cCurrencyId, String contractdate, String docstatus, String copyfrompo, String totallinesonetime, String posted, String adClientId, String mProductId, String deliveryrule, String cBpartnerId, String cBpartnerIdr, String monthlyDay, String proposalstatus, String generateproject, String deliveryviarule, String documentno, String isselfservice, String isdelivered, String isrecharge, String billtoId, String cBidprojectId, String yearlyMonth, String deliverynotes, String weight, String scheddeliverydate, String incotermsdescription, String adUserId, String grandtotal, String isprinted, String invoicedamt, String orderselfjoin, String estpropability, String adOrgId, String dropshipUserId, String copyfrom)    throws ServletException {
    SubscriptionIntervalOverviewData objectSubscriptionIntervalOverviewData[] = new SubscriptionIntervalOverviewData[1];
    objectSubscriptionIntervalOverviewData[0] = new SubscriptionIntervalOverviewData();
    objectSubscriptionIntervalOverviewData[0].created = "";
    objectSubscriptionIntervalOverviewData[0].createdbyr = createdbyr;
    objectSubscriptionIntervalOverviewData[0].updated = "";
    objectSubscriptionIntervalOverviewData[0].updatedTimeStamp = "";
    objectSubscriptionIntervalOverviewData[0].updatedby = updatedby;
    objectSubscriptionIntervalOverviewData[0].updatedbyr = updatedbyr;
    objectSubscriptionIntervalOverviewData[0].cSubscriptionintervalViewId = cSubscriptionintervalViewId;
    objectSubscriptionIntervalOverviewData[0].adClientId = adClientId;
    objectSubscriptionIntervalOverviewData[0].adClientIdr = "";
    objectSubscriptionIntervalOverviewData[0].adOrgId = adOrgId;
    objectSubscriptionIntervalOverviewData[0].adOrgIdr = "";
    objectSubscriptionIntervalOverviewData[0].documentno = documentno;
    objectSubscriptionIntervalOverviewData[0].poreference = poreference;
    objectSubscriptionIntervalOverviewData[0].dateordered = dateordered;
    objectSubscriptionIntervalOverviewData[0].isactive = isactive;
    objectSubscriptionIntervalOverviewData[0].cDoctypetargetId = cDoctypetargetId;
    objectSubscriptionIntervalOverviewData[0].cDoctypetargetIdr = "";
    objectSubscriptionIntervalOverviewData[0].aAssetId = aAssetId;
    objectSubscriptionIntervalOverviewData[0].name = name;
    objectSubscriptionIntervalOverviewData[0].cDoctypeId = cDoctypeId;
    objectSubscriptionIntervalOverviewData[0].cDoctypeIdr = "";
    objectSubscriptionIntervalOverviewData[0].docstatus = docstatus;
    objectSubscriptionIntervalOverviewData[0].docstatusr = "";
    objectSubscriptionIntervalOverviewData[0].description = description;
    objectSubscriptionIntervalOverviewData[0].deliverynotes = deliverynotes;
    objectSubscriptionIntervalOverviewData[0].internalnote = internalnote;
    objectSubscriptionIntervalOverviewData[0].cBpartnerId = cBpartnerId;
    objectSubscriptionIntervalOverviewData[0].cBpartnerIdr = cBpartnerIdr;
    objectSubscriptionIntervalOverviewData[0].bpzipcode = bpzipcode;
    objectSubscriptionIntervalOverviewData[0].billtoId = billtoId;
    objectSubscriptionIntervalOverviewData[0].billtoIdr = "";
    objectSubscriptionIntervalOverviewData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectSubscriptionIntervalOverviewData[0].cBpartnerLocationIdr = "";
    objectSubscriptionIntervalOverviewData[0].adUserId = adUserId;
    objectSubscriptionIntervalOverviewData[0].adUserIdr = "";
    objectSubscriptionIntervalOverviewData[0].salesrepId = salesrepId;
    objectSubscriptionIntervalOverviewData[0].salesrepIdr = "";
    objectSubscriptionIntervalOverviewData[0].mPricelistId = mPricelistId;
    objectSubscriptionIntervalOverviewData[0].mPricelistIdr = "";
    objectSubscriptionIntervalOverviewData[0].isdiscountprinted = isdiscountprinted;
    objectSubscriptionIntervalOverviewData[0].invoicerule = invoicerule;
    objectSubscriptionIntervalOverviewData[0].invoiceruler = "";
    objectSubscriptionIntervalOverviewData[0].estpropability = estpropability;
    objectSubscriptionIntervalOverviewData[0].estpropabilityr = "";
    objectSubscriptionIntervalOverviewData[0].mWarehouseId = mWarehouseId;
    objectSubscriptionIntervalOverviewData[0].mWarehouseIdr = "";
    objectSubscriptionIntervalOverviewData[0].cCurrencyId = cCurrencyId;
    objectSubscriptionIntervalOverviewData[0].cCurrencyIdr = "";
    objectSubscriptionIntervalOverviewData[0].deliveryrule = deliveryrule;
    objectSubscriptionIntervalOverviewData[0].deliveryruler = "";
    objectSubscriptionIntervalOverviewData[0].priorityrule = priorityrule;
    objectSubscriptionIntervalOverviewData[0].priorityruler = "";
    objectSubscriptionIntervalOverviewData[0].paymentrule = paymentrule;
    objectSubscriptionIntervalOverviewData[0].paymentruler = "";
    objectSubscriptionIntervalOverviewData[0].cPaymenttermId = cPaymenttermId;
    objectSubscriptionIntervalOverviewData[0].cPaymenttermIdr = "";
    objectSubscriptionIntervalOverviewData[0].cIncotermsId = cIncotermsId;
    objectSubscriptionIntervalOverviewData[0].cIncotermsIdr = "";
    objectSubscriptionIntervalOverviewData[0].deliveryLocationId = deliveryLocationId;
    objectSubscriptionIntervalOverviewData[0].deliveryLocationIdr = "";
    objectSubscriptionIntervalOverviewData[0].deliveryviarule = deliveryviarule;
    objectSubscriptionIntervalOverviewData[0].deliveryviaruler = "";
    objectSubscriptionIntervalOverviewData[0].mShipperId = mShipperId;
    objectSubscriptionIntervalOverviewData[0].mShipperIdr = "";
    objectSubscriptionIntervalOverviewData[0].weight = weight;
    objectSubscriptionIntervalOverviewData[0].weightUom = weightUom;
    objectSubscriptionIntervalOverviewData[0].weightUomr = "";
    objectSubscriptionIntervalOverviewData[0].freightcostrule = freightcostrule;
    objectSubscriptionIntervalOverviewData[0].freightcostruler = "";
    objectSubscriptionIntervalOverviewData[0].mProductId = mProductId;
    objectSubscriptionIntervalOverviewData[0].mProductIdr = "";
    objectSubscriptionIntervalOverviewData[0].qty = qty;
    objectSubscriptionIntervalOverviewData[0].freightamt = freightamt;
    objectSubscriptionIntervalOverviewData[0].cProjectId = cProjectId;
    objectSubscriptionIntervalOverviewData[0].cProjectIdr = cProjectIdr;
    objectSubscriptionIntervalOverviewData[0].cProjecttaskId = cProjecttaskId;
    objectSubscriptionIntervalOverviewData[0].cProjecttaskIdr = "";
    objectSubscriptionIntervalOverviewData[0].orderselfjoin = orderselfjoin;
    objectSubscriptionIntervalOverviewData[0].orderselfjoinr = "";
    objectSubscriptionIntervalOverviewData[0].firstschedinvoicedate = firstschedinvoicedate;
    objectSubscriptionIntervalOverviewData[0].datepromised = datepromised;
    objectSubscriptionIntervalOverviewData[0].scheddeliverydate = scheddeliverydate;
    objectSubscriptionIntervalOverviewData[0].schedtransactiondate = schedtransactiondate;
    objectSubscriptionIntervalOverviewData[0].transactiondate = transactiondate;
    objectSubscriptionIntervalOverviewData[0].contractdate = contractdate;
    objectSubscriptionIntervalOverviewData[0].enddate = enddate;
    objectSubscriptionIntervalOverviewData[0].invoicefrequence = invoicefrequence;
    objectSubscriptionIntervalOverviewData[0].invoicefrequencer = "";
    objectSubscriptionIntervalOverviewData[0].isinvoiceafterfirstcycle = isinvoiceafterfirstcycle;
    objectSubscriptionIntervalOverviewData[0].quarterlyMonth = quarterlyMonth;
    objectSubscriptionIntervalOverviewData[0].quarterlyMonthr = "";
    objectSubscriptionIntervalOverviewData[0].yearlyMonth = yearlyMonth;
    objectSubscriptionIntervalOverviewData[0].yearlyMonthr = "";
    objectSubscriptionIntervalOverviewData[0].weeklyDay = weeklyDay;
    objectSubscriptionIntervalOverviewData[0].weeklyDayr = "";
    objectSubscriptionIntervalOverviewData[0].monthlyDay = monthlyDay;
    objectSubscriptionIntervalOverviewData[0].proposalstatus = proposalstatus;
    objectSubscriptionIntervalOverviewData[0].proposalstatusr = "";
    objectSubscriptionIntervalOverviewData[0].lostproposalfixedreason = lostproposalfixedreason;
    objectSubscriptionIntervalOverviewData[0].lostproposalfixedreasonr = "";
    objectSubscriptionIntervalOverviewData[0].lostproposalreason = lostproposalreason;
    objectSubscriptionIntervalOverviewData[0].totallinesonetime = totallinesonetime;
    objectSubscriptionIntervalOverviewData[0].grandtotalonetime = grandtotalonetime;
    objectSubscriptionIntervalOverviewData[0].totallines = totallines;
    objectSubscriptionIntervalOverviewData[0].grandtotal = grandtotal;
    objectSubscriptionIntervalOverviewData[0].invoicedamt = invoicedamt;
    objectSubscriptionIntervalOverviewData[0].totalpaid = totalpaid;
    objectSubscriptionIntervalOverviewData[0].completeordervalue = completeordervalue;
    objectSubscriptionIntervalOverviewData[0].iscompletelyinvoiced = iscompletelyinvoiced;
    objectSubscriptionIntervalOverviewData[0].docaction = docaction;
    objectSubscriptionIntervalOverviewData[0].docactionBtn = docactionBtn;
    objectSubscriptionIntervalOverviewData[0].generatetemplate = generatetemplate;
    objectSubscriptionIntervalOverviewData[0].copyfrom = copyfrom;
    objectSubscriptionIntervalOverviewData[0].copyfrompo = copyfrompo;
    objectSubscriptionIntervalOverviewData[0].generateproject = generateproject;
    objectSubscriptionIntervalOverviewData[0].closeproject = closeproject;
    objectSubscriptionIntervalOverviewData[0].cOrderId = cOrderId;
    objectSubscriptionIntervalOverviewData[0].issotrx = issotrx;
    objectSubscriptionIntervalOverviewData[0].processing = processing;
    objectSubscriptionIntervalOverviewData[0].processed = processed;
    objectSubscriptionIntervalOverviewData[0].isdelivered = isdelivered;
    objectSubscriptionIntervalOverviewData[0].isinvoiced = isinvoiced;
    objectSubscriptionIntervalOverviewData[0].isprinted = isprinted;
    objectSubscriptionIntervalOverviewData[0].isselected = isselected;
    objectSubscriptionIntervalOverviewData[0].dateprinted = dateprinted;
    objectSubscriptionIntervalOverviewData[0].dateacct = dateacct;
    objectSubscriptionIntervalOverviewData[0].cChargeId = cChargeId;
    objectSubscriptionIntervalOverviewData[0].chargeamt = chargeamt;
    objectSubscriptionIntervalOverviewData[0].istaxincluded = istaxincluded;
    objectSubscriptionIntervalOverviewData[0].cCampaignId = cCampaignId;
    objectSubscriptionIntervalOverviewData[0].cActivityId = cActivityId;
    objectSubscriptionIntervalOverviewData[0].posted = posted;
    objectSubscriptionIntervalOverviewData[0].dropshipBpartnerId = dropshipBpartnerId;
    objectSubscriptionIntervalOverviewData[0].dropshipLocationId = dropshipLocationId;
    objectSubscriptionIntervalOverviewData[0].dropshipUserId = dropshipUserId;
    objectSubscriptionIntervalOverviewData[0].isselfservice = isselfservice;
    objectSubscriptionIntervalOverviewData[0].adOrgtrxId = adOrgtrxId;
    objectSubscriptionIntervalOverviewData[0].user1Id = user1Id;
    objectSubscriptionIntervalOverviewData[0].user2Id = user2Id;
    objectSubscriptionIntervalOverviewData[0].incotermsdescription = incotermsdescription;
    objectSubscriptionIntervalOverviewData[0].cBidprojectId = cBidprojectId;
    objectSubscriptionIntervalOverviewData[0].cProjectphaseId = cProjectphaseId;
    objectSubscriptionIntervalOverviewData[0].ispaid = ispaid;
    objectSubscriptionIntervalOverviewData[0].isrecharge = isrecharge;
    objectSubscriptionIntervalOverviewData[0].btncopytemplate = btncopytemplate;
    objectSubscriptionIntervalOverviewData[0].language = "";
    return objectSubscriptionIntervalOverviewData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef8E484ACDA22C4137912AB7CE03F16DF6_0(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
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
  public static String selectDefDCC3A82F3D444E338D83C930D884FC48_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Createdby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedbyR);

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
  public static String selectDef851ED0863DD048029EBBEBFAFA8F1601_2(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Updatedby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedbyR);

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
  public static String selectDef8AFDA0D37D114D80B6F7A77103DA7A72_3(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as C_Bpartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Bpartner_IDR);

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

  public static int updateDocAction(ConnectionProvider connectionProvider, String docaction, String cSubscriptionintervalViewId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE c_subscriptioninterval_view" +
      "        SET docaction = ? " +
      "        WHERE c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE c_subscriptioninterval_view" +
      "        SET C_Subscriptioninterval_View_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Documentno = (?) , Poreference = (?) , Dateordered = TO_DATE(?) , Isactive = (?) , C_Doctypetarget_ID = (?) , A_Asset_ID = (?) , Name = (?) , C_Doctype_ID = (?) , Docstatus = (?) , Description = (?) , Deliverynotes = (?) , Internalnote = (?) , C_Bpartner_ID = (?) , bpzipcode = (?) , Billto_ID = (?) , C_Bpartner_Location_ID = (?) , AD_User_ID = (?) , Salesrep_ID = (?) , M_Pricelist_ID = (?) , Isdiscountprinted = (?) , Invoicerule = (?) , Estpropability = (?) , M_Warehouse_ID = (?) , C_Currency_ID = (?) , Deliveryrule = (?) , Priorityrule = (?) , Paymentrule = (?) , C_Paymentterm_ID = (?) , C_Incoterms_ID = (?) , Delivery_Location_ID = (?) , Deliveryviarule = (?) , M_Shipper_ID = (?) , Weight = TO_NUMBER(?) , Weight_Uom = (?) , Freightcostrule = (?) , M_Product_ID = (?) , Qty = TO_NUMBER(?) , Freightamt = TO_NUMBER(?) , C_Project_ID = (?) , C_Projecttask_ID = (?) , Orderselfjoin = (?) , Firstschedinvoicedate = TO_DATE(?) , Datepromised = TO_DATE(?) , Scheddeliverydate = TO_DATE(?) , Schedtransactiondate = TO_DATE(?) , Transactiondate = TO_DATE(?) , Contractdate = TO_DATE(?) , Enddate = TO_DATE(?) , Invoicefrequence = (?) , Isinvoiceafterfirstcycle = (?) , Quarterly_Month = (?) , Yearly_Month = (?) , Weekly_Day = (?) , Monthly_Day = TO_NUMBER(?) , Proposalstatus = (?) , Lostproposalfixedreason = (?) , Lostproposalreason = (?) , Totallinesonetime = TO_NUMBER(?) , Grandtotalonetime = TO_NUMBER(?) , Totallines = TO_NUMBER(?) , Grandtotal = TO_NUMBER(?) , Invoicedamt = TO_NUMBER(?) , Totalpaid = TO_NUMBER(?) , Completeordervalue = TO_NUMBER(?) , Iscompletelyinvoiced = (?) , DocAction = (?) , Generatetemplate = (?) , Copyfrom = (?) , Copyfrompo = (?) , Generateproject = (?) , Closeproject = (?) , C_Order_ID = (?) , Issotrx = (?) , Processing = (?) , Processed = (?) , Isdelivered = (?) , Isinvoiced = (?) , Isprinted = (?) , Isselected = (?) , Dateprinted = TO_DATE(?) , Dateacct = TO_DATE(?) , C_Charge_ID = (?) , Chargeamt = TO_NUMBER(?) , Istaxincluded = (?) , C_Campaign_ID = (?) , C_Activity_ID = (?) , Posted = (?) , Dropship_Bpartner_ID = (?) , Dropship_Location_ID = (?) , Dropship_User_ID = (?) , Isselfservice = (?) , AD_Orgtrx_ID = (?) , User1_ID = (?) , User2_ID = (?) , Incotermsdescription = (?) , C_Bidproject_ID = (?) , C_Projectphase_ID = (?) , Ispaid = (?) , Isrecharge = (?) , btncopytemplate = (?) , updated = now(), updatedby = ? " +
      "        WHERE c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = ? " +
      "        AND c_subscriptioninterval_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_subscriptioninterval_view.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSubscriptionintervalViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverynotes);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, internalnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpzipcode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estpropability);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priorityrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cIncotermsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weightUom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderselfjoin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstschedinvoicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedtransactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contractdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicefrequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiceafterfirstcycle);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quarterlyMonth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yearlyMonth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weeklyDay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, monthlyDay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proposalstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lostproposalfixedreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lostproposalreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallinesonetime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotalonetime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totalpaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, completeordervalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscompletelyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatetemplate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrompo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselected);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselfservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, incotermsdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBidprojectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrecharge);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, btncopytemplate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
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
      "        INSERT INTO c_subscriptioninterval_view " +
      "        (C_Subscriptioninterval_View_ID, AD_Client_ID, AD_Org_ID, Documentno, Poreference, Dateordered, Isactive, C_Doctypetarget_ID, A_Asset_ID, Name, C_Doctype_ID, Docstatus, Description, Deliverynotes, Internalnote, C_Bpartner_ID, bpzipcode, Billto_ID, C_Bpartner_Location_ID, AD_User_ID, Salesrep_ID, M_Pricelist_ID, Isdiscountprinted, Invoicerule, Estpropability, M_Warehouse_ID, C_Currency_ID, Deliveryrule, Priorityrule, Paymentrule, C_Paymentterm_ID, C_Incoterms_ID, Delivery_Location_ID, Deliveryviarule, M_Shipper_ID, Weight, Weight_Uom, Freightcostrule, M_Product_ID, Qty, Freightamt, C_Project_ID, C_Projecttask_ID, Orderselfjoin, Firstschedinvoicedate, Datepromised, Scheddeliverydate, Schedtransactiondate, Transactiondate, Contractdate, Enddate, Invoicefrequence, Isinvoiceafterfirstcycle, Quarterly_Month, Yearly_Month, Weekly_Day, Monthly_Day, Proposalstatus, Lostproposalfixedreason, Lostproposalreason, Totallinesonetime, Grandtotalonetime, Totallines, Grandtotal, Invoicedamt, Totalpaid, Completeordervalue, Iscompletelyinvoiced, DocAction, Generatetemplate, Copyfrom, Copyfrompo, Generateproject, Closeproject, C_Order_ID, Issotrx, Processing, Processed, Isdelivered, Isinvoiced, Isprinted, Isselected, Dateprinted, Dateacct, C_Charge_ID, Chargeamt, Istaxincluded, C_Campaign_ID, C_Activity_ID, Posted, Dropship_Bpartner_ID, Dropship_Location_ID, Dropship_User_ID, Isselfservice, AD_Orgtrx_ID, User1_ID, User2_ID, Incotermsdescription, C_Bidproject_ID, C_Projectphase_ID, Ispaid, Isrecharge, btncopytemplate, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSubscriptionintervalViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverynotes);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, internalnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpzipcode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estpropability);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priorityrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cIncotermsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weightUom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderselfjoin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstschedinvoicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedtransactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contractdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicefrequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiceafterfirstcycle);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quarterlyMonth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yearlyMonth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weeklyDay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, monthlyDay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proposalstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lostproposalfixedreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lostproposalreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallinesonetime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotalonetime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totalpaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, completeordervalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscompletelyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatetemplate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrompo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselected);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselfservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, incotermsdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBidprojectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrecharge);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, btncopytemplate);
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
      "        DELETE FROM c_subscriptioninterval_view" +
      "        WHERE c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = ? " +
      "        AND c_subscriptioninterval_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_subscriptioninterval_view.AD_Org_ID IN (";
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
      "        DELETE FROM c_subscriptioninterval_view" +
      "        WHERE c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = ? ";

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
      "          FROM c_subscriptioninterval_view" +
      "         WHERE c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = ? ";

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
      "          FROM c_subscriptioninterval_view" +
      "         WHERE c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = ? ";

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
