//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openz.controller.TestWindowGuiEngine;

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
class TestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data implements FieldProvider {
static Logger log4j = Logger.getLogger(TestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String serialnumber;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String adClientId;
  public String mProductId;
  public String mProductIdr;
  public String description;
  public String isactive;
  public String aAssetId;
  public String aAssetIdr;
  public String mInternalConsumptionId;
  public String mInternalConsumptionIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String assemblySnr;
  public String mLocatorId;
  public String mLocatorIdr;
  public String mInoutId;
  public String mInoutIdr;
  public String guaranteedate;
  public String cOrderlineId;
  public String mInternalConsumptionlineId;
  public String mInternalConsumptionlineIdr;
  public String mInoutlineId;
  public String mInoutlineIdr;
  public String lotnumber;
  public String movementdate;
  public String quantity;
  public String cProjectId;
  public String cProjectIdr;
  public String docstatus;
  public String docstatusr;
  public String rfidnumber;
  public String snrSerialnumbertrackingId;
  public String movementtype;
  public String movementtyper;
  public String guaranteedays;
  public String mInventoryId;
  public String mInventoryIdr;
  public String mInventorylineId;
  public String adOrgId;
  public String adOrgIdr;
  public String mMovementlineId;
  public String mMovementId;
  public String assemblyProductid;
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
    else if (fieldName.equalsIgnoreCase("serialnumber"))
      return serialnumber;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_idr") || fieldName.equals("aAssetIdr"))
      return aAssetIdr;
    else if (fieldName.equalsIgnoreCase("m_internal_consumption_id") || fieldName.equals("mInternalConsumptionId"))
      return mInternalConsumptionId;
    else if (fieldName.equalsIgnoreCase("m_internal_consumption_idr") || fieldName.equals("mInternalConsumptionIdr"))
      return mInternalConsumptionIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("assembly_snr") || fieldName.equals("assemblySnr"))
      return assemblySnr;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_locator_idr") || fieldName.equals("mLocatorIdr"))
      return mLocatorIdr;
    else if (fieldName.equalsIgnoreCase("m_inout_id") || fieldName.equals("mInoutId"))
      return mInoutId;
    else if (fieldName.equalsIgnoreCase("m_inout_idr") || fieldName.equals("mInoutIdr"))
      return mInoutIdr;
    else if (fieldName.equalsIgnoreCase("guaranteedate"))
      return guaranteedate;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("m_internal_consumptionline_id") || fieldName.equals("mInternalConsumptionlineId"))
      return mInternalConsumptionlineId;
    else if (fieldName.equalsIgnoreCase("m_internal_consumptionline_idr") || fieldName.equals("mInternalConsumptionlineIdr"))
      return mInternalConsumptionlineIdr;
    else if (fieldName.equalsIgnoreCase("m_inoutline_id") || fieldName.equals("mInoutlineId"))
      return mInoutlineId;
    else if (fieldName.equalsIgnoreCase("m_inoutline_idr") || fieldName.equals("mInoutlineIdr"))
      return mInoutlineIdr;
    else if (fieldName.equalsIgnoreCase("lotnumber"))
      return lotnumber;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("rfidnumber"))
      return rfidnumber;
    else if (fieldName.equalsIgnoreCase("snr_serialnumbertracking_id") || fieldName.equals("snrSerialnumbertrackingId"))
      return snrSerialnumbertrackingId;
    else if (fieldName.equalsIgnoreCase("movementtype"))
      return movementtype;
    else if (fieldName.equalsIgnoreCase("movementtyper"))
      return movementtyper;
    else if (fieldName.equalsIgnoreCase("guaranteedays"))
      return guaranteedays;
    else if (fieldName.equalsIgnoreCase("m_inventory_id") || fieldName.equals("mInventoryId"))
      return mInventoryId;
    else if (fieldName.equalsIgnoreCase("m_inventory_idr") || fieldName.equals("mInventoryIdr"))
      return mInventoryIdr;
    else if (fieldName.equalsIgnoreCase("m_inventoryline_id") || fieldName.equals("mInventorylineId"))
      return mInventorylineId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("m_movementline_id") || fieldName.equals("mMovementlineId"))
      return mMovementlineId;
    else if (fieldName.equalsIgnoreCase("m_movement_id") || fieldName.equals("mMovementId"))
      return mMovementId;
    else if (fieldName.equalsIgnoreCase("assembly_productid") || fieldName.equals("assemblyProductid"))
      return assemblyProductid;
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
  public static TestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(snr_serialnumbertracking.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_serialnumbertracking.CreatedBy) as CreatedByR, " +
      "        to_char(snr_serialnumbertracking.Updated, ?) as updated, " +
      "        to_char(snr_serialnumbertracking.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        snr_serialnumbertracking.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_serialnumbertracking.UpdatedBy) as UpdatedByR," +
      "        snr_serialnumbertracking.Serialnumber, " +
      "snr_serialnumbertracking.C_Bpartner_ID, " +
      "(CASE WHEN snr_serialnumbertracking.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "snr_serialnumbertracking.AD_Client_ID, " +
      "snr_serialnumbertracking.M_Product_ID, " +
      "(CASE WHEN snr_serialnumbertracking.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "snr_serialnumbertracking.Description, " +
      "COALESCE(snr_serialnumbertracking.Isactive, 'N') AS Isactive, " +
      "snr_serialnumbertracking.A_Asset_ID, " +
      "(CASE WHEN snr_serialnumbertracking.A_Asset_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "snr_serialnumbertracking.M_Internal_Consumption_ID, " +
      "(CASE WHEN snr_serialnumbertracking.M_Internal_Consumption_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS M_Internal_Consumption_IDR, " +
      "snr_serialnumbertracking.C_Projecttask_ID, " +
      "(CASE WHEN snr_serialnumbertracking.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "snr_serialnumbertracking.Assembly_Snr, " +
      "snr_serialnumbertracking.M_Locator_ID, " +
      "(CASE WHEN snr_serialnumbertracking.M_Locator_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Value), ''))),'') ) END) AS M_Locator_IDR, " +
      "snr_serialnumbertracking.M_Inout_ID, " +
      "(CASE WHEN snr_serialnumbertracking.M_Inout_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table8.MovementDate, 'DD-MM-YYYY')),'') ) END) AS M_Inout_IDR, " +
      "snr_serialnumbertracking.Guaranteedate, " +
      "snr_serialnumbertracking.C_Orderline_ID, " +
      "snr_serialnumbertracking.M_Internal_Consumptionline_ID, " +
      "(CASE WHEN snr_serialnumbertracking.M_Internal_Consumptionline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL11.Name IS NULL THEN TO_CHAR(table11.Name) ELSE TO_CHAR(tableTRL11.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.MovementQty), ''))),'') ) END) AS M_Internal_Consumptionline_IDR, " +
      "snr_serialnumbertracking.M_Inoutline_ID, " +
      "(CASE WHEN snr_serialnumbertracking.M_Inoutline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table13.MovementDate, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL14.Name IS NULL THEN TO_CHAR(table14.Name) ELSE TO_CHAR(tableTRL14.Name) END)), ''))),'') ) END) AS M_Inoutline_IDR, " +
      "snr_serialnumbertracking.Lotnumber, " +
      "snr_serialnumbertracking.Movementdate, " +
      "snr_serialnumbertracking.Quantity, " +
      "snr_serialnumbertracking.C_Project_ID, " +
      "(CASE WHEN snr_serialnumbertracking.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "snr_serialnumbertracking.Docstatus, " +
      "(CASE WHEN snr_serialnumbertracking.Docstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DocstatusR, " +
      "snr_serialnumbertracking.Rfidnumber, " +
      "snr_serialnumbertracking.SNR_Serialnumbertracking_ID, " +
      "snr_serialnumbertracking.Movementtype, " +
      "(CASE WHEN snr_serialnumbertracking.Movementtype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS MovementtypeR, " +
      "snr_serialnumbertracking.Guaranteedays, " +
      "snr_serialnumbertracking.M_Inventory_ID, " +
      "(CASE WHEN snr_serialnumbertracking.M_Inventory_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Name), ''))),'') ) END) AS M_Inventory_IDR, " +
      "snr_serialnumbertracking.M_Inventoryline_ID, " +
      "snr_serialnumbertracking.AD_Org_ID, " +
      "(CASE WHEN snr_serialnumbertracking.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table17.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "snr_serialnumbertracking.M_Movementline_ID, " +
      "snr_serialnumbertracking.M_Movement_ID, " +
      "snr_serialnumbertracking.Assembly_Productid, " +
      "        ? AS LANGUAGE " +
      "        FROM snr_serialnumbertracking left join (select C_BPartner_ID, Name from C_BPartner) table1 on (snr_serialnumbertracking.C_Bpartner_ID = table1.C_BPartner_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (snr_serialnumbertracking.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  left join (select A_Asset_ID, Name from A_Asset) table3 on (snr_serialnumbertracking.A_Asset_ID = table3.A_Asset_ID) left join (select M_Internal_Consumption_ID, Name from M_Internal_Consumption) table4 on (snr_serialnumbertracking.M_Internal_Consumption_ID = table4.M_Internal_Consumption_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table5 on (snr_serialnumbertracking.C_Projecttask_ID = table5.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table6 on (table5.C_Project_ID = table6.C_Project_ID) left join (select M_Locator_ID, Value from M_Locator) table7 on (snr_serialnumbertracking.M_Locator_ID = table7.M_Locator_ID) left join (select M_InOut_ID, DocumentNo, MovementDate from M_InOut) table8 on (snr_serialnumbertracking.M_Inout_ID = table8.M_InOut_ID) left join (select M_Internal_Consumptionline_ID, M_Internal_Consumption_ID, M_Product_ID, MovementQty from M_Internal_Consumptionline) table9 on (snr_serialnumbertracking.M_Internal_Consumptionline_ID = table9.M_Internal_Consumptionline_ID) left join (select M_Internal_Consumption_ID, Name from M_Internal_Consumption) table10 on (table9.M_Internal_Consumption_ID = table10.M_Internal_Consumption_ID) left join (select M_Product_ID, Value, Name from M_Product) table11 on (table9.M_Product_ID = table11.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL11 on (table11.M_Product_ID = tableTRL11.M_Product_ID and tableTRL11.AD_Language = ?)  left join (select M_InOutLine_ID, M_InOut_ID, M_Product_ID from M_InOutLine) table12 on (snr_serialnumbertracking.M_Inoutline_ID = table12.M_InOutLine_ID) left join (select M_InOut_ID, DocumentNo, MovementDate from M_InOut) table13 on (table12.M_InOut_ID = table13.M_InOut_ID) left join (select M_Product_ID, Value, Name from M_Product) table14 on (table12.M_Product_ID = table14.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL14 on (table14.M_Product_ID = tableTRL14.M_Product_ID and tableTRL14.AD_Language = ?)  left join (select C_Project_ID, Value, Name from C_Project) table15 on (snr_serialnumbertracking.C_Project_ID = table15.C_Project_ID) left join ad_ref_list_v list1 on (snr_serialnumbertracking.Docstatus = list1.value and list1.ad_reference_id = '131' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (snr_serialnumbertracking.Movementtype = list2.value and list2.ad_reference_id = '189' and list2.ad_language = ?)  left join (select M_Inventory_ID, Name from M_Inventory) table16 on (snr_serialnumbertracking.M_Inventory_ID = table16.M_Inventory_ID) left join (select AD_Org_ID, Name from AD_Org) table17 on (snr_serialnumbertracking.AD_Org_ID = table17.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND snr_serialnumbertracking.SNR_Serialnumbertracking_ID = ? " +
      "        AND snr_serialnumbertracking.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND snr_serialnumbertracking.AD_Org_ID IN (";
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
        TestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data = new TestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data();
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.created = UtilSql.getValue(result, "created");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.updated = UtilSql.getValue(result, "updated");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.serialnumber = UtilSql.getValue(result, "serialnumber");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.description = UtilSql.getValue(result, "description");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.isactive = UtilSql.getValue(result, "isactive");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.mInternalConsumptionId = UtilSql.getValue(result, "m_internal_consumption_id");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.mInternalConsumptionIdr = UtilSql.getValue(result, "m_internal_consumption_idr");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.assemblySnr = UtilSql.getValue(result, "assembly_snr");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.mLocatorIdr = UtilSql.getValue(result, "m_locator_idr");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.mInoutId = UtilSql.getValue(result, "m_inout_id");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.mInoutIdr = UtilSql.getValue(result, "m_inout_idr");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.guaranteedate = UtilSql.getDateValue(result, "guaranteedate", "dd-MM-yyyy");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.mInternalConsumptionlineId = UtilSql.getValue(result, "m_internal_consumptionline_id");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.mInternalConsumptionlineIdr = UtilSql.getValue(result, "m_internal_consumptionline_idr");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.mInoutlineIdr = UtilSql.getValue(result, "m_inoutline_idr");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.lotnumber = UtilSql.getValue(result, "lotnumber");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.quantity = UtilSql.getValue(result, "quantity");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.docstatus = UtilSql.getValue(result, "docstatus");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.rfidnumber = UtilSql.getValue(result, "rfidnumber");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.snrSerialnumbertrackingId = UtilSql.getValue(result, "snr_serialnumbertracking_id");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.movementtype = UtilSql.getValue(result, "movementtype");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.movementtyper = UtilSql.getValue(result, "movementtyper");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.guaranteedays = UtilSql.getValue(result, "guaranteedays");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.mInventoryId = UtilSql.getValue(result, "m_inventory_id");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.mInventoryIdr = UtilSql.getValue(result, "m_inventory_idr");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.mInventorylineId = UtilSql.getValue(result, "m_inventoryline_id");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.mMovementlineId = UtilSql.getValue(result, "m_movementline_id");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.mMovementId = UtilSql.getValue(result, "m_movement_id");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.assemblyProductid = UtilSql.getValue(result, "assembly_productid");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.language = UtilSql.getValue(result, "language");
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.adUserClient = "";
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.adOrgClient = "";
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.createdby = "";
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.trBgcolor = "";
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.totalCount = "";
        objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data);
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
    TestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[] = new TestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[vector.size()];
    vector.copyInto(objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data);
    return(objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data);
  }

/**
Create a registry
 */
  public static TestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[] set(String docstatus, String mInventoryId, String mInoutlineId, String mInoutlineIdr, String isactive, String snrSerialnumbertrackingId, String cProjecttaskId, String quantity, String guaranteedate, String mMovementlineId, String rfidnumber, String mInoutId, String mInoutIdr, String cBpartnerId, String cBpartnerIdr, String cOrderlineId, String movementdate, String mInternalConsumptionlineId, String adOrgId, String guaranteedays, String mMovementId, String adClientId, String description, String lotnumber, String createdby, String createdbyr, String serialnumber, String mLocatorId, String mLocatorIdr, String assemblyProductid, String cProjectId, String cProjectIdr, String movementtype, String mInternalConsumptionId, String mInventorylineId, String mProductId, String mProductIdr, String aAssetId, String assemblySnr, String updatedby, String updatedbyr)    throws ServletException {
    TestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[] = new TestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[1];
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0] = new TestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data();
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].created = "";
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].createdbyr = createdbyr;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].updated = "";
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].updatedTimeStamp = "";
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].updatedby = updatedby;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].updatedbyr = updatedbyr;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].serialnumber = serialnumber;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].cBpartnerId = cBpartnerId;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].cBpartnerIdr = cBpartnerIdr;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].adClientId = adClientId;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].mProductId = mProductId;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].mProductIdr = mProductIdr;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].description = description;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].isactive = isactive;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].aAssetId = aAssetId;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].aAssetIdr = "";
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].mInternalConsumptionId = mInternalConsumptionId;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].mInternalConsumptionIdr = "";
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].cProjecttaskId = cProjecttaskId;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].cProjecttaskIdr = "";
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].assemblySnr = assemblySnr;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].mLocatorId = mLocatorId;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].mLocatorIdr = mLocatorIdr;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].mInoutId = mInoutId;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].mInoutIdr = mInoutIdr;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].guaranteedate = guaranteedate;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].cOrderlineId = cOrderlineId;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].mInternalConsumptionlineId = mInternalConsumptionlineId;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].mInternalConsumptionlineIdr = "";
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].mInoutlineId = mInoutlineId;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].mInoutlineIdr = mInoutlineIdr;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].lotnumber = lotnumber;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].movementdate = movementdate;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].quantity = quantity;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].cProjectId = cProjectId;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].cProjectIdr = cProjectIdr;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].docstatus = docstatus;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].docstatusr = "";
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].rfidnumber = rfidnumber;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].snrSerialnumbertrackingId = snrSerialnumbertrackingId;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].movementtype = movementtype;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].movementtyper = "";
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].guaranteedays = guaranteedays;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].mInventoryId = mInventoryId;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].mInventoryIdr = "";
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].mInventorylineId = mInventorylineId;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].adOrgId = adOrgId;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].adOrgIdr = "";
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].mMovementlineId = mMovementlineId;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].mMovementId = mMovementId;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].assemblyProductid = assemblyProductid;
    objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data[0].language = "";
    return objectTestSerialNumbers0C75B6BEA9724217BA7FC5524C1AC2F7Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef90CAE05DF99641938BECABEA651659F3_0(ConnectionProvider connectionProvider, String M_Inoutline_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table2.DocumentNo), '')  || ' - ' || COALESCE(TO_CHAR(table2.MovementDate), '')  || ' - ' || COALESCE(TO_CHAR(table3.Value), '')  || ' - ' || COALESCE(TO_CHAR(table3.Name), '') ) as M_Inoutline_ID FROM M_InOutLine table1 left join M_InOut table2 on (table1.M_InOut_ID = table2.M_InOut_ID) left join M_Product table3 on (table1.M_Product_ID = table3.M_Product_ID) WHERE table1.isActive='Y' AND table1.M_InOutLine_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Inoutline_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_inoutline_id");
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
  public static String selectDefB78C46BB7000448EA0E2B35DF351ADC6_1(ConnectionProvider connectionProvider, String M_Inout_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.DocumentNo), '')  || ' - ' || COALESCE(TO_CHAR(table1.MovementDate), '') ) as M_Inout_ID FROM M_InOut table1 WHERE table1.isActive='Y' AND table1.M_InOut_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Inout_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_inout_id");
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
  public static String selectDefFE03AA8BA4B7448088819DDAB664189F_2(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
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
  public static String selectDef775B3326D4104402A931CEDBFEA06933_3(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefC25C3D6A592D47C8B084245749AD006C_4(ConnectionProvider connectionProvider, String M_Locator_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '') ) as M_Locator_ID FROM M_Locator table1 WHERE table1.isActive='Y' AND table1.M_Locator_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Locator_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_locator_id");
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
  public static String selectDef4F68001A1827490B8E25617CCFE9A835_5(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as C_Project_ID FROM C_Project table1 WHERE table1.isActive='Y' AND table1.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_project_id");
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
  public static String selectDefED4444A033624267A14E465923306FF7_6(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDefABA0AE095068430AAF34BB38C525657A_7(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE snr_serialnumbertracking" +
      "        SET Serialnumber = (?) , C_Bpartner_ID = (?) , AD_Client_ID = (?) , M_Product_ID = (?) , Description = (?) , Isactive = (?) , A_Asset_ID = (?) , M_Internal_Consumption_ID = (?) , C_Projecttask_ID = (?) , Assembly_Snr = (?) , M_Locator_ID = (?) , M_Inout_ID = (?) , Guaranteedate = TO_DATE(?) , C_Orderline_ID = (?) , M_Internal_Consumptionline_ID = (?) , M_Inoutline_ID = (?) , Lotnumber = (?) , Movementdate = TO_DATE(?) , Quantity = TO_NUMBER(?) , C_Project_ID = (?) , Docstatus = (?) , Rfidnumber = (?) , SNR_Serialnumbertracking_ID = (?) , Movementtype = (?) , Guaranteedays = TO_NUMBER(?) , M_Inventory_ID = (?) , M_Inventoryline_ID = (?) , AD_Org_ID = (?) , M_Movementline_ID = (?) , M_Movement_ID = (?) , Assembly_Productid = (?) , updated = now(), updatedby = ? " +
      "        WHERE snr_serialnumbertracking.SNR_Serialnumbertracking_ID = ? " +
      "        AND snr_serialnumbertracking.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_serialnumbertracking.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assemblySnr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lotnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rfidnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrSerialnumbertrackingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInventoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInventorylineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mMovementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mMovementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assemblyProductid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrSerialnumbertrackingId);
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
      "        INSERT INTO snr_serialnumbertracking " +
      "        (Serialnumber, C_Bpartner_ID, AD_Client_ID, M_Product_ID, Description, Isactive, A_Asset_ID, M_Internal_Consumption_ID, C_Projecttask_ID, Assembly_Snr, M_Locator_ID, M_Inout_ID, Guaranteedate, C_Orderline_ID, M_Internal_Consumptionline_ID, M_Inoutline_ID, Lotnumber, Movementdate, Quantity, C_Project_ID, Docstatus, Rfidnumber, SNR_Serialnumbertracking_ID, Movementtype, Guaranteedays, M_Inventory_ID, M_Inventoryline_ID, AD_Org_ID, M_Movementline_ID, M_Movement_ID, Assembly_Productid, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), TO_DATE(?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assemblySnr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lotnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rfidnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrSerialnumbertrackingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInventoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInventorylineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mMovementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mMovementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assemblyProductid);
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
      "        DELETE FROM snr_serialnumbertracking" +
      "        WHERE snr_serialnumbertracking.SNR_Serialnumbertracking_ID = ? " +
      "        AND snr_serialnumbertracking.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_serialnumbertracking.AD_Org_ID IN (";
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
      "        DELETE FROM snr_serialnumbertracking" +
      "        WHERE snr_serialnumbertracking.SNR_Serialnumbertracking_ID = ? ";

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
      "          FROM snr_serialnumbertracking" +
      "         WHERE snr_serialnumbertracking.SNR_Serialnumbertracking_ID = ? ";

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
      "          FROM snr_serialnumbertracking" +
      "         WHERE snr_serialnumbertracking.SNR_Serialnumbertracking_ID = ? ";

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
