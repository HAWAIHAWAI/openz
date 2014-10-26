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

class EdiFileImportData implements FieldProvider {
static Logger log4j = Logger.getLogger(EdiFileImportData.class);
  private String InitRecordNumber="0";
  public String iOrderId;
  public String adClientId;
  public String adOrgId;
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
  public String cBpartnerId;
  public String bpartnervalue;
  public String name;
  public String cBpartnerLocationId;
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
  public String contactname;
  public String email;
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

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("i_order_id") || fieldName.equals("iOrderId"))
      return iOrderId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
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
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("bpartnervalue"))
      return bpartnervalue;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
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
    else if (fieldName.equalsIgnoreCase("contactname"))
      return contactname;
    else if (fieldName.equalsIgnoreCase("email"))
      return email;
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
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static EdiFileImportData[] select(ConnectionProvider connectionProvider, String iOrderId)    throws ServletException {
    return select(connectionProvider, iOrderId, 0, 0);
  }

  public static EdiFileImportData[] select(ConnectionProvider connectionProvider, String iOrderId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				select I_ORDER_ID, AD_CLIENT_ID, AD_ORG_ID, AD_ORGTRX_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "				I_ISIMPORTED, I_ERRORMSG, PROCESSING, PROCESSED, SALESREP_ID, M_WAREHOUSE_ID, M_PRICELIST_ID, C_CURRENCY_ID," +
      "				M_SHIPPER_ID, ISSOTRX, C_BPARTNER_ID, BPARTNERVALUE, NAME, C_BPARTNER_LOCATION_ID, BILLTO_ID, C_LOCATION_ID," +
      "				ADDRESS1, ADDRESS2, POSTAL, CITY, C_REGION_ID, REGIONNAME, C_COUNTRY_ID, COUNTRYCODE, AD_USER_ID, CONTACTNAME," +
      "				EMAIL, PHONE, C_PROJECT_ID, C_ACTIVITY_ID, C_DOCTYPE_ID, DOCTYPENAME, C_PAYMENTTERM_ID, PAYMENTTERMVALUE," +
      "				C_ORDER_ID, DOCUMENTNO, DESCRIPTION, M_PRODUCT_ID, PRODUCTVALUE, UPC, SKU, C_TAX_ID, TAXINDICATOR, TAXAMT," +
      "				C_ORDERLINE_ID, LINEDESCRIPTION, C_UOM_ID, QTYORDERED, PRICEACTUAL, C_CAMPAIGN_ID, DATEORDERED," +
      "				DATEPROMISED, ORDER_REFERENCENO, BPARTNERUPC, BILLTO_UPC, C_BPARTNER_LOCATION_UPC, VENDOR_UPC" +
      "				from i_order" +
      "				where I_ORDER_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iOrderId);

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
        EdiFileImportData objectEdiFileImportData = new EdiFileImportData();
        objectEdiFileImportData.iOrderId = UtilSql.getValue(result, "i_order_id");
        objectEdiFileImportData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectEdiFileImportData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectEdiFileImportData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectEdiFileImportData.isactive = UtilSql.getValue(result, "isactive");
        objectEdiFileImportData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectEdiFileImportData.createdby = UtilSql.getValue(result, "createdby");
        objectEdiFileImportData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectEdiFileImportData.updatedby = UtilSql.getValue(result, "updatedby");
        objectEdiFileImportData.iIsimported = UtilSql.getValue(result, "i_isimported");
        objectEdiFileImportData.iErrormsg = UtilSql.getValue(result, "i_errormsg");
        objectEdiFileImportData.processing = UtilSql.getValue(result, "processing");
        objectEdiFileImportData.processed = UtilSql.getValue(result, "processed");
        objectEdiFileImportData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectEdiFileImportData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectEdiFileImportData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectEdiFileImportData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectEdiFileImportData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectEdiFileImportData.issotrx = UtilSql.getValue(result, "issotrx");
        objectEdiFileImportData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectEdiFileImportData.bpartnervalue = UtilSql.getValue(result, "bpartnervalue");
        objectEdiFileImportData.name = UtilSql.getValue(result, "name");
        objectEdiFileImportData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectEdiFileImportData.billtoId = UtilSql.getValue(result, "billto_id");
        objectEdiFileImportData.cLocationId = UtilSql.getValue(result, "c_location_id");
        objectEdiFileImportData.address1 = UtilSql.getValue(result, "address1");
        objectEdiFileImportData.address2 = UtilSql.getValue(result, "address2");
        objectEdiFileImportData.postal = UtilSql.getValue(result, "postal");
        objectEdiFileImportData.city = UtilSql.getValue(result, "city");
        objectEdiFileImportData.cRegionId = UtilSql.getValue(result, "c_region_id");
        objectEdiFileImportData.regionname = UtilSql.getValue(result, "regionname");
        objectEdiFileImportData.cCountryId = UtilSql.getValue(result, "c_country_id");
        objectEdiFileImportData.countrycode = UtilSql.getValue(result, "countrycode");
        objectEdiFileImportData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectEdiFileImportData.contactname = UtilSql.getValue(result, "contactname");
        objectEdiFileImportData.email = UtilSql.getValue(result, "email");
        objectEdiFileImportData.phone = UtilSql.getValue(result, "phone");
        objectEdiFileImportData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectEdiFileImportData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectEdiFileImportData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectEdiFileImportData.doctypename = UtilSql.getValue(result, "doctypename");
        objectEdiFileImportData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectEdiFileImportData.paymenttermvalue = UtilSql.getValue(result, "paymenttermvalue");
        objectEdiFileImportData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectEdiFileImportData.documentno = UtilSql.getValue(result, "documentno");
        objectEdiFileImportData.description = UtilSql.getValue(result, "description");
        objectEdiFileImportData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectEdiFileImportData.productvalue = UtilSql.getValue(result, "productvalue");
        objectEdiFileImportData.upc = UtilSql.getValue(result, "upc");
        objectEdiFileImportData.sku = UtilSql.getValue(result, "sku");
        objectEdiFileImportData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectEdiFileImportData.taxindicator = UtilSql.getValue(result, "taxindicator");
        objectEdiFileImportData.taxamt = UtilSql.getValue(result, "taxamt");
        objectEdiFileImportData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectEdiFileImportData.linedescription = UtilSql.getValue(result, "linedescription");
        objectEdiFileImportData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectEdiFileImportData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectEdiFileImportData.priceactual = UtilSql.getValue(result, "priceactual");
        objectEdiFileImportData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectEdiFileImportData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectEdiFileImportData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectEdiFileImportData.orderReferenceno = UtilSql.getValue(result, "order_referenceno");
        objectEdiFileImportData.bpartnerupc = UtilSql.getValue(result, "bpartnerupc");
        objectEdiFileImportData.billtoUpc = UtilSql.getValue(result, "billto_upc");
        objectEdiFileImportData.cBpartnerLocationUpc = UtilSql.getValue(result, "c_bpartner_location_upc");
        objectEdiFileImportData.vendorUpc = UtilSql.getValue(result, "vendor_upc");
        objectEdiFileImportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEdiFileImportData);
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
    EdiFileImportData objectEdiFileImportData[] = new EdiFileImportData[vector.size()];
    vector.copyInto(objectEdiFileImportData);
    return(objectEdiFileImportData);
  }

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				INSERT INTO I_ORDER " +
      "          (i_order_id, ad_client_id, ad_org_id, isactive, " +
      "           created, createdby, updated, updatedby, " +
      "           i_isimported, issotrx, processing, " +
      "           processed, order_Referenceno, dateordered, " +
      "           datepromised, upc,	linedescription, " +
      "           qtyordered, bpartnerupc, doctypename, " +
      "           billto_upc, description, c_bpartner_location_upc, vendor_upc)" +
      "				VALUES" +
      "          (?, ?, ?, 'Y', " +
      "           now(), ?, now(), ?," +
      "           ?, ?, ?, " +
      "           ?, ?, to_date(?, 'yyyymmdd'), " +
      "           to_date(?, 'yyyymmdd'), ?, ?, " +
      "           TO_NUMBER(?), ?, ?, " +
      "           TO_NUMBER(?), ?, ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iIsimported);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderReferenceno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linedescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnerupc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, doctypename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoUpc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationUpc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorUpc);

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

  public static int delete(Connection conn, ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				DELETE FROM I_ORDER" +
      "				where ad_client_id = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

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
