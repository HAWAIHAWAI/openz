//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.BusinessPartner;

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
class InvoicesB621440747FD4131A2A46A442E55F439Data implements FieldProvider {
static Logger log4j = Logger.getLogger(InvoicesB621440747FD4131A2A46A442E55F439Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String copyfrom;
  public String adOrgtrxId;
  public String user1Id;
  public String user2Id;
  public String documentno;
  public String dateinvoiced;
  public String ispaid;
  public String grandtotal;
  public String totallines;
  public String outstandingamt;
  public String totalpaid;
  public String dueamt;
  public String daystilldue;
  public String writeoffamt;
  public String adOrgId;
  public String discountamt;
  public String updatepaymentmonitor;
  public String paymentrule;
  public String paymentruler;
  public String lastcalculatedondate;
  public String cChargeId;
  public String cChargeIdr;
  public String chargeamt;
  public String isgrossinvoice;
  public String poreference;
  public String salesrepId;
  public String salesrepIdr;
  public String adUserId;
  public String adUserIdr;
  public String cActivityId;
  public String cActivityIdr;
  public String cProjectId;
  public String cProjectIdr;
  public String cCampaignId;
  public String cCampaignIdr;
  public String dateacct;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String cPaymenttermId;
  public String cPaymenttermIdr;
  public String cOrderId;
  public String cOrderIdr;
  public String dateprinted;
  public String description;
  public String cDoctypetargetId;
  public String issotrx;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String docstatus;
  public String docstatusr;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String isactive;
  public String cBpartnerId;
  public String taxdate;
  public String dateordered;
  public String generateto;
  public String createfrom;
  public String isprinted;
  public String processing;
  public String posted;
  public String adClientId;
  public String istaxincluded;
  public String cInvoiceId;
  public String isdiscountprinted;
  public String processed;
  public String mPricelistId;
  public String docaction;
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
    else if (fieldName.equalsIgnoreCase("copyfrom"))
      return copyfrom;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("ispaid"))
      return ispaid;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("totallines"))
      return totallines;
    else if (fieldName.equalsIgnoreCase("outstandingamt"))
      return outstandingamt;
    else if (fieldName.equalsIgnoreCase("totalpaid"))
      return totalpaid;
    else if (fieldName.equalsIgnoreCase("dueamt"))
      return dueamt;
    else if (fieldName.equalsIgnoreCase("daystilldue"))
      return daystilldue;
    else if (fieldName.equalsIgnoreCase("writeoffamt"))
      return writeoffamt;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("discountamt"))
      return discountamt;
    else if (fieldName.equalsIgnoreCase("updatepaymentmonitor"))
      return updatepaymentmonitor;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("paymentruler"))
      return paymentruler;
    else if (fieldName.equalsIgnoreCase("lastcalculatedondate"))
      return lastcalculatedondate;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("c_charge_idr") || fieldName.equals("cChargeIdr"))
      return cChargeIdr;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("isgrossinvoice"))
      return isgrossinvoice;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("c_activity_idr") || fieldName.equals("cActivityIdr"))
      return cActivityIdr;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_campaign_idr") || fieldName.equals("cCampaignIdr"))
      return cCampaignIdr;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_idr") || fieldName.equals("cPaymenttermIdr"))
      return cPaymenttermIdr;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_order_idr") || fieldName.equals("cOrderIdr"))
      return cOrderIdr;
    else if (fieldName.equalsIgnoreCase("dateprinted"))
      return dateprinted;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_id") || fieldName.equals("cDoctypetargetId"))
      return cDoctypetargetId;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("taxdate"))
      return taxdate;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("generateto"))
      return generateto;
    else if (fieldName.equalsIgnoreCase("createfrom"))
      return createfrom;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("istaxincluded"))
      return istaxincluded;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("isdiscountprinted"))
      return isdiscountprinted;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
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
  public static InvoicesB621440747FD4131A2A46A442E55F439Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cBpartnerId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static InvoicesB621440747FD4131A2A46A442E55F439Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Invoice.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Invoice.CreatedBy) as CreatedByR, " +
      "        to_char(C_Invoice.Updated, ?) as updated, " +
      "        to_char(C_Invoice.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Invoice.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Invoice.UpdatedBy) as UpdatedByR," +
      "        C_Invoice.CopyFrom, " +
      "C_Invoice.AD_OrgTrx_ID, " +
      "C_Invoice.User1_ID, " +
      "C_Invoice.User2_ID, " +
      "C_Invoice.DocumentNo, " +
      "C_Invoice.DateInvoiced, " +
      "COALESCE(C_Invoice.IsPaid, 'N') AS IsPaid, " +
      "C_Invoice.GrandTotal, " +
      "C_Invoice.TotalLines, " +
      "C_Invoice.OutstandingAmt, " +
      "C_Invoice.TotalPaid, " +
      "C_Invoice.DueAmt, " +
      "C_Invoice.DaysTillDue, " +
      "C_Invoice.Writeoffamt, " +
      "C_Invoice.AD_Org_ID, " +
      "C_Invoice.Discountamt, " +
      "C_Invoice.UpdatePaymentMonitor, " +
      "C_Invoice.PaymentRule, " +
      "(CASE WHEN C_Invoice.PaymentRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS PaymentRuleR, " +
      "C_Invoice.LastCalculatedOnDate, " +
      "C_Invoice.C_Charge_ID, " +
      "(CASE WHEN C_Invoice.C_Charge_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_Charge_IDR, " +
      "C_Invoice.ChargeAmt, " +
      "COALESCE(C_Invoice.IsGrossInvoice, 'N') AS IsGrossInvoice, " +
      "C_Invoice.POReference, " +
      "C_Invoice.SalesRep_ID, " +
      "(CASE WHEN C_Invoice.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "C_Invoice.AD_User_ID, " +
      "(CASE WHEN C_Invoice.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "C_Invoice.C_Activity_ID, " +
      "(CASE WHEN C_Invoice.C_Activity_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Activity_IDR, " +
      "C_Invoice.C_Project_ID, " +
      "(CASE WHEN C_Invoice.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "C_Invoice.C_Campaign_ID, " +
      "(CASE WHEN C_Invoice.C_Campaign_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_Campaign_IDR, " +
      "C_Invoice.DateAcct, " +
      "C_Invoice.C_BPartner_Location_ID, " +
      "(CASE WHEN C_Invoice.C_BPartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_BPartner_Location_IDR, " +
      "C_Invoice.C_PaymentTerm_ID, " +
      "(CASE WHEN C_Invoice.C_PaymentTerm_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL8.Name IS NULL THEN TO_CHAR(table8.Name) ELSE TO_CHAR(tableTRL8.Name) END)), ''))),'') ) END) AS C_PaymentTerm_IDR, " +
      "C_Invoice.C_Order_ID, " +
      "(CASE WHEN C_Invoice.C_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table9.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.GrandTotal), ''))),'') ) END) AS C_Order_IDR, " +
      "C_Invoice.DatePrinted, " +
      "C_Invoice.Description, " +
      "C_Invoice.C_DocTypeTarget_ID, " +
      "COALESCE(C_Invoice.IsSOTrx, 'N') AS IsSOTrx, " +
      "C_Invoice.C_Currency_ID, " +
      "(CASE WHEN C_Invoice.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "C_Invoice.DocStatus, " +
      "(CASE WHEN C_Invoice.DocStatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS DocStatusR, " +
      "C_Invoice.C_DocType_ID, " +
      "(CASE WHEN C_Invoice.C_DocType_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL11.Name IS NULL THEN TO_CHAR(table11.Name) ELSE TO_CHAR(tableTRL11.Name) END)), ''))),'') ) END) AS C_DocType_IDR, " +
      "COALESCE(C_Invoice.IsActive, 'N') AS IsActive, " +
      "C_Invoice.C_BPartner_ID, " +
      "C_Invoice.Taxdate, " +
      "C_Invoice.DateOrdered, " +
      "C_Invoice.GenerateTo, " +
      "C_Invoice.CreateFrom, " +
      "COALESCE(C_Invoice.IsPrinted, 'N') AS IsPrinted, " +
      "C_Invoice.Processing, " +
      "C_Invoice.Posted, " +
      "C_Invoice.AD_Client_ID, " +
      "COALESCE(C_Invoice.IsTaxIncluded, 'N') AS IsTaxIncluded, " +
      "C_Invoice.C_Invoice_ID, " +
      "COALESCE(C_Invoice.IsDiscountPrinted, 'N') AS IsDiscountPrinted, " +
      "COALESCE(C_Invoice.Processed, 'N') AS Processed, " +
      "C_Invoice.M_PriceList_ID, " +
      "C_Invoice.DocAction, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Invoice left join ad_ref_list_v list1 on (C_Invoice.PaymentRule = list1.value and list1.ad_reference_id = '195' and list1.ad_language = ?)  left join (select C_Charge_ID, Name from C_Charge) table1 on (C_Invoice.C_Charge_ID =  table1.C_Charge_ID) left join (select AD_User_ID, Name from AD_User) table2 on (C_Invoice.SalesRep_ID =  table2.AD_User_ID) left join (select AD_User_ID, Name from AD_User) table3 on (C_Invoice.AD_User_ID = table3.AD_User_ID) left join (select C_Activity_ID, Name from C_Activity) table4 on (C_Invoice.C_Activity_ID = table4.C_Activity_ID) left join (select C_Project_ID, Value, Name from C_Project) table5 on (C_Invoice.C_Project_ID = table5.C_Project_ID) left join (select C_Campaign_ID, Name from C_Campaign) table6 on (C_Invoice.C_Campaign_ID = table6.C_Campaign_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table7 on (C_Invoice.C_BPartner_Location_ID = table7.C_BPartner_Location_ID) left join (select C_PaymentTerm_ID, Name from C_PaymentTerm) table8 on (C_Invoice.C_PaymentTerm_ID = table8.C_PaymentTerm_ID) left join (select C_PaymentTerm_ID,AD_Language, Name from C_PaymentTerm_TRL) tableTRL8 on (table8.C_PaymentTerm_ID = tableTRL8.C_PaymentTerm_ID and tableTRL8.AD_Language = ?)  left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table9 on (C_Invoice.C_Order_ID = table9.C_Order_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table10 on (C_Invoice.C_Currency_ID = table10.C_Currency_ID) left join ad_ref_list_v list2 on (C_Invoice.DocStatus = list2.value and list2.ad_reference_id = '131' and list2.ad_language = ?)  left join (select C_DocType_ID, Name from C_DocType) table11 on (C_Invoice.C_DocType_ID = table11.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL11 on (table11.C_DocType_ID = tableTRL11.C_DocType_ID and tableTRL11.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_Invoice.C_BPartner_ID = ?  ");
    strSql = strSql + 
      "        AND C_Invoice.C_Invoice_ID = ? " +
      "        AND C_Invoice.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Invoice.AD_Org_ID IN (";
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
        InvoicesB621440747FD4131A2A46A442E55F439Data objectInvoicesB621440747FD4131A2A46A442E55F439Data = new InvoicesB621440747FD4131A2A46A442E55F439Data();
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.created = UtilSql.getValue(result, "created");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.updated = UtilSql.getValue(result, "updated");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.user1Id = UtilSql.getValue(result, "user1_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.user2Id = UtilSql.getValue(result, "user2_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.documentno = UtilSql.getValue(result, "documentno");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.ispaid = UtilSql.getValue(result, "ispaid");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.totallines = UtilSql.getValue(result, "totallines");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.outstandingamt = UtilSql.getValue(result, "outstandingamt");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.totalpaid = UtilSql.getValue(result, "totalpaid");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.dueamt = UtilSql.getValue(result, "dueamt");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.daystilldue = UtilSql.getValue(result, "daystilldue");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.writeoffamt = UtilSql.getValue(result, "writeoffamt");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.discountamt = UtilSql.getValue(result, "discountamt");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.updatepaymentmonitor = UtilSql.getValue(result, "updatepaymentmonitor");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.paymentruler = UtilSql.getValue(result, "paymentruler");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.lastcalculatedondate = UtilSql.getDateValue(result, "lastcalculatedondate", "dd-MM-yyyy");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cChargeIdr = UtilSql.getValue(result, "c_charge_idr");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.isgrossinvoice = UtilSql.getValue(result, "isgrossinvoice");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.poreference = UtilSql.getValue(result, "poreference");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cActivityIdr = UtilSql.getValue(result, "c_activity_idr");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cCampaignIdr = UtilSql.getValue(result, "c_campaign_idr");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cPaymenttermIdr = UtilSql.getValue(result, "c_paymentterm_idr");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.dateprinted = UtilSql.getDateValue(result, "dateprinted", "dd-MM-yyyy");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.description = UtilSql.getValue(result, "description");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cDoctypetargetId = UtilSql.getValue(result, "c_doctypetarget_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.issotrx = UtilSql.getValue(result, "issotrx");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.docstatus = UtilSql.getValue(result, "docstatus");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.isactive = UtilSql.getValue(result, "isactive");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.taxdate = UtilSql.getDateValue(result, "taxdate", "dd-MM-yyyy");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.generateto = UtilSql.getValue(result, "generateto");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.createfrom = UtilSql.getValue(result, "createfrom");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.isprinted = UtilSql.getValue(result, "isprinted");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.processing = UtilSql.getValue(result, "processing");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.posted = UtilSql.getValue(result, "posted");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.processed = UtilSql.getValue(result, "processed");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.docaction = UtilSql.getValue(result, "docaction");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.language = UtilSql.getValue(result, "language");
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.adUserClient = "";
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.adOrgClient = "";
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.createdby = "";
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.trBgcolor = "";
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.totalCount = "";
        objectInvoicesB621440747FD4131A2A46A442E55F439Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInvoicesB621440747FD4131A2A46A442E55F439Data);
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
    InvoicesB621440747FD4131A2A46A442E55F439Data objectInvoicesB621440747FD4131A2A46A442E55F439Data[] = new InvoicesB621440747FD4131A2A46A442E55F439Data[vector.size()];
    vector.copyInto(objectInvoicesB621440747FD4131A2A46A442E55F439Data);
    return(objectInvoicesB621440747FD4131A2A46A442E55F439Data);
  }

/**
Create a registry
 */
  public static InvoicesB621440747FD4131A2A46A442E55F439Data[] set(String cBpartnerId, String isgrossinvoice, String issotrx, String user1Id, String createfrom, String cActivityId, String cPaymenttermId, String totallines, String salesrepId, String createdby, String createdbyr, String adOrgtrxId, String cInvoiceId, String dateprinted, String discountamt, String adClientId, String dateinvoiced, String istaxincluded, String mPricelistId, String processing, String description, String cProjectId, String cProjectIdr, String docaction, String isprinted, String dateordered, String chargeamt, String dateacct, String isdiscountprinted, String docstatus, String outstandingamt, String cCurrencyId, String taxdate, String cBpartnerLocationId, String adUserId, String ispaid, String posted, String user2Id, String lastcalculatedondate, String grandtotal, String totalpaid, String poreference, String updatepaymentmonitor, String copyfrom, String cDoctypetargetId, String isactive, String paymentrule, String generateto, String updatedby, String updatedbyr, String processed, String cDoctypeId, String daystilldue, String cChargeId, String cCampaignId, String documentno, String writeoffamt, String dueamt, String adOrgId, String cOrderId)    throws ServletException {
    InvoicesB621440747FD4131A2A46A442E55F439Data objectInvoicesB621440747FD4131A2A46A442E55F439Data[] = new InvoicesB621440747FD4131A2A46A442E55F439Data[1];
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0] = new InvoicesB621440747FD4131A2A46A442E55F439Data();
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].created = "";
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].createdbyr = createdbyr;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].updated = "";
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].updatedTimeStamp = "";
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].updatedby = updatedby;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].updatedbyr = updatedbyr;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].copyfrom = copyfrom;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].adOrgtrxId = adOrgtrxId;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].user1Id = user1Id;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].user2Id = user2Id;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].documentno = documentno;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].dateinvoiced = dateinvoiced;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].ispaid = ispaid;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].grandtotal = grandtotal;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].totallines = totallines;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].outstandingamt = outstandingamt;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].totalpaid = totalpaid;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].dueamt = dueamt;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].daystilldue = daystilldue;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].writeoffamt = writeoffamt;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].adOrgId = adOrgId;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].discountamt = discountamt;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].updatepaymentmonitor = updatepaymentmonitor;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].paymentrule = paymentrule;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].paymentruler = "";
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].lastcalculatedondate = lastcalculatedondate;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cChargeId = cChargeId;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cChargeIdr = "";
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].chargeamt = chargeamt;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].isgrossinvoice = isgrossinvoice;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].poreference = poreference;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].salesrepId = salesrepId;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].salesrepIdr = "";
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].adUserId = adUserId;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].adUserIdr = "";
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cActivityId = cActivityId;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cActivityIdr = "";
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cProjectId = cProjectId;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cProjectIdr = cProjectIdr;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cCampaignId = cCampaignId;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cCampaignIdr = "";
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].dateacct = dateacct;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cBpartnerLocationId = cBpartnerLocationId;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cBpartnerLocationIdr = "";
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cPaymenttermId = cPaymenttermId;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cPaymenttermIdr = "";
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cOrderId = cOrderId;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cOrderIdr = "";
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].dateprinted = dateprinted;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].description = description;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cDoctypetargetId = cDoctypetargetId;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].issotrx = issotrx;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cCurrencyId = cCurrencyId;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cCurrencyIdr = "";
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].docstatus = docstatus;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].docstatusr = "";
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cDoctypeId = cDoctypeId;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cDoctypeIdr = "";
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].isactive = isactive;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cBpartnerId = cBpartnerId;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].taxdate = taxdate;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].dateordered = dateordered;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].generateto = generateto;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].createfrom = createfrom;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].isprinted = isprinted;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].processing = processing;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].posted = posted;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].adClientId = adClientId;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].istaxincluded = istaxincluded;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].cInvoiceId = cInvoiceId;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].isdiscountprinted = isdiscountprinted;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].processed = processed;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].mPricelistId = mPricelistId;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].docaction = docaction;
    objectInvoicesB621440747FD4131A2A46A442E55F439Data[0].language = "";
    return objectInvoicesB621440747FD4131A2A46A442E55F439Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef3489_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef3510_1(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
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
  public static String selectDef3491_2(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
      "        SELECT C_Invoice.C_BPartner_ID AS NAME" +
      "        FROM C_Invoice" +
      "        WHERE C_Invoice.C_Invoice_ID = ?";

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
      "        UPDATE C_Invoice" +
      "        SET CopyFrom = (?) , AD_OrgTrx_ID = (?) , User1_ID = (?) , User2_ID = (?) , DocumentNo = (?) , DateInvoiced = TO_DATE(?) , IsPaid = (?) , GrandTotal = TO_NUMBER(?) , TotalLines = TO_NUMBER(?) , OutstandingAmt = TO_NUMBER(?) , TotalPaid = TO_NUMBER(?) , DueAmt = TO_NUMBER(?) , DaysTillDue = TO_NUMBER(?) , Writeoffamt = TO_NUMBER(?) , AD_Org_ID = (?) , Discountamt = TO_NUMBER(?) , UpdatePaymentMonitor = (?) , PaymentRule = (?) , LastCalculatedOnDate = TO_DATE(?) , C_Charge_ID = (?) , ChargeAmt = TO_NUMBER(?) , IsGrossInvoice = (?) , POReference = (?) , SalesRep_ID = (?) , AD_User_ID = (?) , C_Activity_ID = (?) , C_Project_ID = (?) , C_Campaign_ID = (?) , DateAcct = TO_DATE(?) , C_BPartner_Location_ID = (?) , C_PaymentTerm_ID = (?) , C_Order_ID = (?) , DatePrinted = TO_DATE(?) , Description = (?) , C_DocTypeTarget_ID = (?) , IsSOTrx = (?) , C_Currency_ID = (?) , DocStatus = (?) , C_DocType_ID = (?) , IsActive = (?) , C_BPartner_ID = (?) , Taxdate = TO_DATE(?) , DateOrdered = TO_DATE(?) , GenerateTo = (?) , CreateFrom = (?) , IsPrinted = (?) , Processing = (?) , Posted = (?) , AD_Client_ID = (?) , IsTaxIncluded = (?) , C_Invoice_ID = (?) , IsDiscountPrinted = (?) , Processed = (?) , M_PriceList_ID = (?) , DocAction = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Invoice.C_Invoice_ID = ? " +
      "                 AND C_Invoice.C_BPartner_ID = ? " +
      "        AND C_Invoice.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Invoice.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, outstandingamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totalpaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, daystilldue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, writeoffamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discountamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatepaymentmonitor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastcalculatedondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isgrossinvoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
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
      "        INSERT INTO C_Invoice " +
      "        (CopyFrom, AD_OrgTrx_ID, User1_ID, User2_ID, DocumentNo, DateInvoiced, IsPaid, GrandTotal, TotalLines, OutstandingAmt, TotalPaid, DueAmt, DaysTillDue, Writeoffamt, AD_Org_ID, Discountamt, UpdatePaymentMonitor, PaymentRule, LastCalculatedOnDate, C_Charge_ID, ChargeAmt, IsGrossInvoice, POReference, SalesRep_ID, AD_User_ID, C_Activity_ID, C_Project_ID, C_Campaign_ID, DateAcct, C_BPartner_Location_ID, C_PaymentTerm_ID, C_Order_ID, DatePrinted, Description, C_DocTypeTarget_ID, IsSOTrx, C_Currency_ID, DocStatus, C_DocType_ID, IsActive, C_BPartner_ID, Taxdate, DateOrdered, GenerateTo, CreateFrom, IsPrinted, Processing, Posted, AD_Client_ID, IsTaxIncluded, C_Invoice_ID, IsDiscountPrinted, Processed, M_PriceList_ID, DocAction, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_DATE(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), TO_DATE(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, outstandingamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totalpaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, daystilldue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, writeoffamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discountamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatepaymentmonitor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastcalculatedondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isgrossinvoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
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
      "        DELETE FROM C_Invoice" +
      "        WHERE C_Invoice.C_Invoice_ID = ? " +
      "                 AND C_Invoice.C_BPartner_ID = ? " +
      "        AND C_Invoice.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Invoice.AD_Org_ID IN (";
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
      "        DELETE FROM C_Invoice" +
      "        WHERE C_Invoice.C_Invoice_ID = ? " +
      "                 AND C_Invoice.C_BPartner_ID = ? ";

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
      "          FROM C_Invoice" +
      "         WHERE C_Invoice.C_Invoice_ID = ? ";

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
      "          FROM C_Invoice" +
      "         WHERE C_Invoice.C_Invoice_ID = ? ";

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
