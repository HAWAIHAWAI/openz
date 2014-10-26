//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.OpenShipments;

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
class OpenShipments7F13ED1875034B8083B1F4AD3F215C27Data implements FieldProvider {
static Logger log4j = Logger.getLogger(OpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.class);
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
  public String salesrepId;
  public String salesrepIdr;
  public String scheddeliverydate;
  public String dateordered;
  public String datepromised;
  public String description;
  public String zssiOpenshipmentId;
  public String zssiOpenshipmentIdr;
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
    else if (fieldName.equalsIgnoreCase("zssi_openshipment_id") || fieldName.equals("zssiOpenshipmentId"))
      return zssiOpenshipmentId;
    else if (fieldName.equalsIgnoreCase("zssi_openshipment_idr") || fieldName.equals("zssiOpenshipmentIdr"))
      return zssiOpenshipmentIdr;
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
  public static OpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static OpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
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
      "zssi_openshipment.SalesRep_ID, " +
      "(CASE WHEN zssi_openshipment.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "zssi_openshipment.Scheddeliverydate, " +
      "zssi_openshipment.Dateordered, " +
      "zssi_openshipment.Datepromised, " +
      "zssi_openshipment.Description, " +
      "zssi_openshipment.Zssi_Openshipment_ID, " +
      "(CASE WHEN zssi_openshipment.Zssi_Openshipment_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table9.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.GrandTotal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.LineNetAmt), ''))),'') ) END) AS Zssi_Openshipment_IDR, " +
      "COALESCE(zssi_openshipment.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_openshipment left join (select AD_Client_ID, Name from AD_Client) table1 on (zssi_openshipment.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (zssi_openshipment.AD_Org_ID = table2.AD_Org_ID) left join (select C_BPartner_ID, Name from C_BPartner) table3 on (zssi_openshipment.C_Bpartner_ID = table3.C_BPartner_ID) left join (select M_Product_ID, Value, Name from M_Product) table4 on (zssi_openshipment.M_Product_ID = table4.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL4 on (table4.M_Product_ID = tableTRL4.M_Product_ID and tableTRL4.AD_Language = ?)  left join (select C_Uom_ID, Name from C_Uom) table5 on (zssi_openshipment.C_Uom_ID = table5.C_Uom_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL5 on (table5.C_UOM_ID = tableTRL5.C_UOM_ID and tableTRL5.AD_Language = ?)  left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table6 on (zssi_openshipment.C_Order_ID = table6.C_Order_ID) left join (select AD_User_ID, Name from AD_User) table7 on (zssi_openshipment.SalesRep_ID =  table7.AD_User_ID) left join (select C_OrderLine_ID, C_Order_ID, Line, LineNetAmt from C_OrderLine) table8 on (zssi_openshipment.Zssi_Openshipment_ID = table8.C_OrderLine_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table9 on (table8.C_Order_ID = table9.C_Order_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
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
        OpenShipments7F13ED1875034B8083B1F4AD3F215C27Data objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data = new OpenShipments7F13ED1875034B8083B1F4AD3F215C27Data();
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.created = UtilSql.getValue(result, "created");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.updated = UtilSql.getValue(result, "updated");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.qtydelivered = UtilSql.getValue(result, "qtydelivered");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.qtyreserved = UtilSql.getValue(result, "qtyreserved");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.documentno = UtilSql.getValue(result, "documentno");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.scheddeliverydate = UtilSql.getDateValue(result, "scheddeliverydate", "dd-MM-yyyy");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.description = UtilSql.getValue(result, "description");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.zssiOpenshipmentId = UtilSql.getValue(result, "zssi_openshipment_id");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.zssiOpenshipmentIdr = UtilSql.getValue(result, "zssi_openshipment_idr");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.isactive = UtilSql.getValue(result, "isactive");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.language = UtilSql.getValue(result, "language");
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.adUserClient = "";
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.adOrgClient = "";
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.createdby = "";
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.trBgcolor = "";
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.totalCount = "";
        objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data);
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
    OpenShipments7F13ED1875034B8083B1F4AD3F215C27Data objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[] = new OpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[vector.size()];
    vector.copyInto(objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data);
    return(objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data);
  }

/**
Create a registry
 */
  public static OpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[] set(String description, String qtydelivered, String qtyordered, String cUomId, String qtyinvoiced, String mProductId, String mProductIdr, String cOrderId, String zssiOpenshipmentId, String zssiOpenshipmentIdr, String cBpartnerId, String cBpartnerIdr, String dateordered, String documentno, String salesrepId, String updatedby, String updatedbyr, String datepromised, String isactive, String scheddeliverydate, String adOrgId, String adClientId, String createdby, String createdbyr, String qtyreserved)    throws ServletException {
    OpenShipments7F13ED1875034B8083B1F4AD3F215C27Data objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[] = new OpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[1];
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0] = new OpenShipments7F13ED1875034B8083B1F4AD3F215C27Data();
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].created = "";
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].createdbyr = createdbyr;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].updated = "";
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].updatedTimeStamp = "";
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].updatedby = updatedby;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].updatedbyr = updatedbyr;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].adClientId = adClientId;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].adClientIdr = "";
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].adOrgId = adOrgId;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].adOrgIdr = "";
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].cBpartnerId = cBpartnerId;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].cBpartnerIdr = cBpartnerIdr;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].mProductId = mProductId;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].mProductIdr = mProductIdr;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].qtyordered = qtyordered;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].qtydelivered = qtydelivered;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].qtyreserved = qtyreserved;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].qtyinvoiced = qtyinvoiced;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].cUomId = cUomId;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].cUomIdr = "";
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].documentno = documentno;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].cOrderId = cOrderId;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].cOrderIdr = "";
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].salesrepId = salesrepId;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].salesrepIdr = "";
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].scheddeliverydate = scheddeliverydate;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].dateordered = dateordered;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].datepromised = datepromised;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].description = description;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].zssiOpenshipmentId = zssiOpenshipmentId;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].zssiOpenshipmentIdr = zssiOpenshipmentIdr;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].isactive = isactive;
    objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data[0].language = "";
    return objectOpenShipments7F13ED1875034B8083B1F4AD3F215C27Data;
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
  public static String selectDef457FE8F46C21417F8926E011B54CB676_1(ConnectionProvider connectionProvider, String Zssi_Openshipment_IDR)    throws ServletException {
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
  public static String selectDef2E5D3C755ABA479A8F2C83278E5EA41B_2(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE zssi_openshipment" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , C_Bpartner_ID = (?) , M_Product_ID = (?) , Qtyordered = TO_NUMBER(?) , Qtydelivered = TO_NUMBER(?) , Qtyreserved = TO_NUMBER(?) , Qtyinvoiced = TO_NUMBER(?) , C_Uom_ID = (?) , Documentno = (?) , C_Order_ID = (?) , SalesRep_ID = (?) , Scheddeliverydate = TO_DATE(?) , Dateordered = TO_DATE(?) , Datepromised = TO_DATE(?) , Description = (?) , Zssi_Openshipment_ID = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_openshipment.Zssi_Openshipment_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOpenshipmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOpenshipmentId);
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
      "        (AD_Client_ID, AD_Org_ID, C_Bpartner_ID, M_Product_ID, Qtyordered, Qtydelivered, Qtyreserved, Qtyinvoiced, C_Uom_ID, Documentno, C_Order_ID, SalesRep_ID, Scheddeliverydate, Dateordered, Datepromised, Description, Zssi_Openshipment_ID, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), (?), (?), now(), ?, now(), ?)";

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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOpenshipmentId);
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
      "        DELETE FROM zssi_openshipment" +
      "        WHERE zssi_openshipment.Zssi_Openshipment_ID = ? " +
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
      "        DELETE FROM zssi_openshipment" +
      "        WHERE zssi_openshipment.Zssi_Openshipment_ID = ? ";

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
