//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class DocLineInvoiceData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineInvoiceData.class);
  private String InitRecordNumber="0";
  public String cInvoicelineId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String cInvoiceId;
  public String cOrderlineId;
  public String mInoutlineId;
  public String line;
  public String description;
  public String mProductId;
  public String qtyinvoiced;
  public String pricelist;
  public String priceactual;
  public String pricelimit;
  public String linenetamt;
  public String cChargeId;
  public String chargeamt;
  public String cUomId;
  public String cTaxId;
  public String sResourceassignmentId;
  public String taxamt;
  public String mAttributesetinstanceId;
  public String isdescription;
  public String quantityorder;
  public String mProductUomId;
  public String cCampaignId;
  public String cProjectId;
  public String user1Id;
  public String user2Id;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_invoiceline_id") || fieldName.equals("cInvoicelineId"))
      return cInvoicelineId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("m_inoutline_id") || fieldName.equals("mInoutlineId"))
      return mInoutlineId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("qtyinvoiced"))
      return qtyinvoiced;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("s_resourceassignment_id") || fieldName.equals("sResourceassignmentId"))
      return sResourceassignmentId;
    else if (fieldName.equalsIgnoreCase("taxamt"))
      return taxamt;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("isdescription"))
      return isdescription;
    else if (fieldName.equalsIgnoreCase("quantityorder"))
      return quantityorder;
    else if (fieldName.equalsIgnoreCase("m_product_uom_id") || fieldName.equals("mProductUomId"))
      return mProductUomId;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineInvoiceData[] select(ConnectionProvider connectionProvider, String C_Invoice_ID)    throws ServletException {
    return select(connectionProvider, C_Invoice_ID, 0, 0);
  }

  public static DocLineInvoiceData[] select(ConnectionProvider connectionProvider, String C_Invoice_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_INVOICELINE.C_INVOICELINE_ID, C_INVOICELINE.AD_CLIENT_ID, COALESCE(C_INVOICELINE_ACCTDIMENSION.AD_ORG_ID,C_INVOICELINE.AD_ORG_ID) AS AD_ORG_ID," +
      "          C_INVOICELINE.ISACTIVE, C_INVOICELINE.C_INVOICE_ID, C_INVOICELINE.C_ORDERLINE_ID, C_INVOICELINE.M_INOUTLINE_ID," +
      "        C_INVOICELINE.LINE, C_INVOICELINE.DESCRIPTION, C_INVOICELINE.M_PRODUCT_ID, C_INVOICELINE.QTYINVOICED," +
      "        C_INVOICELINE.PRICELIST, C_INVOICELINE.PRICEACTUAL, C_INVOICELINE.PRICELIMIT," +
      "        COALESCE(C_INVOICELINE_ACCTDIMENSION.AMT, C_INVOICELINE.LINENETAMT) AS LINENETAMT," +
      "        C_INVOICELINE.C_CHARGE_ID, C_INVOICELINE.CHARGEAMT, C_INVOICELINE.C_UOM_ID, '' as C_TAX_ID," +
      "        C_INVOICELINE.S_RESOURCEASSIGNMENT_ID, C_INVOICELINE.TAXAMT, C_INVOICELINE.M_ATTRIBUTESETINSTANCE_ID," +
      "        C_INVOICELINE.ISDESCRIPTION, C_INVOICELINE.QUANTITYORDER, C_INVOICELINE.M_PRODUCT_UOM_ID," +
      "        C_INVOICELINE_ACCTDIMENSION.C_CAMPAIGN_ID, C_INVOICELINE_ACCTDIMENSION.C_PROJECT_ID," +
      "        C_INVOICELINE_ACCTDIMENSION.USER1_ID, C_INVOICELINE_ACCTDIMENSION.USER2_ID" +
      "        FROM C_INVOICELINE left join C_INVOICELINE_ACCTDIMENSION on C_INVOICELINE.C_INVOICELINE_ID = C_INVOICELINE_ACCTDIMENSION.C_INVOICELINE_ID" +
      "        WHERE C_INVOICE_ID = ?" +
      "        ORDER BY LINE";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Invoice_ID);

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
        DocLineInvoiceData objectDocLineInvoiceData = new DocLineInvoiceData();
        objectDocLineInvoiceData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectDocLineInvoiceData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocLineInvoiceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineInvoiceData.isactive = UtilSql.getValue(result, "isactive");
        objectDocLineInvoiceData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectDocLineInvoiceData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectDocLineInvoiceData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectDocLineInvoiceData.line = UtilSql.getValue(result, "line");
        objectDocLineInvoiceData.description = UtilSql.getValue(result, "description");
        objectDocLineInvoiceData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocLineInvoiceData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectDocLineInvoiceData.pricelist = UtilSql.getValue(result, "pricelist");
        objectDocLineInvoiceData.priceactual = UtilSql.getValue(result, "priceactual");
        objectDocLineInvoiceData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectDocLineInvoiceData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectDocLineInvoiceData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectDocLineInvoiceData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectDocLineInvoiceData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectDocLineInvoiceData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectDocLineInvoiceData.sResourceassignmentId = UtilSql.getValue(result, "s_resourceassignment_id");
        objectDocLineInvoiceData.taxamt = UtilSql.getValue(result, "taxamt");
        objectDocLineInvoiceData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectDocLineInvoiceData.isdescription = UtilSql.getValue(result, "isdescription");
        objectDocLineInvoiceData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectDocLineInvoiceData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectDocLineInvoiceData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocLineInvoiceData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocLineInvoiceData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocLineInvoiceData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocLineInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineInvoiceData);
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
    DocLineInvoiceData objectDocLineInvoiceData[] = new DocLineInvoiceData[vector.size()];
    vector.copyInto(objectDocLineInvoiceData);
    return(objectDocLineInvoiceData);
  }

  public static DocLineInvoiceData[] selectTotal(ConnectionProvider connectionProvider, String C_Invoice_ID)    throws ServletException {
    return selectTotal(connectionProvider, C_Invoice_ID, 0, 0);
  }

  public static DocLineInvoiceData[] selectTotal(ConnectionProvider connectionProvider, String C_Invoice_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C_INVOICELINE.C_INVOICELINE_ID) AS C_INVOICELINE_ID, C_INVOICELINE.AD_CLIENT_ID," +
      "        C_INVOICELINE.AD_ORG_ID, C_INVOICELINE.ISACTIVE, C_INVOICELINE.C_INVOICE_ID," +
      "        MAX(C_INVOICELINE.C_ORDERLINE_ID) AS C_ORDERLINE_ID, MAX(C_INVOICELINE.M_INOUTLINE_ID) AS M_INOUTLINE_ID," +
      "        MAX(C_INVOICELINE.LINE) AS LINE, MAX(C_INVOICELINE.DESCRIPTION) AS DESCRIPTION, C_INVOICELINE.M_PRODUCT_ID," +
      "        SUM(C_INVOICELINE.QTYINVOICED) AS QTYINVOICED, C_INVOICELINE.PRICELIST, C_INVOICELINE.PRICEACTUAL," +
      "        C_INVOICELINE.PRICELIMIT, SUM(COALESCE(C_INVOICELINE_ACCTDIMENSION.AMT, C_INVOICELINE.LINENETAMT)) AS LINENETAMT, MAX(C_INVOICELINE.C_CHARGE_ID) AS C_CHARGE_ID," +
      "        SUM(C_INVOICELINE.CHARGEAMT) AS CHARGEAMT, C_INVOICELINE.C_UOM_ID, '' as C_TAX_ID," +
      "        C_INVOICELINE.S_RESOURCEASSIGNMENT_ID, SUM(C_INVOICELINE.TAXAMT) AS TAXAMT," +
      "        C_INVOICELINE.M_ATTRIBUTESETINSTANCE_ID," +
      "        C_INVOICELINE.ISDESCRIPTION, SUM(C_INVOICELINE.QUANTITYORDER) AS QUANTITYORDER, C_INVOICELINE.M_PRODUCT_UOM_ID," +
      "        C_INVOICELINE_ACCTDIMENSION.C_CAMPAIGN_ID, C_INVOICELINE_ACCTDIMENSION.C_PROJECT_ID," +
      "        C_INVOICELINE_ACCTDIMENSION.USER1_ID, C_INVOICELINE_ACCTDIMENSION.USER2_ID" +
      "        FROM C_INVOICELINE left join C_INVOICELINE_ACCTDIMENSION on C_INVOICELINE.C_INVOICELINE_ID = C_INVOICELINE_ACCTDIMENSION.C_INVOICELINE_ID" +
      "        WHERE  C_INVOICELINE.C_INVOICE_ID = ?" +
      "        GROUP BY C_INVOICELINE.AD_CLIENT_ID, C_INVOICELINE.AD_ORG_ID, C_INVOICELINE.ISACTIVE, C_INVOICELINE.C_INVOICE_ID," +
      "        C_INVOICELINE.M_PRODUCT_ID,C_INVOICELINE.PRICELIST, C_INVOICELINE.PRICEACTUAL, C_INVOICELINE.PRICELIMIT," +
      "        C_INVOICELINE.C_UOM_ID, C_INVOICELINE.C_TAX_ID, C_INVOICELINE.S_RESOURCEASSIGNMENT_ID," +
      "        C_INVOICELINE.M_ATTRIBUTESETINSTANCE_ID,C_INVOICELINE.ISDESCRIPTION, C_INVOICELINE.M_PRODUCT_UOM_ID," +
      "        C_INVOICELINE_ACCTDIMENSION.C_CAMPAIGN_ID, C_INVOICELINE_ACCTDIMENSION.C_PROJECT_ID," +
      "        C_INVOICELINE_ACCTDIMENSION.USER1_ID, C_INVOICELINE_ACCTDIMENSION.USER2_ID" +
      "        ORDER BY LINE";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Invoice_ID);

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
        DocLineInvoiceData objectDocLineInvoiceData = new DocLineInvoiceData();
        objectDocLineInvoiceData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectDocLineInvoiceData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocLineInvoiceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineInvoiceData.isactive = UtilSql.getValue(result, "isactive");
        objectDocLineInvoiceData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectDocLineInvoiceData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectDocLineInvoiceData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectDocLineInvoiceData.line = UtilSql.getValue(result, "line");
        objectDocLineInvoiceData.description = UtilSql.getValue(result, "description");
        objectDocLineInvoiceData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocLineInvoiceData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectDocLineInvoiceData.pricelist = UtilSql.getValue(result, "pricelist");
        objectDocLineInvoiceData.priceactual = UtilSql.getValue(result, "priceactual");
        objectDocLineInvoiceData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectDocLineInvoiceData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectDocLineInvoiceData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectDocLineInvoiceData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectDocLineInvoiceData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectDocLineInvoiceData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectDocLineInvoiceData.sResourceassignmentId = UtilSql.getValue(result, "s_resourceassignment_id");
        objectDocLineInvoiceData.taxamt = UtilSql.getValue(result, "taxamt");
        objectDocLineInvoiceData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectDocLineInvoiceData.isdescription = UtilSql.getValue(result, "isdescription");
        objectDocLineInvoiceData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectDocLineInvoiceData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectDocLineInvoiceData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocLineInvoiceData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocLineInvoiceData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocLineInvoiceData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocLineInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineInvoiceData);
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
    DocLineInvoiceData objectDocLineInvoiceData[] = new DocLineInvoiceData[vector.size()];
    vector.copyInto(objectDocLineInvoiceData);
    return(objectDocLineInvoiceData);
  }

  public static String isGrossInvoice(ConnectionProvider connectionProvider, String C_Invoice_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT isgrossinvoice from c_invoice where c_invoice_id =? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Invoice_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "isgrossinvoice");
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

  public static DocLineInvoiceData[] selectGross(ConnectionProvider connectionProvider, String C_Invoice_ID)    throws ServletException {
    return selectGross(connectionProvider, C_Invoice_ID, 0, 0);
  }

  public static DocLineInvoiceData[] selectGross(ConnectionProvider connectionProvider, String C_Invoice_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_invoicetax.c_invoicetax_id as C_INVOICELINE_ID, c_invoicetax.AD_CLIENT_ID,c_invoicetax.AD_ORG_ID," +
      "          c_invoicetax.ISACTIVE, c_invoicetax.C_INVOICE_ID, '' as M_INOUTLINE_ID," +
      "        c_invoicetax.LINE, '' as DESCRIPTION, '' as M_PRODUCT_ID, 0 as QTYINVOICED,C_TAX_ID," +
      "        0 as PRICELIST, 0 as PRICEACTUAL, 0 as PRICELIMIT," +
      "        c_invoicetax.taxbaseamt AS LINENETAMT," +
      "        'N' as ISDESCRIPTION" +
      "        FROM C_INVOICEtax" +
      "        WHERE C_INVOICE_ID = ?" +
      "        ORDER BY LINE";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Invoice_ID);

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
        DocLineInvoiceData objectDocLineInvoiceData = new DocLineInvoiceData();
        objectDocLineInvoiceData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectDocLineInvoiceData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocLineInvoiceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineInvoiceData.isactive = UtilSql.getValue(result, "isactive");
        objectDocLineInvoiceData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectDocLineInvoiceData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectDocLineInvoiceData.line = UtilSql.getValue(result, "line");
        objectDocLineInvoiceData.description = UtilSql.getValue(result, "description");
        objectDocLineInvoiceData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocLineInvoiceData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectDocLineInvoiceData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectDocLineInvoiceData.pricelist = UtilSql.getValue(result, "pricelist");
        objectDocLineInvoiceData.priceactual = UtilSql.getValue(result, "priceactual");
        objectDocLineInvoiceData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectDocLineInvoiceData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectDocLineInvoiceData.isdescription = UtilSql.getValue(result, "isdescription");
        objectDocLineInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineInvoiceData);
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
    DocLineInvoiceData objectDocLineInvoiceData[] = new DocLineInvoiceData[vector.size()];
    vector.copyInto(objectDocLineInvoiceData);
    return(objectDocLineInvoiceData);
  }

  public static String getPAccountFromTax(ConnectionProvider connectionProvider, String C_tax_ID, String Org_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zsfi_GetPAccountFromTax('1',?,?) ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_tax_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Org_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zsfi_getpaccountfromtax");
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

  public static String getPExpenseAccountFromTaxandFirstProduct(ConnectionProvider connectionProvider, String C_invoice_ID, String C_tax_ID, String Org_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zsfi_GetPExpenseAccountFromInvTaxandFirstProduct(?,?,?) ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_invoice_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_tax_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Org_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zsfi_getpexpenseaccountfrominvtaxandfirstproduct");
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
