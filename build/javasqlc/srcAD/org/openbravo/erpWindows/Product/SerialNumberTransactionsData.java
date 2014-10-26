//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Product;

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
class SerialNumberTransactionsData implements FieldProvider {
static Logger log4j = Logger.getLogger(SerialNumberTransactionsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String serialnumber;
  public String movementdate;
  public String adClientId;
  public String mProductId;
  public String mProductIdr;
  public String mAttributesetinstanceId;
  public String mAttributesetinstanceIdr;
  public String isactive;
  public String mLocatorId;
  public String mLocatorIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cOrderlineId;
  public String cOrderlineIdr;
  public String movementtype;
  public String movementtyper;
  public String mMovementId;
  public String mMovementIdr;
  public String mInventoryId;
  public String mInventoryIdr;
  public String mInoutId;
  public String mInoutIdr;
  public String mInternalConsumptionId;
  public String mInternalConsumptionIdr;
  public String mInoutlineId;
  public String mInoutlineIdr;
  public String mMovementlineId;
  public String mMovementlineIdr;
  public String guaranteedays;
  public String mInternalConsumptionlineId;
  public String mInternalConsumptionlineIdr;
  public String mInventorylineId;
  public String mInventorylineIdr;
  public String rfidnumber;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String aAssetId;
  public String aAssetIdr;
  public String assemblyProductid;
  public String assemblyProductidr;
  public String snrSerialnumbertrackingId;
  public String assemblySnr;
  public String adOrgId;
  public String adOrgIdr;
  public String lotnumber;
  public String quantity;
  public String guaranteedate;
  public String description;
  public String docstatus;
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
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_idr") || fieldName.equals("mAttributesetinstanceIdr"))
      return mAttributesetinstanceIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_locator_idr") || fieldName.equals("mLocatorIdr"))
      return mLocatorIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("c_orderline_idr") || fieldName.equals("cOrderlineIdr"))
      return cOrderlineIdr;
    else if (fieldName.equalsIgnoreCase("movementtype"))
      return movementtype;
    else if (fieldName.equalsIgnoreCase("movementtyper"))
      return movementtyper;
    else if (fieldName.equalsIgnoreCase("m_movement_id") || fieldName.equals("mMovementId"))
      return mMovementId;
    else if (fieldName.equalsIgnoreCase("m_movement_idr") || fieldName.equals("mMovementIdr"))
      return mMovementIdr;
    else if (fieldName.equalsIgnoreCase("m_inventory_id") || fieldName.equals("mInventoryId"))
      return mInventoryId;
    else if (fieldName.equalsIgnoreCase("m_inventory_idr") || fieldName.equals("mInventoryIdr"))
      return mInventoryIdr;
    else if (fieldName.equalsIgnoreCase("m_inout_id") || fieldName.equals("mInoutId"))
      return mInoutId;
    else if (fieldName.equalsIgnoreCase("m_inout_idr") || fieldName.equals("mInoutIdr"))
      return mInoutIdr;
    else if (fieldName.equalsIgnoreCase("m_internal_consumption_id") || fieldName.equals("mInternalConsumptionId"))
      return mInternalConsumptionId;
    else if (fieldName.equalsIgnoreCase("m_internal_consumption_idr") || fieldName.equals("mInternalConsumptionIdr"))
      return mInternalConsumptionIdr;
    else if (fieldName.equalsIgnoreCase("m_inoutline_id") || fieldName.equals("mInoutlineId"))
      return mInoutlineId;
    else if (fieldName.equalsIgnoreCase("m_inoutline_idr") || fieldName.equals("mInoutlineIdr"))
      return mInoutlineIdr;
    else if (fieldName.equalsIgnoreCase("m_movementline_id") || fieldName.equals("mMovementlineId"))
      return mMovementlineId;
    else if (fieldName.equalsIgnoreCase("m_movementline_idr") || fieldName.equals("mMovementlineIdr"))
      return mMovementlineIdr;
    else if (fieldName.equalsIgnoreCase("guaranteedays"))
      return guaranteedays;
    else if (fieldName.equalsIgnoreCase("m_internal_consumptionline_id") || fieldName.equals("mInternalConsumptionlineId"))
      return mInternalConsumptionlineId;
    else if (fieldName.equalsIgnoreCase("m_internal_consumptionline_idr") || fieldName.equals("mInternalConsumptionlineIdr"))
      return mInternalConsumptionlineIdr;
    else if (fieldName.equalsIgnoreCase("m_inventoryline_id") || fieldName.equals("mInventorylineId"))
      return mInventorylineId;
    else if (fieldName.equalsIgnoreCase("m_inventoryline_idr") || fieldName.equals("mInventorylineIdr"))
      return mInventorylineIdr;
    else if (fieldName.equalsIgnoreCase("rfidnumber"))
      return rfidnumber;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_idr") || fieldName.equals("aAssetIdr"))
      return aAssetIdr;
    else if (fieldName.equalsIgnoreCase("assembly_productid") || fieldName.equals("assemblyProductid"))
      return assemblyProductid;
    else if (fieldName.equalsIgnoreCase("assembly_productidr") || fieldName.equals("assemblyProductidr"))
      return assemblyProductidr;
    else if (fieldName.equalsIgnoreCase("snr_serialnumbertracking_id") || fieldName.equals("snrSerialnumbertrackingId"))
      return snrSerialnumbertrackingId;
    else if (fieldName.equalsIgnoreCase("assembly_snr") || fieldName.equals("assemblySnr"))
      return assemblySnr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("lotnumber"))
      return lotnumber;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("guaranteedate"))
      return guaranteedate;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
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
  public static SerialNumberTransactionsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String snr_masterdata_ID, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, snr_masterdata_ID, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static SerialNumberTransactionsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String snr_masterdata_ID, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(snr_serialnumbertracking.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_serialnumbertracking.CreatedBy) as CreatedByR, " +
      "        to_char(snr_serialnumbertracking.Updated, ?) as updated, " +
      "        to_char(snr_serialnumbertracking.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        snr_serialnumbertracking.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_serialnumbertracking.UpdatedBy) as UpdatedByR," +
      "        snr_serialnumbertracking.Serialnumber, " +
      "snr_serialnumbertracking.Movementdate, " +
      "snr_serialnumbertracking.AD_Client_ID, " +
      "snr_serialnumbertracking.M_Product_ID, " +
      "(CASE WHEN snr_serialnumbertracking.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "snr_serialnumbertracking.M_Attributesetinstance_ID, " +
      "(CASE WHEN snr_serialnumbertracking.M_Attributesetinstance_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Description), ''))),'') ) END) AS M_Attributesetinstance_IDR, " +
      "COALESCE(snr_serialnumbertracking.Isactive, 'N') AS Isactive, " +
      "snr_serialnumbertracking.M_Locator_ID, " +
      "(CASE WHEN snr_serialnumbertracking.M_Locator_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'') ) END) AS M_Locator_IDR, " +
      "snr_serialnumbertracking.C_Bpartner_ID, " +
      "(CASE WHEN snr_serialnumbertracking.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "snr_serialnumbertracking.C_Orderline_ID, " +
      "(CASE WHEN snr_serialnumbertracking.C_Orderline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table6.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.GrandTotal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.LineNetAmt), ''))),'') ) END) AS C_Orderline_IDR, " +
      "snr_serialnumbertracking.Movementtype, " +
      "(CASE WHEN snr_serialnumbertracking.Movementtype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS MovementtypeR, " +
      "snr_serialnumbertracking.M_Movement_ID, " +
      "(CASE WHEN snr_serialnumbertracking.M_Movement_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS M_Movement_IDR, " +
      "snr_serialnumbertracking.M_Inventory_ID, " +
      "(CASE WHEN snr_serialnumbertracking.M_Inventory_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS M_Inventory_IDR, " +
      "snr_serialnumbertracking.M_Inout_ID, " +
      "(CASE WHEN snr_serialnumbertracking.M_Inout_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table9.MovementDate, 'DD-MM-YYYY')),'') ) END) AS M_Inout_IDR, " +
      "snr_serialnumbertracking.M_Internal_Consumption_ID, " +
      "(CASE WHEN snr_serialnumbertracking.M_Internal_Consumption_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS M_Internal_Consumption_IDR, " +
      "snr_serialnumbertracking.M_Inoutline_ID, " +
      "(CASE WHEN snr_serialnumbertracking.M_Inoutline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table12.MovementDate, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL13.Name IS NULL THEN TO_CHAR(table13.Name) ELSE TO_CHAR(tableTRL13.Name) END)), ''))),'') ) END) AS M_Inoutline_IDR, " +
      "snr_serialnumbertracking.M_Movementline_ID, " +
      "(CASE WHEN snr_serialnumbertracking.M_Movementline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.MovementQty), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Name), ''))),'') ) END) AS M_Movementline_IDR, " +
      "snr_serialnumbertracking.Guaranteedays, " +
      "snr_serialnumbertracking.M_Internal_Consumptionline_ID, " +
      "(CASE WHEN snr_serialnumbertracking.M_Internal_Consumptionline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table17.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table18.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL18.Name IS NULL THEN TO_CHAR(table18.Name) ELSE TO_CHAR(tableTRL18.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.MovementQty), ''))),'') ) END) AS M_Internal_Consumptionline_IDR, " +
      "snr_serialnumbertracking.M_Inventoryline_ID, " +
      "(CASE WHEN snr_serialnumbertracking.M_Inventoryline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.QtyCount), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table20.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.Name), ''))),'') ) END) AS M_Inventoryline_IDR, " +
      "snr_serialnumbertracking.Rfidnumber, " +
      "snr_serialnumbertracking.C_Project_ID, " +
      "(CASE WHEN snr_serialnumbertracking.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table21.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table21.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "snr_serialnumbertracking.C_Projecttask_ID, " +
      "(CASE WHEN snr_serialnumbertracking.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table22.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table23.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table23.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "snr_serialnumbertracking.A_Asset_ID, " +
      "(CASE WHEN snr_serialnumbertracking.A_Asset_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table24.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "snr_serialnumbertracking.Assembly_Productid, " +
      "(CASE WHEN snr_serialnumbertracking.Assembly_Productid IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table25.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL25.Name IS NULL THEN TO_CHAR(table25.Name) ELSE TO_CHAR(tableTRL25.Name) END)), ''))),'') ) END) AS Assembly_ProductidR, " +
      "snr_serialnumbertracking.SNR_Serialnumbertracking_ID, " +
      "snr_serialnumbertracking.Assembly_Snr, " +
      "snr_serialnumbertracking.AD_Org_ID, " +
      "(CASE WHEN snr_serialnumbertracking.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table26.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "snr_serialnumbertracking.Lotnumber, " +
      "snr_serialnumbertracking.Quantity, " +
      "snr_serialnumbertracking.Guaranteedate, " +
      "snr_serialnumbertracking.Description, " +
      "snr_serialnumbertracking.Docstatus, " +
      "        ? AS LANGUAGE " +
      "        FROM snr_serialnumbertracking left join (select M_Product_ID, Value, Name from M_Product) table1 on (snr_serialnumbertracking.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  left join (select M_AttributeSetInstance_ID, Description from M_AttributeSetInstance) table2 on (snr_serialnumbertracking.M_Attributesetinstance_ID = table2.M_AttributeSetInstance_ID) left join (select M_Locator_ID, Value from M_Locator) table3 on (snr_serialnumbertracking.M_Locator_ID = table3.M_Locator_ID) left join (select C_BPartner_ID, Name from C_BPartner) table4 on (snr_serialnumbertracking.C_Bpartner_ID = table4.C_BPartner_ID) left join (select C_OrderLine_ID, C_Order_ID, Line, LineNetAmt from C_OrderLine) table5 on (snr_serialnumbertracking.C_Orderline_ID = table5.C_OrderLine_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table6 on (table5.C_Order_ID = table6.C_Order_ID) left join ad_ref_list_v list1 on (snr_serialnumbertracking.Movementtype = list1.value and list1.ad_reference_id = '189' and list1.ad_language = ?)  left join (select M_Movement_ID, DocumentNo, Name from M_Movement) table7 on (snr_serialnumbertracking.M_Movement_ID = table7.M_Movement_ID) left join (select M_Inventory_ID, Name from M_Inventory) table8 on (snr_serialnumbertracking.M_Inventory_ID = table8.M_Inventory_ID) left join (select M_InOut_ID, DocumentNo, MovementDate from M_InOut) table9 on (snr_serialnumbertracking.M_Inout_ID = table9.M_InOut_ID) left join (select M_Internal_Consumption_ID, Name from M_Internal_Consumption) table10 on (snr_serialnumbertracking.M_Internal_Consumption_ID = table10.M_Internal_Consumption_ID) left join (select M_InOutLine_ID, M_InOut_ID, M_Product_ID from M_InOutLine) table11 on (snr_serialnumbertracking.M_Inoutline_ID = table11.M_InOutLine_ID) left join (select M_InOut_ID, DocumentNo, MovementDate from M_InOut) table12 on (table11.M_InOut_ID = table12.M_InOut_ID) left join (select M_Product_ID, Value, Name from M_Product) table13 on (table11.M_Product_ID = table13.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL13 on (table13.M_Product_ID = tableTRL13.M_Product_ID and tableTRL13.AD_Language = ?)  left join (select M_Movementline_ID, Line, MovementQty, M_Movement_ID from M_Movementline) table14 on (snr_serialnumbertracking.M_Movementline_ID = table14.M_Movementline_ID) left join (select M_Movement_ID, DocumentNo, Name from M_Movement) table15 on (table14.M_Movement_ID = table15.M_Movement_ID) left join (select M_Internal_Consumptionline_ID, M_Internal_Consumption_ID, M_Product_ID, MovementQty from M_Internal_Consumptionline) table16 on (snr_serialnumbertracking.M_Internal_Consumptionline_ID = table16.M_Internal_Consumptionline_ID) left join (select M_Internal_Consumption_ID, Name from M_Internal_Consumption) table17 on (table16.M_Internal_Consumption_ID = table17.M_Internal_Consumption_ID) left join (select M_Product_ID, Value, Name from M_Product) table18 on (table16.M_Product_ID = table18.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL18 on (table18.M_Product_ID = tableTRL18.M_Product_ID and tableTRL18.AD_Language = ?)  left join (select M_Inventoryline_ID, Line, QtyCount, M_Inventory_ID, Name from M_Inventoryline) table19 on (snr_serialnumbertracking.M_Inventoryline_ID = table19.M_Inventoryline_ID) left join (select M_Inventory_ID, Name from M_Inventory) table20 on (table19.M_Inventory_ID = table20.M_Inventory_ID) left join (select C_Project_ID, Value, Name from C_Project) table21 on (snr_serialnumbertracking.C_Project_ID = table21.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table22 on (snr_serialnumbertracking.C_Projecttask_ID = table22.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table23 on (table22.C_Project_ID = table23.C_Project_ID) left join (select A_Asset_ID, Name from A_Asset) table24 on (snr_serialnumbertracking.A_Asset_ID = table24.A_Asset_ID) left join (select M_Product_ID, Value, Name from M_Product) table25 on (snr_serialnumbertracking.Assembly_Productid = table25.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL25 on (table25.M_Product_ID = tableTRL25.M_Product_ID and tableTRL25.AD_Language = ?)  left join (select AD_Org_ID, Name from AD_Org) table26 on (snr_serialnumbertracking.AD_Org_ID = table26.AD_Org_ID)" +
      "        WHERE 2=2 " +
      " AND SNR_serialnumbertracking.snr_masterdata_id = ?" +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snr_masterdata_ID);
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
        SerialNumberTransactionsData objectSerialNumberTransactionsData = new SerialNumberTransactionsData();
        objectSerialNumberTransactionsData.created = UtilSql.getValue(result, "created");
        objectSerialNumberTransactionsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSerialNumberTransactionsData.updated = UtilSql.getValue(result, "updated");
        objectSerialNumberTransactionsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSerialNumberTransactionsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectSerialNumberTransactionsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSerialNumberTransactionsData.serialnumber = UtilSql.getValue(result, "serialnumber");
        objectSerialNumberTransactionsData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectSerialNumberTransactionsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSerialNumberTransactionsData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectSerialNumberTransactionsData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectSerialNumberTransactionsData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectSerialNumberTransactionsData.mAttributesetinstanceIdr = UtilSql.getValue(result, "m_attributesetinstance_idr");
        objectSerialNumberTransactionsData.isactive = UtilSql.getValue(result, "isactive");
        objectSerialNumberTransactionsData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectSerialNumberTransactionsData.mLocatorIdr = UtilSql.getValue(result, "m_locator_idr");
        objectSerialNumberTransactionsData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectSerialNumberTransactionsData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectSerialNumberTransactionsData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectSerialNumberTransactionsData.cOrderlineIdr = UtilSql.getValue(result, "c_orderline_idr");
        objectSerialNumberTransactionsData.movementtype = UtilSql.getValue(result, "movementtype");
        objectSerialNumberTransactionsData.movementtyper = UtilSql.getValue(result, "movementtyper");
        objectSerialNumberTransactionsData.mMovementId = UtilSql.getValue(result, "m_movement_id");
        objectSerialNumberTransactionsData.mMovementIdr = UtilSql.getValue(result, "m_movement_idr");
        objectSerialNumberTransactionsData.mInventoryId = UtilSql.getValue(result, "m_inventory_id");
        objectSerialNumberTransactionsData.mInventoryIdr = UtilSql.getValue(result, "m_inventory_idr");
        objectSerialNumberTransactionsData.mInoutId = UtilSql.getValue(result, "m_inout_id");
        objectSerialNumberTransactionsData.mInoutIdr = UtilSql.getValue(result, "m_inout_idr");
        objectSerialNumberTransactionsData.mInternalConsumptionId = UtilSql.getValue(result, "m_internal_consumption_id");
        objectSerialNumberTransactionsData.mInternalConsumptionIdr = UtilSql.getValue(result, "m_internal_consumption_idr");
        objectSerialNumberTransactionsData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectSerialNumberTransactionsData.mInoutlineIdr = UtilSql.getValue(result, "m_inoutline_idr");
        objectSerialNumberTransactionsData.mMovementlineId = UtilSql.getValue(result, "m_movementline_id");
        objectSerialNumberTransactionsData.mMovementlineIdr = UtilSql.getValue(result, "m_movementline_idr");
        objectSerialNumberTransactionsData.guaranteedays = UtilSql.getValue(result, "guaranteedays");
        objectSerialNumberTransactionsData.mInternalConsumptionlineId = UtilSql.getValue(result, "m_internal_consumptionline_id");
        objectSerialNumberTransactionsData.mInternalConsumptionlineIdr = UtilSql.getValue(result, "m_internal_consumptionline_idr");
        objectSerialNumberTransactionsData.mInventorylineId = UtilSql.getValue(result, "m_inventoryline_id");
        objectSerialNumberTransactionsData.mInventorylineIdr = UtilSql.getValue(result, "m_inventoryline_idr");
        objectSerialNumberTransactionsData.rfidnumber = UtilSql.getValue(result, "rfidnumber");
        objectSerialNumberTransactionsData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectSerialNumberTransactionsData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectSerialNumberTransactionsData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectSerialNumberTransactionsData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectSerialNumberTransactionsData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectSerialNumberTransactionsData.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectSerialNumberTransactionsData.assemblyProductid = UtilSql.getValue(result, "assembly_productid");
        objectSerialNumberTransactionsData.assemblyProductidr = UtilSql.getValue(result, "assembly_productidr");
        objectSerialNumberTransactionsData.snrSerialnumbertrackingId = UtilSql.getValue(result, "snr_serialnumbertracking_id");
        objectSerialNumberTransactionsData.assemblySnr = UtilSql.getValue(result, "assembly_snr");
        objectSerialNumberTransactionsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSerialNumberTransactionsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectSerialNumberTransactionsData.lotnumber = UtilSql.getValue(result, "lotnumber");
        objectSerialNumberTransactionsData.quantity = UtilSql.getValue(result, "quantity");
        objectSerialNumberTransactionsData.guaranteedate = UtilSql.getDateValue(result, "guaranteedate", "dd-MM-yyyy");
        objectSerialNumberTransactionsData.description = UtilSql.getValue(result, "description");
        objectSerialNumberTransactionsData.docstatus = UtilSql.getValue(result, "docstatus");
        objectSerialNumberTransactionsData.language = UtilSql.getValue(result, "language");
        objectSerialNumberTransactionsData.adUserClient = "";
        objectSerialNumberTransactionsData.adOrgClient = "";
        objectSerialNumberTransactionsData.createdby = "";
        objectSerialNumberTransactionsData.trBgcolor = "";
        objectSerialNumberTransactionsData.totalCount = "";
        objectSerialNumberTransactionsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSerialNumberTransactionsData);
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
    SerialNumberTransactionsData objectSerialNumberTransactionsData[] = new SerialNumberTransactionsData[vector.size()];
    vector.copyInto(objectSerialNumberTransactionsData);
    return(objectSerialNumberTransactionsData);
  }

/**
Create a registry
 */
  public static SerialNumberTransactionsData[] set(String assemblyProductid, String assemblyProductidr, String mInoutlineId, String mInoutlineIdr, String snrSerialnumbertrackingId, String isactive, String cProjecttaskId, String mMovementId, String quantity, String description, String mInventorylineId, String movementdate, String mInternalConsumptionlineId, String adOrgId, String guaranteedate, String lotnumber, String mMovementlineId, String createdby, String createdbyr, String movementtype, String mInternalConsumptionId, String assemblySnr, String updatedby, String updatedbyr, String mInventoryId, String guaranteedays, String mAttributesetinstanceId, String mAttributesetinstanceIdr, String mInoutId, String mInoutIdr, String cBpartnerId, String cBpartnerIdr, String adClientId, String rfidnumber, String docstatus, String mLocatorId, String mLocatorIdr, String serialnumber, String cProjectId, String cProjectIdr, String cOrderlineId, String cOrderlineIdr, String mProductId, String mProductIdr, String aAssetId)    throws ServletException {
    SerialNumberTransactionsData objectSerialNumberTransactionsData[] = new SerialNumberTransactionsData[1];
    objectSerialNumberTransactionsData[0] = new SerialNumberTransactionsData();
    objectSerialNumberTransactionsData[0].created = "";
    objectSerialNumberTransactionsData[0].createdbyr = createdbyr;
    objectSerialNumberTransactionsData[0].updated = "";
    objectSerialNumberTransactionsData[0].updatedTimeStamp = "";
    objectSerialNumberTransactionsData[0].updatedby = updatedby;
    objectSerialNumberTransactionsData[0].updatedbyr = updatedbyr;
    objectSerialNumberTransactionsData[0].serialnumber = serialnumber;
    objectSerialNumberTransactionsData[0].movementdate = movementdate;
    objectSerialNumberTransactionsData[0].adClientId = adClientId;
    objectSerialNumberTransactionsData[0].mProductId = mProductId;
    objectSerialNumberTransactionsData[0].mProductIdr = mProductIdr;
    objectSerialNumberTransactionsData[0].mAttributesetinstanceId = mAttributesetinstanceId;
    objectSerialNumberTransactionsData[0].mAttributesetinstanceIdr = mAttributesetinstanceIdr;
    objectSerialNumberTransactionsData[0].isactive = isactive;
    objectSerialNumberTransactionsData[0].mLocatorId = mLocatorId;
    objectSerialNumberTransactionsData[0].mLocatorIdr = mLocatorIdr;
    objectSerialNumberTransactionsData[0].cBpartnerId = cBpartnerId;
    objectSerialNumberTransactionsData[0].cBpartnerIdr = cBpartnerIdr;
    objectSerialNumberTransactionsData[0].cOrderlineId = cOrderlineId;
    objectSerialNumberTransactionsData[0].cOrderlineIdr = cOrderlineIdr;
    objectSerialNumberTransactionsData[0].movementtype = movementtype;
    objectSerialNumberTransactionsData[0].movementtyper = "";
    objectSerialNumberTransactionsData[0].mMovementId = mMovementId;
    objectSerialNumberTransactionsData[0].mMovementIdr = "";
    objectSerialNumberTransactionsData[0].mInventoryId = mInventoryId;
    objectSerialNumberTransactionsData[0].mInventoryIdr = "";
    objectSerialNumberTransactionsData[0].mInoutId = mInoutId;
    objectSerialNumberTransactionsData[0].mInoutIdr = mInoutIdr;
    objectSerialNumberTransactionsData[0].mInternalConsumptionId = mInternalConsumptionId;
    objectSerialNumberTransactionsData[0].mInternalConsumptionIdr = "";
    objectSerialNumberTransactionsData[0].mInoutlineId = mInoutlineId;
    objectSerialNumberTransactionsData[0].mInoutlineIdr = mInoutlineIdr;
    objectSerialNumberTransactionsData[0].mMovementlineId = mMovementlineId;
    objectSerialNumberTransactionsData[0].mMovementlineIdr = "";
    objectSerialNumberTransactionsData[0].guaranteedays = guaranteedays;
    objectSerialNumberTransactionsData[0].mInternalConsumptionlineId = mInternalConsumptionlineId;
    objectSerialNumberTransactionsData[0].mInternalConsumptionlineIdr = "";
    objectSerialNumberTransactionsData[0].mInventorylineId = mInventorylineId;
    objectSerialNumberTransactionsData[0].mInventorylineIdr = "";
    objectSerialNumberTransactionsData[0].rfidnumber = rfidnumber;
    objectSerialNumberTransactionsData[0].cProjectId = cProjectId;
    objectSerialNumberTransactionsData[0].cProjectIdr = cProjectIdr;
    objectSerialNumberTransactionsData[0].cProjecttaskId = cProjecttaskId;
    objectSerialNumberTransactionsData[0].cProjecttaskIdr = "";
    objectSerialNumberTransactionsData[0].aAssetId = aAssetId;
    objectSerialNumberTransactionsData[0].aAssetIdr = "";
    objectSerialNumberTransactionsData[0].assemblyProductid = assemblyProductid;
    objectSerialNumberTransactionsData[0].assemblyProductidr = assemblyProductidr;
    objectSerialNumberTransactionsData[0].snrSerialnumbertrackingId = snrSerialnumbertrackingId;
    objectSerialNumberTransactionsData[0].assemblySnr = assemblySnr;
    objectSerialNumberTransactionsData[0].adOrgId = adOrgId;
    objectSerialNumberTransactionsData[0].adOrgIdr = "";
    objectSerialNumberTransactionsData[0].lotnumber = lotnumber;
    objectSerialNumberTransactionsData[0].quantity = quantity;
    objectSerialNumberTransactionsData[0].guaranteedate = guaranteedate;
    objectSerialNumberTransactionsData[0].description = description;
    objectSerialNumberTransactionsData[0].docstatus = docstatus;
    objectSerialNumberTransactionsData[0].language = "";
    return objectSerialNumberTransactionsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefA71F774962944D41B980C9C2D5B34669_0(ConnectionProvider connectionProvider, String Assembly_ProductidR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as Assembly_Productid FROM M_Product table1 WHERE table1.isActive='Y' AND table1.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Assembly_ProductidR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "assembly_productid");
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
  public static String selectDef90CAE05DF99641938BECABEA651659F3_1(ConnectionProvider connectionProvider, String M_Inoutline_IDR)    throws ServletException {
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
  public static String selectDef775B3326D4104402A931CEDBFEA06933_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefABA0AE095068430AAF34BB38C525657A_3(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefD6E8C36F2B8F4CC7AB52999AB9D274DA_4(ConnectionProvider connectionProvider, String M_Attributesetinstance_IDR)    throws ServletException {
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
  public static String selectDefB78C46BB7000448EA0E2B35DF351ADC6_5(ConnectionProvider connectionProvider, String M_Inout_IDR)    throws ServletException {
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
  public static String selectDefFE03AA8BA4B7448088819DDAB664189F_6(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
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
  public static String selectDefC25C3D6A592D47C8B084245749AD006C_7(ConnectionProvider connectionProvider, String M_Locator_IDR)    throws ServletException {
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
  public static String selectDef4F68001A1827490B8E25617CCFE9A835_8(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
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
  public static String selectDef8E2C92CCC5F547E998DC56323ADBAB8F_9(ConnectionProvider connectionProvider, String C_Orderline_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table2.DocumentNo), '')  || ' - ' || COALESCE(TO_CHAR(table2.Name), '')  || ' - ' || COALESCE(TO_CHAR(table2.DateOrdered), '')  || ' - ' || COALESCE(TO_CHAR(table2.GrandTotal), '')  || ' - ' || COALESCE(TO_CHAR(table1.Line), '')  || ' - ' || COALESCE(TO_CHAR(table1.LineNetAmt), '') ) as C_Orderline_ID FROM C_OrderLine table1 left join C_Order table2 on (table1.C_Order_ID = table2.C_Order_ID) WHERE table1.isActive='Y' AND table1.C_OrderLine_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Orderline_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_orderline_id");
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
  public static String selectDefED4444A033624267A14E465923306FF7_10(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE snr_serialnumbertracking" +
      "        SET Serialnumber = (?) , Movementdate = TO_DATE(?) , AD_Client_ID = (?) , M_Product_ID = (?) , M_Attributesetinstance_ID = (?) , Isactive = (?) , M_Locator_ID = (?) , C_Bpartner_ID = (?) , C_Orderline_ID = (?) , Movementtype = (?) , M_Movement_ID = (?) , M_Inventory_ID = (?) , M_Inout_ID = (?) , M_Internal_Consumption_ID = (?) , M_Inoutline_ID = (?) , M_Movementline_ID = (?) , Guaranteedays = TO_NUMBER(?) , M_Internal_Consumptionline_ID = (?) , M_Inventoryline_ID = (?) , Rfidnumber = (?) , C_Project_ID = (?) , C_Projecttask_ID = (?) , A_Asset_ID = (?) , Assembly_Productid = (?) , SNR_Serialnumbertracking_ID = (?) , Assembly_Snr = (?) , AD_Org_ID = (?) , Lotnumber = (?) , Quantity = TO_NUMBER(?) , Guaranteedate = TO_DATE(?) , Description = (?) , Docstatus = (?) , updated = now(), updatedby = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mMovementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInventoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mMovementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInventorylineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rfidnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assemblyProductid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrSerialnumbertrackingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assemblySnr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lotnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
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
      "        (Serialnumber, Movementdate, AD_Client_ID, M_Product_ID, M_Attributesetinstance_ID, Isactive, M_Locator_ID, C_Bpartner_ID, C_Orderline_ID, Movementtype, M_Movement_ID, M_Inventory_ID, M_Inout_ID, M_Internal_Consumption_ID, M_Inoutline_ID, M_Movementline_ID, Guaranteedays, M_Internal_Consumptionline_ID, M_Inventoryline_ID, Rfidnumber, C_Project_ID, C_Projecttask_ID, A_Asset_ID, Assembly_Productid, SNR_Serialnumbertracking_ID, Assembly_Snr, AD_Org_ID, Lotnumber, Quantity, Guaranteedate, Description, Docstatus, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_DATE(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mMovementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInventoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mMovementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInventorylineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rfidnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assemblyProductid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrSerialnumbertrackingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assemblySnr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lotnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
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
