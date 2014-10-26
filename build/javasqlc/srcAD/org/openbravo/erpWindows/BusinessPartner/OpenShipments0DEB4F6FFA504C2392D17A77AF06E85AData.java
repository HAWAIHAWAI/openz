//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.BusinessPartner;

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
class OpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData implements FieldProvider {
static Logger log4j = Logger.getLogger(OpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String mProductId;
  public String mProductIdr;
  public String qtyordered;
  public String qtydelivered;
  public String qtyreserved;
  public String qtyinvoiced;
  public String cUomId;
  public String cUomIdr;
  public String documentno;
  public String cOrderId;
  public String cOrderIdr;
  public String zssiOpenshipmentId;
  public String zssiOpenshipmentIdr;
  public String salesrepId;
  public String salesrepIdr;
  public String scheddeliverydate;
  public String dateordered;
  public String datepromised;
  public String description;
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
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("qtydelivered"))
      return qtydelivered;
    else if (fieldName.equalsIgnoreCase("qtyreserved"))
      return qtyreserved;
    else if (fieldName.equalsIgnoreCase("qtyinvoiced"))
      return qtyinvoiced;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_order_idr") || fieldName.equals("cOrderIdr"))
      return cOrderIdr;
    else if (fieldName.equalsIgnoreCase("zssi_openshipment_id") || fieldName.equals("zssiOpenshipmentId"))
      return zssiOpenshipmentId;
    else if (fieldName.equalsIgnoreCase("zssi_openshipment_idr") || fieldName.equals("zssiOpenshipmentIdr"))
      return zssiOpenshipmentIdr;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("scheddeliverydate"))
      return scheddeliverydate;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
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
  public static OpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cBpartnerId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static OpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_openshipment.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_openshipment.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_openshipment.Updated, ?) as updated, " +
      "        to_char(zssi_openshipment.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_openshipment.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_openshipment.UpdatedBy) as UpdatedByR," +
      "        zssi_openshipment.AD_Client_ID, " +
      "(CASE WHEN zssi_openshipment.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "zssi_openshipment.AD_Org_ID, " +
      "(CASE WHEN zssi_openshipment.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zssi_openshipment.C_Bpartner_ID, " +
      "(CASE WHEN zssi_openshipment.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "zssi_openshipment.M_Product_ID, " +
      "(CASE WHEN zssi_openshipment.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "zssi_openshipment.Qtyordered, " +
      "zssi_openshipment.Qtydelivered, " +
      "zssi_openshipment.Qtyreserved, " +
      "zssi_openshipment.Qtyinvoiced, " +
      "zssi_openshipment.C_Uom_ID, " +
      "(CASE WHEN zssi_openshipment.C_Uom_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS C_Uom_IDR, " +
      "zssi_openshipment.Documentno, " +
      "zssi_openshipment.C_Order_ID, " +
      "(CASE WHEN zssi_openshipment.C_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table6.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.GrandTotal), ''))),'') ) END) AS C_Order_IDR, " +
      "zssi_openshipment.Zssi_Openshipment_ID, " +
      "(CASE WHEN zssi_openshipment.Zssi_Openshipment_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table8.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.GrandTotal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.LineNetAmt), ''))),'') ) END) AS Zssi_Openshipment_IDR, " +
      "zssi_openshipment.SalesRep_ID, " +
      "(CASE WHEN zssi_openshipment.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "zssi_openshipment.Scheddeliverydate, " +
      "zssi_openshipment.Dateordered, " +
      "zssi_openshipment.Datepromised, " +
      "zssi_openshipment.Description, " +
      "COALESCE(zssi_openshipment.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_openshipment left join (select AD_Client_ID, Name from AD_Client) table1 on (zssi_openshipment.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (zssi_openshipment.AD_Org_ID = table2.AD_Org_ID) left join (select C_BPartner_ID, Name from C_BPartner) table3 on (zssi_openshipment.C_Bpartner_ID = table3.C_BPartner_ID) left join (select M_Product_ID, Value, Name from M_Product) table4 on (zssi_openshipment.M_Product_ID = table4.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL4 on (table4.M_Product_ID = tableTRL4.M_Product_ID and tableTRL4.AD_Language = ?)  left join (select C_Uom_ID, Name from C_Uom) table5 on (zssi_openshipment.C_Uom_ID = table5.C_Uom_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL5 on (table5.C_UOM_ID = tableTRL5.C_UOM_ID and tableTRL5.AD_Language = ?)  left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table6 on (zssi_openshipment.C_Order_ID = table6.C_Order_ID) left join (select C_OrderLine_ID, C_Order_ID, Line, LineNetAmt from C_OrderLine) table7 on (zssi_openshipment.Zssi_Openshipment_ID = table7.C_OrderLine_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table8 on (table7.C_Order_ID = table8.C_Order_ID) left join (select AD_User_ID, Name from AD_User) table9 on (zssi_openshipment.SalesRep_ID =  table9.AD_User_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND zssi_openshipment.C_Bpartner_ID = ?  ");
    strSql = strSql + 
      "        AND zssi_openshipment.Zssi_Openshipment_ID = ? " +
      "        AND zssi_openshipment.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_openshipment.AD_Org_ID IN (";
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
        OpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData = new OpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData();
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.created = UtilSql.getValue(result, "created");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.updated = UtilSql.getValue(result, "updated");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.updatedby = UtilSql.getValue(result, "updatedby");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.qtydelivered = UtilSql.getValue(result, "qtydelivered");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.qtyreserved = UtilSql.getValue(result, "qtyreserved");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.documentno = UtilSql.getValue(result, "documentno");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.zssiOpenshipmentId = UtilSql.getValue(result, "zssi_openshipment_id");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.zssiOpenshipmentIdr = UtilSql.getValue(result, "zssi_openshipment_idr");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.scheddeliverydate = UtilSql.getDateValue(result, "scheddeliverydate", "dd-MM-yyyy");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.description = UtilSql.getValue(result, "description");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.isactive = UtilSql.getValue(result, "isactive");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.language = UtilSql.getValue(result, "language");
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.adUserClient = "";
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.adOrgClient = "";
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.createdby = "";
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.trBgcolor = "";
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.totalCount = "";
        objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData);
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
    OpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[] = new OpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[vector.size()];
    vector.copyInto(objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData);
    return(objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData);
  }

/**
Create a registry
 */
  public static OpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[] set(String cBpartnerId, String description, String qtydelivered, String cUomId, String qtyordered, String qtyinvoiced, String cOrderId, String mProductId, String mProductIdr, String cBpartnerIdr, String zssiOpenshipmentId, String zssiOpenshipmentIdr, String dateordered, String documentno, String salesrepId, String updatedby, String updatedbyr, String datepromised, String isactive, String adClientId, String adOrgId, String scheddeliverydate, String createdby, String createdbyr, String qtyreserved)    throws ServletException {
    OpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[] = new OpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[1];
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0] = new OpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData();
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].created = "";
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].createdbyr = createdbyr;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].updated = "";
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].updatedTimeStamp = "";
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].updatedby = updatedby;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].updatedbyr = updatedbyr;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].adClientId = adClientId;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].adClientIdr = "";
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].adOrgId = adOrgId;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].adOrgIdr = "";
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].cBpartnerId = cBpartnerId;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].cBpartnerIdr = cBpartnerIdr;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].mProductId = mProductId;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].mProductIdr = mProductIdr;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].qtyordered = qtyordered;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].qtydelivered = qtydelivered;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].qtyreserved = qtyreserved;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].qtyinvoiced = qtyinvoiced;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].cUomId = cUomId;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].cUomIdr = "";
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].documentno = documentno;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].cOrderId = cOrderId;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].cOrderIdr = "";
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].zssiOpenshipmentId = zssiOpenshipmentId;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].zssiOpenshipmentIdr = zssiOpenshipmentIdr;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].salesrepId = salesrepId;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].salesrepIdr = "";
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].scheddeliverydate = scheddeliverydate;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].dateordered = dateordered;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].datepromised = datepromised;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].description = description;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].isactive = isactive;
    objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData[0].language = "";
    return objectOpenShipments0DEB4F6FFA504C2392D17A77AF06E85AData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef864D7E94D1324D1FB3ABEBE5A1318660_0(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef2E5D3C755ABA479A8F2C83278E5EA41B_1(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
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
  public static String selectDef457FE8F46C21417F8926E011B54CB676_2(ConnectionProvider connectionProvider, String Zssi_Openshipment_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table2.DocumentNo), '')  || ' - ' || COALESCE(TO_CHAR(table2.Name), '')  || ' - ' || COALESCE(TO_CHAR(table2.DateOrdered), '')  || ' - ' || COALESCE(TO_CHAR(table2.GrandTotal), '')  || ' - ' || COALESCE(TO_CHAR(table1.Line), '')  || ' - ' || COALESCE(TO_CHAR(table1.LineNetAmt), '') ) as Zssi_Openshipment_ID FROM C_OrderLine table1 left join C_Order table2 on (table1.C_Order_ID = table2.C_Order_ID) WHERE table1.isActive='Y' AND table1.C_OrderLine_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Zssi_Openshipment_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zssi_openshipment_id");
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
  public static String selectDef76F388667AF44F80A269285C512318D2_3(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefC55FDBC1AC4F40B990488377703B80A6_4(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zssi_openshipment.C_Bpartner_ID AS NAME" +
      "        FROM zssi_openshipment" +
      "        WHERE zssi_openshipment.Zssi_Openshipment_ID = ?";

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
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_BPartner left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_BPartner.C_Bpartner_ID = table1.C_BPartner_ID) WHERE C_BPartner.C_Bpartner_ID = ?  ";

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
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_BPartner left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_BPartner.C_Bpartner_ID = table1.C_BPartner_ID) WHERE C_BPartner.C_Bpartner_ID = ?  ";

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
      "        UPDATE zssi_openshipment" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , C_Bpartner_ID = (?) , M_Product_ID = (?) , Qtyordered = TO_NUMBER(?) , Qtydelivered = TO_NUMBER(?) , Qtyreserved = TO_NUMBER(?) , Qtyinvoiced = TO_NUMBER(?) , C_Uom_ID = (?) , Documentno = (?) , C_Order_ID = (?) , Zssi_Openshipment_ID = (?) , SalesRep_ID = (?) , Scheddeliverydate = TO_DATE(?) , Dateordered = TO_DATE(?) , Datepromised = TO_DATE(?) , Description = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_openshipment.Zssi_Openshipment_ID = ? " +
      "                 AND zssi_openshipment.C_Bpartner_ID = ? " +
      "        AND zssi_openshipment.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_openshipment.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtydelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreserved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOpenshipmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOpenshipmentId);
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
      "        INSERT INTO zssi_openshipment " +
      "        (AD_Client_ID, AD_Org_ID, C_Bpartner_ID, M_Product_ID, Qtyordered, Qtydelivered, Qtyreserved, Qtyinvoiced, C_Uom_ID, Documentno, C_Order_ID, Zssi_Openshipment_ID, SalesRep_ID, Scheddeliverydate, Dateordered, Datepromised, Description, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtydelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreserved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOpenshipmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cBpartnerId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_openshipment" +
      "        WHERE zssi_openshipment.Zssi_Openshipment_ID = ? " +
      "                 AND zssi_openshipment.C_Bpartner_ID = ? " +
      "        AND zssi_openshipment.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_openshipment.AD_Org_ID IN (";
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
      "        DELETE FROM zssi_openshipment" +
      "        WHERE zssi_openshipment.Zssi_Openshipment_ID = ? " +
      "                 AND zssi_openshipment.C_Bpartner_ID = ? ";

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
      "          FROM zssi_openshipment" +
      "         WHERE zssi_openshipment.Zssi_Openshipment_ID = ? ";

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
      "          FROM zssi_openshipment" +
      "         WHERE zssi_openshipment.Zssi_Openshipment_ID = ? ";

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
