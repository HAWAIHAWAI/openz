//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.mrp.WarehouseOverview;

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
class WarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data implements FieldProvider {
static Logger log4j = Logger.getLogger(WarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssiOnhanqtyOverviewId;
  public String zssiOnhanqtyOverviewIdr;
  public String mProductId;
  public String mProductIdr;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String mLocatorId;
  public String mLocatorIdr;
  public String qtyonhand;
  public String qtyreserved;
  public String qtyincomming;
  public String qtyinsale;
  public String qtyordered;
  public String qtyoutflow;
  public String qtyinflow;
  public String cUomId;
  public String cUomIdr;
  public String mProductCategoryId;
  public String mProductCategoryIdr;
  public String adClientId;
  public String adOrgId;
  public String mAttributesetinstanceId;
  public String mAttributesetinstanceIdr;
  public String isactive;
  public String zssiOnhanqtyId;
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
    else if (fieldName.equalsIgnoreCase("zssi_onhanqty_overview_id") || fieldName.equals("zssiOnhanqtyOverviewId"))
      return zssiOnhanqtyOverviewId;
    else if (fieldName.equalsIgnoreCase("zssi_onhanqty_overview_idr") || fieldName.equals("zssiOnhanqtyOverviewIdr"))
      return zssiOnhanqtyOverviewIdr;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_locator_idr") || fieldName.equals("mLocatorIdr"))
      return mLocatorIdr;
    else if (fieldName.equalsIgnoreCase("qtyonhand"))
      return qtyonhand;
    else if (fieldName.equalsIgnoreCase("qtyreserved"))
      return qtyreserved;
    else if (fieldName.equalsIgnoreCase("qtyincomming"))
      return qtyincomming;
    else if (fieldName.equalsIgnoreCase("qtyinsale"))
      return qtyinsale;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("qtyoutflow"))
      return qtyoutflow;
    else if (fieldName.equalsIgnoreCase("qtyinflow"))
      return qtyinflow;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("m_product_category_id") || fieldName.equals("mProductCategoryId"))
      return mProductCategoryId;
    else if (fieldName.equalsIgnoreCase("m_product_category_idr") || fieldName.equals("mProductCategoryIdr"))
      return mProductCategoryIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_idr") || fieldName.equals("mAttributesetinstanceIdr"))
      return mAttributesetinstanceIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("zssi_onhanqty_id") || fieldName.equals("zssiOnhanqtyId"))
      return zssiOnhanqtyId;
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
  public static WarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssiOnhanqtyOverviewId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zssiOnhanqtyOverviewId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static WarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssiOnhanqtyOverviewId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_onhanqty.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_onhanqty.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_onhanqty.Updated, ?) as updated, " +
      "        to_char(zssi_onhanqty.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_onhanqty.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_onhanqty.UpdatedBy) as UpdatedByR," +
      "        zssi_onhanqty.Zssi_Onhanqty_Overview_ID, " +
      "(CASE WHEN zssi_onhanqty.Zssi_Onhanqty_Overview_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Description), ''))),'') ) END) AS Zssi_Onhanqty_Overview_IDR, " +
      "zssi_onhanqty.M_Product_ID, " +
      "(CASE WHEN zssi_onhanqty.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "zssi_onhanqty.M_Warehouse_ID, " +
      "(CASE WHEN zssi_onhanqty.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "zssi_onhanqty.M_Locator_ID, " +
      "(CASE WHEN zssi_onhanqty.M_Locator_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Value), ''))),'') ) END) AS M_Locator_IDR, " +
      "zssi_onhanqty.QtyOnHand, " +
      "zssi_onhanqty.Qtyreserved, " +
      "zssi_onhanqty.QtyIncomming, " +
      "zssi_onhanqty.QtyInsale, " +
      "zssi_onhanqty.Qtyordered, " +
      "zssi_onhanqty.Qtyoutflow, " +
      "zssi_onhanqty.Qtyinflow, " +
      "zssi_onhanqty.C_Uom_ID, " +
      "(CASE WHEN zssi_onhanqty.C_Uom_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL7.Name IS NULL THEN TO_CHAR(table7.Name) ELSE TO_CHAR(tableTRL7.Name) END)), ''))),'') ) END) AS C_Uom_IDR, " +
      "zssi_onhanqty.M_Product_Category_ID, " +
      "(CASE WHEN zssi_onhanqty.M_Product_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS M_Product_Category_IDR, " +
      "zssi_onhanqty.AD_Client_ID, " +
      "zssi_onhanqty.AD_Org_ID, " +
      "zssi_onhanqty.M_Attributesetinstance_ID, " +
      "(CASE WHEN zssi_onhanqty.M_Attributesetinstance_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Description), ''))),'') ) END) AS M_Attributesetinstance_IDR, " +
      "COALESCE(zssi_onhanqty.Isactive, 'N') AS Isactive, " +
      "zssi_onhanqty.Zssi_Onhanqty_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_onhanqty left join (select Zssi_Onhanqty_Overview_ID, M_Product_ID, M_Attributesetinstance_ID from Zssi_Onhanqty_Overview) table1 on (zssi_onhanqty.Zssi_Onhanqty_Overview_ID = table1.Zssi_Onhanqty_Overview_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  left join (select M_AttributeSetInstance_ID, Description from M_AttributeSetInstance) table3 on (table1.M_Attributesetinstance_ID = table3.M_AttributeSetInstance_ID) left join (select M_Product_ID, Value, Name from M_Product) table4 on (zssi_onhanqty.M_Product_ID = table4.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL4 on (table4.M_Product_ID = tableTRL4.M_Product_ID and tableTRL4.AD_Language = ?)  left join (select M_Warehouse_ID, Name from M_Warehouse) table5 on (zssi_onhanqty.M_Warehouse_ID = table5.M_Warehouse_ID) left join (select M_Locator_ID, Value from M_Locator) table6 on (zssi_onhanqty.M_Locator_ID = table6.M_Locator_ID) left join (select C_Uom_ID, Name from C_Uom) table7 on (zssi_onhanqty.C_Uom_ID = table7.C_Uom_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL7 on (table7.C_UOM_ID = tableTRL7.C_UOM_ID and tableTRL7.AD_Language = ?)  left join (select M_Product_Category_ID, Name from M_Product_Category) table8 on (zssi_onhanqty.M_Product_Category_ID = table8.M_Product_Category_ID) left join (select M_AttributeSetInstance_ID, Description from M_AttributeSetInstance) table9 on (zssi_onhanqty.M_Attributesetinstance_ID = table9.M_AttributeSetInstance_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zssiOnhanqtyOverviewId==null || zssiOnhanqtyOverviewId.equals(""))?"":"  AND zssi_onhanqty.Zssi_Onhanqty_Overview_ID = ?  ");
    strSql = strSql + 
      "        AND zssi_onhanqty.Zssi_Onhanqty_ID = ? " +
      "        AND zssi_onhanqty.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_onhanqty.AD_Org_ID IN (";
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
      if (zssiOnhanqtyOverviewId != null && !(zssiOnhanqtyOverviewId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOnhanqtyOverviewId);
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
        WarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data = new WarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data();
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.created = UtilSql.getValue(result, "created");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.updated = UtilSql.getValue(result, "updated");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.zssiOnhanqtyOverviewId = UtilSql.getValue(result, "zssi_onhanqty_overview_id");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.zssiOnhanqtyOverviewIdr = UtilSql.getValue(result, "zssi_onhanqty_overview_idr");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.mLocatorIdr = UtilSql.getValue(result, "m_locator_idr");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.qtyonhand = UtilSql.getValue(result, "qtyonhand");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.qtyreserved = UtilSql.getValue(result, "qtyreserved");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.qtyincomming = UtilSql.getValue(result, "qtyincomming");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.qtyinsale = UtilSql.getValue(result, "qtyinsale");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.qtyoutflow = UtilSql.getValue(result, "qtyoutflow");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.qtyinflow = UtilSql.getValue(result, "qtyinflow");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.mProductCategoryIdr = UtilSql.getValue(result, "m_product_category_idr");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.mAttributesetinstanceIdr = UtilSql.getValue(result, "m_attributesetinstance_idr");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.isactive = UtilSql.getValue(result, "isactive");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.zssiOnhanqtyId = UtilSql.getValue(result, "zssi_onhanqty_id");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.language = UtilSql.getValue(result, "language");
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.adUserClient = "";
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.adOrgClient = "";
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.createdby = "";
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.trBgcolor = "";
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.totalCount = "";
        objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data);
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
    WarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[] = new WarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[vector.size()];
    vector.copyInto(objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data);
    return(objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data);
  }

/**
Create a registry
 */
  public static WarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[] set(String zssiOnhanqtyOverviewId, String mLocatorId, String mLocatorIdr, String mProductId, String mProductIdr, String cUomId, String createdby, String createdbyr, String qtyoutflow, String updatedby, String updatedbyr, String mProductCategoryId, String qtyinsale, String qtyinflow, String zssiOnhanqtyId, String qtyordered, String qtyreserved, String mWarehouseId, String adOrgId, String qtyincomming, String isactive, String qtyonhand, String adClientId, String mAttributesetinstanceId, String mAttributesetinstanceIdr)    throws ServletException {
    WarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[] = new WarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[1];
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0] = new WarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data();
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].created = "";
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].createdbyr = createdbyr;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].updated = "";
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].updatedTimeStamp = "";
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].updatedby = updatedby;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].updatedbyr = updatedbyr;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].zssiOnhanqtyOverviewId = zssiOnhanqtyOverviewId;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].zssiOnhanqtyOverviewIdr = "";
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].mProductId = mProductId;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].mProductIdr = mProductIdr;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].mWarehouseId = mWarehouseId;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].mWarehouseIdr = "";
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].mLocatorId = mLocatorId;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].mLocatorIdr = mLocatorIdr;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].qtyonhand = qtyonhand;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].qtyreserved = qtyreserved;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].qtyincomming = qtyincomming;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].qtyinsale = qtyinsale;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].qtyordered = qtyordered;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].qtyoutflow = qtyoutflow;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].qtyinflow = qtyinflow;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].cUomId = cUomId;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].cUomIdr = "";
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].mProductCategoryId = mProductCategoryId;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].mProductCategoryIdr = "";
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].adClientId = adClientId;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].adOrgId = adOrgId;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].mAttributesetinstanceId = mAttributesetinstanceId;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].mAttributesetinstanceIdr = mAttributesetinstanceIdr;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].isactive = isactive;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].zssiOnhanqtyId = zssiOnhanqtyId;
    objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data[0].language = "";
    return objectWarehouseQuantitiesACD5DA3B4BE44D39825D0198F7DD4317Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefB97D0EC4BDAE41609590997357818318_0(ConnectionProvider connectionProvider, String M_Locator_IDR)    throws ServletException {
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
  public static String selectDefC9B4ED808633424CBCBD2634B1C6C14F_1(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDefA7D052269ECA4995970594DD9137BE16_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefFF99388CD2A24FBCA4622FF239AA7668_3(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef0A2E9EAFBDC64613A44E6217A3E5EB5E_4(ConnectionProvider connectionProvider, String M_Attributesetinstance_IDR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zssi_onhanqty.Zssi_Onhanqty_Overview_ID AS NAME" +
      "        FROM zssi_onhanqty" +
      "        WHERE zssi_onhanqty.Zssi_Onhanqty_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String zssiOnhanqtyOverviewId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table3.Description), ''))) AS NAME FROM zssi_onhanqty_overview left join (select Zssi_Onhanqty_Overview_ID, M_Product_ID, M_Attributesetinstance_ID from Zssi_Onhanqty_Overview) table1 on (zssi_onhanqty_overview.Zssi_Onhanqty_Overview_ID = table1.Zssi_Onhanqty_Overview_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  left join (select M_AttributeSetInstance_ID, Description from M_AttributeSetInstance) table3 on (table1.M_Attributesetinstance_ID = table3.M_AttributeSetInstance_ID) WHERE zssi_onhanqty_overview.Zssi_Onhanqty_Overview_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOnhanqtyOverviewId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String zssiOnhanqtyOverviewId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table3.Description), ''))) AS NAME FROM zssi_onhanqty_overview left join (select Zssi_Onhanqty_Overview_ID, M_Product_ID, M_Attributesetinstance_ID from Zssi_Onhanqty_Overview) table1 on (zssi_onhanqty_overview.Zssi_Onhanqty_Overview_ID = table1.Zssi_Onhanqty_Overview_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  left join (select M_AttributeSetInstance_ID, Description from M_AttributeSetInstance) table3 on (table1.M_Attributesetinstance_ID = table3.M_AttributeSetInstance_ID) WHERE zssi_onhanqty_overview.Zssi_Onhanqty_Overview_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOnhanqtyOverviewId);

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
      "        UPDATE zssi_onhanqty" +
      "        SET Zssi_Onhanqty_Overview_ID = (?) , M_Product_ID = (?) , M_Warehouse_ID = (?) , M_Locator_ID = (?) , QtyOnHand = TO_NUMBER(?) , Qtyreserved = TO_NUMBER(?) , QtyIncomming = TO_NUMBER(?) , QtyInsale = TO_NUMBER(?) , Qtyordered = TO_NUMBER(?) , Qtyoutflow = TO_NUMBER(?) , Qtyinflow = TO_NUMBER(?) , C_Uom_ID = (?) , M_Product_Category_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , M_Attributesetinstance_ID = (?) , Isactive = (?) , Zssi_Onhanqty_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_onhanqty.Zssi_Onhanqty_ID = ? " +
      "                 AND zssi_onhanqty.Zssi_Onhanqty_Overview_ID = ? " +
      "        AND zssi_onhanqty.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_onhanqty.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOnhanqtyOverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreserved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyincomming);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinsale);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyoutflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOnhanqtyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOnhanqtyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOnhanqtyOverviewId);
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
      "        INSERT INTO zssi_onhanqty " +
      "        (Zssi_Onhanqty_Overview_ID, M_Product_ID, M_Warehouse_ID, M_Locator_ID, QtyOnHand, Qtyreserved, QtyIncomming, QtyInsale, Qtyordered, Qtyoutflow, Qtyinflow, C_Uom_ID, M_Product_Category_ID, AD_Client_ID, AD_Org_ID, M_Attributesetinstance_ID, Isactive, Zssi_Onhanqty_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOnhanqtyOverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreserved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyincomming);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinsale);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyoutflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOnhanqtyId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zssiOnhanqtyOverviewId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_onhanqty" +
      "        WHERE zssi_onhanqty.Zssi_Onhanqty_ID = ? " +
      "                 AND zssi_onhanqty.Zssi_Onhanqty_Overview_ID = ? " +
      "        AND zssi_onhanqty.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_onhanqty.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOnhanqtyOverviewId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zssiOnhanqtyOverviewId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_onhanqty" +
      "        WHERE zssi_onhanqty.Zssi_Onhanqty_ID = ? " +
      "                 AND zssi_onhanqty.Zssi_Onhanqty_Overview_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOnhanqtyOverviewId);

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
      "          FROM zssi_onhanqty" +
      "         WHERE zssi_onhanqty.Zssi_Onhanqty_ID = ? ";

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
      "          FROM zssi_onhanqty" +
      "         WHERE zssi_onhanqty.Zssi_Onhanqty_ID = ? ";

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
