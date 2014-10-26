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

class ExternalSalesData implements FieldProvider {
static Logger log4j = Logger.getLogger(ExternalSalesData.class);
  private String InitRecordNumber="0";
  public String cExternalposId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String value;
  public String name;
  public String description;
  public String mWarehouseId;
  public String cDoctypeId;
  public String cBpartnerId;
  public String mPricelistId;
  public String cCurrencyId;
  public String salesrepId;
  public String mShipperId;
  public String includeProduct;
  public String includeProductCategory;
  public String performPost;
  public String cBpartnerLocationId;
  public String billtoId;
  public String bpValue;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_externalpos_id") || fieldName.equals("cExternalposId"))
      return cExternalposId;
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
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("include_product") || fieldName.equals("includeProduct"))
      return includeProduct;
    else if (fieldName.equalsIgnoreCase("include_product_category") || fieldName.equals("includeProductCategory"))
      return includeProductCategory;
    else if (fieldName.equalsIgnoreCase("perform_post") || fieldName.equals("performPost"))
      return performPost;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("billto_id") || fieldName.equals("billtoId"))
      return billtoId;
    else if (fieldName.equalsIgnoreCase("bp_value") || fieldName.equals("bpValue"))
      return bpValue;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ExternalSalesData[] select(ConnectionProvider connectionProvider, String client, String org, String salesChannel)    throws ServletException {
    return select(connectionProvider, client, org, salesChannel, 0, 0);
  }

  public static ExternalSalesData[] select(ConnectionProvider connectionProvider, String client, String org, String salesChannel, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_EXTERNALPOS_ID, C_EXTERNALPOS.AD_CLIENT_ID, C_EXTERNALPOS.AD_ORG_ID, C_EXTERNALPOS.ISACTIVE, " +
      "        C_EXTERNALPOS.CREATED, C_EXTERNALPOS.CREATEDBY, C_EXTERNALPOS.UPDATED, C_EXTERNALPOS.UPDATEDBY, " +
      "        C_EXTERNALPOS.VALUE, C_EXTERNALPOS.NAME, C_EXTERNALPOS.DESCRIPTION," +
      "        C_EXTERNALPOS.M_WAREHOUSE_ID, C_EXTERNALPOS.C_DOCTYPE_ID, C_EXTERNALPOS.C_BPARTNER_ID, C_EXTERNALPOS.M_PRICELIST_ID, M_PRICELIST.C_CURRENCY_ID, " +
      "        C_EXTERNALPOS.SALESREP_ID, C_EXTERNALPOS.M_SHIPPER_ID, C_EXTERNALPOS.INCLUDE_PRODUCT, C_EXTERNALPOS.INCLUDE_PRODUCT_CATEGORY, " +
      "        C_EXTERNALPOS.PERFORM_POST, C_GETBPLOCATIONID(C_EXTERNALPOS.C_BPARTNER_ID,'B') AS C_BPARTNER_LOCATION_ID, " +
      "        C_GETBPLOCATIONID(C_EXTERNALPOS.C_BPARTNER_ID,'S') AS BILLTO_ID, C_BPARTNER.VALUE AS BP_VALUE" +
      "        FROM C_EXTERNALPOS, C_BPARTNER, M_PRICELIST" +
      "        WHERE C_EXTERNALPOS.AD_CLIENT_ID = ?" +
      "        AND C_EXTERNALPOS.AD_ORG_ID = ?" +
      "        AND C_EXTERNALPOS.VALUE = ?" +
      "        AND C_BPARTNER.C_BPARTNER_ID = C_EXTERNALPOS.C_BPARTNER_ID" +
      "        AND C_BPARTNER.AD_CLIENT_ID = C_EXTERNALPOS.AD_CLIENT_ID" +
      "        AND M_PRICELIST.M_PRICELIST_ID = C_EXTERNALPOS.M_PRICELIST_ID";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesChannel);

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
        ExternalSalesData objectExternalSalesData = new ExternalSalesData();
        objectExternalSalesData.cExternalposId = UtilSql.getValue(result, "c_externalpos_id");
        objectExternalSalesData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectExternalSalesData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectExternalSalesData.isactive = UtilSql.getValue(result, "isactive");
        objectExternalSalesData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectExternalSalesData.createdby = UtilSql.getValue(result, "createdby");
        objectExternalSalesData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectExternalSalesData.updatedby = UtilSql.getValue(result, "updatedby");
        objectExternalSalesData.value = UtilSql.getValue(result, "value");
        objectExternalSalesData.name = UtilSql.getValue(result, "name");
        objectExternalSalesData.description = UtilSql.getValue(result, "description");
        objectExternalSalesData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectExternalSalesData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectExternalSalesData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectExternalSalesData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectExternalSalesData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectExternalSalesData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectExternalSalesData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectExternalSalesData.includeProduct = UtilSql.getValue(result, "include_product");
        objectExternalSalesData.includeProductCategory = UtilSql.getValue(result, "include_product_category");
        objectExternalSalesData.performPost = UtilSql.getValue(result, "perform_post");
        objectExternalSalesData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectExternalSalesData.billtoId = UtilSql.getValue(result, "billto_id");
        objectExternalSalesData.bpValue = UtilSql.getValue(result, "bp_value");
        objectExternalSalesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExternalSalesData);
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
    ExternalSalesData objectExternalSalesData[] = new ExternalSalesData[vector.size()];
    vector.copyInto(objectExternalSalesData);
    return(objectExternalSalesData);
  }
}
