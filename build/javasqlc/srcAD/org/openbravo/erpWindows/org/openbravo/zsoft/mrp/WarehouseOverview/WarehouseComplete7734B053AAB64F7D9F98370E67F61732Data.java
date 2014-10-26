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
class WarehouseComplete7734B053AAB64F7D9F98370E67F61732Data implements FieldProvider {
static Logger log4j = Logger.getLogger(WarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mProductId;
  public String mProductIdr;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String qtyonhand;
  public String qtyreserved;
  public String qtyincomming;
  public String qtyinsale;
  public String qtyordered;
  public String qtyoutflow;
  public String qtyinflow;
  public String cUomId;
  public String cUomIdr;
  public String mAttributesetinstanceId;
  public String mAttributesetinstanceIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String zssiOnhanqtyOverviewId;
  public String isactive;
  public String adClientId;
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
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
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
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_idr") || fieldName.equals("mAttributesetinstanceIdr"))
      return mAttributesetinstanceIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("zssi_onhanqty_overview_id") || fieldName.equals("zssiOnhanqtyOverviewId"))
      return zssiOnhanqtyOverviewId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
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
  public static WarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static WarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_onhanqty_overview.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_onhanqty_overview.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_onhanqty_overview.Updated, ?) as updated, " +
      "        to_char(zssi_onhanqty_overview.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_onhanqty_overview.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_onhanqty_overview.UpdatedBy) as UpdatedByR," +
      "        zssi_onhanqty_overview.M_Product_ID, " +
      "(CASE WHEN zssi_onhanqty_overview.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "zssi_onhanqty_overview.M_Warehouse_ID, " +
      "(CASE WHEN zssi_onhanqty_overview.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "zssi_onhanqty_overview.Qtyonhand, " +
      "zssi_onhanqty_overview.Qtyreserved, " +
      "zssi_onhanqty_overview.Qtyincomming, " +
      "zssi_onhanqty_overview.Qtyinsale, " +
      "zssi_onhanqty_overview.Qtyordered, " +
      "zssi_onhanqty_overview.Qtyoutflow, " +
      "zssi_onhanqty_overview.Qtyinflow, " +
      "zssi_onhanqty_overview.C_Uom_ID, " +
      "(CASE WHEN zssi_onhanqty_overview.C_Uom_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_Uom_IDR, " +
      "zssi_onhanqty_overview.M_Attributesetinstance_ID, " +
      "(CASE WHEN zssi_onhanqty_overview.M_Attributesetinstance_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Description), ''))),'') ) END) AS M_Attributesetinstance_IDR, " +
      "zssi_onhanqty_overview.AD_Org_ID, " +
      "(CASE WHEN zssi_onhanqty_overview.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zssi_onhanqty_overview.Zssi_Onhanqty_Overview_ID, " +
      "COALESCE(zssi_onhanqty_overview.Isactive, 'N') AS Isactive, " +
      "zssi_onhanqty_overview.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_onhanqty_overview left join (select M_Product_ID, Value, Name from M_Product) table1 on (zssi_onhanqty_overview.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  left join (select M_Warehouse_ID, Name from M_Warehouse) table2 on (zssi_onhanqty_overview.M_Warehouse_ID = table2.M_Warehouse_ID) left join (select C_Uom_ID, Name from C_Uom) table3 on (zssi_onhanqty_overview.C_Uom_ID = table3.C_Uom_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL3 on (table3.C_UOM_ID = tableTRL3.C_UOM_ID and tableTRL3.AD_Language = ?)  left join (select M_AttributeSetInstance_ID, Description from M_AttributeSetInstance) table4 on (zssi_onhanqty_overview.M_Attributesetinstance_ID = table4.M_AttributeSetInstance_ID) left join (select AD_Org_ID, Name from AD_Org) table5 on (zssi_onhanqty_overview.AD_Org_ID = table5.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND zssi_onhanqty_overview.Zssi_Onhanqty_Overview_ID = ? " +
      "        AND zssi_onhanqty_overview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_onhanqty_overview.AD_Org_ID IN (";
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
        WarehouseComplete7734B053AAB64F7D9F98370E67F61732Data objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data = new WarehouseComplete7734B053AAB64F7D9F98370E67F61732Data();
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.created = UtilSql.getValue(result, "created");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.updated = UtilSql.getValue(result, "updated");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.qtyonhand = UtilSql.getValue(result, "qtyonhand");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.qtyreserved = UtilSql.getValue(result, "qtyreserved");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.qtyincomming = UtilSql.getValue(result, "qtyincomming");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.qtyinsale = UtilSql.getValue(result, "qtyinsale");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.qtyoutflow = UtilSql.getValue(result, "qtyoutflow");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.qtyinflow = UtilSql.getValue(result, "qtyinflow");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.mAttributesetinstanceIdr = UtilSql.getValue(result, "m_attributesetinstance_idr");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.zssiOnhanqtyOverviewId = UtilSql.getValue(result, "zssi_onhanqty_overview_id");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.isactive = UtilSql.getValue(result, "isactive");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.language = UtilSql.getValue(result, "language");
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.adUserClient = "";
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.adOrgClient = "";
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.createdby = "";
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.trBgcolor = "";
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.totalCount = "";
        objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data);
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
    WarehouseComplete7734B053AAB64F7D9F98370E67F61732Data objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[] = new WarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[vector.size()];
    vector.copyInto(objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data);
    return(objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data);
  }

/**
Create a registry
 */
  public static WarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[] set(String createdby, String createdbyr, String mProductId, String mProductIdr, String qtyincomming, String mWarehouseId, String updatedby, String updatedbyr, String cUomId, String qtyinflow, String qtyinsale, String qtyonhand, String adOrgId, String qtyordered, String zssiOnhanqtyOverviewId, String qtyoutflow, String mAttributesetinstanceId, String mAttributesetinstanceIdr, String qtyreserved, String isactive, String adClientId)    throws ServletException {
    WarehouseComplete7734B053AAB64F7D9F98370E67F61732Data objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[] = new WarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[1];
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0] = new WarehouseComplete7734B053AAB64F7D9F98370E67F61732Data();
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].created = "";
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].createdbyr = createdbyr;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].updated = "";
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].updatedTimeStamp = "";
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].updatedby = updatedby;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].updatedbyr = updatedbyr;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].mProductId = mProductId;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].mProductIdr = mProductIdr;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].mWarehouseId = mWarehouseId;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].mWarehouseIdr = "";
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].qtyonhand = qtyonhand;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].qtyreserved = qtyreserved;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].qtyincomming = qtyincomming;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].qtyinsale = qtyinsale;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].qtyordered = qtyordered;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].qtyoutflow = qtyoutflow;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].qtyinflow = qtyinflow;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].cUomId = cUomId;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].cUomIdr = "";
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].mAttributesetinstanceId = mAttributesetinstanceId;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].mAttributesetinstanceIdr = mAttributesetinstanceIdr;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].adOrgId = adOrgId;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].adOrgIdr = "";
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].zssiOnhanqtyOverviewId = zssiOnhanqtyOverviewId;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].isactive = isactive;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].adClientId = adClientId;
    objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data[0].language = "";
    return objectWarehouseComplete7734B053AAB64F7D9F98370E67F61732Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefB18F6AAF3DF74B5BA50C306F5CD38B01_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefF83F9AB95002421B9F5887FA6B62FC8B_1(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef0E3E9A242FFF48078962E13F2F28838D_2(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef8EBA1560E96748AC9C85E6ED41B0911C_3(ConnectionProvider connectionProvider, String M_Attributesetinstance_IDR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE zssi_onhanqty_overview" +
      "        SET M_Product_ID = (?) , M_Warehouse_ID = (?) , Qtyonhand = TO_NUMBER(?) , Qtyreserved = TO_NUMBER(?) , Qtyincomming = TO_NUMBER(?) , Qtyinsale = TO_NUMBER(?) , Qtyordered = TO_NUMBER(?) , Qtyoutflow = TO_NUMBER(?) , Qtyinflow = TO_NUMBER(?) , C_Uom_ID = (?) , M_Attributesetinstance_ID = (?) , AD_Org_ID = (?) , Zssi_Onhanqty_Overview_ID = (?) , Isactive = (?) , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_onhanqty_overview.Zssi_Onhanqty_Overview_ID = ? " +
      "        AND zssi_onhanqty_overview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_onhanqty_overview.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreserved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyincomming);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinsale);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyoutflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOnhanqtyOverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
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
      "        INSERT INTO zssi_onhanqty_overview " +
      "        (M_Product_ID, M_Warehouse_ID, Qtyonhand, Qtyreserved, Qtyincomming, Qtyinsale, Qtyordered, Qtyoutflow, Qtyinflow, C_Uom_ID, M_Attributesetinstance_ID, AD_Org_ID, Zssi_Onhanqty_Overview_ID, Isactive, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreserved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyincomming);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinsale);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyoutflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOnhanqtyOverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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
      "        DELETE FROM zssi_onhanqty_overview" +
      "        WHERE zssi_onhanqty_overview.Zssi_Onhanqty_Overview_ID = ? " +
      "        AND zssi_onhanqty_overview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_onhanqty_overview.AD_Org_ID IN (";
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
      "        DELETE FROM zssi_onhanqty_overview" +
      "        WHERE zssi_onhanqty_overview.Zssi_Onhanqty_Overview_ID = ? ";

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
      "          FROM zssi_onhanqty_overview" +
      "         WHERE zssi_onhanqty_overview.Zssi_Onhanqty_Overview_ID = ? ";

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
      "          FROM zssi_onhanqty_overview" +
      "         WHERE zssi_onhanqty_overview.Zssi_Onhanqty_Overview_ID = ? ";

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
