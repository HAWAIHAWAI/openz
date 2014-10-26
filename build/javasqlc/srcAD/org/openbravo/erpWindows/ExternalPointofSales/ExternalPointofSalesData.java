//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ExternalPointofSales;

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
class ExternalPointofSalesData implements FieldProvider {
static Logger log4j = Logger.getLogger(ExternalPointofSalesData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cExternalposId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String value;
  public String name;
  public String description;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String mPricelistId;
  public String mPricelistIdr;
  public String salesrepId;
  public String salesrepIdr;
  public String mShipperId;
  public String mShipperIdr;
  public String includeProduct;
  public String includeProductr;
  public String includeProductCategory;
  public String includeProductCategoryr;
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
    else if (fieldName.equalsIgnoreCase("c_externalpos_id") || fieldName.equals("cExternalposId"))
      return cExternalposId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_idr") || fieldName.equals("mPricelistIdr"))
      return mPricelistIdr;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("m_shipper_idr") || fieldName.equals("mShipperIdr"))
      return mShipperIdr;
    else if (fieldName.equalsIgnoreCase("include_product") || fieldName.equals("includeProduct"))
      return includeProduct;
    else if (fieldName.equalsIgnoreCase("include_productr") || fieldName.equals("includeProductr"))
      return includeProductr;
    else if (fieldName.equalsIgnoreCase("include_product_category") || fieldName.equals("includeProductCategory"))
      return includeProductCategory;
    else if (fieldName.equalsIgnoreCase("include_product_categoryr") || fieldName.equals("includeProductCategoryr"))
      return includeProductCategoryr;
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
  public static ExternalPointofSalesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ExternalPointofSalesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_ExternalPOS.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_ExternalPOS.CreatedBy) as CreatedByR, " +
      "        to_char(C_ExternalPOS.Updated, ?) as updated, " +
      "        to_char(C_ExternalPOS.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_ExternalPOS.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_ExternalPOS.UpdatedBy) as UpdatedByR," +
      "        C_ExternalPOS.C_Externalpos_ID, " +
      "C_ExternalPOS.AD_Client_ID, " +
      "(CASE WHEN C_ExternalPOS.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_ExternalPOS.AD_Org_ID, " +
      "(CASE WHEN C_ExternalPOS.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(C_ExternalPOS.IsActive, 'N') AS IsActive, " +
      "C_ExternalPOS.Value, " +
      "C_ExternalPOS.Name, " +
      "C_ExternalPOS.Description, " +
      "C_ExternalPOS.M_Warehouse_ID, " +
      "(CASE WHEN C_ExternalPOS.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "C_ExternalPOS.C_DocType_ID, " +
      "(CASE WHEN C_ExternalPOS.C_DocType_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS C_DocType_IDR, " +
      "C_ExternalPOS.C_BPartner_ID, " +
      "(CASE WHEN C_ExternalPOS.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "C_ExternalPOS.M_PriceList_ID, " +
      "(CASE WHEN C_ExternalPOS.M_PriceList_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS M_PriceList_IDR, " +
      "C_ExternalPOS.SalesRep_ID, " +
      "(CASE WHEN C_ExternalPOS.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "C_ExternalPOS.M_Shipper_ID, " +
      "(CASE WHEN C_ExternalPOS.M_Shipper_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS M_Shipper_IDR, " +
      "C_ExternalPOS.Include_Product, " +
      "(CASE WHEN C_ExternalPOS.Include_Product IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS Include_ProductR, " +
      "C_ExternalPOS.Include_Product_Category, " +
      "(CASE WHEN C_ExternalPOS.Include_Product_Category IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS Include_Product_CategoryR, " +
      "        ? AS LANGUAGE " +
      "        FROM C_ExternalPOS left join (select AD_Client_ID, Name from AD_Client) table1 on (C_ExternalPOS.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_ExternalPOS.AD_Org_ID = table2.AD_Org_ID) left join (select M_Warehouse_ID, Name from M_Warehouse) table3 on (C_ExternalPOS.M_Warehouse_ID = table3.M_Warehouse_ID) left join (select C_DocType_ID, Name from C_DocType) table4 on (C_ExternalPOS.C_DocType_ID =  table4.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL4 on (table4.C_DocType_ID = tableTRL4.C_DocType_ID and tableTRL4.AD_Language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table5 on (C_ExternalPOS.C_BPartner_ID = table5.C_BPartner_ID) left join (select M_PriceList_ID, Name from M_PriceList) table6 on (C_ExternalPOS.M_PriceList_ID = table6.M_PriceList_ID) left join (select AD_User_ID, Name from AD_User) table7 on (C_ExternalPOS.SalesRep_ID =  table7.AD_User_ID) left join (select M_Shipper_ID, Name from M_Shipper) table8 on (C_ExternalPOS.M_Shipper_ID = table8.M_Shipper_ID) left join ad_ref_list_v list1 on (C_ExternalPOS.Include_Product = list1.value and list1.ad_reference_id = '800029' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (C_ExternalPOS.Include_Product_Category = list2.value and list2.ad_reference_id = '800029' and list2.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_ExternalPOS.C_Externalpos_ID = ? " +
      "        AND C_ExternalPOS.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_ExternalPOS.AD_Org_ID IN (";
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
        ExternalPointofSalesData objectExternalPointofSalesData = new ExternalPointofSalesData();
        objectExternalPointofSalesData.created = UtilSql.getValue(result, "created");
        objectExternalPointofSalesData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectExternalPointofSalesData.updated = UtilSql.getValue(result, "updated");
        objectExternalPointofSalesData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectExternalPointofSalesData.updatedby = UtilSql.getValue(result, "updatedby");
        objectExternalPointofSalesData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectExternalPointofSalesData.cExternalposId = UtilSql.getValue(result, "c_externalpos_id");
        objectExternalPointofSalesData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectExternalPointofSalesData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectExternalPointofSalesData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectExternalPointofSalesData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectExternalPointofSalesData.isactive = UtilSql.getValue(result, "isactive");
        objectExternalPointofSalesData.value = UtilSql.getValue(result, "value");
        objectExternalPointofSalesData.name = UtilSql.getValue(result, "name");
        objectExternalPointofSalesData.description = UtilSql.getValue(result, "description");
        objectExternalPointofSalesData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectExternalPointofSalesData.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectExternalPointofSalesData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectExternalPointofSalesData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectExternalPointofSalesData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectExternalPointofSalesData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectExternalPointofSalesData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectExternalPointofSalesData.mPricelistIdr = UtilSql.getValue(result, "m_pricelist_idr");
        objectExternalPointofSalesData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectExternalPointofSalesData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectExternalPointofSalesData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectExternalPointofSalesData.mShipperIdr = UtilSql.getValue(result, "m_shipper_idr");
        objectExternalPointofSalesData.includeProduct = UtilSql.getValue(result, "include_product");
        objectExternalPointofSalesData.includeProductr = UtilSql.getValue(result, "include_productr");
        objectExternalPointofSalesData.includeProductCategory = UtilSql.getValue(result, "include_product_category");
        objectExternalPointofSalesData.includeProductCategoryr = UtilSql.getValue(result, "include_product_categoryr");
        objectExternalPointofSalesData.language = UtilSql.getValue(result, "language");
        objectExternalPointofSalesData.adUserClient = "";
        objectExternalPointofSalesData.adOrgClient = "";
        objectExternalPointofSalesData.createdby = "";
        objectExternalPointofSalesData.trBgcolor = "";
        objectExternalPointofSalesData.totalCount = "";
        objectExternalPointofSalesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExternalPointofSalesData);
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
    ExternalPointofSalesData objectExternalPointofSalesData[] = new ExternalPointofSalesData[vector.size()];
    vector.copyInto(objectExternalPointofSalesData);
    return(objectExternalPointofSalesData);
  }

/**
Create a registry
 */
  public static ExternalPointofSalesData[] set(String adOrgId, String mPricelistId, String isactive, String createdby, String createdbyr, String cBpartnerId, String cBpartnerIdr, String includeProductCategory, String mWarehouseId, String name, String mShipperId, String cExternalposId, String cDoctypeId, String includeProduct, String updatedby, String updatedbyr, String adClientId, String value, String description, String salesrepId)    throws ServletException {
    ExternalPointofSalesData objectExternalPointofSalesData[] = new ExternalPointofSalesData[1];
    objectExternalPointofSalesData[0] = new ExternalPointofSalesData();
    objectExternalPointofSalesData[0].created = "";
    objectExternalPointofSalesData[0].createdbyr = createdbyr;
    objectExternalPointofSalesData[0].updated = "";
    objectExternalPointofSalesData[0].updatedTimeStamp = "";
    objectExternalPointofSalesData[0].updatedby = updatedby;
    objectExternalPointofSalesData[0].updatedbyr = updatedbyr;
    objectExternalPointofSalesData[0].cExternalposId = cExternalposId;
    objectExternalPointofSalesData[0].adClientId = adClientId;
    objectExternalPointofSalesData[0].adClientIdr = "";
    objectExternalPointofSalesData[0].adOrgId = adOrgId;
    objectExternalPointofSalesData[0].adOrgIdr = "";
    objectExternalPointofSalesData[0].isactive = isactive;
    objectExternalPointofSalesData[0].value = value;
    objectExternalPointofSalesData[0].name = name;
    objectExternalPointofSalesData[0].description = description;
    objectExternalPointofSalesData[0].mWarehouseId = mWarehouseId;
    objectExternalPointofSalesData[0].mWarehouseIdr = "";
    objectExternalPointofSalesData[0].cDoctypeId = cDoctypeId;
    objectExternalPointofSalesData[0].cDoctypeIdr = "";
    objectExternalPointofSalesData[0].cBpartnerId = cBpartnerId;
    objectExternalPointofSalesData[0].cBpartnerIdr = cBpartnerIdr;
    objectExternalPointofSalesData[0].mPricelistId = mPricelistId;
    objectExternalPointofSalesData[0].mPricelistIdr = "";
    objectExternalPointofSalesData[0].salesrepId = salesrepId;
    objectExternalPointofSalesData[0].salesrepIdr = "";
    objectExternalPointofSalesData[0].mShipperId = mShipperId;
    objectExternalPointofSalesData[0].mShipperIdr = "";
    objectExternalPointofSalesData[0].includeProduct = includeProduct;
    objectExternalPointofSalesData[0].includeProductr = "";
    objectExternalPointofSalesData[0].includeProductCategory = includeProductCategory;
    objectExternalPointofSalesData[0].includeProductCategoryr = "";
    objectExternalPointofSalesData[0].language = "";
    return objectExternalPointofSalesData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef803053_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef803061_1(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as C_BPartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_IDR);

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
  public static String selectDef803055_2(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        UPDATE C_ExternalPOS" +
      "        SET C_Externalpos_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , IsActive = (?) , Value = (?) , Name = (?) , Description = (?) , M_Warehouse_ID = (?) , C_DocType_ID = (?) , C_BPartner_ID = (?) , M_PriceList_ID = (?) , SalesRep_ID = (?) , M_Shipper_ID = (?) , Include_Product = (?) , Include_Product_Category = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_ExternalPOS.C_Externalpos_ID = ? " +
      "        AND C_ExternalPOS.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_ExternalPOS.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cExternalposId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includeProduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includeProductCategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cExternalposId);
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
      "        INSERT INTO C_ExternalPOS " +
      "        (C_Externalpos_ID, AD_Client_ID, AD_Org_ID, IsActive, Value, Name, Description, M_Warehouse_ID, C_DocType_ID, C_BPartner_ID, M_PriceList_ID, SalesRep_ID, M_Shipper_ID, Include_Product, Include_Product_Category, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cExternalposId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includeProduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includeProductCategory);
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
      "        DELETE FROM C_ExternalPOS" +
      "        WHERE C_ExternalPOS.C_Externalpos_ID = ? " +
      "        AND C_ExternalPOS.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_ExternalPOS.AD_Org_ID IN (";
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
      "        DELETE FROM C_ExternalPOS" +
      "        WHERE C_ExternalPOS.C_Externalpos_ID = ? ";

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
      "          FROM C_ExternalPOS" +
      "         WHERE C_ExternalPOS.C_Externalpos_ID = ? ";

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
      "          FROM C_ExternalPOS" +
      "         WHERE C_ExternalPOS.C_Externalpos_ID = ? ";

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
