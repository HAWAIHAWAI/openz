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
class MainOrder22B66325DCD8421B9E737E4ACB2A5DADData implements FieldProvider {
static Logger log4j = Logger.getLogger(MainOrder22B66325DCD8421B9E737E4ACB2A5DADData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String grandtotalonetime;
  public String lostproposalfixedreason;
  public String lostproposalfixedreasonr;
  public String subscriptionchangedate;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String dateprinted;
  public String estpropability;
  public String estpropabilityr;
  public String deliveryLocationId;
  public String deliveryLocationIdr;
  public String weeklyDay;
  public String weeklyDayr;
  public String chargeamt;
  public String grandtotal;
  public String isactive;
  public String weightUom;
  public String weightUomr;
  public String totallines;
  public String aAssetId;
  public String aAssetIdr;
  public String quarterlyMonth;
  public String quarterlyMonthr;
  public String datepromised;
  public String cPaymenttermId;
  public String cPaymenttermIdr;
  public String deliverynotes;
  public String deliveryviarule;
  public String deliveryviaruler;
  public String freightcostrule;
  public String freightcostruler;
  public String processed;
  public String totalpaid;
  public String cOrderId;
  public String enddate;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String weight;
  public String salesrepId;
  public String salesrepIdr;
  public String transactiondate;
  public String invoicerule;
  public String invoiceruler;
  public String mShipperId;
  public String mShipperIdr;
  public String scheddeliverydate;
  public String internalnote;
  public String dateordered;
  public String generateproject;
  public String istaxincluded;
  public String completeordervalue;
  public String totallinesonetime;
  public String cIncotermsId;
  public String cIncotermsIdr;
  public String proposalstatus;
  public String proposalstatusr;
  public String invoicefrequence;
  public String invoicefrequencer;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String docstatus;
  public String docstatusr;
  public String isprinted;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String isrecharge;
  public String billtoId;
  public String billtoIdr;
  public String firstschedinvoicedate;
  public String isinvoiced;
  public String schedtransactiondate;
  public String cDoctypetargetId;
  public String cDoctypetargetIdr;
  public String dateacct;
  public String iscompletelyinvoiced;
  public String cProjectId;
  public String cProjectIdr;
  public String isinvoiceafterfirstcycle;
  public String ispaid;
  public String paymentrule;
  public String paymentruler;
  public String freightamt;
  public String priorityrule;
  public String priorityruler;
  public String isdelivered;
  public String yearlyMonth;
  public String yearlyMonthr;
  public String posted;
  public String postedBtn;
  public String contractdate;
  public String btncopytemplate;
  public String cBidprojectId;
  public String cBidprojectIdr;
  public String issotrx;
  public String incotermsdescription;
  public String name;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String mPricelistId;
  public String mPricelistIdr;
  public String closeproject;
  public String description;
  public String mProductId;
  public String mProductIdr;
  public String bpzipcode;
  public String lostproposalreason;
  public String dropshipBpartnerId;
  public String dropshipBpartnerIdr;
  public String transactionreference;
  public String docaction;
  public String docactionBtn;
  public String documentno;
  public String monthlyDay;
  public String qty;
  public String isselected;
  public String dropshipLocationId;
  public String dropshipLocationIdr;
  public String deliveryrule;
  public String deliveryruler;
  public String adUserId;
  public String adUserIdr;
  public String isdiscountprinted;
  public String invoicedamt;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
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
    else if (fieldName.equalsIgnoreCase("grandtotalonetime"))
      return grandtotalonetime;
    else if (fieldName.equalsIgnoreCase("lostproposalfixedreason"))
      return lostproposalfixedreason;
    else if (fieldName.equalsIgnoreCase("lostproposalfixedreasonr"))
      return lostproposalfixedreasonr;
    else if (fieldName.equalsIgnoreCase("subscriptionchangedate"))
      return subscriptionchangedate;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("dateprinted"))
      return dateprinted;
    else if (fieldName.equalsIgnoreCase("estpropability"))
      return estpropability;
    else if (fieldName.equalsIgnoreCase("estpropabilityr"))
      return estpropabilityr;
    else if (fieldName.equalsIgnoreCase("delivery_location_id") || fieldName.equals("deliveryLocationId"))
      return deliveryLocationId;
    else if (fieldName.equalsIgnoreCase("delivery_location_idr") || fieldName.equals("deliveryLocationIdr"))
      return deliveryLocationIdr;
    else if (fieldName.equalsIgnoreCase("weekly_day") || fieldName.equals("weeklyDay"))
      return weeklyDay;
    else if (fieldName.equalsIgnoreCase("weekly_dayr") || fieldName.equals("weeklyDayr"))
      return weeklyDayr;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("weight_uom") || fieldName.equals("weightUom"))
      return weightUom;
    else if (fieldName.equalsIgnoreCase("weight_uomr") || fieldName.equals("weightUomr"))
      return weightUomr;
    else if (fieldName.equalsIgnoreCase("totallines"))
      return totallines;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_idr") || fieldName.equals("aAssetIdr"))
      return aAssetIdr;
    else if (fieldName.equalsIgnoreCase("quarterly_month") || fieldName.equals("quarterlyMonth"))
      return quarterlyMonth;
    else if (fieldName.equalsIgnoreCase("quarterly_monthr") || fieldName.equals("quarterlyMonthr"))
      return quarterlyMonthr;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_idr") || fieldName.equals("cPaymenttermIdr"))
      return cPaymenttermIdr;
    else if (fieldName.equalsIgnoreCase("deliverynotes"))
      return deliverynotes;
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
    else if (fieldName.equalsIgnoreCase("deliveryviaruler"))
      return deliveryviaruler;
    else if (fieldName.equalsIgnoreCase("freightcostrule"))
      return freightcostrule;
    else if (fieldName.equalsIgnoreCase("freightcostruler"))
      return freightcostruler;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("totalpaid"))
      return totalpaid;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("enddate"))
      return enddate;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("weight"))
      return weight;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("transactiondate"))
      return transactiondate;
    else if (fieldName.equalsIgnoreCase("invoicerule"))
      return invoicerule;
    else if (fieldName.equalsIgnoreCase("invoiceruler"))
      return invoiceruler;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("m_shipper_idr") || fieldName.equals("mShipperIdr"))
      return mShipperIdr;
    else if (fieldName.equalsIgnoreCase("scheddeliverydate"))
      return scheddeliverydate;
    else if (fieldName.equalsIgnoreCase("internalnote"))
      return internalnote;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("generateproject"))
      return generateproject;
    else if (fieldName.equalsIgnoreCase("istaxincluded"))
      return istaxincluded;
    else if (fieldName.equalsIgnoreCase("completeordervalue"))
      return completeordervalue;
    else if (fieldName.equalsIgnoreCase("totallinesonetime"))
      return totallinesonetime;
    else if (fieldName.equalsIgnoreCase("c_incoterms_id") || fieldName.equals("cIncotermsId"))
      return cIncotermsId;
    else if (fieldName.equalsIgnoreCase("c_incoterms_idr") || fieldName.equals("cIncotermsIdr"))
      return cIncotermsIdr;
    else if (fieldName.equalsIgnoreCase("proposalstatus"))
      return proposalstatus;
    else if (fieldName.equalsIgnoreCase("proposalstatusr"))
      return proposalstatusr;
    else if (fieldName.equalsIgnoreCase("invoicefrequence"))
      return invoicefrequence;
    else if (fieldName.equalsIgnoreCase("invoicefrequencer"))
      return invoicefrequencer;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("isrecharge"))
      return isrecharge;
    else if (fieldName.equalsIgnoreCase("billto_id") || fieldName.equals("billtoId"))
      return billtoId;
    else if (fieldName.equalsIgnoreCase("billto_idr") || fieldName.equals("billtoIdr"))
      return billtoIdr;
    else if (fieldName.equalsIgnoreCase("firstschedinvoicedate"))
      return firstschedinvoicedate;
    else if (fieldName.equalsIgnoreCase("isinvoiced"))
      return isinvoiced;
    else if (fieldName.equalsIgnoreCase("schedtransactiondate"))
      return schedtransactiondate;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_id") || fieldName.equals("cDoctypetargetId"))
      return cDoctypetargetId;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_idr") || fieldName.equals("cDoctypetargetIdr"))
      return cDoctypetargetIdr;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("iscompletelyinvoiced"))
      return iscompletelyinvoiced;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("isinvoiceafterfirstcycle"))
      return isinvoiceafterfirstcycle;
    else if (fieldName.equalsIgnoreCase("ispaid"))
      return ispaid;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("paymentruler"))
      return paymentruler;
    else if (fieldName.equalsIgnoreCase("freightamt"))
      return freightamt;
    else if (fieldName.equalsIgnoreCase("priorityrule"))
      return priorityrule;
    else if (fieldName.equalsIgnoreCase("priorityruler"))
      return priorityruler;
    else if (fieldName.equalsIgnoreCase("isdelivered"))
      return isdelivered;
    else if (fieldName.equalsIgnoreCase("yearly_month") || fieldName.equals("yearlyMonth"))
      return yearlyMonth;
    else if (fieldName.equalsIgnoreCase("yearly_monthr") || fieldName.equals("yearlyMonthr"))
      return yearlyMonthr;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("posted_btn") || fieldName.equals("postedBtn"))
      return postedBtn;
    else if (fieldName.equalsIgnoreCase("contractdate"))
      return contractdate;
    else if (fieldName.equalsIgnoreCase("btncopytemplate"))
      return btncopytemplate;
    else if (fieldName.equalsIgnoreCase("c_bidproject_id") || fieldName.equals("cBidprojectId"))
      return cBidprojectId;
    else if (fieldName.equalsIgnoreCase("c_bidproject_idr") || fieldName.equals("cBidprojectIdr"))
      return cBidprojectIdr;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("incotermsdescription"))
      return incotermsdescription;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_idr") || fieldName.equals("mPricelistIdr"))
      return mPricelistIdr;
    else if (fieldName.equalsIgnoreCase("closeproject"))
      return closeproject;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("bpzipcode"))
      return bpzipcode;
    else if (fieldName.equalsIgnoreCase("lostproposalreason"))
      return lostproposalreason;
    else if (fieldName.equalsIgnoreCase("dropship_bpartner_id") || fieldName.equals("dropshipBpartnerId"))
      return dropshipBpartnerId;
    else if (fieldName.equalsIgnoreCase("dropship_bpartner_idr") || fieldName.equals("dropshipBpartnerIdr"))
      return dropshipBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("transactionreference"))
      return transactionreference;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("docaction_btn") || fieldName.equals("docactionBtn"))
      return docactionBtn;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("monthly_day") || fieldName.equals("monthlyDay"))
      return monthlyDay;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("isselected"))
      return isselected;
    else if (fieldName.equalsIgnoreCase("dropship_location_id") || fieldName.equals("dropshipLocationId"))
      return dropshipLocationId;
    else if (fieldName.equalsIgnoreCase("dropship_location_idr") || fieldName.equals("dropshipLocationIdr"))
      return dropshipLocationIdr;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("deliveryruler"))
      return deliveryruler;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("isdiscountprinted"))
      return isdiscountprinted;
    else if (fieldName.equalsIgnoreCase("invoicedamt"))
      return invoicedamt;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
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
  public static MainOrder22B66325DCD8421B9E737E4ACB2A5DADData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static MainOrder22B66325DCD8421B9E737E4ACB2A5DADData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Order.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Order.CreatedBy) as CreatedByR, " +
      "        to_char(C_Order.Updated, ?) as updated, " +
      "        to_char(C_Order.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Order.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Order.UpdatedBy) as UpdatedByR," +
      "        C_Order.Grandtotalonetime, " +
      "C_Order.Lostproposalfixedreason, " +
      "(CASE WHEN C_Order.Lostproposalfixedreason IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS LostproposalfixedreasonR, " +
      "C_Order.Subscriptionchangedate, " +
      "C_Order.C_BPartner_ID, " +
      "(CASE WHEN C_Order.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "C_Order.DatePrinted, " +
      "C_Order.Estpropability, " +
      "(CASE WHEN C_Order.Estpropability IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS EstpropabilityR, " +
      "C_Order.Delivery_Location_ID, " +
      "(CASE WHEN C_Order.Delivery_Location_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS Delivery_Location_IDR, " +
      "C_Order.Weekly_Day, " +
      "(CASE WHEN C_Order.Weekly_Day IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS Weekly_DayR, " +
      "C_Order.ChargeAmt, " +
      "C_Order.GrandTotal, " +
      "COALESCE(C_Order.IsActive, 'N') AS IsActive, " +
      "C_Order.Weight_Uom, " +
      "(CASE WHEN C_Order.Weight_Uom IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS Weight_UomR, " +
      "C_Order.TotalLines, " +
      "C_Order.A_Asset_ID, " +
      "(CASE WHEN C_Order.A_Asset_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "C_Order.Quarterly_Month, " +
      "(CASE WHEN C_Order.Quarterly_Month IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS Quarterly_MonthR, " +
      "C_Order.DatePromised, " +
      "C_Order.C_PaymentTerm_ID, " +
      "(CASE WHEN C_Order.C_PaymentTerm_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS C_PaymentTerm_IDR, " +
      "C_Order.Deliverynotes, " +
      "C_Order.DeliveryViaRule, " +
      "(CASE WHEN C_Order.DeliveryViaRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list5.name),'') ) END) AS DeliveryViaRuleR, " +
      "C_Order.FreightCostRule, " +
      "(CASE WHEN C_Order.FreightCostRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list6.name),'') ) END) AS FreightCostRuleR, " +
      "COALESCE(C_Order.Processed, 'N') AS Processed, " +
      "C_Order.Totalpaid, " +
      "C_Order.C_Order_ID, " +
      "C_Order.Enddate, " +
      "C_Order.C_Currency_ID, " +
      "(CASE WHEN C_Order.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "C_Order.Weight, " +
      "C_Order.SalesRep_ID, " +
      "(CASE WHEN C_Order.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "C_Order.Transactiondate, " +
      "C_Order.InvoiceRule, " +
      "(CASE WHEN C_Order.InvoiceRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list7.name),'') ) END) AS InvoiceRuleR, " +
      "C_Order.M_Shipper_ID, " +
      "(CASE WHEN C_Order.M_Shipper_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS M_Shipper_IDR, " +
      "C_Order.Scheddeliverydate, " +
      "C_Order.Internalnote, " +
      "C_Order.DateOrdered, " +
      "C_Order.Generateproject, " +
      "COALESCE(C_Order.IsTaxIncluded, 'N') AS IsTaxIncluded, " +
      "C_Order.Completeordervalue, " +
      "C_Order.Totallinesonetime, " +
      "C_Order.C_Incoterms_ID, " +
      "(CASE WHEN C_Order.C_Incoterms_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS C_Incoterms_IDR, " +
      "C_Order.Proposalstatus, " +
      "(CASE WHEN C_Order.Proposalstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list8.name),'') ) END) AS ProposalstatusR, " +
      "C_Order.Invoicefrequence, " +
      "(CASE WHEN C_Order.Invoicefrequence IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list9.name),'') ) END) AS InvoicefrequenceR, " +
      "C_Order.C_Projecttask_ID, " +
      "(CASE WHEN C_Order.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "C_Order.DocStatus, " +
      "(CASE WHEN C_Order.DocStatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list10.name),'') ) END) AS DocStatusR, " +
      "COALESCE(C_Order.IsPrinted, 'N') AS IsPrinted, " +
      "C_Order.C_BPartner_Location_ID, " +
      "(CASE WHEN C_Order.C_BPartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Name), ''))),'') ) END) AS C_BPartner_Location_IDR, " +
      "C_Order.C_DocType_ID, " +
      "(CASE WHEN C_Order.C_DocType_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL13.Name IS NULL THEN TO_CHAR(table13.Name) ELSE TO_CHAR(tableTRL13.Name) END)), ''))),'') ) END) AS C_DocType_IDR, " +
      "COALESCE(C_Order.Isrecharge, 'N') AS Isrecharge, " +
      "C_Order.BillTo_ID, " +
      "(CASE WHEN C_Order.BillTo_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Name), ''))),'') ) END) AS BillTo_IDR, " +
      "C_Order.Firstschedinvoicedate, " +
      "COALESCE(C_Order.IsInvoiced, 'N') AS IsInvoiced, " +
      "C_Order.Schedtransactiondate, " +
      "C_Order.C_DocTypeTarget_ID, " +
      "(CASE WHEN C_Order.C_DocTypeTarget_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL15.Name IS NULL THEN TO_CHAR(table15.Name) ELSE TO_CHAR(tableTRL15.Name) END)), ''))),'') ) END) AS C_DocTypeTarget_IDR, " +
      "C_Order.DateAcct, " +
      "COALESCE(C_Order.Iscompletelyinvoiced, 'N') AS Iscompletelyinvoiced, " +
      "C_Order.C_Project_ID, " +
      "(CASE WHEN C_Order.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "COALESCE(C_Order.Isinvoiceafterfirstcycle, 'N') AS Isinvoiceafterfirstcycle, " +
      "COALESCE(C_Order.Ispaid, 'N') AS Ispaid, " +
      "C_Order.PaymentRule, " +
      "(CASE WHEN C_Order.PaymentRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list11.name),'') ) END) AS PaymentRuleR, " +
      "C_Order.FreightAmt, " +
      "C_Order.PriorityRule, " +
      "(CASE WHEN C_Order.PriorityRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list12.name),'') ) END) AS PriorityRuleR, " +
      "COALESCE(C_Order.IsDelivered, 'N') AS IsDelivered, " +
      "C_Order.Yearly_Month, " +
      "(CASE WHEN C_Order.Yearly_Month IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list13.name),'') ) END) AS Yearly_MonthR, " +
      "C_Order.Posted, " +
      "list14.name as Posted_BTN, " +
      "C_Order.Contractdate, " +
      "C_Order.BtnCopyTemplate, " +
      "C_Order.C_Bidproject_ID, " +
      "(CASE WHEN C_Order.C_Bidproject_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table17.Name), ''))),'') ) END) AS C_Bidproject_IDR, " +
      "COALESCE(C_Order.IsSOTrx, 'N') AS IsSOTrx, " +
      "C_Order.Incotermsdescription, " +
      "C_Order.Name, " +
      "C_Order.M_Warehouse_ID, " +
      "(CASE WHEN C_Order.M_Warehouse_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table18.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "C_Order.M_PriceList_ID, " +
      "(CASE WHEN C_Order.M_PriceList_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.Name), ''))),'') ) END) AS M_PriceList_IDR, " +
      "C_Order.Closeproject, " +
      "C_Order.Description, " +
      "C_Order.M_Product_ID, " +
      "(CASE WHEN C_Order.M_Product_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL20.Name IS NULL THEN TO_CHAR(table20.Name) ELSE TO_CHAR(tableTRL20.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "C_Order.bpzipcode, " +
      "C_Order.Lostproposalreason, " +
      "C_Order.DropShip_BPartner_ID, " +
      "(CASE WHEN C_Order.DropShip_BPartner_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table21.Name), ''))),'') ) END) AS DropShip_BPartner_IDR, " +
      "C_Order.Transactionreference, " +
      "C_Order.DocAction, " +
      "list15.name as DocAction_BTN, " +
      "C_Order.DocumentNo, " +
      "C_Order.Monthly_Day, " +
      "C_Order.Qty, " +
      "COALESCE(C_Order.IsSelected, 'N') AS IsSelected, " +
      "C_Order.DropShip_Location_ID, " +
      "(CASE WHEN C_Order.DropShip_Location_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table22.Name), ''))),'') ) END) AS DropShip_Location_IDR, " +
      "C_Order.DeliveryRule, " +
      "(CASE WHEN C_Order.DeliveryRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list16.name),'') ) END) AS DeliveryRuleR, " +
      "C_Order.AD_User_ID, " +
      "(CASE WHEN C_Order.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table23.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "COALESCE(C_Order.IsDiscountPrinted, 'N') AS IsDiscountPrinted, " +
      "C_Order.Invoicedamt, " +
      "C_Order.AD_Client_ID, " +
      "(CASE WHEN C_Order.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table24.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_Order.AD_Org_ID, " +
      "(CASE WHEN C_Order.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table25.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Order left join ad_ref_list_v list1 on (C_Order.Lostproposalfixedreason = list1.value and list1.ad_reference_id = 'B51F770E9FA84F5B8FC0FFD7B3848317' and list1.ad_language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_Order.C_BPartner_ID = table1.C_BPartner_ID) left join ad_ref_list_v list2 on (C_Order.Estpropability = list2.value and list2.ad_reference_id = 'DD6AA16AB1DD4DF5AD11A2665AE665BC' and list2.ad_language = ?)  left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table2 on (C_Order.Delivery_Location_ID =  table2.C_BPartner_Location_ID) left join ad_ref_list_v list3 on (C_Order.Weekly_Day = list3.value and list3.ad_reference_id = '167' and list3.ad_language = ?)  left join (select C_UOM_ID, Name from C_UOM) table3 on (C_Order.Weight_Uom =  table3.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL3 on (table3.C_UOM_ID = tableTRL3.C_UOM_ID and tableTRL3.AD_Language = ?)  left join (select A_Asset_ID, Name from A_Asset) table4 on (C_Order.A_Asset_ID = table4.A_Asset_ID) left join ad_ref_list_v list4 on (C_Order.Quarterly_Month = list4.value and list4.ad_reference_id = '99780AA6C1644A329162A8AF74602925' and list4.ad_language = ?)  left join (select C_PaymentTerm_ID, Name from C_PaymentTerm) table5 on (C_Order.C_PaymentTerm_ID = table5.C_PaymentTerm_ID) left join (select C_PaymentTerm_ID,AD_Language, Name from C_PaymentTerm_TRL) tableTRL5 on (table5.C_PaymentTerm_ID = tableTRL5.C_PaymentTerm_ID and tableTRL5.AD_Language = ?)  left join ad_ref_list_v list5 on (C_Order.DeliveryViaRule = list5.value and list5.ad_reference_id = '152' and list5.ad_language = ?)  left join ad_ref_list_v list6 on (C_Order.FreightCostRule = list6.value and list6.ad_reference_id = '153' and list6.ad_language = ?)  left join (select C_Currency_ID, ISO_Code from C_Currency) table6 on (C_Order.C_Currency_ID = table6.C_Currency_ID) left join (select AD_User_ID, Name from AD_User) table7 on (C_Order.SalesRep_ID =  table7.AD_User_ID) left join ad_ref_list_v list7 on (C_Order.InvoiceRule = list7.value and list7.ad_reference_id = '150' and list7.ad_language = ?)  left join (select M_Shipper_ID, Name from M_Shipper) table8 on (C_Order.M_Shipper_ID = table8.M_Shipper_ID) left join (select C_Incoterms_ID, Name from C_Incoterms) table9 on (C_Order.C_Incoterms_ID = table9.C_Incoterms_ID) left join ad_ref_list_v list8 on (C_Order.Proposalstatus = list8.value and list8.ad_reference_id = 'B00D78B6B154404A831F25F11ABD867E' and list8.ad_language = ?)  left join ad_ref_list_v list9 on (C_Order.Invoicefrequence = list9.value and list9.ad_reference_id = 'F17BFE71276743BBB6105EE61D9FD666' and list9.ad_language = ?)  left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table10 on (C_Order.C_Projecttask_ID = table10.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table11 on (table10.C_Project_ID = table11.C_Project_ID) left join ad_ref_list_v list10 on (C_Order.DocStatus = list10.value and list10.ad_reference_id = '131' and list10.ad_language = ?)  left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table12 on (C_Order.C_BPartner_Location_ID = table12.C_BPartner_Location_ID) left join (select C_DocType_ID, Name from C_DocType) table13 on (C_Order.C_DocType_ID = table13.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL13 on (table13.C_DocType_ID = tableTRL13.C_DocType_ID and tableTRL13.AD_Language = ?)  left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table14 on (C_Order.BillTo_ID =  table14.C_BPartner_Location_ID) left join (select C_DocType_ID, Name from C_DocType) table15 on (C_Order.C_DocTypeTarget_ID =  table15.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL15 on (table15.C_DocType_ID = tableTRL15.C_DocType_ID and tableTRL15.AD_Language = ?)  left join (select C_Project_ID, Value, Name from C_Project) table16 on (C_Order.C_Project_ID = table16.C_Project_ID) left join ad_ref_list_v list11 on (C_Order.PaymentRule = list11.value and list11.ad_reference_id = '195' and list11.ad_language = ?)  left join ad_ref_list_v list12 on (C_Order.PriorityRule = list12.value and list12.ad_reference_id = '154' and list12.ad_language = ?)  left join ad_ref_list_v list13 on (C_Order.Yearly_Month = list13.value and list13.ad_reference_id = 'B849337BE90242BEB0B230808EDC0CEE' and list13.ad_language = ?)  left join ad_ref_list_v list14 on (list14.ad_reference_id = '234' and list14.ad_language = ?  AND C_Order.Posted = TO_CHAR(list14.value)) left join (select C_Project_ID, value, Name from C_Project) table17 on (C_Order.C_Bidproject_ID =  table17.C_Project_ID) left join (select M_Warehouse_ID, Name from M_Warehouse) table18 on (C_Order.M_Warehouse_ID =  table18.M_Warehouse_ID) left join (select M_PriceList_ID, Name from M_PriceList) table19 on (C_Order.M_PriceList_ID = table19.M_PriceList_ID) left join (select M_Product_ID, value, Name from M_Product) table20 on (C_Order.M_Product_ID =  table20.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL20 on (table20.M_Product_ID = tableTRL20.M_Product_ID and tableTRL20.AD_Language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table21 on (C_Order.DropShip_BPartner_ID =  table21.C_BPartner_ID) left join ad_ref_list_v list15 on (list15.ad_reference_id = '135' and list15.ad_language = ?  AND (CASE C_Order.DocAction WHEN '--' THEN 'CL' ELSE TO_CHAR(C_Order.DocAction) END) = list15.value) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table22 on (C_Order.DropShip_Location_ID =  table22.C_BPartner_Location_ID) left join ad_ref_list_v list16 on (C_Order.DeliveryRule = list16.value and list16.ad_reference_id = '151' and list16.ad_language = ?)  left join (select AD_User_ID, Name from AD_User) table23 on (C_Order.AD_User_ID = table23.AD_User_ID) left join (select AD_Client_ID, Name from AD_Client) table24 on (C_Order.AD_Client_ID = table24.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table25 on (C_Order.AD_Org_ID = table25.AD_Org_ID)" +
      "        WHERE 2=2 " +
      " AND c_order.issotrx='Y'" +
      "        AND 1=1 " +
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
        MainOrder22B66325DCD8421B9E737E4ACB2A5DADData objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData = new MainOrder22B66325DCD8421B9E737E4ACB2A5DADData();
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.created = UtilSql.getValue(result, "created");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.updated = UtilSql.getValue(result, "updated");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.updatedby = UtilSql.getValue(result, "updatedby");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.grandtotalonetime = UtilSql.getValue(result, "grandtotalonetime");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.lostproposalfixedreason = UtilSql.getValue(result, "lostproposalfixedreason");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.lostproposalfixedreasonr = UtilSql.getValue(result, "lostproposalfixedreasonr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.subscriptionchangedate = UtilSql.getDateValue(result, "subscriptionchangedate", "dd-MM-yyyy");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.dateprinted = UtilSql.getDateValue(result, "dateprinted", "dd-MM-yyyy");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.estpropability = UtilSql.getValue(result, "estpropability");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.estpropabilityr = UtilSql.getValue(result, "estpropabilityr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.deliveryLocationId = UtilSql.getValue(result, "delivery_location_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.deliveryLocationIdr = UtilSql.getValue(result, "delivery_location_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.weeklyDay = UtilSql.getValue(result, "weekly_day");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.weeklyDayr = UtilSql.getValue(result, "weekly_dayr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.isactive = UtilSql.getValue(result, "isactive");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.weightUom = UtilSql.getValue(result, "weight_uom");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.weightUomr = UtilSql.getValue(result, "weight_uomr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.totallines = UtilSql.getValue(result, "totallines");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.quarterlyMonth = UtilSql.getValue(result, "quarterly_month");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.quarterlyMonthr = UtilSql.getValue(result, "quarterly_monthr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cPaymenttermIdr = UtilSql.getValue(result, "c_paymentterm_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.deliverynotes = UtilSql.getValue(result, "deliverynotes");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.deliveryviaruler = UtilSql.getValue(result, "deliveryviaruler");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.freightcostrule = UtilSql.getValue(result, "freightcostrule");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.freightcostruler = UtilSql.getValue(result, "freightcostruler");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.processed = UtilSql.getValue(result, "processed");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.totalpaid = UtilSql.getValue(result, "totalpaid");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.enddate = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.weight = UtilSql.getValue(result, "weight");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.transactiondate = UtilSql.getDateValue(result, "transactiondate", "dd-MM-yyyy");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.invoiceruler = UtilSql.getValue(result, "invoiceruler");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.mShipperIdr = UtilSql.getValue(result, "m_shipper_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.scheddeliverydate = UtilSql.getDateValue(result, "scheddeliverydate", "dd-MM-yyyy");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.internalnote = UtilSql.getValue(result, "internalnote");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.generateproject = UtilSql.getValue(result, "generateproject");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.completeordervalue = UtilSql.getValue(result, "completeordervalue");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.totallinesonetime = UtilSql.getValue(result, "totallinesonetime");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cIncotermsId = UtilSql.getValue(result, "c_incoterms_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cIncotermsIdr = UtilSql.getValue(result, "c_incoterms_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.proposalstatus = UtilSql.getValue(result, "proposalstatus");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.proposalstatusr = UtilSql.getValue(result, "proposalstatusr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.invoicefrequence = UtilSql.getValue(result, "invoicefrequence");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.invoicefrequencer = UtilSql.getValue(result, "invoicefrequencer");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.docstatus = UtilSql.getValue(result, "docstatus");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.isprinted = UtilSql.getValue(result, "isprinted");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.isrecharge = UtilSql.getValue(result, "isrecharge");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.billtoId = UtilSql.getValue(result, "billto_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.billtoIdr = UtilSql.getValue(result, "billto_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.firstschedinvoicedate = UtilSql.getDateValue(result, "firstschedinvoicedate", "dd-MM-yyyy");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.isinvoiced = UtilSql.getValue(result, "isinvoiced");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.schedtransactiondate = UtilSql.getDateValue(result, "schedtransactiondate", "dd-MM-yyyy");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cDoctypetargetId = UtilSql.getValue(result, "c_doctypetarget_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cDoctypetargetIdr = UtilSql.getValue(result, "c_doctypetarget_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.iscompletelyinvoiced = UtilSql.getValue(result, "iscompletelyinvoiced");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.isinvoiceafterfirstcycle = UtilSql.getValue(result, "isinvoiceafterfirstcycle");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.ispaid = UtilSql.getValue(result, "ispaid");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.paymentruler = UtilSql.getValue(result, "paymentruler");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.freightamt = UtilSql.getValue(result, "freightamt");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.priorityrule = UtilSql.getValue(result, "priorityrule");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.priorityruler = UtilSql.getValue(result, "priorityruler");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.isdelivered = UtilSql.getValue(result, "isdelivered");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.yearlyMonth = UtilSql.getValue(result, "yearly_month");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.yearlyMonthr = UtilSql.getValue(result, "yearly_monthr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.posted = UtilSql.getValue(result, "posted");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.postedBtn = UtilSql.getValue(result, "posted_btn");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.contractdate = UtilSql.getDateValue(result, "contractdate", "dd-MM-yyyy");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.btncopytemplate = UtilSql.getValue(result, "btncopytemplate");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cBidprojectId = UtilSql.getValue(result, "c_bidproject_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.cBidprojectIdr = UtilSql.getValue(result, "c_bidproject_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.issotrx = UtilSql.getValue(result, "issotrx");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.incotermsdescription = UtilSql.getValue(result, "incotermsdescription");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.name = UtilSql.getValue(result, "name");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.mPricelistIdr = UtilSql.getValue(result, "m_pricelist_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.closeproject = UtilSql.getValue(result, "closeproject");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.description = UtilSql.getValue(result, "description");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.bpzipcode = UtilSql.getValue(result, "bpzipcode");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.lostproposalreason = UtilSql.getValue(result, "lostproposalreason");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.dropshipBpartnerId = UtilSql.getValue(result, "dropship_bpartner_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.dropshipBpartnerIdr = UtilSql.getValue(result, "dropship_bpartner_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.transactionreference = UtilSql.getValue(result, "transactionreference");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.docaction = UtilSql.getValue(result, "docaction");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.docactionBtn = UtilSql.getValue(result, "docaction_btn");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.documentno = UtilSql.getValue(result, "documentno");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.monthlyDay = UtilSql.getValue(result, "monthly_day");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.qty = UtilSql.getValue(result, "qty");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.isselected = UtilSql.getValue(result, "isselected");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.dropshipLocationId = UtilSql.getValue(result, "dropship_location_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.dropshipLocationIdr = UtilSql.getValue(result, "dropship_location_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.deliveryruler = UtilSql.getValue(result, "deliveryruler");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.invoicedamt = UtilSql.getValue(result, "invoicedamt");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.language = UtilSql.getValue(result, "language");
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.adUserClient = "";
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.adOrgClient = "";
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.createdby = "";
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.trBgcolor = "";
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.totalCount = "";
        objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData);
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
    MainOrder22B66325DCD8421B9E737E4ACB2A5DADData objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[] = new MainOrder22B66325DCD8421B9E737E4ACB2A5DADData[vector.size()];
    vector.copyInto(objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData);
    return(objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData);
  }

/**
Create a registry
 */
  public static MainOrder22B66325DCD8421B9E737E4ACB2A5DADData[] set(String cBpartnerId, String cBpartnerIdr, String generateproject, String priorityrule, String aAssetId, String cIncotermsId, String billtoId, String adClientId, String iscompletelyinvoiced, String mShipperId, String freightamt, String completeordervalue, String cProjecttaskId, String qty, String isinvoiced, String dateprinted, String isprinted, String mProductId, String totallines, String weightUom, String enddate, String proposalstatus, String isactive, String transactiondate, String weight, String name, String invoicefrequence, String transactionreference, String incotermsdescription, String cBpartnerLocationId, String totalpaid, String internalnote, String btncopytemplate, String isdiscountprinted, String totallinesonetime, String freightcostrule, String processed, String datepromised, String cPaymenttermId, String contractdate, String docstatus, String cProjectId, String cProjectIdr, String paymentrule, String lostproposalfixedreason, String updatedby, String updatedbyr, String isdelivered, String issotrx, String deliveryLocationId, String dateacct, String salesrepId, String invoicedamt, String mWarehouseId, String cOrderId, String deliveryrule, String createdby, String createdbyr, String dateordered, String schedtransactiondate, String documentno, String monthlyDay, String subscriptionchangedate, String scheddeliverydate, String cCurrencyId, String adOrgId, String bpzipcode, String grandtotalonetime, String cDoctypetargetId, String invoicerule, String chargeamt, String closeproject, String deliverynotes, String isinvoiceafterfirstcycle, String cBidprojectId, String mPricelistId, String dropshipBpartnerId, String estpropability, String weeklyDay, String deliveryviarule, String isrecharge, String description, String docaction, String docactionBtn, String grandtotal, String ispaid, String lostproposalreason, String posted, String postedBtn, String cDoctypeId, String dropshipLocationId, String isselected, String adUserId, String quarterlyMonth, String firstschedinvoicedate, String istaxincluded, String yearlyMonth)    throws ServletException {
    MainOrder22B66325DCD8421B9E737E4ACB2A5DADData objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[] = new MainOrder22B66325DCD8421B9E737E4ACB2A5DADData[1];
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0] = new MainOrder22B66325DCD8421B9E737E4ACB2A5DADData();
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].created = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].createdbyr = createdbyr;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].updated = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].updatedTimeStamp = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].updatedby = updatedby;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].updatedbyr = updatedbyr;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].grandtotalonetime = grandtotalonetime;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].lostproposalfixedreason = lostproposalfixedreason;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].lostproposalfixedreasonr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].subscriptionchangedate = subscriptionchangedate;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cBpartnerId = cBpartnerId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cBpartnerIdr = cBpartnerIdr;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].dateprinted = dateprinted;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].estpropability = estpropability;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].estpropabilityr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].deliveryLocationId = deliveryLocationId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].deliveryLocationIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].weeklyDay = weeklyDay;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].weeklyDayr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].chargeamt = chargeamt;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].grandtotal = grandtotal;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].isactive = isactive;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].weightUom = weightUom;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].weightUomr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].totallines = totallines;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].aAssetId = aAssetId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].aAssetIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].quarterlyMonth = quarterlyMonth;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].quarterlyMonthr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].datepromised = datepromised;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cPaymenttermId = cPaymenttermId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cPaymenttermIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].deliverynotes = deliverynotes;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].deliveryviarule = deliveryviarule;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].deliveryviaruler = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].freightcostrule = freightcostrule;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].freightcostruler = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].processed = processed;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].totalpaid = totalpaid;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cOrderId = cOrderId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].enddate = enddate;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cCurrencyId = cCurrencyId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cCurrencyIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].weight = weight;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].salesrepId = salesrepId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].salesrepIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].transactiondate = transactiondate;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].invoicerule = invoicerule;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].invoiceruler = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].mShipperId = mShipperId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].mShipperIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].scheddeliverydate = scheddeliverydate;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].internalnote = internalnote;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].dateordered = dateordered;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].generateproject = generateproject;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].istaxincluded = istaxincluded;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].completeordervalue = completeordervalue;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].totallinesonetime = totallinesonetime;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cIncotermsId = cIncotermsId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cIncotermsIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].proposalstatus = proposalstatus;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].proposalstatusr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].invoicefrequence = invoicefrequence;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].invoicefrequencer = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cProjecttaskId = cProjecttaskId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cProjecttaskIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].docstatus = docstatus;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].docstatusr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].isprinted = isprinted;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cBpartnerLocationIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cDoctypeId = cDoctypeId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cDoctypeIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].isrecharge = isrecharge;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].billtoId = billtoId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].billtoIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].firstschedinvoicedate = firstschedinvoicedate;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].isinvoiced = isinvoiced;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].schedtransactiondate = schedtransactiondate;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cDoctypetargetId = cDoctypetargetId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cDoctypetargetIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].dateacct = dateacct;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].iscompletelyinvoiced = iscompletelyinvoiced;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cProjectId = cProjectId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cProjectIdr = cProjectIdr;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].isinvoiceafterfirstcycle = isinvoiceafterfirstcycle;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].ispaid = ispaid;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].paymentrule = paymentrule;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].paymentruler = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].freightamt = freightamt;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].priorityrule = priorityrule;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].priorityruler = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].isdelivered = isdelivered;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].yearlyMonth = yearlyMonth;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].yearlyMonthr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].posted = posted;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].postedBtn = postedBtn;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].contractdate = contractdate;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].btncopytemplate = btncopytemplate;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cBidprojectId = cBidprojectId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].cBidprojectIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].issotrx = issotrx;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].incotermsdescription = incotermsdescription;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].name = name;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].mWarehouseId = mWarehouseId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].mWarehouseIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].mPricelistId = mPricelistId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].mPricelistIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].closeproject = closeproject;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].description = description;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].mProductId = mProductId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].mProductIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].bpzipcode = bpzipcode;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].lostproposalreason = lostproposalreason;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].dropshipBpartnerId = dropshipBpartnerId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].dropshipBpartnerIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].transactionreference = transactionreference;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].docaction = docaction;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].docactionBtn = docactionBtn;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].documentno = documentno;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].monthlyDay = monthlyDay;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].qty = qty;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].isselected = isselected;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].dropshipLocationId = dropshipLocationId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].dropshipLocationIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].deliveryrule = deliveryrule;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].deliveryruler = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].adUserId = adUserId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].adUserIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].isdiscountprinted = isdiscountprinted;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].invoicedamt = invoicedamt;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].adClientId = adClientId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].adClientIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].adOrgId = adOrgId;
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].adOrgIdr = "";
    objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData[0].language = "";
    return objectMainOrder22B66325DCD8421B9E737E4ACB2A5DADData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2762_0(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
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
  public static String selectDef3402_1(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
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
  public static String selectDef2168_2(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef2166_3(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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

  public static int updateDocAction(ConnectionProvider connectionProvider, String docaction, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_Order" +
      "        SET docaction = ? " +
      "        WHERE C_Order.C_Order_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
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
      "        UPDATE C_Order" +
      "        SET Grandtotalonetime = TO_NUMBER(?) , Lostproposalfixedreason = (?) , Subscriptionchangedate = TO_DATE(?) , C_BPartner_ID = (?) , DatePrinted = TO_DATE(?) , Estpropability = (?) , Delivery_Location_ID = (?) , Weekly_Day = (?) , ChargeAmt = TO_NUMBER(?) , GrandTotal = TO_NUMBER(?) , IsActive = (?) , Weight_Uom = (?) , TotalLines = TO_NUMBER(?) , A_Asset_ID = (?) , Quarterly_Month = (?) , DatePromised = TO_DATE(?) , C_PaymentTerm_ID = (?) , Deliverynotes = (?) , DeliveryViaRule = (?) , FreightCostRule = (?) , Processed = (?) , Totalpaid = TO_NUMBER(?) , C_Order_ID = (?) , Enddate = TO_DATE(?) , C_Currency_ID = (?) , Weight = TO_NUMBER(?) , SalesRep_ID = (?) , Transactiondate = TO_DATE(?) , InvoiceRule = (?) , M_Shipper_ID = (?) , Scheddeliverydate = TO_DATE(?) , Internalnote = (?) , DateOrdered = TO_DATE(?) , Generateproject = (?) , IsTaxIncluded = (?) , Completeordervalue = TO_NUMBER(?) , Totallinesonetime = TO_NUMBER(?) , C_Incoterms_ID = (?) , Proposalstatus = (?) , Invoicefrequence = (?) , C_Projecttask_ID = (?) , DocStatus = (?) , IsPrinted = (?) , C_BPartner_Location_ID = (?) , C_DocType_ID = (?) , Isrecharge = (?) , BillTo_ID = (?) , Firstschedinvoicedate = TO_DATE(?) , IsInvoiced = (?) , Schedtransactiondate = TO_DATE(?) , C_DocTypeTarget_ID = (?) , DateAcct = TO_DATE(?) , Iscompletelyinvoiced = (?) , C_Project_ID = (?) , Isinvoiceafterfirstcycle = (?) , Ispaid = (?) , PaymentRule = (?) , FreightAmt = TO_NUMBER(?) , PriorityRule = (?) , IsDelivered = (?) , Yearly_Month = (?) , Posted = (?) , Contractdate = TO_DATE(?) , BtnCopyTemplate = (?) , C_Bidproject_ID = (?) , IsSOTrx = (?) , Incotermsdescription = (?) , Name = (?) , M_Warehouse_ID = (?) , M_PriceList_ID = (?) , Closeproject = (?) , Description = (?) , M_Product_ID = (?) , bpzipcode = (?) , Lostproposalreason = (?) , DropShip_BPartner_ID = (?) , Transactionreference = (?) , DocAction = (?) , DocumentNo = (?) , Monthly_Day = TO_NUMBER(?) , Qty = TO_NUMBER(?) , IsSelected = (?) , DropShip_Location_ID = (?) , DeliveryRule = (?) , AD_User_ID = (?) , IsDiscountPrinted = (?) , Invoicedamt = TO_NUMBER(?) , AD_Client_ID = (?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Order.C_Order_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotalonetime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lostproposalfixedreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subscriptionchangedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estpropability);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weeklyDay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weightUom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quarterlyMonth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverynotes);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totalpaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, internalnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, completeordervalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallinesonetime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cIncotermsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proposalstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicefrequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrecharge);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstschedinvoicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedtransactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscompletelyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiceafterfirstcycle);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priorityrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yearlyMonth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contractdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, btncopytemplate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBidprojectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, incotermsdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpzipcode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lostproposalreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transactionreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, monthlyDay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselected);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
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
      "        INSERT INTO C_Order " +
      "        (Grandtotalonetime, Lostproposalfixedreason, Subscriptionchangedate, C_BPartner_ID, DatePrinted, Estpropability, Delivery_Location_ID, Weekly_Day, ChargeAmt, GrandTotal, IsActive, Weight_Uom, TotalLines, A_Asset_ID, Quarterly_Month, DatePromised, C_PaymentTerm_ID, Deliverynotes, DeliveryViaRule, FreightCostRule, Processed, Totalpaid, C_Order_ID, Enddate, C_Currency_ID, Weight, SalesRep_ID, Transactiondate, InvoiceRule, M_Shipper_ID, Scheddeliverydate, Internalnote, DateOrdered, Generateproject, IsTaxIncluded, Completeordervalue, Totallinesonetime, C_Incoterms_ID, Proposalstatus, Invoicefrequence, C_Projecttask_ID, DocStatus, IsPrinted, C_BPartner_Location_ID, C_DocType_ID, Isrecharge, BillTo_ID, Firstschedinvoicedate, IsInvoiced, Schedtransactiondate, C_DocTypeTarget_ID, DateAcct, Iscompletelyinvoiced, C_Project_ID, Isinvoiceafterfirstcycle, Ispaid, PaymentRule, FreightAmt, PriorityRule, IsDelivered, Yearly_Month, Posted, Contractdate, BtnCopyTemplate, C_Bidproject_ID, IsSOTrx, Incotermsdescription, Name, M_Warehouse_ID, M_PriceList_ID, Closeproject, Description, M_Product_ID, bpzipcode, Lostproposalreason, DropShip_BPartner_ID, Transactionreference, DocAction, DocumentNo, Monthly_Day, Qty, IsSelected, DropShip_Location_ID, DeliveryRule, AD_User_ID, IsDiscountPrinted, Invoicedamt, AD_Client_ID, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES (TO_NUMBER(?), (?), TO_DATE(?), (?), TO_DATE(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_DATE(?), (?), TO_NUMBER(?), (?), TO_DATE(?), (?), (?), TO_DATE(?), (?), TO_DATE(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), TO_DATE(?), (?), TO_DATE(?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotalonetime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lostproposalfixedreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subscriptionchangedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estpropability);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weeklyDay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weightUom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quarterlyMonth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverynotes);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totalpaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, internalnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, completeordervalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallinesonetime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cIncotermsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proposalstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicefrequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrecharge);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstschedinvoicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedtransactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscompletelyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiceafterfirstcycle);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priorityrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yearlyMonth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contractdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, btncopytemplate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBidprojectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, incotermsdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpzipcode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lostproposalreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transactionreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, monthlyDay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselected);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
      "        DELETE FROM C_Order" +
      "        WHERE C_Order.C_Order_ID = ? " +
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
      "        DELETE FROM C_Order" +
      "        WHERE C_Order.C_Order_ID = ? ";

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
