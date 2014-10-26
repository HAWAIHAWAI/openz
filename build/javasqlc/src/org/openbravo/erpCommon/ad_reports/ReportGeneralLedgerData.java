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

class ReportGeneralLedgerData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportGeneralLedgerData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String value;
  public String name;
  public String dateacct;
  public String amtacctdr;
  public String amtacctcr;
  public String total;
  public String factAcctGroupId;
  public String id;
  public String groupbyid;
  public String groupbyname;
  public String description;
  public String totalacctdr;
  public String totalacctcr;
  public String totalacctsub;
  public String previousdebit;
  public String previouscredit;
  public String previoustotal;
  public String finaldebit;
  public String finalcredit;
  public String finaltotal;
  public String dateacctnumber;
  public String groupby;
  public String bpid;
  public String bpname;
  public String pdid;
  public String pdname;
  public String pjid;
  public String pjname;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("amtacctdr"))
      return amtacctdr;
    else if (fieldName.equalsIgnoreCase("amtacctcr"))
      return amtacctcr;
    else if (fieldName.equalsIgnoreCase("total"))
      return total;
    else if (fieldName.equalsIgnoreCase("fact_acct_group_id") || fieldName.equals("factAcctGroupId"))
      return factAcctGroupId;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("groupbyid"))
      return groupbyid;
    else if (fieldName.equalsIgnoreCase("groupbyname"))
      return groupbyname;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("totalacctdr"))
      return totalacctdr;
    else if (fieldName.equalsIgnoreCase("totalacctcr"))
      return totalacctcr;
    else if (fieldName.equalsIgnoreCase("totalacctsub"))
      return totalacctsub;
    else if (fieldName.equalsIgnoreCase("previousdebit"))
      return previousdebit;
    else if (fieldName.equalsIgnoreCase("previouscredit"))
      return previouscredit;
    else if (fieldName.equalsIgnoreCase("previoustotal"))
      return previoustotal;
    else if (fieldName.equalsIgnoreCase("finaldebit"))
      return finaldebit;
    else if (fieldName.equalsIgnoreCase("finalcredit"))
      return finalcredit;
    else if (fieldName.equalsIgnoreCase("finaltotal"))
      return finaltotal;
    else if (fieldName.equalsIgnoreCase("dateacctnumber"))
      return dateacctnumber;
    else if (fieldName.equalsIgnoreCase("groupby"))
      return groupby;
    else if (fieldName.equalsIgnoreCase("bpid"))
      return bpid;
    else if (fieldName.equalsIgnoreCase("bpname"))
      return bpname;
    else if (fieldName.equalsIgnoreCase("pdid"))
      return pdid;
    else if (fieldName.equalsIgnoreCase("pdname"))
      return pdname;
    else if (fieldName.equalsIgnoreCase("pjid"))
      return pjid;
    else if (fieldName.equalsIgnoreCase("pjname"))
      return pjname;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportGeneralLedgerData[] select(ConnectionProvider connectionProvider, String rownum, String groupbytext, String groupby, String parDateFrom, String parDateTo, String allaccounts, String accountFrom, String accountTo, String adUserOrg, String adUserClient, String hideMatched, String acctschema, String parDateFrom2, String parDateTo2, String AccountMatch, String org, String cBpartnerId, String mProductId, String cProjectId, String paramAmtFrom, String paramAmtTo, String accountId, String factAcctId, String cBPartner, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    return select(connectionProvider, rownum, groupbytext, groupby, parDateFrom, parDateTo, allaccounts, accountFrom, accountTo, adUserOrg, adUserClient, hideMatched, acctschema, parDateFrom2, parDateTo2, AccountMatch, org, cBpartnerId, mProductId, cProjectId, paramAmtFrom, paramAmtTo, accountId, factAcctId, cBPartner, pgLimit, oraLimit1, oraLimit2, 0, 0);
  }

  public static ReportGeneralLedgerData[] select(ConnectionProvider connectionProvider, String rownum, String groupbytext, String groupby, String parDateFrom, String parDateTo, String allaccounts, String accountFrom, String accountTo, String adUserOrg, String adUserClient, String hideMatched, String acctschema, String parDateFrom2, String parDateTo2, String AccountMatch, String org, String cBpartnerId, String mProductId, String cProjectId, String paramAmtFrom, String paramAmtTo, String accountId, String factAcctId, String cBPartner, String pgLimit, String oraLimit1, String oraLimit2, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT * FROM (" +
      "        SELECT *" +
      "        FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, C.* FROM (" +
      "          SELECT VALUE, NAME, DATEACCT," +
      "              SUM(AMTACCTDR) AS AMTACCTDR, SUM(AMTACCTCR) AS AMTACCTCR, (SUM(AMTACCTDR)-SUM(AMTACCTCR)) AS TOTAL," +
      "              FACT_ACCT_GROUP_ID, ID, groupbyid, groupbyname," +
      "              MIN(DESCRIPTION) AS DESCRIPTION," +
      "              0 AS TOTALACCTDR, 0 AS TOTALACCTCR, 0 AS TOTALACCTSUB," +
      "              0 AS PREVIOUSDEBIT, 0 AS PREVIOUSCREDIT, 0 AS PREVIOUSTOTAL," +
      "              0 AS FINALDEBIT, 0 AS FINALCREDIT, 0 AS FINALTOTAL," +
      "              TO_CHAR(DATEACCT,'J') AS DATEACCTNUMBER," +
      "              ? AS groupby, '' as bpid, '' as bpname, '' as pdid, '' as pdname, '' as pjid, '' as pjname" +
      "          FROM" +
      "            (SELECT FACT_ACCT.ACCTVALUE AS VALUE, FACT_ACCT.ACCTDESCRIPTION AS NAME," +
      "                DATEACCT, AMTACCTDR, AMTACCTCR," +
      "                FACT_ACCT_GROUP_ID, FACT_ACCT.ACCOUNT_ID AS ID, FACT_ACCT.DESCRIPTION," +
      "                CASE ?" +
      "                  WHEN 'BPartner' THEN c_bpartner.c_bpartner_id" +
      "                  WHEN 'Product' THEN m_product.m_product_id" +
      "                  WHEN 'Project' THEN c_project.c_project_id" +
      "                  ELSE '' END AS groupbyid," +
      "                CASE ?" +
      "                  WHEN 'BPartner' THEN to_char(c_bpartner.name)" +
      "                  WHEN 'Product' THEN to_char(m_product.name)" +
      "                  WHEN 'Project' THEN to_char(c_project.name)" +
      "                  ELSE '' END AS groupbyname," +
      "                CASE WHEN AMTACCTDR <> 0 THEN 'Y' ELSE 'N' END AS ISDEBIT" +
      "            FROM FACT_ACCT" +
      "              LEFT JOIN C_BPARTNER ON FACT_ACCT.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "              LEFT JOIN M_PRODUCT ON FACT_ACCT.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "              LEFT JOIN C_PROJECT ON FACT_ACCT.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "              LEFT JOIN(" +
      "                  select account_id, record_id2, sum(amtacctdr-amtacctcr) as sum" +
      "                  from fact_acct f1" +
      "                  where 5=5";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":" AND DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":" AND DATEACCT < TO_DATE(?)  ");
    strSql = strSql + 
      "                  group by account_id, record_id2" +
      "                ) f2 ON fact_acct.account_id = f2.account_id and fact_acct.record_id2 = f2.record_id2" +
      "            WHERE (?='Y' OR FACT_ACCT.ACCOUNT_ID IN (" +
      "                      SELECT c_elementvalue_id as name" +
      "                      FROM C_ELEMENTVALUE" +
      "                      WHERE value >= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                        and value <= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                        and c_elementvalue.ELEMENTLEVEL = 'S'" +
      "                    ))" +
      "              AND FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "              AND FACT_ACCT.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "              AND (? = 'N' OR (fact_acct.RECORD_ID2 IS NULL) OR (SUM != 0))" +
      "              AND 1=1";
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":" AND FACT_ACCT.C_ACCTSCHEMA_ID = ?  ");
    strSql = strSql + ((parDateFrom2==null || parDateFrom2.equals(""))?"":" AND FACT_ACCT.DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + ((parDateTo2==null || parDateTo2.equals(""))?"":" AND FACT_ACCT.DATEACCT < TO_DATE(?)  ");
    strSql = strSql + 
      "              AND  FACT_ACCT.ACCTVALUE like ?" +
      "              AND  FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "              AND 2=2";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND FACT_ACCT.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND FACT_ACCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND FACT_ACCT.C_PROJECT_ID IN" + cProjectId);
    strSql = strSql + 
      "              AND 3=3";
    strSql = strSql + ((paramAmtFrom==null || paramAmtFrom.equals(""))?"":"  AND (FACT_ACCT.AMTACCTDR + FACT_ACCT.AMTACCTCR)>=TO_NUMBER(?)  ");
    strSql = strSql + ((paramAmtTo==null || paramAmtTo.equals(""))?"":"  AND (FACT_ACCT.AMTACCTDR + FACT_ACCT.AMTACCTCR)<=TO_NUMBER(?)  ");
    strSql = strSql + 
      ") D" +
      "            WHERE 6=6";
    strSql = strSql + ((accountId==null || accountId.equals(""))?"":" AND ID = ?  ");
    strSql = strSql + ((factAcctId==null || factAcctId.equals(""))?"":" and to_char(DATEACCT,'J')||FACT_ACCT_GROUP_ID < ?  ");
    strSql = strSql + ((cBPartner==null || cBPartner.equals(""))?"":" AND groupbyid = ?  ");
    strSql = strSql + 
      "            GROUP BY groupbyname, groupbyid, VALUE, NAME, ID, DATEACCT, FACT_ACCT_GROUP_ID, ISDEBIT" +
      "            HAVING SUM(AMTACCTDR) - SUM(AMTACCTCR) <> 0" +
      "            ORDER  BY groupbyname, groupbyid, VALUE, NAME, ID, DATEACCT,  FACT_ACCT_GROUP_ID, ISDEBIT";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":"  LIMIT " + pgLimit);
    strSql = strSql + 
      "          ) C";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "        ) B WHERE 1=1";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":"  AND RN1 BETWEEN " + oraLimit2);
    strSql = strSql + 
      "      ) A ORDER BY  groupbyname, groupbyid, VALUE, DATEACCT, FACT_ACCT_GROUP_ID";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (rownum != null && !(rownum.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupbytext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupby);
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allaccounts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountTo);
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hideMatched);
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (parDateFrom2 != null && !(parDateFrom2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom2);
      }
      if (parDateTo2 != null && !(parDateTo2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo2);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AccountMatch);
      if (org != null && !(org.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        }
      if (paramAmtFrom != null && !(paramAmtFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramAmtFrom);
      }
      if (paramAmtTo != null && !(paramAmtTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramAmtTo);
      }
      if (accountId != null && !(accountId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      }
      if (factAcctId != null && !(factAcctId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctId);
      }
      if (cBPartner != null && !(cBPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBPartner);
      }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
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
        ReportGeneralLedgerData objectReportGeneralLedgerData = new ReportGeneralLedgerData();
        objectReportGeneralLedgerData.rn1 = UtilSql.getValue(result, "rn1");
        objectReportGeneralLedgerData.value = UtilSql.getValue(result, "value");
        objectReportGeneralLedgerData.name = UtilSql.getValue(result, "name");
        objectReportGeneralLedgerData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectReportGeneralLedgerData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportGeneralLedgerData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportGeneralLedgerData.total = UtilSql.getValue(result, "total");
        objectReportGeneralLedgerData.factAcctGroupId = UtilSql.getValue(result, "fact_acct_group_id");
        objectReportGeneralLedgerData.id = UtilSql.getValue(result, "id");
        objectReportGeneralLedgerData.groupbyid = UtilSql.getValue(result, "groupbyid");
        objectReportGeneralLedgerData.groupbyname = UtilSql.getValue(result, "groupbyname");
        objectReportGeneralLedgerData.description = UtilSql.getValue(result, "description");
        objectReportGeneralLedgerData.totalacctdr = UtilSql.getValue(result, "totalacctdr");
        objectReportGeneralLedgerData.totalacctcr = UtilSql.getValue(result, "totalacctcr");
        objectReportGeneralLedgerData.totalacctsub = UtilSql.getValue(result, "totalacctsub");
        objectReportGeneralLedgerData.previousdebit = UtilSql.getValue(result, "previousdebit");
        objectReportGeneralLedgerData.previouscredit = UtilSql.getValue(result, "previouscredit");
        objectReportGeneralLedgerData.previoustotal = UtilSql.getValue(result, "previoustotal");
        objectReportGeneralLedgerData.finaldebit = UtilSql.getValue(result, "finaldebit");
        objectReportGeneralLedgerData.finalcredit = UtilSql.getValue(result, "finalcredit");
        objectReportGeneralLedgerData.finaltotal = UtilSql.getValue(result, "finaltotal");
        objectReportGeneralLedgerData.dateacctnumber = UtilSql.getValue(result, "dateacctnumber");
        objectReportGeneralLedgerData.groupby = UtilSql.getValue(result, "groupby");
        objectReportGeneralLedgerData.bpid = UtilSql.getValue(result, "bpid");
        objectReportGeneralLedgerData.bpname = UtilSql.getValue(result, "bpname");
        objectReportGeneralLedgerData.pdid = UtilSql.getValue(result, "pdid");
        objectReportGeneralLedgerData.pdname = UtilSql.getValue(result, "pdname");
        objectReportGeneralLedgerData.pjid = UtilSql.getValue(result, "pjid");
        objectReportGeneralLedgerData.pjname = UtilSql.getValue(result, "pjname");
        objectReportGeneralLedgerData.rownum = Long.toString(countRecord);
        objectReportGeneralLedgerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportGeneralLedgerData);
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
    ReportGeneralLedgerData objectReportGeneralLedgerData[] = new ReportGeneralLedgerData[vector.size()];
    vector.copyInto(objectReportGeneralLedgerData);
    return(objectReportGeneralLedgerData);
  }

  public static ReportGeneralLedgerData[] selectXLS(ConnectionProvider connectionProvider, String parDateFrom, String parDateTo, String allaccounts, String accountFrom, String accountTo, String adUserOrg, String adUserClient, String hideMatched, String acctschema, String parDateFrom2, String parDateTo2, String AccountMatch, String org, String cBpartnerId, String mProductId, String cProjectId, String paramAmtFrom, String paramAmtTo)    throws ServletException {
    return selectXLS(connectionProvider, parDateFrom, parDateTo, allaccounts, accountFrom, accountTo, adUserOrg, adUserClient, hideMatched, acctschema, parDateFrom2, parDateTo2, AccountMatch, org, cBpartnerId, mProductId, cProjectId, paramAmtFrom, paramAmtTo, 0, 0);
  }

  public static ReportGeneralLedgerData[] selectXLS(ConnectionProvider connectionProvider, String parDateFrom, String parDateTo, String allaccounts, String accountFrom, String accountTo, String adUserOrg, String adUserClient, String hideMatched, String acctschema, String parDateFrom2, String parDateTo2, String AccountMatch, String org, String cBpartnerId, String mProductId, String cProjectId, String paramAmtFrom, String paramAmtTo, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT VALUE, NAME, DATEACCT," +
      "          SUM(AMTACCTDR) AS AMTACCTDR, SUM(AMTACCTCR) AS AMTACCTCR," +
      "          FACT_ACCT_GROUP_ID, ID, bpid, bpname, pdid, pdname, pjid, pjname," +
      "          MIN(DESCRIPTION) AS DESCRIPTION" +
      "      FROM" +
      "        (SELECT FACT_ACCT.ACCTVALUE AS VALUE, FACT_ACCT.ACCTDESCRIPTION AS NAME," +
      "            DATEACCT, AMTACCTDR, AMTACCTCR," +
      "            FACT_ACCT_GROUP_ID, FACT_ACCT.ACCOUNT_ID AS ID, FACT_ACCT.DESCRIPTION," +
      "            c_bpartner.c_bpartner_id as bpid, m_product.m_product_id as pdid, c_project.c_project_id as pjid," +
      "            c_bpartner.name as bpname, m_product.name as pdname, c_project.name as pjname," +
      "            CASE WHEN AMTACCTDR <> 0 THEN 'Y' ELSE 'N' END AS ISDEBIT" +
      "        FROM FACT_ACCT" +
      "          LEFT JOIN C_BPARTNER ON FACT_ACCT.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "          LEFT JOIN M_PRODUCT ON FACT_ACCT.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "          LEFT JOIN C_PROJECT ON FACT_ACCT.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "          LEFT JOIN(" +
      "              select account_id, record_id2, sum(amtacctdr-amtacctcr) as sum" +
      "              from fact_acct f1" +
      "              where 5=5";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":" AND DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":" AND DATEACCT < TO_DATE(?)  ");
    strSql = strSql + 
      "              group by account_id, record_id2" +
      "            ) f2 ON fact_acct.account_id = f2.account_id and fact_acct.record_id2 = f2.record_id2" +
      "        WHERE (?='Y' OR FACT_ACCT.ACCOUNT_ID IN (" +
      "                  SELECT c_elementvalue_id as name" +
      "                  FROM C_ELEMENTVALUE" +
      "                  WHERE value >= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                    and value <= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                    and c_elementvalue.ELEMENTLEVEL = 'S'" +
      "                ))" +
      "          AND FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "          AND FACT_ACCT.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "          AND (? = 'N' OR (fact_acct.RECORD_ID2 IS NULL) OR (SUM != 0))" +
      "          AND 1=1";
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":" AND FACT_ACCT.C_ACCTSCHEMA_ID = ?  ");
    strSql = strSql + ((parDateFrom2==null || parDateFrom2.equals(""))?"":" AND FACT_ACCT.DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + ((parDateTo2==null || parDateTo2.equals(""))?"":" AND FACT_ACCT.DATEACCT < TO_DATE(?)  ");
    strSql = strSql + 
      "          AND  FACT_ACCT.ACCTVALUE like ?" +
      "          AND  FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "          AND 2=2";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND FACT_ACCT.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND FACT_ACCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND FACT_ACCT.C_PROJECT_ID IN" + cProjectId);
    strSql = strSql + 
      "          AND 3=3";
    strSql = strSql + ((paramAmtFrom==null || paramAmtFrom.equals(""))?"":"  AND (FACT_ACCT.AMTACCTDR + FACT_ACCT.AMTACCTCR)>=TO_NUMBER(?)  ");
    strSql = strSql + ((paramAmtTo==null || paramAmtTo.equals(""))?"":"  AND (FACT_ACCT.AMTACCTDR + FACT_ACCT.AMTACCTCR)<=TO_NUMBER(?)  ");
    strSql = strSql + 
      ") D" +
      "        WHERE 6=6" +
      "        GROUP BY VALUE, NAME, ID, DATEACCT, FACT_ACCT_GROUP_ID, bpname, bpid, pdname, pdid, pjname, pjid, ISDEBIT" +
      "        HAVING SUM(AMTACCTDR) - SUM(AMTACCTCR) <> 0" +
      "        ORDER BY VALUE, NAME, ID, DATEACCT, FACT_ACCT_GROUP_ID, bpname, bpid, pdname, pdid, pjname, pjid, ISDEBIT";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allaccounts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountTo);
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hideMatched);
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (parDateFrom2 != null && !(parDateFrom2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom2);
      }
      if (parDateTo2 != null && !(parDateTo2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo2);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AccountMatch);
      if (org != null && !(org.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        }
      if (paramAmtFrom != null && !(paramAmtFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramAmtFrom);
      }
      if (paramAmtTo != null && !(paramAmtTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramAmtTo);
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
        ReportGeneralLedgerData objectReportGeneralLedgerData = new ReportGeneralLedgerData();
        objectReportGeneralLedgerData.value = UtilSql.getValue(result, "value");
        objectReportGeneralLedgerData.name = UtilSql.getValue(result, "name");
        objectReportGeneralLedgerData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectReportGeneralLedgerData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportGeneralLedgerData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportGeneralLedgerData.factAcctGroupId = UtilSql.getValue(result, "fact_acct_group_id");
        objectReportGeneralLedgerData.id = UtilSql.getValue(result, "id");
        objectReportGeneralLedgerData.bpid = UtilSql.getValue(result, "bpid");
        objectReportGeneralLedgerData.bpname = UtilSql.getValue(result, "bpname");
        objectReportGeneralLedgerData.pdid = UtilSql.getValue(result, "pdid");
        objectReportGeneralLedgerData.pdname = UtilSql.getValue(result, "pdname");
        objectReportGeneralLedgerData.pjid = UtilSql.getValue(result, "pjid");
        objectReportGeneralLedgerData.pjname = UtilSql.getValue(result, "pjname");
        objectReportGeneralLedgerData.description = UtilSql.getValue(result, "description");
        objectReportGeneralLedgerData.rownum = Long.toString(countRecord);
        objectReportGeneralLedgerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportGeneralLedgerData);
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
    ReportGeneralLedgerData objectReportGeneralLedgerData[] = new ReportGeneralLedgerData[vector.size()];
    vector.copyInto(objectReportGeneralLedgerData);
    return(objectReportGeneralLedgerData);
  }

  public static ReportGeneralLedgerData[] set()    throws ServletException {
    ReportGeneralLedgerData objectReportGeneralLedgerData[] = new ReportGeneralLedgerData[1];
    objectReportGeneralLedgerData[0] = new ReportGeneralLedgerData();
    objectReportGeneralLedgerData[0].value = "";
    objectReportGeneralLedgerData[0].name = "";
    objectReportGeneralLedgerData[0].dateacct = "";
    objectReportGeneralLedgerData[0].amtacctdr = "";
    objectReportGeneralLedgerData[0].amtacctcr = "";
    objectReportGeneralLedgerData[0].factAcctGroupId = "";
    objectReportGeneralLedgerData[0].id = "";
    objectReportGeneralLedgerData[0].bpid = "";
    objectReportGeneralLedgerData[0].bpname = "";
    objectReportGeneralLedgerData[0].pdid = "";
    objectReportGeneralLedgerData[0].pdname = "";
    objectReportGeneralLedgerData[0].pjid = "";
    objectReportGeneralLedgerData[0].pjname = "";
    objectReportGeneralLedgerData[0].description = "";
    return objectReportGeneralLedgerData;
  }

  public static String selectCompany(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME" +
      "        FROM AD_CLIENT" +
      "        WHERE AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = "0";
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

  public static String selectOrganization(ConnectionProvider connectionProvider, String org)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME" +
      "        FROM AD_ORG" +
      "        WHERE AD_ORG_ID = ?";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);

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

  public static ReportGeneralLedgerData[] selectTotal(ConnectionProvider connectionProvider, String dateFrom, String dateTo, String bpartner, String product, String project, String acctschema, String account, String initialYearBalance, String dateTo2, String orgs, String hideMatched)    throws ServletException {
    return selectTotal(connectionProvider, dateFrom, dateTo, bpartner, product, project, acctschema, account, initialYearBalance, dateTo2, orgs, hideMatched, 0, 0);
  }

  public static ReportGeneralLedgerData[] selectTotal(ConnectionProvider connectionProvider, String dateFrom, String dateTo, String bpartner, String product, String project, String acctschema, String account, String initialYearBalance, String dateTo2, String orgs, String hideMatched, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COALESCE(SUM(AMTACCTDR),0) AS TOTALACCTDR, COALESCE(SUM(AMTACCTCR),0) AS TOTALACCTCR," +
      "      COALESCE(SUM(AMTACCTDR-AMTACCTCR),0) AS TOTAL" +
      "      FROM FACT_ACCT" +
      "      LEFT JOIN(" +
      "        select account_id, record_id2, sum(amtacctdr-amtacctcr) as sum" +
      "        from fact_acct f1" +
      "        where 5=5";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":" AND DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":" AND DATEACCT < TO_DATE(?)  ");
    strSql = strSql + 
      "        group by account_id, record_id2" +
      "      ) f2 ON fact_acct.account_id = f2.account_id and fact_acct.record_id2 = f2.record_id2" +
      "      WHERE 1=1";
    strSql = strSql + ((bpartner==null || bpartner.equals(""))?"":"  AND FACT_ACCT.C_BPARTNER_ID IN" + bpartner);
    strSql = strSql + ((product==null || product.equals(""))?"":"  AND FACT_ACCT.M_PRODUCT_ID IN" + product);
    strSql = strSql + ((project==null || project.equals(""))?"":"  AND FACT_ACCT.C_PROJECT_ID IN" + project);
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND FACT_ACCT.C_ACCTSCHEMA_ID = ?  ");
    strSql = strSql + 
      "      AND FACT_ACCT.ACCOUNT_ID = ?" +
      "      AND DATEACCT >= TO_DATE(?)" +
      "      AND DATEACCT < TO_DATE(?)" +
      "      AND FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((orgs==null || orgs.equals(""))?"":orgs);
    strSql = strSql + 
      ")" +
      "      AND (? = 'N' OR ((fact_acct.RECORD_ID2 IS NULL) OR (DATEACCT < TO_DATE(?)) OR (SUM != 0)))";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (bpartner != null && !(bpartner.equals(""))) {
        }
      if (product != null && !(product.equals(""))) {
        }
      if (project != null && !(project.equals(""))) {
        }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, account);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, initialYearBalance);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo2);
      if (orgs != null && !(orgs.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hideMatched);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);

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
        ReportGeneralLedgerData objectReportGeneralLedgerData = new ReportGeneralLedgerData();
        objectReportGeneralLedgerData.totalacctdr = UtilSql.getValue(result, "totalacctdr");
        objectReportGeneralLedgerData.totalacctcr = UtilSql.getValue(result, "totalacctcr");
        objectReportGeneralLedgerData.total = UtilSql.getValue(result, "total");
        objectReportGeneralLedgerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportGeneralLedgerData);
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
    ReportGeneralLedgerData objectReportGeneralLedgerData[] = new ReportGeneralLedgerData[vector.size()];
    vector.copyInto(objectReportGeneralLedgerData);
    return(objectReportGeneralLedgerData);
  }

  public static String yearInitialDate(ConnectionProvider connectionProvider, String dateTemplate, String date, String client, String orgs)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT TO_CHAR(MAX(INI),?) AS STARTDATE" +
      "      FROM" +
      "        (" +
      "        SELECT MIN(P.STARTDATE) AS INI" +
      "        FROM C_YEAR Y, C_PERIOD P" +
      "        WHERE Y.C_YEAR_ID = P.C_YEAR_ID" +
      "          AND P.STARTDATE <= TO_DATE(?)" +
      "          AND P.AD_CLIENT_ID IN (";
    strSql = strSql + ((client==null || client.equals(""))?"":client);
    strSql = strSql + 
      ")" +
      "          AND P.AD_ORG_ID IN (";
    strSql = strSql + ((orgs==null || orgs.equals(""))?"":orgs);
    strSql = strSql + 
      ")" +
      "        GROUP BY Y.YEAR" +
      "        ) PERIOD";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTemplate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      if (client != null && !(client.equals(""))) {
        }
      if (orgs != null && !(orgs.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "startdate");
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

  public static String selectSubaccountDescription(ConnectionProvider connectionProvider, String elementValueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COALESCE(TO_CHAR(NAME),TO_CHAR(''))" +
      "      FROM C_ELEMENTVALUE" +
      "      WHERE C_ELEMENTVALUE_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, elementValueId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "coalesce");
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
