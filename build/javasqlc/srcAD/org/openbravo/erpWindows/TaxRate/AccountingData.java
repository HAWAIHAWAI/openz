//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.TaxRate;

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
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cTaxId;
  public String cTaxIdr;
  public String cAcctschemaId;
  public String cAcctschemaIdr;
  public String isactive;
  public String tDueAcct;
  public String tDueAcctr;
  public String tLiabilityAcct;
  public String tCreditAcct;
  public String tCreditAcctr;
  public String tReceivablesAcct;
  public String tExpenseAcct;
  public String tPExpenseAcct;
  public String tPExpenseAcctr;
  public String tPRevenueAcct;
  public String tPRevenueAcctr;
  public String tArDiscountAcct;
  public String tArDiscountAcctr;
  public String tApDiscountAcct;
  public String tApDiscountAcctr;
  public String tWriteoffAcct;
  public String tWriteoffAcctr;
  public String cTaxAcctId;
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
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("c_tax_idr") || fieldName.equals("cTaxIdr"))
      return cTaxIdr;
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_idr") || fieldName.equals("cAcctschemaIdr"))
      return cAcctschemaIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
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
    else if (fieldName.equalsIgnoreCase("t_p_expense_acct") || fieldName.equals("tPExpenseAcct"))
      return tPExpenseAcct;
    else if (fieldName.equalsIgnoreCase("t_p_expense_acctr") || fieldName.equals("tPExpenseAcctr"))
      return tPExpenseAcctr;
    else if (fieldName.equalsIgnoreCase("t_p_revenue_acct") || fieldName.equals("tPRevenueAcct"))
      return tPRevenueAcct;
    else if (fieldName.equalsIgnoreCase("t_p_revenue_acctr") || fieldName.equals("tPRevenueAcctr"))
      return tPRevenueAcctr;
    else if (fieldName.equalsIgnoreCase("t_ar_discount_acct") || fieldName.equals("tArDiscountAcct"))
      return tArDiscountAcct;
    else if (fieldName.equalsIgnoreCase("t_ar_discount_acctr") || fieldName.equals("tArDiscountAcctr"))
      return tArDiscountAcctr;
    else if (fieldName.equalsIgnoreCase("t_ap_discount_acct") || fieldName.equals("tApDiscountAcct"))
      return tApDiscountAcct;
    else if (fieldName.equalsIgnoreCase("t_ap_discount_acctr") || fieldName.equals("tApDiscountAcctr"))
      return tApDiscountAcctr;
    else if (fieldName.equalsIgnoreCase("t_writeoff_acct") || fieldName.equals("tWriteoffAcct"))
      return tWriteoffAcct;
    else if (fieldName.equalsIgnoreCase("t_writeoff_acctr") || fieldName.equals("tWriteoffAcctr"))
      return tWriteoffAcctr;
    else if (fieldName.equalsIgnoreCase("c_tax_acct_id") || fieldName.equals("cTaxAcctId"))
      return cTaxAcctId;
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
  public static AccountingData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cTaxId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cTaxId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static AccountingData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cTaxId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Tax_Acct.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Tax_Acct.CreatedBy) as CreatedByR, " +
      "        to_char(C_Tax_Acct.Updated, ?) as updated, " +
      "        to_char(C_Tax_Acct.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Tax_Acct.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Tax_Acct.UpdatedBy) as UpdatedByR," +
      "        C_Tax_Acct.AD_Client_ID, " +
      "(CASE WHEN C_Tax_Acct.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_Tax_Acct.AD_Org_ID, " +
      "(CASE WHEN C_Tax_Acct.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_Tax_Acct.C_Tax_ID, " +
      "(CASE WHEN C_Tax_Acct.C_Tax_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_Tax_IDR, " +
      "C_Tax_Acct.C_AcctSchema_ID, " +
      "(CASE WHEN C_Tax_Acct.C_AcctSchema_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_AcctSchema_IDR, " +
      "COALESCE(C_Tax_Acct.IsActive, 'N') AS IsActive, " +
      "C_Tax_Acct.T_Due_Acct, " +
      "(CASE WHEN C_Tax_Acct.T_Due_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Combination), ''))),'') ) END) AS T_Due_AcctR, " +
      "C_Tax_Acct.T_Liability_Acct, " +
      "C_Tax_Acct.T_Credit_Acct, " +
      "(CASE WHEN C_Tax_Acct.T_Credit_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Combination), ''))),'') ) END) AS T_Credit_AcctR, " +
      "C_Tax_Acct.T_Receivables_Acct, " +
      "C_Tax_Acct.T_Expense_Acct, " +
      "C_Tax_Acct.T_P_Expense_Acct, " +
      "(CASE WHEN C_Tax_Acct.T_P_Expense_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Combination), ''))),'') ) END) AS T_P_Expense_AcctR, " +
      "C_Tax_Acct.T_P_Revenue_Acct, " +
      "(CASE WHEN C_Tax_Acct.T_P_Revenue_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Combination), ''))),'') ) END) AS T_P_Revenue_AcctR, " +
      "C_Tax_Acct.T_Ar_Discount_Acct, " +
      "(CASE WHEN C_Tax_Acct.T_Ar_Discount_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Combination), ''))),'') ) END) AS T_Ar_Discount_AcctR, " +
      "C_Tax_Acct.T_Ap_Discount_Acct, " +
      "(CASE WHEN C_Tax_Acct.T_Ap_Discount_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Combination), ''))),'') ) END) AS T_Ap_Discount_AcctR, " +
      "C_Tax_Acct.T_Writeoff_Acct, " +
      "(CASE WHEN C_Tax_Acct.T_Writeoff_Acct IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Combination), ''))),'') ) END) AS T_Writeoff_AcctR, " +
      "C_Tax_Acct.C_Tax_Acct_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Tax_Acct left join (select AD_Client_ID, Name from AD_Client) table1 on (C_Tax_Acct.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_Tax_Acct.AD_Org_ID = table2.AD_Org_ID) left join (select C_Tax_ID, Name from C_Tax) table3 on (C_Tax_Acct.C_Tax_ID = table3.C_Tax_ID) left join (select C_Tax_ID,AD_Language, Name from C_Tax_TRL) tableTRL3 on (table3.C_Tax_ID = tableTRL3.C_Tax_ID and tableTRL3.AD_Language = ?)  left join (select C_AcctSchema_ID, Name from C_AcctSchema) table4 on (C_Tax_Acct.C_AcctSchema_ID = table4.C_AcctSchema_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table5 on (C_Tax_Acct.T_Due_Acct = table5.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table6 on (C_Tax_Acct.T_Credit_Acct = table6.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table7 on (C_Tax_Acct.T_P_Expense_Acct = table7.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table8 on (C_Tax_Acct.T_P_Revenue_Acct = table8.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table9 on (C_Tax_Acct.T_Ar_Discount_Acct = table9.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table10 on (C_Tax_Acct.T_Ap_Discount_Acct = table10.C_ValidCombination_ID) left join (select C_ValidCombination_ID, Combination from C_ValidCombination) table11 on (C_Tax_Acct.T_Writeoff_Acct = table11.C_ValidCombination_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cTaxId==null || cTaxId.equals(""))?"":"  AND C_Tax_Acct.C_Tax_ID = ?  ");
    strSql = strSql + 
      "        AND C_Tax_Acct.C_Tax_Acct_ID = ? " +
      "        AND C_Tax_Acct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Tax_Acct.AD_Org_ID IN (";
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
      if (cTaxId != null && !(cTaxId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
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
        objectAccountingData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAccountingData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectAccountingData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAccountingData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectAccountingData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectAccountingData.cTaxIdr = UtilSql.getValue(result, "c_tax_idr");
        objectAccountingData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectAccountingData.cAcctschemaIdr = UtilSql.getValue(result, "c_acctschema_idr");
        objectAccountingData.isactive = UtilSql.getValue(result, "isactive");
        objectAccountingData.tDueAcct = UtilSql.getValue(result, "t_due_acct");
        objectAccountingData.tDueAcctr = UtilSql.getValue(result, "t_due_acctr");
        objectAccountingData.tLiabilityAcct = UtilSql.getValue(result, "t_liability_acct");
        objectAccountingData.tCreditAcct = UtilSql.getValue(result, "t_credit_acct");
        objectAccountingData.tCreditAcctr = UtilSql.getValue(result, "t_credit_acctr");
        objectAccountingData.tReceivablesAcct = UtilSql.getValue(result, "t_receivables_acct");
        objectAccountingData.tExpenseAcct = UtilSql.getValue(result, "t_expense_acct");
        objectAccountingData.tPExpenseAcct = UtilSql.getValue(result, "t_p_expense_acct");
        objectAccountingData.tPExpenseAcctr = UtilSql.getValue(result, "t_p_expense_acctr");
        objectAccountingData.tPRevenueAcct = UtilSql.getValue(result, "t_p_revenue_acct");
        objectAccountingData.tPRevenueAcctr = UtilSql.getValue(result, "t_p_revenue_acctr");
        objectAccountingData.tArDiscountAcct = UtilSql.getValue(result, "t_ar_discount_acct");
        objectAccountingData.tArDiscountAcctr = UtilSql.getValue(result, "t_ar_discount_acctr");
        objectAccountingData.tApDiscountAcct = UtilSql.getValue(result, "t_ap_discount_acct");
        objectAccountingData.tApDiscountAcctr = UtilSql.getValue(result, "t_ap_discount_acctr");
        objectAccountingData.tWriteoffAcct = UtilSql.getValue(result, "t_writeoff_acct");
        objectAccountingData.tWriteoffAcctr = UtilSql.getValue(result, "t_writeoff_acctr");
        objectAccountingData.cTaxAcctId = UtilSql.getValue(result, "c_tax_acct_id");
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
  public static AccountingData[] set(String cTaxId, String tDueAcct, String tDueAcctr, String adClientId, String adOrgId, String createdby, String createdbyr, String tPRevenueAcct, String tPRevenueAcctr, String tArDiscountAcct, String tArDiscountAcctr, String tReceivablesAcct, String tReceivablesAcctr, String updatedby, String updatedbyr, String tWriteoffAcct, String tWriteoffAcctr, String tCreditAcct, String tCreditAcctr, String tLiabilityAcct, String tLiabilityAcctr, String tExpenseAcct, String tExpenseAcctr, String cTaxAcctId, String isactive, String cAcctschemaId, String tApDiscountAcct, String tApDiscountAcctr, String tPExpenseAcct, String tPExpenseAcctr)    throws ServletException {
    AccountingData objectAccountingData[] = new AccountingData[1];
    objectAccountingData[0] = new AccountingData();
    objectAccountingData[0].created = "";
    objectAccountingData[0].createdbyr = createdbyr;
    objectAccountingData[0].updated = "";
    objectAccountingData[0].updatedTimeStamp = "";
    objectAccountingData[0].updatedby = updatedby;
    objectAccountingData[0].updatedbyr = updatedbyr;
    objectAccountingData[0].adClientId = adClientId;
    objectAccountingData[0].adClientIdr = "";
    objectAccountingData[0].adOrgId = adOrgId;
    objectAccountingData[0].adOrgIdr = "";
    objectAccountingData[0].cTaxId = cTaxId;
    objectAccountingData[0].cTaxIdr = "";
    objectAccountingData[0].cAcctschemaId = cAcctschemaId;
    objectAccountingData[0].cAcctschemaIdr = "";
    objectAccountingData[0].isactive = isactive;
    objectAccountingData[0].tDueAcct = tDueAcct;
    objectAccountingData[0].tDueAcctr = tDueAcctr;
    objectAccountingData[0].tLiabilityAcct = tLiabilityAcct;
    objectAccountingData[0].tCreditAcct = tCreditAcct;
    objectAccountingData[0].tCreditAcctr = tCreditAcctr;
    objectAccountingData[0].tReceivablesAcct = tReceivablesAcct;
    objectAccountingData[0].tExpenseAcct = tExpenseAcct;
    objectAccountingData[0].tPExpenseAcct = tPExpenseAcct;
    objectAccountingData[0].tPExpenseAcctr = tPExpenseAcctr;
    objectAccountingData[0].tPRevenueAcct = tPRevenueAcct;
    objectAccountingData[0].tPRevenueAcctr = tPRevenueAcctr;
    objectAccountingData[0].tArDiscountAcct = tArDiscountAcct;
    objectAccountingData[0].tArDiscountAcctr = tArDiscountAcctr;
    objectAccountingData[0].tApDiscountAcct = tApDiscountAcct;
    objectAccountingData[0].tApDiscountAcctr = tApDiscountAcctr;
    objectAccountingData[0].tWriteoffAcct = tWriteoffAcct;
    objectAccountingData[0].tWriteoffAcctr = tWriteoffAcctr;
    objectAccountingData[0].cTaxAcctId = cTaxAcctId;
    objectAccountingData[0].language = "";
    return objectAccountingData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef5084_0(ConnectionProvider connectionProvider, String T_Due_AcctR)    throws ServletException {
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
  public static String selectDef5081_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef8BBE9224CA5B4AEFA117E8A44A10D991_2(ConnectionProvider connectionProvider, String T_P_Revenue_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as T_P_Revenue_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, T_P_Revenue_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "t_p_revenue_acct");
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
  public static String selectDefB5899B5DB85A400097FA7DD54E00FEC9_3(ConnectionProvider connectionProvider, String T_Ar_Discount_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as T_Ar_Discount_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, T_Ar_Discount_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "t_ar_discount_acct");
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
  public static String selectDef5087_4(ConnectionProvider connectionProvider, String T_Receivables_AcctR)    throws ServletException {
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
  public static String selectDef5083_5(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef7123AE2D2BDA4143B8AD2345AD331B73_6(ConnectionProvider connectionProvider, String T_Writeoff_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as T_Writeoff_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, T_Writeoff_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "t_writeoff_acct");
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
  public static String selectDef5086_7(ConnectionProvider connectionProvider, String T_Credit_AcctR)    throws ServletException {
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
  public static String selectDef5085_8(ConnectionProvider connectionProvider, String T_Liability_AcctR)    throws ServletException {
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
  public static String selectDef5088_9(ConnectionProvider connectionProvider, String T_Expense_AcctR)    throws ServletException {
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
  public static String selectDefDD2AA7A0BFA7409E80D1FF166AFA6B29_10(ConnectionProvider connectionProvider, String T_Ap_Discount_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as T_Ap_Discount_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, T_Ap_Discount_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "t_ap_discount_acct");
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
  public static String selectDef6DB0FD99E7F14B238CA180BDD0222045_11(ConnectionProvider connectionProvider, String T_P_Expense_AcctR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Combination), '') ) as T_P_Expense_Acct FROM C_ValidCombination table1 WHERE table1.isActive='Y' AND table1.C_ValidCombination_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, T_P_Expense_AcctR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "t_p_expense_acct");
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
      "        SELECT C_Tax_Acct.C_Tax_ID AS NAME" +
      "        FROM C_Tax_Acct" +
      "        WHERE C_Tax_Acct.C_Tax_Acct_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String cTaxId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_Tax left join (select C_Tax_ID, Name from C_Tax) table1 on (C_Tax.C_Tax_ID = table1.C_Tax_ID) left join (select C_Tax_ID,AD_Language, Name from C_Tax_TRL) tableTRL1 on (table1.C_Tax_ID = tableTRL1.C_Tax_ID and tableTRL1.AD_Language = ?)  WHERE C_Tax.C_Tax_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String cTaxId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_Tax left join (select C_Tax_ID, Name from C_Tax) table1 on (C_Tax.C_Tax_ID = table1.C_Tax_ID) left join (select C_Tax_ID,AD_Language, Name from C_Tax_TRL) tableTRL1 on (table1.C_Tax_ID = tableTRL1.C_Tax_ID and tableTRL1.AD_Language = ?)  WHERE C_Tax.C_Tax_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);

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
      "        UPDATE C_Tax_Acct" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , C_Tax_ID = (?) , C_AcctSchema_ID = (?) , IsActive = (?) , T_Due_Acct = (?) , T_Liability_Acct = (?) , T_Credit_Acct = (?) , T_Receivables_Acct = (?) , T_Expense_Acct = (?) , T_P_Expense_Acct = (?) , T_P_Revenue_Acct = (?) , T_Ar_Discount_Acct = (?) , T_Ap_Discount_Acct = (?) , T_Writeoff_Acct = (?) , C_Tax_Acct_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Tax_Acct.C_Tax_Acct_ID = ? " +
      "                 AND C_Tax_Acct.C_Tax_ID = ? " +
      "        AND C_Tax_Acct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Tax_Acct.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tDueAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tLiabilityAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tCreditAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tReceivablesAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tExpenseAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tPExpenseAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tPRevenueAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tArDiscountAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tApDiscountAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tWriteoffAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxAcctId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxAcctId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
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
      "        INSERT INTO C_Tax_Acct " +
      "        (AD_Client_ID, AD_Org_ID, C_Tax_ID, C_AcctSchema_ID, IsActive, T_Due_Acct, T_Liability_Acct, T_Credit_Acct, T_Receivables_Acct, T_Expense_Acct, T_P_Expense_Acct, T_P_Revenue_Acct, T_Ar_Discount_Acct, T_Ap_Discount_Acct, T_Writeoff_Acct, C_Tax_Acct_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tDueAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tLiabilityAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tCreditAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tReceivablesAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tExpenseAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tPExpenseAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tPRevenueAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tArDiscountAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tApDiscountAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tWriteoffAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxAcctId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cTaxId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Tax_Acct" +
      "        WHERE C_Tax_Acct.C_Tax_Acct_ID = ? " +
      "                 AND C_Tax_Acct.C_Tax_ID = ? " +
      "        AND C_Tax_Acct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Tax_Acct.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cTaxId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Tax_Acct" +
      "        WHERE C_Tax_Acct.C_Tax_Acct_ID = ? " +
      "                 AND C_Tax_Acct.C_Tax_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);

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
      "          FROM C_Tax_Acct" +
      "         WHERE C_Tax_Acct.C_Tax_Acct_ID = ? ";

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
      "          FROM C_Tax_Acct" +
      "         WHERE C_Tax_Acct.C_Tax_Acct_ID = ? ";

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
