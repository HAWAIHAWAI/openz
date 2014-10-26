//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.InvoiceOrderReferencing;

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
class InvoiceOrderReferencingData implements FieldProvider {
static Logger log4j = Logger.getLogger(InvoiceOrderReferencingData.class);
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
  public String cDoctypetargetId;
  public String cDoctypetargetIdr;
  public String dateinvoiced;
  public String dateacct;
  public String performanceperiodstart;
  public String performanceperiodend;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String adUserId;
  public String adUserIdr;
  public String mPricelistId;
  public String mPricelistIdr;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String salesrepId;
  public String salesrepIdr;
  public String cChargeId;
  public String cChargeIdr;
  public String chargeamt;
  public String paymentrule;
  public String paymentruler;
  public String cPaymenttermId;
  public String cPaymenttermIdr;
  public String deliveryrule;
  public String deliveryruler;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String totalpaid;
  public String outstandingamt;
  public String discountamt;
  public String writeoffamt;
  public String transactiondate;
  public String schedtransactiondate;
  public String ispaid;
  public String totallines;
  public String grandtotal;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String docstatus;
  public String docstatusr;
  public String posted;
  public String postedBtn;
  public String isgrossinvoice;
  public String cActivityId;
  public String processed;
  public String isselfservice;
  public String taxdate;
  public String cCampaignId;
  public String istaxincluded;
  public String copyfrom;
  public String user1Id;
  public String issotrx;
  public String isdiscountprinted;
  public String btnreinvoiceprojectexpenses;
  public String isprinted;
  public String cWithholdingId;
  public String updatepaymentmonitor;
  public String docaction;
  public String dateprinted;
  public String user2Id;
  public String withholdingamount;
  public String processing;
  public String adOrgtrxId;
  public String dueamt;
  public String cInvoiceId;
  public String aAssetId;
  public String cProjectphaseId;
  public String createfrom;
  public String isactive;
  public String cRefinvoicetoorderViewId;
  public String lastcalculatedondate;
  public String generateto;
  public String ispaymentshedulesummary;
  public String daystilldue;
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
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_id") || fieldName.equals("cDoctypetargetId"))
      return cDoctypetargetId;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_idr") || fieldName.equals("cDoctypetargetIdr"))
      return cDoctypetargetIdr;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("performanceperiodstart"))
      return performanceperiodstart;
    else if (fieldName.equalsIgnoreCase("performanceperiodend"))
      return performanceperiodend;
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
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_idr") || fieldName.equals("mPricelistIdr"))
      return mPricelistIdr;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("c_charge_idr") || fieldName.equals("cChargeIdr"))
      return cChargeIdr;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("paymentruler"))
      return paymentruler;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_idr") || fieldName.equals("cPaymenttermIdr"))
      return cPaymenttermIdr;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("deliveryruler"))
      return deliveryruler;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("totalpaid"))
      return totalpaid;
    else if (fieldName.equalsIgnoreCase("outstandingamt"))
      return outstandingamt;
    else if (fieldName.equalsIgnoreCase("discountamt"))
      return discountamt;
    else if (fieldName.equalsIgnoreCase("writeoffamt"))
      return writeoffamt;
    else if (fieldName.equalsIgnoreCase("transactiondate"))
      return transactiondate;
    else if (fieldName.equalsIgnoreCase("schedtransactiondate"))
      return schedtransactiondate;
    else if (fieldName.equalsIgnoreCase("ispaid"))
      return ispaid;
    else if (fieldName.equalsIgnoreCase("totallines"))
      return totallines;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("posted_btn") || fieldName.equals("postedBtn"))
      return postedBtn;
    else if (fieldName.equalsIgnoreCase("isgrossinvoice"))
      return isgrossinvoice;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("isselfservice"))
      return isselfservice;
    else if (fieldName.equalsIgnoreCase("taxdate"))
      return taxdate;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("istaxincluded"))
      return istaxincluded;
    else if (fieldName.equalsIgnoreCase("copyfrom"))
      return copyfrom;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("isdiscountprinted"))
      return isdiscountprinted;
    else if (fieldName.equalsIgnoreCase("btnreinvoiceprojectexpenses"))
      return btnreinvoiceprojectexpenses;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("c_withholding_id") || fieldName.equals("cWithholdingId"))
      return cWithholdingId;
    else if (fieldName.equalsIgnoreCase("updatepaymentmonitor"))
      return updatepaymentmonitor;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("dateprinted"))
      return dateprinted;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("withholdingamount"))
      return withholdingamount;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("dueamt"))
      return dueamt;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
    else if (fieldName.equalsIgnoreCase("createfrom"))
      return createfrom;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_refinvoicetoorder_view_id") || fieldName.equals("cRefinvoicetoorderViewId"))
      return cRefinvoicetoorderViewId;
    else if (fieldName.equalsIgnoreCase("lastcalculatedondate"))
      return lastcalculatedondate;
    else if (fieldName.equalsIgnoreCase("generateto"))
      return generateto;
    else if (fieldName.equalsIgnoreCase("ispaymentshedulesummary"))
      return ispaymentshedulesummary;
    else if (fieldName.equalsIgnoreCase("daystilldue"))
      return daystilldue;
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
  public static InvoiceOrderReferencingData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static InvoiceOrderReferencingData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_refinvoicetoorder_view.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_refinvoicetoorder_view.CreatedBy) as CreatedByR, " +
      "        to_char(c_refinvoicetoorder_view.Updated, ?) as updated, " +
      "        to_char(c_refinvoicetoorder_view.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_refinvoicetoorder_view.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_refinvoicetoorder_view.UpdatedBy) as UpdatedByR," +
      "        c_refinvoicetoorder_view.AD_Client_ID, " +
      "(CASE WHEN c_refinvoicetoorder_view.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "c_refinvoicetoorder_view.AD_Org_ID, " +
      "(CASE WHEN c_refinvoicetoorder_view.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "c_refinvoicetoorder_view.C_Order_ID, " +
      "(CASE WHEN c_refinvoicetoorder_view.C_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.GrandTotal), ''))),'') ) END) AS C_Order_IDR, " +
      "c_refinvoicetoorder_view.DateOrdered, " +
      "c_refinvoicetoorder_view.DocumentNo, " +
      "c_refinvoicetoorder_view.POReference, " +
      "c_refinvoicetoorder_view.Description, " +
      "c_refinvoicetoorder_view.Internalnote, " +
      "c_refinvoicetoorder_view.C_DocTypeTarget_ID, " +
      "(CASE WHEN c_refinvoicetoorder_view.C_DocTypeTarget_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS C_DocTypeTarget_IDR, " +
      "c_refinvoicetoorder_view.DateInvoiced, " +
      "c_refinvoicetoorder_view.DateAcct, " +
      "c_refinvoicetoorder_view.performanceperiodstart, " +
      "c_refinvoicetoorder_view.performanceperiodend, " +
      "c_refinvoicetoorder_view.C_BPartner_ID, " +
      "(CASE WHEN c_refinvoicetoorder_view.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "c_refinvoicetoorder_view.C_BPartner_Location_ID, " +
      "(CASE WHEN c_refinvoicetoorder_view.C_BPartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_BPartner_Location_IDR, " +
      "c_refinvoicetoorder_view.AD_User_ID, " +
      "(CASE WHEN c_refinvoicetoorder_view.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "c_refinvoicetoorder_view.M_PriceList_ID, " +
      "(CASE WHEN c_refinvoicetoorder_view.M_PriceList_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS M_PriceList_IDR, " +
      "c_refinvoicetoorder_view.C_Currency_ID, " +
      "(CASE WHEN c_refinvoicetoorder_view.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "c_refinvoicetoorder_view.SalesRep_ID, " +
      "(CASE WHEN c_refinvoicetoorder_view.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "c_refinvoicetoorder_view.C_Charge_ID, " +
      "(CASE WHEN c_refinvoicetoorder_view.C_Charge_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS C_Charge_IDR, " +
      "c_refinvoicetoorder_view.ChargeAmt, " +
      "c_refinvoicetoorder_view.PaymentRule, " +
      "(CASE WHEN c_refinvoicetoorder_view.PaymentRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS PaymentRuleR, " +
      "c_refinvoicetoorder_view.C_PaymentTerm_ID, " +
      "(CASE WHEN c_refinvoicetoorder_view.C_PaymentTerm_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL12.Name IS NULL THEN TO_CHAR(table12.Name) ELSE TO_CHAR(tableTRL12.Name) END)), ''))),'') ) END) AS C_PaymentTerm_IDR, " +
      "c_refinvoicetoorder_view.Deliveryrule, " +
      "(CASE WHEN c_refinvoicetoorder_view.Deliveryrule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS DeliveryruleR, " +
      "c_refinvoicetoorder_view.C_Project_ID, " +
      "(CASE WHEN c_refinvoicetoorder_view.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "c_refinvoicetoorder_view.C_Projecttask_ID, " +
      "(CASE WHEN c_refinvoicetoorder_view.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "c_refinvoicetoorder_view.Totalpaid, " +
      "c_refinvoicetoorder_view.OutstandingAmt, " +
      "c_refinvoicetoorder_view.Discountamt, " +
      "c_refinvoicetoorder_view.Writeoffamt, " +
      "c_refinvoicetoorder_view.Transactiondate, " +
      "c_refinvoicetoorder_view.Schedtransactiondate, " +
      "COALESCE(c_refinvoicetoorder_view.Ispaid, 'N') AS Ispaid, " +
      "c_refinvoicetoorder_view.TotalLines, " +
      "c_refinvoicetoorder_view.GrandTotal, " +
      "c_refinvoicetoorder_view.C_DocType_ID, " +
      "(CASE WHEN c_refinvoicetoorder_view.C_DocType_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL16.Name IS NULL THEN TO_CHAR(table16.Name) ELSE TO_CHAR(tableTRL16.Name) END)), ''))),'') ) END) AS C_DocType_IDR, " +
      "c_refinvoicetoorder_view.DocStatus, " +
      "(CASE WHEN c_refinvoicetoorder_view.DocStatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS DocStatusR, " +
      "c_refinvoicetoorder_view.Posted, " +
      "list4.name as Posted_BTN, " +
      "COALESCE(c_refinvoicetoorder_view.Isgrossinvoice, 'N') AS Isgrossinvoice, " +
      "c_refinvoicetoorder_view.C_Activity_ID, " +
      "COALESCE(c_refinvoicetoorder_view.Processed, 'N') AS Processed, " +
      "COALESCE(c_refinvoicetoorder_view.IsSelfService, 'N') AS IsSelfService, " +
      "c_refinvoicetoorder_view.Taxdate, " +
      "c_refinvoicetoorder_view.C_Campaign_ID, " +
      "COALESCE(c_refinvoicetoorder_view.IsTaxIncluded, 'N') AS IsTaxIncluded, " +
      "c_refinvoicetoorder_view.CopyFrom, " +
      "c_refinvoicetoorder_view.User1_ID, " +
      "COALESCE(c_refinvoicetoorder_view.IsSOTrx, 'N') AS IsSOTrx, " +
      "COALESCE(c_refinvoicetoorder_view.IsDiscountPrinted, 'N') AS IsDiscountPrinted, " +
      "c_refinvoicetoorder_view.Btnreinvoiceprojectexpenses, " +
      "COALESCE(c_refinvoicetoorder_view.IsPrinted, 'N') AS IsPrinted, " +
      "c_refinvoicetoorder_view.C_Withholding_ID, " +
      "c_refinvoicetoorder_view.UpdatePaymentMonitor, " +
      "c_refinvoicetoorder_view.DocAction, " +
      "c_refinvoicetoorder_view.DatePrinted, " +
      "c_refinvoicetoorder_view.User2_ID, " +
      "c_refinvoicetoorder_view.Withholdingamount, " +
      "c_refinvoicetoorder_view.Processing, " +
      "c_refinvoicetoorder_view.AD_OrgTrx_ID, " +
      "c_refinvoicetoorder_view.DueAmt, " +
      "c_refinvoicetoorder_view.C_Invoice_ID, " +
      "c_refinvoicetoorder_view.A_Asset_ID, " +
      "c_refinvoicetoorder_view.C_Projectphase_ID, " +
      "c_refinvoicetoorder_view.CreateFrom, " +
      "COALESCE(c_refinvoicetoorder_view.IsActive, 'N') AS IsActive, " +
      "c_refinvoicetoorder_view.C_Refinvoicetoorder_View_ID, " +
      "c_refinvoicetoorder_view.LastCalculatedOnDate, " +
      "c_refinvoicetoorder_view.GenerateTo, " +
      "COALESCE(c_refinvoicetoorder_view.IsPaymentshedulesummary, 'N') AS IsPaymentshedulesummary, " +
      "c_refinvoicetoorder_view.DaysTillDue, " +
      "        ? AS LANGUAGE " +
      "        FROM c_refinvoicetoorder_view left join (select AD_Client_ID, Name from AD_Client) table1 on (c_refinvoicetoorder_view.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (c_refinvoicetoorder_view.AD_Org_ID = table2.AD_Org_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table3 on (c_refinvoicetoorder_view.C_Order_ID = table3.C_Order_ID) left join (select C_DocType_ID, Name from C_DocType) table4 on (c_refinvoicetoorder_view.C_DocTypeTarget_ID =  table4.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL4 on (table4.C_DocType_ID = tableTRL4.C_DocType_ID and tableTRL4.AD_Language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table5 on (c_refinvoicetoorder_view.C_BPartner_ID = table5.C_BPartner_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table6 on (c_refinvoicetoorder_view.C_BPartner_Location_ID = table6.C_BPartner_Location_ID) left join (select AD_User_ID, Name from AD_User) table7 on (c_refinvoicetoorder_view.AD_User_ID = table7.AD_User_ID) left join (select M_PriceList_ID, Name from M_PriceList) table8 on (c_refinvoicetoorder_view.M_PriceList_ID = table8.M_PriceList_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table9 on (c_refinvoicetoorder_view.C_Currency_ID = table9.C_Currency_ID) left join (select AD_User_ID, Name from AD_User) table10 on (c_refinvoicetoorder_view.SalesRep_ID =  table10.AD_User_ID) left join (select C_Charge_ID, Name from C_Charge) table11 on (c_refinvoicetoorder_view.C_Charge_ID =  table11.C_Charge_ID) left join ad_ref_list_v list1 on (c_refinvoicetoorder_view.PaymentRule = list1.value and list1.ad_reference_id = '195' and list1.ad_language = ?)  left join (select C_PaymentTerm_ID, Name from C_PaymentTerm) table12 on (c_refinvoicetoorder_view.C_PaymentTerm_ID = table12.C_PaymentTerm_ID) left join (select C_PaymentTerm_ID,AD_Language, Name from C_PaymentTerm_TRL) tableTRL12 on (table12.C_PaymentTerm_ID = tableTRL12.C_PaymentTerm_ID and tableTRL12.AD_Language = ?)  left join ad_ref_list_v list2 on (c_refinvoicetoorder_view.Deliveryrule = list2.value and list2.ad_reference_id = '151' and list2.ad_language = ?)  left join (select C_Project_ID, Value, Name from C_Project) table13 on (c_refinvoicetoorder_view.C_Project_ID = table13.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table14 on (c_refinvoicetoorder_view.C_Projecttask_ID = table14.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table15 on (table14.C_Project_ID = table15.C_Project_ID) left join (select C_DocType_ID, Name from C_DocType) table16 on (c_refinvoicetoorder_view.C_DocType_ID = table16.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL16 on (table16.C_DocType_ID = tableTRL16.C_DocType_ID and tableTRL16.AD_Language = ?)  left join ad_ref_list_v list3 on (c_refinvoicetoorder_view.DocStatus = list3.value and list3.ad_reference_id = '131' and list3.ad_language = ?)  left join ad_ref_list_v list4 on (list4.ad_reference_id = '234' and list4.ad_language = ?  AND c_refinvoicetoorder_view.Posted = TO_CHAR(list4.value))" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND c_refinvoicetoorder_view.C_Refinvoicetoorder_View_ID = ? " +
      "        AND c_refinvoicetoorder_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_refinvoicetoorder_view.AD_Org_ID IN (";
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
        InvoiceOrderReferencingData objectInvoiceOrderReferencingData = new InvoiceOrderReferencingData();
        objectInvoiceOrderReferencingData.created = UtilSql.getValue(result, "created");
        objectInvoiceOrderReferencingData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectInvoiceOrderReferencingData.updated = UtilSql.getValue(result, "updated");
        objectInvoiceOrderReferencingData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectInvoiceOrderReferencingData.updatedby = UtilSql.getValue(result, "updatedby");
        objectInvoiceOrderReferencingData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectInvoiceOrderReferencingData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectInvoiceOrderReferencingData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectInvoiceOrderReferencingData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectInvoiceOrderReferencingData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectInvoiceOrderReferencingData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectInvoiceOrderReferencingData.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectInvoiceOrderReferencingData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectInvoiceOrderReferencingData.documentno = UtilSql.getValue(result, "documentno");
        objectInvoiceOrderReferencingData.poreference = UtilSql.getValue(result, "poreference");
        objectInvoiceOrderReferencingData.description = UtilSql.getValue(result, "description");
        objectInvoiceOrderReferencingData.internalnote = UtilSql.getValue(result, "internalnote");
        objectInvoiceOrderReferencingData.cDoctypetargetId = UtilSql.getValue(result, "c_doctypetarget_id");
        objectInvoiceOrderReferencingData.cDoctypetargetIdr = UtilSql.getValue(result, "c_doctypetarget_idr");
        objectInvoiceOrderReferencingData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectInvoiceOrderReferencingData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectInvoiceOrderReferencingData.performanceperiodstart = UtilSql.getDateValue(result, "performanceperiodstart", "dd-MM-yyyy");
        objectInvoiceOrderReferencingData.performanceperiodend = UtilSql.getDateValue(result, "performanceperiodend", "dd-MM-yyyy");
        objectInvoiceOrderReferencingData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectInvoiceOrderReferencingData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectInvoiceOrderReferencingData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectInvoiceOrderReferencingData.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectInvoiceOrderReferencingData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectInvoiceOrderReferencingData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectInvoiceOrderReferencingData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectInvoiceOrderReferencingData.mPricelistIdr = UtilSql.getValue(result, "m_pricelist_idr");
        objectInvoiceOrderReferencingData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectInvoiceOrderReferencingData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectInvoiceOrderReferencingData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectInvoiceOrderReferencingData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectInvoiceOrderReferencingData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectInvoiceOrderReferencingData.cChargeIdr = UtilSql.getValue(result, "c_charge_idr");
        objectInvoiceOrderReferencingData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectInvoiceOrderReferencingData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectInvoiceOrderReferencingData.paymentruler = UtilSql.getValue(result, "paymentruler");
        objectInvoiceOrderReferencingData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectInvoiceOrderReferencingData.cPaymenttermIdr = UtilSql.getValue(result, "c_paymentterm_idr");
        objectInvoiceOrderReferencingData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectInvoiceOrderReferencingData.deliveryruler = UtilSql.getValue(result, "deliveryruler");
        objectInvoiceOrderReferencingData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectInvoiceOrderReferencingData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectInvoiceOrderReferencingData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectInvoiceOrderReferencingData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectInvoiceOrderReferencingData.totalpaid = UtilSql.getValue(result, "totalpaid");
        objectInvoiceOrderReferencingData.outstandingamt = UtilSql.getValue(result, "outstandingamt");
        objectInvoiceOrderReferencingData.discountamt = UtilSql.getValue(result, "discountamt");
        objectInvoiceOrderReferencingData.writeoffamt = UtilSql.getValue(result, "writeoffamt");
        objectInvoiceOrderReferencingData.transactiondate = UtilSql.getDateValue(result, "transactiondate", "dd-MM-yyyy");
        objectInvoiceOrderReferencingData.schedtransactiondate = UtilSql.getDateValue(result, "schedtransactiondate", "dd-MM-yyyy");
        objectInvoiceOrderReferencingData.ispaid = UtilSql.getValue(result, "ispaid");
        objectInvoiceOrderReferencingData.totallines = UtilSql.getValue(result, "totallines");
        objectInvoiceOrderReferencingData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectInvoiceOrderReferencingData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectInvoiceOrderReferencingData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectInvoiceOrderReferencingData.docstatus = UtilSql.getValue(result, "docstatus");
        objectInvoiceOrderReferencingData.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectInvoiceOrderReferencingData.posted = UtilSql.getValue(result, "posted");
        objectInvoiceOrderReferencingData.postedBtn = UtilSql.getValue(result, "posted_btn");
        objectInvoiceOrderReferencingData.isgrossinvoice = UtilSql.getValue(result, "isgrossinvoice");
        objectInvoiceOrderReferencingData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectInvoiceOrderReferencingData.processed = UtilSql.getValue(result, "processed");
        objectInvoiceOrderReferencingData.isselfservice = UtilSql.getValue(result, "isselfservice");
        objectInvoiceOrderReferencingData.taxdate = UtilSql.getDateValue(result, "taxdate", "dd-MM-yyyy");
        objectInvoiceOrderReferencingData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectInvoiceOrderReferencingData.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectInvoiceOrderReferencingData.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectInvoiceOrderReferencingData.user1Id = UtilSql.getValue(result, "user1_id");
        objectInvoiceOrderReferencingData.issotrx = UtilSql.getValue(result, "issotrx");
        objectInvoiceOrderReferencingData.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectInvoiceOrderReferencingData.btnreinvoiceprojectexpenses = UtilSql.getValue(result, "btnreinvoiceprojectexpenses");
        objectInvoiceOrderReferencingData.isprinted = UtilSql.getValue(result, "isprinted");
        objectInvoiceOrderReferencingData.cWithholdingId = UtilSql.getValue(result, "c_withholding_id");
        objectInvoiceOrderReferencingData.updatepaymentmonitor = UtilSql.getValue(result, "updatepaymentmonitor");
        objectInvoiceOrderReferencingData.docaction = UtilSql.getValue(result, "docaction");
        objectInvoiceOrderReferencingData.dateprinted = UtilSql.getDateValue(result, "dateprinted", "dd-MM-yyyy");
        objectInvoiceOrderReferencingData.user2Id = UtilSql.getValue(result, "user2_id");
        objectInvoiceOrderReferencingData.withholdingamount = UtilSql.getValue(result, "withholdingamount");
        objectInvoiceOrderReferencingData.processing = UtilSql.getValue(result, "processing");
        objectInvoiceOrderReferencingData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectInvoiceOrderReferencingData.dueamt = UtilSql.getValue(result, "dueamt");
        objectInvoiceOrderReferencingData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectInvoiceOrderReferencingData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectInvoiceOrderReferencingData.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectInvoiceOrderReferencingData.createfrom = UtilSql.getValue(result, "createfrom");
        objectInvoiceOrderReferencingData.isactive = UtilSql.getValue(result, "isactive");
        objectInvoiceOrderReferencingData.cRefinvoicetoorderViewId = UtilSql.getValue(result, "c_refinvoicetoorder_view_id");
        objectInvoiceOrderReferencingData.lastcalculatedondate = UtilSql.getDateValue(result, "lastcalculatedondate", "dd-MM-yyyy");
        objectInvoiceOrderReferencingData.generateto = UtilSql.getValue(result, "generateto");
        objectInvoiceOrderReferencingData.ispaymentshedulesummary = UtilSql.getValue(result, "ispaymentshedulesummary");
        objectInvoiceOrderReferencingData.daystilldue = UtilSql.getValue(result, "daystilldue");
        objectInvoiceOrderReferencingData.language = UtilSql.getValue(result, "language");
        objectInvoiceOrderReferencingData.adUserClient = "";
        objectInvoiceOrderReferencingData.adOrgClient = "";
        objectInvoiceOrderReferencingData.createdby = "";
        objectInvoiceOrderReferencingData.trBgcolor = "";
        objectInvoiceOrderReferencingData.totalCount = "";
        objectInvoiceOrderReferencingData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInvoiceOrderReferencingData);
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
    InvoiceOrderReferencingData objectInvoiceOrderReferencingData[] = new InvoiceOrderReferencingData[vector.size()];
    vector.copyInto(objectInvoiceOrderReferencingData);
    return(objectInvoiceOrderReferencingData);
  }

/**
Create a registry
 */
  public static InvoiceOrderReferencingData[] set(String cChargeId, String adUserId, String cProjectphaseId, String performanceperiodend, String dateacct, String totallines, String dueamt, String isdiscountprinted, String adOrgtrxId, String cInvoiceId, String btnreinvoiceprojectexpenses, String daystilldue, String aAssetId, String cDoctypetargetId, String copyfrom, String description, String schedtransactiondate, String processing, String updatedby, String updatedbyr, String lastcalculatedondate, String totalpaid, String isprinted, String docstatus, String ispaymentshedulesummary, String adOrgId, String chargeamt, String ispaid, String createdby, String createdbyr, String cActivityId, String salesrepId, String updatepaymentmonitor, String posted, String postedBtn, String adClientId, String issotrx, String created, String processed, String documentno, String internalnote, String cOrderId, String cOrderIdr, String cBpartnerId, String cBpartnerIdr, String isactive, String user1Id, String cProjectId, String cProjectIdr, String cCampaignId, String cBpartnerLocationId, String mPricelistId, String outstandingamt, String taxdate, String cPaymenttermId, String istaxincluded, String deliveryrule, String discountamt, String isgrossinvoice, String grandtotal, String cProjecttaskId, String createfrom, String dateordered, String performanceperiodstart, String writeoffamt, String isselfservice, String cWithholdingId, String user2Id, String cDoctypeId, String generateto, String poreference, String withholdingamount, String transactiondate, String paymentrule, String dateprinted, String docaction, String dateinvoiced, String cCurrencyId, String cRefinvoicetoorderViewId)    throws ServletException {
    InvoiceOrderReferencingData objectInvoiceOrderReferencingData[] = new InvoiceOrderReferencingData[1];
    objectInvoiceOrderReferencingData[0] = new InvoiceOrderReferencingData();
    objectInvoiceOrderReferencingData[0].created = created;
    objectInvoiceOrderReferencingData[0].createdbyr = createdbyr;
    objectInvoiceOrderReferencingData[0].updated = "";
    objectInvoiceOrderReferencingData[0].updatedTimeStamp = "";
    objectInvoiceOrderReferencingData[0].updatedby = updatedby;
    objectInvoiceOrderReferencingData[0].updatedbyr = updatedbyr;
    objectInvoiceOrderReferencingData[0].adClientId = adClientId;
    objectInvoiceOrderReferencingData[0].adClientIdr = "";
    objectInvoiceOrderReferencingData[0].adOrgId = adOrgId;
    objectInvoiceOrderReferencingData[0].adOrgIdr = "";
    objectInvoiceOrderReferencingData[0].cOrderId = cOrderId;
    objectInvoiceOrderReferencingData[0].cOrderIdr = cOrderIdr;
    objectInvoiceOrderReferencingData[0].dateordered = dateordered;
    objectInvoiceOrderReferencingData[0].documentno = documentno;
    objectInvoiceOrderReferencingData[0].poreference = poreference;
    objectInvoiceOrderReferencingData[0].description = description;
    objectInvoiceOrderReferencingData[0].internalnote = internalnote;
    objectInvoiceOrderReferencingData[0].cDoctypetargetId = cDoctypetargetId;
    objectInvoiceOrderReferencingData[0].cDoctypetargetIdr = "";
    objectInvoiceOrderReferencingData[0].dateinvoiced = dateinvoiced;
    objectInvoiceOrderReferencingData[0].dateacct = dateacct;
    objectInvoiceOrderReferencingData[0].performanceperiodstart = performanceperiodstart;
    objectInvoiceOrderReferencingData[0].performanceperiodend = performanceperiodend;
    objectInvoiceOrderReferencingData[0].cBpartnerId = cBpartnerId;
    objectInvoiceOrderReferencingData[0].cBpartnerIdr = cBpartnerIdr;
    objectInvoiceOrderReferencingData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectInvoiceOrderReferencingData[0].cBpartnerLocationIdr = "";
    objectInvoiceOrderReferencingData[0].adUserId = adUserId;
    objectInvoiceOrderReferencingData[0].adUserIdr = "";
    objectInvoiceOrderReferencingData[0].mPricelistId = mPricelistId;
    objectInvoiceOrderReferencingData[0].mPricelistIdr = "";
    objectInvoiceOrderReferencingData[0].cCurrencyId = cCurrencyId;
    objectInvoiceOrderReferencingData[0].cCurrencyIdr = "";
    objectInvoiceOrderReferencingData[0].salesrepId = salesrepId;
    objectInvoiceOrderReferencingData[0].salesrepIdr = "";
    objectInvoiceOrderReferencingData[0].cChargeId = cChargeId;
    objectInvoiceOrderReferencingData[0].cChargeIdr = "";
    objectInvoiceOrderReferencingData[0].chargeamt = chargeamt;
    objectInvoiceOrderReferencingData[0].paymentrule = paymentrule;
    objectInvoiceOrderReferencingData[0].paymentruler = "";
    objectInvoiceOrderReferencingData[0].cPaymenttermId = cPaymenttermId;
    objectInvoiceOrderReferencingData[0].cPaymenttermIdr = "";
    objectInvoiceOrderReferencingData[0].deliveryrule = deliveryrule;
    objectInvoiceOrderReferencingData[0].deliveryruler = "";
    objectInvoiceOrderReferencingData[0].cProjectId = cProjectId;
    objectInvoiceOrderReferencingData[0].cProjectIdr = cProjectIdr;
    objectInvoiceOrderReferencingData[0].cProjecttaskId = cProjecttaskId;
    objectInvoiceOrderReferencingData[0].cProjecttaskIdr = "";
    objectInvoiceOrderReferencingData[0].totalpaid = totalpaid;
    objectInvoiceOrderReferencingData[0].outstandingamt = outstandingamt;
    objectInvoiceOrderReferencingData[0].discountamt = discountamt;
    objectInvoiceOrderReferencingData[0].writeoffamt = writeoffamt;
    objectInvoiceOrderReferencingData[0].transactiondate = transactiondate;
    objectInvoiceOrderReferencingData[0].schedtransactiondate = schedtransactiondate;
    objectInvoiceOrderReferencingData[0].ispaid = ispaid;
    objectInvoiceOrderReferencingData[0].totallines = totallines;
    objectInvoiceOrderReferencingData[0].grandtotal = grandtotal;
    objectInvoiceOrderReferencingData[0].cDoctypeId = cDoctypeId;
    objectInvoiceOrderReferencingData[0].cDoctypeIdr = "";
    objectInvoiceOrderReferencingData[0].docstatus = docstatus;
    objectInvoiceOrderReferencingData[0].docstatusr = "";
    objectInvoiceOrderReferencingData[0].posted = posted;
    objectInvoiceOrderReferencingData[0].postedBtn = postedBtn;
    objectInvoiceOrderReferencingData[0].isgrossinvoice = isgrossinvoice;
    objectInvoiceOrderReferencingData[0].cActivityId = cActivityId;
    objectInvoiceOrderReferencingData[0].processed = processed;
    objectInvoiceOrderReferencingData[0].isselfservice = isselfservice;
    objectInvoiceOrderReferencingData[0].taxdate = taxdate;
    objectInvoiceOrderReferencingData[0].cCampaignId = cCampaignId;
    objectInvoiceOrderReferencingData[0].istaxincluded = istaxincluded;
    objectInvoiceOrderReferencingData[0].copyfrom = copyfrom;
    objectInvoiceOrderReferencingData[0].user1Id = user1Id;
    objectInvoiceOrderReferencingData[0].issotrx = issotrx;
    objectInvoiceOrderReferencingData[0].isdiscountprinted = isdiscountprinted;
    objectInvoiceOrderReferencingData[0].btnreinvoiceprojectexpenses = btnreinvoiceprojectexpenses;
    objectInvoiceOrderReferencingData[0].isprinted = isprinted;
    objectInvoiceOrderReferencingData[0].cWithholdingId = cWithholdingId;
    objectInvoiceOrderReferencingData[0].updatepaymentmonitor = updatepaymentmonitor;
    objectInvoiceOrderReferencingData[0].docaction = docaction;
    objectInvoiceOrderReferencingData[0].dateprinted = dateprinted;
    objectInvoiceOrderReferencingData[0].user2Id = user2Id;
    objectInvoiceOrderReferencingData[0].withholdingamount = withholdingamount;
    objectInvoiceOrderReferencingData[0].processing = processing;
    objectInvoiceOrderReferencingData[0].adOrgtrxId = adOrgtrxId;
    objectInvoiceOrderReferencingData[0].dueamt = dueamt;
    objectInvoiceOrderReferencingData[0].cInvoiceId = cInvoiceId;
    objectInvoiceOrderReferencingData[0].aAssetId = aAssetId;
    objectInvoiceOrderReferencingData[0].cProjectphaseId = cProjectphaseId;
    objectInvoiceOrderReferencingData[0].createfrom = createfrom;
    objectInvoiceOrderReferencingData[0].isactive = isactive;
    objectInvoiceOrderReferencingData[0].cRefinvoicetoorderViewId = cRefinvoicetoorderViewId;
    objectInvoiceOrderReferencingData[0].lastcalculatedondate = lastcalculatedondate;
    objectInvoiceOrderReferencingData[0].generateto = generateto;
    objectInvoiceOrderReferencingData[0].ispaymentshedulesummary = ispaymentshedulesummary;
    objectInvoiceOrderReferencingData[0].daystilldue = daystilldue;
    objectInvoiceOrderReferencingData[0].language = "";
    return objectInvoiceOrderReferencingData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef5EBAFE1E03414A08939695F89ED0DB26_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef2CB02F0F77D044FBA3743BD95C54483B_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef4A11500C72ED4099A0FF8A87D91229E0_2(ConnectionProvider connectionProvider, String C_Order_IDR)    throws ServletException {
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
  public static String selectDefE721F93AFAA747079E24079AC33E829C_3(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
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
  public static String selectDefF4A554245BB440048753705111491FEA_4(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
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
Select for action search
 */
  public static String selectActDefM_Locator_ID(ConnectionProvider connectionProvider, String M_Locator_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT Value FROM M_Locator WHERE isActive='Y' AND M_Locator_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Locator_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "value");
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
  public static String selectActDefC_Invoice_ID(ConnectionProvider connectionProvider, String C_Invoice_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DocumentNo FROM C_Invoice WHERE isActive='Y' AND C_Invoice_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Invoice_ID);

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
      "        UPDATE c_refinvoicetoorder_view" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , C_Order_ID = (?) , DateOrdered = TO_DATE(?) , DocumentNo = (?) , POReference = (?) , Description = (?) , Internalnote = (?) , C_DocTypeTarget_ID = (?) , DateInvoiced = TO_DATE(?) , DateAcct = TO_DATE(?) , performanceperiodstart = TO_DATE(?) , performanceperiodend = TO_DATE(?) , C_BPartner_ID = (?) , C_BPartner_Location_ID = (?) , AD_User_ID = (?) , M_PriceList_ID = (?) , C_Currency_ID = (?) , SalesRep_ID = (?) , C_Charge_ID = (?) , ChargeAmt = TO_NUMBER(?) , PaymentRule = (?) , C_PaymentTerm_ID = (?) , Deliveryrule = (?) , C_Project_ID = (?) , C_Projecttask_ID = (?) , Totalpaid = TO_NUMBER(?) , OutstandingAmt = TO_NUMBER(?) , Discountamt = TO_NUMBER(?) , Writeoffamt = TO_NUMBER(?) , Transactiondate = TO_DATE(?) , Schedtransactiondate = TO_DATE(?) , Ispaid = (?) , TotalLines = TO_NUMBER(?) , GrandTotal = TO_NUMBER(?) , C_DocType_ID = (?) , DocStatus = (?) , Posted = (?) , Isgrossinvoice = (?) , C_Activity_ID = (?) , Processed = (?) , IsSelfService = (?) , Taxdate = TO_DATE(?) , C_Campaign_ID = (?) , IsTaxIncluded = (?) , CopyFrom = (?) , User1_ID = (?) , IsSOTrx = (?) , IsDiscountPrinted = (?) , Btnreinvoiceprojectexpenses = (?) , IsPrinted = (?) , C_Withholding_ID = (?) , UpdatePaymentMonitor = (?) , DocAction = (?) , DatePrinted = TO_DATE(?) , User2_ID = (?) , Withholdingamount = TO_NUMBER(?) , Processing = (?) , AD_OrgTrx_ID = (?) , DueAmt = TO_NUMBER(?) , A_Asset_ID = (?) , C_Invoice_ID = (?) , C_Projectphase_ID = (?) , CreateFrom = (?) , IsActive = (?) , C_Refinvoicetoorder_View_ID = (?) , GenerateTo = (?) , LastCalculatedOnDate = TO_DATE(?) , IsPaymentshedulesummary = (?) , DaysTillDue = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE c_refinvoicetoorder_view.C_Refinvoicetoorder_View_ID = ? " +
      "        AND c_refinvoicetoorder_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_refinvoicetoorder_view.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, performanceperiodstart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, performanceperiodend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totalpaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, outstandingamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discountamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, writeoffamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedtransactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isgrossinvoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselfservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, btnreinvoiceprojectexpenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cWithholdingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatepaymentmonitor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, withholdingamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRefinvoicetoorderViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastcalculatedondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaymentshedulesummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, daystilldue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRefinvoicetoorderViewId);
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
      "        INSERT INTO c_refinvoicetoorder_view " +
      "        (AD_Client_ID, AD_Org_ID, C_Order_ID, DateOrdered, DocumentNo, POReference, Description, Internalnote, C_DocTypeTarget_ID, DateInvoiced, DateAcct, performanceperiodstart, performanceperiodend, C_BPartner_ID, C_BPartner_Location_ID, AD_User_ID, M_PriceList_ID, C_Currency_ID, SalesRep_ID, C_Charge_ID, ChargeAmt, PaymentRule, C_PaymentTerm_ID, Deliveryrule, C_Project_ID, C_Projecttask_ID, Totalpaid, OutstandingAmt, Discountamt, Writeoffamt, Transactiondate, Schedtransactiondate, Ispaid, TotalLines, GrandTotal, C_DocType_ID, DocStatus, Posted, Isgrossinvoice, C_Activity_ID, Processed, IsSelfService, Taxdate, C_Campaign_ID, IsTaxIncluded, CopyFrom, User1_ID, IsSOTrx, IsDiscountPrinted, Btnreinvoiceprojectexpenses, IsPrinted, C_Withholding_ID, UpdatePaymentMonitor, DocAction, DatePrinted, User2_ID, Withholdingamount, Processing, AD_OrgTrx_ID, DueAmt, C_Invoice_ID, A_Asset_ID, C_Projectphase_ID, CreateFrom, IsActive, C_Refinvoicetoorder_View_ID, LastCalculatedOnDate, GenerateTo, IsPaymentshedulesummary, DaysTillDue, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), TO_DATE(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), TO_NUMBER(?), now(), ?, now(), ?)";

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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, performanceperiodstart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, performanceperiodend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totalpaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, outstandingamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discountamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, writeoffamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedtransactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isgrossinvoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselfservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, btnreinvoiceprojectexpenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cWithholdingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatepaymentmonitor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, withholdingamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRefinvoicetoorderViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastcalculatedondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaymentshedulesummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, daystilldue);
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
      "        DELETE FROM c_refinvoicetoorder_view" +
      "        WHERE c_refinvoicetoorder_view.C_Refinvoicetoorder_View_ID = ? " +
      "        AND c_refinvoicetoorder_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_refinvoicetoorder_view.AD_Org_ID IN (";
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
      "        DELETE FROM c_refinvoicetoorder_view" +
      "        WHERE c_refinvoicetoorder_view.C_Refinvoicetoorder_View_ID = ? ";

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
      "          FROM c_refinvoicetoorder_view" +
      "         WHERE c_refinvoicetoorder_view.C_Refinvoicetoorder_View_ID = ? ";

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
      "          FROM c_refinvoicetoorder_view" +
      "         WHERE c_refinvoicetoorder_view.C_Refinvoicetoorder_View_ID = ? ";

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
