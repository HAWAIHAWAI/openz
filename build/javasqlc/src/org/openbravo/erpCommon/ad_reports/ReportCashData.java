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

class ReportCashData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportCashData.class);
  private String InitRecordNumber="0";
  public String cCashbookId;
  public String namecashbook;
  public String statementdate;
  public String cCashId;
  public String namecash;
  public String beginningbalance;
  public String endingbalance;
  public String currency;
  public String line;
  public String name;
  public String amount;
  public String description;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_cashbook_id") || fieldName.equals("cCashbookId"))
      return cCashbookId;
    else if (fieldName.equalsIgnoreCase("namecashbook"))
      return namecashbook;
    else if (fieldName.equalsIgnoreCase("statementdate"))
      return statementdate;
    else if (fieldName.equalsIgnoreCase("c_cash_id") || fieldName.equals("cCashId"))
      return cCashId;
    else if (fieldName.equalsIgnoreCase("namecash"))
      return namecash;
    else if (fieldName.equalsIgnoreCase("beginningbalance"))
      return beginningbalance;
    else if (fieldName.equalsIgnoreCase("endingbalance"))
      return endingbalance;
    else if (fieldName.equalsIgnoreCase("currency"))
      return currency;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportCashData[] select(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String parDateFrom, String parDateTo, String cashBook)    throws ServletException {
    return select(connectionProvider, adLanguage, adUserClient, adUserOrg, parDateFrom, parDateTo, cashBook, 0, 0);
  }

  public static ReportCashData[] select(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String parDateFrom, String parDateTo, String cashBook, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_CASHBOOK.C_CASHBOOK_ID, C_CASHBOOK.NAME AS NAMECASHBOOK, C_CASH.STATEMENTDATE, C_CASH.C_CASH_ID, C_CASH.NAME AS NAMECASH, " +
      "             C_CASH.BEGINNINGBALANCE, C_CASH.ENDINGBALANCE,  C_CURRENCY.ISO_CODE AS CURRENCY," +
      "             C_CASHLINE.LINE, COALESCE(AD_REF_LIST_TRL.NAME,AD_REF_LIST.NAME) AS NAME, C_CASHLINE.AMOUNT, C_CASHLINE.DESCRIPTION" +
      "      FROM C_CASHBOOK, C_CASH, C_CASHLINE, C_CURRENCY, AD_REF_LIST " +
      "			     LEFT JOIN AD_REF_LIST_TRL ON AD_REF_LIST.AD_REF_LIST_ID=AD_REF_LIST_TRL.AD_REF_LIST_ID" +
      "      		 					 								 AND AD_REF_LIST_TRL.AD_LANGUAGE = ?" +
      "      WHERE C_CASHBOOK.C_CASHBOOK_ID=C_CASH.C_CASHBOOK_ID" +
      "      AND C_CASH.C_CASH_ID=C_CASHLINE.C_CASH_ID" +
      "      AND C_CASHBOOK.C_CURRENCY_ID=C_CURRENCY.C_CURRENCY_ID" +
      "      AND C_CASHLINE.CASHTYPE=AD_REF_LIST.VALUE" +
      "      AND AD_REFERENCE_ID='217'" +
      "      AND C_CASH.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "      AND C_CASH.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "      AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":" AND C_CASH.STATEMENTDATE >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":" AND C_CASH.STATEMENTDATE < TO_DATE(?) ");
    strSql = strSql + ((cashBook==null || cashBook.equals(""))?"":" AND C_CASHBOOK.C_CASHBOOK_ID = ? ");
    strSql = strSql + 
      "      AND C_CASH.PROCESSED='Y'" +
      "      ORDER BY NAMECASHBOOK, STATEMENTDATE, C_CASH_ID, C_CASHLINE.LINE";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
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
      if (cashBook != null && !(cashBook.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cashBook);
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
        ReportCashData objectReportCashData = new ReportCashData();
        objectReportCashData.cCashbookId = UtilSql.getValue(result, "c_cashbook_id");
        objectReportCashData.namecashbook = UtilSql.getValue(result, "namecashbook");
        objectReportCashData.statementdate = UtilSql.getDateValue(result, "statementdate", "dd-MM-yyyy");
        objectReportCashData.cCashId = UtilSql.getValue(result, "c_cash_id");
        objectReportCashData.namecash = UtilSql.getValue(result, "namecash");
        objectReportCashData.beginningbalance = UtilSql.getValue(result, "beginningbalance");
        objectReportCashData.endingbalance = UtilSql.getValue(result, "endingbalance");
        objectReportCashData.currency = UtilSql.getValue(result, "currency");
        objectReportCashData.line = UtilSql.getValue(result, "line");
        objectReportCashData.name = UtilSql.getValue(result, "name");
        objectReportCashData.amount = UtilSql.getValue(result, "amount");
        objectReportCashData.description = UtilSql.getValue(result, "description");
        objectReportCashData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportCashData);
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
    ReportCashData objectReportCashData[] = new ReportCashData[vector.size()];
    vector.copyInto(objectReportCashData);
    return(objectReportCashData);
  }

  public static ReportCashData[] set()    throws ServletException {
    ReportCashData objectReportCashData[] = new ReportCashData[1];
    objectReportCashData[0] = new ReportCashData();
    objectReportCashData[0].cCashbookId = "";
    objectReportCashData[0].namecashbook = "";
    objectReportCashData[0].statementdate = "";
    objectReportCashData[0].cCashId = "";
    objectReportCashData[0].namecash = "";
    objectReportCashData[0].beginningbalance = "";
    objectReportCashData[0].endingbalance = "";
    objectReportCashData[0].currency = "";
    objectReportCashData[0].line = "";
    objectReportCashData[0].name = "";
    objectReportCashData[0].amount = "";
    objectReportCashData[0].description = "";
    return objectReportCashData;
  }

  public static String BeginningBalance(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String statementDate, String c_cashbookId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COALESCE(SUM(C_CASHLINE.AMOUNT),0) AS TOTAL_AMT" +
      "      FROM C_CASH, C_CASHLINE" +
      "      WHERE C_CASH.C_CASH_ID=C_CASHLINE.C_CASH_ID" +
      "      AND C_CASH.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "      AND C_CASH.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "      AND C_CASH.STATEMENTDATE < TO_DATE(?)" +
      "      AND C_CASH.C_CASHBOOK_ID = ?" +
      "      AND C_CASH.PROCESSED='Y'";

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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, statementDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_cashbookId);

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
