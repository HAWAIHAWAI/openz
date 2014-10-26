//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ws.externalSales;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ExternalSalesIOrderData implements FieldProvider {
static Logger log4j = Logger.getLogger(ExternalSalesIOrderData.class);
  private String InitRecordNumber="0";
  public String iOrderId;
  public String cBpartnerId;
  public String bpartnervalue;
  public String cBpartnerLocationId;
  public String addr;
  public String contactname;
  public String email;
  public String adClientId;
  public String adOrgId;
  public String name;
  public String adOrgtrxId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String iIsimported;
  public String iErrormsg;
  public String processing;
  public String processed;
  public String salesrepId;
  public String mWarehouseId;
  public String mPricelistId;
  public String cCurrencyId;
  public String mShipperId;
  public String issotrx;
  public String billtoId;
  public String cLocationId;
  public String address1;
  public String address2;
  public String postal;
  public String city;
  public String cRegionId;
  public String regionname;
  public String cCountryId;
  public String countrycode;
  public String adUserId;
  public String phone;
  public String cProjectId;
  public String cActivityId;
  public String cDoctypeId;
  public String doctypename;
  public String cPaymenttermId;
  public String paymenttermvalue;
  public String cOrderId;
  public String documentno;
  public String description;
  public String mProductId;
  public String productvalue;
  public String upc;
  public String sku;
  public String cTaxId;
  public String taxindicator;
  public String taxamt;
  public String cOrderlineId;
  public String linedescription;
  public String cUomId;
  public String qtyordered;
  public String priceactual;
  public String cCampaignId;
  public String dateordered;
  public String datepromised;
  public String orderReferenceno;
  public String bpartnerupc;
  public String billtoUpc;
  public String cBpartnerLocationUpc;
  public String vendorUpc;
  public String performPost;
  public String paymentamount1;
  public String paymentrule1;
  public String paymentamount2;
  public String paymentrule2;
  public String dateTimeFormat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("i_order_id") || fieldName.equals("iOrderId"))
      return iOrderId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("bpartnervalue"))
      return bpartnervalue;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("addr"))
      return addr;
    else if (fieldName.equalsIgnoreCase("contactname"))
      return contactname;
    else if (fieldName.equalsIgnoreCase("email"))
      return email;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
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
    else if (fieldName.equalsIgnoreCase("i_isimported") || fieldName.equals("iIsimported"))
      return iIsimported;
    else if (fieldName.equalsIgnoreCase("i_errormsg") || fieldName.equals("iErrormsg"))
      return iErrormsg;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("billto_id") || fieldName.equals("billtoId"))
      return billtoId;
    else if (fieldName.equalsIgnoreCase("c_location_id") || fieldName.equals("cLocationId"))
      return cLocationId;
    else if (fieldName.equalsIgnoreCase("address1"))
      return address1;
    else if (fieldName.equalsIgnoreCase("address2"))
      return address2;
    else if (fieldName.equalsIgnoreCase("postal"))
      return postal;
    else if (fieldName.equalsIgnoreCase("city"))
      return city;
    else if (fieldName.equalsIgnoreCase("c_region_id") || fieldName.equals("cRegionId"))
      return cRegionId;
    else if (fieldName.equalsIgnoreCase("regionname"))
      return regionname;
    else if (fieldName.equalsIgnoreCase("c_country_id") || fieldName.equals("cCountryId"))
      return cCountryId;
    else if (fieldName.equalsIgnoreCase("countrycode"))
      return countrycode;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("doctypename"))
      return doctypename;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("paymenttermvalue"))
      return paymenttermvalue;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("productvalue"))
      return productvalue;
    else if (fieldName.equalsIgnoreCase("upc"))
      return upc;
    else if (fieldName.equalsIgnoreCase("sku"))
      return sku;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("taxindicator"))
      return taxindicator;
    else if (fieldName.equalsIgnoreCase("taxamt"))
      return taxamt;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("linedescription"))
      return linedescription;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("order_referenceno") || fieldName.equals("orderReferenceno"))
      return orderReferenceno;
    else if (fieldName.equalsIgnoreCase("bpartnerupc"))
      return bpartnerupc;
    else if (fieldName.equalsIgnoreCase("billto_upc") || fieldName.equals("billtoUpc"))
      return billtoUpc;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_upc") || fieldName.equals("cBpartnerLocationUpc"))
      return cBpartnerLocationUpc;
    else if (fieldName.equalsIgnoreCase("vendor_upc") || fieldName.equals("vendorUpc"))
      return vendorUpc;
    else if (fieldName.equalsIgnoreCase("perform_post") || fieldName.equals("performPost"))
      return performPost;
    else if (fieldName.equalsIgnoreCase("paymentamount1"))
      return paymentamount1;
    else if (fieldName.equalsIgnoreCase("paymentrule1"))
      return paymentrule1;
    else if (fieldName.equalsIgnoreCase("paymentamount2"))
      return paymentamount2;
    else if (fieldName.equalsIgnoreCase("paymentrule2"))
      return paymentrule2;
    else if (fieldName.equalsIgnoreCase("date_time_format") || fieldName.equals("dateTimeFormat"))
      return dateTimeFormat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ExternalSalesIOrderData[] select(ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    return select(connectionProvider, ad_client_id, 0, 0);
  }

  public static ExternalSalesIOrderData[] select(ConnectionProvider connectionProvider, String ad_client_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				SELECT I_Order_ID, C_BPartner_ID, BPartnerValue, C_BPartner_Location_ID," +
      "				COALESCE (Address1,Address2,City) AS Addr, ContactName, Email," +
      "				AD_Client_ID, AD_Org_ID, Name, AD_OrgTrx_ID, isActive, created, createdBy, updated, updatedBy," +
      "				I_IsImported, I_ErrorMsg, processing, processed, SalesRep_ID, M_Warehouse_ID, M_Pricelist_ID," +
      "				C_Currency_ID, M_Shipper_ID, isSOTRX, billTo_ID, C_Location_ID, Address1, Address2, Postal, City," +
      "				C_Region_ID, RegionName, C_Country_ID, CountryCode, AD_User_ID, Phone, C_Project_ID, C_Activity_ID," +
      "				C_DocType_ID, DocTypeName, C_PaymentTerm_ID, PaymentTermValue, C_Order_ID, DocumentNo, Description," +
      "				M_Product_ID, ProductValue, UPC, SKU, C_Tax_ID, TaxIndicator, TaxAmt, C_OrderLine_ID, LineDescription," +
      "				C_UOM_ID, QtyOrdered, PriceActual, C_Campaign_ID, DateOrdered, DatePromised, Order_ReferenceNo," +
      "				BPartnerUPC, BillTo_UPC, C_BPartner_Location_UPC, Vendor_UPC, Perform_Post, Paymentamount1, Paymentrule1, Paymentamount2, Paymentrule2, '' AS Date_Time_Format" +
      "				FROM I_Order" +
      "				WHERE I_IsImported='N'" +
      "				AND AD_Client_ID = ?";

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
        ExternalSalesIOrderData objectExternalSalesIOrderData = new ExternalSalesIOrderData();
        objectExternalSalesIOrderData.iOrderId = UtilSql.getValue(result, "i_order_id");
        objectExternalSalesIOrderData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectExternalSalesIOrderData.bpartnervalue = UtilSql.getValue(result, "bpartnervalue");
        objectExternalSalesIOrderData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectExternalSalesIOrderData.addr = UtilSql.getValue(result, "addr");
        objectExternalSalesIOrderData.contactname = UtilSql.getValue(result, "contactname");
        objectExternalSalesIOrderData.email = UtilSql.getValue(result, "email");
        objectExternalSalesIOrderData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectExternalSalesIOrderData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectExternalSalesIOrderData.name = UtilSql.getValue(result, "name");
        objectExternalSalesIOrderData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectExternalSalesIOrderData.isactive = UtilSql.getValue(result, "isactive");
        objectExternalSalesIOrderData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectExternalSalesIOrderData.createdby = UtilSql.getValue(result, "createdby");
        objectExternalSalesIOrderData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectExternalSalesIOrderData.updatedby = UtilSql.getValue(result, "updatedby");
        objectExternalSalesIOrderData.iIsimported = UtilSql.getValue(result, "i_isimported");
        objectExternalSalesIOrderData.iErrormsg = UtilSql.getValue(result, "i_errormsg");
        objectExternalSalesIOrderData.processing = UtilSql.getValue(result, "processing");
        objectExternalSalesIOrderData.processed = UtilSql.getValue(result, "processed");
        objectExternalSalesIOrderData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectExternalSalesIOrderData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectExternalSalesIOrderData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectExternalSalesIOrderData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectExternalSalesIOrderData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectExternalSalesIOrderData.issotrx = UtilSql.getValue(result, "issotrx");
        objectExternalSalesIOrderData.billtoId = UtilSql.getValue(result, "billto_id");
        objectExternalSalesIOrderData.cLocationId = UtilSql.getValue(result, "c_location_id");
        objectExternalSalesIOrderData.address1 = UtilSql.getValue(result, "address1");
        objectExternalSalesIOrderData.address2 = UtilSql.getValue(result, "address2");
        objectExternalSalesIOrderData.postal = UtilSql.getValue(result, "postal");
        objectExternalSalesIOrderData.city = UtilSql.getValue(result, "city");
        objectExternalSalesIOrderData.cRegionId = UtilSql.getValue(result, "c_region_id");
        objectExternalSalesIOrderData.regionname = UtilSql.getValue(result, "regionname");
        objectExternalSalesIOrderData.cCountryId = UtilSql.getValue(result, "c_country_id");
        objectExternalSalesIOrderData.countrycode = UtilSql.getValue(result, "countrycode");
        objectExternalSalesIOrderData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectExternalSalesIOrderData.phone = UtilSql.getValue(result, "phone");
        objectExternalSalesIOrderData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectExternalSalesIOrderData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectExternalSalesIOrderData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectExternalSalesIOrderData.doctypename = UtilSql.getValue(result, "doctypename");
        objectExternalSalesIOrderData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectExternalSalesIOrderData.paymenttermvalue = UtilSql.getValue(result, "paymenttermvalue");
        objectExternalSalesIOrderData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectExternalSalesIOrderData.documentno = UtilSql.getValue(result, "documentno");
        objectExternalSalesIOrderData.description = UtilSql.getValue(result, "description");
        objectExternalSalesIOrderData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectExternalSalesIOrderData.productvalue = UtilSql.getValue(result, "productvalue");
        objectExternalSalesIOrderData.upc = UtilSql.getValue(result, "upc");
        objectExternalSalesIOrderData.sku = UtilSql.getValue(result, "sku");
        objectExternalSalesIOrderData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectExternalSalesIOrderData.taxindicator = UtilSql.getValue(result, "taxindicator");
        objectExternalSalesIOrderData.taxamt = UtilSql.getValue(result, "taxamt");
        objectExternalSalesIOrderData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectExternalSalesIOrderData.linedescription = UtilSql.getValue(result, "linedescription");
        objectExternalSalesIOrderData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectExternalSalesIOrderData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectExternalSalesIOrderData.priceactual = UtilSql.getValue(result, "priceactual");
        objectExternalSalesIOrderData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectExternalSalesIOrderData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectExternalSalesIOrderData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectExternalSalesIOrderData.orderReferenceno = UtilSql.getValue(result, "order_referenceno");
        objectExternalSalesIOrderData.bpartnerupc = UtilSql.getValue(result, "bpartnerupc");
        objectExternalSalesIOrderData.billtoUpc = UtilSql.getValue(result, "billto_upc");
        objectExternalSalesIOrderData.cBpartnerLocationUpc = UtilSql.getValue(result, "c_bpartner_location_upc");
        objectExternalSalesIOrderData.vendorUpc = UtilSql.getValue(result, "vendor_upc");
        objectExternalSalesIOrderData.performPost = UtilSql.getValue(result, "perform_post");
        objectExternalSalesIOrderData.paymentamount1 = UtilSql.getValue(result, "paymentamount1");
        objectExternalSalesIOrderData.paymentrule1 = UtilSql.getValue(result, "paymentrule1");
        objectExternalSalesIOrderData.paymentamount2 = UtilSql.getValue(result, "paymentamount2");
        objectExternalSalesIOrderData.paymentrule2 = UtilSql.getValue(result, "paymentrule2");
        objectExternalSalesIOrderData.dateTimeFormat = UtilSql.getValue(result, "date_time_format");
        objectExternalSalesIOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExternalSalesIOrderData);
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
    ExternalSalesIOrderData objectExternalSalesIOrderData[] = new ExternalSalesIOrderData[vector.size()];
    vector.copyInto(objectExternalSalesIOrderData);
    return(objectExternalSalesIOrderData);
  }

  public static ExternalSalesIOrderData[] set()    throws ServletException {
    ExternalSalesIOrderData objectExternalSalesIOrderData[] = new ExternalSalesIOrderData[1];
    objectExternalSalesIOrderData[0] = new ExternalSalesIOrderData();
    objectExternalSalesIOrderData[0].iOrderId = "";
    objectExternalSalesIOrderData[0].cBpartnerId = "";
    objectExternalSalesIOrderData[0].bpartnervalue = "";
    objectExternalSalesIOrderData[0].cBpartnerLocationId = "";
    objectExternalSalesIOrderData[0].addr = "";
    objectExternalSalesIOrderData[0].contactname = "";
    objectExternalSalesIOrderData[0].email = "";
    objectExternalSalesIOrderData[0].adClientId = "";
    objectExternalSalesIOrderData[0].adOrgId = "";
    objectExternalSalesIOrderData[0].name = "";
    objectExternalSalesIOrderData[0].adOrgtrxId = "";
    objectExternalSalesIOrderData[0].isactive = "";
    objectExternalSalesIOrderData[0].created = "";
    objectExternalSalesIOrderData[0].createdby = "";
    objectExternalSalesIOrderData[0].updated = "";
    objectExternalSalesIOrderData[0].updatedby = "";
    objectExternalSalesIOrderData[0].iIsimported = "";
    objectExternalSalesIOrderData[0].iErrormsg = "";
    objectExternalSalesIOrderData[0].processing = "";
    objectExternalSalesIOrderData[0].processed = "";
    objectExternalSalesIOrderData[0].salesrepId = "";
    objectExternalSalesIOrderData[0].mWarehouseId = "";
    objectExternalSalesIOrderData[0].mPricelistId = "";
    objectExternalSalesIOrderData[0].cCurrencyId = "";
    objectExternalSalesIOrderData[0].mShipperId = "";
    objectExternalSalesIOrderData[0].issotrx = "";
    objectExternalSalesIOrderData[0].billtoId = "";
    objectExternalSalesIOrderData[0].cLocationId = "";
    objectExternalSalesIOrderData[0].address1 = "";
    objectExternalSalesIOrderData[0].address2 = "";
    objectExternalSalesIOrderData[0].postal = "";
    objectExternalSalesIOrderData[0].city = "";
    objectExternalSalesIOrderData[0].cRegionId = "";
    objectExternalSalesIOrderData[0].regionname = "";
    objectExternalSalesIOrderData[0].cCountryId = "";
    objectExternalSalesIOrderData[0].countrycode = "";
    objectExternalSalesIOrderData[0].adUserId = "";
    objectExternalSalesIOrderData[0].phone = "";
    objectExternalSalesIOrderData[0].cProjectId = "";
    objectExternalSalesIOrderData[0].cActivityId = "";
    objectExternalSalesIOrderData[0].cDoctypeId = "";
    objectExternalSalesIOrderData[0].doctypename = "";
    objectExternalSalesIOrderData[0].cPaymenttermId = "";
    objectExternalSalesIOrderData[0].paymenttermvalue = "";
    objectExternalSalesIOrderData[0].cOrderId = "";
    objectExternalSalesIOrderData[0].documentno = "";
    objectExternalSalesIOrderData[0].description = "";
    objectExternalSalesIOrderData[0].mProductId = "";
    objectExternalSalesIOrderData[0].productvalue = "";
    objectExternalSalesIOrderData[0].upc = "";
    objectExternalSalesIOrderData[0].sku = "";
    objectExternalSalesIOrderData[0].cTaxId = "";
    objectExternalSalesIOrderData[0].taxindicator = "";
    objectExternalSalesIOrderData[0].taxamt = "";
    objectExternalSalesIOrderData[0].cOrderlineId = "";
    objectExternalSalesIOrderData[0].linedescription = "";
    objectExternalSalesIOrderData[0].cUomId = "";
    objectExternalSalesIOrderData[0].qtyordered = "";
    objectExternalSalesIOrderData[0].priceactual = "";
    objectExternalSalesIOrderData[0].cCampaignId = "";
    objectExternalSalesIOrderData[0].dateordered = "";
    objectExternalSalesIOrderData[0].datepromised = "";
    objectExternalSalesIOrderData[0].orderReferenceno = "";
    objectExternalSalesIOrderData[0].bpartnerupc = "";
    objectExternalSalesIOrderData[0].billtoUpc = "";
    objectExternalSalesIOrderData[0].cBpartnerLocationUpc = "";
    objectExternalSalesIOrderData[0].vendorUpc = "";
    objectExternalSalesIOrderData[0].performPost = "";
    objectExternalSalesIOrderData[0].paymentamount1 = "";
    objectExternalSalesIOrderData[0].paymentrule1 = "";
    objectExternalSalesIOrderData[0].paymentamount2 = "";
    objectExternalSalesIOrderData[0].paymentrule2 = "";
    objectExternalSalesIOrderData[0].dateTimeFormat = "";
    return objectExternalSalesIOrderData;
  }

  public int insert(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				INSERT INTO I_Order (I_ORDER_ID, AD_CLIENT_ID, AD_ORG_ID, DOCUMENTNO, createdBy, created, " +
      "				C_Doctype_ID,dateordered, C_CURRENCY_ID, BPartnervalue, name, C_BPartner_Location_ID,BillTo_ID," +
      "				Address1,Address2,Postal,City,RegionName,CountryCode," +
      "				C_OrderLine_ID,M_Product_Id, qtyOrdered, priceActual, " +
      "				C_Tax_ID, paymenttermvalue, c_PaymentTerm_Id, salesrep_Id, m_Shipper_Id, m_Pricelist_Id, m_Warehouse_Id, " +
      "				Perform_Post, Paymentamount1, Paymentrule1, Paymentamount2, Paymentrule2) VALUES " +
      "				(?,?,?,?,'0',to_date(now())," +
      "				?,to_date(?,?),?,?,?,?,?," +
      "				to_char(?),to_char(?),to_char(?),to_char(?),to_char(?),to_char(?)," +
      "				?,?,to_number(?),to_number(?)," +
      "				?,?,?,?,?,?,?, " +
      "				to_char(?),to_number(?),to_char(?),to_number(?),to_char(?))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderReferenceno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnervalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, city);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, regionname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, countrycode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymenttermvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, performPost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentamount1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentamount2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule2);

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

  public int update(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				UPDATE I_Order SET" +
      "					BPartnerValue=?," +
      "					Name=?," +
      "					C_BPartner_ID=?," +
      "					C_Location_ID=?," +
      "					C_BPartner_Location_ID=?," +
      "					billTo_ID=?," +
      "					AD_User_ID=?," +
      "					Updated=TO_DATE(now())," +
      "					UpdatedBy=?," +
      "					C_Order_ID=?," +
      "					C_Tax_ID=?," +
      "					C_OrderLine_ID=?," +
      "					I_IsImported=?," +
      "					Processed=?," +
      "					Order_ReferenceNo=?" +
      "				WHERE I_Order_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnervalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iIsimported);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderReferenceno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iOrderId);

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
}
