//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ReportBankData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportBankData.class);
  private String InitRecordNumber="0";
  public String name;
  public String bankaccount;
  public String trxamt;
  public String payamt;
  public String bankstatementId;
  public String statementdate;
  public String begining;
  public String ending;
  public String currency;
  public String line;
  public String description;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("bankaccount"))
      return bankaccount;
    else if (fieldName.equalsIgnoreCase("trxamt"))
      return trxamt;
    else if (fieldName.equalsIgnoreCase("payamt"))
      return payamt;
    else if (fieldName.equalsIgnoreCase("bankstatement_id") || fieldName.equals("bankstatementId"))
      return bankstatementId;
    else if (fieldName.equalsIgnoreCase("statementdate"))
      return statementdate;
    else if (fieldName.equalsIgnoreCase("begining"))
      return begining;
    else if (fieldName.equalsIgnoreCase("ending"))
      return ending;
    else if (fieldName.equalsIgnoreCase("currency"))
      return currency;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportBankData[] select(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String parDateFrom, String parDateTo, String parBankaccount)    throws ServletException {
    return select(connectionProvider, adUserClient, adUserOrg, parDateFrom, parDateTo, parBankaccount, 0, 0);
  }

  public static ReportBankData[] select(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String parDateFrom, String parDateTo, String parBankaccount, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_BANK.NAME AS NAME, " +
      "      (C_BANK.CODEBANK || '/' || C_BANK.CODEBRANCH || C_BANK.DIGITCONTROL || C_BANKACCOUNT.CODEACCOUNT || '.' || C_BANKACCOUNT.DIGITCONTROL) AS bankaccount, " +
      "      C_BANKSTATEMENTLINE.STMTAMT AS TRXAMT, C_DEBT_PAYMENT.AMOUNT AS PAYAMT, C_BANKSTATEMENT.C_BANKSTATEMENT_ID AS BANKSTATEMENT_ID," +
      "      C_BANKSTATEMENTLINE.DATEACCT AS STATEMENTDATE, C_BANKSTATEMENT.BEGINNINGBALANCE AS BEGINING, C_BANKSTATEMENT.ENDINGBALANCE AS ENDING, C_CURRENCY.DESCRIPTION AS CURRENCY, C_BANKSTATEMENTLINE.LINE AS LINE, C_BANKSTATEMENTLINE.DESCRIPTION AS DESCRIPTION " +
      "      FROM C_BANKSTATEMENTLINE left join C_DEBT_PAYMENT on C_BANKSTATEMENTLINE.C_DEBT_PAYMENT_ID = C_DEBT_PAYMENT.C_DEBT_PAYMENT_ID," +
      "      C_BANK, C_BANKACCOUNT, C_BANKSTATEMENT,   C_CURRENCY" +
      "      WHERE C_BANK.c_bank_id = C_BANKACCOUNT.C_BANK_ID " +
      "      AND C_BANKACCOUNT.C_BANKACCOUNT_ID = C_BANKSTATEMENT.C_BANKACCOUNT_ID " +
      "      AND C_BANKSTATEMENT.C_BANKSTATEMENT_ID = C_BANKSTATEMENTLINE.C_BANKSTATEMENT_ID " +
      "      AND C_BANKACCOUNT.C_CURRENCY_ID = C_CURRENCY.C_CURRENCY_ID" +
      "      AND C_BANK.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND C_BANK.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":" AND C_BANKSTATEMENTLINE.DATEACCT >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":" AND C_BANKSTATEMENTLINE.DATEACCT < TO_DATE(?) ");
    strSql = strSql + ((parBankaccount==null || parBankaccount.equals(""))?"":" AND c_bankaccount.c_bankaccount_id = ? ");
    strSql = strSql + 
      "      AND C_BANKSTATEMENT.PROCESSED='Y'" +
      "      ORDER BY NAME,STATEMENTDATE, LINE";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (parBankaccount != null && !(parBankaccount.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parBankaccount);
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
        ReportBankData objectReportBankData = new ReportBankData();
        objectReportBankData.name = UtilSql.getValue(result, "name");
        objectReportBankData.bankaccount = UtilSql.getValue(result, "bankaccount");
        objectReportBankData.trxamt = UtilSql.getValue(result, "trxamt");
        objectReportBankData.payamt = UtilSql.getValue(result, "payamt");
        objectReportBankData.bankstatementId = UtilSql.getValue(result, "bankstatement_id");
        objectReportBankData.statementdate = UtilSql.getDateValue(result, "statementdate", "dd-MM-yyyy");
        objectReportBankData.begining = UtilSql.getValue(result, "begining");
        objectReportBankData.ending = UtilSql.getValue(result, "ending");
        objectReportBankData.currency = UtilSql.getValue(result, "currency");
        objectReportBankData.line = UtilSql.getValue(result, "line");
        objectReportBankData.description = UtilSql.getValue(result, "description");
        objectReportBankData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportBankData);
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
    ReportBankData objectReportBankData[] = new ReportBankData[vector.size()];
    vector.copyInto(objectReportBankData);
    return(objectReportBankData);
  }

  public static ReportBankData[] set()    throws ServletException {
    ReportBankData objectReportBankData[] = new ReportBankData[1];
    objectReportBankData[0] = new ReportBankData();
    objectReportBankData[0].name = "";
    objectReportBankData[0].bankaccount = "";
    objectReportBankData[0].trxamt = "";
    objectReportBankData[0].payamt = "";
    objectReportBankData[0].bankstatementId = "";
    objectReportBankData[0].statementdate = "";
    objectReportBankData[0].begining = "";
    objectReportBankData[0].ending = "";
    objectReportBankData[0].currency = "";
    objectReportBankData[0].line = "";
    objectReportBankData[0].description = "";
    return objectReportBankData;
  }

  public static String BeginningBalance(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String acctDate, String cBankaccountId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COALESCE(SUM(C_BANKSTATEMENTLINE.STMTAMT),0) AS TOTAL_AMT" +
      "      FROM C_BANK, C_BANKACCOUNT, C_BANKSTATEMENT, C_BANKSTATEMENTLINE" +
      "      WHERE C_BANK.c_bank_id = C_BANKACCOUNT.C_BANK_ID " +
      "      AND C_BANKACCOUNT.C_BANKACCOUNT_ID = C_BANKSTATEMENT.C_BANKACCOUNT_ID " +
      "      AND C_BANKSTATEMENT.C_BANKSTATEMENT_ID = C_BANKSTATEMENTLINE.C_BANKSTATEMENT_ID " +
      "      AND C_BANK.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND C_BANK.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND C_BANKSTATEMENTLINE.DATEACCT < TO_DATE(?)" +
      "      AND c_bankaccount.c_bankaccount_id = ?" +
      "      AND C_BANKSTATEMENT.PROCESSED='Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total_amt");
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
