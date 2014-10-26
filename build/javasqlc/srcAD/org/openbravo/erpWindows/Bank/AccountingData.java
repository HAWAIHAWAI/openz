//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Bank;

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
class AccountingData implements FieldProvider {
static Logger log4j = Logger.getLogger(AccountingData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cBankaccountAcctId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cBankaccountId;
  public String cBankaccountIdr;
  public String cAcctschemaId;
  public String cAcctschemaIdr;
  public String isactive;
  public String bAssetAcct;
  public String bAssetAcctr;
  public String bIntransitAcct;
  public String bIntransitAcctr;
  public String bUnallocatedcashAcct;
  public String bUnidentifiedAcct;
  public String bPaymentselectAcct;
  public String bExpenseAcct;
  public String bExpenseAcctr;
  public String bInterestexpAcct;
  public String bInterestrevAcct;
  public String bRevaluationgainAcct;
  public String bRevaluationgainAcctr;
  public String bRevaluationlossAcct;
  public String bRevaluationlossAcctr;
  public String bSettlementgainAcct;
  public String bSettlementlossAcct;
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
    else if (fieldName.equalsIgnoreCase("c_bankaccount_acct_id") || fieldName.equals("cBankaccountAcctId"))
      return cBankaccountAcctId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_bankaccount_id") || fieldName.equals("cBankaccountId"))
      return cBankaccountId;
    else if (fieldName.equalsIgnoreCase("c_bankaccount_idr") || fieldName.equals("cBankaccountIdr"))
      return cBankaccountIdr;
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_idr") || fieldName.equals("cAcctschemaIdr"))
      return cAcctschemaIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("b_asset_acct") || fieldName.equals("bAssetAcct"))
      return bAssetAcct;
    else if (fieldName.equalsIgnoreCase("b_asset_acctr") || fieldName.equals("bAssetAcctr"))
      return bAssetAcctr;
    else if (fieldName.equalsIgnoreCase("b_intransit_acct") || fieldName.equals("bIntransitAcct"))
      return bIntransitAcct;
    else if (fieldName.equalsIgnoreCase("b_intransit_acctr") || fieldName.equals("bIntransitAcctr"))
      return bIntransitAcctr;
    else if (fieldName.equalsIgnoreCase("b_unallocatedcash_acct") || fieldName.equals("bUnallocatedcashAcct"))
      return bUnallocatedcashAcct;
    else if (fieldName.equalsIgnoreCase("b_unidentified_acct") || fieldName.equals("bUnidentifiedAcct"))
      return bUnidentifiedAcct;
    else if (fieldName.equalsIgnoreCase("b_paymentselect_acct") || fieldName.equals("bPaymentselectAcct"))
      return bPaymentselectAcct;
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
    else if (fieldName.equalsIgnoreCase("b_settlementgain_acct") || fieldName.equals("bSettlementgainAcct"))
      return bSettlementgainAcct;
    else if (fieldName.equalsIgnoreCase("b_settlementloss_acct") || fieldName.equals("bSettlementlossAcct"))
      return bSettlementlossAcct;
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
  public static AccountingData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBankaccountId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cBankaccountId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static AccountingData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBankaccountId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_BankAccount_Acct.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_BankAccount_Acct.CreatedBy) as CreatedByR, " +
      "        to_char(C_BankAccount_Acct.Updated, ?) as updated, " +
      "        to_char(C_BankAccount_Acct.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_BankAccount_Acct.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_BankAccount_Acct.UpdatedBy) as UpdatedByR," +
      "        C_BankAccount_Acct.C_BankAccount_Acct_ID, " +
      "C_BankAccount_Acct.AD_Client_ID, " +
      "(CASE WHEN C_BankAccount_Acct.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_BankAccount_Acct.AD_Org_ID, " +
      "(CASE WHEN C_BankAccount_Acct.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_BankAccount_Acct.C_BankAccount_ID, " +
      "(CASE WHEN C_BankAccount_Acct.C_BankAccount_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DisplayedAccount), ''))),'') ) END) AS C_BankAccount_IDR, " +
      "C_BankAccount_Acct.C_AcctSchema_ID, " +
      "(CASE WHEN C_BankAccount_Acct.C_AcctSchema_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_AcctSchema_IDR, " +
      "COALESCE(C_BankAccount_Acct.IsActive, 'N') AS IsActive, " +
      "C_BankAccount_Acct.B_Asset_Acct, " +
      "(CASE WHEN C_BankAccount_Acct.B_Asset_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Combination), ''))),'') ) END) AS B_Asset_AcctR, " +
      "C_BankAccount_Acct.B_InTransit_Acct, " +
      "(CASE WHEN C_BankAccount_Acct.B_InTransit_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Combination), ''))),'') ) END) AS B_InTransit_AcctR, " +
      "C_BankAccount_Acct.B_UnallocatedCash_Acct, " +
      "C_BankAccount_Acct.B_Unidentified_Acct, " +
      "C_BankAccount_Acct.B_PaymentSelect_Acct, " +
      "C_BankAccount_Acct.B_Expense_Acct, " +
      "(CASE WHEN C_BankAccount_Acct.B_Expense_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Combination), ''))),'') ) END) AS B_Expense_AcctR, " +
      "C_BankAccount_Acct.B_InterestExp_Acct, " +
      "C_BankAccount_Acct.B_InterestRev_Acct, " +
      "C_BankAccount_Acct.B_RevaluationGain_Acct, " +
      "(CASE WHEN C_BankAccount_Acct.B_RevaluationGain_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Combination), ''))),'') ) END) AS B_RevaluationGain_AcctR, " +
      "C_BankAccount_Acct.B_RevaluationLoss_Acct, " +
      "(CASE WHEN C_BankAccount_Acct.B_RevaluationLoss_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Combination), ''))),'') ) END) AS B_RevaluationLoss_AcctR, " +
      "C_BankAccount_Acct.B_SettlementGain_Acct, " +
      "C_BankAccount_Acct.B_SettlementLoss_Acct, " +
      "        ? AS LANGUAGE " +
      "        FROM C_BankAccount_Acct left join (select AD_Client_ID, Name from AD_Client) table1 on (C_BankAccount_Acct.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_BankAccount_Acct.AD_Org_ID = table2.AD_Org_ID) left join (select C_BankAccount_ID, C_Bank_ID, DisplayedAccount from C_BankAccount) table3 on (C_BankAccount_Acct.C_BankAccount_ID = table3.C_BankAccount_ID) left join (select C_Bank_ID, Name from C_Bank) table4 on (table3.C_Bank_ID = table4.C_Bank_ID) left join (select C_AcctSchema_ID, Name from C_AcctSchema) table5 on (C_BankAccount_Acct.C_AcctSchema_ID = table5.C_AcctSchema_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table6 on (C_BankAccount_Acct.B_Asset_Acct = table6.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table7 on (C_BankAccount_Acct.B_InTransit_Acct = table7.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table8 on (C_BankAccount_Acct.B_Expense_Acct = table8.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table9 on (C_BankAccount_Acct.B_RevaluationGain_Acct = table9.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table10 on (C_BankAccount_Acct.B_RevaluationLoss_Acct = table10.C_ValidCombination_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cBankaccountId==null || cBankaccountId.equals(""))?"":"  AND C_BankAccount_Acct.C_BankAccount_ID = ?  ");
    strSql = strSql + 
      "        AND C_BankAccount_Acct.C_BankAccount_Acct_ID = ? " +
      "        AND C_BankAccount_Acct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_BankAccount_Acct.AD_Org_ID IN (";
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
      if (cBankaccountId != null && !(cBankaccountId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
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
        AccountingData objectAccountingData = new AccountingData();
        objectAccountingData.created = UtilSql.getValue(result, "created");
        objectAccountingData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectAccountingData.updated = UtilSql.getValue(result, "updated");
        objectAccountingData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectAccountingData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAccountingData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectAccountingData.cBankaccountAcctId = UtilSql.getValue(result, "c_bankaccount_acct_id");
        objectAccountingData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAccountingData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectAccountingData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAccountingData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectAccountingData.cBankaccountId = UtilSql.getValue(result, "c_bankaccount_id");
        objectAccountingData.cBankaccountIdr = UtilSql.getValue(result, "c_bankaccount_idr");
        objectAccountingData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectAccountingData.cAcctschemaIdr = UtilSql.getValue(result, "c_acctschema_idr");
        objectAccountingData.isactive = UtilSql.getValue(result, "isactive");
        objectAccountingData.bAssetAcct = UtilSql.getValue(result, "b_asset_acct");
        objectAccountingData.bAssetAcctr = UtilSql.getValue(result, "b_asset_acctr");
        objectAccountingData.bIntransitAcct = UtilSql.getValue(result, "b_intransit_acct");
        objectAccountingData.bIntransitAcctr = UtilSql.getValue(result, "b_intransit_acctr");
        objectAccountingData.bUnallocatedcashAcct = UtilSql.getValue(result, "b_unallocatedcash_acct");
        objectAccountingData.bUnidentifiedAcct = UtilSql.getValue(result, "b_unidentified_acct");
        objectAccountingData.bPaymentselectAcct = UtilSql.getValue(result, "b_paymentselect_acct");
        objectAccountingData.bExpenseAcct = UtilSql.getValue(result, "b_expense_acct");
        objectAccountingData.bExpenseAcctr = UtilSql.getValue(result, "b_expense_acctr");
        objectAccountingData.bInterestexpAcct = UtilSql.getValue(result, "b_interestexp_acct");
        objectAccountingData.bInterestrevAcct = UtilSql.getValue(result, "b_interestrev_acct");
        objectAccountingData.bRevaluationgainAcct = UtilSql.getValue(result, "b_revaluationgain_acct");
        objectAccountingData.bRevaluationgainAcctr = UtilSql.getValue(result, "b_revaluationgain_acctr");
        objectAccountingData.bRevaluationlossAcct = UtilSql.getValue(result, "b_revaluationloss_acct");
        objectAccountingData.bRevaluationlossAcctr = UtilSql.getValue(result, "b_revaluationloss_acctr");
        objectAccountingData.bSettlementgainAcct = UtilSql.getValue(result, "b_settlementgain_acct");
        objectAccountingData.bSettlementlossAcct = UtilSql.getValue(result, "b_settlementloss_acct");
        objectAccountingData.language = UtilSql.getValue(result, "language");
        objectAccountingData.adUserClient = "";
        objectAccountingData.adOrgClient = "";
        objectAccountingData.createdby = "";
        objectAccountingData.trBgcolor = "";
        objectAccountingData.totalCount = "";
        objectAccountingData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountingData);
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
    AccountingData objectAccountingData[] = new AccountingData[vector.size()];
    vector.copyInto(objectAccountingData);
    return(objectAccountingData);
  }

/**
Create a registry
 */
  public static AccountingData[] set(String cBankaccountId, String bSettlementlossAcct, String bSettlementlossAcctr, String cAcctschemaId, String bRevaluationgainAcct, String bRevaluationgainAcctr, String bInterestrevAcct, String bInterestrevAcctr, String bUnallocatedcashAcct, String bUnallocatedcashAcctr, String adOrgId, String bRevaluationlossAcct, String bRevaluationlossAcctr, String bUnidentifiedAcct, String bUnidentifiedAcctr, String bPaymentselectAcct, String bPaymentselectAcctr, String cBankaccountAcctId, String bExpenseAcct, String bExpenseAcctr, String bSettlementgainAcct, String bSettlementgainAcctr, String updatedby, String updatedbyr, String adClientId, String bAssetAcct, String bAssetAcctr, String bInterestexpAcct, String bInterestexpAcctr, String createdby, String createdbyr, String bIntransitAcct, String bIntransitAcctr, String isactive)    throws ServletException {
    AccountingData objectAccountingData[] = new AccountingData[1];
    objectAccountingData[0] = new AccountingData();
    objectAccountingData[0].created = "";
    objectAccountingData[0].createdbyr = createdbyr;
    objectAccountingData[0].updated = "";
    objectAccountingData[0].updatedTimeStamp = "";
    objectAccountingData[0].updatedby = updatedby;
    objectAccountingData[0].updatedbyr = updatedbyr;
    objectAccountingData[0].cBankaccountAcctId = cBankaccountAcctId;
    objectAccountingData[0].adClientId = adClientId;
    objectAccountingData[0].adClientIdr = "";
    objectAccountingData[0].adOrgId = adOrgId;
    objectAccountingData[0].adOrgIdr = "";
    objectAccountingData[0].cBankaccountId = cBankaccountId;
    objectAccountingData[0].cBankaccountIdr = "";
    objectAccountingData[0].cAcctschemaId = cAcctschemaId;
    objectAccountingData[0].cAcctschemaIdr = "";
    objectAccountingData[0].isactive = isactive;
    objectAccountingData[0].bAssetAcct = bAssetAcct;
    objectAccountingData[0].bAssetAcctr = bAssetAcctr;
    objectAccountingData[0].bIntransitAcct = bIntransitAcct;
    objectAccountingData[0].bIntransitAcctr = bIntransitAcctr;
    objectAccountingData[0].bUnallocatedcashAcct = bUnallocatedcashAcct;
    objectAccountingData[0].bUnidentifiedAcct = bUnidentifiedAcct;
    objectAccountingData[0].bPaymentselectAcct = bPaymentselectAcct;
    objectAccountingData[0].bExpenseAcct = bExpenseAcct;
    objectAccountingData[0].bExpenseAcctr = bExpenseAcctr;
    objectAccountingData[0].bInterestexpAcct = bInterestexpAcct;
    objectAccountingData[0].bInterestrevAcct = bInterestrevAcct;
    objectAccountingData[0].bRevaluationgainAcct = bRevaluationgainAcct;
    objectAccountingData[0].bRevaluationgainAcctr = bRevaluationgainAcctr;
    objectAccountingData[0].bRevaluationlossAcct = bRevaluationlossAcct;
    objectAccountingData[0].bRevaluationlossAcctr = bRevaluationlossAcctr;
    objectAccountingData[0].bSettlementgainAcct = bSettlementgainAcct;
    objectAccountingData[0].bSettlementlossAcct = bSettlementlossAcct;
    objectAccountingData[0].language = "";
    return objectAccountingData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef4906_0(ConnectionProvider connectionProvider, String B_SettlementLoss_AcctR)    throws ServletException {
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
  public static String selectDef4907_1(ConnectionProvider connectionProvider, String B_RevaluationGain_AcctR)    throws ServletException {
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
  public static String selectDef4902_2(ConnectionProvider connectionProvider, String B_InterestRev_AcctR)    throws ServletException {
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
  public static String selectDef6495_3(ConnectionProvider connectionProvider, String B_UnallocatedCash_AcctR)    throws ServletException {
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
  public static String selectDef4908_4(ConnectionProvider connectionProvider, String B_RevaluationLoss_AcctR)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDef4904_5(ConnectionProvider connectionProvider, String B_Unidentified_AcctR)    throws ServletException {
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
  public static String selectDef6494_6(ConnectionProvider connectionProvider, String B_PaymentSelect_AcctR)    throws ServletException {
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
  public static String selectDef4901_7(ConnectionProvider connectionProvider, String B_Expense_AcctR)    throws ServletException {
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
  public static String selectDef4905_8(ConnectionProvider connectionProvider, String B_SettlementGain_AcctR)    throws ServletException {
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
  public static String selectDef4898_9(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef4900_10(ConnectionProvider connectionProvider, String B_Asset_AcctR)    throws ServletException {
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
  public static String selectDef4903_11(ConnectionProvider connectionProvider, String B_InterestExp_AcctR)    throws ServletException {
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
  public static String selectDef4896_12(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef4899_13(ConnectionProvider connectionProvider, String B_InTransit_AcctR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_BankAccount_Acct.C_BankAccount_ID AS NAME" +
      "        FROM C_BankAccount_Acct" +
      "        WHERE C_BankAccount_Acct.C_BankAccount_Acct_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cBankaccountId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.DisplayedAccount), ''))) AS NAME FROM C_BankAccount left join (select C_BankAccount_ID, C_Bank_ID, DisplayedAccount from C_BankAccount) table1 on (C_BankAccount.C_BankAccount_ID = table1.C_BankAccount_ID) left join (select C_Bank_ID, Name from C_Bank) table2 on (table1.C_Bank_ID = table2.C_Bank_ID) WHERE C_BankAccount.C_BankAccount_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cBankaccountId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.DisplayedAccount), ''))) AS NAME FROM C_BankAccount left join (select C_BankAccount_ID, C_Bank_ID, DisplayedAccount from C_BankAccount) table1 on (C_BankAccount.C_BankAccount_ID = table1.C_BankAccount_ID) left join (select C_Bank_ID, Name from C_Bank) table2 on (table1.C_Bank_ID = table2.C_Bank_ID) WHERE C_BankAccount.C_BankAccount_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);

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
      "        UPDATE C_BankAccount_Acct" +
      "        SET C_BankAccount_Acct_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_BankAccount_ID = (?) , C_AcctSchema_ID = (?) , IsActive = (?) , B_Asset_Acct = (?) , B_InTransit_Acct = (?) , B_UnallocatedCash_Acct = (?) , B_Unidentified_Acct = (?) , B_PaymentSelect_Acct = (?) , B_Expense_Acct = (?) , B_InterestExp_Acct = (?) , B_InterestRev_Acct = (?) , B_RevaluationGain_Acct = (?) , B_RevaluationLoss_Acct = (?) , B_SettlementGain_Acct = (?) , B_SettlementLoss_Acct = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_BankAccount_Acct.C_BankAccount_Acct_ID = ? " +
      "                 AND C_BankAccount_Acct.C_BankAccount_ID = ? " +
      "        AND C_BankAccount_Acct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_BankAccount_Acct.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountAcctId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bAssetAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bIntransitAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bUnallocatedcashAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bUnidentifiedAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bPaymentselectAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bExpenseAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bInterestexpAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bInterestrevAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bRevaluationgainAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bRevaluationlossAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bSettlementgainAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bSettlementlossAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountAcctId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
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
      "        INSERT INTO C_BankAccount_Acct " +
      "        (C_BankAccount_Acct_ID, AD_Client_ID, AD_Org_ID, C_BankAccount_ID, C_AcctSchema_ID, IsActive, B_Asset_Acct, B_InTransit_Acct, B_UnallocatedCash_Acct, B_Unidentified_Acct, B_PaymentSelect_Acct, B_Expense_Acct, B_InterestExp_Acct, B_InterestRev_Acct, B_RevaluationGain_Acct, B_RevaluationLoss_Acct, B_SettlementGain_Acct, B_SettlementLoss_Acct, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountAcctId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bAssetAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bIntransitAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bUnallocatedcashAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bUnidentifiedAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bPaymentselectAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bExpenseAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bInterestexpAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bInterestrevAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bRevaluationgainAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bRevaluationlossAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bSettlementgainAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bSettlementlossAcct);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cBankaccountId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_BankAccount_Acct" +
      "        WHERE C_BankAccount_Acct.C_BankAccount_Acct_ID = ? " +
      "                 AND C_BankAccount_Acct.C_BankAccount_ID = ? " +
      "        AND C_BankAccount_Acct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_BankAccount_Acct.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cBankaccountId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_BankAccount_Acct" +
      "        WHERE C_BankAccount_Acct.C_BankAccount_Acct_ID = ? " +
      "                 AND C_BankAccount_Acct.C_BankAccount_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);

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
      "          FROM C_BankAccount_Acct" +
      "         WHERE C_BankAccount_Acct.C_BankAccount_Acct_ID = ? ";

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
      "          FROM C_BankAccount_Acct" +
      "         WHERE C_BankAccount_Acct.C_BankAccount_Acct_ID = ? ";

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
