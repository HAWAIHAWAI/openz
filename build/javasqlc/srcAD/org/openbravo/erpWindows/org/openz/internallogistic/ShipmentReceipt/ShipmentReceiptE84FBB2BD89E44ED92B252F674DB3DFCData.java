//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openz.internallogistic.ShipmentReceipt;

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
class ShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData implements FieldProvider {
static Logger log4j = Logger.getLogger(ShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cProjectId;
  public String adOrgId;
  public String adOrgIdr;
  public String documentno;
  public String islogistic;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String movementdate;
  public String mShipperId;
  public String mShipperIdr;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String docstatus;
  public String docstatusr;
  public String movementtype;
  public String movementtyper;
  public String docaction;
  public String docactionBtn;
  public String aAssetId;
  public String cProjecttaskId;
  public String ilsInoutVId;
  public String description;
  public String processing;
  public String processed;
  public String isactive;
  public String cOrderId;
  public String adClientId;
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
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("islogistic"))
      return islogistic;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
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
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("movementtype"))
      return movementtype;
    else if (fieldName.equalsIgnoreCase("movementtyper"))
      return movementtyper;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("docaction_btn") || fieldName.equals("docactionBtn"))
      return docactionBtn;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("ils_inout_v_id") || fieldName.equals("ilsInoutVId"))
      return ilsInoutVId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
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
  public static ShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ils_inout_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ils_inout_v.CreatedBy) as CreatedByR, " +
      "        to_char(ils_inout_v.Updated, ?) as updated, " +
      "        to_char(ils_inout_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ils_inout_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ils_inout_v.UpdatedBy) as UpdatedByR," +
      "        ils_inout_v.C_Project_ID, " +
      "ils_inout_v.AD_Org_ID, " +
      "(CASE WHEN ils_inout_v.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "ils_inout_v.DocumentNo, " +
      "COALESCE(ils_inout_v.Islogistic, 'N') AS Islogistic, " +
      "ils_inout_v.C_DocType_ID, " +
      "(CASE WHEN ils_inout_v.C_DocType_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS C_DocType_IDR, " +
      "ils_inout_v.MovementDate, " +
      "ils_inout_v.M_Shipper_ID, " +
      "(CASE WHEN ils_inout_v.M_Shipper_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS M_Shipper_IDR, " +
      "ils_inout_v.M_Warehouse_ID, " +
      "(CASE WHEN ils_inout_v.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "ils_inout_v.DocStatus, " +
      "(CASE WHEN ils_inout_v.DocStatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DocStatusR, " +
      "ils_inout_v.MovementType, " +
      "(CASE WHEN ils_inout_v.MovementType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS MovementTypeR, " +
      "ils_inout_v.DocAction, " +
      "list3.name as DocAction_BTN, " +
      "ils_inout_v.A_Asset_ID, " +
      "ils_inout_v.C_Projecttask_ID, " +
      "ils_inout_v.ILS_Inout_V_ID, " +
      "ils_inout_v.Description, " +
      "COALESCE(ils_inout_v.Processing, 'N') AS Processing, " +
      "COALESCE(ils_inout_v.Processed, 'N') AS Processed, " +
      "COALESCE(ils_inout_v.IsActive, 'N') AS IsActive, " +
      "ils_inout_v.C_Order_ID, " +
      "ils_inout_v.AD_Client_ID, " +
      "COALESCE(ils_inout_v.IsSOTrx, 'N') AS IsSOTrx, " +
      "        ? AS LANGUAGE " +
      "        FROM ils_inout_v left join (select AD_Org_ID, Name from AD_Org) table1 on (ils_inout_v.AD_Org_ID = table1.AD_Org_ID) left join (select C_DocType_ID, Name from C_DocType) table2 on (ils_inout_v.C_DocType_ID =  table2.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL2 on (table2.C_DocType_ID = tableTRL2.C_DocType_ID and tableTRL2.AD_Language = ?)  left join (select M_Shipper_ID, Name from M_Shipper) table3 on (ils_inout_v.M_Shipper_ID = table3.M_Shipper_ID) left join (select M_Warehouse_ID, Name from M_Warehouse) table4 on (ils_inout_v.M_Warehouse_ID = table4.M_Warehouse_ID) left join ad_ref_list_v list1 on (ils_inout_v.DocStatus = list1.value and list1.ad_reference_id = '131' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (ils_inout_v.MovementType = list2.value and list2.ad_reference_id = '189' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (list3.ad_reference_id = '135' and list3.ad_language = ?  AND (CASE ils_inout_v.DocAction WHEN '--' THEN 'CL' ELSE TO_CHAR(ils_inout_v.DocAction) END) = list3.value)" +
      "        WHERE 2=2 " +
      " AND ils_InOut_v.MovementType IN ('V-', 'V+')  and ils_InOut_v.islogistic='Y'" +
      "        AND 1=1 " +
      "        AND ils_inout_v.ILS_Inout_V_ID = ? " +
      "        AND ils_inout_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ils_inout_v.AD_Org_ID IN (";
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
        ShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData = new ShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData();
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.created = UtilSql.getValue(result, "created");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.updated = UtilSql.getValue(result, "updated");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.updatedby = UtilSql.getValue(result, "updatedby");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.documentno = UtilSql.getValue(result, "documentno");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.islogistic = UtilSql.getValue(result, "islogistic");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.mShipperIdr = UtilSql.getValue(result, "m_shipper_idr");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.docstatus = UtilSql.getValue(result, "docstatus");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.movementtype = UtilSql.getValue(result, "movementtype");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.movementtyper = UtilSql.getValue(result, "movementtyper");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.docaction = UtilSql.getValue(result, "docaction");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.docactionBtn = UtilSql.getValue(result, "docaction_btn");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.ilsInoutVId = UtilSql.getValue(result, "ils_inout_v_id");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.description = UtilSql.getValue(result, "description");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.processing = UtilSql.getValue(result, "processing");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.processed = UtilSql.getValue(result, "processed");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.isactive = UtilSql.getValue(result, "isactive");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.issotrx = UtilSql.getValue(result, "issotrx");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.language = UtilSql.getValue(result, "language");
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.adUserClient = "";
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.adOrgClient = "";
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.createdby = "";
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.trBgcolor = "";
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.totalCount = "";
        objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData);
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
    ShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[] = new ShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[vector.size()];
    vector.copyInto(objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData);
    return(objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData);
  }

/**
Create a registry
 */
  public static ShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[] set(String description, String adOrgId, String islogistic, String mWarehouseId, String docstatus, String processing, String issotrx, String isactive, String cDoctypeId, String docaction, String docactionBtn, String updatedby, String updatedbyr, String processed, String mShipperId, String cProjecttaskId, String ilsInoutVId, String createdby, String createdbyr, String movementtype, String aAssetId, String cProjectId, String adClientId, String documentno, String movementdate, String cOrderId)    throws ServletException {
    ShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[] = new ShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[1];
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0] = new ShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData();
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].created = "";
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].createdbyr = createdbyr;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].updated = "";
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].updatedTimeStamp = "";
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].updatedby = updatedby;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].updatedbyr = updatedbyr;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].cProjectId = cProjectId;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].adOrgId = adOrgId;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].adOrgIdr = "";
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].documentno = documentno;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].islogistic = islogistic;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].cDoctypeId = cDoctypeId;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].cDoctypeIdr = "";
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].movementdate = movementdate;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].mShipperId = mShipperId;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].mShipperIdr = "";
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].mWarehouseId = mWarehouseId;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].mWarehouseIdr = "";
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].docstatus = docstatus;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].docstatusr = "";
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].movementtype = movementtype;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].movementtyper = "";
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].docaction = docaction;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].docactionBtn = docactionBtn;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].aAssetId = aAssetId;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].cProjecttaskId = cProjecttaskId;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].ilsInoutVId = ilsInoutVId;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].description = description;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].processing = processing;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].processed = processed;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].isactive = isactive;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].cOrderId = cOrderId;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].adClientId = adClientId;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].issotrx = issotrx;
    objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData[0].language = "";
    return objectShipmentReceiptE84FBB2BD89E44ED92B252F674DB3DFCData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef7623C03A34134B33B9A974C37FDFD7CC_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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

/**
Select for auxiliar field
 */
  public static String selectDef18C049F2261945D0848F61E6DF7A8CBD_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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

  public static int updateDocAction(ConnectionProvider connectionProvider, String docaction, String ilsInoutVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE ils_inout_v" +
      "        SET docaction = ? " +
      "        WHERE ils_inout_v.ILS_Inout_V_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutVId);

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
      "        UPDATE ils_inout_v" +
      "        SET C_Project_ID = (?) , AD_Org_ID = (?) , DocumentNo = (?) , Islogistic = (?) , C_DocType_ID = (?) , MovementDate = TO_DATE(?) , M_Shipper_ID = (?) , M_Warehouse_ID = (?) , DocStatus = (?) , MovementType = (?) , DocAction = (?) , A_Asset_ID = (?) , C_Projecttask_ID = (?) , ILS_Inout_V_ID = (?) , Description = (?) , Processing = (?) , Processed = (?) , IsActive = (?) , C_Order_ID = (?) , AD_Client_ID = (?) , IsSOTrx = (?) , updated = now(), updatedby = ? " +
      "        WHERE ils_inout_v.ILS_Inout_V_ID = ? " +
      "        AND ils_inout_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ils_inout_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islogistic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutVId);
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
      "        INSERT INTO ils_inout_v " +
      "        (C_Project_ID, AD_Org_ID, DocumentNo, Islogistic, C_DocType_ID, MovementDate, M_Shipper_ID, M_Warehouse_ID, DocStatus, MovementType, DocAction, A_Asset_ID, C_Projecttask_ID, ILS_Inout_V_ID, Description, Processing, Processed, IsActive, C_Order_ID, AD_Client_ID, IsSOTrx, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islogistic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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
      "        DELETE FROM ils_inout_v" +
      "        WHERE ils_inout_v.ILS_Inout_V_ID = ? " +
      "        AND ils_inout_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ils_inout_v.AD_Org_ID IN (";
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
      "        DELETE FROM ils_inout_v" +
      "        WHERE ils_inout_v.ILS_Inout_V_ID = ? ";

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
      "          FROM ils_inout_v" +
      "         WHERE ils_inout_v.ILS_Inout_V_ID = ? ";

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
      "          FROM ils_inout_v" +
      "         WHERE ils_inout_v.ILS_Inout_V_ID = ? ";

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
