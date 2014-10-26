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

class CreateFromShipmentData implements FieldProvider {
static Logger log4j = Logger.getLogger(CreateFromShipmentData.class);
  private String InitRecordNumber="0";
  public String cOrderId;
  public String name;
  public String qty;
  public String cUomId;
  public String uomsymbol;
  public String mProductId;
  public String relationName;
  public String cOrderlineId;
  public String line;
  public String adOrgId;
  public String cInvoicelineId;
  public String mInoutlineId;
  public String breakdown;
  public String stdprecision;
  public String cUomIdConversion;
  public String quantityorder;
  public String mProductUomId;
  public String mAttributesetinstanceId;
  public String id;
  public String cInvoiceId;
  public String description;
  public String secqty;
  public String secProductUomId;
  public String secuomsymbol;
  public String havesec;
  public String havesecuom;
  public String locator;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
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
    else if (fieldName.equalsIgnoreCase("c_invoiceline_id") || fieldName.equals("cInvoicelineId"))
      return cInvoicelineId;
    else if (fieldName.equalsIgnoreCase("m_inoutline_id") || fieldName.equals("mInoutlineId"))
      return mInoutlineId;
    else if (fieldName.equalsIgnoreCase("breakdown"))
      return breakdown;
    else if (fieldName.equalsIgnoreCase("stdprecision"))
      return stdprecision;
    else if (fieldName.equalsIgnoreCase("c_uom_id_conversion") || fieldName.equals("cUomIdConversion"))
      return cUomIdConversion;
    else if (fieldName.equalsIgnoreCase("quantityorder"))
      return quantityorder;
    else if (fieldName.equalsIgnoreCase("m_product_uom_id") || fieldName.equals("mProductUomId"))
      return mProductUomId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("secqty"))
      return secqty;
    else if (fieldName.equalsIgnoreCase("sec_product_uom_id") || fieldName.equals("secProductUomId"))
      return secProductUomId;
    else if (fieldName.equalsIgnoreCase("secuomsymbol"))
      return secuomsymbol;
    else if (fieldName.equalsIgnoreCase("havesec"))
      return havesec;
    else if (fieldName.equalsIgnoreCase("havesecuom"))
      return havesecuom;
    else if (fieldName.equalsIgnoreCase("locator"))
      return locator;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CreateFromShipmentData[] selectFromPO(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId)    throws ServletException {
    return selectFromPO(connectionProvider, language, adUserClient, adOrgClient, poId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromPO(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT o.C_ORDER_ID, Ad_Column_Identifier(TO_CHAR('C_Order'), TO_CHAR(o.c_order_id), TO_CHAR(?)) AS NAME, " +
      "        l.QtyOrdered-SUM(COALESCE(m.Qty,0)) AS QTY, l.C_UOM_ID,uom.UOMSymbol, l.M_Product_ID,p.NAME AS RELATION_NAME, " +
      "        l.C_OrderLine_ID,l.Line, l.ad_org_id, '' as C_InvoiceLine_ID, '' as M_InOutLine_ID, '' AS BREAKDOWN, '' AS STDPRECISION, " +
      "        '' AS C_UOM_ID_Conversion, '' AS QUANTITYORDER, '' AS M_Product_UOM_ID, '' AS M_ATTRIBUTESETINSTANCE_ID, " +
      "        l.C_OrderLine_ID AS ID, '' AS C_Invoice_ID, l.DESCRIPTION AS DESCRIPTION," +
      "        ((l.QtyOrdered-SUM(COALESCE(m.Qty,0)))/COALESCE(" +
      "        (SELECT MULTIPLYRATE FROM C_UOM_CONVERSION WHERE C_UOM_CONVERSION.C_UOM_ID =" +
      "        (SELECT C_UOM.C_UOM_ID FROM M_PRODUCT_UOM, C_UOM WHERE M_PRODUCT_UOM_ID = l.M_PRODUCT_UOM_ID AND M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID)        " +
      "        AND C_UOM_CONVERSION.C_UOM_TO_ID = l.C_UOM_ID),1)) " +
      "        as SECQTY, l.M_PRODUCT_UOM_ID as SEC_PRODUCT_UOM_ID," +
      "        (SELECT C_UOM.NAME FROM M_PRODUCT_UOM, C_UOM WHERE M_PRODUCT_UOM_ID = l.M_PRODUCT_UOM_ID AND M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID) as SECUOMSYMBOL," +
      "        COALESCE(l.M_PRODUCT_UOM_ID,null,'0') as HAVESEC,'' as HAVESECUOM,'' AS LOCATOR" +
      "        FROM C_ORDERLINE l left join  M_MATCHPO m on l.C_OrderLine_ID=m.C_OrderLine_ID" +
      "                                                 and m.M_InOutLine_ID IS NOT NULL," +
      "        C_ORDER o, C_UOM uom, M_PRODUCT p" +
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
      "        GROUP BY o.C_ORDER_ID, o.DocumentNo, o.DateOrdered, o.GrandTotal, l.QtyOrdered,l.qtydelivered, " +
      "        l.C_UOM_ID,uom.UOMSymbol,l.M_Product_ID,p.NAME,l.Line,l.C_OrderLine_ID, l.ad_org_id, l.DESCRIPTION, l.QUANTITYORDER, l.M_PRODUCT_UOM_ID" +
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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCreateFromShipmentData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectCreateFromShipmentData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectCreateFromShipmentData.breakdown = UtilSql.getValue(result, "breakdown");
        objectCreateFromShipmentData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectCreateFromShipmentData.cUomIdConversion = UtilSql.getValue(result, "c_uom_id_conversion");
        objectCreateFromShipmentData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectCreateFromShipmentData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectCreateFromShipmentData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.secqty = UtilSql.getValue(result, "secqty");
        objectCreateFromShipmentData.secProductUomId = UtilSql.getValue(result, "sec_product_uom_id");
        objectCreateFromShipmentData.secuomsymbol = UtilSql.getValue(result, "secuomsymbol");
        objectCreateFromShipmentData.havesec = UtilSql.getValue(result, "havesec");
        objectCreateFromShipmentData.havesecuom = UtilSql.getValue(result, "havesecuom");
        objectCreateFromShipmentData.locator = UtilSql.getValue(result, "locator");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromPOSOTrx(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId)    throws ServletException {
    return selectFromPOSOTrx(connectionProvider, language, adUserClient, adOrgClient, poId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromPOSOTrx(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT o.C_ORDER_ID, Ad_Column_Identifier(TO_CHAR('C_Order'), TO_CHAR(o.c_order_id), TO_CHAR(?)) AS NAME, " +
      "        l.QtyOrdered-COALESCE(l.qtydelivered,0) AS QTY, l.C_UOM_ID,uom.UOMSymbol, l.M_Product_ID,p.NAME AS RELATION_NAME, " +
      "        l.C_OrderLine_ID,l.Line, l.C_OrderLine_ID AS ID, l.DESCRIPTION AS DESCRIPTION" +
      "        FROM M_INOUT_CANDIDATE_V ic, C_ORDER o, C_UOM uom, C_ORDERLINE l, M_PRODUCT p " +
      "        WHERE o.C_ORDER_ID = l.C_ORDER_ID" +
      "        AND o.C_ORDER_ID = ic.C_ORDER_ID " +
      "        AND ic.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ic.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.C_UOM_ID = uom.C_UOM_ID" +
      "        AND l.M_Product_ID=p.M_Product_ID " +
      "        AND ic.C_Order_ID = ? " +
      "        GROUP BY o.C_ORDER_ID, o.DocumentNo, o.DateOrdered, o.GrandTotal, l.QtyOrdered,l.qtydelivered, " +
      "        l.C_UOM_ID,uom.UOMSymbol,l.M_Product_ID,p.NAME,l.Line,l.C_OrderLine_ID, l.ad_org_id, l.DESCRIPTION" +
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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromPOSOTrxCombo(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cBpartnerId, String isSotrx)    throws ServletException {
    return selectFromPOSOTrxCombo(connectionProvider, language, adUserClient, adOrgClient, cBpartnerId, isSotrx, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromPOSOTrxCombo(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cBpartnerId, String isSotrx, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT o.C_ORDER_ID as ID, Ad_Column_Identifier(TO_CHAR('C_Order'), TO_CHAR(o.c_order_id), TO_CHAR(?)) AS NAME" +
      "        FROM M_INOUT_CANDIDATE_V ic, C_ORDER o" +
      "        WHERE o.C_ORDER_ID = ic.C_ORDER_ID " +
      "        AND ic.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ic.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND ic.C_BPartner_ID = ? " +
      "        AND ic.issotrx = ?" +
      "        GROUP BY o.C_ORDER_ID, o.DocumentNo, o.DateOrdered, o.GrandTotal " +
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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromOrderReturnCombo(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cBpartnerId, String isSotrx)    throws ServletException {
    return selectFromOrderReturnCombo(connectionProvider, language, adUserClient, adOrgClient, cBpartnerId, isSotrx, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromOrderReturnCombo(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cBpartnerId, String isSotrx, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT o.C_ORDER_ID as ID, Ad_Column_Identifier(TO_CHAR('C_Order'), TO_CHAR(o.c_order_id), TO_CHAR(?)) AS NAME" +
      "        FROM c_orderline ol, C_ORDER o" +
      "        WHERE o.C_ORDER_ID = ol.C_ORDER_ID " +
      "        AND o.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND o.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND o.C_BPartner_ID = ?" +
      "        AND o.issotrx = ? " +
      "        AND o.docstatus='CO'" +
      "        AND ol.qtydelivered > 0" +
      "        GROUP BY o.C_ORDER_ID, o.DocumentNo, o.DateOrdered, o.GrandTotal " +
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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromPOTrlSOTrx(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId)    throws ServletException {
    return selectFromPOTrlSOTrx(connectionProvider, language, adUserClient, adOrgClient, poId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromPOTrlSOTrx(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT o.C_ORDER_ID, Ad_Column_Identifier(TO_CHAR('C_Order'), TO_CHAR(o.c_order_id), TO_CHAR(?)) AS NAME, " +
      "        l.QtyOrdered-COALESCE(l.qtydelivered,0) AS QTY, l.C_UOM_ID, COALESCE(uomt.UOMSymbol, uom.UOMSymbol) AS UOMSymbol, " +
      "        l.M_Product_ID,p.NAME AS RELATION_NAME, l.C_OrderLine_ID, l.Line, l.C_OrderLine_ID AS ID, l.DESCRIPTION AS DESCRIPTION" +
      "        FROM C_UOM uom left join C_UOM_TRL uomt on uom.C_UOM_ID = uomt.C_UOM_ID" +
      "                                                and uomt.AD_Language = ?," +
      "        M_INOUT_CANDIDATE_V ic, C_ORDER o,   C_ORDERLINE l, M_PRODUCT p " +
      "        WHERE o.C_ORDER_ID = l.C_ORDER_ID" +
      "        AND o.C_ORDER_ID = ic.C_ORDER_ID " +
      "        AND ic.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ic.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.C_UOM_ID = uom.C_UOM_ID " +
      "        AND l.M_Product_ID=p.M_Product_ID " +
      "        AND ic.C_Order_ID = ? " +
      "        GROUP BY o.C_ORDER_ID, o.DocumentNo, o.DateOrdered, o.GrandTotal, l.QtyOrdered,l.qtydelivered, " +
      "        l.C_UOM_ID,uom.UOMSymbol,uomt.UOMSymbol,l.M_Product_ID,p.NAME,l.Line,l.C_OrderLine_ID, l.DESCRIPTION" +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromOrderReturn(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId)    throws ServletException {
    return selectFromOrderReturn(connectionProvider, language, adUserClient, adOrgClient, poId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromOrderReturn(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT o.C_ORDER_ID, Ad_Column_Identifier(TO_CHAR('C_Order'), TO_CHAR(o.c_order_id), TO_CHAR(?)) AS NAME, " +
      "        COALESCE(l.qtydelivered,0) AS QTY, l.C_UOM_ID, COALESCE(uomt.UOMSymbol, uom.UOMSymbol) AS UOMSymbol, " +
      "        l.M_Product_ID,p.NAME AS RELATION_NAME, l.C_OrderLine_ID, l.Line, l.C_OrderLine_ID AS ID, l.DESCRIPTION AS DESCRIPTION" +
      "        FROM C_UOM uom left join C_UOM_TRL uomt on uom.C_UOM_ID = uomt.C_UOM_ID" +
      "                                                and uomt.AD_Language = ?," +
      "        C_ORDER o,   C_ORDERLINE l, M_PRODUCT p " +
      "        WHERE o.C_ORDER_ID = l.C_ORDER_ID" +
      "        AND o.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND o.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.C_UOM_ID = uom.C_UOM_ID " +
      "        AND l.M_Product_ID=p.M_Product_ID " +
      "        AND o.C_Order_ID = ? " +
      "        GROUP BY o.C_ORDER_ID, o.DocumentNo, o.DateOrdered, o.GrandTotal, l.QtyOrdered,l.qtydelivered, " +
      "        l.C_UOM_ID,uom.UOMSymbol,uomt.UOMSymbol,l.M_Product_ID,p.NAME,l.Line,l.C_OrderLine_ID, l.DESCRIPTION" +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromPOUpdate(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId)    throws ServletException {
    return selectFromPOUpdate(conn, connectionProvider, cOrderlineId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromPOUpdate(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT l.QtyOrdered-SUM(COALESCE(m.Qty,0)) AS ID, l.C_UOM_ID,uom.UOMSymbol, l.M_Product_ID,p.NAME, l.C_OrderLine_ID," +
      "      l.Line, '' as C_InvoiceLine_ID, '' as M_InOutLine_ID, COALESCE(uom1.BREAKDOWN, 'N') AS BREAKDOWN, " +
      "      MAX(mu.C_UOM_ID) AS C_UOM_ID_Conversion, MAX(uom1.STDPRECISION) AS STDPRECISION, " +
      "      l.QUANTITYORDER*C_DIVIDE((l.QtyOrdered-SUM(COALESCE(m.Qty,0))),(l.QtyOrdered)) AS quantityOrder, l.M_Product_UOM_ID," +
      "      l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id, l.DESCRIPTION AS DESCRIPTION" +
      "      FROM C_ORDERLINE l left join M_MATCHPO m on l.C_OrderLine_ID=m.C_OrderLine_ID" +
      "                                              and  m.M_InOutLine_ID IS NOT NULL " +
      "                         left join M_Product_UOM mu on l.M_Product_UOM_ID = mu.M_Product_UOM_ID" +
      "                         left join C_UOM uom1 on mu.C_UOM_ID = uom1.C_UOM_ID," +
      "      C_UOM uom,  M_PRODUCT p " +
      "      WHERE l.C_UOM_ID=uom.C_UOM_ID" +
      "      AND l.M_Product_ID=p.M_Product_ID";
    strSql = strSql + ((cOrderlineId==null || cOrderlineId.equals(""))?"":"  AND l.C_OrderLine_ID IN " + cOrderlineId);
    strSql = strSql + 
      "      GROUP BY l.QtyOrdered,l.qtydelivered,l.C_UOM_ID,uom.UOMSymbol,l.M_Product_ID,p.NAME,l.Line,l.C_OrderLine_ID, " +
      "      uom1.BREAKDOWN, l.QUANTITYORDER, l.M_Product_UOM_ID, l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id, l.DESCRIPTION" +
      "      ORDER BY l.Line";

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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectCreateFromShipmentData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectCreateFromShipmentData.breakdown = UtilSql.getValue(result, "breakdown");
        objectCreateFromShipmentData.cUomIdConversion = UtilSql.getValue(result, "c_uom_id_conversion");
        objectCreateFromShipmentData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectCreateFromShipmentData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectCreateFromShipmentData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectCreateFromShipmentData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCreateFromShipmentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromPOUpdateSOTrx(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId)    throws ServletException {
    return selectFromPOUpdateSOTrx(conn, connectionProvider, cOrderlineId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromPOUpdateSOTrx(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT l.QtyOrdered - COALESCE(l.QTYDELIVERED,0) AS ID, l.C_UOM_ID,uom.UOMSymbol, l.M_Product_ID,p.NAME, l.C_OrderLine_ID," +
      "      l.Line, '' as C_InvoiceLine_ID, '' as M_InOutLine_ID, COALESCE(uom1.BREAKDOWN, 'N') AS BREAKDOWN, " +
      "      MAX(mu.C_UOM_ID) AS C_UOM_ID_Conversion, MAX(uom1.STDPRECISION) AS STDPRECISION, " +
      "      l.QUANTITYORDER*C_DIVIDE((l.QtyOrdered - COALESCE(l.QTYDELIVERED,0)),(l.QtyOrdered)) as quantityOrder, l.M_Product_UOM_ID," +
      "      l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id, l.DESCRIPTION AS DESCRIPTION" +
      "      FROM C_ORDERLINE l left join M_Product_UOM mu on l.M_Product_UOM_ID = mu.M_Product_UOM_ID" +
      "                         left join C_UOM uom1 on mu.C_UOM_ID = uom1.C_UOM_ID ," +
      "      C_UOM uom,  M_PRODUCT p  " +
      "      WHERE l.C_UOM_ID=uom.C_UOM_ID" +
      "      AND l.M_Product_ID=p.M_Product_ID";
    strSql = strSql + ((cOrderlineId==null || cOrderlineId.equals(""))?"":"  AND l.C_OrderLine_ID IN " + cOrderlineId);
    strSql = strSql + 
      "      GROUP BY l.QtyOrdered,l.qtydelivered,l.C_UOM_ID,uom.UOMSymbol,l.M_Product_ID,p.NAME,l.Line,l.C_OrderLine_ID, " +
      "      uom1.BREAKDOWN, l.QUANTITYORDER, l.M_Product_UOM_ID, l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id, l.DESCRIPTION" +
      "      HAVING l.QtyOrdered - COALESCE(l.QTYDELIVERED,0)<>0" +
      "      ORDER BY l.Line";

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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectCreateFromShipmentData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectCreateFromShipmentData.breakdown = UtilSql.getValue(result, "breakdown");
        objectCreateFromShipmentData.cUomIdConversion = UtilSql.getValue(result, "c_uom_id_conversion");
        objectCreateFromShipmentData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectCreateFromShipmentData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectCreateFromShipmentData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectCreateFromShipmentData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCreateFromShipmentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectLoopFromOrderReturn(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId)    throws ServletException {
    return selectLoopFromOrderReturn(conn, connectionProvider, cOrderlineId, 0, 0);
  }

  public static CreateFromShipmentData[] selectLoopFromOrderReturn(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT l.QTYDELIVERED AS ID, l.C_UOM_ID,uom.UOMSymbol, l.M_Product_ID,p.NAME, l.C_OrderLine_ID," +
      "      l.Line, '' as C_InvoiceLine_ID, '' as M_InOutLine_ID,'N' AS BREAKDOWN, " +
      "      null AS C_UOM_ID_Conversion, uom.STDPRECISION AS STDPRECISION, " +
      "      l.QUANTITYORDER as quantityOrder, l.M_Product_UOM_ID," +
      "      l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id, l.DESCRIPTION AS DESCRIPTION" +
      "      FROM C_ORDERLINE l ," +
      "      C_UOM uom,  M_PRODUCT p  " +
      "      WHERE l.C_UOM_ID=uom.C_UOM_ID" +
      "      AND l.M_Product_ID=p.M_Product_ID";
    strSql = strSql + ((cOrderlineId==null || cOrderlineId.equals(""))?"":"  AND l.C_OrderLine_ID IN " + cOrderlineId);
    strSql = strSql + 
      "      AND l.qtydelivered > 0" +
      "      ORDER BY l.Line";

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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectCreateFromShipmentData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectCreateFromShipmentData.breakdown = UtilSql.getValue(result, "breakdown");
        objectCreateFromShipmentData.cUomIdConversion = UtilSql.getValue(result, "c_uom_id_conversion");
        objectCreateFromShipmentData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectCreateFromShipmentData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectCreateFromShipmentData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectCreateFromShipmentData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCreateFromShipmentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromInvoice(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cInvoiceId)    throws ServletException {
    return selectFromInvoice(connectionProvider, language, adUserClient, adOrgClient, cInvoiceId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromInvoice(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cInvoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT i.C_Invoice_ID, Ad_Column_Identifier(TO_CHAR('C_Invoice'), TO_CHAR(i.C_Invoice_ID), TO_CHAR(?)) AS NAME, " +
      "        l.QtyInvoiced-SUM(COALESCE(mi.Qty,0)) AS QTY, l.C_UOM_ID,uom.UOMSymbol," +
      "        l.M_Product_ID,p.NAME AS RELATION_NAME, l.C_InvoiceLine_ID,l.Line, l.C_OrderLine_ID, l.C_InvoiceLine_ID AS ID, l.DESCRIPTION AS DESCRIPTION," +
      "        (l.QtyInvoiced-SUM(COALESCE(mi.Qty,0))/COALESCE(" +
      "        (SELECT MULTIPLYRATE FROM C_UOM_CONVERSION WHERE C_UOM_CONVERSION.C_UOM_ID =" +
      "        (SELECT C_UOM.C_UOM_ID FROM M_PRODUCT_UOM, C_UOM WHERE M_PRODUCT_UOM_ID = l.M_PRODUCT_UOM_ID AND M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID)        " +
      "        AND C_UOM_CONVERSION.C_UOM_TO_ID = l.C_UOM_ID),1))" +
      "        as SECQTY, l.M_PRODUCT_UOM_ID as SEC_PRODUCT_UOM_ID," +
      "        (SELECT C_UOM.NAME FROM M_PRODUCT_UOM, C_UOM WHERE M_PRODUCT_UOM_ID = l.M_PRODUCT_UOM_ID AND M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID) as SECUOMSYMBOL," +
      "        COALESCE(l.M_PRODUCT_UOM_ID,null,'0') as HAVESEC,'' as HAVESECUOM,'' AS LOCATOR" +
      "        FROM C_INVOICELINE l left join  M_MATCHINV mi  on l.C_InvoiceLine_ID=mi.C_InvoiceLine_ID," +
      "        C_INVOICE i, C_UOM uom,  M_PRODUCT p" +
      "        WHERE i.C_INVOICE_ID = l.C_INVOICE_ID " +
      "        AND i.IsSOTrx='N' " +
      "        AND i.DocStatus IN ('CL','CO') " +
      "        AND i.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND i.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.C_UOM_ID=uom.C_UOM_ID " +
      "        AND l.M_Product_ID=p.M_Product_ID " +
      "        AND l.C_Invoice_ID = ? " +
      "        GROUP BY i.C_Invoice_ID, i.DocumentNo, DateInvoiced, GrandTotal, l.QtyInvoiced, " +
      "        l.C_UOM_ID,uom.UOMSymbol,l.M_Product_ID,p.NAME, l.C_InvoiceLine_ID,l.Line,l.C_OrderLine_ID, l.DESCRIPTION,l.QUANTITYORDER, l.M_PRODUCT_UOM_ID" +
      "        HAVING (l.QtyInvoiced-SUM(COALESCE(mi.Qty,0))) <> 0 " +
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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromShipmentData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.secqty = UtilSql.getValue(result, "secqty");
        objectCreateFromShipmentData.secProductUomId = UtilSql.getValue(result, "sec_product_uom_id");
        objectCreateFromShipmentData.secuomsymbol = UtilSql.getValue(result, "secuomsymbol");
        objectCreateFromShipmentData.havesec = UtilSql.getValue(result, "havesec");
        objectCreateFromShipmentData.havesecuom = UtilSql.getValue(result, "havesecuom");
        objectCreateFromShipmentData.locator = UtilSql.getValue(result, "locator");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromInvoiceTrx(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cInvoiceId)    throws ServletException {
    return selectFromInvoiceTrx(connectionProvider, language, adUserClient, adOrgClient, cInvoiceId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromInvoiceTrx(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cInvoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  distinct i.C_Invoice_ID, Ad_Column_Identifier(TO_CHAR('C_Invoice'), TO_CHAR(i.C_Invoice_ID), TO_CHAR(?)) AS NAME, " +
      "        l.QtyInvoiced-l.qtydelivered AS QTY, l.C_UOM_ID,uom.UOMSymbol," +
      "        l.M_Product_ID,p.NAME AS RELATION_NAME, i.C_Orderline_ID,l.Line, l.C_OrderLine_ID, l.C_OrderLine_ID AS ID, " +
      "        i.DESCRIPTION AS DESCRIPTION" +
      "        FROM C_INVOICELINE i,c_orderline l , C_UOM uom,  M_PRODUCT p" +
      "        WHERE i.C_ORDERline_ID = l.C_orderline_ID " +
      "        AND i.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND i.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.C_UOM_ID=uom.C_UOM_ID " +
      "        AND l.M_Product_ID=p.M_Product_ID " +
      "        AND i.C_Invoice_ID = ?" +
      "        AND l.qtyinvoiced>l.qtydelivered";

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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromInvoiceTrxCombo(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cBpartnerId, String isSotrx)    throws ServletException {
    return selectFromInvoiceTrxCombo(connectionProvider, language, adUserClient, adOrgClient, cBpartnerId, isSotrx, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromInvoiceTrxCombo(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cBpartnerId, String isSotrx, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT i.C_Invoice_ID AS ID, Ad_Column_Identifier(TO_CHAR('C_Invoice'), TO_CHAR(i.C_Invoice_ID), TO_CHAR(?)) AS NAME" +
      "        FROM C_INVOICE i " +
      "        WHERE i.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND i.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "        AND i.C_BPartner_ID = ?" +
      "        AND i.issotrx = ?" +
      "        AND i.c_doctype_id in ('0AC8991D82484092B1B56A660B223527','45A90145C74C44ECB48AC772B05487CA')" +
      "        ANd i.docstatus='CO'" +
      "        AND EXISTS (SELECT 1 " +
      "                     FROM C_INVOICELINE l ,c_orderline ol" +
      "                      WHERE l.C_orderLine_ID=ol.C_orderLine_ID" +
      "                      and l.C_INVOICE_ID = i.C_INVOICE_ID " +
      "                      and ol.qtyinvoiced>ol.qtydelivered)" +
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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromInvoiceUpdate(Connection conn, ConnectionProvider connectionProvider, String cInvoicelineId)    throws ServletException {
    return selectFromInvoiceUpdate(conn, connectionProvider, cInvoicelineId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromInvoiceUpdate(Connection conn, ConnectionProvider connectionProvider, String cInvoicelineId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT l.QtyInvoiced-SUM(COALESCE(mi.Qty,0)) AS ID, l.C_UOM_ID,uom.UOMSymbol," +
      "      l.M_Product_ID,p.NAME, l.C_InvoiceLine_ID,l.Line, l.C_OrderLine_ID, COALESCE(uom1.BREAKDOWN, 'N') AS BREAKDOWN, " +
      "      MAX(mu.C_UOM_ID) AS C_UOM_ID_Conversion, MAX(uom1.STDPRECISION) AS STDPRECISION, l.QUANTITYORDER, l.M_Product_UOM_ID," +
      "      l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id, l.DESCRIPTION AS DESCRIPTION" +
      "      FROM C_INVOICELINE l left join  M_Product_UOM mu on l.M_Product_UOM_ID = mu.M_Product_UOM_ID " +
      "                           left join C_UOM uom1 on mu.C_UOM_ID = uom1.C_UOM_ID " +
      "                           left join M_MATCHINV mi on l.C_InvoiceLine_ID=mi.C_InvoiceLine_ID," +
      "      C_UOM uom,  M_PRODUCT p" +
      "      WHERE l.C_UOM_ID=uom.C_UOM_ID" +
      "      AND l.M_Product_ID=p.M_Product_ID ";
    strSql = strSql + ((cInvoicelineId==null || cInvoicelineId.equals(""))?"":"  AND l.C_InvoiceLine_ID IN " + cInvoicelineId);
    strSql = strSql + 
      "      GROUP BY l.QtyInvoiced," +
      "      l.C_UOM_ID,uom.UOMSymbol,l.M_Product_ID,p.NAME, l.C_InvoiceLine_ID,l.Line,l.C_OrderLine_ID, " +
      "      uom1.BREAKDOWN, l.QUANTITYORDER, l.M_Product_UOM_ID, l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id, l.DESCRIPTION" +
      "      HAVING l.QtyInvoiced-SUM(COALESCE(mi.Qty,0))<>0" +
      "      ORDER BY l.Line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      if (cInvoicelineId != null && !(cInvoicelineId.equals(""))) {
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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.breakdown = UtilSql.getValue(result, "breakdown");
        objectCreateFromShipmentData.cUomIdConversion = UtilSql.getValue(result, "c_uom_id_conversion");
        objectCreateFromShipmentData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectCreateFromShipmentData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectCreateFromShipmentData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectCreateFromShipmentData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCreateFromShipmentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromInvoiceTrxUpdate(Connection conn, ConnectionProvider connectionProvider, String cInvoicelineId)    throws ServletException {
    return selectFromInvoiceTrxUpdate(conn, connectionProvider, cInvoicelineId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromInvoiceTrxUpdate(Connection conn, ConnectionProvider connectionProvider, String cInvoicelineId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT l.QtyInvoiced-l.qtydelivered AS ID, l.C_UOM_ID,uom.UOMSymbol," +
      "      l.M_Product_ID,p.NAME, i.C_InvoiceLine_ID,i.Line, l.C_OrderLine_ID,  'N' AS BREAKDOWN, " +
      "      null AS C_UOM_ID_Conversion, uom.STDPRECISION AS STDPRECISION, l.QUANTITYORDER, l.M_Product_UOM_ID," +
      "      l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id, i.DESCRIPTION AS DESCRIPTION" +
      "      FROM C_INVOICELINE i,c_orderline l , C_UOM uom,  M_PRODUCT p" +
      "        WHERE i.C_ORDERline_ID = l.C_orderline_ID " +
      "        AND l.C_UOM_ID=uom.C_UOM_ID " +
      "        AND l.M_Product_ID=p.M_Product_ID ";
    strSql = strSql + ((cInvoicelineId==null || cInvoicelineId.equals(""))?"":"  AND i.C_InvoiceLine_ID IN " + cInvoicelineId);
    strSql = strSql + 
      "        AND l.qtyinvoiced>l.qtydelivered" +
      "        ORDER BY i.Line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      if (cInvoicelineId != null && !(cInvoicelineId.equals(""))) {
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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.breakdown = UtilSql.getValue(result, "breakdown");
        objectCreateFromShipmentData.cUomIdConversion = UtilSql.getValue(result, "c_uom_id_conversion");
        objectCreateFromShipmentData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectCreateFromShipmentData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectCreateFromShipmentData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectCreateFromShipmentData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCreateFromShipmentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] set()    throws ServletException {
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[1];
    objectCreateFromShipmentData[0] = new CreateFromShipmentData();
    objectCreateFromShipmentData[0].id = "";
    objectCreateFromShipmentData[0].cUomId = "";
    objectCreateFromShipmentData[0].uomsymbol = "";
    objectCreateFromShipmentData[0].mProductId = "";
    objectCreateFromShipmentData[0].name = "";
    objectCreateFromShipmentData[0].cInvoicelineId = "";
    objectCreateFromShipmentData[0].line = "";
    objectCreateFromShipmentData[0].cOrderlineId = "";
    objectCreateFromShipmentData[0].breakdown = "";
    objectCreateFromShipmentData[0].cUomIdConversion = "";
    objectCreateFromShipmentData[0].stdprecision = "";
    objectCreateFromShipmentData[0].quantityorder = "";
    objectCreateFromShipmentData[0].mProductUomId = "";
    objectCreateFromShipmentData[0].mAttributesetinstanceId = "";
    objectCreateFromShipmentData[0].adOrgId = "";
    objectCreateFromShipmentData[0].description = "";
    return objectCreateFromShipmentData;
  }

  public static String selectLocator(ConnectionProvider connectionProvider, String mLocatorId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT VALUE FROM M_LOCATOR WHERE M_LOCATOR_ID=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "value");
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

  public static String selectBPartner(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NAME FROM C_BPARTNER WHERE C_BPARTNER_ID=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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

  public static String isInvoiced(Connection conn, ConnectionProvider connectionProvider, String cInvoicelineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT PROCESSED FROM C_INVOICE WHERE C_INVOICE_ID=(SELECT C_INVOICE_ID FROM C_INVOICELINE WHERE C_INVOICELINE_ID = ?)";

    ResultSet result;
    String strReturn = "N";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "processed");
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
    return(strReturn);
  }

  public static String selectProjectId(ConnectionProvider connectionProvider, String cOrderlineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT c_project_id FROM c_orderline WHERE c_orderline_id=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);

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

  public static String selectProjectTaskId(ConnectionProvider connectionProvider, String cOrderlineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT c_ProjectTask_Id FROM c_orderline WHERE c_orderline_id=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_projecttask_id");
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

  public static String selectAssetId(ConnectionProvider connectionProvider, String cOrderlineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT a_Asset_Id FROM c_orderline WHERE c_orderline_id=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "a_asset_id");
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

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String mInoutlineId, String mInoutId, String adClientId, String adOrgId, String adUserId, String description, String mProductId, String cUomId, String movementqty, String cOrderlineId, String mLocatorId, String isinvoiced, String quantityorder, String mProductUomId, String mAttributesetinstanceId, String cProjectId, String cProjecttaskId, String aAssetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO M_INOUTLINE " +
      "        (M_InOutLine_ID,M_InOut_ID, AD_Client_ID,AD_Org_ID," +
      "         IsActive,Created,CreatedBy,Updated, UpdatedBy, " +
      "         Line,Description, M_Product_ID," +
      "         C_UOM_ID,MovementQty,C_OrderLine_ID," +
      "         M_Locator_ID,IsInvoiced, QUANTITYORDER, " +
      "         M_PRODUCT_UOM_ID, M_ATTRIBUTESETINSTANCE_ID, " +
      "         C_PROJECT_ID, C_PROJECTTASK_ID, A_ASSET_ID)" +
      "      VALUES " +
      "        (?, ?, ?, ?, " +
      "         'Y', now(), ?, now(), ?, " +
      "         (SELECT (COALESCE(Max(Line),0))+10 FROM M_InOutLine WHERE M_InOut_ID=?), ?, ?, " +
      "         ?, TO_NUMBER(?), ?, " +
      "         ?, ?, TO_NUMBER(?), " +
      "         ?, ?," +
      "         ?, ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
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

  public static int updateInvoice(Connection conn, ConnectionProvider connectionProvider, String mInoutlineId, String cInvoicelineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_InvoiceLine SET M_InoutLine_id = ?" +
      "      WHERE C_InvoiceLine_ID= ? " +
      "      AND M_InOutLine_ID IS NULL";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
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

  public static int updateInvoiceOrder(Connection conn, ConnectionProvider connectionProvider, String mInoutlineId, String cOrderlineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_InvoiceLine SET M_InoutLine_id = ?" +
      "      WHERE C_OrderLine_ID= ? " +
      "      AND M_InOutLine_ID IS NULL";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);

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

  public static int updateC_Order_ID(Connection conn, ConnectionProvider connectionProvider, String cOrderId, String mInoutId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE M_InOut SET C_Order_id = ?, DATEORDERED = (SELECT DATEORDERED FROM C_ORDER WHERE C_ORDER_ID=?)" +
      "      WHERE M_InOut_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);

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

  public static int updateC_Invoice_ID(Connection conn, ConnectionProvider connectionProvider, String cInvoiceId, String mInoutId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE M_InOut SET C_Invoice_id = ?" +
      "      WHERE M_InOut_ID= ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);

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

  public static int deleteC_Order_ID(Connection conn, ConnectionProvider connectionProvider, String mInoutId, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE M_InOut SET C_Order_ID=NULL " +
      "      WHERE M_InOut_ID= ?" +
      "      AND C_Order_ID IS NOT NULL " +
      "      AND C_Order_ID <> ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
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

  public static int deleteC_Invoice_ID(Connection conn, ConnectionProvider connectionProvider, String mInoutId, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE M_InOut SET C_Invoice_ID=NULL " +
      "      WHERE M_InOut_ID= ?" +
      "      AND C_Invoice_ID IS NOT NULL " +
      "      AND C_Invoice_ID <> ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
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

  public static String multiplyRate(ConnectionProvider connectionProvider, String mProductUOM, String mProduct)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT MULTIPLYRATE FROM C_UOM_CONVERSION WHERE C_UOM_ID = ? AND C_UOM_TO_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUOM);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProduct);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "multiplyrate");
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

  public static String divideRate(ConnectionProvider connectionProvider, String mProduct, String mProductUOM)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT DIVIDERATE FROM C_UOM_CONVERSION WHERE C_UOM_ID = ? AND C_UOM_TO_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUOM);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "dividerate");
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

  public static CreateFromShipmentData[] selectUOM(ConnectionProvider connectionProvider, String MProductID)    throws ServletException {
    return selectUOM(connectionProvider, MProductID, 0, 0);
  }

  public static CreateFromShipmentData[] selectUOM(ConnectionProvider connectionProvider, String MProductID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT M_PRODUCT_UOM_ID AS ID,  C_UOM.NAME FROM M_PRODUCT_UOM, C_UOM" +
      "    WHERE M_PRODUCT_ID = ?" +
      "    AND M_PRODUCT_UOM.C_UOM_ID =  C_UOM.C_UOM_ID";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MProductID);

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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectcUomIdConversion(ConnectionProvider connectionProvider, String mProductUomId)    throws ServletException {
    return selectcUomIdConversion(connectionProvider, mProductUomId, 0, 0);
  }

  public static CreateFromShipmentData[] selectcUomIdConversion(ConnectionProvider connectionProvider, String mProductUomId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT M_PRODUCT_UOM.C_UOM_ID AS C_UOM_ID_Conversion, COALESCE(BREAKDOWN, 'N') AS BREAKDOWN, STDPRECISION FROM M_PRODUCT_UOM,C_UOM" +
      "      WHERE  M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID " +
      "      AND M_PRODUCT_UOM_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);

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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.cUomIdConversion = UtilSql.getValue(result, "c_uom_id_conversion");
        objectCreateFromShipmentData.breakdown = UtilSql.getValue(result, "breakdown");
        objectCreateFromShipmentData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }
}
