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

class COrderData implements FieldProvider {
static Logger log4j = Logger.getLogger(COrderData.class);
  private String InitRecordNumber="0";
  public String cOrderId;
  public String cDoctypetargetId;
  public String issotrx;
  public String documentno;
  public String cBpartnerId;
  public String billtoId;
  public String cBpartnerLocationId;
  public String adUserId;
  public String description;
  public String cPaymenttermId;
  public String mPricelistId;
  public String mWarehouseId;
  public String mShipperId;
  public String salesrepId;
  public String adOrgtrxId;
  public String cActivityId;
  public String docstatus;
  public String cCampaignId;
  public String cProjectId;
  public String adClientId;
  public String adOrgId;
  public String docaction;
  public String cDoctypeId;
  public String dateordered;
  public String datepromised;
  public String cCurrencyId;
  public String paymentrule;
  public String invoicerule;
  public String deliveryrule;
  public String freightcostrule;
  public String deliveryviarule;
  public String priorityrule;
  public String isdiscountprinted;
  public String processing;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_id") || fieldName.equals("cDoctypetargetId"))
      return cDoctypetargetId;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("billto_id") || fieldName.equals("billtoId"))
      return billtoId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("invoicerule"))
      return invoicerule;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("freightcostrule"))
      return freightcostrule;
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
    else if (fieldName.equalsIgnoreCase("priorityrule"))
      return priorityrule;
    else if (fieldName.equalsIgnoreCase("isdiscountprinted"))
      return isdiscountprinted;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static COrderData[] select(ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    return select(connectionProvider, adClientId, 0, 0);
  }

  public static COrderData[] select(ConnectionProvider connectionProvider, String adClientId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_Order_ID, C_Doctypetarget_ID, IsSOTrx, DocumentNo, C_BPartner_ID, BillTo_ID," +
      "				C_BPartner_Location_ID, AD_User_ID, Description, C_PaymentTerm_ID, M_PriceList_ID," +
      "				M_Warehouse_ID, M_Shipper_ID, SalesRep_ID, AD_Orgtrx_ID, C_Activity_ID, DocStatus," +
      "				C_Campaign_ID, C_Project_ID, AD_Client_ID, AD_Org_ID, DocAction, C_DocType_ID, DateOrdered, DatePromised," +
      "				C_Currency_ID, PaymentRule, InvoiceRule, DeliveryRule, FreightcostRule, DeliveryviaRule," +
      "				PriorityRule, IsDiscountPrinted, Processing" +
      "			  FROM C_Order" +
      "			  WHERE AD_Client_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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
        COrderData objectCOrderData = new COrderData();
        objectCOrderData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectCOrderData.cDoctypetargetId = UtilSql.getValue(result, "c_doctypetarget_id");
        objectCOrderData.issotrx = UtilSql.getValue(result, "issotrx");
        objectCOrderData.documentno = UtilSql.getValue(result, "documentno");
        objectCOrderData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCOrderData.billtoId = UtilSql.getValue(result, "billto_id");
        objectCOrderData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectCOrderData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectCOrderData.description = UtilSql.getValue(result, "description");
        objectCOrderData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectCOrderData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectCOrderData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectCOrderData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectCOrderData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectCOrderData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectCOrderData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectCOrderData.docstatus = UtilSql.getValue(result, "docstatus");
        objectCOrderData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectCOrderData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCOrderData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCOrderData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCOrderData.docaction = UtilSql.getValue(result, "docaction");
        objectCOrderData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectCOrderData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectCOrderData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectCOrderData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCOrderData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectCOrderData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectCOrderData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectCOrderData.freightcostrule = UtilSql.getValue(result, "freightcostrule");
        objectCOrderData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectCOrderData.priorityrule = UtilSql.getValue(result, "priorityrule");
        objectCOrderData.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectCOrderData.processing = UtilSql.getValue(result, "processing");
        objectCOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCOrderData);
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
    COrderData objectCOrderData[] = new COrderData[vector.size()];
    vector.copyInto(objectCOrderData);
    return(objectCOrderData);
  }

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			  INSERT INTO C_Order (C_Order_ID, AD_Client_ID, AD_Org_ID, isActive, Created, CreatedBy, Updated, UpdatedBy," +
      "				C_Doctypetarget_ID, IsSOTrx, DocumentNo, C_BPartner_ID, BillTo_ID, C_BPartner_Location_ID, AD_User_ID," +
      "				Description, C_PaymentTerm_ID, M_PriceList_ID, M_Warehouse_ID, M_Shipper_ID, SalesRep_ID, AD_Orgtrx_ID," +
      "				C_Activity_ID, DocStatus, DocAction, C_Doctype_ID, DateOrdered, DatePromised, DateAcct, C_Currency_ID," +
      "				PaymentRule, InvoiceRule, DeliveryRule, FreightcostRule, DeliveryviaRule, PriorityRule, IsDiscountPrinted," +
      "				Processing)" +
      "				VALUES (?, ?, ?, 'Y', TO_DATE(now()), ?, TO_DATE(now()), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
      "				TO_DATE(?), TO_DATE(?), TO_DATE(?), ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priorityrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);

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

  public static String selectCurrency(ConnectionProvider connectionProvider, String adClientId, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				SELECT MIN(pl.c_currency_id) AS C_CURRENCY_ID" +
      "				FROM C_BPartner bp, M_Pricelist pl" +
      "				WHERE bp.M_Pricelist_ID = pl.M_Pricelist_ID" +
      "				AND pl.AD_Client_ID = ?" +
      "				AND bp.C_BPartner_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_currency_id");
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
