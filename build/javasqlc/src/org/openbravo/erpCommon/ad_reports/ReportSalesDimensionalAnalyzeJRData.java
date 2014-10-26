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

class ReportSalesDimensionalAnalyzeJRData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportSalesDimensionalAnalyzeJRData.class);
  private String InitRecordNumber="0";
  public String nivel1;
  public String nivel2;
  public String nivel3;
  public String nivel4;
  public String nivel5;
  public String nivel6;
  public String nivel7;
  public String nivel8;
  public String nivel9;
  public String row1;
  public String row2;
  public String row3;
  public String row4;
  public String name;
  public String id;
  public String currency;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("nivel1"))
      return nivel1;
    else if (fieldName.equalsIgnoreCase("nivel2"))
      return nivel2;
    else if (fieldName.equalsIgnoreCase("nivel3"))
      return nivel3;
    else if (fieldName.equalsIgnoreCase("nivel4"))
      return nivel4;
    else if (fieldName.equalsIgnoreCase("nivel5"))
      return nivel5;
    else if (fieldName.equalsIgnoreCase("nivel6"))
      return nivel6;
    else if (fieldName.equalsIgnoreCase("nivel7"))
      return nivel7;
    else if (fieldName.equalsIgnoreCase("nivel8"))
      return nivel8;
    else if (fieldName.equalsIgnoreCase("nivel9"))
      return nivel9;
    else if (fieldName.equalsIgnoreCase("row1"))
      return row1;
    else if (fieldName.equalsIgnoreCase("row2"))
      return row2;
    else if (fieldName.equalsIgnoreCase("row3"))
      return row3;
    else if (fieldName.equalsIgnoreCase("row4"))
      return row4;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("currency"))
      return currency;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportSalesDimensionalAnalyzeJRData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static ReportSalesDimensionalAnalyzeJRData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT" +
      "      '' as NIVEL1, '' as NIVEL2, '' as NIVEL3, '' as NIVEL4, '' as NIVEL5, '' as NIVEL6, '' as NIVEL7, '' as NIVEL8, '' as NIVEL9," +
      "      0 AS ROW1, 0 AS ROW2, 0 as ROW3, 0 as ROW4,'' as name, '' as id," +
      "      'â‚¬' AS CURRENCY from dual";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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
        ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData = new ReportSalesDimensionalAnalyzeJRData();
        objectReportSalesDimensionalAnalyzeJRData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportSalesDimensionalAnalyzeJRData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportSalesDimensionalAnalyzeJRData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportSalesDimensionalAnalyzeJRData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportSalesDimensionalAnalyzeJRData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportSalesDimensionalAnalyzeJRData.nivel6 = UtilSql.getValue(result, "nivel6");
        objectReportSalesDimensionalAnalyzeJRData.nivel7 = UtilSql.getValue(result, "nivel7");
        objectReportSalesDimensionalAnalyzeJRData.nivel8 = UtilSql.getValue(result, "nivel8");
        objectReportSalesDimensionalAnalyzeJRData.nivel9 = UtilSql.getValue(result, "nivel9");
        objectReportSalesDimensionalAnalyzeJRData.row1 = UtilSql.getValue(result, "row1");
        objectReportSalesDimensionalAnalyzeJRData.row2 = UtilSql.getValue(result, "row2");
        objectReportSalesDimensionalAnalyzeJRData.row3 = UtilSql.getValue(result, "row3");
        objectReportSalesDimensionalAnalyzeJRData.row4 = UtilSql.getValue(result, "row4");
        objectReportSalesDimensionalAnalyzeJRData.name = UtilSql.getValue(result, "name");
        objectReportSalesDimensionalAnalyzeJRData.id = UtilSql.getValue(result, "id");
        objectReportSalesDimensionalAnalyzeJRData.currency = UtilSql.getValue(result, "currency");
        objectReportSalesDimensionalAnalyzeJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportSalesDimensionalAnalyzeJRData);
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
    ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData[] = new ReportSalesDimensionalAnalyzeJRData[vector.size()];
    vector.copyInto(objectReportSalesDimensionalAnalyzeJRData);
    return(objectReportSalesDimensionalAnalyzeJRData);
  }

  public static ReportSalesDimensionalAnalyzeJRData[] set()    throws ServletException {
    ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData[] = new ReportSalesDimensionalAnalyzeJRData[1];
    objectReportSalesDimensionalAnalyzeJRData[0] = new ReportSalesDimensionalAnalyzeJRData();
    objectReportSalesDimensionalAnalyzeJRData[0].nivel1 = "";
    objectReportSalesDimensionalAnalyzeJRData[0].nivel2 = "";
    objectReportSalesDimensionalAnalyzeJRData[0].nivel3 = "";
    objectReportSalesDimensionalAnalyzeJRData[0].nivel4 = "";
    objectReportSalesDimensionalAnalyzeJRData[0].nivel5 = "";
    objectReportSalesDimensionalAnalyzeJRData[0].nivel6 = "";
    objectReportSalesDimensionalAnalyzeJRData[0].nivel7 = "";
    objectReportSalesDimensionalAnalyzeJRData[0].nivel8 = "";
    objectReportSalesDimensionalAnalyzeJRData[0].nivel9 = "";
    objectReportSalesDimensionalAnalyzeJRData[0].row1 = "";
    objectReportSalesDimensionalAnalyzeJRData[0].row2 = "";
    objectReportSalesDimensionalAnalyzeJRData[0].row3 = "";
    objectReportSalesDimensionalAnalyzeJRData[0].row4 = "";
    objectReportSalesDimensionalAnalyzeJRData[0].name = "";
    objectReportSalesDimensionalAnalyzeJRData[0].id = "";
    objectReportSalesDimensionalAnalyzeJRData[0].currency = "";
    return objectReportSalesDimensionalAnalyzeJRData;
  }

  public static ReportSalesDimensionalAnalyzeJRData[] selectOrder(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String dateFrom, String dateTo, String dateRange, String adOrgId, String adUserClient, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String mWarehouseId, String salesrepId, String cProjectId, String orderby)    throws ServletException {
    return selectOrder(connectionProvider, cCurrencyConv, nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7, nivel8, nivel9, dateFrom, dateTo, dateRange, adOrgId, adUserClient, cBpartnerGroupId, cBpartnerId, mProductCategoryId, mProductId, mWarehouseId, salesrepId, cProjectId, orderby, 0, 0);
  }

  public static ReportSalesDimensionalAnalyzeJRData[] selectOrder(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String dateFrom, String dateTo, String dateRange, String adOrgId, String adUserClient, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String mWarehouseId, String salesrepId, String cProjectId, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT " +
      "      NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, " +
      "      SUM(AMOUNT) AS ROW1, SUM(QTY) AS ROW4, SUM(estinvamount) as ROW2,SUM(invoiceamount) as ROW3," +
      "      C_CURRENCY_SYMBOL(?, 0, 'Y') AS CURRENCY" +
      "      FROM (SELECT to_char(";
    strSql = strSql + ((nivel1==null || nivel1.equals(""))?"":nivel1);
    strSql = strSql + 
      ") AS NIVEL1, to_char(";
    strSql = strSql + ((nivel2==null || nivel2.equals(""))?"":nivel2);
    strSql = strSql + 
      ") AS NIVEL2, to_char(";
    strSql = strSql + ((nivel3==null || nivel3.equals(""))?"":nivel3);
    strSql = strSql + 
      ") AS NIVEL3, to_char(";
    strSql = strSql + ((nivel4==null || nivel4.equals(""))?"":nivel4);
    strSql = strSql + 
      ") AS NIVEL4, to_char(";
    strSql = strSql + ((nivel5==null || nivel5.equals(""))?"":nivel5);
    strSql = strSql + 
      ") AS NIVEL5, to_char(";
    strSql = strSql + ((nivel6==null || nivel6.equals(""))?"":nivel6);
    strSql = strSql + 
      ") AS NIVEL6, to_char(";
    strSql = strSql + ((nivel7==null || nivel7.equals(""))?"":nivel7);
    strSql = strSql + 
      ") AS NIVEL7, to_char(";
    strSql = strSql + ((nivel8==null || nivel8.equals(""))?"":nivel8);
    strSql = strSql + 
      ") AS NIVEL8, to_char(";
    strSql = strSql + ((nivel9==null || nivel9.equals(""))?"":nivel9);
    strSql = strSql + 
      ") AS NIVEL9, " +
      "      zssi_getOrderLineValueByPeriod(C_ORDERLINE.C_ORDERLINE_ID, to_date(?), to_date(?)) as AMOUNT," +
      "      coalesce(C_ORDERLINE.QTYORDERED,0) as QTY," +
      "      zssi_getinvoicedamt4OrderDevidedByLinesByPeriod(C_ORDER.C_ORDER_ID, to_date(?), to_date(?)) as invoiceamount," +
      "      zssi_getEstInvoiceAmt4orderlineByPeriod(C_ORDERLINE.C_ORDERLINE_ID, to_date(?), to_date(?)) as estinvamount" +
      "      FROM C_ORDER left join AD_USER on C_ORDER.SALESREP_ID = AD_USER.AD_USER_ID, " +
      "       C_BPARTNER,C_BP_GROUP, " +
      "       C_ORDERLINE  left join c_project on C_ORDERLINE.c_project_id=c_project.c_project_id, " +
      "       M_PRODUCT, M_PRODUCT_CATEGORY, M_WAREHOUSE" +
      "      WHERE C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID" +
      "      AND C_ORDERLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "      AND C_ORDER.M_WAREHOUSE_ID = M_WAREHOUSE.M_WAREHOUSE_ID" +
      "      AND C_ORDER.ISSOTRX = 'Y'" +
      "      AND C_ORDER.PROCESSED = 'Y' AND ";
    strSql = strSql + ((dateRange==null || dateRange.equals(""))?"":dateRange);
    strSql = strSql + 
      "      AND ad_get_docbasetype(C_ORDER.c_DocType_ID) not in ('NON','POREQUESTOFFER','SALESOFFER')" +
      "      AND 0=0 AND C_ORDER.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_ORDER.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":" AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":" AND M_WAREHOUSE.M_WAREHOUSE_ID = ? ");
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_ORDER.SALESREP_ID = ? ");
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT.C_PROJECT_ID IN" + cProjectId);
    strSql = strSql + 
      ") AA" +
      "      GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (nivel1 != null && !(nivel1.equals(""))) {
        }
      if (nivel2 != null && !(nivel2.equals(""))) {
        }
      if (nivel3 != null && !(nivel3.equals(""))) {
        }
      if (nivel4 != null && !(nivel4.equals(""))) {
        }
      if (nivel5 != null && !(nivel5.equals(""))) {
        }
      if (nivel6 != null && !(nivel6.equals(""))) {
        }
      if (nivel7 != null && !(nivel7.equals(""))) {
        }
      if (nivel8 != null && !(nivel8.equals(""))) {
        }
      if (nivel9 != null && !(nivel9.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      if (dateRange != null && !(dateRange.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (cBpartnerGroupId != null && !(cBpartnerGroupId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerGroupId);
      }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductCategoryId != null && !(mProductCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        }
      if (orderby != null && !(orderby.equals(""))) {
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
        ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData = new ReportSalesDimensionalAnalyzeJRData();
        objectReportSalesDimensionalAnalyzeJRData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportSalesDimensionalAnalyzeJRData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportSalesDimensionalAnalyzeJRData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportSalesDimensionalAnalyzeJRData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportSalesDimensionalAnalyzeJRData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportSalesDimensionalAnalyzeJRData.nivel6 = UtilSql.getValue(result, "nivel6");
        objectReportSalesDimensionalAnalyzeJRData.nivel7 = UtilSql.getValue(result, "nivel7");
        objectReportSalesDimensionalAnalyzeJRData.nivel8 = UtilSql.getValue(result, "nivel8");
        objectReportSalesDimensionalAnalyzeJRData.nivel9 = UtilSql.getValue(result, "nivel9");
        objectReportSalesDimensionalAnalyzeJRData.row1 = UtilSql.getValue(result, "row1");
        objectReportSalesDimensionalAnalyzeJRData.row4 = UtilSql.getValue(result, "row4");
        objectReportSalesDimensionalAnalyzeJRData.row2 = UtilSql.getValue(result, "row2");
        objectReportSalesDimensionalAnalyzeJRData.row3 = UtilSql.getValue(result, "row3");
        objectReportSalesDimensionalAnalyzeJRData.currency = UtilSql.getValue(result, "currency");
        objectReportSalesDimensionalAnalyzeJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportSalesDimensionalAnalyzeJRData);
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
    ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData[] = new ReportSalesDimensionalAnalyzeJRData[vector.size()];
    vector.copyInto(objectReportSalesDimensionalAnalyzeJRData);
    return(objectReportSalesDimensionalAnalyzeJRData);
  }

  public static ReportSalesDimensionalAnalyzeJRData[] selectOffer(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String dateFrom, String dateTo, String proposalstatus, String dateRange, String adOrgId, String adUserClient, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String mWarehouseId, String salesrepId, String cProjectId, String orderby)    throws ServletException {
    return selectOffer(connectionProvider, cCurrencyConv, nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7, nivel8, nivel9, dateFrom, dateTo, proposalstatus, dateRange, adOrgId, adUserClient, cBpartnerGroupId, cBpartnerId, mProductCategoryId, mProductId, mWarehouseId, salesrepId, cProjectId, orderby, 0, 0);
  }

  public static ReportSalesDimensionalAnalyzeJRData[] selectOffer(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String dateFrom, String dateTo, String proposalstatus, String dateRange, String adOrgId, String adUserClient, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String mWarehouseId, String salesrepId, String cProjectId, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT " +
      "      NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, " +
      "      SUM(AMOUNT) AS ROW1, SUM(QTY) AS ROW4, SUM(CHANCEAMT) as ROW2," +
      "      C_CURRENCY_SYMBOL(?, 0, 'Y') AS CURRENCY" +
      "      FROM (SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, " +
      "      SUM(AMOUNT) AS AMOUNT, SUM(QTY) AS QTY,SUM(CHANCEAMT) as CHANCEAMT," +
      "      TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID" +
      "      FROM (SELECT to_char(";
    strSql = strSql + ((nivel1==null || nivel1.equals(""))?"":nivel1);
    strSql = strSql + 
      ") AS NIVEL1, to_char(";
    strSql = strSql + ((nivel2==null || nivel2.equals(""))?"":nivel2);
    strSql = strSql + 
      ") AS NIVEL2, to_char(";
    strSql = strSql + ((nivel3==null || nivel3.equals(""))?"":nivel3);
    strSql = strSql + 
      ") AS NIVEL3, to_char(";
    strSql = strSql + ((nivel4==null || nivel4.equals(""))?"":nivel4);
    strSql = strSql + 
      ") AS NIVEL4, to_char(";
    strSql = strSql + ((nivel5==null || nivel5.equals(""))?"":nivel5);
    strSql = strSql + 
      ") AS NIVEL5, to_char(";
    strSql = strSql + ((nivel6==null || nivel6.equals(""))?"":nivel6);
    strSql = strSql + 
      ") AS NIVEL6, to_char(";
    strSql = strSql + ((nivel7==null || nivel7.equals(""))?"":nivel7);
    strSql = strSql + 
      ") AS NIVEL7, to_char(";
    strSql = strSql + ((nivel8==null || nivel8.equals(""))?"":nivel8);
    strSql = strSql + 
      ") AS NIVEL8, to_char(";
    strSql = strSql + ((nivel9==null || nivel9.equals(""))?"":nivel9);
    strSql = strSql + 
      ") AS NIVEL9, " +
      "      zssi_getOrderLineValueByPeriod(C_ORDERLINE.C_ORDERLINE_ID,to_date(?), to_date(?)) as AMOUNT," +
      "      coalesce(C_ORDERLINE.QTYORDERED,0) as qty, " +
      "      round(to_number(coalesce(C_ORDER.estpropability,'0'))* zssi_getOrderLineValueByPeriod(C_ORDERLINE.C_ORDERLINE_ID,  to_date(?), to_date(?)) /100,1) as CHANCEAMT," +
      "      COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID) AS TRCURRENCYID,      " +
      "      TO_DATE(COALESCE(C_ORDERLINE.DATEORDERED, C_ORDER.DATEORDERED, NOW())) AS TRDATE,      " +
      "      C_ORDERLINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "      C_ORDERLINE.AD_ORG_ID AS TRORGID " +
      "      FROM C_ORDER left join AD_USER on C_ORDER.SALESREP_ID = AD_USER.AD_USER_ID, " +
      "       C_BPARTNER,C_BP_GROUP, C_ORDERLINE" +
      "       left join c_project on C_ORDERLINE.c_project_id=c_project.c_project_id, M_PRODUCT, M_PRODUCT_CATEGORY, M_WAREHOUSE" +
      "      WHERE C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID" +
      "      AND C_ORDERLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "      AND C_ORDER.M_WAREHOUSE_ID = M_WAREHOUSE.M_WAREHOUSE_ID" +
      "      AND C_ORDER.ISSOTRX = 'Y'" +
      "      AND C_ORDER.PROCESSED = 'Y'" +
      "      AND C_ORDER.proposalstatus= ?" +
      "      AND ad_get_docbasetype(C_ORDER.c_DocType_ID) in ('POREQUESTOFFER','SALESOFFER') AND ";
    strSql = strSql + ((dateRange==null || dateRange.equals(""))?"":dateRange);
    strSql = strSql + 
      "      AND 0=0 AND C_ORDER.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_ORDER.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":" AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":" AND M_WAREHOUSE.M_WAREHOUSE_ID = ? ");
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_ORDER.SALESREP_ID = ? ");
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT.C_PROJECT_ID IN" + cProjectId);
    strSql = strSql + 
      ") AA" +
      "      GROUP BY NIVEL1,  NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID) ZZ" +
      "      GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (nivel1 != null && !(nivel1.equals(""))) {
        }
      if (nivel2 != null && !(nivel2.equals(""))) {
        }
      if (nivel3 != null && !(nivel3.equals(""))) {
        }
      if (nivel4 != null && !(nivel4.equals(""))) {
        }
      if (nivel5 != null && !(nivel5.equals(""))) {
        }
      if (nivel6 != null && !(nivel6.equals(""))) {
        }
      if (nivel7 != null && !(nivel7.equals(""))) {
        }
      if (nivel8 != null && !(nivel8.equals(""))) {
        }
      if (nivel9 != null && !(nivel9.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proposalstatus);
      if (dateRange != null && !(dateRange.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (cBpartnerGroupId != null && !(cBpartnerGroupId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerGroupId);
      }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductCategoryId != null && !(mProductCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        }
      if (orderby != null && !(orderby.equals(""))) {
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
        ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData = new ReportSalesDimensionalAnalyzeJRData();
        objectReportSalesDimensionalAnalyzeJRData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportSalesDimensionalAnalyzeJRData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportSalesDimensionalAnalyzeJRData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportSalesDimensionalAnalyzeJRData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportSalesDimensionalAnalyzeJRData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportSalesDimensionalAnalyzeJRData.nivel6 = UtilSql.getValue(result, "nivel6");
        objectReportSalesDimensionalAnalyzeJRData.nivel7 = UtilSql.getValue(result, "nivel7");
        objectReportSalesDimensionalAnalyzeJRData.nivel8 = UtilSql.getValue(result, "nivel8");
        objectReportSalesDimensionalAnalyzeJRData.nivel9 = UtilSql.getValue(result, "nivel9");
        objectReportSalesDimensionalAnalyzeJRData.row1 = UtilSql.getValue(result, "row1");
        objectReportSalesDimensionalAnalyzeJRData.row4 = UtilSql.getValue(result, "row4");
        objectReportSalesDimensionalAnalyzeJRData.row2 = UtilSql.getValue(result, "row2");
        objectReportSalesDimensionalAnalyzeJRData.currency = UtilSql.getValue(result, "currency");
        objectReportSalesDimensionalAnalyzeJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportSalesDimensionalAnalyzeJRData);
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
    ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData[] = new ReportSalesDimensionalAnalyzeJRData[vector.size()];
    vector.copyInto(objectReportSalesDimensionalAnalyzeJRData);
    return(objectReportSalesDimensionalAnalyzeJRData);
  }

  public static ReportSalesDimensionalAnalyzeJRData[] selectProject(ConnectionProvider connectionProvider, String cCurrencyConv, String dateFrom, String dateTo, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String dateRange, String adOrgId, String adUserClient, String cBpartnerGroupId, String cBpartnerId, String mWarehouseId, String salesrepId, String cProjectId, String orderby)    throws ServletException {
    return selectProject(connectionProvider, cCurrencyConv, dateFrom, dateTo, nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7, nivel8, nivel9, dateRange, adOrgId, adUserClient, cBpartnerGroupId, cBpartnerId, mWarehouseId, salesrepId, cProjectId, orderby, 0, 0);
  }

  public static ReportSalesDimensionalAnalyzeJRData[] selectProject(ConnectionProvider connectionProvider, String cCurrencyConv, String dateFrom, String dateTo, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String dateRange, String adOrgId, String adUserClient, String cBpartnerGroupId, String cBpartnerId, String mWarehouseId, String salesrepId, String cProjectId, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT " +
      "      NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, " +
      "      SUM(OrderAMOUNT) AS ROW1, AVG(MARGIN) AS ROW4,SUM(projectrevenue) as ROW2,SUM(projectcost) as ROW3," +
      "      C_CURRENCY_SYMBOL(?, 0, 'Y') AS CURRENCY" +
      "      FROM (SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, " +
      "      SUM(totallines) AS OrderAmount, AVG(MARGIN) AS MARGIN,SUM(projectrevenue/counter) as projectrevenue,SUM(projectcost/counter) as projectcost," +
      "      TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID" +
      "      FROM (SELECT to_char(";
    strSql = strSql + ((nivel1==null || nivel1.equals(""))?"":nivel1);
    strSql = strSql + 
      ") AS NIVEL1, to_char(";
    strSql = strSql + ((nivel2==null || nivel2.equals(""))?"":nivel2);
    strSql = strSql + 
      ") AS NIVEL2, to_char(";
    strSql = strSql + ((nivel3==null || nivel3.equals(""))?"":nivel3);
    strSql = strSql + 
      ") AS NIVEL3, to_char(";
    strSql = strSql + ((nivel4==null || nivel4.equals(""))?"":nivel4);
    strSql = strSql + 
      ") AS NIVEL4, to_char(";
    strSql = strSql + ((nivel5==null || nivel5.equals(""))?"":nivel5);
    strSql = strSql + 
      ") AS NIVEL5, to_char(";
    strSql = strSql + ((nivel6==null || nivel6.equals(""))?"":nivel6);
    strSql = strSql + 
      ") AS NIVEL6, to_char(";
    strSql = strSql + ((nivel7==null || nivel7.equals(""))?"":nivel7);
    strSql = strSql + 
      ") AS NIVEL7, to_char(";
    strSql = strSql + ((nivel8==null || nivel8.equals(""))?"":nivel8);
    strSql = strSql + 
      ") AS NIVEL8, to_char(";
    strSql = strSql + ((nivel9==null || nivel9.equals(""))?"":nivel9);
    strSql = strSql + 
      ") AS NIVEL9, " +
      "      zssi_getvalue4orderByPeriod(c_order.c_order_id, to_date(?), to_date(?)) as totallines, " +
      "      (select case count(*) when 0 then 1 else count(*) end from c_order where c_project_id=c_project.c_project_id and C_ORDER.DOCSTATUS in ('CO','CL') " +
      "      AND ad_get_docbasetype(C_ORDER.c_DocType_ID) not in ('NON','POREQUESTOFFER','SALESOFFER')" +
      "      and C_ORDER.ISSOTRX = 'Y' AND c_order.orderselfjoin is null) as counter," +
      "      case when coalesce(c_project.invoicedamt,0)=0 then 0 when coalesce(c_project.actualcostamount,0)=0 then 0 else (coalesce(c_project.invoicedamt,0)/case when coalesce(c_project.actualcostamount,0)=0 then 1 else coalesce(c_project.actualcostamount,0) end -1)*100 end as MARGIN, " +
      "      coalesce(c_project.invoicedamt,0) as projectrevenue,coalesce(c_project.actualcostamount,0) as projectcost," +
      "      C_PROJECT.C_CURRENCY_ID AS TRCURRENCYID,      " +
      "      TO_DATE(coalesce(C_PROJECT.startdate,now())) AS TRDATE,      " +
      "      C_PROJECT.AD_CLIENT_ID AS TRCLIENTID,      " +
      "      C_PROJECT.AD_ORG_ID AS TRORGID " +
      "      FROM c_project left join c_order on C_ORDER.c_project_id=c_project.c_project_id," +
      "       AD_USER,  C_BPARTNER,C_BP_GROUP, M_WAREHOUSE" +
      "      WHERE C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_PROJECT.SALESREP_ID = AD_USER.AD_USER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_PROJECT.M_WAREHOUSE_ID = M_WAREHOUSE.M_WAREHOUSE_ID" +
      "      AND C_ORDER.ISSOTRX = 'Y'" +
      "      AND C_PROJECT.projectstatus in ('OR','CL')" +
      "      AND c_order.orderselfjoin is null" +
      "      AND C_ORDER.DOCSTATUS in ('CO','CL') AND ";
    strSql = strSql + ((dateRange==null || dateRange.equals(""))?"":dateRange);
    strSql = strSql + 
      "      AND ad_get_docbasetype(C_ORDER.c_DocType_ID) not in ('NON','POREQUESTOFFER','SALESOFFER')" +
      "      AND 0=0 AND C_PROJECT.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_PROJECT.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":" AND M_WAREHOUSE.M_WAREHOUSE_ID = ? ");
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_ORDER.SALESREP_ID = ? ");
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT.C_PROJECT_ID IN" + cProjectId);
    strSql = strSql + 
      ") AA" +
      "      GROUP BY NIVEL1,  NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID) ZZ" +
      "      GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      if (nivel1 != null && !(nivel1.equals(""))) {
        }
      if (nivel2 != null && !(nivel2.equals(""))) {
        }
      if (nivel3 != null && !(nivel3.equals(""))) {
        }
      if (nivel4 != null && !(nivel4.equals(""))) {
        }
      if (nivel5 != null && !(nivel5.equals(""))) {
        }
      if (nivel6 != null && !(nivel6.equals(""))) {
        }
      if (nivel7 != null && !(nivel7.equals(""))) {
        }
      if (nivel8 != null && !(nivel8.equals(""))) {
        }
      if (nivel9 != null && !(nivel9.equals(""))) {
        }
      if (dateRange != null && !(dateRange.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (cBpartnerGroupId != null && !(cBpartnerGroupId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerGroupId);
      }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        }
      if (orderby != null && !(orderby.equals(""))) {
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
        ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData = new ReportSalesDimensionalAnalyzeJRData();
        objectReportSalesDimensionalAnalyzeJRData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportSalesDimensionalAnalyzeJRData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportSalesDimensionalAnalyzeJRData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportSalesDimensionalAnalyzeJRData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportSalesDimensionalAnalyzeJRData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportSalesDimensionalAnalyzeJRData.nivel6 = UtilSql.getValue(result, "nivel6");
        objectReportSalesDimensionalAnalyzeJRData.nivel7 = UtilSql.getValue(result, "nivel7");
        objectReportSalesDimensionalAnalyzeJRData.nivel8 = UtilSql.getValue(result, "nivel8");
        objectReportSalesDimensionalAnalyzeJRData.nivel9 = UtilSql.getValue(result, "nivel9");
        objectReportSalesDimensionalAnalyzeJRData.row1 = UtilSql.getValue(result, "row1");
        objectReportSalesDimensionalAnalyzeJRData.row4 = UtilSql.getValue(result, "row4");
        objectReportSalesDimensionalAnalyzeJRData.row2 = UtilSql.getValue(result, "row2");
        objectReportSalesDimensionalAnalyzeJRData.row3 = UtilSql.getValue(result, "row3");
        objectReportSalesDimensionalAnalyzeJRData.currency = UtilSql.getValue(result, "currency");
        objectReportSalesDimensionalAnalyzeJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportSalesDimensionalAnalyzeJRData);
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
    ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData[] = new ReportSalesDimensionalAnalyzeJRData[vector.size()];
    vector.copyInto(objectReportSalesDimensionalAnalyzeJRData);
    return(objectReportSalesDimensionalAnalyzeJRData);
  }

  public static String selectBpgroup(ConnectionProvider connectionProvider, String cBpGroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_BP_GROUP.NAME" +
      "      FROM C_BP_GROUP" +
      "      WHERE C_BP_GROUP.C_BP_GROUP_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpGroupId);

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

  public static String selectProductCategory(ConnectionProvider connectionProvider, String mProductCategoryId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT M_PRODUCT_CATEGORY.NAME" +
      "      FROM M_PRODUCT_CATEGORY" +
      "      WHERE M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);

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

  public static String selectMwarehouse(ConnectionProvider connectionProvider, String mWarehouseId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT M_WAREHOUSE.NAME" +
      "      FROM M_WAREHOUSE" +
      "      WHERE M_WAREHOUSE.M_WAREHOUSE_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);

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

  public static String selectSalesrep(ConnectionProvider connectionProvider, String mWarehouseId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_USER.FIRSTNAME||' '||AD_USER.LASTNAME" +
      "      FROM AD_USER" +
      "      WHERE AD_USER.AD_USER_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);

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

  public static String selectEntity(ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_CLIENT.NAME" +
      "      FROM AD_CLIENT" +
      "      WHERE AD_CLIENT.AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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
Reference DimensionalFilterSale
 */
  public static ReportSalesDimensionalAnalyzeJRData[] selectNotShown(ConnectionProvider connectionProvider, String lang, String notShown)    throws ServletException {
    return selectNotShown(connectionProvider, lang, notShown, 0, 0);
  }

/**
Reference DimensionalFilterSale
 */
  public static ReportSalesDimensionalAnalyzeJRData[] selectNotShown(ConnectionProvider connectionProvider, String lang, String notShown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT l.VALUE AS ID, coalesce(T.NAME,L.name) as name " +
      "              FROM AD_REF_LIST     L left join AD_REF_LIST_trl T on l.AD_REF_LIST_ID  = t.AD_REF_LIST_ID and t.AD_LANGUAGE = ?" +
      "             WHERE l.AD_REFERENCE_ID = '800087'" +
      "               AND L.VALUE IN ('1', '2', '3', '4', '5', '6', '7', '8', '9')" +
      "             ORDER BY TO_NUMBER(l.VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((notShown==null || notShown.equals(""))?"":" AND ID NOT IN" + notShown);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      if (notShown != null && !(notShown.equals(""))) {
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
        ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData = new ReportSalesDimensionalAnalyzeJRData();
        objectReportSalesDimensionalAnalyzeJRData.id = UtilSql.getValue(result, "id");
        objectReportSalesDimensionalAnalyzeJRData.name = UtilSql.getValue(result, "name");
        objectReportSalesDimensionalAnalyzeJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportSalesDimensionalAnalyzeJRData);
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
    ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData[] = new ReportSalesDimensionalAnalyzeJRData[vector.size()];
    vector.copyInto(objectReportSalesDimensionalAnalyzeJRData);
    return(objectReportSalesDimensionalAnalyzeJRData);
  }

  public static ReportSalesDimensionalAnalyzeJRData[] selectShown(ConnectionProvider connectionProvider, String lang, String shown)    throws ServletException {
    return selectShown(connectionProvider, lang, shown, 0, 0);
  }

  public static ReportSalesDimensionalAnalyzeJRData[] selectShown(ConnectionProvider connectionProvider, String lang, String shown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT l.VALUE AS ID, coalesce(T.NAME,L.name) as name " +
      "              FROM AD_REF_LIST     L left join AD_REF_LIST_trl T on l.AD_REF_LIST_ID  = t.AD_REF_LIST_ID and t.AD_LANGUAGE = ?" +
      "             WHERE l.AD_REFERENCE_ID = '800087'" +
      "               AND L.VALUE IN ('1', '2', '3', '4', '5', '6', '7', '8', '9')" +
      "             ORDER BY TO_NUMBER(l.VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((shown==null || shown.equals(""))?"":" AND ID IN" + shown);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      if (shown != null && !(shown.equals(""))) {
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
        ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData = new ReportSalesDimensionalAnalyzeJRData();
        objectReportSalesDimensionalAnalyzeJRData.id = UtilSql.getValue(result, "id");
        objectReportSalesDimensionalAnalyzeJRData.name = UtilSql.getValue(result, "name");
        objectReportSalesDimensionalAnalyzeJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportSalesDimensionalAnalyzeJRData);
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
    ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData[] = new ReportSalesDimensionalAnalyzeJRData[vector.size()];
    vector.copyInto(objectReportSalesDimensionalAnalyzeJRData);
    return(objectReportSalesDimensionalAnalyzeJRData);
  }
}
