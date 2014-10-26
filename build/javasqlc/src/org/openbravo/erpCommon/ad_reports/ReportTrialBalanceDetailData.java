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

class ReportTrialBalanceDetailData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportTrialBalanceDetailData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;
  public String accountId;
  public String amtacctdr;
  public String amtacctcr;
  public String month;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("account_id") || fieldName.equals("accountId"))
      return accountId;
    else if (fieldName.equalsIgnoreCase("amtacctdr"))
      return amtacctdr;
    else if (fieldName.equalsIgnoreCase("amtacctcr"))
      return amtacctcr;
    else if (fieldName.equalsIgnoreCase("month"))
      return month;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportTrialBalanceDetailData[] select(ConnectionProvider connectionProvider, String orgFamily, String adUserClient, String adUserOrg, String parDateFrom, String parDateTo, String idFamily, String id)    throws ServletException {
    return select(connectionProvider, orgFamily, adUserClient, adUserOrg, parDateFrom, parDateTo, idFamily, id, 0, 0);
  }

  public static ReportTrialBalanceDetailData[] select(ConnectionProvider connectionProvider, String orgFamily, String adUserClient, String adUserOrg, String parDateFrom, String parDateTo, String idFamily, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT B.ID, B.NAME, B.ACCOUNT_ID, SUM(A.AMTACCTDR) AS AMTACCTDR, " +
      "      SUM(A.AMTACCTCR) AS AMTACCTCR,  TO_CHAR(to_date(ADD_MONTHS(TO_DATE('01/12/2000', 'DD/MM/YYYY'), A.MONTH_N)),to_char('MONTH')) AS MONTH " +
      "      FROM" +
      "      (SELECT SUM((CASE f.FACTACCTTYPE WHEN 'O' THEN 0 ELSE F.AMTACCTDR END)) AS AMTACCTDR, " +
      "      SUM((CASE f.FACTACCTTYPE WHEN 'O' THEN 0 ELSE f.AMTACCTCR END)) AS AMTACCTCR , TO_NUMBER(TO_CHAR(F.DATEACCT,to_char('MM'))) AS MONTH_N" +
      "      FROM FACT_ACCT F, C_ELEMENTVALUE EV" +
      "      WHERE F.ACCOUNT_ID = EV.C_ELEMENTVALUE_ID" +
      "      AND f.AD_ORG_ID IN(";
    strSql = strSql + ((orgFamily==null || orgFamily.equals(""))?"":orgFamily);
    strSql = strSql + 
      ")" +
      "      AND F.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND F.AD_ORG_ID IN(";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":" AND F.DATEACCT >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":" AND F.DATEACCT < TO_DATE(?) ");
    strSql = strSql + 
      "      AND F.FACTACCTTYPE <> 'R'" +
      "      AND F.FACTACCTTYPE <> 'C'" +
      "      AND F.ACCOUNT_ID IN (";
    strSql = strSql + ((idFamily==null || idFamily.equals(""))?"":idFamily);
    strSql = strSql + 
      ")" +
      "      AND F.ISACTIVE = 'Y'" +
      "      GROUP BY TO_CHAR(F.DATEACCT, to_char('MM')))A ," +
      "      (SELECT c_elementvalue_id AS ID,NAME AS NAME, VALUE AS ACCOUNT_ID" +
      "	      FROM C_ELEMENTVALUE WHERE c_elementvalue_id = ?) B" +
      "	    WHERE ID = ?" +
      "      GROUP BY ID, NAME, ACCOUNT_ID, MONTH_N" +
      "      ORDER BY MONTH_N";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (orgFamily != null && !(orgFamily.equals(""))) {
        }
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
      if (idFamily != null && !(idFamily.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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
        ReportTrialBalanceDetailData objectReportTrialBalanceDetailData = new ReportTrialBalanceDetailData();
        objectReportTrialBalanceDetailData.id = UtilSql.getValue(result, "id");
        objectReportTrialBalanceDetailData.name = UtilSql.getValue(result, "name");
        objectReportTrialBalanceDetailData.accountId = UtilSql.getValue(result, "account_id");
        objectReportTrialBalanceDetailData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportTrialBalanceDetailData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportTrialBalanceDetailData.month = UtilSql.getValue(result, "month");
        objectReportTrialBalanceDetailData.rownum = Long.toString(countRecord);
        objectReportTrialBalanceDetailData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportTrialBalanceDetailData);
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
    ReportTrialBalanceDetailData objectReportTrialBalanceDetailData[] = new ReportTrialBalanceDetailData[vector.size()];
    vector.copyInto(objectReportTrialBalanceDetailData);
    return(objectReportTrialBalanceDetailData);
  }

  public static ReportTrialBalanceDetailData[] set()    throws ServletException {
    ReportTrialBalanceDetailData objectReportTrialBalanceDetailData[] = new ReportTrialBalanceDetailData[1];
    objectReportTrialBalanceDetailData[0] = new ReportTrialBalanceDetailData();
    objectReportTrialBalanceDetailData[0].id = "";
    objectReportTrialBalanceDetailData[0].name = "";
    objectReportTrialBalanceDetailData[0].accountId = "";
    objectReportTrialBalanceDetailData[0].amtacctdr = "";
    objectReportTrialBalanceDetailData[0].amtacctcr = "";
    objectReportTrialBalanceDetailData[0].month = "";
    return objectReportTrialBalanceDetailData;
  }

  public static String treeOrg(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TREE_ORG_ID FROM AD_CLIENTINFO" +
      "        WHERE AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_tree_org_id");
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

  public static String treeAccount(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TREE_ID FROM AD_TREE" +
      "        WHERE AD_CLIENT_ID = ?" +
      "        AND TREETYPE = 'EV'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_tree_id");
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

  public static String selectCompany(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME" +
      "        FROM AD_CLIENT" +
      "        WHERE AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

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

  public static String selectAccountName(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME" +
      "        FROM C_ELEMENTVALUE" +
      "        WHERE C_ELEMENTVALUE_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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
}
