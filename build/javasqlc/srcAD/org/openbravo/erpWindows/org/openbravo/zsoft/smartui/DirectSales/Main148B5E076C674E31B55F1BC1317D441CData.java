//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.DirectSales;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

/**
WAD Generated class
 */
class Main148B5E076C674E31B55F1BC1317D441CData implements FieldProvider {
static Logger log4j = Logger.getLogger(Main148B5E076C674E31B55F1BC1317D441CData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssiDirectsalesId;
  public String textlines;
  public String adClientId;
  public String dateofsale;
  public String mProductId;
  public String mProductIdr;
  public String qty;
  public String priceactual;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String cUomId;
  public String cUomIdr;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String mAttributesetinstanceId;
  public String mAttributesetinstanceIdr;
  public String cOrderId;
  public String cOrderIdr;
  public String cInvoiceId;
  public String cInvoiceIdr;
  public String action;
  public String processed;
  public String isposted;
  public String isactive;
  public String adOrgId;
  public String adOrgIdr;
  public String language;
  public String adUserClient;
  public String adOrgClient;
  public String createdby;
  public String trBgcolor;
  public String totalCount;
  public String dateTimeFormat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdbyr"))
      return createdbyr;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updated_time_stamp") || fieldName.equals("updatedTimeStamp"))
      return updatedTimeStamp;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("updatedbyr"))
      return updatedbyr;
    else if (fieldName.equalsIgnoreCase("zssi_directsales_id") || fieldName.equals("zssiDirectsalesId"))
      return zssiDirectsalesId;
    else if (fieldName.equalsIgnoreCase("textlines"))
      return textlines;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("dateofsale"))
      return dateofsale;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_idr") || fieldName.equals("mAttributesetinstanceIdr"))
      return mAttributesetinstanceIdr;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_order_idr") || fieldName.equals("cOrderIdr"))
      return cOrderIdr;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("c_invoice_idr") || fieldName.equals("cInvoiceIdr"))
      return cInvoiceIdr;
    else if (fieldName.equalsIgnoreCase("action"))
      return action;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("isposted"))
      return isposted;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("language"))
      return language;
    else if (fieldName.equals("adUserClient"))
      return adUserClient;
    else if (fieldName.equals("adOrgClient"))
      return adOrgClient;
    else if (fieldName.equals("createdby"))
      return createdby;
    else if (fieldName.equals("trBgcolor"))
      return trBgcolor;
    else if (fieldName.equals("totalCount"))
      return totalCount;
    else if (fieldName.equals("dateTimeFormat"))
      return dateTimeFormat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for edit
 */
  public static Main148B5E076C674E31B55F1BC1317D441CData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Main148B5E076C674E31B55F1BC1317D441CData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_directsales.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_directsales.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_directsales.Updated, ?) as updated, " +
      "        to_char(zssi_directsales.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_directsales.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_directsales.UpdatedBy) as UpdatedByR," +
      "        zssi_directsales.Zssi_Directsales_ID, " +
      "zssi_directsales.Textlines, " +
      "zssi_directsales.AD_Client_ID, " +
      "zssi_directsales.Dateofsale, " +
      "zssi_directsales.M_Product_ID, " +
      "(CASE WHEN zssi_directsales.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "zssi_directsales.Qty, " +
      "zssi_directsales.Priceactual, " +
      "zssi_directsales.C_Bpartner_ID, " +
      "(CASE WHEN zssi_directsales.C_Bpartner_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "zssi_directsales.C_Bpartner_Location_ID, " +
      "(CASE WHEN zssi_directsales.C_Bpartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Bpartner_Location_IDR, " +
      "zssi_directsales.C_Uom_ID, " +
      "(CASE WHEN zssi_directsales.C_Uom_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS C_Uom_IDR, " +
      "zssi_directsales.C_Currency_ID, " +
      "(CASE WHEN zssi_directsales.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "zssi_directsales.M_Warehouse_ID, " +
      "(CASE WHEN zssi_directsales.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "zssi_directsales.M_Attributesetinstance_ID, " +
      "(CASE WHEN zssi_directsales.M_Attributesetinstance_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Description), ''))),'') ) END) AS M_Attributesetinstance_IDR, " +
      "zssi_directsales.C_Order_ID, " +
      "(CASE WHEN zssi_directsales.C_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table8.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.GrandTotal), ''))),'') ) END) AS C_Order_IDR, " +
      "zssi_directsales.C_Invoice_ID, " +
      "(CASE WHEN zssi_directsales.C_Invoice_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table9.DateInvoiced, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.GrandTotal), ''))),'') ) END) AS C_Invoice_IDR, " +
      "zssi_directsales.Action, " +
      "COALESCE(zssi_directsales.Processed, 'N') AS Processed, " +
      "COALESCE(zssi_directsales.Isposted, 'N') AS Isposted, " +
      "COALESCE(zssi_directsales.Isactive, 'N') AS Isactive, " +
      "zssi_directsales.AD_Org_ID, " +
      "(CASE WHEN zssi_directsales.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_directsales left join (select M_Product_ID, Value, Name from M_Product) table1 on (zssi_directsales.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table2 on (zssi_directsales.C_Bpartner_ID =  table2.C_BPartner_ID) left join (select C_Bpartner_Location_ID, Name from C_Bpartner_Location) table3 on (zssi_directsales.C_Bpartner_Location_ID = table3.C_Bpartner_Location_ID) left join (select C_Uom_ID, Name from C_Uom) table4 on (zssi_directsales.C_Uom_ID = table4.C_Uom_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL4 on (table4.C_UOM_ID = tableTRL4.C_UOM_ID and tableTRL4.AD_Language = ?)  left join (select C_Currency_ID, ISO_Code from C_Currency) table5 on (zssi_directsales.C_Currency_ID = table5.C_Currency_ID) left join (select M_Warehouse_ID, Name from M_Warehouse) table6 on (zssi_directsales.M_Warehouse_ID = table6.M_Warehouse_ID) left join (select M_AttributeSetInstance_ID, Description from M_AttributeSetInstance) table7 on (zssi_directsales.M_Attributesetinstance_ID = table7.M_AttributeSetInstance_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table8 on (zssi_directsales.C_Order_ID = table8.C_Order_ID) left join (select C_Invoice_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice) table9 on (zssi_directsales.C_Invoice_ID = table9.C_Invoice_ID) left join (select AD_Org_ID, Name from AD_Org) table10 on (zssi_directsales.AD_Org_ID = table10.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND zssi_directsales.Zssi_Directsales_ID = ? " +
      "        AND zssi_directsales.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_directsales.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
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
        Main148B5E076C674E31B55F1BC1317D441CData objectMain148B5E076C674E31B55F1BC1317D441CData = new Main148B5E076C674E31B55F1BC1317D441CData();
        objectMain148B5E076C674E31B55F1BC1317D441CData.created = UtilSql.getValue(result, "created");
        objectMain148B5E076C674E31B55F1BC1317D441CData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectMain148B5E076C674E31B55F1BC1317D441CData.updated = UtilSql.getValue(result, "updated");
        objectMain148B5E076C674E31B55F1BC1317D441CData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectMain148B5E076C674E31B55F1BC1317D441CData.updatedby = UtilSql.getValue(result, "updatedby");
        objectMain148B5E076C674E31B55F1BC1317D441CData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectMain148B5E076C674E31B55F1BC1317D441CData.zssiDirectsalesId = UtilSql.getValue(result, "zssi_directsales_id");
        objectMain148B5E076C674E31B55F1BC1317D441CData.textlines = UtilSql.getValue(result, "textlines");
        objectMain148B5E076C674E31B55F1BC1317D441CData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMain148B5E076C674E31B55F1BC1317D441CData.dateofsale = UtilSql.getDateValue(result, "dateofsale", "dd-MM-yyyy");
        objectMain148B5E076C674E31B55F1BC1317D441CData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectMain148B5E076C674E31B55F1BC1317D441CData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectMain148B5E076C674E31B55F1BC1317D441CData.qty = UtilSql.getValue(result, "qty");
        objectMain148B5E076C674E31B55F1BC1317D441CData.priceactual = UtilSql.getValue(result, "priceactual");
        objectMain148B5E076C674E31B55F1BC1317D441CData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectMain148B5E076C674E31B55F1BC1317D441CData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectMain148B5E076C674E31B55F1BC1317D441CData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectMain148B5E076C674E31B55F1BC1317D441CData.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectMain148B5E076C674E31B55F1BC1317D441CData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectMain148B5E076C674E31B55F1BC1317D441CData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectMain148B5E076C674E31B55F1BC1317D441CData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectMain148B5E076C674E31B55F1BC1317D441CData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectMain148B5E076C674E31B55F1BC1317D441CData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectMain148B5E076C674E31B55F1BC1317D441CData.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectMain148B5E076C674E31B55F1BC1317D441CData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectMain148B5E076C674E31B55F1BC1317D441CData.mAttributesetinstanceIdr = UtilSql.getValue(result, "m_attributesetinstance_idr");
        objectMain148B5E076C674E31B55F1BC1317D441CData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectMain148B5E076C674E31B55F1BC1317D441CData.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectMain148B5E076C674E31B55F1BC1317D441CData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectMain148B5E076C674E31B55F1BC1317D441CData.cInvoiceIdr = UtilSql.getValue(result, "c_invoice_idr");
        objectMain148B5E076C674E31B55F1BC1317D441CData.action = UtilSql.getValue(result, "action");
        objectMain148B5E076C674E31B55F1BC1317D441CData.processed = UtilSql.getValue(result, "processed");
        objectMain148B5E076C674E31B55F1BC1317D441CData.isposted = UtilSql.getValue(result, "isposted");
        objectMain148B5E076C674E31B55F1BC1317D441CData.isactive = UtilSql.getValue(result, "isactive");
        objectMain148B5E076C674E31B55F1BC1317D441CData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMain148B5E076C674E31B55F1BC1317D441CData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectMain148B5E076C674E31B55F1BC1317D441CData.language = UtilSql.getValue(result, "language");
        objectMain148B5E076C674E31B55F1BC1317D441CData.adUserClient = "";
        objectMain148B5E076C674E31B55F1BC1317D441CData.adOrgClient = "";
        objectMain148B5E076C674E31B55F1BC1317D441CData.createdby = "";
        objectMain148B5E076C674E31B55F1BC1317D441CData.trBgcolor = "";
        objectMain148B5E076C674E31B55F1BC1317D441CData.totalCount = "";
        objectMain148B5E076C674E31B55F1BC1317D441CData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMain148B5E076C674E31B55F1BC1317D441CData);
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
    Main148B5E076C674E31B55F1BC1317D441CData objectMain148B5E076C674E31B55F1BC1317D441CData[] = new Main148B5E076C674E31B55F1BC1317D441CData[vector.size()];
    vector.copyInto(objectMain148B5E076C674E31B55F1BC1317D441CData);
    return(objectMain148B5E076C674E31B55F1BC1317D441CData);
  }

/**
Create a registry
 */
  public static Main148B5E076C674E31B55F1BC1317D441CData[] set(String qty, String cOrderId, String mAttributesetinstanceId, String mAttributesetinstanceIdr, String textlines, String mProductId, String mProductIdr, String priceactual, String cUomId, String cInvoiceId, String zssiDirectsalesId, String isactive, String createdby, String createdbyr, String cCurrencyId, String adClientId, String cBpartnerLocationId, String action, String cBpartnerId, String updatedby, String updatedbyr, String isposted, String dateofsale, String adOrgId, String processed, String mWarehouseId)    throws ServletException {
    Main148B5E076C674E31B55F1BC1317D441CData objectMain148B5E076C674E31B55F1BC1317D441CData[] = new Main148B5E076C674E31B55F1BC1317D441CData[1];
    objectMain148B5E076C674E31B55F1BC1317D441CData[0] = new Main148B5E076C674E31B55F1BC1317D441CData();
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].created = "";
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].createdbyr = createdbyr;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].updated = "";
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].updatedTimeStamp = "";
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].updatedby = updatedby;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].updatedbyr = updatedbyr;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].zssiDirectsalesId = zssiDirectsalesId;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].textlines = textlines;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].adClientId = adClientId;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].dateofsale = dateofsale;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].mProductId = mProductId;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].mProductIdr = mProductIdr;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].qty = qty;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].priceactual = priceactual;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].cBpartnerId = cBpartnerId;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].cBpartnerIdr = "";
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].cBpartnerLocationIdr = "";
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].cUomId = cUomId;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].cUomIdr = "";
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].cCurrencyId = cCurrencyId;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].cCurrencyIdr = "";
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].mWarehouseId = mWarehouseId;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].mWarehouseIdr = "";
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].mAttributesetinstanceId = mAttributesetinstanceId;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].mAttributesetinstanceIdr = mAttributesetinstanceIdr;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].cOrderId = cOrderId;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].cOrderIdr = "";
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].cInvoiceId = cInvoiceId;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].cInvoiceIdr = "";
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].action = action;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].processed = processed;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].isposted = isposted;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].isactive = isactive;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].adOrgId = adOrgId;
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].adOrgIdr = "";
    objectMain148B5E076C674E31B55F1BC1317D441CData[0].language = "";
    return objectMain148B5E076C674E31B55F1BC1317D441CData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef336CBA1BA7F64B5D8B3762929B153D3D_0(ConnectionProvider connectionProvider, String M_Attributesetinstance_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Description), '') ) as M_Attributesetinstance_ID FROM M_AttributeSetInstance table1 WHERE table1.isActive='Y' AND table1.M_AttributeSetInstance_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Attributesetinstance_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_attributesetinstance_id");
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
Select for auxiliar field
 */
  public static String selectDef87A706B233E1446385AEF5E9700B1042(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT textlines from zssi_directsales where processed='N' and length(textlines)=(select max(length(textlines)) from  zssi_directsales where processed='N' ) ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "textlines");
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
Select for auxiliar field
 */
  public static String selectDef5F96903D7A8B46ADA085FA8FBB32905F_1(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as M_Product_ID FROM M_Product table1 WHERE table1.isActive='Y' AND table1.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_product_id");
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
Select for auxiliar field
 */
  public static String selectDef22336F8DC0464153B97044ED323A1E4D_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Createdby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedbyR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "createdby");
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
Select for auxiliar field
 */
  public static String selectDef3F60381C78C543D49E16347196C577B6_3(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Updatedby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedbyR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updatedby");
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
Select for auxiliar field
 */
  public static String selectDefBB7F0D28BC144EDBBDA729BD762BA9D7(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(COALESCE(max(dateofsale),now()),'DD-MM-YYYY') AS DefaultValue from zssi_directsales where isposted='N' ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE zssi_directsales" +
      "        SET Zssi_Directsales_ID = (?) , Textlines = (?) , AD_Client_ID = (?) , Dateofsale = TO_DATE(?) , M_Product_ID = (?) , Qty = TO_NUMBER(?) , Priceactual = TO_NUMBER(?) , C_Bpartner_ID = (?) , C_Bpartner_Location_ID = (?) , C_Uom_ID = (?) , C_Currency_ID = (?) , M_Warehouse_ID = (?) , M_Attributesetinstance_ID = (?) , C_Order_ID = (?) , C_Invoice_ID = (?) , Action = (?) , Processed = (?) , Isposted = (?) , Isactive = (?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_directsales.Zssi_Directsales_ID = ? " +
      "        AND zssi_directsales.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_directsales.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiDirectsalesId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, textlines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateofsale);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, action);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isposted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiDirectsalesId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

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

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO zssi_directsales " +
      "        (Zssi_Directsales_ID, Textlines, AD_Client_ID, Dateofsale, M_Product_ID, Qty, Priceactual, C_Bpartner_ID, C_Bpartner_Location_ID, C_Uom_ID, C_Currency_ID, M_Warehouse_ID, M_Attributesetinstance_ID, C_Order_ID, C_Invoice_ID, Action, Processed, Isposted, Isactive, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_DATE(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiDirectsalesId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, textlines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateofsale);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, action);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isposted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);

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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_directsales" +
      "        WHERE zssi_directsales.Zssi_Directsales_ID = ? " +
      "        AND zssi_directsales.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_directsales.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_directsales" +
      "        WHERE zssi_directsales.Zssi_Directsales_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);

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

/**
Select for relation
 */
  public static String selectOrg(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_ID" +
      "          FROM zssi_directsales" +
      "         WHERE zssi_directsales.Zssi_Directsales_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_id");
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

  public static String getCurrentDBTimestamp(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp" +
      "          FROM zssi_directsales" +
      "         WHERE zssi_directsales.Zssi_Directsales_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updated_time_stamp");
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
