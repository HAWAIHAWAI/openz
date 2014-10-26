//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Settlement;

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
class CancelledPaymentsData implements FieldProvider {
static Logger log4j = Logger.getLogger(CancelledPaymentsData.class);
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
  public String cSettlementId;
  public String cSettlementIdr;
  public String paymentrule;
  public String paymentruler;
  public String dateplanned;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cInvoiceId;
  public String cInvoiceIdr;
  public String description;
  public String cCashbookId;
  public String cCashbookIdr;
  public String cCashlineId;
  public String cCashlineIdr;
  public String cBankaccountId;
  public String cBankaccountIdr;
  public String cBankstatementlineId;
  public String cBankstatementlineIdr;
  public String amount;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String writeoffamt;
  public String discountamt;
  public String isreceipt;
  public String ispaid;
  public String changesettlementcancel;
  public String ismanual;
  public String isvalid;
  public String cancelProcessed;
  public String isactive;
  public String cDebtPaymentId;
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
    else if (fieldName.equalsIgnoreCase("c_settlement_id") || fieldName.equals("cSettlementId"))
      return cSettlementId;
    else if (fieldName.equalsIgnoreCase("c_settlement_idr") || fieldName.equals("cSettlementIdr"))
      return cSettlementIdr;
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
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("c_invoice_idr") || fieldName.equals("cInvoiceIdr"))
      return cInvoiceIdr;
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
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("writeoffamt"))
      return writeoffamt;
    else if (fieldName.equalsIgnoreCase("discountamt"))
      return discountamt;
    else if (fieldName.equalsIgnoreCase("isreceipt"))
      return isreceipt;
    else if (fieldName.equalsIgnoreCase("ispaid"))
      return ispaid;
    else if (fieldName.equalsIgnoreCase("changesettlementcancel"))
      return changesettlementcancel;
    else if (fieldName.equalsIgnoreCase("ismanual"))
      return ismanual;
    else if (fieldName.equalsIgnoreCase("isvalid"))
      return isvalid;
    else if (fieldName.equalsIgnoreCase("cancel_processed") || fieldName.equals("cancelProcessed"))
      return cancelProcessed;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_debt_payment_id") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
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
  public static CancelledPaymentsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cSettlementId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cSettlementId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CancelledPaymentsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cSettlementId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Debt_Payment_Cancel.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Debt_Payment_Cancel.CreatedBy) as CreatedByR, " +
      "        to_char(C_Debt_Payment_Cancel.Updated, ?) as updated, " +
      "        to_char(C_Debt_Payment_Cancel.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Debt_Payment_Cancel.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Debt_Payment_Cancel.UpdatedBy) as UpdatedByR," +
      "        C_Debt_Payment_Cancel.AD_Client_ID, " +
      "(CASE WHEN C_Debt_Payment_Cancel.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_Debt_Payment_Cancel.AD_Org_ID, " +
      "(CASE WHEN C_Debt_Payment_Cancel.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_Debt_Payment_Cancel.C_Settlement_ID, " +
      "(CASE WHEN C_Debt_Payment_Cancel.C_Settlement_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.DateTrx, 'DD-MM-YYYY')),'') ) END) AS C_Settlement_IDR, " +
      "C_Debt_Payment_Cancel.PaymentRule, " +
      "(CASE WHEN C_Debt_Payment_Cancel.PaymentRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS PaymentRuleR, " +
      "C_Debt_Payment_Cancel.Dateplanned, " +
      "C_Debt_Payment_Cancel.C_BPartner_ID, " +
      "(CASE WHEN C_Debt_Payment_Cancel.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "C_Debt_Payment_Cancel.C_Invoice_ID, " +
      "(CASE WHEN C_Debt_Payment_Cancel.C_Invoice_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table5.DateInvoiced, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.GrandTotal), ''))),'') ) END) AS C_Invoice_IDR, " +
      "C_Debt_Payment_Cancel.Description, " +
      "C_Debt_Payment_Cancel.C_CashBook_ID, " +
      "(CASE WHEN C_Debt_Payment_Cancel.C_CashBook_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_CashBook_IDR, " +
      "C_Debt_Payment_Cancel.C_CashLine_ID, " +
      "(CASE WHEN C_Debt_Payment_Cancel.C_CashLine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Amount), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Description), ''))),'') ) END) AS C_CashLine_IDR, " +
      "C_Debt_Payment_Cancel.C_BankAccount_ID, " +
      "(CASE WHEN C_Debt_Payment_Cancel.C_BankAccount_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.DisplayedAccount), ''))),'') ) END) AS C_BankAccount_IDR, " +
      "C_Debt_Payment_Cancel.C_BankStatementLine_ID, " +
      "(CASE WHEN C_Debt_Payment_Cancel.C_BankStatementLine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.StmtAmt), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Name), ''))),'') ) END) AS C_BankStatementLine_IDR, " +
      "C_Debt_Payment_Cancel.Amount, " +
      "C_Debt_Payment_Cancel.C_Currency_ID, " +
      "(CASE WHEN C_Debt_Payment_Cancel.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "C_Debt_Payment_Cancel.WriteOffAmt, " +
      "C_Debt_Payment_Cancel.Discountamt, " +
      "COALESCE(C_Debt_Payment_Cancel.IsReceipt, 'N') AS IsReceipt, " +
      "COALESCE(C_Debt_Payment_Cancel.IsPaid, 'N') AS IsPaid, " +
      "C_Debt_Payment_Cancel.ChangeSettlementCancel, " +
      "COALESCE(C_Debt_Payment_Cancel.IsManual, 'N') AS IsManual, " +
      "COALESCE(C_Debt_Payment_Cancel.IsValid, 'N') AS IsValid, " +
      "COALESCE(C_Debt_Payment_Cancel.Cancel_Processed, 'N') AS Cancel_Processed, " +
      "COALESCE(C_Debt_Payment_Cancel.IsActive, 'N') AS IsActive, " +
      "C_Debt_Payment_Cancel.C_Debt_Payment_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Debt_Payment_Cancel left join (select AD_Client_ID, Name from AD_Client) table1 on (C_Debt_Payment_Cancel.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_Debt_Payment_Cancel.AD_Org_ID = table2.AD_Org_ID) left join (select C_Settlement_ID, DocumentNo, DateTrx from C_Settlement) table3 on (C_Debt_Payment_Cancel.C_Settlement_ID = table3.C_Settlement_ID) left join ad_ref_list_v list1 on (C_Debt_Payment_Cancel.PaymentRule = list1.value and list1.ad_reference_id = '195' and list1.ad_language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table4 on (C_Debt_Payment_Cancel.C_BPartner_ID = table4.C_BPartner_ID) left join (select C_Invoice_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice) table5 on (C_Debt_Payment_Cancel.C_Invoice_ID = table5.C_Invoice_ID) left join (select C_CashBook_ID, Name from C_CashBook) table6 on (C_Debt_Payment_Cancel.C_CashBook_ID = table6.C_CashBook_ID) left join (select C_CashLine_ID, C_Cash_ID, Line, Amount, Description from C_CashLine) table7 on (C_Debt_Payment_Cancel.C_CashLine_ID = table7.C_CashLine_ID) left join (select C_Cash_ID, Name from C_Cash) table8 on (table7.C_Cash_ID = table8.C_Cash_ID) left join (select C_BankAccount_ID, C_Bank_ID, DisplayedAccount from C_BankAccount) table9 on (C_Debt_Payment_Cancel.C_BankAccount_ID = table9.C_BankAccount_ID) left join (select C_Bank_ID, Name from C_Bank) table10 on (table9.C_Bank_ID = table10.C_Bank_ID) left join (select C_BankStatementLine_ID, Line, StmtAmt, C_BankStatement_ID from C_BankStatementLine) table11 on (C_Debt_Payment_Cancel.C_BankStatementLine_ID = table11.C_BankStatementLine_ID) left join (select C_BankStatement_ID, Name from C_BankStatement) table12 on (table11.C_BankStatement_ID = table12.C_BankStatement_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table13 on (C_Debt_Payment_Cancel.C_Currency_ID = table13.C_Currency_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cSettlementId==null || cSettlementId.equals(""))?"":"  AND C_Debt_Payment_Cancel.C_Settlement_ID = ?  ");
    strSql = strSql + 
      "        AND C_Debt_Payment_Cancel.C_Debt_Payment_ID = ? " +
      "        AND C_Debt_Payment_Cancel.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Debt_Payment_Cancel.AD_Org_ID IN (";
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
      if (cSettlementId != null && !(cSettlementId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);
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
        CancelledPaymentsData objectCancelledPaymentsData = new CancelledPaymentsData();
        objectCancelledPaymentsData.created = UtilSql.getValue(result, "created");
        objectCancelledPaymentsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCancelledPaymentsData.updated = UtilSql.getValue(result, "updated");
        objectCancelledPaymentsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCancelledPaymentsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectCancelledPaymentsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCancelledPaymentsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCancelledPaymentsData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectCancelledPaymentsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCancelledPaymentsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectCancelledPaymentsData.cSettlementId = UtilSql.getValue(result, "c_settlement_id");
        objectCancelledPaymentsData.cSettlementIdr = UtilSql.getValue(result, "c_settlement_idr");
        objectCancelledPaymentsData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectCancelledPaymentsData.paymentruler = UtilSql.getValue(result, "paymentruler");
        objectCancelledPaymentsData.dateplanned = UtilSql.getDateValue(result, "dateplanned", "dd-MM-yyyy");
        objectCancelledPaymentsData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCancelledPaymentsData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectCancelledPaymentsData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCancelledPaymentsData.cInvoiceIdr = UtilSql.getValue(result, "c_invoice_idr");
        objectCancelledPaymentsData.description = UtilSql.getValue(result, "description");
        objectCancelledPaymentsData.cCashbookId = UtilSql.getValue(result, "c_cashbook_id");
        objectCancelledPaymentsData.cCashbookIdr = UtilSql.getValue(result, "c_cashbook_idr");
        objectCancelledPaymentsData.cCashlineId = UtilSql.getValue(result, "c_cashline_id");
        objectCancelledPaymentsData.cCashlineIdr = UtilSql.getValue(result, "c_cashline_idr");
        objectCancelledPaymentsData.cBankaccountId = UtilSql.getValue(result, "c_bankaccount_id");
        objectCancelledPaymentsData.cBankaccountIdr = UtilSql.getValue(result, "c_bankaccount_idr");
        objectCancelledPaymentsData.cBankstatementlineId = UtilSql.getValue(result, "c_bankstatementline_id");
        objectCancelledPaymentsData.cBankstatementlineIdr = UtilSql.getValue(result, "c_bankstatementline_idr");
        objectCancelledPaymentsData.amount = UtilSql.getValue(result, "amount");
        objectCancelledPaymentsData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCancelledPaymentsData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectCancelledPaymentsData.writeoffamt = UtilSql.getValue(result, "writeoffamt");
        objectCancelledPaymentsData.discountamt = UtilSql.getValue(result, "discountamt");
        objectCancelledPaymentsData.isreceipt = UtilSql.getValue(result, "isreceipt");
        objectCancelledPaymentsData.ispaid = UtilSql.getValue(result, "ispaid");
        objectCancelledPaymentsData.changesettlementcancel = UtilSql.getValue(result, "changesettlementcancel");
        objectCancelledPaymentsData.ismanual = UtilSql.getValue(result, "ismanual");
        objectCancelledPaymentsData.isvalid = UtilSql.getValue(result, "isvalid");
        objectCancelledPaymentsData.cancelProcessed = UtilSql.getValue(result, "cancel_processed");
        objectCancelledPaymentsData.isactive = UtilSql.getValue(result, "isactive");
        objectCancelledPaymentsData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectCancelledPaymentsData.language = UtilSql.getValue(result, "language");
        objectCancelledPaymentsData.adUserClient = "";
        objectCancelledPaymentsData.adOrgClient = "";
        objectCancelledPaymentsData.createdby = "";
        objectCancelledPaymentsData.trBgcolor = "";
        objectCancelledPaymentsData.totalCount = "";
        objectCancelledPaymentsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCancelledPaymentsData);
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
    CancelledPaymentsData objectCancelledPaymentsData[] = new CancelledPaymentsData[vector.size()];
    vector.copyInto(objectCancelledPaymentsData);
    return(objectCancelledPaymentsData);
  }

/**
Create a registry
 */
  public static CancelledPaymentsData[] set(String cSettlementId, String ispaid, String writeoffamt, String createdby, String createdbyr, String cDebtPaymentId, String cInvoiceId, String cInvoiceIdr, String cCurrencyId, String amount, String dateplanned, String adOrgId, String cBankstatementlineId, String discountamt, String created, String adClientId, String changesettlementcancel, String cCashlineId, String cancelProcessed, String cCashbookId, String isreceipt, String paymentrule, String updatedby, String updatedbyr, String cBankaccountId, String ismanual, String isactive, String isvalid, String description, String cBpartnerId, String cBpartnerIdr)    throws ServletException {
    CancelledPaymentsData objectCancelledPaymentsData[] = new CancelledPaymentsData[1];
    objectCancelledPaymentsData[0] = new CancelledPaymentsData();
    objectCancelledPaymentsData[0].created = created;
    objectCancelledPaymentsData[0].createdbyr = createdbyr;
    objectCancelledPaymentsData[0].updated = "";
    objectCancelledPaymentsData[0].updatedTimeStamp = "";
    objectCancelledPaymentsData[0].updatedby = updatedby;
    objectCancelledPaymentsData[0].updatedbyr = updatedbyr;
    objectCancelledPaymentsData[0].adClientId = adClientId;
    objectCancelledPaymentsData[0].adClientIdr = "";
    objectCancelledPaymentsData[0].adOrgId = adOrgId;
    objectCancelledPaymentsData[0].adOrgIdr = "";
    objectCancelledPaymentsData[0].cSettlementId = cSettlementId;
    objectCancelledPaymentsData[0].cSettlementIdr = "";
    objectCancelledPaymentsData[0].paymentrule = paymentrule;
    objectCancelledPaymentsData[0].paymentruler = "";
    objectCancelledPaymentsData[0].dateplanned = dateplanned;
    objectCancelledPaymentsData[0].cBpartnerId = cBpartnerId;
    objectCancelledPaymentsData[0].cBpartnerIdr = cBpartnerIdr;
    objectCancelledPaymentsData[0].cInvoiceId = cInvoiceId;
    objectCancelledPaymentsData[0].cInvoiceIdr = cInvoiceIdr;
    objectCancelledPaymentsData[0].description = description;
    objectCancelledPaymentsData[0].cCashbookId = cCashbookId;
    objectCancelledPaymentsData[0].cCashbookIdr = "";
    objectCancelledPaymentsData[0].cCashlineId = cCashlineId;
    objectCancelledPaymentsData[0].cCashlineIdr = "";
    objectCancelledPaymentsData[0].cBankaccountId = cBankaccountId;
    objectCancelledPaymentsData[0].cBankaccountIdr = "";
    objectCancelledPaymentsData[0].cBankstatementlineId = cBankstatementlineId;
    objectCancelledPaymentsData[0].cBankstatementlineIdr = "";
    objectCancelledPaymentsData[0].amount = amount;
    objectCancelledPaymentsData[0].cCurrencyId = cCurrencyId;
    objectCancelledPaymentsData[0].cCurrencyIdr = "";
    objectCancelledPaymentsData[0].writeoffamt = writeoffamt;
    objectCancelledPaymentsData[0].discountamt = discountamt;
    objectCancelledPaymentsData[0].isreceipt = isreceipt;
    objectCancelledPaymentsData[0].ispaid = ispaid;
    objectCancelledPaymentsData[0].changesettlementcancel = changesettlementcancel;
    objectCancelledPaymentsData[0].ismanual = ismanual;
    objectCancelledPaymentsData[0].isvalid = isvalid;
    objectCancelledPaymentsData[0].cancelProcessed = cancelProcessed;
    objectCancelledPaymentsData[0].isactive = isactive;
    objectCancelledPaymentsData[0].cDebtPaymentId = cDebtPaymentId;
    objectCancelledPaymentsData[0].language = "";
    return objectCancelledPaymentsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef800352_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef800358_1(ConnectionProvider connectionProvider, String C_Invoice_IDR)    throws ServletException {
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
  public static String selectDef800354_2(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef800359_3(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
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
      "        SELECT C_Debt_Payment_Cancel.C_Settlement_ID AS NAME" +
      "        FROM C_Debt_Payment_Cancel" +
      "        WHERE C_Debt_Payment_Cancel.C_Debt_Payment_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cSettlementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.DateTrx, 'DD-MM-YYYY')) AS NAME FROM C_Settlement left join (select C_Settlement_ID, DocumentNo, DateTrx from C_Settlement) table1 on (C_Settlement.C_Settlement_ID = table1.C_Settlement_ID) WHERE C_Settlement.C_Settlement_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cSettlementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.DateTrx, 'DD-MM-YYYY')) AS NAME FROM C_Settlement left join (select C_Settlement_ID, DocumentNo, DateTrx from C_Settlement) table1 on (C_Settlement.C_Settlement_ID = table1.C_Settlement_ID) WHERE C_Settlement.C_Settlement_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);

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
      "        UPDATE C_Debt_Payment_Cancel" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , C_Settlement_ID = (?) , PaymentRule = (?) , Dateplanned = TO_DATE(?) , C_BPartner_ID = (?) , C_Invoice_ID = (?) , Description = (?) , C_CashBook_ID = (?) , C_CashLine_ID = (?) , C_BankAccount_ID = (?) , C_BankStatementLine_ID = (?) , Amount = TO_NUMBER(?) , C_Currency_ID = (?) , WriteOffAmt = TO_NUMBER(?) , Discountamt = TO_NUMBER(?) , IsReceipt = (?) , IsPaid = (?) , ChangeSettlementCancel = (?) , C_Debt_Payment_ID = (?) , Cancel_Processed = (?) , IsValid = (?) , IsActive = (?) , IsManual = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Debt_Payment_Cancel.C_Debt_Payment_ID = ? " +
      "                 AND C_Debt_Payment_Cancel.C_Settlement_ID = ? " +
      "        AND C_Debt_Payment_Cancel.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Debt_Payment_Cancel.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCashbookId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCashlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, writeoffamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discountamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreceipt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changesettlementcancel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancelProcessed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvalid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismanual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);
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
      "        INSERT INTO C_Debt_Payment_Cancel " +
      "        (AD_Client_ID, AD_Org_ID, C_Settlement_ID, PaymentRule, Dateplanned, C_BPartner_ID, C_Invoice_ID, Description, C_CashBook_ID, C_CashLine_ID, C_BankAccount_ID, C_BankStatementLine_ID, Amount, C_Currency_ID, WriteOffAmt, Discountamt, IsReceipt, IsPaid, ChangeSettlementCancel, IsManual, IsValid, Cancel_Processed, IsActive, C_Debt_Payment_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCashbookId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCashlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, writeoffamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discountamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreceipt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changesettlementcancel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismanual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvalid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancelProcessed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cSettlementId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Debt_Payment_Cancel" +
      "        WHERE C_Debt_Payment_Cancel.C_Debt_Payment_ID = ? " +
      "                 AND C_Debt_Payment_Cancel.C_Settlement_ID = ? " +
      "        AND C_Debt_Payment_Cancel.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Debt_Payment_Cancel.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cSettlementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Debt_Payment_Cancel" +
      "        WHERE C_Debt_Payment_Cancel.C_Debt_Payment_ID = ? " +
      "                 AND C_Debt_Payment_Cancel.C_Settlement_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);

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
      "          FROM C_Debt_Payment_Cancel" +
      "         WHERE C_Debt_Payment_Cancel.C_Debt_Payment_ID = ? ";

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
      "          FROM C_Debt_Payment_Cancel" +
      "         WHERE C_Debt_Payment_Cancel.C_Debt_Payment_ID = ? ";

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
