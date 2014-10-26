//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.FrameContractOverviewPO;

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
class FrameContractsOverviewPOData implements FieldProvider {
static Logger log4j = Logger.getLogger(FrameContractsOverviewPOData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String cFramecontractoverviewId;
  public String cOrderId;
  public String cOrderIdr;
  public String adClientId;
  public String cOrderlineId;
  public String cOrderlineIdr;
  public String docstatus;
  public String docstatusr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String isactive;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String mProductId;
  public String mProductIdr;
  public String cUomId;
  public String cUomIdr;
  public String qtyordered;
  public String securityqty;
  public String calloffqty;
  public String qtyleft;
  public String priceactual;
  public String linenetamt;
  public String aAssetId;
  public String aAssetIdr;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String contractdate;
  public String enddate;
  public String deliverycomplete;
  public String documentno;
  public String line;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String issotrx;
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
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_framecontractoverview_id") || fieldName.equals("cFramecontractoverviewId"))
      return cFramecontractoverviewId;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_order_idr") || fieldName.equals("cOrderIdr"))
      return cOrderIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("c_orderline_idr") || fieldName.equals("cOrderlineIdr"))
      return cOrderlineIdr;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("securityqty"))
      return securityqty;
    else if (fieldName.equalsIgnoreCase("calloffqty"))
      return calloffqty;
    else if (fieldName.equalsIgnoreCase("qtyleft"))
      return qtyleft;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_idr") || fieldName.equals("aAssetIdr"))
      return aAssetIdr;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("contractdate"))
      return contractdate;
    else if (fieldName.equalsIgnoreCase("enddate"))
      return enddate;
    else if (fieldName.equalsIgnoreCase("deliverycomplete"))
      return deliverycomplete;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
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
  public static FrameContractsOverviewPOData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static FrameContractsOverviewPOData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_framecontractoverview.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_framecontractoverview.CreatedBy) as CreatedByR, " +
      "        to_char(c_framecontractoverview.Updated, ?) as updated, " +
      "        to_char(c_framecontractoverview.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_framecontractoverview.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_framecontractoverview.UpdatedBy) as UpdatedByR," +
      "        c_framecontractoverview.AD_Org_ID, " +
      "(CASE WHEN c_framecontractoverview.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "c_framecontractoverview.C_Framecontractoverview_ID, " +
      "c_framecontractoverview.C_Order_ID, " +
      "(CASE WHEN c_framecontractoverview.C_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table2.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.GrandTotal), ''))),'') ) END) AS C_Order_IDR, " +
      "c_framecontractoverview.AD_Client_ID, " +
      "c_framecontractoverview.C_Orderline_ID, " +
      "(CASE WHEN c_framecontractoverview.C_Orderline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table4.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.GrandTotal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.LineNetAmt), ''))),'') ) END) AS C_Orderline_IDR, " +
      "c_framecontractoverview.Docstatus, " +
      "(CASE WHEN c_framecontractoverview.Docstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DocstatusR, " +
      "c_framecontractoverview.C_Bpartner_ID, " +
      "(CASE WHEN c_framecontractoverview.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "COALESCE(c_framecontractoverview.Isactive, 'N') AS Isactive, " +
      "c_framecontractoverview.C_Bpartner_Location_ID, " +
      "(CASE WHEN c_framecontractoverview.C_Bpartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Address1), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Address2), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Postal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.City), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL8.Name IS NULL THEN TO_CHAR(table8.Name) ELSE TO_CHAR(tableTRL8.Name) END)), ''))),'') ) END) AS C_Bpartner_Location_IDR, " +
      "c_framecontractoverview.M_Product_ID, " +
      "(CASE WHEN c_framecontractoverview.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL9.Name IS NULL THEN TO_CHAR(table9.Name) ELSE TO_CHAR(tableTRL9.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "c_framecontractoverview.C_Uom_ID, " +
      "(CASE WHEN c_framecontractoverview.C_Uom_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL10.Name IS NULL THEN TO_CHAR(table10.Name) ELSE TO_CHAR(tableTRL10.Name) END)), ''))),'') ) END) AS C_Uom_IDR, " +
      "c_framecontractoverview.Qtyordered, " +
      "c_framecontractoverview.Securityqty, " +
      "c_framecontractoverview.Calloffqty, " +
      "c_framecontractoverview.Qtyleft, " +
      "c_framecontractoverview.Priceactual, " +
      "c_framecontractoverview.Linenetamt, " +
      "c_framecontractoverview.A_Asset_ID, " +
      "(CASE WHEN c_framecontractoverview.A_Asset_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "c_framecontractoverview.C_Project_ID, " +
      "(CASE WHEN c_framecontractoverview.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "c_framecontractoverview.C_Projecttask_ID, " +
      "(CASE WHEN c_framecontractoverview.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "c_framecontractoverview.Contractdate, " +
      "c_framecontractoverview.Enddate, " +
      "COALESCE(c_framecontractoverview.Deliverycomplete, 'N') AS Deliverycomplete, " +
      "c_framecontractoverview.Documentno, " +
      "c_framecontractoverview.Line, " +
      "c_framecontractoverview.M_Warehouse_ID, " +
      "(CASE WHEN c_framecontractoverview.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "COALESCE(c_framecontractoverview.Issotrx, 'N') AS Issotrx, " +
      "        ? AS LANGUAGE " +
      "        FROM c_framecontractoverview left join (select AD_Org_ID, Name from AD_Org) table1 on (c_framecontractoverview.AD_Org_ID = table1.AD_Org_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table2 on (c_framecontractoverview.C_Order_ID = table2.C_Order_ID) left join (select C_Orderline_ID, C_Order_ID, Line, LineNetAmt from C_Orderline) table3 on (c_framecontractoverview.C_Orderline_ID = table3.C_Orderline_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table4 on (table3.C_Order_ID = table4.C_Order_ID) left join ad_ref_list_v list1 on (c_framecontractoverview.Docstatus = list1.value and list1.ad_reference_id = '131' and list1.ad_language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table5 on (c_framecontractoverview.C_Bpartner_ID = table5.C_BPartner_ID) left join (select C_Location_ID, Address1, Address2, Postal, City, C_Region_ID, C_Country_ID from C_Location) table6 on (c_framecontractoverview.C_Bpartner_Location_ID = table6.C_Location_ID) left join (select C_Region_ID, Name from C_Region) table7 on (table6.C_Region_ID = table7.C_Region_ID) left join (select C_Country_ID, Name from C_Country) table8 on (table6.C_Country_ID = table8.C_Country_ID) left join (select C_Country_ID,AD_Language, Name from C_Country_TRL) tableTRL8 on (table8.C_Country_ID = tableTRL8.C_Country_ID and tableTRL8.AD_Language = ?)  left join (select M_Product_ID, Value, Name from M_Product) table9 on (c_framecontractoverview.M_Product_ID = table9.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL9 on (table9.M_Product_ID = tableTRL9.M_Product_ID and tableTRL9.AD_Language = ?)  left join (select C_Uom_ID, Name from C_Uom) table10 on (c_framecontractoverview.C_Uom_ID = table10.C_Uom_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL10 on (table10.C_UOM_ID = tableTRL10.C_UOM_ID and tableTRL10.AD_Language = ?)  left join (select A_Asset_ID, Name from A_Asset) table11 on (c_framecontractoverview.A_Asset_ID = table11.A_Asset_ID) left join (select C_Project_ID, Value, Name from C_Project) table12 on (c_framecontractoverview.C_Project_ID = table12.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table13 on (c_framecontractoverview.C_Projecttask_ID = table13.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table14 on (table13.C_Project_ID = table14.C_Project_ID) left join (select M_Warehouse_ID, Name from M_Warehouse) table15 on (c_framecontractoverview.M_Warehouse_ID = table15.M_Warehouse_ID)" +
      "        WHERE 2=2 " +
      " AND c_framecontractoverview.issotrx='N'" +
      "        AND 1=1 " +
      "        AND c_framecontractoverview.C_Framecontractoverview_ID = ? " +
      "        AND c_framecontractoverview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_framecontractoverview.AD_Org_ID IN (";
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
        FrameContractsOverviewPOData objectFrameContractsOverviewPOData = new FrameContractsOverviewPOData();
        objectFrameContractsOverviewPOData.created = UtilSql.getValue(result, "created");
        objectFrameContractsOverviewPOData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectFrameContractsOverviewPOData.updated = UtilSql.getValue(result, "updated");
        objectFrameContractsOverviewPOData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectFrameContractsOverviewPOData.updatedby = UtilSql.getValue(result, "updatedby");
        objectFrameContractsOverviewPOData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectFrameContractsOverviewPOData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectFrameContractsOverviewPOData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectFrameContractsOverviewPOData.cFramecontractoverviewId = UtilSql.getValue(result, "c_framecontractoverview_id");
        objectFrameContractsOverviewPOData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectFrameContractsOverviewPOData.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectFrameContractsOverviewPOData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectFrameContractsOverviewPOData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectFrameContractsOverviewPOData.cOrderlineIdr = UtilSql.getValue(result, "c_orderline_idr");
        objectFrameContractsOverviewPOData.docstatus = UtilSql.getValue(result, "docstatus");
        objectFrameContractsOverviewPOData.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectFrameContractsOverviewPOData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectFrameContractsOverviewPOData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectFrameContractsOverviewPOData.isactive = UtilSql.getValue(result, "isactive");
        objectFrameContractsOverviewPOData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectFrameContractsOverviewPOData.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectFrameContractsOverviewPOData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectFrameContractsOverviewPOData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectFrameContractsOverviewPOData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectFrameContractsOverviewPOData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectFrameContractsOverviewPOData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectFrameContractsOverviewPOData.securityqty = UtilSql.getValue(result, "securityqty");
        objectFrameContractsOverviewPOData.calloffqty = UtilSql.getValue(result, "calloffqty");
        objectFrameContractsOverviewPOData.qtyleft = UtilSql.getValue(result, "qtyleft");
        objectFrameContractsOverviewPOData.priceactual = UtilSql.getValue(result, "priceactual");
        objectFrameContractsOverviewPOData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectFrameContractsOverviewPOData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectFrameContractsOverviewPOData.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectFrameContractsOverviewPOData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectFrameContractsOverviewPOData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectFrameContractsOverviewPOData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectFrameContractsOverviewPOData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectFrameContractsOverviewPOData.contractdate = UtilSql.getDateValue(result, "contractdate", "dd-MM-yyyy");
        objectFrameContractsOverviewPOData.enddate = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
        objectFrameContractsOverviewPOData.deliverycomplete = UtilSql.getValue(result, "deliverycomplete");
        objectFrameContractsOverviewPOData.documentno = UtilSql.getValue(result, "documentno");
        objectFrameContractsOverviewPOData.line = UtilSql.getValue(result, "line");
        objectFrameContractsOverviewPOData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectFrameContractsOverviewPOData.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectFrameContractsOverviewPOData.issotrx = UtilSql.getValue(result, "issotrx");
        objectFrameContractsOverviewPOData.language = UtilSql.getValue(result, "language");
        objectFrameContractsOverviewPOData.adUserClient = "";
        objectFrameContractsOverviewPOData.adOrgClient = "";
        objectFrameContractsOverviewPOData.createdby = "";
        objectFrameContractsOverviewPOData.trBgcolor = "";
        objectFrameContractsOverviewPOData.totalCount = "";
        objectFrameContractsOverviewPOData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFrameContractsOverviewPOData);
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
    FrameContractsOverviewPOData objectFrameContractsOverviewPOData[] = new FrameContractsOverviewPOData[vector.size()];
    vector.copyInto(objectFrameContractsOverviewPOData);
    return(objectFrameContractsOverviewPOData);
  }

/**
Create a registry
 */
  public static FrameContractsOverviewPOData[] set(String docstatus, String adClientId, String cOrderlineId, String cOrderId, String calloffqty, String issotrx, String aAssetId, String cUomId, String mProductId, String mProductIdr, String adOrgId, String cBpartnerLocationId, String cBpartnerLocationIdr, String updatedby, String updatedbyr, String mWarehouseId, String cBpartnerId, String cBpartnerIdr, String line, String cFramecontractoverviewId, String qtyordered, String contractdate, String securityqty, String priceactual, String linenetamt, String documentno, String cProjecttaskId, String deliverycomplete, String qtyleft, String createdby, String createdbyr, String enddate, String cProjectId, String isactive)    throws ServletException {
    FrameContractsOverviewPOData objectFrameContractsOverviewPOData[] = new FrameContractsOverviewPOData[1];
    objectFrameContractsOverviewPOData[0] = new FrameContractsOverviewPOData();
    objectFrameContractsOverviewPOData[0].created = "";
    objectFrameContractsOverviewPOData[0].createdbyr = createdbyr;
    objectFrameContractsOverviewPOData[0].updated = "";
    objectFrameContractsOverviewPOData[0].updatedTimeStamp = "";
    objectFrameContractsOverviewPOData[0].updatedby = updatedby;
    objectFrameContractsOverviewPOData[0].updatedbyr = updatedbyr;
    objectFrameContractsOverviewPOData[0].adOrgId = adOrgId;
    objectFrameContractsOverviewPOData[0].adOrgIdr = "";
    objectFrameContractsOverviewPOData[0].cFramecontractoverviewId = cFramecontractoverviewId;
    objectFrameContractsOverviewPOData[0].cOrderId = cOrderId;
    objectFrameContractsOverviewPOData[0].cOrderIdr = "";
    objectFrameContractsOverviewPOData[0].adClientId = adClientId;
    objectFrameContractsOverviewPOData[0].cOrderlineId = cOrderlineId;
    objectFrameContractsOverviewPOData[0].cOrderlineIdr = "";
    objectFrameContractsOverviewPOData[0].docstatus = docstatus;
    objectFrameContractsOverviewPOData[0].docstatusr = "";
    objectFrameContractsOverviewPOData[0].cBpartnerId = cBpartnerId;
    objectFrameContractsOverviewPOData[0].cBpartnerIdr = cBpartnerIdr;
    objectFrameContractsOverviewPOData[0].isactive = isactive;
    objectFrameContractsOverviewPOData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectFrameContractsOverviewPOData[0].cBpartnerLocationIdr = cBpartnerLocationIdr;
    objectFrameContractsOverviewPOData[0].mProductId = mProductId;
    objectFrameContractsOverviewPOData[0].mProductIdr = mProductIdr;
    objectFrameContractsOverviewPOData[0].cUomId = cUomId;
    objectFrameContractsOverviewPOData[0].cUomIdr = "";
    objectFrameContractsOverviewPOData[0].qtyordered = qtyordered;
    objectFrameContractsOverviewPOData[0].securityqty = securityqty;
    objectFrameContractsOverviewPOData[0].calloffqty = calloffqty;
    objectFrameContractsOverviewPOData[0].qtyleft = qtyleft;
    objectFrameContractsOverviewPOData[0].priceactual = priceactual;
    objectFrameContractsOverviewPOData[0].linenetamt = linenetamt;
    objectFrameContractsOverviewPOData[0].aAssetId = aAssetId;
    objectFrameContractsOverviewPOData[0].aAssetIdr = "";
    objectFrameContractsOverviewPOData[0].cProjectId = cProjectId;
    objectFrameContractsOverviewPOData[0].cProjectIdr = "";
    objectFrameContractsOverviewPOData[0].cProjecttaskId = cProjecttaskId;
    objectFrameContractsOverviewPOData[0].cProjecttaskIdr = "";
    objectFrameContractsOverviewPOData[0].contractdate = contractdate;
    objectFrameContractsOverviewPOData[0].enddate = enddate;
    objectFrameContractsOverviewPOData[0].deliverycomplete = deliverycomplete;
    objectFrameContractsOverviewPOData[0].documentno = documentno;
    objectFrameContractsOverviewPOData[0].line = line;
    objectFrameContractsOverviewPOData[0].mWarehouseId = mWarehouseId;
    objectFrameContractsOverviewPOData[0].mWarehouseIdr = "";
    objectFrameContractsOverviewPOData[0].issotrx = issotrx;
    objectFrameContractsOverviewPOData[0].language = "";
    return objectFrameContractsOverviewPOData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1455A04D8C7D42AA922F0AB2A1B3E919_0(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef8BE3EBBA3F5744B2B3D8BF7BE76E60DB_1(ConnectionProvider connectionProvider, String C_Bpartner_Location_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Address1), '')  || ' - ' || COALESCE(TO_CHAR(table1.Address2), '')  || ' - ' || COALESCE(TO_CHAR(table1.Postal), '')  || ' - ' || COALESCE(TO_CHAR(table1.City), '')  || ' - ' || COALESCE(TO_CHAR(table1.C_Region_ID), '')  || ' - ' || COALESCE(TO_CHAR(table1.C_Country_ID), '') ) as C_Bpartner_Location_ID FROM C_Location table1 WHERE table1.isActive='Y' AND table1.C_Location_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Bpartner_Location_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_bpartner_location_id");
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
  public static String selectDefA69A05D740AD456A9753572F8A995BAF_2(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef00B7D3437CAF48FBBD7CDD820698A83B_3(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
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

/**
Select for auxiliar field
 */
  public static String selectDefF05F251C24A240A1AADD0643F75FF2C3_4(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE c_framecontractoverview" +
      "        SET AD_Org_ID = (?) , C_Framecontractoverview_ID = (?) , C_Order_ID = (?) , AD_Client_ID = (?) , C_Orderline_ID = (?) , Docstatus = (?) , C_Bpartner_ID = (?) , Isactive = (?) , C_Bpartner_Location_ID = (?) , M_Product_ID = (?) , C_Uom_ID = (?) , Qtyordered = TO_NUMBER(?) , Securityqty = TO_NUMBER(?) , Calloffqty = TO_NUMBER(?) , Qtyleft = TO_NUMBER(?) , Priceactual = TO_NUMBER(?) , Linenetamt = TO_NUMBER(?) , A_Asset_ID = (?) , C_Project_ID = (?) , C_Projecttask_ID = (?) , Contractdate = TO_DATE(?) , Enddate = TO_DATE(?) , Deliverycomplete = (?) , Documentno = (?) , Line = TO_NUMBER(?) , M_Warehouse_ID = (?) , Issotrx = (?) , updated = now(), updatedby = ? " +
      "        WHERE c_framecontractoverview.C_Framecontractoverview_ID = ? " +
      "        AND c_framecontractoverview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_framecontractoverview.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFramecontractoverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, securityqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, calloffqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyleft);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contractdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverycomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFramecontractoverviewId);
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
      "        INSERT INTO c_framecontractoverview " +
      "        (AD_Org_ID, C_Framecontractoverview_ID, C_Order_ID, AD_Client_ID, C_Orderline_ID, Docstatus, C_Bpartner_ID, Isactive, C_Bpartner_Location_ID, M_Product_ID, C_Uom_ID, Qtyordered, Securityqty, Calloffqty, Qtyleft, Priceactual, Linenetamt, A_Asset_ID, C_Project_ID, C_Projecttask_ID, Contractdate, Enddate, Deliverycomplete, Documentno, Line, M_Warehouse_ID, Issotrx, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_DATE(?), TO_DATE(?), (?), (?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFramecontractoverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, securityqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, calloffqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyleft);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contractdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverycomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
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
      "        DELETE FROM c_framecontractoverview" +
      "        WHERE c_framecontractoverview.C_Framecontractoverview_ID = ? " +
      "        AND c_framecontractoverview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_framecontractoverview.AD_Org_ID IN (";
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
      "        DELETE FROM c_framecontractoverview" +
      "        WHERE c_framecontractoverview.C_Framecontractoverview_ID = ? ";

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
      "          FROM c_framecontractoverview" +
      "         WHERE c_framecontractoverview.C_Framecontractoverview_ID = ? ";

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
      "          FROM c_framecontractoverview" +
      "         WHERE c_framecontractoverview.C_Framecontractoverview_ID = ? ";

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
