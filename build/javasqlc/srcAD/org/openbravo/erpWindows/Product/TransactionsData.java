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
class TransactionsData implements FieldProvider {
static Logger log4j = Logger.getLogger(TransactionsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cProjectissueId;
  public String mProductUomId;
  public String mProductId;
  public String quantityorder;
  public String cUomId;
  public String cUomIdr;
  public String cProjectphaseId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String mAttributesetinstanceId;
  public String mAttributesetinstanceIdr;
  public String isactive;
  public String mLocatorId;
  public String mLocatorIdr;
  public String movementqty;
  public String movementdate;
  public String movementtype;
  public String movementtyper;
  public String mInternalConsumptionlineId;
  public String mInternalConsumptionlineIdr;
  public String mInoutlineId;
  public String mInoutlineIdr;
  public String mInventorylineId;
  public String mInventorylineIdr;
  public String mMovementlineId;
  public String mMovementlineIdr;
  public String mProductionlineId;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String aAssetId;
  public String aAssetIdr;
  public String mTransactionId;
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
    else if (fieldName.equalsIgnoreCase("c_projectissue_id") || fieldName.equals("cProjectissueId"))
      return cProjectissueId;
    else if (fieldName.equalsIgnoreCase("m_product_uom_id") || fieldName.equals("mProductUomId"))
      return mProductUomId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("quantityorder"))
      return quantityorder;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
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
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("movementtype"))
      return movementtype;
    else if (fieldName.equalsIgnoreCase("movementtyper"))
      return movementtyper;
    else if (fieldName.equalsIgnoreCase("m_internal_consumptionline_id") || fieldName.equals("mInternalConsumptionlineId"))
      return mInternalConsumptionlineId;
    else if (fieldName.equalsIgnoreCase("m_internal_consumptionline_idr") || fieldName.equals("mInternalConsumptionlineIdr"))
      return mInternalConsumptionlineIdr;
    else if (fieldName.equalsIgnoreCase("m_inoutline_id") || fieldName.equals("mInoutlineId"))
      return mInoutlineId;
    else if (fieldName.equalsIgnoreCase("m_inoutline_idr") || fieldName.equals("mInoutlineIdr"))
      return mInoutlineIdr;
    else if (fieldName.equalsIgnoreCase("m_inventoryline_id") || fieldName.equals("mInventorylineId"))
      return mInventorylineId;
    else if (fieldName.equalsIgnoreCase("m_inventoryline_idr") || fieldName.equals("mInventorylineIdr"))
      return mInventorylineIdr;
    else if (fieldName.equalsIgnoreCase("m_movementline_id") || fieldName.equals("mMovementlineId"))
      return mMovementlineId;
    else if (fieldName.equalsIgnoreCase("m_movementline_idr") || fieldName.equals("mMovementlineIdr"))
      return mMovementlineIdr;
    else if (fieldName.equalsIgnoreCase("m_productionline_id") || fieldName.equals("mProductionlineId"))
      return mProductionlineId;
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
    else if (fieldName.equalsIgnoreCase("m_transaction_id") || fieldName.equals("mTransactionId"))
      return mTransactionId;
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
  public static TransactionsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String M_PRODUCT_ID, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, M_PRODUCT_ID, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TransactionsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String M_PRODUCT_ID, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_Transaction.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Transaction.CreatedBy) as CreatedByR, " +
      "        to_char(M_Transaction.Updated, ?) as updated, " +
      "        to_char(M_Transaction.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_Transaction.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Transaction.UpdatedBy) as UpdatedByR," +
      "        M_Transaction.C_ProjectIssue_ID, " +
      "M_Transaction.M_Product_Uom_Id, " +
      "M_Transaction.M_Product_ID, " +
      "M_Transaction.QuantityOrder, " +
      "M_Transaction.C_UOM_ID, " +
      "(CASE WHEN M_Transaction.C_UOM_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS C_UOM_IDR, " +
      "M_Transaction.C_Projectphase_ID, " +
      "M_Transaction.AD_Client_ID, " +
      "(CASE WHEN M_Transaction.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "M_Transaction.AD_Org_ID, " +
      "(CASE WHEN M_Transaction.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "M_Transaction.M_AttributeSetInstance_ID, " +
      "(CASE WHEN M_Transaction.M_AttributeSetInstance_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Description), ''))),'') ) END) AS M_AttributeSetInstance_IDR, " +
      "COALESCE(M_Transaction.IsActive, 'N') AS IsActive, " +
      "M_Transaction.M_Locator_ID, " +
      "(CASE WHEN M_Transaction.M_Locator_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'') ) END) AS M_Locator_IDR, " +
      "M_Transaction.MovementQty, " +
      "M_Transaction.MovementDate, " +
      "M_Transaction.MovementType, " +
      "(CASE WHEN M_Transaction.MovementType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS MovementTypeR, " +
      "M_Transaction.M_Internal_Consumptionline_ID, " +
      "(CASE WHEN M_Transaction.M_Internal_Consumptionline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL8.Name IS NULL THEN TO_CHAR(table8.Name) ELSE TO_CHAR(tableTRL8.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.MovementQty), ''))),'') ) END) AS M_Internal_Consumptionline_IDR, " +
      "M_Transaction.M_InOutLine_ID, " +
      "(CASE WHEN M_Transaction.M_InOutLine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table10.MovementDate, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL11.Name IS NULL THEN TO_CHAR(table11.Name) ELSE TO_CHAR(tableTRL11.Name) END)), ''))),'') ) END) AS M_InOutLine_IDR, " +
      "M_Transaction.M_InventoryLine_ID, " +
      "(CASE WHEN M_Transaction.M_InventoryLine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.QtyCount), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Name), ''))),'') ) END) AS M_InventoryLine_IDR, " +
      "M_Transaction.M_MovementLine_ID, " +
      "(CASE WHEN M_Transaction.M_MovementLine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.MovementQty), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Name), ''))),'') ) END) AS M_MovementLine_IDR, " +
      "M_Transaction.M_ProductionLine_ID, " +
      "M_Transaction.C_Project_ID, " +
      "(CASE WHEN M_Transaction.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "M_Transaction.C_Projecttask_ID, " +
      "(CASE WHEN M_Transaction.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table17.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table18.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table18.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "M_Transaction.A_Asset_ID, " +
      "(CASE WHEN M_Transaction.A_Asset_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "M_Transaction.M_Transaction_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM M_Transaction left join (select C_UOM_ID, Name from C_UOM) table1 on (M_Transaction.C_UOM_ID = table1.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL1 on (table1.C_UOM_ID = tableTRL1.C_UOM_ID and tableTRL1.AD_Language = ?)  left join (select AD_Client_ID, Name from AD_Client) table2 on (M_Transaction.AD_Client_ID = table2.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table3 on (M_Transaction.AD_Org_ID = table3.AD_Org_ID) left join (select M_AttributeSetInstance_ID, Description from M_AttributeSetInstance) table4 on (M_Transaction.M_AttributeSetInstance_ID = table4.M_AttributeSetInstance_ID) left join (select M_Locator_ID, Value from M_Locator) table5 on (M_Transaction.M_Locator_ID = table5.M_Locator_ID) left join ad_ref_list_v list1 on (M_Transaction.MovementType = list1.value and list1.ad_reference_id = '189' and list1.ad_language = ?)  left join (select M_Internal_Consumptionline_ID, M_Internal_Consumption_ID, M_Product_ID, MovementQty from M_Internal_Consumptionline) table6 on (M_Transaction.M_Internal_Consumptionline_ID = table6.M_Internal_Consumptionline_ID) left join (select M_Internal_Consumption_ID, Name from M_Internal_Consumption) table7 on (table6.M_Internal_Consumption_ID = table7.M_Internal_Consumption_ID) left join (select M_Product_ID, Value, Name from M_Product) table8 on (table6.M_Product_ID = table8.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL8 on (table8.M_Product_ID = tableTRL8.M_Product_ID and tableTRL8.AD_Language = ?)  left join (select M_InOutLine_ID, M_InOut_ID, M_Product_ID from M_InOutLine) table9 on (M_Transaction.M_InOutLine_ID = table9.M_InOutLine_ID) left join (select M_InOut_ID, DocumentNo, MovementDate from M_InOut) table10 on (table9.M_InOut_ID = table10.M_InOut_ID) left join (select M_Product_ID, Value, Name from M_Product) table11 on (table9.M_Product_ID = table11.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL11 on (table11.M_Product_ID = tableTRL11.M_Product_ID and tableTRL11.AD_Language = ?)  left join (select M_InventoryLine_ID, Line, QtyCount, M_Inventory_ID, Name from M_InventoryLine) table12 on (M_Transaction.M_InventoryLine_ID = table12.M_InventoryLine_ID) left join (select M_Inventory_ID, Name from M_Inventory) table13 on (table12.M_Inventory_ID = table13.M_Inventory_ID) left join (select M_MovementLine_ID, Line, MovementQty, M_Movement_ID from M_MovementLine) table14 on (M_Transaction.M_MovementLine_ID = table14.M_MovementLine_ID) left join (select M_Movement_ID, DocumentNo, Name from M_Movement) table15 on (table14.M_Movement_ID = table15.M_Movement_ID) left join (select C_Project_ID, Value, Name from C_Project) table16 on (M_Transaction.C_Project_ID = table16.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table17 on (M_Transaction.C_Projecttask_ID = table17.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table18 on (table17.C_Project_ID = table18.C_Project_ID) left join (select A_Asset_ID, Name from A_Asset) table19 on (M_Transaction.A_Asset_ID = table19.A_Asset_ID)" +
      "        WHERE 2=2 " +
      " AND M_TRANSACTION.M_Product_ID = ?" +
      "        AND 1=1 " +
      "        AND M_Transaction.M_Transaction_ID = ? " +
      "        AND M_Transaction.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND M_Transaction.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_PRODUCT_ID);
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
        TransactionsData objectTransactionsData = new TransactionsData();
        objectTransactionsData.created = UtilSql.getValue(result, "created");
        objectTransactionsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTransactionsData.updated = UtilSql.getValue(result, "updated");
        objectTransactionsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTransactionsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTransactionsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTransactionsData.cProjectissueId = UtilSql.getValue(result, "c_projectissue_id");
        objectTransactionsData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectTransactionsData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectTransactionsData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectTransactionsData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectTransactionsData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectTransactionsData.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectTransactionsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTransactionsData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectTransactionsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTransactionsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectTransactionsData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectTransactionsData.mAttributesetinstanceIdr = UtilSql.getValue(result, "m_attributesetinstance_idr");
        objectTransactionsData.isactive = UtilSql.getValue(result, "isactive");
        objectTransactionsData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectTransactionsData.mLocatorIdr = UtilSql.getValue(result, "m_locator_idr");
        objectTransactionsData.movementqty = UtilSql.getValue(result, "movementqty");
        objectTransactionsData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectTransactionsData.movementtype = UtilSql.getValue(result, "movementtype");
        objectTransactionsData.movementtyper = UtilSql.getValue(result, "movementtyper");
        objectTransactionsData.mInternalConsumptionlineId = UtilSql.getValue(result, "m_internal_consumptionline_id");
        objectTransactionsData.mInternalConsumptionlineIdr = UtilSql.getValue(result, "m_internal_consumptionline_idr");
        objectTransactionsData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectTransactionsData.mInoutlineIdr = UtilSql.getValue(result, "m_inoutline_idr");
        objectTransactionsData.mInventorylineId = UtilSql.getValue(result, "m_inventoryline_id");
        objectTransactionsData.mInventorylineIdr = UtilSql.getValue(result, "m_inventoryline_idr");
        objectTransactionsData.mMovementlineId = UtilSql.getValue(result, "m_movementline_id");
        objectTransactionsData.mMovementlineIdr = UtilSql.getValue(result, "m_movementline_idr");
        objectTransactionsData.mProductionlineId = UtilSql.getValue(result, "m_productionline_id");
        objectTransactionsData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectTransactionsData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectTransactionsData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectTransactionsData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectTransactionsData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectTransactionsData.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectTransactionsData.mTransactionId = UtilSql.getValue(result, "m_transaction_id");
        objectTransactionsData.language = UtilSql.getValue(result, "language");
        objectTransactionsData.adUserClient = "";
        objectTransactionsData.adOrgClient = "";
        objectTransactionsData.createdby = "";
        objectTransactionsData.trBgcolor = "";
        objectTransactionsData.totalCount = "";
        objectTransactionsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTransactionsData);
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
    TransactionsData objectTransactionsData[] = new TransactionsData[vector.size()];
    vector.copyInto(objectTransactionsData);
    return(objectTransactionsData);
  }

/**
Create a registry
 */
  public static TransactionsData[] set(String mInventorylineId, String mInternalConsumptionlineId, String cProjectId, String mProductUomId, String isactive, String mAttributesetinstanceId, String mAttributesetinstanceIdr, String adClientId, String movementqty, String cUomId, String cProjectissueId, String quantityorder, String cProjecttaskId, String mTransactionId, String movementtype, String adOrgId, String mInoutlineId, String mInoutlineIdr, String mLocatorId, String mLocatorIdr, String mMovementlineId, String createdby, String createdbyr, String cProjectphaseId, String updatedby, String updatedbyr, String mProductId, String mProductionlineId, String movementdate, String aAssetId)    throws ServletException {
    TransactionsData objectTransactionsData[] = new TransactionsData[1];
    objectTransactionsData[0] = new TransactionsData();
    objectTransactionsData[0].created = "";
    objectTransactionsData[0].createdbyr = createdbyr;
    objectTransactionsData[0].updated = "";
    objectTransactionsData[0].updatedTimeStamp = "";
    objectTransactionsData[0].updatedby = updatedby;
    objectTransactionsData[0].updatedbyr = updatedbyr;
    objectTransactionsData[0].cProjectissueId = cProjectissueId;
    objectTransactionsData[0].mProductUomId = mProductUomId;
    objectTransactionsData[0].mProductId = mProductId;
    objectTransactionsData[0].quantityorder = quantityorder;
    objectTransactionsData[0].cUomId = cUomId;
    objectTransactionsData[0].cUomIdr = "";
    objectTransactionsData[0].cProjectphaseId = cProjectphaseId;
    objectTransactionsData[0].adClientId = adClientId;
    objectTransactionsData[0].adClientIdr = "";
    objectTransactionsData[0].adOrgId = adOrgId;
    objectTransactionsData[0].adOrgIdr = "";
    objectTransactionsData[0].mAttributesetinstanceId = mAttributesetinstanceId;
    objectTransactionsData[0].mAttributesetinstanceIdr = mAttributesetinstanceIdr;
    objectTransactionsData[0].isactive = isactive;
    objectTransactionsData[0].mLocatorId = mLocatorId;
    objectTransactionsData[0].mLocatorIdr = mLocatorIdr;
    objectTransactionsData[0].movementqty = movementqty;
    objectTransactionsData[0].movementdate = movementdate;
    objectTransactionsData[0].movementtype = movementtype;
    objectTransactionsData[0].movementtyper = "";
    objectTransactionsData[0].mInternalConsumptionlineId = mInternalConsumptionlineId;
    objectTransactionsData[0].mInternalConsumptionlineIdr = "";
    objectTransactionsData[0].mInoutlineId = mInoutlineId;
    objectTransactionsData[0].mInoutlineIdr = mInoutlineIdr;
    objectTransactionsData[0].mInventorylineId = mInventorylineId;
    objectTransactionsData[0].mInventorylineIdr = "";
    objectTransactionsData[0].mMovementlineId = mMovementlineId;
    objectTransactionsData[0].mMovementlineIdr = "";
    objectTransactionsData[0].mProductionlineId = mProductionlineId;
    objectTransactionsData[0].cProjectId = cProjectId;
    objectTransactionsData[0].cProjectIdr = "";
    objectTransactionsData[0].cProjecttaskId = cProjecttaskId;
    objectTransactionsData[0].cProjecttaskIdr = "";
    objectTransactionsData[0].aAssetId = aAssetId;
    objectTransactionsData[0].aAssetIdr = "";
    objectTransactionsData[0].mTransactionId = mTransactionId;
    objectTransactionsData[0].language = "";
    return objectTransactionsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef9867_0(ConnectionProvider connectionProvider, String M_AttributeSetInstance_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Description), '') ) as M_AttributeSetInstance_ID FROM M_AttributeSetInstance table1 WHERE table1.isActive='Y' AND table1.M_AttributeSetInstance_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_AttributeSetInstance_IDR);

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
  public static String selectDef3673_1(ConnectionProvider connectionProvider, String M_InOutLine_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table2.DocumentNo), '')  || ' - ' || COALESCE(TO_CHAR(table2.MovementDate), '')  || ' - ' || COALESCE(TO_CHAR(table3.Value), '')  || ' - ' || COALESCE(TO_CHAR(table3.Name), '') ) as M_InOutLine_ID FROM M_InOutLine table1 left join M_InOut table2 on (table1.M_InOut_ID = table2.M_InOut_ID) left join M_Product table3 on (table1.M_Product_ID = table3.M_Product_ID) WHERE table1.isActive='Y' AND table1.M_InOutLine_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_InOutLine_IDR);

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
  public static String selectDef3667_2(ConnectionProvider connectionProvider, String M_Locator_IDR)    throws ServletException {
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
  public static String selectDef3663_3(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as CreatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

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
  public static String selectDef3665_4(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as UpdatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

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
      "        UPDATE M_Transaction" +
      "        SET C_ProjectIssue_ID = (?) , M_Product_Uom_Id = (?) , M_Product_ID = (?) , QuantityOrder = TO_NUMBER(?) , C_UOM_ID = (?) , C_Projectphase_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , M_AttributeSetInstance_ID = (?) , IsActive = (?) , M_Locator_ID = (?) , MovementQty = TO_NUMBER(?) , MovementDate = TO_DATE(?) , MovementType = (?) , M_Internal_Consumptionline_ID = (?) , M_InOutLine_ID = (?) , M_InventoryLine_ID = (?) , M_MovementLine_ID = (?) , M_ProductionLine_ID = (?) , C_Project_ID = (?) , C_Projecttask_ID = (?) , A_Asset_ID = (?) , M_Transaction_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE M_Transaction.M_Transaction_ID = ? " +
      "        AND M_Transaction.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_Transaction.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectissueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInventorylineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mMovementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mTransactionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mTransactionId);
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
      "        INSERT INTO M_Transaction " +
      "        (C_ProjectIssue_ID, M_Product_Uom_Id, M_Product_ID, QuantityOrder, C_UOM_ID, C_Projectphase_ID, AD_Client_ID, AD_Org_ID, M_AttributeSetInstance_ID, IsActive, M_Locator_ID, MovementQty, MovementDate, MovementType, M_Internal_Consumptionline_ID, M_InOutLine_ID, M_InventoryLine_ID, M_MovementLine_ID, M_ProductionLine_ID, C_Project_ID, C_Projecttask_ID, A_Asset_ID, M_Transaction_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectissueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInventorylineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mMovementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mTransactionId);
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
      "        DELETE FROM M_Transaction" +
      "        WHERE M_Transaction.M_Transaction_ID = ? " +
      "        AND M_Transaction.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_Transaction.AD_Org_ID IN (";
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
      "        DELETE FROM M_Transaction" +
      "        WHERE M_Transaction.M_Transaction_ID = ? ";

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
      "          FROM M_Transaction" +
      "         WHERE M_Transaction.M_Transaction_ID = ? ";

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
      "          FROM M_Transaction" +
      "         WHERE M_Transaction.M_Transaction_ID = ? ";

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
