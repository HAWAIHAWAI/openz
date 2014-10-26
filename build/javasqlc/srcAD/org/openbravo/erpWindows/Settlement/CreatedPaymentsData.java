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
class CreatedPaymentsData implements FieldProvider {
static Logger log4j = Logger.getLogger(CreatedPaymentsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String cDebtPaymentId;
  public String adOrgId;
  public String adOrgIdr;
  public String cSettlementId;
  public String cSettlementIdr;
  public String isactive;
  public String cSettlementCancelId;
  public String cSettlementCancelIdr;
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
  public String cInvoiceId;
  public String cBankstatementlineId;
  public String cBankstatementlineIdr;
  public String amount;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String writeoffamt;
  public String discountamt;
  public String isreceipt;
  public String ispaid;
  public String ismanual;
  public String isvalid;
  public String generateProcessed;
  public String isdirectposting;
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
    else if (fieldName.equalsIgnoreCase("c_debt_payment_id") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_settlement_id") || fieldName.equals("cSettlementId"))
      return cSettlementId;
    else if (fieldName.equalsIgnoreCase("c_settlement_idr") || fieldName.equals("cSettlementIdr"))
      return cSettlementIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_settlement_cancel_id") || fieldName.equals("cSettlementCancelId"))
      return cSettlementCancelId;
    else if (fieldName.equalsIgnoreCase("c_settlement_cancel_idr") || fieldName.equals("cSettlementCancelIdr"))
      return cSettlementCancelIdr;
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
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
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
    else if (fieldName.equalsIgnoreCase("ismanual"))
      return ismanual;
    else if (fieldName.equalsIgnoreCase("isvalid"))
      return isvalid;
    else if (fieldName.equalsIgnoreCase("generate_processed") || fieldName.equals("generateProcessed"))
      return generateProcessed;
    else if (fieldName.equalsIgnoreCase("isdirectposting"))
      return isdirectposting;
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
  public static CreatedPaymentsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cSettlementId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cSettlementId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CreatedPaymentsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cSettlementId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Debt_Payment_Generate.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Debt_Payment_Generate.CreatedBy) as CreatedByR, " +
      "        to_char(C_Debt_Payment_Generate.Updated, ?) as updated, " +
      "        to_char(C_Debt_Payment_Generate.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Debt_Payment_Generate.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Debt_Payment_Generate.UpdatedBy) as UpdatedByR," +
      "        C_Debt_Payment_Generate.AD_Client_ID, " +
      "(CASE WHEN C_Debt_Payment_Generate.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_Debt_Payment_Generate.C_Debt_Payment_ID, " +
      "C_Debt_Payment_Generate.AD_Org_ID, " +
      "(CASE WHEN C_Debt_Payment_Generate.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_Debt_Payment_Generate.C_Settlement_ID, " +
      "(CASE WHEN C_Debt_Payment_Generate.C_Settlement_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.DateTrx, 'DD-MM-YYYY')),'') ) END) AS C_Settlement_IDR, " +
      "COALESCE(C_Debt_Payment_Generate.IsActive, 'N') AS IsActive, " +
      "C_Debt_Payment_Generate.C_Settlement_Cancel_ID, " +
      "(CASE WHEN C_Debt_Payment_Generate.C_Settlement_Cancel_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table4.DateTrx, 'DD-MM-YYYY')),'') ) END) AS C_Settlement_Cancel_IDR, " +
      "C_Debt_Payment_Generate.PaymentRule, " +
      "(CASE WHEN C_Debt_Payment_Generate.PaymentRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS PaymentRuleR, " +
      "C_Debt_Payment_Generate.Dateplanned, " +
      "C_Debt_Payment_Generate.C_BPartner_ID, " +
      "(CASE WHEN C_Debt_Payment_Generate.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "C_Debt_Payment_Generate.Description, " +
      "C_Debt_Payment_Generate.C_CashBook_ID, " +
      "(CASE WHEN C_Debt_Payment_Generate.C_CashBook_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_CashBook_IDR, " +
      "C_Debt_Payment_Generate.C_CashLine_ID, " +
      "(CASE WHEN C_Debt_Payment_Generate.C_CashLine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Amount), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Description), ''))),'') ) END) AS C_CashLine_IDR, " +
      "C_Debt_Payment_Generate.C_BankAccount_ID, " +
      "(CASE WHEN C_Debt_Payment_Generate.C_BankAccount_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.DisplayedAccount), ''))),'') ) END) AS C_BankAccount_IDR, " +
      "C_Debt_Payment_Generate.C_Invoice_ID, " +
      "C_Debt_Payment_Generate.C_BankStatementLine_ID, " +
      "(CASE WHEN C_Debt_Payment_Generate.C_BankStatementLine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.StmtAmt), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Name), ''))),'') ) END) AS C_BankStatementLine_IDR, " +
      "C_Debt_Payment_Generate.Amount, " +
      "C_Debt_Payment_Generate.C_Currency_ID, " +
      "(CASE WHEN C_Debt_Payment_Generate.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "C_Debt_Payment_Generate.WriteOffAmt, " +
      "C_Debt_Payment_Generate.Discountamt, " +
      "COALESCE(C_Debt_Payment_Generate.IsReceipt, 'N') AS IsReceipt, " +
      "COALESCE(C_Debt_Payment_Generate.IsPaid, 'N') AS IsPaid, " +
      "COALESCE(C_Debt_Payment_Generate.IsManual, 'N') AS IsManual, " +
      "COALESCE(C_Debt_Payment_Generate.IsValid, 'N') AS IsValid, " +
      "COALESCE(C_Debt_Payment_Generate.Generate_Processed, 'N') AS Generate_Processed, " +
      "COALESCE(C_Debt_Payment_Generate.Isdirectposting, 'N') AS Isdirectposting, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Debt_Payment_Generate left join (select AD_Client_ID, Name from AD_Client) table1 on (C_Debt_Payment_Generate.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_Debt_Payment_Generate.AD_Org_ID = table2.AD_Org_ID) left join (select C_Settlement_ID, DocumentNo, DateTrx from C_Settlement) table3 on (C_Debt_Payment_Generate.C_Settlement_ID = table3.C_Settlement_ID) left join (select C_Settlement_ID, DocumentNo, DateTrx from C_Settlement) table4 on (C_Debt_Payment_Generate.C_Settlement_Cancel_ID = table4.C_Settlement_ID) left join ad_ref_list_v list1 on (C_Debt_Payment_Generate.PaymentRule = list1.value and list1.ad_reference_id = '195' and list1.ad_language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table5 on (C_Debt_Payment_Generate.C_BPartner_ID = table5.C_BPartner_ID) left join (select C_CashBook_ID, Name from C_CashBook) table6 on (C_Debt_Payment_Generate.C_CashBook_ID = table6.C_CashBook_ID) left join (select C_CashLine_ID, C_Cash_ID, Line, Amount, Description from C_CashLine) table7 on (C_Debt_Payment_Generate.C_CashLine_ID = table7.C_CashLine_ID) left join (select C_Cash_ID, Name from C_Cash) table8 on (table7.C_Cash_ID = table8.C_Cash_ID) left join (select C_BankAccount_ID, C_Bank_ID, DisplayedAccount from C_BankAccount) table9 on (C_Debt_Payment_Generate.C_BankAccount_ID = table9.C_BankAccount_ID) left join (select C_Bank_ID, Name from C_Bank) table10 on (table9.C_Bank_ID = table10.C_Bank_ID) left join (select C_BankStatementLine_ID, Line, StmtAmt, C_BankStatement_ID from C_BankStatementLine) table11 on (C_Debt_Payment_Generate.C_BankStatementLine_ID = table11.C_BankStatementLine_ID) left join (select C_BankStatement_ID, Name from C_BankStatement) table12 on (table11.C_BankStatement_ID = table12.C_BankStatement_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table13 on (C_Debt_Payment_Generate.C_Currency_ID = table13.C_Currency_ID)" +
      "        WHERE 2=2 " +
      " AND C_Debt_Payment_Generate.ismanual='N'" +
      "        AND 1=1 ";
    strSql = strSql + ((cSettlementId==null || cSettlementId.equals(""))?"":"  AND C_Debt_Payment_Generate.C_Settlement_ID = ?  ");
    strSql = strSql + 
      "        AND C_Debt_Payment_Generate.C_Debt_Payment_ID = ? " +
      "        AND C_Debt_Payment_Generate.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Debt_Payment_Generate.AD_Org_ID IN (";
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
        CreatedPaymentsData objectCreatedPaymentsData = new CreatedPaymentsData();
        objectCreatedPaymentsData.created = UtilSql.getValue(result, "created");
        objectCreatedPaymentsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCreatedPaymentsData.updated = UtilSql.getValue(result, "updated");
        objectCreatedPaymentsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCreatedPaymentsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectCreatedPaymentsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCreatedPaymentsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCreatedPaymentsData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectCreatedPaymentsData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectCreatedPaymentsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCreatedPaymentsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectCreatedPaymentsData.cSettlementId = UtilSql.getValue(result, "c_settlement_id");
        objectCreatedPaymentsData.cSettlementIdr = UtilSql.getValue(result, "c_settlement_idr");
        objectCreatedPaymentsData.isactive = UtilSql.getValue(result, "isactive");
        objectCreatedPaymentsData.cSettlementCancelId = UtilSql.getValue(result, "c_settlement_cancel_id");
        objectCreatedPaymentsData.cSettlementCancelIdr = UtilSql.getValue(result, "c_settlement_cancel_idr");
        objectCreatedPaymentsData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectCreatedPaymentsData.paymentruler = UtilSql.getValue(result, "paymentruler");
        objectCreatedPaymentsData.dateplanned = UtilSql.getDateValue(result, "dateplanned", "dd-MM-yyyy");
        objectCreatedPaymentsData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCreatedPaymentsData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectCreatedPaymentsData.description = UtilSql.getValue(result, "description");
        objectCreatedPaymentsData.cCashbookId = UtilSql.getValue(result, "c_cashbook_id");
        objectCreatedPaymentsData.cCashbookIdr = UtilSql.getValue(result, "c_cashbook_idr");
        objectCreatedPaymentsData.cCashlineId = UtilSql.getValue(result, "c_cashline_id");
        objectCreatedPaymentsData.cCashlineIdr = UtilSql.getValue(result, "c_cashline_idr");
        objectCreatedPaymentsData.cBankaccountId = UtilSql.getValue(result, "c_bankaccount_id");
        objectCreatedPaymentsData.cBankaccountIdr = UtilSql.getValue(result, "c_bankaccount_idr");
        objectCreatedPaymentsData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCreatedPaymentsData.cBankstatementlineId = UtilSql.getValue(result, "c_bankstatementline_id");
        objectCreatedPaymentsData.cBankstatementlineIdr = UtilSql.getValue(result, "c_bankstatementline_idr");
        objectCreatedPaymentsData.amount = UtilSql.getValue(result, "amount");
        objectCreatedPaymentsData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCreatedPaymentsData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectCreatedPaymentsData.writeoffamt = UtilSql.getValue(result, "writeoffamt");
        objectCreatedPaymentsData.discountamt = UtilSql.getValue(result, "discountamt");
        objectCreatedPaymentsData.isreceipt = UtilSql.getValue(result, "isreceipt");
        objectCreatedPaymentsData.ispaid = UtilSql.getValue(result, "ispaid");
        objectCreatedPaymentsData.ismanual = UtilSql.getValue(result, "ismanual");
        objectCreatedPaymentsData.isvalid = UtilSql.getValue(result, "isvalid");
        objectCreatedPaymentsData.generateProcessed = UtilSql.getValue(result, "generate_processed");
        objectCreatedPaymentsData.isdirectposting = UtilSql.getValue(result, "isdirectposting");
        objectCreatedPaymentsData.language = UtilSql.getValue(result, "language");
        objectCreatedPaymentsData.adUserClient = "";
        objectCreatedPaymentsData.adOrgClient = "";
        objectCreatedPaymentsData.createdby = "";
        objectCreatedPaymentsData.trBgcolor = "";
        objectCreatedPaymentsData.totalCount = "";
        objectCreatedPaymentsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreatedPaymentsData);
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
    CreatedPaymentsData objectCreatedPaymentsData[] = new CreatedPaymentsData[vector.size()];
    vector.copyInto(objectCreatedPaymentsData);
    return(objectCreatedPaymentsData);
  }

/**
Create a registry
 */
  public static CreatedPaymentsData[] set(String cSettlementId, String adClientId, String dateplanned, String ispaid, String cDebtPaymentId, String cInvoiceId, String description, String discountamt, String createdby, String createdbyr, String cBankstatementlineId, String isvalid, String paymentrule, String writeoffamt, String cSettlementCancelId, String isactive, String isreceipt, String cCashbookId, String ismanual, String adOrgId, String cBpartnerId, String cBpartnerIdr, String isdirectposting, String updatedby, String updatedbyr, String amount, String generateProcessed, String cBankaccountId, String cCashlineId, String cCurrencyId, String created)    throws ServletException {
    CreatedPaymentsData objectCreatedPaymentsData[] = new CreatedPaymentsData[1];
    objectCreatedPaymentsData[0] = new CreatedPaymentsData();
    objectCreatedPaymentsData[0].created = created;
    objectCreatedPaymentsData[0].createdbyr = createdbyr;
    objectCreatedPaymentsData[0].updated = "";
    objectCreatedPaymentsData[0].updatedTimeStamp = "";
    objectCreatedPaymentsData[0].updatedby = updatedby;
    objectCreatedPaymentsData[0].updatedbyr = updatedbyr;
    objectCreatedPaymentsData[0].adClientId = adClientId;
    objectCreatedPaymentsData[0].adClientIdr = "";
    objectCreatedPaymentsData[0].cDebtPaymentId = cDebtPaymentId;
    objectCreatedPaymentsData[0].adOrgId = adOrgId;
    objectCreatedPaymentsData[0].adOrgIdr = "";
    objectCreatedPaymentsData[0].cSettlementId = cSettlementId;
    objectCreatedPaymentsData[0].cSettlementIdr = "";
    objectCreatedPaymentsData[0].isactive = isactive;
    objectCreatedPaymentsData[0].cSettlementCancelId = cSettlementCancelId;
    objectCreatedPaymentsData[0].cSettlementCancelIdr = "";
    objectCreatedPaymentsData[0].paymentrule = paymentrule;
    objectCreatedPaymentsData[0].paymentruler = "";
    objectCreatedPaymentsData[0].dateplanned = dateplanned;
    objectCreatedPaymentsData[0].cBpartnerId = cBpartnerId;
    objectCreatedPaymentsData[0].cBpartnerIdr = cBpartnerIdr;
    objectCreatedPaymentsData[0].description = description;
    objectCreatedPaymentsData[0].cCashbookId = cCashbookId;
    objectCreatedPaymentsData[0].cCashbookIdr = "";
    objectCreatedPaymentsData[0].cCashlineId = cCashlineId;
    objectCreatedPaymentsData[0].cCashlineIdr = "";
    objectCreatedPaymentsData[0].cBankaccountId = cBankaccountId;
    objectCreatedPaymentsData[0].cBankaccountIdr = "";
    objectCreatedPaymentsData[0].cInvoiceId = cInvoiceId;
    objectCreatedPaymentsData[0].cBankstatementlineId = cBankstatementlineId;
    objectCreatedPaymentsData[0].cBankstatementlineIdr = "";
    objectCreatedPaymentsData[0].amount = amount;
    objectCreatedPaymentsData[0].cCurrencyId = cCurrencyId;
    objectCreatedPaymentsData[0].cCurrencyIdr = "";
    objectCreatedPaymentsData[0].writeoffamt = writeoffamt;
    objectCreatedPaymentsData[0].discountamt = discountamt;
    objectCreatedPaymentsData[0].isreceipt = isreceipt;
    objectCreatedPaymentsData[0].ispaid = ispaid;
    objectCreatedPaymentsData[0].ismanual = ismanual;
    objectCreatedPaymentsData[0].isvalid = isvalid;
    objectCreatedPaymentsData[0].generateProcessed = generateProcessed;
    objectCreatedPaymentsData[0].isdirectposting = isdirectposting;
    objectCreatedPaymentsData[0].language = "";
    return objectCreatedPaymentsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef800377_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef800384_1(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
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
  public static String selectDef800379_2(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
      "        SELECT C_Debt_Payment_Generate.C_Settlement_ID AS NAME" +
      "        FROM C_Debt_Payment_Generate" +
      "        WHERE C_Debt_Payment_Generate.C_Debt_Payment_ID = ?";

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
      "        UPDATE C_Debt_Payment_Generate" +
      "        SET C_Debt_Payment_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_Settlement_ID = (?) , IsActive = (?) , C_Settlement_Cancel_ID = (?) , PaymentRule = (?) , Dateplanned = TO_DATE(?) , C_BPartner_ID = (?) , Description = (?) , C_CashBook_ID = (?) , C_CashLine_ID = (?) , C_BankAccount_ID = (?) , C_BankStatementLine_ID = (?) , C_Invoice_ID = (?) , Amount = TO_NUMBER(?) , C_Currency_ID = (?) , WriteOffAmt = TO_NUMBER(?) , Discountamt = TO_NUMBER(?) , IsReceipt = (?) , IsPaid = (?) , IsManual = (?) , IsValid = (?) , Generate_Processed = (?) , Isdirectposting = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Debt_Payment_Generate.C_Debt_Payment_ID = ? " +
      "                 AND C_Debt_Payment_Generate.C_Settlement_ID = ? " +
      "        AND C_Debt_Payment_Generate.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Debt_Payment_Generate.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementCancelId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCashbookId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCashlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, writeoffamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discountamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreceipt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismanual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvalid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateProcessed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdirectposting);
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
      "        INSERT INTO C_Debt_Payment_Generate " +
      "        (AD_Client_ID, C_Debt_Payment_ID, AD_Org_ID, C_Settlement_ID, IsActive, C_Settlement_Cancel_ID, PaymentRule, Dateplanned, C_BPartner_ID, Description, C_CashBook_ID, C_CashLine_ID, C_BankAccount_ID, C_Invoice_ID, C_BankStatementLine_ID, Amount, C_Currency_ID, WriteOffAmt, Discountamt, IsReceipt, IsPaid, IsManual, IsValid, Generate_Processed, Isdirectposting, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementCancelId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCashbookId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCashlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, writeoffamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discountamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreceipt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismanual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvalid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateProcessed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdirectposting);
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
      "        DELETE FROM C_Debt_Payment_Generate" +
      "        WHERE C_Debt_Payment_Generate.C_Debt_Payment_ID = ? " +
      "                 AND C_Debt_Payment_Generate.C_Settlement_ID = ? " +
      "        AND C_Debt_Payment_Generate.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Debt_Payment_Generate.AD_Org_ID IN (";
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
      "        DELETE FROM C_Debt_Payment_Generate" +
      "        WHERE C_Debt_Payment_Generate.C_Debt_Payment_ID = ? " +
      "                 AND C_Debt_Payment_Generate.C_Settlement_ID = ? ";

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
      "          FROM C_Debt_Payment_Generate" +
      "         WHERE C_Debt_Payment_Generate.C_Debt_Payment_ID = ? ";

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
      "          FROM C_Debt_Payment_Generate" +
      "         WHERE C_Debt_Payment_Generate.C_Debt_Payment_ID = ? ";

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
