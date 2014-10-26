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

class ReportRefundInvoiceCustomerDimensionalAnalysesData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportRefundInvoiceCustomerDimensionalAnalysesData.class);
  private String InitRecordNumber="0";
  public String nivel1;
  public String nivel2;
  public String nivel3;
  public String nivel4;
  public String nivel5;
  public String nivel6;
  public String linenetamt;
  public String refundamt;
  public String qtyinvoiced;
  public String refundqty;
  public String linenetref;
  public String refundamtref;
  public String ratio;
  public String qtyinvoicedref;
  public String refundqtyref;
  public String id;
  public String name;
  public String uomsymbol;

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
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("refundamt"))
      return refundamt;
    else if (fieldName.equalsIgnoreCase("qtyinvoiced"))
      return qtyinvoiced;
    else if (fieldName.equalsIgnoreCase("refundqty"))
      return refundqty;
    else if (fieldName.equalsIgnoreCase("linenetref"))
      return linenetref;
    else if (fieldName.equalsIgnoreCase("refundamtref"))
      return refundamtref;
    else if (fieldName.equalsIgnoreCase("ratio"))
      return ratio;
    else if (fieldName.equalsIgnoreCase("qtyinvoicedref"))
      return qtyinvoicedref;
    else if (fieldName.equalsIgnoreCase("refundqtyref"))
      return refundqtyref;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("uomsymbol"))
      return uomsymbol;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportRefundInvoiceCustomerDimensionalAnalysesData[] select(ConnectionProvider connectionProvider, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartner, String mProductCategoryId, String mProduct, String salesrepId, String dateFromRef, String dateToRef, String orderby)    throws ServletException {
    return select(connectionProvider, nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, adOrgId, adUserClient, dateFrom, dateTo, cBpartnerGroupId, cBpartner, mProductCategoryId, mProduct, salesrepId, dateFromRef, dateToRef, orderby, 0, 0);
  }

  public static ReportRefundInvoiceCustomerDimensionalAnalysesData[] select(ConnectionProvider connectionProvider, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartner, String mProductCategoryId, String mProduct, String salesrepId, String dateFromRef, String dateToRef, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, SUM(LINENETAMT) AS LINENETAMT, SUM(REFUNDAMT) AS REFUNDAMT, SUM(QTYINVOICED) AS QTYINVOICED, SUM(REFUNDQTY) AS REFUNDQTY, SUM(LINENETREF) AS LINENETREF, SUM(REFUNDAMTREF) AS REFUNDAMTREF, C_DIVIDE(SUM(REFUNDAMT), (SUM(LINENETAMT)+SUM(REFUNDAMT)))*100 AS RATIO, SUM(QTYINVOICEDREF) AS QTYINVOICEDREF, SUM(REFUNDQTYREF) AS REFUNDQTYREF, '' AS ID, '' AS NAME, UOMSYMBOL" +
      "      FROM (SELECT ";
    strSql = strSql + ((nivel1==null || nivel1.equals(""))?"":nivel1);
    strSql = strSql + 
      "char('1') AS NIVEL1, ";
    strSql = strSql + ((nivel2==null || nivel2.equals(""))?"":nivel2);
    strSql = strSql + 
      "char('2') AS NIVEL2, ";
    strSql = strSql + ((nivel3==null || nivel3.equals(""))?"":nivel3);
    strSql = strSql + 
      "char('3') AS NIVEL3, ";
    strSql = strSql + ((nivel4==null || nivel4.equals(""))?"":nivel4);
    strSql = strSql + 
      "char('4') AS NIVEL4, ";
    strSql = strSql + ((nivel5==null || nivel5.equals(""))?"":nivel5);
    strSql = strSql + 
      "char('5') AS NIVEL5, ";
    strSql = strSql + ((nivel6==null || nivel6.equals(""))?"":nivel6);
    strSql = strSql + 
      "char('6') AS NIVEL6," +
      "      C_INVOICELINE.LINENETAMT AS LINENETAMT, CASE SIGN(C_INVOICELINE.LINENETAMT) WHEN  -1 THEN  -1*C_INVOICELINE.LINENETAMT ELSE  0 END AS REFUNDAMT, C_INVOICELINE.QTYINVOICED AS QTYINVOICED, CASE SIGN(C_INVOICELINE.QTYINVOICED) WHEN  -1 THEN  (-1*C_INVOICELINE.QTYINVOICED) ELSE  0 END AS REFUNDQTY, 0 AS LINENETREF, 0 AS REFUNDAMTREF, 0 AS QTYINVOICEDREF, 0 AS REFUNDQTYREF, C_UOM.UOMSYMBOL" +
      "      FROM C_INVOICE left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID," +
      "           C_INVOICELINE left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                         left join M_PRODUCT_CATEGORY on  M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID " +
      "                         left join C_UOM on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID," +
      "           C_BPARTNER, C_BP_GROUP" +
      "      WHERE C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "        AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "      AND C_INVOICE.ISSOTRX = 'Y'" +
      "      AND C_INVOICE.PROCESSED = 'Y'" +
      "      AND 0=0 AND C_INVOICE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_INVOICE.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":" AND C_INVOICE.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":" AND C_INVOICE.DATEINVOICED < to_date(?) ");
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartner==null || cBpartner.equals(""))?"":"  AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartner);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProduct==null || mProduct.equals(""))?"":"  AND M_PRODUCT.M_PRODUCT_ID IN" + mProduct);
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_INVOICE.SALESREP_ID = ? ");
    strSql = strSql + 
      "      UNION ALL SELECT ";
    strSql = strSql + ((nivel1==null || nivel1.equals(""))?"":nivel1);
    strSql = strSql + 
      "char('8') AS NIVEL1 , ";
    strSql = strSql + ((nivel2==null || nivel2.equals(""))?"":nivel2);
    strSql = strSql + 
      "char('9') AS NIVEL2 , ";
    strSql = strSql + ((nivel3==null || nivel3.equals(""))?"":nivel3);
    strSql = strSql + 
      "har('10') AS NIVEL3 , ";
    strSql = strSql + ((nivel4==null || nivel4.equals(""))?"":nivel4);
    strSql = strSql + 
      "har('11') AS NIVEL4 , ";
    strSql = strSql + ((nivel5==null || nivel5.equals(""))?"":nivel5);
    strSql = strSql + 
      "har('12') AS NIVEL5 , ";
    strSql = strSql + ((nivel6==null || nivel6.equals(""))?"":nivel6);
    strSql = strSql + 
      "har('13') AS NIVEL6," +
      "      0 AS LINENETAMT, 0 AS REFUNDAMT, 0 AS QTYINVOICED, 0 AS REFUNDQTY, C_INVOICELINE.LINENETAMT AS LINENETREF, CASE SIGN(C_INVOICELINE.LINENETAMT) WHEN  -1 THEN  (-1*C_INVOICELINE.LINENETAMT) ELSE  0 END AS REFUNDAMTREF, C_INVOICELINE.QTYINVOICED AS QTYINVOICEDREF, CASE SIGN(C_INVOICELINE.QTYINVOICED) WHEN  -1 THEN  (-1*C_INVOICELINE.QTYINVOICED) ELSE  0 END AS REFUNDQTYREF, C_UOM.UOMSYMBOL" +
      "      FROM C_INVOICE left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID," +
      "           C_INVOICELINE left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                         left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                         left join C_UOM on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID," +
      "          C_BPARTNER, C_BP_GROUP" +
      "      WHERE C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "      AND C_INVOICE.ISSOTRX = 'Y'" +
      "      AND C_INVOICE.PROCESSED = 'Y'" +
      "      AND 3=3 AND C_INVOICE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_INVOICE.AD_CLIENT_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 2=2";
    strSql = strSql + ((dateFromRef==null || dateFromRef.equals(""))?"":" AND C_INVOICE.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((dateToRef==null || dateToRef.equals(""))?"":" AND C_INVOICE.DATEINVOICED < to_date(?) ");
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartner==null || cBpartner.equals(""))?"":"  AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartner);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProduct==null || mProduct.equals(""))?"":"  AND M_PRODUCT.M_PRODUCT_ID IN" + mProduct);
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_INVOICE.SALESREP_ID = ? ");
    strSql = strSql + 
      ") AA" +
      "      WHERE LINENETAMT <> 0" +
      "      OR REFUNDAMT <> 0" +
      "      OR LINENETREF <> 0" +
      "      OR REFUNDAMTREF <> 0" +
      "      GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, UOMSYMBOL";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
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
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (cBpartnerGroupId != null && !(cBpartnerGroupId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerGroupId);
      }
      if (cBpartner != null && !(cBpartner.equals(""))) {
        }
      if (mProductCategoryId != null && !(mProductCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      }
      if (mProduct != null && !(mProduct.equals(""))) {
        }
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
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
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (dateFromRef != null && !(dateFromRef.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFromRef);
      }
      if (dateToRef != null && !(dateToRef.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToRef);
      }
      if (cBpartnerGroupId != null && !(cBpartnerGroupId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerGroupId);
      }
      if (cBpartner != null && !(cBpartner.equals(""))) {
        }
      if (mProductCategoryId != null && !(mProductCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      }
      if (mProduct != null && !(mProduct.equals(""))) {
        }
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
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
        ReportRefundInvoiceCustomerDimensionalAnalysesData objectReportRefundInvoiceCustomerDimensionalAnalysesData = new ReportRefundInvoiceCustomerDimensionalAnalysesData();
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.nivel6 = UtilSql.getValue(result, "nivel6");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.refundamt = UtilSql.getValue(result, "refundamt");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.refundqty = UtilSql.getValue(result, "refundqty");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.linenetref = UtilSql.getValue(result, "linenetref");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.refundamtref = UtilSql.getValue(result, "refundamtref");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.ratio = UtilSql.getValue(result, "ratio");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.qtyinvoicedref = UtilSql.getValue(result, "qtyinvoicedref");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.refundqtyref = UtilSql.getValue(result, "refundqtyref");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.name = UtilSql.getValue(result, "name");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportRefundInvoiceCustomerDimensionalAnalysesData);
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
    ReportRefundInvoiceCustomerDimensionalAnalysesData objectReportRefundInvoiceCustomerDimensionalAnalysesData[] = new ReportRefundInvoiceCustomerDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportRefundInvoiceCustomerDimensionalAnalysesData);
    return(objectReportRefundInvoiceCustomerDimensionalAnalysesData);
  }

  public static ReportRefundInvoiceCustomerDimensionalAnalysesData[] set()    throws ServletException {
    ReportRefundInvoiceCustomerDimensionalAnalysesData objectReportRefundInvoiceCustomerDimensionalAnalysesData[] = new ReportRefundInvoiceCustomerDimensionalAnalysesData[1];
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0] = new ReportRefundInvoiceCustomerDimensionalAnalysesData();
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0].nivel1 = "";
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0].nivel2 = "";
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0].nivel3 = "";
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0].nivel4 = "";
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0].nivel5 = "";
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0].nivel6 = "";
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0].linenetamt = "";
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0].refundamt = "";
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0].qtyinvoiced = "";
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0].refundqty = "";
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0].linenetref = "";
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0].refundamtref = "";
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0].ratio = "";
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0].qtyinvoicedref = "";
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0].refundqtyref = "";
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0].id = "";
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0].name = "";
    objectReportRefundInvoiceCustomerDimensionalAnalysesData[0].uomsymbol = "";
    return objectReportRefundInvoiceCustomerDimensionalAnalysesData;
  }

  public static ReportRefundInvoiceCustomerDimensionalAnalysesData[] selectNoComparative(ConnectionProvider connectionProvider, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartner, String mProductCategoryId, String mProduct, String salesrepId, String orderby)    throws ServletException {
    return selectNoComparative(connectionProvider, nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, adOrgId, adUserClient, dateFrom, dateTo, cBpartnerGroupId, cBpartner, mProductCategoryId, mProduct, salesrepId, orderby, 0, 0);
  }

  public static ReportRefundInvoiceCustomerDimensionalAnalysesData[] selectNoComparative(ConnectionProvider connectionProvider, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartner, String mProductCategoryId, String mProduct, String salesrepId, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, SUM(LINENETAMT) AS LINENETAMT, SUM(REFUNDAMT) AS REFUNDAMT, C_DIVIDE(SUM(REFUNDAMT), (SUM(LINENETAMT)+SUM(REFUNDAMT)))*100 AS RATIO, SUM(QTYINVOICED) AS QTYINVOICED, SUM(REFUNDQTY) AS REFUNDQTY, SUM(LINENETREF) AS LINENETREF, SUM(REFUNDAMTREF) AS REFUNDAMTREF, SUM(QTYINVOICEDREF) AS QTYINVOICEDREF, SUM(REFUNDQTYREF) AS REFUNDQTYREF, '' AS ID, '' AS NAME, UOMSYMBOL" +
      "      FROM (SELECT ";
    strSql = strSql + ((nivel1==null || nivel1.equals(""))?"":nivel1);
    strSql = strSql + 
      "char('1') AS NIVEL1, ";
    strSql = strSql + ((nivel2==null || nivel2.equals(""))?"":nivel2);
    strSql = strSql + 
      "char('2') AS NIVEL2, ";
    strSql = strSql + ((nivel3==null || nivel3.equals(""))?"":nivel3);
    strSql = strSql + 
      "char('3') AS NIVEL3, ";
    strSql = strSql + ((nivel4==null || nivel4.equals(""))?"":nivel4);
    strSql = strSql + 
      "char('4') AS NIVEL4, ";
    strSql = strSql + ((nivel5==null || nivel5.equals(""))?"":nivel5);
    strSql = strSql + 
      "char('5') AS NIVEL5, ";
    strSql = strSql + ((nivel6==null || nivel6.equals(""))?"":nivel6);
    strSql = strSql + 
      "char('6') AS NIVEL6," +
      "      C_INVOICELINE.LINENETAMT AS LINENETAMT, CASE SIGN(C_INVOICELINE.LINENETAMT) WHEN  -1 THEN  -1*C_INVOICELINE.LINENETAMT ELSE  0 END AS REFUNDAMT, C_INVOICELINE.QTYINVOICED AS QTYINVOICED, CASE SIGN(C_INVOICELINE.QTYINVOICED) WHEN  -1 THEN  (-1*C_INVOICELINE.QTYINVOICED) ELSE  0 END AS REFUNDQTY, 0 AS LINENETREF, 0 AS REFUNDAMTREF, 0 AS QTYINVOICEDREF, 0 AS REFUNDQTYREF, C_UOM.UOMSYMBOL" +
      "      FROM C_INVOICE left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID," +
      "           C_INVOICELINE left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                         left join C_UOM on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                         left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID," +
      "           C_BPARTNER, C_BP_GROUP" +
      "      WHERE C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "      AND C_INVOICE.ISSOTRX = 'Y'" +
      "      AND C_INVOICE.PROCESSED = 'Y'" +
      "      AND 0=0 AND C_INVOICE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_INVOICE.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":" AND C_INVOICE.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":" AND C_INVOICE.DATEINVOICED < to_date(?) ");
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartner==null || cBpartner.equals(""))?"":"  AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartner);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProduct==null || mProduct.equals(""))?"":"  AND M_PRODUCT.M_PRODUCT_ID IN" + mProduct);
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_INVOICE.SALESREP_ID = ? ");
    strSql = strSql + 
      ") AA" +
      "      WHERE LINENETAMT <> 0" +
      "      OR REFUNDAMT <> 0" +
      "      OR LINENETREF <> 0" +
      "      OR REFUNDAMTREF <> 0" +
      "      GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, UOMSYMBOL";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
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
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (cBpartnerGroupId != null && !(cBpartnerGroupId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerGroupId);
      }
      if (cBpartner != null && !(cBpartner.equals(""))) {
        }
      if (mProductCategoryId != null && !(mProductCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      }
      if (mProduct != null && !(mProduct.equals(""))) {
        }
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
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
        ReportRefundInvoiceCustomerDimensionalAnalysesData objectReportRefundInvoiceCustomerDimensionalAnalysesData = new ReportRefundInvoiceCustomerDimensionalAnalysesData();
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.nivel6 = UtilSql.getValue(result, "nivel6");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.refundamt = UtilSql.getValue(result, "refundamt");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.ratio = UtilSql.getValue(result, "ratio");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.refundqty = UtilSql.getValue(result, "refundqty");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.linenetref = UtilSql.getValue(result, "linenetref");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.refundamtref = UtilSql.getValue(result, "refundamtref");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.qtyinvoicedref = UtilSql.getValue(result, "qtyinvoicedref");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.refundqtyref = UtilSql.getValue(result, "refundqtyref");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.name = UtilSql.getValue(result, "name");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportRefundInvoiceCustomerDimensionalAnalysesData);
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
    ReportRefundInvoiceCustomerDimensionalAnalysesData objectReportRefundInvoiceCustomerDimensionalAnalysesData[] = new ReportRefundInvoiceCustomerDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportRefundInvoiceCustomerDimensionalAnalysesData);
    return(objectReportRefundInvoiceCustomerDimensionalAnalysesData);
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

  public static ReportRefundInvoiceCustomerDimensionalAnalysesData[] selectNotShown(ConnectionProvider connectionProvider, String notShown)    throws ServletException {
    return selectNotShown(connectionProvider, notShown, 0, 0);
  }

  public static ReportRefundInvoiceCustomerDimensionalAnalysesData[] selectNotShown(ConnectionProvider connectionProvider, String notShown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, NAME " +
      "              FROM AD_REF_LIST " +
      "             WHERE AD_REFERENCE_ID = '800087'" +
      "             AND AD_REF_LIST.VALUE IN ('1', '2', '3', '4', '5', '6')" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((notShown==null || notShown.equals(""))?"":" AND ID NOT IN" + notShown);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
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
        ReportRefundInvoiceCustomerDimensionalAnalysesData objectReportRefundInvoiceCustomerDimensionalAnalysesData = new ReportRefundInvoiceCustomerDimensionalAnalysesData();
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.name = UtilSql.getValue(result, "name");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportRefundInvoiceCustomerDimensionalAnalysesData);
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
    ReportRefundInvoiceCustomerDimensionalAnalysesData objectReportRefundInvoiceCustomerDimensionalAnalysesData[] = new ReportRefundInvoiceCustomerDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportRefundInvoiceCustomerDimensionalAnalysesData);
    return(objectReportRefundInvoiceCustomerDimensionalAnalysesData);
  }

  public static ReportRefundInvoiceCustomerDimensionalAnalysesData[] selectShown(ConnectionProvider connectionProvider, String shown)    throws ServletException {
    return selectShown(connectionProvider, shown, 0, 0);
  }

  public static ReportRefundInvoiceCustomerDimensionalAnalysesData[] selectShown(ConnectionProvider connectionProvider, String shown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, NAME " +
      "              FROM AD_REF_LIST " +
      "             WHERE AD_REFERENCE_ID = '800087' " +
      "             AND AD_REF_LIST.VALUE IN ('1', '2', '3', '4', '5', '6')" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((shown==null || shown.equals(""))?"":" AND ID IN" + shown);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
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
        ReportRefundInvoiceCustomerDimensionalAnalysesData objectReportRefundInvoiceCustomerDimensionalAnalysesData = new ReportRefundInvoiceCustomerDimensionalAnalysesData();
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.name = UtilSql.getValue(result, "name");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportRefundInvoiceCustomerDimensionalAnalysesData);
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
    ReportRefundInvoiceCustomerDimensionalAnalysesData objectReportRefundInvoiceCustomerDimensionalAnalysesData[] = new ReportRefundInvoiceCustomerDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportRefundInvoiceCustomerDimensionalAnalysesData);
    return(objectReportRefundInvoiceCustomerDimensionalAnalysesData);
  }

  public static ReportRefundInvoiceCustomerDimensionalAnalysesData[] selectNotShownTrl(ConnectionProvider connectionProvider, String lang, String notShown)    throws ServletException {
    return selectNotShownTrl(connectionProvider, lang, notShown, 0, 0);
  }

  public static ReportRefundInvoiceCustomerDimensionalAnalysesData[] selectNotShownTrl(ConnectionProvider connectionProvider, String lang, String notShown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, T.NAME " +
      "              FROM AD_REF_LIST_trl T," +
      "                   AD_REF_LIST     L" +
      "             WHERE l.AD_REFERENCE_ID = '800087'" +
      "               AND l.AD_REF_LIST_ID  = t.AD_REF_LIST_ID" +
      "               AND L.VALUE IN ('1', '2', '3', '4', '5', '6')" +
      "               AND t.AD_LANGUAGE = ?" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
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
        ReportRefundInvoiceCustomerDimensionalAnalysesData objectReportRefundInvoiceCustomerDimensionalAnalysesData = new ReportRefundInvoiceCustomerDimensionalAnalysesData();
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.name = UtilSql.getValue(result, "name");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportRefundInvoiceCustomerDimensionalAnalysesData);
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
    ReportRefundInvoiceCustomerDimensionalAnalysesData objectReportRefundInvoiceCustomerDimensionalAnalysesData[] = new ReportRefundInvoiceCustomerDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportRefundInvoiceCustomerDimensionalAnalysesData);
    return(objectReportRefundInvoiceCustomerDimensionalAnalysesData);
  }

  public static ReportRefundInvoiceCustomerDimensionalAnalysesData[] selectShownTrl(ConnectionProvider connectionProvider, String lang, String shown)    throws ServletException {
    return selectShownTrl(connectionProvider, lang, shown, 0, 0);
  }

  public static ReportRefundInvoiceCustomerDimensionalAnalysesData[] selectShownTrl(ConnectionProvider connectionProvider, String lang, String shown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, T.NAME " +
      "              FROM AD_REF_LIST_trl T," +
      "                   AD_REF_LIST     L" +
      "             WHERE l.AD_REFERENCE_ID = '800087'" +
      "               AND l.AD_REF_LIST_ID  = t.AD_REF_LIST_ID" +
      "               AND L.VALUE IN ('1', '2', '3', '4', '5', '6')" +
      "               AND t.AD_LANGUAGE = ?" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
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
        ReportRefundInvoiceCustomerDimensionalAnalysesData objectReportRefundInvoiceCustomerDimensionalAnalysesData = new ReportRefundInvoiceCustomerDimensionalAnalysesData();
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.name = UtilSql.getValue(result, "name");
        objectReportRefundInvoiceCustomerDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportRefundInvoiceCustomerDimensionalAnalysesData);
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
    ReportRefundInvoiceCustomerDimensionalAnalysesData objectReportRefundInvoiceCustomerDimensionalAnalysesData[] = new ReportRefundInvoiceCustomerDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportRefundInvoiceCustomerDimensionalAnalysesData);
    return(objectReportRefundInvoiceCustomerDimensionalAnalysesData);
  }
}
