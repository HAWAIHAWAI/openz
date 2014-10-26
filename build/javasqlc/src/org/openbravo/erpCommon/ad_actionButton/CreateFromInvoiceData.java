//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class CreateFromInvoiceData implements FieldProvider {
static Logger log4j = Logger.getLogger(CreateFromInvoiceData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;
  public String nameorder;
  public String nameshipment;
  public String qty;
  public String cUomId;
  public String uomsymbol;
  public String mProductId;
  public String relationName;
  public String cOrderlineId;
  public String line;
  public String adOrgId;
  public String stdprecision;
  public String mInoutlineId;
  public String priceactual;
  public String pricelist;
  public String pricelimit;
  public String description;
  public String pricestd;
  public String quantityorder;
  public String mProductUomId;
  public String mAttributesetinstanceId;
  public String mOfferId;
  public String priceprecision;
  public String cProjectId;
  public String aAssetId;
  public String linenetamt;
  public String linegrossamt;
  public String cTaxId;
  public String minoutdoctypeid;
  public String cProjecttaskId;
  public String pendingqty;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("nameorder"))
      return nameorder;
    else if (fieldName.equalsIgnoreCase("nameshipment"))
      return nameshipment;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("uomsymbol"))
      return uomsymbol;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("relation_name") || fieldName.equals("relationName"))
      return relationName;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("stdprecision"))
      return stdprecision;
    else if (fieldName.equalsIgnoreCase("m_inoutline_id") || fieldName.equals("mInoutlineId"))
      return mInoutlineId;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("quantityorder"))
      return quantityorder;
    else if (fieldName.equalsIgnoreCase("m_product_uom_id") || fieldName.equals("mProductUomId"))
      return mProductUomId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("m_offer_id") || fieldName.equals("mOfferId"))
      return mOfferId;
    else if (fieldName.equalsIgnoreCase("priceprecision"))
      return priceprecision;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("linegrossamt"))
      return linegrossamt;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("minoutdoctypeid"))
      return minoutdoctypeid;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("pendingqty"))
      return pendingqty;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CreateFromInvoiceData[] selectFromPO(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId)    throws ServletException {
    return selectFromPO(connectionProvider, language, adUserClient, adOrgClient, poId, 0, 0);
  }

  public static CreateFromInvoiceData[] selectFromPO(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT o.C_ORDER_ID as ID, Ad_Column_Identifier(to_char('C_Order'), to_char(o.c_order_id), to_char(?)) AS NAME, o.DocumentNo AS NAMEORDER," +
      "        '' AS NAMESHIPMENT," +
      "        l.QtyOrdered-SUM(COALESCE(m.Qty,0)) AS QTY, l.C_UOM_ID,uom.UOMSymbol, l.M_Product_ID,p.NAME AS RELATION_NAME, " +
      "        l.C_OrderLine_ID,l.Line, l.ad_org_id, '' as STDPRECISION, " +
      "        '' as M_InOutLine_ID, '' AS PriceActual, '' AS PriceList, '' AS PriceLimit, '' AS Description, '' as PriceStd," +
      "        '' AS QUANTITYORDER, '' AS M_Product_UOM_ID, '' AS M_ATTRIBUTESETINSTANCE_ID, '' AS M_Offer_ID, '' AS PricePrecision," +
      "        '' AS C_PROJECT_ID, '' as A_ASSET_ID, '' as linenetamt,'' as linegrossamt," +
      "        '' as c_tax_id,'' as mInoutDoctypeId, '' as c_projecttask_id,'' as pendingqty" +
      "        FROM C_ORDERLINE l left join M_MATCHPO m on  l.C_OrderLine_ID=m.C_OrderLine_ID" +
      "                                                 AND m.C_InvoiceLine_ID IS NOT NULL, " +
      "        C_ORDER o, C_UOM uom,  M_PRODUCT p" +
      "        WHERE o.C_ORDER_ID = l.C_ORDER_ID " +
      "        AND o.IsSOTrx='N' " +
      "        AND o.DocStatus IN ('CL','CO') " +
      "        AND o.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND o.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.C_UOM_ID=uom.C_UOM_ID" +
      "        AND l.M_Product_ID=p.M_Product_ID" +
      "        AND l.C_Order_ID = ? " +
      "        GROUP BY o.C_ORDER_ID, o.DocumentNo, o.DateOrdered, o.GrandTotal, l.QtyOrdered,l.C_UOM_ID," +
      "        uom.UOMSymbol,l.M_Product_ID,p.NAME,l.Line,l.C_OrderLine_ID, l.ad_org_id" +
      "        HAVING (l.QtyOrdered-SUM(COALESCE(m.Qty,0))) <> 0" +
      "        ORDER BY NAME, l.Line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poId);

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
        CreateFromInvoiceData objectCreateFromInvoiceData = new CreateFromInvoiceData();
        objectCreateFromInvoiceData.id = UtilSql.getValue(result, "id");
        objectCreateFromInvoiceData.name = UtilSql.getValue(result, "name");
        objectCreateFromInvoiceData.nameorder = UtilSql.getValue(result, "nameorder");
        objectCreateFromInvoiceData.nameshipment = UtilSql.getValue(result, "nameshipment");
        objectCreateFromInvoiceData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromInvoiceData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromInvoiceData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromInvoiceData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromInvoiceData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromInvoiceData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromInvoiceData.line = UtilSql.getValue(result, "line");
        objectCreateFromInvoiceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCreateFromInvoiceData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectCreateFromInvoiceData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectCreateFromInvoiceData.priceactual = UtilSql.getValue(result, "priceactual");
        objectCreateFromInvoiceData.pricelist = UtilSql.getValue(result, "pricelist");
        objectCreateFromInvoiceData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectCreateFromInvoiceData.description = UtilSql.getValue(result, "description");
        objectCreateFromInvoiceData.pricestd = UtilSql.getValue(result, "pricestd");
        objectCreateFromInvoiceData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectCreateFromInvoiceData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectCreateFromInvoiceData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCreateFromInvoiceData.mOfferId = UtilSql.getValue(result, "m_offer_id");
        objectCreateFromInvoiceData.priceprecision = UtilSql.getValue(result, "priceprecision");
        objectCreateFromInvoiceData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCreateFromInvoiceData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectCreateFromInvoiceData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectCreateFromInvoiceData.linegrossamt = UtilSql.getValue(result, "linegrossamt");
        objectCreateFromInvoiceData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectCreateFromInvoiceData.minoutdoctypeid = UtilSql.getValue(result, "minoutdoctypeid");
        objectCreateFromInvoiceData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectCreateFromInvoiceData.pendingqty = UtilSql.getValue(result, "pendingqty");
        objectCreateFromInvoiceData.rownum = Long.toString(countRecord);
        objectCreateFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromInvoiceData);
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
    CreateFromInvoiceData objectCreateFromInvoiceData[] = new CreateFromInvoiceData[vector.size()];
    vector.copyInto(objectCreateFromInvoiceData);
    return(objectCreateFromInvoiceData);
  }

  public static CreateFromInvoiceData[] selectFromPOSOTrx(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId)    throws ServletException {
    return selectFromPOSOTrx(connectionProvider, language, adUserClient, adOrgClient, poId, 0, 0);
  }

  public static CreateFromInvoiceData[] selectFromPOSOTrx(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT o.C_ORDER_ID as ID, Ad_Column_Identifier(to_char('C_Order'), to_char(o.c_order_id), to_char(?)) AS NAME,o.DocumentNo AS NAMEORDER," +
      "        ic.pendingqty AS QTY, l.C_UOM_ID,uom.UOMSymbol, l.M_Product_ID,p.NAME AS RELATION_NAME, " +
      "        l.C_OrderLine_ID,l.Line, l.ad_Org_id,l.linenetamt,l.linegrossamt,l.description" +
      "        FROM C_INVOICE_CANDIDATE_V ic, C_UOM uom, C_ORDER o, C_ORDERLINE l, M_PRODUCT p " +
      "        WHERE l.C_UOM_ID=uom.C_UOM_ID" +
      "        AND o.C_ORDER_ID = ic.C_ORDER_ID " +
      "        AND o.C_ORDER_ID=l.C_ORDER_ID " +
      "        AND ic.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ic.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.M_Product_ID=p.M_Product_ID " +
      "        AND ic.C_Order_ID = ? " +
      "        GROUP BY o.C_ORDER_ID, o.DocumentNo, o.DateOrdered, o.GrandTotal, ic.pendingqty," +
      "        l.C_UOM_ID,uom.UOMSymbol,l.M_Product_ID,p.NAME,l.Line,l.C_OrderLine_ID, l.ad_org_id," +
      "        l.linenetamt,l.linegrossamt,l.description" +
      "        ORDER BY NAME, l.Line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poId);

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
        CreateFromInvoiceData objectCreateFromInvoiceData = new CreateFromInvoiceData();
        objectCreateFromInvoiceData.id = UtilSql.getValue(result, "id");
        objectCreateFromInvoiceData.name = UtilSql.getValue(result, "name");
        objectCreateFromInvoiceData.nameorder = UtilSql.getValue(result, "nameorder");
        objectCreateFromInvoiceData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromInvoiceData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromInvoiceData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromInvoiceData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromInvoiceData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromInvoiceData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromInvoiceData.line = UtilSql.getValue(result, "line");
        objectCreateFromInvoiceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCreateFromInvoiceData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectCreateFromInvoiceData.linegrossamt = UtilSql.getValue(result, "linegrossamt");
        objectCreateFromInvoiceData.description = UtilSql.getValue(result, "description");
        objectCreateFromInvoiceData.rownum = Long.toString(countRecord);
        objectCreateFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromInvoiceData);
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
    CreateFromInvoiceData objectCreateFromInvoiceData[] = new CreateFromInvoiceData[vector.size()];
    vector.copyInto(objectCreateFromInvoiceData);
    return(objectCreateFromInvoiceData);
  }

  public static CreateFromInvoiceData[] selectFromPOSOTrxCombo(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cBpartnerId, String isSotrx)    throws ServletException {
    return selectFromPOSOTrxCombo(connectionProvider, language, adUserClient, adOrgClient, cBpartnerId, isSotrx, 0, 0);
  }

  public static CreateFromInvoiceData[] selectFromPOSOTrxCombo(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cBpartnerId, String isSotrx, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ic.C_ORDER_ID as ID, Ad_Column_Identifier(to_char('C_Order'), to_char(ic.c_order_id), to_char(?)) AS NAME " +
      "        FROM C_INVOICE_CANDIDATE_V ic" +
      "        WHERE ic.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ic.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND ic.C_BPartner_ID = ? " +
      "        AND ic.issotrx = ?" +
      "        ORDER BY NAME";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isSotrx);

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
        CreateFromInvoiceData objectCreateFromInvoiceData = new CreateFromInvoiceData();
        objectCreateFromInvoiceData.id = UtilSql.getValue(result, "id");
        objectCreateFromInvoiceData.name = UtilSql.getValue(result, "name");
        objectCreateFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromInvoiceData);
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
    CreateFromInvoiceData objectCreateFromInvoiceData[] = new CreateFromInvoiceData[vector.size()];
    vector.copyInto(objectCreateFromInvoiceData);
    return(objectCreateFromInvoiceData);
  }

/**
Orders, that have Invoices (not Credit Memo)
 */
  public static CreateFromInvoiceData[] selectFromOrderCreditReturnCombo(ConnectionProvider connectionProvider, String language, String isSotrx, String adUserClient, String adOrgClient, String cBpartnerId)    throws ServletException {
    return selectFromOrderCreditReturnCombo(connectionProvider, language, isSotrx, adUserClient, adOrgClient, cBpartnerId, 0, 0);
  }

/**
Orders, that have Invoices (not Credit Memo)
 */
  public static CreateFromInvoiceData[] selectFromOrderCreditReturnCombo(ConnectionProvider connectionProvider, String language, String isSotrx, String adUserClient, String adOrgClient, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT o.C_ORDER_ID as ID, Ad_Column_Identifier(to_char('C_Order'), to_char(o.c_order_id), to_char(?)) AS NAME " +
      "        FROM  C_ORDER o , C_ORDERLINE ol" +
      "        WHERE o.c_order_id=ol.c_order_id " +
      "        AND o.DOCSTATUS='CO'" +
      "        AND o.issotrx= ?" +
      "        AND o.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND o.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND o.C_BPartner_ID = ? " +
      "        AND ol.qtydelivered<ol.qtyinvoiced" +
      "        AND ol.qtyinvoiced>0" +
      "        GROUP BY o.C_ORDER_ID, o.DocumentNo, o.DateOrdered, o.GrandTotal " +
      "        ORDER BY NAME";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isSotrx);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
        CreateFromInvoiceData objectCreateFromInvoiceData = new CreateFromInvoiceData();
        objectCreateFromInvoiceData.id = UtilSql.getValue(result, "id");
        objectCreateFromInvoiceData.name = UtilSql.getValue(result, "name");
        objectCreateFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromInvoiceData);
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
    CreateFromInvoiceData objectCreateFromInvoiceData[] = new CreateFromInvoiceData[vector.size()];
    vector.copyInto(objectCreateFromInvoiceData);
    return(objectCreateFromInvoiceData);
  }

  public static CreateFromInvoiceData[] selectFromPOTrl(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adOrgClient, String poId)    throws ServletException {
    return selectFromPOTrl(connectionProvider, adLanguage, adUserClient, adOrgClient, poId, 0, 0);
  }

  public static CreateFromInvoiceData[] selectFromPOTrl(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adOrgClient, String poId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT o.C_ORDER_ID as ID, Ad_Column_Identifier(to_char('C_Order'), to_char(o.c_order_id), to_char(?)) AS NAME, o.DocumentNo AS NAMEORDER," +
      "        l.QtyOrdered-SUM(COALESCE(m.Qty,0)) AS QTY, l.C_UOM_ID, COALESCE(uomt.UOMSYMBOL, uom.UOMSymbol) AS UOMSymbol, " +
      "        l.M_Product_ID,p.NAME AS RELATION_NAME, l.C_OrderLine_ID,l.Line ," +
      "        l.linenetamt,l.linegrossamt,l.description" +
      "        FROM C_UOM uom left join  C_UOM_TRL uomt on uom.C_UOM_ID = uomt.C_UOM_ID" +
      "                                                and uomt.AD_Language = ?," +
      "             C_ORDERLINE l left join M_MATCHPO m on l.C_OrderLine_ID=m.C_OrderLine_ID" +
      "                                                and m.C_InvoiceLine_ID IS NOT NULL," +
      "        C_ORDER o, M_PRODUCT p" +
      "        WHERE o.C_ORDER_ID = l.C_ORDER_ID " +
      "        AND o.IsSOTrx='N' " +
      "        AND o.DocStatus IN ('CL','CO') " +
      "        AND o.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND o.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.C_UOM_ID=uom.C_UOM_ID " +
      "        AND l.M_Product_ID=p.M_Product_ID  " +
      "        AND l.C_Order_ID = ? " +
      "        GROUP BY o.C_ORDER_ID, o.DocumentNo, o.DateOrdered, o.GrandTotal, l.QtyOrdered,l.C_UOM_ID," +
      "        uom.UOMSymbol, uomt.UOMSYMBOL,l.M_Product_ID,p.NAME,l.Line,l.C_OrderLine_ID ," +
      "        l.linenetamt,l.linegrossamt,l.description" +
      "        HAVING (l.QtyOrdered-SUM(COALESCE(m.Qty,0))) <> 0" +
      "        ORDER BY NAME, l.Line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poId);

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
        CreateFromInvoiceData objectCreateFromInvoiceData = new CreateFromInvoiceData();
        objectCreateFromInvoiceData.id = UtilSql.getValue(result, "id");
        objectCreateFromInvoiceData.name = UtilSql.getValue(result, "name");
        objectCreateFromInvoiceData.nameorder = UtilSql.getValue(result, "nameorder");
        objectCreateFromInvoiceData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromInvoiceData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromInvoiceData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromInvoiceData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromInvoiceData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromInvoiceData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromInvoiceData.line = UtilSql.getValue(result, "line");
        objectCreateFromInvoiceData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectCreateFromInvoiceData.linegrossamt = UtilSql.getValue(result, "linegrossamt");
        objectCreateFromInvoiceData.description = UtilSql.getValue(result, "description");
        objectCreateFromInvoiceData.rownum = Long.toString(countRecord);
        objectCreateFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromInvoiceData);
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
    CreateFromInvoiceData objectCreateFromInvoiceData[] = new CreateFromInvoiceData[vector.size()];
    vector.copyInto(objectCreateFromInvoiceData);
    return(objectCreateFromInvoiceData);
  }

  public static CreateFromInvoiceData[] selectFromPOTrlSOTrx(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adOrgClient, String poId)    throws ServletException {
    return selectFromPOTrlSOTrx(connectionProvider, adLanguage, adUserClient, adOrgClient, poId, 0, 0);
  }

  public static CreateFromInvoiceData[] selectFromPOTrlSOTrx(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adOrgClient, String poId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ic.C_ORDER_ID as ID, Ad_Column_Identifier(to_char('C_Order'), to_char(ic.c_order_id), to_char(?) ) AS NAME,ic.DocumentNo AS NAMEORDER," +
      "        icl.pendingqty AS QTY, icl.C_UOM_ID, COALESCE(uomt.UOMSymbol, uom.UOMSymbol) AS UOMSymbol, " +
      "        icl.M_Product_ID,zssi_getproductname(icl.M_Product_ID,?) AS RELATION_NAME, icl.C_OrderLine_ID,l.Line," +
      "        l.linenetamt,l.linegrossamt,l.description" +
      "        FROM C_UOM uom left join C_UOM_TRL uomt on uom.C_UOM_ID = uomt.C_UOM_ID" +
      "                                               and  uomt.AD_Language = ?, " +
      "        C_INVOICE_CANDIDATE_V ic,c_invoice_candidate_lines_v icl, C_ORDERLINE l " +
      "        WHERE icl.C_UOM_ID=uom.C_UOM_ID" +
      "        AND icl.C_ORDER_ID = ic.C_ORDER_ID " +
      "        AND ic.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ic.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.c_orderline_id=icl.c_orderline_id" +
      "        AND ic.C_Order_ID = ? " +
      "        AND icl.m_inout_doctype_id not in ('2317023F9771481696461C5EAF9A0915','2E1E735AA91A49F8BC7181D31B09B370')" +
      "        ORDER BY NAME, l.Line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poId);

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
        CreateFromInvoiceData objectCreateFromInvoiceData = new CreateFromInvoiceData();
        objectCreateFromInvoiceData.id = UtilSql.getValue(result, "id");
        objectCreateFromInvoiceData.name = UtilSql.getValue(result, "name");
        objectCreateFromInvoiceData.nameorder = UtilSql.getValue(result, "nameorder");
        objectCreateFromInvoiceData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromInvoiceData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromInvoiceData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromInvoiceData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromInvoiceData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromInvoiceData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromInvoiceData.line = UtilSql.getValue(result, "line");
        objectCreateFromInvoiceData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectCreateFromInvoiceData.linegrossamt = UtilSql.getValue(result, "linegrossamt");
        objectCreateFromInvoiceData.description = UtilSql.getValue(result, "description");
        objectCreateFromInvoiceData.rownum = Long.toString(countRecord);
        objectCreateFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromInvoiceData);
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
    CreateFromInvoiceData objectCreateFromInvoiceData[] = new CreateFromInvoiceData[vector.size()];
    vector.copyInto(objectCreateFromInvoiceData);
    return(objectCreateFromInvoiceData);
  }

/**
Only Things that have been Invoiced and not delivered yet.
 */
  public static CreateFromInvoiceData[] selectFromOrderCreditMemo(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adOrgClient, String poId)    throws ServletException {
    return selectFromOrderCreditMemo(connectionProvider, adLanguage, adUserClient, adOrgClient, poId, 0, 0);
  }

/**
Only Things that have been Invoiced and not delivered yet.
 */
  public static CreateFromInvoiceData[] selectFromOrderCreditMemo(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adOrgClient, String poId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT o.C_ORDER_ID as ID, Ad_Column_Identifier(to_char('C_Order'), to_char(o.c_order_id), to_char(?) ) AS NAME,o.DocumentNo AS NAMEORDER," +
      "        l.QTYINVOICED-l.QTYDELIVERED AS QTY, l.C_UOM_ID, COALESCE(uomt.UOMSymbol, uom.UOMSymbol) AS UOMSymbol, " +
      "        l.M_Product_ID,p.NAME AS RELATION_NAME, l.C_OrderLine_ID,l.Line," +
      "        l.linenetamt,l.linegrossamt,l.description" +
      "        FROM C_UOM uom left join C_UOM_TRL uomt on uom.C_UOM_ID = uomt.C_UOM_ID" +
      "                                               and  uomt.AD_Language = ?, " +
      "        C_ORDER o, C_ORDERLINE l, M_PRODUCT p " +
      "        WHERE l.C_UOM_ID=uom.C_UOM_ID" +
      "        AND o.C_ORDER_ID=l.C_ORDER_ID " +
      "        AND o.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND o.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.M_Product_ID=p.M_Product_ID" +
      "        AND l.qtydelivered<l.qtyinvoiced" +
      "        AND l.qtyinvoiced>0" +
      "        AND o.C_Order_ID = ? " +
      "        GROUP BY o.C_ORDER_ID, o.DocumentNo, o.DateOrdered, o.GrandTotal, l.QtyOrdered," +
      "        l.C_UOM_ID,uom.UOMSymbol, uomt.UOMSymbol,l.M_Product_ID,p.NAME,l.Line,l.C_OrderLine_ID, l.QTYINVOICED ,l.QTYDELIVERED ," +
      "        l.linenetamt,l.linegrossamt,l.description" +
      "        ORDER BY NAME, l.Line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poId);

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
        CreateFromInvoiceData objectCreateFromInvoiceData = new CreateFromInvoiceData();
        objectCreateFromInvoiceData.id = UtilSql.getValue(result, "id");
        objectCreateFromInvoiceData.name = UtilSql.getValue(result, "name");
        objectCreateFromInvoiceData.nameorder = UtilSql.getValue(result, "nameorder");
        objectCreateFromInvoiceData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromInvoiceData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromInvoiceData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromInvoiceData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromInvoiceData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromInvoiceData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromInvoiceData.line = UtilSql.getValue(result, "line");
        objectCreateFromInvoiceData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectCreateFromInvoiceData.linegrossamt = UtilSql.getValue(result, "linegrossamt");
        objectCreateFromInvoiceData.description = UtilSql.getValue(result, "description");
        objectCreateFromInvoiceData.rownum = Long.toString(countRecord);
        objectCreateFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromInvoiceData);
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
    CreateFromInvoiceData objectCreateFromInvoiceData[] = new CreateFromInvoiceData[vector.size()];
    vector.copyInto(objectCreateFromInvoiceData);
    return(objectCreateFromInvoiceData);
  }

  public static CreateFromInvoiceData[] selectFromPOUpdateSOTrx(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId)    throws ServletException {
    return selectFromPOUpdateSOTrx(conn, connectionProvider, cOrderlineId, 0, 0);
  }

  public static CreateFromInvoiceData[] selectFromPOUpdateSOTrx(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_tax_id,ad_Org_Id,c_Orderline_Id,m_Inoutline_Id,description,m_Product_Id," +
      "               c_Uom_Id,pendingqty,priceList, priceActual,priceLimit,quantityorder," +
      "               m_Product_Uom_Id,m_Attributesetinstance_Id,priceStd," +
      "               c_Project_Id, c_ProjectTask_Id ,a_asset_id" +
      "        from c_invoice_candidate_lines_v" +
      "        where c_orderline_id in ";
    strSql = strSql + ((cOrderlineId==null || cOrderlineId.equals(""))?"":cOrderlineId);
    strSql = strSql + 
      "        and m_inout_doctype_id not in ('2317023F9771481696461C5EAF9A0915','2E1E735AA91A49F8BC7181D31B09B370')" +
      "        order by line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      if (cOrderlineId != null && !(cOrderlineId.equals(""))) {
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
        CreateFromInvoiceData objectCreateFromInvoiceData = new CreateFromInvoiceData();
        objectCreateFromInvoiceData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectCreateFromInvoiceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCreateFromInvoiceData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromInvoiceData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectCreateFromInvoiceData.description = UtilSql.getValue(result, "description");
        objectCreateFromInvoiceData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromInvoiceData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromInvoiceData.pendingqty = UtilSql.getValue(result, "pendingqty");
        objectCreateFromInvoiceData.pricelist = UtilSql.getValue(result, "pricelist");
        objectCreateFromInvoiceData.priceactual = UtilSql.getValue(result, "priceactual");
        objectCreateFromInvoiceData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectCreateFromInvoiceData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectCreateFromInvoiceData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectCreateFromInvoiceData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCreateFromInvoiceData.pricestd = UtilSql.getValue(result, "pricestd");
        objectCreateFromInvoiceData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCreateFromInvoiceData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectCreateFromInvoiceData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectCreateFromInvoiceData.rownum = Long.toString(countRecord);
        objectCreateFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromInvoiceData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    CreateFromInvoiceData objectCreateFromInvoiceData[] = new CreateFromInvoiceData[vector.size()];
    vector.copyInto(objectCreateFromInvoiceData);
    return(objectCreateFromInvoiceData);
  }

  public static CreateFromInvoiceData[] selectLoopFromOrderCreditMemo(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId)    throws ServletException {
    return selectLoopFromOrderCreditMemo(conn, connectionProvider, cOrderlineId, 0, 0);
  }

  public static CreateFromInvoiceData[] selectLoopFromOrderCreditMemo(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT l.QTYINVOICED-l.QTYDELIVERED AS pendingqty," +
      "                l.C_UOM_ID,uom.UOMSymbol, l.M_Product_ID,p.NAME, " +
      "                l.C_OrderLine_ID,l.Line, uom.stdprecision, cur.priceprecision, null as M_InOutLine_ID, l.Description," +
      "                l.quantityOrder  AS quantityOrder," +
      "                l.M_Product_UOM_ID, l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id,l.pricestd,l.pricelist,l.priceactual,l.c_tax_id," +
      "                l.a_asset_id,l.c_project_id" +
      "         FROM C_ORDERLINE l ,C_UOM uom,  M_PRODUCT p  ,c_currency cur" +
      "         WHERE cur.C_CURRENCY_ID=l.C_CURRENCY_ID AND l.C_UOM_ID=uom.C_UOM_ID" +
      "                AND l.M_Product_ID=p.M_Product_ID ";
    strSql = strSql + ((cOrderlineId==null || cOrderlineId.equals(""))?"":"  AND l.C_OrderLine_ID IN " + cOrderlineId);
    strSql = strSql + 
      "                AND l.qtydelivered<l.qtyinvoiced" +
      "                AND l.qtyinvoiced>0" +
      "        ORDER BY l.Line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      if (cOrderlineId != null && !(cOrderlineId.equals(""))) {
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
        CreateFromInvoiceData objectCreateFromInvoiceData = new CreateFromInvoiceData();
        objectCreateFromInvoiceData.pendingqty = UtilSql.getValue(result, "pendingqty");
        objectCreateFromInvoiceData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromInvoiceData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromInvoiceData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromInvoiceData.name = UtilSql.getValue(result, "name");
        objectCreateFromInvoiceData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromInvoiceData.line = UtilSql.getValue(result, "line");
        objectCreateFromInvoiceData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectCreateFromInvoiceData.priceprecision = UtilSql.getValue(result, "priceprecision");
        objectCreateFromInvoiceData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectCreateFromInvoiceData.description = UtilSql.getValue(result, "description");
        objectCreateFromInvoiceData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectCreateFromInvoiceData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectCreateFromInvoiceData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCreateFromInvoiceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCreateFromInvoiceData.pricestd = UtilSql.getValue(result, "pricestd");
        objectCreateFromInvoiceData.pricelist = UtilSql.getValue(result, "pricelist");
        objectCreateFromInvoiceData.priceactual = UtilSql.getValue(result, "priceactual");
        objectCreateFromInvoiceData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectCreateFromInvoiceData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectCreateFromInvoiceData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCreateFromInvoiceData.rownum = Long.toString(countRecord);
        objectCreateFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromInvoiceData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    CreateFromInvoiceData objectCreateFromInvoiceData[] = new CreateFromInvoiceData[vector.size()];
    vector.copyInto(objectCreateFromInvoiceData);
    return(objectCreateFromInvoiceData);
  }

  public static CreateFromInvoiceData[] selectFromShipment(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adOrgClient, String mInoutId)    throws ServletException {
    return selectFromShipment(connectionProvider, adLanguage, adUserClient, adOrgClient, mInoutId, 0, 0);
  }

  public static CreateFromInvoiceData[] selectFromShipment(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adOrgClient, String mInoutId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT s.M_InOut_ID AS ID, Ad_Column_Identifier(to_char('M_InOut'), to_char(s.M_InOut_ID), to_char(?)) AS NAME, " +
      "        s.DocumentNo AS NAMESHIPMENT, " +
      "        (l.MovementQty-SUM(COALESCE(mi.Qty,0))) AS QTY, l.C_UOM_ID,uom.UOMSymbol, l.M_Product_ID,p.NAME||' '||(CASE WHEN ma.serno IS NOT NULL THEN TO_CHAR('('||' '||ma.serno||' '||')') ELSE TO_CHAR('')  END) AS RELATION_NAME, " +
      "        l.M_InOutLine_ID,l.Line, l.M_InOutLine_ID as C_OrderLine_ID " +
      "        FROM M_INOUTLINE l left join M_ATTRIBUTESETINSTANCE ma on l.M_ATTRIBUTESETINSTANCE_ID = ma.M_ATTRIBUTESETINSTANCE_ID" +
      "                           left join M_MATCHINV mi             on l.M_InOutLine_ID=mi.M_InOutLine_ID," +
      "        M_INOUT s, C_UOM uom,  M_PRODUCT p" +
      "        WHERE s.M_INOUT_ID = l.M_INOUT_ID " +
      "        AND s.IsSOTrx='N' " +
      "        AND s.DocStatus IN ('CL','CO') " +
      "        AND s.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND s.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.C_UOM_ID=uom.C_UOM_ID " +
      "        AND l.M_Product_ID=p.M_Product_ID " +
      "        AND l.M_InOut_ID=? " +
      "        GROUP BY s.M_InOut_ID, s.DocumentNo, s.MovementDate, l.MovementQty,l.C_UOM_ID,uom.UOMSymbol," +
      "        l.M_Product_ID,ma.serno,p.NAME, l.M_InOutLine_ID,l.Line,l.C_OrderLine_ID " +
      "        HAVING  (l.MovementQty-SUM(COALESCE(mi.Qty,0))) <> 0" +
      "        ORDER BY NAME, l.Line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);

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
        CreateFromInvoiceData objectCreateFromInvoiceData = new CreateFromInvoiceData();
        objectCreateFromInvoiceData.id = UtilSql.getValue(result, "id");
        objectCreateFromInvoiceData.name = UtilSql.getValue(result, "name");
        objectCreateFromInvoiceData.nameshipment = UtilSql.getValue(result, "nameshipment");
        objectCreateFromInvoiceData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromInvoiceData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromInvoiceData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromInvoiceData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromInvoiceData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromInvoiceData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectCreateFromInvoiceData.line = UtilSql.getValue(result, "line");
        objectCreateFromInvoiceData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromInvoiceData.rownum = Long.toString(countRecord);
        objectCreateFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromInvoiceData);
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
    CreateFromInvoiceData objectCreateFromInvoiceData[] = new CreateFromInvoiceData[vector.size()];
    vector.copyInto(objectCreateFromInvoiceData);
    return(objectCreateFromInvoiceData);
  }

  public static CreateFromInvoiceData[] selectFromShipmentSOTrx(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adOrgClient, String mInoutId)    throws ServletException {
    return selectFromShipmentSOTrx(connectionProvider, adLanguage, adUserClient, adOrgClient, mInoutId, 0, 0);
  }

  public static CreateFromInvoiceData[] selectFromShipmentSOTrx(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adOrgClient, String mInoutId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT s.M_InOut_ID AS ID, Ad_Column_Identifier(to_char('M_InOut'), to_char(s.M_InOut_ID), to_char(?)) AS NAME," +
      "        s.DocumentNo AS NAMESHIPMENT," +
      "        l.MovementQty AS QTY, l.C_UOM_ID,uom.UOMSymbol, l.M_Product_ID,p.NAME||' '||(CASE WHEN ma.serno IS NOT NULL THEN TO_CHAR('('||' '||ma.serno||' '||')') ELSE TO_CHAR('') END) AS RELATION_NAME, l.M_InOutLine_ID,l.Line," +
      "        l.M_InOutLine_ID as C_OrderLine_ID " +
      "        FROM M_INOUTLINE l left join M_ATTRIBUTESETINSTANCE ma on l.M_ATTRIBUTESETINSTANCE_ID = ma.M_ATTRIBUTESETINSTANCE_ID," +
      "        M_INOUT s, C_UOM uom, M_PRODUCT p " +
      "        WHERE s.M_INOUT_ID = l.M_INOUT_ID" +
      "        AND s.IsSOTrx='Y' " +
      "        AND s.DocStatus IN ('CL','CO') " +
      "        AND s.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND s.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.C_UOM_ID=uom.C_UOM_ID " +
      "        AND l.M_Product_ID=p.M_Product_ID " +
      "        AND l.isinvoiced = 'N' " +
      "        AND l.M_InOut_ID=?" +
      "        GROUP BY s.M_InOut_ID, s.DocumentNo, s.MovementDate, l.MovementQty,l.C_UOM_ID,uom.UOMSymbol," +
      "        l.M_Product_ID,p.NAME, ma.serno, l.M_InOutLine_ID,l.Line,l.C_OrderLine_ID" +
      "        ORDER BY NAME, l.Line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);

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
        CreateFromInvoiceData objectCreateFromInvoiceData = new CreateFromInvoiceData();
        objectCreateFromInvoiceData.id = UtilSql.getValue(result, "id");
        objectCreateFromInvoiceData.name = UtilSql.getValue(result, "name");
        objectCreateFromInvoiceData.nameshipment = UtilSql.getValue(result, "nameshipment");
        objectCreateFromInvoiceData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromInvoiceData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromInvoiceData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromInvoiceData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromInvoiceData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromInvoiceData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectCreateFromInvoiceData.line = UtilSql.getValue(result, "line");
        objectCreateFromInvoiceData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromInvoiceData.rownum = Long.toString(countRecord);
        objectCreateFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromInvoiceData);
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
    CreateFromInvoiceData objectCreateFromInvoiceData[] = new CreateFromInvoiceData[vector.size()];
    vector.copyInto(objectCreateFromInvoiceData);
    return(objectCreateFromInvoiceData);
  }

/**
No Shipment-Returns, Only Shipments that are not Invoiced and have no Orderline with Invoiceline
 */
  public static CreateFromInvoiceData[] selectFromShipmentSOTrxCombo(ConnectionProvider connectionProvider, String adLanguage, String isSOTrx, String adUserClient, String adOrgClient, String cBpartnerId)    throws ServletException {
    return selectFromShipmentSOTrxCombo(connectionProvider, adLanguage, isSOTrx, adUserClient, adOrgClient, cBpartnerId, 0, 0);
  }

/**
No Shipment-Returns, Only Shipments that are not Invoiced and have no Orderline with Invoiceline
 */
  public static CreateFromInvoiceData[] selectFromShipmentSOTrxCombo(ConnectionProvider connectionProvider, String adLanguage, String isSOTrx, String adUserClient, String adOrgClient, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT s.M_InOut_ID AS ID, Ad_Column_Identifier(to_char('M_InOut'), to_char(s.M_InOut_ID), to_char(?)) AS NAME " +
      "        FROM M_INOUT s " +
      "        WHERE s.IsSOTrx= ?  " +
      "        AND s.ISLOGISTIC <> 'Y'" +
      "        AND s.DocStatus IN ('CL','CO') " +
      "        AND s.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND s.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "        AND s.C_BPartner_ID = ?  " +
      "        AND s.c_doctype_id not in ( '2317023F9771481696461C5EAF9A0915','2E1E735AA91A49F8BC7181D31B09B370')" +
      "        AND EXISTS (SELECT 1 FROM M_INOUTLINE l " +
      "                           WHERE l.M_INOUT_ID = s.M_INOUT_ID " +
      "                           AND l.isinvoiced = 'N') " +
      "        AND NOT EXISTS (select 0 from M_INOUTLINE iol, c_orderline ol, c_invoiceline il" +
      "                           WHERE iol.M_INOUT_ID = s.M_INOUT_ID  " +
      "                           AND   iol.c_orderline_id=ol.c_orderline_id" +
      "                           AND   il.c_orderline_id=ol.c_orderline_id" +
      "                           AND   c_isorderline2invoiceByNowOrGenerally(ol.c_orderline_id,'N')='N')" +
      "        ORDER BY NAME";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isSOTrx);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
        CreateFromInvoiceData objectCreateFromInvoiceData = new CreateFromInvoiceData();
        objectCreateFromInvoiceData.id = UtilSql.getValue(result, "id");
        objectCreateFromInvoiceData.name = UtilSql.getValue(result, "name");
        objectCreateFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromInvoiceData);
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
    CreateFromInvoiceData objectCreateFromInvoiceData[] = new CreateFromInvoiceData[vector.size()];
    vector.copyInto(objectCreateFromInvoiceData);
    return(objectCreateFromInvoiceData);
  }

/**
Only Shipment Returns that have no Credit Memo yet and no Orderline with Invoiceline (last is automatically a Credit Memo)
 */
  public static CreateFromInvoiceData[] selectFromShipmentCreditReturnCombo(ConnectionProvider connectionProvider, String adLanguage, String isSoTrx, String adUserClient, String adOrgClient, String cBpartnerId)    throws ServletException {
    return selectFromShipmentCreditReturnCombo(connectionProvider, adLanguage, isSoTrx, adUserClient, adOrgClient, cBpartnerId, 0, 0);
  }

/**
Only Shipment Returns that have no Credit Memo yet and no Orderline with Invoiceline (last is automatically a Credit Memo)
 */
  public static CreateFromInvoiceData[] selectFromShipmentCreditReturnCombo(ConnectionProvider connectionProvider, String adLanguage, String isSoTrx, String adUserClient, String adOrgClient, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT s.M_InOut_ID AS ID, Ad_Column_Identifier(to_char('M_InOut'), to_char(s.M_InOut_ID), to_char(?)) AS NAME " +
      "        FROM M_INOUT s , M_INOUTLINE l" +
      "        WHERE s.IsSOTrx= ? " +
      "        AND l.M_INOUT_ID = s.M_INOUT_ID " +
      "        AND l.isinvoiced = 'N'" +
      "        AND s.ISLOGISTIC <> 'Y'" +
      "        AND s.DocStatus IN ('CL','CO') " +
      "        AND s.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND s.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "        AND s.C_BPartner_ID = ?  " +
      "        AND s.c_doctype_id in ('2317023F9771481696461C5EAF9A0915', '2E1E735AA91A49F8BC7181D31B09B370')" +
      "        AND NOT EXISTS (select 0 from M_INOUTLINE iol, c_orderline ol, c_invoiceline il, c_invoice i" +
      "                           WHERE iol.M_INOUT_ID = s.M_INOUT_ID  " +
      "                           AND   iol.c_orderline_id=ol.c_orderline_id" +
      "                           AND   il.c_orderline_id=ol.c_orderline_id" +
      "                           AND   il.m_inoutline_id=l.m_inoutline_id" +
      "                           AND   i.c_invoice_id=il.c_invoice_id" +
      "                           AND   i.c_doctype_id in ('A4277AD679DF4DD8A9C2BB9F3C2F2C92','3CD24CAE0D074B8FA9918178780D50FB')" +
      "                           AND   i.docstatus = 'CO'" +
      "                           )" +
      "        ORDER BY NAME";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isSoTrx);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
        CreateFromInvoiceData objectCreateFromInvoiceData = new CreateFromInvoiceData();
        objectCreateFromInvoiceData.id = UtilSql.getValue(result, "id");
        objectCreateFromInvoiceData.name = UtilSql.getValue(result, "name");
        objectCreateFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromInvoiceData);
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
    CreateFromInvoiceData objectCreateFromInvoiceData[] = new CreateFromInvoiceData[vector.size()];
    vector.copyInto(objectCreateFromInvoiceData);
    return(objectCreateFromInvoiceData);
  }

  public static CreateFromInvoiceData[] selectFromShipmentTrlSOTrx(ConnectionProvider connectionProvider, String adLanguage, String isSoTrx, String adUserClient, String adOrgClient, String mInoutId)    throws ServletException {
    return selectFromShipmentTrlSOTrx(connectionProvider, adLanguage, isSoTrx, adUserClient, adOrgClient, mInoutId, 0, 0);
  }

  public static CreateFromInvoiceData[] selectFromShipmentTrlSOTrx(ConnectionProvider connectionProvider, String adLanguage, String isSoTrx, String adUserClient, String adOrgClient, String mInoutId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT s.M_InOut_ID AS ID, Ad_Column_Identifier(to_char('M_InOut'), to_char(s.M_InOut_ID), to_char(?)) AS NAME," +
      "        s.DocumentNo AS NAMESHIPMENT, " +
      "        l.MovementQty AS QTY, l.C_UOM_ID,COALESCE(uomt.UOMSymbol, uom.UOMSymbol) AS UOMSymbol, " +
      "        l.M_Product_ID,p.NAME||' '|| (CASE WHEN ma.serno IS NOT NULL THEN TO_CHAR('('||' '||ma.serno||' '||')') ELSE TO_CHAR('')  END) AS RELATION_NAME, l.M_InOutLine_ID,l.Line, l.M_InOutLine_ID as C_OrderLine_ID ," +
      "        '' as linenetamt,'' as linegrossamt,l.description" +
      "        FROM M_INOUTLINE l left join M_ATTRIBUTESETINSTANCE ma on l.M_ATTRIBUTESETINSTANCE_ID = ma.M_ATTRIBUTESETINSTANCE_ID," +
      "             C_UOM uom     left join C_UOM_TRL uomt            on uom.C_UOM_ID = uomt.C_UOM_ID" +
      "                                                              and uomt.AD_Language = ? ," +
      "        M_INOUT s,    M_PRODUCT p " +
      "        WHERE s.M_INOUT_ID = l.M_INOUT_ID" +
      "        AND s.IsSOTrx= ?" +
      "        AND s.DocStatus IN ('CL','CO') " +
      "        AND s.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND s.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.C_UOM_ID=uom.C_UOM_ID " +
      "        AND l.M_Product_ID=p.M_Product_ID " +
      "        AND l.isinvoiced = 'N' " +
      "        AND l.M_InOut_ID=? " +
      "        GROUP BY s.M_InOut_ID, s.DocumentNo, s.MovementDate, l.MovementQty,l.C_UOM_ID,uom.UOMSymbol, uomt.UOMSymbol," +
      "        l.M_Product_ID,p.NAME,ma.serno, l.M_InOutLine_ID,l.Line,l.C_OrderLine_ID,l.description" +
      "        ORDER BY NAME, l.Line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isSoTrx);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);

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
        CreateFromInvoiceData objectCreateFromInvoiceData = new CreateFromInvoiceData();
        objectCreateFromInvoiceData.id = UtilSql.getValue(result, "id");
        objectCreateFromInvoiceData.name = UtilSql.getValue(result, "name");
        objectCreateFromInvoiceData.nameshipment = UtilSql.getValue(result, "nameshipment");
        objectCreateFromInvoiceData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromInvoiceData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromInvoiceData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromInvoiceData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromInvoiceData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromInvoiceData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectCreateFromInvoiceData.line = UtilSql.getValue(result, "line");
        objectCreateFromInvoiceData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromInvoiceData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectCreateFromInvoiceData.linegrossamt = UtilSql.getValue(result, "linegrossamt");
        objectCreateFromInvoiceData.description = UtilSql.getValue(result, "description");
        objectCreateFromInvoiceData.rownum = Long.toString(countRecord);
        objectCreateFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromInvoiceData);
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
    CreateFromInvoiceData objectCreateFromInvoiceData[] = new CreateFromInvoiceData[vector.size()];
    vector.copyInto(objectCreateFromInvoiceData);
    return(objectCreateFromInvoiceData);
  }

  public static CreateFromInvoiceData[] selectFromShipmentUpdateSOTrx(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId)    throws ServletException {
    return selectFromShipmentUpdateSOTrx(conn, connectionProvider, cOrderlineId, 0, 0);
  }

  public static CreateFromInvoiceData[] selectFromShipmentUpdateSOTrx(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT l.MovementQty AS pendingqty, l.C_UOM_ID,uom.UOMSymbol, l.M_Product_ID,p.NAME, l.M_InOutLine_ID,l.Line," +
      "        l.C_OrderLine_ID, max(uom.STDPRECISION) as stdprecision, l.Description,l.quantityOrder, l.M_Product_UOM_ID," +
      "        l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id," +
      "        ol.a_asset_id,ol.c_project_id,ol.c_projecttask_id,ol.pricestd,ol.pricelist,ol.priceactual,ol.c_tax_id,ol.pricelimit" +
      "        FROM C_UOM uom, M_PRODUCT p ,M_INOUTLINE l" +
      "             left join c_orderline ol on  ol.c_orderline_id=l.c_orderline_id" +
      "        WHERE l.C_UOM_ID=uom.C_UOM_ID" +
      "        AND l.M_Product_ID=p.M_Product_ID " +
      "        AND l.isinvoiced = 'N' ";
    strSql = strSql + ((cOrderlineId==null || cOrderlineId.equals(""))?"":"  AND l.M_InOutLine_ID IN " + cOrderlineId);
    strSql = strSql + 
      "        GROUP BY l.MovementQty,l.C_UOM_ID,uom.UOMSymbol,l.M_Product_ID,p.NAME, l.M_InOutLine_ID,l.Line,l.C_OrderLine_ID, l.Description, l.quantityOrder, l.M_Product_UOM_ID, l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id," +
      "                 ol.a_asset_id,ol.c_project_id,ol.pricestd,ol.pricelist,ol.priceactual,ol.c_tax_id,ol.c_projecttask_id,ol.pricelimit" +
      "        ORDER BY l.Line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      if (cOrderlineId != null && !(cOrderlineId.equals(""))) {
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
        CreateFromInvoiceData objectCreateFromInvoiceData = new CreateFromInvoiceData();
        objectCreateFromInvoiceData.pendingqty = UtilSql.getValue(result, "pendingqty");
        objectCreateFromInvoiceData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromInvoiceData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromInvoiceData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromInvoiceData.name = UtilSql.getValue(result, "name");
        objectCreateFromInvoiceData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectCreateFromInvoiceData.line = UtilSql.getValue(result, "line");
        objectCreateFromInvoiceData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromInvoiceData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectCreateFromInvoiceData.description = UtilSql.getValue(result, "description");
        objectCreateFromInvoiceData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectCreateFromInvoiceData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectCreateFromInvoiceData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCreateFromInvoiceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCreateFromInvoiceData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectCreateFromInvoiceData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCreateFromInvoiceData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectCreateFromInvoiceData.pricestd = UtilSql.getValue(result, "pricestd");
        objectCreateFromInvoiceData.pricelist = UtilSql.getValue(result, "pricelist");
        objectCreateFromInvoiceData.priceactual = UtilSql.getValue(result, "priceactual");
        objectCreateFromInvoiceData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectCreateFromInvoiceData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectCreateFromInvoiceData.rownum = Long.toString(countRecord);
        objectCreateFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromInvoiceData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    CreateFromInvoiceData objectCreateFromInvoiceData[] = new CreateFromInvoiceData[vector.size()];
    vector.copyInto(objectCreateFromInvoiceData);
    return(objectCreateFromInvoiceData);
  }

  public static CreateFromInvoiceData[] set()    throws ServletException {
    CreateFromInvoiceData objectCreateFromInvoiceData[] = new CreateFromInvoiceData[1];
    objectCreateFromInvoiceData[0] = new CreateFromInvoiceData();
    objectCreateFromInvoiceData[0].pendingqty = "";
    objectCreateFromInvoiceData[0].cUomId = "";
    objectCreateFromInvoiceData[0].uomsymbol = "";
    objectCreateFromInvoiceData[0].mProductId = "";
    objectCreateFromInvoiceData[0].name = "";
    objectCreateFromInvoiceData[0].mInoutlineId = "";
    objectCreateFromInvoiceData[0].line = "";
    objectCreateFromInvoiceData[0].cOrderlineId = "";
    objectCreateFromInvoiceData[0].stdprecision = "";
    objectCreateFromInvoiceData[0].description = "";
    objectCreateFromInvoiceData[0].quantityorder = "";
    objectCreateFromInvoiceData[0].mProductUomId = "";
    objectCreateFromInvoiceData[0].mAttributesetinstanceId = "";
    objectCreateFromInvoiceData[0].adOrgId = "";
    objectCreateFromInvoiceData[0].aAssetId = "";
    objectCreateFromInvoiceData[0].cProjectId = "";
    objectCreateFromInvoiceData[0].cProjecttaskId = "";
    objectCreateFromInvoiceData[0].pricestd = "";
    objectCreateFromInvoiceData[0].pricelist = "";
    objectCreateFromInvoiceData[0].priceactual = "";
    objectCreateFromInvoiceData[0].cTaxId = "";
    objectCreateFromInvoiceData[0].pricelimit = "";
    return objectCreateFromInvoiceData;
  }

  public static CreateFromInvoiceData[] selectPriceList(Connection conn, ConnectionProvider connectionProvider, String validfrom, String mPricelistId)    throws ServletException {
    return selectPriceList(conn, connectionProvider, validfrom, mPricelistId, 0, 0);
  }

  public static CreateFromInvoiceData[] selectPriceList(Connection conn, ConnectionProvider connectionProvider, String validfrom, String mPricelistId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT plv.M_PriceList_Version_ID AS ID, cur.Priceprecision" +
      "      FROM M_PRICELIST pl, M_PRICELIST_VERSION plv, C_CURRENCY cur" +
      "      WHERE pl.M_PriceList_ID = plv.M_PriceList_ID " +
      "      AND pl.C_Currency_ID = cur.C_Currency_ID" +
      "      AND plv.IsActive='Y'" +
      "      AND plv.ValidFrom <= TO_DATE(?) AND pl.M_PriceList_ID=? " +
      "      ORDER BY plv.ValidFrom DESC";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);

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
        CreateFromInvoiceData objectCreateFromInvoiceData = new CreateFromInvoiceData();
        objectCreateFromInvoiceData.id = UtilSql.getValue(result, "id");
        objectCreateFromInvoiceData.priceprecision = UtilSql.getValue(result, "priceprecision");
        objectCreateFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromInvoiceData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    CreateFromInvoiceData objectCreateFromInvoiceData[] = new CreateFromInvoiceData[vector.size()];
    vector.copyInto(objectCreateFromInvoiceData);
    return(objectCreateFromInvoiceData);
  }

  public static CreateFromInvoiceData[] selectPrices(Connection conn, ConnectionProvider connectionProvider, String mProductId, String mPricelistId, String orderDate, String cBpartnerId, String qty)    throws ServletException {
    return selectPrices(conn, connectionProvider, mProductId, mPricelistId, orderDate, cBpartnerId, qty, 0, 0);
  }

  public static CreateFromInvoiceData[] selectPrices(Connection conn, ConnectionProvider connectionProvider, String mProductId, String mPricelistId, String orderDate, String cBpartnerId, String qty, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT  m_bom_pricestd(?,?) as PriceStd,m_bom_pricelist(?,?) as PriceList,m_bom_pricelimit(?,?) as PriceLimit," +
      "              m_get_offers_price(to_date(?),?,?,to_number(?),?) as PriceActual" +
      "      FROM dual";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);

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
        CreateFromInvoiceData objectCreateFromInvoiceData = new CreateFromInvoiceData();
        objectCreateFromInvoiceData.pricestd = UtilSql.getValue(result, "pricestd");
        objectCreateFromInvoiceData.pricelist = UtilSql.getValue(result, "pricelist");
        objectCreateFromInvoiceData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectCreateFromInvoiceData.priceactual = UtilSql.getValue(result, "priceactual");
        objectCreateFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromInvoiceData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    CreateFromInvoiceData objectCreateFromInvoiceData[] = new CreateFromInvoiceData[vector.size()];
    vector.copyInto(objectCreateFromInvoiceData);
    return(objectCreateFromInvoiceData);
  }

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String cInvoicelineId, String cInvoiceId, String adClientId, String adOrgId, String adUserId, String cOrderlineId, String mInoutlineId, String description, String mProductId, String cUomId, String qtyinvoiced, String pricelist, String priceactual, String pricelimit, String linenetamt, String cTaxId, String quantityOrder, String mProductUomId, String mAttributesetinstanceId, String pricestd, String cProjectId, String cProjecttaskId, String aAssetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO C_INVOICELINE " +
      "        (C_InvoiceLine_ID,C_Invoice_ID, AD_Client_ID,AD_Org_ID,IsActive," +
      "        Created,CreatedBy,Updated,UpdatedBy, " +
      "        C_OrderLine_ID,M_InOutLine_ID, Line,Description, M_Product_ID," +
      "        C_UOM_ID,QtyInvoiced, PriceList," +
      "        PriceActual,PriceLimit, LineNetAmt," +
      "        ChargeAmt,C_Tax_ID, QuantityOrder, M_Product_UOM_ID," +
      "        M_Attributesetinstance_ID, PriceStd,c_project_id,c_projecttask_id,a_asset_id)" +
      "      VALUES " +
      "        (?, ?, ?, ?, 'Y', " +
      "         now(), ?, now(), ?, " +
      "         ?, ?, (SELECT (COALESCE(Max(Line),0))+10 FROM C_InvoiceLine WHERE C_Invoice_ID=?), ?, ?, " +
      "         ?, TO_NUMBER(?), TO_NUMBER(?), " +
      "         TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), " +
      "         0, ?, TO_NUMBER(?), ?, " +
      "         ?, TO_NUMBER(?),?,?,?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityOrder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricestd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);

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

  public static int updateC_Order_ID(Connection conn, ConnectionProvider connectionProvider, String cOrderId, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_Invoice SET C_Order_id = ?" +
      "      WHERE C_Invoice_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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

  public static int deleteC_Order_ID(Connection conn, ConnectionProvider connectionProvider, String cInvoiceId, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_INVOICE SET C_Order_ID=NULL" +
      "      WHERE C_Invoice_ID=?" +
      "      AND C_Order_ID IS NOT NULL AND C_Order_ID <> ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

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

  public static String selectProject(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Project_ID" +
      "      FROM C_INVOICE" +
      "      WHERE C_INVOICE_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_project_id");
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

  public static String getTax(ConnectionProvider connectionProvider, String cOrderLineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Tax_ID" +
      "      FROM C_ORDERLINE" +
      "      WHERE C_ORDERLINE_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderLineId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_tax_id");
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
