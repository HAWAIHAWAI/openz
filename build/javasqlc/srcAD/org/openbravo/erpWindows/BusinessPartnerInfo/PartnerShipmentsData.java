//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.BusinessPartnerInfo;

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
class PartnerShipmentsData implements FieldProvider {
static Logger log4j = Logger.getLogger(PartnerShipmentsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgtrxId;
  public String dateprinted;
  public String mShipperId;
  public String freightcostrule;
  public String pickdate;
  public String trackingno;
  public String qty;
  public String shipdate;
  public String user2Id;
  public String user1Id;
  public String cCampaignId;
  public String cProjectId;
  public String adUserId;
  public String dateacct;
  public String docaction;
  public String posted;
  public String createfrom;
  public String generateto;
  public String chargeamt;
  public String dateordered;
  public String freightamt;
  public String cInvoiceId;
  public String deliveryviarule;
  public String processed;
  public String processing;
  public String priorityrule;
  public String cBpartnerLocationId;
  public String issotrx;
  public String deliveryrule;
  public String cChargeId;
  public String isactive;
  public String cActivityId;
  public String cBpartnerId;
  public String poreference;
  public String isprinted;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String documentno;
  public String docstatus;
  public String docstatusr;
  public String movementtype;
  public String movementtyper;
  public String movementdate;
  public String salesrepId;
  public String salesrepIdr;
  public String description;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String cOrderId;
  public String cOrderIdr;
  public String mInoutId;
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
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("dateprinted"))
      return dateprinted;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("freightcostrule"))
      return freightcostrule;
    else if (fieldName.equalsIgnoreCase("pickdate"))
      return pickdate;
    else if (fieldName.equalsIgnoreCase("trackingno"))
      return trackingno;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("shipdate"))
      return shipdate;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("createfrom"))
      return createfrom;
    else if (fieldName.equalsIgnoreCase("generateto"))
      return generateto;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("freightamt"))
      return freightamt;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("priorityrule"))
      return priorityrule;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("movementtype"))
      return movementtype;
    else if (fieldName.equalsIgnoreCase("movementtyper"))
      return movementtyper;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_order_idr") || fieldName.equals("cOrderIdr"))
      return cOrderIdr;
    else if (fieldName.equalsIgnoreCase("m_inout_id") || fieldName.equals("mInoutId"))
      return mInoutId;
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
  public static PartnerShipmentsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String C_BPartner_ID, String cBpartnerId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, C_BPartner_ID, cBpartnerId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PartnerShipmentsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String C_BPartner_ID, String cBpartnerId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_InOut.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_InOut.CreatedBy) as CreatedByR, " +
      "        to_char(M_InOut.Updated, ?) as updated, " +
      "        to_char(M_InOut.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_InOut.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_InOut.UpdatedBy) as UpdatedByR," +
      "        M_InOut.AD_OrgTrx_ID, " +
      "M_InOut.DatePrinted, " +
      "M_InOut.M_Shipper_ID, " +
      "M_InOut.FreightCostRule, " +
      "M_InOut.PickDate, " +
      "M_InOut.TrackingNo, " +
      "M_InOut.Qty, " +
      "M_InOut.ShipDate, " +
      "M_InOut.User2_ID, " +
      "M_InOut.User1_ID, " +
      "M_InOut.C_Campaign_ID, " +
      "M_InOut.C_Project_ID, " +
      "M_InOut.AD_User_ID, " +
      "M_InOut.DateAcct, " +
      "M_InOut.DocAction, " +
      "M_InOut.Posted, " +
      "M_InOut.CreateFrom, " +
      "M_InOut.GenerateTo, " +
      "M_InOut.ChargeAmt, " +
      "M_InOut.DateOrdered, " +
      "M_InOut.FreightAmt, " +
      "M_InOut.C_Invoice_ID, " +
      "M_InOut.DeliveryViaRule, " +
      "COALESCE(M_InOut.Processed, 'N') AS Processed, " +
      "COALESCE(M_InOut.Processing, 'N') AS Processing, " +
      "M_InOut.PriorityRule, " +
      "M_InOut.C_BPartner_Location_ID, " +
      "COALESCE(M_InOut.IsSOTrx, 'N') AS IsSOTrx, " +
      "M_InOut.DeliveryRule, " +
      "M_InOut.C_Charge_ID, " +
      "COALESCE(M_InOut.IsActive, 'N') AS IsActive, " +
      "M_InOut.C_Activity_ID, " +
      "M_InOut.C_BPartner_ID, " +
      "M_InOut.POReference, " +
      "COALESCE(M_InOut.IsPrinted, 'N') AS IsPrinted, " +
      "M_InOut.AD_Client_ID, " +
      "(CASE WHEN M_InOut.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "M_InOut.AD_Org_ID, " +
      "(CASE WHEN M_InOut.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "M_InOut.C_DocType_ID, " +
      "(CASE WHEN M_InOut.C_DocType_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_DocType_IDR, " +
      "M_InOut.DocumentNo, " +
      "M_InOut.DocStatus, " +
      "(CASE WHEN M_InOut.DocStatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DocStatusR, " +
      "M_InOut.MovementType, " +
      "(CASE WHEN M_InOut.MovementType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS MovementTypeR, " +
      "M_InOut.MovementDate, " +
      "M_InOut.SalesRep_ID, " +
      "(CASE WHEN M_InOut.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "M_InOut.Description, " +
      "M_InOut.M_Warehouse_ID, " +
      "(CASE WHEN M_InOut.M_Warehouse_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "M_InOut.C_Order_ID, " +
      "(CASE WHEN M_InOut.C_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table6.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.GrandTotal), ''))),'') ) END) AS C_Order_IDR, " +
      "M_InOut.M_InOut_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM M_InOut left join (select AD_Client_ID, Name from AD_Client) table1 on (M_InOut.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (M_InOut.AD_Org_ID = table2.AD_Org_ID) left join (select C_DocType_ID, Name from C_DocType) table3 on (M_InOut.C_DocType_ID =  table3.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL3 on (table3.C_DocType_ID = tableTRL3.C_DocType_ID and tableTRL3.AD_Language = ?)  left join ad_ref_list_v list1 on (M_InOut.DocStatus = list1.value and list1.ad_reference_id = '131' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (M_InOut.MovementType = list2.value and list2.ad_reference_id = '189' and list2.ad_language = ?)  left join (select AD_User_ID, Name from AD_User) table4 on (M_InOut.SalesRep_ID =  table4.AD_User_ID) left join (select M_Warehouse_ID, Name from M_Warehouse) table5 on (M_InOut.M_Warehouse_ID =  table5.M_Warehouse_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table6 on (M_InOut.C_Order_ID = table6.C_Order_ID)" +
      "        WHERE 2=2 " +
      " AND M_InOut.C_BPartner_ID=?" +
      "        AND 1=1 ";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND M_InOut.C_BPartner_ID = ?  ");
    strSql = strSql + 
      "        AND M_InOut.M_InOut_ID = ? " +
      "        AND M_InOut.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND M_InOut.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_ID);
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      }
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
        PartnerShipmentsData objectPartnerShipmentsData = new PartnerShipmentsData();
        objectPartnerShipmentsData.created = UtilSql.getValue(result, "created");
        objectPartnerShipmentsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPartnerShipmentsData.updated = UtilSql.getValue(result, "updated");
        objectPartnerShipmentsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPartnerShipmentsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPartnerShipmentsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPartnerShipmentsData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectPartnerShipmentsData.dateprinted = UtilSql.getDateValue(result, "dateprinted", "dd-MM-yyyy");
        objectPartnerShipmentsData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectPartnerShipmentsData.freightcostrule = UtilSql.getValue(result, "freightcostrule");
        objectPartnerShipmentsData.pickdate = UtilSql.getDateValue(result, "pickdate", "dd-MM-yyyy");
        objectPartnerShipmentsData.trackingno = UtilSql.getValue(result, "trackingno");
        objectPartnerShipmentsData.qty = UtilSql.getValue(result, "qty");
        objectPartnerShipmentsData.shipdate = UtilSql.getDateValue(result, "shipdate", "dd-MM-yyyy");
        objectPartnerShipmentsData.user2Id = UtilSql.getValue(result, "user2_id");
        objectPartnerShipmentsData.user1Id = UtilSql.getValue(result, "user1_id");
        objectPartnerShipmentsData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectPartnerShipmentsData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectPartnerShipmentsData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectPartnerShipmentsData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectPartnerShipmentsData.docaction = UtilSql.getValue(result, "docaction");
        objectPartnerShipmentsData.posted = UtilSql.getValue(result, "posted");
        objectPartnerShipmentsData.createfrom = UtilSql.getValue(result, "createfrom");
        objectPartnerShipmentsData.generateto = UtilSql.getValue(result, "generateto");
        objectPartnerShipmentsData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectPartnerShipmentsData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectPartnerShipmentsData.freightamt = UtilSql.getValue(result, "freightamt");
        objectPartnerShipmentsData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectPartnerShipmentsData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectPartnerShipmentsData.processed = UtilSql.getValue(result, "processed");
        objectPartnerShipmentsData.processing = UtilSql.getValue(result, "processing");
        objectPartnerShipmentsData.priorityrule = UtilSql.getValue(result, "priorityrule");
        objectPartnerShipmentsData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectPartnerShipmentsData.issotrx = UtilSql.getValue(result, "issotrx");
        objectPartnerShipmentsData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectPartnerShipmentsData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectPartnerShipmentsData.isactive = UtilSql.getValue(result, "isactive");
        objectPartnerShipmentsData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectPartnerShipmentsData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectPartnerShipmentsData.poreference = UtilSql.getValue(result, "poreference");
        objectPartnerShipmentsData.isprinted = UtilSql.getValue(result, "isprinted");
        objectPartnerShipmentsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPartnerShipmentsData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectPartnerShipmentsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPartnerShipmentsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPartnerShipmentsData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectPartnerShipmentsData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectPartnerShipmentsData.documentno = UtilSql.getValue(result, "documentno");
        objectPartnerShipmentsData.docstatus = UtilSql.getValue(result, "docstatus");
        objectPartnerShipmentsData.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectPartnerShipmentsData.movementtype = UtilSql.getValue(result, "movementtype");
        objectPartnerShipmentsData.movementtyper = UtilSql.getValue(result, "movementtyper");
        objectPartnerShipmentsData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectPartnerShipmentsData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectPartnerShipmentsData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectPartnerShipmentsData.description = UtilSql.getValue(result, "description");
        objectPartnerShipmentsData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectPartnerShipmentsData.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectPartnerShipmentsData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectPartnerShipmentsData.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectPartnerShipmentsData.mInoutId = UtilSql.getValue(result, "m_inout_id");
        objectPartnerShipmentsData.language = UtilSql.getValue(result, "language");
        objectPartnerShipmentsData.adUserClient = "";
        objectPartnerShipmentsData.adOrgClient = "";
        objectPartnerShipmentsData.createdby = "";
        objectPartnerShipmentsData.trBgcolor = "";
        objectPartnerShipmentsData.totalCount = "";
        objectPartnerShipmentsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPartnerShipmentsData);
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
    PartnerShipmentsData objectPartnerShipmentsData[] = new PartnerShipmentsData[vector.size()];
    vector.copyInto(objectPartnerShipmentsData);
    return(objectPartnerShipmentsData);
  }

/**
Create a registry
 */
  public static PartnerShipmentsData[] set(String cBpartnerId, String freightamt, String adClientId, String poreference, String user1Id, String docaction, String generateto, String movementtype, String cProjectId, String cCampaignId, String shipdate, String docstatus, String isprinted, String mShipperId, String dateacct, String priorityrule, String mInoutId, String createfrom, String cInvoiceId, String trackingno, String updatedby, String updatedbyr, String createdby, String createdbyr, String processed, String issotrx, String dateprinted, String freightcostrule, String mWarehouseId, String adOrgtrxId, String isactive, String salesrepId, String qty, String adOrgId, String cBpartnerLocationId, String cOrderId, String cOrderIdr, String deliveryrule, String user2Id, String dateordered, String processing, String cChargeId, String documentno, String chargeamt, String cActivityId, String cDoctypeId, String movementdate, String pickdate, String description, String posted, String deliveryviarule, String adUserId)    throws ServletException {
    PartnerShipmentsData objectPartnerShipmentsData[] = new PartnerShipmentsData[1];
    objectPartnerShipmentsData[0] = new PartnerShipmentsData();
    objectPartnerShipmentsData[0].created = "";
    objectPartnerShipmentsData[0].createdbyr = createdbyr;
    objectPartnerShipmentsData[0].updated = "";
    objectPartnerShipmentsData[0].updatedTimeStamp = "";
    objectPartnerShipmentsData[0].updatedby = updatedby;
    objectPartnerShipmentsData[0].updatedbyr = updatedbyr;
    objectPartnerShipmentsData[0].adOrgtrxId = adOrgtrxId;
    objectPartnerShipmentsData[0].dateprinted = dateprinted;
    objectPartnerShipmentsData[0].mShipperId = mShipperId;
    objectPartnerShipmentsData[0].freightcostrule = freightcostrule;
    objectPartnerShipmentsData[0].pickdate = pickdate;
    objectPartnerShipmentsData[0].trackingno = trackingno;
    objectPartnerShipmentsData[0].qty = qty;
    objectPartnerShipmentsData[0].shipdate = shipdate;
    objectPartnerShipmentsData[0].user2Id = user2Id;
    objectPartnerShipmentsData[0].user1Id = user1Id;
    objectPartnerShipmentsData[0].cCampaignId = cCampaignId;
    objectPartnerShipmentsData[0].cProjectId = cProjectId;
    objectPartnerShipmentsData[0].adUserId = adUserId;
    objectPartnerShipmentsData[0].dateacct = dateacct;
    objectPartnerShipmentsData[0].docaction = docaction;
    objectPartnerShipmentsData[0].posted = posted;
    objectPartnerShipmentsData[0].createfrom = createfrom;
    objectPartnerShipmentsData[0].generateto = generateto;
    objectPartnerShipmentsData[0].chargeamt = chargeamt;
    objectPartnerShipmentsData[0].dateordered = dateordered;
    objectPartnerShipmentsData[0].freightamt = freightamt;
    objectPartnerShipmentsData[0].cInvoiceId = cInvoiceId;
    objectPartnerShipmentsData[0].deliveryviarule = deliveryviarule;
    objectPartnerShipmentsData[0].processed = processed;
    objectPartnerShipmentsData[0].processing = processing;
    objectPartnerShipmentsData[0].priorityrule = priorityrule;
    objectPartnerShipmentsData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectPartnerShipmentsData[0].issotrx = issotrx;
    objectPartnerShipmentsData[0].deliveryrule = deliveryrule;
    objectPartnerShipmentsData[0].cChargeId = cChargeId;
    objectPartnerShipmentsData[0].isactive = isactive;
    objectPartnerShipmentsData[0].cActivityId = cActivityId;
    objectPartnerShipmentsData[0].cBpartnerId = cBpartnerId;
    objectPartnerShipmentsData[0].poreference = poreference;
    objectPartnerShipmentsData[0].isprinted = isprinted;
    objectPartnerShipmentsData[0].adClientId = adClientId;
    objectPartnerShipmentsData[0].adClientIdr = "";
    objectPartnerShipmentsData[0].adOrgId = adOrgId;
    objectPartnerShipmentsData[0].adOrgIdr = "";
    objectPartnerShipmentsData[0].cDoctypeId = cDoctypeId;
    objectPartnerShipmentsData[0].cDoctypeIdr = "";
    objectPartnerShipmentsData[0].documentno = documentno;
    objectPartnerShipmentsData[0].docstatus = docstatus;
    objectPartnerShipmentsData[0].docstatusr = "";
    objectPartnerShipmentsData[0].movementtype = movementtype;
    objectPartnerShipmentsData[0].movementtyper = "";
    objectPartnerShipmentsData[0].movementdate = movementdate;
    objectPartnerShipmentsData[0].salesrepId = salesrepId;
    objectPartnerShipmentsData[0].salesrepIdr = "";
    objectPartnerShipmentsData[0].description = description;
    objectPartnerShipmentsData[0].mWarehouseId = mWarehouseId;
    objectPartnerShipmentsData[0].mWarehouseIdr = "";
    objectPartnerShipmentsData[0].cOrderId = cOrderId;
    objectPartnerShipmentsData[0].cOrderIdr = cOrderIdr;
    objectPartnerShipmentsData[0].mInoutId = mInoutId;
    objectPartnerShipmentsData[0].language = "";
    return objectPartnerShipmentsData;
  }

/**
Select for auxiliar field
 */
  public static String selectActP154_M_PriceList_Version_ID(ConnectionProvider connectionProvider, String isSOTrx, String C_BPARTNER_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MIN(M_PRICELIST_VERSION_ID) AS TOTAL FROM M_PRICELIST_VERSION M, C_BPARTNER B WHERE M.M_PRICELIST_ID = (CASE ? WHEN 'Y' THEN B.M_PRICELIST_ID ELSE COALESCE(B.PO_PRICELIST_ID, B.M_PRICELIST_ID) END) AND M.ISACTIVE = 'Y' AND B.C_BPARTNER_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isSOTrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPARTNER_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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
  public static String selectDef3528_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef3526_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef3809_2(ConnectionProvider connectionProvider, String C_Order_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.DocumentNo), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '')  || ' - ' || COALESCE(TO_CHAR(table1.DateOrdered), '')  || ' - ' || COALESCE(TO_CHAR(table1.GrandTotal), '') ) as C_Order_ID FROM C_Order table1 WHERE table1.isActive='Y' AND table1.C_Order_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Order_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_order_id");
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_InOut.C_BPartner_ID AS NAME" +
      "        FROM M_InOut" +
      "        WHERE M_InOut.M_InOut_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
Select for parent field
 */
  public static String selectParent(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_BPartner left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_BPartner.C_BPartner_ID = table1.C_BPartner_ID) WHERE C_BPartner.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
Select for parent field
 */
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_BPartner left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_BPartner.C_BPartner_ID = table1.C_BPartner_ID) WHERE C_BPartner.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
      "        UPDATE M_InOut" +
      "        SET AD_OrgTrx_ID = (?) , DatePrinted = TO_DATE(?) , M_Shipper_ID = (?) , FreightCostRule = (?) , PickDate = TO_DATE(?) , TrackingNo = (?) , Qty = TO_NUMBER(?) , ShipDate = TO_DATE(?) , User2_ID = (?) , User1_ID = (?) , C_Campaign_ID = (?) , C_Project_ID = (?) , AD_User_ID = (?) , DateAcct = TO_DATE(?) , DocAction = (?) , Posted = (?) , CreateFrom = (?) , GenerateTo = (?) , ChargeAmt = TO_NUMBER(?) , DateOrdered = TO_DATE(?) , FreightAmt = TO_NUMBER(?) , C_Invoice_ID = (?) , DeliveryViaRule = (?) , Processed = (?) , Processing = (?) , PriorityRule = (?) , C_BPartner_Location_ID = (?) , IsSOTrx = (?) , DeliveryRule = (?) , C_Charge_ID = (?) , IsActive = (?) , C_Activity_ID = (?) , C_BPartner_ID = (?) , POReference = (?) , IsPrinted = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_DocType_ID = (?) , DocumentNo = (?) , DocStatus = (?) , MovementType = (?) , MovementDate = TO_DATE(?) , SalesRep_ID = (?) , Description = (?) , M_Warehouse_ID = (?) , C_Order_ID = (?) , M_InOut_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE M_InOut.M_InOut_ID = ? " +
      "                 AND M_InOut.C_BPartner_ID = ? " +
      "        AND M_InOut.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_InOut.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pickdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, trackingno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priorityrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
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
      "        INSERT INTO M_InOut " +
      "        (AD_OrgTrx_ID, DatePrinted, M_Shipper_ID, FreightCostRule, PickDate, TrackingNo, Qty, ShipDate, User2_ID, User1_ID, C_Campaign_ID, C_Project_ID, AD_User_ID, DateAcct, DocAction, Posted, CreateFrom, GenerateTo, ChargeAmt, DateOrdered, FreightAmt, C_Invoice_ID, DeliveryViaRule, Processed, Processing, PriorityRule, C_BPartner_Location_ID, IsSOTrx, DeliveryRule, C_Charge_ID, IsActive, C_Activity_ID, C_BPartner_ID, POReference, IsPrinted, AD_Client_ID, AD_Org_ID, C_DocType_ID, DocumentNo, DocStatus, MovementType, MovementDate, SalesRep_ID, Description, M_Warehouse_ID, C_Order_ID, M_InOut_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), TO_DATE(?), (?), (?), TO_DATE(?), (?), TO_NUMBER(?), TO_DATE(?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), TO_NUMBER(?), TO_DATE(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pickdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, trackingno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priorityrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cBpartnerId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM M_InOut" +
      "        WHERE M_InOut.M_InOut_ID = ? " +
      "                 AND M_InOut.C_BPartner_ID = ? " +
      "        AND M_InOut.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_InOut.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM M_InOut" +
      "        WHERE M_InOut.M_InOut_ID = ? " +
      "                 AND M_InOut.C_BPartner_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
      "          FROM M_InOut" +
      "         WHERE M_InOut.M_InOut_ID = ? ";

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
      "          FROM M_InOut" +
      "         WHERE M_InOut.M_InOut_ID = ? ";

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
