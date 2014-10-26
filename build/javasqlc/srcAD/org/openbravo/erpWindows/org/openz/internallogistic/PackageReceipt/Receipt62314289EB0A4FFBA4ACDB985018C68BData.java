//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openz.internallogistic.PackageReceipt;

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
class Receipt62314289EB0A4FFBA4ACDB985018C68BData implements FieldProvider {
static Logger log4j = Logger.getLogger(Receipt62314289EB0A4FFBA4ACDB985018C68BData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String ilsInoutpackageVId;
  public String documentno;
  public String docstatus;
  public String docstatusr;
  public String adClientId;
  public String serialnumber;
  public String adOrgId;
  public String employee;
  public String isactive;
  public String adUserId;
  public String adUserIdr;
  public String movementdate;
  public String mShipperId;
  public String mShipperIdr;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String issotrx;
  public String mLocatorId;
  public String mLocatorIdr;
  public String mProductId;
  public String mProductIdr;
  public String cUomId;
  public String cUomIdr;
  public String movementqty;
  public String cOrderId;
  public String partner;
  public String partnerr;
  public String description;
  public String shipmentcontent;
  public String sigmano;
  public String directmail;
  public String processing;
  public String snremployee;
  public String movementtype;
  public String movementtyper;
  public String processed;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String docaction;
  public String docactionBtn;
  public String processbutton;
  public String islogistic;
  public String cProjectId;
  public String aAssetId;
  public String cProjecttaskId;
  public String cOrderlineId;
  public String isinvoiced;
  public String mInoutId;
  public String mInoutlineId;
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
    else if (fieldName.equalsIgnoreCase("ils_inoutpackage_v_id") || fieldName.equals("ilsInoutpackageVId"))
      return ilsInoutpackageVId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("serialnumber"))
      return serialnumber;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("employee"))
      return employee;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("m_shipper_idr") || fieldName.equals("mShipperIdr"))
      return mShipperIdr;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_locator_idr") || fieldName.equals("mLocatorIdr"))
      return mLocatorIdr;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("partner"))
      return partner;
    else if (fieldName.equalsIgnoreCase("partnerr"))
      return partnerr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("shipmentcontent"))
      return shipmentcontent;
    else if (fieldName.equalsIgnoreCase("sigmano"))
      return sigmano;
    else if (fieldName.equalsIgnoreCase("directmail"))
      return directmail;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("snremployee"))
      return snremployee;
    else if (fieldName.equalsIgnoreCase("movementtype"))
      return movementtype;
    else if (fieldName.equalsIgnoreCase("movementtyper"))
      return movementtyper;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("docaction_btn") || fieldName.equals("docactionBtn"))
      return docactionBtn;
    else if (fieldName.equalsIgnoreCase("processbutton"))
      return processbutton;
    else if (fieldName.equalsIgnoreCase("islogistic"))
      return islogistic;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("isinvoiced"))
      return isinvoiced;
    else if (fieldName.equalsIgnoreCase("m_inout_id") || fieldName.equals("mInoutId"))
      return mInoutId;
    else if (fieldName.equalsIgnoreCase("m_inoutline_id") || fieldName.equals("mInoutlineId"))
      return mInoutlineId;
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
  public static Receipt62314289EB0A4FFBA4ACDB985018C68BData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Receipt62314289EB0A4FFBA4ACDB985018C68BData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ils_inoutpackage_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ils_inoutpackage_v.CreatedBy) as CreatedByR, " +
      "        to_char(ils_inoutpackage_v.Updated, ?) as updated, " +
      "        to_char(ils_inoutpackage_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ils_inoutpackage_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ils_inoutpackage_v.UpdatedBy) as UpdatedByR," +
      "        ils_inoutpackage_v.ILS_Inoutpackage_V_ID, " +
      "ils_inoutpackage_v.DocumentNo, " +
      "ils_inoutpackage_v.Docstatus, " +
      "(CASE WHEN ils_inoutpackage_v.Docstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DocstatusR, " +
      "ils_inoutpackage_v.AD_Client_ID, " +
      "ils_inoutpackage_v.Serialnumber, " +
      "ils_inoutpackage_v.AD_Org_ID, " +
      "ils_inoutpackage_v.Employee, " +
      "COALESCE(ils_inoutpackage_v.Isactive, 'N') AS Isactive, " +
      "ils_inoutpackage_v.AD_User_ID, " +
      "(CASE WHEN ils_inoutpackage_v.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "ils_inoutpackage_v.Movementdate, " +
      "ils_inoutpackage_v.M_Shipper_ID, " +
      "(CASE WHEN ils_inoutpackage_v.M_Shipper_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS M_Shipper_IDR, " +
      "ils_inoutpackage_v.M_Warehouse_ID, " +
      "(CASE WHEN ils_inoutpackage_v.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "COALESCE(ils_inoutpackage_v.Issotrx, 'N') AS Issotrx, " +
      "ils_inoutpackage_v.M_Locator_ID, " +
      "(CASE WHEN ils_inoutpackage_v.M_Locator_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'') ) END) AS M_Locator_IDR, " +
      "ils_inoutpackage_v.M_Product_ID, " +
      "(CASE WHEN ils_inoutpackage_v.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "ils_inoutpackage_v.C_Uom_ID, " +
      "(CASE WHEN ils_inoutpackage_v.C_Uom_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'') ) END) AS C_Uom_IDR, " +
      "ils_inoutpackage_v.Movementqty, " +
      "ils_inoutpackage_v.C_Order_ID, " +
      "ils_inoutpackage_v.partner, " +
      "(CASE WHEN ils_inoutpackage_v.partner IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS partnerR, " +
      "ils_inoutpackage_v.Description, " +
      "ils_inoutpackage_v.Shipmentcontent, " +
      "ils_inoutpackage_v.Sigmano, " +
      "COALESCE(ils_inoutpackage_v.Directmail, 'N') AS Directmail, " +
      "COALESCE(ils_inoutpackage_v.Processing, 'N') AS Processing, " +
      "ils_inoutpackage_v.Snremployee, " +
      "ils_inoutpackage_v.Movementtype, " +
      "(CASE WHEN ils_inoutpackage_v.Movementtype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS MovementtypeR, " +
      "COALESCE(ils_inoutpackage_v.Processed, 'N') AS Processed, " +
      "ils_inoutpackage_v.C_Doctype_ID, " +
      "(CASE WHEN ils_inoutpackage_v.C_Doctype_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL8.Name IS NULL THEN TO_CHAR(table8.Name) ELSE TO_CHAR(tableTRL8.Name) END)), ''))),'') ) END) AS C_Doctype_IDR, " +
      "ils_inoutpackage_v.DocAction, " +
      "list3.name as DocAction_BTN, " +
      "ils_inoutpackage_v.Processbutton, " +
      "COALESCE(ils_inoutpackage_v.Islogistic, 'N') AS Islogistic, " +
      "ils_inoutpackage_v.C_Project_ID, " +
      "ils_inoutpackage_v.A_Asset_ID, " +
      "ils_inoutpackage_v.C_Projecttask_ID, " +
      "ils_inoutpackage_v.C_Orderline_ID, " +
      "COALESCE(ils_inoutpackage_v.Isinvoiced, 'N') AS Isinvoiced, " +
      "ils_inoutpackage_v.M_Inout_ID, " +
      "ils_inoutpackage_v.M_Inoutline_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM ils_inoutpackage_v left join ad_ref_list_v list1 on (ils_inoutpackage_v.Docstatus = list1.value and list1.ad_reference_id = '131' and list1.ad_language = ?)  left join (select AD_User_ID, Name from AD_User) table1 on (ils_inoutpackage_v.AD_User_ID = table1.AD_User_ID) left join (select M_Shipper_ID, Name from M_Shipper) table2 on (ils_inoutpackage_v.M_Shipper_ID = table2.M_Shipper_ID) left join (select M_Warehouse_ID, Name from M_Warehouse) table3 on (ils_inoutpackage_v.M_Warehouse_ID = table3.M_Warehouse_ID) left join (select M_Locator_ID, Value from M_Locator) table4 on (ils_inoutpackage_v.M_Locator_ID =  table4.M_Locator_ID) left join (select M_Product_ID, Value, Name from M_Product) table5 on (ils_inoutpackage_v.M_Product_ID = table5.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL5 on (table5.M_Product_ID = tableTRL5.M_Product_ID and tableTRL5.AD_Language = ?)  left join (select C_Uom_ID, Name from C_Uom) table6 on (ils_inoutpackage_v.C_Uom_ID = table6.C_Uom_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL6 on (table6.C_UOM_ID = tableTRL6.C_UOM_ID and tableTRL6.AD_Language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table7 on (ils_inoutpackage_v.partner = table7.C_BPartner_ID) left join ad_ref_list_v list2 on (ils_inoutpackage_v.Movementtype = list2.value and list2.ad_reference_id = '189' and list2.ad_language = ?)  left join (select C_DocType_ID, Name from C_DocType) table8 on (ils_inoutpackage_v.C_Doctype_ID =  table8.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL8 on (table8.C_DocType_ID = tableTRL8.C_DocType_ID and tableTRL8.AD_Language = ?)  left join ad_ref_list_v list3 on (list3.ad_reference_id = '135' and list3.ad_language = ?  AND (CASE ils_inoutpackage_v.DocAction WHEN '--' THEN 'CL' ELSE TO_CHAR(ils_inoutpackage_v.DocAction) END) = list3.value)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND ils_inoutpackage_v.ILS_Inoutpackage_V_ID = ? " +
      "        AND ils_inoutpackage_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ils_inoutpackage_v.AD_Org_ID IN (";
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
        Receipt62314289EB0A4FFBA4ACDB985018C68BData objectReceipt62314289EB0A4FFBA4ACDB985018C68BData = new Receipt62314289EB0A4FFBA4ACDB985018C68BData();
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.created = UtilSql.getValue(result, "created");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.updated = UtilSql.getValue(result, "updated");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.updatedby = UtilSql.getValue(result, "updatedby");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.ilsInoutpackageVId = UtilSql.getValue(result, "ils_inoutpackage_v_id");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.documentno = UtilSql.getValue(result, "documentno");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.docstatus = UtilSql.getValue(result, "docstatus");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.serialnumber = UtilSql.getValue(result, "serialnumber");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.employee = UtilSql.getValue(result, "employee");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.isactive = UtilSql.getValue(result, "isactive");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.mShipperIdr = UtilSql.getValue(result, "m_shipper_idr");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.issotrx = UtilSql.getValue(result, "issotrx");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.mLocatorIdr = UtilSql.getValue(result, "m_locator_idr");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.movementqty = UtilSql.getValue(result, "movementqty");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.partner = UtilSql.getValue(result, "partner");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.partnerr = UtilSql.getValue(result, "partnerr");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.description = UtilSql.getValue(result, "description");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.shipmentcontent = UtilSql.getValue(result, "shipmentcontent");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.sigmano = UtilSql.getValue(result, "sigmano");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.directmail = UtilSql.getValue(result, "directmail");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.processing = UtilSql.getValue(result, "processing");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.snremployee = UtilSql.getValue(result, "snremployee");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.movementtype = UtilSql.getValue(result, "movementtype");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.movementtyper = UtilSql.getValue(result, "movementtyper");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.processed = UtilSql.getValue(result, "processed");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.docaction = UtilSql.getValue(result, "docaction");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.docactionBtn = UtilSql.getValue(result, "docaction_btn");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.processbutton = UtilSql.getValue(result, "processbutton");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.islogistic = UtilSql.getValue(result, "islogistic");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.isinvoiced = UtilSql.getValue(result, "isinvoiced");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.mInoutId = UtilSql.getValue(result, "m_inout_id");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.language = UtilSql.getValue(result, "language");
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.adUserClient = "";
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.adOrgClient = "";
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.createdby = "";
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.trBgcolor = "";
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.totalCount = "";
        objectReceipt62314289EB0A4FFBA4ACDB985018C68BData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReceipt62314289EB0A4FFBA4ACDB985018C68BData);
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
    Receipt62314289EB0A4FFBA4ACDB985018C68BData objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[] = new Receipt62314289EB0A4FFBA4ACDB985018C68BData[vector.size()];
    vector.copyInto(objectReceipt62314289EB0A4FFBA4ACDB985018C68BData);
    return(objectReceipt62314289EB0A4FFBA4ACDB985018C68BData);
  }

/**
Create a registry
 */
  public static Receipt62314289EB0A4FFBA4ACDB985018C68BData[] set(String movementqty, String shipmentcontent, String cOrderId, String updatedby, String updatedbyr, String adClientId, String cUomId, String issotrx, String mProductId, String mProductIdr, String processed, String adOrgId, String mInoutlineId, String docstatus, String cDoctypeId, String processing, String cProjectId, String aAssetId, String employee, String description, String cOrderlineId, String directmail, String documentno, String serialnumber, String isactive, String ilsInoutpackageVId, String docaction, String docactionBtn, String snremployee, String movementtype, String cProjecttaskId, String mInoutId, String mLocatorId, String mShipperId, String sigmano, String isinvoiced, String partner, String partnerr, String islogistic, String createdby, String createdbyr, String processbutton, String mWarehouseId, String adUserId, String movementdate)    throws ServletException {
    Receipt62314289EB0A4FFBA4ACDB985018C68BData objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[] = new Receipt62314289EB0A4FFBA4ACDB985018C68BData[1];
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0] = new Receipt62314289EB0A4FFBA4ACDB985018C68BData();
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].created = "";
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].createdbyr = createdbyr;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].updated = "";
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].updatedTimeStamp = "";
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].updatedby = updatedby;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].updatedbyr = updatedbyr;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].ilsInoutpackageVId = ilsInoutpackageVId;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].documentno = documentno;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].docstatus = docstatus;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].docstatusr = "";
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].adClientId = adClientId;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].serialnumber = serialnumber;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].adOrgId = adOrgId;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].employee = employee;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].isactive = isactive;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].adUserId = adUserId;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].adUserIdr = "";
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].movementdate = movementdate;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].mShipperId = mShipperId;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].mShipperIdr = "";
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].mWarehouseId = mWarehouseId;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].mWarehouseIdr = "";
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].issotrx = issotrx;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].mLocatorId = mLocatorId;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].mLocatorIdr = "";
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].mProductId = mProductId;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].mProductIdr = mProductIdr;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].cUomId = cUomId;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].cUomIdr = "";
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].movementqty = movementqty;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].cOrderId = cOrderId;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].partner = partner;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].partnerr = partnerr;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].description = description;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].shipmentcontent = shipmentcontent;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].sigmano = sigmano;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].directmail = directmail;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].processing = processing;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].snremployee = snremployee;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].movementtype = movementtype;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].movementtyper = "";
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].processed = processed;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].cDoctypeId = cDoctypeId;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].cDoctypeIdr = "";
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].docaction = docaction;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].docactionBtn = docactionBtn;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].processbutton = processbutton;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].islogistic = islogistic;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].cProjectId = cProjectId;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].aAssetId = aAssetId;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].cProjecttaskId = cProjecttaskId;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].cOrderlineId = cOrderlineId;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].isinvoiced = isinvoiced;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].mInoutId = mInoutId;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].mInoutlineId = mInoutlineId;
    objectReceipt62314289EB0A4FFBA4ACDB985018C68BData[0].language = "";
    return objectReceipt62314289EB0A4FFBA4ACDB985018C68BData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefB092402FC9B54A73ADF4BD714F92B307_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef15CF5E12B6FF45FEB42C56322F623397(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT value AS DefaultValue FROM AD_PREFERENCE WHERE ATTRIBUTE='DEFAULTINTERNALLOGISTICPRODUCT' ";

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

/**
Select for auxiliar field
 */
  public static String selectDef15CF5E12B6FF45FEB42C56322F623397_1(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDefFB1B36D4EAAE4DE798EC6CA54884BC40_2(ConnectionProvider connectionProvider, String partnerR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as partner FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, partnerR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "partner");
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
  public static String selectDef5DFFED3DEDBC4351906A9EA15F262461_3(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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

  public static int updateDocAction(ConnectionProvider connectionProvider, String docaction, String ilsInoutpackageVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE ils_inoutpackage_v" +
      "        SET docaction = ? " +
      "        WHERE ils_inoutpackage_v.ILS_Inoutpackage_V_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutpackageVId);

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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE ils_inoutpackage_v" +
      "        SET ILS_Inoutpackage_V_ID = (?) , DocumentNo = (?) , Docstatus = (?) , AD_Client_ID = (?) , Serialnumber = (?) , AD_Org_ID = (?) , Employee = (?) , Isactive = (?) , AD_User_ID = (?) , Movementdate = TO_DATE(?) , M_Shipper_ID = (?) , M_Warehouse_ID = (?) , Issotrx = (?) , M_Locator_ID = (?) , M_Product_ID = (?) , C_Uom_ID = (?) , Movementqty = TO_NUMBER(?) , C_Order_ID = (?) , partner = (?) , Description = (?) , Shipmentcontent = (?) , Sigmano = (?) , Directmail = (?) , Processing = (?) , Snremployee = (?) , Movementtype = (?) , Processed = (?) , C_Doctype_ID = (?) , DocAction = (?) , Processbutton = (?) , Islogistic = (?) , C_Project_ID = (?) , A_Asset_ID = (?) , C_Projecttask_ID = (?) , C_Orderline_ID = (?) , Isinvoiced = (?) , M_Inout_ID = (?) , M_Inoutline_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE ils_inoutpackage_v.ILS_Inoutpackage_V_ID = ? " +
      "        AND ils_inoutpackage_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ils_inoutpackage_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutpackageVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, employee);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, partner);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipmentcontent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sigmano);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, directmail);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snremployee);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processbutton);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islogistic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutpackageVId);
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
      "        INSERT INTO ils_inoutpackage_v " +
      "        (ILS_Inoutpackage_V_ID, DocumentNo, Docstatus, AD_Client_ID, Serialnumber, AD_Org_ID, Employee, Isactive, AD_User_ID, Movementdate, M_Shipper_ID, M_Warehouse_ID, Issotrx, M_Locator_ID, M_Product_ID, C_Uom_ID, Movementqty, C_Order_ID, partner, Description, Shipmentcontent, Sigmano, Directmail, Processing, Snremployee, Movementtype, Processed, C_Doctype_ID, DocAction, Processbutton, Islogistic, C_Project_ID, A_Asset_ID, C_Projecttask_ID, C_Orderline_ID, Isinvoiced, M_Inout_ID, M_Inoutline_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutpackageVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, employee);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, partner);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipmentcontent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sigmano);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, directmail);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snremployee);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processbutton);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islogistic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
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
      "        DELETE FROM ils_inoutpackage_v" +
      "        WHERE ils_inoutpackage_v.ILS_Inoutpackage_V_ID = ? " +
      "        AND ils_inoutpackage_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ils_inoutpackage_v.AD_Org_ID IN (";
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
      "        DELETE FROM ils_inoutpackage_v" +
      "        WHERE ils_inoutpackage_v.ILS_Inoutpackage_V_ID = ? ";

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
      "          FROM ils_inoutpackage_v" +
      "         WHERE ils_inoutpackage_v.ILS_Inoutpackage_V_ID = ? ";

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
      "          FROM ils_inoutpackage_v" +
      "         WHERE ils_inoutpackage_v.ILS_Inoutpackage_V_ID = ? ";

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
