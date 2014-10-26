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

class InvoiceVendorMultilineLinesData implements FieldProvider {
static Logger log4j = Logger.getLogger(InvoiceVendorMultilineLinesData.class);
  private String InitRecordNumber="0";
  public String cInvoicelineId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
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
  public String cInvoiceDiscountId;
  public String mProductIdD;
  public String pricestd;
  public String mOfferId;

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
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
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
    else if (fieldName.equalsIgnoreCase("c_invoice_discount_id") || fieldName.equals("cInvoiceDiscountId"))
      return cInvoiceDiscountId;
    else if (fieldName.equalsIgnoreCase("m_product_id_d") || fieldName.equals("mProductIdD"))
      return mProductIdD;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("m_offer_id") || fieldName.equals("mOfferId"))
      return mOfferId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static InvoiceVendorMultilineLinesData[] select(ConnectionProvider connectionProvider, String adLanguage, String cInvoiceId)    throws ServletException {
    return select(connectionProvider, adLanguage, cInvoiceId, 0, 0);
  }

  public static InvoiceVendorMultilineLinesData[] select(ConnectionProvider connectionProvider, String adLanguage, String cInvoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_INVOICELINE_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, C_INVOICE_ID, C_ORDERLINE_ID, M_INOUTLINE_ID, LINE, DESCRIPTION, M_PRODUCT_ID, QTYINVOICED, PRICELIST, PRICEACTUAL, PRICELIMIT, LINENETAMT, C_CHARGE_ID, CHARGEAMT, C_UOM_ID, C_TAX_ID, S_RESOURCEASSIGNMENT_ID, TAXAMT, M_ATTRIBUTESETINSTANCE_ID, ISDESCRIPTION, QUANTITYORDER, M_PRODUCT_UOM_ID, '' as C_INVOICE_DISCOUNT_ID, " +
      "      AD_COLUMN_IDENTIFIER(TO_CHAR('M_Product'), TO_CHAR(M_PRODUCT_ID), TO_CHAR(?)) AS M_PRODUCT_ID_D, PRICESTD, M_OFFER_ID " +
      "      FROM C_INVOICELINE " +
      "      WHERE C_INVOICE_ID = ? " +
      "      ORDER BY LINE";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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
        InvoiceVendorMultilineLinesData objectInvoiceVendorMultilineLinesData = new InvoiceVendorMultilineLinesData();
        objectInvoiceVendorMultilineLinesData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectInvoiceVendorMultilineLinesData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectInvoiceVendorMultilineLinesData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectInvoiceVendorMultilineLinesData.isactive = UtilSql.getValue(result, "isactive");
        objectInvoiceVendorMultilineLinesData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectInvoiceVendorMultilineLinesData.createdby = UtilSql.getValue(result, "createdby");
        objectInvoiceVendorMultilineLinesData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectInvoiceVendorMultilineLinesData.updatedby = UtilSql.getValue(result, "updatedby");
        objectInvoiceVendorMultilineLinesData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectInvoiceVendorMultilineLinesData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectInvoiceVendorMultilineLinesData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectInvoiceVendorMultilineLinesData.line = UtilSql.getValue(result, "line");
        objectInvoiceVendorMultilineLinesData.description = UtilSql.getValue(result, "description");
        objectInvoiceVendorMultilineLinesData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectInvoiceVendorMultilineLinesData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectInvoiceVendorMultilineLinesData.pricelist = UtilSql.getValue(result, "pricelist");
        objectInvoiceVendorMultilineLinesData.priceactual = UtilSql.getValue(result, "priceactual");
        objectInvoiceVendorMultilineLinesData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectInvoiceVendorMultilineLinesData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectInvoiceVendorMultilineLinesData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectInvoiceVendorMultilineLinesData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectInvoiceVendorMultilineLinesData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectInvoiceVendorMultilineLinesData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectInvoiceVendorMultilineLinesData.sResourceassignmentId = UtilSql.getValue(result, "s_resourceassignment_id");
        objectInvoiceVendorMultilineLinesData.taxamt = UtilSql.getValue(result, "taxamt");
        objectInvoiceVendorMultilineLinesData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectInvoiceVendorMultilineLinesData.isdescription = UtilSql.getValue(result, "isdescription");
        objectInvoiceVendorMultilineLinesData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectInvoiceVendorMultilineLinesData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectInvoiceVendorMultilineLinesData.cInvoiceDiscountId = UtilSql.getValue(result, "c_invoice_discount_id");
        objectInvoiceVendorMultilineLinesData.mProductIdD = UtilSql.getValue(result, "m_product_id_d");
        objectInvoiceVendorMultilineLinesData.pricestd = UtilSql.getValue(result, "pricestd");
        objectInvoiceVendorMultilineLinesData.mOfferId = UtilSql.getValue(result, "m_offer_id");
        objectInvoiceVendorMultilineLinesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInvoiceVendorMultilineLinesData);
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
    InvoiceVendorMultilineLinesData objectInvoiceVendorMultilineLinesData[] = new InvoiceVendorMultilineLinesData[vector.size()];
    vector.copyInto(objectInvoiceVendorMultilineLinesData);
    return(objectInvoiceVendorMultilineLinesData);
  }

  public static InvoiceVendorMultilineLinesData[] set(String line)    throws ServletException {
    InvoiceVendorMultilineLinesData objectInvoiceVendorMultilineLinesData[] = new InvoiceVendorMultilineLinesData[1];
    objectInvoiceVendorMultilineLinesData[0] = new InvoiceVendorMultilineLinesData();
    objectInvoiceVendorMultilineLinesData[0].cInvoicelineId = "";
    objectInvoiceVendorMultilineLinesData[0].adClientId = "";
    objectInvoiceVendorMultilineLinesData[0].adOrgId = "";
    objectInvoiceVendorMultilineLinesData[0].isactive = "";
    objectInvoiceVendorMultilineLinesData[0].created = "";
    objectInvoiceVendorMultilineLinesData[0].createdby = "";
    objectInvoiceVendorMultilineLinesData[0].updated = "";
    objectInvoiceVendorMultilineLinesData[0].updatedby = "";
    objectInvoiceVendorMultilineLinesData[0].cInvoiceId = "";
    objectInvoiceVendorMultilineLinesData[0].cOrderlineId = "";
    objectInvoiceVendorMultilineLinesData[0].mInoutlineId = "";
    objectInvoiceVendorMultilineLinesData[0].line = line;
    objectInvoiceVendorMultilineLinesData[0].description = "";
    objectInvoiceVendorMultilineLinesData[0].mProductId = "";
    objectInvoiceVendorMultilineLinesData[0].qtyinvoiced = "";
    objectInvoiceVendorMultilineLinesData[0].pricelist = "";
    objectInvoiceVendorMultilineLinesData[0].priceactual = "";
    objectInvoiceVendorMultilineLinesData[0].pricelimit = "";
    objectInvoiceVendorMultilineLinesData[0].linenetamt = "";
    objectInvoiceVendorMultilineLinesData[0].cChargeId = "";
    objectInvoiceVendorMultilineLinesData[0].chargeamt = "";
    objectInvoiceVendorMultilineLinesData[0].cUomId = "";
    objectInvoiceVendorMultilineLinesData[0].cTaxId = "";
    objectInvoiceVendorMultilineLinesData[0].sResourceassignmentId = "";
    objectInvoiceVendorMultilineLinesData[0].taxamt = "";
    objectInvoiceVendorMultilineLinesData[0].mAttributesetinstanceId = "";
    objectInvoiceVendorMultilineLinesData[0].isdescription = "";
    objectInvoiceVendorMultilineLinesData[0].quantityorder = "";
    objectInvoiceVendorMultilineLinesData[0].mProductUomId = "";
    objectInvoiceVendorMultilineLinesData[0].cInvoiceDiscountId = "";
    objectInvoiceVendorMultilineLinesData[0].mProductIdD = "";
    objectInvoiceVendorMultilineLinesData[0].pricestd = "";
    objectInvoiceVendorMultilineLinesData[0].mOfferId = "";
    return objectInvoiceVendorMultilineLinesData;
  }

  public static String selectLineNo(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT LINE AS TOTAL" +
      "      FROM C_INVOICELINE " +
      "      WHERE C_INVOICELINE_ID = ? ";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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

  public static String selectNextLine(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COALESCE(MAX(LINE), 0) + 10 AS TOTAL" +
      "      FROM C_INVOICELINE " +
      "      WHERE C_INVOICE_ID = ? ";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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

  public static String selectUOM(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_UOM_ID AS TOTAL" +
      "      FROM M_PRODUCT " +
      "      WHERE M_PRODUCT_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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

  public int update(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_INVOICELINE SET UPDATEDBY = ?, UPDATED = now(), M_PRODUCT_ID = ?, QTYINVOICED = TO_NUMBER(?), C_TAX_ID = ?, " +
      "        DESCRIPTION = ?, PRICELIST = TO_NUMBER(?), PRICEACTUAL = TO_NUMBER(?), PRICELIMIT = TO_NUMBER(?), LINENETAMT = (TO_NUMBER(?)*TO_NUMBER(?)), " +
      "        C_CHARGE_ID = ?, CHARGEAMT = TO_NUMBER(?), C_UOM_ID = ?, S_RESOURCEASSIGNMENT_ID = ?, TAXAMT = TO_NUMBER(?), " +
      "        M_ATTRIBUTESETINSTANCE_ID = ?, ISDESCRIPTION = ?, QUANTITYORDER = TO_NUMBER(?), M_PRODUCT_UOM_ID = ?, C_INVOICE_DISCOUNT_ID = ?, " +
      "        PRICESTD = TO_NUMBER(?)" +
      "        WHERE C_INVOICELINE_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceassignmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceDiscountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricestd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);

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

  public int insert(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_INVOICELINE (" +
      "    C_INVOICELINE_ID, AD_CLIENT_ID, AD_ORG_ID, " +
      "    ISACTIVE, CREATED, CREATEDBY, " +
      "    UPDATED, UPDATEDBY, C_INVOICE_ID, " +
      "    C_ORDERLINE_ID, M_INOUTLINE_ID, LINE, " +
      "    DESCRIPTION, M_PRODUCT_ID, QTYINVOICED, " +
      "    PRICELIST, PRICEACTUAL, PRICELIMIT, " +
      "    LINENETAMT, C_CHARGE_ID, CHARGEAMT, " +
      "    C_UOM_ID, C_TAX_ID, S_RESOURCEASSIGNMENT_ID, " +
      "    TAXAMT, M_ATTRIBUTESETINSTANCE_ID, " +
      "    ISDESCRIPTION, QUANTITYORDER, M_PRODUCT_UOM_ID, " +
      "    C_INVOICE_DISCOUNT_ID, PRICESTD) " +
      "    VALUES ( ?, ?, ?, " +
      "    'Y', now(), ?, " +
      "    now(), ?, ?, " +
      "    ?, ?, (SELECT COALESCE(MAX(LINE), 0) +10 FROM C_INVOICELINE WHERE C_INVOICE_ID=?), " +
      "    ?, ?, TO_NUMBER(?), " +
      "    TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), " +
      "    (TO_NUMBER(?)*TO_NUMBER(?)), ?, TO_NUMBER(?), " +
      "    ?, ?, ?, " +
      "    TO_NUMBER(?), ?, ?, " +
      "    ?, ?, ?, " +
      "    ?, TO_NUMBER(?))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceassignmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceDiscountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricestd);

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

  public int delete(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_INVOICELINE " +
      "        WHERE C_INVOICELINE_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);

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
}
