//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.DocumentPreferences;

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
class Preferences3D18346ED9BD4F70B308F4878E7830D6Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Preferences3D18346ED9BD4F70B308F4878E7830D6Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssiSmartinvoiceprefsId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String invoicetype;
  public String invoicetyper;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String mPricelistId;
  public String mPricelistIdr;
  public String cPaymenttermId;
  public String cPaymenttermIdr;
  public String paymentrule;
  public String paymentruler;
  public String deliveryrule;
  public String deliveryruler;
  public String invoicerule;
  public String invoiceruler;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String deliveryviarule;
  public String deliveryviaruler;
  public String freightcostrule;
  public String freightcostruler;
  public String cIncotermsId;
  public String cIncotermsIdr;
  public String weightUom;
  public String weightUomr;
  public String mShipperId;
  public String mShipperIdr;
  public String isautoclosing;
  public String isdefault;
  public String usecustomersdefaults;
  public String isactive;
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
    else if (fieldName.equalsIgnoreCase("zssi_smartinvoiceprefs_id") || fieldName.equals("zssiSmartinvoiceprefsId"))
      return zssiSmartinvoiceprefsId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("invoicetype"))
      return invoicetype;
    else if (fieldName.equalsIgnoreCase("invoicetyper"))
      return invoicetyper;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_idr") || fieldName.equals("mPricelistIdr"))
      return mPricelistIdr;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_idr") || fieldName.equals("cPaymenttermIdr"))
      return cPaymenttermIdr;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("paymentruler"))
      return paymentruler;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("deliveryruler"))
      return deliveryruler;
    else if (fieldName.equalsIgnoreCase("invoicerule"))
      return invoicerule;
    else if (fieldName.equalsIgnoreCase("invoiceruler"))
      return invoiceruler;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
    else if (fieldName.equalsIgnoreCase("deliveryviaruler"))
      return deliveryviaruler;
    else if (fieldName.equalsIgnoreCase("freightcostrule"))
      return freightcostrule;
    else if (fieldName.equalsIgnoreCase("freightcostruler"))
      return freightcostruler;
    else if (fieldName.equalsIgnoreCase("c_incoterms_id") || fieldName.equals("cIncotermsId"))
      return cIncotermsId;
    else if (fieldName.equalsIgnoreCase("c_incoterms_idr") || fieldName.equals("cIncotermsIdr"))
      return cIncotermsIdr;
    else if (fieldName.equalsIgnoreCase("weight_uom") || fieldName.equals("weightUom"))
      return weightUom;
    else if (fieldName.equalsIgnoreCase("weight_uomr") || fieldName.equals("weightUomr"))
      return weightUomr;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("m_shipper_idr") || fieldName.equals("mShipperIdr"))
      return mShipperIdr;
    else if (fieldName.equalsIgnoreCase("isautoclosing"))
      return isautoclosing;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("usecustomersdefaults"))
      return usecustomersdefaults;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
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
  public static Preferences3D18346ED9BD4F70B308F4878E7830D6Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Preferences3D18346ED9BD4F70B308F4878E7830D6Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_smartinvoiceprefs.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_smartinvoiceprefs.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_smartinvoiceprefs.Updated, ?) as updated, " +
      "        to_char(zssi_smartinvoiceprefs.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_smartinvoiceprefs.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_smartinvoiceprefs.UpdatedBy) as UpdatedByR," +
      "        zssi_smartinvoiceprefs.Zssi_Smartinvoiceprefs_ID, " +
      "zssi_smartinvoiceprefs.AD_Client_ID, " +
      "(CASE WHEN zssi_smartinvoiceprefs.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "zssi_smartinvoiceprefs.AD_Org_ID, " +
      "(CASE WHEN zssi_smartinvoiceprefs.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zssi_smartinvoiceprefs.Invoicetype, " +
      "(CASE WHEN zssi_smartinvoiceprefs.Invoicetype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS InvoicetypeR, " +
      "zssi_smartinvoiceprefs.C_Bpartner_ID, " +
      "(CASE WHEN zssi_smartinvoiceprefs.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "zssi_smartinvoiceprefs.C_Bpartner_Location_ID, " +
      "(CASE WHEN zssi_smartinvoiceprefs.C_Bpartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Bpartner_Location_IDR, " +
      "zssi_smartinvoiceprefs.C_Doctype_ID, " +
      "(CASE WHEN zssi_smartinvoiceprefs.C_Doctype_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS C_Doctype_IDR, " +
      "zssi_smartinvoiceprefs.M_Pricelist_ID, " +
      "(CASE WHEN zssi_smartinvoiceprefs.M_Pricelist_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS M_Pricelist_IDR, " +
      "zssi_smartinvoiceprefs.C_Paymentterm_ID, " +
      "(CASE WHEN zssi_smartinvoiceprefs.C_Paymentterm_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL7.Name IS NULL THEN TO_CHAR(table7.Name) ELSE TO_CHAR(tableTRL7.Name) END)), ''))),'') ) END) AS C_Paymentterm_IDR, " +
      "zssi_smartinvoiceprefs.Paymentrule, " +
      "(CASE WHEN zssi_smartinvoiceprefs.Paymentrule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS PaymentruleR, " +
      "zssi_smartinvoiceprefs.Deliveryrule, " +
      "(CASE WHEN zssi_smartinvoiceprefs.Deliveryrule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS DeliveryruleR, " +
      "zssi_smartinvoiceprefs.Invoicerule, " +
      "(CASE WHEN zssi_smartinvoiceprefs.Invoicerule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS InvoiceruleR, " +
      "zssi_smartinvoiceprefs.M_Warehouse_ID, " +
      "(CASE WHEN zssi_smartinvoiceprefs.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "zssi_smartinvoiceprefs.DeliveryViaRule, " +
      "(CASE WHEN zssi_smartinvoiceprefs.DeliveryViaRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list5.name),'') ) END) AS DeliveryViaRuleR, " +
      "zssi_smartinvoiceprefs.Freightcostrule, " +
      "(CASE WHEN zssi_smartinvoiceprefs.Freightcostrule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list6.name),'') ) END) AS FreightcostruleR, " +
      "zssi_smartinvoiceprefs.C_Incoterms_ID, " +
      "(CASE WHEN zssi_smartinvoiceprefs.C_Incoterms_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS C_Incoterms_IDR, " +
      "zssi_smartinvoiceprefs.Weight_Uom, " +
      "(CASE WHEN zssi_smartinvoiceprefs.Weight_Uom IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL10.Name IS NULL THEN TO_CHAR(table10.Name) ELSE TO_CHAR(tableTRL10.Name) END)), ''))),'') ) END) AS Weight_UomR, " +
      "zssi_smartinvoiceprefs.M_Shipper_ID, " +
      "(CASE WHEN zssi_smartinvoiceprefs.M_Shipper_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS M_Shipper_IDR, " +
      "COALESCE(zssi_smartinvoiceprefs.Isautoclosing, 'N') AS Isautoclosing, " +
      "COALESCE(zssi_smartinvoiceprefs.Isdefault, 'N') AS Isdefault, " +
      "COALESCE(zssi_smartinvoiceprefs.Usecustomersdefaults, 'N') AS Usecustomersdefaults, " +
      "COALESCE(zssi_smartinvoiceprefs.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_smartinvoiceprefs left join (select AD_Client_ID, Name from AD_Client) table1 on (zssi_smartinvoiceprefs.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (zssi_smartinvoiceprefs.AD_Org_ID = table2.AD_Org_ID) left join ad_ref_list_v list1 on (zssi_smartinvoiceprefs.Invoicetype = list1.value and list1.ad_reference_id = 'F2F614C13163411D8EFD805E23037EE0' and list1.ad_language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table3 on (zssi_smartinvoiceprefs.C_Bpartner_ID = table3.C_BPartner_ID) left join (select C_Bpartner_Location_ID, Name from C_Bpartner_Location) table4 on (zssi_smartinvoiceprefs.C_Bpartner_Location_ID = table4.C_Bpartner_Location_ID) left join (select C_Doctype_ID, Name from C_Doctype) table5 on (zssi_smartinvoiceprefs.C_Doctype_ID = table5.C_Doctype_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL5 on (table5.C_DocType_ID = tableTRL5.C_DocType_ID and tableTRL5.AD_Language = ?)  left join (select M_Pricelist_ID, Name from M_Pricelist) table6 on (zssi_smartinvoiceprefs.M_Pricelist_ID = table6.M_Pricelist_ID) left join (select C_Paymentterm_ID, Name from C_Paymentterm) table7 on (zssi_smartinvoiceprefs.C_Paymentterm_ID = table7.C_Paymentterm_ID) left join (select C_PaymentTerm_ID,AD_Language, Name from C_PaymentTerm_TRL) tableTRL7 on (table7.C_PaymentTerm_ID = tableTRL7.C_PaymentTerm_ID and tableTRL7.AD_Language = ?)  left join ad_ref_list_v list2 on (zssi_smartinvoiceprefs.Paymentrule = list2.value and list2.ad_reference_id = '195' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (zssi_smartinvoiceprefs.Deliveryrule = list3.value and list3.ad_reference_id = '151' and list3.ad_language = ?)  left join ad_ref_list_v list4 on (zssi_smartinvoiceprefs.Invoicerule = list4.value and list4.ad_reference_id = '150' and list4.ad_language = ?)  left join (select M_Warehouse_ID, Name from M_Warehouse) table8 on (zssi_smartinvoiceprefs.M_Warehouse_ID = table8.M_Warehouse_ID) left join ad_ref_list_v list5 on (zssi_smartinvoiceprefs.DeliveryViaRule = list5.value and list5.ad_reference_id = '152' and list5.ad_language = ?)  left join ad_ref_list_v list6 on (zssi_smartinvoiceprefs.Freightcostrule = list6.value and list6.ad_reference_id = '153' and list6.ad_language = ?)  left join (select C_Incoterms_ID, Name from C_Incoterms) table9 on (zssi_smartinvoiceprefs.C_Incoterms_ID = table9.C_Incoterms_ID) left join (select C_UOM_ID, Name from C_UOM) table10 on (zssi_smartinvoiceprefs.Weight_Uom =  table10.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL10 on (table10.C_UOM_ID = tableTRL10.C_UOM_ID and tableTRL10.AD_Language = ?)  left join (select M_Shipper_ID, Name from M_Shipper) table11 on (zssi_smartinvoiceprefs.M_Shipper_ID = table11.M_Shipper_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND zssi_smartinvoiceprefs.Zssi_Smartinvoiceprefs_ID = ? " +
      "        AND zssi_smartinvoiceprefs.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_smartinvoiceprefs.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
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
        Preferences3D18346ED9BD4F70B308F4878E7830D6Data objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data = new Preferences3D18346ED9BD4F70B308F4878E7830D6Data();
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.created = UtilSql.getValue(result, "created");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.updated = UtilSql.getValue(result, "updated");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.zssiSmartinvoiceprefsId = UtilSql.getValue(result, "zssi_smartinvoiceprefs_id");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.invoicetype = UtilSql.getValue(result, "invoicetype");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.invoicetyper = UtilSql.getValue(result, "invoicetyper");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.mPricelistIdr = UtilSql.getValue(result, "m_pricelist_idr");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.cPaymenttermIdr = UtilSql.getValue(result, "c_paymentterm_idr");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.paymentruler = UtilSql.getValue(result, "paymentruler");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.deliveryruler = UtilSql.getValue(result, "deliveryruler");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.invoiceruler = UtilSql.getValue(result, "invoiceruler");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.deliveryviaruler = UtilSql.getValue(result, "deliveryviaruler");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.freightcostrule = UtilSql.getValue(result, "freightcostrule");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.freightcostruler = UtilSql.getValue(result, "freightcostruler");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.cIncotermsId = UtilSql.getValue(result, "c_incoterms_id");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.cIncotermsIdr = UtilSql.getValue(result, "c_incoterms_idr");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.weightUom = UtilSql.getValue(result, "weight_uom");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.weightUomr = UtilSql.getValue(result, "weight_uomr");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.mShipperIdr = UtilSql.getValue(result, "m_shipper_idr");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.isautoclosing = UtilSql.getValue(result, "isautoclosing");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.isdefault = UtilSql.getValue(result, "isdefault");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.usecustomersdefaults = UtilSql.getValue(result, "usecustomersdefaults");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.isactive = UtilSql.getValue(result, "isactive");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.language = UtilSql.getValue(result, "language");
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.adUserClient = "";
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.adOrgClient = "";
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.createdby = "";
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.trBgcolor = "";
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.totalCount = "";
        objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data);
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
    Preferences3D18346ED9BD4F70B308F4878E7830D6Data objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[] = new Preferences3D18346ED9BD4F70B308F4878E7830D6Data[vector.size()];
    vector.copyInto(objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data);
    return(objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data);
  }

/**
Create a registry
 */
  public static Preferences3D18346ED9BD4F70B308F4878E7830D6Data[] set(String paymentrule, String adOrgId, String deliveryrule, String cDoctypeId, String mWarehouseId, String mPricelistId, String mShipperId, String cIncotermsId, String invoicetype, String cPaymenttermId, String createdby, String createdbyr, String updatedby, String updatedbyr, String zssiSmartinvoiceprefsId, String invoicerule, String deliveryviarule, String freightcostrule, String cBpartnerLocationId, String isautoclosing, String isdefault, String weightUom, String usecustomersdefaults, String isactive, String cBpartnerId, String cBpartnerIdr, String adClientId)    throws ServletException {
    Preferences3D18346ED9BD4F70B308F4878E7830D6Data objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[] = new Preferences3D18346ED9BD4F70B308F4878E7830D6Data[1];
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0] = new Preferences3D18346ED9BD4F70B308F4878E7830D6Data();
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].created = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].createdbyr = createdbyr;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].updated = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].updatedTimeStamp = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].updatedby = updatedby;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].updatedbyr = updatedbyr;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].zssiSmartinvoiceprefsId = zssiSmartinvoiceprefsId;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].adClientId = adClientId;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].adClientIdr = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].adOrgId = adOrgId;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].adOrgIdr = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].invoicetype = invoicetype;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].invoicetyper = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].cBpartnerId = cBpartnerId;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].cBpartnerIdr = cBpartnerIdr;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].cBpartnerLocationId = cBpartnerLocationId;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].cBpartnerLocationIdr = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].cDoctypeId = cDoctypeId;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].cDoctypeIdr = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].mPricelistId = mPricelistId;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].mPricelistIdr = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].cPaymenttermId = cPaymenttermId;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].cPaymenttermIdr = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].paymentrule = paymentrule;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].paymentruler = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].deliveryrule = deliveryrule;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].deliveryruler = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].invoicerule = invoicerule;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].invoiceruler = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].mWarehouseId = mWarehouseId;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].mWarehouseIdr = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].deliveryviarule = deliveryviarule;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].deliveryviaruler = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].freightcostrule = freightcostrule;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].freightcostruler = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].cIncotermsId = cIncotermsId;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].cIncotermsIdr = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].weightUom = weightUom;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].weightUomr = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].mShipperId = mShipperId;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].mShipperIdr = "";
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].isautoclosing = isautoclosing;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].isdefault = isdefault;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].usecustomersdefaults = usecustomersdefaults;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].isactive = isactive;
    objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data[0].language = "";
    return objectPreferences3D18346ED9BD4F70B308F4878E7830D6Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef098C82C1E9EC4FA28E26CC27BECC914C_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefF8FC7E605916482D9BB182C702B852F3_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef0A747D2612984FB899B20B4AD1E145EC_2(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as C_Bpartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Bpartner_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_bpartner_id");
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
      "        UPDATE zssi_smartinvoiceprefs" +
      "        SET Zssi_Smartinvoiceprefs_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Invoicetype = (?) , C_Bpartner_ID = (?) , C_Bpartner_Location_ID = (?) , C_Doctype_ID = (?) , M_Pricelist_ID = (?) , C_Paymentterm_ID = (?) , Paymentrule = (?) , Deliveryrule = (?) , Invoicerule = (?) , M_Warehouse_ID = (?) , DeliveryViaRule = (?) , Freightcostrule = (?) , C_Incoterms_ID = (?) , Weight_Uom = (?) , M_Shipper_ID = (?) , Isautoclosing = (?) , Isdefault = (?) , Usecustomersdefaults = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_smartinvoiceprefs.Zssi_Smartinvoiceprefs_ID = ? " +
      "        AND zssi_smartinvoiceprefs.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_smartinvoiceprefs.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiSmartinvoiceprefsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cIncotermsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weightUom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isautoclosing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usecustomersdefaults);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiSmartinvoiceprefsId);
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
      "        INSERT INTO zssi_smartinvoiceprefs " +
      "        (Zssi_Smartinvoiceprefs_ID, AD_Client_ID, AD_Org_ID, Invoicetype, C_Bpartner_ID, C_Bpartner_Location_ID, C_Doctype_ID, M_Pricelist_ID, C_Paymentterm_ID, Paymentrule, Deliveryrule, Invoicerule, M_Warehouse_ID, DeliveryViaRule, Freightcostrule, C_Incoterms_ID, Weight_Uom, M_Shipper_ID, Isautoclosing, Isdefault, Usecustomersdefaults, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiSmartinvoiceprefsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cIncotermsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weightUom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isautoclosing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usecustomersdefaults);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
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
      "        DELETE FROM zssi_smartinvoiceprefs" +
      "        WHERE zssi_smartinvoiceprefs.Zssi_Smartinvoiceprefs_ID = ? " +
      "        AND zssi_smartinvoiceprefs.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_smartinvoiceprefs.AD_Org_ID IN (";
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
      "        DELETE FROM zssi_smartinvoiceprefs" +
      "        WHERE zssi_smartinvoiceprefs.Zssi_Smartinvoiceprefs_ID = ? ";

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
      "          FROM zssi_smartinvoiceprefs" +
      "         WHERE zssi_smartinvoiceprefs.Zssi_Smartinvoiceprefs_ID = ? ";

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
      "          FROM zssi_smartinvoiceprefs" +
      "         WHERE zssi_smartinvoiceprefs.Zssi_Smartinvoiceprefs_ID = ? ";

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
