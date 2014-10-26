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
import org.openbravo.database.RDBMSIndependent;
import org.openbravo.exception.*;

class RequisitionToOrderData implements FieldProvider {
static Logger log4j = Logger.getLogger(RequisitionToOrderData.class);
  private String InitRecordNumber="0";
  public String mRequisitionlineId;
  public String reqqty;
  public String matchedqty;
  public String qtytoorder;
  public String mPricelistId;
  public String needbydate;
  public String pricelist;
  public String price;
  public String mProductId;
  public String mAttributesetinstanceId;
  public String vendorId;
  public String vendor;
  public String product;
  public String tooltipproduct;
  public String attribute;
  public String requester;
  public String pricelistid;
  public String vendorpricelist;
  public String lockedby;
  public String lockqty;
  public String lockprice;
  public String adOrgId;
  public String org;
  public String invoicerule;
  public String deliveryrule;
  public String freightcostrule;
  public String deliveryviarule;
  public String paymentrulepo;
  public String poPaymenttermId;
  public String note;
  public String cUomId;
  public String pricelimit;
  public String priceactual;
  public String discount;
  public String tax;
  public String cOrderlineId;
  public String padre;
  public String id;
  public String name;
  public String pricestd;
  public String toClose;
  public String project;
  public String internalnote;
  public String tooltipinternalnote;
  public String tooltipnote;
  public String documentno;
  public String aAssetId;
  public String cProjectId;
  public String cProjectphaseId;
  public String cProjecttaskId;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_requisitionline_id") || fieldName.equals("mRequisitionlineId"))
      return mRequisitionlineId;
    else if (fieldName.equalsIgnoreCase("reqqty"))
      return reqqty;
    else if (fieldName.equalsIgnoreCase("matchedqty"))
      return matchedqty;
    else if (fieldName.equalsIgnoreCase("qtytoorder"))
      return qtytoorder;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("needbydate"))
      return needbydate;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("price"))
      return price;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("vendor_id") || fieldName.equals("vendorId"))
      return vendorId;
    else if (fieldName.equalsIgnoreCase("vendor"))
      return vendor;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("tooltipproduct"))
      return tooltipproduct;
    else if (fieldName.equalsIgnoreCase("attribute"))
      return attribute;
    else if (fieldName.equalsIgnoreCase("requester"))
      return requester;
    else if (fieldName.equalsIgnoreCase("pricelistid"))
      return pricelistid;
    else if (fieldName.equalsIgnoreCase("vendorpricelist"))
      return vendorpricelist;
    else if (fieldName.equalsIgnoreCase("lockedby"))
      return lockedby;
    else if (fieldName.equalsIgnoreCase("lockqty"))
      return lockqty;
    else if (fieldName.equalsIgnoreCase("lockprice"))
      return lockprice;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("invoicerule"))
      return invoicerule;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("freightcostrule"))
      return freightcostrule;
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
    else if (fieldName.equalsIgnoreCase("paymentrulepo"))
      return paymentrulepo;
    else if (fieldName.equalsIgnoreCase("po_paymentterm_id") || fieldName.equals("poPaymenttermId"))
      return poPaymenttermId;
    else if (fieldName.equalsIgnoreCase("note"))
      return note;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("discount"))
      return discount;
    else if (fieldName.equalsIgnoreCase("tax"))
      return tax;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("padre"))
      return padre;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("to_close") || fieldName.equals("toClose"))
      return toClose;
    else if (fieldName.equalsIgnoreCase("project"))
      return project;
    else if (fieldName.equalsIgnoreCase("internalnote"))
      return internalnote;
    else if (fieldName.equalsIgnoreCase("tooltipinternalnote"))
      return tooltipinternalnote;
    else if (fieldName.equalsIgnoreCase("tooltipnote"))
      return tooltipnote;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RequisitionToOrderData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static RequisitionToOrderData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT '' AS M_REQUISITIONLINE_ID, '' AS REQQTY, '' AS MATCHEDQTY, '' AS QTYTOORDER, " +
      "          '' AS M_PRICELIST_ID, '' AS NEEDBYDATE, '' AS PRICELIST, '' AS PRICE," +
      "          '' AS M_PRODUCT_ID, '' AS M_ATTRIBUTESETINSTANCE_ID, '' AS VENDOR_ID, '' AS VENDOR, " +
      "          '' AS PRODUCT, '' AS TOOLTIPPRODUCT, '' AS ATTRIBUTE, ''  AS REQUESTER, '' AS PRICELISTID, '' AS VENDORPRICELIST," +
      "          '' AS LOCKEDBY, '' AS LOCKQTY, '' AS LOCKPRICE, '' AS AD_ORG_ID, '' AS ORG, " +
      "          '' AS InvoiceRule, '' AS DeliveryRule, '' AS FreightCostRule, '' AS DeliveryViaRule," +
      "          '' AS PaymentRulePO, '' AS PO_PaymentTerm_ID, '' AS NOTE, '' AS C_UOM_ID," +
      "          '' AS PRICELIMIT, '' AS PRICEACTUAL, '' AS DISCOUNT, '' AS TAX, '' AS C_ORDERLINE_ID," +
      "          '' AS PADRE, '' AS ID, '' AS NAME, '' AS PRICESTD, '' AS TO_CLOSE," +
      "          '' as PROJECT,''  as INTERNALNOTE," +
      "          '' as TOOLTIPINTERNALNOTE, '' as TOOLTIPNOTE, '' AS DOCUMENTNO," +
      "          '' AS A_ASSET_ID, '' AS C_PROJECT_ID,'' AS C_PROJECTPHASE_ID, '' AS C_PROJECTTASK_ID" +
      "        FROM DUAL";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.mRequisitionlineId = UtilSql.getValue(result, "m_requisitionline_id");
        objectRequisitionToOrderData.reqqty = UtilSql.getValue(result, "reqqty");
        objectRequisitionToOrderData.matchedqty = UtilSql.getValue(result, "matchedqty");
        objectRequisitionToOrderData.qtytoorder = UtilSql.getValue(result, "qtytoorder");
        objectRequisitionToOrderData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectRequisitionToOrderData.needbydate = UtilSql.getValue(result, "needbydate");
        objectRequisitionToOrderData.pricelist = UtilSql.getValue(result, "pricelist");
        objectRequisitionToOrderData.price = UtilSql.getValue(result, "price");
        objectRequisitionToOrderData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectRequisitionToOrderData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectRequisitionToOrderData.vendorId = UtilSql.getValue(result, "vendor_id");
        objectRequisitionToOrderData.vendor = UtilSql.getValue(result, "vendor");
        objectRequisitionToOrderData.product = UtilSql.getValue(result, "product");
        objectRequisitionToOrderData.tooltipproduct = UtilSql.getValue(result, "tooltipproduct");
        objectRequisitionToOrderData.attribute = UtilSql.getValue(result, "attribute");
        objectRequisitionToOrderData.requester = UtilSql.getValue(result, "requester");
        objectRequisitionToOrderData.pricelistid = UtilSql.getValue(result, "pricelistid");
        objectRequisitionToOrderData.vendorpricelist = UtilSql.getValue(result, "vendorpricelist");
        objectRequisitionToOrderData.lockedby = UtilSql.getValue(result, "lockedby");
        objectRequisitionToOrderData.lockqty = UtilSql.getValue(result, "lockqty");
        objectRequisitionToOrderData.lockprice = UtilSql.getValue(result, "lockprice");
        objectRequisitionToOrderData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectRequisitionToOrderData.org = UtilSql.getValue(result, "org");
        objectRequisitionToOrderData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectRequisitionToOrderData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectRequisitionToOrderData.freightcostrule = UtilSql.getValue(result, "freightcostrule");
        objectRequisitionToOrderData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectRequisitionToOrderData.paymentrulepo = UtilSql.getValue(result, "paymentrulepo");
        objectRequisitionToOrderData.poPaymenttermId = UtilSql.getValue(result, "po_paymentterm_id");
        objectRequisitionToOrderData.note = UtilSql.getValue(result, "note");
        objectRequisitionToOrderData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectRequisitionToOrderData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectRequisitionToOrderData.priceactual = UtilSql.getValue(result, "priceactual");
        objectRequisitionToOrderData.discount = UtilSql.getValue(result, "discount");
        objectRequisitionToOrderData.tax = UtilSql.getValue(result, "tax");
        objectRequisitionToOrderData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectRequisitionToOrderData.padre = UtilSql.getValue(result, "padre");
        objectRequisitionToOrderData.id = UtilSql.getValue(result, "id");
        objectRequisitionToOrderData.name = UtilSql.getValue(result, "name");
        objectRequisitionToOrderData.pricestd = UtilSql.getValue(result, "pricestd");
        objectRequisitionToOrderData.toClose = UtilSql.getValue(result, "to_close");
        objectRequisitionToOrderData.project = UtilSql.getValue(result, "project");
        objectRequisitionToOrderData.internalnote = UtilSql.getValue(result, "internalnote");
        objectRequisitionToOrderData.tooltipinternalnote = UtilSql.getValue(result, "tooltipinternalnote");
        objectRequisitionToOrderData.tooltipnote = UtilSql.getValue(result, "tooltipnote");
        objectRequisitionToOrderData.documentno = UtilSql.getValue(result, "documentno");
        objectRequisitionToOrderData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectRequisitionToOrderData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectRequisitionToOrderData.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectRequisitionToOrderData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectRequisitionToOrderData.rownum = Long.toString(countRecord);
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] set()    throws ServletException {
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[1];
    objectRequisitionToOrderData[0] = new RequisitionToOrderData();
    objectRequisitionToOrderData[0].mRequisitionlineId = "";
    objectRequisitionToOrderData[0].reqqty = "";
    objectRequisitionToOrderData[0].matchedqty = "";
    objectRequisitionToOrderData[0].qtytoorder = "";
    objectRequisitionToOrderData[0].mPricelistId = "";
    objectRequisitionToOrderData[0].needbydate = "";
    objectRequisitionToOrderData[0].pricelist = "";
    objectRequisitionToOrderData[0].price = "";
    objectRequisitionToOrderData[0].mProductId = "";
    objectRequisitionToOrderData[0].mAttributesetinstanceId = "";
    objectRequisitionToOrderData[0].vendorId = "";
    objectRequisitionToOrderData[0].vendor = "";
    objectRequisitionToOrderData[0].product = "";
    objectRequisitionToOrderData[0].tooltipproduct = "";
    objectRequisitionToOrderData[0].attribute = "";
    objectRequisitionToOrderData[0].requester = "";
    objectRequisitionToOrderData[0].pricelistid = "";
    objectRequisitionToOrderData[0].vendorpricelist = "";
    objectRequisitionToOrderData[0].lockedby = "";
    objectRequisitionToOrderData[0].lockqty = "";
    objectRequisitionToOrderData[0].lockprice = "";
    objectRequisitionToOrderData[0].adOrgId = "";
    objectRequisitionToOrderData[0].org = "";
    objectRequisitionToOrderData[0].invoicerule = "";
    objectRequisitionToOrderData[0].deliveryrule = "";
    objectRequisitionToOrderData[0].freightcostrule = "";
    objectRequisitionToOrderData[0].deliveryviarule = "";
    objectRequisitionToOrderData[0].paymentrulepo = "";
    objectRequisitionToOrderData[0].poPaymenttermId = "";
    objectRequisitionToOrderData[0].note = "";
    objectRequisitionToOrderData[0].cUomId = "";
    objectRequisitionToOrderData[0].pricelimit = "";
    objectRequisitionToOrderData[0].priceactual = "";
    objectRequisitionToOrderData[0].discount = "";
    objectRequisitionToOrderData[0].tax = "";
    objectRequisitionToOrderData[0].cOrderlineId = "";
    objectRequisitionToOrderData[0].padre = "";
    objectRequisitionToOrderData[0].id = "";
    objectRequisitionToOrderData[0].name = "";
    objectRequisitionToOrderData[0].pricestd = "";
    objectRequisitionToOrderData[0].toClose = "";
    objectRequisitionToOrderData[0].project = "";
    objectRequisitionToOrderData[0].internalnote = "";
    objectRequisitionToOrderData[0].tooltipinternalnote = "";
    objectRequisitionToOrderData[0].tooltipnote = "";
    objectRequisitionToOrderData[0].documentno = "";
    objectRequisitionToOrderData[0].aAssetId = "";
    objectRequisitionToOrderData[0].cProjectId = "";
    objectRequisitionToOrderData[0].cProjectphaseId = "";
    objectRequisitionToOrderData[0].cProjecttaskId = "";
    return objectRequisitionToOrderData;
  }

  public static RequisitionToOrderData[] selectLines(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgId, String prejected, String parDateFrom, String parDateTo, String parProduct, String parRequester, String parVendorInc, String parVendor)    throws ServletException {
    return selectLines(connectionProvider, language, adUserClient, adOrgId, prejected, parDateFrom, parDateTo, parProduct, parRequester, parVendorInc, parVendor, 0, 0);
  }

  public static RequisitionToOrderData[] selectLines(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgId, String prejected, String parDateFrom, String parDateTo, String parProduct, String parRequester, String parVendorInc, String parVendor, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_REQUISITIONLINE_ID, M_REQUISITIONLINE.NEEDBYDATE," +
      "          M_REQUISITIONLINE.QTY - M_REQUISITIONLINE.ORDEREDQTY AS QTYTOORDER, M_REQUISITION.DOCUMENTNO," +
      "          zssi_strNumber(coalesce(M_REQUISITIONLINE.priceactual,m_get_offers_price(to_date(now()),coalesce(M_REQUISITIONLINE.C_BPARTNER_ID,M_REQUISITION.C_BPARTNER_ID,m_product.C_BPARTNER_ID)," +
      "                             M_REQUISITIONLINE.M_PRODUCT_ID,null,  M_REQUISITIONLINE.QTY - M_REQUISITIONLINE.ORDEREDQTY," +
      "                             ( select po_pricelist_id from c_bpartner where c_bpartner_id=coalesce(M_REQUISITIONLINE.C_BPARTNER_ID,M_REQUISITION.C_BPARTNER_ID,m_product.C_BPARTNER_ID)))),?)   AS PRICE," +
      "          AD_COLUMN_IDENTIFIER(to_char('C_BPartner'), coalesce(M_REQUISITIONLINE.C_BPARTNER_ID,M_REQUISITION.C_BPARTNER_ID,m_product.C_BPARTNER_ID), ?) AS VENDOR," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_PriceList'), ( select po_pricelist_id from c_bpartner where c_bpartner_id=coalesce(M_REQUISITIONLINE.C_BPARTNER_ID,M_REQUISITION.C_BPARTNER_ID,m_product.C_BPARTNER_ID)), ?) AS PRICELISTID," +
      "          zssi_nomultiline(AD_COLUMN_IDENTIFIER(to_char('M_Product'), to_char(M_REQUISITIONLINE.M_PRODUCT_ID), ?)) AS PRODUCT," +
      "          zssi_2HTML(AD_COLUMN_IDENTIFIER(to_char('M_Product'), to_char(M_REQUISITIONLINE.M_PRODUCT_ID), ?)) AS TOOLTIPPRODUCT," +
      "          zssi_getprojectorcostcentername(M_REQUISITIONLINE.c_project_id,M_REQUISITIONLINE.a_asset_id) as PROJECT," +
      "          zssi_nomultiline(M_REQUISITIONLINE.suppliernotes) as NOTE," +
      "          zssi_2HTML(M_REQUISITIONLINE.suppliernotes) as TOOLTIPNOTE," +
      "          zssi_nomultiline(M_REQUISITIONLINE.internalnotes) as INTERNALNOTE," +
      "          zssi_2HTML(M_REQUISITIONLINE.internalnotes) as TOOLTIPINTERNALNOTE," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_AttributeSetInstance'), to_char(M_REQUISITIONLINE.M_ATTRIBUTESETINSTANCE_ID), ?) AS ATTRIBUTE," +
      "          AD_COLUMN_IDENTIFIER(to_char('AD_User'), to_char(M_REQUISITION.AD_USER_ID), ?) AS REQUESTER" +
      "        FROM M_REQUISITIONLINE, M_REQUISITION,M_PRODUCT " +
      "        WHERE M_REQUISITIONLINE.M_REQUISITION_ID = M_REQUISITION.M_REQUISITION_ID" +
      "          AND M_PRODUCT.M_PRODUCT_ID=M_REQUISITIONLINE.M_PRODUCT_ID" +
      "          AND M_REQUISITION.ISACTIVE = 'Y'" +
      "          AND M_REQUISITIONLINE.ISACTIVE = 'Y'" +
      "          AND M_REQUISITION.DOCSTATUS = 'CO'" +
      "          AND M_REQUISITIONLINE.REQSTATUS = 'O'" +
      "          AND case M_REQUISITIONLINE.REJECTED when 'Y' then 1=1 else M_REQUISITIONLINE.LOCKEDBY IS NULL end" +
      "          AND M_REQUISITION.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "          AND M_REQUISITIONLINE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "          AND M_REQUISITIONLINE.REJECTED IN (";
    strSql = strSql + ((prejected==null || prejected.equals(""))?"":prejected);
    strSql = strSql + 
      ")" +
      "          AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND M_REQUISITIONLINE.NEEDBYDATE >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND M_REQUISITIONLINE.NEEDBYDATE < TO_DATE(?) ");
    strSql = strSql + ((parProduct==null || parProduct.equals(""))?"":"  AND M_REQUISITIONLINE.M_PRODUCT_ID = TO_CHAR(?) ");
    strSql = strSql + ((parRequester==null || parRequester.equals(""))?"":"  AND M_REQUISITION.AD_USER_ID = TO_CHAR(?) ");
    strSql = strSql + ((parVendorInc==null || parVendorInc.equals(""))?"":"  AND (COALESCE(M_REQUISITIONLINE.C_BPARTNER_ID, M_REQUISITION.C_BPARTNER_ID,'-1') = TO_CHAR(?) OR (M_REQUISITIONLINE.C_BPARTNER_ID IS NULL AND M_REQUISITION.C_BPARTNER_ID IS NULL)) ");
    strSql = strSql + ((parVendor==null || parVendor.equals(""))?"":"  AND COALESCE(M_REQUISITIONLINE.C_BPARTNER_ID, M_REQUISITION.C_BPARTNER_ID,'-1') = TO_CHAR(?) ");
    strSql = strSql + 
      "        ORDER BY M_REQUISITIONLINE.NEEDBYDATE, M_REQUISITIONLINE.M_PRODUCT_ID, M_REQUISITIONLINE.C_BPARTNER_ID, M_REQUISITIONLINE.M_ATTRIBUTESETINSTANCE_ID";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (prejected != null && !(prejected.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (parProduct != null && !(parProduct.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parProduct);
      }
      if (parRequester != null && !(parRequester.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parRequester);
      }
      if (parVendorInc != null && !(parVendorInc.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parVendorInc);
      }
      if (parVendor != null && !(parVendor.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parVendor);
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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.mRequisitionlineId = UtilSql.getValue(result, "m_requisitionline_id");
        objectRequisitionToOrderData.needbydate = UtilSql.getDateValue(result, "needbydate", "dd-MM-yyyy");
        objectRequisitionToOrderData.qtytoorder = UtilSql.getValue(result, "qtytoorder");
        objectRequisitionToOrderData.documentno = UtilSql.getValue(result, "documentno");
        objectRequisitionToOrderData.price = UtilSql.getValue(result, "price");
        objectRequisitionToOrderData.vendor = UtilSql.getValue(result, "vendor");
        objectRequisitionToOrderData.pricelistid = UtilSql.getValue(result, "pricelistid");
        objectRequisitionToOrderData.product = UtilSql.getValue(result, "product");
        objectRequisitionToOrderData.tooltipproduct = UtilSql.getValue(result, "tooltipproduct");
        objectRequisitionToOrderData.project = UtilSql.getValue(result, "project");
        objectRequisitionToOrderData.note = UtilSql.getValue(result, "note");
        objectRequisitionToOrderData.tooltipnote = UtilSql.getValue(result, "tooltipnote");
        objectRequisitionToOrderData.internalnote = UtilSql.getValue(result, "internalnote");
        objectRequisitionToOrderData.tooltipinternalnote = UtilSql.getValue(result, "tooltipinternalnote");
        objectRequisitionToOrderData.attribute = UtilSql.getValue(result, "attribute");
        objectRequisitionToOrderData.requester = UtilSql.getValue(result, "requester");
        objectRequisitionToOrderData.rownum = Long.toString(countRecord);
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] selectSelected(ConnectionProvider connectionProvider, String language, String isWorkflowActive, String isWorkflowApprover, String adUserId, String adUserClient, String adOrgId)    throws ServletException {
    return selectSelected(connectionProvider, language, isWorkflowActive, isWorkflowApprover, adUserId, adUserClient, adOrgId, 0, 0);
  }

  public static RequisitionToOrderData[] selectSelected(ConnectionProvider connectionProvider, String language, String isWorkflowActive, String isWorkflowApprover, String adUserId, String adUserClient, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_REQUISITIONLINE.M_REQUISITIONLINE_ID, M_REQUISITIONLINE.NEEDBYDATE, M_REQUISITIONLINE.QTY AS REQQTY," +
      "          M_REQUISITIONLINE.ORDEREDQTY AS MATCHEDQTY, M_REQUISITION.DOCUMENTNO," +
      "          coalesce(m_get_offers_price(to_date(now()),coalesce(M_REQUISITIONLINE.C_BPARTNER_ID,M_REQUISITION.C_BPARTNER_ID,m_product.C_BPARTNER_ID)," +
      "                             M_REQUISITIONLINE.M_PRODUCT_ID,null,  M_REQUISITIONLINE.QTY - M_REQUISITIONLINE.ORDEREDQTY," +
      "                             ( select po_pricelist_id from c_bpartner where c_bpartner_id=coalesce(M_REQUISITIONLINE.C_BPARTNER_ID,M_REQUISITION.C_BPARTNER_ID,m_product.C_BPARTNER_ID))),0) AS PRICELIST," +
      "          COALESCE(LOCKQTY, QTY-ORDEREDQTY) AS LOCKQTY," +
      "          coalesce(M_REQUISITIONLINE.priceactual,m_get_offers_price(to_date(now()),coalesce(M_REQUISITIONLINE.C_BPARTNER_ID,M_REQUISITION.C_BPARTNER_ID,m_product.C_BPARTNER_ID)," +
      "                             M_REQUISITIONLINE.M_PRODUCT_ID,null,  M_REQUISITIONLINE.QTY - M_REQUISITIONLINE.ORDEREDQTY," +
      "                             ( select po_pricelist_id from c_bpartner where c_bpartner_id=coalesce(M_REQUISITIONLINE.C_BPARTNER_ID,M_REQUISITION.C_BPARTNER_ID,m_product.C_BPARTNER_ID))))   AS LOCKPRICE," +
      "          coalesce(M_REQUISITIONLINE.C_BPARTNER_ID,M_REQUISITION.C_BPARTNER_ID,m_product.C_BPARTNER_ID,'-1') AS VENDOR_ID," +
      "          COALESCE(( select po_pricelist_id from c_bpartner where c_bpartner_id=coalesce(M_REQUISITIONLINE.C_BPARTNER_ID,M_REQUISITION.C_BPARTNER_ID,m_product.C_BPARTNER_ID)), '-1') AS M_PRICELIST_ID," +
      "          AD_COLUMN_IDENTIFIER(to_char('C_BPartner'), coalesce(M_REQUISITIONLINE.C_BPARTNER_ID,M_REQUISITION.C_BPARTNER_ID,m_product.C_BPARTNER_ID), ?) AS VENDOR," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_PriceList'), ( select po_pricelist_id from c_bpartner where c_bpartner_id=coalesce(M_REQUISITIONLINE.C_BPARTNER_ID,M_REQUISITION.C_BPARTNER_ID,m_product.C_BPARTNER_ID)), ?) AS PRICELISTID," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_Product'), to_char(M_REQUISITIONLINE.M_PRODUCT_ID), ?) AS PRODUCT," +
      "          zssi_2HTML(AD_COLUMN_IDENTIFIER(to_char('M_Product'), to_char(M_REQUISITIONLINE.M_PRODUCT_ID), ?)) AS TOOLTIPPRODUCT," +
      "          zssi_getprojectorcostcentername(M_REQUISITIONLINE.c_project_id,M_REQUISITIONLINE.a_asset_id) as PROJECT," +
      "          zssi_nomultiline(M_REQUISITIONLINE.suppliernotes) as NOTE," +
      "          zssi_2HTML(M_REQUISITIONLINE.suppliernotes) as TOOLTIPNOTE," +
      "          zssi_nomultiline(M_REQUISITIONLINE.internalnotes) as INTERNALNOTE," +
      "          zssi_2HTML(M_REQUISITIONLINE.internalnotes) as TOOLTIPINTERNALNOTE," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_AttributeSetInstance'), to_char(M_REQUISITIONLINE.M_ATTRIBUTESETINSTANCE_ID), ?) AS ATTRIBUTE" +
      "        FROM M_REQUISITION, M_REQUISITIONLINE,M_PRODUCT " +
      "        WHERE M_REQUISITION.M_REQUISITION_ID = M_REQUISITIONLINE.M_REQUISITION_ID" +
      "          AND M_PRODUCT.M_PRODUCT_ID=M_REQUISITIONLINE.M_PRODUCT_ID" +
      "          AND M_REQUISITION.ISACTIVE = 'Y'" +
      "          AND M_REQUISITIONLINE.ISACTIVE = 'Y'" +
      "          AND M_REQUISITION.DOCSTATUS = 'CO'" +
      "          AND M_REQUISITIONLINE.REQSTATUS = 'O'" +
      "          AND case ? when 'Y' then (case ? when 'Y' then M_REQUISITIONLINE.LOCKEDBY is not null and M_REQUISITIONLINE.REJECTED='N' else M_REQUISITIONLINE.LOCKEDBY is not null and M_REQUISITIONLINE.REJECTED='N' end) else M_REQUISITIONLINE.LOCKEDBY = ? end" +
      "          AND M_REQUISITION.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "          AND M_REQUISITIONLINE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "        ORDER BY  VENDOR, M_REQUISITION.DOCUMENTNO, PRODUCT";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isWorkflowActive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isWorkflowApprover);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.mRequisitionlineId = UtilSql.getValue(result, "m_requisitionline_id");
        objectRequisitionToOrderData.needbydate = UtilSql.getDateValue(result, "needbydate", "dd-MM-yyyy");
        objectRequisitionToOrderData.reqqty = UtilSql.getValue(result, "reqqty");
        objectRequisitionToOrderData.matchedqty = UtilSql.getValue(result, "matchedqty");
        objectRequisitionToOrderData.documentno = UtilSql.getValue(result, "documentno");
        objectRequisitionToOrderData.pricelist = UtilSql.getValue(result, "pricelist");
        objectRequisitionToOrderData.lockqty = UtilSql.getValue(result, "lockqty");
        objectRequisitionToOrderData.lockprice = UtilSql.getValue(result, "lockprice");
        objectRequisitionToOrderData.vendorId = UtilSql.getValue(result, "vendor_id");
        objectRequisitionToOrderData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectRequisitionToOrderData.vendor = UtilSql.getValue(result, "vendor");
        objectRequisitionToOrderData.pricelistid = UtilSql.getValue(result, "pricelistid");
        objectRequisitionToOrderData.product = UtilSql.getValue(result, "product");
        objectRequisitionToOrderData.tooltipproduct = UtilSql.getValue(result, "tooltipproduct");
        objectRequisitionToOrderData.project = UtilSql.getValue(result, "project");
        objectRequisitionToOrderData.note = UtilSql.getValue(result, "note");
        objectRequisitionToOrderData.tooltipnote = UtilSql.getValue(result, "tooltipnote");
        objectRequisitionToOrderData.internalnote = UtilSql.getValue(result, "internalnote");
        objectRequisitionToOrderData.tooltipinternalnote = UtilSql.getValue(result, "tooltipinternalnote");
        objectRequisitionToOrderData.attribute = UtilSql.getValue(result, "attribute");
        objectRequisitionToOrderData.rownum = Long.toString(countRecord);
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] linesToOrder(ConnectionProvider connectionProvider, String billto, String org, String parRequisitionLines)    throws ServletException {
    return linesToOrder(connectionProvider, billto, org, parRequisitionLines, 0, 0);
  }

  public static RequisitionToOrderData[] linesToOrder(ConnectionProvider connectionProvider, String billto, String org, String parRequisitionLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_REQUISITIONLINE.M_PRODUCT_ID, M_ATTRIBUTESETINSTANCE_ID, LOCKQTY,suppliernotes AS NOTE, C_UOM_ID, " +
      "          M_REQUISITIONLINE_ID, '' AS C_ORDERLINE_ID," +
      "          COALESCE(M_REQUISITIONLINE.PRICELIST, LOCKPRICE) AS PRICELIST," +
      "          LOCKPRICE AS PRICELIMIT," +
      "          LOCKPRICE AS PRICESTD," +
      "          COALESCE(M_REQUISITIONLINE.PRICEACTUAL, LOCKPRICE) AS PRICEACTUAL," +
      "          0 AS DISCOUNT," +
      "          zsfi_GetTax(?,M_REQUISITIONLINE.M_PRODUCT_ID, ?) AS TAX," +
      "          CASE WHEN LOCKQTY < (M_REQUISITIONLINE.QTY - M_REQUISITIONLINE.ORDEREDQTY) THEN 'N' ELSE 'Y' END AS TO_CLOSE," +
      "          M_REQUISITIONLINE.a_asset_id,M_REQUISITIONLINE.c_project_id,M_REQUISITIONLINE.c_projectphase_id,M_REQUISITIONLINE.c_projecttask_id" +
      "        FROM M_REQUISITIONLINE " +
      "        WHERE 1=1";
    strSql = strSql + ((parRequisitionLines==null || parRequisitionLines.equals(""))?"":"  AND M_RequisitionLine_ID IN" + parRequisitionLines);
    strSql = strSql + 
      "        ORDER BY M_REQUISITIONLINE.M_PRODUCT_ID, M_ATTRIBUTESETINSTANCE_ID, SUPPLIERNOTES, LOCKPRICE";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      if (parRequisitionLines != null && !(parRequisitionLines.equals(""))) {
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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectRequisitionToOrderData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectRequisitionToOrderData.lockqty = UtilSql.getValue(result, "lockqty");
        objectRequisitionToOrderData.note = UtilSql.getValue(result, "note");
        objectRequisitionToOrderData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectRequisitionToOrderData.mRequisitionlineId = UtilSql.getValue(result, "m_requisitionline_id");
        objectRequisitionToOrderData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectRequisitionToOrderData.pricelist = UtilSql.getValue(result, "pricelist");
        objectRequisitionToOrderData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectRequisitionToOrderData.pricestd = UtilSql.getValue(result, "pricestd");
        objectRequisitionToOrderData.priceactual = UtilSql.getValue(result, "priceactual");
        objectRequisitionToOrderData.discount = UtilSql.getValue(result, "discount");
        objectRequisitionToOrderData.tax = UtilSql.getValue(result, "tax");
        objectRequisitionToOrderData.toClose = UtilSql.getValue(result, "to_close");
        objectRequisitionToOrderData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectRequisitionToOrderData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectRequisitionToOrderData.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectRequisitionToOrderData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectRequisitionToOrderData.rownum = Long.toString(countRecord);
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] selectVendor(ConnectionProvider connectionProvider, String parRequisitionLines)    throws ServletException {
    return selectVendor(connectionProvider, parRequisitionLines, 0, 0);
  }

  public static RequisitionToOrderData[] selectVendor(ConnectionProvider connectionProvider, String parRequisitionLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT DISTINCT COALESCE(M_REQUISITIONLINE.C_BPARTNER_ID, M_REQUISITION.C_BPARTNER_ID) AS VENDOR_ID" +
      "      FROM M_REQUISITIONLINE, M_REQUISITION" +
      "      WHERE M_REQUISITION.M_REQUISITION_ID = M_REQUISITIONLINE.M_REQUISITION_ID" +
      "        AND COALESCE(M_REQUISITIONLINE.C_BPARTNER_ID, M_REQUISITION.C_BPARTNER_ID) IS NOT NULL" +
      "        AND 1=1";
    strSql = strSql + ((parRequisitionLines==null || parRequisitionLines.equals(""))?"":" AND M_RequisitionLine_ID IN" + parRequisitionLines);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (parRequisitionLines != null && !(parRequisitionLines.equals(""))) {
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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.vendorId = UtilSql.getValue(result, "vendor_id");
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] selectPriceList(ConnectionProvider connectionProvider, String language, String parRequisitionLines)    throws ServletException {
    return selectPriceList(connectionProvider, language, parRequisitionLines, 0, 0);
  }

  public static RequisitionToOrderData[] selectPriceList(ConnectionProvider connectionProvider, String language, String parRequisitionLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT c_bpartner.po_pricelist_id AS M_PRICELIST_ID," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_PriceList'), c_bpartner.po_pricelist_id, ?) AS PRICELISTID" +
      "        FROM M_REQUISITIONLINE, M_REQUISITION, c_bpartner " +
      "        WHERE M_REQUISITION.M_REQUISITION_ID = M_REQUISITIONLINE.M_REQUISITION_ID" +
      "          AND coalesce(M_REQUISITIONLINE.c_bpartner_id,M_REQUISITION.c_bpartner_id)=c_bpartner.c_bpartner_id" +
      "          AND 1=1";
    strSql = strSql + ((parRequisitionLines==null || parRequisitionLines.equals(""))?"":" AND M_RequisitionLine_ID IN" + parRequisitionLines);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (parRequisitionLines != null && !(parRequisitionLines.equals(""))) {
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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectRequisitionToOrderData.pricelistid = UtilSql.getValue(result, "pricelistid");
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] selectOrg(ConnectionProvider connectionProvider, String language, String parRequisitionLines)    throws ServletException {
    return selectOrg(connectionProvider, language, parRequisitionLines, 0, 0);
  }

  public static RequisitionToOrderData[] selectOrg(ConnectionProvider connectionProvider, String language, String parRequisitionLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT AD_ORG_ID," +
      "          AD_COLUMN_IDENTIFIER(to_char('AD_Org'), to_char(AD_ORG_ID), ?) AS ORG" +
      "        FROM M_REQUISITIONLINE" +
      "        WHERE 1=1";
    strSql = strSql + ((parRequisitionLines==null || parRequisitionLines.equals(""))?"":" AND M_RequisitionLine_ID IN" + parRequisitionLines);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (parRequisitionLines != null && !(parRequisitionLines.equals(""))) {
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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectRequisitionToOrderData.org = UtilSql.getValue(result, "org");
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] selectNoPrice(ConnectionProvider connectionProvider, String language, String pricelistversion, String parRequisitionLines)    throws ServletException {
    return selectNoPrice(connectionProvider, language, pricelistversion, parRequisitionLines, 0, 0);
  }

  public static RequisitionToOrderData[] selectNoPrice(ConnectionProvider connectionProvider, String language, String pricelistversion, String parRequisitionLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT M_PRODUCT_ID," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_Product'), to_char(M_REQUISITIONLINE.M_PRODUCT_ID), ?) AS PRODUCT" +
      "        FROM M_REQUISITIONLINE" +
      "        WHERE NOT EXISTS ( SELECT 1 FROM M_PRODUCTPRICE" +
      "                           WHERE M_REQUISITIONLINE.M_PRODUCT_ID = M_PRODUCTPRICE.M_PRODUCT_ID" +
      "                           AND M_PRODUCTPRICE.M_PRICELIST_VERSION_ID = ? )" +
      "          AND LOCKPRICE IS NULL" +
      "          AND 1=1";
    strSql = strSql + ((parRequisitionLines==null || parRequisitionLines.equals(""))?"":"  AND M_RequisitionLine_ID IN" + parRequisitionLines);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelistversion);
      if (parRequisitionLines != null && !(parRequisitionLines.equals(""))) {
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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectRequisitionToOrderData.product = UtilSql.getValue(result, "product");
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] selectWarehouseDouble(ConnectionProvider connectionProvider, String clientid, String adOrgId, String adclient)    throws ServletException {
    return selectWarehouseDouble(connectionProvider, clientid, adOrgId, adclient, 0, 0);
  }

  public static RequisitionToOrderData[] selectWarehouseDouble(ConnectionProvider connectionProvider, String clientid, String adOrgId, String adclient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG.AD_ORG_ID AS PADRE, M_WAREHOUSE.M_WAREHOUSE_ID AS ID, M_WAREHOUSE.NAME AS NAME" +
      "        FROM M_WAREHOUSE, AD_ORG" +
      "        WHERE AD_ISORGINCLUDED(AD_ORG.AD_ORG_ID, M_WAREHOUSE.AD_ORG_ID, ?) <> -1" +
      "          AND AD_ORG.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "          AND M_WAREHOUSE.AD_CLIENT_ID IN (";
    strSql = strSql + ((adclient==null || adclient.equals(""))?"":adclient);
    strSql = strSql + 
      ")" +
      "        ORDER BY PADRE, NAME";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, clientid);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adclient != null && !(adclient.equals(""))) {
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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.padre = UtilSql.getValue(result, "padre");
        objectRequisitionToOrderData.id = UtilSql.getValue(result, "id");
        objectRequisitionToOrderData.name = UtilSql.getValue(result, "name");
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] selectVendorData(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return selectVendorData(connectionProvider, cBpartnerId, 0, 0);
  }

  public static RequisitionToOrderData[] selectVendorData(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT p.InvoiceRule, p.DeliveryRule, DeliveryViaRule," +
      "        p.PaymentRulePO, p.PO_PaymentTerm_ID" +
      "      FROM C_BPartner p" +
      "      WHERE p.C_BPartner_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectRequisitionToOrderData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectRequisitionToOrderData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectRequisitionToOrderData.paymentrulepo = UtilSql.getValue(result, "paymentrulepo");
        objectRequisitionToOrderData.poPaymenttermId = UtilSql.getValue(result, "po_paymentterm_id");
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static String bPartnerDescription(ConnectionProvider connectionProvider, String partnerid, String language)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_COLUMN_IDENTIFIER(to_char('C_BPartner'), to_char(?), to_char(?)) AS VENDOR" +
      "        FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, partnerid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "vendor");
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

  public static String mProductDescription(ConnectionProvider connectionProvider, String productid, String language)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_COLUMN_IDENTIFIER(to_char('M_Product'), to_char(?), to_char(?)) AS PRODUCT" +
      "        FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "product");
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

  public static String getPricelistVersion(ConnectionProvider connectionProvider, String pricelist, String orderdate)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_GET_PRICELIST_VERSION(?, to_date(?)) AS PRICELISTID" +
      "        FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderdate);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "pricelistid");
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

  public static String treeOrg(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TREE_ORG_ID FROM AD_CLIENTINFO" +
      "        WHERE AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_tree_org_id");
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

  public static String cDoctypeTarget(Connection conn, ConnectionProvider connectionProvider, String adClientId, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_GET_DOCTYPE(?, ?, 'POO', null) FROM DUAL";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_get_doctype");
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

  public static String cBPartnerLocationId(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C_BPARTNER_LOCATION_ID) FROM C_BPARTNER_LOCATION" +
      "        WHERE C_BPARTNER_ID = ?" +
      "        AND C_BPartner_Location.IsActive='Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "max");
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

  public static String billto(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C_BPARTNER_LOCATION_ID) FROM C_BPARTNER_LOCATION" +
      "        WHERE  C_BPartner_Location.IsBillTo='Y'" +
      "        AND C_BPartner_Location.IsActive='Y'" +
      "        AND C_BPARTNER_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "max");
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

  public static String selectCurrency(ConnectionProvider connectionProvider, String mPricelistId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_CURRENCY_ID" +
      "        FROM M_PRICELIST" +
      "        WHERE  M_PRICELIST_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);

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

  public static String selectPricelistversion(ConnectionProvider connectionProvider, String mPricelistId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT M_PRICELIST_VERSION_ID  FROM M_PRICELIST_VERSION" +
      "          WHERE M_PRICELIST_ID= ? and  VALIDFROM =    (SELECT max(VALIDFROM)    FROM M_PRICELIST_VERSION   WHERE M_PRICELIST_ID= ? and VALIDFROM<=TO_DATE(NOW()))";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_pricelist_version_id");
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

  public static int unlock(ConnectionProvider connectionProvider, String requisitionlines)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_REQUISITIONLINE" +
      "        SET LOCKEDBY = null," +
      "            LOCKPRICE = null," +
      "            LOCKQTY = null," +
      "            LOCKDATE = null," +
      "            LOCKCAUSE = null" +
      "        WHERE M_REQUISITIONLINE_ID IN ";
    strSql = strSql + ((requisitionlines==null || requisitionlines.equals(""))?"":requisitionlines);

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (requisitionlines != null && !(requisitionlines.equals(""))) {
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

  public static int lock(ConnectionProvider connectionProvider, String userId, String requisitionlines)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_REQUISITIONLINE" +
      "        SET LOCKEDBY = ?," +
      "            LOCKDATE = now()," +
      "            LOCKQTY = null," +
      "            LOCKPRICE = null," +
      "            LOCKCAUSE = 'M'," +
      "            REJECTED ='N'" +
      "        WHERE M_REQUISITIONLINE_ID IN ";
    strSql = strSql + ((requisitionlines==null || requisitionlines.equals(""))?"":requisitionlines);

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);
      if (requisitionlines != null && !(requisitionlines.equals(""))) {
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

  public static int reject(ConnectionProvider connectionProvider, String userId, String requisitionlines)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_REQUISITIONLINE" +
      "        SET REJECTED = 'Y'," +
      "            LOCKEDBY = ?," +
      "            LOCKDATE = now()," +
      "            UPDATEDBY = ?," +
      "            UPDATED = now()" +
      "        WHERE M_REQUISITIONLINE_ID IN ";
    strSql = strSql + ((requisitionlines==null || requisitionlines.equals(""))?"":requisitionlines);

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);
      if (requisitionlines != null && !(requisitionlines.equals(""))) {
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

  public static int updateLock(ConnectionProvider connectionProvider, String lockQty, String lockPrice, String mRequisitionLineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_REQUISITIONLINE" +
      "        SET LOCKQTY = to_number(?)," +
      "            LOCKPRICE = to_number(?)" +
      "        WHERE M_REQUISITIONLINE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lockQty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lockPrice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mRequisitionLineId);

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

  public static int insertCOrder(Connection conn, ConnectionProvider connectionProvider, String cOrderId, String adClientId, String adOrgId, String user, String documentNo, String docStatus, String docAction, String cDoctypeId, String cDoctypetargetId, String dateordered, String datepromised, String dateacct, String cBpartnerId, String cBpartnerLocationId, String billtoId, String cCurrencyId, String paymentrule, String cPaymenttermId, String invoicerule, String deliveryrule, String freightcostrule, String deliveryviarule, String mWarehouseId, String mPricelistId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_ORDER (C_ORDER_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, DOCUMENTNO," +
      "        DOCSTATUS, DOCACTION, C_DOCTYPE_ID, C_DOCTYPETARGET_ID," +
      "        DATEORDERED, DATEPROMISED, DATEACCT, C_BPARTNER_ID, C_BPARTNER_LOCATION_ID, BILLTO_ID, C_CURRENCY_ID, " +
      "        PAYMENTRULE, C_PAYMENTTERM_ID, INVOICERULE, DELIVERYRULE, FREIGHTCOSTRULE, " +
      "        DELIVERYVIARULE, M_WAREHOUSE_ID, M_PRICELIST_ID, " +
      "        PRIORITYRULE, ISSOTRX,PROCESSING,salesrep_id)" +
      "        VALUES (?,?,?,now(),?,now(),?,?,?,?,?,?,TO_DATE(?),TO_DATE(?),TO_DATE(?),?,?,?,?,?,?,?,?,?,?,?,?,'5', 'N','N',?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentNo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docStatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docAction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);

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

  public static int insertCOrderline(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId, String adClientId, String adOrgId, String user, String cOrderId, String line, String cBpartnerId, String cBpartnerLocationId, String dateordered, String datepromised, String description, String mProductId, String mAttributeSetInstanceId, String mWarehouseId, String cUomId, String qtyordered, String cCurrencyId, String plvId, String priceactual, String pricelistid, String taxid, String discount, String cAssetID, String cProjectID, String cProjectPhaseId, String cProjectTaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_ORDERLINE (C_ORDERLINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "        C_ORDER_ID, LINE, C_BPARTNER_ID, C_BPARTNER_LOCATION_ID, DATEORDERED, DATEPROMISED, " +
      "        DESCRIPTION, M_PRODUCT_ID, M_ATTRIBUTESETINSTANCE_ID," +
      "        M_WAREHOUSE_ID, C_UOM_ID, QTYORDERED, C_CURRENCY_ID, " +
      "        PRICELIST, " +
      "        PRICEACTUAL," +
      "        PRICESTD, " +
      "        C_TAX_ID, DISCOUNT, " +
      "        A_ASSET_ID, C_PROJECT_ID, C_PROJECTPHASE_ID, C_PROJECTTASK_ID) " +
      "        VALUES (?,?,?,now(),?,now(),?," +
      "        ?,TO_NUMBER(?),?,?,TO_DATE(?),TO_DATE(?)," +
      "        ?,?,?," +
      "        ?, ?,TO_NUMBER(?),?," +
      "        m_bom_pricelist(?,?), " +
      "        coalesce(TO_NUMBER(?),m_get_offers_price(to_date(now()),?,?,0.0,TO_NUMBER(?),?))," +
      "        m_bom_pricestd(?,?), " +
      "        ?, TO_NUMBER(?), " +
      "        ?,?,?,?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributeSetInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plvId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelistid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plvId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAssetID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectPhaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectTaskId);

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

  public static int insertRequisitionOrder(Connection conn, ConnectionProvider connectionProvider, String mRequisitionOrderId, String adClientId, String adOrgId, String user, String mRequisitionLineId, String cOrderLineId, String qty)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO M_REQUISITIONORDER (M_REQUISITIONORDER_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, ISACTIVE," +
      "        M_REQUISITIONLINE_ID, C_ORDERLINE_ID, QTY)" +
      "        VALUES (?,?,?,now(),?,now(),?,'Y'," +
      "        ?,?,TO_NUMBER(?))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mRequisitionOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mRequisitionLineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderLineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);

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

  public static RequisitionToOrderData cOrderPost0(Connection conn, ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Order_Post(?)";

    RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      st.execute();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
        log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
        throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
        log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData requisitionStatus(Connection conn, ConnectionProvider connectionProvider, String requisitionLineId, String userId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_RequisitionLine_Status(null, ?, ?)";

    RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, requisitionLineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);

      st.execute();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(requisitionLineId);
      parametersTypes.addElement("in");
      parametersData.addElement(userId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
        log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
        throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
        log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectRequisitionToOrderData);
  }

  public static int updateOrderReference(ConnectionProvider connectionProvider, String cAssetID, String cProjectID, String cProjectPhaseId, String cProjectTaskId, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_ORDER" +
      "        SET A_ASSET_ID = ?," +
      "            C_PROJECT_ID = ?," +
      "            C_PROJECTPHASE_ID = ?," +
      "            C_PROJECTTASK_ID = ?" +
      "        WHERE C_ORDER_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAssetID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectPhaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectTaskId);
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static String isPRapprovalworkflow(ConnectionProvider connectionProvider, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT prapprovalworkflow" +
      "       from   " +
      "       (SELECT prapprovalworkflow,isstandard" +
      "            from c_orgconfiguration       " +
      "            WHERE ad_org_id = ? " +
      "        UNION" +
      "        SELECT prapprovalworkflow,isstandard" +
      "            from c_orgconfiguration " +
      "            WHERE isstandard='Y'" +
      "        )a order by isstandard LIMIT 1";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "prapprovalworkflow");
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

  public static String isPRapprover(ConnectionProvider connectionProvider, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT isprapprover" +
      "       from" +
      "       (SELECT isprapprover" +
      "           from   c_bpartner,ad_user where ad_user.c_bpartner_id= c_bpartner.c_bpartner_id      " +
      "           and ad_user_id = ? " +
      "        UNION" +
      "           SELECT 'N' as isprapprover from dual" +
      "        ) a order by isprapprover desc LIMIT 1";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "isprapprover");
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

  public static int lockbyRequestor(ConnectionProvider connectionProvider, String requisitionlines)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_REQUISITIONLINE SET LOCKEDBY=o.lockedby, LOCKDATE = now()," +
      "                LOCKQTY = null," +
      "                LOCKPRICE = null," +
      "                LOCKCAUSE = 'M'," +
      "                REJECTED ='N'  from (select ad_user_id as lockedby,m_requisition_id from m_requisition) as o " +
      "            where M_REQUISITIONLINE.m_requisition_id=o.m_requisition_id" +
      "              and M_REQUISITIONLINE_ID IN ";
    strSql = strSql + ((requisitionlines==null || requisitionlines.equals(""))?"":requisitionlines);

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (requisitionlines != null && !(requisitionlines.equals(""))) {
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
}
