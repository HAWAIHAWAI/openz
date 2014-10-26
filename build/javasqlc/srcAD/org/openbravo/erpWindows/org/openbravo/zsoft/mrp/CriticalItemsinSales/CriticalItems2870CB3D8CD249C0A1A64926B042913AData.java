//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.mrp.CriticalItemsinSales;

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
class CriticalItems2870CB3D8CD249C0A1A64926B042913AData implements FieldProvider {
static Logger log4j = Logger.getLogger(CriticalItems2870CB3D8CD249C0A1A64926B042913AData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mrpCriticalitemsVId;
  public String mrpInoutplanVId;
  public String mProductId;
  public String mProductIdr;
  public String planneddate;
  public String adClientId;
  public String movementqty;
  public String estimatedStockQty;
  public String documenttype;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String cOrderlineId;
  public String cOrderlineIdr;
  public String cUomId;
  public String cUomIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String mProductCategoryId;
  public String mProductCategoryIdr;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String zssiOnhanqtyOverviewId;
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
    else if (fieldName.equalsIgnoreCase("mrp_criticalitems_v_id") || fieldName.equals("mrpCriticalitemsVId"))
      return mrpCriticalitemsVId;
    else if (fieldName.equalsIgnoreCase("mrp_inoutplan_v_id") || fieldName.equals("mrpInoutplanVId"))
      return mrpInoutplanVId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("planneddate"))
      return planneddate;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("estimated_stock_qty") || fieldName.equals("estimatedStockQty"))
      return estimatedStockQty;
    else if (fieldName.equalsIgnoreCase("documenttype"))
      return documenttype;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("c_orderline_idr") || fieldName.equals("cOrderlineIdr"))
      return cOrderlineIdr;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("m_product_category_id") || fieldName.equals("mProductCategoryId"))
      return mProductCategoryId;
    else if (fieldName.equalsIgnoreCase("m_product_category_idr") || fieldName.equals("mProductCategoryIdr"))
      return mProductCategoryIdr;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("zssi_onhanqty_overview_id") || fieldName.equals("zssiOnhanqtyOverviewId"))
      return zssiOnhanqtyOverviewId;
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
  public static CriticalItems2870CB3D8CD249C0A1A64926B042913AData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CriticalItems2870CB3D8CD249C0A1A64926B042913AData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(mrp_criticalitems_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = mrp_criticalitems_v.CreatedBy) as CreatedByR, " +
      "        to_char(mrp_criticalitems_v.Updated, ?) as updated, " +
      "        to_char(mrp_criticalitems_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        mrp_criticalitems_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = mrp_criticalitems_v.UpdatedBy) as UpdatedByR," +
      "        mrp_criticalitems_v.MRP_Criticalitems_V_ID, " +
      "mrp_criticalitems_v.MRP_Inoutplan_V_ID, " +
      "mrp_criticalitems_v.M_Product_ID, " +
      "(CASE WHEN mrp_criticalitems_v.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "mrp_criticalitems_v.Planneddate, " +
      "mrp_criticalitems_v.AD_Client_ID, " +
      "mrp_criticalitems_v.Movementqty, " +
      "mrp_criticalitems_v.Estimated_Stock_Qty, " +
      "mrp_criticalitems_v.Documenttype, " +
      "mrp_criticalitems_v.C_Projecttask_ID, " +
      "(CASE WHEN mrp_criticalitems_v.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "mrp_criticalitems_v.C_Orderline_ID, " +
      "(CASE WHEN mrp_criticalitems_v.C_Orderline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table5.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.GrandTotal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.LineNetAmt), ''))),'') ) END) AS C_Orderline_IDR, " +
      "mrp_criticalitems_v.C_Uom_ID, " +
      "(CASE WHEN mrp_criticalitems_v.C_Uom_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'') ) END) AS C_Uom_IDR, " +
      "mrp_criticalitems_v.C_Bpartner_ID, " +
      "(CASE WHEN mrp_criticalitems_v.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "mrp_criticalitems_v.M_Product_Category_ID, " +
      "(CASE WHEN mrp_criticalitems_v.M_Product_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS M_Product_Category_IDR, " +
      "mrp_criticalitems_v.M_Warehouse_ID, " +
      "(CASE WHEN mrp_criticalitems_v.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "mrp_criticalitems_v.AD_Org_ID, " +
      "(CASE WHEN mrp_criticalitems_v.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "mrp_criticalitems_v.Zssi_Onhanqty_Overview_ID, " +
      "COALESCE(mrp_criticalitems_v.isactive, 'N') AS isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM mrp_criticalitems_v left join (select M_Product_ID, Value, Name from M_Product) table1 on (mrp_criticalitems_v.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table2 on (mrp_criticalitems_v.C_Projecttask_ID = table2.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table3 on (table2.C_Project_ID = table3.C_Project_ID) left join (select C_Orderline_ID, C_Order_ID, Line, LineNetAmt from C_Orderline) table4 on (mrp_criticalitems_v.C_Orderline_ID = table4.C_Orderline_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table5 on (table4.C_Order_ID = table5.C_Order_ID) left join (select C_Uom_ID, Name from C_Uom) table6 on (mrp_criticalitems_v.C_Uom_ID = table6.C_Uom_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL6 on (table6.C_UOM_ID = tableTRL6.C_UOM_ID and tableTRL6.AD_Language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table7 on (mrp_criticalitems_v.C_Bpartner_ID = table7.C_BPartner_ID) left join (select M_Product_Category_ID, Name from M_Product_Category) table8 on (mrp_criticalitems_v.M_Product_Category_ID = table8.M_Product_Category_ID) left join (select M_Warehouse_ID, Name from M_Warehouse) table9 on (mrp_criticalitems_v.M_Warehouse_ID = table9.M_Warehouse_ID) left join (select AD_Org_ID, Name from AD_Org) table10 on (mrp_criticalitems_v.AD_Org_ID = table10.AD_Org_ID)" +
      "        WHERE 2=2 " +
      " AND mrp_criticalitems_v.documenttype='SOO'" +
      "        AND 1=1 " +
      "        AND mrp_criticalitems_v.MRP_Criticalitems_V_ID = ? " +
      "        AND mrp_criticalitems_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND mrp_criticalitems_v.AD_Org_ID IN (";
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
        CriticalItems2870CB3D8CD249C0A1A64926B042913AData objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData = new CriticalItems2870CB3D8CD249C0A1A64926B042913AData();
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.created = UtilSql.getValue(result, "created");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.updated = UtilSql.getValue(result, "updated");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.updatedby = UtilSql.getValue(result, "updatedby");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.mrpCriticalitemsVId = UtilSql.getValue(result, "mrp_criticalitems_v_id");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.mrpInoutplanVId = UtilSql.getValue(result, "mrp_inoutplan_v_id");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.planneddate = UtilSql.getDateValue(result, "planneddate", "dd-MM-yyyy");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.movementqty = UtilSql.getValue(result, "movementqty");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.estimatedStockQty = UtilSql.getValue(result, "estimated_stock_qty");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.documenttype = UtilSql.getValue(result, "documenttype");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.cOrderlineIdr = UtilSql.getValue(result, "c_orderline_idr");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.mProductCategoryIdr = UtilSql.getValue(result, "m_product_category_idr");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.zssiOnhanqtyOverviewId = UtilSql.getValue(result, "zssi_onhanqty_overview_id");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.isactive = UtilSql.getValue(result, "isactive");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.language = UtilSql.getValue(result, "language");
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.adUserClient = "";
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.adOrgClient = "";
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.createdby = "";
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.trBgcolor = "";
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.totalCount = "";
        objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData);
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
    CriticalItems2870CB3D8CD249C0A1A64926B042913AData objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[] = new CriticalItems2870CB3D8CD249C0A1A64926B042913AData[vector.size()];
    vector.copyInto(objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData);
    return(objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData);
  }

/**
Create a registry
 */
  public static CriticalItems2870CB3D8CD249C0A1A64926B042913AData[] set(String updatedby, String updatedbyr, String adClientId, String isactive, String estimatedStockQty, String zssiOnhanqtyOverviewId, String mWarehouseId, String mProductId, String mProductIdr, String cOrderlineId, String cBpartnerId, String cBpartnerIdr, String cUomId, String cProjecttaskId, String documenttype, String adOrgId, String mrpCriticalitemsVId, String mrpInoutplanVId, String mProductCategoryId, String planneddate, String createdby, String createdbyr, String movementqty)    throws ServletException {
    CriticalItems2870CB3D8CD249C0A1A64926B042913AData objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[] = new CriticalItems2870CB3D8CD249C0A1A64926B042913AData[1];
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0] = new CriticalItems2870CB3D8CD249C0A1A64926B042913AData();
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].created = "";
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].createdbyr = createdbyr;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].updated = "";
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].updatedTimeStamp = "";
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].updatedby = updatedby;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].updatedbyr = updatedbyr;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].mrpCriticalitemsVId = mrpCriticalitemsVId;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].mrpInoutplanVId = mrpInoutplanVId;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].mProductId = mProductId;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].mProductIdr = mProductIdr;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].planneddate = planneddate;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].adClientId = adClientId;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].movementqty = movementqty;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].estimatedStockQty = estimatedStockQty;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].documenttype = documenttype;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].cProjecttaskId = cProjecttaskId;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].cProjecttaskIdr = "";
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].cOrderlineId = cOrderlineId;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].cOrderlineIdr = "";
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].cUomId = cUomId;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].cUomIdr = "";
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].cBpartnerId = cBpartnerId;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].cBpartnerIdr = cBpartnerIdr;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].mProductCategoryId = mProductCategoryId;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].mProductCategoryIdr = "";
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].mWarehouseId = mWarehouseId;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].mWarehouseIdr = "";
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].adOrgId = adOrgId;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].adOrgIdr = "";
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].zssiOnhanqtyOverviewId = zssiOnhanqtyOverviewId;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].isactive = isactive;
    objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData[0].language = "";
    return objectCriticalItems2870CB3D8CD249C0A1A64926B042913AData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefA8DAB88AC16843B4B09E6854AE30AEF2_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef758B32661B3A4951807E0C528FA249A4_1(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDefEAE83DD336DB4D6A840BC2DDADF210DA_2(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
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
  public static String selectDefC0B333E2E4ED46D09027DEB02FF87487_3(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        UPDATE mrp_criticalitems_v" +
      "        SET MRP_Criticalitems_V_ID = (?) , MRP_Inoutplan_V_ID = (?) , M_Product_ID = (?) , Planneddate = TO_DATE(?) , AD_Client_ID = (?) , Movementqty = TO_NUMBER(?) , Estimated_Stock_Qty = TO_NUMBER(?) , Documenttype = (?) , C_Projecttask_ID = (?) , C_Orderline_ID = (?) , C_Uom_ID = (?) , C_Bpartner_ID = (?) , M_Product_Category_ID = (?) , M_Warehouse_ID = (?) , AD_Org_ID = (?) , Zssi_Onhanqty_Overview_ID = (?) , isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE mrp_criticalitems_v.MRP_Criticalitems_V_ID = ? " +
      "        AND mrp_criticalitems_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND mrp_criticalitems_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpCriticalitemsVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpInoutplanVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedStockQty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documenttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOnhanqtyOverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpCriticalitemsVId);
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
      "        INSERT INTO mrp_criticalitems_v " +
      "        (MRP_Criticalitems_V_ID, MRP_Inoutplan_V_ID, M_Product_ID, Planneddate, AD_Client_ID, Movementqty, Estimated_Stock_Qty, Documenttype, C_Projecttask_ID, C_Orderline_ID, C_Uom_ID, C_Bpartner_ID, M_Product_Category_ID, M_Warehouse_ID, AD_Org_ID, Zssi_Onhanqty_Overview_ID, isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_DATE(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpCriticalitemsVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpInoutplanVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedStockQty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documenttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOnhanqtyOverviewId);
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
      "        DELETE FROM mrp_criticalitems_v" +
      "        WHERE mrp_criticalitems_v.MRP_Criticalitems_V_ID = ? " +
      "        AND mrp_criticalitems_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND mrp_criticalitems_v.AD_Org_ID IN (";
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
      "        DELETE FROM mrp_criticalitems_v" +
      "        WHERE mrp_criticalitems_v.MRP_Criticalitems_V_ID = ? ";

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
      "          FROM mrp_criticalitems_v" +
      "         WHERE mrp_criticalitems_v.MRP_Criticalitems_V_ID = ? ";

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
      "          FROM mrp_criticalitems_v" +
      "         WHERE mrp_criticalitems_v.MRP_Criticalitems_V_ID = ? ";

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
