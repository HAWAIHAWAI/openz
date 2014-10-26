//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class COrderLineData implements FieldProvider {
static Logger log4j = Logger.getLogger(COrderLineData.class);
  private String InitRecordNumber="0";
  public String cOrderlineId;
  public String line;
  public String mProductId;
  public String qtyordered;
  public String priceactual;
  public String cTaxId;
  public String freightamt;
  public String adClientId;
  public String adOrgId;
  public String adUserId;
  public String cOrderId;
  public String pricelist;
  public String pricestd;
  public String pricelimit;
  public String discount;
  public String cUomId;
  public String dateordered;
  public String mWarehouseId;
  public String cCurrencyId;
  public String description;
  public String cBpartnerId;
  public String cBpartnerLocationId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("freightamt"))
      return freightamt;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("discount"))
      return discount;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static COrderLineData[] select(ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    return select(connectionProvider, ad_client_id, 0, 0);
  }

  public static COrderLineData[] select(ConnectionProvider connectionProvider, String ad_client_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ol.C_OrderLine_ID, ol.Line, ol.M_Product_ID, ol.QtyOrdered, ol.PriceActual, ol.C_Tax_ID, ol.FreightAmt," +
      "				ol.AD_Client_ID, ol.AD_Org_ID, o.AD_User_ID, ol.C_Order_ID, ol.PriceList, ol.PriceStd, ol.PriceLimit, ol.Discount, ol.C_UOM_ID," +
      "				ol.DateOrdered, ol.M_Warehouse_ID, ol.C_Currency_ID, ol.Description, ol.C_BPartner_ID, ol.C_BPartner_Location_ID" +
      "			  FROM C_OrderLine ol, C_Order o" +
      "				WHERE ol.C_Order_ID = o.C_Order_ID" +
      "			  AND ol.AD_Client_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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
        COrderLineData objectCOrderLineData = new COrderLineData();
        objectCOrderLineData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCOrderLineData.line = UtilSql.getValue(result, "line");
        objectCOrderLineData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCOrderLineData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectCOrderLineData.priceactual = UtilSql.getValue(result, "priceactual");
        objectCOrderLineData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectCOrderLineData.freightamt = UtilSql.getValue(result, "freightamt");
        objectCOrderLineData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCOrderLineData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCOrderLineData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectCOrderLineData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectCOrderLineData.pricelist = UtilSql.getValue(result, "pricelist");
        objectCOrderLineData.pricestd = UtilSql.getValue(result, "pricestd");
        objectCOrderLineData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectCOrderLineData.discount = UtilSql.getValue(result, "discount");
        objectCOrderLineData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCOrderLineData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectCOrderLineData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectCOrderLineData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCOrderLineData.description = UtilSql.getValue(result, "description");
        objectCOrderLineData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCOrderLineData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectCOrderLineData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCOrderLineData);
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
    COrderLineData objectCOrderLineData[] = new COrderLineData[vector.size()];
    vector.copyInto(objectCOrderLineData);
    return(objectCOrderLineData);
  }

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "              INSERT INTO C_OrderLine " +
      "                (C_OrderLine_ID, AD_Client_ID, AD_Org_ID, isActive, Created, CreatedBy, Updated, UpdatedBy," +
      "                Line, M_Product_ID, QtyOrdered, PriceActual, C_Tax_ID, " +
      "                FreightAmt, C_Order_ID, PriceList, PriceStd, PriceLimit," +
      "                Discount, C_UOM_ID, DateOrdered, M_Warehouse_ID, C_Currency_ID, Description, C_BPartner_ID, C_BPartner_Location_ID)" +
      "                VALUES " +
      "                (?, ?, ?, 'Y', now(), ?, now(), ?, " +
      "                 TO_NUMBER(?), ?, TO_NUMBER(?), TO_NUMBER(?), ?, " +
      "                 COALESCE(TO_NUMBER(?), 0), ?, TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), " +
      "                 TO_NUMBER(?), ?, TO_DATE(?), ?, ?, ?, ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricestd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);

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
