//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.PurchaseInvoice;

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
class PaymentData implements FieldProvider {
static Logger log4j = Logger.getLogger(PaymentData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String isreceipt;
  public String amount;
  public String cDebtPaymentId;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String writeoffamt;
  public String isactive;
  public String discountamt;
  public String ispaid;
  public String isapproved;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cInvoiceId;
  public String cInvoiceIdr;
  public String cSettlementCancelId;
  public String cSettlementCancelIdr;
  public String cSettlementGenerateId;
  public String paymentrule;
  public String paymentruler;
  public String dateplanned;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String description;
  public String cCashbookId;
  public String cCashbookIdr;
  public String cCashlineId;
  public String cCashlineIdr;
  public String cBankaccountId;
  public String cBankaccountIdr;
  public String cBankstatementlineId;
  public String cBankstatementlineIdr;
  public String ismanual;
  public String isvalid;
  public String changesettlementcancel;
  public String cancelProcessed;
  public String generateProcessed;
  public String glitemamt;
  public String isdirectposting;
  public String cGlitemId;
  public String status;
  public String cProjectId;
  public String statusInitial;
  public String cOrderId;
  public String isautomaticgenerated;
  public String cWithholdingId;
  public String withholdingamount;
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
    else if (fieldName.equalsIgnoreCase("isreceipt"))
      return isreceipt;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("c_debt_payment_id") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("writeoffamt"))
      return writeoffamt;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("discountamt"))
      return discountamt;
    else if (fieldName.equalsIgnoreCase("ispaid"))
      return ispaid;
    else if (fieldName.equalsIgnoreCase("isapproved"))
      return isapproved;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("c_invoice_idr") || fieldName.equals("cInvoiceIdr"))
      return cInvoiceIdr;
    else if (fieldName.equalsIgnoreCase("c_settlement_cancel_id") || fieldName.equals("cSettlementCancelId"))
      return cSettlementCancelId;
    else if (fieldName.equalsIgnoreCase("c_settlement_cancel_idr") || fieldName.equals("cSettlementCancelIdr"))
      return cSettlementCancelIdr;
    else if (fieldName.equalsIgnoreCase("c_settlement_generate_id") || fieldName.equals("cSettlementGenerateId"))
      return cSettlementGenerateId;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("paymentruler"))
      return paymentruler;
    else if (fieldName.equalsIgnoreCase("dateplanned"))
      return dateplanned;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_cashbook_id") || fieldName.equals("cCashbookId"))
      return cCashbookId;
    else if (fieldName.equalsIgnoreCase("c_cashbook_idr") || fieldName.equals("cCashbookIdr"))
      return cCashbookIdr;
    else if (fieldName.equalsIgnoreCase("c_cashline_id") || fieldName.equals("cCashlineId"))
      return cCashlineId;
    else if (fieldName.equalsIgnoreCase("c_cashline_idr") || fieldName.equals("cCashlineIdr"))
      return cCashlineIdr;
    else if (fieldName.equalsIgnoreCase("c_bankaccount_id") || fieldName.equals("cBankaccountId"))
      return cBankaccountId;
    else if (fieldName.equalsIgnoreCase("c_bankaccount_idr") || fieldName.equals("cBankaccountIdr"))
      return cBankaccountIdr;
    else if (fieldName.equalsIgnoreCase("c_bankstatementline_id") || fieldName.equals("cBankstatementlineId"))
      return cBankstatementlineId;
    else if (fieldName.equalsIgnoreCase("c_bankstatementline_idr") || fieldName.equals("cBankstatementlineIdr"))
      return cBankstatementlineIdr;
    else if (fieldName.equalsIgnoreCase("ismanual"))
      return ismanual;
    else if (fieldName.equalsIgnoreCase("isvalid"))
      return isvalid;
    else if (fieldName.equalsIgnoreCase("changesettlementcancel"))
      return changesettlementcancel;
    else if (fieldName.equalsIgnoreCase("cancel_processed") || fieldName.equals("cancelProcessed"))
      return cancelProcessed;
    else if (fieldName.equalsIgnoreCase("generate_processed") || fieldName.equals("generateProcessed"))
      return generateProcessed;
    else if (fieldName.equalsIgnoreCase("glitemamt"))
      return glitemamt;
    else if (fieldName.equalsIgnoreCase("isdirectposting"))
      return isdirectposting;
    else if (fieldName.equalsIgnoreCase("c_glitem_id") || fieldName.equals("cGlitemId"))
      return cGlitemId;
    else if (fieldName.equalsIgnoreCase("status"))
      return status;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("status_initial") || fieldName.equals("statusInitial"))
      return statusInitial;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("isautomaticgenerated"))
      return isautomaticgenerated;
    else if (fieldName.equalsIgnoreCase("c_withholding_id") || fieldName.equals("cWithholdingId"))
      return cWithholdingId;
    else if (fieldName.equalsIgnoreCase("withholdingamount"))
      return withholdingamount;
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
  public static PaymentData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cInvoiceId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cInvoiceId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PaymentData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cInvoiceId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Debt_Payment.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Debt_Payment.CreatedBy) as CreatedByR, " +
      "        to_char(C_Debt_Payment.Updated, ?) as updated, " +
      "        to_char(C_Debt_Payment.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Debt_Payment.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Debt_Payment.UpdatedBy) as UpdatedByR," +
      "        COALESCE(C_Debt_Payment.IsReceipt, 'N') AS IsReceipt, " +
      "C_Debt_Payment.Amount, " +
      "C_Debt_Payment.C_Debt_Payment_ID, " +
      "C_Debt_Payment.C_Currency_ID, " +
      "(CASE WHEN C_Debt_Payment.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "C_Debt_Payment.WriteOffAmt, " +
      "COALESCE(C_Debt_Payment.IsActive, 'N') AS IsActive, " +
      "C_Debt_Payment.Discountamt, " +
      "COALESCE(C_Debt_Payment.IsPaid, 'N') AS IsPaid, " +
      "COALESCE(C_Debt_Payment.Isapproved, 'N') AS Isapproved, " +
      "C_Debt_Payment.AD_Client_ID, " +
      "(CASE WHEN C_Debt_Payment.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_Debt_Payment.AD_Org_ID, " +
      "(CASE WHEN C_Debt_Payment.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_Debt_Payment.C_Invoice_ID, " +
      "(CASE WHEN C_Debt_Payment.C_Invoice_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table4.DateInvoiced, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.GrandTotal), ''))),'') ) END) AS C_Invoice_IDR, " +
      "C_Debt_Payment.C_Settlement_Cancel_ID, " +
      "(CASE WHEN C_Debt_Payment.C_Settlement_Cancel_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table5.DateTrx, 'DD-MM-YYYY')),'') ) END) AS C_Settlement_Cancel_IDR, " +
      "C_Debt_Payment.C_Settlement_Generate_ID, " +
      "C_Debt_Payment.PaymentRule, " +
      "(CASE WHEN C_Debt_Payment.PaymentRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS PaymentRuleR, " +
      "C_Debt_Payment.Dateplanned, " +
      "C_Debt_Payment.C_BPartner_ID, " +
      "(CASE WHEN C_Debt_Payment.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "C_Debt_Payment.Description, " +
      "C_Debt_Payment.C_CashBook_ID, " +
      "(CASE WHEN C_Debt_Payment.C_CashBook_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_CashBook_IDR, " +
      "C_Debt_Payment.C_CashLine_ID, " +
      "(CASE WHEN C_Debt_Payment.C_CashLine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Amount), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Description), ''))),'') ) END) AS C_CashLine_IDR, " +
      "C_Debt_Payment.C_BankAccount_ID, " +
      "(CASE WHEN C_Debt_Payment.C_BankAccount_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.DisplayedAccount), ''))),'') ) END) AS C_BankAccount_IDR, " +
      "C_Debt_Payment.C_BankStatementLine_ID, " +
      "(CASE WHEN C_Debt_Payment.C_BankStatementLine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.StmtAmt), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.Name), ''))),'') ) END) AS C_BankStatementLine_IDR, " +
      "COALESCE(C_Debt_Payment.IsManual, 'N') AS IsManual, " +
      "COALESCE(C_Debt_Payment.IsValid, 'N') AS IsValid, " +
      "C_Debt_Payment.Changesettlementcancel, " +
      "COALESCE(C_Debt_Payment.Cancel_Processed, 'N') AS Cancel_Processed, " +
      "COALESCE(C_Debt_Payment.Generate_Processed, 'N') AS Generate_Processed, " +
      "C_Debt_Payment.GLItemAmt, " +
      "COALESCE(C_Debt_Payment.Isdirectposting, 'N') AS Isdirectposting, " +
      "C_Debt_Payment.C_Glitem_ID, " +
      "C_Debt_Payment.Status, " +
      "C_Debt_Payment.C_Project_ID, " +
      "C_Debt_Payment.Status_Initial, " +
      "C_Debt_Payment.C_Order_ID, " +
      "COALESCE(C_Debt_Payment.IsAutomaticGenerated, 'N') AS IsAutomaticGenerated, " +
      "C_Debt_Payment.C_Withholding_ID, " +
      "C_Debt_Payment.Withholdingamount, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Debt_Payment left join (select C_Currency_ID, ISO_Code from C_Currency) table1 on (C_Debt_Payment.C_Currency_ID = table1.C_Currency_ID) left join (select AD_Client_ID, Name from AD_Client) table2 on (C_Debt_Payment.AD_Client_ID = table2.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table3 on (C_Debt_Payment.AD_Org_ID = table3.AD_Org_ID) left join (select C_Invoice_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice) table4 on (C_Debt_Payment.C_Invoice_ID = table4.C_Invoice_ID) left join (select C_Settlement_ID, DocumentNo, DateTrx from C_Settlement) table5 on (C_Debt_Payment.C_Settlement_Cancel_ID = table5.C_Settlement_ID) left join ad_ref_list_v list1 on (C_Debt_Payment.PaymentRule = list1.value and list1.ad_reference_id = '195' and list1.ad_language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table6 on (C_Debt_Payment.C_BPartner_ID = table6.C_BPartner_ID) left join (select C_CashBook_ID, Name from C_CashBook) table7 on (C_Debt_Payment.C_CashBook_ID = table7.C_CashBook_ID) left join (select C_CashLine_ID, C_Cash_ID, Line, Amount, Description from C_CashLine) table8 on (C_Debt_Payment.C_CashLine_ID = table8.C_CashLine_ID) left join (select C_Cash_ID, Name from C_Cash) table9 on (table8.C_Cash_ID = table9.C_Cash_ID) left join (select C_BankAccount_ID, C_Bank_ID, DisplayedAccount from C_BankAccount) table10 on (C_Debt_Payment.C_BankAccount_ID = table10.C_BankAccount_ID) left join (select C_Bank_ID, Name from C_Bank) table11 on (table10.C_Bank_ID = table11.C_Bank_ID) left join (select C_BankStatementLine_ID, Line, StmtAmt, C_BankStatement_ID from C_BankStatementLine) table12 on (C_Debt_Payment.C_BankStatementLine_ID = table12.C_BankStatementLine_ID) left join (select C_BankStatement_ID, Name from C_BankStatement) table13 on (table12.C_BankStatement_ID = table13.C_BankStatement_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cInvoiceId==null || cInvoiceId.equals(""))?"":"  AND C_Debt_Payment.C_Invoice_ID = ?  ");
    strSql = strSql + 
      "        AND C_Debt_Payment.C_Debt_Payment_ID = ? " +
      "        AND C_Debt_Payment.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Debt_Payment.AD_Org_ID IN (";
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
      if (cInvoiceId != null && !(cInvoiceId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
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
        PaymentData objectPaymentData = new PaymentData();
        objectPaymentData.created = UtilSql.getValue(result, "created");
        objectPaymentData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPaymentData.updated = UtilSql.getValue(result, "updated");
        objectPaymentData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPaymentData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPaymentData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPaymentData.isreceipt = UtilSql.getValue(result, "isreceipt");
        objectPaymentData.amount = UtilSql.getValue(result, "amount");
        objectPaymentData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectPaymentData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectPaymentData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectPaymentData.writeoffamt = UtilSql.getValue(result, "writeoffamt");
        objectPaymentData.isactive = UtilSql.getValue(result, "isactive");
        objectPaymentData.discountamt = UtilSql.getValue(result, "discountamt");
        objectPaymentData.ispaid = UtilSql.getValue(result, "ispaid");
        objectPaymentData.isapproved = UtilSql.getValue(result, "isapproved");
        objectPaymentData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPaymentData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectPaymentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPaymentData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPaymentData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectPaymentData.cInvoiceIdr = UtilSql.getValue(result, "c_invoice_idr");
        objectPaymentData.cSettlementCancelId = UtilSql.getValue(result, "c_settlement_cancel_id");
        objectPaymentData.cSettlementCancelIdr = UtilSql.getValue(result, "c_settlement_cancel_idr");
        objectPaymentData.cSettlementGenerateId = UtilSql.getValue(result, "c_settlement_generate_id");
        objectPaymentData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectPaymentData.paymentruler = UtilSql.getValue(result, "paymentruler");
        objectPaymentData.dateplanned = UtilSql.getDateValue(result, "dateplanned", "dd-MM-yyyy");
        objectPaymentData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectPaymentData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectPaymentData.description = UtilSql.getValue(result, "description");
        objectPaymentData.cCashbookId = UtilSql.getValue(result, "c_cashbook_id");
        objectPaymentData.cCashbookIdr = UtilSql.getValue(result, "c_cashbook_idr");
        objectPaymentData.cCashlineId = UtilSql.getValue(result, "c_cashline_id");
        objectPaymentData.cCashlineIdr = UtilSql.getValue(result, "c_cashline_idr");
        objectPaymentData.cBankaccountId = UtilSql.getValue(result, "c_bankaccount_id");
        objectPaymentData.cBankaccountIdr = UtilSql.getValue(result, "c_bankaccount_idr");
        objectPaymentData.cBankstatementlineId = UtilSql.getValue(result, "c_bankstatementline_id");
        objectPaymentData.cBankstatementlineIdr = UtilSql.getValue(result, "c_bankstatementline_idr");
        objectPaymentData.ismanual = UtilSql.getValue(result, "ismanual");
        objectPaymentData.isvalid = UtilSql.getValue(result, "isvalid");
        objectPaymentData.changesettlementcancel = UtilSql.getValue(result, "changesettlementcancel");
        objectPaymentData.cancelProcessed = UtilSql.getValue(result, "cancel_processed");
        objectPaymentData.generateProcessed = UtilSql.getValue(result, "generate_processed");
        objectPaymentData.glitemamt = UtilSql.getValue(result, "glitemamt");
        objectPaymentData.isdirectposting = UtilSql.getValue(result, "isdirectposting");
        objectPaymentData.cGlitemId = UtilSql.getValue(result, "c_glitem_id");
        objectPaymentData.status = UtilSql.getValue(result, "status");
        objectPaymentData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectPaymentData.statusInitial = UtilSql.getValue(result, "status_initial");
        objectPaymentData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectPaymentData.isautomaticgenerated = UtilSql.getValue(result, "isautomaticgenerated");
        objectPaymentData.cWithholdingId = UtilSql.getValue(result, "c_withholding_id");
        objectPaymentData.withholdingamount = UtilSql.getValue(result, "withholdingamount");
        objectPaymentData.language = UtilSql.getValue(result, "language");
        objectPaymentData.adUserClient = "";
        objectPaymentData.adOrgClient = "";
        objectPaymentData.createdby = "";
        objectPaymentData.trBgcolor = "";
        objectPaymentData.totalCount = "";
        objectPaymentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPaymentData);
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
    PaymentData objectPaymentData[] = new PaymentData[vector.size()];
    vector.copyInto(objectPaymentData);
    return(objectPaymentData);
  }

/**
Create a registry
 */
  public static PaymentData[] set(String cInvoiceId, String cBankstatementlineId, String isreceipt, String ispaid, String cancelProcessed, String cSettlementCancelId, String isdirectposting, String description, String isvalid, String createdby, String createdbyr, String dateplanned, String adOrgId, String amount, String isautomaticgenerated, String statusInitial, String cProjectId, String cSettlementGenerateId, String cCurrencyId, String cCashlineId, String isactive, String discountamt, String writeoffamt, String created, String cDebtPaymentId, String isapproved, String cGlitemId, String cBankaccountId, String ismanual, String adClientId, String cInvoiceIdr, String status, String changesettlementcancel, String cCashbookId, String paymentrule, String generateProcessed, String cOrderId, String withholdingamount, String cWithholdingId, String updatedby, String updatedbyr, String glitemamt, String cBpartnerId, String cBpartnerIdr)    throws ServletException {
    PaymentData objectPaymentData[] = new PaymentData[1];
    objectPaymentData[0] = new PaymentData();
    objectPaymentData[0].created = created;
    objectPaymentData[0].createdbyr = createdbyr;
    objectPaymentData[0].updated = "";
    objectPaymentData[0].updatedTimeStamp = "";
    objectPaymentData[0].updatedby = updatedby;
    objectPaymentData[0].updatedbyr = updatedbyr;
    objectPaymentData[0].isreceipt = isreceipt;
    objectPaymentData[0].amount = amount;
    objectPaymentData[0].cDebtPaymentId = cDebtPaymentId;
    objectPaymentData[0].cCurrencyId = cCurrencyId;
    objectPaymentData[0].cCurrencyIdr = "";
    objectPaymentData[0].writeoffamt = writeoffamt;
    objectPaymentData[0].isactive = isactive;
    objectPaymentData[0].discountamt = discountamt;
    objectPaymentData[0].ispaid = ispaid;
    objectPaymentData[0].isapproved = isapproved;
    objectPaymentData[0].adClientId = adClientId;
    objectPaymentData[0].adClientIdr = "";
    objectPaymentData[0].adOrgId = adOrgId;
    objectPaymentData[0].adOrgIdr = "";
    objectPaymentData[0].cInvoiceId = cInvoiceId;
    objectPaymentData[0].cInvoiceIdr = cInvoiceIdr;
    objectPaymentData[0].cSettlementCancelId = cSettlementCancelId;
    objectPaymentData[0].cSettlementCancelIdr = "";
    objectPaymentData[0].cSettlementGenerateId = cSettlementGenerateId;
    objectPaymentData[0].paymentrule = paymentrule;
    objectPaymentData[0].paymentruler = "";
    objectPaymentData[0].dateplanned = dateplanned;
    objectPaymentData[0].cBpartnerId = cBpartnerId;
    objectPaymentData[0].cBpartnerIdr = cBpartnerIdr;
    objectPaymentData[0].description = description;
    objectPaymentData[0].cCashbookId = cCashbookId;
    objectPaymentData[0].cCashbookIdr = "";
    objectPaymentData[0].cCashlineId = cCashlineId;
    objectPaymentData[0].cCashlineIdr = "";
    objectPaymentData[0].cBankaccountId = cBankaccountId;
    objectPaymentData[0].cBankaccountIdr = "";
    objectPaymentData[0].cBankstatementlineId = cBankstatementlineId;
    objectPaymentData[0].cBankstatementlineIdr = "";
    objectPaymentData[0].ismanual = ismanual;
    objectPaymentData[0].isvalid = isvalid;
    objectPaymentData[0].changesettlementcancel = changesettlementcancel;
    objectPaymentData[0].cancelProcessed = cancelProcessed;
    objectPaymentData[0].generateProcessed = generateProcessed;
    objectPaymentData[0].glitemamt = glitemamt;
    objectPaymentData[0].isdirectposting = isdirectposting;
    objectPaymentData[0].cGlitemId = cGlitemId;
    objectPaymentData[0].status = status;
    objectPaymentData[0].cProjectId = cProjectId;
    objectPaymentData[0].statusInitial = statusInitial;
    objectPaymentData[0].cOrderId = cOrderId;
    objectPaymentData[0].isautomaticgenerated = isautomaticgenerated;
    objectPaymentData[0].cWithholdingId = cWithholdingId;
    objectPaymentData[0].withholdingamount = withholdingamount;
    objectPaymentData[0].language = "";
    return objectPaymentData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef800304_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef800311_1(ConnectionProvider connectionProvider, String C_Invoice_IDR)    throws ServletException {
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
  public static String selectDef800306_2(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef800312_3(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
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
      "        SELECT C_Debt_Payment.C_Invoice_ID AS NAME" +
      "        FROM C_Debt_Payment" +
      "        WHERE C_Debt_Payment.C_Debt_Payment_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.DateInvoiced, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.GrandTotal), ''))) AS NAME FROM C_Invoice left join (select C_Invoice_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice) table1 on (C_Invoice.C_Invoice_ID = table1.C_Invoice_ID) WHERE C_Invoice.C_Invoice_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.DateInvoiced, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.GrandTotal), ''))) AS NAME FROM C_Invoice left join (select C_Invoice_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice) table1 on (C_Invoice.C_Invoice_ID = table1.C_Invoice_ID) WHERE C_Invoice.C_Invoice_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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
      "        UPDATE C_Debt_Payment" +
      "        SET IsReceipt = (?) , C_Debt_Payment_ID = (?) , Amount = TO_NUMBER(?) , C_Currency_ID = (?) , WriteOffAmt = TO_NUMBER(?) , Discountamt = TO_NUMBER(?) , IsActive = (?) , IsPaid = (?) , Isapproved = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_Invoice_ID = (?) , C_Settlement_Cancel_ID = (?) , PaymentRule = (?) , C_Settlement_Generate_ID = (?) , Dateplanned = TO_DATE(?) , C_BPartner_ID = (?) , Description = (?) , C_CashBook_ID = (?) , C_CashLine_ID = (?) , C_BankAccount_ID = (?) , C_BankStatementLine_ID = (?) , IsManual = (?) , IsValid = (?) , Changesettlementcancel = (?) , Cancel_Processed = (?) , Generate_Processed = (?) , GLItemAmt = TO_NUMBER(?) , Isdirectposting = (?) , C_Glitem_ID = (?) , Status = (?) , C_Project_ID = (?) , Status_Initial = (?) , C_Order_ID = (?) , IsAutomaticGenerated = (?) , C_Withholding_ID = (?) , Withholdingamount = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE C_Debt_Payment.C_Debt_Payment_ID = ? " +
      "                 AND C_Debt_Payment.C_Invoice_ID = ? " +
      "        AND C_Debt_Payment.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Debt_Payment.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreceipt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, writeoffamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discountamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isapproved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementCancelId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementGenerateId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCashbookId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCashlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismanual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvalid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changesettlementcancel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancelProcessed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateProcessed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glitemamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdirectposting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGlitemId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, statusInitial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isautomaticgenerated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cWithholdingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, withholdingamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
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
      "        INSERT INTO C_Debt_Payment " +
      "        (IsReceipt, Amount, C_Debt_Payment_ID, C_Currency_ID, WriteOffAmt, IsActive, Discountamt, IsPaid, Isapproved, AD_Client_ID, AD_Org_ID, C_Invoice_ID, C_Settlement_Cancel_ID, C_Settlement_Generate_ID, PaymentRule, Dateplanned, C_BPartner_ID, Description, C_CashBook_ID, C_CashLine_ID, C_BankAccount_ID, C_BankStatementLine_ID, IsManual, IsValid, Changesettlementcancel, Cancel_Processed, Generate_Processed, GLItemAmt, Isdirectposting, C_Glitem_ID, Status, C_Project_ID, Status_Initial, C_Order_ID, IsAutomaticGenerated, C_Withholding_ID, Withholdingamount, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreceipt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, writeoffamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discountamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isapproved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementCancelId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementGenerateId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCashbookId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCashlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismanual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvalid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changesettlementcancel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancelProcessed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateProcessed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glitemamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdirectposting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGlitemId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, statusInitial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isautomaticgenerated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cWithholdingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, withholdingamount);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cInvoiceId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Debt_Payment" +
      "        WHERE C_Debt_Payment.C_Debt_Payment_ID = ? " +
      "                 AND C_Debt_Payment.C_Invoice_ID = ? " +
      "        AND C_Debt_Payment.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Debt_Payment.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Debt_Payment" +
      "        WHERE C_Debt_Payment.C_Debt_Payment_ID = ? " +
      "                 AND C_Debt_Payment.C_Invoice_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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
      "          FROM C_Debt_Payment" +
      "         WHERE C_Debt_Payment.C_Debt_Payment_ID = ? ";

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
      "          FROM C_Debt_Payment" +
      "         WHERE C_Debt_Payment.C_Debt_Payment_ID = ? ";

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
