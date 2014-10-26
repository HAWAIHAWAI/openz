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

class ReportTaxInvoiceData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportTaxInvoiceData.class);
  private String InitRecordNumber="0";
  public String sales;
  public String national;
  public String documentno;
  public String dateinvoiced;
  public String bpartner;
  public String taxname;
  public String taxbaseamt;
  public String taxamt;
  public String adtreeid;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("sales"))
      return sales;
    else if (fieldName.equalsIgnoreCase("national"))
      return national;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("bpartner"))
      return bpartner;
    else if (fieldName.equalsIgnoreCase("taxname"))
      return taxname;
    else if (fieldName.equalsIgnoreCase("taxbaseamt"))
      return taxbaseamt;
    else if (fieldName.equalsIgnoreCase("taxamt"))
      return taxamt;
    else if (fieldName.equalsIgnoreCase("adtreeid"))
      return adtreeid;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportTaxInvoiceData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String cCountryId, String adUserClient, String parDateFrom, String parDateTo, String issotrx, String adOrgId)    throws ServletException {
    return select(connectionProvider, cCurrencyConv, cCountryId, adUserClient, parDateFrom, parDateTo, issotrx, adOrgId, 0, 0);
  }

  public static ReportTaxInvoiceData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String cCountryId, String adUserClient, String parDateFrom, String parDateTo, String issotrx, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_INVOICE.ISSOTRX AS SALES, 'Y' AS NATIONAL, C_INVOICE.DOCUMENTNO AS DOCUMENTNO, C_INVOICE.DATEINVOICED, C_BPARTNER.NAME AS BPARTNER, LTRIM(RTRIM(C_TAX.NAME, ' '), ' ') AS TAXNAME, " +
      "      SUM(CASE WHEN DOCBASETYPE IN ('ARC','APC') THEN -1 * (C_CURRENCY_CONVERT(C_INVOICETAX.TAXBASEAMT, C_INVOICE.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())), NULL, C_INVOICETAX.AD_CLIENT_ID, C_INVOICETAX.AD_ORG_ID)) " +
      "      ELSE C_CURRENCY_CONVERT(C_INVOICETAX.TAXBASEAMT, C_INVOICE.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())), NULL, C_INVOICETAX.AD_CLIENT_ID, C_INVOICETAX.AD_ORG_ID) END) AS TAXBASEAMT, " +
      "      SUM(CASE WHEN DOCBASETYPE IN ('ARC','APC') THEN -1 * ( C_CURRENCY_CONVERT(C_INVOICETAX.TAXAMT, C_INVOICE.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())), NULL, C_INVOICETAX.AD_CLIENT_ID, C_INVOICETAX.AD_ORG_ID)) ELSE ( C_CURRENCY_CONVERT(C_INVOICETAX.TAXAMT, C_INVOICE.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())), NULL, C_INVOICETAX.AD_CLIENT_ID, C_INVOICETAX.AD_ORG_ID)) END) AS TAXAMT,'' AS ADTREEID" +
      "      FROM C_TAX, C_INVOICETAX, C_INVOICE, C_BPARTNER_LOCATION, C_LOCATION, C_BPARTNER, C_DOCTYPE" +
      "      WHERE C_TAX.C_TAX_ID=C_INVOICETAX.C_TAX_ID" +
      "      AND C_INVOICETAX.C_INVOICE_ID=C_INVOICE.C_INVOICE_ID" +
      "      AND C_INVOICE.C_BPARTNER_LOCATION_ID = C_BPARTNER_LOCATION.C_BPARTNER_LOCATION_ID" +
      "      AND C_BPARTNER_LOCATION.C_LOCATION_ID = C_LOCATION.C_LOCATION_ID" +
      "      AND C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_INVOICE.C_DOCTYPE_ID = C_DOCTYPE.C_DOCTYPE_ID" +
      "      AND C_LOCATION.C_COUNTRY_ID = ?" +
      "      AND C_INVOICE.PROCESSED = 'Y'" +
      "      AND C_INVOICE.ISACTIVE = 'Y'" +
      "      AND C_INVOICE.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND C_INVOICE.DATEINVOICED >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND C_INVOICE.DATEINVOICED < TO_DATE(?) ");
    strSql = strSql + 
      "      AND C_INVOICE.ISSOTRX = ?" +
      "      AND C_INVOICE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      GROUP BY C_INVOICE.DOCUMENTNO, C_INVOICE.DATEINVOICED, C_TAX.NAME, C_BPARTNER.NAME, C_INVOICE.ISSOTRX" +
      "      HAVING SUM(C_INVOICETAX.TAXBASEAMT) <> 0" +
      "      ORDER BY C_TAX.NAME, C_INVOICE.DATEINVOICED";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCountryId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      if (adOrgId != null && !(adOrgId.equals(""))) {
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
        ReportTaxInvoiceData objectReportTaxInvoiceData = new ReportTaxInvoiceData();
        objectReportTaxInvoiceData.sales = UtilSql.getValue(result, "sales");
        objectReportTaxInvoiceData.national = UtilSql.getValue(result, "national");
        objectReportTaxInvoiceData.documentno = UtilSql.getValue(result, "documentno");
        objectReportTaxInvoiceData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectReportTaxInvoiceData.bpartner = UtilSql.getValue(result, "bpartner");
        objectReportTaxInvoiceData.taxname = UtilSql.getValue(result, "taxname");
        objectReportTaxInvoiceData.taxbaseamt = UtilSql.getValue(result, "taxbaseamt");
        objectReportTaxInvoiceData.taxamt = UtilSql.getValue(result, "taxamt");
        objectReportTaxInvoiceData.adtreeid = UtilSql.getValue(result, "adtreeid");
        objectReportTaxInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportTaxInvoiceData);
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
    ReportTaxInvoiceData objectReportTaxInvoiceData[] = new ReportTaxInvoiceData[vector.size()];
    vector.copyInto(objectReportTaxInvoiceData);
    return(objectReportTaxInvoiceData);
  }

  public static ReportTaxInvoiceData[] set()    throws ServletException {
    ReportTaxInvoiceData objectReportTaxInvoiceData[] = new ReportTaxInvoiceData[1];
    objectReportTaxInvoiceData[0] = new ReportTaxInvoiceData();
    objectReportTaxInvoiceData[0].sales = "";
    objectReportTaxInvoiceData[0].national = "";
    objectReportTaxInvoiceData[0].documentno = "";
    objectReportTaxInvoiceData[0].dateinvoiced = "";
    objectReportTaxInvoiceData[0].bpartner = "";
    objectReportTaxInvoiceData[0].taxname = "";
    objectReportTaxInvoiceData[0].taxbaseamt = "";
    objectReportTaxInvoiceData[0].taxamt = "";
    objectReportTaxInvoiceData[0].adtreeid = "";
    return objectReportTaxInvoiceData;
  }

  public static String selectTreeNode(ConnectionProvider connectionProvider, String adUserClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT MAX(AD_TREE_ID) AS ADTREEID" +
      "      FROM AD_TREE" +
      "      WHERE TREETYPE = 'OO'" +
      "      AND AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "adtreeid");
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

  public static ReportTaxInvoiceData[] selectForeign(ConnectionProvider connectionProvider, String cCurrencyConv, String cCountryId, String adUserClient, String parDateFrom, String parDateTo, String issotrx, String adOrgId)    throws ServletException {
    return selectForeign(connectionProvider, cCurrencyConv, cCountryId, adUserClient, parDateFrom, parDateTo, issotrx, adOrgId, 0, 0);
  }

  public static ReportTaxInvoiceData[] selectForeign(ConnectionProvider connectionProvider, String cCurrencyConv, String cCountryId, String adUserClient, String parDateFrom, String parDateTo, String issotrx, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_INVOICE.ISSOTRX AS SALES, 'N' AS NATIONAL, C_INVOICE.DOCUMENTNO AS DOCUMENTNO, C_INVOICE.DATEINVOICED, " +
      "      C_BPARTNER.NAME AS BPARTNER, LTRIM(RTRIM(C_TAX.NAME, ' '), ' ') AS TAXNAME, " +
      "      SUM(CASE WHEN DOCBASETYPE IN ('ARC','APC') THEN -1 * (C_CURRENCY_CONVERT(C_INVOICETAX.TAXBASEAMT, C_INVOICE.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())), NULL, C_INVOICETAX.AD_CLIENT_ID, C_INVOICETAX.AD_ORG_ID)) " +
      "      ELSE C_CURRENCY_CONVERT(C_INVOICETAX.TAXBASEAMT, C_INVOICE.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())), NULL, C_INVOICETAX.AD_CLIENT_ID, C_INVOICETAX.AD_ORG_ID) END) AS TAXBASEAMT, " +
      "      SUM(CASE WHEN DOCBASETYPE IN ('ARC','APC') THEN -1 * ( C_CURRENCY_CONVERT(C_INVOICETAX.TAXAMT, C_INVOICE.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())), NULL, C_INVOICETAX.AD_CLIENT_ID, C_INVOICETAX.AD_ORG_ID)) ELSE ( C_CURRENCY_CONVERT(C_INVOICETAX.TAXAMT, C_INVOICE.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())), NULL, C_INVOICETAX.AD_CLIENT_ID, C_INVOICETAX.AD_ORG_ID)) END) AS TAXAMT,'' AS ADTREEID" +
      "      FROM C_TAX, C_INVOICETAX, C_INVOICE, C_BPARTNER_LOCATION, C_LOCATION, C_BPARTNER, C_DOCTYPE" +
      "      WHERE C_TAX.C_TAX_ID=C_INVOICETAX.C_TAX_ID" +
      "      AND C_INVOICETAX.C_INVOICE_ID=C_INVOICE.C_INVOICE_ID" +
      "      AND C_INVOICE.C_BPARTNER_LOCATION_ID = C_BPARTNER_LOCATION.C_BPARTNER_LOCATION_ID" +
      "      AND C_BPARTNER_LOCATION.C_LOCATION_ID = C_LOCATION.C_LOCATION_ID" +
      "      AND C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_INVOICE.C_DOCTYPE_ID = C_DOCTYPE.C_DOCTYPE_ID" +
      "      AND C_LOCATION.C_COUNTRY_ID <> ?" +
      "      AND C_INVOICE.PROCESSED = 'Y'" +
      "      AND C_INVOICE.ISACTIVE = 'Y'" +
      "      AND C_INVOICE.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND C_INVOICE.DATEINVOICED >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND C_INVOICE.DATEINVOICED < TO_DATE(?) ");
    strSql = strSql + 
      "      AND C_INVOICE.ISSOTRX = ?" +
      "      AND C_INVOICE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      GROUP BY C_INVOICE.DOCUMENTNO, C_TAX.NAME, C_INVOICE.DATEINVOICED, C_BPARTNER.NAME, C_INVOICE.ISSOTRX" +
      "      HAVING SUM(C_INVOICETAX.TAXBASEAMT) <> 0" +
      "      ORDER BY C_TAX.NAME, C_INVOICE.DATEINVOICED";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCountryId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      if (adOrgId != null && !(adOrgId.equals(""))) {
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
        ReportTaxInvoiceData objectReportTaxInvoiceData = new ReportTaxInvoiceData();
        objectReportTaxInvoiceData.sales = UtilSql.getValue(result, "sales");
        objectReportTaxInvoiceData.national = UtilSql.getValue(result, "national");
        objectReportTaxInvoiceData.documentno = UtilSql.getValue(result, "documentno");
        objectReportTaxInvoiceData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectReportTaxInvoiceData.bpartner = UtilSql.getValue(result, "bpartner");
        objectReportTaxInvoiceData.taxname = UtilSql.getValue(result, "taxname");
        objectReportTaxInvoiceData.taxbaseamt = UtilSql.getValue(result, "taxbaseamt");
        objectReportTaxInvoiceData.taxamt = UtilSql.getValue(result, "taxamt");
        objectReportTaxInvoiceData.adtreeid = UtilSql.getValue(result, "adtreeid");
        objectReportTaxInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportTaxInvoiceData);
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
    ReportTaxInvoiceData objectReportTaxInvoiceData[] = new ReportTaxInvoiceData[vector.size()];
    vector.copyInto(objectReportTaxInvoiceData);
    return(objectReportTaxInvoiceData);
  }
}
