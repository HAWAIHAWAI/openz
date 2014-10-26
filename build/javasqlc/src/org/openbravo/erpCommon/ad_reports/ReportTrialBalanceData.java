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

class ReportTrialBalanceData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportTrialBalanceData.class);
  private String InitRecordNumber="0";
  public String parentId;
  public String adOrgId;
  public String id;
  public String name;
  public String accountId;
  public String elementlevel;
  public String saldoInicial;
  public String amtacctcr;
  public String amtacctdr;
  public String totalamtacctcr;
  public String totalamtacctdr;
  public String saldoFinal;
  public String dateFrom;
  public String dateTo;
  public String bp;
  public String padre;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("parent_id") || fieldName.equals("parentId"))
      return parentId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("account_id") || fieldName.equals("accountId"))
      return accountId;
    else if (fieldName.equalsIgnoreCase("elementlevel"))
      return elementlevel;
    else if (fieldName.equalsIgnoreCase("saldo_inicial") || fieldName.equals("saldoInicial"))
      return saldoInicial;
    else if (fieldName.equalsIgnoreCase("amtacctcr"))
      return amtacctcr;
    else if (fieldName.equalsIgnoreCase("amtacctdr"))
      return amtacctdr;
    else if (fieldName.equalsIgnoreCase("totalamtacctcr"))
      return totalamtacctcr;
    else if (fieldName.equalsIgnoreCase("totalamtacctdr"))
      return totalamtacctdr;
    else if (fieldName.equalsIgnoreCase("saldo_final") || fieldName.equals("saldoFinal"))
      return saldoFinal;
    else if (fieldName.equalsIgnoreCase("date_from") || fieldName.equals("dateFrom"))
      return dateFrom;
    else if (fieldName.equalsIgnoreCase("date_to") || fieldName.equals("dateTo"))
      return dateTo;
    else if (fieldName.equalsIgnoreCase("bp"))
      return bp;
    else if (fieldName.equalsIgnoreCase("padre"))
      return padre;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportTrialBalanceData[] select(ConnectionProvider connectionProvider, String acctSchema, String dateFrom, String dateTo, String treeAcct, String adorgid, String adUserClient, String adUserOrg, String parDateFrom, String parDateTo, String accountFrom, String accountTo)    throws ServletException {
    return select(connectionProvider, acctSchema, dateFrom, dateTo, treeAcct, adorgid, adUserClient, adUserOrg, parDateFrom, parDateTo, accountFrom, accountTo, 0, 0);
  }

  public static ReportTrialBalanceData[] select(ConnectionProvider connectionProvider, String acctSchema, String dateFrom, String dateTo, String treeAcct, String adorgid, String adUserClient, String adUserOrg, String parDateFrom, String parDateTo, String accountFrom, String accountTo, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT" +
      "      MAX(parent_id) AS parent_id," +
      "      ad_org_id," +
      "      id," +
      "      name, " +
      "      account_id, " +
      "      elementlevel, " +
      "      SUM(saldo_inicial) AS saldo_inicial," +
      "      SUM(amtacctcr) AS AMTACCTCR, " +
      "      SUM(amtacctdr) AS AMTACCTDR, " +
      "      0 AS totalamtacctcr," +
      "      0 AS totalamtacctdr," +
      "      SUM(saldo_inicial) + zsfi_GetBalanceAmount(ad_org_id, ?, id, TO_DATE(?), TO_DATE(?)) AS saldo_final," +
      "      TO_DATE(?) AS date_from, " +
      "      TO_DATE(?) AS date_to, " +
      "      '' AS bp, " +
      "      '' AS padre" +
      "      FROM (" +
      "        SELECT " +
      "          AD_TREENODE.PARENT_ID, " +
      "          C_ELEMENTVALUE.ad_org_id,        " +
      "          C_ELEMENTVALUE.C_ELEMENTVALUE_ID AS ID, " +
      "          C_ELEMENTVALUE.elementlevel, " +
      "          C_ELEMENTVALUE.NAME AS NAME, " +
      "          C_ELEMENTVALUE.VALUE AS ACCOUNT_ID, " +
      "          0 AS SALDO_INICIAL, " +
      "          0 AS AMTACCTCR, " +
      "          0 AS AMTACCTDR" +
      "        FROM AD_TREENODE, C_ELEMENTVALUE" +
      "        WHERE AD_TREENODE.NODE_ID = C_ELEMENTVALUE.C_ELEMENTVALUE_ID" +
      "        AND AD_TREENODE.AD_TREE_ID = ?" +
      "        AND AD_TREENODE.ISACTIVE = 'Y'" +
      "        AND C_ELEMENTVALUE.ISACTIVE = 'Y'" +
      "        AND (" +
      "          select max(c_element_id) " +
      "          from c_acctschema_element" +
      "          where 1=1" +
      "            and c_acctschema_id = ?" +
      "            and ELEMENTTYPE = 'AC') = C_ELEMENTVALUE.C_ELEMENT_ID" +
      "      UNION" +
      "        SELECT" +
      "          '0' AS PARENT_ID," +
      "          f.ad_org_id," +
      "          F.ACCOUNT_ID AS ID," +
      "          EV.elementlevel," +
      "          EV.NAME AS NAME," +
      "          EV.VALUE AS ACCOUNT_ID," +
      "          zsfi_GetBalanceAtTime(f.ad_org_id, ?, f.account_id, TO_DATE(?)) AS SALDO_INICIAL," +
      "          SUM((CASE f.FACTACCTTYPE WHEN 'O' THEN 0 ELSE f.AMTACCTCR END)) AS AMTACCTCR_soll," +
      "          SUM((CASE f.FACTACCTTYPE WHEN 'O' THEN 0 ELSE F.AMTACCTDR END)) AS AMTACCTDR_haben " +
      "        FROM FACT_ACCT F, C_ELEMENTVALUE EV" +
      "        WHERE F.ACCOUNT_ID = EV.C_ELEMENTVALUE_ID" +
      "          AND f.AD_ORG_ID = ?" +
      "          AND F.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "          AND F.AD_ORG_ID IN(";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "          AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":" AND F.DATEACCT >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":" AND F.DATEACCT <= TO_DATE(?) ");
    strSql = strSql + ((accountFrom==null || accountFrom.equals(""))?"":" AND EV.VALUE >= ? ");
    strSql = strSql + ((accountTo==null || accountTo.equals(""))?"":" AND EV.VALUE <= ? ");
    strSql = strSql + ((acctSchema==null || acctSchema.equals(""))?"":"  AND F.C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      "          AND F.FACTACCTTYPE <> 'R'" +
      "          AND F.FACTACCTTYPE <> 'C'" +
      "          AND F.ISACTIVE = 'Y'" +
      "        GROUP BY f.ad_org_id, account_id, ev.name, ev.value, ev.elementlevel" +
      "        ) A" +
      "      GROUP BY ad_org_id, id, name, account_id, elementlevel" +
      "      ORDER BY parent_id, ad_org_id, id, name, account_id, elementlevel;";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctSchema);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, treeAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctSchema);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctSchema);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adorgid);
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
      if (accountFrom != null && !(accountFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountFrom);
      }
      if (accountTo != null && !(accountTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountTo);
      }
      if (acctSchema != null && !(acctSchema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctSchema);
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
        ReportTrialBalanceData objectReportTrialBalanceData = new ReportTrialBalanceData();
        objectReportTrialBalanceData.parentId = UtilSql.getValue(result, "parent_id");
        objectReportTrialBalanceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportTrialBalanceData.id = UtilSql.getValue(result, "id");
        objectReportTrialBalanceData.name = UtilSql.getValue(result, "name");
        objectReportTrialBalanceData.accountId = UtilSql.getValue(result, "account_id");
        objectReportTrialBalanceData.elementlevel = UtilSql.getValue(result, "elementlevel");
        objectReportTrialBalanceData.saldoInicial = UtilSql.getValue(result, "saldo_inicial");
        objectReportTrialBalanceData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportTrialBalanceData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportTrialBalanceData.totalamtacctcr = UtilSql.getValue(result, "totalamtacctcr");
        objectReportTrialBalanceData.totalamtacctdr = UtilSql.getValue(result, "totalamtacctdr");
        objectReportTrialBalanceData.saldoFinal = UtilSql.getValue(result, "saldo_final");
        objectReportTrialBalanceData.dateFrom = UtilSql.getDateValue(result, "date_from", "dd-MM-yyyy");
        objectReportTrialBalanceData.dateTo = UtilSql.getDateValue(result, "date_to", "dd-MM-yyyy");
        objectReportTrialBalanceData.bp = UtilSql.getValue(result, "bp");
        objectReportTrialBalanceData.padre = UtilSql.getValue(result, "padre");
        objectReportTrialBalanceData.rownum = Long.toString(countRecord);
        objectReportTrialBalanceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportTrialBalanceData);
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
    ReportTrialBalanceData objectReportTrialBalanceData[] = new ReportTrialBalanceData[vector.size()];
    vector.copyInto(objectReportTrialBalanceData);
    return(objectReportTrialBalanceData);
  }

  public static ReportTrialBalanceData[] selectBP(ConnectionProvider connectionProvider, String dateFrom, String dateTo, String org, String orgFamily, String adUserClient, String adUserOrg, String parDateFrom, String parDateTo, String accountFrom, String accountTo, String cBpartnerId, String acctSchema)    throws ServletException {
    return selectBP(connectionProvider, dateFrom, dateTo, org, orgFamily, adUserClient, adUserOrg, parDateFrom, parDateTo, accountFrom, accountTo, cBpartnerId, acctSchema, 0, 0);
  }

  public static ReportTrialBalanceData[] selectBP(ConnectionProvider connectionProvider, String dateFrom, String dateTo, String org, String orgFamily, String adUserClient, String adUserOrg, String parDateFrom, String parDateTo, String accountFrom, String accountTo, String cBpartnerId, String acctSchema, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT 0 AS PARENT_ID, bp, ID, NAME, ACCOUNT_ID, ELEMENTLEVEL, SUM(AMTACCTDR) AS AMTACCTDR, " +
      "      SUM(AMTACCTCR) AS AMTACCTCR, SUM(SALDO_INICIAL) AS SALDO_INICIAL,0 AS TOTALAMTACCTDR, 0 AS TOTALAMTACCTCR," +
      "      SUM(SALDO_INICIAL+AMTACCTDR-AMTACCTCR) AS SALDO_FINAL, TO_DATE(?) AS DATE_FROM, TO_DATE(?) AS DATE_TO, ? AS AD_ORG_ID" +
      "      FROM" +
      "      (SELECT f.c_bpartner_id, bp.name as bp, 0 AS PARENT_ID, F.ACCOUNT_ID AS ID, EV.ELEMENTLEVEL, EV.NAME AS NAME, EV.VALUE AS ACCOUNT_ID, " +
      "      SUM((CASE f.FACTACCTTYPE WHEN 'O' THEN F.AMTACCTDR-F.AMTACCTCR ELSE 0 END)) AS SALDO_INICIAL, " +
      "      SUM((CASE f.FACTACCTTYPE WHEN 'O' THEN 0 ELSE F.AMTACCTDR END)) AS AMTACCTDR, " +
      "      SUM((CASE f.FACTACCTTYPE WHEN 'O' THEN 0 ELSE f.AMTACCTCR END)) AS AMTACCTCR " +
      "      FROM C_ELEMENTVALUE EV, " +
      "           FACT_ACCT F left join c_bpartner bp on bp.c_bpartner_id = f.c_bpartner_id" +
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
    strSql = strSql + ((accountFrom==null || accountFrom.equals(""))?"":" AND EV.VALUE >= ? ");
    strSql = strSql + ((accountTo==null || accountTo.equals(""))?"":" AND EV.VALUE <= ? ");
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND F.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((acctSchema==null || acctSchema.equals(""))?"":"  AND F.C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      "      AND F.FACTACCTTYPE <> 'R'" +
      "      AND F.FACTACCTTYPE <> 'C'" +
      "      AND F.ISACTIVE = 'Y'" +
      "      GROUP BY f.c_bpartner_id, bp.name, ACCOUNT_ID,EV.NAME, EV.VALUE, EV.ELEMENTLEVEL) A" +
      "      GROUP BY bp, ID, NAME, ACCOUNT_ID, ELEMENTLEVEL" +
      "      ORDER BY bp, ID, ACCOUNT_ID";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
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
      if (accountFrom != null && !(accountFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountFrom);
      }
      if (accountTo != null && !(accountTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountTo);
      }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (acctSchema != null && !(acctSchema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctSchema);
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
        ReportTrialBalanceData objectReportTrialBalanceData = new ReportTrialBalanceData();
        objectReportTrialBalanceData.parentId = UtilSql.getValue(result, "parent_id");
        objectReportTrialBalanceData.bp = UtilSql.getValue(result, "bp");
        objectReportTrialBalanceData.id = UtilSql.getValue(result, "id");
        objectReportTrialBalanceData.name = UtilSql.getValue(result, "name");
        objectReportTrialBalanceData.accountId = UtilSql.getValue(result, "account_id");
        objectReportTrialBalanceData.elementlevel = UtilSql.getValue(result, "elementlevel");
        objectReportTrialBalanceData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportTrialBalanceData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportTrialBalanceData.saldoInicial = UtilSql.getValue(result, "saldo_inicial");
        objectReportTrialBalanceData.totalamtacctdr = UtilSql.getValue(result, "totalamtacctdr");
        objectReportTrialBalanceData.totalamtacctcr = UtilSql.getValue(result, "totalamtacctcr");
        objectReportTrialBalanceData.saldoFinal = UtilSql.getValue(result, "saldo_final");
        objectReportTrialBalanceData.dateFrom = UtilSql.getDateValue(result, "date_from", "dd-MM-yyyy");
        objectReportTrialBalanceData.dateTo = UtilSql.getDateValue(result, "date_to", "dd-MM-yyyy");
        objectReportTrialBalanceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportTrialBalanceData.rownum = Long.toString(countRecord);
        objectReportTrialBalanceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportTrialBalanceData);
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
    ReportTrialBalanceData objectReportTrialBalanceData[] = new ReportTrialBalanceData[vector.size()];
    vector.copyInto(objectReportTrialBalanceData);
    return(objectReportTrialBalanceData);
  }

  public static ReportTrialBalanceData[] set()    throws ServletException {
    ReportTrialBalanceData objectReportTrialBalanceData[] = new ReportTrialBalanceData[1];
    objectReportTrialBalanceData[0] = new ReportTrialBalanceData();
    objectReportTrialBalanceData[0].parentId = "";
    objectReportTrialBalanceData[0].bp = "";
    objectReportTrialBalanceData[0].id = "";
    objectReportTrialBalanceData[0].name = "";
    objectReportTrialBalanceData[0].accountId = "";
    objectReportTrialBalanceData[0].elementlevel = "";
    objectReportTrialBalanceData[0].amtacctdr = "";
    objectReportTrialBalanceData[0].amtacctcr = "";
    objectReportTrialBalanceData[0].saldoInicial = "";
    objectReportTrialBalanceData[0].totalamtacctdr = "";
    objectReportTrialBalanceData[0].totalamtacctcr = "";
    objectReportTrialBalanceData[0].saldoFinal = "";
    objectReportTrialBalanceData[0].dateFrom = "";
    objectReportTrialBalanceData[0].dateTo = "";
    objectReportTrialBalanceData[0].adOrgId = "";
    return objectReportTrialBalanceData;
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
    String strReturn = null;
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

  public static String selectOrgName(ConnectionProvider connectionProvider, String organization)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME" +
      "        FROM AD_ORG" +
      "        WHERE AD_ORG_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, organization);

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

  public static String selectAcctSchemaName(ConnectionProvider connectionProvider, String acctSchema)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME" +
      "        FROM C_ACCTSCHEMA" +
      "        WHERE C_ACCTSCHEMA_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctSchema);

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

  public static ReportTrialBalanceData[] selectAccount(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String cElementvalueId, String schema)    throws ServletException {
    return selectAccount(connectionProvider, adOrgClient, adUserClient, cElementvalueId, schema, 0, 0);
  }

  public static ReportTrialBalanceData[] selectAccount(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String cElementvalueId, String schema, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_ElementValue.value as id, " +
      "        ((CASE C_ElementValue.isActive WHEN 'N' THEN '**' ELSE '' END) || C_ElementValue.value || ' - ' || C_ElementValue.Name) as name " +
      "        FROM C_ElementValue" +
      "        WHERE C_ElementValue.AD_Org_ID IN(";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND C_ElementValue.AD_Client_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")  " +
      "        AND C_ElementValue.IsSummary='N' " +
      "        AND (C_ElementValue.isActive = 'Y' OR C_ElementValue.C_ElementValue_ID = ? ) " +
      "        AND 1=1";
    strSql = strSql + ((schema==null || schema.equals(""))?"":"  AND (select max(c_element_id) from c_acctschema_element where c_acctschema_id = ? and ELEMENTTYPE = 'AC') = C_ElementValue.c_element_id  ");
    strSql = strSql + 
      "        ORDER BY C_ElementValue.Value";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
      if (schema != null && !(schema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, schema);
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
        ReportTrialBalanceData objectReportTrialBalanceData = new ReportTrialBalanceData();
        objectReportTrialBalanceData.id = UtilSql.getValue(result, "id");
        objectReportTrialBalanceData.name = UtilSql.getValue(result, "name");
        objectReportTrialBalanceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportTrialBalanceData);
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
    ReportTrialBalanceData objectReportTrialBalanceData[] = new ReportTrialBalanceData[vector.size()];
    vector.copyInto(objectReportTrialBalanceData);
    return(objectReportTrialBalanceData);
  }

  public static ReportTrialBalanceData[] selectAccountDouble(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String cElementvalueId)    throws ServletException {
    return selectAccountDouble(connectionProvider, adOrgClient, adUserClient, cElementvalueId, 0, 0);
  }

  public static ReportTrialBalanceData[] selectAccountDouble(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String cElementvalueId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_acctschema_element.c_acctschema_id AS PADRE, C_ElementValue.value as id, " +
      "        ((CASE C_ElementValue.isActive WHEN 'N' THEN '**' ELSE '' END) || C_ElementValue.value || ' - ' || C_ElementValue.Name) as name " +
      "        FROM c_acctschema, c_acctschema_element, c_element, c_elementvalue" +
      "        WHERE C_ElementValue.AD_Org_ID IN(";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND C_ElementValue.AD_Client_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")  " +
      "        AND C_ElementValue.IsSummary='N' " +
      "        AND (C_ElementValue.isActive = 'Y' OR C_ElementValue.C_ElementValue_ID = ? ) " +
      "        AND 1=1" +
      "        AND c_acctschema_element.ELEMENTTYPE = 'AC'" +
      "        AND c_acctschema.c_acctschema_id = c_acctschema_element.c_acctschema_id" +
      "        AND c_acctschema_element.c_element_id = c_element.c_element_id" +
      "        AND c_element.c_element_id = c_elementvalue.c_element_id" +
      "        ORDER BY C_ElementValue.Value";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);

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
        ReportTrialBalanceData objectReportTrialBalanceData = new ReportTrialBalanceData();
        objectReportTrialBalanceData.padre = UtilSql.getValue(result, "padre");
        objectReportTrialBalanceData.id = UtilSql.getValue(result, "id");
        objectReportTrialBalanceData.name = UtilSql.getValue(result, "name");
        objectReportTrialBalanceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportTrialBalanceData);
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
    ReportTrialBalanceData objectReportTrialBalanceData[] = new ReportTrialBalanceData[vector.size()];
    vector.copyInto(objectReportTrialBalanceData);
    return(objectReportTrialBalanceData);
  }

  public static String selectAccountingName(ConnectionProvider connectionProvider, String cElementvalueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_ELEMENTVALUE.VALUE||'-'||C_ELEMENTVALUE.NAME" +
      "        FROM C_ELEMENTVALUE" +
      "        WHERE C_ELEMENTVALUE.VALUE = ?" +
      "        AND C_ELEMENTVALUE.ISACTIVE = 'Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "?column?");
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

  public static String selectLastAccount(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	    SELECT MAX(C_ELEMENTVALUE.VALUE) AS ID " +
      "        FROM C_ELEMENTVALUE" +
      "        WHERE C_ELEMENTVALUE.AD_Org_ID IN(";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "       AND C_ELEMENTVALUE.AD_Client_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")  " +
      "       AND C_ELEMENTVALUE.IsSummary='N'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "id");
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
