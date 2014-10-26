//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.AccountingSchema;

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
class DefaultsData implements FieldProvider {
static Logger log4j = Logger.getLogger(DefaultsData.class);
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
  public String cAcctschemaDefaultId;
  public String cAcctschemaId;
  public String cAcctschemaIdr;
  public String cReceivableAcct;
  public String cReceivableAcctr;
  public String cPrepaymentAcct;
  public String aDisposalGain;
  public String paydiscountExpAcct;
  public String aDisposalLoss;
  public String writeoffAcct;
  public String writeoffAcctr;
  public String arDiscountAcct;
  public String arDiscountAcctr;
  public String apDiscountAcct;
  public String apDiscountAcctr;
  public String notinvoicedreceivablesAcct;
  public String notinvoicedrevenueAcct;
  public String unearnedrevenueAcct;
  public String vLiabilityAcct;
  public String vLiabilityAcctr;
  public String vLiabilityServicesAcct;
  public String vPrepaymentAcct;
  public String paydiscountRevAcct;
  public String notinvoicedreceiptsAcct;
  public String notinvoicedreceiptsAcctr;
  public String ePrepaymentAcct;
  public String eExpenseAcct;
  public String pAssetAcct;
  public String pAssetAcctr;
  public String pExpenseAcct;
  public String pExpenseAcctr;
  public String pRevenueAcct;
  public String pRevenueAcctr;
  public String pCogsAcct;
  public String pCogsAcctr;
  public String pPurchasepricevarianceAcct;
  public String pInvoicepricevarianceAcct;
  public String pInvoicepricevarianceAcctr;
  public String pTradediscountrecAcct;
  public String pTradediscountgrantAcct;
  public String wInventoryAcct;
  public String wInventoryAcctr;
  public String wInvactualadjustAcct;
  public String wDifferencesAcct;
  public String wDifferencesAcctr;
  public String wRevaluationAcct;
  public String wRevaluationAcctr;
  public String bAssetAcct;
  public String bAssetAcctr;
  public String bIntransitAcct;
  public String bIntransitAcctr;
  public String bUnidentifiedAcct;
  public String bUnallocatedcashAcct;
  public String bPaymentselectAcct;
  public String bPaymentselectAcctr;
  public String bExpenseAcct;
  public String bExpenseAcctr;
  public String bInterestexpAcct;
  public String bInterestrevAcct;
  public String bRevaluationgainAcct;
  public String bRevaluationgainAcctr;
  public String bRevaluationlossAcct;
  public String bRevaluationlossAcctr;
  public String bSettlementlossAcct;
  public String bSettlementgainAcct;
  public String tDueAcct;
  public String tDueAcctr;
  public String tLiabilityAcct;
  public String tCreditAcct;
  public String tCreditAcctr;
  public String tReceivablesAcct;
  public String tExpenseAcct;
  public String chExpenseAcct;
  public String chExpenseAcctr;
  public String chRevenueAcct;
  public String unrealizedgainAcct;
  public String unrealizedlossAcct;
  public String realizedgainAcct;
  public String realizedlossAcct;
  public String cbAssetAcct;
  public String cbAssetAcctr;
  public String cbDifferencesAcct;
  public String cbDifferencesAcctr;
  public String cbCashtransferAcct;
  public String cbCashtransferAcctr;
  public String cbExpenseAcct;
  public String cbExpenseAcctr;
  public String cbReceiptAcct;
  public String cbReceiptAcctr;
  public String aDepreciationAcct;
  public String aDepreciationAcctr;
  public String aAccumdepreciationAcct;
  public String aAccumdepreciationAcctr;
  public String pjAssetAcct;
  public String pjAssetAcctr;
  public String pjWipAcct;
  public String pjWipAcctr;
  public String isactive;
  public String withholdingAcct;
  public String processing;
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
    else if (fieldName.equalsIgnoreCase("c_acctschema_default_id") || fieldName.equals("cAcctschemaDefaultId"))
      return cAcctschemaDefaultId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_idr") || fieldName.equals("cAcctschemaIdr"))
      return cAcctschemaIdr;
    else if (fieldName.equalsIgnoreCase("c_receivable_acct") || fieldName.equals("cReceivableAcct"))
      return cReceivableAcct;
    else if (fieldName.equalsIgnoreCase("c_receivable_acctr") || fieldName.equals("cReceivableAcctr"))
      return cReceivableAcctr;
    else if (fieldName.equalsIgnoreCase("c_prepayment_acct") || fieldName.equals("cPrepaymentAcct"))
      return cPrepaymentAcct;
    else if (fieldName.equalsIgnoreCase("a_disposal_gain") || fieldName.equals("aDisposalGain"))
      return aDisposalGain;
    else if (fieldName.equalsIgnoreCase("paydiscount_exp_acct") || fieldName.equals("paydiscountExpAcct"))
      return paydiscountExpAcct;
    else if (fieldName.equalsIgnoreCase("a_disposal_loss") || fieldName.equals("aDisposalLoss"))
      return aDisposalLoss;
    else if (fieldName.equalsIgnoreCase("writeoff_acct") || fieldName.equals("writeoffAcct"))
      return writeoffAcct;
    else if (fieldName.equalsIgnoreCase("writeoff_acctr") || fieldName.equals("writeoffAcctr"))
      return writeoffAcctr;
    else if (fieldName.equalsIgnoreCase("ar_discount_acct") || fieldName.equals("arDiscountAcct"))
      return arDiscountAcct;
    else if (fieldName.equalsIgnoreCase("ar_discount_acctr") || fieldName.equals("arDiscountAcctr"))
      return arDiscountAcctr;
    else if (fieldName.equalsIgnoreCase("ap_discount_acct") || fieldName.equals("apDiscountAcct"))
      return apDiscountAcct;
    else if (fieldName.equalsIgnoreCase("ap_discount_acctr") || fieldName.equals("apDiscountAcctr"))
      return apDiscountAcctr;
    else if (fieldName.equalsIgnoreCase("notinvoicedreceivables_acct") || fieldName.equals("notinvoicedreceivablesAcct"))
      return notinvoicedreceivablesAcct;
    else if (fieldName.equalsIgnoreCase("notinvoicedrevenue_acct") || fieldName.equals("notinvoicedrevenueAcct"))
      return notinvoicedrevenueAcct;
    else if (fieldName.equalsIgnoreCase("unearnedrevenue_acct") || fieldName.equals("unearnedrevenueAcct"))
      return unearnedrevenueAcct;
    else if (fieldName.equalsIgnoreCase("v_liability_acct") || fieldName.equals("vLiabilityAcct"))
      return vLiabilityAcct;
    else if (fieldName.equalsIgnoreCase("v_liability_acctr") || fieldName.equals("vLiabilityAcctr"))
      return vLiabilityAcctr;
    else if (fieldName.equalsIgnoreCase("v_liability_services_acct") || fieldName.equals("vLiabilityServicesAcct"))
      return vLiabilityServicesAcct;
    else if (fieldName.equalsIgnoreCase("v_prepayment_acct") || fieldName.equals("vPrepaymentAcct"))
      return vPrepaymentAcct;
    else if (fieldName.equalsIgnoreCase("paydiscount_rev_acct") || fieldName.equals("paydiscountRevAcct"))
      return paydiscountRevAcct;
    else if (fieldName.equalsIgnoreCase("notinvoicedreceipts_acct") || fieldName.equals("notinvoicedreceiptsAcct"))
      return notinvoicedreceiptsAcct;
    else if (fieldName.equalsIgnoreCase("notinvoicedreceipts_acctr") || fieldName.equals("notinvoicedreceiptsAcctr"))
      return notinvoicedreceiptsAcctr;
    else if (fieldName.equalsIgnoreCase("e_prepayment_acct") || fieldName.equals("ePrepaymentAcct"))
      return ePrepaymentAcct;
    else if (fieldName.equalsIgnoreCase("e_expense_acct") || fieldName.equals("eExpenseAcct"))
      return eExpenseAcct;
    else if (fieldName.equalsIgnoreCase("p_asset_acct") || fieldName.equals("pAssetAcct"))
      return pAssetAcct;
    else if (fieldName.equalsIgnoreCase("p_asset_acctr") || fieldName.equals("pAssetAcctr"))
      return pAssetAcctr;
    else if (fieldName.equalsIgnoreCase("p_expense_acct") || fieldName.equals("pExpenseAcct"))
      return pExpenseAcct;
    else if (fieldName.equalsIgnoreCase("p_expense_acctr") || fieldName.equals("pExpenseAcctr"))
      return pExpenseAcctr;
    else if (fieldName.equalsIgnoreCase("p_revenue_acct") || fieldName.equals("pRevenueAcct"))
      return pRevenueAcct;
    else if (fieldName.equalsIgnoreCase("p_revenue_acctr") || fieldName.equals("pRevenueAcctr"))
      return pRevenueAcctr;
    else if (fieldName.equalsIgnoreCase("p_cogs_acct") || fieldName.equals("pCogsAcct"))
      return pCogsAcct;
    else if (fieldName.equalsIgnoreCase("p_cogs_acctr") || fieldName.equals("pCogsAcctr"))
      return pCogsAcctr;
    else if (fieldName.equalsIgnoreCase("p_purchasepricevariance_acct") || fieldName.equals("pPurchasepricevarianceAcct"))
      return pPurchasepricevarianceAcct;
    else if (fieldName.equalsIgnoreCase("p_invoicepricevariance_acct") || fieldName.equals("pInvoicepricevarianceAcct"))
      return pInvoicepricevarianceAcct;
    else if (fieldName.equalsIgnoreCase("p_invoicepricevariance_acctr") || fieldName.equals("pInvoicepricevarianceAcctr"))
      return pInvoicepricevarianceAcctr;
    else if (fieldName.equalsIgnoreCase("p_tradediscountrec_acct") || fieldName.equals("pTradediscountrecAcct"))
      return pTradediscountrecAcct;
    else if (fieldName.equalsIgnoreCase("p_tradediscountgrant_acct") || fieldName.equals("pTradediscountgrantAcct"))
      return pTradediscountgrantAcct;
    else if (fieldName.equalsIgnoreCase("w_inventory_acct") || fieldName.equals("wInventoryAcct"))
      return wInventoryAcct;
    else if (fieldName.equalsIgnoreCase("w_inventory_acctr") || fieldName.equals("wInventoryAcctr"))
      return wInventoryAcctr;
    else if (fieldName.equalsIgnoreCase("w_invactualadjust_acct") || fieldName.equals("wInvactualadjustAcct"))
      return wInvactualadjustAcct;
    else if (fieldName.equalsIgnoreCase("w_differences_acct") || fieldName.equals("wDifferencesAcct"))
      return wDifferencesAcct;
    else if (fieldName.equalsIgnoreCase("w_differences_acctr") || fieldName.equals("wDifferencesAcctr"))
      return wDifferencesAcctr;
    else if (fieldName.equalsIgnoreCase("w_revaluation_acct") || fieldName.equals("wRevaluationAcct"))
      return wRevaluationAcct;
    else if (fieldName.equalsIgnoreCase("w_revaluation_acctr") || fieldName.equals("wRevaluationAcctr"))
      return wRevaluationAcctr;
    else if (fieldName.equalsIgnoreCase("b_asset_acct") || fieldName.equals("bAssetAcct"))
      return bAssetAcct;
    else if (fieldName.equalsIgnoreCase("b_asset_acctr") || fieldName.equals("bAssetAcctr"))
      return bAssetAcctr;
    else if (fieldName.equalsIgnoreCase("b_intransit_acct") || fieldName.equals("bIntransitAcct"))
      return bIntransitAcct;
    else if (fieldName.equalsIgnoreCase("b_intransit_acctr") || fieldName.equals("bIntransitAcctr"))
      return bIntransitAcctr;
    else if (fieldName.equalsIgnoreCase("b_unidentified_acct") || fieldName.equals("bUnidentifiedAcct"))
      return bUnidentifiedAcct;
    else if (fieldName.equalsIgnoreCase("b_unallocatedcash_acct") || fieldName.equals("bUnallocatedcashAcct"))
      return bUnallocatedcashAcct;
    else if (fieldName.equalsIgnoreCase("b_paymentselect_acct") || fieldName.equals("bPaymentselectAcct"))
      return bPaymentselectAcct;
    else if (fieldName.equalsIgnoreCase("b_paymentselect_acctr") || fieldName.equals("bPaymentselectAcctr"))
      return bPaymentselectAcctr;
    else if (fieldName.equalsIgnoreCase("b_expense_acct") || fieldName.equals("bExpenseAcct"))
      return bExpenseAcct;
    else if (fieldName.equalsIgnoreCase("b_expense_acctr") || fieldName.equals("bExpenseAcctr"))
      return bExpenseAcctr;
    else if (fieldName.equalsIgnoreCase("b_interestexp_acct") || fieldName.equals("bInterestexpAcct"))
      return bInterestexpAcct;
    else if (fieldName.equalsIgnoreCase("b_interestrev_acct") || fieldName.equals("bInterestrevAcct"))
      return bInterestrevAcct;
    else if (fieldName.equalsIgnoreCase("b_revaluationgain_acct") || fieldName.equals("bRevaluationgainAcct"))
      return bRevaluationgainAcct;
    else if (fieldName.equalsIgnoreCase("b_revaluationgain_acctr") || fieldName.equals("bRevaluationgainAcctr"))
      return bRevaluationgainAcctr;
    else if (fieldName.equalsIgnoreCase("b_revaluationloss_acct") || fieldName.equals("bRevaluationlossAcct"))
      return bRevaluationlossAcct;
    else if (fieldName.equalsIgnoreCase("b_revaluationloss_acctr") || fieldName.equals("bRevaluationlossAcctr"))
      return bRevaluationlossAcctr;
    else if (fieldName.equalsIgnoreCase("b_settlementloss_acct") || fieldName.equals("bSettlementlossAcct"))
      return bSettlementlossAcct;
    else if (fieldName.equalsIgnoreCase("b_settlementgain_acct") || fieldName.equals("bSettlementgainAcct"))
      return bSettlementgainAcct;
    else if (fieldName.equalsIgnoreCase("t_due_acct") || fieldName.equals("tDueAcct"))
      return tDueAcct;
    else if (fieldName.equalsIgnoreCase("t_due_acctr") || fieldName.equals("tDueAcctr"))
      return tDueAcctr;
    else if (fieldName.equalsIgnoreCase("t_liability_acct") || fieldName.equals("tLiabilityAcct"))
      return tLiabilityAcct;
    else if (fieldName.equalsIgnoreCase("t_credit_acct") || fieldName.equals("tCreditAcct"))
      return tCreditAcct;
    else if (fieldName.equalsIgnoreCase("t_credit_acctr") || fieldName.equals("tCreditAcctr"))
      return tCreditAcctr;
    else if (fieldName.equalsIgnoreCase("t_receivables_acct") || fieldName.equals("tReceivablesAcct"))
      return tReceivablesAcct;
    else if (fieldName.equalsIgnoreCase("t_expense_acct") || fieldName.equals("tExpenseAcct"))
      return tExpenseAcct;
    else if (fieldName.equalsIgnoreCase("ch_expense_acct") || fieldName.equals("chExpenseAcct"))
      return chExpenseAcct;
    else if (fieldName.equalsIgnoreCase("ch_expense_acctr") || fieldName.equals("chExpenseAcctr"))
      return chExpenseAcctr;
    else if (fieldName.equalsIgnoreCase("ch_revenue_acct") || fieldName.equals("chRevenueAcct"))
      return chRevenueAcct;
    else if (fieldName.equalsIgnoreCase("unrealizedgain_acct") || fieldName.equals("unrealizedgainAcct"))
      return unrealizedgainAcct;
    else if (fieldName.equalsIgnoreCase("unrealizedloss_acct") || fieldName.equals("unrealizedlossAcct"))
      return unrealizedlossAcct;
    else if (fieldName.equalsIgnoreCase("realizedgain_acct") || fieldName.equals("realizedgainAcct"))
      return realizedgainAcct;
    else if (fieldName.equalsIgnoreCase("realizedloss_acct") || fieldName.equals("realizedlossAcct"))
      return realizedlossAcct;
    else if (fieldName.equalsIgnoreCase("cb_asset_acct") || fieldName.equals("cbAssetAcct"))
      return cbAssetAcct;
    else if (fieldName.equalsIgnoreCase("cb_asset_acctr") || fieldName.equals("cbAssetAcctr"))
      return cbAssetAcctr;
    else if (fieldName.equalsIgnoreCase("cb_differences_acct") || fieldName.equals("cbDifferencesAcct"))
      return cbDifferencesAcct;
    else if (fieldName.equalsIgnoreCase("cb_differences_acctr") || fieldName.equals("cbDifferencesAcctr"))
      return cbDifferencesAcctr;
    else if (fieldName.equalsIgnoreCase("cb_cashtransfer_acct") || fieldName.equals("cbCashtransferAcct"))
      return cbCashtransferAcct;
    else if (fieldName.equalsIgnoreCase("cb_cashtransfer_acctr") || fieldName.equals("cbCashtransferAcctr"))
      return cbCashtransferAcctr;
    else if (fieldName.equalsIgnoreCase("cb_expense_acct") || fieldName.equals("cbExpenseAcct"))
      return cbExpenseAcct;
    else if (fieldName.equalsIgnoreCase("cb_expense_acctr") || fieldName.equals("cbExpenseAcctr"))
      return cbExpenseAcctr;
    else if (fieldName.equalsIgnoreCase("cb_receipt_acct") || fieldName.equals("cbReceiptAcct"))
      return cbReceiptAcct;
    else if (fieldName.equalsIgnoreCase("cb_receipt_acctr") || fieldName.equals("cbReceiptAcctr"))
      return cbReceiptAcctr;
    else if (fieldName.equalsIgnoreCase("a_depreciation_acct") || fieldName.equals("aDepreciationAcct"))
      return aDepreciationAcct;
    else if (fieldName.equalsIgnoreCase("a_depreciation_acctr") || fieldName.equals("aDepreciationAcctr"))
      return aDepreciationAcctr;
    else if (fieldName.equalsIgnoreCase("a_accumdepreciation_acct") || fieldName.equals("aAccumdepreciationAcct"))
      return aAccumdepreciationAcct;
    else if (fieldName.equalsIgnoreCase("a_accumdepreciation_acctr") || fieldName.equals("aAccumdepreciationAcctr"))
      return aAccumdepreciationAcctr;
    else if (fieldName.equalsIgnoreCase("pj_asset_acct") || fieldName.equals("pjAssetAcct"))
      return pjAssetAcct;
    else if (fieldName.equalsIgnoreCase("pj_asset_acctr") || fieldName.equals("pjAssetAcctr"))
      return pjAssetAcctr;
    else if (fieldName.equalsIgnoreCase("pj_wip_acct") || fieldName.equals("pjWipAcct"))
      return pjWipAcct;
    else if (fieldName.equalsIgnoreCase("pj_wip_acctr") || fieldName.equals("pjWipAcctr"))
      return pjWipAcctr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("withholding_acct") || fieldName.equals("withholdingAcct"))
      return withholdingAcct;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
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
  public static DefaultsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cAcctschemaId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cAcctschemaId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static DefaultsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cAcctschemaId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_AcctSchema_Default.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_AcctSchema_Default.CreatedBy) as CreatedByR, " +
      "        to_char(C_AcctSchema_Default.Updated, ?) as updated, " +
      "        to_char(C_AcctSchema_Default.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_AcctSchema_Default.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_AcctSchema_Default.UpdatedBy) as UpdatedByR," +
      "        C_AcctSchema_Default.AD_Client_ID, " +
      "(CASE WHEN C_AcctSchema_Default.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_AcctSchema_Default.AD_Org_ID, " +
      "(CASE WHEN C_AcctSchema_Default.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_AcctSchema_Default.C_Acctschema_Default_ID, " +
      "C_AcctSchema_Default.C_AcctSchema_ID, " +
      "(CASE WHEN C_AcctSchema_Default.C_AcctSchema_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_AcctSchema_IDR, " +
      "C_AcctSchema_Default.C_Receivable_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.C_Receivable_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Combination), ''))),'') ) END) AS C_Receivable_AcctR, " +
      "C_AcctSchema_Default.C_Prepayment_Acct, " +
      "C_AcctSchema_Default.A_Disposal_Gain, " +
      "C_AcctSchema_Default.PayDiscount_Exp_Acct, " +
      "C_AcctSchema_Default.A_Disposal_Loss, " +
      "C_AcctSchema_Default.WriteOff_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.WriteOff_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Combination), ''))),'') ) END) AS WriteOff_AcctR, " +
      "C_AcctSchema_Default.AR_Discount_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.AR_Discount_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Combination), ''))),'') ) END) AS AR_Discount_AcctR, " +
      "C_AcctSchema_Default.AP_Discount_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.AP_Discount_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Combination), ''))),'') ) END) AS AP_Discount_AcctR, " +
      "C_AcctSchema_Default.NotInvoicedReceivables_Acct, " +
      "C_AcctSchema_Default.NotInvoicedRevenue_Acct, " +
      "C_AcctSchema_Default.UnEarnedRevenue_Acct, " +
      "C_AcctSchema_Default.V_Liability_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.V_Liability_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Combination), ''))),'') ) END) AS V_Liability_AcctR, " +
      "C_AcctSchema_Default.V_Liability_Services_Acct, " +
      "C_AcctSchema_Default.V_Prepayment_Acct, " +
      "C_AcctSchema_Default.PayDiscount_Rev_Acct, " +
      "C_AcctSchema_Default.NotInvoicedReceipts_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.NotInvoicedReceipts_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Combination), ''))),'') ) END) AS NotInvoicedReceipts_AcctR, " +
      "C_AcctSchema_Default.E_Prepayment_Acct, " +
      "C_AcctSchema_Default.E_Expense_Acct, " +
      "C_AcctSchema_Default.P_Asset_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.P_Asset_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Combination), ''))),'') ) END) AS P_Asset_AcctR, " +
      "C_AcctSchema_Default.P_Expense_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.P_Expense_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Combination), ''))),'') ) END) AS P_Expense_AcctR, " +
      "C_AcctSchema_Default.P_Revenue_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.P_Revenue_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Combination), ''))),'') ) END) AS P_Revenue_AcctR, " +
      "C_AcctSchema_Default.P_Cogs_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.P_Cogs_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.Combination), ''))),'') ) END) AS P_Cogs_AcctR, " +
      "C_AcctSchema_Default.P_PurchasePriceVariance_Acct, " +
      "C_AcctSchema_Default.P_InvoicePriceVariance_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.P_InvoicePriceVariance_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Combination), ''))),'') ) END) AS P_InvoicePriceVariance_AcctR, " +
      "C_AcctSchema_Default.P_TradeDiscountRec_Acct, " +
      "C_AcctSchema_Default.P_TradeDiscountGrant_Acct, " +
      "C_AcctSchema_Default.W_Inventory_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.W_Inventory_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Combination), ''))),'') ) END) AS W_Inventory_AcctR, " +
      "C_AcctSchema_Default.W_InvActualAdjust_Acct, " +
      "C_AcctSchema_Default.W_Differences_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.W_Differences_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Combination), ''))),'') ) END) AS W_Differences_AcctR, " +
      "C_AcctSchema_Default.W_Revaluation_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.W_Revaluation_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table17.Combination), ''))),'') ) END) AS W_Revaluation_AcctR, " +
      "C_AcctSchema_Default.B_Asset_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.B_Asset_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table18.Combination), ''))),'') ) END) AS B_Asset_AcctR, " +
      "C_AcctSchema_Default.B_InTransit_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.B_InTransit_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.Combination), ''))),'') ) END) AS B_InTransit_AcctR, " +
      "C_AcctSchema_Default.B_Unidentified_Acct, " +
      "C_AcctSchema_Default.B_UnallocatedCash_Acct, " +
      "C_AcctSchema_Default.B_PaymentSelect_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.B_PaymentSelect_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table20.Combination), ''))),'') ) END) AS B_PaymentSelect_AcctR, " +
      "C_AcctSchema_Default.B_Expense_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.B_Expense_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table21.Combination), ''))),'') ) END) AS B_Expense_AcctR, " +
      "C_AcctSchema_Default.B_InterestExp_Acct, " +
      "C_AcctSchema_Default.B_InterestRev_Acct, " +
      "C_AcctSchema_Default.B_RevaluationGain_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.B_RevaluationGain_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table22.Combination), ''))),'') ) END) AS B_RevaluationGain_AcctR, " +
      "C_AcctSchema_Default.B_RevaluationLoss_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.B_RevaluationLoss_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table23.Combination), ''))),'') ) END) AS B_RevaluationLoss_AcctR, " +
      "C_AcctSchema_Default.B_SettlementLoss_Acct, " +
      "C_AcctSchema_Default.B_SettlementGain_Acct, " +
      "C_AcctSchema_Default.T_Due_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.T_Due_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table24.Combination), ''))),'') ) END) AS T_Due_AcctR, " +
      "C_AcctSchema_Default.T_Liability_Acct, " +
      "C_AcctSchema_Default.T_Credit_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.T_Credit_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table25.Combination), ''))),'') ) END) AS T_Credit_AcctR, " +
      "C_AcctSchema_Default.T_Receivables_Acct, " +
      "C_AcctSchema_Default.T_Expense_Acct, " +
      "C_AcctSchema_Default.Ch_Expense_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.Ch_Expense_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table26.Combination), ''))),'') ) END) AS Ch_Expense_AcctR, " +
      "C_AcctSchema_Default.Ch_Revenue_Acct, " +
      "C_AcctSchema_Default.UnrealizedGain_Acct, " +
      "C_AcctSchema_Default.UnrealizedLoss_Acct, " +
      "C_AcctSchema_Default.RealizedGain_Acct, " +
      "C_AcctSchema_Default.RealizedLoss_Acct, " +
      "C_AcctSchema_Default.CB_Asset_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.CB_Asset_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table27.Combination), ''))),'') ) END) AS CB_Asset_AcctR, " +
      "C_AcctSchema_Default.CB_Differences_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.CB_Differences_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table28.Combination), ''))),'') ) END) AS CB_Differences_AcctR, " +
      "C_AcctSchema_Default.CB_CashTransfer_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.CB_CashTransfer_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table29.Combination), ''))),'') ) END) AS CB_CashTransfer_AcctR, " +
      "C_AcctSchema_Default.CB_Expense_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.CB_Expense_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table30.Combination), ''))),'') ) END) AS CB_Expense_AcctR, " +
      "C_AcctSchema_Default.CB_Receipt_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.CB_Receipt_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table31.Combination), ''))),'') ) END) AS CB_Receipt_AcctR, " +
      "C_AcctSchema_Default.A_Depreciation_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.A_Depreciation_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table32.Combination), ''))),'') ) END) AS A_Depreciation_AcctR, " +
      "C_AcctSchema_Default.A_Accumdepreciation_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.A_Accumdepreciation_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table33.Combination), ''))),'') ) END) AS A_Accumdepreciation_AcctR, " +
      "C_AcctSchema_Default.PJ_Asset_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.PJ_Asset_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table34.Combination), ''))),'') ) END) AS PJ_Asset_AcctR, " +
      "C_AcctSchema_Default.PJ_WIP_Acct, " +
      "(CASE WHEN C_AcctSchema_Default.PJ_WIP_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table35.Combination), ''))),'') ) END) AS PJ_WIP_AcctR, " +
      "COALESCE(C_AcctSchema_Default.IsActive, 'N') AS IsActive, " +
      "C_AcctSchema_Default.Withholding_Acct, " +
      "C_AcctSchema_Default.Processing, " +
      "        ? AS LANGUAGE " +
      "        FROM C_AcctSchema_Default left join (select AD_Client_ID, Name from AD_Client) table1 on (C_AcctSchema_Default.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_AcctSchema_Default.AD_Org_ID = table2.AD_Org_ID) left join (select C_AcctSchema_ID, Name from C_AcctSchema) table3 on (C_AcctSchema_Default.C_AcctSchema_ID = table3.C_AcctSchema_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table4 on (C_AcctSchema_Default.C_Receivable_Acct = table4.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table5 on (C_AcctSchema_Default.WriteOff_Acct = table5.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table6 on (C_AcctSchema_Default.AR_Discount_Acct = table6.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table7 on (C_AcctSchema_Default.AP_Discount_Acct = table7.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table8 on (C_AcctSchema_Default.V_Liability_Acct = table8.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table9 on (C_AcctSchema_Default.NotInvoicedReceipts_Acct = table9.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table10 on (C_AcctSchema_Default.P_Asset_Acct = table10.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table11 on (C_AcctSchema_Default.P_Expense_Acct = table11.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table12 on (C_AcctSchema_Default.P_Revenue_Acct = table12.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table13 on (C_AcctSchema_Default.P_Cogs_Acct = table13.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table14 on (C_AcctSchema_Default.P_InvoicePriceVariance_Acct = table14.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table15 on (C_AcctSchema_Default.W_Inventory_Acct = table15.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table16 on (C_AcctSchema_Default.W_Differences_Acct = table16.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table17 on (C_AcctSchema_Default.W_Revaluation_Acct = table17.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table18 on (C_AcctSchema_Default.B_Asset_Acct = table18.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table19 on (C_AcctSchema_Default.B_InTransit_Acct = table19.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table20 on (C_AcctSchema_Default.B_PaymentSelect_Acct = table20.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table21 on (C_AcctSchema_Default.B_Expense_Acct = table21.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table22 on (C_AcctSchema_Default.B_RevaluationGain_Acct = table22.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table23 on (C_AcctSchema_Default.B_RevaluationLoss_Acct = table23.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table24 on (C_AcctSchema_Default.T_Due_Acct = table24.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table25 on (C_AcctSchema_Default.T_Credit_Acct = table25.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table26 on (C_AcctSchema_Default.Ch_Expense_Acct = table26.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table27 on (C_AcctSchema_Default.CB_Asset_Acct = table27.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table28 on (C_AcctSchema_Default.CB_Differences_Acct = table28.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table29 on (C_AcctSchema_Default.CB_CashTransfer_Acct = table29.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table30 on (C_AcctSchema_Default.CB_Expense_Acct = table30.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table31 on (C_AcctSchema_Default.CB_Receipt_Acct = table31.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table32 on (C_AcctSchema_Default.A_Depreciation_Acct = table32.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table33 on (C_AcctSchema_Default.A_Accumdepreciation_Acct = table33.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table34 on (C_AcctSchema_Default.PJ_Asset_Acct = table34.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table35 on (C_AcctSchema_Default.PJ_WIP_Acct = table35.C_ValidCombination_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cAcctschemaId==null || cAcctschemaId.equals(""))?"":"  AND C_AcctSchema_Default.C_AcctSchema_ID = ?  ");
    strSql = strSql + 
      "        AND C_AcctSchema_Default.C_Acctschema_Default_ID = ? " +
      "        AND C_AcctSchema_Default.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_AcctSchema_Default.AD_Org_ID IN (";
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
      if (cAcctschemaId != null && !(cAcctschemaId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
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
        DefaultsData objectDefaultsData = new DefaultsData();
        objectDefaultsData.created = UtilSql.getValue(result, "created");
        objectDefaultsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectDefaultsData.updated = UtilSql.getValue(result, "updated");
        objectDefaultsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectDefaultsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDefaultsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectDefaultsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDefaultsData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectDefaultsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDefaultsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectDefaultsData.cAcctschemaDefaultId = UtilSql.getValue(result, "c_acctschema_default_id");
        objectDefaultsData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectDefaultsData.cAcctschemaIdr = UtilSql.getValue(result, "c_acctschema_idr");
        objectDefaultsData.cReceivableAcct = UtilSql.getValue(result, "c_receivable_acct");
        objectDefaultsData.cReceivableAcctr = UtilSql.getValue(result, "c_receivable_acctr");
        objectDefaultsData.cPrepaymentAcct = UtilSql.getValue(result, "c_prepayment_acct");
        objectDefaultsData.aDisposalGain = UtilSql.getValue(result, "a_disposal_gain");
        objectDefaultsData.paydiscountExpAcct = UtilSql.getValue(result, "paydiscount_exp_acct");
        objectDefaultsData.aDisposalLoss = UtilSql.getValue(result, "a_disposal_loss");
        objectDefaultsData.writeoffAcct = UtilSql.getValue(result, "writeoff_acct");
        objectDefaultsData.writeoffAcctr = UtilSql.getValue(result, "writeoff_acctr");
        objectDefaultsData.arDiscountAcct = UtilSql.getValue(result, "ar_discount_acct");
        objectDefaultsData.arDiscountAcctr = UtilSql.getValue(result, "ar_discount_acctr");
        objectDefaultsData.apDiscountAcct = UtilSql.getValue(result, "ap_discount_acct");
        objectDefaultsData.apDiscountAcctr = UtilSql.getValue(result, "ap_discount_acctr");
        objectDefaultsData.notinvoicedreceivablesAcct = UtilSql.getValue(result, "notinvoicedreceivables_acct");
        objectDefaultsData.notinvoicedrevenueAcct = UtilSql.getValue(result, "notinvoicedrevenue_acct");
        objectDefaultsData.unearnedrevenueAcct = UtilSql.getValue(result, "unearnedrevenue_acct");
        objectDefaultsData.vLiabilityAcct = UtilSql.getValue(result, "v_liability_acct");
        objectDefaultsData.vLiabilityAcctr = UtilSql.getValue(result, "v_liability_acctr");
        objectDefaultsData.vLiabilityServicesAcct = UtilSql.getValue(result, "v_liability_services_acct");
        objectDefaultsData.vPrepaymentAcct = UtilSql.getValue(result, "v_prepayment_acct");
        objectDefaultsData.paydiscountRevAcct = UtilSql.getValue(result, "paydiscount_rev_acct");
        objectDefaultsData.notinvoicedreceiptsAcct = UtilSql.getValue(result, "notinvoicedreceipts_acct");
        objectDefaultsData.notinvoicedreceiptsAcctr = UtilSql.getValue(result, "notinvoicedreceipts_acctr");
        objectDefaultsData.ePrepaymentAcct = UtilSql.getValue(result, "e_prepayment_acct");
        objectDefaultsData.eExpenseAcct = UtilSql.getValue(result, "e_expense_acct");
        objectDefaultsData.pAssetAcct = UtilSql.getValue(result, "p_asset_acct");
        objectDefaultsData.pAssetAcctr = UtilSql.getValue(result, "p_asset_acctr");
        objectDefaultsData.pExpenseAcct = UtilSql.getValue(result, "p_expense_acct");
        objectDefaultsData.pExpenseAcctr = UtilSql.getValue(result, "p_expense_acctr");
        objectDefaultsData.pRevenueAcct = UtilSql.getValue(result, "p_revenue_acct");
        objectDefaultsData.pRevenueAcctr = UtilSql.getValue(result, "p_revenue_acctr");
        objectDefaultsData.pCogsAcct = UtilSql.getValue(result, "p_cogs_acct");
        objectDefaultsData.pCogsAcctr = UtilSql.getValue(result, "p_cogs_acctr");
        objectDefaultsData.pPurchasepricevarianceAcct = UtilSql.getValue(result, "p_purchasepricevariance_acct");
        objectDefaultsData.pInvoicepricevarianceAcct = UtilSql.getValue(result, "p_invoicepricevariance_acct");
        objectDefaultsData.pInvoicepricevarianceAcctr = UtilSql.getValue(result, "p_invoicepricevariance_acctr");
        objectDefaultsData.pTradediscountrecAcct = UtilSql.getValue(result, "p_tradediscountrec_acct");
        objectDefaultsData.pTradediscountgrantAcct = UtilSql.getValue(result, "p_tradediscountgrant_acct");
        objectDefaultsData.wInventoryAcct = UtilSql.getValue(result, "w_inventory_acct");
        objectDefaultsData.wInventoryAcctr = UtilSql.getValue(result, "w_inventory_acctr");
        objectDefaultsData.wInvactualadjustAcct = UtilSql.getValue(result, "w_invactualadjust_acct");
        objectDefaultsData.wDifferencesAcct = UtilSql.getValue(result, "w_differences_acct");
        objectDefaultsData.wDifferencesAcctr = UtilSql.getValue(result, "w_differences_acctr");
        objectDefaultsData.wRevaluationAcct = UtilSql.getValue(result, "w_revaluation_acct");
        objectDefaultsData.wRevaluationAcctr = UtilSql.getValue(result, "w_revaluation_acctr");
        objectDefaultsData.bAssetAcct = UtilSql.getValue(result, "b_asset_acct");
        objectDefaultsData.bAssetAcctr = UtilSql.getValue(result, "b_asset_acctr");
        objectDefaultsData.bIntransitAcct = UtilSql.getValue(result, "b_intransit_acct");
        objectDefaultsData.bIntransitAcctr = UtilSql.getValue(result, "b_intransit_acctr");
        objectDefaultsData.bUnidentifiedAcct = UtilSql.getValue(result, "b_unidentified_acct");
        objectDefaultsData.bUnallocatedcashAcct = UtilSql.getValue(result, "b_unallocatedcash_acct");
        objectDefaultsData.bPaymentselectAcct = UtilSql.getValue(result, "b_paymentselect_acct");
        objectDefaultsData.bPaymentselectAcctr = UtilSql.getValue(result, "b_paymentselect_acctr");
        objectDefaultsData.bExpenseAcct = UtilSql.getValue(result, "b_expense_acct");
        objectDefaultsData.bExpenseAcctr = UtilSql.getValue(result, "b_expense_acctr");
        objectDefaultsData.bInterestexpAcct = UtilSql.getValue(result, "b_interestexp_acct");
        objectDefaultsData.bInterestrevAcct = UtilSql.getValue(result, "b_interestrev_acct");
        objectDefaultsData.bRevaluationgainAcct = UtilSql.getValue(result, "b_revaluationgain_acct");
        objectDefaultsData.bRevaluationgainAcctr = UtilSql.getValue(result, "b_revaluationgain_acctr");
        objectDefaultsData.bRevaluationlossAcct = UtilSql.getValue(result, "b_revaluationloss_acct");
        objectDefaultsData.bRevaluationlossAcctr = UtilSql.getValue(result, "b_revaluationloss_acctr");
        objectDefaultsData.bSettlementlossAcct = UtilSql.getValue(result, "b_settlementloss_acct");
        objectDefaultsData.bSettlementgainAcct = UtilSql.getValue(result, "b_settlementgain_acct");
        objectDefaultsData.tDueAcct = UtilSql.getValue(result, "t_due_acct");
        objectDefaultsData.tDueAcctr = UtilSql.getValue(result, "t_due_acctr");
        objectDefaultsData.tLiabilityAcct = UtilSql.getValue(result, "t_liability_acct");
        objectDefaultsData.tCreditAcct = UtilSql.getValue(result, "t_credit_acct");
        objectDefaultsData.tCreditAcctr = UtilSql.getValue(result, "t_credit_acctr");
        objectDefaultsData.tReceivablesAcct = UtilSql.getValue(result, "t_receivables_acct");
        objectDefaultsData.tExpenseAcct = UtilSql.getValue(result, "t_expense_acct");
        objectDefaultsData.chExpenseAcct = UtilSql.getValue(result, "ch_expense_acct");
        objectDefaultsData.chExpenseAcctr = UtilSql.getValue(result, "ch_expense_acctr");
        objectDefaultsData.chRevenueAcct = UtilSql.getValue(result, "ch_revenue_acct");
        objectDefaultsData.unrealizedgainAcct = UtilSql.getValue(result, "unrealizedgain_acct");
        objectDefaultsData.unrealizedlossAcct = UtilSql.getValue(result, "unrealizedloss_acct");
        objectDefaultsData.realizedgainAcct = UtilSql.getValue(result, "realizedgain_acct");
        objectDefaultsData.realizedlossAcct = UtilSql.getValue(result, "realizedloss_acct");
        objectDefaultsData.cbAssetAcct = UtilSql.getValue(result, "cb_asset_acct");
        objectDefaultsData.cbAssetAcctr = UtilSql.getValue(result, "cb_asset_acctr");
        objectDefaultsData.cbDifferencesAcct = UtilSql.getValue(result, "cb_differences_acct");
        objectDefaultsData.cbDifferencesAcctr = UtilSql.getValue(result, "cb_differences_acctr");
        objectDefaultsData.cbCashtransferAcct = UtilSql.getValue(result, "cb_cashtransfer_acct");
        objectDefaultsData.cbCashtransferAcctr = UtilSql.getValue(result, "cb_cashtransfer_acctr");
        objectDefaultsData.cbExpenseAcct = UtilSql.getValue(result, "cb_expense_acct");
        objectDefaultsData.cbExpenseAcctr = UtilSql.getValue(result, "cb_expense_acctr");
        objectDefaultsData.cbReceiptAcct = UtilSql.getValue(result, "cb_receipt_acct");
        objectDefaultsData.cbReceiptAcctr = UtilSql.getValue(result, "cb_receipt_acctr");
        objectDefaultsData.aDepreciationAcct = UtilSql.getValue(result, "a_depreciation_acct");
        objectDefaultsData.aDepreciationAcctr = UtilSql.getValue(result, "a_depreciation_acctr");
        objectDefaultsData.aAccumdepreciationAcct = UtilSql.getValue(result, "a_accumdepreciation_acct");
        objectDefaultsData.aAccumdepreciationAcctr = UtilSql.getValue(result, "a_accumdepreciation_acctr");
        objectDefaultsData.pjAssetAcct = UtilSql.getValue(result, "pj_asset_acct");
        objectDefaultsData.pjAssetAcctr = UtilSql.getValue(result, "pj_asset_acctr");
        objectDefaultsData.pjWipAcct = UtilSql.getValue(result, "pj_wip_acct");
        objectDefaultsData.pjWipAcctr = UtilSql.getValue(result, "pj_wip_acctr");
        objectDefaultsData.isactive = UtilSql.getValue(result, "isactive");
        objectDefaultsData.withholdingAcct = UtilSql.getValue(result, "withholding_acct");
        objectDefaultsData.processing = UtilSql.getValue(result, "processing");
        objectDefaultsData.language = UtilSql.getValue(result, "language");
        objectDefaultsData.adUserClient = "";
        objectDefaultsData.adOrgClient = "";
        objectDefaultsData.createdby = "";
        objectDefaultsData.trBgcolor = "";
        objectDefaultsData.totalCount = "";
        objectDefaultsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDefaultsData);
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
    DefaultsData objectDefaultsData[] = new DefaultsData[vector.size()];
    vector.copyInto(objectDefaultsData);
    return(objectDefaultsData);
  }

/**
Create a registry
 */
  public static DefaultsData[] set(String cAcctschemaId, String apDiscountAcct, String apDiscountAcctr, String aDepreciationAcct, String aDepreciationAcctr, String notinvoicedrevenueAcct, String notinvoicedrevenueAcctr, String pjWipAcct, String pjWipAcctr, String aAccumdepreciationAcct, String aAccumdepreciationAcctr, String bInterestrevAcct, String bInterestrevAcctr, String adClientId, String wInvactualadjustAcct, String wInvactualadjustAcctr, String cAcctschemaDefaultId, String cPrepaymentAcct, String cPrepaymentAcctr, String bPaymentselectAcct, String bPaymentselectAcctr, String pRevenueAcct, String pRevenueAcctr, String created, String ePrepaymentAcct, String ePrepaymentAcctr, String cReceivableAcct, String cReceivableAcctr, String pInvoicepricevarianceAcct, String pInvoicepricevarianceAcctr, String notinvoicedreceiptsAcct, String notinvoicedreceiptsAcctr, String tCreditAcct, String tCreditAcctr, String vLiabilityServicesAcct, String vLiabilityServicesAcctr, String vLiabilityAcct, String vLiabilityAcctr, String paydiscountExpAcct, String paydiscountExpAcctr, String bAssetAcct, String bAssetAcctr, String withholdingAcct, String bRevaluationgainAcct, String bRevaluationgainAcctr, String wDifferencesAcct, String wDifferencesAcctr, String cbReceiptAcct, String cbReceiptAcctr, String pExpenseAcct, String pExpenseAcctr, String pAssetAcct, String pAssetAcctr, String cbDifferencesAcct, String cbDifferencesAcctr, String chExpenseAcct, String chExpenseAcctr, String pjAssetAcct, String pjAssetAcctr, String unearnedrevenueAcct, String unearnedrevenueAcctr, String bExpenseAcct, String bExpenseAcctr, String aDisposalLoss, String unrealizedlossAcct, String unrealizedlossAcctr, String unrealizedgainAcct, String unrealizedgainAcctr, String pTradediscountrecAcct, String pTradediscountrecAcctr, String createdby, String createdbyr, String tReceivablesAcct, String tReceivablesAcctr, String wInventoryAcct, String wInventoryAcctr, String writeoffAcct, String writeoffAcctr, String adOrgId, String cbExpenseAcct, String cbExpenseAcctr, String bInterestexpAcct, String bInterestexpAcctr, String pPurchasepricevarianceAcct, String pPurchasepricevarianceAcctr, String bIntransitAcct, String bIntransitAcctr, String wRevaluationAcct, String wRevaluationAcctr, String arDiscountAcct, String arDiscountAcctr, String chRevenueAcct, String chRevenueAcctr, String realizedgainAcct, String realizedgainAcctr, String realizedlossAcct, String realizedlossAcctr, String bSettlementgainAcct, String bSettlementgainAcctr, String pCogsAcct, String pCogsAcctr, String aDisposalGain, String cbCashtransferAcct, String cbCashtransferAcctr, String tDueAcct, String tDueAcctr, String vPrepaymentAcct, String vPrepaymentAcctr, String pTradediscountgrantAcct, String pTradediscountgrantAcctr, String tExpenseAcct, String tExpenseAcctr, String notinvoicedreceivablesAcct, String notinvoicedreceivablesAcctr, String tLiabilityAcct, String tLiabilityAcctr, String isactive, String cbAssetAcct, String cbAssetAcctr, String processing, String bUnallocatedcashAcct, String bUnallocatedcashAcctr, String bSettlementlossAcct, String bSettlementlossAcctr, String updatedby, String updatedbyr, String bUnidentifiedAcct, String bUnidentifiedAcctr, String paydiscountRevAcct, String paydiscountRevAcctr, String eExpenseAcct, String eExpenseAcctr, String bRevaluationlossAcct, String bRevaluationlossAcctr)    throws ServletException {
    DefaultsData objectDefaultsData[] = new DefaultsData[1];
    objectDefaultsData[0] = new DefaultsData();
    objectDefaultsData[0].created = created;
    objectDefaultsData[0].createdbyr = createdbyr;
    objectDefaultsData[0].updated = "";
    objectDefaultsData[0].updatedTimeStamp = "";
    objectDefaultsData[0].updatedby = updatedby;
    objectDefaultsData[0].updatedbyr = updatedbyr;
    objectDefaultsData[0].adClientId = adClientId;
    objectDefaultsData[0].adClientIdr = "";
    objectDefaultsData[0].adOrgId = adOrgId;
    objectDefaultsData[0].adOrgIdr = "";
    objectDefaultsData[0].cAcctschemaDefaultId = cAcctschemaDefaultId;
    objectDefaultsData[0].cAcctschemaId = cAcctschemaId;
    objectDefaultsData[0].cAcctschemaIdr = "";
    objectDefaultsData[0].cReceivableAcct = cReceivableAcct;
    objectDefaultsData[0].cReceivableAcctr = cReceivableAcctr;
    objectDefaultsData[0].cPrepaymentAcct = cPrepaymentAcct;
    objectDefaultsData[0].aDisposalGain = aDisposalGain;
    objectDefaultsData[0].paydiscountExpAcct = paydiscountExpAcct;
    objectDefaultsData[0].aDisposalLoss = aDisposalLoss;
    objectDefaultsData[0].writeoffAcct = writeoffAcct;
    objectDefaultsData[0].writeoffAcctr = writeoffAcctr;
    objectDefaultsData[0].arDiscountAcct = arDiscountAcct;
    objectDefaultsData[0].arDiscountAcctr = arDiscountAcctr;
    objectDefaultsData[0].apDiscountAcct = apDiscountAcct;
    objectDefaultsData[0].apDiscountAcctr = apDiscountAcctr;
    objectDefaultsData[0].notinvoicedreceivablesAcct = notinvoicedreceivablesAcct;
    objectDefaultsData[0].notinvoicedrevenueAcct = notinvoicedrevenueAcct;
    objectDefaultsData[0].unearnedrevenueAcct = unearnedrevenueAcct;
    objectDefaultsData[0].vLiabilityAcct = vLiabilityAcct;
    objectDefaultsData[0].vLiabilityAcctr = vLiabilityAcctr;
    objectDefaultsData[0].vLiabilityServicesAcct = vLiabilityServicesAcct;
    objectDefaultsData[0].vPrepaymentAcct = vPrepaymentAcct;
    objectDefaultsData[0].paydiscountRevAcct = paydiscountRevAcct;
    objectDefaultsData[0].notinvoicedreceiptsAcct = notinvoicedreceiptsAcct;
    objectDefaultsData[0].notinvoicedreceiptsAcctr = notinvoicedreceiptsAcctr;
    objectDefaultsData[0].ePrepaymentAcct = ePrepaymentAcct;
    objectDefaultsData[0].eExpenseAcct = eExpenseAcct;
    objectDefaultsData[0].pAssetAcct = pAssetAcct;
    objectDefaultsData[0].pAssetAcctr = pAssetAcctr;
    objectDefaultsData[0].pExpenseAcct = pExpenseAcct;
    objectDefaultsData[0].pExpenseAcctr = pExpenseAcctr;
    objectDefaultsData[0].pRevenueAcct = pRevenueAcct;
    objectDefaultsData[0].pRevenueAcctr = pRevenueAcctr;
    objectDefaultsData[0].pCogsAcct = pCogsAcct;
    objectDefaultsData[0].pCogsAcctr = pCogsAcctr;
    objectDefaultsData[0].pPurchasepricevarianceAcct = pPurchasepricevarianceAcct;
    objectDefaultsData[0].pInvoicepricevarianceAcct = pInvoicepricevarianceAcct;
    objectDefaultsData[0].pInvoicepricevarianceAcctr = pInvoicepricevarianceAcctr;
    objectDefaultsData[0].pTradediscountrecAcct = pTradediscountrecAcct;
    objectDefaultsData[0].pTradediscountgrantAcct = pTradediscountgrantAcct;
    objectDefaultsData[0].wInventoryAcct = wInventoryAcct;
    objectDefaultsData[0].wInventoryAcctr = wInventoryAcctr;
    objectDefaultsData[0].wInvactualadjustAcct = wInvactualadjustAcct;
    objectDefaultsData[0].wDifferencesAcct = wDifferencesAcct;
    objectDefaultsData[0].wDifferencesAcctr = wDifferencesAcctr;
    objectDefaultsData[0].wRevaluationAcct = wRevaluationAcct;
    objectDefaultsData[0].wRevaluationAcctr = wRevaluationAcctr;
    objectDefaultsData[0].bAssetAcct = bAssetAcct;
    objectDefaultsData[0].bAssetAcctr = bAssetAcctr;
    objectDefaultsData[0].bIntransitAcct = bIntransitAcct;
    objectDefaultsData[0].bIntransitAcctr = bIntransitAcctr;
    objectDefaultsData[0].bUnidentifiedAcct = bUnidentifiedAcct;
    objectDefaultsData[0].bUnallocatedcashAcct = bUnallocatedcashAcct;
    objectDefaultsData[0].bPaymentselectAcct = bPaymentselectAcct;
    objectDefaultsData[0].bPaymentselectAcctr = bPaymentselectAcctr;
    objectDefaultsData[0].bExpenseAcct = bExpenseAcct;
    objectDefaultsData[0].bExpenseAcctr = bExpenseAcctr;
    objectDefaultsData[0].bInterestexpAcct = bInterestexpAcct;
    objectDefaultsData[0].bInterestrevAcct = bInterestrevAcct;
    objectDefaultsData[0].bRevaluationgainAcct = bRevaluationgainAcct;
    objectDefaultsData[0].bRevaluationgainAcctr = bRevaluationgainAcctr;
    objectDefaultsData[0].bRevaluationlossAcct = bRevaluationlossAcct;
    objectDefaultsData[0].bRevaluationlossAcctr = bRevaluationlossAcctr;
    objectDefaultsData[0].bSettlementlossAcct = bSettlementlossAcct;
    objectDefaultsData[0].bSettlementgainAcct = bSettlementgainAcct;
    objectDefaultsData[0].tDueAcct = tDueAcct;
    objectDefaultsData[0].tDueAcctr = tDueAcctr;
    objectDefaultsData[0].tLiabilityAcct = tLiabilityAcct;
    objectDefaultsData[0].tCreditAcct = tCreditAcct;
    objectDefaultsData[0].tCreditAcctr = tCreditAcctr;
    objectDefaultsData[0].tReceivablesAcct = tReceivablesAcct;
    objectDefaultsData[0].tExpenseAcct = tExpenseAcct;
    objectDefaultsData[0].chExpenseAcct = chExpenseAcct;
    objectDefaultsData[0].chExpenseAcctr = chExpenseAcctr;
    objectDefaultsData[0].chRevenueAcct = chRevenueAcct;
    objectDefaultsData[0].unrealizedgainAcct = unrealizedgainAcct;
    objectDefaultsData[0].unrealizedlossAcct = unrealizedlossAcct;
    objectDefaultsData[0].realizedgainAcct = realizedgainAcct;
    objectDefaultsData[0].realizedlossAcct = realizedlossAcct;
    objectDefaultsData[0].cbAssetAcct = cbAssetAcct;
    objectDefaultsData[0].cbAssetAcctr = cbAssetAcctr;
    objectDefaultsData[0].cbDifferencesAcct = cbDifferencesAcct;
    objectDefaultsData[0].cbDifferencesAcctr = cbDifferencesAcctr;
    objectDefaultsData[0].cbCashtransferAcct = cbCashtransferAcct;
    objectDefaultsData[0].cbCashtransferAcctr = cbCashtransferAcctr;
    objectDefaultsData[0].cbExpenseAcct = cbExpenseAcct;
    objectDefaultsData[0].cbExpenseAcctr = cbExpenseAcctr;
    objectDefaultsData[0].cbReceiptAcct = cbReceiptAcct;
    objectDefaultsData[0].cbReceiptAcctr = cbReceiptAcctr;
    objectDefaultsData[0].aDepreciationAcct = aDepreciationAcct;
    objectDefaultsData[0].aDepreciationAcctr = aDepreciationAcctr;
    objectDefaultsData[0].aAccumdepreciationAcct = aAccumdepreciationAcct;
    objectDefaultsData[0].aAccumdepreciationAcctr = aAccumdepreciationAcctr;
    objectDefaultsData[0].pjAssetAcct = pjAssetAcct;
    objectDefaultsData[0].pjAssetAcctr = pjAssetAcctr;
    objectDefaultsData[0].pjWipAcct = pjWipAcct;
    objectDefaultsData[0].pjWipAcctr = pjWipAcctr;
    objectDefaultsData[0].isactive = isactive;
    objectDefaultsData[0].withholdingAcct = withholdingAcct;
    objectDefaultsData[0].processing = processing;
    objectDefaultsData[0].language = "";
    return objectDefaultsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef4AB84B7CA36B42088BA5533EE6998C45_0(ConnectionProvider connectionProvider, String AP_Discount_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as AP_Discount_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AP_Discount_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ap_discount_acct");
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
  public static String selectDef803370_1(ConnectionProvider connectionProvider, String A_Depreciation_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as A_Depreciation_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, A_Depreciation_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "a_depreciation_acct");
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
  public static String selectDef4840_2(ConnectionProvider connectionProvider, String NotInvoicedRevenue_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as NotInvoicedRevenue_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, NotInvoicedRevenue_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "notinvoicedrevenue_acct");
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
  public static String selectDef4854_3(ConnectionProvider connectionProvider, String PJ_WIP_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as PJ_WIP_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, PJ_WIP_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "pj_wip_acct");
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
  public static String selectDef803369_4(ConnectionProvider connectionProvider, String A_Accumdepreciation_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as A_Accumdepreciation_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, A_Accumdepreciation_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "a_accumdepreciation_acct");
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
  public static String selectDef4863_5(ConnectionProvider connectionProvider, String B_InterestRev_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as B_InterestRev_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_InterestRev_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "b_interestrev_acct");
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
  public static String selectDef6114_6(ConnectionProvider connectionProvider, String W_InvActualAdjust_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as W_InvActualAdjust_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, W_InvActualAdjust_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "w_invactualadjust_acct");
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
  public static String selectDef3452_7(ConnectionProvider connectionProvider, String C_Prepayment_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as C_Prepayment_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Prepayment_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_prepayment_acct");
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
  public static String selectDef6491_8(ConnectionProvider connectionProvider, String B_PaymentSelect_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as B_PaymentSelect_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_PaymentSelect_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "b_paymentselect_acct");
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
  public static String selectDef3445_9(ConnectionProvider connectionProvider, String P_Revenue_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as P_Revenue_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, P_Revenue_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "p_revenue_acct");
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
  public static String selectDef3450_10(ConnectionProvider connectionProvider, String E_Prepayment_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as E_Prepayment_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, E_Prepayment_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "e_prepayment_acct");
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
  public static String selectDef3451_11(ConnectionProvider connectionProvider, String C_Receivable_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as C_Receivable_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Receivable_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_receivable_acct");
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
  public static String selectDef6111_12(ConnectionProvider connectionProvider, String P_InvoicePriceVariance_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as P_InvoicePriceVariance_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, P_InvoicePriceVariance_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "p_invoicepricevariance_acct");
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
  public static String selectDef4841_13(ConnectionProvider connectionProvider, String NotInvoicedReceipts_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as NotInvoicedReceipts_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, NotInvoicedReceipts_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "notinvoicedreceipts_acct");
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
  public static String selectDef4859_14(ConnectionProvider connectionProvider, String T_Credit_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as T_Credit_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, T_Credit_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "t_credit_acct");
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
  public static String selectDef3455_15(ConnectionProvider connectionProvider, String V_Liability_Services_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as V_Liability_Services_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, V_Liability_Services_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "v_liability_services_acct");
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
  public static String selectDef3453_16(ConnectionProvider connectionProvider, String V_Liability_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as V_Liability_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, V_Liability_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "v_liability_acct");
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
  public static String selectDef4846_17(ConnectionProvider connectionProvider, String PayDiscount_Exp_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as PayDiscount_Exp_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, PayDiscount_Exp_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "paydiscount_exp_acct");
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
  public static String selectDef4861_18(ConnectionProvider connectionProvider, String B_Asset_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as B_Asset_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_Asset_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "b_asset_acct");
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
  public static String selectDef4868_19(ConnectionProvider connectionProvider, String B_RevaluationGain_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as B_RevaluationGain_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_RevaluationGain_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "b_revaluationgain_acct");
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
  public static String selectDef3444_20(ConnectionProvider connectionProvider, String W_Differences_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as W_Differences_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, W_Differences_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "w_differences_acct");
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
  public static String selectDef5209_21(ConnectionProvider connectionProvider, String CB_Receipt_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as CB_Receipt_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CB_Receipt_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "cb_receipt_acct");
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
  public static String selectDef3446_22(ConnectionProvider connectionProvider, String P_Expense_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as P_Expense_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, P_Expense_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "p_expense_acct");
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
  public static String selectDef3447_23(ConnectionProvider connectionProvider, String P_Asset_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as P_Asset_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, P_Asset_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "p_asset_acct");
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
  public static String selectDef5207_24(ConnectionProvider connectionProvider, String CB_Differences_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as CB_Differences_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CB_Differences_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "cb_differences_acct");
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
  public static String selectDef4870_25(ConnectionProvider connectionProvider, String Ch_Expense_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as Ch_Expense_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Ch_Expense_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ch_expense_acct");
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
  public static String selectDef3456_26(ConnectionProvider connectionProvider, String PJ_Asset_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as PJ_Asset_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, PJ_Asset_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "pj_asset_acct");
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
  public static String selectDef4872_27(ConnectionProvider connectionProvider, String UnEarnedRevenue_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as UnEarnedRevenue_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UnEarnedRevenue_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "unearnedrevenue_acct");
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
  public static String selectDef4862_28(ConnectionProvider connectionProvider, String B_Expense_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as B_Expense_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_Expense_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "b_expense_acct");
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
  public static String selectDef4850_29(ConnectionProvider connectionProvider, String UnrealizedLoss_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as UnrealizedLoss_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UnrealizedLoss_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "unrealizedloss_acct");
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
  public static String selectDef4849_30(ConnectionProvider connectionProvider, String UnrealizedGain_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as UnrealizedGain_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UnrealizedGain_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "unrealizedgain_acct");
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
  public static String selectDef6112_31(ConnectionProvider connectionProvider, String P_TradeDiscountRec_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as P_TradeDiscountRec_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, P_TradeDiscountRec_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "p_tradediscountrec_acct");
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
  public static String selectDef3440_32(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef4857_33(ConnectionProvider connectionProvider, String T_Receivables_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as T_Receivables_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, T_Receivables_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "t_receivables_acct");
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
  public static String selectDef3443_34(ConnectionProvider connectionProvider, String W_Inventory_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as W_Inventory_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, W_Inventory_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "w_inventory_acct");
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
  public static String selectDef4847_35(ConnectionProvider connectionProvider, String WriteOff_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as WriteOff_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, WriteOff_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "writeoff_acct");
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
  public static String selectDef5208_36(ConnectionProvider connectionProvider, String CB_Expense_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as CB_Expense_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CB_Expense_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "cb_expense_acct");
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
  public static String selectDef4864_37(ConnectionProvider connectionProvider, String B_InterestExp_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as B_InterestExp_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_InterestExp_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "b_interestexp_acct");
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
  public static String selectDef4844_38(ConnectionProvider connectionProvider, String P_PurchasePriceVariance_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as P_PurchasePriceVariance_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, P_PurchasePriceVariance_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "p_purchasepricevariance_acct");
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
  public static String selectDef4860_39(ConnectionProvider connectionProvider, String B_InTransit_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as B_InTransit_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_InTransit_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "b_intransit_acct");
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
  public static String selectDef4843_40(ConnectionProvider connectionProvider, String W_Revaluation_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as W_Revaluation_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, W_Revaluation_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "w_revaluation_acct");
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
  public static String selectDef9E64B4959F9B4D29B393E3E516093DB1_41(ConnectionProvider connectionProvider, String AR_Discount_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as AR_Discount_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AR_Discount_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ar_discount_acct");
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
  public static String selectDef4871_42(ConnectionProvider connectionProvider, String Ch_Revenue_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as Ch_Revenue_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Ch_Revenue_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ch_revenue_acct");
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
  public static String selectDef4851_43(ConnectionProvider connectionProvider, String RealizedGain_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as RealizedGain_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, RealizedGain_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "realizedgain_acct");
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
  public static String selectDef4852_44(ConnectionProvider connectionProvider, String RealizedLoss_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as RealizedLoss_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, RealizedLoss_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "realizedloss_acct");
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
  public static String selectDef4866_45(ConnectionProvider connectionProvider, String B_SettlementGain_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as B_SettlementGain_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_SettlementGain_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "b_settlementgain_acct");
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
  public static String selectDef3448_46(ConnectionProvider connectionProvider, String P_Cogs_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as P_Cogs_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, P_Cogs_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "p_cogs_acct");
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
  public static String selectDef6493_47(ConnectionProvider connectionProvider, String CB_CashTransfer_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as CB_CashTransfer_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CB_CashTransfer_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "cb_cashtransfer_acct");
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
  public static String selectDef4858_48(ConnectionProvider connectionProvider, String T_Due_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as T_Due_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, T_Due_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "t_due_acct");
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
  public static String selectDef3454_49(ConnectionProvider connectionProvider, String V_Prepayment_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as V_Prepayment_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, V_Prepayment_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "v_prepayment_acct");
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
  public static String selectDef6113_50(ConnectionProvider connectionProvider, String P_TradeDiscountGrant_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as P_TradeDiscountGrant_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, P_TradeDiscountGrant_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "p_tradediscountgrant_acct");
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
  public static String selectDef4855_51(ConnectionProvider connectionProvider, String T_Expense_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as T_Expense_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, T_Expense_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "t_expense_acct");
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
  public static String selectDef4873_52(ConnectionProvider connectionProvider, String NotInvoicedReceivables_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as NotInvoicedReceivables_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, NotInvoicedReceivables_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "notinvoicedreceivables_acct");
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
  public static String selectDef4856_53(ConnectionProvider connectionProvider, String T_Liability_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as T_Liability_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, T_Liability_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "t_liability_acct");
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
  public static String selectDef5206_54(ConnectionProvider connectionProvider, String CB_Asset_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as CB_Asset_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CB_Asset_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "cb_asset_acct");
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
  public static String selectDef6492_55(ConnectionProvider connectionProvider, String B_UnallocatedCash_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as B_UnallocatedCash_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_UnallocatedCash_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "b_unallocatedcash_acct");
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
  public static String selectDef4867_56(ConnectionProvider connectionProvider, String B_SettlementLoss_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as B_SettlementLoss_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_SettlementLoss_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "b_settlementloss_acct");
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
  public static String selectDef3442_57(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef4865_58(ConnectionProvider connectionProvider, String B_Unidentified_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as B_Unidentified_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_Unidentified_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "b_unidentified_acct");
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
  public static String selectDef4848_59(ConnectionProvider connectionProvider, String PayDiscount_Rev_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as PayDiscount_Rev_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, PayDiscount_Rev_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "paydiscount_rev_acct");
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
  public static String selectDef3449_60(ConnectionProvider connectionProvider, String E_Expense_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as E_Expense_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, E_Expense_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "e_expense_acct");
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
  public static String selectDef4869_61(ConnectionProvider connectionProvider, String B_RevaluationLoss_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as B_RevaluationLoss_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_RevaluationLoss_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "b_revaluationloss_acct");
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
      "        SELECT C_AcctSchema_Default.C_AcctSchema_ID AS NAME" +
      "        FROM C_AcctSchema_Default" +
      "        WHERE C_AcctSchema_Default.C_Acctschema_Default_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cAcctschemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_AcctSchema left join (select C_AcctSchema_ID, Name from C_AcctSchema) table1 on (C_AcctSchema.C_AcctSchema_ID = table1.C_AcctSchema_ID) WHERE C_AcctSchema.C_AcctSchema_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cAcctschemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_AcctSchema left join (select C_AcctSchema_ID, Name from C_AcctSchema) table1 on (C_AcctSchema.C_AcctSchema_ID = table1.C_AcctSchema_ID) WHERE C_AcctSchema.C_AcctSchema_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

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
      "        UPDATE C_AcctSchema_Default" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , C_Acctschema_Default_ID = (?) , C_AcctSchema_ID = (?) , C_Receivable_Acct = (?) , C_Prepayment_Acct = (?) , A_Disposal_Gain = (?) , PayDiscount_Exp_Acct = (?) , A_Disposal_Loss = (?) , WriteOff_Acct = (?) , AR_Discount_Acct = (?) , AP_Discount_Acct = (?) , NotInvoicedReceivables_Acct = (?) , NotInvoicedRevenue_Acct = (?) , UnEarnedRevenue_Acct = (?) , V_Liability_Acct = (?) , V_Liability_Services_Acct = (?) , V_Prepayment_Acct = (?) , PayDiscount_Rev_Acct = (?) , NotInvoicedReceipts_Acct = (?) , E_Prepayment_Acct = (?) , E_Expense_Acct = (?) , P_Asset_Acct = (?) , P_Expense_Acct = (?) , P_Revenue_Acct = (?) , P_Cogs_Acct = (?) , P_PurchasePriceVariance_Acct = (?) , P_InvoicePriceVariance_Acct = (?) , P_TradeDiscountRec_Acct = (?) , P_TradeDiscountGrant_Acct = (?) , W_Inventory_Acct = (?) , W_InvActualAdjust_Acct = (?) , W_Differences_Acct = (?) , W_Revaluation_Acct = (?) , B_Asset_Acct = (?) , B_InTransit_Acct = (?) , B_Unidentified_Acct = (?) , B_UnallocatedCash_Acct = (?) , B_PaymentSelect_Acct = (?) , B_Expense_Acct = (?) , B_InterestExp_Acct = (?) , B_InterestRev_Acct = (?) , B_RevaluationGain_Acct = (?) , B_RevaluationLoss_Acct = (?) , B_SettlementLoss_Acct = (?) , B_SettlementGain_Acct = (?) , T_Due_Acct = (?) , T_Liability_Acct = (?) , T_Credit_Acct = (?) , T_Receivables_Acct = (?) , T_Expense_Acct = (?) , Ch_Expense_Acct = (?) , Ch_Revenue_Acct = (?) , UnrealizedGain_Acct = (?) , UnrealizedLoss_Acct = (?) , RealizedGain_Acct = (?) , RealizedLoss_Acct = (?) , CB_Asset_Acct = (?) , CB_Differences_Acct = (?) , CB_CashTransfer_Acct = (?) , CB_Expense_Acct = (?) , CB_Receipt_Acct = (?) , A_Depreciation_Acct = (?) , A_Accumdepreciation_Acct = (?) , PJ_Asset_Acct = (?) , PJ_WIP_Acct = (?) , IsActive = (?) , Withholding_Acct = (?) , Processing = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_AcctSchema_Default.C_Acctschema_Default_ID = ? " +
      "                 AND C_AcctSchema_Default.C_AcctSchema_ID = ? " +
      "        AND C_AcctSchema_Default.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_AcctSchema_Default.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaDefaultId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cReceivableAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPrepaymentAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aDisposalGain);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paydiscountExpAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aDisposalLoss);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, writeoffAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, arDiscountAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, apDiscountAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, notinvoicedreceivablesAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, notinvoicedrevenueAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unearnedrevenueAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vLiabilityAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vLiabilityServicesAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vPrepaymentAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paydiscountRevAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, notinvoicedreceiptsAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ePrepaymentAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, eExpenseAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pAssetAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pExpenseAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pRevenueAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pCogsAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pPurchasepricevarianceAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pInvoicepricevarianceAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pTradediscountrecAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pTradediscountgrantAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, wInventoryAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, wInvactualadjustAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, wDifferencesAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, wRevaluationAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bAssetAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bIntransitAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bUnidentifiedAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bUnallocatedcashAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bPaymentselectAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bExpenseAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bInterestexpAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bInterestrevAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bRevaluationgainAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bRevaluationlossAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bSettlementlossAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bSettlementgainAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tDueAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tLiabilityAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tCreditAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tReceivablesAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tExpenseAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chExpenseAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chRevenueAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unrealizedgainAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unrealizedlossAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, realizedgainAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, realizedlossAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cbAssetAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cbDifferencesAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cbCashtransferAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cbExpenseAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cbReceiptAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aDepreciationAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAccumdepreciationAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pjAssetAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pjWipAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, withholdingAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaDefaultId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
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
      "        INSERT INTO C_AcctSchema_Default " +
      "        (AD_Client_ID, AD_Org_ID, C_Acctschema_Default_ID, C_AcctSchema_ID, C_Receivable_Acct, C_Prepayment_Acct, A_Disposal_Gain, PayDiscount_Exp_Acct, A_Disposal_Loss, WriteOff_Acct, AR_Discount_Acct, AP_Discount_Acct, NotInvoicedReceivables_Acct, NotInvoicedRevenue_Acct, UnEarnedRevenue_Acct, V_Liability_Acct, V_Liability_Services_Acct, V_Prepayment_Acct, PayDiscount_Rev_Acct, NotInvoicedReceipts_Acct, E_Prepayment_Acct, E_Expense_Acct, P_Asset_Acct, P_Expense_Acct, P_Revenue_Acct, P_Cogs_Acct, P_PurchasePriceVariance_Acct, P_InvoicePriceVariance_Acct, P_TradeDiscountRec_Acct, P_TradeDiscountGrant_Acct, W_Inventory_Acct, W_InvActualAdjust_Acct, W_Differences_Acct, W_Revaluation_Acct, B_Asset_Acct, B_InTransit_Acct, B_Unidentified_Acct, B_UnallocatedCash_Acct, B_PaymentSelect_Acct, B_Expense_Acct, B_InterestExp_Acct, B_InterestRev_Acct, B_RevaluationGain_Acct, B_RevaluationLoss_Acct, B_SettlementLoss_Acct, B_SettlementGain_Acct, T_Due_Acct, T_Liability_Acct, T_Credit_Acct, T_Receivables_Acct, T_Expense_Acct, Ch_Expense_Acct, Ch_Revenue_Acct, UnrealizedGain_Acct, UnrealizedLoss_Acct, RealizedGain_Acct, RealizedLoss_Acct, CB_Asset_Acct, CB_Differences_Acct, CB_CashTransfer_Acct, CB_Expense_Acct, CB_Receipt_Acct, A_Depreciation_Acct, A_Accumdepreciation_Acct, PJ_Asset_Acct, PJ_WIP_Acct, IsActive, Withholding_Acct, Processing, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaDefaultId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cReceivableAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPrepaymentAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aDisposalGain);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paydiscountExpAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aDisposalLoss);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, writeoffAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, arDiscountAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, apDiscountAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, notinvoicedreceivablesAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, notinvoicedrevenueAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unearnedrevenueAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vLiabilityAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vLiabilityServicesAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vPrepaymentAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paydiscountRevAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, notinvoicedreceiptsAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ePrepaymentAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, eExpenseAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pAssetAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pExpenseAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pRevenueAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pCogsAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pPurchasepricevarianceAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pInvoicepricevarianceAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pTradediscountrecAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pTradediscountgrantAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, wInventoryAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, wInvactualadjustAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, wDifferencesAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, wRevaluationAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bAssetAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bIntransitAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bUnidentifiedAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bUnallocatedcashAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bPaymentselectAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bExpenseAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bInterestexpAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bInterestrevAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bRevaluationgainAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bRevaluationlossAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bSettlementlossAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bSettlementgainAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tDueAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tLiabilityAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tCreditAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tReceivablesAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tExpenseAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chExpenseAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chRevenueAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unrealizedgainAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unrealizedlossAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, realizedgainAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, realizedlossAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cbAssetAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cbDifferencesAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cbCashtransferAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cbExpenseAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cbReceiptAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aDepreciationAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAccumdepreciationAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pjAssetAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pjWipAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, withholdingAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cAcctschemaId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_AcctSchema_Default" +
      "        WHERE C_AcctSchema_Default.C_Acctschema_Default_ID = ? " +
      "                 AND C_AcctSchema_Default.C_AcctSchema_ID = ? " +
      "        AND C_AcctSchema_Default.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_AcctSchema_Default.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cAcctschemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_AcctSchema_Default" +
      "        WHERE C_AcctSchema_Default.C_Acctschema_Default_ID = ? " +
      "                 AND C_AcctSchema_Default.C_AcctSchema_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

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
      "          FROM C_AcctSchema_Default" +
      "         WHERE C_AcctSchema_Default.C_Acctschema_Default_ID = ? ";

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
      "          FROM C_AcctSchema_Default" +
      "         WHERE C_AcctSchema_Default.C_Acctschema_Default_ID = ? ";

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
